package efremov.pages;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import efremov.forms.MetalAndColorsForm;

@JPage(url = "/page2.htm", title = "Metal and Colors")
public class MetalAndColorsPage extends WebPage {

    public MetalAndColorsForm metalAndColorsForm;

}
