package com.xiaomi.push;

import android.os.Bundle;
import android.text.TextUtils;

public class fo extends fp {

    /* renamed from: a  reason: collision with root package name */
    private boolean f51807a = false;

    /* renamed from: b  reason: collision with root package name */
    private String f51808b = null;

    /* renamed from: b  reason: collision with other field name */
    private boolean f2871b = false;

    /* renamed from: c  reason: collision with root package name */
    private String f51809c = null;

    /* renamed from: d  reason: collision with root package name */
    private String f51810d;

    /* renamed from: e  reason: collision with root package name */
    private String f51811e;

    /* renamed from: f  reason: collision with root package name */
    private String f51812f;

    /* renamed from: g  reason: collision with root package name */
    private String f51813g;

    /* renamed from: h  reason: collision with root package name */
    private String f51814h;

    /* renamed from: i  reason: collision with root package name */
    private String f51815i = "";

    /* renamed from: j  reason: collision with root package name */
    private String f51816j = "";

    /* renamed from: k  reason: collision with root package name */
    private String f51817k = "";

    /* renamed from: l  reason: collision with root package name */
    private String f51818l = "";

    public fo() {
    }

    public void a(boolean z11) {
        this.f51807a = z11;
    }

    public String b() {
        return this.f51808b;
    }

    public String c() {
        return this.f51814h;
    }

    public String d() {
        return this.f51815i;
    }

    public String e() {
        return this.f51816j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        fo foVar = (fo) obj;
        if (!super.equals(foVar)) {
            return false;
        }
        String str = this.f51812f;
        if (str == null ? foVar.f51812f != null : !str.equals(foVar.f51812f)) {
            return false;
        }
        String str2 = this.f51810d;
        if (str2 == null ? foVar.f51810d != null : !str2.equals(foVar.f51810d)) {
            return false;
        }
        String str3 = this.f51811e;
        if (str3 == null ? foVar.f51811e != null : !str3.equals(foVar.f51811e)) {
            return false;
        }
        String str4 = this.f51809c;
        if (str4 == null ? foVar.f51809c != null : !str4.equals(foVar.f51809c)) {
            return false;
        }
        if (this.f51808b == foVar.f51808b) {
            return true;
        }
        return false;
    }

    public String f() {
        return this.f51817k;
    }

    public String g() {
        return this.f51818l;
    }

    public void h(String str) {
        this.f51812f = str;
    }

    public int hashCode() {
        String str = this.f51808b;
        int i11 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f51812f;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f51809c;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f51810d;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f51811e;
        if (str5 != null) {
            i11 = str5.hashCode();
        }
        return hashCode4 + i11;
    }

    public void i(String str) {
        this.f51809c = str;
    }

    public void j(String str) {
        this.f51810d = str;
    }

    public void a(String str) {
        this.f51814h = str;
    }

    public void b(String str) {
        this.f51815i = str;
    }

    public void c(String str) {
        this.f51816j = str;
    }

    public void d(String str) {
        this.f51817k = str;
    }

    public void e(String str) {
        this.f51818l = str;
    }

    public void f(String str) {
        this.f51808b = str;
    }

    public void g(String str) {
        this.f51811e = str;
    }

    public String h() {
        return this.f51810d;
    }

    public void a(String str, String str2) {
        this.f51812f = str;
        this.f51813g = str2;
    }

    public void b(boolean z11) {
        this.f2871b = z11;
    }

    public Bundle a() {
        Bundle a11 = super.a();
        if (!TextUtils.isEmpty(this.f51808b)) {
            a11.putString("ext_msg_type", this.f51808b);
        }
        String str = this.f51810d;
        if (str != null) {
            a11.putString("ext_msg_lang", str);
        }
        String str2 = this.f51811e;
        if (str2 != null) {
            a11.putString("ext_msg_sub", str2);
        }
        String str3 = this.f51812f;
        if (str3 != null) {
            a11.putString("ext_msg_body", str3);
        }
        if (!TextUtils.isEmpty(this.f51813g)) {
            a11.putString("ext_body_encode", this.f51813g);
        }
        String str4 = this.f51809c;
        if (str4 != null) {
            a11.putString("ext_msg_thread", str4);
        }
        String str5 = this.f51814h;
        if (str5 != null) {
            a11.putString("ext_msg_appid", str5);
        }
        if (this.f51807a) {
            a11.putBoolean("ext_msg_trans", true);
        }
        if (!TextUtils.isEmpty(this.f51815i)) {
            a11.putString("ext_msg_seq", this.f51815i);
        }
        if (!TextUtils.isEmpty(this.f51816j)) {
            a11.putString("ext_msg_mseq", this.f51816j);
        }
        if (!TextUtils.isEmpty(this.f51817k)) {
            a11.putString("ext_msg_fseq", this.f51817k);
        }
        if (this.f2871b) {
            a11.putBoolean("ext_msg_encrypt", true);
        }
        if (!TextUtils.isEmpty(this.f51818l)) {
            a11.putString("ext_msg_status", this.f51818l);
        }
        return a11;
    }

    public fo(Bundle bundle) {
        super(bundle);
        this.f51808b = bundle.getString("ext_msg_type");
        this.f51810d = bundle.getString("ext_msg_lang");
        this.f51809c = bundle.getString("ext_msg_thread");
        this.f51811e = bundle.getString("ext_msg_sub");
        this.f51812f = bundle.getString("ext_msg_body");
        this.f51813g = bundle.getString("ext_body_encode");
        this.f51814h = bundle.getString("ext_msg_appid");
        this.f51807a = bundle.getBoolean("ext_msg_trans", false);
        this.f2871b = bundle.getBoolean("ext_msg_encrypt", false);
        this.f51815i = bundle.getString("ext_msg_seq");
        this.f51816j = bundle.getString("ext_msg_mseq");
        this.f51817k = bundle.getString("ext_msg_fseq");
        this.f51818l = bundle.getString("ext_msg_status");
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m2694a() {
        ft a11;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("<message");
        if (p() != null) {
            sb2.append(" xmlns=\"");
            sb2.append(p());
            sb2.append("\"");
        }
        if (this.f51810d != null) {
            sb2.append(" xml:lang=\"");
            sb2.append(h());
            sb2.append("\"");
        }
        if (j() != null) {
            sb2.append(" id=\"");
            sb2.append(j());
            sb2.append("\"");
        }
        if (l() != null) {
            sb2.append(" to=\"");
            sb2.append(fy.a(l()));
            sb2.append("\"");
        }
        if (!TextUtils.isEmpty(d())) {
            sb2.append(" seq=\"");
            sb2.append(d());
            sb2.append("\"");
        }
        if (!TextUtils.isEmpty(e())) {
            sb2.append(" mseq=\"");
            sb2.append(e());
            sb2.append("\"");
        }
        if (!TextUtils.isEmpty(f())) {
            sb2.append(" fseq=\"");
            sb2.append(f());
            sb2.append("\"");
        }
        if (!TextUtils.isEmpty(g())) {
            sb2.append(" status=\"");
            sb2.append(g());
            sb2.append("\"");
        }
        if (m() != null) {
            sb2.append(" from=\"");
            sb2.append(fy.a(m()));
            sb2.append("\"");
        }
        if (k() != null) {
            sb2.append(" chid=\"");
            sb2.append(fy.a(k()));
            sb2.append("\"");
        }
        if (this.f51807a) {
            sb2.append(" transient=\"true\"");
        }
        if (!TextUtils.isEmpty(this.f51814h)) {
            sb2.append(" appid=\"");
            sb2.append(c());
            sb2.append("\"");
        }
        if (!TextUtils.isEmpty(this.f51808b)) {
            sb2.append(" type=\"");
            sb2.append(this.f51808b);
            sb2.append("\"");
        }
        if (this.f2871b) {
            sb2.append(" s=\"1\"");
        }
        sb2.append(">");
        if (this.f51811e != null) {
            sb2.append("<subject>");
            sb2.append(fy.a(this.f51811e));
            sb2.append("</subject>");
        }
        if (this.f51812f != null) {
            sb2.append("<body");
            if (!TextUtils.isEmpty(this.f51813g)) {
                sb2.append(" encode=\"");
                sb2.append(this.f51813g);
                sb2.append("\"");
            }
            sb2.append(">");
            sb2.append(fy.a(this.f51812f));
            sb2.append("</body>");
        }
        if (this.f51809c != null) {
            sb2.append("<thread>");
            sb2.append(this.f51809c);
            sb2.append("</thread>");
        }
        if ("error".equalsIgnoreCase(this.f51808b) && (a11 = a()) != null) {
            sb2.append(a11.a());
        }
        sb2.append(o());
        sb2.append("</message>");
        return sb2.toString();
    }
}
