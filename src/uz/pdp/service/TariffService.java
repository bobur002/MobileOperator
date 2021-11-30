package uz.pdp.service;

import uz.pdp.modul.MobileCompany;
import uz.pdp.modul.Tariff;
import uz.pdp.service.interfaceFiles.TariffServiceInterface;

import java.util.ArrayList;
import java.util.List;

public class TariffService implements TariffServiceInterface {
    @Override
    public Integer add(Tariff tariff) {
        if (!check(tariff.getName())) {
            tariffList.add(tariff);
            return 2;
        }
        tariffList.add(tariff);
        return 1;
    }

    @Override
    public List<Tariff> getList() {
        return tariffList;
    }

    @Override
    public Tariff getTariff(String name) {
        for (Tariff tariff : tariffList) {
            if(tariff.getName().equals(name));
            return tariff;
        }
        return null;
    }

    @Override
    public boolean rewriteTariff(Tariff tariff) {
        for (int i=0; i<tariffList.size(); i++) {
            if(tariffList.get(i).getName().equals(tariff.getName())) {
                tariffList.set(i, tariff);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Tariff> getCompanyTariff(MobileCompany mobileCompany) {
        List<Tariff> companyTariffList = new ArrayList<>();
        for (Tariff tariff : tariffList) {
            if(tariff.getCompanyId().equals(mobileCompany.getId()));
                companyTariffList.add(tariff);
        }
        return companyTariffList;
    }

    @Override
    public boolean check(String name) {
        for (Tariff tariff1:  TariffServiceInterface.tariffList ) {
            if(tariff1.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(Tariff tariff) {
        return false;
    }
}
