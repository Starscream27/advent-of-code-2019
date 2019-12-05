package common

import org.scalatest.{FlatSpec, Matchers}

class December4Spec extends FlatSpec with Matchers {
  "December4" should "correctly assess if a number match the password rules" in {
    December4.matchesPasswordRules(111111) shouldBe true
    December4.matchesPasswordRules(223450) shouldBe false
    December4.matchesPasswordRules(123789) shouldBe false
  }
  "December4" should "correctly assess if a number match the password rules with added criterias" in {
    December4.matchesPasswordRules2(112233) shouldBe true
    December4.matchesPasswordRules2(123444) shouldBe false
    December4.matchesPasswordRules2(111122) shouldBe true
  }
}