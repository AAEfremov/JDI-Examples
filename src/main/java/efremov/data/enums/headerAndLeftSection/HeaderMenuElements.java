package efremov.data.enums.headerAndLeftSection;

public enum HeaderMenuElements {

    //header menu elements
    HOME("HOME"),
    CONTACT_FORM("CONTACT FORM"),
    SERVICE("SERVICE"),
    METALS_AND_COLORS("METALS & COLORS"),

    //service dropdown elements
    SUPPORT("SUPPORT"),
    DATES("DATES"),
    COMPLEX_TABLE("COMPLEX TABLE"),
    SIMPLE_TABLE("SIMPLE TABLE"),
    TABLE_WITH_PAGES("TABLE WITH PAGES"),
    DIFFERENT_ELEMENTS("DIFFERENT ELEMENTS");

    private String element;

    HeaderMenuElements(String element) {
        this.element = element;
    }


    public String getElement() {
        return element;
    }
}
