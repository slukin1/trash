package com.hbg.module.monitor.model;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.x;

@Keep
public final class NetWorkConfigModel {
    @SerializedName("apiList")
    private final List<String> apiList;
    @SerializedName("ignoreList")
    private final List<String> ignoreList;
    @SerializedName("isAll")
    private final Integer isAll;
    @SerializedName("start")
    private final Integer start;
    @SerializedName("timeinterval")
    private final Long timeInterval;

    public NetWorkConfigModel(List<String> list, List<String> list2, Integer num, Integer num2, Long l11) {
        this.apiList = list;
        this.ignoreList = list2;
        this.isAll = num;
        this.start = num2;
        this.timeInterval = l11;
    }

    public static /* synthetic */ NetWorkConfigModel copy$default(NetWorkConfigModel netWorkConfigModel, List<String> list, List<String> list2, Integer num, Integer num2, Long l11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = netWorkConfigModel.apiList;
        }
        if ((i11 & 2) != 0) {
            list2 = netWorkConfigModel.ignoreList;
        }
        List<String> list3 = list2;
        if ((i11 & 4) != 0) {
            num = netWorkConfigModel.isAll;
        }
        Integer num3 = num;
        if ((i11 & 8) != 0) {
            num2 = netWorkConfigModel.start;
        }
        Integer num4 = num2;
        if ((i11 & 16) != 0) {
            l11 = netWorkConfigModel.timeInterval;
        }
        return netWorkConfigModel.copy(list, list3, num3, num4, l11);
    }

    public final List<String> apiList() {
        List<String> list = this.apiList;
        return list == null ? new ArrayList() : list;
    }

    public final List<String> component1() {
        return this.apiList;
    }

    public final List<String> component2() {
        return this.ignoreList;
    }

    public final Integer component3() {
        return this.isAll;
    }

    public final Integer component4() {
        return this.start;
    }

    public final Long component5() {
        return this.timeInterval;
    }

    public final NetWorkConfigModel copy(List<String> list, List<String> list2, Integer num, Integer num2, Long l11) {
        return new NetWorkConfigModel(list, list2, num, num2, l11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NetWorkConfigModel)) {
            return false;
        }
        NetWorkConfigModel netWorkConfigModel = (NetWorkConfigModel) obj;
        return x.b(this.apiList, netWorkConfigModel.apiList) && x.b(this.ignoreList, netWorkConfigModel.ignoreList) && x.b(this.isAll, netWorkConfigModel.isAll) && x.b(this.start, netWorkConfigModel.start) && x.b(this.timeInterval, netWorkConfigModel.timeInterval);
    }

    public final List<String> getApiList() {
        return this.apiList;
    }

    public final List<String> getIgnoreList() {
        return this.ignoreList;
    }

    public final Integer getStart() {
        return this.start;
    }

    public final Long getTimeInterval() {
        return this.timeInterval;
    }

    public int hashCode() {
        List<String> list = this.apiList;
        int i11 = 0;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<String> list2 = this.ignoreList;
        int hashCode2 = (hashCode + (list2 == null ? 0 : list2.hashCode())) * 31;
        Integer num = this.isAll;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.start;
        int hashCode4 = (hashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Long l11 = this.timeInterval;
        if (l11 != null) {
            i11 = l11.hashCode();
        }
        return hashCode4 + i11;
    }

    public final List<String> ignoreList() {
        List<String> list = this.ignoreList;
        return list == null ? new ArrayList() : list;
    }

    public final Integer isAll() {
        return this.isAll;
    }

    public final boolean isStart() {
        Integer num = this.start;
        return 1 == (num != null ? num.intValue() : 2);
    }

    public final long timeInterval() {
        Long l11 = this.timeInterval;
        if (l11 != null) {
            return l11.longValue();
        }
        return 300;
    }

    public String toString() {
        return "NetWorkConfigModel(apiList=" + this.apiList + ", ignoreList=" + this.ignoreList + ", isAll=" + this.isAll + ", start=" + this.start + ", timeInterval=" + this.timeInterval + ')';
    }

    /* renamed from: isAll  reason: collision with other method in class */
    public final boolean m14isAll() {
        Integer num = this.isAll;
        return 1 == (num != null ? num.intValue() : 1);
    }
}
