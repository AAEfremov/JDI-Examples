package efremov.sections;

import com.epam.jdi.uitests.web.selenium.elements.common.Text;
import com.epam.jdi.uitests.web.selenium.elements.complex.Elements;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;

import org.openqa.selenium.support.FindBy;

public class LogsSection extends Section {

    @FindBy(css = ".panel-body-list.logs>li")
    public Elements<Text> logs;

    /*@FindBy(css = ".panel-body-list.results>li")
    public Elements<Label> results;*/

}