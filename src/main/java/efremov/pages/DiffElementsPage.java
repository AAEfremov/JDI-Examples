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

import java.util.List;

import static efremov.JDISite.logsSection;
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
        Assert.isTrue(checkboxes.getWebElement(label.getLabel()).findElement(new By.ByCssSelector("input")).isSelected());
    }

    public void unselectAndCheckCheckbox(CheckboxLabels label) {

        checkboxes.check(label.getLabel());
        Assert.isFalse(checkboxes.getWebElement(label.getLabel()).findElement(new By.ByCssSelector("input")).isSelected());
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

    public void checkLogs() {

        Assert.assertTrue(logsSection.logs.get(0).getValue().contains(YELLOW.getColorTag()) && logsSection.logs.get(0).getValue().contains(YELLOW.getColor()));
        Assert.assertTrue(logsSection.logs.get(1).getValue().contains(SELEN.getMetalTag()) && logsSection.logs.get(1).getValue().contains(SELEN.getLabel()));
        Assert.assertTrue(logsSection.logs.get(2).getValue().contains(WIND.getLabel())&& logsSection.logs.get(2).getValue().contains(WIND.getTrueStatus()));
        Assert.assertTrue(logsSection.logs.get(3).getValue().contains(WATER.getLabel())&& logsSection.logs.get(3).getValue().contains(WATER.getTrueStatus()));

    }

    public void checkLogs(List<String> lst) {
        Assert.assertTrue(lst.get(0).contains(WIND.getLabel())&&lst.get(0).contains(WIND.getFalseStatus()));
        Assert.assertTrue(lst.get(1).contains(WATER.getLabel())&&lst.get(1).contains(WATER.getFalseStatus()));
    }
}