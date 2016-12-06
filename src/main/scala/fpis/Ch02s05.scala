package fpis

import scala.runtime.ScalaRunTime.stringOf

object Ch02s05 {

  /**
   * I've kept this formatting function, which is from when I
   * didn't have tests and was using print statements to verify
   * my code, because it demonstrates one way of doing generic
   * programming in scala.
   */
  def formatIsSorted[@specialized A](array: Array[A])
      (implicit arithmetic: Numeric[A])
      : String = {
    val arrayStr = stringOf(array)
    val isArraySorted = isSorted(
      array, (x: A, y: A) => { arithmetic.lteq(x, y) }
    )
    s"isSorted(${arrayStr}, (x, y) => x <= y) is ${isArraySorted}"
  }

  def isSorted[A](container: Array[A], ordering: (A, A) => Boolean) = {
    @annotation.tailrec
    def go(n: Int): Boolean = {
      if (n >= container.length) true
      else if (!ordering(container(n - 1), container(n))) false
      else go(n + 1)
    }
    go(1)
  }

  def findFirst[A](container: Array[A], p: A => Boolean) = {
    @annotation.tailrec
    def go(n: Int): Int = {
      if (container.length <= n) -1
      else if ( p(container(n)) ) n
      else go(n + 1)
    }
    go(0)
  }

}
