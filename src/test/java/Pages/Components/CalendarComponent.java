package Pages.Components;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    private String day = "//*[text() = '%s']";

    public void setData(String date, String monthOfBirth, String year) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption(monthOfBirth);
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOption(year);
        $(By.xpath(String.format(day, date))).click();
    }
}
