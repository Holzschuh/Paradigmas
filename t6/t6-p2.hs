import Text.Printf

linhas = 7
colunas = 5

type Point     = (Float,Float)
type Rect      = (Point,Float,Float)


-- Gera retangulo SVG 
-- a partir de coordenadas+dimensoes e de uma string com atributos de estilo
writeRect :: (String,Rect) -> String 
writeRect (style,((x,y),w,h)) = 
  printf "<rect x='%.3f' y='%.3f' width='%.2f' height='%.2f' style='%s' />\n" x y w h style

-- Gera codigo-fonte de arquivo SVG 
-- concatenando uma lista de retangulos e seus atributos de estilo
writeRects :: Float -> Float -> [(String,Rect)] -> String 
writeRects w h rs = 
  printf "<svg width='%.2f' height='%.2f' style='background:gray' xmlns='http://www.w3.org/2000/svg'>\n" w h 
      ++ (concatMap writeRect rs) ++ "</svg>"

{--
     O codigo abaixo cria um arquivo "colors.svg" com 2 retangulos.
     Para simplificar o exemplo, todos os atributos sao definidos manualmente,
     mas para gerar figuras maiores os atributos deverao ser calculados por funcoes.
 --}

createRects :: Float -> Float -> Float -> Float -> Float -> [(String, Rect)]
createRects hue xInit yInit lin col = 
   let
      xs = [xInit, xInit+50 ..((col-1)*50)+xInit]
      ys = [yInit, yInit+30 ..((lin-1)*30)+yInit]
      
      colors = [(l,s) | l<-[100,100-100/(lin-1)..0], s<-[100,100-100/(col-1)..0]]
      rects = [((x, y), 45, 25) | x <- xs, y <- ys]

      styles = map(\m -> "fill:hsl(" ++show (hue)++ "," ++show(fst m)++ "%," ++show(snd m)++ "%)" ) colors      
      
   in (zip styles rects)
    
     

main :: IO ()
main = do
   let
      lin = 10
      col = 10
      xInit = 10
      yInit = 10

      out1 = createRects 0 xInit yInit lin col 
      out2 = createRects 60 (col*50+xInit+30) yInit lin col 
      out3 = createRects 200 xInit (lin*30+yInit+30) lin col 
      out4 = createRects 250 (col*50+xInit+30) (lin*30+yInit+30) lin col
      
      out = out1 ++ out2 ++ out3 ++ out4

      (wAux,hAux) = (xInit + ((col-1)*50)+xInit + 45, yInit + ((lin-1)*30)+yInit + 25)
      (w,h) = (wAux*4+30,hAux*4+30)
   writeFile "colors.svg" $ writeRects w h out

