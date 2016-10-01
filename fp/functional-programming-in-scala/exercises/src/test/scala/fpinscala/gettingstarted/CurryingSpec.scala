package fpinscala.gettingstarted

import org.scalatest.FunSpec

class CurryingSpec extends FunSpec {
  describe("Curry") {
    it("should currying function") {
      def f(a: String, b: String): String = a + b

      assert(f("hello", "world") == PolymorphicFunctions.curry(f)("hello")("world"))
    }
  }

  describe("Uncurry") {
    it("should uncurring function") {
      def f(a: String)(b: String): String = a + b

      assert(f("hello")("world") == PolymorphicFunctions.uncurry(f)("hello", "world"))
    }
  }
}
