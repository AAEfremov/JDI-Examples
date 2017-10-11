package efremov.forms;

import com.epam.jdi.uitests.core.annotations.Mandatory;
import com.epam.jdi.uitests.web.robot.RFileInput;
import com.epam.jdi.uitests.web.selenium.elements.common.*;
import com.epam.jdi.uitests.web.selenium.elements.complex.Elements;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import efremov.entities.DatesData;
import org.openqa.selenium.support.FindBy;

public class DatesForm extends Form<DatesData> {

    @Mandatory
    @FindBy(id="Name")
    public TextField firstName;
    @Mandatory
    @FindBy(id="LastName")
    public TextField lastName;

    @FindBy(id = "Description")
    public TextArea description;

    @JFindBy(id = "datepicker")
    public DatePicker datePicker;

    @JFindBy(id = "timepicker")
    public TextField time;  //There is no TimePicker type

    @FindBy(css = ".thumbnail>span")
    public RFileInput imageInput;

    /*@Mandatory
    @FindBy(css = ".range-from.overflow>input")
    public Elements<TextField> range1;*/
    @Mandatory
    @FindBy(xpath = "//*[@class='range-from overflow']/input[1]")
    public TextField from;
    @Mandatory
    @FindBy(xpath = "//*[@class='range-from overflow']/input[2]")
    public TextField to;

    @FindBy(css = ".ui-state-default.ui-corner-all")
    public Elements<Link> range2;

    @JFindBy(text = "Submit")
    public Button submit;
}
