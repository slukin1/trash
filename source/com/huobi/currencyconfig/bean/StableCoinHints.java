package com.huobi.currencyconfig.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class StableCoinHints implements Serializable {
    private static final long serialVersionUID = 9158210997994000843L;
    @SerializedName("currency")
    private String currency;
    @SerializedName("forbiddenHint")
    private String forbiddenHint;
    @SerializedName("inForbiddenHint")
    private String inForbiddenHint;
    @SerializedName("lang")
    private String lang;
    @SerializedName("normalHint")
    private String normalHint;
    @SerializedName("outForbiddenHint")
    private String outForbiddenHint;

    public boolean canEqual(Object obj) {
        return obj instanceof StableCoinHints;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StableCoinHints)) {
            return false;
        }
        StableCoinHints stableCoinHints = (StableCoinHints) obj;
        if (!stableCoinHints.canEqual(this)) {
            return false;
        }
        String currency2 = getCurrency();
        String currency3 = stableCoinHints.getCurrency();
        if (currency2 != null ? !currency2.equals(currency3) : currency3 != null) {
            return false;
        }
        String forbiddenHint2 = getForbiddenHint();
        String forbiddenHint3 = stableCoinHints.getForbiddenHint();
        if (forbiddenHint2 != null ? !forbiddenHint2.equals(forbiddenHint3) : forbiddenHint3 != null) {
            return false;
        }
        String lang2 = getLang();
        String lang3 = stableCoinHints.getLang();
        if (lang2 != null ? !lang2.equals(lang3) : lang3 != null) {
            return false;
        }
        String normalHint2 = getNormalHint();
        String normalHint3 = stableCoinHints.getNormalHint();
        if (normalHint2 != null ? !normalHint2.equals(normalHint3) : normalHint3 != null) {
            return false;
        }
        String inForbiddenHint2 = getInForbiddenHint();
        String inForbiddenHint3 = stableCoinHints.getInForbiddenHint();
        if (inForbiddenHint2 != null ? !inForbiddenHint2.equals(inForbiddenHint3) : inForbiddenHint3 != null) {
            return false;
        }
        String outForbiddenHint2 = getOutForbiddenHint();
        String outForbiddenHint3 = stableCoinHints.getOutForbiddenHint();
        return outForbiddenHint2 != null ? outForbiddenHint2.equals(outForbiddenHint3) : outForbiddenHint3 == null;
    }

    public String getCurrency() {
        return this.currency;
    }

    public String getForbiddenHint() {
        return this.forbiddenHint;
    }

    public String getInForbiddenHint() {
        return this.inForbiddenHint;
    }

    public String getLang() {
        return this.lang;
    }

    public String getNormalHint() {
        return this.normalHint;
    }

    public String getOutForbiddenHint() {
        return this.outForbiddenHint;
    }

    public int hashCode() {
        String currency2 = getCurrency();
        int i11 = 43;
        int hashCode = currency2 == null ? 43 : currency2.hashCode();
        String forbiddenHint2 = getForbiddenHint();
        int hashCode2 = ((hashCode + 59) * 59) + (forbiddenHint2 == null ? 43 : forbiddenHint2.hashCode());
        String lang2 = getLang();
        int hashCode3 = (hashCode2 * 59) + (lang2 == null ? 43 : lang2.hashCode());
        String normalHint2 = getNormalHint();
        int hashCode4 = (hashCode3 * 59) + (normalHint2 == null ? 43 : normalHint2.hashCode());
        String inForbiddenHint2 = getInForbiddenHint();
        int hashCode5 = (hashCode4 * 59) + (inForbiddenHint2 == null ? 43 : inForbiddenHint2.hashCode());
        String outForbiddenHint2 = getOutForbiddenHint();
        int i12 = hashCode5 * 59;
        if (outForbiddenHint2 != null) {
            i11 = outForbiddenHint2.hashCode();
        }
        return i12 + i11;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setForbiddenHint(String str) {
        this.forbiddenHint = str;
    }

    public void setInForbiddenHint(String str) {
        this.inForbiddenHint = str;
    }

    public void setLang(String str) {
        this.lang = str;
    }

    public void setNormalHint(String str) {
        this.normalHint = str;
    }

    public void setOutForbiddenHint(String str) {
        this.outForbiddenHint = str;
    }

    public String toString() {
        return "StableCoinHints(currency=" + getCurrency() + ", forbiddenHint=" + getForbiddenHint() + ", lang=" + getLang() + ", normalHint=" + getNormalHint() + ", inForbiddenHint=" + getInForbiddenHint() + ", outForbiddenHint=" + getOutForbiddenHint() + ")";
    }
}
