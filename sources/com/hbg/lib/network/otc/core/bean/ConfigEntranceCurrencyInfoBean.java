package com.hbg.lib.network.otc.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class ConfigEntranceCurrencyInfoBean implements Serializable {
    @SerializedName("modules")
    private List<EntranceCurrencyInfoBean> modules;

    public static class EntranceCurrencyInfoBean implements Serializable {
        @SerializedName("bankImage")
        private String bankImage;
        @SerializedName("code")
        private String code;
        @SerializedName("payMethodInfo")
        private List<PayMethodInfo> payMethodInfo;
        @SerializedName("supportVirtualDesc")
        private String supportVirtualDesc;
        @SerializedName("tag")
        private String tag;
        @SerializedName("tradeTypeName")
        private String tradeTypeName;

        public static class PayMethodInfo implements Serializable {
            @SerializedName("payInfo")
            private PayInfo payInfo;

            public static class PayInfo implements Serializable {
                public boolean canEqual(Object obj) {
                    return obj instanceof PayInfo;
                }

                public boolean equals(Object obj) {
                    if (obj == this) {
                        return true;
                    }
                    return (obj instanceof PayInfo) && ((PayInfo) obj).canEqual(this);
                }

                public int hashCode() {
                    return 1;
                }

                public String toString() {
                    return "ConfigEntranceCurrencyInfoBean.EntranceCurrencyInfoBean.PayMethodInfo.PayInfo()";
                }
            }

            public boolean canEqual(Object obj) {
                return obj instanceof PayMethodInfo;
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof PayMethodInfo)) {
                    return false;
                }
                PayMethodInfo payMethodInfo = (PayMethodInfo) obj;
                if (!payMethodInfo.canEqual(this)) {
                    return false;
                }
                PayInfo payInfo2 = getPayInfo();
                PayInfo payInfo3 = payMethodInfo.getPayInfo();
                return payInfo2 != null ? payInfo2.equals(payInfo3) : payInfo3 == null;
            }

            public PayInfo getPayInfo() {
                return this.payInfo;
            }

            public int hashCode() {
                PayInfo payInfo2 = getPayInfo();
                return 59 + (payInfo2 == null ? 43 : payInfo2.hashCode());
            }

            public void setPayInfo(PayInfo payInfo2) {
                this.payInfo = payInfo2;
            }

            public String toString() {
                return "ConfigEntranceCurrencyInfoBean.EntranceCurrencyInfoBean.PayMethodInfo(payInfo=" + getPayInfo() + ")";
            }
        }

        public boolean canEqual(Object obj) {
            return obj instanceof EntranceCurrencyInfoBean;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof EntranceCurrencyInfoBean)) {
                return false;
            }
            EntranceCurrencyInfoBean entranceCurrencyInfoBean = (EntranceCurrencyInfoBean) obj;
            if (!entranceCurrencyInfoBean.canEqual(this)) {
                return false;
            }
            String tradeTypeName2 = getTradeTypeName();
            String tradeTypeName3 = entranceCurrencyInfoBean.getTradeTypeName();
            if (tradeTypeName2 != null ? !tradeTypeName2.equals(tradeTypeName3) : tradeTypeName3 != null) {
                return false;
            }
            String supportVirtualDesc2 = getSupportVirtualDesc();
            String supportVirtualDesc3 = entranceCurrencyInfoBean.getSupportVirtualDesc();
            if (supportVirtualDesc2 != null ? !supportVirtualDesc2.equals(supportVirtualDesc3) : supportVirtualDesc3 != null) {
                return false;
            }
            String code2 = getCode();
            String code3 = entranceCurrencyInfoBean.getCode();
            if (code2 != null ? !code2.equals(code3) : code3 != null) {
                return false;
            }
            String tag2 = getTag();
            String tag3 = entranceCurrencyInfoBean.getTag();
            if (tag2 != null ? !tag2.equals(tag3) : tag3 != null) {
                return false;
            }
            String bankImage2 = getBankImage();
            String bankImage3 = entranceCurrencyInfoBean.getBankImage();
            if (bankImage2 != null ? !bankImage2.equals(bankImage3) : bankImage3 != null) {
                return false;
            }
            List<PayMethodInfo> payMethodInfo2 = getPayMethodInfo();
            List<PayMethodInfo> payMethodInfo3 = entranceCurrencyInfoBean.getPayMethodInfo();
            return payMethodInfo2 != null ? payMethodInfo2.equals(payMethodInfo3) : payMethodInfo3 == null;
        }

        public String getBankImage() {
            return this.bankImage;
        }

        public String getCode() {
            return this.code;
        }

        public List<PayMethodInfo> getPayMethodInfo() {
            return this.payMethodInfo;
        }

        public String getSupportVirtualDesc() {
            return this.supportVirtualDesc;
        }

        public String getTag() {
            return this.tag;
        }

        public String getTradeTypeName() {
            return this.tradeTypeName;
        }

        public int hashCode() {
            String tradeTypeName2 = getTradeTypeName();
            int i11 = 43;
            int hashCode = tradeTypeName2 == null ? 43 : tradeTypeName2.hashCode();
            String supportVirtualDesc2 = getSupportVirtualDesc();
            int hashCode2 = ((hashCode + 59) * 59) + (supportVirtualDesc2 == null ? 43 : supportVirtualDesc2.hashCode());
            String code2 = getCode();
            int hashCode3 = (hashCode2 * 59) + (code2 == null ? 43 : code2.hashCode());
            String tag2 = getTag();
            int hashCode4 = (hashCode3 * 59) + (tag2 == null ? 43 : tag2.hashCode());
            String bankImage2 = getBankImage();
            int hashCode5 = (hashCode4 * 59) + (bankImage2 == null ? 43 : bankImage2.hashCode());
            List<PayMethodInfo> payMethodInfo2 = getPayMethodInfo();
            int i12 = hashCode5 * 59;
            if (payMethodInfo2 != null) {
                i11 = payMethodInfo2.hashCode();
            }
            return i12 + i11;
        }

        public void setBankImage(String str) {
            this.bankImage = str;
        }

        public void setCode(String str) {
            this.code = str;
        }

        public void setPayMethodInfo(List<PayMethodInfo> list) {
            this.payMethodInfo = list;
        }

        public void setSupportVirtualDesc(String str) {
            this.supportVirtualDesc = str;
        }

        public void setTag(String str) {
            this.tag = str;
        }

        public void setTradeTypeName(String str) {
            this.tradeTypeName = str;
        }

        public String toString() {
            return "ConfigEntranceCurrencyInfoBean.EntranceCurrencyInfoBean(tradeTypeName=" + getTradeTypeName() + ", supportVirtualDesc=" + getSupportVirtualDesc() + ", code=" + getCode() + ", tag=" + getTag() + ", bankImage=" + getBankImage() + ", payMethodInfo=" + getPayMethodInfo() + ")";
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof ConfigEntranceCurrencyInfoBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConfigEntranceCurrencyInfoBean)) {
            return false;
        }
        ConfigEntranceCurrencyInfoBean configEntranceCurrencyInfoBean = (ConfigEntranceCurrencyInfoBean) obj;
        if (!configEntranceCurrencyInfoBean.canEqual(this)) {
            return false;
        }
        List<EntranceCurrencyInfoBean> modules2 = getModules();
        List<EntranceCurrencyInfoBean> modules3 = configEntranceCurrencyInfoBean.getModules();
        return modules2 != null ? modules2.equals(modules3) : modules3 == null;
    }

    public List<EntranceCurrencyInfoBean> getModules() {
        return this.modules;
    }

    public int hashCode() {
        List<EntranceCurrencyInfoBean> modules2 = getModules();
        return 59 + (modules2 == null ? 43 : modules2.hashCode());
    }

    public void setModules(List<EntranceCurrencyInfoBean> list) {
        this.modules = list;
    }

    public String toString() {
        return "ConfigEntranceCurrencyInfoBean(modules=" + getModules() + ")";
    }
}
