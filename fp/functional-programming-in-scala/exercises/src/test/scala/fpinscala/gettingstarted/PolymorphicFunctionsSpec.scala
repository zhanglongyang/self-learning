package fpinscala.gettingstarted

import org.scalatest.FunSpec

class PolymorphicFunctionsSpec extends FunSpec {
  describe("PolymorphicFunctions") {
    describe("when given array is sorted") {
      it("should return true if matching comparison") {
        assert(PolymorphicFunctions.isSorted(Array(4, 3, 2, 1), (a: Int, b: Int) => a > b))
      }

      it("should return false if not matching comparison") {
        assert(!PolymorphicFunctions.isSorted(Array(1, 2, 3, 4), (a: Int, b: Int) => a > b))
      }
    }

    describe("when given array is not sorted") {
      it("should return false") {
        assert(!PolymorphicFunctions.isSorted(Array(1, 4, 3, 2), (a: Int, b: Int) => a > b))
      }
    }
  }
}
