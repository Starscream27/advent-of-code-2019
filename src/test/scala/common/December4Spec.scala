package common

import org.scalatest.{FlatSpec, Matchers}

class December4Spec extends FlatSpec with Matchers {
  "December4" should "correctly assess if a number match the password rules" in {
    December4.matchesPasswordRules(111111) shouldBe true
    December4.matchesPasswordRules(223450) shouldBe false
    December4.matchesPasswordRules(123789) shouldBe false
  }
}