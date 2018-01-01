import Test.Tasty
import Test.Tasty.HUnit

main = defaultMain tests

tests :: TestTree
tests = testGroup "Tests" [unitTests]

unitTests = testGroup "Unit Tests"
  [ testCase "List comparison (different length)" $
    [1, 2, 3] `compare` [1, 2] @?= GT
  ]