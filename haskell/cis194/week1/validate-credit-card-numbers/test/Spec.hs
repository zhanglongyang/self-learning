import Test.Tasty
import Test.Tasty.HUnit
import Lib

main = defaultMain tests

tests :: TestTree
tests = testGroup "Unit Tests"
  [
    toDigitsTests,
    toDigitsRevTests,
    sumDigitsTests,
    doubleEveryOtherTests
  ]

toDigitsTests = testGroup "toDigits Tests"
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

toDigitsRevTests = testGroup "toDigitsRev Tests"
  [
    testCase "0 to reversed digists should be []" $
    toDigitsRev 0 @?= [],

    testCase "1 to reversed digists should be [1]" $
    toDigitsRev 1 @?= [1],

    testCase "-17 to reversed digists should be []" $
    toDigitsRev (-17) @?= [],

    testCase "1234 to reversed digists should be [4, 3, 2, 1]" $
    toDigitsRev 1234 @?= [4, 3, 2, 1]
  ]

sumDigitsTests = testGroup "sumDigits Tests"
  [
    testCase "sum [] should be 0" $
    sumDigits [] @?= 0,

    testCase "sum [1] should be 1" $
    sumDigits [1] @?= 1,

    testCase "sum [1, 2, 3] should be 6" $
    sumDigits [1, 2, 3] @?= 6,

    testCase "sum [11] should be 2" $
    sumDigits [11] @?= 2,

    testCase "sum [16, 7, 12, 5] should be 22" $
    sumDigits [16, 7, 12, 5] @?= 22
  ]

doubleEveryOtherTests = testGroup "doubleEveryOther Tests"
  [
    testCase "double every other for [] should be []" $
    doubleEveryOther [] @?= [],

    testCase "double every other for [1] should be [1]" $
    doubleEveryOther [1] @?= [1],

    testCase "double every other for [1, 2] should be [2, 2]" $
    doubleEveryOther [1, 2] @?= [2, 2],

    testCase "double every other for [1, 2, 3] should be [1, 4, 3]" $
    doubleEveryOther [1, 2, 3] @?= [1, 4, 3],

    testCase "double every other for [8, 7, 6, 5] should be [16,7,12,5]" $
    doubleEveryOther [8, 7, 6, 5] @?= [16, 7, 12, 5]
  ]