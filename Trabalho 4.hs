--1
eleva2 :: [Int] -> [Int]
eleva2 [] = []
eleva2 (x:xs) = x^2 : eleva2 xs

--2
contido :: Char -> String -> Bool
contido c [] = False
contido c (x:xs)
   | c == x = True
   | otherwise = contido c xs

--3
semVogais :: String -> String
semVogais [] = []
semVogais (x:xs)
   | x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u' = semVogais xs
   | otherwise = x : semVogais xs

--4
translate :: [(Float, Float)] -> [(Float, Float)]
translate [] = []
translate ((x,y):xs) = (x+2, y+2) : translate xs

--5
geraTabela' :: Int -> [(Int, Int)]
geraTabela' n = geraTabela 1 n

geraTabela :: Int -> Int -> [(Int, Int)]
geraTabela m n 
   | m <= n = (m, m^2) : geraTabela (m+1) n
   | otherwise = []
