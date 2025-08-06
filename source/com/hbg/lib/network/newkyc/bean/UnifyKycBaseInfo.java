package com.hbg.lib.network.newkyc.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class UnifyKycBaseInfo implements Serializable {
    private static final long serialVersionUID = -2386253949241759564L;
    @SerializedName("cardNumber")
    private String cardNumber;
    @SerializedName("cardType")
    private int cardType;
    @SerializedName("countryId")
    private int countryId;
    @SerializedName("countryName")
    private String countryName;
    @SerializedName("firstName")
    private String firstName;
    @SerializedName("lastName")
    private String lastName;
    @SerializedName("middleName")
    private String middleName;

    public boolean canEqual(Object obj) {
        return obj instanceof UnifyKycBaseInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UnifyKycBaseInfo)) {
            return false;
        }
        UnifyKycBaseInfo unifyKycBaseInfo = (UnifyKycBaseInfo) obj;
        if (!unifyKycBaseInfo.canEqual(this)) {
            return false;
        }
        String cardNumber2 = getCardNumber();
        String cardNumber3 = unifyKycBaseInfo.getCardNumber();
        if (cardNumber2 != null ? !cardNumber2.equals(cardNumber3) : cardNumber3 != null) {
            return false;
        }
        if (getCardType() != unifyKycBaseInfo.getCardType() || getCountryId() != unifyKycBaseInfo.getCountryId()) {
            return false;
        }
        String countryName2 = getCountryName();
        String countryName3 = unifyKycBaseInfo.getCountryName();
        if (countryName2 != null ? !countryName2.equals(countryName3) : countryName3 != null) {
            return false;
        }
        String firstName2 = getFirstName();
        String firstName3 = unifyKycBaseInfo.getFirstName();
        if (firstName2 != null ? !firstName2.equals(firstName3) : firstName3 != null) {
            return false;
        }
        String lastName2 = getLastName();
        String lastName3 = unifyKycBaseInfo.getLastName();
        if (lastName2 != null ? !lastName2.equals(lastName3) : lastName3 != null) {
            return false;
        }
        String middleName2 = getMiddleName();
        String middleName3 = unifyKycBaseInfo.getMiddleName();
        return middleName2 != null ? middleName2.equals(middleName3) : middleName3 == null;
    }

    public String getCardNumber() {
        return this.cardNumber;
    }

    public int getCardType() {
        return this.cardType;
    }

    public int getCountryId() {
        return this.countryId;
    }

    public String getCountryName() {
        return this.countryName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getMiddleName() {
        return this.middleName;
    }

    public int hashCode() {
        String cardNumber2 = getCardNumber();
        int i11 = 43;
        int hashCode = (((((cardNumber2 == null ? 43 : cardNumber2.hashCode()) + 59) * 59) + getCardType()) * 59) + getCountryId();
        String countryName2 = getCountryName();
        int hashCode2 = (hashCode * 59) + (countryName2 == null ? 43 : countryName2.hashCode());
        String firstName2 = getFirstName();
        int hashCode3 = (hashCode2 * 59) + (firstName2 == null ? 43 : firstName2.hashCode());
        String lastName2 = getLastName();
        int hashCode4 = (hashCode3 * 59) + (lastName2 == null ? 43 : lastName2.hashCode());
        String middleName2 = getMiddleName();
        int i12 = hashCode4 * 59;
        if (middleName2 != null) {
            i11 = middleName2.hashCode();
        }
        return i12 + i11;
    }

    public void setCardNumber(String str) {
        this.cardNumber = str;
    }

    public void setCardType(int i11) {
        this.cardType = i11;
    }

    public void setCountryId(int i11) {
        this.countryId = i11;
    }

    public void setCountryName(String str) {
        this.countryName = str;
    }

    public void setFirstName(String str) {
        this.firstName = str;
    }

    public void setLastName(String str) {
        this.lastName = str;
    }

    public void setMiddleName(String str) {
        this.middleName = str;
    }

    public String toString() {
        return "UnifyKycBaseInfo(cardNumber=" + getCardNumber() + ", cardType=" + getCardType() + ", countryId=" + getCountryId() + ", countryName=" + getCountryName() + ", firstName=" + getFirstName() + ", lastName=" + getLastName() + ", middleName=" + getMiddleName() + ")";
    }
}
