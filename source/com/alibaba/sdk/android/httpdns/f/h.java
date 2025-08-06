package com.alibaba.sdk.android.httpdns.f;

import com.huobi.vulcan.model.VulcanInfo;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONObject;
import w2.a;

public class h {

    /* renamed from: a  reason: collision with root package name */
    public String f14595a;

    /* renamed from: b  reason: collision with root package name */
    public String[] f14596b;

    /* renamed from: c  reason: collision with root package name */
    public String[] f14597c;

    /* renamed from: d  reason: collision with root package name */
    public int f14598d;

    /* renamed from: e  reason: collision with root package name */
    public String f14599e;

    public h(String str, String[] strArr, String[] strArr2, int i11, String str2) {
        this.f14595a = str;
        if (strArr != null) {
            this.f14596b = strArr;
        } else {
            this.f14596b = new String[0];
        }
        if (strArr2 != null) {
            this.f14597c = strArr2;
        } else {
            this.f14597c = new String[0];
        }
        if (i11 > 0) {
            this.f14598d = i11;
        } else {
            this.f14598d = 60;
        }
        this.f14599e = str2;
    }

    public static h b(String str) {
        String[] strArr;
        String[] strArr2;
        JSONArray jSONArray;
        JSONObject jSONObject = new JSONObject(str);
        String string = jSONObject.getString(VulcanInfo.HOST);
        String str2 = null;
        try {
            int i11 = 0;
            if (jSONObject.has("ips")) {
                JSONArray jSONArray2 = jSONObject.getJSONArray("ips");
                int length = jSONArray2.length();
                strArr = new String[length];
                int i12 = 0;
                while (i12 < length) {
                    try {
                        strArr[i12] = jSONArray2.getString(i12);
                        i12++;
                    } catch (Exception e11) {
                        e = e11;
                        strArr2 = null;
                        e.printStackTrace();
                        return new h(string, strArr, strArr2, jSONObject.getInt("ttl"), str2);
                    }
                }
            } else {
                strArr = null;
            }
            if (!jSONObject.has("ipsv6") || (jSONArray = jSONObject.getJSONArray("ipsv6")) == null || jSONArray.length() == 0) {
                strArr2 = null;
            } else {
                strArr2 = new String[jSONArray.length()];
                while (i11 < jSONArray.length()) {
                    try {
                        strArr2[i11] = jSONArray.getString(i11);
                        i11++;
                    } catch (Exception e12) {
                        e = e12;
                        e.printStackTrace();
                        return new h(string, strArr, strArr2, jSONObject.getInt("ttl"), str2);
                    }
                }
            }
            if (jSONObject.has("extra")) {
                str2 = jSONObject.getString("extra");
            }
        } catch (Exception e13) {
            e = e13;
            strArr2 = null;
            strArr = null;
            e.printStackTrace();
            return new h(string, strArr, strArr2, jSONObject.getInt("ttl"), str2);
        }
        return new h(string, strArr, strArr2, jSONObject.getInt("ttl"), str2);
    }

    public int a() {
        return this.f14598d;
    }

    public String[] c() {
        return this.f14597c;
    }

    public String d() {
        return this.f14599e;
    }

    public String[] e() {
        return this.f14596b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        h hVar = (h) obj;
        return this.f14598d == hVar.f14598d && this.f14595a.equals(hVar.f14595a) && Arrays.equals(this.f14596b, hVar.f14596b) && Arrays.equals(this.f14597c, hVar.f14597c) && a.m(this.f14599e, hVar.f14599e);
    }

    public int hashCode() {
        return (((Arrays.hashCode(new Object[]{this.f14595a, Integer.valueOf(this.f14598d), this.f14599e}) * 31) + Arrays.hashCode(this.f14596b)) * 31) + Arrays.hashCode(this.f14597c);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("host: ");
        sb2.append(this.f14595a);
        sb2.append(" ip cnt: ");
        String[] strArr = this.f14596b;
        sb2.append(strArr != null ? strArr.length : 0);
        sb2.append(" ttl: ");
        sb2.append(this.f14598d);
        String sb3 = sb2.toString();
        if (this.f14596b != null) {
            for (int i11 = 0; i11 < this.f14596b.length; i11++) {
                sb3 = sb3 + "\n ip: " + this.f14596b[i11];
            }
        }
        StringBuilder sb4 = new StringBuilder();
        sb4.append(sb3);
        sb4.append("\n ipv6 cnt: ");
        String[] strArr2 = this.f14597c;
        sb4.append(strArr2 != null ? strArr2.length : 0);
        String sb5 = sb4.toString();
        if (this.f14597c != null) {
            for (int i12 = 0; i12 < this.f14597c.length; i12++) {
                sb5 = sb5 + "\n ipv6: " + this.f14597c[i12];
            }
        }
        return sb5 + "\n extra: " + this.f14599e;
    }
}
