package efremov.data.enums.metalAndColorsPage;

public enum MetalsLabels {

    COL("Col"),
    GOLD("Gold"),
    SILVER("Silver"),
    BRONZE("Bronze"),
    SELEN("Selen");

    private String label;


    MetalsLabels(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
