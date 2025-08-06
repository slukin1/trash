package com.sumsub.sns.internal.core.presentation.base.adapter;

import kotlin.jvm.internal.x;

public final class e extends a {

    /* renamed from: b  reason: collision with root package name */
    public final String f33710b;

    public e(String str) {
        super(3);
        this.f33710b = str;
    }

    public final e a(String str) {
        return new e(str);
    }

    public final String b() {
        return this.f33710b;
    }

    public final String c() {
        return this.f33710b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof e) && x.b(this.f33710b, ((e) obj).f33710b);
    }

    public int hashCode() {
        return this.f33710b.hashCode();
    }

    public String toString() {
        return "SNSHugeIconViewItem(iconKey=" + this.f33710b + ')';
    }

    public static /* synthetic */ e a(e eVar, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = eVar.f33710b;
        }
        return eVar.a(str);
    }
}
