package com.tencent.liteav.txcvodplayer.b;

import com.luck.picture.lib.loader.IBridgeMediaLoader;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.txcvodplayer.b.c;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public JSONObject f21948a;

    /* renamed from: b  reason: collision with root package name */
    public g f21949b;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f21950a;

        /* renamed from: b  reason: collision with root package name */
        public String f21951b;

        /* renamed from: c  reason: collision with root package name */
        public List<Integer> f21952c;
    }

    public f(JSONObject jSONObject) {
        this.f21948a = jSONObject;
    }

    private g l() {
        try {
            JSONObject jSONObject = this.f21948a.getJSONObject("videoInfo").getJSONObject("masterPlayList");
            g gVar = new g();
            gVar.f21953a = jSONObject.getString("url");
            return gVar;
        } catch (JSONException e11) {
            e11.printStackTrace();
            return null;
        }
    }

    private String m() {
        try {
            return this.f21948a.getJSONObject("playerInfo").getString("defaultVideoClassification");
        } catch (JSONException e11) {
            e11.printStackTrace();
            return null;
        }
    }

    private List<Integer> n() {
        List<a> k11 = k();
        String m11 = m();
        if (m11 == null || k11 == null) {
            return null;
        }
        for (a next : k11) {
            if (next.f21950a.equals(m11)) {
                return next.f21952c;
            }
        }
        return null;
    }

    public final String a() {
        if (this.f21949b == null) {
            this.f21949b = c();
        }
        g gVar = this.f21949b;
        if (gVar != null) {
            return gVar.f21953a;
        }
        return null;
    }

    public final int b() {
        if (this.f21949b == null) {
            this.f21949b = c();
        }
        g gVar = this.f21949b;
        if (gVar != null) {
            return gVar.f21957e;
        }
        return -1;
    }

    public final g c() {
        if (l() != null) {
            return l();
        }
        if (e().size() == 0) {
            return f();
        }
        List<Integer> n11 = n();
        if (n11 != null) {
            for (g next : e()) {
                if (n11.contains(Integer.valueOf(next.f21961i))) {
                    return next;
                }
            }
        }
        return e().get(0);
    }

    public final String d() {
        try {
            JSONObject jSONObject = this.f21948a.getJSONObject("coverInfo");
            if (jSONObject != null) {
                return jSONObject.getString("coverUrl");
            }
            return null;
        } catch (JSONException e11) {
            LiteavLog.e("TXPlayInfoResponse", "get cover url failed.", (Throwable) e11);
            return null;
        }
    }

    public final List<g> e() {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = this.f21948a.getJSONObject("videoInfo").getJSONArray("transcodeList");
            if (jSONArray != null) {
                for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i11);
                    g gVar = new g();
                    gVar.f21953a = jSONObject.getString("url");
                    gVar.f21957e = jSONObject.getInt(IBridgeMediaLoader.COLUMN_DURATION);
                    gVar.f21955c = jSONObject.getInt("width");
                    gVar.f21954b = jSONObject.getInt("height");
                    gVar.f21956d = Math.max(jSONObject.getLong("totalSize"), jSONObject.getLong("size"));
                    gVar.f21958f = jSONObject.getInt("bitrate");
                    gVar.f21961i = jSONObject.getInt("definition");
                    gVar.f21959g = jSONObject.getString(TtmlNode.RUBY_CONTAINER);
                    gVar.f21960h = jSONObject.getString("templateName");
                    arrayList.add(gVar);
                }
            }
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
        return arrayList;
    }

    public final g f() {
        try {
            JSONObject jSONObject = this.f21948a.getJSONObject("videoInfo").getJSONObject("sourceVideo");
            g gVar = new g();
            gVar.f21953a = jSONObject.getString("url");
            gVar.f21957e = jSONObject.getInt(IBridgeMediaLoader.COLUMN_DURATION);
            gVar.f21955c = jSONObject.getInt("width");
            gVar.f21954b = jSONObject.getInt("height");
            gVar.f21956d = Math.max(jSONObject.getLong("size"), jSONObject.getLong("totalSize"));
            gVar.f21958f = jSONObject.getInt("bitrate");
            return gVar;
        } catch (JSONException e11) {
            e11.printStackTrace();
            return null;
        }
    }

    public final String g() {
        try {
            JSONObject jSONObject = this.f21948a.getJSONObject("videoInfo").getJSONObject("basicInfo");
            if (jSONObject != null) {
                return jSONObject.getString("name");
            }
            return null;
        } catch (JSONException e11) {
            e11.printStackTrace();
            return null;
        }
    }

    public final String h() {
        try {
            JSONObject jSONObject = this.f21948a.getJSONObject("videoInfo").getJSONObject("basicInfo");
            if (jSONObject != null) {
                return jSONObject.getString("description");
            }
            return null;
        } catch (JSONException e11) {
            e11.printStackTrace();
            return null;
        }
    }

    public final c.C0172c i() {
        JSONObject optJSONObject = this.f21948a.optJSONObject("imageSpriteInfo");
        if (optJSONObject != null) {
            try {
                JSONArray jSONArray = optJSONObject.getJSONArray("imageSpriteList");
                if (jSONArray == null) {
                    return null;
                }
                JSONObject jSONObject = jSONArray.getJSONObject(jSONArray.length() - 1);
                c.C0172c cVar = new c.C0172c();
                cVar.f21921b = jSONObject.getString("webVttUrl");
                JSONArray jSONArray2 = jSONObject.getJSONArray("imageUrls");
                ArrayList<String> arrayList = new ArrayList<>();
                for (int i11 = 0; i11 < jSONArray2.length(); i11++) {
                    arrayList.add(jSONArray2.getString(i11));
                }
                cVar.f21920a = arrayList;
                return cVar;
            } catch (JSONException unused) {
                LiteavLog.e("TXPlayInfoResponse", "v2 getImageSpriteInfo exception");
            }
        }
        return null;
    }

    public final List<c.d> j() {
        JSONObject optJSONObject = this.f21948a.optJSONObject("keyFrameDescInfo");
        if (optJSONObject == null) {
            return null;
        }
        try {
            return a(optJSONObject);
        } catch (JSONException unused) {
            LiteavLog.e("TXPlayInfoResponse", "v2 parseKeyFrameDescInfo exception");
            return null;
        }
    }

    public final List<a> k() {
        try {
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray = this.f21948a.getJSONObject("playerInfo").getJSONArray("videoClassification");
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                a aVar = new a();
                aVar.f21950a = jSONArray.getJSONObject(i11).getString("id");
                aVar.f21951b = jSONArray.getJSONObject(i11).getString("name");
                aVar.f21952c = new ArrayList();
                JSONArray jSONArray2 = jSONArray.getJSONObject(i11).getJSONArray("definitionList");
                for (int i12 = 0; i12 < jSONArray2.length(); i12++) {
                    aVar.f21952c.add(Integer.valueOf(jSONArray2.getInt(i12)));
                }
                arrayList.add(aVar);
            }
            return arrayList;
        } catch (JSONException e11) {
            e11.printStackTrace();
            return null;
        }
    }

    private static List<c.d> a(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray = jSONObject.getJSONArray("keyFrameDescList");
        if (jSONArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            String string = jSONArray.getJSONObject(i11).getString("content");
            float f11 = (float) (((double) jSONArray.getJSONObject(i11).getLong("timeOffset")) / 1000.0d);
            c.d dVar = new c.d();
            try {
                dVar.f21922a = URLDecoder.decode(string, "UTF-8");
            } catch (UnsupportedEncodingException e11) {
                e11.printStackTrace();
                dVar.f21922a = "";
            }
            dVar.f21923b = f11;
            arrayList.add(dVar);
        }
        return arrayList;
    }
}
