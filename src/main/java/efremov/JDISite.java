package efremov;

import com.epam.jdi.uitests.web.selenium.elements.common.Image;
import com.epam.jdi.uitests.web.selenium.elements.common.Label;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JSite;
import com.epam.web.matcher.testng.Assert;
import efremov.entities.User;
import efremov.forms.LoginForm;
import efremov.pages.*;
import efremov.sections.Header;
import efremov.sections.LeftSection;
import efremov.sections.LogsSection;
import efremov.sections.ResultSection;
import org.openqa.selenium.support.FindBy;

@JSite(domain = "https://epam.github.io/JDI/")
public class JDISite extends WebSite{

    public static IndexPage indexPage;

    public static ContactFormPage contactFormPage;
    public static DatesPage datesPage;
    public static DiffElementsPage diffElementsPage;

    public static Header header;
    public static LeftSection leftSection;
    public static LogsSection logsSection;
    public static ResultSection resultSection;

    public static LoginForm loginForm;
    //public static ContactForm contactForm;


    @FindBy(css = ".fa-user")
    public static Label profilePhoto;



    public static void login(User user) {
        profilePhoto.click();
        loginForm.loginAs(user);
    }

    public static void checkUsername(User user) {
        Assert.assertEquals(loginForm.userName.getText(), user.userName);
    }


    /*public static void checkLogs() {
        Assert.assertTrue(logsSection.checkLogs());
    }*/


    public static void checkIndexPageInterface() {

        for(Image pic : indexPage.pictures) {
            Assert.isTrue(pic.isDisplayed());
        }

        for(Label text : indexPage.textsUnderPictures) {
            Assert.isTrue(text.isDisplayed());
        }

        for(Label text : indexPage.textsAbovePictures) {
            Assert.isTrue(text.isDisplayed());
        }

    }

    public static void checkDiffElemPageInterface() {

        for(String checkboxLabel : diffElementsPage.checkboxes.getValues()) {
            Assert.isTrue(diffElementsPage.checkboxes.isDisplayed(checkboxLabel));
        }

        diffElementsPage.radios.isDisplayed();
        diffElementsPage.colorsDropdownSelector.isDisplayed();
        diffElementsPage.defaultButton.isDisplayed();
        diffElementsPage.button.isDisplayed();
    }
}
