package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HelperCar extends HelperBase {
    public HelperCar(WebDriver wd) {
        super(wd);
    }


    public void submit() {
        click(By.xpath("//button[@type='submit']"));
    }

    public void searchCurrentMonth(String city, String dateFrom, String dateTo) {
        typeCity(city);
        click(By.id("dates"));
        //"5/29/2026","5/31/2026"
        String from = dateFrom.split("/")[1];
        By fromLocator = By.xpath(
                "//button[not(contains(@class, 'rdrDayPassive'))][not(contains(@class, 'rdrDayDisabled'))]//span[text()='" + from + "']");
        click(fromLocator);
        String to = dateTo.split("/")[1];
        By toLocator = By.xpath(
                "//button[not(contains(@class, 'rdrDayPassive'))][not(contains(@class, 'rdrDayDisabled'))]//span[text()='" + to + "']");
        click(toLocator);
    }

    private void typeCity(String city) {
        type(By.id("city"), city);
        click(By.id("city-suggestions"));
    }

    public boolean isListOfCarsAppeared() {
        return isElementPresent(By.cssSelector("a.car-container"));
    }

    public void searchCurrentYear(String city, String dateFrom, String dateTo) {
        typeCity(city);
        click(By.id("dates"));
        //"9/15/2026","11/7/2026"

        LocalDate now = LocalDate.now();
        System.out.println(now); //2026-05-28
        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();

        LocalDate from = LocalDate.parse(dateFrom, DateTimeFormatter.ofPattern("M/d/yyyy")); //2026-09-15
        LocalDate to = LocalDate.parse(dateTo, DateTimeFormatter.ofPattern("M/d/yyyy"));
        //LocalDate from1 = LocalDate.parse("2013:23/05",DateTimeFormatter.ofPattern("yyyy:dd/MM"));
        //System.out.println(from1);

        int diffMonth = from.getMonthValue() - month;
        if (diffMonth > 0) {
            clickNextMontBtn(diffMonth);
        }
        click(By.xpath("//button[not(contains(@class, 'rdrDayPassive'))][not(contains(@class, 'rdrDayDisabled'))]//span[text()='" + from.getDayOfMonth() + "']"));

        diffMonth = to.getMonthValue() - from.getMonthValue();
        if (diffMonth > 0) {
            clickNextMontBtn(diffMonth);
        }
        click(By.xpath("//button[not(contains(@class, 'rdrDayPassive'))][not(contains(@class, 'rdrDayDisabled'))]//span[text()='" + to.getDayOfMonth() + "']"));

    }

    private void clickNextMontBtn(int diffMonth) {
        for (int i = 0; i < diffMonth; i++) {
            click(By.cssSelector(".rdrNextPrevButton.rdrNextButton"));

        }
    }

    public void searchAnyPeriodSuccess(String city, String dateFrom, String dateTo) {
        typeCity(city);
        click(By.id("dates"));
        //"10/15/2026", "3/10/2027"
        LocalDate now = LocalDate.now();
        LocalDate from = LocalDate.parse(dateFrom, DateTimeFormatter.ofPattern("M/d/yyyy"));
        LocalDate to = LocalDate.parse(dateTo, DateTimeFormatter.ofPattern("M/d/yyyy"));

        int diffYear;
        int diffMonth;
        //***from***
        diffYear = from.getYear() - now.getYear();
        if (diffYear == 0) {
            diffMonth = from.getMonthValue() - now.getMonthValue();
        } else {
            diffMonth = 12 - now.getMonthValue() + from.getMonthValue();
        }
        clickNextMontBtn(diffMonth);
        click(By.xpath("//button[not(contains(@class, 'rdrDayPassive'))][not(contains(@class, 'rdrDayDisabled'))]//span[text()='" + from.getDayOfMonth() + "']"));
        //***to***
        diffYear = to.getYear() - from.getYear();
        if (diffYear == 0) {
            diffMonth = to.getMonthValue() - from.getMonthValue();
        } else {
            diffMonth = 12 - from.getMonthValue() + to.getMonthValue();
        }
        clickNextMontBtn(diffMonth);
        click(By.xpath("//button[not(contains(@class, 'rdrDayPassive'))][not(contains(@class, 'rdrDayDisabled'))]//span[text()='" + to.getDayOfMonth() + "']"));
    }

    public void clickLogo() {
        click(By.cssSelector(".header>a.logo"));
    }
}
