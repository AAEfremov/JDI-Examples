package efremov.data;

import efremov.entities.DatesData;
import efremov.entities.User;
import org.testng.annotations.DataProvider;

import static efremov.data.enums.datesPage.DatesInfo.*;
import static efremov.data.enums.datesPage.StatusesForFields.*;
import static efremov.data.enums.indexPage.UsersCredentials.*;

public class DataProviders {

    @DataProvider(name = "testLoginData", parallel = true)
    public static Object[][] testLoginData() {
        return new Object[][]{
                {new User(USER1.getName(), USER1.getPassword(), USER1.getStatus())},
                {new User(USER2.getName(), USER2.getPassword(), USER2.getStatus())},
                {new User(USER3.getName(), USER3.getPassword(), USER3.getStatus())},
                {new User()}
        };
    }

    /*@DataProvider(name = "fillUserData")
    public static Object[][] fillUserData() {
        return new Object[][]{
                {new User()}
        };
    }*/

    @DataProvider(name = "testDatesData", parallel = true)
    public static Object[][] testDatesData() {
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

    @DataProvider(name = "dragAndDrop")
    public Object[][] dragAndDrop(){
        return new Object[][]{
                {0, 100},
                {0, 0},
                {100, 100},
                {30, 70}
        };
    }



}
