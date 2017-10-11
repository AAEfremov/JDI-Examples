package Homeworks.Task3;

import Homeworks.SimpleTestsInit;
import com.epam.web.matcher.testng.Assert;
import efremov.data.DataProviders;
import efremov.entities.User;
import org.testng.annotations.Test;

import static com.epam.jdi.uitests.core.interfaces.complex.interfaces.CheckPageTypes.CONTAINS;
import static efremov.JDISite.*;
import static efremov.data.enums.headerAndLeftSection.HeaderMenuElements.DATES;
import static efremov.data.enums.headerAndLeftSection.HeaderMenuElements.SERVICE;

public class CheckDatesFunctionality extends SimpleTestsInit {

    @Test(dataProvider = "fillUserData", dataProviderClass = DataProviders.class)
    public void checkDF(User user) {
        indexPage.checkTitleType = CONTAINS;
        indexPage.shouldBeOpened();
        login(user);
        checkUsername(user);
        checkIndexPageInterface();

        //checkPictures();
        //checkTexts();
        //checkServiceDropdown();
        header.open(SERVICE, DATES);
    }

}
