package Homeworks.Task2;

import Homeworks.SimpleTestsInit;
import org.testng.annotations.Test;
import static com.epam.jdi.uitests.core.interfaces.complex.interfaces.CheckPageTypes.CONTAINS;
import static efremov.JDISite.contactFormPage;
import static efremov.JDISite.indexPage;

public class SmokeRegressionTests extends SimpleTestsInit {

    @Test(groups = {"regression", "smoke"})
    public void simpleIndexPageTest() {
        indexPage.checkTitleType = CONTAINS;
        indexPage.shouldBeOpened();
    }

    @Test(groups = {"regression", "smoke"})
    public void simpleContactFormPageTest() {
        contactFormPage.checkTitleType = CONTAINS;
        contactFormPage.shouldBeOpened();
    }
}
