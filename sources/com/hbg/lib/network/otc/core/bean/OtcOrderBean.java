package com.hbg.lib.network.otc.core.bean;

import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OtcOrderBean implements Serializable {
    public static final int BUSINESS_TYPE_BUY = 0;
    public static final int BUSINESS_TYPE_SELL = 1;
    public static final int ORDER_TYPE_FAST_BUY = 4;
    private String amount;
    private int buyPayAccount;
    private int coinId;
    private int country;
    private int currency;
    private String currencyStr;
    private String fee;
    private long gmtCreate;
    private String gmtCreateStr;
    private long gmtModified;
    private long gmtPay;
    private long gmtResetCancel;

    /* renamed from: id  reason: collision with root package name */
    private int f70590id;
    private int matchPayId;
    private long now;
    private String orderNo;
    private int orderType;
    private String payCode;
    private String payMethod;
    private int payTerm;
    private String price;
    private String quantity;
    private int status;
    private String statusStr;
    private int tradeId;
    private String tradeNo;
    private String tradeRealName;
    private int tradeType;
    private long tradeUid;
    private String tradeUserName;

    public boolean canEqual(Object obj) {
        return obj instanceof OtcOrderBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OtcOrderBean)) {
            return false;
        }
        OtcOrderBean otcOrderBean = (OtcOrderBean) obj;
        if (!otcOrderBean.canEqual(this) || getId() != otcOrderBean.getId()) {
            return false;
        }
        String orderNo2 = getOrderNo();
        String orderNo3 = otcOrderBean.getOrderNo();
        if (orderNo2 != null ? !orderNo2.equals(orderNo3) : orderNo3 != null) {
            return false;
        }
        if (getTradeId() != otcOrderBean.getTradeId() || getTradeType() != otcOrderBean.getTradeType() || getCoinId() != otcOrderBean.getCoinId()) {
            return false;
        }
        String price2 = getPrice();
        String price3 = otcOrderBean.getPrice();
        if (price2 != null ? !price2.equals(price3) : price3 != null) {
            return false;
        }
        String quantity2 = getQuantity();
        String quantity3 = otcOrderBean.getQuantity();
        if (quantity2 != null ? !quantity2.equals(quantity3) : quantity3 != null) {
            return false;
        }
        String amount2 = getAmount();
        String amount3 = otcOrderBean.getAmount();
        if (amount2 != null ? !amount2.equals(amount3) : amount3 != null) {
            return false;
        }
        if (getCountry() != otcOrderBean.getCountry() || getCurrency() != otcOrderBean.getCurrency()) {
            return false;
        }
        String fee2 = getFee();
        String fee3 = otcOrderBean.getFee();
        if (fee2 != null ? !fee2.equals(fee3) : fee3 != null) {
            return false;
        }
        if (getStatus() != otcOrderBean.getStatus()) {
            return false;
        }
        String statusStr2 = getStatusStr();
        String statusStr3 = otcOrderBean.getStatusStr();
        if (statusStr2 != null ? !statusStr2.equals(statusStr3) : statusStr3 != null) {
            return false;
        }
        List<String> payMethod2 = getPayMethod();
        List<String> payMethod3 = otcOrderBean.getPayMethod();
        if (payMethod2 != null ? !payMethod2.equals(payMethod3) : payMethod3 != null) {
            return false;
        }
        if (getBuyPayAccount() != otcOrderBean.getBuyPayAccount() || getPayTerm() != otcOrderBean.getPayTerm()) {
            return false;
        }
        String payCode2 = getPayCode();
        String payCode3 = otcOrderBean.getPayCode();
        if (payCode2 != null ? !payCode2.equals(payCode3) : payCode3 != null) {
            return false;
        }
        if (getGmtCreate() != otcOrderBean.getGmtCreate()) {
            return false;
        }
        String gmtCreateStr2 = getGmtCreateStr();
        String gmtCreateStr3 = otcOrderBean.getGmtCreateStr();
        if (gmtCreateStr2 != null ? !gmtCreateStr2.equals(gmtCreateStr3) : gmtCreateStr3 != null) {
            return false;
        }
        if (getGmtModified() != otcOrderBean.getGmtModified() || getGmtPay() != otcOrderBean.getGmtPay()) {
            return false;
        }
        String tradeNo2 = getTradeNo();
        String tradeNo3 = otcOrderBean.getTradeNo();
        if (tradeNo2 != null ? !tradeNo2.equals(tradeNo3) : tradeNo3 != null) {
            return false;
        }
        if (getNow() != otcOrderBean.getNow()) {
            return false;
        }
        String tradeUserName2 = getTradeUserName();
        String tradeUserName3 = otcOrderBean.getTradeUserName();
        if (tradeUserName2 != null ? !tradeUserName2.equals(tradeUserName3) : tradeUserName3 != null) {
            return false;
        }
        String tradeRealName2 = getTradeRealName();
        String tradeRealName3 = otcOrderBean.getTradeRealName();
        if (tradeRealName2 != null ? !tradeRealName2.equals(tradeRealName3) : tradeRealName3 != null) {
            return false;
        }
        if (getTradeUid() != otcOrderBean.getTradeUid()) {
            return false;
        }
        String currencyStr2 = getCurrencyStr();
        String currencyStr3 = otcOrderBean.getCurrencyStr();
        if (currencyStr2 != null ? currencyStr2.equals(currencyStr3) : currencyStr3 == null) {
            return getGmtResetCancel() == otcOrderBean.getGmtResetCancel() && getMatchPayId() == otcOrderBean.getMatchPayId() && getOrderType() == otcOrderBean.getOrderType();
        }
        return false;
    }

    public String getAmount() {
        return this.amount;
    }

    public int getBuyPayAccount() {
        return this.buyPayAccount;
    }

    public int getCoinId() {
        return this.coinId;
    }

    public int getCountry() {
        return this.country;
    }

    public int getCurrency() {
        return this.currency;
    }

    public String getCurrencyStr() {
        return this.currencyStr;
    }

    public String getFee() {
        return this.fee;
    }

    public long getGmtCreate() {
        return this.gmtCreate;
    }

    public String getGmtCreateStr() {
        return this.gmtCreateStr;
    }

    public long getGmtModified() {
        return this.gmtModified;
    }

    public long getGmtPay() {
        return this.gmtPay;
    }

    public long getGmtResetCancel() {
        return this.gmtResetCancel;
    }

    public int getId() {
        return this.f70590id;
    }

    public int getMatchPayId() {
        return this.matchPayId;
    }

    public long getNow() {
        return this.now;
    }

    public String getOrderNo() {
        return this.orderNo;
    }

    public int getOrderType() {
        return this.orderType;
    }

    public String getPayCode() {
        return this.payCode;
    }

    public List<String> getPayMethod() {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(this.payMethod)) {
            if (this.payMethod.contains(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                arrayList.addAll(Arrays.asList(this.payMethod.split(Constants.ACCEPT_TIME_SEPARATOR_SP)));
            } else {
                arrayList.add(this.payMethod);
            }
        }
        return arrayList;
    }

    public int getPayTerm() {
        return this.payTerm;
    }

    public String getPrice() {
        return this.price;
    }

    public String getQuantity() {
        return this.quantity;
    }

    public int getStatus() {
        return this.status;
    }

    public String getStatusStr() {
        return this.statusStr;
    }

    public int getTradeId() {
        return this.tradeId;
    }

    public String getTradeNo() {
        return this.tradeNo;
    }

    public String getTradeRealName() {
        return this.tradeRealName;
    }

    public int getTradeType() {
        return this.tradeType;
    }

    public long getTradeUid() {
        return this.tradeUid;
    }

    public String getTradeUserName() {
        return this.tradeUserName;
    }

    public int hashCode() {
        String orderNo2 = getOrderNo();
        int i11 = 43;
        int id2 = ((((((((getId() + 59) * 59) + (orderNo2 == null ? 43 : orderNo2.hashCode())) * 59) + getTradeId()) * 59) + getTradeType()) * 59) + getCoinId();
        String price2 = getPrice();
        int hashCode = (id2 * 59) + (price2 == null ? 43 : price2.hashCode());
        String quantity2 = getQuantity();
        int hashCode2 = (hashCode * 59) + (quantity2 == null ? 43 : quantity2.hashCode());
        String amount2 = getAmount();
        int hashCode3 = (((((hashCode2 * 59) + (amount2 == null ? 43 : amount2.hashCode())) * 59) + getCountry()) * 59) + getCurrency();
        String fee2 = getFee();
        int hashCode4 = (((hashCode3 * 59) + (fee2 == null ? 43 : fee2.hashCode())) * 59) + getStatus();
        String statusStr2 = getStatusStr();
        int hashCode5 = (hashCode4 * 59) + (statusStr2 == null ? 43 : statusStr2.hashCode());
        List<String> payMethod2 = getPayMethod();
        int hashCode6 = (((((hashCode5 * 59) + (payMethod2 == null ? 43 : payMethod2.hashCode())) * 59) + getBuyPayAccount()) * 59) + getPayTerm();
        String payCode2 = getPayCode();
        int i12 = hashCode6 * 59;
        int hashCode7 = payCode2 == null ? 43 : payCode2.hashCode();
        long gmtCreate2 = getGmtCreate();
        int i13 = ((i12 + hashCode7) * 59) + ((int) (gmtCreate2 ^ (gmtCreate2 >>> 32)));
        String gmtCreateStr2 = getGmtCreateStr();
        int hashCode8 = (i13 * 59) + (gmtCreateStr2 == null ? 43 : gmtCreateStr2.hashCode());
        long gmtModified2 = getGmtModified();
        int i14 = (hashCode8 * 59) + ((int) (gmtModified2 ^ (gmtModified2 >>> 32)));
        long gmtPay2 = getGmtPay();
        int i15 = (i14 * 59) + ((int) (gmtPay2 ^ (gmtPay2 >>> 32)));
        String tradeNo2 = getTradeNo();
        int hashCode9 = (i15 * 59) + (tradeNo2 == null ? 43 : tradeNo2.hashCode());
        long now2 = getNow();
        int i16 = (hashCode9 * 59) + ((int) (now2 ^ (now2 >>> 32)));
        String tradeUserName2 = getTradeUserName();
        int hashCode10 = (i16 * 59) + (tradeUserName2 == null ? 43 : tradeUserName2.hashCode());
        String tradeRealName2 = getTradeRealName();
        int hashCode11 = (hashCode10 * 59) + (tradeRealName2 == null ? 43 : tradeRealName2.hashCode());
        long tradeUid2 = getTradeUid();
        int i17 = (hashCode11 * 59) + ((int) (tradeUid2 ^ (tradeUid2 >>> 32)));
        String currencyStr2 = getCurrencyStr();
        int i18 = i17 * 59;
        if (currencyStr2 != null) {
            i11 = currencyStr2.hashCode();
        }
        int i19 = i18 + i11;
        long gmtResetCancel2 = getGmtResetCancel();
        return (((((i19 * 59) + ((int) ((gmtResetCancel2 >>> 32) ^ gmtResetCancel2))) * 59) + getMatchPayId()) * 59) + getOrderType();
    }

    public boolean isFastBuy() {
        return this.orderType == 4;
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public void setBuyPayAccount(int i11) {
        this.buyPayAccount = i11;
    }

    public void setCoinId(int i11) {
        this.coinId = i11;
    }

    public void setCountry(int i11) {
        this.country = i11;
    }

    public void setCurrency(int i11) {
        this.currency = i11;
    }

    public void setCurrencyStr(String str) {
        this.currencyStr = str;
    }

    public void setFee(String str) {
        this.fee = str;
    }

    public void setGmtCreate(long j11) {
        this.gmtCreate = j11;
    }

    public void setGmtCreateStr(String str) {
        this.gmtCreateStr = str;
    }

    public void setGmtModified(long j11) {
        this.gmtModified = j11;
    }

    public void setGmtPay(long j11) {
        this.gmtPay = j11;
    }

    public void setGmtResetCancel(long j11) {
        this.gmtResetCancel = j11;
    }

    public void setId(int i11) {
        this.f70590id = i11;
    }

    public void setMatchPayId(int i11) {
        this.matchPayId = i11;
    }

    public void setNow(long j11) {
        this.now = j11;
    }

    public void setOrderNo(String str) {
        this.orderNo = str;
    }

    public void setOrderType(int i11) {
        this.orderType = i11;
    }

    public void setPayCode(String str) {
        this.payCode = str;
    }

    public void setPayMethod(String str) {
        this.payMethod = str;
    }

    public void setPayTerm(int i11) {
        this.payTerm = i11;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public void setQuantity(String str) {
        this.quantity = str;
    }

    public void setStatus(int i11) {
        this.status = i11;
    }

    public void setStatusStr(String str) {
        this.statusStr = str;
    }

    public void setTradeId(int i11) {
        this.tradeId = i11;
    }

    public void setTradeNo(String str) {
        this.tradeNo = str;
    }

    public void setTradeRealName(String str) {
        this.tradeRealName = str;
    }

    public void setTradeType(int i11) {
        this.tradeType = i11;
    }

    public void setTradeUid(long j11) {
        this.tradeUid = j11;
    }

    public void setTradeUserName(String str) {
        this.tradeUserName = str;
    }

    public String toString() {
        return "OtcOrderBean(id=" + getId() + ", orderNo=" + getOrderNo() + ", tradeId=" + getTradeId() + ", tradeType=" + getTradeType() + ", coinId=" + getCoinId() + ", price=" + getPrice() + ", quantity=" + getQuantity() + ", amount=" + getAmount() + ", country=" + getCountry() + ", currency=" + getCurrency() + ", fee=" + getFee() + ", status=" + getStatus() + ", statusStr=" + getStatusStr() + ", payMethod=" + getPayMethod() + ", buyPayAccount=" + getBuyPayAccount() + ", payTerm=" + getPayTerm() + ", payCode=" + getPayCode() + ", gmtCreate=" + getGmtCreate() + ", gmtCreateStr=" + getGmtCreateStr() + ", gmtModified=" + getGmtModified() + ", gmtPay=" + getGmtPay() + ", tradeNo=" + getTradeNo() + ", now=" + getNow() + ", tradeUserName=" + getTradeUserName() + ", tradeRealName=" + getTradeRealName() + ", tradeUid=" + getTradeUid() + ", currencyStr=" + getCurrencyStr() + ", gmtResetCancel=" + getGmtResetCancel() + ", matchPayId=" + getMatchPayId() + ", orderType=" + getOrderType() + ")";
    }
}
