package com.tencent.android.tpush.service.protocol;

import android.content.Context;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.qcloud.tuicore.TUIConstants;
import org.json.JSONObject;

public class i extends d {

    /* renamed from: a  reason: collision with root package name */
    public long f69732a = 0;

    /* renamed from: b  reason: collision with root package name */
    public long f69733b = 0;

    /* renamed from: c  reason: collision with root package name */
    public long f69734c = 0;

    /* renamed from: d  reason: collision with root package name */
    public long f69735d = 0;

    /* renamed from: e  reason: collision with root package name */
    public long f69736e = 0;

    /* renamed from: f  reason: collision with root package name */
    public long f69737f = 0;

    /* renamed from: g  reason: collision with root package name */
    public String f69738g = "";

    /* renamed from: h  reason: collision with root package name */
    public String f69739h = "";

    /* renamed from: i  reason: collision with root package name */
    public String f69740i = "";

    public JSONObject a(Context context) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", this.f69732a);
        jSONObject.put("accessId", this.f69733b);
        jSONObject.put("msgId", this.f69734c);
        jSONObject.put("broadcastId", this.f69735d);
        jSONObject.put("msgTimestamp", this.f69736e);
        jSONObject.put("clientTimestamp", this.f69737f);
        jSONObject.put(RemoteMessageConst.MessageBody.MSG, this.f69738g);
        jSONObject.put(TUIConstants.TUIOfflinePush.NOTIFICATION_EXT_KEY, this.f69739h);
        jSONObject.put("pkgName", this.f69740i);
        return jSONObject;
    }

    public MessageType a() {
        return MessageType.COMMON_REPORT;
    }
}
