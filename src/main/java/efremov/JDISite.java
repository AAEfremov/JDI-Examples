package efremov;

import com.epam.jdi.uitests.web.selenium.elements.common.Image;
import com.epam.jdi.uitests.web.selenium.elements.common.Label;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JSite;
import com.epam.web.matcher.testng.Assert;
import efremov.entities.User;
import efremov.forms.LoginForm;
import efremov.pages.*;
import efremov.sections.*;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

@JSite(domain = "https://epam.github.io/JDI/")
public class JDISite extends WebSite{

    public static IndexPage indexPage;

    public static ContactFormPage contactFormPage;
    public static DatesPage datesPage;
    public static DiffElementsPage diffElementsPage;
    public static SupportPage supportPage;
    public static ComplexTablePage complexTablePage;
    public static SimpleTablePage simpleTablePage;
    public static TableWithPagesPage tableWithPagesPage;
    public static MetalAndColorsPage metalAndColorsPage;

    public static Header header;
    public static LeftSection leftSection;
    public static LogsSection logsSection;
    public static ResultSection resultSection;
    public static Paginator paginator;
    public static LoginForm loginForm;

    @FindBy(css = ".fa-user")
    public static Label profilePhoto;

    @Step("Login to the account")
    public static void login() {
        User user = new User();
        profilePhoto.click();
        loginForm.loginAs(user);
    }

    @Step("Check Index Page interface")
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

    @Step("Check Different Elements Page interface")
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
