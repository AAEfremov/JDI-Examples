package testsFromSelenide;

import initialization.SimpleTestsInit;
import efremov.data.DataProviders;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Step;

import static com.epam.jdi.uitests.core.interfaces.complex.interfaces.CheckPageTypes.CONTAINS;
import static efremov.JDISite.*;
import static efremov.data.enums.headerAndLeftSection.HeaderMenuElements.DATES;
import static efremov.data.enums.headerAndLeftSection.HeaderMenuElements.SERVICE;

public class DatesFunctionalityTest extends SimpleTestsInit {


    @Step("Open Index Page and then Dates Page")
    @BeforeClass(alwaysRun = true)
    public void openPage() {
        indexPage.checkTitleType = CONTAINS;
        indexPage.shouldBeOpened();
        login();
        checkIndexPageInterface();
        header.open(SERVICE, DATES);
    }

    @Step("Check slider on the Dates Page")
    @Test(dataProvider = "dragAndDrop", dataProviderClass = DataProviders.class, groups = {"regression", "dp"})
    public void checkDF(int leftPos, int rightPos) {
        datesPage.datesForm.setHandlesPosition(leftPos,rightPos);
        datesPage.datesForm.checkHandlesPosition(leftPos, rightPos);

    }

}
