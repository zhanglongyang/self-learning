module Lib
  (
    toDigits,
    toDigitsRev,
    sumDigits,
    doubleEveryOther
  ) where

toDigits :: Integer -> [Integer]
toDigits x
  | x <= 0 = []
  | otherwise = toDigits (x `div` 10) ++ [x `mod` 10]

toDigitsRev :: Integer -> [Integer]
toDigitsRev = reverse . toDigits

sumDigits :: [Integer] -> Integer
sumDigits [] = 0
sumDigits (x:xs)= sum (toDigits x) + sumDigits xs

doubleEveryOther :: [Integer] -> [Integer]
doubleEveryOther [] = []
doubleEveryOther (x:[]) = [x]
doubleEveryOther (x:y:zs)
  | (length (x:y:zs)) `mod` 2 == 0 = 2*x : y : doubleEveryOther zs
  | otherwise = x : 2*y : doubleEveryOther zs