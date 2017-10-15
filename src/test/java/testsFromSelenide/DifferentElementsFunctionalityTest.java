package testsFromSelenide;

import initialization.SimpleTestsInit;
import org.testng.annotations.Test;

import java.util.List;

import static com.epam.jdi.uitests.core.interfaces.complex.interfaces.CheckPageTypes.CONTAINS;
import static efremov.JDISite.*;
import static efremov.data.enums.diffElementsPage.CheckboxLabels.*;
import static efremov.data.enums.diffElementsPage.ColorsOptions.*;
import static efremov.data.enums.diffElementsPage.RadioLabels.*;
import static efremov.data.enums.headerAndLeftSection.HeaderMenuElements.*;

public class DifferentElementsFunctionalityTest extends SimpleTestsInit {

    @Test(groups = {"regression", "dep"})
    public void checkDEF() {

        indexPage.checkTitleType = CONTAINS;
        indexPage.shouldBeOpened();
        login();
        //checkUsername();
        checkIndexPageInterface();

        //checkPictures();
        //checkTexts();
        //checkServiceDropdown();
        header.open(SERVICE, DIFFERENT_ELEMENTS);
        diffElementsPage.checkTitleType = CONTAINS;
        //diffElementsPage.shouldBeOpened();

        checkDiffElemPageInterface();

        diffElementsPage.selectAndCheckCheckbox(WATER);
        diffElementsPage.selectAndCheckCheckbox(WIND);
        diffElementsPage.selectAndCheckRadio(SELEN);
        diffElementsPage.selectAndCheckColor(YELLOW);

        List<String> lst = logsSection.logs.getOptions();
        diffElementsPage.checkLogs(lst, 0);

        diffElementsPage.unselectAndCheckCheckbox(WATER);
        diffElementsPage.unselectAndCheckCheckbox(WIND);

        lst = logsSection.logs.getOptions();

        diffElementsPage.checkLogs(lst, 1);

    }
}
