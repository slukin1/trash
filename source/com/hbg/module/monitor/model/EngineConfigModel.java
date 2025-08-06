package com.hbg.module.monitor.model;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.x;

@Keep
public final class EngineConfigModel {
    @SerializedName("start")
    private final Integer start;

    public EngineConfigModel(Integer num) {
        this.start = num;
    }

    public static /* synthetic */ EngineConfigModel copy$default(EngineConfigModel engineConfigModel, Integer num, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            num = engineConfigModel.start;
        }
        return engineConfigModel.copy(num);
    }

    public final Integer component1() {
        return this.start;
    }

    public final EngineConfigModel copy(Integer num) {
        return new EngineConfigModel(num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof EngineConfigModel) && x.b(this.start, ((EngineConfigModel) obj).start);
    }

    public final Integer getStart() {
        return this.start;
    }

    public int hashCode() {
        Integer num = this.start;
        if (num == null) {
            return 0;
        }
        return num.hashCode();
    }

    public String toString() {
        return "EngineConfigModel(start=" + this.start + ')';
    }
}
