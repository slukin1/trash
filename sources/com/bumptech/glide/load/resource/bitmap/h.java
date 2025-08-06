package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;
import java.io.File;

public final class h {

    /* renamed from: f  reason: collision with root package name */
    public static final File f64095f = new File("/proc/self/fd");

    /* renamed from: g  reason: collision with root package name */
    public static volatile h f64096g;

    /* renamed from: a  reason: collision with root package name */
    public final boolean f64097a = d();

    /* renamed from: b  reason: collision with root package name */
    public final int f64098b;

    /* renamed from: c  reason: collision with root package name */
    public final int f64099c;

    /* renamed from: d  reason: collision with root package name */
    public int f64100d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f64101e = true;

    public h() {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f64098b = 20000;
            this.f64099c = 0;
            return;
        }
        this.f64098b = 700;
        this.f64099c = 128;
    }

    public static h a() {
        if (f64096g == null) {
            synchronized (h.class) {
                if (f64096g == null) {
                    f64096g = new h();
                }
            }
        }
        return f64096g;
    }

    public static boolean d() {
        String str = Build.MODEL;
        if (str == null || str.length() < 7) {
            return true;
        }
        String substring = str.substring(0, 7);
        substring.hashCode();
        char c11 = 65535;
        switch (substring.hashCode()) {
            case -1398613787:
                if (substring.equals("SM-A520")) {
                    c11 = 0;
                    break;
                }
                break;
            case -1398431166:
                if (substring.equals("SM-G930")) {
                    c11 = 1;
                    break;
                }
                break;
            case -1398431161:
                if (substring.equals("SM-G935")) {
                    c11 = 2;
                    break;
                }
                break;
            case -1398431073:
                if (substring.equals("SM-G960")) {
                    c11 = 3;
                    break;
                }
                break;
            case -1398431068:
                if (substring.equals("SM-G965")) {
                    c11 = 4;
                    break;
                }
                break;
            case -1398343746:
                if (substring.equals("SM-J720")) {
                    c11 = 5;
                    break;
                }
                break;
            case -1398222624:
                if (substring.equals("SM-N935")) {
                    c11 = 6;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                if (Build.VERSION.SDK_INT != 26) {
                    return true;
                }
                return false;
            default:
                return true;
        }
    }

    public final synchronized boolean b() {
        boolean z11 = true;
        int i11 = this.f64100d + 1;
        this.f64100d = i11;
        if (i11 >= 50) {
            this.f64100d = 0;
            int length = f64095f.list().length;
            if (length >= this.f64098b) {
                z11 = false;
            }
            this.f64101e = z11;
            if (!z11 && Log.isLoggable("Downsampler", 5)) {
                Log.w("Downsampler", "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors " + length + ", limit " + this.f64098b);
            }
        }
        return this.f64101e;
    }

    public boolean c(int i11, int i12, boolean z11, boolean z12) {
        int i13;
        if (!z11 || !this.f64097a || Build.VERSION.SDK_INT < 26 || z12 || i11 < (i13 = this.f64099c) || i12 < i13 || !b()) {
            return false;
        }
        return true;
    }

    @TargetApi(26)
    public boolean e(int i11, int i12, BitmapFactory.Options options, boolean z11, boolean z12) {
        boolean c11 = c(i11, i12, z11, z12);
        if (c11) {
            options.inPreferredConfig = Bitmap.Config.HARDWARE;
            options.inMutable = false;
        }
        return c11;
    }
}
