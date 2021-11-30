package uz.pdp.modul;

import java.util.Objects;
import java.util.UUID;

public class SimCard extends BaseModel{
    private String cardNumber;
    private int pinCode;
    private UUID tariffId;
    private UUID userId;
    private int simMin;
    private int simMb;
    private int simSms;
    private double balance;
    private UUID companyId;
    private Situation situation;

    public static class Situation{
        private int counter;
        private boolean isActive;

        public Situation() {
            counter=3;
            isActive=true;
        }

        public int getCounter() {
            return counter;
        }
        public void setCounter(int counter) {
            this.counter = counter;
        }
        public boolean isActive() {
            return isActive;
        }
        public void setActive(boolean active) {
            isActive = active;
        }

    }

    public SimCard( String cardNumber, int pinCode, UUID tariffId, UUID companyId) {
        this.cardNumber = cardNumber;
        this.pinCode = pinCode;
        this.tariffId = tariffId;
        this.companyId = companyId;
        this.situation = new Situation();
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public UUID getTariffId() {
        return tariffId;
    }

    public void setTariffId(UUID tariffId) {
        this.tariffId = tariffId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public int getSimMb() {
        return simMb;
    }

    public void setSimMb(int simMb) {
        this.simMb = simMb;
    }

    public int getSimSms() {
        return simSms;
    }

    public void setSimSms(int simSms) {
        this.simSms = simSms;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Situation getSituation() {
        return situation;
    }

    public void setSituation(Situation situation) {
        this.situation = situation;
    }

    public UUID getCompanyId() {
        return companyId;
    }

    public void setCompanyId(UUID companyId) {
        this.companyId = companyId;
    }

    public int getSimMin() {
        return simMin;
    }

    public void setSimMin(int simMin) {
        this.simMin = simMin;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SimCard simCard = (SimCard) o;
        return this.cardNumber.equals(simCard.cardNumber);
    }

}
