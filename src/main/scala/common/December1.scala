package common

import scala.io.Source

// https://adventofcode.com/2019/day/1

object December1 {
  def main(args: Array[String]): Unit = {
    val inputFile = "December1.input.txt"
    val transformer: (Long => Long) => Long = transformInputFile(inputFile)
    println(s"December 1st, part 1: ${transformer(computeFuelRequired)}")
    println(s"December 1st, part 2: ${transformer(computeFuelRequiredTakingAddedFuelMassIntoAccount)}")
  }

  def transformInputFile(inputFilePath: String)(computer: Long => Long): Long = Source.fromResource(inputFilePath)
      .getLines
      .toList
      .map(_.toLong)
      .map(computer)
      .foldLeft(0L)(_ + _)

  def computeFuelRequired(mass: Long): Long = mass / 3 - 2
  def computeFuelRequiredTakingAddedFuelMassIntoAccount(mass: Long): Long = {
    val fuel = computeFuelRequired(mass)
    if (fuel <= 0) 0
    else fuel + computeFuelRequiredTakingAddedFuelMassIntoAccount(fuel)
  }
}
