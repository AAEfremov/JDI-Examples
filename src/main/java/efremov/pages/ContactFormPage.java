package efremov.pages;

import com.epam.jdi.uitests.web.selenium.elements.common.TextArea;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import efremov.entities.User;
import efremov.forms.ContactForm;
import org.openqa.selenium.support.FindBy;

@JPage(url = "/page1.htm", title = "Contact Form")
public class ContactFormPage extends WebPage {

    public ContactForm contactForm;


    public void fillContactForm() {

        contactForm.submit(new User(), "Submit");
    }

}

