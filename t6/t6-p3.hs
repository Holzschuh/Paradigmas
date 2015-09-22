import Text.Printf
import System.Random

linhas = 7
colunas = 5

type Point     = (Float,Float)
type Rect      = (Point,Float,Float)
type Circle    = (Point,Float)


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

writeCircle :: (String,Circle) -> String 
writeCircle (style,((x,y),radius)) = 
  printf "<circle cx='%.2f' cy='%.2f' r='%.2f' style ='%s'/>" x y radius style


writeCircles :: Float -> Float -> [(String,Circle)] -> String
writeCircles w h circles =
  printf "<svg width='%.2f' height='%.2f' style='background:gray' xmlns='http://www.w3.org/2000/svg'>\n" w h 
      ++ (concatMap writeCircle circles) ++ "</svg>"


-- <svg height="100" width="100">
--  <circle cx="50" cy="50" r="40" stroke="black" stroke-width="3" fill="red" />
-- </svg> 

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
    
createCircles :: Float -> Float -> Float -> Float -> Float -> [(String, Circle)]
createCircles hue xc yc radMax n = 
   let
      colors = [(l,s) | l<-[100,100-100/(n-1)..0], s<-[100,100-100/(n-1)..0]]
      circles = [((xc, yc), radius) | radius <- [radMax, (radMax-0.1).. 1] ]

      styles = map(\m -> "fill:hsl(" ++show (hue)++ "," ++show(fst m)++ "%," ++show(snd m)++ "%)" ) colors      
      
   in (zip styles circles)

     

main :: IO ()
main = do
   let
      lin = 10
      col = 10
      xInit = 10
      yInit = 10
      
      out = createCircles 15 350 350 250 500
      
      (wAux,hAux) = (xInit + ((col-1)*50)+xInit + 45, yInit + ((lin-1)*30)+yInit + 25)
      (w,h) = (wAux*4+30,hAux*4+30)
   writeFile "colors.svg" $ writeCircles w h out

