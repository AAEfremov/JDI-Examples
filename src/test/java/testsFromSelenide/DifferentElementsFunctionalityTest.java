package testsFromSelenide;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.web.matcher.testng.Assert;
import initialization.SimpleTestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

import static com.epam.jdi.uitests.core.interfaces.complex.interfaces.CheckPageTypes.CONTAINS;
import static efremov.JDISite.*;
import static efremov.data.enums.Pages.DIFFERENT_ELEMENTS_PAGE;
import static efremov.data.enums.diffElementsPage.CheckboxLabels.*;
import static efremov.data.enums.diffElementsPage.ColorsOptions.*;
import static efremov.data.enums.diffElementsPage.RadioLabels.*;
import static efremov.data.enums.headerAndLeftSection.HeaderMenuElements.*;

public class DifferentElementsFunctionalityTest extends SimpleTestsInit {

    @Step("Open Index Page, Different Elements Page and check their interfaces")
    @BeforeMethod(alwaysRun = true)
    public void openPageAndCheckInterface() {
        indexPage.checkTitleType = CONTAINS;
        indexPage.shouldBeOpened();
        login();
        checkIndexPageInterface();
        header.open(SERVICE, DIFFERENT_ELEMENTS);
        Assert.contains(WebPage.getTitle(), DIFFERENT_ELEMENTS_PAGE.getPageTitle());
        checkDiffElemPageInterface();
    }

    @Step("Check Different Elements Page functionality")
    @Test(groups = {"regression", "dep"})
    public void checkDEF() {
        diffElementsPage.selectCheckbox(WATER);
        diffElementsPage.checkCheckboxSelected(WATER);
        diffElementsPage.selectCheckbox(WIND);
        diffElementsPage.checkCheckboxSelected(WATER);
        diffElementsPage.selectRadio(SELEN);
        diffElementsPage.checkRadioSelected(SELEN);
        diffElementsPage.selectColor(YELLOW);
        diffElementsPage.checkColorSelected(YELLOW);

        List<String> lst = logsSection.logs.getOptions();
        diffElementsPage.checkLogs(lst, 0);

        diffElementsPage.unselectCheckbox(WATER);
        diffElementsPage.checkCheckboxUnselected(WATER);
        diffElementsPage.unselectCheckbox(WIND);
        diffElementsPage.checkCheckboxUnselected(WATER);

        lst = logsSection.logs.getOptions();

        diffElementsPage.checkLogs(lst, 1);

    }
}
