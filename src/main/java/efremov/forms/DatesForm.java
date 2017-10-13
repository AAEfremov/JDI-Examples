package efremov.forms;

import com.codeborne.selenide.SelenideElement;
import com.epam.jdi.uitests.core.annotations.Mandatory;
import com.epam.jdi.uitests.core.interfaces.complex.FormFilters;
import com.epam.jdi.uitests.web.robot.RFileInput;
import com.epam.jdi.uitests.web.selenium.elements.common.*;
import com.epam.jdi.uitests.web.selenium.elements.complex.Elements;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import com.epam.web.matcher.testng.Assert;
import efremov.entities.DatesData;
import efremov.sections.ResultSection;
import org.openqa.selenium.support.FindBy;

import static com.epam.jdi.uitests.core.interfaces.complex.FormFilters.ALL;
import static com.epam.jdi.uitests.core.interfaces.complex.FormFilters.MANDATORY;
import static com.epam.jdi.uitests.core.interfaces.complex.FormFilters.OPTIONAL;
import static com.epam.web.matcher.testng.Assert.assertEquals;
import static efremov.JDISite.datesPage;

public class DatesForm extends Form<DatesData> {

    @Mandatory
    @FindBy(id="Name")
    public TextField firstName;
    @Mandatory
    @FindBy(id="LastName")
    public TextField lastName;

    @FindBy(id = "Description")
    public TextArea description;

    @JFindBy(xpath = "//*[@id='datepicker']/input")
    public DatePicker date;

    @JFindBy(id = "timepicker")
    public DatePicker time;  //There is no TimePicker type

    @FindBy(css = ".thumbnail>span")
    public RFileInput imageInput;

    /*@Mandatory
    @FindBy(css = ".range-range1.overflow>input")
    public Elements<TextField> range1;*/
    @FindBy(css = ".range-from>input")
    public Elements<TextField> range1;

    @FindBy(css = ".ui-slider-handle")
    public Elements<Link> handles;

    @FindBy(css = ".ui-slider")
    private SelenideElement handleTrack;

    @JFindBy(text = "Submit")
    public Button submit;


    private FormFilters currentFilter = ALL;

    @Override
    public void filter(FormFilters filter){
        currentFilter = filter;
        super.filter(filter);
    }

    @Override
    public void submit(DatesData datesData){
        super.fill(datesData);

        if (currentFilter != OPTIONAL){
            range1.get(0).sendKeys(String.valueOf(datesData.range1.from));
            range1.get(1).sendKeys(String.valueOf(datesData.range1.to));
        }

        if (currentFilter != MANDATORY){
            setHandlesPosition(datesData.range2.from, datesData.range2.to);
        }

        submit.click();
    }

    @Override
    public void fill(DatesData datesData){
        super.fill(datesData);

        if (currentFilter != OPTIONAL){
            range1.get(0).sendKeys(String.valueOf(datesData.range1.from));
            range1.get(1).sendKeys(String.valueOf(datesData.range1.to));
        }

        if (currentFilter != MANDATORY){
            handleTrack.scrollTo();
            setHandlesPosition(datesData.range2.from, datesData.range2.to);
        }
    }


    private Double getStep() {

        return Double.parseDouble(String.valueOf(handleTrack.getSize().width)) / 100.0;
    }

    public void moveHandleToPosition(Link handle, int position) {

        int extraOffset = -2; //need because handles aren't accurately determined
        Double offset = (position - Integer.valueOf(handle.getValue())) * getStep();
        handle.dragAndDropBy((int) Math.round(offset) + extraOffset, 0);
    }

    public void setHandlesPosition(int leftPos, int rightPos) {
        if (rightPos < leftPos)
            return;
        handleTrack.scrollTo();
        if (getHandlePosition(handles.get(1)) <= leftPos) {
            moveHandleToPosition(handles.get(1), rightPos);
            moveHandleToPosition(handles.get(0), leftPos);
        } else {
            moveHandleToPosition(handles.get(0), leftPos);
            moveHandleToPosition(handles.get(1), rightPos);
        }
    }

    private int getHandlePosition(Link handle) {
        return new Integer(handle.getText());
    }

    public void checkHandlesPosition(int leftPos, int rightPos) {
        assertEquals(handles.get(0).getValue(), Integer.toString(leftPos));
        assertEquals(handles.get(1).getValue(), Integer.toString(rightPos));
    }

    public void checkAll(DatesData datesData, ResultSection resultSection) {
        Assert.contains(resultSection.firstName.getText(), datesData.firstName);
        Assert.contains(resultSection.lastName.getText(), datesData.lastName);
        Assert.contains(resultSection.description.getText(), datesData.description);
        Assert.contains(resultSection.date.getText(), datesData.date);
        Assert.contains(resultSection.time.getText(), datesData.time);
        Assert.contains(resultSection.range.getText(), String.valueOf(datesData.range1.from));
        Assert.contains(resultSection.range.getText(), String.valueOf(datesData.range1.to));
        Assert.contains(resultSection.slider.getText(), String.valueOf(datesData.range2.from));
        Assert.contains(resultSection.slider.getText(), String.valueOf(datesData.range2.to));
    }

    public void checkOptional(DatesData datesData, ResultSection resultSection) {
        Assert.contains(resultSection.description.getText(), datesData.description);
        Assert.contains(resultSection.time.getText(), datesData.time);
        /*Assert.assertTrue(firstName.getText().isEmpty() && lastName.getText().isEmpty() &&
                range1.get(0).getText().isEmpty() && range1.get(1).getText().isEmpty());*/
    }

    public void checkMandatory(DatesData datesData, ResultSection resultSection) {
        Assert.contains(resultSection.firstName.getText(), datesData.firstName);
        Assert.contains(resultSection.lastName.getText(), datesData.lastName);
        Assert.contains(resultSection.range.getText(), String.valueOf(datesData.range1.from));
        Assert.contains(resultSection.range.getText(), String.valueOf(datesData.range1.to));
        Assert.assertTrue(description.getText().isEmpty() && date.getText().isEmpty());
    }

    public void checkNothing() {
        Assert.assertTrue(firstName.getText().isEmpty() && lastName.getText().isEmpty() && description.getText().isEmpty() &&
                date.getText().isEmpty() &&
                datesPage.datesForm.range1.get(0).getText().isEmpty() &&
                datesPage.datesForm.range1.get(1).getText().isEmpty());
    }
}
