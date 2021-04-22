import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TvSets {

    WebDriver driver = new ChromeDriver();

        @BeforeAll
        public static void init() {
            System.setProperty("webdriver.chrome.driver", ".\\src\\chromedriver1.exe");
        }

        @Test
        public void test() throws InterruptedException {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            driver.get("https://onliner.by");

            driver.findElement(By.xpath("//span[@class=\"b-main-navigation__text\" and text()='Каталог']")).click();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//span[@class=\"catalog-navigation-classifier__item-title-wrapper\" and text()='Электроника']")).click();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//h3[@class=\"b-tile-header max-lines-2\" and text()='Телевизоры']")).click();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            js.executeScript("window.scrollBy(0, 5000)");
            driver.findElement(By.xpath("//input[@value='lg']/following-sibling::span")).click();
            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
            Assertions.assertTrue(driver.findElement(By.xpath("//input[@value='lg']")).isSelected());
//            Assertions.assertFalse(driver.findElement(By.xpath("//input[@value='samsung']")).isSelected());

            List<WebElement> fullName = new ArrayList<>();
            fullName = driver.findElements(By.xpath("//span[@data-bind=\"html: product.extended_name || product.full_name\"]"));

            for(WebElement webElement : fullName) {
                try {
                    System.out.println("fullName = " + webElement.getText());

                } catch (Exception e) {
                    e.getMessage();
                    System.out.println("Упаль: " + e);
                }
            }
//            driver.quit();
        }
}
