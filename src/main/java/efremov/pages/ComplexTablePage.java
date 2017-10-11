package efremov.pages;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.Label;
import com.epam.jdi.uitests.web.selenium.elements.complex.Dropdown;
import com.epam.jdi.uitests.web.selenium.elements.complex.table.Table;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import efremov.data.enums.ComplexTablePage.Columns;
import org.openqa.selenium.support.FindBy;

@JPage(url = "/page5.htm", title = "Complex Table")
public class ComplexTablePage extends WebPage {

    @FindBy(css = ".support-title")
    public Label supportTitle;

    @FindBy(css = ".table-delete")
    public Table info;

    @FindBy(css = ".btn-default")
    public Dropdown<Columns> items;

    @JFindBy(text = "Reestablish")
    public Button reestablish;

    @JFindBy(text = "Apply")
    public Button apply;

}
