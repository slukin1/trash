package com.hbg.module.huobi.im.group.ui.active;

import java.io.Serializable;
import kotlin.jvm.internal.r;

public final class RewardsLocation implements Serializable {

    /* renamed from: x  reason: collision with root package name */
    private int f20043x;

    /* renamed from: y  reason: collision with root package name */
    private int f20044y;

    public RewardsLocation() {
        this(0, 0, 3, (r) null);
    }

    public RewardsLocation(int i11, int i12) {
        this.f20043x = i11;
        this.f20044y = i12;
    }

    public static /* synthetic */ RewardsLocation copy$default(RewardsLocation rewardsLocation, int i11, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i11 = rewardsLocation.f20043x;
        }
        if ((i13 & 2) != 0) {
            i12 = rewardsLocation.f20044y;
        }
        return rewardsLocation.copy(i11, i12);
    }

    public final int component1() {
        return this.f20043x;
    }

    public final int component2() {
        return this.f20044y;
    }

    public final RewardsLocation copy(int i11, int i12) {
        return new RewardsLocation(i11, i12);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RewardsLocation)) {
            return false;
        }
        RewardsLocation rewardsLocation = (RewardsLocation) obj;
        return this.f20043x == rewardsLocation.f20043x && this.f20044y == rewardsLocation.f20044y;
    }

    public final int getX() {
        return this.f20043x;
    }

    public final int getY() {
        return this.f20044y;
    }

    public int hashCode() {
        return (this.f20043x * 31) + this.f20044y;
    }

    public final void setX(int i11) {
        this.f20043x = i11;
    }

    public final void setY(int i11) {
        this.f20044y = i11;
    }

    public String toString() {
        return "RewardsLocation(x=" + this.f20043x + ", y=" + this.f20044y + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RewardsLocation(int i11, int i12, int i13, r rVar) {
        this((i13 & 1) != 0 ? 0 : i11, (i13 & 2) != 0 ? 0 : i12);
    }
}
