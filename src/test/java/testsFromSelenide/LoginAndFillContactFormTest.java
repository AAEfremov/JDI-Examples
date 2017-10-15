package testsFromSelenide;
import efremov.entities.ContactFormData;
import efremov.entities.User;
import initialization.SimpleTestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Step;

import static com.epam.jdi.uitests.core.interfaces.complex.interfaces.CheckPageTypes.CONTAINS;
import static efremov.JDISite.*;
import static efremov.data.enums.headerAndLeftSection.HeaderMenuElements.*;
import static org.testng.Assert.*;

public class LoginAndFillContactFormTest extends SimpleTestsInit {

    @Step("Open Index Page and then Contact Form Page")
    @BeforeMethod(alwaysRun = true)
    public void openPage() {
        indexPage.checkTitleType = CONTAINS;
        indexPage.shouldBeOpened();
        login();
        assertEquals(loginForm.userName.getText(), new User().userName);

        header.open(CONTACT_FORM);
        contactFormPage.checkTitleType = CONTAINS;
        contactFormPage.shouldBeOpened();
    }

    @Step("Check Contact Form functionality")
    @Test(groups = "regression")
    public void fillContactForm() {
        contactFormPage.contactForm.submit(new ContactFormData());
        assertTrue(logsSection.logs.get(0).getText().contains("submit")); // not good??
    }
}