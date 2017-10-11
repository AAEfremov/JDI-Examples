package efremov.pages;

import com.epam.jdi.uitests.web.selenium.elements.common.Label;
import com.epam.jdi.uitests.web.selenium.elements.complex.table.Table;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import org.openqa.selenium.support.FindBy;

@JPage(url = "page3.htm", title = "Support")
public class SupportPage extends WebPage {

    @FindBy(css = ".support-title")
    public Label supportTitle;

    @FindBy(css = ".uui-table.stripe")
    public Table supportInfo;
}
