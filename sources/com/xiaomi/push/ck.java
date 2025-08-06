package com.xiaomi.push;

import com.huobi.vulcan.model.VulcanInfo;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

class ck implements Comparable<ck> {

    /* renamed from: a  reason: collision with root package name */
    public int f51501a;

    /* renamed from: a  reason: collision with other field name */
    private long f2611a;

    /* renamed from: a  reason: collision with other field name */
    public String f2612a;

    /* renamed from: a  reason: collision with other field name */
    private final LinkedList<cc> f2613a;

    public ck() {
        this((String) null, 0);
    }

    public synchronized void a(cc ccVar) {
        if (ccVar != null) {
            this.f2613a.add(ccVar);
            int a11 = ccVar.a();
            if (a11 > 0) {
                this.f51501a += ccVar.a();
            } else {
                int i11 = 0;
                int size = this.f2613a.size() - 1;
                while (size >= 0 && this.f2613a.get(size).a() < 0) {
                    i11++;
                    size--;
                }
                this.f51501a += a11 * i11;
            }
            if (this.f2613a.size() > 30) {
                this.f51501a -= this.f2613a.remove().a();
            }
        }
    }

    public String toString() {
        return this.f2612a + ":" + this.f51501a;
    }

    public ck(String str) {
        this(str, 0);
    }

    public ck(String str, int i11) {
        this.f2613a = new LinkedList<>();
        this.f2611a = 0;
        this.f2612a = str;
        this.f51501a = i11;
    }

    /* renamed from: a */
    public int compareTo(ck ckVar) {
        if (ckVar == null) {
            return 1;
        }
        return ckVar.f51501a - this.f51501a;
    }

    public synchronized JSONObject a() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put(TtmlNode.TAG_TT, this.f2611a);
        jSONObject.put("wt", this.f51501a);
        jSONObject.put(VulcanInfo.HOST, this.f2612a);
        JSONArray jSONArray = new JSONArray();
        Iterator it2 = this.f2613a.iterator();
        while (it2.hasNext()) {
            jSONArray.put(((cc) it2.next()).a());
        }
        jSONObject.put("ah", jSONArray);
        return jSONObject;
    }

    public synchronized ck a(JSONObject jSONObject) {
        this.f2611a = jSONObject.getLong(TtmlNode.TAG_TT);
        this.f51501a = jSONObject.getInt("wt");
        this.f2612a = jSONObject.getString(VulcanInfo.HOST);
        JSONArray jSONArray = jSONObject.getJSONArray("ah");
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            this.f2613a.add(new cc().a(jSONArray.getJSONObject(i11)));
        }
        return this;
    }
}
