package com.huobi.otc.bean;

import com.google.gson.annotations.SerializedName;
import com.huobi.otc.handler.OtcComplainHandler;
import java.io.Serializable;
import java.util.List;
import s9.a;

public class MarketAppeal implements Serializable {
    @SerializedName("appeal")
    private List<Appeal> appeal;
    @SerializedName("buyer")
    private List<Appeal> buyer;
    @SerializedName("seller")
    private List<Appeal> seller;

    public class Appeal implements Serializable, a {
        public lp.a callBackSetResult;
        private String extra;
        private String extraReason;

        /* renamed from: id  reason: collision with root package name */
        private int f78263id;
        private boolean isChecked;
        private boolean isExtra;
        private String name;

        public Appeal() {
        }

        public lp.a getCallBackSetResult() {
            return this.callBackSetResult;
        }

        public String getExtra() {
            return this.extra;
        }

        public String getExtraReason() {
            return this.extraReason;
        }

        public int getId() {
            return this.f78263id;
        }

        public String getName() {
            return this.name;
        }

        public String getViewHandlerName() {
            return OtcComplainHandler.class.getName();
        }

        public boolean isChecked() {
            return this.isChecked;
        }

        public boolean isExtra() {
            return this.isExtra;
        }

        public void setCallBackSetResult(lp.a aVar) {
            this.callBackSetResult = aVar;
        }

        public void setChecked(boolean z11) {
            this.isChecked = z11;
        }

        public void setExtra(String str) {
            this.extra = str;
        }

        public void setExtraReason(String str) {
            this.extraReason = str;
        }

        public void setId(int i11) {
            this.f78263id = i11;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setExtra(boolean z11) {
            this.isExtra = z11;
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof MarketAppeal;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MarketAppeal)) {
            return false;
        }
        MarketAppeal marketAppeal = (MarketAppeal) obj;
        if (!marketAppeal.canEqual(this)) {
            return false;
        }
        List<Appeal> appeal2 = getAppeal();
        List<Appeal> appeal3 = marketAppeal.getAppeal();
        if (appeal2 != null ? !appeal2.equals(appeal3) : appeal3 != null) {
            return false;
        }
        List<Appeal> seller2 = getSeller();
        List<Appeal> seller3 = marketAppeal.getSeller();
        if (seller2 != null ? !seller2.equals(seller3) : seller3 != null) {
            return false;
        }
        List<Appeal> buyer2 = getBuyer();
        List<Appeal> buyer3 = marketAppeal.getBuyer();
        return buyer2 != null ? buyer2.equals(buyer3) : buyer3 == null;
    }

    public List<Appeal> getAppeal() {
        return this.appeal;
    }

    public List<Appeal> getBuyer() {
        return this.buyer;
    }

    public List<Appeal> getSeller() {
        return this.seller;
    }

    public int hashCode() {
        List<Appeal> appeal2 = getAppeal();
        int i11 = 43;
        int hashCode = appeal2 == null ? 43 : appeal2.hashCode();
        List<Appeal> seller2 = getSeller();
        int hashCode2 = ((hashCode + 59) * 59) + (seller2 == null ? 43 : seller2.hashCode());
        List<Appeal> buyer2 = getBuyer();
        int i12 = hashCode2 * 59;
        if (buyer2 != null) {
            i11 = buyer2.hashCode();
        }
        return i12 + i11;
    }

    public void setAppeal(List<Appeal> list) {
        this.appeal = list;
    }

    public void setBuyer(List<Appeal> list) {
        this.buyer = list;
    }

    public void setSeller(List<Appeal> list) {
        this.seller = list;
    }

    public String toString() {
        return "MarketAppeal(appeal=" + getAppeal() + ", seller=" + getSeller() + ", buyer=" + getBuyer() + ")";
    }
}
