package fpis


/**
  * Introductory examples: everything up through the end of section 2.4
  */
object Ch02s04 {

  /**
   * Run method: this is from prior to using a test package to run my code,
   * when I needed something to sbt run in order to see my outputs
   *
   * It's the only example I'll leave in this codebase of my pre-using-tests
   * dev workflow :)
   */
  def run(): String = {
    List(
      formatUnary(abs, "absolute value", -42),
      formatUnary(factorial, "factorial", 5),
      formatUnary(fibbonacci, "fibbonacci", 6)
    ).reduce((a, b) => a + "\n" + b)
  }

  def formatUnary(f: Int => Int, f_name: String, n: Int): String = {
    val msg = "The %s of %d is %d"
    msg.format(f_name, n, f(n))
  }

  def abs(n: Int): Int = {
    if (n >= 0) n else -n
  }

  def factorial(n: Int): Int = {
    @annotation.tailrec
    def loop(n: Int, product: Int = 1): Int = {
      if (n <= 1) product
      else loop(n - 1, product * n)
    }
    loop(n)
  }

  def fibbonacci(n: Int): Int = {
    @annotation.tailrec
    def loop(n_left : Int, last: Int = 1, current: Int = 1): Int = {
      if (n_left <= 1) current
      else loop(n_left - 1, current, current + last)
    }
    loop(n - 1)
  }

}
