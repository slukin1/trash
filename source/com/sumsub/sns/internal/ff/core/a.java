package com.sumsub.sns.internal.ff.core;

import com.sumsub.sns.internal.core.common.e0;
import java.util.concurrent.atomic.AtomicReference;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final String f34241a;

    /* renamed from: b  reason: collision with root package name */
    public final String f34242b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f34243c;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicReference<c> f34244d = new AtomicReference<>();

    /* renamed from: e  reason: collision with root package name */
    public final AtomicReference<c> f34245e = new AtomicReference<>();

    /* renamed from: f  reason: collision with root package name */
    public final AtomicReference<c> f34246f = new AtomicReference<>();

    /* renamed from: g  reason: collision with root package name */
    public final c f34247g;

    public a(String str, String str2, boolean z11, String str3) {
        this.f34241a = str;
        this.f34242b = str2;
        this.f34243c = z11;
        this.f34247g = new c(str, false, str3, FeatureFlagValueType.DEFAULT);
    }

    public final void a() {
        this.f34246f.set((Object) null);
    }

    public final c b() {
        return this.f34247g;
    }

    public final String c() {
        return this.f34242b;
    }

    public final boolean d() {
        return this.f34243c;
    }

    public final String e() {
        return this.f34241a;
    }

    public final String f() {
        return i().c();
    }

    public final boolean g() {
        return h() || i().d();
    }

    public final boolean h() {
        e0.f32018a.isDebug();
        return false;
    }

    public final c i() {
        c cVar;
        c cVar2 = this.f34246f.get();
        if (cVar2 != null) {
            return cVar2;
        }
        c cVar3 = this.f34245e.get();
        if (cVar3 != null) {
            return cVar3;
        }
        if (this.f34243c || (cVar = this.f34244d.get()) == null) {
            return this.f34247g;
        }
        return cVar;
    }

    public final void j() {
        this.f34244d.set((Object) null);
        this.f34246f.set((Object) null);
        this.f34245e.set((Object) null);
    }

    public static /* synthetic */ void a(a aVar, boolean z11, String str, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str = null;
        }
        aVar.a(z11, str);
    }

    public static /* synthetic */ void b(a aVar, boolean z11, String str, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str = null;
        }
        aVar.b(z11, str);
    }

    public static /* synthetic */ void c(a aVar, boolean z11, String str, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str = null;
        }
        aVar.c(z11, str);
    }

    public final void a(boolean z11, String str) {
        this.f34245e.set(new c(this.f34241a, z11, str, FeatureFlagValueType.CLIENT_OVERRIDE));
    }

    public final void b(boolean z11, String str) {
        this.f34246f.set(new c(this.f34241a, z11, str, FeatureFlagValueType.LOCAL_OVERRIDE));
    }

    public final void c(boolean z11, String str) {
        this.f34244d.set(new c(this.f34241a, z11, str, FeatureFlagValueType.REMOTE));
    }
}
