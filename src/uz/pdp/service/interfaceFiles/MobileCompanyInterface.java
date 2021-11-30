package uz.pdp.service.interfaceFiles;

import uz.pdp.modul.MobileCompany;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public interface MobileCompanyInterface extends BaseModelService<MobileCompany, Integer>{
    List<MobileCompany> companyList = new ArrayList<>();
    boolean check(MobileCompany mobileCompany);
    MobileCompany getCompany(String name);
    public MobileCompany getCompany(UUID id);
}
