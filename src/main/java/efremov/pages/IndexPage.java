package efremov.pages;

import com.epam.jdi.uitests.web.selenium.elements.common.Image;
import com.epam.jdi.uitests.web.selenium.elements.common.Label;
import com.epam.jdi.uitests.web.selenium.elements.complex.Elements;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import org.openqa.selenium.support.FindBy;

@JPage(url = "/index.htm", title = "Index Page")
public class IndexPage extends WebPage {

    @FindBy(css = ".benefit-icon")
    public Elements<Image> pictures;

    @FindBy(css = ".benefit-txt")
    public Elements<Label> textsUnderPictures;

    @FindBy(css = ".text-center")
    public Elements<Label> textsAbovePictures;
}