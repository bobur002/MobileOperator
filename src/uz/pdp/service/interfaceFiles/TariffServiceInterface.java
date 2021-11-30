package uz.pdp.service.interfaceFiles;

import uz.pdp.modul.MobileCompany;
import uz.pdp.modul.Tariff;

import java.util.ArrayList;
import java.util.List;

public interface TariffServiceInterface extends BaseModelService<Tariff,Integer>{
    List<Tariff> tariffList = new ArrayList<>();

    List<Tariff> getCompanyTariff(MobileCompany mobileCompany);
    Tariff getTariff(String name);
    boolean rewriteTariff(Tariff tariff);
    boolean check(String name);

}
