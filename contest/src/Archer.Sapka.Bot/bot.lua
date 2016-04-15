-- Sapka bot: 
-- Author:

---------------------------------------
TEAM = 'foobar'
CFG = 'CFGEfWAPWlaADYLQEUbccGK#CFGuXiyaYMAXErSiMIVoaCg#CFGeQkaKWAirQluBYPMOWLQ#CFGSdYmuwK@gjyYGgYFeTin#CFGoUDQKcSdqheuCtSxQXAQ#CFGmGaAPWWkHykEiyNMvEJa#CFGsXWWoeIyncOkKWCPCyUG#CFGChOUPcgTaRujEJouBoko#CFGUYKUQyHcYLuLMyHUkWe@#CFGmBEaJkWKVEqeiPeFUIWt#CFGCPmKqasLgfUpigolqAaW#CFGcvcevsdODEjsMUAFQqJw#CFGmcsQhsNKFObcAiJotMyB'

---------------------------------------

-- LOGFILE = 'bot-'..TEAM..'.log'
VISUALIZER = true

--[[ supported functions:

launch(team, config)
move_left(bomb)
move_right(bomb)
move_up(bomb)
move_down(bomb)
engine_stop(bomb)

]]--

---------------------------------------

---------------------------------------

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
-- map: { cellsize = n, rows = { {o,o,o,o,o,o,o,o}, {o,o,o,o,o,o,o,o}, ...}
-- every 'o' is a map item (char)
function on_round_start(id, map)
end


-- score: int (your score)
function on_round_end(score)
end


-- Gets called every ~50 ms.
-- The last one to get called after all other map change events.
-- t: int
function on_tick(t)
  if t > 100 then engine_stop(true) end
end


-- player: { id = n, x = n, y = n, speed = n, bombs = n, stren = n, dead = f, infected = f }
function on_player(player)
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
