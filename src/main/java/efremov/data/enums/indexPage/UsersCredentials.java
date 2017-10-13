package efremov.data.enums.indexPage;

public enum UsersCredentials {

    USER1("epam", "", false),
    USER2("abc", "abc", false),
    USER3("", "", false);

    private String name;
    private String password;
    private Boolean status;


    UsersCredentials(String name, String password, Boolean status) {
        this.name = name;
        this.password = password;
        this.status = status;
    }


    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public Boolean getStatus() {
        return status;
    }
}
