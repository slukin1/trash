package com.tencent.android.tpush;

import android.app.Notification;
import android.content.Context;
import android.util.Pair;
import org.json.JSONObject;

public class XGBasicPushNotificationBuilder extends XGPushNotificationBuilder {
    public void a(JSONObject jSONObject) {
    }

    public void b(JSONObject jSONObject) {
    }

    public Pair<Notification, Object> buildNotification(Context context) {
        return a(context);
    }

    public String getType() {
        return "basic";
    }
}
