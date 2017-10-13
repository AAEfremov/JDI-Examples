package testsFromSelenide.Task2;

import initialization.SimpleTestsInit;
import org.testng.annotations.Test;
import static com.epam.jdi.uitests.core.interfaces.complex.interfaces.CheckPageTypes.CONTAINS;
import static efremov.JDISite.*;

public class RegressionTests extends SimpleTestsInit{

    @Test(groups = "regression")
    public void simpleIndexPageTest() {
        indexPage.checkTitleType = CONTAINS;
        indexPage.shouldBeOpened();
    }

    @Test(groups = "regression")
    public void simpleContactFormPageTest() {
        contactFormPage.checkTitleType = CONTAINS;
        contactFormPage.shouldBeOpened();
    }

    @Test(groups = "regression")
    public void simpleDatesPageTest() {
        datesPage.checkTitleType =CONTAINS;
        datesPage.shouldBeOpened();
    }
    @Test(groups = "regression")
    public void simpleDiffElementsPageTest() {
        diffElementsPage.checkTitleType = CONTAINS;
        diffElementsPage.shouldBeOpened();
    }
}
