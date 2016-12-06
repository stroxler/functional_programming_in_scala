package fpis

import scala.runtime.ScalaRunTime.stringOf

object Ch02s06 {

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
    // Note: functions have a compose method, so you
    // could implement this as g compose f
    (a: A) => g(f(a))
  }

}
