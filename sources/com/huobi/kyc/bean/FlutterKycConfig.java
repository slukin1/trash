package com.huobi.kyc.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class FlutterKycConfig implements Serializable {
    private static final long serialVersionUID = 9194912249137364360L;
    @SerializedName("accountName")
    private String accountName;
    @SerializedName("authBizCode")
    private String authBizCode;
    @SerializedName("cnyCurrencyRate")
    private String cnyCurrencyRate;
    @SerializedName("country_id")
    private String countryId;
    @SerializedName("curCurrencyRate")
    private String curCurrencyRate;
    @SerializedName("currencyUnit")
    private String currencyUnit;
    @SerializedName("email")
    private String email;
    @SerializedName("phone")
    private String phone;
    @SerializedName("source")
    private String source = "0";

    public boolean canEqual(Object obj) {
        return obj instanceof FlutterKycConfig;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FlutterKycConfig)) {
            return false;
        }
        FlutterKycConfig flutterKycConfig = (FlutterKycConfig) obj;
        if (!flutterKycConfig.canEqual(this)) {
            return false;
        }
        String countryId2 = getCountryId();
        String countryId3 = flutterKycConfig.getCountryId();
        if (countryId2 != null ? !countryId2.equals(countryId3) : countryId3 != null) {
            return false;
        }
        String phone2 = getPhone();
        String phone3 = flutterKycConfig.getPhone();
        if (phone2 != null ? !phone2.equals(phone3) : phone3 != null) {
            return false;
        }
        String email2 = getEmail();
        String email3 = flutterKycConfig.getEmail();
        if (email2 != null ? !email2.equals(email3) : email3 != null) {
            return false;
        }
        String accountName2 = getAccountName();
        String accountName3 = flutterKycConfig.getAccountName();
        if (accountName2 != null ? !accountName2.equals(accountName3) : accountName3 != null) {
            return false;
        }
        String authBizCode2 = getAuthBizCode();
        String authBizCode3 = flutterKycConfig.getAuthBizCode();
        if (authBizCode2 != null ? !authBizCode2.equals(authBizCode3) : authBizCode3 != null) {
            return false;
        }
        String source2 = getSource();
        String source3 = flutterKycConfig.getSource();
        if (source2 != null ? !source2.equals(source3) : source3 != null) {
            return false;
        }
        String curCurrencyRate2 = getCurCurrencyRate();
        String curCurrencyRate3 = flutterKycConfig.getCurCurrencyRate();
        if (curCurrencyRate2 != null ? !curCurrencyRate2.equals(curCurrencyRate3) : curCurrencyRate3 != null) {
            return false;
        }
        String cnyCurrencyRate2 = getCnyCurrencyRate();
        String cnyCurrencyRate3 = flutterKycConfig.getCnyCurrencyRate();
        if (cnyCurrencyRate2 != null ? !cnyCurrencyRate2.equals(cnyCurrencyRate3) : cnyCurrencyRate3 != null) {
            return false;
        }
        String currencyUnit2 = getCurrencyUnit();
        String currencyUnit3 = flutterKycConfig.getCurrencyUnit();
        return currencyUnit2 != null ? currencyUnit2.equals(currencyUnit3) : currencyUnit3 == null;
    }

    public String getAccountName() {
        return this.accountName;
    }

    public String getAuthBizCode() {
        return this.authBizCode;
    }

    public String getCnyCurrencyRate() {
        return this.cnyCurrencyRate;
    }

    public String getCountryId() {
        return this.countryId;
    }

    public String getCurCurrencyRate() {
        return this.curCurrencyRate;
    }

    public String getCurrencyUnit() {
        return this.currencyUnit;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getSource() {
        return this.source;
    }

    public int hashCode() {
        String countryId2 = getCountryId();
        int i11 = 43;
        int hashCode = countryId2 == null ? 43 : countryId2.hashCode();
        String phone2 = getPhone();
        int hashCode2 = ((hashCode + 59) * 59) + (phone2 == null ? 43 : phone2.hashCode());
        String email2 = getEmail();
        int hashCode3 = (hashCode2 * 59) + (email2 == null ? 43 : email2.hashCode());
        String accountName2 = getAccountName();
        int hashCode4 = (hashCode3 * 59) + (accountName2 == null ? 43 : accountName2.hashCode());
        String authBizCode2 = getAuthBizCode();
        int hashCode5 = (hashCode4 * 59) + (authBizCode2 == null ? 43 : authBizCode2.hashCode());
        String source2 = getSource();
        int hashCode6 = (hashCode5 * 59) + (source2 == null ? 43 : source2.hashCode());
        String curCurrencyRate2 = getCurCurrencyRate();
        int hashCode7 = (hashCode6 * 59) + (curCurrencyRate2 == null ? 43 : curCurrencyRate2.hashCode());
        String cnyCurrencyRate2 = getCnyCurrencyRate();
        int hashCode8 = (hashCode7 * 59) + (cnyCurrencyRate2 == null ? 43 : cnyCurrencyRate2.hashCode());
        String currencyUnit2 = getCurrencyUnit();
        int i12 = hashCode8 * 59;
        if (currencyUnit2 != null) {
            i11 = currencyUnit2.hashCode();
        }
        return i12 + i11;
    }

    public void setAccountName(String str) {
        this.accountName = str;
    }

    public void setAuthBizCode(String str) {
        this.authBizCode = str;
    }

    public void setCnyCurrencyRate(String str) {
        this.cnyCurrencyRate = str;
    }

    public void setCountryId(String str) {
        this.countryId = str;
    }

    public void setCurCurrencyRate(String str) {
        this.curCurrencyRate = str;
    }

    public void setCurrencyUnit(String str) {
        this.currencyUnit = str;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public void setPhone(String str) {
        this.phone = str;
    }

    public void setSource(String str) {
        this.source = str;
    }

    public String toString() {
        return "FlutterKycConfig(countryId=" + getCountryId() + ", phone=" + getPhone() + ", email=" + getEmail() + ", accountName=" + getAccountName() + ", authBizCode=" + getAuthBizCode() + ", source=" + getSource() + ", curCurrencyRate=" + getCurCurrencyRate() + ", cnyCurrencyRate=" + getCnyCurrencyRate() + ", currencyUnit=" + getCurrencyUnit() + ")";
    }
}
