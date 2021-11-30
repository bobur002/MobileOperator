package uz.pdp;

import uz.pdp.modul.MobileCompany;
import uz.pdp.modul.Tariff;
import uz.pdp.modul.User;
import uz.pdp.service.*;

import java.util.Scanner;

public class Main {



    public static void main(String[] args) {
	// write your code here
        UserService userService = new UserService();
        TariffService tariffService = new TariffService();
        SimCardService simCardService = new SimCardService();
        MobileCompanyService mobileCompanyService = new MobileCompanyService();
        Scanner scannerStr = new Scanner(System.in);
        Scanner scannerInt = new Scanner(System.in);

        int stepCode = 1;
        while (stepCode != 0) {
            System.out.println("---------------------------------------------");
            System.out.println("1.SighIn.\n2.SighUp.\n0.Exit.");
            System.out.println("---------------------------------------------");
            stepCode = scannerInt.nextInt();
            switch (stepCode) {
                case 1:
                    User user = sighIn(userService, scannerStr);
                    if (user != null) {
                        boolean isAdmin = userService.isAdmin(user);
                        if (isAdmin) {
                            System.out.println("admin panel");
                            AdminPanel.main(mobileCompanyService,userService,tariffService,simCardService,scannerStr, scannerStr);
                        }else {
                            System.out.println("user panel");
                            UserPanel.main(user,mobileCompanyService,tariffService,simCardService,scannerStr, scannerStr);
                        }
                    }
                    break;
                case 2:
                    sighUp(userService,scannerStr);
            }
        }
    }

    public static User sighIn(UserService userService,Scanner scannerStr){
        System.out.println("Please enter your username");
        String username = scannerStr.nextLine();
        System.out.println("Please enter your password");
        String password = scannerStr.nextLine();
        User user = userService.checkUser(username,password);
        if(user!=null)
            return user;
        System.out.println("Username or password is invalid...");
        return null;
    }
    public static void sighUp(UserService userService,Scanner scannerStr) {
        System.out.println("enter name");
        String name = scannerStr.next();
        System.out.println("enter username");
        String username = scannerStr.next();
        System.out.println("enter password");
        String password = scannerStr.next();
        User user1 = new User(name,username,password);
        int isDone = userService.add(user1);
        if(isDone==1)
        System.out.println("Congratulation sigh up is completed successfully...");
        else if (isDone==2)
            System.out.println("this profile is already...");

    }




}
