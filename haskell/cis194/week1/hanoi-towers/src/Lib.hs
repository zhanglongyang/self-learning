module Lib
    ( hanio
    ) where

type Peg = String
type Move = (Peg, Peg)

hanio :: Integer -> Peg -> Peg -> Peg -> [Move]
hanio 1 a b c = [(a, b)]
hanio n a b c = hanio (n - 1) a c b ++ [(a, b)] ++ hanio (n - 1) c b a