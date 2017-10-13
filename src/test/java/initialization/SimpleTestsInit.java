package initialization;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.testng.testRunner.TestNGBase;
import efremov.JDISite;
import org.testng.annotations.BeforeSuite;

import static com.epam.jdi.uitests.core.settings.JDISettings.logger;

public class SimpleTestsInit extends TestNGBase {
    @BeforeSuite(alwaysRun = true)
    public static void setUp() {
        WebSite.init(JDISite.class);
        logger.info("Run Tests");
    }
}
