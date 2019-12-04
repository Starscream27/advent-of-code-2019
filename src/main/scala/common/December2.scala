package common

import scala.annotation.tailrec
import scala.io.Source

object December2 {
  type IntCode = List[Int]

  def main(args: Array[String]): Unit = {
    val inputFile = "December2.input.txt"
    val input = Source.fromResource(inputFile)
      .mkString
      .stripLineEnd
      .split(",")
      .toList
      .filter(_.nonEmpty)
      .map(_.toInt)

    val memory = input.updated(1, 12).updated(2, 2)
    val res = runProgram(memory)

    println(s"input: $input")
    println(s"res  : (${res.head} from $res")
  }

  def runProgram(memory: IntCode) = {
    @tailrec
    def runProgramAtAddress(memory: IntCode, address: Int): IntCode = {
      executeInstruction(memory, address) match {
        case (updatedMemory, Some(nextAddress)) => runProgramAtAddress(updatedMemory, nextAddress)
        case (updatedMemory, None) => updatedMemory
      }
    }

    runProgramAtAddress(memory, 0)
  }

  private def executeInstruction(memory: IntCode, address: Int): (IntCode, Option[Int]) = memory.lift(address) match {
      case Some(1) => executeInstruction(memory, address, _ + _) -> Some(address + 4)
      case Some(2) => executeInstruction(memory, address, _ * _) -> Some(address + 4)
      case Some(99) => memory -> None
      case _ =>  memory -> None
  }

  private def executeInstruction(memory: IntCode, address: Int, instruction: (Int, Int) => Int): IntCode = {
    if (memory.length < address + 4 - 1) memory
    else memory.updated(memory(address + 3), instruction(memory(memory(address + 1)), memory(memory(address + 2))))
  }
}