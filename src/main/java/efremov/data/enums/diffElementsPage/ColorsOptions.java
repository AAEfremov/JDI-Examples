package efremov.data.enums.diffElementsPage;

import java.util.ArrayList;
import java.util.List;

public enum ColorsOptions {

    RED("Red"),
    GREEN("Green"),
    BLUE("Blue"),
    YELLOW("Yellow");

    private String color;

    ColorsOptions(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public String getColorTag() {
        return "Colors";
    }
}
