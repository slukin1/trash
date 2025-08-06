package com.hbg.lib.network.otc.core.bean;

import java.io.Serializable;
import java.util.List;

public class OtcTradeConfigListBean implements Serializable {
    private CryptoAsset cryptoAsset;
    private List<QuoteAsset> quoteAsset;

    public static class CryptoAsset implements Serializable {
        private String name;
        private int scale;

        public boolean canEqual(Object obj) {
            return obj instanceof CryptoAsset;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof CryptoAsset)) {
                return false;
            }
            CryptoAsset cryptoAsset = (CryptoAsset) obj;
            if (!cryptoAsset.canEqual(this)) {
                return false;
            }
            String name2 = getName();
            String name3 = cryptoAsset.getName();
            if (name2 != null ? name2.equals(name3) : name3 == null) {
                return getScale() == cryptoAsset.getScale();
            }
            return false;
        }

        public String getName() {
            return this.name;
        }

        public int getScale() {
            return this.scale;
        }

        public int hashCode() {
            String name2 = getName();
            return (((name2 == null ? 43 : name2.hashCode()) + 59) * 59) + getScale();
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setScale(int i11) {
            this.scale = i11;
        }

        public String toString() {
            return "OtcTradeConfigListBean.CryptoAsset(name=" + getName() + ", scale=" + getScale() + ")";
        }
    }

    public static class PaymentDetail implements Serializable {
        private String maxAmount;
        private String maxQuantity;
        private String minAmount;
        private String minQuantity;
        private int payMethodId;
        private String payMethodName;

        public boolean canEqual(Object obj) {
            return obj instanceof PaymentDetail;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof PaymentDetail)) {
                return false;
            }
            PaymentDetail paymentDetail = (PaymentDetail) obj;
            if (!paymentDetail.canEqual(this) || getPayMethodId() != paymentDetail.getPayMethodId()) {
                return false;
            }
            String payMethodName2 = getPayMethodName();
            String payMethodName3 = paymentDetail.getPayMethodName();
            if (payMethodName2 != null ? !payMethodName2.equals(payMethodName3) : payMethodName3 != null) {
                return false;
            }
            String minAmount2 = getMinAmount();
            String minAmount3 = paymentDetail.getMinAmount();
            if (minAmount2 != null ? !minAmount2.equals(minAmount3) : minAmount3 != null) {
                return false;
            }
            String maxAmount2 = getMaxAmount();
            String maxAmount3 = paymentDetail.getMaxAmount();
            if (maxAmount2 != null ? !maxAmount2.equals(maxAmount3) : maxAmount3 != null) {
                return false;
            }
            String minQuantity2 = getMinQuantity();
            String minQuantity3 = paymentDetail.getMinQuantity();
            if (minQuantity2 != null ? !minQuantity2.equals(minQuantity3) : minQuantity3 != null) {
                return false;
            }
            String maxQuantity2 = getMaxQuantity();
            String maxQuantity3 = paymentDetail.getMaxQuantity();
            return maxQuantity2 != null ? maxQuantity2.equals(maxQuantity3) : maxQuantity3 == null;
        }

        public String getMaxAmount() {
            return this.maxAmount;
        }

        public String getMaxQuantity() {
            return this.maxQuantity;
        }

        public String getMinAmount() {
            return this.minAmount;
        }

        public String getMinQuantity() {
            return this.minQuantity;
        }

        public int getPayMethodId() {
            return this.payMethodId;
        }

        public String getPayMethodName() {
            return this.payMethodName;
        }

        public int hashCode() {
            String payMethodName2 = getPayMethodName();
            int i11 = 43;
            int payMethodId2 = ((getPayMethodId() + 59) * 59) + (payMethodName2 == null ? 43 : payMethodName2.hashCode());
            String minAmount2 = getMinAmount();
            int hashCode = (payMethodId2 * 59) + (minAmount2 == null ? 43 : minAmount2.hashCode());
            String maxAmount2 = getMaxAmount();
            int hashCode2 = (hashCode * 59) + (maxAmount2 == null ? 43 : maxAmount2.hashCode());
            String minQuantity2 = getMinQuantity();
            int hashCode3 = (hashCode2 * 59) + (minQuantity2 == null ? 43 : minQuantity2.hashCode());
            String maxQuantity2 = getMaxQuantity();
            int i12 = hashCode3 * 59;
            if (maxQuantity2 != null) {
                i11 = maxQuantity2.hashCode();
            }
            return i12 + i11;
        }

        public void setMaxAmount(String str) {
            this.maxAmount = str;
        }

        public void setMaxQuantity(String str) {
            this.maxQuantity = str;
        }

        public void setMinAmount(String str) {
            this.minAmount = str;
        }

        public void setMinQuantity(String str) {
            this.minQuantity = str;
        }

        public void setPayMethodId(int i11) {
            this.payMethodId = i11;
        }

        public void setPayMethodName(String str) {
            this.payMethodName = str;
        }

        public String toString() {
            return "OtcTradeConfigListBean.PaymentDetail(payMethodId=" + getPayMethodId() + ", payMethodName=" + getPayMethodName() + ", minAmount=" + getMinAmount() + ", maxAmount=" + getMaxAmount() + ", minQuantity=" + getMinQuantity() + ", maxQuantity=" + getMaxQuantity() + ")";
        }
    }

    public static class QuoteAsset implements Serializable {
        private String name;
        private List<QuotePayments> quotePayments;
        private List<QuoteRunMode> quoteRunModes;
        private int scale;

        public boolean canEqual(Object obj) {
            return obj instanceof QuoteAsset;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof QuoteAsset)) {
                return false;
            }
            QuoteAsset quoteAsset = (QuoteAsset) obj;
            if (!quoteAsset.canEqual(this)) {
                return false;
            }
            String name2 = getName();
            String name3 = quoteAsset.getName();
            if (name2 != null ? !name2.equals(name3) : name3 != null) {
                return false;
            }
            if (getScale() != quoteAsset.getScale()) {
                return false;
            }
            List<QuotePayments> quotePayments2 = getQuotePayments();
            List<QuotePayments> quotePayments3 = quoteAsset.getQuotePayments();
            if (quotePayments2 != null ? !quotePayments2.equals(quotePayments3) : quotePayments3 != null) {
                return false;
            }
            List<QuoteRunMode> quoteRunModes2 = getQuoteRunModes();
            List<QuoteRunMode> quoteRunModes3 = quoteAsset.getQuoteRunModes();
            return quoteRunModes2 != null ? quoteRunModes2.equals(quoteRunModes3) : quoteRunModes3 == null;
        }

        public String getName() {
            return this.name;
        }

        public List<QuotePayments> getQuotePayments() {
            return this.quotePayments;
        }

        public List<QuoteRunMode> getQuoteRunModes() {
            return this.quoteRunModes;
        }

        public int getScale() {
            return this.scale;
        }

        public int hashCode() {
            String name2 = getName();
            int i11 = 43;
            int hashCode = (((name2 == null ? 43 : name2.hashCode()) + 59) * 59) + getScale();
            List<QuotePayments> quotePayments2 = getQuotePayments();
            int hashCode2 = (hashCode * 59) + (quotePayments2 == null ? 43 : quotePayments2.hashCode());
            List<QuoteRunMode> quoteRunModes2 = getQuoteRunModes();
            int i12 = hashCode2 * 59;
            if (quoteRunModes2 != null) {
                i11 = quoteRunModes2.hashCode();
            }
            return i12 + i11;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setQuotePayments(List<QuotePayments> list) {
            this.quotePayments = list;
        }

        public void setQuoteRunModes(List<QuoteRunMode> list) {
            this.quoteRunModes = list;
        }

        public void setScale(int i11) {
            this.scale = i11;
        }

        public String toString() {
            return "OtcTradeConfigListBean.QuoteAsset(name=" + getName() + ", scale=" + getScale() + ", quotePayments=" + getQuotePayments() + ", quoteRunModes=" + getQuoteRunModes() + ")";
        }
    }

    public static class QuotePayments implements Serializable {
        private String maxAmount;
        private String maxQuantity;
        private String minAmount;
        private String minQuantity;
        private int payMethodId;
        private String payMethodName;
        private List<PaymentDetail> paymentDetail;

        public boolean canEqual(Object obj) {
            return obj instanceof QuotePayments;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof QuotePayments)) {
                return false;
            }
            QuotePayments quotePayments = (QuotePayments) obj;
            if (!quotePayments.canEqual(this) || getPayMethodId() != quotePayments.getPayMethodId()) {
                return false;
            }
            String payMethodName2 = getPayMethodName();
            String payMethodName3 = quotePayments.getPayMethodName();
            if (payMethodName2 != null ? !payMethodName2.equals(payMethodName3) : payMethodName3 != null) {
                return false;
            }
            String minAmount2 = getMinAmount();
            String minAmount3 = quotePayments.getMinAmount();
            if (minAmount2 != null ? !minAmount2.equals(minAmount3) : minAmount3 != null) {
                return false;
            }
            String maxAmount2 = getMaxAmount();
            String maxAmount3 = quotePayments.getMaxAmount();
            if (maxAmount2 != null ? !maxAmount2.equals(maxAmount3) : maxAmount3 != null) {
                return false;
            }
            String minQuantity2 = getMinQuantity();
            String minQuantity3 = quotePayments.getMinQuantity();
            if (minQuantity2 != null ? !minQuantity2.equals(minQuantity3) : minQuantity3 != null) {
                return false;
            }
            String maxQuantity2 = getMaxQuantity();
            String maxQuantity3 = quotePayments.getMaxQuantity();
            if (maxQuantity2 != null ? !maxQuantity2.equals(maxQuantity3) : maxQuantity3 != null) {
                return false;
            }
            List<PaymentDetail> paymentDetail2 = getPaymentDetail();
            List<PaymentDetail> paymentDetail3 = quotePayments.getPaymentDetail();
            return paymentDetail2 != null ? paymentDetail2.equals(paymentDetail3) : paymentDetail3 == null;
        }

        public String getMaxAmount() {
            return this.maxAmount;
        }

        public String getMaxQuantity() {
            return this.maxQuantity;
        }

        public String getMinAmount() {
            return this.minAmount;
        }

        public String getMinQuantity() {
            return this.minQuantity;
        }

        public int getPayMethodId() {
            return this.payMethodId;
        }

        public String getPayMethodName() {
            return this.payMethodName;
        }

        public List<PaymentDetail> getPaymentDetail() {
            return this.paymentDetail;
        }

        public int hashCode() {
            String payMethodName2 = getPayMethodName();
            int i11 = 43;
            int payMethodId2 = ((getPayMethodId() + 59) * 59) + (payMethodName2 == null ? 43 : payMethodName2.hashCode());
            String minAmount2 = getMinAmount();
            int hashCode = (payMethodId2 * 59) + (minAmount2 == null ? 43 : minAmount2.hashCode());
            String maxAmount2 = getMaxAmount();
            int hashCode2 = (hashCode * 59) + (maxAmount2 == null ? 43 : maxAmount2.hashCode());
            String minQuantity2 = getMinQuantity();
            int hashCode3 = (hashCode2 * 59) + (minQuantity2 == null ? 43 : minQuantity2.hashCode());
            String maxQuantity2 = getMaxQuantity();
            int hashCode4 = (hashCode3 * 59) + (maxQuantity2 == null ? 43 : maxQuantity2.hashCode());
            List<PaymentDetail> paymentDetail2 = getPaymentDetail();
            int i12 = hashCode4 * 59;
            if (paymentDetail2 != null) {
                i11 = paymentDetail2.hashCode();
            }
            return i12 + i11;
        }

        public void setMaxAmount(String str) {
            this.maxAmount = str;
        }

        public void setMaxQuantity(String str) {
            this.maxQuantity = str;
        }

        public void setMinAmount(String str) {
            this.minAmount = str;
        }

        public void setMinQuantity(String str) {
            this.minQuantity = str;
        }

        public void setPayMethodId(int i11) {
            this.payMethodId = i11;
        }

        public void setPayMethodName(String str) {
            this.payMethodName = str;
        }

        public void setPaymentDetail(List<PaymentDetail> list) {
            this.paymentDetail = list;
        }

        public String toString() {
            return "OtcTradeConfigListBean.QuotePayments(payMethodId=" + getPayMethodId() + ", payMethodName=" + getPayMethodName() + ", minAmount=" + getMinAmount() + ", maxAmount=" + getMaxAmount() + ", minQuantity=" + getMinQuantity() + ", maxQuantity=" + getMaxQuantity() + ", paymentDetail=" + getPaymentDetail() + ")";
        }
    }

    public static class QuoteRunMode implements Serializable {
        private int code;

        public boolean canEqual(Object obj) {
            return obj instanceof QuoteRunMode;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof QuoteRunMode)) {
                return false;
            }
            QuoteRunMode quoteRunMode = (QuoteRunMode) obj;
            return quoteRunMode.canEqual(this) && getCode() == quoteRunMode.getCode();
        }

        public int getCode() {
            return this.code;
        }

        public int hashCode() {
            return 59 + getCode();
        }

        public void setCode(int i11) {
            this.code = i11;
        }

        public String toString() {
            return "OtcTradeConfigListBean.QuoteRunMode(code=" + getCode() + ")";
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof OtcTradeConfigListBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OtcTradeConfigListBean)) {
            return false;
        }
        OtcTradeConfigListBean otcTradeConfigListBean = (OtcTradeConfigListBean) obj;
        if (!otcTradeConfigListBean.canEqual(this)) {
            return false;
        }
        CryptoAsset cryptoAsset2 = getCryptoAsset();
        CryptoAsset cryptoAsset3 = otcTradeConfigListBean.getCryptoAsset();
        if (cryptoAsset2 != null ? !cryptoAsset2.equals(cryptoAsset3) : cryptoAsset3 != null) {
            return false;
        }
        List<QuoteAsset> quoteAsset2 = getQuoteAsset();
        List<QuoteAsset> quoteAsset3 = otcTradeConfigListBean.getQuoteAsset();
        return quoteAsset2 != null ? quoteAsset2.equals(quoteAsset3) : quoteAsset3 == null;
    }

    public CryptoAsset getCryptoAsset() {
        return this.cryptoAsset;
    }

    public List<QuoteAsset> getQuoteAsset() {
        return this.quoteAsset;
    }

    public int hashCode() {
        CryptoAsset cryptoAsset2 = getCryptoAsset();
        int i11 = 43;
        int hashCode = cryptoAsset2 == null ? 43 : cryptoAsset2.hashCode();
        List<QuoteAsset> quoteAsset2 = getQuoteAsset();
        int i12 = (hashCode + 59) * 59;
        if (quoteAsset2 != null) {
            i11 = quoteAsset2.hashCode();
        }
        return i12 + i11;
    }

    public void setCryptoAsset(CryptoAsset cryptoAsset2) {
        this.cryptoAsset = cryptoAsset2;
    }

    public void setQuoteAsset(List<QuoteAsset> list) {
        this.quoteAsset = list;
    }

    public String toString() {
        return "OtcTradeConfigListBean(cryptoAsset=" + getCryptoAsset() + ", quoteAsset=" + getQuoteAsset() + ")";
    }
}
