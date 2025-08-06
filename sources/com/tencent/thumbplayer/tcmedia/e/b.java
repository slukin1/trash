package com.tencent.thumbplayer.tcmedia.e;

import android.text.TextUtils;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private String f49168a;

    /* renamed from: b  reason: collision with root package name */
    private String f49169b;

    /* renamed from: c  reason: collision with root package name */
    private String f49170c;

    /* renamed from: d  reason: collision with root package name */
    private String f49171d;

    /* renamed from: e  reason: collision with root package name */
    private String f49172e;

    public b(b bVar, String str) {
        this.f49168a = "";
        this.f49169b = "";
        this.f49170c = "";
        this.f49171d = "";
        this.f49172e = "TPLogger";
        a(bVar, str);
    }

    public b(String str) {
        this(str, "", "", "");
    }

    public b(String str, String str2, String str3, String str4) {
        this.f49168a = "";
        this.f49169b = "";
        this.f49170c = "";
        this.f49171d = "";
        this.f49172e = "TPLogger";
        this.f49168a = str;
        this.f49169b = str2;
        this.f49170c = str3;
        this.f49171d = str4;
        b();
    }

    private void b() {
        this.f49172e = this.f49168a;
        if (!TextUtils.isEmpty(this.f49169b)) {
            this.f49172e += "_C" + this.f49169b;
        }
        if (!TextUtils.isEmpty(this.f49170c)) {
            this.f49172e += "_T" + this.f49170c;
        }
        if (!TextUtils.isEmpty(this.f49171d)) {
            this.f49172e += "_" + this.f49171d;
        }
    }

    public String a() {
        return this.f49172e;
    }

    public void a(b bVar, String str) {
        String str2;
        if (bVar != null) {
            this.f49168a = bVar.f49168a;
            this.f49169b = bVar.f49169b;
            str2 = bVar.f49170c;
        } else {
            str2 = "";
            this.f49168a = str2;
            this.f49169b = str2;
        }
        this.f49170c = str2;
        this.f49171d = str;
        b();
    }

    public void a(String str) {
        this.f49170c = str;
        b();
    }

    public String toString() {
        return "TPLoggerContext{prefix='" + this.f49168a + '\'' + ", classId='" + this.f49169b + '\'' + ", taskId='" + this.f49170c + '\'' + ", model='" + this.f49171d + '\'' + ", tag='" + this.f49172e + '\'' + '}';
    }
}
