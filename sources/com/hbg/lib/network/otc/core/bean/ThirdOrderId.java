package com.hbg.lib.network.otc.core.bean;

import java.io.Serializable;

public class ThirdOrderId implements Serializable {
    public String acceptOrder;
    public String amount;
    public String callBackUrl;
    public String cryptoAsset;
    public String liquidityToken;
    public String orderId;
    public String paymentId;
    public String providerName;
    public String quantity;
    public String quoteAsset;
    public String submitUrl;
    public String uid;
    public String versionId;
    public String walletAddress;
    public String walletType;

    public boolean canEqual(Object obj) {
        return obj instanceof ThirdOrderId;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ThirdOrderId)) {
            return false;
        }
        ThirdOrderId thirdOrderId = (ThirdOrderId) obj;
        if (!thirdOrderId.canEqual(this)) {
            return false;
        }
        String orderId2 = getOrderId();
        String orderId3 = thirdOrderId.getOrderId();
        if (orderId2 != null ? !orderId2.equals(orderId3) : orderId3 != null) {
            return false;
        }
        String submitUrl2 = getSubmitUrl();
        String submitUrl3 = thirdOrderId.getSubmitUrl();
        if (submitUrl2 != null ? !submitUrl2.equals(submitUrl3) : submitUrl3 != null) {
            return false;
        }
        String callBackUrl2 = getCallBackUrl();
        String callBackUrl3 = thirdOrderId.getCallBackUrl();
        if (callBackUrl2 != null ? !callBackUrl2.equals(callBackUrl3) : callBackUrl3 != null) {
            return false;
        }
        String providerName2 = getProviderName();
        String providerName3 = thirdOrderId.getProviderName();
        if (providerName2 != null ? !providerName2.equals(providerName3) : providerName3 != null) {
            return false;
        }
        String versionId2 = getVersionId();
        String versionId3 = thirdOrderId.getVersionId();
        if (versionId2 != null ? !versionId2.equals(versionId3) : versionId3 != null) {
            return false;
        }
        String liquidityToken2 = getLiquidityToken();
        String liquidityToken3 = thirdOrderId.getLiquidityToken();
        if (liquidityToken2 != null ? !liquidityToken2.equals(liquidityToken3) : liquidityToken3 != null) {
            return false;
        }
        String paymentId2 = getPaymentId();
        String paymentId3 = thirdOrderId.getPaymentId();
        if (paymentId2 != null ? !paymentId2.equals(paymentId3) : paymentId3 != null) {
            return false;
        }
        String uid2 = getUid();
        String uid3 = thirdOrderId.getUid();
        if (uid2 != null ? !uid2.equals(uid3) : uid3 != null) {
            return false;
        }
        String walletAddress2 = getWalletAddress();
        String walletAddress3 = thirdOrderId.getWalletAddress();
        if (walletAddress2 != null ? !walletAddress2.equals(walletAddress3) : walletAddress3 != null) {
            return false;
        }
        String walletType2 = getWalletType();
        String walletType3 = thirdOrderId.getWalletType();
        if (walletType2 != null ? !walletType2.equals(walletType3) : walletType3 != null) {
            return false;
        }
        String quoteAsset2 = getQuoteAsset();
        String quoteAsset3 = thirdOrderId.getQuoteAsset();
        if (quoteAsset2 != null ? !quoteAsset2.equals(quoteAsset3) : quoteAsset3 != null) {
            return false;
        }
        String amount2 = getAmount();
        String amount3 = thirdOrderId.getAmount();
        if (amount2 != null ? !amount2.equals(amount3) : amount3 != null) {
            return false;
        }
        String cryptoAsset2 = getCryptoAsset();
        String cryptoAsset3 = thirdOrderId.getCryptoAsset();
        if (cryptoAsset2 != null ? !cryptoAsset2.equals(cryptoAsset3) : cryptoAsset3 != null) {
            return false;
        }
        String quantity2 = getQuantity();
        String quantity3 = thirdOrderId.getQuantity();
        if (quantity2 != null ? !quantity2.equals(quantity3) : quantity3 != null) {
            return false;
        }
        String acceptOrder2 = getAcceptOrder();
        String acceptOrder3 = thirdOrderId.getAcceptOrder();
        return acceptOrder2 != null ? acceptOrder2.equals(acceptOrder3) : acceptOrder3 == null;
    }

    public String getAcceptOrder() {
        return this.acceptOrder;
    }

    public String getAmount() {
        return this.amount;
    }

    public String getCallBackUrl() {
        return this.callBackUrl;
    }

    public String getCryptoAsset() {
        return this.cryptoAsset;
    }

    public String getLiquidityToken() {
        return this.liquidityToken;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public String getPaymentId() {
        return this.paymentId;
    }

    public String getProviderName() {
        return this.providerName;
    }

    public String getQuantity() {
        return this.quantity;
    }

    public String getQuoteAsset() {
        return this.quoteAsset;
    }

    public String getSubmitUrl() {
        return this.submitUrl;
    }

    public String getUid() {
        return this.uid;
    }

    public String getVersionId() {
        return this.versionId;
    }

    public String getWalletAddress() {
        return this.walletAddress;
    }

    public String getWalletType() {
        return this.walletType;
    }

    public int hashCode() {
        String orderId2 = getOrderId();
        int i11 = 43;
        int hashCode = orderId2 == null ? 43 : orderId2.hashCode();
        String submitUrl2 = getSubmitUrl();
        int hashCode2 = ((hashCode + 59) * 59) + (submitUrl2 == null ? 43 : submitUrl2.hashCode());
        String callBackUrl2 = getCallBackUrl();
        int hashCode3 = (hashCode2 * 59) + (callBackUrl2 == null ? 43 : callBackUrl2.hashCode());
        String providerName2 = getProviderName();
        int hashCode4 = (hashCode3 * 59) + (providerName2 == null ? 43 : providerName2.hashCode());
        String versionId2 = getVersionId();
        int hashCode5 = (hashCode4 * 59) + (versionId2 == null ? 43 : versionId2.hashCode());
        String liquidityToken2 = getLiquidityToken();
        int hashCode6 = (hashCode5 * 59) + (liquidityToken2 == null ? 43 : liquidityToken2.hashCode());
        String paymentId2 = getPaymentId();
        int hashCode7 = (hashCode6 * 59) + (paymentId2 == null ? 43 : paymentId2.hashCode());
        String uid2 = getUid();
        int hashCode8 = (hashCode7 * 59) + (uid2 == null ? 43 : uid2.hashCode());
        String walletAddress2 = getWalletAddress();
        int hashCode9 = (hashCode8 * 59) + (walletAddress2 == null ? 43 : walletAddress2.hashCode());
        String walletType2 = getWalletType();
        int hashCode10 = (hashCode9 * 59) + (walletType2 == null ? 43 : walletType2.hashCode());
        String quoteAsset2 = getQuoteAsset();
        int hashCode11 = (hashCode10 * 59) + (quoteAsset2 == null ? 43 : quoteAsset2.hashCode());
        String amount2 = getAmount();
        int hashCode12 = (hashCode11 * 59) + (amount2 == null ? 43 : amount2.hashCode());
        String cryptoAsset2 = getCryptoAsset();
        int hashCode13 = (hashCode12 * 59) + (cryptoAsset2 == null ? 43 : cryptoAsset2.hashCode());
        String quantity2 = getQuantity();
        int hashCode14 = (hashCode13 * 59) + (quantity2 == null ? 43 : quantity2.hashCode());
        String acceptOrder2 = getAcceptOrder();
        int i12 = hashCode14 * 59;
        if (acceptOrder2 != null) {
            i11 = acceptOrder2.hashCode();
        }
        return i12 + i11;
    }

    public void setAcceptOrder(String str) {
        this.acceptOrder = str;
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public void setCallBackUrl(String str) {
        this.callBackUrl = str;
    }

    public void setCryptoAsset(String str) {
        this.cryptoAsset = str;
    }

    public void setLiquidityToken(String str) {
        this.liquidityToken = str;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }

    public void setPaymentId(String str) {
        this.paymentId = str;
    }

    public void setProviderName(String str) {
        this.providerName = str;
    }

    public void setQuantity(String str) {
        this.quantity = str;
    }

    public void setQuoteAsset(String str) {
        this.quoteAsset = str;
    }

    public void setSubmitUrl(String str) {
        this.submitUrl = str;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void setVersionId(String str) {
        this.versionId = str;
    }

    public void setWalletAddress(String str) {
        this.walletAddress = str;
    }

    public void setWalletType(String str) {
        this.walletType = str;
    }

    public String toString() {
        return "ThirdOrderId(orderId=" + getOrderId() + ", submitUrl=" + getSubmitUrl() + ", callBackUrl=" + getCallBackUrl() + ", providerName=" + getProviderName() + ", versionId=" + getVersionId() + ", liquidityToken=" + getLiquidityToken() + ", paymentId=" + getPaymentId() + ", uid=" + getUid() + ", walletAddress=" + getWalletAddress() + ", walletType=" + getWalletType() + ", quoteAsset=" + getQuoteAsset() + ", amount=" + getAmount() + ", cryptoAsset=" + getCryptoAsset() + ", quantity=" + getQuantity() + ", acceptOrder=" + getAcceptOrder() + ")";
    }
}
