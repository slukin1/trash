package com.sumsub.sns.internal.core.presentation.base.adapter;

import kotlin.jvm.internal.x;

public final class h extends a {

    /* renamed from: b  reason: collision with root package name */
    public final String f33715b;

    public h(String str) {
        super(4);
        this.f33715b = str;
    }

    public final h a(String str) {
        return new h(str);
    }

    public final String b() {
        return this.f33715b;
    }

    public final String c() {
        return this.f33715b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof h) && x.b(this.f33715b, ((h) obj).f33715b);
    }

    public int hashCode() {
        String str = this.f33715b;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        return "SNSTitleViewItem(text=" + this.f33715b + ')';
    }

    public static /* synthetic */ h a(h hVar, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = hVar.f33715b;
        }
        return hVar.a(str);
    }
}
