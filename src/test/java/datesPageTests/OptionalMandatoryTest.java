package datesPageTests;

import com.epam.web.matcher.testng.Assert;
import efremov.data.DataProviders;
import efremov.entities.DatesData;
import initialization.SimpleTestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Objects;

import static com.codeborne.selenide.Configuration.browser;
import static com.epam.jdi.uitests.core.interfaces.complex.interfaces.CheckPageTypes.CONTAINS;
import static efremov.JDISite.*;
import static efremov.data.enums.datesPage.StatusesForFields.NOTHING;
import static efremov.data.enums.headerAndLeftSection.HeaderMenuElements.*;


public class OptionalMandatoryTest extends SimpleTestsInit {

    @Test(dataProvider = "testDatesData", dataProviderClass = DataProviders.class)
    public void mandatoryOptionalTest(DatesData datesData, String status, Boolean submit) {

        indexPage.checkTitleType = CONTAINS;
        indexPage.shouldBeOpened();
        login();

        header.open(SERVICE, DATES);

        switch (submit.toString()) {
            case "true":
                switch (status) {
                    case "all":
                        datesPage.datesForm.fill(datesData);
                        datesPage.datesForm.submit.click();
                        Assert.contains(resultSection.firstName.getText(), datesData.firstName);
                        Assert.contains(resultSection.lastName.getText(), datesData.lastName);
                        Assert.contains(resultSection.description.getText(), datesData.description);
                        Assert.contains(resultSection.date.getText(), datesData.date);
                        Assert.contains(resultSection.time.getText(), datesData.time);
                        Assert.contains(resultSection.range.getText(), String.valueOf(datesData.range1.from));
                        Assert.contains(resultSection.range.getText(), String.valueOf(datesData.range1.to));
                        Assert.contains(resultSection.slider.getText(), String.valueOf(datesData.range2.from));
                        Assert.contains(resultSection.slider.getText(), String.valueOf(datesData.range2.to));
                        break;
                    case "mandatory":
                        datesPage.datesForm.onlyMandatory().submit(datesData);
                        Assert.contains(resultSection.firstName.getText(), datesData.firstName);
                        Assert.contains(resultSection.lastName.getText(), datesData.lastName);
                        Assert.contains(resultSection.range.getText(), String.valueOf(datesData.range1.from));
                        Assert.contains(resultSection.range.getText(), String.valueOf(datesData.range1.to));
                        Assert.assertTrue(datesPage.datesForm.description.getText().isEmpty() &&
                                datesPage.datesForm.date.getText().isEmpty());
                        break;
                    case "optional":
                        datesPage.datesForm.onlyOptional().submit(datesData);
                        Assert.contains(resultSection.description.getText(), datesData.description);
                        Assert.contains(resultSection.time.getText(), datesData.time);
                        Assert.assertTrue(datesPage.datesForm.firstName.getText().isEmpty() &&
                                datesPage.datesForm.lastName.getText().isEmpty() &&
                                datesPage.datesForm.range1.get(0).getText().isEmpty() &&
                                datesPage.datesForm.range1.get(1).getText().isEmpty()
                                );
                        break;
                    case "nothing":
                        datesPage.datesForm.submit.click();
                        Assert.assertTrue(datesPage.datesForm.firstName.getText().isEmpty() &&
                                datesPage.datesForm.lastName.getText().isEmpty() &&
                                datesPage.datesForm.description.getText().isEmpty() &&
                                datesPage.datesForm.date.getText().isEmpty() &&
                                datesPage.datesForm.range1.get(0).getText().isEmpty() &&
                                datesPage.datesForm.range1.get(1).getText().isEmpty()
                                );
                        break;
                }
                break;
            case "false":
                switch (status) {
                    case "all":
                        datesPage.datesForm.fill(datesData);
                        break;
                    case "mandatory":
                        datesPage.datesForm.time.clear();
                        datesPage.datesForm.onlyMandatory().fill(datesData);
                        Assert.assertTrue(datesPage.datesForm.description.getText().isEmpty() &&
                                datesPage.datesForm.date.getText().isEmpty() &&
                                datesPage.datesForm.time.getText().isEmpty());
                        break;
                    case "optional":
                        datesPage.datesForm.onlyOptional().fill(datesData);
                        Assert.assertTrue(datesPage.datesForm.firstName.getText().isEmpty() &&
                                datesPage.datesForm.lastName.getText().isEmpty() &&
                                datesPage.datesForm.range1.get(0).getText().isEmpty() &&
                                datesPage.datesForm.range1.get(1).getText().isEmpty());
                        break;
                    case "nothing":
                        datesPage.datesForm.time.clear();
                        Assert.assertTrue(datesPage.datesForm.firstName.getText().isEmpty() &&
                                datesPage.datesForm.lastName.getText().isEmpty() &&
                                datesPage.datesForm.description.getText().isEmpty() &&
                                datesPage.datesForm.date.getText().isEmpty() &&
                                datesPage.datesForm.time.getText().isEmpty() &&
                                datesPage.datesForm.range1.get(0).getText().isEmpty() &&
                                datesPage.datesForm.range1.get(1).getText().isEmpty());
                        break;
                }
                break;
        }

    }

    @BeforeMethod
    public void tearDown() {
    }

}
