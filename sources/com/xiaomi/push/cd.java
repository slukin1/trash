package com.xiaomi.push;

import android.text.TextUtils;
import com.hbg.lib.network.pro.core.util.Period;
import com.huobi.vulcan.model.VulcanInfo;
import com.twitter.sdk.android.core.identity.AuthHandler;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class cd {

    /* renamed from: a  reason: collision with root package name */
    private double f51481a = 0.1d;

    /* renamed from: a  reason: collision with other field name */
    private long f2593a;

    /* renamed from: a  reason: collision with other field name */
    public String f2594a = "";

    /* renamed from: a  reason: collision with other field name */
    private ArrayList<ck> f2595a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private long f51482b = Period.DAY_MILLS;

    /* renamed from: b  reason: collision with other field name */
    public String f2596b;

    /* renamed from: c  reason: collision with root package name */
    public String f51483c;

    /* renamed from: d  reason: collision with root package name */
    public String f51484d;

    /* renamed from: e  reason: collision with root package name */
    public String f51485e;

    /* renamed from: f  reason: collision with root package name */
    public String f51486f;

    /* renamed from: g  reason: collision with root package name */
    public String f51487g;

    /* renamed from: h  reason: collision with root package name */
    public String f51488h;

    /* renamed from: i  reason: collision with root package name */
    private String f51489i;

    /* renamed from: j  reason: collision with root package name */
    private String f51490j = "s.mi1.cc";

    public cd(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f2593a = System.currentTimeMillis();
            this.f2595a.add(new ck(str, -1));
            this.f2594a = ch.a();
            this.f2596b = str;
            return;
        }
        throw new IllegalArgumentException("the host is empty");
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2476a() {
        return TextUtils.equals(this.f2594a, ch.a());
    }

    public boolean b() {
        return System.currentTimeMillis() - this.f2593a < this.f51482b;
    }

    public boolean c() {
        long j11 = this.f51482b;
        if (864000000 >= j11) {
            j11 = 864000000;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j12 = this.f2593a;
        return currentTimeMillis - j12 > j11 || (currentTimeMillis - j12 > this.f51482b && this.f2594a.startsWith("WIFI-"));
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f2594a);
        sb2.append("\n");
        sb2.append(a());
        Iterator<ck> it2 = this.f2595a.iterator();
        while (it2.hasNext()) {
            sb2.append("\n");
            sb2.append(it2.next().toString());
        }
        sb2.append("\n");
        return sb2.toString();
    }

    public boolean a(cd cdVar) {
        return TextUtils.equals(this.f2594a, cdVar.f2594a);
    }

    public void b(String str, long j11, long j12) {
        a(str, 0, j11, j12, (Exception) null);
    }

    public void a(long j11) {
        if (j11 > 0) {
            this.f51482b = j11;
            return;
        }
        throw new IllegalArgumentException("the duration is invalid " + j11);
    }

    public void b(String str, long j11, long j12, Exception exc) {
        a(str, -1, j11, j12, exc);
    }

    public void b(String str) {
        this.f51490j = str;
    }

    private synchronized void c(String str) {
        Iterator<ck> it2 = this.f2595a.iterator();
        while (it2.hasNext()) {
            if (TextUtils.equals(it2.next().f2612a, str)) {
                it2.remove();
            }
        }
    }

    public ArrayList<String> a(String str) {
        if (!TextUtils.isEmpty(str)) {
            URL url = new URL(str);
            if (TextUtils.equals(url.getHost(), this.f2596b)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<String> it2 = a(true).iterator();
                while (it2.hasNext()) {
                    cf a11 = cf.a(it2.next(), url.getPort());
                    arrayList.add(new URL(url.getProtocol(), a11.a(), a11.a(), url.getFile()).toString());
                }
                return arrayList;
            }
            throw new IllegalArgumentException("the url is not supported by the fallback");
        }
        throw new IllegalArgumentException("the url is empty.");
    }

    public void a(String str, long j11, long j12) {
        try {
            b(new URL(str).getHost(), j11, j12);
        } catch (MalformedURLException unused) {
        }
    }

    public void a(String str, long j11, long j12, Exception exc) {
        try {
            b(new URL(str).getHost(), j11, j12, exc);
        } catch (MalformedURLException unused) {
        }
    }

    public void a(String str, int i11, long j11, long j12, Exception exc) {
        a(str, new cc(i11, j11, j12, exc));
    }

    public synchronized void a(String str, cc ccVar) {
        Iterator<ck> it2 = this.f2595a.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            ck next = it2.next();
            if (TextUtils.equals(str, next.f2612a)) {
                next.a(ccVar);
                break;
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized ArrayList<String> m2473a() {
        return a(false);
    }

    public synchronized ArrayList<String> a(boolean z11) {
        ArrayList<String> arrayList;
        int size = this.f2595a.size();
        ck[] ckVarArr = new ck[size];
        this.f2595a.toArray(ckVarArr);
        Arrays.sort(ckVarArr);
        arrayList = new ArrayList<>();
        for (int i11 = 0; i11 < size; i11++) {
            ck ckVar = ckVarArr[i11];
            if (z11) {
                arrayList.add(ckVar.f2612a);
            } else {
                int indexOf = ckVar.f2612a.indexOf(":");
                if (indexOf != -1) {
                    arrayList.add(ckVar.f2612a.substring(0, indexOf));
                } else {
                    arrayList.add(ckVar.f2612a);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m2475a(String str) {
        a(new ck(str));
    }

    public synchronized void a(ck ckVar) {
        c(ckVar.f2612a);
        this.f2595a.add(ckVar);
    }

    public synchronized void a(String[] strArr) {
        int i11;
        int size = this.f2595a.size() - 1;
        while (true) {
            i11 = 0;
            if (size < 0) {
                break;
            }
            int length = strArr.length;
            while (true) {
                if (i11 >= length) {
                    break;
                }
                if (TextUtils.equals(this.f2595a.get(size).f2612a, strArr[i11])) {
                    this.f2595a.remove(size);
                    break;
                }
                i11++;
            }
            size--;
        }
        Iterator<ck> it2 = this.f2595a.iterator();
        int i12 = 0;
        while (it2.hasNext()) {
            int i13 = it2.next().f51501a;
            if (i13 > i12) {
                i12 = i13;
            }
        }
        while (i11 < strArr.length) {
            a(new ck(strArr[i11], (strArr.length + i12) - i11));
            i11++;
        }
    }

    public synchronized String a() {
        if (!TextUtils.isEmpty(this.f51489i)) {
            return this.f51489i;
        } else if (TextUtils.isEmpty(this.f51485e)) {
            return "hardcode_isp";
        } else {
            String a11 = bc.a((Object[]) new String[]{this.f51485e, this.f51483c, this.f51484d, this.f51487g, this.f51486f}, "_");
            this.f51489i = a11;
            return a11;
        }
    }

    public void a(double d11) {
        this.f51481a = d11;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized JSONObject m2474a() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put("net", this.f2594a);
        jSONObject.put("ttl", this.f51482b);
        jSONObject.put("pct", this.f51481a);
        jSONObject.put(AuthHandler.EXTRA_TOKEN_SECRET, this.f2593a);
        jSONObject.put("city", this.f51484d);
        jSONObject.put("prv", this.f51483c);
        jSONObject.put("cty", this.f51487g);
        jSONObject.put("isp", this.f51485e);
        jSONObject.put("ip", this.f51486f);
        jSONObject.put(VulcanInfo.HOST, this.f2596b);
        jSONObject.put("xf", this.f51488h);
        JSONArray jSONArray = new JSONArray();
        Iterator<ck> it2 = this.f2595a.iterator();
        while (it2.hasNext()) {
            jSONArray.put(it2.next().a());
        }
        jSONObject.put("fbs", jSONArray);
        return jSONObject;
    }

    public synchronized cd a(JSONObject jSONObject) {
        this.f2594a = jSONObject.optString("net");
        this.f51482b = jSONObject.getLong("ttl");
        this.f51481a = jSONObject.getDouble("pct");
        this.f2593a = jSONObject.getLong(AuthHandler.EXTRA_TOKEN_SECRET);
        this.f51484d = jSONObject.optString("city");
        this.f51483c = jSONObject.optString("prv");
        this.f51487g = jSONObject.optString("cty");
        this.f51485e = jSONObject.optString("isp");
        this.f51486f = jSONObject.optString("ip");
        this.f2596b = jSONObject.optString(VulcanInfo.HOST);
        this.f51488h = jSONObject.optString("xf");
        JSONArray jSONArray = jSONObject.getJSONArray("fbs");
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            a(new ck().a(jSONArray.getJSONObject(i11)));
        }
        return this;
    }
}
