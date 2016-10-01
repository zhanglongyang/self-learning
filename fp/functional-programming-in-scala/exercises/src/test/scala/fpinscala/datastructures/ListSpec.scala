package fpinscala.datastructures

import org.scalatest.FunSpec

class ListSpec extends FunSpec {
  describe("List") {
    val l = List(1, 2, 3, 4)

    describe("tail") {
      it("should return Nil when l is Nil") {
        assert(List.tail(Nil) == Nil)
      }

      it("should return tail of list when l is not Nil") {
        assert(List.tail(l) == List(2, 3, 4))
      }
    }

    describe("setHead") {
      it("should set head") {
        assert(List.setHead(l, 5) == List(5, 2, 3, 4))
      }
    }

    describe("drop") {
      it("should return list itself when n is 0") {
        assert(List.drop(l, 0) == List(1, 2, 3, 4))
      }

      it("should return Nil if list is Nil") {
        assert(List.drop(Nil, 3) == Nil)
      }

      it("should return list without n-th item") {
        assert(List.drop(l, 2) == List(3, 4))
      }
    }

    describe("dropWhile") {
      it("should return Nil if list is Nil") {
        assert(List.dropWhile(Nil, (x: Int) => x % 2 == 0) == Nil)
      }

      it("should return list with even only") {
        assert(List.dropWhile(l, (x: Int) => x % 2 == 0) == List(2, 4))
      }
    }

    describe("init") {
      it("should return Nil if list is Nil") {
        assert(List.init(Nil) == Nil)
      }

      it("should return itself if list only has 1 item") {
        assert(List.init(List(1)) == List(1))
      }

      it("should return list without the last item if list has more than 1 items") {
        assert(List.init(l) == List(1, 2, 3))
      }
    }

    describe("length") {
      it("should return 0 if list is Nil") {
        assert(List.length(Nil) == 0)
      }

      it("should return 1 if list only has 1 item") {
        assert(List.length(List(1)) == 1)
      }

      it("should return 4 if list has 4 items") {
        assert(List.length(l) == 4)
      }
    }

    describe("foldLeft") {
      it("should return 0 if list is Nil") {
        assert(List.foldLeft(Nil, 0)((x: Int, y: Int) => x + y) == 0)
      }

      it("should return 1 if list has 1 item") {
        assert(List.foldLeft(List(1), 0)((x, y) => x + y) == 1)
      }

      it("should return 10 if list has 4 items") {
        assert(List.foldLeft(l, 0)((x, y) => x + y) == 10)
      }
    }

    describe("map") {
      it("should map with adding 1") {
        assert(List.map(l)(x => x + 1) == List(2, 3, 4, 5))
      }

      it("should map Double to String") {
        assert(List.map(List(1.1, 2.2))(x => x.toString) == List("1.1", "2.2"))
      }
    }

    describe("filter") {
      it("should filter even number from list") {
        assert(List.filter(l)(x => x % 2 == 0) == List(2, 4))
      }
    }

    describe("flatMap") {
      it("should return Nil when list is Nil") {
        assert(List.flatMap(Nil)((x: Int) => List(x - 1, x + 1)) == Nil)
      }

      it("should return flat-mapped List[B]") {
        assert(List.flatMap(l)(x => List(x - 1, x + 1)) == List(0, 2, 1, 3, 2, 4, 3, 5))
      }
    }

    describe("filter via flatMap") {
      it("should filter even number from list") {
        assert(List.filterViaFlatMap(l)(x => x % 2 == 0) == List(2, 4))
      }
    }

    describe("zipWith") {
      it("should return Nil if first one is Nil") {
        assert(List.zipWith(Nil, l)((x, y) => x + y) == Nil)
      }

      it("should return Nil if second one is Nil") {
        assert(List.zipWith(l, Nil)((x, y) => x + y) == Nil)
      }

      it("should return zip list if first list shorter than second one") {
        assert(List.zipWith(List(1, 2, 3), List(1, 2, 3, 4))((x, y) => x + y) == List(2, 4, 6))
      }

      it("should return zip list if second list shorter than first one") {
        assert(List.zipWith(List(1, 2, 3, 4), List(1, 2, 3))((x, y) => x + y) == List(2, 4, 6))
      }

      it("should return zip list if two lists have the same size") {
        assert(List.zipWith(l, l)((x, y) => x + y) == List(2, 4, 6, 8))
      }
    }

    describe("hasSubsequence") {
      it("should return false if sup is Nil") {
        assert(List.hasSubsequence(Nil, l) == false)
      }

      it("should return true if sub is Nil") {
        assert(List.hasSubsequence(l, Nil))
      }

      it("should return true if sub is subsequence of sup") {
        assert(List.hasSubsequence(l, List(1, 2)))
      }

      it("should return false if sub is not subsequence of sup") {
        assert(List.hasSubsequence(l, List(2, 4)) == false)
      }
    }
  }
}
