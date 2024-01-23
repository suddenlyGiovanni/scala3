import language.experimental.captureChecking
import scala.annotation.unchecked.uncheckedVariance

trait IterableFactory[+CC[_]] extends Pure:

  def fill[A](n: Int)(elem: => A): CC[A]^{elem} = ???
  def fill[A](n1: Int, n2: Int)(elem: => A): CC[(CC[A]^{elem}) @uncheckedVariance]^{elem} =
  	fill[CC[A]^{elem}](n1)(fill(n2)(elem)) // !!! explicit type argument required under cc
  	// fill(n1)(fill(n2)(elem)) // !!! does not currently work


