package com.huawei.hms.common.internal;

import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class ResponseWrap {

    /* renamed from: a  reason: collision with root package name */
    private String f37946a;

    /* renamed from: b  reason: collision with root package name */
    private ResponseHeader f37947b;

    public ResponseWrap(ResponseHeader responseHeader) {
        this.f37947b = responseHeader;
    }

    public boolean fromJson(String str) {
        if (this.f37947b == null) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f37947b.setStatusCode(JsonUtil.getIntValue(jSONObject, "status_code"));
            this.f37947b.setErrorCode(JsonUtil.getIntValue(jSONObject, NativeProtocol.BRIDGE_ARG_ERROR_CODE));
            this.f37947b.setErrorReason(JsonUtil.getStringValue(jSONObject, "error_reason"));
            this.f37947b.setSrvName(JsonUtil.getStringValue(jSONObject, "srv_name"));
            this.f37947b.setApiName(JsonUtil.getStringValue(jSONObject, "api_name"));
            this.f37947b.setAppID(JsonUtil.getStringValue(jSONObject, "app_id"));
            this.f37947b.setPkgName(JsonUtil.getStringValue(jSONObject, "pkg_name"));
            this.f37947b.setSessionId(JsonUtil.getStringValue(jSONObject, "session_id"));
            this.f37947b.setTransactionId(JsonUtil.getStringValue(jSONObject, "transaction_id"));
            this.f37947b.setResolution(JsonUtil.getStringValue(jSONObject, CommonCode.MapKey.HAS_RESOLUTION));
            this.f37946a = JsonUtil.getStringValue(jSONObject, TtmlNode.TAG_BODY);
            return true;
        } catch (JSONException e11) {
            HMSLog.e("ResponseWrap", "fromJson failed: " + e11.getMessage());
            return false;
        }
    }

    public String getBody() {
        if (TextUtils.isEmpty(this.f37946a)) {
            this.f37946a = new JSONObject().toString();
        }
        return this.f37946a;
    }

    public ResponseHeader getResponseHeader() {
        return this.f37947b;
    }

    public void setBody(String str) {
        this.f37946a = str;
    }

    public void setResponseHeader(ResponseHeader responseHeader) {
        this.f37947b = responseHeader;
    }

    public String toJson() {
        if (this.f37947b == null) {
            return "{}";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status_code", this.f37947b.getStatusCode());
            jSONObject.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, this.f37947b.getErrorCode());
            jSONObject.put("error_reason", this.f37947b.getErrorReason());
            jSONObject.put("srv_name", this.f37947b.getSrvName());
            jSONObject.put("api_name", this.f37947b.getApiName());
            jSONObject.put("app_id", this.f37947b.getAppID());
            jSONObject.put("pkg_name", this.f37947b.getPkgName());
            jSONObject.put("transaction_id", this.f37947b.getTransactionId());
            jSONObject.put(CommonCode.MapKey.HAS_RESOLUTION, this.f37947b.getResolution());
            String sessionId = this.f37947b.getSessionId();
            if (!TextUtils.isEmpty(sessionId)) {
                jSONObject.put("session_id", sessionId);
            }
            if (!TextUtils.isEmpty(this.f37946a)) {
                jSONObject.put(TtmlNode.TAG_BODY, this.f37946a);
            }
        } catch (JSONException e11) {
            HMSLog.e("ResponseWrap", "toJson failed: " + e11.getMessage());
        }
        return jSONObject.toString();
    }

    public String toString() {
        return "ResponseWrap{body='" + this.f37946a + '\'' + ", responseHeader=" + this.f37947b + '}';
    }
}
