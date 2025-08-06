package com.hbg.lib.network.linear.swap.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class LinearSwapContactConfigInfo implements Serializable {
    public static final int MODE_MARGIN_ALL = 3;
    public static final int MODE_MARGIN_CROSS = 2;
    public static final int MODE_MARGIN_ISOLATED = 1;
    @SerializedName("active_time")
    private long activeTime;
    @SerializedName("business_type")
    private String businessType;
    @SerializedName("contract_code")
    private String contractCode;
    @SerializedName("contract_type")
    private String contractType;
    @SerializedName("grid_max_num")
    private String gridMaxNum;
    @SerializedName("grid_min_num")
    private String gridMinNum;
    @SerializedName("margin_mode")
    private int marginMode;
    @SerializedName("最大保证金")
    private String maxInvestment;
    private String pair;
    @SerializedName("product_id")
    private String productId;

    public boolean canEqual(Object obj) {
        return obj instanceof LinearSwapContactConfigInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LinearSwapContactConfigInfo)) {
            return false;
        }
        LinearSwapContactConfigInfo linearSwapContactConfigInfo = (LinearSwapContactConfigInfo) obj;
        if (!linearSwapContactConfigInfo.canEqual(this)) {
            return false;
        }
        String productId2 = getProductId();
        String productId3 = linearSwapContactConfigInfo.getProductId();
        if (productId2 != null ? !productId2.equals(productId3) : productId3 != null) {
            return false;
        }
        String contractCode2 = getContractCode();
        String contractCode3 = linearSwapContactConfigInfo.getContractCode();
        if (contractCode2 != null ? !contractCode2.equals(contractCode3) : contractCode3 != null) {
            return false;
        }
        String contractType2 = getContractType();
        String contractType3 = linearSwapContactConfigInfo.getContractType();
        if (contractType2 != null ? !contractType2.equals(contractType3) : contractType3 != null) {
            return false;
        }
        String businessType2 = getBusinessType();
        String businessType3 = linearSwapContactConfigInfo.getBusinessType();
        if (businessType2 != null ? !businessType2.equals(businessType3) : businessType3 != null) {
            return false;
        }
        String pair2 = getPair();
        String pair3 = linearSwapContactConfigInfo.getPair();
        if (pair2 != null ? !pair2.equals(pair3) : pair3 != null) {
            return false;
        }
        String maxInvestment2 = getMaxInvestment();
        String maxInvestment3 = linearSwapContactConfigInfo.getMaxInvestment();
        if (maxInvestment2 != null ? !maxInvestment2.equals(maxInvestment3) : maxInvestment3 != null) {
            return false;
        }
        String gridMinNum2 = getGridMinNum();
        String gridMinNum3 = linearSwapContactConfigInfo.getGridMinNum();
        if (gridMinNum2 != null ? !gridMinNum2.equals(gridMinNum3) : gridMinNum3 != null) {
            return false;
        }
        String gridMaxNum2 = getGridMaxNum();
        String gridMaxNum3 = linearSwapContactConfigInfo.getGridMaxNum();
        if (gridMaxNum2 != null ? gridMaxNum2.equals(gridMaxNum3) : gridMaxNum3 == null) {
            return getMarginMode() == linearSwapContactConfigInfo.getMarginMode() && getActiveTime() == linearSwapContactConfigInfo.getActiveTime();
        }
        return false;
    }

    public long getActiveTime() {
        return this.activeTime;
    }

    public String getBusinessType() {
        return this.businessType;
    }

    public String getContractCode() {
        return this.contractCode;
    }

    public String getContractType() {
        return this.contractType;
    }

    public String getGridMaxNum() {
        return this.gridMaxNum;
    }

    public String getGridMinNum() {
        return this.gridMinNum;
    }

    public int getMarginMode() {
        return this.marginMode;
    }

    public String getMaxInvestment() {
        return this.maxInvestment;
    }

    public String getPair() {
        return this.pair;
    }

    public String getProductId() {
        return this.productId;
    }

    public int hashCode() {
        String productId2 = getProductId();
        int i11 = 43;
        int hashCode = productId2 == null ? 43 : productId2.hashCode();
        String contractCode2 = getContractCode();
        int hashCode2 = ((hashCode + 59) * 59) + (contractCode2 == null ? 43 : contractCode2.hashCode());
        String contractType2 = getContractType();
        int hashCode3 = (hashCode2 * 59) + (contractType2 == null ? 43 : contractType2.hashCode());
        String businessType2 = getBusinessType();
        int hashCode4 = (hashCode3 * 59) + (businessType2 == null ? 43 : businessType2.hashCode());
        String pair2 = getPair();
        int hashCode5 = (hashCode4 * 59) + (pair2 == null ? 43 : pair2.hashCode());
        String maxInvestment2 = getMaxInvestment();
        int hashCode6 = (hashCode5 * 59) + (maxInvestment2 == null ? 43 : maxInvestment2.hashCode());
        String gridMinNum2 = getGridMinNum();
        int hashCode7 = (hashCode6 * 59) + (gridMinNum2 == null ? 43 : gridMinNum2.hashCode());
        String gridMaxNum2 = getGridMaxNum();
        int i12 = hashCode7 * 59;
        if (gridMaxNum2 != null) {
            i11 = gridMaxNum2.hashCode();
        }
        long activeTime2 = getActiveTime();
        return ((((i12 + i11) * 59) + getMarginMode()) * 59) + ((int) ((activeTime2 >>> 32) ^ activeTime2));
    }

    public void setActiveTime(long j11) {
        this.activeTime = j11;
    }

    public void setBusinessType(String str) {
        this.businessType = str;
    }

    public void setContractCode(String str) {
        this.contractCode = str;
    }

    public void setContractType(String str) {
        this.contractType = str;
    }

    public void setGridMaxNum(String str) {
        this.gridMaxNum = str;
    }

    public void setGridMinNum(String str) {
        this.gridMinNum = str;
    }

    public void setMarginMode(int i11) {
        this.marginMode = i11;
    }

    public void setMaxInvestment(String str) {
        this.maxInvestment = str;
    }

    public void setPair(String str) {
        this.pair = str;
    }

    public void setProductId(String str) {
        this.productId = str;
    }

    public String toString() {
        return "LinearSwapContactConfigInfo(productId=" + getProductId() + ", contractCode=" + getContractCode() + ", contractType=" + getContractType() + ", businessType=" + getBusinessType() + ", pair=" + getPair() + ", maxInvestment=" + getMaxInvestment() + ", gridMinNum=" + getGridMinNum() + ", gridMaxNum=" + getGridMaxNum() + ", marginMode=" + getMarginMode() + ", activeTime=" + getActiveTime() + ")";
    }
}
