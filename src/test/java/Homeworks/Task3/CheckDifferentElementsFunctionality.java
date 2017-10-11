package Homeworks.Task3;

import Homeworks.SimpleTestsInit;
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

public class CheckDifferentElementsFunctionality extends SimpleTestsInit {

    @Test
    public void checkDEF() {

        User user = new User();
        indexPage.checkTitleType = CONTAINS;
        indexPage.shouldBeOpened();
        login(user);
        checkUsername(user);
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


        Assert.assertTrue(logsSection.logs.get(0).getValue().contains(YELLOW.getColor())); // not good
        Assert.assertTrue(logsSection.logs.get(1).getValue().contains(SELEN.getLabel()));
        Assert.assertTrue(logsSection.logs.get(2).getValue().contains(WIND.getLabel())&& logsSection.logs.get(2).getValue().contains("true"));
        Assert.assertTrue(logsSection.logs.get(3).getValue().contains(WATER.getLabel())&& logsSection.logs.get(3).getValue().contains("true"));

        diffElementsPage.unselectAndCheckCheckbox(WATER);
        diffElementsPage.unselectAndCheckCheckbox(WIND);

        List<String> lst = logsSection.logs.getOptions();
        Assert.assertTrue(lst.get(0).contains(WIND.getLabel())&&lst.get(0).contains("false"));
        Assert.assertTrue(lst.get(1).contains(WATER.getLabel())&&lst.get(1).contains("false"));

    }
}
