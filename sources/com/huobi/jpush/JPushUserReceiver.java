package com.huobi.jpush;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.engagelab.privates.common.component.MTCommonReceiver;
import com.engagelab.privates.core.api.MTCorePrivatesApi;
import com.engagelab.privates.push.api.CustomMessage;
import com.engagelab.privates.push.api.NotificationMessage;
import com.engagelab.privates.push.api.PlatformTokenMessage;
import com.huobi.app.JumpActivity;
import com.huobi.jpush.listener.StatusObserver;
import gs.g;
import i6.d;
import org.json.JSONObject;

public class JPushUserReceiver extends MTCommonReceiver {
    public void onConnectStatus(Context context, boolean z11) {
        d.j("UserReceiver", "onConnectState:" + z11);
        if (StatusObserver.a().b() != null) {
            StatusObserver.a().b().a(z11);
        }
        if (z11) {
            String registrationId = MTCorePrivatesApi.getRegistrationId(context);
            d.j("UserReceiver", "registrationId:" + registrationId);
        }
    }

    public void onCustomMessage(Context context, CustomMessage customMessage) {
        d.j("UserReceiver", "onCustomMessage:" + customMessage.toString());
    }

    public void onNotificationArrived(Context context, NotificationMessage notificationMessage) {
        d.j("UserReceiver", "onNotificationArrived:" + notificationMessage.toString());
    }

    public void onNotificationClicked(Context context, NotificationMessage notificationMessage) {
        try {
            d.j("UserReceiver", "onNotificationClicked:" + notificationMessage.toString());
            Bundle extras = notificationMessage.getExtras();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("template_code", extras.get("template_code").toString());
            jSONObject.put("type", extras.get("type").toString());
            jSONObject.put("value", extras.get("value").toString());
            g.k(2, notificationMessage.toString());
            Intent Af = JumpActivity.Af(context, jSONObject.toString());
            Af.addFlags(268435456);
            context.startActivity(Af);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void onNotificationDeleted(Context context, NotificationMessage notificationMessage) {
        d.j("UserReceiver", "onNotificationDeleted:" + notificationMessage.toString());
    }

    public void onNotificationStatus(Context context, boolean z11) {
        d.j("UserReceiver", "onNotificationStatus:" + z11);
        if (StatusObserver.a().b() != null) {
            StatusObserver.a().b().b(z11);
        }
    }

    public void onPlatformToken(Context context, PlatformTokenMessage platformTokenMessage) {
        d.j("UserReceiver", "onPlatformToken:" + platformTokenMessage.toString());
    }
}
