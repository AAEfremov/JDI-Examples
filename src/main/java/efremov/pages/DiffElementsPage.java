package efremov.pages;


import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.complex.CheckList;
import com.epam.jdi.uitests.web.selenium.elements.complex.Dropdown;
import com.epam.jdi.uitests.web.selenium.elements.complex.RadioButtons;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import com.epam.web.matcher.testng.Assert;
import efremov.data.enums.diffElementsPage.CheckboxLabels;
import efremov.data.enums.diffElementsPage.ColorsOptions;
import efremov.data.enums.diffElementsPage.RadioLabels;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

@JPage(url = "/page8.htm", title = "Different Element")
public class DiffElementsPage extends WebPage {

    @FindBy(css = ".label-checkbox")
    public CheckList<CheckboxLabels> checkboxes;

    @FindBy(css = ".label-radio")
    public RadioButtons<RadioLabels> radios;

    @FindBy(css = "select.uui-form-element")
    public Dropdown<ColorsOptions> colorsDropdownSelector;

    @FindBy(css = "[name='Default Button']")
    public Button defaultButton;

    @FindBy(css = "[value='Button']")
    public Button button;

    public void selectAndCheckCheckbox(CheckboxLabels label) {

        checkboxes.check(label.getLabel());
                //getWebElement(label.getLabel()).findElement(new By.ByCssSelector("input")).click();
                //.get(label.getLabel()).click();
        Assert.isTrue(checkboxes.getWebElement(label.getLabel()).findElement(new By.ByCssSelector("input")).isSelected());
                //.get(label.getLabel()).get(By.cssSelector("input")).isSelected());
    }

    public void unselectAndCheckCheckbox(CheckboxLabels label) {

        checkboxes.check(label.getLabel());
                //getWebElement(label.getLabel()).findElement(new By.ByCssSelector("input")).click();
                //.get(label.getLabel()).click();
        Assert.isFalse(checkboxes.getWebElement(label.getLabel()).findElement(new By.ByCssSelector("input")).isSelected());
                //.get(label.getLabel()).get(By.cssSelector("input")).isSelected());
    }

    public void selectAndCheckRadio(RadioLabels label) {

        radios.select(label.getLabel());
        Assert.isTrue(radios.getWebElement(label.getLabel()).findElement(new By.ByCssSelector("input")).isSelected());
    }

    public void selectAndCheckColor(ColorsOptions color) {
        colorsDropdownSelector.click();
        colorsDropdownSelector.select(color.getColor());
        Assert.isTrue(colorsDropdownSelector.isSelected(color.getColor()));
    }
}