package com.huobi.staring.bean;

import com.hbg.lib.network.contract.core.util.RemindBusinessType;
import com.huobi.staring.adapter.StareConfigListViewHandler;
import java.io.Serializable;

public class StareInfo implements s9.a, Serializable {
    private RemindBusinessType businessType;
    private String description;
    private int isSupport;
    private String price;
    private int rate;
    private int status;
    private a statusChangeListener;
    private int strategyId;
    private String strategyName;
    private String symbol;

    public interface a {
        void a(int i11, int i12, boolean z11);

        void b(int i11);
    }

    public boolean canEqual(Object obj) {
        return obj instanceof StareInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StareInfo)) {
            return false;
        }
        StareInfo stareInfo = (StareInfo) obj;
        if (!stareInfo.canEqual(this) || getStatus() != stareInfo.getStatus() || getStrategyId() != stareInfo.getStrategyId()) {
            return false;
        }
        String strategyName2 = getStrategyName();
        String strategyName3 = stareInfo.getStrategyName();
        if (strategyName2 != null ? !strategyName2.equals(strategyName3) : strategyName3 != null) {
            return false;
        }
        String description2 = getDescription();
        String description3 = stareInfo.getDescription();
        if (description2 != null ? !description2.equals(description3) : description3 != null) {
            return false;
        }
        a statusChangeListener2 = getStatusChangeListener();
        a statusChangeListener3 = stareInfo.getStatusChangeListener();
        if (statusChangeListener2 != null ? !statusChangeListener2.equals(statusChangeListener3) : statusChangeListener3 != null) {
            return false;
        }
        RemindBusinessType businessType2 = getBusinessType();
        RemindBusinessType businessType3 = stareInfo.getBusinessType();
        if (businessType2 != null ? !businessType2.equals(businessType3) : businessType3 != null) {
            return false;
        }
        String price2 = getPrice();
        String price3 = stareInfo.getPrice();
        if (price2 != null ? !price2.equals(price3) : price3 != null) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = stareInfo.getSymbol();
        if (symbol2 != null ? symbol2.equals(symbol3) : symbol3 == null) {
            return getIsSupport() == stareInfo.getIsSupport() && getRate() == stareInfo.getRate();
        }
        return false;
    }

    public RemindBusinessType getBusinessType() {
        return this.businessType;
    }

    public String getDescription() {
        return this.description;
    }

    public int getIsSupport() {
        return this.isSupport;
    }

    public String getPrice() {
        return this.price;
    }

    public int getRate() {
        return this.rate;
    }

    public int getStatus() {
        return this.status;
    }

    public a getStatusChangeListener() {
        return this.statusChangeListener;
    }

    public int getStrategyId() {
        return this.strategyId;
    }

    public String getStrategyName() {
        return this.strategyName;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public String getViewHandlerName() {
        return StareConfigListViewHandler.class.getName();
    }

    public int hashCode() {
        int status2 = ((getStatus() + 59) * 59) + getStrategyId();
        String strategyName2 = getStrategyName();
        int i11 = 43;
        int hashCode = (status2 * 59) + (strategyName2 == null ? 43 : strategyName2.hashCode());
        String description2 = getDescription();
        int hashCode2 = (hashCode * 59) + (description2 == null ? 43 : description2.hashCode());
        a statusChangeListener2 = getStatusChangeListener();
        int hashCode3 = (hashCode2 * 59) + (statusChangeListener2 == null ? 43 : statusChangeListener2.hashCode());
        RemindBusinessType businessType2 = getBusinessType();
        int hashCode4 = (hashCode3 * 59) + (businessType2 == null ? 43 : businessType2.hashCode());
        String price2 = getPrice();
        int hashCode5 = (hashCode4 * 59) + (price2 == null ? 43 : price2.hashCode());
        String symbol2 = getSymbol();
        int i12 = hashCode5 * 59;
        if (symbol2 != null) {
            i11 = symbol2.hashCode();
        }
        return ((((i12 + i11) * 59) + getIsSupport()) * 59) + getRate();
    }

    public void setBusinessType(RemindBusinessType remindBusinessType) {
        this.businessType = remindBusinessType;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setIsSupport(int i11) {
        this.isSupport = i11;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public void setRate(int i11) {
        this.rate = i11;
    }

    public void setStatus(int i11) {
        this.status = i11;
    }

    public void setStatusChangeListener(a aVar) {
        this.statusChangeListener = aVar;
    }

    public void setStrategyId(int i11) {
        this.strategyId = i11;
    }

    public void setStrategyName(String str) {
        this.strategyName = str;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public String toString() {
        return "StareInfo(status=" + getStatus() + ", strategyId=" + getStrategyId() + ", strategyName=" + getStrategyName() + ", description=" + getDescription() + ", statusChangeListener=" + getStatusChangeListener() + ", businessType=" + getBusinessType() + ", price=" + getPrice() + ", symbol=" + getSymbol() + ", isSupport=" + getIsSupport() + ", rate=" + getRate() + ")";
    }
}
