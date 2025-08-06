package com.jumio.liveness.dto;

import com.jumio.commons.utils.ValueWithOffset;
import java.io.Serializable;

public final class Pitch implements ValueWithOffset<Integer>, Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final int f24945a;

    /* renamed from: b  reason: collision with root package name */
    public final int f24946b;

    public Pitch(int i11, int i12) {
        this.f24945a = i11;
        this.f24946b = i12;
    }

    public static /* synthetic */ Pitch copy$default(Pitch pitch, int i11, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i11 = pitch.f24945a;
        }
        if ((i13 & 2) != 0) {
            i12 = pitch.f24946b;
        }
        return pitch.copy(i11, i12);
    }

    public final int component1() {
        return this.f24945a;
    }

    public final int component2() {
        return this.f24946b;
    }

    public final Pitch copy(int i11, int i12) {
        return new Pitch(i11, i12);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Pitch)) {
            return false;
        }
        Pitch pitch = (Pitch) obj;
        return this.f24945a == pitch.f24945a && this.f24946b == pitch.f24946b;
    }

    public Integer getOffset() {
        return Integer.valueOf(this.f24946b);
    }

    public Integer getValue() {
        return Integer.valueOf(this.f24945a);
    }

    public int hashCode() {
        return this.f24946b + (this.f24945a * 31);
    }

    public String toString() {
        int i11 = this.f24945a;
        int i12 = this.f24946b;
        return "Pitch(value=" + i11 + ", offset=" + i12 + ")";
    }
}
