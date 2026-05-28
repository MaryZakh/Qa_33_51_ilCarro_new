import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchCarTests extends TestBase {


//    @Test
//    public void searchCurrentMonthSuccess() {
//        app.getHelperCar().searchCurrentMonth("Haifa","5/30/2026","5/31/2026");
//        app.getHelperCar().submit();
//        Assert.assertTrue(app.getHelperCar().isListOfCarsAppeared());
//    }


    @Test
    public void searchCurrentYear(){
        app.getHelperCar().searchCurrentYear("Haifa","10/29/2026","12/16/2026");
        app.getHelperCar().submit();
        Assert.assertTrue(app.getHelperCar().isListOfCarsAppeared());
    }

//    @Test
//    public void searchCurrentYear(){
//        app.getHelperCar().searchAnyPeriodSuccess("Haifa","10/15/2026","3/10/2026");
//        app.getHelperCar().submit();
//        Assert.assertTrue(app.getHelperCar().isListOfCarsAppeared());
//    }
}
