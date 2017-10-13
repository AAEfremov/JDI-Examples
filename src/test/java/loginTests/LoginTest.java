package loginTests;

import efremov.data.DataProviders;
import efremov.entities.User;
import initialization.SimpleTestsInit;
import org.testng.annotations.Test;

import static com.epam.jdi.uitests.core.interfaces.complex.interfaces.CheckPageTypes.CONTAINS;
import static efremov.JDISite.*;

public class LoginTest extends SimpleTestsInit {

    @Test(dataProvider = "testLoginData", dataProviderClass = DataProviders.class, groups = "smoke")
    public void loginTest(User user) {

        indexPage.checkTitleType = CONTAINS;
        indexPage.shouldBeOpened();
        loginForm.loginAs(user);

        if(user.status) {
            loginForm.checkUserName(user);
        }
        else {
            loginForm.checkLoginFailed(user);
        }

    }
}
