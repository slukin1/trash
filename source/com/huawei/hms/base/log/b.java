package com.huawei.hms.base.log;

import android.content.Context;
import android.util.Log;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private int f37827a = 4;

    /* renamed from: b  reason: collision with root package name */
    private String f37828b;

    /* renamed from: c  reason: collision with root package name */
    private d f37829c = new c();

    public void a(Context context, int i11, String str) {
        this.f37827a = i11;
        this.f37828b = str;
        this.f37829c.a(context, "HMSCore");
    }

    public void b(int i11, String str, String str2, Throwable th2) {
        try {
            if (a(i11)) {
                e a11 = a(i11, str, str2, th2);
                d dVar = this.f37829c;
                dVar.a(a11.c() + a11.a(), i11, str, str2 + 10 + Log.getStackTraceString(th2));
            }
        } catch (OutOfMemoryError unused) {
            b();
        }
    }

    public d a() {
        return this.f37829c;
    }

    public void a(d dVar) {
        this.f37829c = dVar;
    }

    private void b() {
        try {
            Log.e("HMSSDK_LogAdaptor", "log happened OOM error.");
        } catch (Throwable unused) {
        }
    }

    public boolean a(int i11) {
        return i11 >= this.f37827a;
    }

    public void a(int i11, String str, String str2) {
        try {
            if (a(i11)) {
                e a11 = a(i11, str, str2, (Throwable) null);
                this.f37829c.a(a11.c() + a11.a(), i11, str, str2);
            }
        } catch (OutOfMemoryError unused) {
            b();
        }
    }

    public void a(String str, String str2) {
        try {
            e a11 = a(4, str, str2, (Throwable) null);
            this.f37829c.a(a11.c() + 10 + a11.a(), 4, str, str2);
        } catch (OutOfMemoryError unused) {
            b();
        }
    }

    private e a(int i11, String str, String str2, Throwable th2) {
        e eVar = new e(8, this.f37828b, i11, str);
        eVar.a(str2);
        eVar.a(th2);
        return eVar;
    }
}
