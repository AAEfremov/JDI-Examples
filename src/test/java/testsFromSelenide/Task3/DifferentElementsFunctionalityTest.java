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

    @Test
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


        Assert.assertTrue(logsSection.logs.get(0).getValue().contains(YELLOW.getColorTag()) && logsSection.logs.get(0).getValue().contains(YELLOW.getColor())); // not good
        Assert.assertTrue(logsSection.logs.get(1).getValue().contains(SELEN.getMetalTag()) && logsSection.logs.get(1).getValue().contains(SELEN.getLabel()));
        Assert.assertTrue(logsSection.logs.get(2).getValue().contains(WIND.getLabel())&& logsSection.logs.get(2).getValue().contains(WIND.getTrueStatus()));
        Assert.assertTrue(logsSection.logs.get(3).getValue().contains(WATER.getLabel())&& logsSection.logs.get(3).getValue().contains(WATER.getTrueStatus()));

        diffElementsPage.unselectAndCheckCheckbox(WATER);
        diffElementsPage.unselectAndCheckCheckbox(WIND);

        List<String> lst = logsSection.logs.getOptions();
        Assert.assertTrue(lst.get(0).contains(WIND.getLabel())&&lst.get(0).contains(WIND.getFalseStatus()));
        Assert.assertTrue(lst.get(1).contains(WATER.getLabel())&&lst.get(1).contains(WATER.getFalseStatus()));

    }
}
