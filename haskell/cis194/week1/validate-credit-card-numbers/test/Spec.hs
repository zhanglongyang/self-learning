import Test.Tasty
import Test.Tasty.HUnit
import Lib

main = defaultMain tests

tests :: TestTree
tests = testGroup "Tests" [toDigitsTests]

toDigitsTests = testGroup "Unit Tests"
  [
    testCase "0 to digits should be []" $
    toDigits 0 @?= [],

    testCase "1 to digits should be [1]" $
    toDigits 1 @?= [1],

    testCase "-17 to digits should be []" $
    toDigits (-17) @?= [],

    testCase "1234 to digits should be [1, 2, 3, 4]" $
    toDigits 1234 @?= [1, 2, 3, 4],

    testCase "4012888888881881 to digits should be [4, 0, 1, 2, 8, 8, 8, 8, 8, 8, 8, 8, 1, 8, 8, 1]" $
    toDigits 4012888888881881 @?= [4, 0, 1, 2, 8, 8, 8, 8, 8, 8, 8, 8, 1, 8, 8, 1]
  ]