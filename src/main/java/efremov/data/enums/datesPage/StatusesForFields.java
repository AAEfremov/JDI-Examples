package efremov.data.enums.datesPage;

/**
 * Created by X240 on 10/8/2017.
 */
public enum StatusesForFields {
    ALL("all"),
    MANDATORY("mandatory"),
    OPTIONAL("optional"),
    NOTHING("nothing");

    private String status;

    StatusesForFields(String status){
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
