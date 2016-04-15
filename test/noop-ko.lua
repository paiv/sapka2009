-- Sapka bot: noop-ko
-- Author: Pavel Ivashkov <pasha@archer-soft.com>

---------------------------------------
TEAM = 'noop-ko'
CFG = 'CFGsnmWxWLgsbQrokkRGOUw#CFGOlcIUpaShYRAkUQJikOA#CFGYIAqqfqeFYpCvuZoKMlW#CFGGhyQaYOpgjIaiImTExmt#CFGcklaoEkNahKwOJElMhaI#CFGYSQWhiMAleuMESxiZyVS#CFGahmIyqgyroaWIGiFqaaM#CFGiVmQNcMTcrqxwHWYJsmk#CFGAiCEWZqDetSrAQtIyuAj#CFGalCKnQkMVwuyCPcrGaiv#CFGqrQoYYMHqXcBIOItCEqW#CFGWVMYraTEtsDOKCCBUWdE#CFGYKMUlsHsfmDcYGncZaov'

---------------------------------------

LOGFILE = [[D:\projects\archer\sapka\svn\test\bot-]]..TEAM..'.log'
-- VISUALIZER = true

dbg = {}
DEBUG=true
MAXPATH=5

--[[ supported functions:

launch(team, config)
move_left(bomb)
move_right(bomb)
move_up(bomb)
move_down(bomb)
engine_stop(bomb)

]]--

-- x,y     - raw coordinates
-- cx, cy  - cell coordinates (raw coordinates / cell.size)

---------------------------------------
STATE_SEARCH = 0
STATE_CRAWL  = 1
STATE_BOMB   = 2
STATE_RUN    = 3
STATE_HIDE   = 4
STATE_DEAD   = 666

---------------------------------------
_playerId = 0
_state = STATE_SEARCH
_player = nil

_rawmap  = nil
_map     = nil  -- map[][] = { cx, cy, icon }
_mapsize = nil  -- {width, height}
_paths   = nil  -- { cell = {cx, cy}, dist[] = {o,o,..} }

--------------------------------------------------------------------------
-- server events

function on_connected()
  launch(TEAM, CFG)
end


function on_game_start(pid)
  _playerId = pid
end


-- score: { P0 = {rank = n, score = n}, P1 = ...}
-- P0,P1: int
function on_game_over(score)
  for p,v in pairs(score) do
    -- p, v.rank, v.score
  end
end


-- id: int (round id)
-- map: { cellsize = n, rows = { {o,o,o,o,o,o,o,o}, {o,o,o,o,o,o,o,o}, ...}}
-- every 'o' is a map item (char)
function on_round_start(id, map)
  build_map(map)
end


-- score: int (your score)
function on_round_end(score)
end


-- player: { id = n, x = n, y = n, speed = n, bombs = n, strength = n, dead = f, infected = f }
function on_player(player)
  if player.id == _playerId then
    _player = player
    _player.stren = player.strength
    _player.cx = math.floor(_player.x / _rawmap.cellsize)
    _player.cy = math.floor(_player.y / _rawmap.cellsize)
    _paths = build_paths_from(_player, _paths)
    if player.dead then _state = STATE_DEAD end
  end
end


-- item: { icon = 's', x = n, y = n }
-- bomb/hightemp: { icon = 's', x = n, y = n, range = n, time = n }
function on_item_added(item)
end

-- item: { icon = 's', x = n, y = n }
function on_item_removed(item)
end


-- the game is over soon
-- (gets called every tick starting from 8 seconds before game ends)
function on_danger()
end


-- Gets called every ~50 ms.
-- The last one to get called after all other map change events.
-- t: int
function on_tick(t)
  dbg.format("---- %d", t)
  dbg.format("P%d %d %d", _player.id, _player.cx, _player.cy)
  repeat
    if     _state == STATE_SEARCH then do_search()
    elseif _state == STATE_CRAWL  then do_crawl()
    elseif _state == STATE_BOMB   then do_bomb()
    elseif _state == STATE_RUN    then do_run()
    elseif _state == STATE_HIDE   then do_hide()
    elseif _state == STATE_DEAD   then return
    else  dbg.print('! unknown state:', _state)
    end
  until _state ~= STATE_SEARCH and _state ~= STATE_BOMB
end

--------------------------------------------------------------------------
-- my stuff

function switch_to(newstate)
  dbg.print(string.format("state switch to %d", newstate))
  _state = newstate
end

function do_search()
  -- dbg.format("IAM ON %d %d", _player.cx, _player.cy)
  _target = find_target(1, 4)
  if _target == nil then
    local shelter = find_shelter_from(_player)
    if shelter ~= nil then
      _target = {cx = _player.cx, cy = _player.cy, icon = '.'}
    end
  end
  if _target ~= nil then
    dbg.format("target on %d %d", _target.cx, _target.cy)
    step_to(_target)
  else
    dbg.print("no target")
  end
  switch_to(STATE_CRAWL)
end

function do_crawl()
  if _target ~= nil then
    if same_cell(_player, _target) then
      if calc_dmgwei(_player, _player.stren) <= 0 then
        switch_to(STATE_SEARCH)
      else
        switch_to(STATE_BOMB)
      end
      return
    end
    if not step_to(_target) then switch_to(STATE_SEARCH) end
  else
    switch_to(STATE_SEARCH)
  end
end

function do_bomb()
  local sp = find_shelter_from(_player)
  dbg.format("!bombing. shelter= %s", dbg.pp(sp))
  if sp == nil then switch_to(STATE_SEARCH)
  else
    _shelter = sp
    engine_stop(true)
    switch_to(STATE_RUN)
  end
end

function do_run()
  step_to(_shelter)
  if same_cell(_player, _shelter) then
    --switch_to(STATE_HIDE)
    switch_to(STATE_SEARCH)
  end
end

function do_hide()
--  switch_to(STATE_SEARCH)
end

function build_map(map)
  --dbg.format("orig map= %s)", dbg.pp(map))
  _rawmap = map
  _map = {}
  _mapsize = { width = table.maxn(map.rows[1]) + 1,
    height = table.maxn(map.rows) + 1 }
  for p,r in pairs(map.rows) do
    _map[p] = {}
    for i,v in pairs(r) do
      _map[p][i] = { cx = i, cy = p, icon = v }
    end
  end
  --dbg.format("build_map= %s)", dbg.pp(_map))
end

function build_paths_from(cell, oldpaths)
  -- dbg.format("build_paths_from({%d,%d}, %s)", cell.cx, cell.cy, dbg.pp(oldpaths))
  if oldpaths ~= nil then
    if same_cell(cell, oldpaths.cell) then return oldpaths end
  end
  local paths = { cell = {cx = cell.cx, cy = cell.cy}, dist = {} }
  for r = 0,_mapsize.height-1,1 do
    for i = 0,_mapsize.width-1,1 do
      local dist = math.abs(cell.cy - r) + math.abs(cell.cx - i)
      if dist <= MAXPATH then
        if paths.dist[dist] == nil then paths.dist[dist] = {} end
        table.insert(paths.dist[dist], _map[r][i])
      end
    end
  end
  return paths
end

function find_target(dist, howfar)
  if dist > howfar then return nil end

  local t = _paths.dist[dist]
  -- dbg.format("find_target: t= %s", dbg.pp(t))
  if t == nil then return nil end
  local possi = {}

  for i,o in pairs(t) do
    if can_step_on(o.icon) then
      table.insert(possi, { wei = calc_dmgwei(o, _player.stren), obj = o })
    end
  end
  table.sort(possi, sort_by_wei)

  for i,e in pairs(possi) do
    if e.wei > 0 then
      local shelter = find_shelter_from(e.obj)
      if shelter ~= nil then return e.obj end
    end
  end

  -- todo: check path
  return find_target(dist + 1, howfar)
end

function calc_dmgwei(cell, stren)
  local z = 0
  for i = 1,stren,1 do
    z = z + calc_dmgwei1({cx = cell.cx + i, cy = cell.cy}) +
      calc_dmgwei1({cx = cell.cx, cy = cell.cy + i}) +
      calc_dmgwei1({cx = cell.cx - i, cy = cell.cy}) +
      calc_dmgwei1({cx = cell.cx, cy = cell.cy - i})
  end
  return z
end

function calc_dmgwei1(cell)
  if cell.cx < 0 or cell.cy < 0 or
    cell.cx >= _mapsize.width or cell.cy >= _mapsize.height then
    return 0
  end
  if same_cell(_player, cell) then return 0 end
  local x = _map[cell.cy][cell.cx].icon
  if x == 'w' then return 10 end
  if x == '@' then return 50 end
  if x == 'r' or x == 's' or x == 'u' or x == 'o' then return 10 end
  return 0
end

function find_shelter_from(cell)
  -- dbg.format("find_shelter_from(%d,%d)", cell.cx, cell.cy)
  local paths = build_paths_from(cell, nil)
  local waves = {}
  local t = paths.dist[1]
  -- dbg.format("find_shelter_from: t= %s", dbg.pp(t))
  if t == nil then return nil end

  waves[1] = {}
  for i,v in pairs(t) do
    if can_step_on(v) then
      table.insert(waves[1], {cx = v.cx, cy = v.cy, back = nil})
      if hidden_cell(v, cell, _player.stren) then return v end
    end
  end

  local candi = nil
  for dist = 2,(_mapsize.height+_mapsize.width),1 do
    local t = paths.dist[dist]
    if t == nil then break end
    waves[dist] = {}
    for i,v in pairs(t) do
      local x = get_connected_cell(v, waves[dist-1])
      if x ~= nil then
        candi = {cx = v.cx, cy = v.cy, back = x}
        if can_step_on(candi) then
          table.insert(waves[dist], candi)
          if hidden_cell(candi, cell, _player.stren) then return candi end
        end
      end
    end
  end
  return candi
end

function get_connected_cell(to, neighbors)
  for i,v in pairs(neighbors) do
    if v.cx == to.cx or v.cy == to.cy then return v end
  end
  return nil
end

function hidden_cell(cell, bomb, stren)
  if cell.cx == bomb.cx then return math.abs(cell.cy - bomb.cy) > stren end
  if cell.cy == bomb.cy then return math.abs(cell.cx - bomb.cx) > stren end
  return true
end

function step_to(cell)
  dbg.format("step to %d %d", cell.cx, cell.cy)
  local path = find_your_way_to(cell)
  if path == nil then
    dbg.print("path not found")
    return false
  end
  local t = path[1]
  dbg.format("moving to %d %d", t.cx, t.cy)
  local i = _player.cx - t.cx
  if i > 0 then move_left()
  elseif i < 0 then move_right() end
  local i = _player.cy - t.cy
  if i > 0 then move_up()
  elseif i < 0 then move_down() end
  return true
end

function find_your_way_to(cell)
  if same_cell(_player, cell) then return {cell} end
  local waves = {}
  local t = _paths.dist[1]
  dbg.format("find_your_way_to: t= %s", dbg.pp(t))
  if t == nil then return nil end

  waves[1] = {}
  for i,v in pairs(t) do
    if can_step_on(v) then
      table.insert(waves[1], {cx = v.cx, cy = v.cy, back = nil})
      if same_cell(v, cell) then return {v} end
    end
  end

  local candi = nil
  for dist = 2,(_mapsize.height+_mapsize.width),1 do
    local t = _paths.dist[dist]
    if t == nil then break end
    waves[dist] = {}
    for i,v in pairs(t) do
      local x = get_connected_cell(v, waves[dist-1])
      if x ~= nil then
        candi = {cx = v.cx, cy = v.cy, back = x}
        if can_step_on(candi) then
          table.insert(waves[dist], candi)
          if same_cell(candi, cell) then return {candi} end
        end
      end
    end
  end
  return {candi}

--[[
  local cx = sgn(cell.cx - _player.cx)
  local cy = sgn(cell.cy - _player.cy)

  local t = _paths.dist[1]
  if t == nil then return nil end
  local ok = nil
  for k,o in pairs(t) do
    local cell = {cx = o.cx, cy = o.cy}
    if can_step_on(cell) then
      ok = cell
      if _player.cx + cx == o.cx and _player.cy + cy == o.cy then
        return cell
      end
    end
  end
  return ok
]]--
end

function can_step_on(icon)
  return (icon == '.' or icon == 'b' or icon == 'v' or icon == 'f' or
    icon == '?')
end

--------------------------------------------------------------------------
-- utility

function sort_by_wei(a, b)
  return a.wei >= b.wei
end

function same_cell(a, b)
  return a.cx == b.cx and a.cy == b.cy
end

function sgn(x)
  if x ~= 0 then x = x / math.abs(x) end
  return x
end

--------------------------------------------------------------------------
function dbg.pp(obj)
  if DEBUG then return dbg.tostring(obj) end
end

function dbg.format(f,...)
  if DEBUG then dbg.print(string.format(f,...)) end
end

function dbg.print(s,...)
  if DEBUG then print(s,...) end
end

function dbg.tostring(obj)
	local mt
	local tname
	local o
	if type(obj) == 'userdata' then
		mt = getmetatable(obj)
		o = '['
		if mt and mt.__index then
			tname = mt.__index.__typename
			if tname then
				o = o .. tname
			end
		end
		if obj.name then
			if tname and tname == 'WClientWin' then
				o = o .. ': ' .. dbg.tostring(obj:get_ident())
			else
				o = o .. ': ' .. obj:name()
			end
		end
		return o .. ']'
	elseif type(obj) == 'table' then
		o = '{'
		sep = ''
		for k, v in pairs(obj)
		do
			o = o .. sep .. dbg.tostring(k) .. '='
			o = o .. dbg.tostring(v)
			sep = ', '
		end
		return o .. '}'
	end
	return tostring(obj)
end

--------------------------------------------------------------------------
