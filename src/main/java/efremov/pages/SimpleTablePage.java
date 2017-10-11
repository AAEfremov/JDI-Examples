package efremov.pages;

import com.epam.jdi.uitests.web.selenium.elements.common.Label;
import com.epam.jdi.uitests.web.selenium.elements.complex.table.Table;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import org.openqa.selenium.support.FindBy;

@JPage(url = "/page6.htm", title = "Simple Table")
public class SimpleTablePage extends WebPage {

    @FindBy(css = ".support-title")
    public Label supportTitle;

    @FindBy(css = ".table-td-click")
    public Table supportInfo;
}
