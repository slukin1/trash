package com.hbg.lib.network.otc.core.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class OtcOrderDetailBean implements Serializable {
    private AppealInfo appealInfo;
    private C2cOrder c2cOrder;
    private CouponsInfo couponsInfo;
    private ExchangeOrder exchangeOrder;
    private FeeInfo feeInfo;
    private HbPayOrder hbPayOrder;
    private boolean inNegotiation;
    private List<OrderCancelConsults> orderCancelConsults;
    private OrderInfo orderInfo;
    private OrderSnapshot orderSnapshot;
    private OrderTag orderTag;
    private OtherInfo otherInfo;
    private List<PaymentMethod> paymentMethod;

    public static class AppealInfo implements Serializable {
        private String appealCode;
        private String appealReason;
        private int beforeStatus;
        private boolean isCancel;
        private int status;
        private int type;
        private int typeSecond;

        public boolean canEqual(Object obj) {
            return obj instanceof AppealInfo;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof AppealInfo)) {
                return false;
            }
            AppealInfo appealInfo = (AppealInfo) obj;
            if (!appealInfo.canEqual(this)) {
                return false;
            }
            String appealCode2 = getAppealCode();
            String appealCode3 = appealInfo.getAppealCode();
            if (appealCode2 != null ? !appealCode2.equals(appealCode3) : appealCode3 != null) {
                return false;
            }
            if (isCancel() != appealInfo.isCancel() || getType() != appealInfo.getType() || getStatus() != appealInfo.getStatus() || getTypeSecond() != appealInfo.getTypeSecond()) {
                return false;
            }
            String appealReason2 = getAppealReason();
            String appealReason3 = appealInfo.getAppealReason();
            if (appealReason2 != null ? appealReason2.equals(appealReason3) : appealReason3 == null) {
                return getBeforeStatus() == appealInfo.getBeforeStatus();
            }
            return false;
        }

        public String getAppealCode() {
            return this.appealCode;
        }

        public String getAppealReason() {
            return this.appealReason;
        }

        public int getBeforeStatus() {
            return this.beforeStatus;
        }

        public int getStatus() {
            return this.status;
        }

        public int getType() {
            return this.type;
        }

        public int getTypeSecond() {
            return this.typeSecond;
        }

        public int hashCode() {
            String appealCode2 = getAppealCode();
            int i11 = 43;
            int hashCode = (((((((((appealCode2 == null ? 43 : appealCode2.hashCode()) + 59) * 59) + (isCancel() ? 79 : 97)) * 59) + getType()) * 59) + getStatus()) * 59) + getTypeSecond();
            String appealReason2 = getAppealReason();
            int i12 = hashCode * 59;
            if (appealReason2 != null) {
                i11 = appealReason2.hashCode();
            }
            return ((i12 + i11) * 59) + getBeforeStatus();
        }

        public boolean isCancel() {
            return this.isCancel;
        }

        public void setAppealCode(String str) {
            this.appealCode = str;
        }

        public void setAppealReason(String str) {
            this.appealReason = str;
        }

        public void setBeforeStatus(int i11) {
            this.beforeStatus = i11;
        }

        public void setCancel(boolean z11) {
            this.isCancel = z11;
        }

        public void setStatus(int i11) {
            this.status = i11;
        }

        public void setType(int i11) {
            this.type = i11;
        }

        public void setTypeSecond(int i11) {
            this.typeSecond = i11;
        }

        public String toString() {
            return "OtcOrderDetailBean.AppealInfo(appealCode=" + getAppealCode() + ", isCancel=" + isCancel() + ", type=" + getType() + ", status=" + getStatus() + ", typeSecond=" + getTypeSecond() + ", appealReason=" + getAppealReason() + ", beforeStatus=" + getBeforeStatus() + ")";
        }
    }

    public static class C2cOrder implements Serializable {
        private String acceptStatus;
        private String amount;
        private Integer appCountDown;
        private Integer appMaxCountDown;
        private Integer buyPayAccount;
        private long cancelCountDown;
        private Integer consultCancelCountDown;
        private String cryptoAssetName;
        private String gmtPay;
        private Long gmtResetCancel;
        private Integer matchPayId;
        private String orderStatus;
        private String payCode;
        private int payTerm;
        private String quantity;
        private String quote;
        private String quoteAssetName;
        private long waitCompletedCountDown;

        public boolean canEqual(Object obj) {
            return obj instanceof C2cOrder;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C2cOrder)) {
                return false;
            }
            C2cOrder c2cOrder = (C2cOrder) obj;
            if (!c2cOrder.canEqual(this)) {
                return false;
            }
            Integer matchPayId2 = getMatchPayId();
            Integer matchPayId3 = c2cOrder.getMatchPayId();
            if (matchPayId2 != null ? !matchPayId2.equals(matchPayId3) : matchPayId3 != null) {
                return false;
            }
            if (getPayTerm() != c2cOrder.getPayTerm()) {
                return false;
            }
            String payCode2 = getPayCode();
            String payCode3 = c2cOrder.getPayCode();
            if (payCode2 != null ? !payCode2.equals(payCode3) : payCode3 != null) {
                return false;
            }
            String quote2 = getQuote();
            String quote3 = c2cOrder.getQuote();
            if (quote2 != null ? !quote2.equals(quote3) : quote3 != null) {
                return false;
            }
            String amount2 = getAmount();
            String amount3 = c2cOrder.getAmount();
            if (amount2 != null ? !amount2.equals(amount3) : amount3 != null) {
                return false;
            }
            String quantity2 = getQuantity();
            String quantity3 = c2cOrder.getQuantity();
            if (quantity2 != null ? !quantity2.equals(quantity3) : quantity3 != null) {
                return false;
            }
            String quoteAssetName2 = getQuoteAssetName();
            String quoteAssetName3 = c2cOrder.getQuoteAssetName();
            if (quoteAssetName2 != null ? !quoteAssetName2.equals(quoteAssetName3) : quoteAssetName3 != null) {
                return false;
            }
            String cryptoAssetName2 = getCryptoAssetName();
            String cryptoAssetName3 = c2cOrder.getCryptoAssetName();
            if (cryptoAssetName2 != null ? !cryptoAssetName2.equals(cryptoAssetName3) : cryptoAssetName3 != null) {
                return false;
            }
            String gmtPay2 = getGmtPay();
            String gmtPay3 = c2cOrder.getGmtPay();
            if (gmtPay2 != null ? !gmtPay2.equals(gmtPay3) : gmtPay3 != null) {
                return false;
            }
            Long gmtResetCancel2 = getGmtResetCancel();
            Long gmtResetCancel3 = c2cOrder.getGmtResetCancel();
            if (gmtResetCancel2 != null ? !gmtResetCancel2.equals(gmtResetCancel3) : gmtResetCancel3 != null) {
                return false;
            }
            if (getCancelCountDown() != c2cOrder.getCancelCountDown() || getWaitCompletedCountDown() != c2cOrder.getWaitCompletedCountDown()) {
                return false;
            }
            Integer buyPayAccount2 = getBuyPayAccount();
            Integer buyPayAccount3 = c2cOrder.getBuyPayAccount();
            if (buyPayAccount2 != null ? !buyPayAccount2.equals(buyPayAccount3) : buyPayAccount3 != null) {
                return false;
            }
            Integer appCountDown2 = getAppCountDown();
            Integer appCountDown3 = c2cOrder.getAppCountDown();
            if (appCountDown2 != null ? !appCountDown2.equals(appCountDown3) : appCountDown3 != null) {
                return false;
            }
            Integer appMaxCountDown2 = getAppMaxCountDown();
            Integer appMaxCountDown3 = c2cOrder.getAppMaxCountDown();
            if (appMaxCountDown2 != null ? !appMaxCountDown2.equals(appMaxCountDown3) : appMaxCountDown3 != null) {
                return false;
            }
            String acceptStatus2 = getAcceptStatus();
            String acceptStatus3 = c2cOrder.getAcceptStatus();
            if (acceptStatus2 != null ? !acceptStatus2.equals(acceptStatus3) : acceptStatus3 != null) {
                return false;
            }
            String orderStatus2 = getOrderStatus();
            String orderStatus3 = c2cOrder.getOrderStatus();
            if (orderStatus2 != null ? !orderStatus2.equals(orderStatus3) : orderStatus3 != null) {
                return false;
            }
            Integer consultCancelCountDown2 = getConsultCancelCountDown();
            Integer consultCancelCountDown3 = c2cOrder.getConsultCancelCountDown();
            return consultCancelCountDown2 != null ? consultCancelCountDown2.equals(consultCancelCountDown3) : consultCancelCountDown3 == null;
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

        public Integer getBuyPayAccount() {
            return this.buyPayAccount;
        }

        public long getCancelCountDown() {
            return this.cancelCountDown;
        }

        public Integer getConsultCancelCountDown() {
            return this.consultCancelCountDown;
        }

        public String getCryptoAssetName() {
            return this.cryptoAssetName;
        }

        public String getGmtPay() {
            return this.gmtPay;
        }

        public Long getGmtResetCancel() {
            return this.gmtResetCancel;
        }

        public Integer getMatchPayId() {
            return this.matchPayId;
        }

        public String getOrderStatus() {
            return this.orderStatus;
        }

        public String getPayCode() {
            return this.payCode;
        }

        public int getPayTerm() {
            return this.payTerm;
        }

        public String getQuantity() {
            return this.quantity;
        }

        public String getQuote() {
            return this.quote;
        }

        public String getQuoteAssetName() {
            return this.quoteAssetName;
        }

        public long getWaitCompletedCountDown() {
            return this.waitCompletedCountDown;
        }

        public int hashCode() {
            Integer matchPayId2 = getMatchPayId();
            int i11 = 43;
            int hashCode = (((matchPayId2 == null ? 43 : matchPayId2.hashCode()) + 59) * 59) + getPayTerm();
            String payCode2 = getPayCode();
            int hashCode2 = (hashCode * 59) + (payCode2 == null ? 43 : payCode2.hashCode());
            String quote2 = getQuote();
            int hashCode3 = (hashCode2 * 59) + (quote2 == null ? 43 : quote2.hashCode());
            String amount2 = getAmount();
            int hashCode4 = (hashCode3 * 59) + (amount2 == null ? 43 : amount2.hashCode());
            String quantity2 = getQuantity();
            int hashCode5 = (hashCode4 * 59) + (quantity2 == null ? 43 : quantity2.hashCode());
            String quoteAssetName2 = getQuoteAssetName();
            int hashCode6 = (hashCode5 * 59) + (quoteAssetName2 == null ? 43 : quoteAssetName2.hashCode());
            String cryptoAssetName2 = getCryptoAssetName();
            int hashCode7 = (hashCode6 * 59) + (cryptoAssetName2 == null ? 43 : cryptoAssetName2.hashCode());
            String gmtPay2 = getGmtPay();
            int hashCode8 = (hashCode7 * 59) + (gmtPay2 == null ? 43 : gmtPay2.hashCode());
            Long gmtResetCancel2 = getGmtResetCancel();
            int hashCode9 = (hashCode8 * 59) + (gmtResetCancel2 == null ? 43 : gmtResetCancel2.hashCode());
            long cancelCountDown2 = getCancelCountDown();
            int i12 = (hashCode9 * 59) + ((int) (cancelCountDown2 ^ (cancelCountDown2 >>> 32)));
            long waitCompletedCountDown2 = getWaitCompletedCountDown();
            int i13 = (i12 * 59) + ((int) (waitCompletedCountDown2 ^ (waitCompletedCountDown2 >>> 32)));
            Integer buyPayAccount2 = getBuyPayAccount();
            int hashCode10 = (i13 * 59) + (buyPayAccount2 == null ? 43 : buyPayAccount2.hashCode());
            Integer appCountDown2 = getAppCountDown();
            int hashCode11 = (hashCode10 * 59) + (appCountDown2 == null ? 43 : appCountDown2.hashCode());
            Integer appMaxCountDown2 = getAppMaxCountDown();
            int hashCode12 = (hashCode11 * 59) + (appMaxCountDown2 == null ? 43 : appMaxCountDown2.hashCode());
            String acceptStatus2 = getAcceptStatus();
            int hashCode13 = (hashCode12 * 59) + (acceptStatus2 == null ? 43 : acceptStatus2.hashCode());
            String orderStatus2 = getOrderStatus();
            int hashCode14 = (hashCode13 * 59) + (orderStatus2 == null ? 43 : orderStatus2.hashCode());
            Integer consultCancelCountDown2 = getConsultCancelCountDown();
            int i14 = hashCode14 * 59;
            if (consultCancelCountDown2 != null) {
                i11 = consultCancelCountDown2.hashCode();
            }
            return i14 + i11;
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

        public void setBuyPayAccount(Integer num) {
            this.buyPayAccount = num;
        }

        public void setCancelCountDown(long j11) {
            this.cancelCountDown = j11;
        }

        public void setConsultCancelCountDown(Integer num) {
            this.consultCancelCountDown = num;
        }

        public void setCryptoAssetName(String str) {
            this.cryptoAssetName = str;
        }

        public void setGmtPay(String str) {
            this.gmtPay = str;
        }

        public void setGmtResetCancel(Long l11) {
            this.gmtResetCancel = l11;
        }

        public void setMatchPayId(Integer num) {
            this.matchPayId = num;
        }

        public void setOrderStatus(String str) {
            this.orderStatus = str;
        }

        public void setPayCode(String str) {
            this.payCode = str;
        }

        public void setPayTerm(int i11) {
            this.payTerm = i11;
        }

        public void setQuantity(String str) {
            this.quantity = str;
        }

        public void setQuote(String str) {
            this.quote = str;
        }

        public void setQuoteAssetName(String str) {
            this.quoteAssetName = str;
        }

        public void setWaitCompletedCountDown(long j11) {
            this.waitCompletedCountDown = j11;
        }

        public String toString() {
            return "OtcOrderDetailBean.C2cOrder(matchPayId=" + getMatchPayId() + ", payTerm=" + getPayTerm() + ", payCode=" + getPayCode() + ", quote=" + getQuote() + ", amount=" + getAmount() + ", quantity=" + getQuantity() + ", quoteAssetName=" + getQuoteAssetName() + ", cryptoAssetName=" + getCryptoAssetName() + ", gmtPay=" + getGmtPay() + ", gmtResetCancel=" + getGmtResetCancel() + ", cancelCountDown=" + getCancelCountDown() + ", waitCompletedCountDown=" + getWaitCompletedCountDown() + ", buyPayAccount=" + getBuyPayAccount() + ", appCountDown=" + getAppCountDown() + ", appMaxCountDown=" + getAppMaxCountDown() + ", acceptStatus=" + getAcceptStatus() + ", orderStatus=" + getOrderStatus() + ", consultCancelCountDown=" + getConsultCancelCountDown() + ")";
        }
    }

    public static class CouponsInfo implements Serializable {
        private String amount;
        private String describe;
        private String quantity;
        private String totalAmount;

        public boolean canEqual(Object obj) {
            return obj instanceof CouponsInfo;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof CouponsInfo)) {
                return false;
            }
            CouponsInfo couponsInfo = (CouponsInfo) obj;
            if (!couponsInfo.canEqual(this)) {
                return false;
            }
            String amount2 = getAmount();
            String amount3 = couponsInfo.getAmount();
            if (amount2 != null ? !amount2.equals(amount3) : amount3 != null) {
                return false;
            }
            String quantity2 = getQuantity();
            String quantity3 = couponsInfo.getQuantity();
            if (quantity2 != null ? !quantity2.equals(quantity3) : quantity3 != null) {
                return false;
            }
            String totalAmount2 = getTotalAmount();
            String totalAmount3 = couponsInfo.getTotalAmount();
            if (totalAmount2 != null ? !totalAmount2.equals(totalAmount3) : totalAmount3 != null) {
                return false;
            }
            String describe2 = getDescribe();
            String describe3 = couponsInfo.getDescribe();
            return describe2 != null ? describe2.equals(describe3) : describe3 == null;
        }

        public String getAmount() {
            return this.amount;
        }

        public String getDescribe() {
            return this.describe;
        }

        public String getQuantity() {
            return this.quantity;
        }

        public String getTotalAmount() {
            return this.totalAmount;
        }

        public int hashCode() {
            String amount2 = getAmount();
            int i11 = 43;
            int hashCode = amount2 == null ? 43 : amount2.hashCode();
            String quantity2 = getQuantity();
            int hashCode2 = ((hashCode + 59) * 59) + (quantity2 == null ? 43 : quantity2.hashCode());
            String totalAmount2 = getTotalAmount();
            int hashCode3 = (hashCode2 * 59) + (totalAmount2 == null ? 43 : totalAmount2.hashCode());
            String describe2 = getDescribe();
            int i12 = hashCode3 * 59;
            if (describe2 != null) {
                i11 = describe2.hashCode();
            }
            return i12 + i11;
        }

        public void setAmount(String str) {
            this.amount = str;
        }

        public void setDescribe(String str) {
            this.describe = str;
        }

        public void setQuantity(String str) {
            this.quantity = str;
        }

        public void setTotalAmount(String str) {
            this.totalAmount = str;
        }

        public String toString() {
            return "OtcOrderDetailBean.CouponsInfo(amount=" + getAmount() + ", quantity=" + getQuantity() + ", totalAmount=" + getTotalAmount() + ", describe=" + getDescribe() + ")";
        }
    }

    public static class ExchangeOrder implements Serializable {
        private String amount;
        private int cryptoAssetId;
        private String cryptoAssetName;
        private String cryptoAssetSymbol;
        private String quantity;
        private String quote;
        private int quoteAssetId;
        private String quoteAssetName;
        private String quoteAssetSymbol;

        public boolean canEqual(Object obj) {
            return obj instanceof ExchangeOrder;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ExchangeOrder)) {
                return false;
            }
            ExchangeOrder exchangeOrder = (ExchangeOrder) obj;
            if (!exchangeOrder.canEqual(this) || getQuoteAssetId() != exchangeOrder.getQuoteAssetId()) {
                return false;
            }
            String quoteAssetName2 = getQuoteAssetName();
            String quoteAssetName3 = exchangeOrder.getQuoteAssetName();
            if (quoteAssetName2 != null ? !quoteAssetName2.equals(quoteAssetName3) : quoteAssetName3 != null) {
                return false;
            }
            String quoteAssetSymbol2 = getQuoteAssetSymbol();
            String quoteAssetSymbol3 = exchangeOrder.getQuoteAssetSymbol();
            if (quoteAssetSymbol2 != null ? !quoteAssetSymbol2.equals(quoteAssetSymbol3) : quoteAssetSymbol3 != null) {
                return false;
            }
            if (getCryptoAssetId() != exchangeOrder.getCryptoAssetId()) {
                return false;
            }
            String cryptoAssetName2 = getCryptoAssetName();
            String cryptoAssetName3 = exchangeOrder.getCryptoAssetName();
            if (cryptoAssetName2 != null ? !cryptoAssetName2.equals(cryptoAssetName3) : cryptoAssetName3 != null) {
                return false;
            }
            String cryptoAssetSymbol2 = getCryptoAssetSymbol();
            String cryptoAssetSymbol3 = exchangeOrder.getCryptoAssetSymbol();
            if (cryptoAssetSymbol2 != null ? !cryptoAssetSymbol2.equals(cryptoAssetSymbol3) : cryptoAssetSymbol3 != null) {
                return false;
            }
            String quote2 = getQuote();
            String quote3 = exchangeOrder.getQuote();
            if (quote2 != null ? !quote2.equals(quote3) : quote3 != null) {
                return false;
            }
            String amount2 = getAmount();
            String amount3 = exchangeOrder.getAmount();
            if (amount2 != null ? !amount2.equals(amount3) : amount3 != null) {
                return false;
            }
            String quantity2 = getQuantity();
            String quantity3 = exchangeOrder.getQuantity();
            return quantity2 != null ? quantity2.equals(quantity3) : quantity3 == null;
        }

        public String getAmount() {
            return this.amount;
        }

        public int getCryptoAssetId() {
            return this.cryptoAssetId;
        }

        public String getCryptoAssetName() {
            return this.cryptoAssetName;
        }

        public String getCryptoAssetSymbol() {
            return this.cryptoAssetSymbol;
        }

        public String getQuantity() {
            return this.quantity;
        }

        public String getQuote() {
            return this.quote;
        }

        public int getQuoteAssetId() {
            return this.quoteAssetId;
        }

        public String getQuoteAssetName() {
            return this.quoteAssetName;
        }

        public String getQuoteAssetSymbol() {
            return this.quoteAssetSymbol;
        }

        public int hashCode() {
            String quoteAssetName2 = getQuoteAssetName();
            int i11 = 43;
            int quoteAssetId2 = ((getQuoteAssetId() + 59) * 59) + (quoteAssetName2 == null ? 43 : quoteAssetName2.hashCode());
            String quoteAssetSymbol2 = getQuoteAssetSymbol();
            int hashCode = (((quoteAssetId2 * 59) + (quoteAssetSymbol2 == null ? 43 : quoteAssetSymbol2.hashCode())) * 59) + getCryptoAssetId();
            String cryptoAssetName2 = getCryptoAssetName();
            int hashCode2 = (hashCode * 59) + (cryptoAssetName2 == null ? 43 : cryptoAssetName2.hashCode());
            String cryptoAssetSymbol2 = getCryptoAssetSymbol();
            int hashCode3 = (hashCode2 * 59) + (cryptoAssetSymbol2 == null ? 43 : cryptoAssetSymbol2.hashCode());
            String quote2 = getQuote();
            int hashCode4 = (hashCode3 * 59) + (quote2 == null ? 43 : quote2.hashCode());
            String amount2 = getAmount();
            int hashCode5 = (hashCode4 * 59) + (amount2 == null ? 43 : amount2.hashCode());
            String quantity2 = getQuantity();
            int i12 = hashCode5 * 59;
            if (quantity2 != null) {
                i11 = quantity2.hashCode();
            }
            return i12 + i11;
        }

        public void setAmount(String str) {
            this.amount = str;
        }

        public void setCryptoAssetId(int i11) {
            this.cryptoAssetId = i11;
        }

        public void setCryptoAssetName(String str) {
            this.cryptoAssetName = str;
        }

        public void setCryptoAssetSymbol(String str) {
            this.cryptoAssetSymbol = str;
        }

        public void setQuantity(String str) {
            this.quantity = str;
        }

        public void setQuote(String str) {
            this.quote = str;
        }

        public void setQuoteAssetId(int i11) {
            this.quoteAssetId = i11;
        }

        public void setQuoteAssetName(String str) {
            this.quoteAssetName = str;
        }

        public void setQuoteAssetSymbol(String str) {
            this.quoteAssetSymbol = str;
        }

        public String toString() {
            return "OtcOrderDetailBean.ExchangeOrder(quoteAssetId=" + getQuoteAssetId() + ", quoteAssetName=" + getQuoteAssetName() + ", quoteAssetSymbol=" + getQuoteAssetSymbol() + ", cryptoAssetId=" + getCryptoAssetId() + ", cryptoAssetName=" + getCryptoAssetName() + ", cryptoAssetSymbol=" + getCryptoAssetSymbol() + ", quote=" + getQuote() + ", amount=" + getAmount() + ", quantity=" + getQuantity() + ")";
        }
    }

    public static class FeeDetail implements Serializable {
        public static final int FEE_STATUS_ABORT = 4;
        public static final int FEE_STATUS_FAILURE = 3;
        public static final int FEE_STATUS_SUCCESSFUL = 2;
        public static final int FEE_STATUS_UNFINISHED = 1;
        private String fee;
        private String feeName;
        private int feeStatus;
        private int feeType;

        public boolean canEqual(Object obj) {
            return obj instanceof FeeDetail;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof FeeDetail)) {
                return false;
            }
            FeeDetail feeDetail = (FeeDetail) obj;
            if (!feeDetail.canEqual(this) || getFeeType() != feeDetail.getFeeType() || getFeeStatus() != feeDetail.getFeeStatus()) {
                return false;
            }
            String fee2 = getFee();
            String fee3 = feeDetail.getFee();
            if (fee2 != null ? !fee2.equals(fee3) : fee3 != null) {
                return false;
            }
            String feeName2 = getFeeName();
            String feeName3 = feeDetail.getFeeName();
            return feeName2 != null ? feeName2.equals(feeName3) : feeName3 == null;
        }

        public String getFee() {
            return this.fee;
        }

        public String getFeeName() {
            return this.feeName;
        }

        public int getFeeStatus() {
            return this.feeStatus;
        }

        public int getFeeType() {
            return this.feeType;
        }

        public int hashCode() {
            int feeType2 = ((getFeeType() + 59) * 59) + getFeeStatus();
            String fee2 = getFee();
            int i11 = 43;
            int hashCode = (feeType2 * 59) + (fee2 == null ? 43 : fee2.hashCode());
            String feeName2 = getFeeName();
            int i12 = hashCode * 59;
            if (feeName2 != null) {
                i11 = feeName2.hashCode();
            }
            return i12 + i11;
        }

        public void setFee(String str) {
            this.fee = str;
        }

        public void setFeeName(String str) {
            this.feeName = str;
        }

        public void setFeeStatus(int i11) {
            this.feeStatus = i11;
        }

        public void setFeeType(int i11) {
            this.feeType = i11;
        }

        public String toString() {
            return "OtcOrderDetailBean.FeeDetail(feeType=" + getFeeType() + ", feeStatus=" + getFeeStatus() + ", fee=" + getFee() + ", feeName=" + getFeeName() + ")";
        }
    }

    public static class FeeInfo implements Serializable {
        private List<FeeDetail> feeList;
        private String totalFee;

        public boolean canEqual(Object obj) {
            return obj instanceof FeeInfo;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof FeeInfo)) {
                return false;
            }
            FeeInfo feeInfo = (FeeInfo) obj;
            if (!feeInfo.canEqual(this)) {
                return false;
            }
            String totalFee2 = getTotalFee();
            String totalFee3 = feeInfo.getTotalFee();
            if (totalFee2 != null ? !totalFee2.equals(totalFee3) : totalFee3 != null) {
                return false;
            }
            List<FeeDetail> feeList2 = getFeeList();
            List<FeeDetail> feeList3 = feeInfo.getFeeList();
            return feeList2 != null ? feeList2.equals(feeList3) : feeList3 == null;
        }

        public List<FeeDetail> getFeeList() {
            return this.feeList;
        }

        public String getTotalFee() {
            return this.totalFee;
        }

        public int hashCode() {
            String totalFee2 = getTotalFee();
            int i11 = 43;
            int hashCode = totalFee2 == null ? 43 : totalFee2.hashCode();
            List<FeeDetail> feeList2 = getFeeList();
            int i12 = (hashCode + 59) * 59;
            if (feeList2 != null) {
                i11 = feeList2.hashCode();
            }
            return i12 + i11;
        }

        public void setFeeList(List<FeeDetail> list) {
            this.feeList = list;
        }

        public void setTotalFee(String str) {
            this.totalFee = str;
        }

        public String toString() {
            return "OtcOrderDetailBean.FeeInfo(totalFee=" + getTotalFee() + ", feeList=" + getFeeList() + ")";
        }
    }

    public static class HbPayOrder implements Serializable {
        private String cardBankName;
        private String cardBankNumber;
        private String cardScheme;

        /* renamed from: id  reason: collision with root package name */
        private long f70591id;
        private long liquidityId;
        private long orderId;

        public boolean canEqual(Object obj) {
            return obj instanceof HbPayOrder;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof HbPayOrder)) {
                return false;
            }
            HbPayOrder hbPayOrder = (HbPayOrder) obj;
            if (!hbPayOrder.canEqual(this) || getId() != hbPayOrder.getId() || getOrderId() != hbPayOrder.getOrderId() || getLiquidityId() != hbPayOrder.getLiquidityId()) {
                return false;
            }
            String cardScheme2 = getCardScheme();
            String cardScheme3 = hbPayOrder.getCardScheme();
            if (cardScheme2 != null ? !cardScheme2.equals(cardScheme3) : cardScheme3 != null) {
                return false;
            }
            String cardBankName2 = getCardBankName();
            String cardBankName3 = hbPayOrder.getCardBankName();
            if (cardBankName2 != null ? !cardBankName2.equals(cardBankName3) : cardBankName3 != null) {
                return false;
            }
            String cardBankNumber2 = getCardBankNumber();
            String cardBankNumber3 = hbPayOrder.getCardBankNumber();
            return cardBankNumber2 != null ? cardBankNumber2.equals(cardBankNumber3) : cardBankNumber3 == null;
        }

        public String getCardBankName() {
            return this.cardBankName;
        }

        public String getCardBankNumber() {
            return this.cardBankNumber;
        }

        public String getCardScheme() {
            return this.cardScheme;
        }

        public long getId() {
            return this.f70591id;
        }

        public long getLiquidityId() {
            return this.liquidityId;
        }

        public long getOrderId() {
            return this.orderId;
        }

        public int hashCode() {
            long id2 = getId();
            long orderId2 = getOrderId();
            int i11 = ((((int) (id2 ^ (id2 >>> 32))) + 59) * 59) + ((int) (orderId2 ^ (orderId2 >>> 32)));
            long liquidityId2 = getLiquidityId();
            String cardScheme2 = getCardScheme();
            int i12 = ((i11 * 59) + ((int) ((liquidityId2 >>> 32) ^ liquidityId2))) * 59;
            int i13 = 43;
            int hashCode = i12 + (cardScheme2 == null ? 43 : cardScheme2.hashCode());
            String cardBankName2 = getCardBankName();
            int hashCode2 = (hashCode * 59) + (cardBankName2 == null ? 43 : cardBankName2.hashCode());
            String cardBankNumber2 = getCardBankNumber();
            int i14 = hashCode2 * 59;
            if (cardBankNumber2 != null) {
                i13 = cardBankNumber2.hashCode();
            }
            return i14 + i13;
        }

        public void setCardBankName(String str) {
            this.cardBankName = str;
        }

        public void setCardBankNumber(String str) {
            this.cardBankNumber = str;
        }

        public void setCardScheme(String str) {
            this.cardScheme = str;
        }

        public void setId(long j11) {
            this.f70591id = j11;
        }

        public void setLiquidityId(long j11) {
            this.liquidityId = j11;
        }

        public void setOrderId(long j11) {
            this.orderId = j11;
        }

        public String toString() {
            return "OtcOrderDetailBean.HbPayOrder(id=" + getId() + ", orderId=" + getOrderId() + ", liquidityId=" + getLiquidityId() + ", cardScheme=" + getCardScheme() + ", cardBankName=" + getCardBankName() + ", cardBankNumber=" + getCardBankNumber() + ")";
        }
    }

    public static class OrderCancelConsults implements Serializable {
        private int cancelType;
        private String consultReason;
        private String consultReasonSecond;
        private String description;
        private String gmtCreate;
        private String gmtModified;

        /* renamed from: id  reason: collision with root package name */
        private String f70592id;
        private String proofUrls;

        public boolean canEqual(Object obj) {
            return obj instanceof OrderCancelConsults;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof OrderCancelConsults)) {
                return false;
            }
            OrderCancelConsults orderCancelConsults = (OrderCancelConsults) obj;
            if (!orderCancelConsults.canEqual(this)) {
                return false;
            }
            String id2 = getId();
            String id3 = orderCancelConsults.getId();
            if (id2 != null ? !id2.equals(id3) : id3 != null) {
                return false;
            }
            String consultReason2 = getConsultReason();
            String consultReason3 = orderCancelConsults.getConsultReason();
            if (consultReason2 != null ? !consultReason2.equals(consultReason3) : consultReason3 != null) {
                return false;
            }
            String consultReasonSecond2 = getConsultReasonSecond();
            String consultReasonSecond3 = orderCancelConsults.getConsultReasonSecond();
            if (consultReasonSecond2 != null ? !consultReasonSecond2.equals(consultReasonSecond3) : consultReasonSecond3 != null) {
                return false;
            }
            String description2 = getDescription();
            String description3 = orderCancelConsults.getDescription();
            if (description2 != null ? !description2.equals(description3) : description3 != null) {
                return false;
            }
            String proofUrls2 = getProofUrls();
            String proofUrls3 = orderCancelConsults.getProofUrls();
            if (proofUrls2 != null ? !proofUrls2.equals(proofUrls3) : proofUrls3 != null) {
                return false;
            }
            String gmtCreate2 = getGmtCreate();
            String gmtCreate3 = orderCancelConsults.getGmtCreate();
            if (gmtCreate2 != null ? !gmtCreate2.equals(gmtCreate3) : gmtCreate3 != null) {
                return false;
            }
            String gmtModified2 = getGmtModified();
            String gmtModified3 = orderCancelConsults.getGmtModified();
            if (gmtModified2 != null ? gmtModified2.equals(gmtModified3) : gmtModified3 == null) {
                return getCancelType() == orderCancelConsults.getCancelType();
            }
            return false;
        }

        public int getCancelType() {
            return this.cancelType;
        }

        public String getConsultReason() {
            return this.consultReason;
        }

        public String getConsultReasonSecond() {
            return this.consultReasonSecond;
        }

        public String getDescription() {
            return this.description;
        }

        public String getGmtCreate() {
            return this.gmtCreate;
        }

        public String getGmtModified() {
            return this.gmtModified;
        }

        public String getId() {
            return this.f70592id;
        }

        public String getProofUrls() {
            return this.proofUrls;
        }

        public int hashCode() {
            String id2 = getId();
            int i11 = 43;
            int hashCode = id2 == null ? 43 : id2.hashCode();
            String consultReason2 = getConsultReason();
            int hashCode2 = ((hashCode + 59) * 59) + (consultReason2 == null ? 43 : consultReason2.hashCode());
            String consultReasonSecond2 = getConsultReasonSecond();
            int hashCode3 = (hashCode2 * 59) + (consultReasonSecond2 == null ? 43 : consultReasonSecond2.hashCode());
            String description2 = getDescription();
            int hashCode4 = (hashCode3 * 59) + (description2 == null ? 43 : description2.hashCode());
            String proofUrls2 = getProofUrls();
            int hashCode5 = (hashCode4 * 59) + (proofUrls2 == null ? 43 : proofUrls2.hashCode());
            String gmtCreate2 = getGmtCreate();
            int hashCode6 = (hashCode5 * 59) + (gmtCreate2 == null ? 43 : gmtCreate2.hashCode());
            String gmtModified2 = getGmtModified();
            int i12 = hashCode6 * 59;
            if (gmtModified2 != null) {
                i11 = gmtModified2.hashCode();
            }
            return ((i12 + i11) * 59) + getCancelType();
        }

        public void setCancelType(int i11) {
            this.cancelType = i11;
        }

        public void setConsultReason(String str) {
            this.consultReason = str;
        }

        public void setConsultReasonSecond(String str) {
            this.consultReasonSecond = str;
        }

        public void setDescription(String str) {
            this.description = str;
        }

        public void setGmtCreate(String str) {
            this.gmtCreate = str;
        }

        public void setGmtModified(String str) {
            this.gmtModified = str;
        }

        public void setId(String str) {
            this.f70592id = str;
        }

        public void setProofUrls(String str) {
            this.proofUrls = str;
        }

        public String toString() {
            return "OtcOrderDetailBean.OrderCancelConsults(id=" + getId() + ", consultReason=" + getConsultReason() + ", consultReasonSecond=" + getConsultReasonSecond() + ", description=" + getDescription() + ", proofUrls=" + getProofUrls() + ", gmtCreate=" + getGmtCreate() + ", gmtModified=" + getGmtModified() + ", cancelType=" + getCancelType() + ")";
        }
    }

    public static class OrderInfo implements Serializable {
        private String amount;
        private int areaType = 1;
        private int cryptoAssetId;
        private String cryptoAssetName;
        private String cryptoAssetSymbol;
        private int cryptoAssetType;
        private long gmtCreate;
        private Long gmtModified;
        private int liquidDivision;
        private String nickName;
        private String orderId;
        private String orderNo;
        private int orderStatus;
        private String quantity;
        private String quote;
        private int quoteAssetId;
        private String quoteAssetName;
        private String quoteAssetSymbol;
        private int quoteAssetType;
        private String realName;
        private String roleName;
        private int runMode;
        private int side;
        private String sideName;
        private int tradeMode;
        private String uid;

        public boolean canEqual(Object obj) {
            return obj instanceof OrderInfo;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof OrderInfo)) {
                return false;
            }
            OrderInfo orderInfo = (OrderInfo) obj;
            if (!orderInfo.canEqual(this)) {
                return false;
            }
            String orderId2 = getOrderId();
            String orderId3 = orderInfo.getOrderId();
            if (orderId2 != null ? !orderId2.equals(orderId3) : orderId3 != null) {
                return false;
            }
            String orderNo2 = getOrderNo();
            String orderNo3 = orderInfo.getOrderNo();
            if (orderNo2 != null ? !orderNo2.equals(orderNo3) : orderNo3 != null) {
                return false;
            }
            String uid2 = getUid();
            String uid3 = orderInfo.getUid();
            if (uid2 != null ? !uid2.equals(uid3) : uid3 != null) {
                return false;
            }
            String nickName2 = getNickName();
            String nickName3 = orderInfo.getNickName();
            if (nickName2 != null ? !nickName2.equals(nickName3) : nickName3 != null) {
                return false;
            }
            String realName2 = getRealName();
            String realName3 = orderInfo.getRealName();
            if (realName2 != null ? !realName2.equals(realName3) : realName3 != null) {
                return false;
            }
            String roleName2 = getRoleName();
            String roleName3 = orderInfo.getRoleName();
            if (roleName2 != null ? !roleName2.equals(roleName3) : roleName3 != null) {
                return false;
            }
            if (getSide() != orderInfo.getSide() || getRunMode() != orderInfo.getRunMode() || getTradeMode() != orderInfo.getTradeMode()) {
                return false;
            }
            String sideName2 = getSideName();
            String sideName3 = orderInfo.getSideName();
            if (sideName2 != null ? !sideName2.equals(sideName3) : sideName3 != null) {
                return false;
            }
            if (getQuoteAssetId() != orderInfo.getQuoteAssetId() || getQuoteAssetType() != orderInfo.getQuoteAssetType()) {
                return false;
            }
            String quoteAssetName2 = getQuoteAssetName();
            String quoteAssetName3 = orderInfo.getQuoteAssetName();
            if (quoteAssetName2 != null ? !quoteAssetName2.equals(quoteAssetName3) : quoteAssetName3 != null) {
                return false;
            }
            String quoteAssetSymbol2 = getQuoteAssetSymbol();
            String quoteAssetSymbol3 = orderInfo.getQuoteAssetSymbol();
            if (quoteAssetSymbol2 != null ? !quoteAssetSymbol2.equals(quoteAssetSymbol3) : quoteAssetSymbol3 != null) {
                return false;
            }
            if (getCryptoAssetId() != orderInfo.getCryptoAssetId() || getCryptoAssetType() != orderInfo.getCryptoAssetType()) {
                return false;
            }
            String cryptoAssetName2 = getCryptoAssetName();
            String cryptoAssetName3 = orderInfo.getCryptoAssetName();
            if (cryptoAssetName2 != null ? !cryptoAssetName2.equals(cryptoAssetName3) : cryptoAssetName3 != null) {
                return false;
            }
            String cryptoAssetSymbol2 = getCryptoAssetSymbol();
            String cryptoAssetSymbol3 = orderInfo.getCryptoAssetSymbol();
            if (cryptoAssetSymbol2 != null ? !cryptoAssetSymbol2.equals(cryptoAssetSymbol3) : cryptoAssetSymbol3 != null) {
                return false;
            }
            String amount2 = getAmount();
            String amount3 = orderInfo.getAmount();
            if (amount2 != null ? !amount2.equals(amount3) : amount3 != null) {
                return false;
            }
            String quantity2 = getQuantity();
            String quantity3 = orderInfo.getQuantity();
            if (quantity2 != null ? !quantity2.equals(quantity3) : quantity3 != null) {
                return false;
            }
            String quote2 = getQuote();
            String quote3 = orderInfo.getQuote();
            if (quote2 != null ? !quote2.equals(quote3) : quote3 != null) {
                return false;
            }
            if (getOrderStatus() != orderInfo.getOrderStatus() || getGmtCreate() != orderInfo.getGmtCreate()) {
                return false;
            }
            Long gmtModified2 = getGmtModified();
            Long gmtModified3 = orderInfo.getGmtModified();
            if (gmtModified2 != null ? gmtModified2.equals(gmtModified3) : gmtModified3 == null) {
                return getAreaType() == orderInfo.getAreaType() && getLiquidDivision() == orderInfo.getLiquidDivision();
            }
            return false;
        }

        public String getAmount() {
            return this.amount;
        }

        public int getAreaType() {
            return this.areaType;
        }

        public int getCryptoAssetId() {
            return this.cryptoAssetId;
        }

        public String getCryptoAssetName() {
            return this.cryptoAssetName;
        }

        public String getCryptoAssetSymbol() {
            return this.cryptoAssetSymbol;
        }

        public int getCryptoAssetType() {
            return this.cryptoAssetType;
        }

        public long getGmtCreate() {
            return this.gmtCreate;
        }

        public Long getGmtModified() {
            return this.gmtModified;
        }

        public int getLiquidDivision() {
            return this.liquidDivision;
        }

        public String getNickName() {
            return this.nickName;
        }

        public String getOrderId() {
            return this.orderId;
        }

        public String getOrderNo() {
            return this.orderNo;
        }

        public int getOrderStatus() {
            return this.orderStatus;
        }

        public String getQuantity() {
            return this.quantity;
        }

        public String getQuote() {
            return this.quote;
        }

        public int getQuoteAssetId() {
            return this.quoteAssetId;
        }

        public String getQuoteAssetName() {
            return this.quoteAssetName;
        }

        public String getQuoteAssetSymbol() {
            return this.quoteAssetSymbol;
        }

        public int getQuoteAssetType() {
            return this.quoteAssetType;
        }

        public String getRealName() {
            return this.realName;
        }

        public String getRoleName() {
            return this.roleName;
        }

        public int getRunMode() {
            return this.runMode;
        }

        public int getSide() {
            return this.side;
        }

        public String getSideName() {
            return this.sideName;
        }

        public int getTradeMode() {
            return this.tradeMode;
        }

        public String getUid() {
            return this.uid;
        }

        public int hashCode() {
            String orderId2 = getOrderId();
            int i11 = 43;
            int hashCode = orderId2 == null ? 43 : orderId2.hashCode();
            String orderNo2 = getOrderNo();
            int hashCode2 = ((hashCode + 59) * 59) + (orderNo2 == null ? 43 : orderNo2.hashCode());
            String uid2 = getUid();
            int hashCode3 = (hashCode2 * 59) + (uid2 == null ? 43 : uid2.hashCode());
            String nickName2 = getNickName();
            int hashCode4 = (hashCode3 * 59) + (nickName2 == null ? 43 : nickName2.hashCode());
            String realName2 = getRealName();
            int hashCode5 = (hashCode4 * 59) + (realName2 == null ? 43 : realName2.hashCode());
            String roleName2 = getRoleName();
            int hashCode6 = (((((((hashCode5 * 59) + (roleName2 == null ? 43 : roleName2.hashCode())) * 59) + getSide()) * 59) + getRunMode()) * 59) + getTradeMode();
            String sideName2 = getSideName();
            int hashCode7 = (((((hashCode6 * 59) + (sideName2 == null ? 43 : sideName2.hashCode())) * 59) + getQuoteAssetId()) * 59) + getQuoteAssetType();
            String quoteAssetName2 = getQuoteAssetName();
            int hashCode8 = (hashCode7 * 59) + (quoteAssetName2 == null ? 43 : quoteAssetName2.hashCode());
            String quoteAssetSymbol2 = getQuoteAssetSymbol();
            int hashCode9 = (((((hashCode8 * 59) + (quoteAssetSymbol2 == null ? 43 : quoteAssetSymbol2.hashCode())) * 59) + getCryptoAssetId()) * 59) + getCryptoAssetType();
            String cryptoAssetName2 = getCryptoAssetName();
            int hashCode10 = (hashCode9 * 59) + (cryptoAssetName2 == null ? 43 : cryptoAssetName2.hashCode());
            String cryptoAssetSymbol2 = getCryptoAssetSymbol();
            int hashCode11 = (hashCode10 * 59) + (cryptoAssetSymbol2 == null ? 43 : cryptoAssetSymbol2.hashCode());
            String amount2 = getAmount();
            int hashCode12 = (hashCode11 * 59) + (amount2 == null ? 43 : amount2.hashCode());
            String quantity2 = getQuantity();
            int hashCode13 = (hashCode12 * 59) + (quantity2 == null ? 43 : quantity2.hashCode());
            String quote2 = getQuote();
            int hashCode14 = (((hashCode13 * 59) + (quote2 == null ? 43 : quote2.hashCode())) * 59) + getOrderStatus();
            long gmtCreate2 = getGmtCreate();
            int i12 = (hashCode14 * 59) + ((int) (gmtCreate2 ^ (gmtCreate2 >>> 32)));
            Long gmtModified2 = getGmtModified();
            int i13 = i12 * 59;
            if (gmtModified2 != null) {
                i11 = gmtModified2.hashCode();
            }
            return ((((i13 + i11) * 59) + getAreaType()) * 59) + getLiquidDivision();
        }

        public void setAmount(String str) {
            this.amount = str;
        }

        public void setAreaType(int i11) {
            this.areaType = i11;
        }

        public void setCryptoAssetId(int i11) {
            this.cryptoAssetId = i11;
        }

        public void setCryptoAssetName(String str) {
            this.cryptoAssetName = str;
        }

        public void setCryptoAssetSymbol(String str) {
            this.cryptoAssetSymbol = str;
        }

        public void setCryptoAssetType(int i11) {
            this.cryptoAssetType = i11;
        }

        public void setGmtCreate(long j11) {
            this.gmtCreate = j11;
        }

        public void setGmtModified(Long l11) {
            this.gmtModified = l11;
        }

        public void setLiquidDivision(int i11) {
            this.liquidDivision = i11;
        }

        public void setNickName(String str) {
            this.nickName = str;
        }

        public void setOrderId(String str) {
            this.orderId = str;
        }

        public void setOrderNo(String str) {
            this.orderNo = str;
        }

        public void setOrderStatus(int i11) {
            this.orderStatus = i11;
        }

        public void setQuantity(String str) {
            this.quantity = str;
        }

        public void setQuote(String str) {
            this.quote = str;
        }

        public void setQuoteAssetId(int i11) {
            this.quoteAssetId = i11;
        }

        public void setQuoteAssetName(String str) {
            this.quoteAssetName = str;
        }

        public void setQuoteAssetSymbol(String str) {
            this.quoteAssetSymbol = str;
        }

        public void setQuoteAssetType(int i11) {
            this.quoteAssetType = i11;
        }

        public void setRealName(String str) {
            this.realName = str;
        }

        public void setRoleName(String str) {
            this.roleName = str;
        }

        public void setRunMode(int i11) {
            this.runMode = i11;
        }

        public void setSide(int i11) {
            this.side = i11;
        }

        public void setSideName(String str) {
            this.sideName = str;
        }

        public void setTradeMode(int i11) {
            this.tradeMode = i11;
        }

        public void setUid(String str) {
            this.uid = str;
        }

        public String toString() {
            return "OtcOrderDetailBean.OrderInfo(orderId=" + getOrderId() + ", orderNo=" + getOrderNo() + ", uid=" + getUid() + ", nickName=" + getNickName() + ", realName=" + getRealName() + ", roleName=" + getRoleName() + ", side=" + getSide() + ", runMode=" + getRunMode() + ", tradeMode=" + getTradeMode() + ", sideName=" + getSideName() + ", quoteAssetId=" + getQuoteAssetId() + ", quoteAssetType=" + getQuoteAssetType() + ", quoteAssetName=" + getQuoteAssetName() + ", quoteAssetSymbol=" + getQuoteAssetSymbol() + ", cryptoAssetId=" + getCryptoAssetId() + ", cryptoAssetType=" + getCryptoAssetType() + ", cryptoAssetName=" + getCryptoAssetName() + ", cryptoAssetSymbol=" + getCryptoAssetSymbol() + ", amount=" + getAmount() + ", quantity=" + getQuantity() + ", quote=" + getQuote() + ", orderStatus=" + getOrderStatus() + ", gmtCreate=" + getGmtCreate() + ", gmtModified=" + getGmtModified() + ", areaType=" + getAreaType() + ", liquidDivision=" + getLiquidDivision() + ")";
        }
    }

    public static class OrderSnapshot implements Serializable {
        private String tradeInstructionStatus;

        public boolean canEqual(Object obj) {
            return obj instanceof OrderSnapshot;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof OrderSnapshot)) {
                return false;
            }
            OrderSnapshot orderSnapshot = (OrderSnapshot) obj;
            if (!orderSnapshot.canEqual(this)) {
                return false;
            }
            String tradeInstructionStatus2 = getTradeInstructionStatus();
            String tradeInstructionStatus3 = orderSnapshot.getTradeInstructionStatus();
            return tradeInstructionStatus2 != null ? tradeInstructionStatus2.equals(tradeInstructionStatus3) : tradeInstructionStatus3 == null;
        }

        public String getTradeInstructionStatus() {
            return this.tradeInstructionStatus;
        }

        public int hashCode() {
            String tradeInstructionStatus2 = getTradeInstructionStatus();
            return 59 + (tradeInstructionStatus2 == null ? 43 : tradeInstructionStatus2.hashCode());
        }

        public void setTradeInstructionStatus(String str) {
            this.tradeInstructionStatus = str;
        }

        public String toString() {
            return "OtcOrderDetailBean.OrderSnapshot(tradeInstructionStatus=" + getTradeInstructionStatus() + ")";
        }
    }

    public static class OrderTag implements Serializable {
        private int isAppeal;
        private int isAppealPremature;
        private boolean isFollowed;
        private int isPhone;
        private int isPremature;
        private boolean isShield;
        private int isSoonLock;
        private int legalChoiceFlag;
        private Integer negotiationStatus;
        private long now;
        private int specialCancelFlag;

        public boolean canEqual(Object obj) {
            return obj instanceof OrderTag;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof OrderTag)) {
                return false;
            }
            OrderTag orderTag = (OrderTag) obj;
            if (!orderTag.canEqual(this) || getIsSoonLock() != orderTag.getIsSoonLock() || getIsPremature() != orderTag.getIsPremature() || getIsAppeal() != orderTag.getIsAppeal() || getSpecialCancelFlag() != orderTag.getSpecialCancelFlag() || getLegalChoiceFlag() != orderTag.getLegalChoiceFlag() || getIsPhone() != orderTag.getIsPhone() || getNow() != orderTag.getNow() || getIsAppealPremature() != orderTag.getIsAppealPremature() || isFollowed() != orderTag.isFollowed() || isShield() != orderTag.isShield()) {
                return false;
            }
            Integer negotiationStatus2 = getNegotiationStatus();
            Integer negotiationStatus3 = orderTag.getNegotiationStatus();
            return negotiationStatus2 != null ? negotiationStatus2.equals(negotiationStatus3) : negotiationStatus3 == null;
        }

        public int getIsAppeal() {
            return this.isAppeal;
        }

        public int getIsAppealPremature() {
            return this.isAppealPremature;
        }

        public int getIsPhone() {
            return this.isPhone;
        }

        public int getIsPremature() {
            return this.isPremature;
        }

        public int getIsSoonLock() {
            return this.isSoonLock;
        }

        public int getLegalChoiceFlag() {
            return this.legalChoiceFlag;
        }

        public Integer getNegotiationStatus() {
            return this.negotiationStatus;
        }

        public long getNow() {
            return this.now;
        }

        public int getSpecialCancelFlag() {
            return this.specialCancelFlag;
        }

        public int hashCode() {
            int isSoonLock2 = ((((((((((getIsSoonLock() + 59) * 59) + getIsPremature()) * 59) + getIsAppeal()) * 59) + getSpecialCancelFlag()) * 59) + getLegalChoiceFlag()) * 59) + getIsPhone();
            long now2 = getNow();
            int i11 = 79;
            int isAppealPremature2 = ((((((isSoonLock2 * 59) + ((int) (now2 ^ (now2 >>> 32)))) * 59) + getIsAppealPremature()) * 59) + (isFollowed() ? 79 : 97)) * 59;
            if (!isShield()) {
                i11 = 97;
            }
            Integer negotiationStatus2 = getNegotiationStatus();
            return ((isAppealPremature2 + i11) * 59) + (negotiationStatus2 == null ? 43 : negotiationStatus2.hashCode());
        }

        public boolean isFollowed() {
            return this.isFollowed;
        }

        public boolean isShield() {
            return this.isShield;
        }

        public void setFollowed(boolean z11) {
            this.isFollowed = z11;
        }

        public void setIsAppeal(int i11) {
            this.isAppeal = i11;
        }

        public void setIsAppealPremature(int i11) {
            this.isAppealPremature = i11;
        }

        public void setIsPhone(int i11) {
            this.isPhone = i11;
        }

        public void setIsPremature(int i11) {
            this.isPremature = i11;
        }

        public void setIsSoonLock(int i11) {
            this.isSoonLock = i11;
        }

        public void setLegalChoiceFlag(int i11) {
            this.legalChoiceFlag = i11;
        }

        public void setNegotiationStatus(Integer num) {
            this.negotiationStatus = num;
        }

        public void setNow(long j11) {
            this.now = j11;
        }

        public void setShield(boolean z11) {
            this.isShield = z11;
        }

        public void setSpecialCancelFlag(int i11) {
            this.specialCancelFlag = i11;
        }

        public String toString() {
            return "OtcOrderDetailBean.OrderTag(isSoonLock=" + getIsSoonLock() + ", isPremature=" + getIsPremature() + ", isAppeal=" + getIsAppeal() + ", specialCancelFlag=" + getSpecialCancelFlag() + ", legalChoiceFlag=" + getLegalChoiceFlag() + ", isPhone=" + getIsPhone() + ", now=" + getNow() + ", isAppealPremature=" + getIsAppealPremature() + ", isFollowed=" + isFollowed() + ", isShield=" + isShield() + ", negotiationStatus=" + getNegotiationStatus() + ")";
        }
    }

    public static class OtherInfo implements Serializable {
        private int appealMonthTimes;
        private int appealMonthWinTimes;
        private BigDecimal buyCancelTimeAvg;
        private float buyCompleteRate;
        private long gmtCreate;
        private boolean isOnline;
        private boolean isPhoneBind;
        private boolean isSeniorAuth;
        private BigDecimal marginAmount;
        private int marginAssetId;
        private String marginAssetName;
        private int merchantLevel;
        private String nickName;
        private float orderCompleteRate;
        private String realName;
        private int realTradeCountBuy;
        private int realTradeCountSell;
        private long registerTime;
        private long releaseTime;
        private int thumbUp;
        private int tradeCount;
        private int tradeMonthCount;
        private long uid;

        public boolean canEqual(Object obj) {
            return obj instanceof OtherInfo;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof OtherInfo)) {
                return false;
            }
            OtherInfo otherInfo = (OtherInfo) obj;
            if (!otherInfo.canEqual(this) || getUid() != otherInfo.getUid()) {
                return false;
            }
            String nickName2 = getNickName();
            String nickName3 = otherInfo.getNickName();
            if (nickName2 != null ? !nickName2.equals(nickName3) : nickName3 != null) {
                return false;
            }
            String realName2 = getRealName();
            String realName3 = otherInfo.getRealName();
            if (realName2 != null ? !realName2.equals(realName3) : realName3 != null) {
                return false;
            }
            if (getGmtCreate() != otherInfo.getGmtCreate() || getMerchantLevel() != otherInfo.getMerchantLevel() || getRealTradeCountBuy() != otherInfo.getRealTradeCountBuy() || getRealTradeCountSell() != otherInfo.getRealTradeCountSell() || getRegisterTime() != otherInfo.getRegisterTime() || isPhoneBind() != otherInfo.isPhoneBind() || getMarginAssetId() != otherInfo.getMarginAssetId()) {
                return false;
            }
            String marginAssetName2 = getMarginAssetName();
            String marginAssetName3 = otherInfo.getMarginAssetName();
            if (marginAssetName2 != null ? !marginAssetName2.equals(marginAssetName3) : marginAssetName3 != null) {
                return false;
            }
            BigDecimal marginAmount2 = getMarginAmount();
            BigDecimal marginAmount3 = otherInfo.getMarginAmount();
            if (marginAmount2 != null ? !marginAmount2.equals(marginAmount3) : marginAmount3 != null) {
                return false;
            }
            if (getAppealMonthTimes() != otherInfo.getAppealMonthTimes() || getAppealMonthWinTimes() != otherInfo.getAppealMonthWinTimes() || isOnline() != otherInfo.isOnline() || Float.compare(getOrderCompleteRate(), otherInfo.getOrderCompleteRate()) != 0 || getTradeMonthCount() != otherInfo.getTradeMonthCount() || getTradeCount() != otherInfo.getTradeCount() || getReleaseTime() != otherInfo.getReleaseTime() || Float.compare(getBuyCompleteRate(), otherInfo.getBuyCompleteRate()) != 0) {
                return false;
            }
            BigDecimal buyCancelTimeAvg2 = getBuyCancelTimeAvg();
            BigDecimal buyCancelTimeAvg3 = otherInfo.getBuyCancelTimeAvg();
            if (buyCancelTimeAvg2 != null ? buyCancelTimeAvg2.equals(buyCancelTimeAvg3) : buyCancelTimeAvg3 == null) {
                return isSeniorAuth() == otherInfo.isSeniorAuth() && getThumbUp() == otherInfo.getThumbUp();
            }
            return false;
        }

        public int getAppealMonthTimes() {
            return this.appealMonthTimes;
        }

        public int getAppealMonthWinTimes() {
            return this.appealMonthWinTimes;
        }

        public BigDecimal getBuyCancelTimeAvg() {
            return this.buyCancelTimeAvg;
        }

        public float getBuyCompleteRate() {
            return this.buyCompleteRate;
        }

        public long getGmtCreate() {
            return this.gmtCreate;
        }

        public BigDecimal getMarginAmount() {
            return this.marginAmount;
        }

        public int getMarginAssetId() {
            return this.marginAssetId;
        }

        public String getMarginAssetName() {
            return this.marginAssetName;
        }

        public int getMerchantLevel() {
            return this.merchantLevel;
        }

        public String getNickName() {
            return this.nickName;
        }

        public float getOrderCompleteRate() {
            return this.orderCompleteRate;
        }

        public String getRealName() {
            return this.realName;
        }

        public int getRealTradeCountBuy() {
            return this.realTradeCountBuy;
        }

        public int getRealTradeCountSell() {
            return this.realTradeCountSell;
        }

        public long getRegisterTime() {
            return this.registerTime;
        }

        public long getReleaseTime() {
            return this.releaseTime;
        }

        public int getThumbUp() {
            return this.thumbUp;
        }

        public int getTradeCount() {
            return this.tradeCount;
        }

        public int getTradeMonthCount() {
            return this.tradeMonthCount;
        }

        public long getUid() {
            return this.uid;
        }

        public int hashCode() {
            long uid2 = getUid();
            String nickName2 = getNickName();
            int i11 = 43;
            int hashCode = ((((int) (uid2 ^ (uid2 >>> 32))) + 59) * 59) + (nickName2 == null ? 43 : nickName2.hashCode());
            String realName2 = getRealName();
            int i12 = hashCode * 59;
            int hashCode2 = realName2 == null ? 43 : realName2.hashCode();
            long gmtCreate2 = getGmtCreate();
            long registerTime2 = getRegisterTime();
            int merchantLevel2 = (((((((((((i12 + hashCode2) * 59) + ((int) (gmtCreate2 ^ (gmtCreate2 >>> 32)))) * 59) + getMerchantLevel()) * 59) + getRealTradeCountBuy()) * 59) + getRealTradeCountSell()) * 59) + ((int) (registerTime2 ^ (registerTime2 >>> 32)))) * 59;
            int i13 = 79;
            int marginAssetId2 = ((merchantLevel2 + (isPhoneBind() ? 79 : 97)) * 59) + getMarginAssetId();
            String marginAssetName2 = getMarginAssetName();
            int hashCode3 = (marginAssetId2 * 59) + (marginAssetName2 == null ? 43 : marginAssetName2.hashCode());
            BigDecimal marginAmount2 = getMarginAmount();
            int hashCode4 = ((((((hashCode3 * 59) + (marginAmount2 == null ? 43 : marginAmount2.hashCode())) * 59) + getAppealMonthTimes()) * 59) + getAppealMonthWinTimes()) * 59;
            int i14 = isOnline() ? 79 : 97;
            long releaseTime2 = getReleaseTime();
            int floatToIntBits = ((((((((((hashCode4 + i14) * 59) + Float.floatToIntBits(getOrderCompleteRate())) * 59) + getTradeMonthCount()) * 59) + getTradeCount()) * 59) + ((int) ((releaseTime2 >>> 32) ^ releaseTime2))) * 59) + Float.floatToIntBits(getBuyCompleteRate());
            BigDecimal buyCancelTimeAvg2 = getBuyCancelTimeAvg();
            int i15 = floatToIntBits * 59;
            if (buyCancelTimeAvg2 != null) {
                i11 = buyCancelTimeAvg2.hashCode();
            }
            int i16 = (i15 + i11) * 59;
            if (!isSeniorAuth()) {
                i13 = 97;
            }
            return ((i16 + i13) * 59) + getThumbUp();
        }

        public boolean isOnline() {
            return this.isOnline;
        }

        public boolean isPhoneBind() {
            return this.isPhoneBind;
        }

        public boolean isSeniorAuth() {
            return this.isSeniorAuth;
        }

        public void setAppealMonthTimes(int i11) {
            this.appealMonthTimes = i11;
        }

        public void setAppealMonthWinTimes(int i11) {
            this.appealMonthWinTimes = i11;
        }

        public void setBuyCancelTimeAvg(BigDecimal bigDecimal) {
            this.buyCancelTimeAvg = bigDecimal;
        }

        public void setBuyCompleteRate(float f11) {
            this.buyCompleteRate = f11;
        }

        public void setGmtCreate(long j11) {
            this.gmtCreate = j11;
        }

        public void setMarginAmount(BigDecimal bigDecimal) {
            this.marginAmount = bigDecimal;
        }

        public void setMarginAssetId(int i11) {
            this.marginAssetId = i11;
        }

        public void setMarginAssetName(String str) {
            this.marginAssetName = str;
        }

        public void setMerchantLevel(int i11) {
            this.merchantLevel = i11;
        }

        public void setNickName(String str) {
            this.nickName = str;
        }

        public void setOnline(boolean z11) {
            this.isOnline = z11;
        }

        public void setOrderCompleteRate(float f11) {
            this.orderCompleteRate = f11;
        }

        public void setPhoneBind(boolean z11) {
            this.isPhoneBind = z11;
        }

        public void setRealName(String str) {
            this.realName = str;
        }

        public void setRealTradeCountBuy(int i11) {
            this.realTradeCountBuy = i11;
        }

        public void setRealTradeCountSell(int i11) {
            this.realTradeCountSell = i11;
        }

        public void setRegisterTime(long j11) {
            this.registerTime = j11;
        }

        public void setReleaseTime(long j11) {
            this.releaseTime = j11;
        }

        public void setSeniorAuth(boolean z11) {
            this.isSeniorAuth = z11;
        }

        public void setThumbUp(int i11) {
            this.thumbUp = i11;
        }

        public void setTradeCount(int i11) {
            this.tradeCount = i11;
        }

        public void setTradeMonthCount(int i11) {
            this.tradeMonthCount = i11;
        }

        public void setUid(long j11) {
            this.uid = j11;
        }

        public String toString() {
            return "OtcOrderDetailBean.OtherInfo(uid=" + getUid() + ", nickName=" + getNickName() + ", realName=" + getRealName() + ", gmtCreate=" + getGmtCreate() + ", merchantLevel=" + getMerchantLevel() + ", realTradeCountBuy=" + getRealTradeCountBuy() + ", realTradeCountSell=" + getRealTradeCountSell() + ", registerTime=" + getRegisterTime() + ", isPhoneBind=" + isPhoneBind() + ", marginAssetId=" + getMarginAssetId() + ", marginAssetName=" + getMarginAssetName() + ", marginAmount=" + getMarginAmount() + ", appealMonthTimes=" + getAppealMonthTimes() + ", appealMonthWinTimes=" + getAppealMonthWinTimes() + ", isOnline=" + isOnline() + ", orderCompleteRate=" + getOrderCompleteRate() + ", tradeMonthCount=" + getTradeMonthCount() + ", tradeCount=" + getTradeCount() + ", releaseTime=" + getReleaseTime() + ", buyCompleteRate=" + getBuyCompleteRate() + ", buyCancelTimeAvg=" + getBuyCancelTimeAvg() + ", isSeniorAuth=" + isSeniorAuth() + ", thumbUp=" + getThumbUp() + ")";
        }
    }

    public static class PaymentMethod implements Serializable {
        private String bankAddress;
        private String bankName;
        private String bankNumber;
        private int bankType;
        private String color;

        /* renamed from: id  reason: collision with root package name */
        private int f70593id;
        private List<OtcPaymentTemplateBean> modelFieldsList;
        private String payMethodName;
        private int paymentStatus;
        private String qrCode;
        private String userName;

        public boolean canEqual(Object obj) {
            return obj instanceof PaymentMethod;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof PaymentMethod)) {
                return false;
            }
            PaymentMethod paymentMethod = (PaymentMethod) obj;
            if (!paymentMethod.canEqual(this) || getId() != paymentMethod.getId()) {
                return false;
            }
            String userName2 = getUserName();
            String userName3 = paymentMethod.getUserName();
            if (userName2 != null ? !userName2.equals(userName3) : userName3 != null) {
                return false;
            }
            if (getBankType() != paymentMethod.getBankType()) {
                return false;
            }
            String bankNumber2 = getBankNumber();
            String bankNumber3 = paymentMethod.getBankNumber();
            if (bankNumber2 != null ? !bankNumber2.equals(bankNumber3) : bankNumber3 != null) {
                return false;
            }
            String bankName2 = getBankName();
            String bankName3 = paymentMethod.getBankName();
            if (bankName2 != null ? !bankName2.equals(bankName3) : bankName3 != null) {
                return false;
            }
            String bankAddress2 = getBankAddress();
            String bankAddress3 = paymentMethod.getBankAddress();
            if (bankAddress2 != null ? !bankAddress2.equals(bankAddress3) : bankAddress3 != null) {
                return false;
            }
            String qrCode2 = getQrCode();
            String qrCode3 = paymentMethod.getQrCode();
            if (qrCode2 != null ? !qrCode2.equals(qrCode3) : qrCode3 != null) {
                return false;
            }
            List<OtcPaymentTemplateBean> modelFieldsList2 = getModelFieldsList();
            List<OtcPaymentTemplateBean> modelFieldsList3 = paymentMethod.getModelFieldsList();
            if (modelFieldsList2 != null ? !modelFieldsList2.equals(modelFieldsList3) : modelFieldsList3 != null) {
                return false;
            }
            if (getPaymentStatus() != paymentMethod.getPaymentStatus()) {
                return false;
            }
            String payMethodName2 = getPayMethodName();
            String payMethodName3 = paymentMethod.getPayMethodName();
            if (payMethodName2 != null ? !payMethodName2.equals(payMethodName3) : payMethodName3 != null) {
                return false;
            }
            String color2 = getColor();
            String color3 = paymentMethod.getColor();
            return color2 != null ? color2.equals(color3) : color3 == null;
        }

        public String getBankAddress() {
            return this.bankAddress;
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

        public String getColor() {
            return this.color;
        }

        public int getId() {
            return this.f70593id;
        }

        public List<OtcPaymentTemplateBean> getModelFieldsList() {
            return this.modelFieldsList;
        }

        public String getPayMethodName() {
            return this.payMethodName;
        }

        public int getPaymentStatus() {
            return this.paymentStatus;
        }

        public String getQrCode() {
            return this.qrCode;
        }

        public String getUserName() {
            return this.userName;
        }

        public int hashCode() {
            String userName2 = getUserName();
            int i11 = 43;
            int id2 = ((((getId() + 59) * 59) + (userName2 == null ? 43 : userName2.hashCode())) * 59) + getBankType();
            String bankNumber2 = getBankNumber();
            int hashCode = (id2 * 59) + (bankNumber2 == null ? 43 : bankNumber2.hashCode());
            String bankName2 = getBankName();
            int hashCode2 = (hashCode * 59) + (bankName2 == null ? 43 : bankName2.hashCode());
            String bankAddress2 = getBankAddress();
            int hashCode3 = (hashCode2 * 59) + (bankAddress2 == null ? 43 : bankAddress2.hashCode());
            String qrCode2 = getQrCode();
            int hashCode4 = (hashCode3 * 59) + (qrCode2 == null ? 43 : qrCode2.hashCode());
            List<OtcPaymentTemplateBean> modelFieldsList2 = getModelFieldsList();
            int hashCode5 = (((hashCode4 * 59) + (modelFieldsList2 == null ? 43 : modelFieldsList2.hashCode())) * 59) + getPaymentStatus();
            String payMethodName2 = getPayMethodName();
            int hashCode6 = (hashCode5 * 59) + (payMethodName2 == null ? 43 : payMethodName2.hashCode());
            String color2 = getColor();
            int i12 = hashCode6 * 59;
            if (color2 != null) {
                i11 = color2.hashCode();
            }
            return i12 + i11;
        }

        public void setBankAddress(String str) {
            this.bankAddress = str;
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

        public void setColor(String str) {
            this.color = str;
        }

        public void setId(int i11) {
            this.f70593id = i11;
        }

        public void setModelFieldsList(List<OtcPaymentTemplateBean> list) {
            this.modelFieldsList = list;
        }

        public void setPayMethodName(String str) {
            this.payMethodName = str;
        }

        public void setPaymentStatus(int i11) {
            this.paymentStatus = i11;
        }

        public void setQrCode(String str) {
            this.qrCode = str;
        }

        public void setUserName(String str) {
            this.userName = str;
        }

        public String toString() {
            return "OtcOrderDetailBean.PaymentMethod(id=" + getId() + ", userName=" + getUserName() + ", bankType=" + getBankType() + ", bankNumber=" + getBankNumber() + ", bankName=" + getBankName() + ", bankAddress=" + getBankAddress() + ", qrCode=" + getQrCode() + ", modelFieldsList=" + getModelFieldsList() + ", paymentStatus=" + getPaymentStatus() + ", payMethodName=" + getPayMethodName() + ", color=" + getColor() + ")";
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof OtcOrderDetailBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OtcOrderDetailBean)) {
            return false;
        }
        OtcOrderDetailBean otcOrderDetailBean = (OtcOrderDetailBean) obj;
        if (!otcOrderDetailBean.canEqual(this)) {
            return false;
        }
        OrderInfo orderInfo2 = getOrderInfo();
        OrderInfo orderInfo3 = otcOrderDetailBean.getOrderInfo();
        if (orderInfo2 != null ? !orderInfo2.equals(orderInfo3) : orderInfo3 != null) {
            return false;
        }
        OtherInfo otherInfo2 = getOtherInfo();
        OtherInfo otherInfo3 = otcOrderDetailBean.getOtherInfo();
        if (otherInfo2 != null ? !otherInfo2.equals(otherInfo3) : otherInfo3 != null) {
            return false;
        }
        List<PaymentMethod> paymentMethod2 = getPaymentMethod();
        List<PaymentMethod> paymentMethod3 = otcOrderDetailBean.getPaymentMethod();
        if (paymentMethod2 != null ? !paymentMethod2.equals(paymentMethod3) : paymentMethod3 != null) {
            return false;
        }
        FeeInfo feeInfo2 = getFeeInfo();
        FeeInfo feeInfo3 = otcOrderDetailBean.getFeeInfo();
        if (feeInfo2 != null ? !feeInfo2.equals(feeInfo3) : feeInfo3 != null) {
            return false;
        }
        OrderTag orderTag2 = getOrderTag();
        OrderTag orderTag3 = otcOrderDetailBean.getOrderTag();
        if (orderTag2 != null ? !orderTag2.equals(orderTag3) : orderTag3 != null) {
            return false;
        }
        C2cOrder c2cOrder2 = getC2cOrder();
        C2cOrder c2cOrder3 = otcOrderDetailBean.getC2cOrder();
        if (c2cOrder2 != null ? !c2cOrder2.equals(c2cOrder3) : c2cOrder3 != null) {
            return false;
        }
        ExchangeOrder exchangeOrder2 = getExchangeOrder();
        ExchangeOrder exchangeOrder3 = otcOrderDetailBean.getExchangeOrder();
        if (exchangeOrder2 != null ? !exchangeOrder2.equals(exchangeOrder3) : exchangeOrder3 != null) {
            return false;
        }
        AppealInfo appealInfo2 = getAppealInfo();
        AppealInfo appealInfo3 = otcOrderDetailBean.getAppealInfo();
        if (appealInfo2 != null ? !appealInfo2.equals(appealInfo3) : appealInfo3 != null) {
            return false;
        }
        CouponsInfo couponsInfo2 = getCouponsInfo();
        CouponsInfo couponsInfo3 = otcOrderDetailBean.getCouponsInfo();
        if (couponsInfo2 != null ? !couponsInfo2.equals(couponsInfo3) : couponsInfo3 != null) {
            return false;
        }
        HbPayOrder hbPayOrder2 = getHbPayOrder();
        HbPayOrder hbPayOrder3 = otcOrderDetailBean.getHbPayOrder();
        if (hbPayOrder2 != null ? !hbPayOrder2.equals(hbPayOrder3) : hbPayOrder3 != null) {
            return false;
        }
        if (isInNegotiation() != otcOrderDetailBean.isInNegotiation()) {
            return false;
        }
        List<OrderCancelConsults> orderCancelConsults2 = getOrderCancelConsults();
        List<OrderCancelConsults> orderCancelConsults3 = otcOrderDetailBean.getOrderCancelConsults();
        if (orderCancelConsults2 != null ? !orderCancelConsults2.equals(orderCancelConsults3) : orderCancelConsults3 != null) {
            return false;
        }
        OrderSnapshot orderSnapshot2 = getOrderSnapshot();
        OrderSnapshot orderSnapshot3 = otcOrderDetailBean.getOrderSnapshot();
        return orderSnapshot2 != null ? orderSnapshot2.equals(orderSnapshot3) : orderSnapshot3 == null;
    }

    public AppealInfo getAppealInfo() {
        return this.appealInfo;
    }

    public C2cOrder getC2cOrder() {
        return this.c2cOrder;
    }

    public CouponsInfo getCouponsInfo() {
        return this.couponsInfo;
    }

    public ExchangeOrder getExchangeOrder() {
        return this.exchangeOrder;
    }

    public FeeInfo getFeeInfo() {
        return this.feeInfo;
    }

    public HbPayOrder getHbPayOrder() {
        return this.hbPayOrder;
    }

    public List<OrderCancelConsults> getOrderCancelConsults() {
        return this.orderCancelConsults;
    }

    public OrderInfo getOrderInfo() {
        return this.orderInfo;
    }

    public OrderSnapshot getOrderSnapshot() {
        return this.orderSnapshot;
    }

    public OrderTag getOrderTag() {
        return this.orderTag;
    }

    public OtherInfo getOtherInfo() {
        return this.otherInfo;
    }

    public List<PaymentMethod> getPaymentMethod() {
        return this.paymentMethod;
    }

    public int hashCode() {
        OrderInfo orderInfo2 = getOrderInfo();
        int i11 = 43;
        int hashCode = orderInfo2 == null ? 43 : orderInfo2.hashCode();
        OtherInfo otherInfo2 = getOtherInfo();
        int hashCode2 = ((hashCode + 59) * 59) + (otherInfo2 == null ? 43 : otherInfo2.hashCode());
        List<PaymentMethod> paymentMethod2 = getPaymentMethod();
        int hashCode3 = (hashCode2 * 59) + (paymentMethod2 == null ? 43 : paymentMethod2.hashCode());
        FeeInfo feeInfo2 = getFeeInfo();
        int hashCode4 = (hashCode3 * 59) + (feeInfo2 == null ? 43 : feeInfo2.hashCode());
        OrderTag orderTag2 = getOrderTag();
        int hashCode5 = (hashCode4 * 59) + (orderTag2 == null ? 43 : orderTag2.hashCode());
        C2cOrder c2cOrder2 = getC2cOrder();
        int hashCode6 = (hashCode5 * 59) + (c2cOrder2 == null ? 43 : c2cOrder2.hashCode());
        ExchangeOrder exchangeOrder2 = getExchangeOrder();
        int hashCode7 = (hashCode6 * 59) + (exchangeOrder2 == null ? 43 : exchangeOrder2.hashCode());
        AppealInfo appealInfo2 = getAppealInfo();
        int hashCode8 = (hashCode7 * 59) + (appealInfo2 == null ? 43 : appealInfo2.hashCode());
        CouponsInfo couponsInfo2 = getCouponsInfo();
        int hashCode9 = (hashCode8 * 59) + (couponsInfo2 == null ? 43 : couponsInfo2.hashCode());
        HbPayOrder hbPayOrder2 = getHbPayOrder();
        int hashCode10 = (((hashCode9 * 59) + (hbPayOrder2 == null ? 43 : hbPayOrder2.hashCode())) * 59) + (isInNegotiation() ? 79 : 97);
        List<OrderCancelConsults> orderCancelConsults2 = getOrderCancelConsults();
        int hashCode11 = (hashCode10 * 59) + (orderCancelConsults2 == null ? 43 : orderCancelConsults2.hashCode());
        OrderSnapshot orderSnapshot2 = getOrderSnapshot();
        int i12 = hashCode11 * 59;
        if (orderSnapshot2 != null) {
            i11 = orderSnapshot2.hashCode();
        }
        return i12 + i11;
    }

    public boolean isInNegotiation() {
        return this.inNegotiation;
    }

    public void setAppealInfo(AppealInfo appealInfo2) {
        this.appealInfo = appealInfo2;
    }

    public void setC2cOrder(C2cOrder c2cOrder2) {
        this.c2cOrder = c2cOrder2;
    }

    public void setCouponsInfo(CouponsInfo couponsInfo2) {
        this.couponsInfo = couponsInfo2;
    }

    public void setExchangeOrder(ExchangeOrder exchangeOrder2) {
        this.exchangeOrder = exchangeOrder2;
    }

    public void setFeeInfo(FeeInfo feeInfo2) {
        this.feeInfo = feeInfo2;
    }

    public void setHbPayOrder(HbPayOrder hbPayOrder2) {
        this.hbPayOrder = hbPayOrder2;
    }

    public void setInNegotiation(boolean z11) {
        this.inNegotiation = z11;
    }

    public void setOrderCancelConsults(List<OrderCancelConsults> list) {
        this.orderCancelConsults = list;
    }

    public void setOrderInfo(OrderInfo orderInfo2) {
        this.orderInfo = orderInfo2;
    }

    public void setOrderSnapshot(OrderSnapshot orderSnapshot2) {
        this.orderSnapshot = orderSnapshot2;
    }

    public void setOrderTag(OrderTag orderTag2) {
        this.orderTag = orderTag2;
    }

    public void setOtherInfo(OtherInfo otherInfo2) {
        this.otherInfo = otherInfo2;
    }

    public void setPaymentMethod(List<PaymentMethod> list) {
        this.paymentMethod = list;
    }

    public String toString() {
        return "OtcOrderDetailBean(orderInfo=" + getOrderInfo() + ", otherInfo=" + getOtherInfo() + ", paymentMethod=" + getPaymentMethod() + ", feeInfo=" + getFeeInfo() + ", orderTag=" + getOrderTag() + ", c2cOrder=" + getC2cOrder() + ", exchangeOrder=" + getExchangeOrder() + ", appealInfo=" + getAppealInfo() + ", couponsInfo=" + getCouponsInfo() + ", hbPayOrder=" + getHbPayOrder() + ", inNegotiation=" + isInNegotiation() + ", orderCancelConsults=" + getOrderCancelConsults() + ", orderSnapshot=" + getOrderSnapshot() + ")";
    }
}
