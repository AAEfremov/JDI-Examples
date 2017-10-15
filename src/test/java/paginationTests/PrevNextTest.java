package paginationTests;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import efremov.data.DataProviders;
import efremov.data.enums.Pages;
import initialization.SimpleTestsInit;
import org.testng.annotations.Test;

import static efremov.JDISite.*;
import static org.testng.Assert.*;

public class PrevNextTest extends SimpleTestsInit {

    @Test(dataProvider = "pagination", dataProviderClass = DataProviders.class, groups = "pagination")
    public void prevNextTest(Pages current, Pages checking, String direction) {
        indexPage.open();
        login();
        switch (current.getPageNumber()) {
            case 1: contactFormPage.open();
                break;
            case 2: supportPage.open();
                break;
            case 3: datesPage.open();
                break;
            case 4: complexTablePage.open();
                break;
            case 5: simpleTablePage.open();
                break;
            case 6: tableWithPagesPage.open();
                break;
            case 7: diffElementsPage.open();
                break;
            case 8: metalAndColorsPage.open();
                break;
        }

        switch (direction) {
            case "prev":
                paginator.previous();
                break;
            case "next":
                paginator.next();
        }

        assertEquals(WebPage.getTitle(), checking.getPageTitle());

    }
}
