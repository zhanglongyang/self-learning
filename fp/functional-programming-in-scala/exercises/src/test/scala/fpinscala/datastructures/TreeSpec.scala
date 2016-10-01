package fpinscala.datastructures

import org.scalatest.FunSpec

class TreeSpec extends FunSpec {
  val t: Branch[Int] = Branch(Branch(Leaf(1), Leaf(2)), Branch(Leaf(3), Leaf(4)))

  describe("Tree") {
    describe("size") {
      it("should return 1 leaf") {
        assert(Tree.size(Leaf(2)) == 1)
      }

      it("should sum both left tree and right tree size") {
        assert(Tree.size(t) == 4)
      }
    }

    describe("maximum") {
      it("should return 4") {
        assert(Tree.maximum(t) == 4)
      }
    }

    describe("depth") {
      it("should return 1 for Leaf") {
        assert(Tree.depth(Leaf(1)) == 0)
      }

      it("should return 2 for left with 2 leaves") {
        assert(Tree.depth(Branch(Branch(Leaf(1), Leaf(2)), Leaf(3))) == 2)
      }
    }

    describe("map") {
      it("should map tree") {
        assert(Tree.map(t)(x => x + 1) == Branch(Branch(Leaf(2), Leaf(3)), Branch(Leaf(4), Leaf(5))))
      }
    }
  }
}
