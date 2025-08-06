package com.hbg.lib.network.otc.core.bean;

import java.io.Serializable;
import java.util.List;

public class ConfigEntranceInfoBean implements Serializable {
    private String currencyName;
    private List<PayMethodInfoBean> payMethodInfo;
    private String supportVirtualDesc;
    private String tradeTypeName;

    public static class PayMethodInfoBean implements Serializable {
        public String bankImage;
        public String nameCn;
        public String nameEn;
        public String parentId;

        public boolean canEqual(Object obj) {
            return obj instanceof PayMethodInfoBean;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof PayMethodInfoBean)) {
                return false;
            }
            PayMethodInfoBean payMethodInfoBean = (PayMethodInfoBean) obj;
            if (!payMethodInfoBean.canEqual(this)) {
                return false;
            }
            String bankImage2 = getBankImage();
            String bankImage3 = payMethodInfoBean.getBankImage();
            if (bankImage2 != null ? !bankImage2.equals(bankImage3) : bankImage3 != null) {
                return false;
            }
            String nameCn2 = getNameCn();
            String nameCn3 = payMethodInfoBean.getNameCn();
            if (nameCn2 != null ? !nameCn2.equals(nameCn3) : nameCn3 != null) {
                return false;
            }
            String nameEn2 = getNameEn();
            String nameEn3 = payMethodInfoBean.getNameEn();
            if (nameEn2 != null ? !nameEn2.equals(nameEn3) : nameEn3 != null) {
                return false;
            }
            String parentId2 = getParentId();
            String parentId3 = payMethodInfoBean.getParentId();
            return parentId2 != null ? parentId2.equals(parentId3) : parentId3 == null;
        }

        public String getBankImage() {
            return this.bankImage;
        }

        public String getNameCn() {
            return this.nameCn;
        }

        public String getNameEn() {
            return this.nameEn;
        }

        public String getParentId() {
            return this.parentId;
        }

        public int hashCode() {
            String bankImage2 = getBankImage();
            int i11 = 43;
            int hashCode = bankImage2 == null ? 43 : bankImage2.hashCode();
            String nameCn2 = getNameCn();
            int hashCode2 = ((hashCode + 59) * 59) + (nameCn2 == null ? 43 : nameCn2.hashCode());
            String nameEn2 = getNameEn();
            int hashCode3 = (hashCode2 * 59) + (nameEn2 == null ? 43 : nameEn2.hashCode());
            String parentId2 = getParentId();
            int i12 = hashCode3 * 59;
            if (parentId2 != null) {
                i11 = parentId2.hashCode();
            }
            return i12 + i11;
        }

        public void setBankImage(String str) {
            this.bankImage = str;
        }

        public void setNameCn(String str) {
            this.nameCn = str;
        }

        public void setNameEn(String str) {
            this.nameEn = str;
        }

        public void setParentId(String str) {
            this.parentId = str;
        }

        public String toString() {
            return "ConfigEntranceInfoBean.PayMethodInfoBean(bankImage=" + getBankImage() + ", nameCn=" + getNameCn() + ", nameEn=" + getNameEn() + ", parentId=" + getParentId() + ")";
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof ConfigEntranceInfoBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConfigEntranceInfoBean)) {
            return false;
        }
        ConfigEntranceInfoBean configEntranceInfoBean = (ConfigEntranceInfoBean) obj;
        if (!configEntranceInfoBean.canEqual(this)) {
            return false;
        }
        String currencyName2 = getCurrencyName();
        String currencyName3 = configEntranceInfoBean.getCurrencyName();
        if (currencyName2 != null ? !currencyName2.equals(currencyName3) : currencyName3 != null) {
            return false;
        }
        List<PayMethodInfoBean> payMethodInfo2 = getPayMethodInfo();
        List<PayMethodInfoBean> payMethodInfo3 = configEntranceInfoBean.getPayMethodInfo();
        if (payMethodInfo2 != null ? !payMethodInfo2.equals(payMethodInfo3) : payMethodInfo3 != null) {
            return false;
        }
        String tradeTypeName2 = getTradeTypeName();
        String tradeTypeName3 = configEntranceInfoBean.getTradeTypeName();
        if (tradeTypeName2 != null ? !tradeTypeName2.equals(tradeTypeName3) : tradeTypeName3 != null) {
            return false;
        }
        String supportVirtualDesc2 = getSupportVirtualDesc();
        String supportVirtualDesc3 = configEntranceInfoBean.getSupportVirtualDesc();
        return supportVirtualDesc2 != null ? supportVirtualDesc2.equals(supportVirtualDesc3) : supportVirtualDesc3 == null;
    }

    public String getCurrencyName() {
        return this.currencyName;
    }

    public List<PayMethodInfoBean> getPayMethodInfo() {
        return this.payMethodInfo;
    }

    public String getSupportVirtualDesc() {
        return this.supportVirtualDesc;
    }

    public String getTradeTypeName() {
        return this.tradeTypeName;
    }

    public int hashCode() {
        String currencyName2 = getCurrencyName();
        int i11 = 43;
        int hashCode = currencyName2 == null ? 43 : currencyName2.hashCode();
        List<PayMethodInfoBean> payMethodInfo2 = getPayMethodInfo();
        int hashCode2 = ((hashCode + 59) * 59) + (payMethodInfo2 == null ? 43 : payMethodInfo2.hashCode());
        String tradeTypeName2 = getTradeTypeName();
        int hashCode3 = (hashCode2 * 59) + (tradeTypeName2 == null ? 43 : tradeTypeName2.hashCode());
        String supportVirtualDesc2 = getSupportVirtualDesc();
        int i12 = hashCode3 * 59;
        if (supportVirtualDesc2 != null) {
            i11 = supportVirtualDesc2.hashCode();
        }
        return i12 + i11;
    }

    public void setCurrencyName(String str) {
        this.currencyName = str;
    }

    public void setPayMethodInfo(List<PayMethodInfoBean> list) {
        this.payMethodInfo = list;
    }

    public void setSupportVirtualDesc(String str) {
        this.supportVirtualDesc = str;
    }

    public void setTradeTypeName(String str) {
        this.tradeTypeName = str;
    }

    public String toString() {
        return "ConfigEntranceInfoBean(currencyName=" + getCurrencyName() + ", payMethodInfo=" + getPayMethodInfo() + ", tradeTypeName=" + getTradeTypeName() + ", supportVirtualDesc=" + getSupportVirtualDesc() + ")";
    }
}
