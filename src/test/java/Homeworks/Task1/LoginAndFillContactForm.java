package Homeworks.Task1;


import Homeworks.SimpleTestsInit;
import com.epam.web.matcher.testng.Assert;
import efremov.data.DataProviders;
import efremov.entities.User;
import org.testng.annotations.Test;

import static com.epam.jdi.uitests.core.interfaces.complex.interfaces.CheckPageTypes.CONTAINS;
import static efremov.JDISite.*;
import static efremov.data.enums.headerAndLeftSection.HeaderMenuElements.*;

public class LoginAndFillContactForm extends SimpleTestsInit {

    @Test(dataProvider = "fillUserData", dataProviderClass = DataProviders.class)
    public void loginAndFillContactForm(User user) {
        indexPage.checkTitleType = CONTAINS;
        indexPage.shouldBeOpened();
        login(user);
        checkUsername(user);
        //checkUsername(); or Assert.assertTrue(loginForm.userName.getText().equals(new User().userName));  //??
        //how to check name?? --> watch JDISite
        //headerMenu.clickOn(CONTACT_FORM);
        header.open(CONTACT_FORM);
        contactFormPage.checkTitleType = CONTAINS;
        contactFormPage.shouldBeOpened();
        contactFormPage.fillContactForm();
        Assert.assertTrue(logsSection.logs.get(0).getText().contains("submit")); // not good??
        //checkLogs();
    }
}