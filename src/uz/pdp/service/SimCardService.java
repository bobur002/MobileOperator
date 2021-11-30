package uz.pdp.service;

import uz.pdp.modul.MobileCompany;
import uz.pdp.modul.SimCard;
import uz.pdp.modul.Tariff;
import uz.pdp.modul.User;
import uz.pdp.service.interfaceFiles.MobileCompanyInterface;
import uz.pdp.service.interfaceFiles.SimCardInterface;

import java.util.List;
import java.util.UUID;

public class SimCardService implements SimCardInterface {

    @Override
    public Integer add(SimCard simCard) {
        for (SimCard cur: simCardList) {
            if(cur.equals(simCard))
                return 2;
        }
        simCardList.add(simCard);
        return 1;
    }

    @Override
    public List<SimCard> getList() {
        return simCardList;
    }

    @Override
    public void setTariffLimits(SimCard simCard, Tariff tariff, User user) {
        for (int i=0; i<simCardList.size(); i++ ) {
            if(simCardList.get(i).equals(simCard)){
                simCardList.get(i).setSimMb(tariff.getPerMonthMb()+simCardList.get(i).getSimMb());
                simCardList.get(i).setSimMb(tariff.getPerMonthMb()+simCardList.get(i).getSimMb());
                simCardList.get(i).setSimSms(tariff.getPerMonthMb()+simCardList.get(i).getSimSms());
                simCardList.get(i).setBalance(simCardList.get(i).getBalance()-tariff.getPerMonthPay());
                simCardList.get(i).setTariffId(tariff.getId());
                simCardList.get(i).setUserId(user.getId());
                for (int j=0; j<MobileCompanyService.companyList.size(); j++ ) {
                    if(MobileCompanyService.companyList.get(j).getId()==simCard.getCompanyId()) {
                        MobileCompanyService.companyList.get(j).setBalance(MobileCompanyService.companyList.get(j).getBalance()+ tariff.getPerMonthPay());
                        return;
                    }
                }
                return;
            }
        }
    }

    @Override
    public boolean delete(SimCard simCard) {
        return false;
    }

    @Override
    public void spendMin(SimCard simCard, MobileCompany mobileCompany) {
        for (int i=0; i<simCardList.size(); i++ ) {
            if(simCardList.get(i).equals(simCard)){
                simCardList.get(i).setSimSms(simCardList.get(i).getSimSms()-1);
                if (simCardList.get(i).getSimSms()==-1){
                    simCardList.get(i).setSimSms(0);
                    simCardList.get(i).setBalance(simCardList.get(i).getBalance()- mobileCompany.getMinPrice());
                    mobileCompany.setBalance(mobileCompany.getBalance()+mobileCompany.getMinPrice());
                    for (int j=0; j<MobileCompanyService.companyList.size(); j++ ) {
                        if(MobileCompanyService.companyList.get(j).equals(mobileCompany)) {
                            MobileCompanyService.companyList.set(j, mobileCompany);
                            return;
                        }
                    }
                }
            }
        }
    }

    @Override
    public void spendSms(SimCard simCard, MobileCompany mobileCompany) {
        for (int i=0; i<simCardList.size(); i++ ) {
            if(simCardList.get(i).equals(simCard)){
                simCardList.get(i).setSimSms(simCardList.get(i).getSimSms()-1);
                if (simCardList.get(i).getSimSms()==-1){
                    simCardList.get(i).setSimSms(0);
                    simCardList.get(i).setBalance(simCardList.get(i).getBalance()- mobileCompany.getSmsPrice());
                    mobileCompany.setBalance(mobileCompany.getBalance()+mobileCompany.getSmsPrice());
                    for (int j=0; j<MobileCompanyService.companyList.size(); j++ ) {
                        if(MobileCompanyService.companyList.get(j).equals(mobileCompany)) {
                            MobileCompanyService.companyList.set(j, mobileCompany);
                            return;
                        }
                    }
                }
                return;
            }
        }
    }

    @Override
    public void spendMb(SimCard simCard, MobileCompany mobileCompany) {
        for (int i=0; i<simCardList.size(); i++ ) {
            if(simCardList.get(i).equals(simCard)){
                simCardList.get(i).setSimMb(simCardList.get(i).getSimMb()-1);
                if (simCardList.get(i).getSimMb()==-1){
                    simCardList.get(i).setSimMb(0);
                    simCardList.get(i).setBalance(simCardList.get(i).getBalance()- mobileCompany.getMbPrice());
                    mobileCompany.setBalance(mobileCompany.getBalance()+mobileCompany.getMbPrice());
                    for (int j=0; j<MobileCompanyService.companyList.size(); j++ ) {
                        if(MobileCompanyService.companyList.get(j).equals(mobileCompany)) {
                            MobileCompanyService.companyList.set(j, mobileCompany);
                            return;
                        }
                    }
                }
                return;
            }
        }
    }

    @Override
    public void fillBalance(SimCard simCard, double newBalance) {
        for (int i=0; i<simCardList.size(); i++ ) {
            if(simCardList.get(i).equals(simCard)){
                simCardList.get(i).setBalance(simCardList.get(i).getBalance()+newBalance);
                return;
            }
        }
    }

    @Override
    public SimCard getSimCard(UUID userId) {
        for (SimCard simCard: simCardList) {
            if(simCard.getUserId()==userId)
                return simCard;
        }
        return null;
    }

    public SimCard getSimCardNumber(String cardNumber){
        for (SimCard simCard: simCardList) {
            if(simCard.getCardNumber().equals(cardNumber))
                return simCard;
        }
        return null;
    }

    @Override
    public boolean reActivated(SimCard simCard) {
        int index = 0;
        for (SimCard cur: simCardList) {
            if (cur.equals(simCard)) {
                simCardList.set(index,simCard);
                return true;
            }
            index++;
        }
        return false;
    }
}
