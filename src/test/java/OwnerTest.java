import config.CredentialConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;

public class OwnerTest {

    CredentialConfig credentialConfig =
            ConfigFactory.create(CredentialConfig.class);

    @Test
    public void credentialTest() {
        String login = credentialConfig.login();
        String password = credentialConfig.password();
        System.out.println(login);
        System.out.println(password);
    }
}
