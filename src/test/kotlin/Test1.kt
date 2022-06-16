import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class Test1 : StringSpec(
  {
    "Simple Test" {
      3 + 4 shouldBe 7
      4 + 4 shouldBe 8
    }
  })