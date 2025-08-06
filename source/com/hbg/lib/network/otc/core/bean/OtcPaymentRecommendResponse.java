package com.hbg.lib.network.otc.core.bean;

import java.io.Serializable;
import java.util.List;

public class OtcPaymentRecommendResponse implements Serializable {
    private List<OtcPaymentRecommendInfo> payMethod;
    private List<OtcPaymentRecommendInfo> recommendMethod;

    public boolean canEqual(Object obj) {
        return obj instanceof OtcPaymentRecommendResponse;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OtcPaymentRecommendResponse)) {
            return false;
        }
        OtcPaymentRecommendResponse otcPaymentRecommendResponse = (OtcPaymentRecommendResponse) obj;
        if (!otcPaymentRecommendResponse.canEqual(this)) {
            return false;
        }
        List<OtcPaymentRecommendInfo> recommendMethod2 = getRecommendMethod();
        List<OtcPaymentRecommendInfo> recommendMethod3 = otcPaymentRecommendResponse.getRecommendMethod();
        if (recommendMethod2 != null ? !recommendMethod2.equals(recommendMethod3) : recommendMethod3 != null) {
            return false;
        }
        List<OtcPaymentRecommendInfo> payMethod2 = getPayMethod();
        List<OtcPaymentRecommendInfo> payMethod3 = otcPaymentRecommendResponse.getPayMethod();
        return payMethod2 != null ? payMethod2.equals(payMethod3) : payMethod3 == null;
    }

    public List<OtcPaymentRecommendInfo> getPayMethod() {
        return this.payMethod;
    }

    public List<OtcPaymentRecommendInfo> getRecommendMethod() {
        return this.recommendMethod;
    }

    public int hashCode() {
        List<OtcPaymentRecommendInfo> recommendMethod2 = getRecommendMethod();
        int i11 = 43;
        int hashCode = recommendMethod2 == null ? 43 : recommendMethod2.hashCode();
        List<OtcPaymentRecommendInfo> payMethod2 = getPayMethod();
        int i12 = (hashCode + 59) * 59;
        if (payMethod2 != null) {
            i11 = payMethod2.hashCode();
        }
        return i12 + i11;
    }

    public void setPayMethod(List<OtcPaymentRecommendInfo> list) {
        this.payMethod = list;
    }

    public void setRecommendMethod(List<OtcPaymentRecommendInfo> list) {
        this.recommendMethod = list;
    }

    public String toString() {
        return "OtcPaymentRecommendResponse(recommendMethod=" + getRecommendMethod() + ", payMethod=" + getPayMethod() + ")";
    }
}
