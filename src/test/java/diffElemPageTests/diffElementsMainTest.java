package diffElemPageTests;

import efremov.data.DataProviders;
import efremov.data.enums.diffElementsPage.CheckboxLabels;
import efremov.data.enums.diffElementsPage.ColorsOptions;
import efremov.data.enums.diffElementsPage.RadioLabels;
import initialization.SimpleTestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Step;

import static efremov.JDISite.*;

public class diffElementsMainTest extends SimpleTestsInit {

    @Step("Open Index Page and then Different Elements Page")
    @BeforeMethod(alwaysRun = true)
    public void openNeedPage() {
        indexPage.open();
        login();
        diffElementsPage.open();
    }

    @Step("Check Different Elements Page functionality")
    @Test(dataProvider = "diffElementsProvider", dataProviderClass = DataProviders.class, groups = "dep")
    public void diffElemTest(CheckboxLabels element, RadioLabels metal, ColorsOptions color) {
        diffElementsPage.selectCheckbox(element);
        diffElementsPage.checkCheckboxSelected(element);
        diffElementsPage.selectRadio(metal);
        diffElementsPage.checkRadioSelected(metal);
        diffElementsPage.selectColor(color);
        diffElementsPage.checkColorSelected(color);
    }
}
