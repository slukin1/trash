package com.huobi.vulcan.model;

import com.facebook.internal.NativeProtocol;
import com.huobi.kalle.simple.JsonFormat;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ExceptionLogModel implements JsonFormat {
    private String error_code;
    private String error_msg;
    private long timestamp;

    public static List<ExceptionLogModel> fromJsonArrStr(String str) {
        try {
            return fromJsonArray(new JSONArray(str));
        } catch (JSONException e11) {
            e11.printStackTrace();
            return null;
        }
    }

    public static List<ExceptionLogModel> fromJsonArray(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            ExceptionLogModel exceptionLogModel = new ExceptionLogModel();
            exceptionLogModel.fromJson(jSONArray.optJSONObject(i11));
            arrayList.add(exceptionLogModel);
        }
        return arrayList;
    }

    public static JSONArray toJsonArr(List<ExceptionLogModel> list) {
        JSONArray jSONArray = null;
        try {
            JSONArray jSONArray2 = new JSONArray();
            if (list == null) {
                return jSONArray2;
            }
            try {
                for (ExceptionLogModel json : list) {
                    jSONArray2.put(json.toJson());
                }
                return jSONArray2;
            } catch (Exception e11) {
                e = e11;
                jSONArray = jSONArray2;
                e.printStackTrace();
                return jSONArray;
            }
        } catch (Exception e12) {
            e = e12;
            e.printStackTrace();
            return jSONArray;
        }
    }

    public void fromJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.timestamp = jSONObject.optLong("timestamp");
            this.error_code = jSONObject.optString(NativeProtocol.BRIDGE_ARG_ERROR_CODE);
            this.error_msg = jSONObject.optString("error_msg");
        }
    }

    public String getError_code() {
        return this.error_code;
    }

    public String getError_msg() {
        return this.error_msg;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void setError_code(String str) {
        this.error_code = str;
    }

    public void setError_msg(String str) {
        this.error_msg = str;
    }

    public void setTimestamp(long j11) {
        this.timestamp = j11;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("timestamp", this.timestamp);
            jSONObject.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, this.error_code);
            jSONObject.put("error_msg", this.error_msg);
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
        return jSONObject;
    }

    public String toString() {
        return "timestamp=" + this.timestamp + "&error_code=" + this.error_code + "&error_msg=" + this.error_msg;
    }
}
