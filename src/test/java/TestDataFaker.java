import com.github.javafaker.Faker;

public class TestDataFaker {

    Faker faker = new Faker();

    public static final String URL_REGISTRATION = "https://demoqa.com/automation-practice-form";
    public  String
            firstName = faker.funnyName().name(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            mobilePhone = faker.phoneNumber().subscriberNumber(12) ,
            monthOfBirth = "September",
            year = "1988",
            subjects = "Computer Science",
            currentAddress = faker.address().city(),
            pathFile = "img/testImg.png";
}
