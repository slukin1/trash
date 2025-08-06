package com.huawei.hms.base.log;

import android.os.Process;
import android.util.Log;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private final StringBuilder f37831a = new StringBuilder();

    /* renamed from: b  reason: collision with root package name */
    private String f37832b;

    /* renamed from: c  reason: collision with root package name */
    private String f37833c = "HMS";

    /* renamed from: d  reason: collision with root package name */
    private int f37834d;

    /* renamed from: e  reason: collision with root package name */
    private long f37835e = 0;

    /* renamed from: f  reason: collision with root package name */
    private long f37836f = 0;

    /* renamed from: g  reason: collision with root package name */
    private String f37837g;

    /* renamed from: h  reason: collision with root package name */
    private int f37838h;

    /* renamed from: i  reason: collision with root package name */
    private int f37839i;

    /* renamed from: j  reason: collision with root package name */
    private int f37840j;

    public e(int i11, String str, int i12, String str2) {
        this.f37840j = i11;
        this.f37832b = str;
        this.f37834d = i12;
        if (str2 != null) {
            this.f37833c = str2;
        }
        b();
    }

    public static String a(int i11) {
        if (i11 == 3) {
            return "D";
        }
        if (i11 == 4) {
            return "I";
        }
        if (i11 != 5) {
            return i11 != 6 ? String.valueOf(i11) : "E";
        }
        return "W";
    }

    private e b() {
        this.f37835e = System.currentTimeMillis();
        Thread currentThread = Thread.currentThread();
        this.f37836f = currentThread.getId();
        this.f37838h = Process.myPid();
        StackTraceElement[] stackTrace = currentThread.getStackTrace();
        int length = stackTrace.length;
        int i11 = this.f37840j;
        if (length > i11) {
            StackTraceElement stackTraceElement = stackTrace[i11];
            this.f37837g = stackTraceElement.getFileName();
            this.f37839i = stackTraceElement.getLineNumber();
        }
        return this;
    }

    public String c() {
        StringBuilder sb2 = new StringBuilder();
        b(sb2);
        return sb2.toString();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        b(sb2);
        a(sb2);
        return sb2.toString();
    }

    public <T> e a(T t11) {
        this.f37831a.append(t11);
        return this;
    }

    public e a(Throwable th2) {
        a(10).a(Log.getStackTraceString(th2));
        return this;
    }

    public String a() {
        StringBuilder sb2 = new StringBuilder();
        a(sb2);
        return sb2.toString();
    }

    private StringBuilder a(StringBuilder sb2) {
        sb2.append(' ');
        sb2.append(this.f37831a.toString());
        return sb2;
    }

    private StringBuilder b(StringBuilder sb2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault());
        sb2.append('[');
        sb2.append(simpleDateFormat.format(Long.valueOf(this.f37835e)));
        String a11 = a(this.f37834d);
        sb2.append(' ');
        sb2.append(a11);
        sb2.append('/');
        sb2.append(this.f37833c);
        sb2.append('/');
        sb2.append(this.f37832b);
        sb2.append(' ');
        sb2.append(this.f37838h);
        sb2.append(':');
        sb2.append(this.f37836f);
        sb2.append(' ');
        sb2.append(this.f37837g);
        sb2.append(':');
        sb2.append(this.f37839i);
        sb2.append(']');
        return sb2;
    }
}
