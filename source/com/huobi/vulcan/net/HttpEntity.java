package com.huobi.vulcan.net;

import java.io.Serializable;
import org.json.JSONObject;

public class HttpEntity implements Serializable {
    public static final int CODE_NO_UPLOAD_COLLECT_DATA = 93001;
    public int code;
    public String data;
    public String message;

    public static HttpEntity fromJsonStr(String str) {
        HttpEntity httpEntity = new HttpEntity();
        try {
            JSONObject jSONObject = new JSONObject(str);
            httpEntity.code = jSONObject.optInt("code");
            httpEntity.message = jSONObject.optString("message");
            httpEntity.data = jSONObject.optString("data");
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

    public boolean isNoUploadCollectData() {
        return this.code == 93001;
    }

    public boolean isSucceed() {
        return this.code == 200;
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
}
