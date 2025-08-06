package com.hbg.lib.network.otc.core.bean;

import java.io.Serializable;
import java.util.List;

public class OtcConfigItem implements Serializable {
    private Object object;

    public static class CountryBean implements Serializable {
        private static final long serialVersionUID = -2349711376402721500L;
        private String appShort;
        private String countryId;
        private String currencyId;
        private String currencyName;

        public CountryBean() {
        }

        public boolean canEqual(Object obj) {
            return obj instanceof CountryBean;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof CountryBean)) {
                return false;
            }
            CountryBean countryBean = (CountryBean) obj;
            if (!countryBean.canEqual(this)) {
                return false;
            }
            String countryId2 = getCountryId();
            String countryId3 = countryBean.getCountryId();
            if (countryId2 != null ? !countryId2.equals(countryId3) : countryId3 != null) {
                return false;
            }
            String currencyName2 = getCurrencyName();
            String currencyName3 = countryBean.getCurrencyName();
            if (currencyName2 != null ? !currencyName2.equals(currencyName3) : currencyName3 != null) {
                return false;
            }
            String currencyId2 = getCurrencyId();
            String currencyId3 = countryBean.getCurrencyId();
            if (currencyId2 != null ? !currencyId2.equals(currencyId3) : currencyId3 != null) {
                return false;
            }
            String appShort2 = getAppShort();
            String appShort3 = countryBean.getAppShort();
            return appShort2 != null ? appShort2.equals(appShort3) : appShort3 == null;
        }

        public String getAppShort() {
            return this.appShort;
        }

        public String getCountryId() {
            return this.countryId;
        }

        public String getCurrencyId() {
            return this.currencyId;
        }

        public String getCurrencyName() {
            return this.currencyName;
        }

        public int hashCode() {
            String countryId2 = getCountryId();
            int i11 = 43;
            int hashCode = countryId2 == null ? 43 : countryId2.hashCode();
            String currencyName2 = getCurrencyName();
            int hashCode2 = ((hashCode + 59) * 59) + (currencyName2 == null ? 43 : currencyName2.hashCode());
            String currencyId2 = getCurrencyId();
            int hashCode3 = (hashCode2 * 59) + (currencyId2 == null ? 43 : currencyId2.hashCode());
            String appShort2 = getAppShort();
            int i12 = hashCode3 * 59;
            if (appShort2 != null) {
                i11 = appShort2.hashCode();
            }
            return i12 + i11;
        }

        public void setAppShort(String str) {
            this.appShort = str;
        }

        public void setCountryId(String str) {
            this.countryId = str;
        }

        public void setCurrencyId(String str) {
            this.currencyId = str;
        }

        public void setCurrencyName(String str) {
            this.currencyName = str;
        }

        public String toString() {
            return "OtcConfigItem.CountryBean(countryId=" + getCountryId() + ", currencyName=" + getCurrencyName() + ", currencyId=" + getCurrencyId() + ", appShort=" + getAppShort() + ")";
        }

        public CountryBean(String str, String str2, String str3, String str4) {
            this.countryId = str;
            this.currencyName = str2;
            this.currencyId = str3;
            this.appShort = str4;
        }
    }

    public static class PayMethodBean implements Serializable {
        private String color;
        private String name;
        private int payMethodId;
        private int template;

        public PayMethodBean() {
        }

        public boolean canEqual(Object obj) {
            return obj instanceof PayMethodBean;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof PayMethodBean)) {
                return false;
            }
            PayMethodBean payMethodBean = (PayMethodBean) obj;
            if (!payMethodBean.canEqual(this) || getPayMethodId() != payMethodBean.getPayMethodId()) {
                return false;
            }
            String name2 = getName();
            String name3 = payMethodBean.getName();
            if (name2 != null ? !name2.equals(name3) : name3 != null) {
                return false;
            }
            if (getTemplate() != payMethodBean.getTemplate()) {
                return false;
            }
            String color2 = getColor();
            String color3 = payMethodBean.getColor();
            return color2 != null ? color2.equals(color3) : color3 == null;
        }

        public String getColor() {
            return this.color;
        }

        public String getName() {
            return this.name;
        }

        public int getPayMethodId() {
            return this.payMethodId;
        }

        public int getTemplate() {
            return this.template;
        }

        public int hashCode() {
            String name2 = getName();
            int i11 = 43;
            int payMethodId2 = ((((getPayMethodId() + 59) * 59) + (name2 == null ? 43 : name2.hashCode())) * 59) + getTemplate();
            String color2 = getColor();
            int i12 = payMethodId2 * 59;
            if (color2 != null) {
                i11 = color2.hashCode();
            }
            return i12 + i11;
        }

        public void setColor(String str) {
            this.color = str;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setPayMethodId(int i11) {
            this.payMethodId = i11;
        }

        public void setTemplate(int i11) {
            this.template = i11;
        }

        public String toString() {
            return this.name;
        }

        public PayMethodBean(int i11, String str, int i12, String str2) {
            this.payMethodId = i11;
            this.name = str;
            this.template = i12;
            this.color = str2;
        }
    }

    public OtcConfigItem() {
    }

    public boolean canEqual(Object obj) {
        return obj instanceof OtcConfigItem;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OtcConfigItem)) {
            return false;
        }
        OtcConfigItem otcConfigItem = (OtcConfigItem) obj;
        if (!otcConfigItem.canEqual(this)) {
            return false;
        }
        Object object2 = getObject();
        Object object3 = otcConfigItem.getObject();
        return object2 != null ? object2.equals(object3) : object3 == null;
    }

    public Object getObject() {
        return this.object;
    }

    public int hashCode() {
        Object object2 = getObject();
        return 59 + (object2 == null ? 43 : object2.hashCode());
    }

    public void setObject(Object obj) {
        this.object = obj;
    }

    public String toString() {
        return "OtcConfigItem(object=" + getObject() + ")";
    }

    public static class CurrencyBean implements Serializable {
        private static final long serialVersionUID = -2234056015135051185L;
        private String currencyId;
        private int entrance;
        private String nameShort;
        private List<Integer> supportPayments;
        private String symbol = "";
        private int whetherGib;

        public CurrencyBean() {
        }

        public boolean canEqual(Object obj) {
            return obj instanceof CurrencyBean;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof CurrencyBean)) {
                return false;
            }
            CurrencyBean currencyBean = (CurrencyBean) obj;
            if (!currencyBean.canEqual(this)) {
                return false;
            }
            String currencyId2 = getCurrencyId();
            String currencyId3 = currencyBean.getCurrencyId();
            if (currencyId2 != null ? !currencyId2.equals(currencyId3) : currencyId3 != null) {
                return false;
            }
            String nameShort2 = getNameShort();
            String nameShort3 = currencyBean.getNameShort();
            if (nameShort2 != null ? !nameShort2.equals(nameShort3) : nameShort3 != null) {
                return false;
            }
            String symbol2 = getSymbol();
            String symbol3 = currencyBean.getSymbol();
            if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
                return false;
            }
            List<Integer> supportPayments2 = getSupportPayments();
            List<Integer> supportPayments3 = currencyBean.getSupportPayments();
            if (supportPayments2 != null ? supportPayments2.equals(supportPayments3) : supportPayments3 == null) {
                return getWhetherGib() == currencyBean.getWhetherGib() && getEntrance() == currencyBean.getEntrance();
            }
            return false;
        }

        public String getCurrencyId() {
            return this.currencyId;
        }

        public int getEntrance() {
            return this.entrance;
        }

        public String getNameShort() {
            return this.nameShort;
        }

        public List<Integer> getSupportPayments() {
            return this.supportPayments;
        }

        public String getSymbol() {
            return this.symbol;
        }

        public int getWhetherGib() {
            return this.whetherGib;
        }

        public int hashCode() {
            String currencyId2 = getCurrencyId();
            int i11 = 43;
            int hashCode = currencyId2 == null ? 43 : currencyId2.hashCode();
            String nameShort2 = getNameShort();
            int hashCode2 = ((hashCode + 59) * 59) + (nameShort2 == null ? 43 : nameShort2.hashCode());
            String symbol2 = getSymbol();
            int hashCode3 = (hashCode2 * 59) + (symbol2 == null ? 43 : symbol2.hashCode());
            List<Integer> supportPayments2 = getSupportPayments();
            int i12 = hashCode3 * 59;
            if (supportPayments2 != null) {
                i11 = supportPayments2.hashCode();
            }
            return ((((i12 + i11) * 59) + getWhetherGib()) * 59) + getEntrance();
        }

        public void setCurrencyId(String str) {
            this.currencyId = str;
        }

        public void setEntrance(int i11) {
            this.entrance = i11;
        }

        public void setNameShort(String str) {
            this.nameShort = str;
        }

        public void setSupportPayments(List<Integer> list) {
            this.supportPayments = list;
        }

        public void setSymbol(String str) {
            this.symbol = str;
        }

        public void setWhetherGib(int i11) {
            this.whetherGib = i11;
        }

        public String toString() {
            return "OtcConfigItem.CurrencyBean(currencyId=" + getCurrencyId() + ", nameShort=" + getNameShort() + ", symbol=" + getSymbol() + ", supportPayments=" + getSupportPayments() + ", whetherGib=" + getWhetherGib() + ", entrance=" + getEntrance() + ")";
        }

        public CurrencyBean(String str, String str2, String str3, List<Integer> list, int i11, int i12) {
            this.currencyId = str;
            this.nameShort = str2;
            this.symbol = str3;
            this.supportPayments = list;
            this.whetherGib = i11;
            this.entrance = i12;
        }
    }

    public OtcConfigItem(Object obj) {
        this.object = obj;
    }
}
