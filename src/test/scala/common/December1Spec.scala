package common

import org.scalatest._

class December1Spec extends FlatSpec with Matchers {
  "December1" should "compute examples correctly" in {
    December1.computeFuelRequired(12) shouldBe 2
    December1.computeFuelRequired(14) shouldBe 2
    December1.computeFuelRequired(1969) shouldBe 654
    December1.computeFuelRequired(100756) shouldBe 33583
  }
}
