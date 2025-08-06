package com.sumsub.sns.internal.fingerprint.infoproviders;

import android.os.Build;
import kotlin.Result;
import kotlin.jvm.internal.Lambda;

public final class c0 implements b0 {

    public static final class a extends Lambda implements d10.a<String> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f34592a = new a();

        public a() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return Build.VERSION.RELEASE;
        }
    }

    public static final class b extends Lambda implements d10.a<String> {

        /* renamed from: a  reason: collision with root package name */
        public static final b f34593a = new b();

        public b() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return Build.FINGERPRINT;
        }
    }

    public static final class c extends Lambda implements d10.a<String> {

        /* renamed from: a  reason: collision with root package name */
        public static final c f34594a = new c();

        public c() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return System.getProperty("os.version");
        }
    }

    public static final class d extends Lambda implements d10.a<String> {

        /* renamed from: a  reason: collision with root package name */
        public static final d f34595a = new d();

        public d() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return Build.MANUFACTURER;
        }
    }

    public static final class e extends Lambda implements d10.a<String> {

        /* renamed from: a  reason: collision with root package name */
        public static final e f34596a = new e();

        public e() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return Build.MODEL;
        }
    }

    public static final class f extends Lambda implements d10.a<String> {

        /* renamed from: a  reason: collision with root package name */
        public static final f f34597a = new f();

        public f() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return String.valueOf(Build.VERSION.SDK_INT);
        }
    }

    public String a() {
        Object a11 = com.sumsub.sns.internal.fingerprint.tools.threading.safe.c.a(0, f.f34597a, 1, (Object) null);
        if (Result.m3078isFailureimpl(a11)) {
            a11 = "";
        }
        return (String) a11;
    }

    public String b() {
        Object a11 = com.sumsub.sns.internal.fingerprint.tools.threading.safe.c.a(0, b.f34593a, 1, (Object) null);
        if (Result.m3078isFailureimpl(a11)) {
            a11 = "";
        }
        return (String) a11;
    }

    public String c() {
        Object a11 = com.sumsub.sns.internal.fingerprint.tools.threading.safe.c.a(0, a.f34592a, 1, (Object) null);
        if (Result.m3078isFailureimpl(a11)) {
            a11 = "";
        }
        return (String) a11;
    }

    public String d() {
        Object a11 = com.sumsub.sns.internal.fingerprint.tools.threading.safe.c.a(0, c.f34594a, 1, (Object) null);
        if (Result.m3078isFailureimpl(a11)) {
            a11 = "";
        }
        return (String) a11;
    }

    public String e() {
        Object a11 = com.sumsub.sns.internal.fingerprint.tools.threading.safe.c.a(0, d.f34595a, 1, (Object) null);
        if (Result.m3078isFailureimpl(a11)) {
            a11 = "";
        }
        return (String) a11;
    }

    public String f() {
        Object a11 = com.sumsub.sns.internal.fingerprint.tools.threading.safe.c.a(0, e.f34596a, 1, (Object) null);
        if (Result.m3078isFailureimpl(a11)) {
            a11 = "";
        }
        return (String) a11;
    }
}
