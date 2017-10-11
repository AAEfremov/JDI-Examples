package efremov.pages;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import efremov.forms.DatesForm;

@JPage(url = "/page4.htm", title = "Dates")
public class DatesPage extends WebPage {

    public DatesForm datesForm;


}



/*public class datesPage extends ChromeSetup {

    private Header headerMenu = page(Header.class);
    private LeftSection leftMenu = page(LeftSection.class);

    @FindBy(css = ".ui-slider")
    SelenideElement sliderTrack;

    @FindBy(css = ".ui-slider-handle")
    private ElementsCollection sliderHandles;

    //open Dates Page
    public void openPage() {
        headerMenu.getHeaderService().click();
        headerMenu.getHeaderServiceElements().get(1).click();
    }

    //scroll down Dates Page
    public void scrollDown() {
        Selenide.executeJavaScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    //get real handle step size
    private Double getStep() {

        return Double.parseDouble(String.valueOf(sliderTrack.getSize().width)) / 100.0;
    }

    //get handle current position
    private Double getCurrentPosition(SliderHandles handle) {

        Double sliderCenterPx = Double.parseDouble(sliderHandles.get(handle.getHandle()).getCssValue("left")
                .replaceAll("px", "")) + (sliderHandles.get(handle.getHandle())).getSize().width / 2.0;

        return sliderCenterPx / getStep();
    }

    //move and check handler
    public void setHandlePosition(SliderHandles handle, Integer position) {

        int extraOffset = 10; //need because handles aren't accurately determined
        Double offset = (position - getCurrentPosition(handle)) * getStep();
        actions().dragAndDropBy(sliderHandles.get(handle.getHandle()), (int) Math.round(offset) + extraOffset, 0).perform();
        sliderHandles.get(handle.getHandle()).shouldHave(exactText(position.toString()));

    }
}*/










