package com.hbg.lib.network.pro.core.bean;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import java.util.List;
import java.util.Locale;

public class CurrencyBean implements Serializable {
    private static final String ETP = "etp";
    private static final String FIAT_ASSETS = "fiatassets";
    private static final String HAD = "had";
    private static final String HADAX = "hadax";
    private static final String ST = "st";
    public static final String TAG_HIDDEN = "hidden";
    private static final long serialVersionUID = -6971369330154396126L;
    @SerializedName("at")
    private int assetType;
    private List<ChainInfo> chainInfos;
    @SerializedName("cd")
    private boolean countryDisabled;
    @SerializedName("cawt")
    private boolean currencyAddrWithTag;
    @SerializedName("de")
    private boolean depositEnabled;
    @SerializedName("dma")
    private String depositMinAmount;
    @SerializedName("dd")
    private String deposit_desc;
    @SerializedName("dn")
    private String displayName;
    @SerializedName("fc")
    private int fastConfirms;
    @SerializedName("ft")
    private String feeType;
    @SerializedName("fn")
    private String fullName;
    @SerializedName("cc")
    private String name;
    @SerializedName("sp")
    private String precision;
    @SerializedName("qc")
    private boolean quoteCurrency;
    @SerializedName("sc")
    private int safeConfirms;
    @SerializedName("state")
    private String state;
    @SerializedName("sdd")
    private String suspendDepositDesc;
    @SerializedName("svd")
    private String suspendVisibleDesc;
    @SerializedName("swd")
    private String suspendWithdrawDesc;
    private String tags;
    @SerializedName("v")
    private boolean visible;
    @SerializedName("w")
    private String weight;
    @SerializedName("whe")
    private boolean whiteEnabled;
    @SerializedName("wd")
    private String withdrawDesc;
    @SerializedName("wed")
    private boolean withdrawEnabled;
    @SerializedName("wma")
    private String withdrawMinAmount;
    @SerializedName("wp")
    private int withdrawPrecision;

    public List<ChainInfo> getChainInfos() {
        return this.chainInfos;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public String getFullName() {
        return this.fullName;
    }

    public String getName() {
        return this.name;
    }

    public String getPrecision() {
        return this.precision;
    }

    public String getState() {
        return this.state;
    }

    public String getSuspendVisibleDesc() {
        return this.suspendVisibleDesc;
    }

    public String getTags() {
        return this.tags;
    }

    public String getWeight() {
        return this.weight;
    }

    public boolean hasTag(String str) {
        if (!TextUtils.isEmpty(getTags()) && !TextUtils.isEmpty(str) && getTags().toLowerCase(Locale.US).contains(str)) {
            String[] split = getTags().split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            for (String equalsIgnoreCase : split) {
                if (str.equalsIgnoreCase(equalsIgnoreCase)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isCountryDisabled() {
        return this.countryDisabled;
    }

    public boolean isDepositEnabled() {
        List<ChainInfo> list = this.chainInfos;
        if (list == null || list.isEmpty()) {
            return false;
        }
        for (ChainInfo next : this.chainInfos) {
            if (next != null && next.getDepositEnable()) {
                return true;
            }
        }
        return false;
    }

    public boolean isEtpTag() {
        return !TextUtils.isEmpty(this.tags) && this.tags.toLowerCase(Locale.US).contains(ETP);
    }

    public boolean isFiatTag() {
        return !TextUtils.isEmpty(this.tags) && this.tags.toLowerCase(Locale.US).contains(FIAT_ASSETS);
    }

    public boolean isHadSt() {
        if (!TextUtils.isEmpty(getTags()) && getTags().toLowerCase(Locale.US).contains(HAD)) {
            String[] split = getTags().split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            for (String lowerCase : split) {
                if (HAD.equals(lowerCase.toLowerCase(Locale.US))) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isHadaxTag() {
        if (!TextUtils.isEmpty(getTags()) && getTags().toLowerCase(Locale.US).contains(HADAX)) {
            String[] split = getTags().split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            for (String lowerCase : split) {
                if (HADAX.equals(lowerCase.toLowerCase(Locale.US))) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isQuoteCurrency() {
        return this.quoteCurrency;
    }

    public boolean isStTag() {
        if (!TextUtils.isEmpty(getTags()) && getTags().toLowerCase(Locale.US).contains("st")) {
            String[] split = getTags().split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            for (String lowerCase : split) {
                if ("st".equals(lowerCase.toLowerCase(Locale.US))) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isVisible() {
        return this.visible;
    }

    public boolean isWhiteEnabled() {
        return this.whiteEnabled;
    }

    public boolean isWithdrawEnabled() {
        List<ChainInfo> list = this.chainInfos;
        if (list == null || list.isEmpty()) {
            return false;
        }
        for (ChainInfo next : this.chainInfos) {
            if (next != null && next.getWithdrawEnable()) {
                return true;
            }
        }
        return false;
    }

    public void setChainInfos(List<ChainInfo> list) {
        this.chainInfos = list;
    }

    public void setCountryDisabled(boolean z11) {
        this.countryDisabled = z11;
    }

    public void setDisplayName(String str) {
        this.displayName = str;
    }

    public void setFullName(String str) {
        this.fullName = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPrecision(String str) {
        this.precision = str;
    }

    public void setQuoteCurrency(boolean z11) {
        this.quoteCurrency = z11;
    }

    public void setState(String str) {
        this.state = str;
    }

    public void setSuspendVisibleDesc(String str) {
        this.suspendVisibleDesc = str;
    }

    public void setTags(String str) {
        this.tags = str;
    }

    public void setVisible(boolean z11) {
        this.visible = z11;
    }

    public void setWeight(String str) {
        this.weight = str;
    }

    public void setWhiteEnabled(boolean z11) {
        this.whiteEnabled = z11;
    }
}
