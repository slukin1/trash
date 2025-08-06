package com.hbg.lib.network.pro.socket.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ContractPositionTpslWs implements Serializable {
    @SerializedName("contract_code")
    public String contractCode;
    @SerializedName("direction")
    public String direction;
    @SerializedName("margin_mode")
    public String marginMode;
    @SerializedName("sl_order_id")
    public String slOrderId;
    @SerializedName("sl_trigger_price")
    public String slTriggerPrice;
    @SerializedName("sl_trigger_type")
    public String slTriggerType;
    @SerializedName("tp_order_id")
    public String tpOrderId;
    @SerializedName("tp_trigger_price")
    public String tpTriggerPrice;
    @SerializedName("tp_trigger_type")
    public String tpTriggerType;

    public boolean canEqual(Object obj) {
        return obj instanceof ContractPositionTpslWs;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ContractPositionTpslWs)) {
            return false;
        }
        ContractPositionTpslWs contractPositionTpslWs = (ContractPositionTpslWs) obj;
        if (!contractPositionTpslWs.canEqual(this)) {
            return false;
        }
        String contractCode2 = getContractCode();
        String contractCode3 = contractPositionTpslWs.getContractCode();
        if (contractCode2 != null ? !contractCode2.equals(contractCode3) : contractCode3 != null) {
            return false;
        }
        String marginMode2 = getMarginMode();
        String marginMode3 = contractPositionTpslWs.getMarginMode();
        if (marginMode2 != null ? !marginMode2.equals(marginMode3) : marginMode3 != null) {
            return false;
        }
        String direction2 = getDirection();
        String direction3 = contractPositionTpslWs.getDirection();
        if (direction2 != null ? !direction2.equals(direction3) : direction3 != null) {
            return false;
        }
        String tpTriggerPrice2 = getTpTriggerPrice();
        String tpTriggerPrice3 = contractPositionTpslWs.getTpTriggerPrice();
        if (tpTriggerPrice2 != null ? !tpTriggerPrice2.equals(tpTriggerPrice3) : tpTriggerPrice3 != null) {
            return false;
        }
        String slTriggerPrice2 = getSlTriggerPrice();
        String slTriggerPrice3 = contractPositionTpslWs.getSlTriggerPrice();
        if (slTriggerPrice2 != null ? !slTriggerPrice2.equals(slTriggerPrice3) : slTriggerPrice3 != null) {
            return false;
        }
        String tpTriggerType2 = getTpTriggerType();
        String tpTriggerType3 = contractPositionTpslWs.getTpTriggerType();
        if (tpTriggerType2 != null ? !tpTriggerType2.equals(tpTriggerType3) : tpTriggerType3 != null) {
            return false;
        }
        String slTriggerType2 = getSlTriggerType();
        String slTriggerType3 = contractPositionTpslWs.getSlTriggerType();
        if (slTriggerType2 != null ? !slTriggerType2.equals(slTriggerType3) : slTriggerType3 != null) {
            return false;
        }
        String tpOrderId2 = getTpOrderId();
        String tpOrderId3 = contractPositionTpslWs.getTpOrderId();
        if (tpOrderId2 != null ? !tpOrderId2.equals(tpOrderId3) : tpOrderId3 != null) {
            return false;
        }
        String slOrderId2 = getSlOrderId();
        String slOrderId3 = contractPositionTpslWs.getSlOrderId();
        return slOrderId2 != null ? slOrderId2.equals(slOrderId3) : slOrderId3 == null;
    }

    public String getContractCode() {
        return this.contractCode;
    }

    public String getDirection() {
        return this.direction;
    }

    public String getMarginMode() {
        return this.marginMode;
    }

    public String getSlOrderId() {
        return this.slOrderId;
    }

    public String getSlTriggerPrice() {
        return this.slTriggerPrice;
    }

    public String getSlTriggerType() {
        return this.slTriggerType;
    }

    public String getTpOrderId() {
        return this.tpOrderId;
    }

    public String getTpTriggerPrice() {
        return this.tpTriggerPrice;
    }

    public String getTpTriggerType() {
        return this.tpTriggerType;
    }

    public int hashCode() {
        String contractCode2 = getContractCode();
        int i11 = 43;
        int hashCode = contractCode2 == null ? 43 : contractCode2.hashCode();
        String marginMode2 = getMarginMode();
        int hashCode2 = ((hashCode + 59) * 59) + (marginMode2 == null ? 43 : marginMode2.hashCode());
        String direction2 = getDirection();
        int hashCode3 = (hashCode2 * 59) + (direction2 == null ? 43 : direction2.hashCode());
        String tpTriggerPrice2 = getTpTriggerPrice();
        int hashCode4 = (hashCode3 * 59) + (tpTriggerPrice2 == null ? 43 : tpTriggerPrice2.hashCode());
        String slTriggerPrice2 = getSlTriggerPrice();
        int hashCode5 = (hashCode4 * 59) + (slTriggerPrice2 == null ? 43 : slTriggerPrice2.hashCode());
        String tpTriggerType2 = getTpTriggerType();
        int hashCode6 = (hashCode5 * 59) + (tpTriggerType2 == null ? 43 : tpTriggerType2.hashCode());
        String slTriggerType2 = getSlTriggerType();
        int hashCode7 = (hashCode6 * 59) + (slTriggerType2 == null ? 43 : slTriggerType2.hashCode());
        String tpOrderId2 = getTpOrderId();
        int hashCode8 = (hashCode7 * 59) + (tpOrderId2 == null ? 43 : tpOrderId2.hashCode());
        String slOrderId2 = getSlOrderId();
        int i12 = hashCode8 * 59;
        if (slOrderId2 != null) {
            i11 = slOrderId2.hashCode();
        }
        return i12 + i11;
    }

    public void setContractCode(String str) {
        this.contractCode = str;
    }

    public void setDirection(String str) {
        this.direction = str;
    }

    public void setMarginMode(String str) {
        this.marginMode = str;
    }

    public void setSlOrderId(String str) {
        this.slOrderId = str;
    }

    public void setSlTriggerPrice(String str) {
        this.slTriggerPrice = str;
    }

    public void setSlTriggerType(String str) {
        this.slTriggerType = str;
    }

    public void setTpOrderId(String str) {
        this.tpOrderId = str;
    }

    public void setTpTriggerPrice(String str) {
        this.tpTriggerPrice = str;
    }

    public void setTpTriggerType(String str) {
        this.tpTriggerType = str;
    }

    public String toString() {
        return "ContractPositionTpslWs(contractCode=" + getContractCode() + ", marginMode=" + getMarginMode() + ", direction=" + getDirection() + ", tpTriggerPrice=" + getTpTriggerPrice() + ", slTriggerPrice=" + getSlTriggerPrice() + ", tpTriggerType=" + getTpTriggerType() + ", slTriggerType=" + getSlTriggerType() + ", tpOrderId=" + getTpOrderId() + ", slOrderId=" + getSlOrderId() + ")";
    }
}
