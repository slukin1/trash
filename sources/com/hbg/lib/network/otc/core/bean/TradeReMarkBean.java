package com.hbg.lib.network.otc.core.bean;

import java.io.Serializable;

public class TradeReMarkBean implements Serializable {
    public String merchantLevel;
    public String nickname;
    public String remark;
    public String uid;

    public boolean canEqual(Object obj) {
        return obj instanceof TradeReMarkBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TradeReMarkBean)) {
            return false;
        }
        TradeReMarkBean tradeReMarkBean = (TradeReMarkBean) obj;
        if (!tradeReMarkBean.canEqual(this)) {
            return false;
        }
        String uid2 = getUid();
        String uid3 = tradeReMarkBean.getUid();
        if (uid2 != null ? !uid2.equals(uid3) : uid3 != null) {
            return false;
        }
        String nickname2 = getNickname();
        String nickname3 = tradeReMarkBean.getNickname();
        if (nickname2 != null ? !nickname2.equals(nickname3) : nickname3 != null) {
            return false;
        }
        String merchantLevel2 = getMerchantLevel();
        String merchantLevel3 = tradeReMarkBean.getMerchantLevel();
        if (merchantLevel2 != null ? !merchantLevel2.equals(merchantLevel3) : merchantLevel3 != null) {
            return false;
        }
        String remark2 = getRemark();
        String remark3 = tradeReMarkBean.getRemark();
        return remark2 != null ? remark2.equals(remark3) : remark3 == null;
    }

    public String getMerchantLevel() {
        return this.merchantLevel;
    }

    public String getNickname() {
        return this.nickname;
    }

    public String getRemark() {
        return this.remark;
    }

    public String getUid() {
        return this.uid;
    }

    public int hashCode() {
        String uid2 = getUid();
        int i11 = 43;
        int hashCode = uid2 == null ? 43 : uid2.hashCode();
        String nickname2 = getNickname();
        int hashCode2 = ((hashCode + 59) * 59) + (nickname2 == null ? 43 : nickname2.hashCode());
        String merchantLevel2 = getMerchantLevel();
        int hashCode3 = (hashCode2 * 59) + (merchantLevel2 == null ? 43 : merchantLevel2.hashCode());
        String remark2 = getRemark();
        int i12 = hashCode3 * 59;
        if (remark2 != null) {
            i11 = remark2.hashCode();
        }
        return i12 + i11;
    }

    public void setMerchantLevel(String str) {
        this.merchantLevel = str;
    }

    public void setNickname(String str) {
        this.nickname = str;
    }

    public void setRemark(String str) {
        this.remark = str;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public String toString() {
        return "TradeReMarkBean(uid=" + getUid() + ", nickname=" + getNickname() + ", merchantLevel=" + getMerchantLevel() + ", remark=" + getRemark() + ")";
    }
}
