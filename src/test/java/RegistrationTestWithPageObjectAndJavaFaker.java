import Pages.Components.CalendarComponent;
import Pages.RegistrationPage;
import org.junit.jupiter.api.Test;

public class RegistrationTestWithPageObjectAndJavaFaker extends TestBase {

    TestDataFaker testDataFaker = new TestDataFaker();
    RegistrationPage registrationPage = new RegistrationPage();
    CalendarComponent calendarComponent = new CalendarComponent();


    @Test
    public void registrationWithPageObjectTest() {
        registrationPage
                .openPage()
                .setFirstName(testDataFaker.firstName)
                .setLastName(testDataFaker.lastName)
                .setEmail(testDataFaker.email)
                .clickMaleRadioBtn()
                .setMobilePhone(testDataFaker.mobilePhone);

        calendarComponent.setData("25", "September", "1988");
        registrationPage
                .setSubjectField(TestData.subjects)
                .clickSportCheckBoxField()
                .uploadPicture(TestData.pathFile)
                .setCurrentAddress(testDataFaker.currentAddress)
                .chooseNcrOption()
                .chooseDelhiOption()
                .clickSubmitBtn();
    }
}
