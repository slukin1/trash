package com.hbg.lib.network.otc.core.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class QuickTradeConfigBean implements Serializable {
    private List<Business> business;
    private String cdnHost;
    private List<Asset> fiatAsset;
    private Map<String, List<String>> pair;
    private List<Payment> payment;
    private List<Asset> virtualAsset;

    public static class Asset implements Serializable {
        private String fullName;
        private String icon;
        private String max;
        private String min;
        private String name;
        private int scale;
        private String symbol;
        private String trade;
        private int type;

        public boolean canEqual(Object obj) {
            return obj instanceof Asset;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Asset)) {
                return false;
            }
            Asset asset = (Asset) obj;
            if (!asset.canEqual(this)) {
                return false;
            }
            String name2 = getName();
            String name3 = asset.getName();
            if (name2 != null ? !name2.equals(name3) : name3 != null) {
                return false;
            }
            String icon2 = getIcon();
            String icon3 = asset.getIcon();
            if (icon2 != null ? !icon2.equals(icon3) : icon3 != null) {
                return false;
            }
            String symbol2 = getSymbol();
            String symbol3 = asset.getSymbol();
            if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
                return false;
            }
            String fullName2 = getFullName();
            String fullName3 = asset.getFullName();
            if (fullName2 != null ? !fullName2.equals(fullName3) : fullName3 != null) {
                return false;
            }
            if (getScale() != asset.getScale() || getType() != asset.getType()) {
                return false;
            }
            String min2 = getMin();
            String min3 = asset.getMin();
            if (min2 != null ? !min2.equals(min3) : min3 != null) {
                return false;
            }
            String max2 = getMax();
            String max3 = asset.getMax();
            if (max2 != null ? !max2.equals(max3) : max3 != null) {
                return false;
            }
            String trade2 = getTrade();
            String trade3 = asset.getTrade();
            return trade2 != null ? trade2.equals(trade3) : trade3 == null;
        }

        public String getFullName() {
            return this.fullName;
        }

        public String getIcon() {
            return this.icon;
        }

        public String getMax() {
            return this.max;
        }

        public String getMin() {
            return this.min;
        }

        public String getName() {
            return this.name;
        }

        public int getScale() {
            return this.scale;
        }

        public String getSymbol() {
            return this.symbol;
        }

        public String getTrade() {
            return this.trade;
        }

        public int getType() {
            return this.type;
        }

        public int hashCode() {
            String name2 = getName();
            int i11 = 43;
            int hashCode = name2 == null ? 43 : name2.hashCode();
            String icon2 = getIcon();
            int hashCode2 = ((hashCode + 59) * 59) + (icon2 == null ? 43 : icon2.hashCode());
            String symbol2 = getSymbol();
            int hashCode3 = (hashCode2 * 59) + (symbol2 == null ? 43 : symbol2.hashCode());
            String fullName2 = getFullName();
            int hashCode4 = (((((hashCode3 * 59) + (fullName2 == null ? 43 : fullName2.hashCode())) * 59) + getScale()) * 59) + getType();
            String min2 = getMin();
            int hashCode5 = (hashCode4 * 59) + (min2 == null ? 43 : min2.hashCode());
            String max2 = getMax();
            int hashCode6 = (hashCode5 * 59) + (max2 == null ? 43 : max2.hashCode());
            String trade2 = getTrade();
            int i12 = hashCode6 * 59;
            if (trade2 != null) {
                i11 = trade2.hashCode();
            }
            return i12 + i11;
        }

        public void setFullName(String str) {
            this.fullName = str;
        }

        public void setIcon(String str) {
            this.icon = str;
        }

        public void setMax(String str) {
            this.max = str;
        }

        public void setMin(String str) {
            this.min = str;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setScale(int i11) {
            this.scale = i11;
        }

        public void setSymbol(String str) {
            this.symbol = str;
        }

        public void setTrade(String str) {
            this.trade = str;
        }

        public void setType(int i11) {
            this.type = i11;
        }

        public String toString() {
            return "QuickTradeConfigBean.Asset(name=" + getName() + ", icon=" + getIcon() + ", symbol=" + getSymbol() + ", fullName=" + getFullName() + ", scale=" + getScale() + ", type=" + getType() + ", min=" + getMin() + ", max=" + getMax() + ", trade=" + getTrade() + ")";
        }
    }

    public static class Business implements Serializable {
        private String code;
        private String name;
        private List<String> side;

        public boolean canEqual(Object obj) {
            return obj instanceof Business;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Business)) {
                return false;
            }
            Business business = (Business) obj;
            if (!business.canEqual(this)) {
                return false;
            }
            String code2 = getCode();
            String code3 = business.getCode();
            if (code2 != null ? !code2.equals(code3) : code3 != null) {
                return false;
            }
            String name2 = getName();
            String name3 = business.getName();
            if (name2 != null ? !name2.equals(name3) : name3 != null) {
                return false;
            }
            List<String> side2 = getSide();
            List<String> side3 = business.getSide();
            return side2 != null ? side2.equals(side3) : side3 == null;
        }

        public String getCode() {
            return this.code;
        }

        public String getName() {
            return this.name;
        }

        public List<String> getSide() {
            return this.side;
        }

        public int hashCode() {
            String code2 = getCode();
            int i11 = 43;
            int hashCode = code2 == null ? 43 : code2.hashCode();
            String name2 = getName();
            int hashCode2 = ((hashCode + 59) * 59) + (name2 == null ? 43 : name2.hashCode());
            List<String> side2 = getSide();
            int i12 = hashCode2 * 59;
            if (side2 != null) {
                i11 = side2.hashCode();
            }
            return i12 + i11;
        }

        public void setCode(String str) {
            this.code = str;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setSide(List<String> list) {
            this.side = list;
        }

        public String toString() {
            return "QuickTradeConfigBean.Business(code=" + getCode() + ", name=" + getName() + ", side=" + getSide() + ")";
        }
    }

    public static class Payment implements Serializable {
        private String code;
        private String color;
        private String name;

        public boolean canEqual(Object obj) {
            return obj instanceof Payment;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Payment)) {
                return false;
            }
            Payment payment = (Payment) obj;
            if (!payment.canEqual(this)) {
                return false;
            }
            String code2 = getCode();
            String code3 = payment.getCode();
            if (code2 != null ? !code2.equals(code3) : code3 != null) {
                return false;
            }
            String name2 = getName();
            String name3 = payment.getName();
            if (name2 != null ? !name2.equals(name3) : name3 != null) {
                return false;
            }
            String color2 = getColor();
            String color3 = payment.getColor();
            return color2 != null ? color2.equals(color3) : color3 == null;
        }

        public String getCode() {
            return this.code;
        }

        public String getColor() {
            return this.color;
        }

        public String getName() {
            return this.name;
        }

        public int hashCode() {
            String code2 = getCode();
            int i11 = 43;
            int hashCode = code2 == null ? 43 : code2.hashCode();
            String name2 = getName();
            int hashCode2 = ((hashCode + 59) * 59) + (name2 == null ? 43 : name2.hashCode());
            String color2 = getColor();
            int i12 = hashCode2 * 59;
            if (color2 != null) {
                i11 = color2.hashCode();
            }
            return i12 + i11;
        }

        public void setCode(String str) {
            this.code = str;
        }

        public void setColor(String str) {
            this.color = str;
        }

        public void setName(String str) {
            this.name = str;
        }

        public String toString() {
            return "QuickTradeConfigBean.Payment(code=" + getCode() + ", name=" + getName() + ", color=" + getColor() + ")";
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof QuickTradeConfigBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof QuickTradeConfigBean)) {
            return false;
        }
        QuickTradeConfigBean quickTradeConfigBean = (QuickTradeConfigBean) obj;
        if (!quickTradeConfigBean.canEqual(this)) {
            return false;
        }
        String cdnHost2 = getCdnHost();
        String cdnHost3 = quickTradeConfigBean.getCdnHost();
        if (cdnHost2 != null ? !cdnHost2.equals(cdnHost3) : cdnHost3 != null) {
            return false;
        }
        List<Asset> fiatAsset2 = getFiatAsset();
        List<Asset> fiatAsset3 = quickTradeConfigBean.getFiatAsset();
        if (fiatAsset2 != null ? !fiatAsset2.equals(fiatAsset3) : fiatAsset3 != null) {
            return false;
        }
        List<Asset> virtualAsset2 = getVirtualAsset();
        List<Asset> virtualAsset3 = quickTradeConfigBean.getVirtualAsset();
        if (virtualAsset2 != null ? !virtualAsset2.equals(virtualAsset3) : virtualAsset3 != null) {
            return false;
        }
        List<Payment> payment2 = getPayment();
        List<Payment> payment3 = quickTradeConfigBean.getPayment();
        if (payment2 != null ? !payment2.equals(payment3) : payment3 != null) {
            return false;
        }
        List<Business> business2 = getBusiness();
        List<Business> business3 = quickTradeConfigBean.getBusiness();
        if (business2 != null ? !business2.equals(business3) : business3 != null) {
            return false;
        }
        Map<String, List<String>> pair2 = getPair();
        Map<String, List<String>> pair3 = quickTradeConfigBean.getPair();
        return pair2 != null ? pair2.equals(pair3) : pair3 == null;
    }

    public List<Business> getBusiness() {
        return this.business;
    }

    public String getCdnHost() {
        return this.cdnHost;
    }

    public List<Asset> getFiatAsset() {
        return this.fiatAsset;
    }

    public Map<String, List<String>> getPair() {
        return this.pair;
    }

    public List<Payment> getPayment() {
        return this.payment;
    }

    public List<Asset> getVirtualAsset() {
        return this.virtualAsset;
    }

    public int hashCode() {
        String cdnHost2 = getCdnHost();
        int i11 = 43;
        int hashCode = cdnHost2 == null ? 43 : cdnHost2.hashCode();
        List<Asset> fiatAsset2 = getFiatAsset();
        int hashCode2 = ((hashCode + 59) * 59) + (fiatAsset2 == null ? 43 : fiatAsset2.hashCode());
        List<Asset> virtualAsset2 = getVirtualAsset();
        int hashCode3 = (hashCode2 * 59) + (virtualAsset2 == null ? 43 : virtualAsset2.hashCode());
        List<Payment> payment2 = getPayment();
        int hashCode4 = (hashCode3 * 59) + (payment2 == null ? 43 : payment2.hashCode());
        List<Business> business2 = getBusiness();
        int hashCode5 = (hashCode4 * 59) + (business2 == null ? 43 : business2.hashCode());
        Map<String, List<String>> pair2 = getPair();
        int i12 = hashCode5 * 59;
        if (pair2 != null) {
            i11 = pair2.hashCode();
        }
        return i12 + i11;
    }

    public void setBusiness(List<Business> list) {
        this.business = list;
    }

    public void setCdnHost(String str) {
        this.cdnHost = str;
    }

    public void setFiatAsset(List<Asset> list) {
        this.fiatAsset = list;
    }

    public void setPair(Map<String, List<String>> map) {
        this.pair = map;
    }

    public void setPayment(List<Payment> list) {
        this.payment = list;
    }

    public void setVirtualAsset(List<Asset> list) {
        this.virtualAsset = list;
    }

    public String toString() {
        return "QuickTradeConfigBean(cdnHost=" + getCdnHost() + ", fiatAsset=" + getFiatAsset() + ", virtualAsset=" + getVirtualAsset() + ", payment=" + getPayment() + ", business=" + getBusiness() + ", pair=" + getPair() + ")";
    }
}
