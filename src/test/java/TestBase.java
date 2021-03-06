import com.codeborne.selenide.Configuration;
import config.CredentialConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static java.lang.String.format;

public class TestBase {

    @BeforeAll
    static void setup() {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true); // Need to translate video (default headless mode Selenoid)
        capabilities.setCapability("enableVideo", true); // Record video (Selenoid)

        Configuration.browserCapabilities = capabilities;
        Configuration.startMaximized = true;

       CredentialConfig credentialConfig =
                ConfigFactory.create(CredentialConfig.class);
//        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub/"; // for connection selenoid

//        Configuration.remote = "https://" + credentialConfig.login()+ ":" + credentialConfig.password() + "@selenoid.autotests.cloud/wd/hub/"; // for connection selenoid
        String url = System.getProperty("url", "selenoid.autotests.cloud/wd/hub/");
        Configuration.remote = format("https://%s:%s@%s", credentialConfig.login(), credentialConfig.password(), url);
        System.out.println(Configuration.remote);
//         Params for Jenkins
//        String url = System.getProperty("url", "https://demoqa.com/");
    }


    @AfterEach
    public void tearDown() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
