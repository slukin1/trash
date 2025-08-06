package com.alibaba.sdk.android.httpdns.f;

import com.huobi.vulcan.model.VulcanInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class m {

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, a> f14632a = new HashMap<>();

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f14633a;

        /* renamed from: b  reason: collision with root package name */
        public String[] f14634b;

        /* renamed from: c  reason: collision with root package name */
        public String[] f14635c;

        /* renamed from: d  reason: collision with root package name */
        public int f14636d;

        public a(String str, String[] strArr, String[] strArr2, int i11) {
            this.f14633a = str;
            this.f14634b = strArr;
            this.f14635c = strArr2;
            if (i11 <= 0) {
                this.f14636d = 60;
            } else {
                this.f14636d = i11;
            }
        }

        public int a() {
            return this.f14636d;
        }

        public String[] d() {
            return this.f14634b;
        }

        public String[] e() {
            return this.f14635c;
        }
    }

    public m(HashMap<String, a> hashMap) {
        this.f14632a = hashMap;
    }

    public static m b(String str) {
        JSONObject jSONObject = new JSONObject(str);
        if (!jSONObject.has("dns")) {
            return null;
        }
        JSONArray jSONArray = jSONObject.getJSONArray("dns");
        HashMap hashMap = new HashMap();
        String[] strArr = null;
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i11);
            String string = jSONObject2.getString(VulcanInfo.HOST);
            int i12 = jSONObject2.getInt("type");
            int i13 = jSONObject2.getInt("ttl");
            if (jSONObject2.has("ips")) {
                JSONArray jSONArray2 = jSONObject2.getJSONArray("ips");
                int length = jSONArray2.length();
                String[] strArr2 = new String[length];
                for (int i14 = 0; i14 < length; i14++) {
                    strArr2[i14] = jSONArray2.getString(i14);
                }
                strArr = strArr2;
            }
            a aVar = (a) hashMap.get(string);
            if (aVar == null) {
                aVar = new a(string, (String[]) null, (String[]) null, i13);
                hashMap.put(string, aVar);
            }
            if (i12 == 1) {
                String[] unused = aVar.f14634b = strArr;
            } else if (i12 == 28) {
                String[] unused2 = aVar.f14635c = strArr;
            }
        }
        return new m(hashMap);
    }

    public a a(String str) {
        return this.f14632a.get(str);
    }

    public List<String> c() {
        return new ArrayList(this.f14632a.keySet());
    }
}
