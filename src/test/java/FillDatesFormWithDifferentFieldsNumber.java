import Homeworks.SimpleTestsInit;
import com.epam.web.matcher.testng.Assert;
import efremov.data.DataProviders;
import efremov.entities.DatesData;
import efremov.entities.User;
import org.testng.annotations.Test;

import static com.epam.jdi.uitests.core.interfaces.complex.interfaces.CheckPageTypes.CONTAINS;
import static efremov.JDISite.*;
import static efremov.data.enums.headerAndLeftSection.HeaderMenuElements.*;


public class FillDatesFormWithDifferentFieldsNumber extends SimpleTestsInit {

    @Test(dataProvider = "fillUserAndDatesData", dataProviderClass = DataProviders.class)
    public void FillAllFieldsAndSubmit(User user, DatesData datesData) {

        indexPage.checkTitleType = CONTAINS;
        indexPage.shouldBeOpened();
        login(user);
        checkUsername(user);

        header.open(SERVICE, DATES);

        //DatesData datesData = new DatesData(FIRST_NAME.getValue(), LAST_NAME.getValue(), DESCRIPTION.getValue(), TIME.getValue(), FROM.getValue(), TO.getValue());
        //datesPage.datesForm.submit(datesData);
        datesPage.datesForm.submit(datesData);
        Assert.contains(resultSection.firstName.getText(), datesData.firstName);
        Assert.contains(resultSection.lastName.getText(), datesData.lastName);
        Assert.contains(resultSection.description.getText(), datesData.description);
        Assert.contains(resultSection.time.getText(), datesData.time);
        Assert.contains(resultSection.range.getText(), datesData.from);
        Assert.contains(resultSection.range.getText(), datesData.to);
    }

    @Test(dataProvider = "fillUserAndDatesData", dataProviderClass = DataProviders.class)
    public void FillOnlyMandatoryFields(User user, DatesData datesData) {

        indexPage.checkTitleType = CONTAINS;
        indexPage.shouldBeOpened();
        login(user);
        checkUsername(user);

        header.open(SERVICE, DATES);
        datesPage.datesForm.time.clear();
        //DatesData datesData = new DatesData(FIRST_NAME.getValue(), LAST_NAME.getValue(), FROM.getValue(), TO.getValue());
        datesPage.datesForm.onlyMandatory().fill(datesData);
    }

    @Test(dataProvider = "fillUserAndDatesData", dataProviderClass = DataProviders.class)
    public void FillAllOptionalFields(User user, DatesData datesData) {

        indexPage.checkTitleType = CONTAINS;
        indexPage.shouldBeOpened();
        login(user);
        checkUsername(user);

        header.open(SERVICE, DATES);

        //DatesData datesData = new DatesData(DESCRIPTION.getValue(), TIME.getValue());
        datesPage.datesForm.onlyOptional().submit(datesData);

        Assert.contains(resultSection.description.getText(), datesData.description);
        Assert.contains(resultSection.time.getText(), datesData.time);
    }

    @Test(dataProvider = "fillUserData", dataProviderClass = DataProviders.class)
    public void NotFillAndSubmit(User user) {

        indexPage.checkTitleType = CONTAINS;
        indexPage.shouldBeOpened();
        login(user);
        checkUsername(user);

        header.open(SERVICE, DATES);

        datesPage.datesForm.time.clear();
        datesPage.datesForm.submit.click();
    }

}
