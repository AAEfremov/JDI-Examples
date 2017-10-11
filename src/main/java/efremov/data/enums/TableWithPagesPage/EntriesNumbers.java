package efremov.data.enums.TableWithPagesPage;

public enum EntriesNumbers {

    NUMBER5(5),
    NUMBER10(10),
    NUMBER15(15),
    NUMBER20(20);

    private Integer value;

    EntriesNumbers(Integer value) {
        this.value = value;
    }


    public Integer getValue() {
        return value;
    }
}
