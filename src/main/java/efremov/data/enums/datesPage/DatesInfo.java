package efremov.data.enums.datesPage;

import java.util.ArrayList;
import java.util.List;

public enum DatesInfo {

    FIRST_NAME("Alex"),
    LAST_NAME("Efremov"),
    DESCRIPTION("This one of meny tests in my life..."),
    TIME("10:00 AM"),
    FROM("10"),
    TO("50");
    //RANGE1("10", "50");

    private String value;
    private List<String> rangeValues = new ArrayList<>();

    DatesInfo(String value) {
        this.value = value;
    }

    DatesInfo(String from, String to) {
        this.rangeValues.add(from);
        this.rangeValues.add(to);
    }

    public String getValue() {
        return value;
    }

    public String getRangeValue(Integer index) {
        return rangeValues.get(index);
    }
}
