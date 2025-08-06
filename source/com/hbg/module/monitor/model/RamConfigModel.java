package com.hbg.module.monitor.model;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.x;

@Keep
public final class RamConfigModel {
    @SerializedName("start")
    private final Integer start;
    @SerializedName("timeinterval")
    private final Integer timeInterval;

    public RamConfigModel(Integer num, Integer num2) {
        this.start = num;
        this.timeInterval = num2;
    }

    public static /* synthetic */ RamConfigModel copy$default(RamConfigModel ramConfigModel, Integer num, Integer num2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            num = ramConfigModel.start;
        }
        if ((i11 & 2) != 0) {
            num2 = ramConfigModel.timeInterval;
        }
        return ramConfigModel.copy(num, num2);
    }

    public final Integer component1() {
        return this.start;
    }

    public final Integer component2() {
        return this.timeInterval;
    }

    public final RamConfigModel copy(Integer num, Integer num2) {
        return new RamConfigModel(num, num2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RamConfigModel)) {
            return false;
        }
        RamConfigModel ramConfigModel = (RamConfigModel) obj;
        return x.b(this.start, ramConfigModel.start) && x.b(this.timeInterval, ramConfigModel.timeInterval);
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
        return "RamConfigModel(start=" + this.start + ", timeInterval=" + this.timeInterval + ')';
    }
}
