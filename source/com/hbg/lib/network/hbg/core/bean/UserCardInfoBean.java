package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class UserCardInfoBean implements Serializable {
    public String accountName;
    public String accountNumber;
    public String bankCode;
    public String bankName;
    public String billingAddress;
    public String cardCountry;
    public long cardId;
    public int cardState;
    public int cardType;
    public String currency;
    public long expiryTime;
    public String extend;
    public String firstName;
    public boolean isLast;
    public boolean isShowTypeAdd;
    public long lastAuthAt;
    public String lastName;
    public String merchantCode;
    private String payMethodCode;
    public long paymentCreateAt;
    public String paymentMethod;
    public String scheme;

    public boolean canEqual(Object obj) {
        return obj instanceof UserCardInfoBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UserCardInfoBean)) {
            return false;
        }
        UserCardInfoBean userCardInfoBean = (UserCardInfoBean) obj;
        if (!userCardInfoBean.canEqual(this) || getCardId() != userCardInfoBean.getCardId()) {
            return false;
        }
        String paymentMethod2 = getPaymentMethod();
        String paymentMethod3 = userCardInfoBean.getPaymentMethod();
        if (paymentMethod2 != null ? !paymentMethod2.equals(paymentMethod3) : paymentMethod3 != null) {
            return false;
        }
        String merchantCode2 = getMerchantCode();
        String merchantCode3 = userCardInfoBean.getMerchantCode();
        if (merchantCode2 != null ? !merchantCode2.equals(merchantCode3) : merchantCode3 != null) {
            return false;
        }
        String currency2 = getCurrency();
        String currency3 = userCardInfoBean.getCurrency();
        if (currency2 != null ? !currency2.equals(currency3) : currency3 != null) {
            return false;
        }
        String accountNumber2 = getAccountNumber();
        String accountNumber3 = userCardInfoBean.getAccountNumber();
        if (accountNumber2 != null ? !accountNumber2.equals(accountNumber3) : accountNumber3 != null) {
            return false;
        }
        String accountName2 = getAccountName();
        String accountName3 = userCardInfoBean.getAccountName();
        if (accountName2 != null ? !accountName2.equals(accountName3) : accountName3 != null) {
            return false;
        }
        String bankCode2 = getBankCode();
        String bankCode3 = userCardInfoBean.getBankCode();
        if (bankCode2 != null ? !bankCode2.equals(bankCode3) : bankCode3 != null) {
            return false;
        }
        String bankName2 = getBankName();
        String bankName3 = userCardInfoBean.getBankName();
        if (bankName2 != null ? !bankName2.equals(bankName3) : bankName3 != null) {
            return false;
        }
        String scheme2 = getScheme();
        String scheme3 = userCardInfoBean.getScheme();
        if (scheme2 != null ? !scheme2.equals(scheme3) : scheme3 != null) {
            return false;
        }
        String cardCountry2 = getCardCountry();
        String cardCountry3 = userCardInfoBean.getCardCountry();
        if (cardCountry2 != null ? !cardCountry2.equals(cardCountry3) : cardCountry3 != null) {
            return false;
        }
        String extend2 = getExtend();
        String extend3 = userCardInfoBean.getExtend();
        if (extend2 != null ? !extend2.equals(extend3) : extend3 != null) {
            return false;
        }
        if (getCardState() != userCardInfoBean.getCardState()) {
            return false;
        }
        String payMethodCode2 = getPayMethodCode();
        String payMethodCode3 = userCardInfoBean.getPayMethodCode();
        if (payMethodCode2 != null ? !payMethodCode2.equals(payMethodCode3) : payMethodCode3 != null) {
            return false;
        }
        if (getLastAuthAt() != userCardInfoBean.getLastAuthAt() || getExpiryTime() != userCardInfoBean.getExpiryTime() || getCardType() != userCardInfoBean.getCardType()) {
            return false;
        }
        String billingAddress2 = getBillingAddress();
        String billingAddress3 = userCardInfoBean.getBillingAddress();
        if (billingAddress2 != null ? !billingAddress2.equals(billingAddress3) : billingAddress3 != null) {
            return false;
        }
        String firstName2 = getFirstName();
        String firstName3 = userCardInfoBean.getFirstName();
        if (firstName2 != null ? !firstName2.equals(firstName3) : firstName3 != null) {
            return false;
        }
        String lastName2 = getLastName();
        String lastName3 = userCardInfoBean.getLastName();
        if (lastName2 != null ? lastName2.equals(lastName3) : lastName3 == null) {
            return getPaymentCreateAt() == userCardInfoBean.getPaymentCreateAt() && isShowTypeAdd() == userCardInfoBean.isShowTypeAdd() && isLast() == userCardInfoBean.isLast();
        }
        return false;
    }

    public String getAccountName() {
        return this.accountName;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public String getBankCode() {
        return this.bankCode;
    }

    public String getBankName() {
        return this.bankName;
    }

    public String getBillingAddress() {
        return this.billingAddress;
    }

    public String getCardCountry() {
        return this.cardCountry;
    }

    public long getCardId() {
        return this.cardId;
    }

    public int getCardState() {
        return this.cardState;
    }

    public int getCardType() {
        return this.cardType;
    }

    public String getCurrency() {
        return this.currency;
    }

    public long getExpiryTime() {
        return this.expiryTime;
    }

    public String getExtend() {
        return this.extend;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public long getLastAuthAt() {
        return this.lastAuthAt;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getMerchantCode() {
        return this.merchantCode;
    }

    public String getPayMethodCode() {
        return this.payMethodCode;
    }

    public long getPaymentCreateAt() {
        return this.paymentCreateAt;
    }

    public String getPaymentMethod() {
        return this.paymentMethod;
    }

    public String getScheme() {
        return this.scheme;
    }

    public int hashCode() {
        long cardId2 = getCardId();
        String paymentMethod2 = getPaymentMethod();
        int i11 = 43;
        int hashCode = ((((int) (cardId2 ^ (cardId2 >>> 32))) + 59) * 59) + (paymentMethod2 == null ? 43 : paymentMethod2.hashCode());
        String merchantCode2 = getMerchantCode();
        int hashCode2 = (hashCode * 59) + (merchantCode2 == null ? 43 : merchantCode2.hashCode());
        String currency2 = getCurrency();
        int hashCode3 = (hashCode2 * 59) + (currency2 == null ? 43 : currency2.hashCode());
        String accountNumber2 = getAccountNumber();
        int hashCode4 = (hashCode3 * 59) + (accountNumber2 == null ? 43 : accountNumber2.hashCode());
        String accountName2 = getAccountName();
        int hashCode5 = (hashCode4 * 59) + (accountName2 == null ? 43 : accountName2.hashCode());
        String bankCode2 = getBankCode();
        int hashCode6 = (hashCode5 * 59) + (bankCode2 == null ? 43 : bankCode2.hashCode());
        String bankName2 = getBankName();
        int hashCode7 = (hashCode6 * 59) + (bankName2 == null ? 43 : bankName2.hashCode());
        String scheme2 = getScheme();
        int hashCode8 = (hashCode7 * 59) + (scheme2 == null ? 43 : scheme2.hashCode());
        String cardCountry2 = getCardCountry();
        int hashCode9 = (hashCode8 * 59) + (cardCountry2 == null ? 43 : cardCountry2.hashCode());
        String extend2 = getExtend();
        int hashCode10 = (((hashCode9 * 59) + (extend2 == null ? 43 : extend2.hashCode())) * 59) + getCardState();
        String payMethodCode2 = getPayMethodCode();
        int i12 = hashCode10 * 59;
        int hashCode11 = payMethodCode2 == null ? 43 : payMethodCode2.hashCode();
        long lastAuthAt2 = getLastAuthAt();
        long expiryTime2 = getExpiryTime();
        int cardType2 = ((((((i12 + hashCode11) * 59) + ((int) (lastAuthAt2 ^ (lastAuthAt2 >>> 32)))) * 59) + ((int) (expiryTime2 ^ (expiryTime2 >>> 32)))) * 59) + getCardType();
        String billingAddress2 = getBillingAddress();
        int hashCode12 = (cardType2 * 59) + (billingAddress2 == null ? 43 : billingAddress2.hashCode());
        String firstName2 = getFirstName();
        int hashCode13 = (hashCode12 * 59) + (firstName2 == null ? 43 : firstName2.hashCode());
        String lastName2 = getLastName();
        int i13 = hashCode13 * 59;
        if (lastName2 != null) {
            i11 = lastName2.hashCode();
        }
        long paymentCreateAt2 = getPaymentCreateAt();
        int i14 = (((i13 + i11) * 59) + ((int) ((paymentCreateAt2 >>> 32) ^ paymentCreateAt2))) * 59;
        int i15 = 79;
        int i16 = (i14 + (isShowTypeAdd() ? 79 : 97)) * 59;
        if (!isLast()) {
            i15 = 97;
        }
        return i16 + i15;
    }

    public boolean isLast() {
        return this.isLast;
    }

    public boolean isShowTypeAdd() {
        return this.isShowTypeAdd;
    }

    public void setAccountName(String str) {
        this.accountName = str;
    }

    public void setAccountNumber(String str) {
        this.accountNumber = str;
    }

    public void setBankCode(String str) {
        this.bankCode = str;
    }

    public void setBankName(String str) {
        this.bankName = str;
    }

    public void setBillingAddress(String str) {
        this.billingAddress = str;
    }

    public void setCardCountry(String str) {
        this.cardCountry = str;
    }

    public void setCardId(long j11) {
        this.cardId = j11;
    }

    public void setCardState(int i11) {
        this.cardState = i11;
    }

    public void setCardType(int i11) {
        this.cardType = i11;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setExpiryTime(long j11) {
        this.expiryTime = j11;
    }

    public void setExtend(String str) {
        this.extend = str;
    }

    public void setFirstName(String str) {
        this.firstName = str;
    }

    public void setLast(boolean z11) {
        this.isLast = z11;
    }

    public void setLastAuthAt(long j11) {
        this.lastAuthAt = j11;
    }

    public void setLastName(String str) {
        this.lastName = str;
    }

    public void setMerchantCode(String str) {
        this.merchantCode = str;
    }

    public void setPayMethodCode(String str) {
        this.payMethodCode = str;
    }

    public void setPaymentCreateAt(long j11) {
        this.paymentCreateAt = j11;
    }

    public void setPaymentMethod(String str) {
        this.paymentMethod = str;
    }

    public void setScheme(String str) {
        this.scheme = str;
    }

    public void setShowTypeAdd(boolean z11) {
        this.isShowTypeAdd = z11;
    }

    public String toString() {
        return "UserCardInfoBean(cardId=" + getCardId() + ", paymentMethod=" + getPaymentMethod() + ", merchantCode=" + getMerchantCode() + ", currency=" + getCurrency() + ", accountNumber=" + getAccountNumber() + ", accountName=" + getAccountName() + ", bankCode=" + getBankCode() + ", bankName=" + getBankName() + ", scheme=" + getScheme() + ", cardCountry=" + getCardCountry() + ", extend=" + getExtend() + ", cardState=" + getCardState() + ", payMethodCode=" + getPayMethodCode() + ", lastAuthAt=" + getLastAuthAt() + ", expiryTime=" + getExpiryTime() + ", cardType=" + getCardType() + ", billingAddress=" + getBillingAddress() + ", firstName=" + getFirstName() + ", lastName=" + getLastName() + ", paymentCreateAt=" + getPaymentCreateAt() + ", isShowTypeAdd=" + isShowTypeAdd() + ", isLast=" + isLast() + ")";
    }
}
