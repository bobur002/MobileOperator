package uz.pdp;


import uz.pdp.modul.MobileCompany;
import uz.pdp.modul.SimCard;
import uz.pdp.modul.Tariff;
import uz.pdp.modul.User;
import uz.pdp.service.MobileCompanyService;
import uz.pdp.service.SimCardService;
import uz.pdp.service.TariffService;
import uz.pdp.service.UserService;

import java.util.Scanner;

public class AdminPanel {

    public static void main(MobileCompanyService mobileCompanyService, UserService userService, TariffService tariffService, SimCardService simCardService, Scanner scannerStr, Scanner scannerInt){
        int stepCode= 1;
        while(stepCode!=0){
            System.out.println("---------------------------------------------");
            System.out.println("1.Mobile companies.\n2.Get Companies list.\n3.Create new mobile company.\n4.Get user list.\n0.Exit.");
            System.out.println("---------------------------------------------");
            stepCode = scannerInt.nextInt();
            switch (stepCode){
                case 1:
                    System.out.println("---------------------------------------------");
                    showCompanies(mobileCompanyService);
                    System.out.println("---------------------------------------------");
                    System.out.println("\nEnter mobile company name:");
                    String name = scannerStr.next();
                    MobileCompany mobileCompany = mobileCompanyService.getCompany(name);
                    companyPanel(mobileCompany,tariffService, simCardService, scannerStr, scannerInt);
                    break;
                case 2:
                    showCompanies(mobileCompanyService);
                    break;
                case 3:
                    System.out.println("Enter company name : ");
                    String name1 = scannerStr.next();
                    System.out.println("Enter company  min price");
                    double minPrice = scannerInt.nextDouble();
                    System.out.println("Enter company  sms price");
                    double smsPrice = scannerInt.nextDouble();
                    System.out.println("Enter company  mb price");
                    double mbPrice = scannerInt.nextDouble();
                    MobileCompany mobileCompany1 = new MobileCompany(name1, minPrice, mbPrice, smsPrice);
                    int a = mobileCompanyService.add(mobileCompany1);
                    if(a==1){
                        System.out.println("operation is done successfully");
                    }else {
                        System.out.println("this mobile company is already exist...");
                    }
                    break;
                case 4:
                    showUser(userService, simCardService, mobileCompanyService);
                    break;
            }
        }
    }
    public static void companyPanel(MobileCompany mobileCompany,TariffService tariffService, SimCardService simCardService, Scanner scannerStr, Scanner scannerInt){
        int stepCode= 1;
        while(stepCode!=0){
            System.out.println("---------------------------------------------");
            System.out.println("1.Tariff. \n2.Sim Cards.\n3.Get company balance.\n0.Exit.");
            System.out.println("---------------------------------------------");
            stepCode = scannerInt.nextInt();
            switch (stepCode){
                case 1:
                    tariffPanel(tariffService, mobileCompany, scannerStr, scannerInt);
                    break;
                case 2:
                    simCardPanel(mobileCompany,simCardService,tariffService, scannerStr, scannerInt);
                    break;
                case 3:
                    System.out.println("this company balance : " + mobileCompany.getBalance());
            }
        }
    }

    public static void tariffPanel(TariffService tariffService,MobileCompany mobileCompany, Scanner scannerStr, Scanner scannerInt){
        int stepCode= 1;
        while(stepCode!=0){
            System.out.println("---------------------------------------------");
            System.out.println("1.Get tariff list.\n2.Create new tariff.\n3.Rewrite tariff.");
            System.out.println("---------------------------------------------");
            stepCode = scannerInt.nextInt();
            switch (stepCode){
                case 1:
                    showTariff(tariffService,mobileCompany);
                    break;
                case 2:
                    System.out.println("enter tariff name");
                    String name = scannerStr.next();
                    System.out.println("enter perMonthPay");
                    double perMonthPay = scannerInt.nextDouble();
                    System.out.println("enter perMonthMin");
                    int perMonthMin = scannerStr.nextInt();
                    System.out.println("enter perMonthSms");
                    int perMonthMb = scannerStr.nextInt();
                    System.out.println("enter perMonthSms");
                    int perMonthSms = scannerStr.nextInt();
                    boolean isExist = tariffService.check(name);
                    if(!isExist){
                        Tariff tariff1 = new Tariff(name,perMonthPay,perMonthMin,perMonthMb,perMonthSms,mobileCompany.getId());
                        tariffService.add(tariff1);
                        System.out.println("operation is done successfully");
                    }else{
                        System.out.println("this tariff is already exist");
                    }
                    break;
                case 3:
                    System.out.println("---------------------------------------------");
                    showTariff(tariffService,mobileCompany);
                    System.out.println("---------------------------------------------");

                    System.out.println("\nenter tariff name");
                    String name2 = scannerStr.next();
                    boolean isExist2 = tariffService.check(name2);
                    if(isExist2){
                        System.out.println("enter new perMonthPay");
                        double perMonthPay2 = scannerInt.nextDouble();
                        System.out.println("enter new perMonthMin");
                        int perMonthMin2 = scannerStr.nextInt();
                        System.out.println("enter new perMonthSms");
                        int perMonthMb2 = scannerStr.nextInt();
                        System.out.println("enter new perMonthSms");
                        int perMonthSms2 = scannerStr.nextInt();

                        Tariff tariff1 = new Tariff(name2,perMonthPay2,perMonthMin2,perMonthMb2,perMonthSms2,mobileCompany.getId());
                        tariffService.rewriteTariff(tariff1);
                        System.out.println("operation is done successfully...");
                    }else{
                        System.out.println("this tariff is nor found...");
                    }
                    break;
            }
        }
    }
    public static void simCardPanel(MobileCompany mobileCompany, SimCardService simCardService,TariffService tariffService, Scanner scannerStr, Scanner scannerInt){
        int stepCode= 1;
        while(stepCode!=0){
            System.out.println("------------------------------------------------------");
            System.out.println("1.Get new Sim Card.\t2.Activate Sim Card.\t0.Exit.");
            System.out.println("------------------------------------------------------");
            stepCode = scannerInt.nextInt();
            switch (stepCode){
                case 1:
                    System.out.println("------------------------------------------------------");
                    showTariff(tariffService,mobileCompany);
                    System.out.println("------------------------------------------------------");

                    System.out.println("\nEnter tariff name");
                    String name2 = scannerStr.next();
                    Tariff tariff = tariffService.getTariff(name2);
                    System.out.println("Enter Sim Card number");
                    String cardNumber = scannerStr.next();
                    System.out.println("Enter Pin Code");
                    int cardPinCode = scannerInt.nextInt();
                    SimCard simCard = new SimCard(cardNumber,cardPinCode,tariff.getId(),mobileCompany.getId());
                    int done = simCardService.add(simCard);
                    if(done==1){
                        System.out.println("operation is done successfully...");
                    }else{
                        System.out.println("this Sim Card is already...");
                    }
                    break;
                case 2:
                    System.out.println("Enter Sim Card number");
                    String cardNumber1 = scannerStr.next();
                    SimCard simCard1 = simCardService.getSimCardNumber(cardNumber1);
                    simCard1.setSituation(new SimCard.Situation());
                    if (simCardService.reActivated(simCard1)) {
                        System.out.println("Operation is done successfully...");
                    }else{
                        System.out.println("This sim card is not found...");
                    }
                    break;
            }
        }
    }

    public static void showCompanies(MobileCompanyService mobileCompanyService){
        for (MobileCompany mobileCompany: mobileCompanyService.getList()) {
            System.out.println("Name : " + mobileCompany.getName() + "MB price : " + mobileCompany.getMbPrice() + "SMS price : " + mobileCompany.getSmsPrice());
        }
    }
    public static void showTariff(TariffService tariffService, MobileCompany mobileCompany){
        for (Tariff tariff: tariffService.getCompanyTariff(mobileCompany) ) {
                System.out.println("Nomi : "+tariff.getName()+"\toylik to`lov : "+tariff.getPerMonthPay()+"\toylik mb : "+tariff.getPerMonthMb()+"\toylik sms : "+tariff.getPerMonthSms());
        }
    }
    public static void showUser(UserService userService, SimCardService simCardService, MobileCompanyService mobileCompanyService){

        for (User user: userService.getList() ) {
            if (simCardService.getSimCard(user.getId())!=null)
            System.out.println("ismi : "+user.getName()+"\tMobile Company name : "+
                    mobileCompanyService.getCompany(simCardService.getSimCard(user.getId()).getCompanyId()).getName()+
                    "\tSimcard nomeri : "+simCardService.getSimCard(user.getId()).getCardNumber());
        }
    }

}