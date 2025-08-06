package com.xiaomi.push;

import android.os.Bundle;
import java.util.HashMap;
import java.util.Map;

public class fn extends fp {

    /* renamed from: a  reason: collision with root package name */
    private a f51801a = a.f51802a;

    /* renamed from: a  reason: collision with other field name */
    private final Map<String, String> f2869a = new HashMap();

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f51802a = new a("get");

        /* renamed from: b  reason: collision with root package name */
        public static final a f51803b = new a("set");

        /* renamed from: c  reason: collision with root package name */
        public static final a f51804c = new a("result");

        /* renamed from: d  reason: collision with root package name */
        public static final a f51805d = new a("error");

        /* renamed from: e  reason: collision with root package name */
        public static final a f51806e = new a("command");

        /* renamed from: a  reason: collision with other field name */
        private String f2870a;

        private a(String str) {
            this.f2870a = str;
        }

        public static a a(String str) {
            if (str == null) {
                return null;
            }
            String lowerCase = str.toLowerCase();
            a aVar = f51802a;
            if (aVar.toString().equals(lowerCase)) {
                return aVar;
            }
            a aVar2 = f51803b;
            if (aVar2.toString().equals(lowerCase)) {
                return aVar2;
            }
            a aVar3 = f51805d;
            if (aVar3.toString().equals(lowerCase)) {
                return aVar3;
            }
            a aVar4 = f51804c;
            if (aVar4.toString().equals(lowerCase)) {
                return aVar4;
            }
            a aVar5 = f51806e;
            if (aVar5.toString().equals(lowerCase)) {
                return aVar5;
            }
            return null;
        }

        public String toString() {
            return this.f2870a;
        }
    }

    public fn() {
    }

    public synchronized void a(Map<String, String> map) {
        this.f2869a.putAll(map);
    }

    public String b() {
        return null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public a m2692a() {
        return this.f51801a;
    }

    public fn(Bundle bundle) {
        super(bundle);
        if (bundle.containsKey("ext_iq_type")) {
            this.f51801a = a.a(bundle.getString("ext_iq_type"));
        }
    }

    public void a(a aVar) {
        if (aVar == null) {
            this.f51801a = a.f51802a;
        } else {
            this.f51801a = aVar;
        }
    }

    public Bundle a() {
        Bundle a11 = super.a();
        a aVar = this.f51801a;
        if (aVar != null) {
            a11.putString("ext_iq_type", aVar.toString());
        }
        return a11;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m2693a() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("<iq ");
        if (j() != null) {
            sb2.append("id=\"" + j() + "\" ");
        }
        if (l() != null) {
            sb2.append("to=\"");
            sb2.append(fy.a(l()));
            sb2.append("\" ");
        }
        if (m() != null) {
            sb2.append("from=\"");
            sb2.append(fy.a(m()));
            sb2.append("\" ");
        }
        if (k() != null) {
            sb2.append("chid=\"");
            sb2.append(fy.a(k()));
            sb2.append("\" ");
        }
        for (Map.Entry next : this.f2869a.entrySet()) {
            sb2.append(fy.a((String) next.getKey()));
            sb2.append("=\"");
            sb2.append(fy.a((String) next.getValue()));
            sb2.append("\" ");
        }
        if (this.f51801a == null) {
            sb2.append("type=\"get\">");
        } else {
            sb2.append("type=\"");
            sb2.append(a());
            sb2.append("\">");
        }
        String b11 = b();
        if (b11 != null) {
            sb2.append(b11);
        }
        sb2.append(o());
        ft a11 = a();
        if (a11 != null) {
            sb2.append(a11.a());
        }
        sb2.append("</iq>");
        return sb2.toString();
    }
}
