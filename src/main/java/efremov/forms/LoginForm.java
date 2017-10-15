package efremov.forms;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.Label;
import com.epam.jdi.uitests.web.selenium.elements.common.Text;
import com.epam.jdi.uitests.web.selenium.elements.common.TextField;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import com.epam.web.matcher.testng.Assert;
import efremov.entities.User;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by Roman_Iovlev on 10/22/2015.
 */
public class LoginForm extends Form<User> {
    @FindBy(id = "Login")
    public TextField name;
    @FindBy(id = "Password")
    public TextField password;

    @FindBy(css = ".profile-photo span")
    public Text userName;

    @FindBy(css = "[type=submit]")
    public Button enter;

    @FindBy(css = ".login-txt")
    public Text loginFailed;

    @Step("Check username")
    public void checkUserName(User user) {
        Assert.assertEquals(userName.getText(), user.userName);
    }


    @Step("Check that login has been failed")
    public void checkLoginFailed(User user) {
        Assert.areEquals(loginFailed.getText(), user.loginFailed);
    }
}
