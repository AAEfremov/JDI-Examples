package paginationTests;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import efremov.data.enums.Pages;
import initialization.SimpleTestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Step;

import static efremov.JDISite.*;
import static org.testng.Assert.*;

public class FirstLastTest extends SimpleTestsInit {

    @Step("Open Index Page and then Dates Page")
    @BeforeMethod(alwaysRun = true)
    public void openPage() {
        indexPage.open();
        login();
        datesPage.open();
    }

    @Step("Check paginator first and last buttons work")
    @Test(groups = "pagination")
    public void firstLastTest(){
        paginator.first();
        assertEquals(WebPage.getTitle(), Pages.CONTACT_FORM_PAGE.getPageTitle());
        paginator.last();
        assertEquals(WebPage.getTitle(), Pages.METALS_AND_COLORS_PAGE.getPageTitle());
    }
}
