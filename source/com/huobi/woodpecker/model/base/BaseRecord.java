package com.huobi.woodpecker.model.base;

import android.text.TextUtils;
import com.huobi.woodpecker.core.ActionType;
import com.huobi.woodpecker.model.base.IRecord;
import com.sumsub.sentry.a;
import com.tencent.android.tpush.common.MessageKey;
import com.tencent.qcloud.tuicore.TUIConstants;
import org.json.JSONException;
import org.json.JSONObject;

public class BaseRecord<T extends IRecord> implements IRecord {
    private ActionType action;
    private int app;
    private T data;
    private long date;
    private String env;
    private ExtRecord ext;
    private String sessionid;
    private String sid;
    private String source = String.valueOf(3);

    /* renamed from: ua  reason: collision with root package name */
    private String f21147ua;
    private String uid;
    private String uuid;

    public ActionType getAction() {
        return this.action;
    }

    public int getApp() {
        return this.app;
    }

    public T getData() {
        return this.data;
    }

    public long getDate() {
        return this.date;
    }

    public long getDateMillis() {
        long j11 = this.date;
        if (j11 > 0) {
            return j11 / 1000;
        }
        return 0;
    }

    public String getEnv() {
        return this.env;
    }

    public ExtRecord getExt() {
        return this.ext;
    }

    public String getSessionid() {
        return this.sessionid;
    }

    public String getSid() {
        return this.sid;
    }

    public String getSource() {
        return this.source;
    }

    public String getUa() {
        return this.f21147ua;
    }

    public String getUid() {
        return this.uid;
    }

    public String getUuid() {
        return this.uuid;
    }

    public boolean isActionEnabled() {
        ActionType actionType = this.action;
        return actionType != null && actionType.isEnable();
    }

    public void setAction(ActionType actionType) {
        this.action = actionType;
    }

    public void setApp(int i11) {
        this.app = i11;
    }

    public void setData(T t11) {
        this.data = t11;
    }

    public void setDate(long j11) {
        this.date = j11;
    }

    public void setEnv(String str) {
        this.env = str;
    }

    public void setExt(ExtRecord extRecord) {
        this.ext = extRecord;
    }

    public void setSessionid(String str) {
        this.sessionid = str;
    }

    public void setSid(String str) {
        this.sid = str;
    }

    public void setSource(String str) {
        this.source = str;
    }

    public void setUa(String str) {
        this.f21147ua = str;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void setUuid(String str) {
        this.uuid = str;
    }

    public JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(this.uuid)) {
                jSONObject.put(ZendeskIdentityStorage.UUID_KEY, this.uuid);
            }
            jSONObject.put(MessageKey.MSG_DATE, getDateMillis());
            jSONObject.put("ua", this.f21147ua);
            jSONObject.put("sid", this.sid);
            jSONObject.put("sessionid", this.sessionid);
            jSONObject.put(a.f30241h, this.app);
            if (!TextUtils.isEmpty(this.uid)) {
                jSONObject.put("uid", this.uid);
            }
            jSONObject.put("env", this.env);
            jSONObject.put("source", this.source);
            jSONObject.put("action", this.action);
            ExtRecord extRecord = this.ext;
            if (extRecord != null) {
                jSONObject.put(TUIConstants.TUIOfflinePush.NOTIFICATION_EXT_KEY, extRecord.toJsonObject());
            }
            T t11 = this.data;
            if (t11 != null) {
                jSONObject.put("data", t11.toJsonObject());
            }
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
        return jSONObject;
    }

    public String toJsonString() {
        return toJsonObject().toString();
    }

    public String toString() {
        return toJsonString();
    }
}
