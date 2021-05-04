import org.openqa.selenium.*;
import static com.codeborne.selenide.Selenide.*;

public class HomePage {

    private WebElement catalogButton = $(By.linkText("Каталог"));
    private WebElement mobileBurger = $(By.xpath("//a[@class=\"header-style__underlay\"]"));
    private WebElement mobileCatalogButton = $(By.xpath("//span[@class=\"header-style__sign\" and text()='Каталог']"));

    public HomePage clickBurger() {
        mobileBurger.click();
        return this;
    }

    public HomePage selectSection() {
        catalogButton.click();
        return this;
    }

    public HomePage selectMobileSection() {
        catalogButton.click();
        return this;
    }
}
