package contactPageTests;

import efremov.data.DataProviders;
import efremov.entities.ContactData;
import initialization.SimpleTestsInit;
import org.testng.annotations.Test;

import static efremov.JDISite.*;

public class contactFormMainTest extends SimpleTestsInit {

    @Test(dataProvider = "contactFormProvider", dataProviderClass = DataProviders.class, groups = "cf")
    public void TestCF(ContactData contactData){
        indexPage.open();
        login();
        contactFormPage.open();

        int sum = contactFormPage.contactForm.takeSum(contactData.oddNumber, contactData.evenNumber);

        contactFormPage.contactForm.submit(contactData);

        contactFormPage.contactForm.checkResults(contactData, sum);
    }
}
