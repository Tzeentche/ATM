import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class CompAndNet {

    public String[] names = {"Ноутбуки, компьютеры, мониторы", "Комплектующие", "Хранение данных", "Сетевое оборудование"};
    String[] xpathes = {"//div[@data-id=\"2\"]//div/div[2]/div[2]/div/a/span/span[2]",
            "//div[@data-id=\"2\"]//div/div[2]/div[2]/div/a/span/span[3]"};
    List<String> listSideElements = new ArrayList<>();

    private WebElement elementsButton = $(By.xpath("//div[@class=\"catalog-navigation-list__aside-title\" and contains(text(), 'Комплектующие')]"));
    private ElementsCollection verticalList = $$(By.xpath("//*[@id=\"container\"]/div/div/div/div/div[1]/div[3]/div/div[2]/div[1]/div/div"));
    private ElementsCollection listCompComponents = $$(By.xpath("//div[@data-id=\"2\"]//div/div[2]/div[2]/div/a"));

    public CompAndNet clickElement() {
        $(elementsButton).click();
        return this;
    }

    public ElementsCollection getVerticalList() {
        return verticalList;
    }

    public ElementsCollection getListComponents() {
        return listCompComponents;
    }

    public int sideListExtractor() {

        int count = 0;
        for (WebElement webElement : getVerticalList()) {
            listSideElements.add(webElement.getText());
        }

        for (String element : names) {

            for (String listElement : listSideElements) {

                if (element.equals(listElement)) {
                    count++;
                }
            }
        }
        return count;
    }
}
