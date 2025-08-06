package com.hbg.lib.network.hbg.core.bean;

import androidx.annotation.Keep;
import kotlin.jvm.internal.x;

@Keep
public final class ActivityZeroNoticeSureBean {
    private final Integer noticeType;

    public ActivityZeroNoticeSureBean(Integer num) {
        this.noticeType = num;
    }

    public static /* synthetic */ ActivityZeroNoticeSureBean copy$default(ActivityZeroNoticeSureBean activityZeroNoticeSureBean, Integer num, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            num = activityZeroNoticeSureBean.noticeType;
        }
        return activityZeroNoticeSureBean.copy(num);
    }

    public final Integer component1() {
        return this.noticeType;
    }

    public final ActivityZeroNoticeSureBean copy(Integer num) {
        return new ActivityZeroNoticeSureBean(num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ActivityZeroNoticeSureBean) && x.b(this.noticeType, ((ActivityZeroNoticeSureBean) obj).noticeType);
    }

    public final Integer getNoticeType() {
        return this.noticeType;
    }

    public int hashCode() {
        Integer num = this.noticeType;
        if (num == null) {
            return 0;
        }
        return num.hashCode();
    }

    public String toString() {
        return "ActivityZeroNoticeSureBean(noticeType=" + this.noticeType + ')';
    }
}
