package com.huobi.otc.bean;

import java.io.Serializable;
import java.util.List;

public class OtcU1000DetailBean implements Serializable {
    private List<OtcU1000ActivityBean> activityRecordList;
    private String activityUrl;
    private int advertiseEarns;
    private int allEarns;
    private int orderEarns;
    private int topEarns;

    public boolean canEqual(Object obj) {
        return obj instanceof OtcU1000DetailBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OtcU1000DetailBean)) {
            return false;
        }
        OtcU1000DetailBean otcU1000DetailBean = (OtcU1000DetailBean) obj;
        if (!otcU1000DetailBean.canEqual(this) || getAllEarns() != otcU1000DetailBean.getAllEarns() || getTopEarns() != otcU1000DetailBean.getTopEarns() || getAdvertiseEarns() != otcU1000DetailBean.getAdvertiseEarns() || getOrderEarns() != otcU1000DetailBean.getOrderEarns()) {
            return false;
        }
        String activityUrl2 = getActivityUrl();
        String activityUrl3 = otcU1000DetailBean.getActivityUrl();
        if (activityUrl2 != null ? !activityUrl2.equals(activityUrl3) : activityUrl3 != null) {
            return false;
        }
        List<OtcU1000ActivityBean> activityRecordList2 = getActivityRecordList();
        List<OtcU1000ActivityBean> activityRecordList3 = otcU1000DetailBean.getActivityRecordList();
        return activityRecordList2 != null ? activityRecordList2.equals(activityRecordList3) : activityRecordList3 == null;
    }

    public List<OtcU1000ActivityBean> getActivityRecordList() {
        return this.activityRecordList;
    }

    public String getActivityUrl() {
        return this.activityUrl;
    }

    public int getAdvertiseEarns() {
        return this.advertiseEarns;
    }

    public int getAllEarns() {
        return this.allEarns;
    }

    public int getOrderEarns() {
        return this.orderEarns;
    }

    public int getTopEarns() {
        return this.topEarns;
    }

    public int hashCode() {
        int allEarns2 = ((((((getAllEarns() + 59) * 59) + getTopEarns()) * 59) + getAdvertiseEarns()) * 59) + getOrderEarns();
        String activityUrl2 = getActivityUrl();
        int i11 = 43;
        int hashCode = (allEarns2 * 59) + (activityUrl2 == null ? 43 : activityUrl2.hashCode());
        List<OtcU1000ActivityBean> activityRecordList2 = getActivityRecordList();
        int i12 = hashCode * 59;
        if (activityRecordList2 != null) {
            i11 = activityRecordList2.hashCode();
        }
        return i12 + i11;
    }

    public void setActivityRecordList(List<OtcU1000ActivityBean> list) {
        this.activityRecordList = list;
    }

    public void setActivityUrl(String str) {
        this.activityUrl = str;
    }

    public void setAdvertiseEarns(int i11) {
        this.advertiseEarns = i11;
    }

    public void setAllEarns(int i11) {
        this.allEarns = i11;
    }

    public void setOrderEarns(int i11) {
        this.orderEarns = i11;
    }

    public void setTopEarns(int i11) {
        this.topEarns = i11;
    }

    public String toString() {
        return "OtcU1000DetailBean(allEarns=" + getAllEarns() + ", topEarns=" + getTopEarns() + ", advertiseEarns=" + getAdvertiseEarns() + ", orderEarns=" + getOrderEarns() + ", activityUrl=" + getActivityUrl() + ", activityRecordList=" + getActivityRecordList() + ")";
    }
}
