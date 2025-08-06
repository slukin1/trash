package com.huobi.otc.bean;

import com.hbg.lib.network.otc.core.bean.OtcAdTicket;
import java.io.Serializable;

public class OtcOptionalPlaceOrderFromBean implements Serializable {
    public String amount;
    public int couponId;
    public boolean fromWatchword;
    public boolean isAcceptOrder;
    public boolean isContinue;
    public boolean isUseVerify;
    public OtcAdTicket otcAdTicket;
    public String pwd;
    public String securityToken;
    public String shareCode;
    public String ticketId;
    public String traceId;
    public String tradeId;
    public String watchword;

    public boolean canEqual(Object obj) {
        return obj instanceof OtcOptionalPlaceOrderFromBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OtcOptionalPlaceOrderFromBean)) {
            return false;
        }
        OtcOptionalPlaceOrderFromBean otcOptionalPlaceOrderFromBean = (OtcOptionalPlaceOrderFromBean) obj;
        if (!otcOptionalPlaceOrderFromBean.canEqual(this)) {
            return false;
        }
        String ticketId2 = getTicketId();
        String ticketId3 = otcOptionalPlaceOrderFromBean.getTicketId();
        if (ticketId2 != null ? !ticketId2.equals(ticketId3) : ticketId3 != null) {
            return false;
        }
        String tradeId2 = getTradeId();
        String tradeId3 = otcOptionalPlaceOrderFromBean.getTradeId();
        if (tradeId2 != null ? !tradeId2.equals(tradeId3) : tradeId3 != null) {
            return false;
        }
        String amount2 = getAmount();
        String amount3 = otcOptionalPlaceOrderFromBean.getAmount();
        if (amount2 != null ? !amount2.equals(amount3) : amount3 != null) {
            return false;
        }
        String pwd2 = getPwd();
        String pwd3 = otcOptionalPlaceOrderFromBean.getPwd();
        if (pwd2 != null ? !pwd2.equals(pwd3) : pwd3 != null) {
            return false;
        }
        OtcAdTicket otcAdTicket2 = getOtcAdTicket();
        OtcAdTicket otcAdTicket3 = otcOptionalPlaceOrderFromBean.getOtcAdTicket();
        if (otcAdTicket2 != null ? !otcAdTicket2.equals(otcAdTicket3) : otcAdTicket3 != null) {
            return false;
        }
        if (isContinue() != otcOptionalPlaceOrderFromBean.isContinue() || getCouponId() != otcOptionalPlaceOrderFromBean.getCouponId() || isAcceptOrder() != otcOptionalPlaceOrderFromBean.isAcceptOrder() || isUseVerify() != otcOptionalPlaceOrderFromBean.isUseVerify()) {
            return false;
        }
        String securityToken2 = getSecurityToken();
        String securityToken3 = otcOptionalPlaceOrderFromBean.getSecurityToken();
        if (securityToken2 != null ? !securityToken2.equals(securityToken3) : securityToken3 != null) {
            return false;
        }
        String traceId2 = getTraceId();
        String traceId3 = otcOptionalPlaceOrderFromBean.getTraceId();
        if (traceId2 != null ? !traceId2.equals(traceId3) : traceId3 != null) {
            return false;
        }
        if (isFromWatchword() != otcOptionalPlaceOrderFromBean.isFromWatchword()) {
            return false;
        }
        String shareCode2 = getShareCode();
        String shareCode3 = otcOptionalPlaceOrderFromBean.getShareCode();
        if (shareCode2 != null ? !shareCode2.equals(shareCode3) : shareCode3 != null) {
            return false;
        }
        String watchword2 = getWatchword();
        String watchword3 = otcOptionalPlaceOrderFromBean.getWatchword();
        return watchword2 != null ? watchword2.equals(watchword3) : watchword3 == null;
    }

    public String getAmount() {
        return this.amount;
    }

    public int getCouponId() {
        return this.couponId;
    }

    public OtcAdTicket getOtcAdTicket() {
        return this.otcAdTicket;
    }

    public String getPwd() {
        return this.pwd;
    }

    public String getSecurityToken() {
        return this.securityToken;
    }

    public String getShareCode() {
        return this.shareCode;
    }

    public String getTicketId() {
        return this.ticketId;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public String getTradeId() {
        return this.tradeId;
    }

    public String getWatchword() {
        return this.watchword;
    }

    public int hashCode() {
        String ticketId2 = getTicketId();
        int i11 = 43;
        int hashCode = ticketId2 == null ? 43 : ticketId2.hashCode();
        String tradeId2 = getTradeId();
        int hashCode2 = ((hashCode + 59) * 59) + (tradeId2 == null ? 43 : tradeId2.hashCode());
        String amount2 = getAmount();
        int hashCode3 = (hashCode2 * 59) + (amount2 == null ? 43 : amount2.hashCode());
        String pwd2 = getPwd();
        int hashCode4 = (hashCode3 * 59) + (pwd2 == null ? 43 : pwd2.hashCode());
        OtcAdTicket otcAdTicket2 = getOtcAdTicket();
        int i12 = 79;
        int hashCode5 = (((((((((hashCode4 * 59) + (otcAdTicket2 == null ? 43 : otcAdTicket2.hashCode())) * 59) + (isContinue() ? 79 : 97)) * 59) + getCouponId()) * 59) + (isAcceptOrder() ? 79 : 97)) * 59) + (isUseVerify() ? 79 : 97);
        String securityToken2 = getSecurityToken();
        int hashCode6 = (hashCode5 * 59) + (securityToken2 == null ? 43 : securityToken2.hashCode());
        String traceId2 = getTraceId();
        int hashCode7 = ((hashCode6 * 59) + (traceId2 == null ? 43 : traceId2.hashCode())) * 59;
        if (!isFromWatchword()) {
            i12 = 97;
        }
        String shareCode2 = getShareCode();
        int hashCode8 = ((hashCode7 + i12) * 59) + (shareCode2 == null ? 43 : shareCode2.hashCode());
        String watchword2 = getWatchword();
        int i13 = hashCode8 * 59;
        if (watchword2 != null) {
            i11 = watchword2.hashCode();
        }
        return i13 + i11;
    }

    public boolean isAcceptOrder() {
        return this.isAcceptOrder;
    }

    public boolean isContinue() {
        return this.isContinue;
    }

    public boolean isFromWatchword() {
        return this.fromWatchword;
    }

    public boolean isUseVerify() {
        return this.isUseVerify;
    }

    public void setAcceptOrder(boolean z11) {
        this.isAcceptOrder = z11;
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public void setContinue(boolean z11) {
        this.isContinue = z11;
    }

    public void setCouponId(int i11) {
        this.couponId = i11;
    }

    public void setFromWatchword(boolean z11) {
        this.fromWatchword = z11;
    }

    public void setOtcAdTicket(OtcAdTicket otcAdTicket2) {
        this.otcAdTicket = otcAdTicket2;
    }

    public void setPwd(String str) {
        this.pwd = str;
    }

    public void setSecurityToken(String str) {
        this.securityToken = str;
    }

    public void setShareCode(String str) {
        this.shareCode = str;
    }

    public void setTicketId(String str) {
        this.ticketId = str;
    }

    public void setTraceId(String str) {
        this.traceId = str;
    }

    public void setTradeId(String str) {
        this.tradeId = str;
    }

    public void setUseVerify(boolean z11) {
        this.isUseVerify = z11;
    }

    public void setWatchword(String str) {
        this.watchword = str;
    }

    public String toString() {
        return "OtcOptionalPlaceOrderFromBean(ticketId=" + getTicketId() + ", tradeId=" + getTradeId() + ", amount=" + getAmount() + ", pwd=" + getPwd() + ", otcAdTicket=" + getOtcAdTicket() + ", isContinue=" + isContinue() + ", couponId=" + getCouponId() + ", isAcceptOrder=" + isAcceptOrder() + ", isUseVerify=" + isUseVerify() + ", securityToken=" + getSecurityToken() + ", traceId=" + getTraceId() + ", fromWatchword=" + isFromWatchword() + ", shareCode=" + getShareCode() + ", watchword=" + getWatchword() + ")";
    }
}
