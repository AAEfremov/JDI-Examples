package contactPageTests;

import efremov.data.DataProviders;
import efremov.entities.ContactFormData;
import initialization.SimpleTestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Step;

import static efremov.JDISite.*;

public class contactFormMainTest extends SimpleTestsInit {

    @Step("Open Index Page and then Contact Form Page")
    @BeforeMethod(alwaysRun = true)
    public void openIndexPage() {
        indexPage.open();
        login();
        contactFormPage.open();
    }

    @Step("Check Contact Form functionality")
    @Test(dataProvider = "contactFormProvider", dataProviderClass = DataProviders.class, groups = "cf")
    public void TestCF(ContactFormData contactFormData){
        int sum = contactFormPage.contactForm.takeSum(contactFormData.oddNumber, contactFormData.evenNumber);
        contactFormPage.contactForm.submit(contactFormData);
        contactFormPage.contactForm.checkResults(contactFormData, sum);
    }
}
