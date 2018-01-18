import Test.Tasty
import Test.Tasty.HUnit
import Lib

main = defaultMain test

test :: TestTree
test = testGroup "Unit Tests"
  [
    hanioTests
  ]

hanioTests = testGroup "hanio tests"
  [
    testCase "moves for abc pegs with 2 discs should be [(a, c), (a, b), (c, b)]" $
    hanio 2 "a" "b" "c" @?= [("a","c"), ("a","b"), ("c","b")],

    testCase "moves for abc pegs with 3 discs should be [(a, b), (a, c), (b, c), (a, b), (c, a), (c, b), (a, b)]" $
    hanio 3 "a" "b" "c" @?= [("a","b"),("a","c"),("b","c"),("a","b"),("c","a"),("c","b"),("a","b")]
  ]