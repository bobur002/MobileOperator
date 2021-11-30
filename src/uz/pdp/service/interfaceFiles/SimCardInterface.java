package uz.pdp.service.interfaceFiles;

import uz.pdp.modul.MobileCompany;
import uz.pdp.modul.SimCard;
import uz.pdp.modul.Tariff;
import uz.pdp.modul.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public interface SimCardInterface extends BaseModelService<SimCard,Integer>{
    List<SimCard> simCardList = new ArrayList<>();

    void spendMin(SimCard simCard, MobileCompany mobileCompany);
    void spendSms(SimCard simCard, MobileCompany mobileCompany);
    void spendMb(SimCard simCard, MobileCompany mobileCompany);
    void fillBalance(SimCard simCard, double newBalance);
    void setTariffLimits(SimCard simCard, Tariff tariff, User user);
    SimCard getSimCard(UUID userId);
    boolean reActivated(SimCard simCard);


}
