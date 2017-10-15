package datesPageTests;

import efremov.data.DataProviders;
import efremov.entities.DatesData;
import initialization.SimpleTestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Step;

import static efremov.JDISite.*;

public class OptionalMandatoryTest extends SimpleTestsInit {

    @Step("Open Index Page and then Dates Page")
    @BeforeMethod(alwaysRun = true)
    public void openNeedPage() {
        indexPage.open();
        login();
        datesPage.open();
    }

    @Step("Check all/mandatory/optional fields of Dates Page")
    @Test(dataProvider = "testDatesData", dataProviderClass = DataProviders.class, groups = "dp")
    public void mandatoryOptionalTest(DatesData datesData, String status, Boolean submit) {

        switch (submit.toString()) {
            case "true":
                switch (status) {
                    case "all":
                        datesPage.datesForm.submit(datesData);
                        datesPage.datesForm.checkAll(datesData, resultSection);
                        break;
                    case "mandatory":
                        datesPage.datesForm.onlyMandatory().submit(datesData);
                        datesPage.datesForm.checkMandatory(datesData, resultSection);
                        break;
                    case "optional":
                        datesPage.datesForm.onlyOptional().submit(datesData);
                        datesPage.datesForm.checkOptional(datesData, resultSection);
                        break;
                    case "nothing":
                        datesPage.datesForm.submit.click();
                        datesPage.datesForm.checkNothing();
                        break;
                }
                break;
            case "false":
                switch (status) {
                    case "all":
                        datesPage.datesForm.fill(datesData);
                        break;
                    case "mandatory":
                        datesPage.datesForm.time.clear();
                        datesPage.datesForm.onlyMandatory().fill(datesData);
                        break;
                    case "optional":
                        datesPage.datesForm.onlyOptional().fill(datesData);
                        break;
                    case "nothing":
                        datesPage.datesForm.time.clear();
                        break;
                }
                break;
        }

    }

}
