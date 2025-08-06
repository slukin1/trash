package com.huobi.entity;

import java.io.Serializable;

public class ExchangeCodes implements Serializable, Comparable<ExchangeCodes> {
    private static final long serialVersionUID = -4740887121728754626L;
    private boolean check;
    private String code;
    private int coinType;
    private String currency;
    private String currencyType;
    private String fastQuotation;
    private boolean isFutures;
    private int isHuobi;
    private String marketName;
    private String name;
    private String slowQuodation;
    private int tag;
    private String tradeName;

    public static boolean compareCode(ExchangeCodes exchangeCodes, String str) {
        if (exchangeCodes == null || str == null) {
            return false;
        }
        try {
            if (str.equals("")) {
                return false;
            }
            return exchangeCodes.code.equals(str);
        } catch (Exception e11) {
            e11.printStackTrace();
            return false;
        }
    }

    public String getCode() {
        return this.code;
    }

    public int getCoinType() {
        return this.coinType;
    }

    public String getCurrency() {
        return this.currency;
    }

    public String getCurrencyType() {
        return this.currencyType;
    }

    public String getFastQuotation() {
        return this.fastQuotation;
    }

    public int getIsHuobi() {
        return this.isHuobi;
    }

    public String getMarketName() {
        return this.marketName;
    }

    public String getName() {
        return this.name;
    }

    public String getSlowQuodation() {
        return this.slowQuodation;
    }

    public int getTag() {
        return this.tag;
    }

    public String getTradeName() {
        return this.tradeName;
    }

    public boolean isCheck() {
        return this.check;
    }

    public boolean isFutures() {
        return this.isFutures;
    }

    public void setCheck(boolean z11) {
        this.check = z11;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setCoinType(int i11) {
        this.coinType = i11;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setCurrencyType(String str) {
        this.currencyType = str;
    }

    public void setFastQuotation(String str) {
        this.fastQuotation = str;
    }

    public void setFutures(boolean z11) {
        this.isFutures = z11;
    }

    public void setIsHuobi(int i11) {
        this.isHuobi = i11;
    }

    public void setMarketName(String str) {
        this.marketName = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setSlowQuodation(String str) {
        this.slowQuodation = str;
    }

    public void setTag(int i11) {
        this.tag = i11;
    }

    public void setTradeName(String str) {
        this.tradeName = str;
    }

    public String toString() {
        return "ExchangeCodes [code=" + this.code + ", name=" + this.name + ", tradeName=" + this.tradeName + ", coinType=" + this.coinType + ", currencyType=" + this.currencyType + ", isHuobi=" + this.isHuobi + ", isFutures=" + this.isFutures + ", fastQuotation=" + this.fastQuotation + ", slowQuodation=" + this.slowQuodation + ", currency=" + this.currency + ", marketName=" + this.marketName + "]";
    }

    public int compareTo(ExchangeCodes exchangeCodes) {
        return this.tag < exchangeCodes.tag ? -1 : 1;
    }
}
