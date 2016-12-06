package fpis

import org.scalatest.{FunSpec, Spec}
import org.scalatest.matchers.ShouldMatchers

class Ch02s06Spec extends FunSpec with ShouldMatchers {

  import Ch02s06.{partial1, curry, uncurry, compose}

  describe("the Section 2.6 code") {

    it("should have a properly working partial1") {
      def f(x: String, y: String) = x + " and " + y
      val fthis = partial1(f, "this")
      fthis("that") should be("this and that")
    }

    it("should have a properly working curry") {
      def f(x: String, y: String) = x + " and " + y
      val fcurried = curry(f)
      val fthis = fcurried("this")
      fthis("that") should be("this and that")
    }

    it("should have a properly working uncurry") {
      def fcurried(x: String) = {(y: String) => x + " and " + y}
      val f = uncurry(fcurried)
      f("this", "that") should be("this and that")
    }

    it("should have a properly working compose") {
      def f(x: String) = "super " + x
      def g(x: String) = "awesome " + x
      val h = compose(f, g)
      h("thing") should be("super awesome thing")
    }

  }
}
