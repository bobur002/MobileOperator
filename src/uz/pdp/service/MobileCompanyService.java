package uz.pdp.service;

import uz.pdp.modul.MobileCompany;
import uz.pdp.service.interfaceFiles.MobileCompanyInterface;

import java.util.List;
import java.util.UUID;

public class MobileCompanyService implements MobileCompanyInterface {
    @Override
    public Integer add(MobileCompany mobileCompany) {
        if (check(mobileCompany)) {
            return 2;
        }
        companyList.add(mobileCompany);
        return 1;
    }

    @Override
    public List<MobileCompany> getList() {
        return companyList;
    }

    @Override
    public boolean delete(MobileCompany mobileCompany) {
        for (int i=0; i<companyList.size(); i++){
            if(companyList.get(i).equals(mobileCompany)){
                companyList.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean check(MobileCompany mobileCompany) {
        for (MobileCompany cur:companyList ) {
            if(mobileCompany.getName().equals(cur.getName()))
                return true;
        }
        return false;
    }

    @Override
    public MobileCompany getCompany(String name) {
        for (MobileCompany cur : companyList ) {
            if (cur.getName().equals(name)) {
                return cur;
            }
        }
        return null;
    }
    @Override
    public MobileCompany getCompany(UUID id) {
        for (MobileCompany cur : companyList ) {
            if (cur.getId()==id) {
                return cur;
            }
        }
        return null;
    }
}
