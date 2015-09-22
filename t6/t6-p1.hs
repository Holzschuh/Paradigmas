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

createRects :: Float -> Float -> [(String, Rect)]
createRects lin col = 
   let
      ys = [20,50..((lin-1)*30)+20]
      xs = [20,70..((col-1)*50)+20]
      
      colors = [(l,s) | l<-[100,100-100/(lin-1)..0], s<-[100,100-100/(col-1)..0]]
      rects = [((x, y), 45, 25) | x <- xs, y <- ys]

      styles = map(\m -> "fill:hsl(15, "++show(fst m)++"%, "++show(snd m)++"%)") colors      
      
   in zip styles rects
    
     

main :: IO ()
main = do
   let
      lin = 20
      col = 20

      (w,h) = (20 + ((col-1)*50)+20 + 45, 20 + ((lin-1)*30)+20 + 25)
          
   writeFile "colors.svg" $ writeRects w h (createRects lin col)

