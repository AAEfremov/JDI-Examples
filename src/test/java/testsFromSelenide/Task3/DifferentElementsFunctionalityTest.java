package testsFromSelenide.Task3;

import initialization.SimpleTestsInit;
import com.epam.web.matcher.testng.Assert;
import efremov.entities.User;
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

        diffElementsPage.checkLogs();

        diffElementsPage.unselectAndCheckCheckbox(WATER);
        diffElementsPage.unselectAndCheckCheckbox(WIND);

        List<String> lst = logsSection.logs.getOptions();

        diffElementsPage.checkLogs(lst);

    }
}
