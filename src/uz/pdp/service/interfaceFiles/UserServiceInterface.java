package uz.pdp.service.interfaceFiles;

import uz.pdp.modul.User;

import java.util.ArrayList;
import java.util.List;

public interface UserServiceInterface extends BaseModelService<User,Integer>{
    List<User> userList = new ArrayList<>();
    User checkUser(String userName, String password);
    boolean isAdmin(User user);
}
