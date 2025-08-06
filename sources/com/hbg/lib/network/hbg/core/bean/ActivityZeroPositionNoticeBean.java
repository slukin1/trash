package com.hbg.lib.network.hbg.core.bean;

import androidx.annotation.Keep;
import kotlin.jvm.internal.x;

@Keep
public final class ActivityZeroPositionNoticeBean {
    private final Integer noticeType;

    public ActivityZeroPositionNoticeBean(Integer num) {
        this.noticeType = num;
    }

    public static /* synthetic */ ActivityZeroPositionNoticeBean copy$default(ActivityZeroPositionNoticeBean activityZeroPositionNoticeBean, Integer num, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            num = activityZeroPositionNoticeBean.noticeType;
        }
        return activityZeroPositionNoticeBean.copy(num);
    }

    public final Integer component1() {
        return this.noticeType;
    }

    public final ActivityZeroPositionNoticeBean copy(Integer num) {
        return new ActivityZeroPositionNoticeBean(num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ActivityZeroPositionNoticeBean) && x.b(this.noticeType, ((ActivityZeroPositionNoticeBean) obj).noticeType);
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
        return "ActivityZeroPositionNoticeBean(noticeType=" + this.noticeType + ')';
    }
}
