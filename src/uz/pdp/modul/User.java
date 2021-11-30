package uz.pdp.modul;

import java.util.Objects;
import java.util.UUID;

public class User extends BaseModel{
    private String userName;
    private String password;
    private UserType userType;


    public User() {

    }

    public User(String name, String userName, String password) {
        super( name);
        this.userName = userName;
        this.password = password;
        this.userType = UserType.USER;
    }

    public User(String name, String userName, String password, double balance, UserType userType) {
        super( name);
        this.userName = userName;
        this.password = password;
        this.userType = userType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return this.id==user.id && this.password.equals(user.password);
    }

}
