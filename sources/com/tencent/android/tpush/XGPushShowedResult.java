package com.tencent.android.tpush;

import android.content.Intent;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.common.MessageKey;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.logging.TLogger;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class XGPushShowedResult implements XGIResult {
    public static final int NOTIFICATION_ACTION_ACTIVITY = NotificationAction.activity.getType();
    public static final int NOTIFICATION_ACTION_INTENT = NotificationAction.intent.getType();
    public static final int NOTIFICATION_ACTION_INTENT_WIHT_ACTION = NotificationAction.intent_with_action.getType();
    public static final int NOTIFICATION_ACTION_PACKAGE = NotificationAction.action_package.getType();
    public static final int NOTIFICATION_ACTION_URL = NotificationAction.url.getType();

    /* renamed from: a  reason: collision with root package name */
    public long f68071a = 0;

    /* renamed from: b  reason: collision with root package name */
    public String f68072b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f68073c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f68074d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f68075e = "";

    /* renamed from: f  reason: collision with root package name */
    public int f68076f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f68077g = NotificationAction.activity.getType();

    /* renamed from: h  reason: collision with root package name */
    public int f68078h = 100;

    /* renamed from: i  reason: collision with root package name */
    public boolean f68079i = false;
    public String templateId = "";
    public String traceId = "";

    public String getActivity() {
        return this.f68075e;
    }

    public String getContent() {
        return this.f68073c;
    }

    public String getCustomContent() {
        return this.f68074d;
    }

    public long getMsgId() {
        return this.f68071a;
    }

    public int getNotifactionId() {
        return this.f68076f;
    }

    public int getNotificationActionType() {
        return this.f68077g;
    }

    public int getPushChannel() {
        return this.f68078h;
    }

    public String getTemplateId() {
        return this.templateId;
    }

    public String getTitle() {
        return this.f68072b;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public boolean isCustomLayout() {
        return this.f68079i;
    }

    public void parseIntent(Intent intent) {
        this.f68071a = intent.getLongExtra("msgId", -1);
        this.f68075e = intent.getStringExtra("activity");
        this.f68072b = Rijndael.decrypt(intent.getStringExtra("title"));
        this.f68073c = Rijndael.decrypt(intent.getStringExtra("content"));
        this.f68077g = intent.getIntExtra("notificationActionType", NotificationAction.activity.getType());
        this.f68074d = Rijndael.decrypt(intent.getStringExtra("custom_content"));
        this.f68076f = intent.getIntExtra(MessageKey.NOTIFACTION_ID, 0);
        this.f68078h = intent.getIntExtra(Constants.PUSH_CHANNEL, 100);
        this.templateId = intent.getStringExtra(MessageKey.MSG_TEMPLATE_ID);
        this.traceId = intent.getStringExtra(MessageKey.MSG_TRACE_ID);
        this.f68079i = intent.getBooleanExtra(Constants.FLAG_IS_SHOW_IN_CUSTOM_LAYOUT, false);
        int i11 = this.f68078h;
        if (i11 == 101 || i11 == 99) {
            try {
                this.f68075e = URLDecoder.decode(this.f68075e, "UTF-8");
            } catch (UnsupportedEncodingException e11) {
                TLogger.d("XGPushShowedResult", "parseIntent activityName :" + e11.toString());
            }
        }
    }

    public String toString() {
        return "XGPushShowedResult [msgId = " + this.f68071a + ", title = " + this.f68072b + ", content = " + this.f68073c + ", customContent=" + this.f68074d + ", activity = " + this.f68075e + ", notificationActionType = " + this.f68077g + ", pushChannel = " + this.f68078h + ", templateId = " + this.templateId + ", traceId = " + this.traceId + ", isCustomLayout = " + this.f68079i + "]";
    }
}
