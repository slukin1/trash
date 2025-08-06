package com.huawei.hms.hatool;

import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

public class d1 implements g {

    /* renamed from: a  reason: collision with root package name */
    private String f38140a;

    /* renamed from: b  reason: collision with root package name */
    private String f38141b;

    /* renamed from: c  reason: collision with root package name */
    private String f38142c;

    /* renamed from: d  reason: collision with root package name */
    private List<b1> f38143d;

    public d1(List<b1> list, String str, String str2, String str3) {
        this.f38140a = str;
        this.f38141b = str2;
        this.f38142c = str3;
        this.f38143d = list;
    }

    private void a() {
        String a11 = n1.a(this.f38140a, this.f38142c, this.f38141b);
        d.a(q0.i(), "backup_event", a11);
    }

    public void run() {
        List<b1> list = this.f38143d;
        if (list == null || list.size() == 0) {
            v.d("hmsSdk", "failed events is empty");
            return;
        }
        if (c0.a(q0.i(), "cached_v2_1", q0.k() * 1048576)) {
            v.e("hmsSdk", "The cacheFile is full,Can not writing data! reqID:" + this.f38141b);
            return;
        }
        String a11 = n1.a(this.f38140a, this.f38142c);
        List list2 = c1.b(q0.i(), "cached_v2_1", a11).get(a11);
        if (!(list2 == null || list2.size() == 0)) {
            this.f38143d.addAll(list2);
        }
        JSONArray jSONArray = new JSONArray();
        for (b1 d11 : this.f38143d) {
            try {
                jSONArray.put(d11.d());
            } catch (JSONException unused) {
                v.e("hmsSdk", "event to json error");
            }
        }
        String jSONArray2 = jSONArray.toString();
        if (jSONArray2.length() > q0.h() * 1048576) {
            v.e("hmsSdk", "this failed data is too long,can not writing it");
            this.f38143d = null;
            return;
        }
        v.d("hmsSdk", "data send failed, write to cache file...reqID:" + this.f38141b);
        d.b(q0.i(), "cached_v2_1", a11, jSONArray2);
        a();
    }
}
