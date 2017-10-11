package efremov.forms;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.TextArea;
import com.epam.jdi.uitests.web.selenium.elements.common.TextField;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import efremov.entities.User;
import org.openqa.selenium.support.FindBy;

public class ContactForm extends Form<User> {

    @FindBy(id="Name")
    public TextField firstName;
    @FindBy(id="LastName")
    public TextField lastName;

    @JFindBy(id = "Description")
    public TextArea description;

    @JFindBy(text = "Calculate")
    public Button calculate;

    @JFindBy(text = "Submit")
    public Button submit;
}
