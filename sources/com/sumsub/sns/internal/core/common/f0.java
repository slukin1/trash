package com.sumsub.sns.internal.core.common;

import kotlin.jvm.internal.r;

public abstract class f0 {

    /* renamed from: a  reason: collision with root package name */
    public final String f32058a;

    public static final class a extends f0 {

        /* renamed from: b  reason: collision with root package name */
        public static final a f32059b = new a();

        public a() {
            super("NFC disabled", (r) null);
        }
    }

    public static final class b extends f0 {

        /* renamed from: b  reason: collision with root package name */
        public static final b f32060b = new b();

        public b() {
            super("NFC enabled", (r) null);
        }
    }

    public static final class c extends f0 {

        /* renamed from: b  reason: collision with root package name */
        public final Throwable f32061b;

        public c(Throwable th2) {
            super("NFC Error", (r) null);
            this.f32061b = th2;
        }

        public final Throwable b() {
            return this.f32061b;
        }
    }

    public static final class d extends f0 {

        /* renamed from: b  reason: collision with root package name */
        public static final d f32062b = new d();

        public d() {
            super("Device has no NFC onboard", (r) null);
        }
    }

    public /* synthetic */ f0(String str, r rVar) {
        this(str);
    }

    public final String a() {
        return this.f32058a;
    }

    public f0(String str) {
        this.f32058a = str;
    }
}
