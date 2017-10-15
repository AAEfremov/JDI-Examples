package efremov.entities;

import com.epam.commons.DataClass;

import java.util.ArrayList;
import java.util.List;

public class DatesData extends DataClass {

    public String firstName = "";
    public String lastName = "";
    public String description = "";
    public String date = "";
    public String time = "";
    public Range range1 = null;
    public Range range2 = null;

    public DatesData(String firstName, String lastName, String description, String date, String time, Range range1, Range range2) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.description = description;
        this.date = date;
        this.time = time;
        this.range1 = range1;
        this.range2 = range2;
    }

    public DatesData() {

    }


}
