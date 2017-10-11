package efremov.data.enums.headerAndLeftSection;

public enum LeftMenuElements {

    //left menu elements
    HOME("Home"),
    CONTACT_FORM("Contact form"),
    SERVICE("Service"),
    METALS_AND_COLORS("Metals & Colors"),

    //service dropdown elements
    SUPPORT("Support"),
    DATES("Dates"),
    COMPLEX_TABLE("Complex Table"),
    SIMPLE_TABLE("Simple Table"),
    TABLE_WITH_PAGES("Table with pages"),
    DIFFERENT_ELEMENTS("Different elements");

    private String element;

    LeftMenuElements(String element) {
        this.element = element;
    }


    public String getElement() {
        return element;
    }
}
