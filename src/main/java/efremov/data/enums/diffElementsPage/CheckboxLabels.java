package efremov.data.enums.diffElementsPage;

import java.util.ArrayList;
import java.util.List;

public enum CheckboxLabels {

    WATER("Water"),
    EARTH("Earth"),
    WIND("Wind"),
    FIRE("Fire");

    private String label;


    CheckboxLabels(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
