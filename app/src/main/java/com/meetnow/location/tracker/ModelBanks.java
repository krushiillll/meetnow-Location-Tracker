package com.meetnow.location.tracker;

public class ModelBanks {

    String strBankName, strBalance, strCustomerCare, strMiniStatement;
    int icon;

    public ModelBanks(String strBankName, String strBalance, String strCustomerCare, int icon, String strMiniStatement) {
        this.strBankName = strBankName;
        this.strBalance = strBalance;
        this.strCustomerCare = strCustomerCare;
        this.icon = icon;
        this.strMiniStatement = strMiniStatement;
    }

    public String getStrBankName() {
        return strBankName;
    }

    public void setStrBankName(String strBankName) {
        this.strBankName = strBankName;
    }

    public String getStrBalance() {
        return strBalance;
    }

    public void setStrBalance(String strBalance) {
        this.strBalance = strBalance;
    }

    public String getStrCustomerCare() {
        return strCustomerCare;
    }

    public void setStrCustomerCare(String strCustomerCare) {
        this.strCustomerCare = strCustomerCare;
    }

    public String getStrMiniStatement() {
        return strMiniStatement;
    }

    public void setStrMiniStatement(String strMiniStatement) {
        this.strMiniStatement = strMiniStatement;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
