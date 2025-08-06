package com.huobi.finance.bean;

import com.huobi.finance.viewhandler.SuperMarginBalanceViewAdapter;

public class SuperMarginDetailInfo extends BaseAssetInfo {
    private String interest;
    private String loan;

    public boolean canEqual(Object obj) {
        return obj instanceof SuperMarginDetailInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SuperMarginDetailInfo)) {
            return false;
        }
        SuperMarginDetailInfo superMarginDetailInfo = (SuperMarginDetailInfo) obj;
        if (!superMarginDetailInfo.canEqual(this) || !super.equals(obj)) {
            return false;
        }
        String loan2 = getLoan();
        String loan3 = superMarginDetailInfo.getLoan();
        if (loan2 != null ? !loan2.equals(loan3) : loan3 != null) {
            return false;
        }
        String interest2 = getInterest();
        String interest3 = superMarginDetailInfo.getInterest();
        return interest2 != null ? interest2.equals(interest3) : interest3 == null;
    }

    public void fillEmptyValues() {
        if (getInterest() == null) {
            setInterest("0");
        }
        if (getLoan() == null) {
            setLoan("0");
        }
        if (getOnOrders() == null) {
            setOnOrders("0");
        }
        if (getAvaialAble() == null) {
            setAvaialAble("0");
        }
        if (getEstimateAmount() == null) {
            setEstimateAmount("0");
        }
        if (getEstimateAmountToBtc() == null) {
            setEstimateAmountToBtc("0");
        }
    }

    public String getInterest() {
        return this.interest;
    }

    public String getLoan() {
        return this.loan;
    }

    public String getTitle() {
        return getDisplayName();
    }

    public String getViewHandlerName() {
        return SuperMarginBalanceViewAdapter.class.getName();
    }

    public int hashCode() {
        int hashCode = super.hashCode();
        String loan2 = getLoan();
        int i11 = 43;
        int hashCode2 = (hashCode * 59) + (loan2 == null ? 43 : loan2.hashCode());
        String interest2 = getInterest();
        int i12 = hashCode2 * 59;
        if (interest2 != null) {
            i11 = interest2.hashCode();
        }
        return i12 + i11;
    }

    public void setInterest(String str) {
        this.interest = str;
    }

    public void setLoan(String str) {
        this.loan = str;
    }

    public String toString() {
        return "SuperMarginDetailInfo(loan=" + getLoan() + ", interest=" + getInterest() + ")";
    }
}
