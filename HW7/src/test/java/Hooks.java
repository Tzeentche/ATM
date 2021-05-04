import com.codeborne.selenide.Configuration;
import io.cucumber.java.Before;
import static com.codeborne.selenide.Selenide.*;

public class Hooks {

    @Before
    public void openUrl() {
        Configuration.startMaximized = true;
        open("https://www.onliner.by/");
    }
}
