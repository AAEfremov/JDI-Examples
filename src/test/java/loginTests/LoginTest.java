package loginTests;

import efremov.data.DataProviders;
import efremov.entities.User;
import initialization.SimpleTestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Step;

import static com.epam.jdi.uitests.core.interfaces.complex.interfaces.CheckPageTypes.CONTAINS;
import static efremov.JDISite.*;

public class LoginTest extends SimpleTestsInit {

    @Step("Open Index Page")
    @BeforeMethod(alwaysRun = true)
    public void openPage() {
        indexPage.checkTitleType = CONTAINS;
        indexPage.shouldBeOpened();
    }

    @Step("Try to login as exist/non-exist user")
    @Test(dataProvider = "testLoginData", dataProviderClass = DataProviders.class, groups = "smoke")
    public void loginTest(User user) {
        profilePhoto.click();
        loginForm.loginAs(user);

        if(user.status) {
            loginForm.checkUserName(user);
        }
        else {
            loginForm.checkLoginFailed(user);
        }

    }
}
