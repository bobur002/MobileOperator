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

public class UserPanel {

    public static void main(User user, MobileCompanyService mobileCompanyService, TariffService tariffService, SimCardService simCardService, Scanner scannerStr, Scanner scannerInt){
        int stepCode= 1;
        while(stepCode!=0){
            int tries = 0;
            System.out.println("Enter sim card number:");
            String cardNumber = scannerInt.nextLine();
            SimCard simCard = simCardService.getSimCardNumber(cardNumber);
            if (!simCard.getSituation().isActive()){
                System.out.println("This sim card is blocked...");
                return;
            }
            System.out.println("Enter Pin Code :");
            int cardPin = scannerInt.nextInt();
            if (simCard.getPinCode()==cardPin) {
                MobileCompany mobileCompany = mobileCompanyService.getCompany(simCard.getCompanyId());
                System.out.println("---------------------------------------------------------------");
                System.out.println("1.Check balance.\t2.Call.\t3.Write SMS.\t" +
                        "4.Write Email.\t5.Get tariff\t6.Fill balance\t0.Exit");
                System.out.println("---------------------------------------------------------------");
                stepCode = scannerInt.nextInt();
                switch (stepCode) {
                    case 1:
                        System.out.println("---------------------------------------------------------------");
                        System.out.println("your balance :  " + simCard.getBalance());
                        System.out.println("your monthly min :  " + simCard.getSimMin());
                        System.out.println("your monthly sms :  " + simCard.getSimSms());
                        System.out.println("your monthly mb :  " + simCard.getSimMb());
                        System.out.println("---------------------------------------------------------------");
                        break;
                    case 2:
                        System.out.println("---------------------------------------------------------------");
                        System.out.println("Enter phone number:");
                        String phoneNumber = scannerStr.nextLine();
                        simCardService.spendMin(simCard,mobileCompany);
                        System.out.println("---------------------------------------------------------------");
                        break;
                    case 3:
                        System.out.println("---------------------------------------------------------------");
                        System.out.println("Enter sms phone number:");
                        String phoneNumber2 = scannerStr.nextLine();
                        simCardService.spendSms(simCard,mobileCompany);
                        System.out.println("---------------------------------------------------------------");
                        break;
                    case 4:
                        System.out.println("---------------------------------------------------------------");
                        System.out.println("Enter email address:");
                        String emailAddress = scannerStr.nextLine();
                        simCardService.spendMb(simCard,mobileCompany);
                        System.out.println("---------------------------------------------------------------");
                        break;
                    case 5:
                        System.out.println("---------------------------------------------------------------");
                        for (Tariff tariff: tariffService.getCompanyTariff(mobileCompany)) {
                            System.out.println("Nomi : "+tariff.getName()+"\toylik to`lov : "+tariff.getPerMonthPay()+
                                    "\toylik mb : "+tariff.getPerMonthMb()+"\toylik sms : "+tariff.getPerMonthSms());
                        }

                        System.out.println("Enter tariff name :");
                        String name = scannerStr.nextLine();
                        Tariff tariff = tariffService.getTariff(name);
                        simCardService.setTariffLimits(simCard,tariff,user);
                        simCard  = simCardService.getSimCard(simCard.getId());
                        System.out.println("---------------------------------------------------------------");
                        break;
                    case 6:
                        System.out.println("---------------------------------------------------------------");
                        System.out.println("Enter fill balance : ");
                        double newBalance = scannerInt.nextDouble();
                        simCardService.fillBalance(simCard,newBalance);
                        System.out.println("---------------------------------------------------------------");
                }
            }else{
                tries++;
                if (tries==3){
                    simCard.setSituation(new SimCard.Situation());
                    simCardService.reActivated(simCard);
                    return;
                }
            }
        }
    }
}
