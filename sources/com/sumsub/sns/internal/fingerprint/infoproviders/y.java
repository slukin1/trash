package com.sumsub.sns.internal.fingerprint.infoproviders;

import java.util.List;
import kotlin.jvm.internal.x;

public final class y {

    /* renamed from: a  reason: collision with root package name */
    public final String f34654a;

    /* renamed from: b  reason: collision with root package name */
    public final List<String> f34655b;

    public y(String str, List<String> list) {
        this.f34654a = str;
        this.f34655b = list;
    }

    public final String a() {
        return this.f34654a;
    }

    public final List<String> b() {
        return this.f34655b;
    }

    public final List<String> c() {
        return this.f34655b;
    }

    public final String d() {
        return this.f34654a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        return x.b(this.f34654a, yVar.f34654a) && x.b(this.f34655b, yVar.f34655b);
    }

    public int hashCode() {
        return (this.f34654a.hashCode() * 31) + this.f34655b.hashCode();
    }

    public String toString() {
        return "MediaCodecInfo(name=" + this.f34654a + ", capabilities=" + this.f34655b + ')';
    }

    public final y a(String str, List<String> list) {
        return new y(str, list);
    }

    public static /* synthetic */ y a(y yVar, String str, List<String> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = yVar.f34654a;
        }
        if ((i11 & 2) != 0) {
            list = yVar.f34655b;
        }
        return yVar.a(str, list);
    }
}
