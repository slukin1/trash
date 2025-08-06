package com.huobi.otc.bean;

import android.text.TextUtils;
import com.hbg.lib.core.util.CollectionsUtils;
import com.hbg.lib.network.otc.core.bean.OtcOrderDetailBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class OtcOrderDetailInfo implements Serializable {
    private OtcAppealBean appeal;
    private List<BankInfoBean> bankInfo;
    private List<OtcOrderDetailBean.FeeDetail> feeDetails;
    private OtcOrderDetailBean.HbPayOrder hbPayOrder;
    private boolean inNegotiation;
    private boolean isFeeFinish = true;
    private boolean isSoonLock;
    private boolean isTaker;
    private OtcOrderBean order;
    private List<OtcOrderDetailBean.OrderCancelConsults> orderCancelConsults;
    private OtcOrderCoupons orderCoupons;
    private OtcOrderFee orderFee;
    private OtcOrderDetailBean.OrderTag orderTag;
    private OtherInfoBean otherInfo;
    private TradeBean trade;
    private String tradeInstructionStatus;
    private OtcOrderUserInfo userInfo;

    public static OtcOrderDetailInfo coverData(OtcOrderDetailBean otcOrderDetailBean) {
        int i11;
        int i12;
        long j11;
        OtcOrderDetailInfo otcOrderDetailInfo = new OtcOrderDetailInfo();
        otcOrderDetailInfo.setHbPayOrder(otcOrderDetailBean.getHbPayOrder());
        OtcOrderBean otcOrderBean = new OtcOrderBean();
        otcOrderDetailInfo.setOtcOrder(otcOrderBean);
        long j12 = 0;
        if (otcOrderDetailBean.getOrderInfo() != null) {
            otcOrderBean.setId(otcOrderDetailBean.getOrderInfo().getOrderId());
            otcOrderBean.setOrderNo(otcOrderDetailBean.getOrderInfo().getOrderNo());
            otcOrderBean.setTradeType(otcOrderDetailBean.getOrderInfo().getSide());
            otcOrderBean.setCoinId(otcOrderDetailBean.getOrderInfo().getCryptoAssetId());
            otcOrderBean.setPrice(otcOrderDetailBean.getOrderInfo().getQuote());
            otcOrderBean.setCurrency(otcOrderDetailBean.getOrderInfo().getQuoteAssetId());
            otcOrderBean.setStatus(otcOrderDetailBean.getOrderInfo().getOrderStatus());
            otcOrderBean.setAreaType(otcOrderDetailBean.getOrderInfo().getAreaType());
            otcOrderBean.setGmtCreate(otcOrderDetailBean.getOrderInfo().getGmtCreate());
            otcOrderBean.setOrderType(otcOrderDetailBean.getOrderInfo().getTradeMode());
            otcOrderBean.setRunMode(Integer.valueOf(otcOrderDetailBean.getOrderInfo().getRunMode()));
            otcOrderBean.setAmount(otcOrderDetailBean.getOrderInfo().getAmount());
            otcOrderBean.setQuantity(otcOrderDetailBean.getOrderInfo().getQuantity());
            if (otcOrderDetailBean.getOrderInfo().getGmtModified() == null) {
                j11 = 0;
            } else {
                j11 = otcOrderDetailBean.getOrderInfo().getGmtModified().longValue();
            }
            otcOrderBean.setGmtModified(j11);
            otcOrderDetailInfo.setTaker(TextUtils.equals(otcOrderDetailBean.getOrderInfo().getRoleName(), "taker"));
            otcOrderBean.setTradeMode(otcOrderDetailBean.getOrderInfo().getTradeMode());
            otcOrderBean.setQuoteAssetName(otcOrderDetailBean.getOrderInfo().getQuoteAssetName());
            otcOrderBean.setCryptoAssetName(otcOrderDetailBean.getOrderInfo().getCryptoAssetName());
            otcOrderBean.setLiquidDivision(otcOrderDetailBean.getOrderInfo().getLiquidDivision());
        }
        OtherInfoBean otherInfoBean = new OtherInfoBean();
        otcOrderDetailInfo.setOtherInfo(otherInfoBean);
        if (otcOrderDetailBean.getOtherInfo() != null) {
            otherInfoBean.setUid(otcOrderDetailBean.getOtherInfo().getUid());
            otherInfoBean.setUserName(otcOrderDetailBean.getOtherInfo().getNickName());
            otherInfoBean.setMerchantLevel(otcOrderDetailBean.getOtherInfo().getMerchantLevel());
            otherInfoBean.setMarginCoinId(otcOrderDetailBean.getOtherInfo().getMarginAssetId());
            otherInfoBean.setMarginAmount(otcOrderDetailBean.getOtherInfo().getMarginAmount());
            otherInfoBean.setSeniorAuth(otcOrderDetailBean.getOtherInfo().isSeniorAuth());
            otcOrderBean.setTradeUserName(otcOrderDetailBean.getOtherInfo().getNickName());
            otcOrderBean.setTradeRealName(otcOrderDetailBean.getOtherInfo().getRealName());
            otcOrderBean.setTradeUid(otcOrderDetailBean.getOtherInfo().getUid());
            otcOrderBean.setThumbUp(otcOrderDetailBean.getOtherInfo().getThumbUp());
        }
        if (otcOrderDetailBean.getExchangeOrder() != null) {
            otcOrderBean.setSmallCoinId(otcOrderDetailBean.getExchangeOrder().getCryptoAssetId());
            otcOrderBean.setSmallCoinName(otcOrderDetailBean.getExchangeOrder().getCryptoAssetName());
            otcOrderBean.setBaseCoinId(otcOrderDetailBean.getExchangeOrder().getQuoteAssetId());
            otcOrderBean.setBaseCoinName(otcOrderDetailBean.getExchangeOrder().getQuoteAssetName());
            otcOrderBean.setBaseCoinPrice(otcOrderDetailBean.getExchangeOrder().getQuote());
        }
        boolean z11 = false;
        if (otcOrderDetailBean.getC2cOrder() != null) {
            if (otcOrderDetailBean.getC2cOrder().getBuyPayAccount() == null) {
                i11 = 0;
            } else {
                i11 = otcOrderDetailBean.getC2cOrder().getBuyPayAccount().intValue();
            }
            otcOrderBean.setBuyPayAccount(i11);
            otcOrderBean.setPayTerm(otcOrderDetailBean.getC2cOrder().getPayTerm());
            otcOrderBean.setGmtPay(!TextUtils.isEmpty(otcOrderDetailBean.getC2cOrder().getGmtPay()) ? Long.parseLong(otcOrderDetailBean.getC2cOrder().getGmtPay()) : 0);
            if (otcOrderDetailBean.getC2cOrder().getGmtResetCancel() != null) {
                j12 = otcOrderDetailBean.getC2cOrder().getGmtResetCancel().longValue();
            }
            otcOrderBean.setGmtResetCancel(j12);
            if (otcOrderDetailBean.getC2cOrder().getMatchPayId() == null) {
                i12 = 0;
            } else {
                i12 = otcOrderDetailBean.getC2cOrder().getMatchPayId().intValue();
            }
            otcOrderBean.setMatchPayId(i12);
            otcOrderBean.setBaseCoinAmount(otcOrderDetailBean.getC2cOrder().getQuantity());
            otcOrderBean.setCancelCountDown(otcOrderDetailBean.getC2cOrder().getCancelCountDown());
            otcOrderBean.setAppCountDown(otcOrderDetailBean.getC2cOrder().getAppCountDown());
            otcOrderBean.setAppMaxCountDown(otcOrderDetailBean.getC2cOrder().getAppMaxCountDown());
            otcOrderBean.setAcceptStatus(otcOrderDetailBean.getC2cOrder().getAcceptStatus());
            otcOrderBean.setConsultCancelCountDown(otcOrderDetailBean.getC2cOrder().getConsultCancelCountDown());
        }
        OtcAppealBean otcAppealBean = new OtcAppealBean();
        otcOrderDetailInfo.setAppeal(otcAppealBean);
        if (otcOrderDetailBean.getAppealInfo() != null) {
            otcAppealBean.setAppealCode(otcOrderDetailBean.getAppealInfo().getAppealCode());
            otcAppealBean.setCancle(otcOrderDetailBean.getAppealInfo().isCancel());
            otcAppealBean.setType(otcOrderDetailBean.getAppealInfo().getType());
            otcAppealBean.setDescription(otcOrderDetailBean.getAppealInfo().getAppealReason());
            otcAppealBean.setBeforeStatus(otcOrderDetailBean.getAppealInfo().getBeforeStatus());
        }
        ArrayList arrayList = new ArrayList();
        otcOrderDetailInfo.setBankInfo(arrayList);
        if (!CollectionsUtils.b(otcOrderDetailBean.getPaymentMethod())) {
            for (int i13 = 0; i13 < otcOrderDetailBean.getPaymentMethod().size(); i13++) {
                BankInfoBean bankInfoBean = new BankInfoBean();
                OtcOrderDetailBean.PaymentMethod paymentMethod = otcOrderDetailBean.getPaymentMethod().get(i13);
                bankInfoBean.setId(paymentMethod.getId());
                bankInfoBean.setUserName(paymentMethod.getUserName());
                bankInfoBean.setBankType(paymentMethod.getBankType());
                bankInfoBean.setBankNumber(paymentMethod.getBankNumber());
                bankInfoBean.setBankName(paymentMethod.getBankName());
                bankInfoBean.setBankAddress(paymentMethod.getBankAddress());
                bankInfoBean.setQrCode(paymentMethod.getQrCode());
                bankInfoBean.setModelFieldsList(paymentMethod.getModelFieldsList());
                bankInfoBean.setPayMethodName(paymentMethod.getPayMethodName());
                bankInfoBean.setPaymentStatus(paymentMethod.getPaymentStatus());
                bankInfoBean.setColor(paymentMethod.getColor());
                arrayList.add(bankInfoBean);
            }
        }
        if (!(otcOrderDetailBean.getFeeInfo() == null || otcOrderDetailBean.getFeeInfo().getFeeList() == null)) {
            otcOrderDetailInfo.setFeeDetails(otcOrderDetailBean.getFeeInfo().getFeeList());
            for (int i14 = 0; i14 < otcOrderDetailBean.getFeeInfo().getFeeList().size(); i14++) {
                OtcOrderDetailBean.FeeDetail feeDetail = otcOrderDetailBean.getFeeInfo().getFeeList().get(i14);
                if ((feeDetail.getFeeType() == 1 || feeDetail.getFeeType() == 3) && feeDetail.getFeeStatus() == 1) {
                    otcOrderDetailInfo.setFeeFinish(false);
                }
            }
        }
        if (otcOrderDetailBean.getCouponsInfo() != null) {
            OtcOrderCoupons otcOrderCoupons = new OtcOrderCoupons();
            otcOrderDetailInfo.setOrderCoupons(otcOrderCoupons);
            otcOrderCoupons.setAmount(otcOrderDetailBean.getCouponsInfo().getAmount());
            otcOrderCoupons.setQuantity(otcOrderDetailBean.getCouponsInfo().getQuantity());
            otcOrderCoupons.setTotalAmount(otcOrderDetailBean.getCouponsInfo().getTotalAmount());
            otcOrderCoupons.setDescribe(otcOrderDetailBean.getCouponsInfo().getDescribe());
        }
        if (otcOrderDetailBean.getOrderTag() != null) {
            if (otcOrderDetailBean.getOrderTag().getIsSoonLock() == 1) {
                z11 = true;
            }
            otcOrderDetailInfo.setIsSoonLock(z11);
            otcOrderDetailInfo.setOrderTag(otcOrderDetailBean.getOrderTag());
            otcOrderBean.setNow(otcOrderDetailBean.getOrderTag().getNow());
        }
        otcOrderDetailInfo.setOrderCancelConsults(otcOrderDetailBean.getOrderCancelConsults());
        otcOrderDetailInfo.setInNegotiation(otcOrderDetailBean.isInNegotiation());
        OtcOrderDetailBean.OrderSnapshot orderSnapshot = otcOrderDetailBean.getOrderSnapshot();
        if (orderSnapshot != null) {
            otcOrderDetailInfo.setTradeInstructionStatus(orderSnapshot.getTradeInstructionStatus());
        }
        return otcOrderDetailInfo;
    }

    public boolean canEqual(Object obj) {
        return obj instanceof OtcOrderDetailInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OtcOrderDetailInfo)) {
            return false;
        }
        OtcOrderDetailInfo otcOrderDetailInfo = (OtcOrderDetailInfo) obj;
        if (!otcOrderDetailInfo.canEqual(this)) {
            return false;
        }
        OtherInfoBean otherInfo2 = getOtherInfo();
        OtherInfoBean otherInfo3 = otcOrderDetailInfo.getOtherInfo();
        if (otherInfo2 != null ? !otherInfo2.equals(otherInfo3) : otherInfo3 != null) {
            return false;
        }
        OtcOrderBean order2 = getOrder();
        OtcOrderBean order3 = otcOrderDetailInfo.getOrder();
        if (order2 != null ? !order2.equals(order3) : order3 != null) {
            return false;
        }
        OtcAppealBean appeal2 = getAppeal();
        OtcAppealBean appeal3 = otcOrderDetailInfo.getAppeal();
        if (appeal2 != null ? !appeal2.equals(appeal3) : appeal3 != null) {
            return false;
        }
        if (isIsSoonLock() != otcOrderDetailInfo.isIsSoonLock()) {
            return false;
        }
        List<BankInfoBean> bankInfo2 = getBankInfo();
        List<BankInfoBean> bankInfo3 = otcOrderDetailInfo.getBankInfo();
        if (bankInfo2 != null ? !bankInfo2.equals(bankInfo3) : bankInfo3 != null) {
            return false;
        }
        TradeBean trade2 = getTrade();
        TradeBean trade3 = otcOrderDetailInfo.getTrade();
        if (trade2 != null ? !trade2.equals(trade3) : trade3 != null) {
            return false;
        }
        OtcOrderFee orderFee2 = getOrderFee();
        OtcOrderFee orderFee3 = otcOrderDetailInfo.getOrderFee();
        if (orderFee2 != null ? !orderFee2.equals(orderFee3) : orderFee3 != null) {
            return false;
        }
        if (isTaker() != otcOrderDetailInfo.isTaker()) {
            return false;
        }
        OtcOrderUserInfo userInfo2 = getUserInfo();
        OtcOrderUserInfo userInfo3 = otcOrderDetailInfo.getUserInfo();
        if (userInfo2 != null ? !userInfo2.equals(userInfo3) : userInfo3 != null) {
            return false;
        }
        OtcOrderCoupons orderCoupons2 = getOrderCoupons();
        OtcOrderCoupons orderCoupons3 = otcOrderDetailInfo.getOrderCoupons();
        if (orderCoupons2 != null ? !orderCoupons2.equals(orderCoupons3) : orderCoupons3 != null) {
            return false;
        }
        OtcOrderDetailBean.OrderTag orderTag2 = getOrderTag();
        OtcOrderDetailBean.OrderTag orderTag3 = otcOrderDetailInfo.getOrderTag();
        if (orderTag2 != null ? !orderTag2.equals(orderTag3) : orderTag3 != null) {
            return false;
        }
        List<OtcOrderDetailBean.FeeDetail> feeDetails2 = getFeeDetails();
        List<OtcOrderDetailBean.FeeDetail> feeDetails3 = otcOrderDetailInfo.getFeeDetails();
        if (feeDetails2 != null ? !feeDetails2.equals(feeDetails3) : feeDetails3 != null) {
            return false;
        }
        if (isFeeFinish() != otcOrderDetailInfo.isFeeFinish()) {
            return false;
        }
        List<OtcOrderDetailBean.OrderCancelConsults> orderCancelConsults2 = getOrderCancelConsults();
        List<OtcOrderDetailBean.OrderCancelConsults> orderCancelConsults3 = otcOrderDetailInfo.getOrderCancelConsults();
        if (orderCancelConsults2 != null ? !orderCancelConsults2.equals(orderCancelConsults3) : orderCancelConsults3 != null) {
            return false;
        }
        if (isInNegotiation() != otcOrderDetailInfo.isInNegotiation()) {
            return false;
        }
        OtcOrderDetailBean.HbPayOrder hbPayOrder2 = getHbPayOrder();
        OtcOrderDetailBean.HbPayOrder hbPayOrder3 = otcOrderDetailInfo.getHbPayOrder();
        if (hbPayOrder2 != null ? !hbPayOrder2.equals(hbPayOrder3) : hbPayOrder3 != null) {
            return false;
        }
        String tradeInstructionStatus2 = getTradeInstructionStatus();
        String tradeInstructionStatus3 = otcOrderDetailInfo.getTradeInstructionStatus();
        return tradeInstructionStatus2 != null ? tradeInstructionStatus2.equals(tradeInstructionStatus3) : tradeInstructionStatus3 == null;
    }

    public OtcAppealBean getAppeal() {
        return this.appeal;
    }

    public List<BankInfoBean> getBankInfo() {
        return this.bankInfo;
    }

    public List<OtcOrderDetailBean.FeeDetail> getFeeDetails() {
        return this.feeDetails;
    }

    public OtcOrderDetailBean.HbPayOrder getHbPayOrder() {
        return this.hbPayOrder;
    }

    public OtcOrderBean getOrder() {
        return this.order;
    }

    public List<OtcOrderDetailBean.OrderCancelConsults> getOrderCancelConsults() {
        return this.orderCancelConsults;
    }

    public OtcOrderCoupons getOrderCoupons() {
        return this.orderCoupons;
    }

    public OtcOrderFee getOrderFee() {
        return this.orderFee;
    }

    public OtcOrderDetailBean.OrderTag getOrderTag() {
        return this.orderTag;
    }

    public OtcAppealBean getOtcAppeal() {
        return this.appeal;
    }

    public OtcOrderBean getOtcOrder() {
        return this.order;
    }

    public OtherInfoBean getOtherInfo() {
        return this.otherInfo;
    }

    public TradeBean getTrade() {
        return this.trade;
    }

    public String getTradeInstructionStatus() {
        return this.tradeInstructionStatus;
    }

    public OtcOrderUserInfo getUserInfo() {
        return this.userInfo;
    }

    public int hashCode() {
        OtherInfoBean otherInfo2 = getOtherInfo();
        int i11 = 43;
        int hashCode = otherInfo2 == null ? 43 : otherInfo2.hashCode();
        OtcOrderBean order2 = getOrder();
        int hashCode2 = ((hashCode + 59) * 59) + (order2 == null ? 43 : order2.hashCode());
        OtcAppealBean appeal2 = getAppeal();
        int i12 = 79;
        int hashCode3 = (((hashCode2 * 59) + (appeal2 == null ? 43 : appeal2.hashCode())) * 59) + (isIsSoonLock() ? 79 : 97);
        List<BankInfoBean> bankInfo2 = getBankInfo();
        int hashCode4 = (hashCode3 * 59) + (bankInfo2 == null ? 43 : bankInfo2.hashCode());
        TradeBean trade2 = getTrade();
        int hashCode5 = (hashCode4 * 59) + (trade2 == null ? 43 : trade2.hashCode());
        OtcOrderFee orderFee2 = getOrderFee();
        int hashCode6 = (((hashCode5 * 59) + (orderFee2 == null ? 43 : orderFee2.hashCode())) * 59) + (isTaker() ? 79 : 97);
        OtcOrderUserInfo userInfo2 = getUserInfo();
        int hashCode7 = (hashCode6 * 59) + (userInfo2 == null ? 43 : userInfo2.hashCode());
        OtcOrderCoupons orderCoupons2 = getOrderCoupons();
        int hashCode8 = (hashCode7 * 59) + (orderCoupons2 == null ? 43 : orderCoupons2.hashCode());
        OtcOrderDetailBean.OrderTag orderTag2 = getOrderTag();
        int hashCode9 = (hashCode8 * 59) + (orderTag2 == null ? 43 : orderTag2.hashCode());
        List<OtcOrderDetailBean.FeeDetail> feeDetails2 = getFeeDetails();
        int hashCode10 = (((hashCode9 * 59) + (feeDetails2 == null ? 43 : feeDetails2.hashCode())) * 59) + (isFeeFinish() ? 79 : 97);
        List<OtcOrderDetailBean.OrderCancelConsults> orderCancelConsults2 = getOrderCancelConsults();
        int hashCode11 = ((hashCode10 * 59) + (orderCancelConsults2 == null ? 43 : orderCancelConsults2.hashCode())) * 59;
        if (!isInNegotiation()) {
            i12 = 97;
        }
        OtcOrderDetailBean.HbPayOrder hbPayOrder2 = getHbPayOrder();
        int hashCode12 = ((hashCode11 + i12) * 59) + (hbPayOrder2 == null ? 43 : hbPayOrder2.hashCode());
        String tradeInstructionStatus2 = getTradeInstructionStatus();
        int i13 = hashCode12 * 59;
        if (tradeInstructionStatus2 != null) {
            i11 = tradeInstructionStatus2.hashCode();
        }
        return i13 + i11;
    }

    public boolean isFeeFinish() {
        return this.isFeeFinish;
    }

    public boolean isInNegotiation() {
        return this.inNegotiation;
    }

    public boolean isIsSoonLock() {
        return this.isSoonLock;
    }

    public boolean isTaker() {
        return this.isTaker;
    }

    public void setAppeal(OtcAppealBean otcAppealBean) {
        this.appeal = otcAppealBean;
    }

    public void setBankInfo(List<BankInfoBean> list) {
        this.bankInfo = list;
    }

    public void setFeeDetails(List<OtcOrderDetailBean.FeeDetail> list) {
        this.feeDetails = list;
    }

    public void setFeeFinish(boolean z11) {
        this.isFeeFinish = z11;
    }

    public void setHbPayOrder(OtcOrderDetailBean.HbPayOrder hbPayOrder2) {
        this.hbPayOrder = hbPayOrder2;
    }

    public void setInNegotiation(boolean z11) {
        this.inNegotiation = z11;
    }

    public void setIsSoonLock(boolean z11) {
        this.isSoonLock = z11;
    }

    public void setOrder(OtcOrderBean otcOrderBean) {
        this.order = otcOrderBean;
    }

    public void setOrderCancelConsults(List<OtcOrderDetailBean.OrderCancelConsults> list) {
        this.orderCancelConsults = list;
    }

    public void setOrderCoupons(OtcOrderCoupons otcOrderCoupons) {
        this.orderCoupons = otcOrderCoupons;
    }

    public void setOrderFee(OtcOrderFee otcOrderFee) {
        this.orderFee = otcOrderFee;
    }

    public void setOrderTag(OtcOrderDetailBean.OrderTag orderTag2) {
        this.orderTag = orderTag2;
    }

    public void setOtcAppeal(OtcAppealBean otcAppealBean) {
        this.appeal = otcAppealBean;
    }

    public void setOtcOrder(OtcOrderBean otcOrderBean) {
        this.order = otcOrderBean;
    }

    public void setOtherInfo(OtherInfoBean otherInfoBean) {
        this.otherInfo = otherInfoBean;
    }

    public void setTaker(boolean z11) {
        this.isTaker = z11;
    }

    public void setTrade(TradeBean tradeBean) {
        this.trade = tradeBean;
    }

    public void setTradeInstructionStatus(String str) {
        this.tradeInstructionStatus = str;
    }

    public void setUserInfo(OtcOrderUserInfo otcOrderUserInfo) {
        this.userInfo = otcOrderUserInfo;
    }

    public String toString() {
        return "OtcOrderDetailInfo(otherInfo=" + getOtherInfo() + ", order=" + getOrder() + ", appeal=" + getAppeal() + ", isSoonLock=" + isIsSoonLock() + ", bankInfo=" + getBankInfo() + ", trade=" + getTrade() + ", orderFee=" + getOrderFee() + ", isTaker=" + isTaker() + ", userInfo=" + getUserInfo() + ", orderCoupons=" + getOrderCoupons() + ", orderTag=" + getOrderTag() + ", feeDetails=" + getFeeDetails() + ", isFeeFinish=" + isFeeFinish() + ", orderCancelConsults=" + getOrderCancelConsults() + ", inNegotiation=" + isInNegotiation() + ", hbPayOrder=" + getHbPayOrder() + ", tradeInstructionStatus=" + getTradeInstructionStatus() + ")";
    }
}
