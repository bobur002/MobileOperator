package uz.pdp.service;

import uz.pdp.modul.User;
import uz.pdp.modul.UserType;
import uz.pdp.service.interfaceFiles.UserServiceInterface;

import java.util.List;

public  class  UserService implements UserServiceInterface {

    {
        User admin = new User("bobur", "admin", "1111", 0, UserType.ADMIN);
        userList.add(admin);
    }

    @Override
    public Integer add(User user) {
        if (userList.size()==1){
            userList.add(user);
            return 1;
        }
        for (User curUser : userList) {
            if(user.equals(curUser)){
                return 2;
            }
        }
        userList.add(user);

        return 1;
    }

    @Override
    public List<User> getList() {
        return userList;
    }

    @Override
    public User checkUser(String userName, String password) {
        for (User user: userList ) {
            if(user.getUserName().equals(userName)&&user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }

    @Override
    public boolean delete(User user) {
        return false;
    }

    @Override
    public boolean isAdmin(User user) {
        return user.getUserType()==UserType.ADMIN;
    }
}
