package Homeworks.Task2;

import Homeworks.SimpleTestsInit;
import org.testng.annotations.Test;
import static com.epam.jdi.uitests.core.interfaces.complex.interfaces.CheckPageTypes.CONTAINS;
import static efremov.JDISite.contactFormPage;
import static efremov.JDISite.indexPage;

public class SmokeTests extends SimpleTestsInit{

    @Test(groups = "smoke")
    public void simpleContactFormPageTest() {
        contactFormPage.checkTitleType = CONTAINS;
        contactFormPage.shouldBeOpened();
    }

    @Test(groups = "smoke")
    public void simpleIndexPageTest() {
        indexPage.checkTitleType = CONTAINS;
        indexPage.shouldBeOpened();
    }
}
