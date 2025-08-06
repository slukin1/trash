package com.huobi.woodpecker.model;

import android.text.TextUtils;
import com.engagelab.privates.push.constants.MTPushConstants;
import com.huobi.woodpecker.HBOkHttpDNS;
import com.huobi.woodpecker.b;
import com.huobi.woodpecker.core.ActionType;
import com.huobi.woodpecker.kalle.simple.JsonFormat;
import com.huobi.woodpecker.utils.StringUtils;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import vu.e;

public class Config implements JsonFormat, Comparable<Config> {
    private long confinterval;
    private boolean enabled;
    private long interval;
    private Map<String, String> resHeaders;

    /* renamed from: tm  reason: collision with root package name */
    private long f21142tm = System.currentTimeMillis();
    private List<String> url;
    private List<String> urlfilters;
    private double webViewOptCoefficient;

    public static Config fromJsonObject(String str) {
        Config config = new Config();
        try {
            if (!StringUtils.b(str)) {
                JSONObject jSONObject = new JSONObject(str);
                config.fromJson(jSONObject);
                ActionType.update(jSONObject);
                if (jSONObject.has("httpdns")) {
                    HBOkHttpDNS.e().n(jSONObject.optJSONObject("httpdns"));
                }
                if (jSONObject.has("ws_timeout")) {
                    e.g().o(jSONObject.optJSONObject("ws_timeout"));
                }
            }
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
        return config;
    }

    public int compareTo(Config config) {
        return 0;
    }

    public void fromJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null) {
            this.interval = jSONObject.optLong(MTPushConstants.Geofence.KEY_INTERVAL);
            this.enabled = jSONObject.optBoolean(Constants.ENABLED);
            this.webViewOptCoefficient = jSONObject.optDouble("webViewOptCoefficient");
            JSONArray optJSONArray = jSONObject.optJSONArray("url");
            this.url = new ArrayList();
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i11 = 0; i11 < optJSONArray.length(); i11++) {
                    this.url.add(optJSONArray.optString(i11));
                }
            }
            if (jSONObject.has("confinterval")) {
                this.confinterval = jSONObject.optLong("confinterval");
            }
            if (jSONObject.has("api") && (optJSONObject = jSONObject.optJSONObject("api")) != null) {
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("urlfilters");
                this.urlfilters = new ArrayList();
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    for (int i12 = 0; i12 < optJSONArray2.length(); i12++) {
                        this.urlfilters.add(optJSONArray2.optString(i12));
                    }
                }
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("resheader");
                if (optJSONObject2 != null) {
                    this.resHeaders = new HashMap();
                    Iterator<String> keys = optJSONObject2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        String optString = optJSONObject2.optString(next);
                        if (!TextUtils.isEmpty(optString)) {
                            this.resHeaders.put(next, optString);
                        }
                    }
                }
            }
        }
    }

    public long getConfinterval() {
        return this.confinterval;
    }

    public long getConfintervalMillis() {
        return this.confinterval * 1000;
    }

    public long getInterval() {
        return this.interval;
    }

    public long getIntervalMillis() {
        return this.interval * 1000;
    }

    public Map<String, String> getResHeaders() {
        return this.resHeaders;
    }

    public long getTm() {
        return this.f21142tm;
    }

    public List<String> getUrl() {
        return this.url;
    }

    public List<String> getUrlfilters() {
        return this.urlfilters;
    }

    public double getWebViewOptCoefficient() {
        double d11 = this.webViewOptCoefficient;
        return d11 > 0.0d ? d11 : b.i();
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public void setConfinterval(long j11) {
        this.confinterval = j11;
    }

    public void setEnabled(boolean z11) {
        this.enabled = z11;
    }

    public void setInterval(long j11) {
        this.interval = j11;
    }

    public void setTm(long j11) {
        this.f21142tm = j11;
    }

    public void setUrl(List<String> list) {
        this.url = list;
    }

    public void setUrlfilters(List<String> list) {
        this.urlfilters = list;
    }

    public void setWebViewOptCoefficient(double d11) {
        this.webViewOptCoefficient = d11;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(MTPushConstants.Geofence.KEY_INTERVAL, this.interval);
            jSONObject.put("tm", this.f21142tm);
            jSONObject.put(Constants.ENABLED, this.enabled);
            JSONArray jSONArray = new JSONArray();
            List<String> list = this.url;
            if (list != null && !list.isEmpty()) {
                for (String put : this.url) {
                    jSONArray.put(put);
                }
            }
            jSONObject.put("url", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            List<String> list2 = this.urlfilters;
            if (list2 != null && !list2.isEmpty()) {
                for (String put2 : this.urlfilters) {
                    jSONArray2.put(put2);
                }
            }
            jSONObject.put("urlfilters", jSONArray2);
            jSONObject.put("confinterval", this.confinterval);
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
        return jSONObject;
    }

    public String toString() {
        JSONObject json = toJson();
        return json != null ? json.toString() : "{}";
    }
}
