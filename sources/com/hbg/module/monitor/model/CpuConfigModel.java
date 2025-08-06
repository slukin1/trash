package com.hbg.module.monitor.model;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.x;

@Keep
public final class CpuConfigModel {
    @SerializedName("start")
    private final Integer start;
    @SerializedName("timeinterval")
    private final Integer timeInterval;

    public CpuConfigModel(Integer num, Integer num2) {
        this.start = num;
        this.timeInterval = num2;
    }

    public static /* synthetic */ CpuConfigModel copy$default(CpuConfigModel cpuConfigModel, Integer num, Integer num2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            num = cpuConfigModel.start;
        }
        if ((i11 & 2) != 0) {
            num2 = cpuConfigModel.timeInterval;
        }
        return cpuConfigModel.copy(num, num2);
    }

    public final Integer component1() {
        return this.start;
    }

    public final Integer component2() {
        return this.timeInterval;
    }

    public final CpuConfigModel copy(Integer num, Integer num2) {
        return new CpuConfigModel(num, num2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CpuConfigModel)) {
            return false;
        }
        CpuConfigModel cpuConfigModel = (CpuConfigModel) obj;
        return x.b(this.start, cpuConfigModel.start) && x.b(this.timeInterval, cpuConfigModel.timeInterval);
    }

    public final Integer getStart() {
        return this.start;
    }

    public final Integer getTimeInterval() {
        return this.timeInterval;
    }

    public int hashCode() {
        Integer num = this.start;
        int i11 = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.timeInterval;
        if (num2 != null) {
            i11 = num2.hashCode();
        }
        return hashCode + i11;
    }

    public String toString() {
        return "CpuConfigModel(start=" + this.start + ", timeInterval=" + this.timeInterval + ')';
    }
}
