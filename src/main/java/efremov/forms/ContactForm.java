package efremov.forms;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.TextArea;
import com.epam.jdi.uitests.web.selenium.elements.common.TextField;
import com.epam.jdi.uitests.web.selenium.elements.complex.RadioButtons;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import com.epam.web.matcher.testng.Assert;
import efremov.data.enums.Numbers;
import efremov.entities.ContactData;
import efremov.sections.ResultSection;
import org.openqa.selenium.support.FindBy;

import static efremov.JDISite.resultSection;
import static org.testng.Assert.*;

public class ContactForm extends Form<ContactData> {

    @FindBy(id="Name")
    public TextField firstName;
    @FindBy(id="LastName")
    public TextField lastName;

    @FindBy(id = "Description")
    public TextArea description;

    @JFindBy(text = "Calculate")
    public Button calculate;

    @JFindBy(text = "Submit")
    public Button submit;

    @FindBy(css = ".horizontal-group label")
    public RadioButtons<Numbers> numbers;

    @Override
    public void submit(ContactData data){
        if (!data.oddNumber.isEmpty()){
            numbers.select(data.oddNumber);
        }
        if (!data.evenNumber.isEmpty()) {
            numbers.select(data.evenNumber);
        }
        super.submit(data);
    }

    public int takeSum(String oddNumber, String evenNumber) {

        switch (oddNumber) {
            case "":
                switch (evenNumber) {
                    case "": return 3;
                    default: return Integer.parseInt(evenNumber) + 1;
                }
            default:
                switch (evenNumber) {
                    case "": return Integer.parseInt(oddNumber) + 2;
                    default: return Integer.parseInt(oddNumber) + Integer.parseInt(evenNumber);
                }
        }
    }


    public void checkResults(ContactData contactData, int sum) {
        assertTrue(resultSection.summary.getText().contains(String.valueOf(sum)));
        assertTrue(resultSection.firstName.getText().contains(String.valueOf(contactData.firstName)));
        assertTrue(resultSection.lastName.getText().contains(String.valueOf(contactData.lastName)));
        if (!contactData.description.isEmpty()) {
            assertTrue(resultSection.description.getText().contains(String.valueOf(contactData.description)));
        }
    }
}
