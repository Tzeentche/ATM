import com.codeborne.selenide.*;
import org.openqa.selenium.*;

import static com.codeborne.selenide.Selenide.$;

public class PageHome {

    //        private WebElement catalogButton = $(By.linkText("Каталог"));
    private SelenideElement navigElemAuto = $(By.xpath("//span[@class=\"b-main-navigation__text\" and text()='Автобарахолка']"));
    private WebElement mobileCatalogButton = $(By.xpath("//span[@class=\"header-style__sign\" and text()='Каталог']"));

    public PageHome findNavigElemHome() {
        navigElemAuto.shouldBe(Condition.visible);
        navigElemAuto.hover();
        return this;
    }

//        public PageAuto selectSection() {
//            catalogButton.click();
//            return this;
//        }
//
//        public PageAuto selectMobileSection() {
//            catalogButton.click();
//            return this;
//        }





}
