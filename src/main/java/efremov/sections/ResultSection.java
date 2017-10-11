package efremov.sections;

import com.epam.jdi.uitests.web.selenium.elements.common.Label;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import org.openqa.selenium.support.FindBy;

public class ResultSection extends Section {

    @FindBy(className = "summ-res")
    public Label summary;

    @FindBy(className = "name-res")
    public Label firstName;

    @FindBy(className = "lname-res")
    public Label lastName;

    @FindBy(className = "descr-res")
    public Label description;

    @FindBy(className = "date-res")
    public Label date;

    @FindBy(className = "time-res")
    public Label time;

    @FindBy(className = "range-res")
    public Label range;

    @FindBy(className = "slider-res")
    public Label slider;

    @FindBy(className = "elem-res")
    public Label element;

    @FindBy(className = "col-res")
    public Label color;

    @FindBy(className = "met-res")
    public Label metal;

    @FindBy(className = "sal-res")
    public Label salad;



}
