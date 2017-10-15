package efremov.entities;

import com.epam.commons.DataClass;

public class ContactData extends DataClass {

    public String firstName = "Alexandr";
    public String lastName = "Efremov";
    public String description = "";
    public String oddNumber = "";
    public String evenNumber = "";

    public ContactData(String firstName, String lastName, String description, String oddNumber, String evenNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.description = description;
        this.oddNumber = oddNumber;
        this.evenNumber = evenNumber;
    }

    public ContactData() {

    }


}
