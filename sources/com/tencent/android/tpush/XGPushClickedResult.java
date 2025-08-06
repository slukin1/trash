package com.tencent.android.tpush;

import android.content.Intent;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.common.MessageKey;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.logging.TLogger;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class XGPushClickedResult implements XGIResult, Serializable {
    public static final int NOTIFACTION_CLICKED_TYPE = NotificationAction.clicked.getType();
    public static final int NOTIFACTION_DELETED_TYPE = NotificationAction.delete.getType();
    public static final int NOTIFACTION_DOWNLOAD_CANCEL_TYPE = NotificationAction.download_cancel.getType();
    public static final int NOTIFACTION_DOWNLOAD_TYPE = NotificationAction.download.getType();
    public static final int NOTIFACTION_OPEN_CANCEL_TYPE = NotificationAction.open_cancel.getType();
    public static final int NOTIFACTION_OPEN_TYPE = NotificationAction.open.getType();
    public static final int NOTIFICATION_ACTION_ACTIVITY = NotificationAction.activity.getType();
    private static final String TAG = "XGPushClickedResult";
    private static final long serialVersionUID = 5485267763104201539L;
    public int actionType = NotificationAction.clicked.getType();
    public String activityName = "";
    public String content = "";
    public String customContent = "";
    public boolean isCustomLayout = false;
    public long msgId = 0;
    public int notificationActionType = NotificationAction.activity.getType();
    public int pushChannel = 100;
    public String templateId = "";
    public String title = "";
    public String traceId = "";

    public long getActionType() {
        return (long) this.actionType;
    }

    public String getActivityName() {
        return this.activityName;
    }

    public String getContent() {
        return this.content;
    }

    public String getCustomContent() {
        return this.customContent;
    }

    public long getMsgId() {
        return this.msgId;
    }

    public int getNotificationActionType() {
        return this.notificationActionType;
    }

    public int getPushChannel() {
        return this.pushChannel;
    }

    public String getTemplateId() {
        return this.templateId;
    }

    public String getTitle() {
        return this.title;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public boolean isCustomLayout() {
        return this.isCustomLayout;
    }

    public void parseIntent(Intent intent) {
        this.msgId = intent.getLongExtra("msgId", -1);
        this.activityName = intent.getStringExtra("activity");
        this.title = Rijndael.decrypt(intent.getStringExtra("title"));
        this.content = Rijndael.decrypt(intent.getStringExtra("content"));
        this.customContent = Rijndael.decrypt(intent.getStringExtra("custom_content"));
        this.actionType = intent.getIntExtra("action", NotificationAction.clicked.getType());
        this.notificationActionType = intent.getIntExtra("notificationActionType", NotificationAction.activity.getType());
        this.pushChannel = intent.getIntExtra(Constants.PUSH_CHANNEL, 100);
        this.templateId = intent.getStringExtra(MessageKey.MSG_TEMPLATE_ID);
        this.traceId = intent.getStringExtra(MessageKey.MSG_TRACE_ID);
        this.isCustomLayout = intent.getBooleanExtra(Constants.FLAG_IS_SHOW_IN_CUSTOM_LAYOUT, false);
        int i11 = this.pushChannel;
        if (i11 == 101 || i11 == 99) {
            try {
                this.activityName = URLDecoder.decode(this.activityName, "UTF-8");
            } catch (UnsupportedEncodingException e11) {
                TLogger.d(TAG, "parseIntent activityName :" + e11.toString());
            }
        }
    }

    public String toString() {
        return "XGPushClickedResult [msgId = " + this.msgId + ", title = " + this.title + ", content = " + this.content + ", customContent = " + this.customContent + ", activityName = " + this.activityName + ", actionType = " + this.actionType + ", pushChannel = " + this.pushChannel + ", notificationActionType = " + this.notificationActionType + ", templateId = " + this.templateId + ", traceId = " + this.traceId + ", isCustomLayout = " + this.isCustomLayout + "]";
    }
}
