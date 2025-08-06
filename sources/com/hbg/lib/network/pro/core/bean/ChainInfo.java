package com.hbg.lib.network.pro.core.bean;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ChainInfo implements Serializable, Comparable<ChainInfo> {
    public static final int CHAIN_IS_DEFAULT = 1;
    public static final int CHAIN_NOT_DEFAULT = 0;
    public static final String CHAIN_TYPE_LEGAL = "legal";
    public static final String CHAIN_TYPE_LIVE = "live";
    public static final String CHAIN_TYPE_NEW = "new";
    public static final String CHAIN_TYPE_OLD = "old";
    public static final String CHAIN_TYPE_PLAIN = "plain";
    public static final String CHAIN_TYPE_TOO_OLD = "tooold";
    private static final long serialVersionUID = 3455051214784666167L;
    @SerializedName("ao")
    private boolean addrOneoff;
    @SerializedName("awt")
    private boolean addrWithTag;
    @SerializedName("adt")
    private boolean addrdepositTag;
    @SerializedName("ac")
    private String addressChain;
    private String chain;
    @SerializedName("ct")
    private String chainType;
    private String code;
    @SerializedName("ca")
    private String contractAddress;
    @SerializedName("cct")
    private int contractChainType;
    private String currency;
    @SerializedName("deposit-desc")
    private String depositDesc;
    @SerializedName("de")
    private boolean depositEnable;
    @SerializedName("dma")
    private String depositMinAmount;
    @SerializedName("deposit-tips-desc")
    private String depositTipsDesc;
    @SerializedName("dn")
    private String displayName;
    @SerializedName("fc")
    private int fastConfirms;
    @SerializedName("ft")
    private String feeType;
    @SerializedName("fn")
    private String fullName;

    /* renamed from: id  reason: collision with root package name */
    private Long f70610id;
    @SerializedName("default")
    private int isDefault;
    @SerializedName("replace-chain-info-desc")
    private String replaceChainInfoDesc;
    @SerializedName("replace-chain-notification-desc")
    private String replaceChainNotificationDesc;
    @SerializedName("replace-chain-popup-desc")
    private String replaceChainPopupDesc;
    @SerializedName("sc")
    private int safeConfirms;
    @SerializedName("sda")
    private String suspendDepositAnnouncement;
    @SerializedName("suspend-deposit-desc")
    private String suspendDepositDesc;
    @SerializedName("swa")
    private String suspendWithdrawAnnouncement;
    @SerializedName("suspend-withdraw-desc")
    private String suspendWithdrawDesc;
    @SerializedName("v")
    private boolean visible;
    @SerializedName("withdraw-desc")
    private String withdrawDesc;
    @SerializedName("we")
    private boolean withdrawEnable;
    @SerializedName("wma")
    private String withdrawMinAmount;
    @SerializedName("wp")
    private int withdrawPrecision;
    @SerializedName("withdraw-tips-desc")
    private String withdrawTipsDesc;

    public ChainInfo(Long l11, String str, String str2, String str3, String str4, int i11, String str5, String str6, boolean z11, boolean z12, int i12, String str7, String str8, String str9, String str10, boolean z13, boolean z14, boolean z15, int i13, int i14, boolean z16, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19) {
        this.f70610id = l11;
        this.chainType = str;
        this.chain = str2;
        this.currency = str3;
        this.addressChain = str4;
        this.isDefault = i11;
        this.depositMinAmount = str5;
        this.withdrawMinAmount = str6;
        this.depositEnable = z11;
        this.withdrawEnable = z12;
        this.withdrawPrecision = i12;
        this.feeType = str7;
        this.code = str8;
        this.displayName = str9;
        this.fullName = str10;
        this.addrWithTag = z13;
        this.addrdepositTag = z14;
        this.addrOneoff = z15;
        this.fastConfirms = i13;
        this.safeConfirms = i14;
        this.visible = z16;
        this.depositDesc = str11;
        this.withdrawDesc = str12;
        this.suspendDepositDesc = str13;
        this.suspendWithdrawDesc = str14;
        this.replaceChainInfoDesc = str15;
        this.replaceChainNotificationDesc = str16;
        this.replaceChainPopupDesc = str17;
        this.depositTipsDesc = str18;
        this.withdrawTipsDesc = str19;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChainInfo)) {
            return false;
        }
        ChainInfo chainInfo = (ChainInfo) obj;
        if (!TextUtils.equals(this.chainType, chainInfo.chainType) || !TextUtils.equals(this.chain, chainInfo.chain) || !TextUtils.equals(this.currency, chainInfo.currency)) {
            return false;
        }
        return true;
    }

    public boolean getAddrOneoff() {
        return this.addrOneoff;
    }

    public boolean getAddrWithTag() {
        return this.addrWithTag;
    }

    public boolean getAddrdepositTag() {
        return this.addrdepositTag;
    }

    public String getAddressChain() {
        return this.addressChain;
    }

    public String getChain() {
        return this.chain;
    }

    public String getChainType() {
        return this.chainType;
    }

    public String getCode() {
        return this.code;
    }

    public String getContractAddress() {
        return this.contractAddress;
    }

    public int getContractChainType() {
        return this.contractChainType;
    }

    public String getCurrency() {
        return this.currency;
    }

    public String getDepositDesc() {
        return this.depositDesc;
    }

    public boolean getDepositEnable() {
        return this.depositEnable;
    }

    public String getDepositMinAmount() {
        return this.depositMinAmount;
    }

    public String getDepositTipsDesc() {
        return this.depositTipsDesc;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public int getFastConfirms() {
        return this.fastConfirms;
    }

    public String getFeeType() {
        return this.feeType;
    }

    public String getFullName() {
        return this.fullName;
    }

    public Long getId() {
        return this.f70610id;
    }

    public int getIsDefault() {
        return this.isDefault;
    }

    public String getReplaceChainInfoDesc() {
        return this.replaceChainInfoDesc;
    }

    public String getReplaceChainNotificationDesc() {
        return this.replaceChainNotificationDesc;
    }

    public String getReplaceChainPopupDesc() {
        return this.replaceChainPopupDesc;
    }

    public int getSafeConfirms() {
        return this.safeConfirms;
    }

    public String getSuspendDepositAnnouncement() {
        return this.suspendDepositAnnouncement;
    }

    public String getSuspendDepositDesc() {
        return this.suspendDepositDesc;
    }

    public String getSuspendWithdrawAnnouncement() {
        return this.suspendWithdrawAnnouncement;
    }

    public String getSuspendWithdrawDesc() {
        return this.suspendWithdrawDesc;
    }

    public boolean getVisible() {
        return this.visible;
    }

    public String getWithdrawDesc() {
        return this.withdrawDesc;
    }

    public boolean getWithdrawEnable() {
        return this.withdrawEnable;
    }

    public String getWithdrawMinAmount() {
        return this.withdrawMinAmount;
    }

    public int getWithdrawPrecision() {
        return this.withdrawPrecision;
    }

    public String getWithdrawTipsDesc() {
        return this.withdrawTipsDesc;
    }

    public int hashCode() {
        return (((this.chainType.hashCode() * 31) + this.chain.hashCode()) * 31) + this.currency.hashCode();
    }

    public boolean isDefaultChain() {
        return this.isDefault == 1;
    }

    public boolean isIgnoreChainType() {
        String str = this.chainType;
        return str == null || CHAIN_TYPE_TOO_OLD.equals(str) || CHAIN_TYPE_LEGAL.equals(this.chainType) || !this.visible;
    }

    public void reloadAllDesc(ChainInfo chainInfo) {
        if (chainInfo != null) {
            if (TextUtils.isEmpty(getDepositDesc())) {
                setDepositDesc(chainInfo.getDepositDesc());
            }
            if (TextUtils.isEmpty(getWithdrawDesc())) {
                setWithdrawDesc(chainInfo.getWithdrawDesc());
            }
            if (TextUtils.isEmpty(getSuspendDepositDesc())) {
                setSuspendDepositDesc(chainInfo.getSuspendDepositDesc());
            }
            if (TextUtils.isEmpty(getSuspendWithdrawDesc())) {
                setSuspendWithdrawDesc(chainInfo.getSuspendWithdrawDesc());
            }
            if (TextUtils.isEmpty(getReplaceChainPopupDesc())) {
                setReplaceChainPopupDesc(chainInfo.getReplaceChainPopupDesc());
            }
            if (TextUtils.isEmpty(getReplaceChainNotificationDesc())) {
                setReplaceChainNotificationDesc(chainInfo.getReplaceChainNotificationDesc());
            }
            if (TextUtils.isEmpty(getReplaceChainInfoDesc())) {
                setReplaceChainInfoDesc(chainInfo.getReplaceChainInfoDesc());
            }
        }
    }

    public void setAddrOneoff(boolean z11) {
        this.addrOneoff = z11;
    }

    public void setAddrWithTag(boolean z11) {
        this.addrWithTag = z11;
    }

    public void setAddrdepositTag(boolean z11) {
        this.addrdepositTag = z11;
    }

    public void setAddressChain(String str) {
        this.addressChain = str;
    }

    public void setChain(String str) {
        this.chain = str;
    }

    public void setChainType(String str) {
        this.chainType = str;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setContractAddress(String str) {
        this.contractAddress = str;
    }

    public void setContractChainType(int i11) {
        this.contractChainType = i11;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setDepositDesc(String str) {
        this.depositDesc = str;
    }

    public void setDepositEnable(boolean z11) {
        this.depositEnable = z11;
    }

    public void setDepositMinAmount(String str) {
        this.depositMinAmount = str;
    }

    public void setDepositTipsDesc(String str) {
        this.depositTipsDesc = str;
    }

    public void setDisplayName(String str) {
        this.displayName = str;
    }

    public void setFastConfirms(int i11) {
        this.fastConfirms = i11;
    }

    public void setFeeType(String str) {
        this.feeType = str;
    }

    public void setFullName(String str) {
        this.fullName = str;
    }

    public void setId(Long l11) {
        this.f70610id = l11;
    }

    public void setIsDefault(int i11) {
        this.isDefault = i11;
    }

    public void setReplaceChainInfoDesc(String str) {
        this.replaceChainInfoDesc = str;
    }

    public void setReplaceChainNotificationDesc(String str) {
        this.replaceChainNotificationDesc = str;
    }

    public void setReplaceChainPopupDesc(String str) {
        this.replaceChainPopupDesc = str;
    }

    public void setSafeConfirms(int i11) {
        this.safeConfirms = i11;
    }

    public void setSuspendDepositAnnouncement(String str) {
        this.suspendDepositAnnouncement = str;
    }

    public void setSuspendDepositDesc(String str) {
        this.suspendDepositDesc = str;
    }

    public void setSuspendWithdrawAnnouncement(String str) {
        this.suspendWithdrawAnnouncement = str;
    }

    public void setSuspendWithdrawDesc(String str) {
        this.suspendWithdrawDesc = str;
    }

    public void setVisible(boolean z11) {
        this.visible = z11;
    }

    public void setWithdrawDesc(String str) {
        this.withdrawDesc = str;
    }

    public void setWithdrawEnable(boolean z11) {
        this.withdrawEnable = z11;
    }

    public void setWithdrawMinAmount(String str) {
        this.withdrawMinAmount = str;
    }

    public void setWithdrawPrecision(int i11) {
        this.withdrawPrecision = i11;
    }

    public void setWithdrawTipsDesc(String str) {
        this.withdrawTipsDesc = str;
    }

    public String toString() {
        return "ChainInfo(id=" + getId() + ", chainType=" + getChainType() + ", contractChainType=" + getContractChainType() + ", contractAddress=" + getContractAddress() + ", chain=" + getChain() + ", currency=" + getCurrency() + ", addressChain=" + getAddressChain() + ", isDefault=" + getIsDefault() + ", depositMinAmount=" + getDepositMinAmount() + ", withdrawMinAmount=" + getWithdrawMinAmount() + ", depositEnable=" + getDepositEnable() + ", withdrawEnable=" + getWithdrawEnable() + ", withdrawPrecision=" + getWithdrawPrecision() + ", feeType=" + getFeeType() + ", code=" + getCode() + ", displayName=" + getDisplayName() + ", fullName=" + getFullName() + ", addrWithTag=" + getAddrWithTag() + ", addrdepositTag=" + getAddrdepositTag() + ", addrOneoff=" + getAddrOneoff() + ", fastConfirms=" + getFastConfirms() + ", safeConfirms=" + getSafeConfirms() + ", visible=" + getVisible() + ", depositDesc=" + getDepositDesc() + ", withdrawDesc=" + getWithdrawDesc() + ", suspendDepositDesc=" + getSuspendDepositDesc() + ", suspendWithdrawDesc=" + getSuspendWithdrawDesc() + ", suspendDepositAnnouncement=" + getSuspendDepositAnnouncement() + ", suspendWithdrawAnnouncement=" + getSuspendWithdrawAnnouncement() + ", replaceChainInfoDesc=" + getReplaceChainInfoDesc() + ", replaceChainNotificationDesc=" + getReplaceChainNotificationDesc() + ", replaceChainPopupDesc=" + getReplaceChainPopupDesc() + ", depositTipsDesc=" + getDepositTipsDesc() + ", withdrawTipsDesc=" + getWithdrawTipsDesc() + ")";
    }

    public int compareTo(ChainInfo chainInfo) {
        if (chainInfo == null) {
            return 0;
        }
        if (!isDefaultChain() || chainInfo.isDefaultChain()) {
            return (isDefaultChain() || !chainInfo.isDefaultChain()) ? 0 : 1;
        }
        return -1;
    }

    public ChainInfo() {
    }

    public ChainInfo(Long l11, String str, String str2, String str3, String str4, int i11, String str5, String str6, boolean z11, boolean z12, int i12, String str7, String str8, String str9, String str10, boolean z13, boolean z14, boolean z15, int i13, int i14, boolean z16, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21) {
        this.f70610id = l11;
        this.chainType = str;
        this.chain = str2;
        this.currency = str3;
        this.addressChain = str4;
        this.isDefault = i11;
        this.depositMinAmount = str5;
        this.withdrawMinAmount = str6;
        this.depositEnable = z11;
        this.withdrawEnable = z12;
        this.withdrawPrecision = i12;
        this.feeType = str7;
        this.code = str8;
        this.displayName = str9;
        this.fullName = str10;
        this.addrWithTag = z13;
        this.addrdepositTag = z14;
        this.addrOneoff = z15;
        this.fastConfirms = i13;
        this.safeConfirms = i14;
        this.visible = z16;
        this.depositDesc = str11;
        this.withdrawDesc = str12;
        this.suspendDepositDesc = str13;
        this.suspendWithdrawDesc = str14;
        this.suspendDepositAnnouncement = str15;
        this.suspendWithdrawAnnouncement = str16;
        this.replaceChainInfoDesc = str17;
        this.replaceChainNotificationDesc = str18;
        this.replaceChainPopupDesc = str19;
        this.depositTipsDesc = str20;
        this.withdrawTipsDesc = str21;
    }

    public ChainInfo(Long l11, String str, int i11, String str2, String str3, String str4, String str5, int i12, String str6, String str7, boolean z11, boolean z12, int i13, String str8, String str9, String str10, String str11, boolean z13, boolean z14, boolean z15, int i14, int i15, boolean z16, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22) {
        this.f70610id = l11;
        this.chainType = str;
        this.contractChainType = i11;
        this.contractAddress = str2;
        this.chain = str3;
        this.currency = str4;
        this.addressChain = str5;
        this.isDefault = i12;
        this.depositMinAmount = str6;
        this.withdrawMinAmount = str7;
        this.depositEnable = z11;
        this.withdrawEnable = z12;
        this.withdrawPrecision = i13;
        this.feeType = str8;
        this.code = str9;
        this.displayName = str10;
        this.fullName = str11;
        this.addrWithTag = z13;
        this.addrdepositTag = z14;
        this.addrOneoff = z15;
        this.fastConfirms = i14;
        this.safeConfirms = i15;
        this.visible = z16;
        this.depositDesc = str12;
        this.withdrawDesc = str13;
        this.suspendDepositDesc = str14;
        this.suspendWithdrawDesc = str15;
        this.suspendDepositAnnouncement = str16;
        this.suspendWithdrawAnnouncement = str17;
        this.replaceChainInfoDesc = str18;
        this.replaceChainNotificationDesc = str19;
        this.replaceChainPopupDesc = str20;
        this.depositTipsDesc = str21;
        this.withdrawTipsDesc = str22;
    }
}
