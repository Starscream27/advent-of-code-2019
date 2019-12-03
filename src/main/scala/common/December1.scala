package common

import scala.io.Source

// https://adventofcode.com/2019/day/1

object December1 {
  def main(args: Array[String]): Unit = {
    val inputFile = "December1.input.txt"
    val part1 = Source.fromResource(inputFile).getLines.toList
      .map(_.toLong)
      .map(December1.computeFuelRequired)
      .foldLeft(0.toLong)(_ + _)

    println(s"December 1st, part 1: $part1")
  }

  def computeFuelRequired(mass: Long): Long = mass / 3 - 2
}
