package com.huobi.woodpecker.net;

import java.io.Serializable;
import org.json.JSONObject;

public class HttpEntity implements Serializable {
    public int code;
    public String data;
    public String message;
    public boolean success;

    public static HttpEntity fromJsonStr(String str) {
        HttpEntity httpEntity = new HttpEntity();
        try {
            JSONObject jSONObject = new JSONObject(str);
            httpEntity.code = jSONObject.optInt("code");
            httpEntity.message = jSONObject.optString("message");
            httpEntity.data = jSONObject.optString("data");
            httpEntity.success = jSONObject.optBoolean("success");
        } catch (Exception e11) {
            e11.printStackTrace();
            httpEntity.code = 910001;
            httpEntity.message = "格式错误";
        }
        return httpEntity;
    }

    public int getCode() {
        return this.code;
    }

    public String getData() {
        return this.data;
    }

    public String getMessage() {
        return this.message;
    }

    public boolean isSuccess() {
        return this.success && this.code == 200;
    }

    public void setCode(int i11) {
        this.code = i11;
    }

    public void setData(String str) {
        this.data = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setSuccess(boolean z11) {
        this.success = z11;
    }
}
