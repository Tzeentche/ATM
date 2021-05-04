import com.codeborne.selenide.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.*;

public class OnlinerMobilePageTest {

        private WebDriver driver;
        private HomePage homePage;
        private Catalog catalog;
        private CompAndNet compAndNet;
        int countTitle = 0, countPrice = 0, countGoods = 0;

        @BeforeEach
        public void setUp() {
            System.setProperty("chromeoptions.mobileEmulation", "deviceName=Nexus 5");
            Configuration.startMaximized = true;
            open("https://onliner.by/");
            homePage = new HomePage();
            homePage.clickBurger();
            homePage.selectMobileSection();
        }

        @Test
        public void testCatalog() throws InterruptedException {

            catalog = new Catalog();
            int count = catalog.textExtractor();
            int countArray = catalog.names.length;

            // если количество элементов совпали со списком из задачи, то возвращаем true
            Assertions.assertEquals(countArray, count);
        }

        @Test
        public void testCompAndNets() throws InterruptedException {

            catalog = new Catalog();
            catalog.clickButton();
            compAndNet = new CompAndNet();
            int count = compAndNet.sideListExtractor();
            int countArray = compAndNet.names.length;

//        Убедиться что появляется вертикальный список пунктов секции:
            Assertions.assertTrue(compAndNet.getVerticalList().size() > 0);

//        Присутствуют как минимум пункты "Ноутбуки,компьютеры, мониторы", "Комплектующие", "Хранение данных", "Сетевое оборудование"
            Assertions.assertEquals(countArray, count);
        }

        @Test
        public void testAccessories() throws InterruptedException {

            int countArray;
            catalog = new Catalog();
            compAndNet = new CompAndNet();
            ElementsCollection listCompComponents;

            catalog.clickButton();
            compAndNet.clickElement();

//        Количество элементов в списке
            countArray = compAndNet.getListComponents().size();

//        Лист названий элементов
//        Лист цен элементов
            for(String xpath : compAndNet.xpathes) {
                listCompComponents = $$(By.xpath(xpath));

                for (WebElement element : listCompComponents) {
                    String getext = element.getText().trim();

                    if (xpath.contains("/span/span[2]")) {
                        countTitle++;

                    } else if(xpath.contains("/span/span[3]")) {
                        String[] arraySubstring;
                        String delimeter = " ";
                        arraySubstring = getext.split(delimeter);

                        if(!arraySubstring[0].isEmpty()) {
                            countGoods++;
                        }

                        if (!arraySubstring[1].isEmpty()) {
                            countPrice++;
                        }
                    }
                }
            }

            assertAll("All counts are equals!",
                    () -> assertEquals(countTitle, countGoods),
                    () -> assertEquals(countPrice, countTitle),
                    () -> assertEquals(countGoods, countPrice));
        }

        @AfterEach
        public void tearDown() {

        }
}
