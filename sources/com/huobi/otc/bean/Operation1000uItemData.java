package com.huobi.otc.bean;

import com.huobi.otc.handler.Operation1000uItemViewHandler;
import java.io.Serializable;
import s9.a;

public class Operation1000uItemData implements Serializable, a {
    public String advertiseDays;
    public String time;
    public String type;

    public boolean canEqual(Object obj) {
        return obj instanceof Operation1000uItemData;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Operation1000uItemData)) {
            return false;
        }
        Operation1000uItemData operation1000uItemData = (Operation1000uItemData) obj;
        if (!operation1000uItemData.canEqual(this)) {
            return false;
        }
        String type2 = getType();
        String type3 = operation1000uItemData.getType();
        if (type2 != null ? !type2.equals(type3) : type3 != null) {
            return false;
        }
        String advertiseDays2 = getAdvertiseDays();
        String advertiseDays3 = operation1000uItemData.getAdvertiseDays();
        if (advertiseDays2 != null ? !advertiseDays2.equals(advertiseDays3) : advertiseDays3 != null) {
            return false;
        }
        String time2 = getTime();
        String time3 = operation1000uItemData.getTime();
        return time2 != null ? time2.equals(time3) : time3 == null;
    }

    public String getAdvertiseDays() {
        return this.advertiseDays;
    }

    public String getTime() {
        return this.time;
    }

    public String getType() {
        return this.type;
    }

    public String getViewHandlerName() {
        return Operation1000uItemViewHandler.class.getName();
    }

    public int hashCode() {
        String type2 = getType();
        int i11 = 43;
        int hashCode = type2 == null ? 43 : type2.hashCode();
        String advertiseDays2 = getAdvertiseDays();
        int hashCode2 = ((hashCode + 59) * 59) + (advertiseDays2 == null ? 43 : advertiseDays2.hashCode());
        String time2 = getTime();
        int i12 = hashCode2 * 59;
        if (time2 != null) {
            i11 = time2.hashCode();
        }
        return i12 + i11;
    }

    public void setAdvertiseDays(String str) {
        this.advertiseDays = str;
    }

    public void setTime(String str) {
        this.time = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String toString() {
        return "Operation1000uItemData(type=" + getType() + ", advertiseDays=" + getAdvertiseDays() + ", time=" + getTime() + ")";
    }
}
