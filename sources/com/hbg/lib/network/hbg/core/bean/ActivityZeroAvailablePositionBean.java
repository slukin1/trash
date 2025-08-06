package com.hbg.lib.network.hbg.core.bean;

import androidx.annotation.Keep;
import kotlin.jvm.internal.x;

@Keep
public final class ActivityZeroAvailablePositionBean {
    private final Integer available;
    private final Integer count;
    private final String highestProfit;
    private final Integer positionNotice;

    public ActivityZeroAvailablePositionBean(Integer num, Integer num2, String str, Integer num3) {
        this.available = num;
        this.count = num2;
        this.highestProfit = str;
        this.positionNotice = num3;
    }

    public static /* synthetic */ ActivityZeroAvailablePositionBean copy$default(ActivityZeroAvailablePositionBean activityZeroAvailablePositionBean, Integer num, Integer num2, String str, Integer num3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            num = activityZeroAvailablePositionBean.available;
        }
        if ((i11 & 2) != 0) {
            num2 = activityZeroAvailablePositionBean.count;
        }
        if ((i11 & 4) != 0) {
            str = activityZeroAvailablePositionBean.highestProfit;
        }
        if ((i11 & 8) != 0) {
            num3 = activityZeroAvailablePositionBean.positionNotice;
        }
        return activityZeroAvailablePositionBean.copy(num, num2, str, num3);
    }

    public final Integer component1() {
        return this.available;
    }

    public final Integer component2() {
        return this.count;
    }

    public final String component3() {
        return this.highestProfit;
    }

    public final Integer component4() {
        return this.positionNotice;
    }

    public final ActivityZeroAvailablePositionBean copy(Integer num, Integer num2, String str, Integer num3) {
        return new ActivityZeroAvailablePositionBean(num, num2, str, num3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityZeroAvailablePositionBean)) {
            return false;
        }
        ActivityZeroAvailablePositionBean activityZeroAvailablePositionBean = (ActivityZeroAvailablePositionBean) obj;
        return x.b(this.available, activityZeroAvailablePositionBean.available) && x.b(this.count, activityZeroAvailablePositionBean.count) && x.b(this.highestProfit, activityZeroAvailablePositionBean.highestProfit) && x.b(this.positionNotice, activityZeroAvailablePositionBean.positionNotice);
    }

    public final Integer getAvailable() {
        return this.available;
    }

    public final Integer getCount() {
        return this.count;
    }

    public final String getHighestProfit() {
        return this.highestProfit;
    }

    public final Integer getPositionNotice() {
        return this.positionNotice;
    }

    public int hashCode() {
        Integer num = this.available;
        int i11 = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.count;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str = this.highestProfit;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        Integer num3 = this.positionNotice;
        if (num3 != null) {
            i11 = num3.hashCode();
        }
        return hashCode3 + i11;
    }

    public String toString() {
        return "ActivityZeroAvailablePositionBean(available=" + this.available + ", count=" + this.count + ", highestProfit=" + this.highestProfit + ", positionNotice=" + this.positionNotice + ')';
    }
}
