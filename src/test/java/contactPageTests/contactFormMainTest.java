package contactPageTests;

import efremov.data.DataProviders;
import efremov.entities.ContactData;
import initialization.SimpleTestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static efremov.JDISite.*;

public class contactFormMainTest extends SimpleTestsInit {

    @BeforeMethod
    public void openNeedPage() {
        indexPage.open();
        login();
        contactFormPage.open();
    }

    @Test(dataProvider = "contactFormProvider", dataProviderClass = DataProviders.class, groups = "smoke")
    public void TestCF(ContactData contactData){

        int sum = contactFormPage.contactForm.takeSum(contactData.oddNumber, contactData.evenNumber);

        contactFormPage.contactForm.submit(contactData);

        contactFormPage.contactForm.checkResults(contactData, sum, resultSection);
    }
}
