package com.xiaomi.push;

import android.text.TextUtils;
import com.huobi.vulcan.model.VulcanInfo;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

class ce {

    /* renamed from: a  reason: collision with root package name */
    private String f51491a;

    /* renamed from: a  reason: collision with other field name */
    private final ArrayList<cd> f2597a = new ArrayList<>();

    public ce(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f51491a = str;
            return;
        }
        throw new IllegalArgumentException("the host is empty");
    }

    public synchronized void a(cd cdVar) {
        int i11 = 0;
        while (true) {
            if (i11 >= this.f2597a.size()) {
                break;
            } else if (this.f2597a.get(i11).a(cdVar)) {
                this.f2597a.set(i11, cdVar);
                break;
            } else {
                i11++;
            }
        }
        if (i11 >= this.f2597a.size()) {
            this.f2597a.add(cdVar);
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f51491a);
        sb2.append("\n");
        Iterator<cd> it2 = this.f2597a.iterator();
        while (it2.hasNext()) {
            sb2.append(it2.next());
        }
        return sb2.toString();
    }

    public ce() {
    }

    public synchronized cd a() {
        for (int size = this.f2597a.size() - 1; size >= 0; size--) {
            cd cdVar = this.f2597a.get(size);
            if (cdVar.a()) {
                ch.a().a(cdVar.a());
                return cdVar;
            }
        }
        return null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public ArrayList<cd> m2478a() {
        return this.f2597a;
    }

    public synchronized void a(boolean z11) {
        for (int size = this.f2597a.size() - 1; size >= 0; size--) {
            cd cdVar = this.f2597a.get(size);
            if (z11) {
                if (cdVar.c()) {
                    this.f2597a.remove(size);
                }
            } else if (!cdVar.b()) {
                this.f2597a.remove(size);
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m2477a() {
        return this.f51491a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized JSONObject m2479a() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put(VulcanInfo.HOST, this.f51491a);
        JSONArray jSONArray = new JSONArray();
        Iterator<cd> it2 = this.f2597a.iterator();
        while (it2.hasNext()) {
            jSONArray.put(it2.next().a());
        }
        jSONObject.put("fbs", jSONArray);
        return jSONObject;
    }

    public synchronized ce a(JSONObject jSONObject) {
        this.f51491a = jSONObject.getString(VulcanInfo.HOST);
        JSONArray jSONArray = jSONObject.getJSONArray("fbs");
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            this.f2597a.add(new cd(this.f51491a).a(jSONArray.getJSONObject(i11)));
        }
        return this;
    }
}
