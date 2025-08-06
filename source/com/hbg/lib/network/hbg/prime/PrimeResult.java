package com.hbg.lib.network.hbg.prime;

import java.io.Serializable;
import java.util.List;

public class PrimeResult implements Serializable {
    private static final long serialVersionUID = -3008641217156008554L;
    private List<String> bidIds;
    private List<PrimeBidResultDetail> detail;
    private boolean isFinished;
    private boolean isLucky;
    private String orderId;
    private String quotaAmount;
    private String quotaPerBid;
    private List<String> winBidIds;
    private String winRate;

    public boolean canEqual(Object obj) {
        return obj instanceof PrimeResult;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PrimeResult)) {
            return false;
        }
        PrimeResult primeResult = (PrimeResult) obj;
        if (!primeResult.canEqual(this)) {
            return false;
        }
        String quotaAmount2 = getQuotaAmount();
        String quotaAmount3 = primeResult.getQuotaAmount();
        if (quotaAmount2 != null ? !quotaAmount2.equals(quotaAmount3) : quotaAmount3 != null) {
            return false;
        }
        String orderId2 = getOrderId();
        String orderId3 = primeResult.getOrderId();
        if (orderId2 != null ? !orderId2.equals(orderId3) : orderId3 != null) {
            return false;
        }
        if (isLucky() != primeResult.isLucky() || isFinished() != primeResult.isFinished()) {
            return false;
        }
        String quotaPerBid2 = getQuotaPerBid();
        String quotaPerBid3 = primeResult.getQuotaPerBid();
        if (quotaPerBid2 != null ? !quotaPerBid2.equals(quotaPerBid3) : quotaPerBid3 != null) {
            return false;
        }
        List<String> bidIds2 = getBidIds();
        List<String> bidIds3 = primeResult.getBidIds();
        if (bidIds2 != null ? !bidIds2.equals(bidIds3) : bidIds3 != null) {
            return false;
        }
        List<String> winBidIds2 = getWinBidIds();
        List<String> winBidIds3 = primeResult.getWinBidIds();
        if (winBidIds2 != null ? !winBidIds2.equals(winBidIds3) : winBidIds3 != null) {
            return false;
        }
        String winRate2 = getWinRate();
        String winRate3 = primeResult.getWinRate();
        if (winRate2 != null ? !winRate2.equals(winRate3) : winRate3 != null) {
            return false;
        }
        List<PrimeBidResultDetail> detail2 = getDetail();
        List<PrimeBidResultDetail> detail3 = primeResult.getDetail();
        return detail2 != null ? detail2.equals(detail3) : detail3 == null;
    }

    public List<String> getBidIds() {
        return this.bidIds;
    }

    public List<PrimeBidResultDetail> getDetail() {
        return this.detail;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public String getQuotaAmount() {
        return this.quotaAmount;
    }

    public String getQuotaPerBid() {
        return this.quotaPerBid;
    }

    public List<String> getWinBidIds() {
        return this.winBidIds;
    }

    public String getWinRate() {
        return this.winRate;
    }

    public int hashCode() {
        String quotaAmount2 = getQuotaAmount();
        int i11 = 43;
        int hashCode = quotaAmount2 == null ? 43 : quotaAmount2.hashCode();
        String orderId2 = getOrderId();
        int i12 = 79;
        int hashCode2 = (((((hashCode + 59) * 59) + (orderId2 == null ? 43 : orderId2.hashCode())) * 59) + (isLucky() ? 79 : 97)) * 59;
        if (!isFinished()) {
            i12 = 97;
        }
        String quotaPerBid2 = getQuotaPerBid();
        int hashCode3 = ((hashCode2 + i12) * 59) + (quotaPerBid2 == null ? 43 : quotaPerBid2.hashCode());
        List<String> bidIds2 = getBidIds();
        int hashCode4 = (hashCode3 * 59) + (bidIds2 == null ? 43 : bidIds2.hashCode());
        List<String> winBidIds2 = getWinBidIds();
        int hashCode5 = (hashCode4 * 59) + (winBidIds2 == null ? 43 : winBidIds2.hashCode());
        String winRate2 = getWinRate();
        int hashCode6 = (hashCode5 * 59) + (winRate2 == null ? 43 : winRate2.hashCode());
        List<PrimeBidResultDetail> detail2 = getDetail();
        int i13 = hashCode6 * 59;
        if (detail2 != null) {
            i11 = detail2.hashCode();
        }
        return i13 + i11;
    }

    public boolean isFinished() {
        return this.isFinished;
    }

    public boolean isLucky() {
        return this.isLucky;
    }

    public void setBidIds(List<String> list) {
        this.bidIds = list;
    }

    public void setDetail(List<PrimeBidResultDetail> list) {
        this.detail = list;
    }

    public void setFinished(boolean z11) {
        this.isFinished = z11;
    }

    public void setLucky(boolean z11) {
        this.isLucky = z11;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }

    public void setQuotaAmount(String str) {
        this.quotaAmount = str;
    }

    public void setQuotaPerBid(String str) {
        this.quotaPerBid = str;
    }

    public void setWinBidIds(List<String> list) {
        this.winBidIds = list;
    }

    public void setWinRate(String str) {
        this.winRate = str;
    }

    public String toString() {
        return "PrimeResult(quotaAmount=" + getQuotaAmount() + ", orderId=" + getOrderId() + ", isLucky=" + isLucky() + ", isFinished=" + isFinished() + ", quotaPerBid=" + getQuotaPerBid() + ", bidIds=" + getBidIds() + ", winBidIds=" + getWinBidIds() + ", winRate=" + getWinRate() + ", detail=" + getDetail() + ")";
    }
}
