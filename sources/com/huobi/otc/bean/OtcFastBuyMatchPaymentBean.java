package com.huobi.otc.bean;

import android.view.View;
import com.huobi.otc.enums.TradeBusinessEnum;
import com.huobi.otc.handler.OtcFastBuyMatchPaymentHandler;
import java.io.Serializable;
import s9.a;

public class OtcFastBuyMatchPaymentBean implements Serializable, a {
    private String amount;
    private TradeBusinessEnum businessEnum;
    private CheckPaymentCallback callback;
    private boolean isAcceptOrder;
    private int isBuy = 0;
    private boolean isChecked;
    private boolean isFist;
    private boolean isLast;
    private boolean isPriceLow;
    private float itemWith;
    private int payId;
    private String payMethodCode;
    private String payMethodName;
    private String runMode;

    public interface CheckPaymentCallback {
        void onPaymentCheck(int i11, OtcFastBuyMatchPaymentBean otcFastBuyMatchPaymentBean, View view);
    }

    public boolean canEqual(Object obj) {
        return obj instanceof OtcFastBuyMatchPaymentBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OtcFastBuyMatchPaymentBean)) {
            return false;
        }
        OtcFastBuyMatchPaymentBean otcFastBuyMatchPaymentBean = (OtcFastBuyMatchPaymentBean) obj;
        if (!otcFastBuyMatchPaymentBean.canEqual(this) || getPayId() != otcFastBuyMatchPaymentBean.getPayId() || isPriceLow() != otcFastBuyMatchPaymentBean.isPriceLow()) {
            return false;
        }
        String amount2 = getAmount();
        String amount3 = otcFastBuyMatchPaymentBean.getAmount();
        if (amount2 != null ? !amount2.equals(amount3) : amount3 != null) {
            return false;
        }
        if (isChecked() != otcFastBuyMatchPaymentBean.isChecked() || Float.compare(getItemWith(), otcFastBuyMatchPaymentBean.getItemWith()) != 0 || isFist() != otcFastBuyMatchPaymentBean.isFist() || isLast() != otcFastBuyMatchPaymentBean.isLast()) {
            return false;
        }
        CheckPaymentCallback callback2 = getCallback();
        CheckPaymentCallback callback3 = otcFastBuyMatchPaymentBean.getCallback();
        if (callback2 != null ? !callback2.equals(callback3) : callback3 != null) {
            return false;
        }
        if (isAcceptOrder() != otcFastBuyMatchPaymentBean.isAcceptOrder()) {
            return false;
        }
        String payMethodName2 = getPayMethodName();
        String payMethodName3 = otcFastBuyMatchPaymentBean.getPayMethodName();
        if (payMethodName2 != null ? !payMethodName2.equals(payMethodName3) : payMethodName3 != null) {
            return false;
        }
        String payMethodCode2 = getPayMethodCode();
        String payMethodCode3 = otcFastBuyMatchPaymentBean.getPayMethodCode();
        if (payMethodCode2 != null ? !payMethodCode2.equals(payMethodCode3) : payMethodCode3 != null) {
            return false;
        }
        String runMode2 = getRunMode();
        String runMode3 = otcFastBuyMatchPaymentBean.getRunMode();
        if (runMode2 != null ? !runMode2.equals(runMode3) : runMode3 != null) {
            return false;
        }
        if (getIsBuy() != otcFastBuyMatchPaymentBean.getIsBuy()) {
            return false;
        }
        TradeBusinessEnum businessEnum2 = getBusinessEnum();
        TradeBusinessEnum businessEnum3 = otcFastBuyMatchPaymentBean.getBusinessEnum();
        return businessEnum2 != null ? businessEnum2.equals(businessEnum3) : businessEnum3 == null;
    }

    public String getAmount() {
        return this.amount;
    }

    public TradeBusinessEnum getBusinessEnum() {
        return this.businessEnum;
    }

    public CheckPaymentCallback getCallback() {
        return this.callback;
    }

    public int getIsBuy() {
        return this.isBuy;
    }

    public float getItemWith() {
        return this.itemWith;
    }

    public int getPayId() {
        return this.payId;
    }

    public String getPayMethodCode() {
        return this.payMethodCode;
    }

    public String getPayMethodName() {
        return this.payMethodName;
    }

    public String getRunMode() {
        return this.runMode;
    }

    public String getViewHandlerName() {
        return OtcFastBuyMatchPaymentHandler.class.getName();
    }

    public int hashCode() {
        int i11 = 79;
        int payId2 = ((getPayId() + 59) * 59) + (isPriceLow() ? 79 : 97);
        String amount2 = getAmount();
        int i12 = 43;
        int hashCode = (((((((((payId2 * 59) + (amount2 == null ? 43 : amount2.hashCode())) * 59) + (isChecked() ? 79 : 97)) * 59) + Float.floatToIntBits(getItemWith())) * 59) + (isFist() ? 79 : 97)) * 59) + (isLast() ? 79 : 97);
        CheckPaymentCallback callback2 = getCallback();
        int hashCode2 = ((hashCode * 59) + (callback2 == null ? 43 : callback2.hashCode())) * 59;
        if (!isAcceptOrder()) {
            i11 = 97;
        }
        String payMethodName2 = getPayMethodName();
        int hashCode3 = ((hashCode2 + i11) * 59) + (payMethodName2 == null ? 43 : payMethodName2.hashCode());
        String payMethodCode2 = getPayMethodCode();
        int hashCode4 = (hashCode3 * 59) + (payMethodCode2 == null ? 43 : payMethodCode2.hashCode());
        String runMode2 = getRunMode();
        int hashCode5 = (((hashCode4 * 59) + (runMode2 == null ? 43 : runMode2.hashCode())) * 59) + getIsBuy();
        TradeBusinessEnum businessEnum2 = getBusinessEnum();
        int i13 = hashCode5 * 59;
        if (businessEnum2 != null) {
            i12 = businessEnum2.hashCode();
        }
        return i13 + i12;
    }

    public boolean isAcceptOrder() {
        return this.isAcceptOrder;
    }

    public boolean isChecked() {
        return this.isChecked;
    }

    public boolean isFist() {
        return this.isFist;
    }

    public boolean isLast() {
        return this.isLast;
    }

    public boolean isPriceLow() {
        return this.isPriceLow;
    }

    public void setAcceptOrder(boolean z11) {
        this.isAcceptOrder = z11;
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public void setBusinessEnum(TradeBusinessEnum tradeBusinessEnum) {
        this.businessEnum = tradeBusinessEnum;
    }

    public void setCallback(CheckPaymentCallback checkPaymentCallback) {
        this.callback = checkPaymentCallback;
    }

    public void setChecked(boolean z11) {
        this.isChecked = z11;
    }

    public void setFist(boolean z11) {
        this.isFist = z11;
    }

    public void setIsBuy(int i11) {
        this.isBuy = i11;
    }

    public void setItemWith(float f11) {
        this.itemWith = f11;
    }

    public void setLast(boolean z11) {
        this.isLast = z11;
    }

    public void setPayId(int i11) {
        this.payId = i11;
    }

    public void setPayMethodCode(String str) {
        this.payMethodCode = str;
    }

    public void setPayMethodName(String str) {
        this.payMethodName = str;
    }

    public void setPriceLow(boolean z11) {
        this.isPriceLow = z11;
    }

    public void setRunMode(String str) {
        this.runMode = str;
    }

    public String toString() {
        return "OtcFastBuyMatchPaymentBean(payId=" + getPayId() + ", isPriceLow=" + isPriceLow() + ", amount=" + getAmount() + ", isChecked=" + isChecked() + ", itemWith=" + getItemWith() + ", isFist=" + isFist() + ", isLast=" + isLast() + ", callback=" + getCallback() + ", isAcceptOrder=" + isAcceptOrder() + ", payMethodName=" + getPayMethodName() + ", payMethodCode=" + getPayMethodCode() + ", runMode=" + getRunMode() + ", isBuy=" + getIsBuy() + ", businessEnum=" + getBusinessEnum() + ")";
    }
}
