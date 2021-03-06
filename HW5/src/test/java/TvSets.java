import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class TvSets {

    static WebDriver driver;
    static JavascriptExecutor js;

        @BeforeAll
        public static void init() {
            System.setProperty("webdriver.chrome.driver", ".\\src\\chromedriver1.exe");
            driver = new ChromeDriver();
            js = (JavascriptExecutor) driver;
            driver.get("https://onliner.by");
        }

        @Test
        public void test() throws InterruptedException {

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//span[@class=\"b-main-navigation__text\" and text()='Каталог']")).click();
            driver.findElement(By.xpath("//span[@class=\"catalog-navigation-classifier__item-title-wrapper\" and text()='Электроника']")).click();
            driver.findElement(By.xpath("//h3[@class=\"b-tile-header max-lines-2\" and text()='Телевизоры']")).click();
            js.executeScript("window.scrollBy(0, 5000)");
            driver.findElement(By.xpath("//input[@value='lg']/following-sibling::span")).click();
            Assertions.assertTrue(driver.findElement(By.xpath("//input[@value='lg']")).isSelected());
            Assertions.assertFalse(driver.findElement(By.xpath("//input[@value='samsung']")).isSelected());
            driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//span[@data-bind=\"text: $root.nextPageText\" and text()='Следующие 30 товаров']"));

            List<WebElement> fullName = new ArrayList<>();
            fullName = driver.findElements(By.xpath("//span[@data-bind=\"html: product.extended_name || product.full_name\"]"));

            for(WebElement webElement : fullName) {
                try {
                    System.out.println("FullName= " + webElement.getText().substring(9, 20));
                    Assertions.assertTrue(webElement.getText().toLowerCase().contains("lg"));

                } catch (Exception e) {
                    e.getMessage();
                    System.out.println("Упаль: " + e);
                }
            }
//            driver.quit();
        }
}
