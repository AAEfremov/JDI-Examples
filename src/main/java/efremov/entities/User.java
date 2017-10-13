package efremov.entities;

import com.epam.commons.DataClass;

/**
 * Created by Roman_Iovlev on 5/26/2017.
 */
public class User extends DataClass {
    public String name = "epam";
    public String password = "1234";
    public Boolean status = true;
    public String userName = "PITER CHAILOVSKII";
    public String loginFailed = "* Login Faild";

    public User(){}

    public User(String name, String password, Boolean status) {
        this.name = name;
        this.password = password;
        this.status = status;
    }
}
