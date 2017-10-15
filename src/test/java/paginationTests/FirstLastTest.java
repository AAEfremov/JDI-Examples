package paginationTests;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import efremov.data.enums.Pages;
import initialization.SimpleTestsInit;
import org.testng.annotations.Test;

import static efremov.JDISite.*;
import static org.testng.Assert.*;

public class FirstLastTest extends SimpleTestsInit {

    @Test(groups = "pagination")
    public void firstLastTest(){
        indexPage.open();
        login();
        datesPage.open();
        paginator.first();
        assertEquals(WebPage.getTitle(), Pages.CONTACT_FORM_PAGE.getPageTitle());
        paginator.last();
        assertEquals(WebPage.getTitle(), Pages.METALS_AND_COLORS_PAGE.getPageTitle());
    }
}
