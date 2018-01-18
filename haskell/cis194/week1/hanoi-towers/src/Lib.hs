module Lib
    ( hanio
    ) where

type Peg = String
type Move = (Peg, Peg)

hanio :: Integer -> Peg -> Peg -> Peg -> [Move]
hanio i a b c = [(a, c), (a, b), (c, b)]