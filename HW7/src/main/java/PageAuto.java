import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Selenide.*;

    public class PageAuto {

//        private WebElement catalogButton = $(By.linkText("Каталог"));
        private SelenideElement navigElemAuto = $(By.xpath("//span[@class=\"b-main-navigation__text\" and text()='Автобарахолка']"));
        private WebElement mobileCatalogButton = $(By.xpath("//span[@class=\"header-style__sign\" and text()='Каталог']"));

        public PageAuto findNavigElemAuto() {
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
