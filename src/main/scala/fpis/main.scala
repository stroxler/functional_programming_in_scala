package fpis

import scala.runtime.ScalaRunTime.stringOf


/**
  *  This is my main, which I use to keep other objects
  *  functionally pure
  */
object Main {

  def main(args: Array[String]): Unit = {
    println(PolymorphicHi.run())
    println(Type2ImpHi.run())
  }
}

/**
  *  section 2.6 examples and exercises
  */
object Type2ImpHi {

  def run(): String = {
    List(
      formatPartial1((x: Int, y: Int) => x + y, "+", 1, 2),
      formatPartial1((x: Int, y: Double) => x / y, "/", 1, 2.5),
      "curry(+)(1)(2) gives %s"
        .format(curry((x: Int, y: Int) => x + y)(1)(2)),
      "uncurry(curry(+))(1, 2) gives %s"
        .format(uncurry(curry((x: Int, y: Int) => x + y))(1, 2)),
      "compose(_ + 1, _ * 3)(2) gives %s"
        .format(compose((x: Double) => x + 1, (x: Double) => x * 3)(2))
    ).reduce( (x, y) => {x + "\n" + y} )
  }

  def formatPartial1[A, B, C](f: (A, B) => C, fStr: String, a: A, b: B) = {
    val result = partial1(f, a)(b)
    "partial1(%s, %s)(%s) is %s".format(fStr, a, b, result)
  }

  def partial1[A, B, C](f: (A, B) => C, a: A): B => C = {
    (b: B) => f(a, b)
  }

  def curry[A, B, C](f: (A, B) => C): A => B => C = {
    (a: A) => partial1(f, a)
  }

  def uncurry[A, B, C](f: A => B => C): (A, B) => C = {
    (a: A, b: B) => f(a)(b)
  }

  def compose[A, B, C](g: B => C, f: A => B): A => C = {
    g compose f
  }
}

/**
  * Section 2.5 examples and exercises
  */
object PolymorphicHi {

  def run(): String = {
    val myarray = Array("this", "that", "another")
    List(
      formatFindFirst(myarray, "this"),
      formatFindFirst(myarray, "that"),
      formatFindFirst(myarray, "oops"),
      formatIsSorted(Array(1, 2, 3)),
      formatIsSorted(Array(2, 1, 3)),
      formatIsSorted(Array(1.5, 2.5, 3.5))
    ).reduce( (x, y) => {x + "\n" + y} )
  }

  def formatFindFirst[A](array: Array[A], thing: A) : String = {
    val arrayStr = stringOf(array)
    val idx = findfirst(array, (a: A) => { a == thing} )
    s"findfirst(${arrayStr}, ${thing}) is ${idx}"
  }

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

  def findfirst[A](container: Array[A], p: A => Boolean) = {
    @annotation.tailrec
    def go(n: Int): Int = {
      if (container.length <= n) -1
      else if ( p(container(n)) ) n
      else go(n + 1)
    }
    go(0)
  }
}
