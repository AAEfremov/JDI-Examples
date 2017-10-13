package diffElemPageTests;

import efremov.data.DataProviders;
import efremov.data.enums.diffElementsPage.CheckboxLabels;
import efremov.data.enums.diffElementsPage.ColorsOptions;
import efremov.data.enums.diffElementsPage.RadioLabels;
import initialization.SimpleTestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static efremov.JDISite.*;

public class diffElementsMainTest extends SimpleTestsInit {

    @BeforeMethod
    public void openNeedPage() {
        indexPage.open();
        login();
        diffElementsPage.open();
    }

    @Test(dataProvider = "diffElementsProvider", dataProviderClass = DataProviders.class, groups = "dep")
    public void diffElemTest(CheckboxLabels element, RadioLabels metal, ColorsOptions color) {
        diffElementsPage.selectAndCheckCheckbox(element);
        diffElementsPage.selectAndCheckRadio(metal);
        diffElementsPage.selectAndCheckColor(color);
    }
}
