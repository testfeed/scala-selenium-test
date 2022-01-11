package selenium.spec

import io.restassured.RestAssured.when
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.{By, WebDriver}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should
import org.scalatest.{BeforeAndAfterAll, BeforeAndAfterEachTestData}
import org.scalatestplus.selenium.WebBrowser

import scala.util.Try

class JuiceSpec extends AnyFlatSpec
  with WebBrowser
  with should.Matchers
  with BeforeAndAfterAll
  with BeforeAndAfterEachTestData {

  val address = "localhost"
  val port = 3000
  implicit val driver: WebDriver = new FirefoxDriver()

  override def afterAll() {
    Try(driver.quit())
  }

  it should "do something" in {
      driver.get(s"http://$address:$port")
      driver.getCurrentUrl should be (s"http://$address:$port/#/")

      driver.findElement(By.className("close-dialog")).click()

      Thread.sleep(1000)

      val apple_juice = driver.findElements(By.className("product"))
      apple_juice.get(0).click

      Thread.sleep(2000)

      driver.findElement(By.className("close-dialog")).click
    }

  it should "test the api" in {
    when()
      .get(s"http://$address:$port/rest/products/search?q=")
      .then()
      .statusCode(200);
  }
}
