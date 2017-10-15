package efremov.data.enums.diffElementsPage;

import java.util.ArrayList;
import java.util.List;

public enum RadioLabels {

    GOLD("Gold"),
    SILVER("Silver"),
    BRONZE("Bronze"),
    SELEN("Selen"),
    METAL("metal");


    private String label;

    RadioLabels(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public String getMetalTag() {
        return METAL.getLabel();
    }
}
