package testsFromSelenide.Task1;


import efremov.entities.ContactData;
import efremov.entities.User;
import initialization.SimpleTestsInit;
import com.epam.web.matcher.testng.Assert;
import org.testng.annotations.Test;

import static com.epam.jdi.uitests.core.interfaces.complex.interfaces.CheckPageTypes.CONTAINS;
import static efremov.JDISite.*;
import static efremov.data.enums.headerAndLeftSection.HeaderMenuElements.*;

public class LoginAndFillContactFormTest extends SimpleTestsInit {

    @Test(groups = "regression")
    public void loginAndFillContactForm() {
        indexPage.checkTitleType = CONTAINS;
        indexPage.shouldBeOpened();
        login();
        header.open(CONTACT_FORM);
        contactFormPage.checkTitleType = CONTAINS;
        contactFormPage.shouldBeOpened();
        contactFormPage.contactForm.submit(new ContactData());
        Assert.assertTrue(logsSection.logs.get(0).getText().contains("submit")); // not good??
    }
}