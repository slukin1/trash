package com.hbg.module.libkt.utils.event.bean;

import com.fluttercandies.photo_manager.core.entity.a;
import kotlin.jvm.internal.r;

public final class RisePut {

    /* renamed from: a  reason: collision with root package name */
    public long f24886a;

    /* renamed from: b  reason: collision with root package name */
    public int f24887b;

    /* renamed from: c  reason: collision with root package name */
    public int f24888c;

    /* renamed from: d  reason: collision with root package name */
    public int f24889d;

    public RisePut() {
        this(0, 0, 0, 0, 15, (r) null);
    }

    public RisePut(long j11, int i11, int i12, int i13) {
        this.f24886a = j11;
        this.f24887b = i11;
        this.f24888c = i12;
        this.f24889d = i13;
    }

    public final long a() {
        return this.f24886a;
    }

    public final int b() {
        return this.f24888c;
    }

    public final int c() {
        return this.f24887b;
    }

    public final int d() {
        return this.f24889d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RisePut)) {
            return false;
        }
        RisePut risePut = (RisePut) obj;
        return this.f24886a == risePut.f24886a && this.f24887b == risePut.f24887b && this.f24888c == risePut.f24888c && this.f24889d == risePut.f24889d;
    }

    public int hashCode() {
        return (((((a.a(this.f24886a) * 31) + this.f24887b) * 31) + this.f24888c) * 31) + this.f24889d;
    }

    public String toString() {
        return "RisePut(id=" + this.f24886a + ", rise=" + this.f24887b + ", put=" + this.f24888c + ", status=" + this.f24889d + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RisePut(long j11, int i11, int i12, int i13, int i14, r rVar) {
        this((i14 & 1) != 0 ? 0 : j11, (i14 & 2) != 0 ? 0 : i11, (i14 & 4) != 0 ? 0 : i12, (i14 & 8) != 0 ? 0 : i13);
    }
}
