package com.tencent.liteav.txcvodplayer.b;

import android.text.TextUtils;
import com.hbg.lib.network.pro.core.bean.ChainInfo;
import com.luck.picture.lib.loader.IBridgeMediaLoader;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.txcvodplayer.b.c;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public String f21878a;

    /* renamed from: b  reason: collision with root package name */
    public String f21879b;

    /* renamed from: c  reason: collision with root package name */
    public String f21880c;

    /* renamed from: d  reason: collision with root package name */
    public int f21881d;

    /* renamed from: e  reason: collision with root package name */
    public long f21882e;

    /* renamed from: f  reason: collision with root package name */
    public String f21883f;

    /* renamed from: g  reason: collision with root package name */
    public List<c.e> f21884g;

    /* renamed from: h  reason: collision with root package name */
    public String f21885h;

    /* renamed from: i  reason: collision with root package name */
    public c.C0172c f21886i;

    /* renamed from: j  reason: collision with root package name */
    public List<c.d> f21887j;

    /* renamed from: k  reason: collision with root package name */
    private JSONObject f21888k;

    /* renamed from: l  reason: collision with root package name */
    private String f21889l;

    /* renamed from: m  reason: collision with root package name */
    private List<a> f21890m;

    /* renamed from: n  reason: collision with root package name */
    private String f21891n;

    /* renamed from: o  reason: collision with root package name */
    private String f21892o;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f21893a;

        /* renamed from: b  reason: collision with root package name */
        public String f21894b;
    }

    public b(JSONObject jSONObject) {
        this.f21888k = jSONObject;
        c();
    }

    private void a(JSONArray jSONArray) throws JSONException {
        if (jSONArray != null && jSONArray.length() > 0) {
            this.f21884g = new ArrayList();
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i11);
                c.e eVar = new c.e();
                int optInt = jSONObject.optInt("width");
                int optInt2 = jSONObject.optInt("height");
                eVar.f21925b = optInt;
                eVar.f21926c = optInt2;
                eVar.f21924a = jSONObject.optString("resolutionName");
                eVar.f21927d = jSONObject.optString("type");
                eVar.f21928e = jSONObject.optLong("size");
                eVar.f21929f = jSONObject.optString("url");
                this.f21884g.add(eVar);
            }
        }
    }

    private void c() {
        JSONObject optJSONObject;
        try {
            JSONObject jSONObject = this.f21888k.getJSONObject("media");
            if (jSONObject != null) {
                JSONObject optJSONObject2 = jSONObject.optJSONObject("basicInfo");
                if (optJSONObject2 != null) {
                    this.f21878a = optJSONObject2.optString("name");
                    String optString = optJSONObject2.optString("description");
                    this.f21879b = optString;
                    if (TextUtils.isEmpty(optString)) {
                        this.f21879b = this.f21878a;
                    }
                    this.f21880c = optJSONObject2.optString("coverUrl");
                    this.f21881d = optJSONObject2.optInt(IBridgeMediaLoader.COLUMN_DURATION);
                    this.f21882e = optJSONObject2.optLong("size");
                }
                String optString2 = jSONObject.optString("audioVideoType");
                if (TextUtils.equals(optString2, "AdaptiveDynamicStream")) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("streamingInfo");
                    if (jSONObject2 != null) {
                        JSONObject optJSONObject3 = jSONObject2.optJSONObject("plainOutput");
                        if (optJSONObject3 != null) {
                            this.f21889l = optJSONObject3.optString("url");
                            a(optJSONObject3.optJSONArray("subStreams"));
                        }
                        JSONArray optJSONArray = jSONObject2.optJSONArray("drmOutput");
                        if (optJSONArray != null && optJSONArray.length() > 0) {
                            this.f21890m = new ArrayList();
                            for (int i11 = 0; i11 < optJSONArray.length(); i11++) {
                                JSONObject optJSONObject4 = optJSONArray.optJSONObject(i11);
                                String optString3 = optJSONObject4.optString("type");
                                String optString4 = optJSONObject4.optString("url");
                                a aVar = new a();
                                aVar.f21893a = optString3;
                                aVar.f21894b = optString4;
                                if (optString3.equalsIgnoreCase("SimpleAES")) {
                                    this.f21885h = optString3;
                                }
                                this.f21890m.add(aVar);
                                a(optJSONObject4.optJSONArray("subStreams"));
                            }
                        }
                        this.f21891n = jSONObject2.optString("drmToken");
                        String optString5 = jSONObject2.optString("widevineLicenseUrl");
                        this.f21892o = optString5;
                        if (!TextUtils.isEmpty(optString5)) {
                            this.f21885h = "Widevine";
                        }
                    }
                } else if (TextUtils.equals(optString2, "Transcode")) {
                    JSONObject optJSONObject5 = jSONObject.optJSONObject("transcodeInfo");
                    if (optJSONObject5 != null) {
                        this.f21889l = optJSONObject5.optString("url");
                    }
                } else if (TextUtils.equals(optString2, "Original") && (optJSONObject = jSONObject.optJSONObject("originalInfo")) != null) {
                    this.f21889l = optJSONObject.optString("url");
                }
                JSONObject optJSONObject6 = jSONObject.optJSONObject("imageSpriteInfo");
                if (optJSONObject6 != null) {
                    c.C0172c cVar = new c.C0172c();
                    this.f21886i = cVar;
                    cVar.f21921b = optJSONObject6.getString("webVttUrl");
                    JSONArray optJSONArray2 = optJSONObject6.optJSONArray("imageUrls");
                    if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        for (int i12 = 0; i12 < optJSONArray2.length(); i12++) {
                            arrayList.add(optJSONArray2.getString(i12));
                        }
                        this.f21886i.f21920a = arrayList;
                    }
                }
                a(jSONObject);
                JSONObject optJSONObject7 = jSONObject.optJSONObject("ghostWatermarkInfo");
                if (optJSONObject7 != null) {
                    this.f21883f = optJSONObject7.optString("text");
                }
            }
        } catch (JSONException e11) {
            LiteavLog.e("TXCPlayInfoParserV4", e11.getMessage());
        }
    }

    public final String b() {
        if (!TextUtils.isEmpty(this.f21892o)) {
            return this.f21892o;
        }
        return null;
    }

    private void a(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("keyFrameDescInfo");
        if (optJSONObject != null) {
            this.f21887j = new ArrayList();
            JSONArray optJSONArray = optJSONObject.optJSONArray("keyFrameDescList");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i11 = 0; i11 < optJSONArray.length(); i11++) {
                    JSONObject jSONObject2 = null;
                    try {
                        jSONObject2 = optJSONArray.getJSONObject(i11);
                    } catch (JSONException e11) {
                        e11.printStackTrace();
                    }
                    c.d dVar = new c.d();
                    dVar.f21923b = (float) jSONObject2.optLong("timeOffset");
                    dVar.f21922a = jSONObject2.optString("content");
                    this.f21887j.add(dVar);
                }
            }
        }
    }

    public final String a(String str) {
        if (ChainInfo.CHAIN_TYPE_PLAIN.equalsIgnoreCase(str)) {
            return this.f21889l;
        }
        List<a> list = this.f21890m;
        if (list == null) {
            return null;
        }
        for (a next : list) {
            String str2 = next.f21893a;
            if (str2 != null && str2.equalsIgnoreCase(str)) {
                return next.f21894b;
            }
        }
        return null;
    }

    public final String a() {
        if (TextUtils.isEmpty(this.f21891n)) {
            return null;
        }
        return this.f21891n;
    }
}
