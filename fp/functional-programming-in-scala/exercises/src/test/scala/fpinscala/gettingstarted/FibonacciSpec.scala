package fpinscala.gettingstarted

import org.scalatest.FunSpec

class FibonacciSpec extends FunSpec {
  describe("Fibonacci") {
    it("should return correct fibonacci number") {
      assert(MyModule.fib(0) == 0)
      assert(MyModule.fib(1) == 1)
      assert(MyModule.fib(2) == 1)
      assert(MyModule.fib(3) == 2)
      assert(MyModule.fib(4) == 3)
      assert(MyModule.fib(5) == 5)
      assert(MyModule.fib(6) == 8)
      assert(MyModule.fib(7) == 13)
      assert(MyModule.fib(8) == 21)
      assert(MyModule.fib(9) == 34)
      assert(MyModule.fib(10) == 55)
    }
  }
}
