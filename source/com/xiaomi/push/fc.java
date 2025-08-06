package com.xiaomi.push;

import java.util.Map;

public class fc implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public static String f51775a = "wcc-ml-test10.bj";

    /* renamed from: b  reason: collision with root package name */
    public static String f51776b;

    /* renamed from: a  reason: collision with other field name */
    private int f2854a;

    /* renamed from: a  reason: collision with other field name */
    private ff f2855a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f2856a = fb.f2839a;

    /* renamed from: b  reason: collision with other field name */
    private boolean f2857b = true;

    /* renamed from: c  reason: collision with root package name */
    private String f51777c;

    /* renamed from: d  reason: collision with root package name */
    private String f51778d;

    /* renamed from: e  reason: collision with root package name */
    private String f51779e;

    public fc(Map<String, Integer> map, int i11, String str, ff ffVar) {
        a(map, i11, str, ffVar);
    }

    public static final String a() {
        String str = f51776b;
        if (str != null) {
            return str;
        }
        if (y.a()) {
            return "sandbox.xmpush.xiaomi.com";
        }
        return y.b() ? "10.38.162.35" : "app.chat.xiaomi.net";
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m2681a() {
        return null;
    }

    public void b(String str) {
        this.f51779e = str;
    }

    public String c() {
        if (this.f51778d == null) {
            this.f51778d = a();
        }
        return this.f51778d;
    }

    public String b() {
        return this.f51779e;
    }

    public static final void a(String str) {
        if (!y.b()) {
            f51776b = str;
        }
    }

    public void c(String str) {
        this.f51778d = str;
    }

    private void a(Map<String, Integer> map, int i11, String str, ff ffVar) {
        this.f2854a = i11;
        this.f51777c = str;
        this.f2855a = ffVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public int m2679a() {
        return this.f2854a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2680a() {
        return this.f2856a;
    }

    public void a(boolean z11) {
        this.f2856a = z11;
    }
}
