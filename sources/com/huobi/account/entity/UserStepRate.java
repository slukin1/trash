package com.huobi.account.entity;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class UserStepRate implements Serializable {
    private static final long serialVersionUID = 5736987060796727302L;
    private String holdings;
    private int level;
    @SerializedName("maker-deduction")
    private String makerDeduction;
    @SerializedName("maker-fee-rate")
    private String makerFeeRate;
    @SerializedName("taker-deduction")
    private String takerDeduction;
    @SerializedName("taker-fee-rate")
    private String takerFeeRate;
    private String volume;

    public boolean canEqual(Object obj) {
        return obj instanceof UserStepRate;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UserStepRate)) {
            return false;
        }
        UserStepRate userStepRate = (UserStepRate) obj;
        if (!userStepRate.canEqual(this) || getLevel() != userStepRate.getLevel()) {
            return false;
        }
        String holdings2 = getHoldings();
        String holdings3 = userStepRate.getHoldings();
        if (holdings2 != null ? !holdings2.equals(holdings3) : holdings3 != null) {
            return false;
        }
        String volume2 = getVolume();
        String volume3 = userStepRate.getVolume();
        if (volume2 != null ? !volume2.equals(volume3) : volume3 != null) {
            return false;
        }
        String makerFeeRate2 = getMakerFeeRate();
        String makerFeeRate3 = userStepRate.getMakerFeeRate();
        if (makerFeeRate2 != null ? !makerFeeRate2.equals(makerFeeRate3) : makerFeeRate3 != null) {
            return false;
        }
        String makerDeduction2 = getMakerDeduction();
        String makerDeduction3 = userStepRate.getMakerDeduction();
        if (makerDeduction2 != null ? !makerDeduction2.equals(makerDeduction3) : makerDeduction3 != null) {
            return false;
        }
        String takerFeeRate2 = getTakerFeeRate();
        String takerFeeRate3 = userStepRate.getTakerFeeRate();
        if (takerFeeRate2 != null ? !takerFeeRate2.equals(takerFeeRate3) : takerFeeRate3 != null) {
            return false;
        }
        String takerDeduction2 = getTakerDeduction();
        String takerDeduction3 = userStepRate.getTakerDeduction();
        return takerDeduction2 != null ? takerDeduction2.equals(takerDeduction3) : takerDeduction3 == null;
    }

    public String getHoldings() {
        return this.holdings;
    }

    public int getLevel() {
        return this.level;
    }

    public String getMakerDeduction() {
        return this.makerDeduction;
    }

    public String getMakerFeeRate() {
        return this.makerFeeRate;
    }

    public String getTakerDeduction() {
        return this.takerDeduction;
    }

    public String getTakerFeeRate() {
        return this.takerFeeRate;
    }

    public String getVolume() {
        return this.volume;
    }

    public int hashCode() {
        String holdings2 = getHoldings();
        int i11 = 43;
        int level2 = ((getLevel() + 59) * 59) + (holdings2 == null ? 43 : holdings2.hashCode());
        String volume2 = getVolume();
        int hashCode = (level2 * 59) + (volume2 == null ? 43 : volume2.hashCode());
        String makerFeeRate2 = getMakerFeeRate();
        int hashCode2 = (hashCode * 59) + (makerFeeRate2 == null ? 43 : makerFeeRate2.hashCode());
        String makerDeduction2 = getMakerDeduction();
        int hashCode3 = (hashCode2 * 59) + (makerDeduction2 == null ? 43 : makerDeduction2.hashCode());
        String takerFeeRate2 = getTakerFeeRate();
        int hashCode4 = (hashCode3 * 59) + (takerFeeRate2 == null ? 43 : takerFeeRate2.hashCode());
        String takerDeduction2 = getTakerDeduction();
        int i12 = hashCode4 * 59;
        if (takerDeduction2 != null) {
            i11 = takerDeduction2.hashCode();
        }
        return i12 + i11;
    }

    public void setHoldings(String str) {
        this.holdings = str;
    }

    public void setLevel(int i11) {
        this.level = i11;
    }

    public void setMakerDeduction(String str) {
        this.makerDeduction = str;
    }

    public void setMakerFeeRate(String str) {
        this.makerFeeRate = str;
    }

    public void setTakerDeduction(String str) {
        this.takerDeduction = str;
    }

    public void setTakerFeeRate(String str) {
        this.takerFeeRate = str;
    }

    public void setVolume(String str) {
        this.volume = str;
    }

    public String toString() {
        return "UserStepRate(level=" + getLevel() + ", holdings=" + getHoldings() + ", volume=" + getVolume() + ", makerFeeRate=" + getMakerFeeRate() + ", makerDeduction=" + getMakerDeduction() + ", takerFeeRate=" + getTakerFeeRate() + ", takerDeduction=" + getTakerDeduction() + ")";
    }
}
