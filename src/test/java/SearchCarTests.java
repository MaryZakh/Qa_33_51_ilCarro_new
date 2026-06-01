import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchCarTests extends TestBase {


    @BeforeMethod
    public void preCondition(){
        app.getHelperCar().clickLogo();
    }


    @Test
    public void searchCurrentMonthSuccess() {
        app.getHelperCar().searchCurrentMonth("Haifa","6/2/2026","6/21/2026");
        app.getHelperCar().getScreen("src/test/resources/screenshots/current.png");
        app.getHelperCar().submit();
        Assert.assertTrue(app.getHelperCar().isListOfCarsAppeared());
    }


    @Test
    public void searchCurrentYear() {
        app.getHelperCar().searchCurrentYear("Haifa", "10/29/2026", "12/16/2026");
        app.getHelperCar().getScreen("src/test/resources/screenshots/currentYear.png");
        app.getHelperCar().submit();
        Assert.assertTrue(app.getHelperCar().isListOfCarsAppeared());
    }

    @Test
    public void searchAnyPeriod() {
        app.getHelperCar().searchAnyPeriodSuccess("Haifa", "10/15/2026", "3/10/2027");
        app.getHelperCar().getScreen("src/test/resources/screenshots/any.png");
        app.getHelperCar().submit();
        Assert.assertTrue(app.getHelperCar().isListOfCarsAppeared());
    }
}
