package com.dianping.logan;

import android.text.TextUtils;
import com.hbg.lib.network.pro.core.util.Period;

public class LoganConfig {

    /* renamed from: a  reason: collision with root package name */
    public String f64825a;

    /* renamed from: b  reason: collision with root package name */
    public String f64826b;

    /* renamed from: c  reason: collision with root package name */
    public long f64827c;

    /* renamed from: d  reason: collision with root package name */
    public long f64828d;

    /* renamed from: e  reason: collision with root package name */
    public long f64829e;

    /* renamed from: f  reason: collision with root package name */
    public long f64830f;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f64831g;

    /* renamed from: h  reason: collision with root package name */
    public byte[] f64832h;

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        public String f64833a;

        /* renamed from: b  reason: collision with root package name */
        public String f64834b;

        /* renamed from: c  reason: collision with root package name */
        public long f64835c = 10485760;

        /* renamed from: d  reason: collision with root package name */
        public long f64836d = Period.WEEK_MILLS;

        /* renamed from: e  reason: collision with root package name */
        public byte[] f64837e;

        /* renamed from: f  reason: collision with root package name */
        public byte[] f64838f;

        /* renamed from: g  reason: collision with root package name */
        public long f64839g = 52428800;

        public LoganConfig a() {
            LoganConfig loganConfig = new LoganConfig();
            loganConfig.i(this.f64833a);
            loganConfig.o(this.f64834b);
            loganConfig.m(this.f64835c);
            loganConfig.n(this.f64839g);
            loganConfig.j(this.f64836d);
            loganConfig.l(this.f64837e);
            loganConfig.k(this.f64838f);
            return loganConfig;
        }

        public Builder b(String str) {
            this.f64833a = str;
            return this;
        }

        public Builder c(long j11) {
            this.f64836d = j11 * Period.DAY_MILLS;
            return this;
        }

        public Builder d(byte[] bArr) {
            this.f64838f = bArr;
            return this;
        }

        public Builder e(byte[] bArr) {
            this.f64837e = bArr;
            return this;
        }

        public Builder f(long j11) {
            this.f64835c = j11 * 1048576;
            return this;
        }

        public Builder g(String str) {
            this.f64834b = str;
            return this;
        }
    }

    public boolean h() {
        return !TextUtils.isEmpty(this.f64825a) && !TextUtils.isEmpty(this.f64826b) && this.f64831g != null && this.f64832h != null;
    }

    public final void i(String str) {
        this.f64825a = str;
    }

    public final void j(long j11) {
        this.f64828d = j11;
    }

    public final void k(byte[] bArr) {
        this.f64832h = bArr;
    }

    public final void l(byte[] bArr) {
        this.f64831g = bArr;
    }

    public final void m(long j11) {
        this.f64827c = j11;
    }

    public final void n(long j11) {
        this.f64830f = j11;
    }

    public final void o(String str) {
        this.f64826b = str;
    }

    public LoganConfig() {
        this.f64827c = 10485760;
        this.f64828d = Period.WEEK_MILLS;
        this.f64829e = 500;
        this.f64830f = 52428800;
    }
}
