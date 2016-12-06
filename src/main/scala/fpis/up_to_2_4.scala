package fpis


/**
  * Introductory examples: everything up through the end of section 2.4
  */
object UpTo2_4 {

  /**
   * Run method: this is from prior to using a test package to run my code,
   * when I needed something to sbt run in order to see my outputs
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
    def go(n: Int, product: Int = 1): Int = {
      if (n <= 1) product
      else go(n - 1, product * n)
    }
    go(n)
  }

  def fibbonacci(n: Int): Int = {
    @annotation.tailrec
    def go(n_left : Int, last: Int = 1, current: Int = 1): Int = {
      if (n_left <= 1) current
      else go(n_left - 1, current, current + last)
    }
    go(n - 1)
  }

}
