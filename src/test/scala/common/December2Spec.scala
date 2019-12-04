package common

import org.scalatest._

import scala.collection.immutable.List

class December2Spec extends FlatSpec with Matchers {
  "December2" should "execute program correctly" in {
    December2.runProgram(List(1,9,10,3,2,3,11,0,99,30,40,50)) shouldBe List(3500,9,10,70,2,3,11,0,99,30,40,50)
    December2.runProgram(List(1,0,0,0,99)) shouldBe List(2,0,0,0,99)
    December2.runProgram(List(2,3,0,3,99)) shouldBe List(2,3,0,6,99)
    December2.runProgram(List(2,4,4,5,99,0)) shouldBe List(2,4,4,5,99,9801)
    December2.runProgram(List(1,1,1,4,99,5,6,0,99)) shouldBe List(30,1,1,4,2,5,6,0,99)
  }
}
