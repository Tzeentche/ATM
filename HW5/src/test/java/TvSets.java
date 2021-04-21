import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TvSets {

        @BeforeAll
        public static void init() {
            System.setProperty("webdriver.chrome.driver", ".\\src\\chromedriver1.exe");
        }

        @Test
        public void test() throws InterruptedException {
            WebDriver driver = new ChromeDriver();
            driver.get("https://onliner.by");
            driver.findElement(By.xpath("//*[@id=\"container\"]/div/div/header/div[2]/div/nav/ul[1]/li[1]/a[2]/span")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id=\"container\"]/div/div/div/div/div[1]/ul/li[2]/span[2]/span")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id=\"widget-9101\"]/div/a/h3")).click();
            Thread.sleep(1000);
            ((JavascriptExecutor)driver).executeScript("window.scrollBy(0, 250)");
            Thread.sleep(1000);
            driver.findElement(By.xpath("//input[@value='lg']/following-sibling::span")).click();
            Assertions.assertTrue(driver.findElement(By.xpath("//input[@value='lg']")).isSelected());
//            driver.quit();
        }
}
