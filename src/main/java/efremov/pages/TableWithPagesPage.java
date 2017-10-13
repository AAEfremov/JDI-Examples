package efremov.pages;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.Label;
import com.epam.jdi.uitests.web.selenium.elements.common.TextField;
import com.epam.jdi.uitests.web.selenium.elements.complex.Dropdown;
import com.epam.jdi.uitests.web.selenium.elements.complex.Elements;
import com.epam.jdi.uitests.web.selenium.elements.complex.table.Table;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import efremov.data.enums.tableWithPagesPage.EntriesNumbers;
import org.openqa.selenium.support.FindBy;

@JPage(url = "/page7.htm", title = "Table with pages")
public class TableWithPagesPage extends WebPage {

    @FindBy(css = ".support-title")
    public Label supportTitle;

    @FindBy(css = "select.uui-form-element")
    public Dropdown<EntriesNumbers> entriesNumbers;

    @FindBy(css = "label>input.uui-form-element")
    public TextField search;

    @FindBy(css = ".dataTable.no-footer")
    public Table info;

    @FindBy(css = ".paginate_button")
    public Elements<Button> tablePaginates;
}
