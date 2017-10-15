package smokeRegressionTests;

import initialization.SimpleTestsInit;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Step;

import static com.epam.jdi.uitests.core.interfaces.complex.interfaces.CheckPageTypes.CONTAINS;
import static efremov.JDISite.indexPage;

public class IndexPageExistenceTest extends SimpleTestsInit{

    @Step("Open Index Page")
    @Test(groups = {"smoke", "regression"})
    public void IndexPageTestExist() {
        indexPage.checkTitleType = CONTAINS;
        indexPage.shouldBeOpened();
    }
}
