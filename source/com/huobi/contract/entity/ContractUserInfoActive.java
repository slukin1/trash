package com.huobi.contract.entity;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ContractUserInfoActive implements Serializable {
    private static final long serialVersionUID = 2667822717431461170L;
    @SerializedName("is_agree")
    private int agree;
    @SerializedName("is_agree_v2")
    private int agreeV2;
    @SerializedName("contract")
    private ContractActive contract;
    @SerializedName("has_trade")
    private int has_trade;
    @SerializedName("kyc_country")
    private String kycCountry;
    @SerializedName("kyc_state")
    private int kycState;
    @SerializedName("linear_swap")
    private ContractActive linearSwap;
    @SerializedName("option")
    private ContractActive option;
    @SerializedName("swap")
    private ContractActive swap;

    public boolean canEqual(Object obj) {
        return obj instanceof ContractUserInfoActive;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ContractUserInfoActive)) {
            return false;
        }
        ContractUserInfoActive contractUserInfoActive = (ContractUserInfoActive) obj;
        if (!contractUserInfoActive.canEqual(this) || getAgree() != contractUserInfoActive.getAgree() || getAgreeV2() != contractUserInfoActive.getAgreeV2()) {
            return false;
        }
        ContractActive contract2 = getContract();
        ContractActive contract3 = contractUserInfoActive.getContract();
        if (contract2 != null ? !contract2.equals(contract3) : contract3 != null) {
            return false;
        }
        ContractActive swap2 = getSwap();
        ContractActive swap3 = contractUserInfoActive.getSwap();
        if (swap2 != null ? !swap2.equals(swap3) : swap3 != null) {
            return false;
        }
        ContractActive linearSwap2 = getLinearSwap();
        ContractActive linearSwap3 = contractUserInfoActive.getLinearSwap();
        if (linearSwap2 != null ? !linearSwap2.equals(linearSwap3) : linearSwap3 != null) {
            return false;
        }
        ContractActive option2 = getOption();
        ContractActive option3 = contractUserInfoActive.getOption();
        if (option2 != null ? !option2.equals(option3) : option3 != null) {
            return false;
        }
        if (getHas_trade() != contractUserInfoActive.getHas_trade()) {
            return false;
        }
        String kycCountry2 = getKycCountry();
        String kycCountry3 = contractUserInfoActive.getKycCountry();
        if (kycCountry2 != null ? kycCountry2.equals(kycCountry3) : kycCountry3 == null) {
            return getKycState() == contractUserInfoActive.getKycState();
        }
        return false;
    }

    public int getAgree() {
        return this.agree;
    }

    public int getAgreeV2() {
        return this.agreeV2;
    }

    public ContractActive getContract() {
        return this.contract;
    }

    public int getHas_trade() {
        return this.has_trade;
    }

    public String getKycCountry() {
        return this.kycCountry;
    }

    public int getKycState() {
        return this.kycState;
    }

    public ContractActive getLinearSwap() {
        return this.linearSwap;
    }

    public ContractActive getOption() {
        return this.option;
    }

    public ContractActive getSwap() {
        return this.swap;
    }

    public int hashCode() {
        int agree2 = ((getAgree() + 59) * 59) + getAgreeV2();
        ContractActive contract2 = getContract();
        int i11 = 43;
        int hashCode = (agree2 * 59) + (contract2 == null ? 43 : contract2.hashCode());
        ContractActive swap2 = getSwap();
        int hashCode2 = (hashCode * 59) + (swap2 == null ? 43 : swap2.hashCode());
        ContractActive linearSwap2 = getLinearSwap();
        int hashCode3 = (hashCode2 * 59) + (linearSwap2 == null ? 43 : linearSwap2.hashCode());
        ContractActive option2 = getOption();
        int hashCode4 = (((hashCode3 * 59) + (option2 == null ? 43 : option2.hashCode())) * 59) + getHas_trade();
        String kycCountry2 = getKycCountry();
        int i12 = hashCode4 * 59;
        if (kycCountry2 != null) {
            i11 = kycCountry2.hashCode();
        }
        return ((i12 + i11) * 59) + getKycState();
    }

    public boolean isKycVerified() {
        return this.kycState == 2;
    }

    public void setAgree(int i11) {
        this.agree = i11;
    }

    public void setAgreeV2(int i11) {
        this.agreeV2 = i11;
    }

    public void setContract(ContractActive contractActive) {
        this.contract = contractActive;
    }

    public void setHas_trade(int i11) {
        this.has_trade = i11;
    }

    public void setKycCountry(String str) {
        this.kycCountry = str;
    }

    public void setKycState(int i11) {
        this.kycState = i11;
    }

    public void setLinearSwap(ContractActive contractActive) {
        this.linearSwap = contractActive;
    }

    public void setOption(ContractActive contractActive) {
        this.option = contractActive;
    }

    public void setSwap(ContractActive contractActive) {
        this.swap = contractActive;
    }

    public String toString() {
        return "ContractUserInfoActive(agree=" + getAgree() + ", agreeV2=" + getAgreeV2() + ", contract=" + getContract() + ", swap=" + getSwap() + ", linearSwap=" + getLinearSwap() + ", option=" + getOption() + ", has_trade=" + getHas_trade() + ", kycCountry=" + getKycCountry() + ", kycState=" + getKycState() + ")";
    }
}
