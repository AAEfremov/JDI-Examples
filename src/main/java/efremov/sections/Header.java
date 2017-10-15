package efremov.sections;

import com.epam.jdi.uitests.web.selenium.elements.complex.Dropdown;
import com.epam.jdi.uitests.web.selenium.elements.complex.Menu;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import efremov.data.enums.headerAndLeftSection.HeaderMenuElements;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

public class Header extends Section{

    @FindBy(css = ".m-l8>li>a")
    public Menu<HeaderMenuElements> menu;

    @FindBy(css = "ul.dropdown-menu>li")
    public Dropdown<HeaderMenuElements> serviceDropdown;

    @Step("Open verified page through header menu")
    public void open(HeaderMenuElements... elements) {
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
