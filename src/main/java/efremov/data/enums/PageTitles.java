package efremov.data.enums;

public enum PageTitles {

    INDEX_PAGE("Index Page"),
    CONTACT_FORM_PAGE("Contact Form"),
    SUPPORT_PAGE("Support"),
    DATES_PAGE("Dates"),
    COMPLEX_TABLE_PAGE("Complex Table"),
    SIMPLE_TABLE_PAGE("Simple Table"),
    TABLE_WITH_PAGES_PAGE("Table with pages"),
    DIFFERENT_ELEMENTS_PAGE("Different Element"),
    METALS_AND_COLORS_PAGE("Metal and Colors");

    private String pageTitle;


    PageTitles(String pageTitle) {
        this.pageTitle = pageTitle;
    }

    public String getPageTitle() {
        return pageTitle;
    }
}
