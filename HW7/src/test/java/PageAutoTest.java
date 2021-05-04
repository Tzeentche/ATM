import io.cucumber.java.ru.*;
import org.openqa.selenium.support.PageFactory;

public class PageAutoTest {

    PageAuto pageAuto = new PageAuto();

    @Когда("Пользователь наводит курсор мыши на пункт {string}")
    public void пользователь_наводит_курсор_мыши_на_пункт(String string) {

        pageAuto.findNavigElemAuto();
        throw new io.cucumber.java.PendingException();
    }

    @Тогда("Появляется подменю")
    public void появляется_подменю() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Тогда("подменю отображает категорию {string}")
    public void подменю_отображает_категорию(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
