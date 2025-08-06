package com.qihoo.stat;

import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.luck.picture.lib.loader.IBridgeMediaLoader;
import com.twitter.sdk.android.core.identity.AuthHandler;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONObject;

public class j {

    /* renamed from: h  reason: collision with root package name */
    public static String f28779h = "HistoryBean";

    /* renamed from: a  reason: collision with root package name */
    public Vector f28780a;

    /* renamed from: b  reason: collision with root package name */
    public Map f28781b;

    /* renamed from: c  reason: collision with root package name */
    public Map f28782c;

    /* renamed from: d  reason: collision with root package name */
    public Map f28783d;

    /* renamed from: e  reason: collision with root package name */
    public Map f28784e;

    /* renamed from: f  reason: collision with root package name */
    public Map f28785f;

    /* renamed from: g  reason: collision with root package name */
    public Map f28786g;

    public j() {
        this.f28780a = null;
        this.f28781b = null;
        this.f28782c = null;
        this.f28783d = null;
        this.f28784e = null;
        this.f28785f = null;
        this.f28786g = null;
        this.f28780a = new Vector();
        this.f28781b = new HashMap();
        this.f28782c = new HashMap();
        this.f28783d = new HashMap();
        this.f28784e = new HashMap();
        this.f28785f = new HashMap();
        this.f28786g = new HashMap();
    }

    public void a() {
        if (this.f28780a != null) {
            for (int i11 = 0; i11 < this.f28780a.size(); i11++) {
                ((n) this.f28780a.get(i11)).f28818d.clear();
            }
            this.f28780a.clear();
            this.f28780a = null;
        }
        Map map = this.f28781b;
        if (map != null) {
            for (Map.Entry value : map.entrySet()) {
                ((Vector) value.getValue()).clear();
            }
            this.f28781b.clear();
            this.f28781b = null;
        }
        Map map2 = this.f28782c;
        if (map2 != null) {
            for (Map.Entry value2 : map2.entrySet()) {
                Vector vector = (Vector) value2.getValue();
                for (int i12 = 0; i12 < vector.size(); i12++) {
                    Map map3 = ((i) vector.get(i12)).f28778g;
                    if (map3 != null) {
                        map3.clear();
                    }
                }
                vector.clear();
            }
            this.f28782c.clear();
            this.f28782c = null;
        }
        Map map4 = this.f28783d;
        if (map4 != null) {
            for (Map.Entry value3 : map4.entrySet()) {
                ((Vector) value3.getValue()).clear();
            }
            this.f28783d.clear();
            this.f28783d = null;
        }
        Map map5 = this.f28784e;
        if (map5 != null) {
            for (Map.Entry value4 : map5.entrySet()) {
                ((Vector) value4.getValue()).clear();
            }
            this.f28784e.clear();
            this.f28784e = null;
        }
        Map map6 = this.f28785f;
        if (map6 != null) {
            for (Map.Entry value5 : map6.entrySet()) {
                ((Vector) value5.getValue()).clear();
            }
            this.f28785f.clear();
            this.f28785f = null;
        }
        Map map7 = this.f28786g;
        if (map7 != null) {
            for (Map.Entry value6 : map7.entrySet()) {
                ((Vector) value6.getValue()).clear();
            }
            this.f28786g.clear();
            this.f28786g = null;
        }
    }

    public void b(String str) {
        String str2;
        Iterator<String> it2;
        String str3;
        JSONObject jSONObject;
        String str4;
        String str5;
        String str6;
        JSONArray jSONArray;
        String str7;
        String str8;
        j jVar = this;
        String str9 = "terminateTime";
        String str10 = "use";
        String str11 = "createTime";
        String str12 = "buy";
        String str13 = SettingsJsonConstants.SESSION_KEY;
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject2 = new JSONObject(str);
                if (!jSONObject2.isNull("terminate") && (jSONArray = jSONObject2.getJSONArray("terminate")) != null) {
                    int i11 = 0;
                    while (i11 < jSONArray.length()) {
                        JSONObject jSONObject3 = (JSONObject) jSONArray.opt(i11);
                        n nVar = new n();
                        if (!jSONObject3.isNull(str13)) {
                            nVar.f28815a = jSONObject3.getString(str13);
                        }
                        if (!jSONObject3.isNull(str11)) {
                            str8 = str12;
                            str7 = str13;
                            nVar.f28816b = jSONObject3.getLong(str11);
                        } else {
                            str8 = str12;
                            str7 = str13;
                        }
                        if (!jSONObject3.isNull(str9)) {
                            nVar.f28817c = jSONObject3.getLong(str9);
                        }
                        if (!jSONObject3.isNull("uptr")) {
                            nVar.f28819e = jSONObject3.getLong("uptr");
                        }
                        if (!jSONObject3.isNull("dntr")) {
                            nVar.f28820f = jSONObject3.getLong("dntr");
                        }
                        if (!jSONObject3.isNull("activity")) {
                            JSONObject jSONObject4 = jSONObject3.getJSONObject("activity");
                            Iterator<String> keys = jSONObject4.keys();
                            while (keys.hasNext()) {
                                String next = keys.next();
                                String str14 = str9;
                                if (nVar.f28818d == null) {
                                    nVar.f28818d = new Vector();
                                }
                                nVar.f28818d.add(new g(next, 0, 0, (long) jSONObject4.getInt(next)));
                                str9 = str14;
                                str11 = str11;
                                keys = keys;
                                jSONObject4 = jSONObject4;
                            }
                        }
                        jVar.f28780a.add(nVar);
                        i11++;
                        str12 = str8;
                        str13 = str7;
                        str9 = str9;
                        str11 = str11;
                    }
                }
                String str15 = str12;
                boolean isNull = jSONObject2.isNull("pay");
                String str16 = AuthHandler.EXTRA_TOKEN_SECRET;
                String str17 = "number";
                String str18 = "coin";
                String str19 = FirebaseAnalytics.Param.LEVEL;
                if (!isNull) {
                    JSONObject jSONObject5 = jSONObject2.getJSONObject("pay");
                    Iterator<String> keys2 = jSONObject5.keys();
                    while (keys2.hasNext()) {
                        String next2 = keys2.next();
                        JSONArray jSONArray2 = jSONObject5.getJSONArray(next2);
                        if (jSONArray2 != null) {
                            Vector vector = new Vector();
                            JSONObject jSONObject6 = jSONObject5;
                            Iterator<String> it3 = keys2;
                            int i12 = 0;
                            while (i12 < jSONArray2.length()) {
                                JSONObject jSONObject7 = (JSONObject) jSONArray2.opt(i12);
                                String str20 = next2;
                                l lVar = new l();
                                JSONArray jSONArray3 = jSONArray2;
                                if (!jSONObject7.isNull("cash")) {
                                    lVar.f28795a = jSONObject7.getInt("cash");
                                }
                                if (!jSONObject7.isNull(str18)) {
                                    lVar.f28797c = jSONObject7.getInt(str18);
                                }
                                if (!jSONObject7.isNull("props")) {
                                    lVar.f28798d = jSONObject7.getString("props");
                                }
                                if (!jSONObject7.isNull(str17)) {
                                    lVar.f28799e = jSONObject7.getInt(str17);
                                }
                                if (!jSONObject7.isNull("source")) {
                                    lVar.f28800f = jSONObject7.getInt("source");
                                }
                                if (!jSONObject7.isNull(str19)) {
                                    lVar.f28801g = jSONObject7.getString(str19);
                                }
                                if (!jSONObject7.isNull("rank")) {
                                    lVar.f28802h = jSONObject7.getString("rank");
                                }
                                if (!jSONObject7.isNull(str16)) {
                                    str6 = str17;
                                    str5 = str18;
                                    lVar.f28803i = jSONObject7.getLong(str16);
                                } else {
                                    str6 = str17;
                                    str5 = str18;
                                }
                                vector.add(lVar);
                                i12++;
                                str17 = str6;
                                next2 = str20;
                                jSONArray2 = jSONArray3;
                                str18 = str5;
                            }
                            jVar.f28781b.put(next2, vector);
                            jSONObject5 = jSONObject6;
                            keys2 = it3;
                        }
                    }
                }
                String str21 = str17;
                String str22 = str18;
                if (!jSONObject2.isNull("event")) {
                    JSONObject jSONObject8 = jSONObject2.getJSONObject("event");
                    Iterator<String> keys3 = jSONObject8.keys();
                    while (keys3.hasNext()) {
                        String next3 = keys3.next();
                        JSONArray jSONArray4 = jSONObject8.getJSONArray(next3);
                        if (jSONArray4 != null) {
                            Vector vector2 = new Vector();
                            int i13 = 0;
                            while (i13 < jSONArray4.length()) {
                                JSONObject jSONObject9 = (JSONObject) jSONArray4.opt(i13);
                                JSONObject jSONObject10 = jSONObject8;
                                i iVar = new i();
                                Iterator<String> keys4 = jSONObject9.keys();
                                while (keys4.hasNext()) {
                                    Iterator<String> it4 = keys3;
                                    String next4 = keys4.next();
                                    String str23 = next3;
                                    if ("qhId".equals(next4)) {
                                        iVar.f28772a = jSONObject9.getString(next4);
                                    } else if ("qhTs".equals(next4)) {
                                        iVar.f28773b = jSONObject9.getLong(next4);
                                    } else if ("qhBegin".equals(next4)) {
                                        iVar.f28775d = jSONObject9.getLong(next4);
                                    } else if ("qhEnd".equals(next4)) {
                                        iVar.f28776e = jSONObject9.getLong(next4);
                                    } else if ("qhDuration".equals(next4)) {
                                        iVar.f28777f = jSONObject9.getLong(next4);
                                    } else {
                                        if (iVar.f28778g == null) {
                                            iVar.f28778g = new HashMap();
                                        }
                                        iVar.f28778g.put(next4, jSONObject9.getString(next4));
                                        next3 = str23;
                                        keys3 = it4;
                                        iVar = iVar;
                                    }
                                    next3 = str23;
                                    keys3 = it4;
                                }
                                vector2.add(iVar);
                                i13++;
                                jSONObject8 = jSONObject10;
                            }
                            jVar.f28782c.put(next3, vector2);
                        }
                    }
                }
                if (!jSONObject2.isNull(str19)) {
                    JSONObject jSONObject11 = jSONObject2.getJSONObject(str19);
                    Iterator<String> keys5 = jSONObject11.keys();
                    while (keys5.hasNext()) {
                        String str24 = str21;
                        String next5 = keys5.next();
                        String str25 = str10;
                        JSONArray jSONArray5 = jSONObject11.getJSONArray(next5);
                        if (jSONArray5 != null) {
                            JSONObject jSONObject12 = jSONObject11;
                            Vector vector3 = new Vector();
                            String str26 = str16;
                            String str27 = str19;
                            int i14 = 0;
                            while (i14 < jSONArray5.length()) {
                                JSONObject jSONObject13 = (JSONObject) jSONArray5.opt(i14);
                                JSONArray jSONArray6 = jSONArray5;
                                k kVar = new k();
                                if (!jSONObject13.isNull("name")) {
                                    str4 = next5;
                                    kVar.f28788a = jSONObject13.getString("name");
                                } else {
                                    str4 = next5;
                                }
                                String str28 = str15;
                                if (!jSONObject13.isNull("begin")) {
                                    kVar.f28789b = jSONObject13.getLong("begin");
                                }
                                if (!jSONObject13.isNull("end")) {
                                    kVar.f28790c = jSONObject13.getLong("end");
                                }
                                if (!jSONObject13.isNull(IBridgeMediaLoader.COLUMN_DURATION)) {
                                    kVar.f28791d = jSONObject13.getLong(IBridgeMediaLoader.COLUMN_DURATION);
                                }
                                if (!jSONObject13.isNull("status")) {
                                    kVar.f28792e = jSONObject13.getInt("status");
                                }
                                if (!jSONObject13.isNull(Constants.REASON)) {
                                    kVar.f28793f = jSONObject13.getString(Constants.REASON);
                                }
                                vector3.add(kVar);
                                i14++;
                                jSONArray5 = jSONArray6;
                                next5 = str4;
                                str15 = str28;
                            }
                            jVar.f28783d.put(next5, vector3);
                            str10 = str25;
                            str21 = str24;
                            jSONObject11 = jSONObject12;
                            str19 = str27;
                            str16 = str26;
                        } else {
                            str10 = str25;
                            str21 = str24;
                        }
                    }
                }
                String str29 = str10;
                String str30 = str16;
                String str31 = str19;
                String str32 = str15;
                String str33 = str21;
                if (!jSONObject2.isNull("task")) {
                    JSONObject jSONObject14 = jSONObject2.getJSONObject("task");
                    Iterator<String> keys6 = jSONObject14.keys();
                    while (keys6.hasNext()) {
                        String next6 = keys6.next();
                        JSONArray jSONArray7 = jSONObject14.getJSONArray(next6);
                        if (jSONArray7 != null) {
                            Vector vector4 = new Vector();
                            JSONObject jSONObject15 = jSONObject14;
                            int i15 = 0;
                            while (i15 < jSONArray7.length()) {
                                JSONObject jSONObject16 = (JSONObject) jSONArray7.opt(i15);
                                Iterator<String> it5 = keys6;
                                o oVar = new o();
                                if (!jSONObject16.isNull("name")) {
                                    str3 = next6;
                                    oVar.f28822a = jSONObject16.getString("name");
                                } else {
                                    str3 = next6;
                                }
                                JSONArray jSONArray8 = jSONArray7;
                                if (!jSONObject16.isNull("begin")) {
                                    jSONObject = jSONObject2;
                                    oVar.f28826e = jSONObject16.getLong("begin");
                                } else {
                                    jSONObject = jSONObject2;
                                }
                                if (!jSONObject16.isNull("end")) {
                                    oVar.f28827f = jSONObject16.getLong("end");
                                }
                                if (!jSONObject16.isNull(IBridgeMediaLoader.COLUMN_DURATION)) {
                                    oVar.f28828g = jSONObject16.getLong(IBridgeMediaLoader.COLUMN_DURATION);
                                }
                                if (!jSONObject16.isNull("status")) {
                                    oVar.f28825d = jSONObject16.getInt("status");
                                }
                                if (!jSONObject16.isNull("type")) {
                                    oVar.f28823b = jSONObject16.getString("type");
                                }
                                if (!jSONObject16.isNull(Constants.REASON)) {
                                    oVar.f28824c = jSONObject16.getString(Constants.REASON);
                                }
                                vector4.add(oVar);
                                i15++;
                                jSONObject2 = jSONObject;
                                keys6 = it5;
                                next6 = str3;
                                jSONArray7 = jSONArray8;
                            }
                            jVar.f28784e.put(next6, vector4);
                            jSONObject14 = jSONObject15;
                        }
                    }
                }
                JSONObject jSONObject17 = jSONObject2;
                String str34 = str32;
                if (!jSONObject17.isNull(str34)) {
                    JSONObject jSONObject18 = jSONObject17.getJSONObject(str34);
                    Iterator<String> keys7 = jSONObject18.keys();
                    while (keys7.hasNext()) {
                        String next7 = keys7.next();
                        JSONArray jSONArray9 = jSONObject18.getJSONArray(next7);
                        if (jSONArray9 != null) {
                            Vector vector5 = new Vector();
                            int i16 = 0;
                            while (i16 < jSONArray9.length()) {
                                JSONObject jSONObject19 = (JSONObject) jSONArray9.opt(i16);
                                h hVar = new h();
                                if (!jSONObject19.isNull("name")) {
                                    hVar.f28761a = jSONObject19.getString("name");
                                }
                                if (!jSONObject19.isNull("type")) {
                                    hVar.f28762b = jSONObject19.getString("type");
                                }
                                String str35 = str33;
                                if (!jSONObject19.isNull(str35)) {
                                    hVar.f28763c = jSONObject19.getInt(str35);
                                }
                                String str36 = str22;
                                if (!jSONObject19.isNull(str36)) {
                                    hVar.f28766f = jSONObject19.getInt(str36);
                                }
                                if (!jSONObject19.isNull("coinType")) {
                                    hVar.f28765e = jSONObject19.getString("coinType");
                                }
                                if (!jSONObject19.isNull("method")) {
                                    hVar.f28764d = jSONObject19.getString("method");
                                }
                                String str37 = str30;
                                if (!jSONObject19.isNull(str37)) {
                                    it2 = keys7;
                                    str2 = next7;
                                    hVar.f28767g = jSONObject19.getLong(str37);
                                } else {
                                    it2 = keys7;
                                    str2 = next7;
                                }
                                String str38 = str31;
                                if (!jSONObject19.isNull(str38)) {
                                    hVar.f28768h = jSONObject19.getString(str38);
                                }
                                vector5.add(hVar);
                                i16++;
                                str31 = str38;
                                str22 = str36;
                                str30 = str37;
                                keys7 = it2;
                                next7 = str2;
                                str33 = str35;
                            }
                            jVar.f28785f.put(next7, vector5);
                        }
                    }
                }
                String str39 = str33;
                String str40 = str22;
                String str41 = str31;
                String str42 = str30;
                String str43 = str29;
                if (!jSONObject17.isNull(str43)) {
                    JSONObject jSONObject20 = jSONObject17.getJSONObject(str43);
                    Iterator<String> keys8 = jSONObject20.keys();
                    while (keys8.hasNext()) {
                        String next8 = keys8.next();
                        JSONArray jSONArray10 = jSONObject20.getJSONArray(next8);
                        if (jSONArray10 != null) {
                            Vector vector6 = new Vector();
                            int i17 = 0;
                            while (i17 < jSONArray10.length()) {
                                JSONObject jSONObject21 = (JSONObject) jSONArray10.opt(i17);
                                p pVar = new p();
                                if (!jSONObject21.isNull("name")) {
                                    pVar.f28830a = jSONObject21.getString("name");
                                }
                                if (!jSONObject21.isNull(str39)) {
                                    pVar.f28832c = jSONObject21.getInt(str39);
                                }
                                if (!jSONObject21.isNull(str40)) {
                                    pVar.f28833d = jSONObject21.getInt(str40);
                                }
                                if (!jSONObject21.isNull("type")) {
                                    pVar.f28831b = jSONObject21.getString("type");
                                }
                                JSONObject jSONObject22 = jSONObject20;
                                if (!jSONObject21.isNull(str42)) {
                                    pVar.f28834e = jSONObject21.getLong(str42);
                                }
                                if (!jSONObject21.isNull(str41)) {
                                    pVar.f28835f = jSONObject21.getString(str41);
                                }
                                vector6.add(pVar);
                                i17++;
                                jVar = this;
                                jSONObject20 = jSONObject22;
                            }
                            jVar.f28786g.put(next8, vector6);
                        } else {
                            jVar = this;
                        }
                    }
                }
            }
        } catch (Exception e11) {
            g0.b(f28779h, e11);
        } catch (Error e12) {
            g0.a(f28779h, e12);
        }
    }
}
