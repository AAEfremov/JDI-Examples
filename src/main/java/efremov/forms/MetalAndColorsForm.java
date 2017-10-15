package efremov.forms;

import com.epam.jdi.uitests.core.interfaces.complex.IDropDown;
import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.complex.CheckList;
import com.epam.jdi.uitests.web.selenium.elements.complex.ComboBox;
import com.epam.jdi.uitests.web.selenium.elements.complex.Dropdown;
import com.epam.jdi.uitests.web.selenium.elements.complex.RadioButtons;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import efremov.data.enums.Numbers;
import efremov.data.enums.diffElementsPage.CheckboxLabels;
import efremov.data.enums.diffElementsPage.ColorsOptions;
import efremov.data.enums.metalAndColorsPage.MetalsLabels;
import efremov.data.enums.metalAndColorsPage.VegetablesLabels;
import efremov.entities.MetalAndColorsData;
import org.openqa.selenium.support.FindBy;

public class MetalAndColorsForm extends Form<MetalAndColorsData> {

    @FindBy(css = ".horizontal-group label")
    public RadioButtons<Numbers> numbers;

    @FindBy(css = "p.checkbox")
    public CheckList<CheckboxLabels> elements;

    @FindBy(id = "colors-dropdown")
    public Dropdown<ColorsOptions> colors;

    @FindBy(id = "metals-combobox")
    public ComboBox<MetalsLabels> metals;

    @FindBy(id = "salad-dropdown")
    public IDropDown<VegetablesLabels> vegetables;

    @FindBy(id = "submit-button")
    public Button submit;

    @Override
    public void submit(MetalAndColorsData data) {
        if (!data.oddNumber.isEmpty()) {
            numbers.select(data.oddNumber);
        }
        if (!data.evenNumber.isEmpty()) {
            numbers.select(data.evenNumber);
        }

        elements.check(data.element);
        colors.click();
        colors.select(data.color);
        metals.click();
        metals.select(data.element);
        vegetables.click();
        vegetables.select(data.vegetable);
        submit.click();
    }
}
