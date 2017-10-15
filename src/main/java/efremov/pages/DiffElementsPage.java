package efremov.pages;


import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.complex.CheckList;
import com.epam.jdi.uitests.web.selenium.elements.complex.Dropdown;
import com.epam.jdi.uitests.web.selenium.elements.complex.RadioButtons;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import efremov.data.enums.diffElementsPage.CheckboxLabels;
import efremov.data.enums.diffElementsPage.ColorsOptions;
import efremov.data.enums.diffElementsPage.RadioLabels;
import efremov.sections.LogsSection;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

import static efremov.data.enums.diffElementsPage.CheckboxLabels.WATER;
import static efremov.data.enums.diffElementsPage.CheckboxLabels.WIND;
import static efremov.data.enums.diffElementsPage.ColorsOptions.YELLOW;
import static efremov.data.enums.diffElementsPage.RadioLabels.SELEN;

@JPage(url = "/page8.htm", title = "Different Element")
public class DiffElementsPage extends WebPage {

    @FindBy(css = ".label-checkbox")
    public CheckList<CheckboxLabels> checkboxes;

    @FindBy(css = ".label-radio")
    public RadioButtons<RadioLabels> radios;

    @FindBy(css = "select.uui-form-element")
    public Dropdown<ColorsOptions> colorsDropdownSelector;

    @FindBy(css = "[firstName='Default Button']")
    public Button defaultButton;

    @FindBy(css = "[value='Button']")
    public Button button;

    public void selectAndCheckCheckbox(CheckboxLabels label) {

        checkboxes.check(label.getLabel());
        Assert.assertTrue(checkboxes.getWebElement(label.getLabel()).findElement(new By.ByCssSelector("input")).isSelected());
    }

    public void unselectAndCheckCheckbox(CheckboxLabels label) {

        checkboxes.check(label.getLabel());
        Assert.assertFalse(checkboxes.getWebElement(label.getLabel()).findElement(new By.ByCssSelector("input")).isSelected());
    }

    public void selectAndCheckRadio(RadioLabels label) {

        radios.select(label.getLabel());
        Assert.assertTrue(radios.getWebElement(label.getLabel()).findElement(new By.ByCssSelector("input")).isSelected());
    }

    public void selectAndCheckColor(ColorsOptions color) {
        colorsDropdownSelector.click();
        colorsDropdownSelector.select(color.getColor());
        Assert.assertTrue(colorsDropdownSelector.isSelected(color.getColor()));
    }

    public void checkLogs(List<String> lst, int type) {
        switch (type) {
            case 0:
                Assert.assertTrue(lst.get(0).contains(YELLOW.getColorTag()) && lst.get(0).contains(YELLOW.getColor()));
                Assert.assertTrue(lst.get(1).contains(SELEN.getMetalTag()) && lst.get(1).contains(SELEN.getLabel()));
                Assert.assertTrue(lst.get(2).contains(WIND.getLabel())&& lst.get(2).contains(WIND.getTrueStatus()));
                Assert.assertTrue(lst.get(3).contains(WATER.getLabel())&& lst.get(3).contains(WATER.getTrueStatus()));
                break;
            case 1:
                Assert.assertTrue(lst.get(0).contains(WIND.getLabel())&&lst.get(0).contains(WIND.getFalseStatus()));
                Assert.assertTrue(lst.get(1).contains(WATER.getLabel())&&lst.get(1).contains(WATER.getFalseStatus()));
                break;
            default:
                break;
        }
    }
}