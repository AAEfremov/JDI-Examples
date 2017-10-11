package efremov.sections;

import com.epam.jdi.uitests.web.selenium.elements.complex.Dropdown;
import com.epam.jdi.uitests.web.selenium.elements.complex.Menu;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import efremov.data.enums.headerAndLeftSection.LeftMenuElements;
import org.openqa.selenium.support.FindBy;

public class LeftSection extends Section {


    @FindBy(css = ".sidebar-menu>li")
    public Menu<LeftMenuElements> menu;

    @FindBy(css = ".sub>li")
    public Dropdown<LeftMenuElements> serviceDropdown;



    public void open(LeftMenuElements... elements) {
        switch (elements.length) {
            case 1:
                menu.clickOn(elements[0].getElement());
                break;
            case 2:
                menu.clickOn(elements[0].getElement());
                serviceDropdown.select(elements[1].getElement());
                break;
            default:
                break;
        }
    }
}
