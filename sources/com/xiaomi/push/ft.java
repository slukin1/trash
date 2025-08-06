package com.xiaomi.push;

import android.os.Bundle;
import android.os.Parcelable;
import com.huobi.points.entity.PointsPack;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ft {

    /* renamed from: a  reason: collision with root package name */
    private int f51844a;

    /* renamed from: a  reason: collision with other field name */
    private String f2882a;

    /* renamed from: a  reason: collision with other field name */
    private List<fm> f2883a = null;

    /* renamed from: b  reason: collision with root package name */
    private String f51845b;

    /* renamed from: c  reason: collision with root package name */
    private String f51846c;

    /* renamed from: d  reason: collision with root package name */
    private String f51847d;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f51848a = new a("internal-server-error");

        /* renamed from: b  reason: collision with root package name */
        public static final a f51849b = new a(PointsPack.PURCHASABLE_TYPE_FORBIDDEN);

        /* renamed from: c  reason: collision with root package name */
        public static final a f51850c = new a("bad-request");

        /* renamed from: d  reason: collision with root package name */
        public static final a f51851d = new a("conflict");

        /* renamed from: e  reason: collision with root package name */
        public static final a f51852e = new a("feature-not-implemented");

        /* renamed from: f  reason: collision with root package name */
        public static final a f51853f = new a("gone");

        /* renamed from: g  reason: collision with root package name */
        public static final a f51854g = new a("item-not-found");

        /* renamed from: h  reason: collision with root package name */
        public static final a f51855h = new a("jid-malformed");

        /* renamed from: i  reason: collision with root package name */
        public static final a f51856i = new a("not-acceptable");

        /* renamed from: j  reason: collision with root package name */
        public static final a f51857j = new a("not-allowed");

        /* renamed from: k  reason: collision with root package name */
        public static final a f51858k = new a("not-authorized");

        /* renamed from: l  reason: collision with root package name */
        public static final a f51859l = new a("payment-required");

        /* renamed from: m  reason: collision with root package name */
        public static final a f51860m = new a("recipient-unavailable");

        /* renamed from: n  reason: collision with root package name */
        public static final a f51861n = new a("redirect");

        /* renamed from: o  reason: collision with root package name */
        public static final a f51862o = new a("registration-required");

        /* renamed from: p  reason: collision with root package name */
        public static final a f51863p = new a("remote-server-error");

        /* renamed from: q  reason: collision with root package name */
        public static final a f51864q = new a("remote-server-not-found");

        /* renamed from: r  reason: collision with root package name */
        public static final a f51865r = new a("remote-server-timeout");

        /* renamed from: s  reason: collision with root package name */
        public static final a f51866s = new a("resource-constraint");

        /* renamed from: t  reason: collision with root package name */
        public static final a f51867t = new a("service-unavailable");

        /* renamed from: u  reason: collision with root package name */
        public static final a f51868u = new a("subscription-required");

        /* renamed from: v  reason: collision with root package name */
        public static final a f51869v = new a("undefined-condition");

        /* renamed from: w  reason: collision with root package name */
        public static final a f51870w = new a("unexpected-request");

        /* renamed from: x  reason: collision with root package name */
        public static final a f51871x = new a("request-timeout");
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with other field name */
        public String f2884a;

        public a(String str) {
            this.f2884a = str;
        }

        public String toString() {
            return this.f2884a;
        }
    }

    public ft(a aVar) {
        a(aVar);
        this.f51847d = null;
    }

    private void a(a aVar) {
        this.f51845b = aVar.f2884a;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        String str = this.f51845b;
        if (str != null) {
            sb2.append(str);
        }
        sb2.append("(");
        sb2.append(this.f51844a);
        sb2.append(")");
        if (this.f51847d != null) {
            sb2.append(" ");
            sb2.append(this.f51847d);
        }
        return sb2.toString();
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        String str = this.f2882a;
        if (str != null) {
            bundle.putString("ext_err_type", str);
        }
        bundle.putInt("ext_err_code", this.f51844a);
        String str2 = this.f51846c;
        if (str2 != null) {
            bundle.putString("ext_err_reason", str2);
        }
        String str3 = this.f51845b;
        if (str3 != null) {
            bundle.putString("ext_err_cond", str3);
        }
        String str4 = this.f51847d;
        if (str4 != null) {
            bundle.putString("ext_err_msg", str4);
        }
        List<fm> list = this.f2883a;
        if (list != null) {
            Bundle[] bundleArr = new Bundle[list.size()];
            int i11 = 0;
            for (fm a11 : this.f2883a) {
                Bundle a12 = a11.a();
                if (a12 != null) {
                    bundleArr[i11] = a12;
                    i11++;
                }
            }
            bundle.putParcelableArray("ext_exts", bundleArr);
        }
        return bundle;
    }

    public ft(int i11, String str, String str2, String str3, String str4, List<fm> list) {
        this.f51844a = i11;
        this.f2882a = str;
        this.f51846c = str2;
        this.f51845b = str3;
        this.f51847d = str4;
        this.f2883a = list;
    }

    public ft(Bundle bundle) {
        this.f51844a = bundle.getInt("ext_err_code");
        if (bundle.containsKey("ext_err_type")) {
            this.f2882a = bundle.getString("ext_err_type");
        }
        this.f51845b = bundle.getString("ext_err_cond");
        this.f51846c = bundle.getString("ext_err_reason");
        this.f51847d = bundle.getString("ext_err_msg");
        Parcelable[] parcelableArray = bundle.getParcelableArray("ext_exts");
        if (parcelableArray != null) {
            this.f2883a = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                fm a11 = fm.a((Bundle) parcelable);
                if (a11 != null) {
                    this.f2883a.add(a11);
                }
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m2700a() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("<error code=\"");
        sb2.append(this.f51844a);
        sb2.append("\"");
        if (this.f2882a != null) {
            sb2.append(" type=\"");
            sb2.append(this.f2882a);
            sb2.append("\"");
        }
        if (this.f51846c != null) {
            sb2.append(" reason=\"");
            sb2.append(this.f51846c);
            sb2.append("\"");
        }
        sb2.append(">");
        if (this.f51845b != null) {
            sb2.append("<");
            sb2.append(this.f51845b);
            sb2.append(" xmlns=\"urn:ietf:params:xml:ns:xmpp-stanzas\"/>");
        }
        if (this.f51847d != null) {
            sb2.append("<text xml:lang=\"en\" xmlns=\"urn:ietf:params:xml:ns:xmpp-stanzas\">");
            sb2.append(this.f51847d);
            sb2.append("</text>");
        }
        for (fq d11 : a()) {
            sb2.append(d11.d());
        }
        sb2.append("</error>");
        return sb2.toString();
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized List<fm> m2701a() {
        List<fm> list = this.f2883a;
        if (list == null) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(list);
    }
}
