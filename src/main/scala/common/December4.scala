package common

object December4 {
  def main(args: Array[String]): Unit = {
    val matches = (236491 to 713787)
      .map(matchesPasswordRules)
      .count(_ == true)

    println(s"Number of matches found: $matches")
  }

  private def twoAdjacentDigitsAreTheSame(password: Int): Boolean = {
    val digits = password.toString.toArray
    for ((currentValue, index) <- digits.view.zipWithIndex) {
      digits.lift(index - 1) match {
        case Some(prevValue) if currentValue == prevValue => return true
        case _ => {}
      }
    }
    false
  }
  private def digitsAlwaysIncrease(password: Int): Boolean = {
    val digits = password.toString.toArray
    for ((current, index) <- digits.view.zipWithIndex) {
      digits.lift(index - 1) match {
        case Some(prev) if prev > current => return false
        case _ => {}
      }
    }
    true
  }

  def matchesPasswordRules(password: Int): Boolean =
    twoAdjacentDigitsAreTheSame(password) && digitsAlwaysIncrease(password)
}
