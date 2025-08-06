package com.hbg.lib.network.hbg.core.bean;

import androidx.annotation.Keep;
import java.util.List;
import kotlin.jvm.internal.x;

@Keep
public final class ActivityZeroCreateBean {
    private final String highestProfit;
    private final String mainTitle;
    private final List<ActivityZeroPosition> positionList;
    private final Integer positionNew;
    private final Integer positionNum;
    private final String subTitle;

    public ActivityZeroCreateBean(String str, List<ActivityZeroPosition> list, Integer num, Integer num2, String str2, String str3) {
        this.highestProfit = str;
        this.positionList = list;
        this.positionNum = num;
        this.positionNew = num2;
        this.mainTitle = str2;
        this.subTitle = str3;
    }

    public static /* synthetic */ ActivityZeroCreateBean copy$default(ActivityZeroCreateBean activityZeroCreateBean, String str, List<ActivityZeroPosition> list, Integer num, Integer num2, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = activityZeroCreateBean.highestProfit;
        }
        if ((i11 & 2) != 0) {
            list = activityZeroCreateBean.positionList;
        }
        List<ActivityZeroPosition> list2 = list;
        if ((i11 & 4) != 0) {
            num = activityZeroCreateBean.positionNum;
        }
        Integer num3 = num;
        if ((i11 & 8) != 0) {
            num2 = activityZeroCreateBean.positionNew;
        }
        Integer num4 = num2;
        if ((i11 & 16) != 0) {
            str2 = activityZeroCreateBean.mainTitle;
        }
        String str4 = str2;
        if ((i11 & 32) != 0) {
            str3 = activityZeroCreateBean.subTitle;
        }
        return activityZeroCreateBean.copy(str, list2, num3, num4, str4, str3);
    }

    public final String component1() {
        return this.highestProfit;
    }

    public final List<ActivityZeroPosition> component2() {
        return this.positionList;
    }

    public final Integer component3() {
        return this.positionNum;
    }

    public final Integer component4() {
        return this.positionNew;
    }

    public final String component5() {
        return this.mainTitle;
    }

    public final String component6() {
        return this.subTitle;
    }

    public final ActivityZeroCreateBean copy(String str, List<ActivityZeroPosition> list, Integer num, Integer num2, String str2, String str3) {
        return new ActivityZeroCreateBean(str, list, num, num2, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityZeroCreateBean)) {
            return false;
        }
        ActivityZeroCreateBean activityZeroCreateBean = (ActivityZeroCreateBean) obj;
        return x.b(this.highestProfit, activityZeroCreateBean.highestProfit) && x.b(this.positionList, activityZeroCreateBean.positionList) && x.b(this.positionNum, activityZeroCreateBean.positionNum) && x.b(this.positionNew, activityZeroCreateBean.positionNew) && x.b(this.mainTitle, activityZeroCreateBean.mainTitle) && x.b(this.subTitle, activityZeroCreateBean.subTitle);
    }

    public final String getHighestProfit() {
        return this.highestProfit;
    }

    public final String getMainTitle() {
        return this.mainTitle;
    }

    public final List<ActivityZeroPosition> getPositionList() {
        return this.positionList;
    }

    public final Integer getPositionNew() {
        return this.positionNew;
    }

    public final Integer getPositionNum() {
        return this.positionNum;
    }

    public final String getSubTitle() {
        return this.subTitle;
    }

    public int hashCode() {
        String str = this.highestProfit;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        List<ActivityZeroPosition> list = this.positionList;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        Integer num = this.positionNum;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.positionNew;
        int hashCode4 = (hashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str2 = this.mainTitle;
        int hashCode5 = (hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.subTitle;
        if (str3 != null) {
            i11 = str3.hashCode();
        }
        return hashCode5 + i11;
    }

    public final boolean isShow() {
        List list;
        Integer num = this.positionNew;
        if (1 != (num != null ? num.intValue() : 0)) {
            return false;
        }
        List<ActivityZeroPosition> list2 = this.positionList;
        if (list2 == null || (list = CollectionsKt___CollectionsKt.X(list2)) == null) {
            list = CollectionsKt__CollectionsKt.k();
        }
        if (!list.isEmpty()) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "ActivityZeroCreateBean(highestProfit=" + this.highestProfit + ", positionList=" + this.positionList + ", positionNum=" + this.positionNum + ", positionNew=" + this.positionNew + ", mainTitle=" + this.mainTitle + ", subTitle=" + this.subTitle + ')';
    }
}
