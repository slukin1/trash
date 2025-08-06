package com.jumio.liveness.dto;

import com.jumio.commons.utils.ValueWithOffset;
import java.io.Serializable;

public final class Yaw implements ValueWithOffset<Integer>, Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final int f24947a;

    /* renamed from: b  reason: collision with root package name */
    public final int f24948b;

    public Yaw(int i11, int i12) {
        this.f24947a = i11;
        this.f24948b = i12;
    }

    public static /* synthetic */ Yaw copy$default(Yaw yaw, int i11, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i11 = yaw.f24947a;
        }
        if ((i13 & 2) != 0) {
            i12 = yaw.f24948b;
        }
        return yaw.copy(i11, i12);
    }

    public final int component1() {
        return this.f24947a;
    }

    public final int component2() {
        return this.f24948b;
    }

    public final Yaw copy(int i11, int i12) {
        return new Yaw(i11, i12);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Yaw)) {
            return false;
        }
        Yaw yaw = (Yaw) obj;
        return this.f24947a == yaw.f24947a && this.f24948b == yaw.f24948b;
    }

    public Integer getOffset() {
        return Integer.valueOf(this.f24948b);
    }

    public Integer getValue() {
        return Integer.valueOf(this.f24947a);
    }

    public int hashCode() {
        return this.f24948b + (this.f24947a * 31);
    }

    public String toString() {
        int i11 = this.f24947a;
        int i12 = this.f24948b;
        return "Yaw(value=" + i11 + ", offset=" + i12 + ")";
    }
}
