package common

import scala.collection.mutable.ListBuffer

object December4 {
  def main(args: Array[String]): Unit = {
    val matches = (236491 to 713787)
      .count(matchesPasswordRules)

    println(s"Number of matches found: $matches")

    val matchesPart2 = (236491 to 713787)
      .count(matchesPasswordRules2)

    println(s"Number of refined (part2) matches found: $matchesPart2")
  }

  private def toDigits(password: Int): List[Int] = password.toString.toList.map(_.toInt)

  private def twoAdjacentDigitsAreTheSame(password: Int): Boolean = {
    toDigits(password)
      .sliding(2)
      .exists(window => window.head == window.last)
  }

  private def digitsAlwaysIncrease(password: Int): Boolean = {
    toDigits(password)
      .sliding(2)
      .forall(window => window.last >= window.head)
  }

  private def atLeastOneGroupOfTwoEqualDigitsAreIsolated(password: Int): Boolean = {
    def findAllGroupOfTwoEqualDigitsIndexes(digits: List[Int]): List[(Int, Int)] = {
      val adjacentValuesIndexes = ListBuffer[(Int, Int)]()
      for ((currentValue, index) <- digits.view.zipWithIndex) {
        digits.lift(index - 1) match {
          case Some(prevValue) if currentValue == prevValue => {
            adjacentValuesIndexes.addOne((index - 1, index))
          }
          case _ => {}
        }
      }
      adjacentValuesIndexes.toList
    }
    def isDigitAtIndexEqualThan(digits: List[Int], index: Int, than: Int) = {
        digits.lift(index) match {
          case Some(value) if value == than => true
          case _ => false
        }
    }

    val digits = toDigits(password)
    val adjacentValues = findAllGroupOfTwoEqualDigitsIndexes(digits)

    val numberOfIsolatedAdjacentPairs = adjacentValues.map(indexes => {
      val value = digits(indexes._1)
      val previousIsSame = isDigitAtIndexEqualThan(digits, indexes._1 - 1, value)
      val nextIsSame = isDigitAtIndexEqualThan(digits, indexes._2 + 1, value)
      previousIsSame || nextIsSame
    }).count(_ == false)

    numberOfIsolatedAdjacentPairs > 0
  }

  def matchesPasswordRules(password: Int): Boolean =
    twoAdjacentDigitsAreTheSame(password) && digitsAlwaysIncrease(password)

  def matchesPasswordRules2(password: Int): Boolean =
    twoAdjacentDigitsAreTheSame(password) && atLeastOneGroupOfTwoEqualDigitsAreIsolated(password) && digitsAlwaysIncrease(password)
}
