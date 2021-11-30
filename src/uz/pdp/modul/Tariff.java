package uz.pdp.modul;

import java.util.Objects;
import java.util.UUID;

public class Tariff extends BaseModel{
    private double perMonthPay;
    private int perMonthMin;
    private int perMonthMb;
    private int perMonthSms;
    private UUID companyId;
 
    public Tariff(String name, double perMonthPay, int perMonthMin, int perMonthMb, int perMonthSms, UUID companyId) {
        super(name);
        this.perMonthMin=perMonthMin;
        this.perMonthPay = perMonthPay;
        this.perMonthMb = perMonthMb;
        this.perMonthSms = perMonthSms;
        this.companyId = companyId;
    }

    public double getPerMonthPay() {
        return perMonthPay;
    }

    public void setPerMonthPay(double perMonthPay) {
        this.perMonthPay = perMonthPay;
    }

    public int getPerMonthMin() {
        return perMonthMin;
    }

    public void setPerMonthMin(int perMonthMin) {
        this.perMonthMin = perMonthMin;
    }

    public int getPerMonthMb() {
        return perMonthMb;
    }

    public void setPerMonthMb(int perMonthMb) {
        this.perMonthMb = perMonthMb;
    }

    public int getPerMonthSms() {
        return perMonthSms;
    }

    public void setPerMonthSms(int perMonthSms) {
        this.perMonthSms = perMonthSms;
    }

    public UUID getCompanyId() {
        return companyId;
    }

    public void setCompanyId(UUID companyId) {
        this.companyId = companyId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Tariff tariff = (Tariff) o;
        return this.name==tariff.name;
    }
    
}
