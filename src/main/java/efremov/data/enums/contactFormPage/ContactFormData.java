package efremov.data.enums.contactFormPage;

public enum ContactFormData {

    FIRST_NAME("SomeName"),
    LAST_NAME("SomeLastName"),
    DESCRIPTION("SomeDescription");

    private String value;


    ContactFormData(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
