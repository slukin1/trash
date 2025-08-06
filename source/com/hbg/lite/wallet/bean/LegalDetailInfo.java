package com.hbg.lite.wallet.bean;

import com.hbg.lite.wallet.viewhandler.BalanceInfoFirstViewHandler;
import com.hbg.lite.wallet.viewhandler.LegalInfoViewHandler;
import s9.a;

public class LegalDetailInfo extends BaseAssetInfo implements a {
    public static final int FLAG_STATUS_CANNOT_DEPOSIT = 4;
    public static final int FLAG_STATUS_CANNOT_TRADE = 1;
    public static final int FLAG_STATUS_CANNOT_TRANFER = 2;
    private String borrow;
    private int coinId;
    private boolean isFirst;
    private boolean isSecond;
    private String liteLogo;
    private String logo;
    private String name;
    private boolean quoted;
    private int status;

    public boolean canEqual(Object obj) {
        return obj instanceof LegalDetailInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LegalDetailInfo)) {
            return false;
        }
        LegalDetailInfo legalDetailInfo = (LegalDetailInfo) obj;
        if (!legalDetailInfo.canEqual(this) || !super.equals(obj) || getCoinId() != legalDetailInfo.getCoinId()) {
            return false;
        }
        String borrow2 = getBorrow();
        String borrow3 = legalDetailInfo.getBorrow();
        if (borrow2 != null ? !borrow2.equals(borrow3) : borrow3 != null) {
            return false;
        }
        if (getStatus() != legalDetailInfo.getStatus()) {
            return false;
        }
        String name2 = getName();
        String name3 = legalDetailInfo.getName();
        if (name2 != null ? !name2.equals(name3) : name3 != null) {
            return false;
        }
        String logo2 = getLogo();
        String logo3 = legalDetailInfo.getLogo();
        if (logo2 != null ? !logo2.equals(logo3) : logo3 != null) {
            return false;
        }
        String liteLogo2 = getLiteLogo();
        String liteLogo3 = legalDetailInfo.getLiteLogo();
        if (liteLogo2 != null ? liteLogo2.equals(liteLogo3) : liteLogo3 == null) {
            return isQuoted() == legalDetailInfo.isQuoted() && isFirst() == legalDetailInfo.isFirst() && isSecond() == legalDetailInfo.isSecond();
        }
        return false;
    }

    public String getBorrow() {
        return this.borrow;
    }

    public int getCoinId() {
        return this.coinId;
    }

    public String getLiteLogo() {
        return this.liteLogo;
    }

    public String getLogo() {
        return this.logo;
    }

    public String getName() {
        return this.name;
    }

    public int getStatus() {
        return this.status;
    }

    public String getViewHandlerName() {
        if (this.isFirst) {
            return BalanceInfoFirstViewHandler.class.getName();
        }
        return LegalInfoViewHandler.class.getName();
    }

    public int hashCode() {
        int hashCode = (super.hashCode() * 59) + getCoinId();
        String borrow2 = getBorrow();
        int i11 = 43;
        int hashCode2 = (((hashCode * 59) + (borrow2 == null ? 43 : borrow2.hashCode())) * 59) + getStatus();
        String name2 = getName();
        int hashCode3 = (hashCode2 * 59) + (name2 == null ? 43 : name2.hashCode());
        String logo2 = getLogo();
        int hashCode4 = (hashCode3 * 59) + (logo2 == null ? 43 : logo2.hashCode());
        String liteLogo2 = getLiteLogo();
        int i12 = hashCode4 * 59;
        if (liteLogo2 != null) {
            i11 = liteLogo2.hashCode();
        }
        int i13 = (i12 + i11) * 59;
        int i14 = 79;
        int i15 = (((i13 + (isQuoted() ? 79 : 97)) * 59) + (isFirst() ? 79 : 97)) * 59;
        if (!isSecond()) {
            i14 = 97;
        }
        return i15 + i14;
    }

    public boolean isFirst() {
        return this.isFirst;
    }

    public boolean isQuoted() {
        return this.quoted;
    }

    public boolean isSecond() {
        return this.isSecond;
    }

    public void setBorrow(String str) {
        this.borrow = str;
    }

    public void setCoinId(int i11) {
        this.coinId = i11;
    }

    public void setFirst(boolean z11) {
        this.isFirst = z11;
    }

    public void setLiteLogo(String str) {
        this.liteLogo = str;
    }

    public void setLogo(String str) {
        this.logo = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setQuoted(boolean z11) {
        this.quoted = z11;
    }

    public void setSecond(boolean z11) {
        this.isSecond = z11;
    }

    public void setStatus(int i11) {
        this.status = i11;
    }

    public String toString() {
        return "LegalDetailInfo(coinId=" + getCoinId() + ", borrow=" + getBorrow() + ", status=" + getStatus() + ", name=" + getName() + ", logo=" + getLogo() + ", liteLogo=" + getLiteLogo() + ", quoted=" + isQuoted() + ", isFirst=" + isFirst() + ", isSecond=" + isSecond() + ")";
    }
}
