package smokeRegressionTests;

import initialization.SimpleTestsInit;
import org.testng.annotations.Test;

import static com.epam.jdi.uitests.core.interfaces.complex.interfaces.CheckPageTypes.CONTAINS;
import static efremov.JDISite.indexPage;

public class IndexPageExistenceTest extends SimpleTestsInit{

    @Test(groups = {"smoke", "regression"})
    public void IndexPageTestExist() {
        indexPage.checkTitleType = CONTAINS;
        indexPage.shouldBeOpened();
    }
}
