package com.hbg.lib.network.hbg.core.bean;

import androidx.annotation.Keep;
import kotlin.jvm.internal.x;

@Keep
public final class ActivityZeroPositionProfitInfoBean {
    private final Integer highestProfitFlag;
    private final Integer profitNotice;

    public ActivityZeroPositionProfitInfoBean(Integer num, Integer num2) {
        this.profitNotice = num;
        this.highestProfitFlag = num2;
    }

    public static /* synthetic */ ActivityZeroPositionProfitInfoBean copy$default(ActivityZeroPositionProfitInfoBean activityZeroPositionProfitInfoBean, Integer num, Integer num2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            num = activityZeroPositionProfitInfoBean.profitNotice;
        }
        if ((i11 & 2) != 0) {
            num2 = activityZeroPositionProfitInfoBean.highestProfitFlag;
        }
        return activityZeroPositionProfitInfoBean.copy(num, num2);
    }

    public final Integer component1() {
        return this.profitNotice;
    }

    public final Integer component2() {
        return this.highestProfitFlag;
    }

    public final ActivityZeroPositionProfitInfoBean copy(Integer num, Integer num2) {
        return new ActivityZeroPositionProfitInfoBean(num, num2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityZeroPositionProfitInfoBean)) {
            return false;
        }
        ActivityZeroPositionProfitInfoBean activityZeroPositionProfitInfoBean = (ActivityZeroPositionProfitInfoBean) obj;
        return x.b(this.profitNotice, activityZeroPositionProfitInfoBean.profitNotice) && x.b(this.highestProfitFlag, activityZeroPositionProfitInfoBean.highestProfitFlag);
    }

    public final Integer getHighestProfitFlag() {
        return this.highestProfitFlag;
    }

    public final Integer getProfitNotice() {
        return this.profitNotice;
    }

    public int hashCode() {
        Integer num = this.profitNotice;
        int i11 = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.highestProfitFlag;
        if (num2 != null) {
            i11 = num2.hashCode();
        }
        return hashCode + i11;
    }

    public String toString() {
        return "ActivityZeroPositionProfitInfoBean(profitNotice=" + this.profitNotice + ", highestProfitFlag=" + this.highestProfitFlag + ')';
    }
}
