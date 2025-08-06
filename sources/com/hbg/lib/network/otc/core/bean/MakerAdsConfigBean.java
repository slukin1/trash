package com.hbg.lib.network.otc.core.bean;

import java.io.Serializable;

public class MakerAdsConfigBean implements Serializable {
    private AdsCount count;

    public static class AdsCount implements Serializable {
        public String max;
        public String min;

        public boolean canEqual(Object obj) {
            return obj instanceof AdsCount;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof AdsCount)) {
                return false;
            }
            AdsCount adsCount = (AdsCount) obj;
            if (!adsCount.canEqual(this)) {
                return false;
            }
            String max2 = getMax();
            String max3 = adsCount.getMax();
            if (max2 != null ? !max2.equals(max3) : max3 != null) {
                return false;
            }
            String min2 = getMin();
            String min3 = adsCount.getMin();
            return min2 != null ? min2.equals(min3) : min3 == null;
        }

        public String getMax() {
            return this.max;
        }

        public String getMin() {
            return this.min;
        }

        public int hashCode() {
            String max2 = getMax();
            int i11 = 43;
            int hashCode = max2 == null ? 43 : max2.hashCode();
            String min2 = getMin();
            int i12 = (hashCode + 59) * 59;
            if (min2 != null) {
                i11 = min2.hashCode();
            }
            return i12 + i11;
        }

        public void setMax(String str) {
            this.max = str;
        }

        public void setMin(String str) {
            this.min = str;
        }

        public String toString() {
            return "MakerAdsConfigBean.AdsCount(max=" + getMax() + ", min=" + getMin() + ")";
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof MakerAdsConfigBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MakerAdsConfigBean)) {
            return false;
        }
        MakerAdsConfigBean makerAdsConfigBean = (MakerAdsConfigBean) obj;
        if (!makerAdsConfigBean.canEqual(this)) {
            return false;
        }
        AdsCount count2 = getCount();
        AdsCount count3 = makerAdsConfigBean.getCount();
        return count2 != null ? count2.equals(count3) : count3 == null;
    }

    public AdsCount getCount() {
        return this.count;
    }

    public int hashCode() {
        AdsCount count2 = getCount();
        return 59 + (count2 == null ? 43 : count2.hashCode());
    }

    public void setCount(AdsCount adsCount) {
        this.count = adsCount;
    }

    public String toString() {
        return "MakerAdsConfigBean(count=" + getCount() + ")";
    }
}
