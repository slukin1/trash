package com.huobi.vulcan.model;

import com.huobi.kalle.simple.JsonFormat;
import com.huobi.vulcan.core.Scene;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Config implements JsonFormat, Comparable<Config> {
    public String cHash;
    public int dataUpload;
    public long overdue;
    public List<String> parameters;
    public int scenes;

    public static List<Config> fromJsonArrStr(String str) {
        try {
            return fromJsonArray(new JSONArray(str));
        } catch (JSONException e11) {
            e11.printStackTrace();
            return null;
        }
    }

    public static List<Config> fromJsonArray(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            Config config = new Config();
            config.fromJson(jSONArray.optJSONObject(i11));
            arrayList.add(config);
        }
        return arrayList;
    }

    public static Config getDefaultConfig() {
        Config config = new Config();
        config.scenes = 0;
        config.cHash = "ffffffffffffffffffffffffffffffff";
        config.overdue = Long.MAX_VALUE;
        config.dataUpload = 1;
        return config;
    }

    public void fromJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.scenes = jSONObject.optInt("scenes");
            JSONArray optJSONArray = jSONObject.optJSONArray("parameters");
            this.parameters = new ArrayList();
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i11 = 0; i11 < optJSONArray.length(); i11++) {
                    this.parameters.add(optJSONArray.optString(i11));
                }
            }
            this.cHash = jSONObject.optString("cHash", "");
            this.overdue = jSONObject.optLong("overdue");
            this.dataUpload = jSONObject.optInt("dataUpload");
        }
    }

    public int getDataUpload() {
        return this.dataUpload;
    }

    public long getOverdue() {
        return this.overdue;
    }

    public List<String> getParameters() {
        return this.parameters;
    }

    public int getScenes() {
        return this.scenes;
    }

    public String getcHash() {
        return this.cHash;
    }

    public boolean isInit() {
        return this.scenes == Scene.Init.getVal();
    }

    public boolean isNeedUpload() {
        return this.dataUpload == 1;
    }

    public boolean isOverdue() {
        return Calendar.getInstance(TimeZone.getTimeZone("GMT-0")).getTimeInMillis() >= this.overdue;
    }

    public void setDataUpload(int i11) {
        this.dataUpload = i11;
    }

    public void setOverdue(long j11) {
        this.overdue = j11;
    }

    public void setParameters(List<String> list) {
        this.parameters = list;
    }

    public void setScenes(int i11) {
        this.scenes = i11;
    }

    public void setcHash(String str) {
        this.cHash = str;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("scenes", this.scenes);
            JSONArray jSONArray = new JSONArray();
            List<String> list = this.parameters;
            if (list != null) {
                for (String put : list) {
                    jSONArray.put(put);
                }
            }
            jSONObject.put("parameters", jSONArray);
            jSONObject.put("cHash", this.cHash);
            jSONObject.put("overdue", this.overdue);
            jSONObject.put("dataUpload", this.dataUpload);
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
        return jSONObject;
    }

    public String toString() {
        return toJson().toString();
    }

    public int compareTo(Config config) {
        long j11 = this.overdue;
        long j12 = config.overdue;
        if (j11 > j12) {
            return 1;
        }
        return j11 == j12 ? 0 : -1;
    }
}
