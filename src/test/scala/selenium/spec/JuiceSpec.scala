package selenium.spec

import com.dimafeng.testcontainers.GenericContainer
import com.dimafeng.testcontainers.scalatest.TestContainerForAll
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.{By, WebDriver}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should
import org.scalatest.{BeforeAndAfterAll, BeforeAndAfterEachTestData}
import org.scalatestplus.selenium.WebBrowser
import org.testcontainers.containers.wait.strategy.Wait

import scala.util.Try

class JuiceSpec extends AnyFlatSpec with TestContainerForAll
  with WebBrowser
  with should.Matchers
  with BeforeAndAfterAll
  with BeforeAndAfterEachTestData {

  val aPort = 3000
  override val containerDef = GenericContainer.Def("bkimminich/juice-shop:v13.0.3",
                                                              exposedPorts = Seq(aPort),
                                                              waitStrategy = Wait.forHttp("/"))

  implicit val driver: WebDriver = new FirefoxDriver()

  override def afterAll() {
    Try(driver.quit())
  }

  it should "do something" in withContainers { juiceShopContainer =>
      val address: String = juiceShopContainer.containerIpAddress
      val port: Int = juiceShopContainer.mappedPort(aPort)
      driver.get(s"http://$address:$port")
      driver.getCurrentUrl should be (s"http://$address:$port/#/")

      driver.findElement(By.className("close-dialog")).click()

      Thread.sleep(1000)

      val apple_juice = driver.findElements(By.className("product"))
      apple_juice.get(0).click

      Thread.sleep(2000)

      driver.findElement(By.className("close-dialog")).click
    }
}
