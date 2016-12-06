package fpis


/* 
 * Note that when reading the test output, the TestNG
 * and Spec-based tests are in separate blocks, and the
 * TestNG header actually makes it a little confusing to
 * read. Just look higher up for the FunSpec results.
 */

import org.scalatest.{FunSpec, Spec}
import org.scalatest.matchers.ShouldMatchers

/**
 * Demo of a simple ShouldMatchers test
 *
 * - FYI it's possible to use asserts here and the tests will
 *   run properly
 */
class Ch02s04Spec extends FunSpec with ShouldMatchers {

  import Ch02s04.{factorial, fibbonacci}

  describe("The factorial function") {

    it("works for all numbers up to 4") {
      factorial(1) should be(1)
      factorial(2) should be(2)
      factorial(3) should be(6)
      factorial(4) should be(24)
    }
  }

  describe("The fibbonacci function") {

    it("works for all numbers up to 6") {
      fibbonacci(1) should be(1)
      fibbonacci(2) should be(1)
      fibbonacci(3) should be(2)
      fibbonacci(4) should be(3)
      fibbonacci(5) should be(5)
      fibbonacci(6) should be(8)
    }
  }
}

import java.lang.Integer
import org.scalatest.testng.{TestNGSuite}
import collection.mutable.ArrayBuilder
import org.testng.annotations.{Test, DataProvider}
import org.testng.Assert.assertEquals


/**
 * Demo of using TestNG from scala
 *
 *   - it's pretty easy to use a standard test which just
 *     involves asserts, that works just like in java
 *   - as the example shows, using a data provider can make
 *     life a little messier, since all of the types need to be
 *     understandable to java. So you may need to cast scala types,
 *     e.g. Int here, to Java types; this is a little annoying
 */
class Ch02s04Suite extends TestNGSuite {

  import Ch02s04.{formatUnary, abs}

  @DataProvider(name = "provider")
  def provideData = {
    val g = new ArrayBuilder.ofRef[Array[Object]]

    def intArray(n0: Int, n1: Int): Array[Object] = {
      Array[Object](n0.asInstanceOf[java.lang.Integer],
                    n1.asInstanceOf[java.lang.Integer])
    }

    g += (intArray(0, 0),
          intArray(2, 2),
          intArray(-2, 2))

    g.result()
  }

  @Test(dataProvider = "provider", groups=Array("my-testng-group"))
  def testAbs(n: Int, expected: Int) {
    val actual = abs(n)
    assertEquals(actual, expected)
  }

  @Test(groups=Array("my-testng-group"))
  def testFormatUnaryWithAbs() {
    val actual = formatUnary(abs, "absolute value", -2)
    val expected = "The absolute value of -2 is 2"
    assertEquals(actual, expected)
  }
}
