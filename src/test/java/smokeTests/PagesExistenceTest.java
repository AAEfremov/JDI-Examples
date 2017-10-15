package smokeTests;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.web.matcher.testng.Assert;
import efremov.data.DataProviders;
import efremov.data.enums.headerAndLeftSection.HeaderMenuElements;
import initialization.SimpleTestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Step;

import static efremov.JDISite.*;

public class PagesExistenceTest extends SimpleTestsInit{

    @Step("Open Index Page and login")
    @BeforeMethod(alwaysRun = true)
    public void openIndexPage() {
        indexPage.open();
        login();
    }


    @Step("Open verified page and check its title")
    @Test(dataProvider = "pages", dataProviderClass = DataProviders.class, groups = "smoke")
    public void pagesExistTest(String title, HeaderMenuElements... page) {
        header.open(page);
        Assert.assertContains(WebPage.getTitle(), title);
    }




}
