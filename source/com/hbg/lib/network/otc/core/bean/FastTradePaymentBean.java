package com.hbg.lib.network.otc.core.bean;

import java.io.Serializable;
import java.util.List;

public class FastTradePaymentBean implements Serializable {
    private String bankName = "";
    private String bankNumber = "";
    private int bankType;
    private String bankTypeI18n = "";

    /* renamed from: id  reason: collision with root package name */
    private int f70568id;
    private List<OtcPaymentTemplateBean> modelFieldsList;
    private String payMethodName;

    public boolean canEqual(Object obj) {
        return obj instanceof FastTradePaymentBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FastTradePaymentBean)) {
            return false;
        }
        FastTradePaymentBean fastTradePaymentBean = (FastTradePaymentBean) obj;
        if (!fastTradePaymentBean.canEqual(this)) {
            return false;
        }
        String bankNumber2 = getBankNumber();
        String bankNumber3 = fastTradePaymentBean.getBankNumber();
        if (bankNumber2 != null ? !bankNumber2.equals(bankNumber3) : bankNumber3 != null) {
            return false;
        }
        String bankTypeI18n2 = getBankTypeI18n();
        String bankTypeI18n3 = fastTradePaymentBean.getBankTypeI18n();
        if (bankTypeI18n2 != null ? !bankTypeI18n2.equals(bankTypeI18n3) : bankTypeI18n3 != null) {
            return false;
        }
        if (getBankType() != fastTradePaymentBean.getBankType()) {
            return false;
        }
        String bankName2 = getBankName();
        String bankName3 = fastTradePaymentBean.getBankName();
        if (bankName2 != null ? !bankName2.equals(bankName3) : bankName3 != null) {
            return false;
        }
        if (getId() != fastTradePaymentBean.getId()) {
            return false;
        }
        String payMethodName2 = getPayMethodName();
        String payMethodName3 = fastTradePaymentBean.getPayMethodName();
        if (payMethodName2 != null ? !payMethodName2.equals(payMethodName3) : payMethodName3 != null) {
            return false;
        }
        List<OtcPaymentTemplateBean> modelFieldsList2 = getModelFieldsList();
        List<OtcPaymentTemplateBean> modelFieldsList3 = fastTradePaymentBean.getModelFieldsList();
        return modelFieldsList2 != null ? modelFieldsList2.equals(modelFieldsList3) : modelFieldsList3 == null;
    }

    public String getBankName() {
        return this.bankName;
    }

    public String getBankNumber() {
        return this.bankNumber;
    }

    public int getBankType() {
        return this.bankType;
    }

    public String getBankTypeI18n() {
        return this.bankTypeI18n;
    }

    public int getId() {
        return this.f70568id;
    }

    public List<OtcPaymentTemplateBean> getModelFieldsList() {
        return this.modelFieldsList;
    }

    public String getPayMethodName() {
        return this.payMethodName;
    }

    public int hashCode() {
        String bankNumber2 = getBankNumber();
        int i11 = 43;
        int hashCode = bankNumber2 == null ? 43 : bankNumber2.hashCode();
        String bankTypeI18n2 = getBankTypeI18n();
        int hashCode2 = ((((hashCode + 59) * 59) + (bankTypeI18n2 == null ? 43 : bankTypeI18n2.hashCode())) * 59) + getBankType();
        String bankName2 = getBankName();
        int hashCode3 = (((hashCode2 * 59) + (bankName2 == null ? 43 : bankName2.hashCode())) * 59) + getId();
        String payMethodName2 = getPayMethodName();
        int hashCode4 = (hashCode3 * 59) + (payMethodName2 == null ? 43 : payMethodName2.hashCode());
        List<OtcPaymentTemplateBean> modelFieldsList2 = getModelFieldsList();
        int i12 = hashCode4 * 59;
        if (modelFieldsList2 != null) {
            i11 = modelFieldsList2.hashCode();
        }
        return i12 + i11;
    }

    public void setBankName(String str) {
        this.bankName = str;
    }

    public void setBankNumber(String str) {
        this.bankNumber = str;
    }

    public void setBankType(int i11) {
        this.bankType = i11;
    }

    public void setBankTypeI18n(String str) {
        this.bankTypeI18n = str;
    }

    public void setId(int i11) {
        this.f70568id = i11;
    }

    public void setModelFieldsList(List<OtcPaymentTemplateBean> list) {
        this.modelFieldsList = list;
    }

    public void setPayMethodName(String str) {
        this.payMethodName = str;
    }

    public String toString() {
        return "FastTradePaymentBean(bankNumber=" + getBankNumber() + ", bankTypeI18n=" + getBankTypeI18n() + ", bankType=" + getBankType() + ", bankName=" + getBankName() + ", id=" + getId() + ", payMethodName=" + getPayMethodName() + ", modelFieldsList=" + getModelFieldsList() + ")";
    }
}
