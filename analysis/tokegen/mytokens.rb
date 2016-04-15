if $*.size < 1
  puts "usage: mytokens teamname"
  exit
end

team = $*[0]
puts team

cfg = []
dma = []

File.readlines('sapka-tokenids.txt').each {|l|
  l =~ /(e|d)\(\"(.*?)\"\)\s+\"(.*?)\"/
  type = $1 == 'e' ? 'CFG' : 'DMA'
  tid = $2
  cmt = $3
  tk = %x|token.exe #{team} #{type} #{tid}|
  tk.strip!

  cfg << tk if type == 'CFG'
  dma << tk if type == 'DMA'

  puts "#{tk} - #{cmt}"
}

if cfg.size > 0
  s = cfg.join('#')
  puts "config #{s};"
end
if dma.size > 0
  s = dma.join('#')
  puts "dma #{s};"
end
