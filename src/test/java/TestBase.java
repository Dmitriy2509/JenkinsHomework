import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBase {

    @BeforeAll
    static void setup() {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true); // Need to translate video (default headless mode Selenoid)
        capabilities.setCapability("enableVideo", true); // Record video (Selenoid)

        Configuration.browserCapabilities = capabilities;
        Configuration.startMaximized = true;
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub/"; // for connection selenoid
        // Params for Jenkins
        String url = System.getProperty("url", "https://demoqa.com/");
    }

    @AfterEach
    public void tearDown() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
