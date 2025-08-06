package com.hbg.module.libkt.utils.event.bean;

import com.fluttercandies.photo_manager.core.entity.a;
import kotlin.jvm.internal.r;

public final class ShareNum {

    /* renamed from: a  reason: collision with root package name */
    public long f24890a;

    /* renamed from: b  reason: collision with root package name */
    public int f24891b;

    public ShareNum() {
        this(0, 0, 3, (r) null);
    }

    public ShareNum(long j11, int i11) {
        this.f24890a = j11;
        this.f24891b = i11;
    }

    public final int a() {
        return this.f24891b;
    }

    public final long b() {
        return this.f24890a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShareNum)) {
            return false;
        }
        ShareNum shareNum = (ShareNum) obj;
        return this.f24890a == shareNum.f24890a && this.f24891b == shareNum.f24891b;
    }

    public int hashCode() {
        return (a.a(this.f24890a) * 31) + this.f24891b;
    }

    public String toString() {
        return "ShareNum(topicId=" + this.f24890a + ", shareNum=" + this.f24891b + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ShareNum(long j11, int i11, int i12, r rVar) {
        this((i12 & 1) != 0 ? 0 : j11, (i12 & 2) != 0 ? 0 : i11);
    }
}
