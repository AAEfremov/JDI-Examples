package efremov.data.enums;

public enum Pages {

    INDEX_PAGE(0, "Index Page"),
    CONTACT_FORM_PAGE(1, "Contact Form"),
    SUPPORT_PAGE(2, "Support"),
    DATES_PAGE(3, "Dates"),
    COMPLEX_TABLE_PAGE(4, "Complex Table"),
    SIMPLE_TABLE_PAGE(5, "Simple Table"),
    TABLE_WITH_PAGES_PAGE(6, "Table with pages"),
    DIFFERENT_ELEMENTS_PAGE(7, "Different Element"),
    METALS_AND_COLORS_PAGE(8, "Metal and Colors");

    private String pageTitle;
    private int pageNumber;


    Pages(int pageNumber, String pageTitle) {
        this.pageNumber = pageNumber;
        this.pageTitle = pageTitle;
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public int getPageNumber() {
        return pageNumber;
    }
}
