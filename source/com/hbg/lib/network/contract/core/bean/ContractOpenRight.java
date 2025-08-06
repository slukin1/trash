package com.hbg.lib.network.contract.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ContractOpenRight implements Serializable {
    public static final int RIGHT_CLOSE = 0;
    public static final int RIGHT_OPEN = 1;
    private static final long serialVersionUID = -8981290183564127583L;
    @SerializedName("close_right")
    private int closeRight;
    @SerializedName("contract_code")
    private String contractCode;
    @SerializedName("kyc_country_code")
    private String kycCountryCode;
    private int right;

    public boolean canEqual(Object obj) {
        return obj instanceof ContractOpenRight;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ContractOpenRight)) {
            return false;
        }
        ContractOpenRight contractOpenRight = (ContractOpenRight) obj;
        if (!contractOpenRight.canEqual(this)) {
            return false;
        }
        String kycCountryCode2 = getKycCountryCode();
        String kycCountryCode3 = contractOpenRight.getKycCountryCode();
        if (kycCountryCode2 != null ? !kycCountryCode2.equals(kycCountryCode3) : kycCountryCode3 != null) {
            return false;
        }
        String contractCode2 = getContractCode();
        String contractCode3 = contractOpenRight.getContractCode();
        if (contractCode2 != null ? contractCode2.equals(contractCode3) : contractCode3 == null) {
            return getRight() == contractOpenRight.getRight() && getCloseRight() == contractOpenRight.getCloseRight();
        }
        return false;
    }

    public int getCloseRight() {
        return this.closeRight;
    }

    public String getContractCode() {
        return this.contractCode;
    }

    public String getKycCountryCode() {
        return this.kycCountryCode;
    }

    public int getRight() {
        return this.right;
    }

    public int hashCode() {
        String kycCountryCode2 = getKycCountryCode();
        int i11 = 43;
        int hashCode = kycCountryCode2 == null ? 43 : kycCountryCode2.hashCode();
        String contractCode2 = getContractCode();
        int i12 = (hashCode + 59) * 59;
        if (contractCode2 != null) {
            i11 = contractCode2.hashCode();
        }
        return ((((i12 + i11) * 59) + getRight()) * 59) + getCloseRight();
    }

    public void setCloseRight(int i11) {
        this.closeRight = i11;
    }

    public void setContractCode(String str) {
        this.contractCode = str;
    }

    public void setKycCountryCode(String str) {
        this.kycCountryCode = str;
    }

    public void setRight(int i11) {
        this.right = i11;
    }

    public String toString() {
        return "ContractOpenRight(kycCountryCode=" + getKycCountryCode() + ", contractCode=" + getContractCode() + ", right=" + getRight() + ", closeRight=" + getCloseRight() + ")";
    }
}
