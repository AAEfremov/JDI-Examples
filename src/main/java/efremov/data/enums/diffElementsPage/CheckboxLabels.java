package efremov.data.enums.diffElementsPage;

import java.util.ArrayList;
import java.util.List;

public enum CheckboxLabels {

    WATER("Water"),
    EARTH("Earth"),
    WIND("Wind"),
    FIRE("Fire"),
    TRUE("true"),
    FALSE("false");

    private String label;


    CheckboxLabels(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public String getTrueStatus() {
        return TRUE.getLabel();
    }

    public String getFalseStatus() {
        return FALSE.getLabel();
    }

}
