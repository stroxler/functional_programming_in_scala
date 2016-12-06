package fpis

import org.scalatest.{FunSpec, Spec}
import org.scalatest.matchers.ShouldMatchers

class Ch02s05Spec extends FunSpec with ShouldMatchers {

  import Ch02s05.{isSorted, findFirst, formatIsSorted}

  describe("The isSorted function") {

    it("should return True on arrays of length 1") {
      isSorted(Array(1), (x: Int, y: Int) => x <= y) should be(true)
      isSorted(Array(1.5), (x: Double, y: Double) => x <= y) should be(true)
    }

    it("should work for tests of ascending order") {
      isSorted(Array(1, 2, 3), (x: Int, y: Int) => x <= y) should be(true)
      isSorted(Array(2, 1, 3), (x: Int, y: Int) => x <= y) should be(false)
    }

    it("should work for tests of descending order") {
      isSorted(Array(3, 1, 2), (x: Int, y: Int) => x > y) should be(false)
      isSorted(Array(3, 2, 1), (x: Int, y: Int) => x > y) should be(true)
    }
  }

  describe("The formatIsSorted function") {

    it("should work on a simple example") {
      val actual = formatIsSorted(Array(1, 2, 3))
      val expected = "isSorted(Array(1, 2, 3), (x, y) => x <= y) is true"
      actual should be(expected)
    }
  }

  describe("The findFirst function") {

    it("should return -1 on empty arrays") {
      findFirst(Array(), (x: Any) => true) should be(-1)
    }

    it("should return -1 when the predicate is false") {
      findFirst(Array(1, 2), (x: Any) => false) should be(-1)
    }

    it("should return 0 when the predicate is true on nonempty arrays") {
      findFirst(Array(1, 2), (x: Any) => true) should be(0)
    }

    it("should return appropriately when the predicate is equality") {
      findFirst(Array(1, 2, 3, 2), (x: Int) => x == 1) should be(0)
      findFirst(Array(1, 2, 3, 2), (x: Int) => x == 2) should be(1)
      findFirst(Array(1, 2, 3, 2), (x: Int) => x == 3) should be(2)
      findFirst(Array(1, 2, 3, 2), (x: Int) => x == 4) should be(-1)
    }

  }
}

