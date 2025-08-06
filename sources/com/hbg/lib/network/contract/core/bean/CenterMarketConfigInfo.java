package com.hbg.lib.network.contract.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class CenterMarketConfigInfo implements Serializable {
    private static final long serialVersionUID = -9176915968955970831L;
    @SerializedName("business_type")
    private int businessType;
    @SerializedName("contract_type")
    private int contractType;

    /* renamed from: id  reason: collision with root package name */
    private long f69212id;
    private String symbol;
    @SerializedName("trigger_price")
    private String triggerPrice;
    @SerializedName("trigger_type")
    private int triggerType;
    private long uid;

    public boolean canEqual(Object obj) {
        return obj instanceof CenterMarketConfigInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CenterMarketConfigInfo)) {
            return false;
        }
        CenterMarketConfigInfo centerMarketConfigInfo = (CenterMarketConfigInfo) obj;
        if (!centerMarketConfigInfo.canEqual(this) || getId() != centerMarketConfigInfo.getId() || getUid() != centerMarketConfigInfo.getUid() || getBusinessType() != centerMarketConfigInfo.getBusinessType()) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = centerMarketConfigInfo.getSymbol();
        if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
            return false;
        }
        if (getContractType() != centerMarketConfigInfo.getContractType()) {
            return false;
        }
        String triggerPrice2 = getTriggerPrice();
        String triggerPrice3 = centerMarketConfigInfo.getTriggerPrice();
        if (triggerPrice2 != null ? triggerPrice2.equals(triggerPrice3) : triggerPrice3 == null) {
            return getTriggerType() == centerMarketConfigInfo.getTriggerType();
        }
        return false;
    }

    public int getBusinessType() {
        return this.businessType;
    }

    public int getContractType() {
        return this.contractType;
    }

    public long getId() {
        return this.f69212id;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public String getTriggerPrice() {
        return this.triggerPrice;
    }

    public int getTriggerType() {
        return this.triggerType;
    }

    public long getUid() {
        return this.uid;
    }

    public int hashCode() {
        long id2 = getId();
        long uid2 = getUid();
        int businessType2 = ((((((int) (id2 ^ (id2 >>> 32))) + 59) * 59) + ((int) ((uid2 >>> 32) ^ uid2))) * 59) + getBusinessType();
        String symbol2 = getSymbol();
        int i11 = 43;
        int hashCode = (((businessType2 * 59) + (symbol2 == null ? 43 : symbol2.hashCode())) * 59) + getContractType();
        String triggerPrice2 = getTriggerPrice();
        int i12 = hashCode * 59;
        if (triggerPrice2 != null) {
            i11 = triggerPrice2.hashCode();
        }
        return ((i12 + i11) * 59) + getTriggerType();
    }

    public void setBusinessType(int i11) {
        this.businessType = i11;
    }

    public void setContractType(int i11) {
        this.contractType = i11;
    }

    public void setId(long j11) {
        this.f69212id = j11;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public void setTriggerPrice(String str) {
        this.triggerPrice = str;
    }

    public void setTriggerType(int i11) {
        this.triggerType = i11;
    }

    public void setUid(long j11) {
        this.uid = j11;
    }

    public String toString() {
        return "CenterMarketConfigInfo(id=" + getId() + ", uid=" + getUid() + ", businessType=" + getBusinessType() + ", symbol=" + getSymbol() + ", contractType=" + getContractType() + ", triggerPrice=" + getTriggerPrice() + ", triggerType=" + getTriggerType() + ")";
    }
}
