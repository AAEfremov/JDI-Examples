package efremov.data;

import efremov.entities.ContactData;
import efremov.entities.DatesData;
import efremov.entities.User;
import org.testng.annotations.DataProvider;

import static efremov.data.enums.Numbers.*;
import static efremov.data.enums.Pages.*;
import static efremov.data.enums.contactFormPage.ContactFormData.*;
import static efremov.data.enums.datesPage.DatesInfo.*;
import static efremov.data.enums.datesPage.StatusesForFields.*;
import static efremov.data.enums.diffElementsPage.CheckboxLabels.*;
import static efremov.data.enums.diffElementsPage.ColorsOptions.*;
import static efremov.data.enums.diffElementsPage.RadioLabels.*;
import static efremov.data.enums.headerAndLeftSection.HeaderMenuElements.*;
import static efremov.data.enums.indexPage.UsersCredentials.*;

public class DataProviders {



    @DataProvider(name = "pages", parallel = true)
    public Object[][] pages() {
        return new Object[][]{
                {CONTACT_FORM_PAGE.getPageTitle(), CONTACT_FORM},
                {SUPPORT_PAGE.getPageTitle(), SERVICE, SUPPORT},
                {DATES_PAGE.getPageTitle(), SERVICE, DATES},
                {COMPLEX_TABLE_PAGE.getPageTitle(), SERVICE, COMPLEX_TABLE},
                {SIMPLE_TABLE_PAGE.getPageTitle(), SERVICE, SIMPLE_TABLE},
                {TABLE_WITH_PAGES_PAGE.getPageTitle(), SERVICE, TABLE_WITH_PAGES},
                {DIFFERENT_ELEMENTS_PAGE.getPageTitle(), SERVICE, DIFFERENT_ELEMENTS},
                {METALS_AND_COLORS_PAGE.getPageTitle(), METALS_AND_COLORS}
        };
    }

    @DataProvider(name = "testLoginData", parallel = true)
    public Object[][] testLoginData() {
        return new Object[][]{
                {new User(USER1.getName(), USER1.getPassword(), USER1.getStatus())},
                {new User(USER2.getName(), USER2.getPassword(), USER2.getStatus())},
                {new User(USER3.getName(), USER3.getPassword(), USER3.getStatus())},
                {new User()}
        };
    }

    /*@DataProvider(firstName = "fillUserData")
    public static Object[][] fillUserData() {
        return new Object[][]{
                {new User()}
        };
    }*/

    @DataProvider(name = "testDatesData", parallel = true)
    public Object[][] testDatesData() {
        return new Object[][]{
                {new DatesData(DATA1.getFirstName(),DATA1.getLastName(), DATA1.getDescription(), DATA1.getDate(),
                        DATA1.getTime(),DATA1.getRange1(), DATA1.getRange2()), ALL.getStatus(), true},

                {new DatesData(DATA2.getFirstName(),DATA2.getLastName(), DATA2.getDescription(), DATA2.getDate(),
                        DATA2.getTime(),DATA2.getRange1(), DATA2.getRange2()), MANDATORY.getStatus(), false},

                {new DatesData(DATA3.getFirstName(),DATA3.getLastName(), DATA3.getDescription(), DATA3.getDate(),
                        DATA3.getTime(),DATA3.getRange1(), DATA3.getRange2()), OPTIONAL.getStatus(), true},

                {new DatesData(), NOTHING.getStatus(), true}

        };
    }

    //Testing Dates Page functionality
    @DataProvider(name = "dragAndDrop")
    public Object[][] dragAndDrop(){
        return new Object[][]{
                {0, 100},
                {0, 0},
                {100, 100},
                {30, 70}
        };
    }

    @DataProvider(name = "diffElementsProvider", parallel = true)
    public Object[][] diffElementsData(){
        return new Object[][]{
                {WATER, GOLD, RED},
                {EARTH, BRONZE, GREEN},
                {WIND, BRONZE, YELLOW},
                {FIRE, SILVER, BLUE}
        };
    }

    @DataProvider(name = "contactFormProvider", parallel = true)
    public Object[][] contactFormData(){
        return new Object[][]{
                {new ContactData(FIRST_NAME.getValue(), LAST_NAME.getValue(), DESCRIPTION.getValue(), THREE.getValue(), FOUR.getValue())},
                {new ContactData(FIRST_NAME.getValue(), LAST_NAME.getValue(), DESCRIPTION.getValue(), FIVE.getValue(), "")},
                {new ContactData(FIRST_NAME.getValue(), LAST_NAME.getValue(), "", "", SIX.getValue())},
                {new ContactData(FIRST_NAME.getValue(), LAST_NAME.getValue(), DESCRIPTION.getValue(), "", "")}
        };
    }

    @DataProvider(name = "pagination", parallel = true)
    public Object[][] pagination() {
        return new Object[][]{
                {SUPPORT_PAGE, CONTACT_FORM_PAGE, "prev"},
                {COMPLEX_TABLE_PAGE, DATES_PAGE, "prev"},
                {TABLE_WITH_PAGES_PAGE, SIMPLE_TABLE_PAGE, "prev"},
                {DATES_PAGE, COMPLEX_TABLE_PAGE, "next"},
                {SIMPLE_TABLE_PAGE, TABLE_WITH_PAGES_PAGE, "next"},
                {DIFFERENT_ELEMENTS_PAGE, METALS_AND_COLORS_PAGE, "next"}

        };
    }


}
