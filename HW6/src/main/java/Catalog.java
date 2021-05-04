import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.*;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class Catalog {

    public String[] names = {"Электроника", "Компьютеры и сети", "Бытовая техника", "Стройка и ремонт", "Дом и сад", "Авто и мото",
            "Красота и спорт", "Детям и мамам", "Работа и офис", "Еда"};
    private WebElement tabButton = $(By.xpath("//span[@class=\"catalog-navigation-classifier__item-title-wrapper\" and " +
            "contains(text(), 'Компьютеры и')]"));
    private ElementsCollection listClasses = $$(By.xpath("//span[@class=\"catalog-navigation-classifier__item-title-wrapper\"]"));
    List<String> listElements = new ArrayList<>();


    public int textExtractor() {

        int count = 0;

        for (WebElement webElement : getListClasses()) {
            listElements.add(webElement.getText());
        }

        for (String element : names) {

            for (String listElement : listElements) {

                if (element.equals(listElement)) {
                    count++;
                }
            }
        }
        return count;
    }

    public Catalog clickButton() {
        tabButton.click();
        return this;
    }

    public ElementsCollection getListClasses() {
        return listClasses;
    }
}
