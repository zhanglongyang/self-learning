package fpinscala.errorhandling

import org.scalatest.FunSpec

class OptionSpec extends FunSpec {
  describe("Option") {
    describe("map") {
      it("should return None for None") {
        assert(None.map((x: Int) => x + 1) == None)
      }

      it("should return Some for some value") {
        assert(Some(1).map(x => x + 1) == Some(2))
      }
    }

    describe("getOrElse") {
      it("should return default value for None") {
        assert(None.getOrElse(1) == 1)
      }

      it("should return given value for Some") {
        assert(Some(1).getOrElse(3) == 1)
      }
    }

    describe("flatMap") {
      it("should return None for None") {
        assert(None.flatMap((x: Int) => Some(x + 1)) == None)
      }

      it("should return Some for Some") {
        assert(Some(1).flatMap(x => Some(x.toString)) == Some("1"))
      }
    }

    describe("orElse") {
      it("should return default for None") {
        assert(None.orElse(Some(1)) == Some(1))
      }

      it("should return itself for Some") {
        assert(Some(1).orElse(Some(2)) == Some(1))
      }
    }

    describe("filter") {
      it("should return None for None") {
        assert(None.filter((x: Int) => x % 2 == 0) == None)
      }

      it("should return None if not satisfied") {
        assert(Some(1).filter(x => x % 2 == 0) == None)
      }

      it("should return Some if satisfied") {
        assert(Some(2).filter(x => x % 2 == 0) == Some(2))
      }
    }
  }
}
