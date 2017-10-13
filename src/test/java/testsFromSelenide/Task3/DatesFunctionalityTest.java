package testsFromSelenide.Task3;

import initialization.SimpleTestsInit;
import efremov.data.DataProviders;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.epam.jdi.uitests.core.interfaces.complex.interfaces.CheckPageTypes.CONTAINS;
import static efremov.JDISite.*;
import static efremov.data.enums.headerAndLeftSection.HeaderMenuElements.DATES;
import static efremov.data.enums.headerAndLeftSection.HeaderMenuElements.SERVICE;

public class DatesFunctionalityTest extends SimpleTestsInit {


    @BeforeClass
    public void openPage() {
        indexPage.checkTitleType = CONTAINS;
        indexPage.shouldBeOpened();
        login();
        checkIndexPageInterface();

        header.open(SERVICE, DATES);
    }

    @Test(dataProvider = "dragAndDrop", dataProviderClass = DataProviders.class, groups = {"regression", "dp"})
    public void checkDF(int leftPos, int rightPos) {

        datesPage.datesForm.setHandlesPosition(leftPos,rightPos);
        datesPage.datesForm.checkHandlesPosition(leftPos, rightPos);

    }

}
