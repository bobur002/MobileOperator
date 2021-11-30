package uz.pdp.modul;

import java.util.UUID;

public class MobileCompany extends BaseModel {
    private double minPrice;
    private double mbPrice;
    private double smsPrice;
    private double balance;


    public MobileCompany(String name, double minPrice, double mbPrice, double smsPrice) {
        super(name);
        this.minPrice=minPrice;
        this.mbPrice = mbPrice;
        this.smsPrice = smsPrice;
    }

    public double getMbPrice() {
        return mbPrice;
    }

    public void setMbPrice(double mbPrice) {
        this.mbPrice = mbPrice;
    }

    public double getSmsPrice() {
        return smsPrice;
    }

    public void setSmsPrice(double smsPrice) {
        this.smsPrice = smsPrice;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null || getClass() != obj.getClass()) return false;
        MobileCompany mobileCompany = (MobileCompany) obj;
        return name.equals(mobileCompany.name);
    }
}
