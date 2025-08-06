package com.hbg.lib.network.otc.core.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class OrderInfoListBean implements Serializable {
    private String amount;
    private CardInfo cardInfo;
    private String counterpartNickName;
    private String counterpartRealName;
    private Long counterpartUid;
    private String cryptoAssetName;
    private String cryptoAssetSymbol;
    private List<FeeInfoItem> feeList;
    private Long gmtCreate;
    private Long gmtModified;
    private boolean inNegotiation;
    private LegalService legalService;
    private String orderId;
    private String orderNo;
    private Integer orderStatus;
    private String quantity;
    private String quote;
    private String quoteAssetName;
    private String quoteAssetSymbol;
    private Integer runMode;
    private Integer side;
    private String sideName;
    private Integer tradeMode;

    public static class CardInfo {

        /* renamed from: a  reason: collision with root package name */
        public String f70570a;

        /* renamed from: b  reason: collision with root package name */
        public String f70571b;

        /* renamed from: c  reason: collision with root package name */
        public String f70572c;

        public boolean a(Object obj) {
            return obj instanceof CardInfo;
        }

        public String b() {
            return this.f70571b;
        }

        public String c() {
            return this.f70572c;
        }

        public String d() {
            return this.f70570a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof CardInfo)) {
                return false;
            }
            CardInfo cardInfo = (CardInfo) obj;
            if (!cardInfo.a(this)) {
                return false;
            }
            String d11 = d();
            String d12 = cardInfo.d();
            if (d11 != null ? !d11.equals(d12) : d12 != null) {
                return false;
            }
            String b11 = b();
            String b12 = cardInfo.b();
            if (b11 != null ? !b11.equals(b12) : b12 != null) {
                return false;
            }
            String c11 = c();
            String c12 = cardInfo.c();
            return c11 != null ? c11.equals(c12) : c12 == null;
        }

        public int hashCode() {
            String d11 = d();
            int i11 = 43;
            int hashCode = d11 == null ? 43 : d11.hashCode();
            String b11 = b();
            int hashCode2 = ((hashCode + 59) * 59) + (b11 == null ? 43 : b11.hashCode());
            String c11 = c();
            int i12 = hashCode2 * 59;
            if (c11 != null) {
                i11 = c11.hashCode();
            }
            return i12 + i11;
        }

        public String toString() {
            return "OrderInfoListBean.CardInfo(scheme=" + d() + ", bankName=" + b() + ", bankNumber=" + c() + ")";
        }
    }

    public static class FeeInfoItem {

        /* renamed from: a  reason: collision with root package name */
        public String f70573a;

        /* renamed from: b  reason: collision with root package name */
        public String f70574b;

        public boolean a(Object obj) {
            return obj instanceof FeeInfoItem;
        }

        public String b() {
            return this.f70573a;
        }

        public String c() {
            return this.f70574b;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof FeeInfoItem)) {
                return false;
            }
            FeeInfoItem feeInfoItem = (FeeInfoItem) obj;
            if (!feeInfoItem.a(this)) {
                return false;
            }
            String b11 = b();
            String b12 = feeInfoItem.b();
            if (b11 != null ? !b11.equals(b12) : b12 != null) {
                return false;
            }
            String c11 = c();
            String c12 = feeInfoItem.c();
            return c11 != null ? c11.equals(c12) : c12 == null;
        }

        public int hashCode() {
            String b11 = b();
            int i11 = 43;
            int hashCode = b11 == null ? 43 : b11.hashCode();
            String c11 = c();
            int i12 = (hashCode + 59) * 59;
            if (c11 != null) {
                i11 = c11.hashCode();
            }
            return i12 + i11;
        }

        public String toString() {
            return "OrderInfoListBean.FeeInfoItem(fee=" + b() + ", feeName=" + c() + ")";
        }
    }

    public static class LegalService {

        /* renamed from: a  reason: collision with root package name */
        public String f70575a;

        /* renamed from: b  reason: collision with root package name */
        public String f70576b;

        /* renamed from: c  reason: collision with root package name */
        public Integer f70577c;

        /* renamed from: d  reason: collision with root package name */
        public Date f70578d;

        public boolean a(Object obj) {
            return obj instanceof LegalService;
        }

        public String b() {
            return this.f70576b;
        }

        public String c() {
            return this.f70575a;
        }

        public Date d() {
            return this.f70578d;
        }

        public Integer e() {
            return this.f70577c;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof LegalService)) {
                return false;
            }
            LegalService legalService = (LegalService) obj;
            if (!legalService.a(this)) {
                return false;
            }
            String c11 = c();
            String c12 = legalService.c();
            if (c11 != null ? !c11.equals(c12) : c12 != null) {
                return false;
            }
            String b11 = b();
            String b12 = legalService.b();
            if (b11 != null ? !b11.equals(b12) : b12 != null) {
                return false;
            }
            Integer e11 = e();
            Integer e12 = legalService.e();
            if (e11 != null ? !e11.equals(e12) : e12 != null) {
                return false;
            }
            Date d11 = d();
            Date d12 = legalService.d();
            return d11 != null ? d11.equals(d12) : d12 == null;
        }

        public int hashCode() {
            String c11 = c();
            int i11 = 43;
            int hashCode = c11 == null ? 43 : c11.hashCode();
            String b11 = b();
            int hashCode2 = ((hashCode + 59) * 59) + (b11 == null ? 43 : b11.hashCode());
            Integer e11 = e();
            int hashCode3 = (hashCode2 * 59) + (e11 == null ? 43 : e11.hashCode());
            Date d11 = d();
            int i12 = hashCode3 * 59;
            if (d11 != null) {
                i11 = d11.hashCode();
            }
            return i12 + i11;
        }

        public String toString() {
            return "OrderInfoListBean.LegalService(assetName=" + c() + ", amount=" + b() + ", status=" + e() + ", gmtPeriod=" + d() + ")";
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof OrderInfoListBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderInfoListBean)) {
            return false;
        }
        OrderInfoListBean orderInfoListBean = (OrderInfoListBean) obj;
        if (!orderInfoListBean.canEqual(this)) {
            return false;
        }
        String orderId2 = getOrderId();
        String orderId3 = orderInfoListBean.getOrderId();
        if (orderId2 != null ? !orderId2.equals(orderId3) : orderId3 != null) {
            return false;
        }
        String orderNo2 = getOrderNo();
        String orderNo3 = orderInfoListBean.getOrderNo();
        if (orderNo2 != null ? !orderNo2.equals(orderNo3) : orderNo3 != null) {
            return false;
        }
        Long counterpartUid2 = getCounterpartUid();
        Long counterpartUid3 = orderInfoListBean.getCounterpartUid();
        if (counterpartUid2 != null ? !counterpartUid2.equals(counterpartUid3) : counterpartUid3 != null) {
            return false;
        }
        String counterpartRealName2 = getCounterpartRealName();
        String counterpartRealName3 = orderInfoListBean.getCounterpartRealName();
        if (counterpartRealName2 != null ? !counterpartRealName2.equals(counterpartRealName3) : counterpartRealName3 != null) {
            return false;
        }
        String counterpartNickName2 = getCounterpartNickName();
        String counterpartNickName3 = orderInfoListBean.getCounterpartNickName();
        if (counterpartNickName2 != null ? !counterpartNickName2.equals(counterpartNickName3) : counterpartNickName3 != null) {
            return false;
        }
        Integer side2 = getSide();
        Integer side3 = orderInfoListBean.getSide();
        if (side2 != null ? !side2.equals(side3) : side3 != null) {
            return false;
        }
        Integer tradeMode2 = getTradeMode();
        Integer tradeMode3 = orderInfoListBean.getTradeMode();
        if (tradeMode2 != null ? !tradeMode2.equals(tradeMode3) : tradeMode3 != null) {
            return false;
        }
        Integer runMode2 = getRunMode();
        Integer runMode3 = orderInfoListBean.getRunMode();
        if (runMode2 != null ? !runMode2.equals(runMode3) : runMode3 != null) {
            return false;
        }
        String sideName2 = getSideName();
        String sideName3 = orderInfoListBean.getSideName();
        if (sideName2 != null ? !sideName2.equals(sideName3) : sideName3 != null) {
            return false;
        }
        String quoteAssetName2 = getQuoteAssetName();
        String quoteAssetName3 = orderInfoListBean.getQuoteAssetName();
        if (quoteAssetName2 != null ? !quoteAssetName2.equals(quoteAssetName3) : quoteAssetName3 != null) {
            return false;
        }
        String quoteAssetSymbol2 = getQuoteAssetSymbol();
        String quoteAssetSymbol3 = orderInfoListBean.getQuoteAssetSymbol();
        if (quoteAssetSymbol2 != null ? !quoteAssetSymbol2.equals(quoteAssetSymbol3) : quoteAssetSymbol3 != null) {
            return false;
        }
        String cryptoAssetName2 = getCryptoAssetName();
        String cryptoAssetName3 = orderInfoListBean.getCryptoAssetName();
        if (cryptoAssetName2 != null ? !cryptoAssetName2.equals(cryptoAssetName3) : cryptoAssetName3 != null) {
            return false;
        }
        String cryptoAssetSymbol2 = getCryptoAssetSymbol();
        String cryptoAssetSymbol3 = orderInfoListBean.getCryptoAssetSymbol();
        if (cryptoAssetSymbol2 != null ? !cryptoAssetSymbol2.equals(cryptoAssetSymbol3) : cryptoAssetSymbol3 != null) {
            return false;
        }
        String amount2 = getAmount();
        String amount3 = orderInfoListBean.getAmount();
        if (amount2 != null ? !amount2.equals(amount3) : amount3 != null) {
            return false;
        }
        String quantity2 = getQuantity();
        String quantity3 = orderInfoListBean.getQuantity();
        if (quantity2 != null ? !quantity2.equals(quantity3) : quantity3 != null) {
            return false;
        }
        String quote2 = getQuote();
        String quote3 = orderInfoListBean.getQuote();
        if (quote2 != null ? !quote2.equals(quote3) : quote3 != null) {
            return false;
        }
        Integer orderStatus2 = getOrderStatus();
        Integer orderStatus3 = orderInfoListBean.getOrderStatus();
        if (orderStatus2 != null ? !orderStatus2.equals(orderStatus3) : orderStatus3 != null) {
            return false;
        }
        Long gmtCreate2 = getGmtCreate();
        Long gmtCreate3 = orderInfoListBean.getGmtCreate();
        if (gmtCreate2 != null ? !gmtCreate2.equals(gmtCreate3) : gmtCreate3 != null) {
            return false;
        }
        Long gmtModified2 = getGmtModified();
        Long gmtModified3 = orderInfoListBean.getGmtModified();
        if (gmtModified2 != null ? !gmtModified2.equals(gmtModified3) : gmtModified3 != null) {
            return false;
        }
        LegalService legalService2 = getLegalService();
        LegalService legalService3 = orderInfoListBean.getLegalService();
        if (legalService2 != null ? !legalService2.equals(legalService3) : legalService3 != null) {
            return false;
        }
        List<FeeInfoItem> feeList2 = getFeeList();
        List<FeeInfoItem> feeList3 = orderInfoListBean.getFeeList();
        if (feeList2 != null ? !feeList2.equals(feeList3) : feeList3 != null) {
            return false;
        }
        CardInfo cardInfo2 = getCardInfo();
        CardInfo cardInfo3 = orderInfoListBean.getCardInfo();
        if (cardInfo2 != null ? cardInfo2.equals(cardInfo3) : cardInfo3 == null) {
            return isInNegotiation() == orderInfoListBean.isInNegotiation();
        }
        return false;
    }

    public String getAmount() {
        return this.amount;
    }

    public CardInfo getCardInfo() {
        return this.cardInfo;
    }

    public String getCounterpartNickName() {
        return this.counterpartNickName;
    }

    public String getCounterpartRealName() {
        return this.counterpartRealName;
    }

    public Long getCounterpartUid() {
        return this.counterpartUid;
    }

    public String getCryptoAssetName() {
        return this.cryptoAssetName;
    }

    public String getCryptoAssetSymbol() {
        return this.cryptoAssetSymbol;
    }

    public List<FeeInfoItem> getFeeList() {
        return this.feeList;
    }

    public Long getGmtCreate() {
        return this.gmtCreate;
    }

    public Long getGmtModified() {
        return this.gmtModified;
    }

    public LegalService getLegalService() {
        return this.legalService;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public String getOrderNo() {
        return this.orderNo;
    }

    public Integer getOrderStatus() {
        return this.orderStatus;
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

    public String getQuoteAssetSymbol() {
        return this.quoteAssetSymbol;
    }

    public Integer getRunMode() {
        return this.runMode;
    }

    public Integer getSide() {
        return this.side;
    }

    public String getSideName() {
        return this.sideName;
    }

    public Integer getTradeMode() {
        return this.tradeMode;
    }

    public int hashCode() {
        String orderId2 = getOrderId();
        int i11 = 43;
        int hashCode = orderId2 == null ? 43 : orderId2.hashCode();
        String orderNo2 = getOrderNo();
        int hashCode2 = ((hashCode + 59) * 59) + (orderNo2 == null ? 43 : orderNo2.hashCode());
        Long counterpartUid2 = getCounterpartUid();
        int hashCode3 = (hashCode2 * 59) + (counterpartUid2 == null ? 43 : counterpartUid2.hashCode());
        String counterpartRealName2 = getCounterpartRealName();
        int hashCode4 = (hashCode3 * 59) + (counterpartRealName2 == null ? 43 : counterpartRealName2.hashCode());
        String counterpartNickName2 = getCounterpartNickName();
        int hashCode5 = (hashCode4 * 59) + (counterpartNickName2 == null ? 43 : counterpartNickName2.hashCode());
        Integer side2 = getSide();
        int hashCode6 = (hashCode5 * 59) + (side2 == null ? 43 : side2.hashCode());
        Integer tradeMode2 = getTradeMode();
        int hashCode7 = (hashCode6 * 59) + (tradeMode2 == null ? 43 : tradeMode2.hashCode());
        Integer runMode2 = getRunMode();
        int hashCode8 = (hashCode7 * 59) + (runMode2 == null ? 43 : runMode2.hashCode());
        String sideName2 = getSideName();
        int hashCode9 = (hashCode8 * 59) + (sideName2 == null ? 43 : sideName2.hashCode());
        String quoteAssetName2 = getQuoteAssetName();
        int hashCode10 = (hashCode9 * 59) + (quoteAssetName2 == null ? 43 : quoteAssetName2.hashCode());
        String quoteAssetSymbol2 = getQuoteAssetSymbol();
        int hashCode11 = (hashCode10 * 59) + (quoteAssetSymbol2 == null ? 43 : quoteAssetSymbol2.hashCode());
        String cryptoAssetName2 = getCryptoAssetName();
        int hashCode12 = (hashCode11 * 59) + (cryptoAssetName2 == null ? 43 : cryptoAssetName2.hashCode());
        String cryptoAssetSymbol2 = getCryptoAssetSymbol();
        int hashCode13 = (hashCode12 * 59) + (cryptoAssetSymbol2 == null ? 43 : cryptoAssetSymbol2.hashCode());
        String amount2 = getAmount();
        int hashCode14 = (hashCode13 * 59) + (amount2 == null ? 43 : amount2.hashCode());
        String quantity2 = getQuantity();
        int hashCode15 = (hashCode14 * 59) + (quantity2 == null ? 43 : quantity2.hashCode());
        String quote2 = getQuote();
        int hashCode16 = (hashCode15 * 59) + (quote2 == null ? 43 : quote2.hashCode());
        Integer orderStatus2 = getOrderStatus();
        int hashCode17 = (hashCode16 * 59) + (orderStatus2 == null ? 43 : orderStatus2.hashCode());
        Long gmtCreate2 = getGmtCreate();
        int hashCode18 = (hashCode17 * 59) + (gmtCreate2 == null ? 43 : gmtCreate2.hashCode());
        Long gmtModified2 = getGmtModified();
        int hashCode19 = (hashCode18 * 59) + (gmtModified2 == null ? 43 : gmtModified2.hashCode());
        LegalService legalService2 = getLegalService();
        int hashCode20 = (hashCode19 * 59) + (legalService2 == null ? 43 : legalService2.hashCode());
        List<FeeInfoItem> feeList2 = getFeeList();
        int hashCode21 = (hashCode20 * 59) + (feeList2 == null ? 43 : feeList2.hashCode());
        CardInfo cardInfo2 = getCardInfo();
        int i12 = hashCode21 * 59;
        if (cardInfo2 != null) {
            i11 = cardInfo2.hashCode();
        }
        return ((i12 + i11) * 59) + (isInNegotiation() ? 79 : 97);
    }

    public boolean isInNegotiation() {
        return this.inNegotiation;
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public void setCardInfo(CardInfo cardInfo2) {
        this.cardInfo = cardInfo2;
    }

    public void setCounterpartNickName(String str) {
        this.counterpartNickName = str;
    }

    public void setCounterpartRealName(String str) {
        this.counterpartRealName = str;
    }

    public void setCounterpartUid(Long l11) {
        this.counterpartUid = l11;
    }

    public void setCryptoAssetName(String str) {
        this.cryptoAssetName = str;
    }

    public void setCryptoAssetSymbol(String str) {
        this.cryptoAssetSymbol = str;
    }

    public void setFeeList(List<FeeInfoItem> list) {
        this.feeList = list;
    }

    public void setGmtCreate(Long l11) {
        this.gmtCreate = l11;
    }

    public void setGmtModified(Long l11) {
        this.gmtModified = l11;
    }

    public void setInNegotiation(boolean z11) {
        this.inNegotiation = z11;
    }

    public void setLegalService(LegalService legalService2) {
        this.legalService = legalService2;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }

    public void setOrderNo(String str) {
        this.orderNo = str;
    }

    public void setOrderStatus(Integer num) {
        this.orderStatus = num;
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

    public void setQuoteAssetSymbol(String str) {
        this.quoteAssetSymbol = str;
    }

    public void setRunMode(Integer num) {
        this.runMode = num;
    }

    public void setSide(Integer num) {
        this.side = num;
    }

    public void setSideName(String str) {
        this.sideName = str;
    }

    public void setTradeMode(Integer num) {
        this.tradeMode = num;
    }

    public String toString() {
        return "OrderInfoListBean(orderId=" + getOrderId() + ", orderNo=" + getOrderNo() + ", counterpartUid=" + getCounterpartUid() + ", counterpartRealName=" + getCounterpartRealName() + ", counterpartNickName=" + getCounterpartNickName() + ", side=" + getSide() + ", tradeMode=" + getTradeMode() + ", runMode=" + getRunMode() + ", sideName=" + getSideName() + ", quoteAssetName=" + getQuoteAssetName() + ", quoteAssetSymbol=" + getQuoteAssetSymbol() + ", cryptoAssetName=" + getCryptoAssetName() + ", cryptoAssetSymbol=" + getCryptoAssetSymbol() + ", amount=" + getAmount() + ", quantity=" + getQuantity() + ", quote=" + getQuote() + ", orderStatus=" + getOrderStatus() + ", gmtCreate=" + getGmtCreate() + ", gmtModified=" + getGmtModified() + ", legalService=" + getLegalService() + ", feeList=" + getFeeList() + ", cardInfo=" + getCardInfo() + ", inNegotiation=" + isInNegotiation() + ")";
    }
}
