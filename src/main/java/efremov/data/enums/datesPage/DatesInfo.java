package efremov.data.enums.datesPage;

import efremov.entities.Range;

public enum DatesInfo {
    DATA1("Nekto", "Somebody", "This one of many tests in my life...", "10/13/2017", "10:00 AM", new Range(10, 50), new Range(20, 80)),
    DATA2("Ivan", "Ivanovich", "Some description", "01/01/2001", "1:00 PM", new Range(0, 0), new Range(0, 100)),
    DATA3("Alisa", "Yandex", "This is the new smart helper...", "10/10/2017", "12:00 AM", new Range(100, 100), new Range(100, 100));


    private String firstName;
    private String lastName;
    private String description;
    private String date;
    private String time;
    private Range range1;
    private Range range2;


    DatesInfo(String firstName, String lastName, String description, String date, String time, Range range1, Range range2) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.description = description;
        this.date = date;
        this.time = time;
        this.range1 = range1;
        this.range2 = range2;

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }


    public Range getRange1() {
        return range1;
    }

    public Range getRange2() {
        return range2;
    }
}
