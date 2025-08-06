package com.tencent.thumbplayer.tcmedia.utils;

import android.os.SystemClock;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private long f49695a;

    /* renamed from: b  reason: collision with root package name */
    private long f49696b;

    public void a() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.f49695a = elapsedRealtime;
        this.f49696b = elapsedRealtime;
    }

    public void b() {
        this.f49696b = SystemClock.elapsedRealtime();
    }

    public long c() {
        return SystemClock.elapsedRealtime() - this.f49696b;
    }

    public long d() {
        return SystemClock.elapsedRealtime() - this.f49695a;
    }

    public long e() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j11 = elapsedRealtime - this.f49696b;
        this.f49696b = elapsedRealtime;
        return j11;
    }
}
