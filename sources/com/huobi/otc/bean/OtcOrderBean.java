package com.huobi.otc.bean;

import java.io.Serializable;
import va.b;

public class OtcOrderBean implements Serializable {
    public static final int BUSINESS_TYPE_BUY = 0;
    public static final int BUSINESS_TYPE_SELL = 1;
    public static final int ORDER_TYPE_FAST_BUY = 4;
    private String acceptStatus;
    private String amount;
    private Integer appCountDown;
    private Integer appMaxCountDown;
    private int areaType = 1;
    private String baseCoinAmount;
    private int baseCoinId;
    private String baseCoinName;
    private String baseCoinPrice;
    private int buyPayAccount;
    private long cancelCountDown;
    private int coinId;
    private Integer consultCancelCountDown;
    private int country;
    private String cryptoAssetName;
    private int currency;
    private String currencyStr;
    private String fee;
    private long gmtCreate;
    private String gmtCreateStr;
    private long gmtModified;
    private long gmtPay;
    private long gmtResetCancel;

    /* renamed from: id  reason: collision with root package name */
    private String f78267id;
    private int liquidDivision;
    private int matchPayId;
    private long now;
    private String orderNo;
    private int orderType;
    private String payCode;
    private String payMethod;
    private int payTerm;
    private String price;
    private String quantity;
    private String quoteAssetName;
    private Integer runMode;
    private int smallCoinId;
    private String smallCoinName;
    private int status;
    private String statusStr;
    private int thumbUp;
    private int tradeId;
    private int tradeMode;
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
        if (!otcOrderBean.canEqual(this)) {
            return false;
        }
        String id2 = getId();
        String id3 = otcOrderBean.getId();
        if (id2 != null ? !id2.equals(id3) : id3 != null) {
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
        if (getAreaType() != otcOrderBean.getAreaType()) {
            return false;
        }
        String payMethod2 = getPayMethod();
        String payMethod3 = otcOrderBean.getPayMethod();
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
        if (currencyStr2 != null ? !currencyStr2.equals(currencyStr3) : currencyStr3 != null) {
            return false;
        }
        if (getGmtResetCancel() != otcOrderBean.getGmtResetCancel() || getMatchPayId() != otcOrderBean.getMatchPayId() || getOrderType() != otcOrderBean.getOrderType()) {
            return false;
        }
        Integer runMode2 = getRunMode();
        Integer runMode3 = otcOrderBean.getRunMode();
        if (runMode2 != null ? !runMode2.equals(runMode3) : runMode3 != null) {
            return false;
        }
        if (getSmallCoinId() != otcOrderBean.getSmallCoinId()) {
            return false;
        }
        String smallCoinName2 = getSmallCoinName();
        String smallCoinName3 = otcOrderBean.getSmallCoinName();
        if (smallCoinName2 != null ? !smallCoinName2.equals(smallCoinName3) : smallCoinName3 != null) {
            return false;
        }
        if (getBaseCoinId() != otcOrderBean.getBaseCoinId()) {
            return false;
        }
        String baseCoinName2 = getBaseCoinName();
        String baseCoinName3 = otcOrderBean.getBaseCoinName();
        if (baseCoinName2 != null ? !baseCoinName2.equals(baseCoinName3) : baseCoinName3 != null) {
            return false;
        }
        String baseCoinAmount2 = getBaseCoinAmount();
        String baseCoinAmount3 = otcOrderBean.getBaseCoinAmount();
        if (baseCoinAmount2 != null ? !baseCoinAmount2.equals(baseCoinAmount3) : baseCoinAmount3 != null) {
            return false;
        }
        String baseCoinPrice2 = getBaseCoinPrice();
        String baseCoinPrice3 = otcOrderBean.getBaseCoinPrice();
        if (baseCoinPrice2 != null ? !baseCoinPrice2.equals(baseCoinPrice3) : baseCoinPrice3 != null) {
            return false;
        }
        if (getCancelCountDown() != otcOrderBean.getCancelCountDown()) {
            return false;
        }
        Integer appCountDown2 = getAppCountDown();
        Integer appCountDown3 = otcOrderBean.getAppCountDown();
        if (appCountDown2 != null ? !appCountDown2.equals(appCountDown3) : appCountDown3 != null) {
            return false;
        }
        Integer appMaxCountDown2 = getAppMaxCountDown();
        Integer appMaxCountDown3 = otcOrderBean.getAppMaxCountDown();
        if (appMaxCountDown2 != null ? !appMaxCountDown2.equals(appMaxCountDown3) : appMaxCountDown3 != null) {
            return false;
        }
        String acceptStatus2 = getAcceptStatus();
        String acceptStatus3 = otcOrderBean.getAcceptStatus();
        if (acceptStatus2 != null ? !acceptStatus2.equals(acceptStatus3) : acceptStatus3 != null) {
            return false;
        }
        if (getTradeMode() != otcOrderBean.getTradeMode()) {
            return false;
        }
        String quoteAssetName2 = getQuoteAssetName();
        String quoteAssetName3 = otcOrderBean.getQuoteAssetName();
        if (quoteAssetName2 != null ? !quoteAssetName2.equals(quoteAssetName3) : quoteAssetName3 != null) {
            return false;
        }
        String cryptoAssetName2 = getCryptoAssetName();
        String cryptoAssetName3 = otcOrderBean.getCryptoAssetName();
        if (cryptoAssetName2 != null ? !cryptoAssetName2.equals(cryptoAssetName3) : cryptoAssetName3 != null) {
            return false;
        }
        Integer consultCancelCountDown2 = getConsultCancelCountDown();
        Integer consultCancelCountDown3 = otcOrderBean.getConsultCancelCountDown();
        if (consultCancelCountDown2 != null ? consultCancelCountDown2.equals(consultCancelCountDown3) : consultCancelCountDown3 == null) {
            return getLiquidDivision() == otcOrderBean.getLiquidDivision() && getThumbUp() == otcOrderBean.getThumbUp();
        }
        return false;
    }

    public String getAcceptStatus() {
        return this.acceptStatus;
    }

    public String getAmount() {
        return this.amount;
    }

    public Integer getAppCountDown() {
        return this.appCountDown;
    }

    public Integer getAppMaxCountDown() {
        return this.appMaxCountDown;
    }

    public int getAreaType() {
        return this.areaType;
    }

    public String getBaseCoinAmount() {
        return this.baseCoinAmount;
    }

    public int getBaseCoinId() {
        return this.baseCoinId;
    }

    public String getBaseCoinName() {
        return this.baseCoinName;
    }

    public String getBaseCoinPrice() {
        return this.baseCoinPrice;
    }

    public int getBuyPayAccount() {
        return this.buyPayAccount;
    }

    public long getCancelCountDown() {
        return this.cancelCountDown;
    }

    public int getCoinId() {
        return this.coinId;
    }

    public String getCoinName() {
        return b.g(this.coinId);
    }

    public Integer getConsultCancelCountDown() {
        return this.consultCancelCountDown;
    }

    public int getCountry() {
        return this.country;
    }

    public String getCryptoAssetName() {
        return this.cryptoAssetName;
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

    public String getId() {
        return this.f78267id;
    }

    public int getLiquidDivision() {
        return this.liquidDivision;
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

    public String getPayMethod() {
        return this.payMethod;
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

    public String getQuoteAssetName() {
        return this.quoteAssetName;
    }

    public Integer getRunMode() {
        return this.runMode;
    }

    public int getSmallCoinId() {
        return this.smallCoinId;
    }

    public String getSmallCoinName() {
        return this.smallCoinName;
    }

    public int getStatus() {
        return this.status;
    }

    public String getStatusStr() {
        return this.statusStr;
    }

    public int getThumbUp() {
        return this.thumbUp;
    }

    public int getTradeId() {
        return this.tradeId;
    }

    public int getTradeMode() {
        return this.tradeMode;
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
        String id2 = getId();
        int i11 = 43;
        int hashCode = id2 == null ? 43 : id2.hashCode();
        String orderNo2 = getOrderNo();
        int hashCode2 = ((((((((hashCode + 59) * 59) + (orderNo2 == null ? 43 : orderNo2.hashCode())) * 59) + getTradeId()) * 59) + getTradeType()) * 59) + getCoinId();
        String price2 = getPrice();
        int hashCode3 = (hashCode2 * 59) + (price2 == null ? 43 : price2.hashCode());
        String quantity2 = getQuantity();
        int hashCode4 = (hashCode3 * 59) + (quantity2 == null ? 43 : quantity2.hashCode());
        String amount2 = getAmount();
        int hashCode5 = (((((hashCode4 * 59) + (amount2 == null ? 43 : amount2.hashCode())) * 59) + getCountry()) * 59) + getCurrency();
        String fee2 = getFee();
        int hashCode6 = (((hashCode5 * 59) + (fee2 == null ? 43 : fee2.hashCode())) * 59) + getStatus();
        String statusStr2 = getStatusStr();
        int hashCode7 = (((hashCode6 * 59) + (statusStr2 == null ? 43 : statusStr2.hashCode())) * 59) + getAreaType();
        String payMethod2 = getPayMethod();
        int hashCode8 = (((((hashCode7 * 59) + (payMethod2 == null ? 43 : payMethod2.hashCode())) * 59) + getBuyPayAccount()) * 59) + getPayTerm();
        String payCode2 = getPayCode();
        int hashCode9 = (hashCode8 * 59) + (payCode2 == null ? 43 : payCode2.hashCode());
        long gmtCreate2 = getGmtCreate();
        int i12 = (hashCode9 * 59) + ((int) (gmtCreate2 ^ (gmtCreate2 >>> 32)));
        String gmtCreateStr2 = getGmtCreateStr();
        int hashCode10 = (i12 * 59) + (gmtCreateStr2 == null ? 43 : gmtCreateStr2.hashCode());
        long gmtModified2 = getGmtModified();
        int i13 = (hashCode10 * 59) + ((int) (gmtModified2 ^ (gmtModified2 >>> 32)));
        long gmtPay2 = getGmtPay();
        int i14 = (i13 * 59) + ((int) (gmtPay2 ^ (gmtPay2 >>> 32)));
        String tradeNo2 = getTradeNo();
        int hashCode11 = (i14 * 59) + (tradeNo2 == null ? 43 : tradeNo2.hashCode());
        long now2 = getNow();
        int i15 = (hashCode11 * 59) + ((int) (now2 ^ (now2 >>> 32)));
        String tradeUserName2 = getTradeUserName();
        int hashCode12 = (i15 * 59) + (tradeUserName2 == null ? 43 : tradeUserName2.hashCode());
        String tradeRealName2 = getTradeRealName();
        int hashCode13 = (hashCode12 * 59) + (tradeRealName2 == null ? 43 : tradeRealName2.hashCode());
        long tradeUid2 = getTradeUid();
        int i16 = (hashCode13 * 59) + ((int) (tradeUid2 ^ (tradeUid2 >>> 32)));
        String currencyStr2 = getCurrencyStr();
        int hashCode14 = (i16 * 59) + (currencyStr2 == null ? 43 : currencyStr2.hashCode());
        long gmtResetCancel2 = getGmtResetCancel();
        int matchPayId2 = (((((hashCode14 * 59) + ((int) (gmtResetCancel2 ^ (gmtResetCancel2 >>> 32)))) * 59) + getMatchPayId()) * 59) + getOrderType();
        Integer runMode2 = getRunMode();
        int hashCode15 = (((matchPayId2 * 59) + (runMode2 == null ? 43 : runMode2.hashCode())) * 59) + getSmallCoinId();
        String smallCoinName2 = getSmallCoinName();
        int hashCode16 = (((hashCode15 * 59) + (smallCoinName2 == null ? 43 : smallCoinName2.hashCode())) * 59) + getBaseCoinId();
        String baseCoinName2 = getBaseCoinName();
        int hashCode17 = (hashCode16 * 59) + (baseCoinName2 == null ? 43 : baseCoinName2.hashCode());
        String baseCoinAmount2 = getBaseCoinAmount();
        int hashCode18 = (hashCode17 * 59) + (baseCoinAmount2 == null ? 43 : baseCoinAmount2.hashCode());
        String baseCoinPrice2 = getBaseCoinPrice();
        int hashCode19 = (hashCode18 * 59) + (baseCoinPrice2 == null ? 43 : baseCoinPrice2.hashCode());
        long cancelCountDown2 = getCancelCountDown();
        int i17 = (hashCode19 * 59) + ((int) (cancelCountDown2 ^ (cancelCountDown2 >>> 32)));
        Integer appCountDown2 = getAppCountDown();
        int hashCode20 = (i17 * 59) + (appCountDown2 == null ? 43 : appCountDown2.hashCode());
        Integer appMaxCountDown2 = getAppMaxCountDown();
        int hashCode21 = (hashCode20 * 59) + (appMaxCountDown2 == null ? 43 : appMaxCountDown2.hashCode());
        String acceptStatus2 = getAcceptStatus();
        int hashCode22 = (((hashCode21 * 59) + (acceptStatus2 == null ? 43 : acceptStatus2.hashCode())) * 59) + getTradeMode();
        String quoteAssetName2 = getQuoteAssetName();
        int hashCode23 = (hashCode22 * 59) + (quoteAssetName2 == null ? 43 : quoteAssetName2.hashCode());
        String cryptoAssetName2 = getCryptoAssetName();
        int hashCode24 = (hashCode23 * 59) + (cryptoAssetName2 == null ? 43 : cryptoAssetName2.hashCode());
        Integer consultCancelCountDown2 = getConsultCancelCountDown();
        int i18 = hashCode24 * 59;
        if (consultCancelCountDown2 != null) {
            i11 = consultCancelCountDown2.hashCode();
        }
        return ((((i18 + i11) * 59) + getLiquidDivision()) * 59) + getThumbUp();
    }

    public boolean isFastBuy() {
        return this.orderType == 4;
    }

    public boolean isP2pPayOrder() {
        return this.liquidDivision == 3;
    }

    public boolean isSeller() {
        return this.tradeType == Integer.parseInt("1");
    }

    public boolean isThirdOrder() {
        return getLiquidDivision() == 4;
    }

    public boolean isThirdPayOrder() {
        return this.liquidDivision == 4;
    }

    public void setAcceptStatus(String str) {
        this.acceptStatus = str;
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public void setAppCountDown(Integer num) {
        this.appCountDown = num;
    }

    public void setAppMaxCountDown(Integer num) {
        this.appMaxCountDown = num;
    }

    public void setAreaType(int i11) {
        this.areaType = i11;
    }

    public void setBaseCoinAmount(String str) {
        this.baseCoinAmount = str;
    }

    public void setBaseCoinId(int i11) {
        this.baseCoinId = i11;
    }

    public void setBaseCoinName(String str) {
        this.baseCoinName = str;
    }

    public void setBaseCoinPrice(String str) {
        this.baseCoinPrice = str;
    }

    public void setBuyPayAccount(int i11) {
        this.buyPayAccount = i11;
    }

    public void setCancelCountDown(long j11) {
        this.cancelCountDown = j11;
    }

    public void setCoinId(int i11) {
        this.coinId = i11;
    }

    public void setConsultCancelCountDown(Integer num) {
        this.consultCancelCountDown = num;
    }

    public void setCountry(int i11) {
        this.country = i11;
    }

    public void setCryptoAssetName(String str) {
        this.cryptoAssetName = str;
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

    public void setId(String str) {
        this.f78267id = str;
    }

    public void setLiquidDivision(int i11) {
        this.liquidDivision = i11;
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

    public void setQuoteAssetName(String str) {
        this.quoteAssetName = str;
    }

    public void setRunMode(Integer num) {
        this.runMode = num;
    }

    public void setSmallCoinId(int i11) {
        this.smallCoinId = i11;
    }

    public void setSmallCoinName(String str) {
        this.smallCoinName = str;
    }

    public void setStatus(int i11) {
        this.status = i11;
    }

    public void setStatusStr(String str) {
        this.statusStr = str;
    }

    public void setThumbUp(int i11) {
        this.thumbUp = i11;
    }

    public void setTradeId(int i11) {
        this.tradeId = i11;
    }

    public void setTradeMode(int i11) {
        this.tradeMode = i11;
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
        return "OtcOrderBean(id=" + getId() + ", orderNo=" + getOrderNo() + ", tradeId=" + getTradeId() + ", tradeType=" + getTradeType() + ", coinId=" + getCoinId() + ", price=" + getPrice() + ", quantity=" + getQuantity() + ", amount=" + getAmount() + ", country=" + getCountry() + ", currency=" + getCurrency() + ", fee=" + getFee() + ", status=" + getStatus() + ", statusStr=" + getStatusStr() + ", areaType=" + getAreaType() + ", payMethod=" + getPayMethod() + ", buyPayAccount=" + getBuyPayAccount() + ", payTerm=" + getPayTerm() + ", payCode=" + getPayCode() + ", gmtCreate=" + getGmtCreate() + ", gmtCreateStr=" + getGmtCreateStr() + ", gmtModified=" + getGmtModified() + ", gmtPay=" + getGmtPay() + ", tradeNo=" + getTradeNo() + ", now=" + getNow() + ", tradeUserName=" + getTradeUserName() + ", tradeRealName=" + getTradeRealName() + ", tradeUid=" + getTradeUid() + ", currencyStr=" + getCurrencyStr() + ", gmtResetCancel=" + getGmtResetCancel() + ", matchPayId=" + getMatchPayId() + ", orderType=" + getOrderType() + ", runMode=" + getRunMode() + ", smallCoinId=" + getSmallCoinId() + ", smallCoinName=" + getSmallCoinName() + ", baseCoinId=" + getBaseCoinId() + ", baseCoinName=" + getBaseCoinName() + ", baseCoinAmount=" + getBaseCoinAmount() + ", baseCoinPrice=" + getBaseCoinPrice() + ", cancelCountDown=" + getCancelCountDown() + ", appCountDown=" + getAppCountDown() + ", appMaxCountDown=" + getAppMaxCountDown() + ", acceptStatus=" + getAcceptStatus() + ", tradeMode=" + getTradeMode() + ", quoteAssetName=" + getQuoteAssetName() + ", cryptoAssetName=" + getCryptoAssetName() + ", consultCancelCountDown=" + getConsultCancelCountDown() + ", liquidDivision=" + getLiquidDivision() + ", thumbUp=" + getThumbUp() + ")";
    }
}
