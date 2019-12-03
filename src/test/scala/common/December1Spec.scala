package common

import org.scalatest._

class December1Spec extends FlatSpec with Matchers {
  "December1" should "compute examples correctly" in {
    December1.computeFuelRequired(12) shouldBe 2
    December1.computeFuelRequired(14) shouldBe 2
    December1.computeFuelRequired(1969) shouldBe 654
    December1.computeFuelRequired(100756) shouldBe 33583
  }
  "December1" should "compute examples correctly for phase 2" in {
    December1.computeFuelRequiredTakingAddedFuelMassIntoAccount(14) shouldBe 2
    December1.computeFuelRequiredTakingAddedFuelMassIntoAccount(1969) shouldBe 966
    December1.computeFuelRequiredTakingAddedFuelMassIntoAccount(100756) shouldBe 50346
  }
}
