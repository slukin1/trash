package com.qihoo.stat;

import android.text.TextUtils;
import java.util.Vector;
import org.json.JSONObject;

public class n {

    /* renamed from: g  reason: collision with root package name */
    public static String f28814g = "SessionBean";

    /* renamed from: a  reason: collision with root package name */
    public String f28815a = "";

    /* renamed from: b  reason: collision with root package name */
    public long f28816b = 0;

    /* renamed from: c  reason: collision with root package name */
    public long f28817c = 0;

    /* renamed from: d  reason: collision with root package name */
    public Vector f28818d = new Vector();

    /* renamed from: e  reason: collision with root package name */
    public long f28819e = 0;

    /* renamed from: f  reason: collision with root package name */
    public long f28820f = 0;

    public n() {
    }

    public n(String str, long j11) {
        this.f28815a = str;
        this.f28816b = j11;
    }

    public void a() {
        Vector vector = this.f28818d;
        if (vector != null) {
            vector.clear();
            this.f28818d = null;
        }
        this.f28815a = "";
        this.f28816b = 0;
        this.f28817c = 0;
        this.f28819e = 0;
        this.f28820f = 0;
    }

    public void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (this.f28818d == null) {
                this.f28818d = new Vector();
            }
            boolean z11 = false;
            int i11 = 0;
            while (true) {
                if (i11 >= this.f28818d.size()) {
                    break;
                }
                g gVar = (g) this.f28818d.get(i11);
                if (str.equals(gVar.f28756a)) {
                    gVar.f28757b = u.M();
                    z11 = true;
                    break;
                }
                i11++;
            }
            if (!z11) {
                this.f28818d.add(new g(str, u.M()));
            }
        }
    }

    public JSONObject c() {
        Vector vector;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SettingsJsonConstants.SESSION_KEY, this.f28815a);
            jSONObject.put("createTime", this.f28816b);
            jSONObject.put("terminateTime", this.f28817c);
            long j11 = this.f28819e;
            if (j11 > 0) {
                jSONObject.put("uptr", j11);
            }
            long j12 = this.f28820f;
            if (j12 > 0) {
                jSONObject.put("dntr", j12);
            }
            if (d.f28720l && (vector = this.f28818d) != null && vector.size() > 0) {
                JSONObject jSONObject2 = new JSONObject();
                for (int i11 = 0; i11 < this.f28818d.size(); i11++) {
                    g gVar = (g) this.f28818d.get(i11);
                    jSONObject2.put(gVar.f28756a, gVar.f28759d);
                }
                jSONObject.put("activity", jSONObject2);
            }
        } catch (Exception e11) {
            g0.b(f28814g, e11);
        } catch (Error e12) {
            g0.a(f28814g, e12);
        }
        return jSONObject;
    }

    public void d(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (this.f28818d == null) {
                this.f28818d = new Vector();
            }
            for (int i11 = 0; i11 < this.f28818d.size(); i11++) {
                g gVar = (g) this.f28818d.get(i11);
                if (str.equals(gVar.f28756a)) {
                    long M = u.M();
                    gVar.f28758c = M;
                    long j11 = gVar.f28757b;
                    if (0 != j11) {
                        gVar.f28759d += M - j11;
                        gVar.f28757b = 0;
                        return;
                    }
                    return;
                }
            }
        }
    }
}
