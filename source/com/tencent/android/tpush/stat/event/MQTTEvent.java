package com.tencent.android.tpush.stat.event;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.push.AttributionReporter;
import com.tencent.android.tpush.common.MessageKey;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.message.PushMessageManager;
import com.tencent.android.tpush.stat.b.b;
import com.tencent.tpns.baseapi.XGApiConfig;
import com.tencent.tpns.baseapi.base.device.GuidInfoManager;
import org.json.JSONObject;

public class MQTTEvent extends Event {
    public long accessid;
    public String appVersion;
    public String appkey;
    public String eventId;
    public long msgBusiId;
    public long msgId;
    public long msgType;
    public String nGroupId;
    public JSONObject prop;
    public int pushAction;
    public int pushChannel;
    public long pushtime;
    public String sdkVersion;
    public long source;
    public long targetType;
    public String templateId;
    public long timestamp;
    public String token;
    public String traceId;

    public MQTTEvent(Context context, String str, long j11) {
        super(context, str, j11);
        this.appkey = null;
        this.accessid = 0;
        this.appVersion = null;
        this.sdkVersion = null;
        this.token = null;
        this.msgId = -1;
        this.msgType = -1;
        this.pushAction = -1;
        this.nGroupId = null;
        this.targetType = 0;
        this.source = 0;
        this.eventId = null;
        this.prop = null;
        this.templateId = "";
        this.traceId = "";
        this.appkey = str;
        this.accessid = j11;
    }

    private void a(PushMessageManager pushMessageManager) {
        this.msgBusiId = pushMessageManager.getBusiMsgId();
        this.timestamp = System.currentTimeMillis() / 1000;
        this.pushtime = pushMessageManager.getTimestamps() / 1000;
        this.pushChannel = pushMessageManager.pushChannel;
        this.appVersion = b.c(this.f70003k);
        this.sdkVersion = "1.4.4.2";
        this.token = GuidInfoManager.getToken(this.f70003k);
        this.msgId = pushMessageManager.getMsgId();
        this.msgType = pushMessageManager.getType();
        this.nGroupId = pushMessageManager.getGroupId();
        this.targetType = pushMessageManager.getTargetType();
        this.source = pushMessageManager.getSource();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            MQTTEvent mQTTEvent = (MQTTEvent) obj;
            try {
                if (this.accessid == mQTTEvent.accessid && this.timestamp == mQTTEvent.timestamp && this.msgType == mQTTEvent.msgType && this.pushAction == mQTTEvent.pushAction && this.msgId == mQTTEvent.msgId && this.appVersion.equals(mQTTEvent.appVersion) && this.token.equals(mQTTEvent.token) && this.targetType == mQTTEvent.targetType && this.source == mQTTEvent.source) {
                    return true;
                }
                return false;
            } catch (Throwable th2) {
                TLogger.d("MQTTEvent equals Error:", th2.getMessage());
            }
        }
        return false;
    }

    public long getAccessid() {
        return this.accessid;
    }

    public String getAppkey() {
        return this.appkey;
    }

    public EventType getType() {
        return null;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public boolean onEncode(JSONObject jSONObject) {
        return true;
    }

    public void setAccessid(long j11) {
        this.accessid = j11;
    }

    public void setAppkey(String str) {
        this.appkey = str;
    }

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("accessId", this.accessid);
            jSONObject.put("pushAction", this.pushAction);
            jSONObject.put("msgId", this.msgId);
            jSONObject.put("msgType", this.msgType);
            jSONObject.put("msgId", this.msgId);
            jSONObject.put("pushtime", this.pushtime);
            jSONObject.put("timestamp", this.timestamp);
            jSONObject.put(MessageKey.MSG_TEMPLATE_ID, this.templateId);
            jSONObject.put(MessageKey.MSG_TRACE_ID, this.traceId);
            String str = this.token;
            if (str != null) {
                jSONObject.put("token", str);
            }
            String str2 = this.appkey;
            if (str2 != null) {
                jSONObject.put("accessKey", str2);
            }
            String str3 = this.appVersion;
            if (str3 != null) {
                jSONObject.put(AttributionReporter.APP_VERSION, str3);
            }
            String str4 = this.sdkVersion;
            if (str4 != null) {
                jSONObject.put("sdkVersion", str4);
            }
            String str5 = this.nGroupId;
            if (str5 != null) {
                jSONObject.put("groupId", str5);
            }
            jSONObject.put(MessageKey.MSG_PUSH_CHANNEL, this.pushChannel);
            long j11 = this.targetType;
            if (j11 > 0) {
                jSONObject.put(MessageKey.MSG_TARGET_TYPE, j11);
            }
            long j12 = this.source;
            if (j12 > 0) {
                jSONObject.put("source", j12);
            }
            String str6 = this.eventId;
            if (str6 != null && !TextUtils.isEmpty(str6)) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("eventId", this.eventId);
                JSONObject jSONObject3 = this.prop;
                if (!(jSONObject3 == null || jSONObject3.length() == 0)) {
                    jSONObject2.put("kv", this.prop);
                }
                jSONObject.put("customEvent", jSONObject2);
            }
            return jSONObject.toString();
        } catch (Throwable th2) {
            TLogger.d("MQTTEvent toJsonString Error:", th2.getMessage());
            return null;
        }
    }

    public String toString() {
        return toJsonString();
    }

    public MQTTEvent(Context context, long j11) {
        this(context, XGApiConfig.getAccessKey(context), j11);
    }

    public MQTTEvent(Context context) {
        super(context, XGApiConfig.getAccessKey(context), XGApiConfig.getAccessId(context));
        this.appkey = null;
        this.accessid = 0;
        this.appVersion = null;
        this.sdkVersion = null;
        this.token = null;
        this.msgId = -1;
        this.msgType = -1;
        this.pushAction = -1;
        this.nGroupId = null;
        this.targetType = 0;
        this.source = 0;
        this.eventId = null;
        this.prop = null;
        this.templateId = "";
        this.traceId = "";
        this.appkey = XGApiConfig.getAccessKey(context);
        this.accessid = XGApiConfig.getAccessId(context);
    }

    public MQTTEvent(Context context, long j11, PushMessageManager pushMessageManager) {
        this(context, j11);
        a(pushMessageManager);
    }
}
