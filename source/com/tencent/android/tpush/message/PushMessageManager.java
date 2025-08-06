package com.tencent.android.tpush.message;

import android.content.Context;
import android.content.Intent;
import com.tencent.android.tpush.XGPushManager;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.common.MessageKey;
import com.tencent.android.tpush.common.j;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.logging.TLogger;

public class PushMessageManager {
    public static final int CUSTOM_LAYOUT_TYPE_1 = 1;
    public static final int CUSTOM_LAYOUT_TYPE_2 = 2;
    public static final int CUSTOM_LAYOUT_TYPE_3 = 3;
    public static final int MESSAGE_TYPE_CLOUD_CTRL = 1000;
    public static final int MESSAGE_TYPE_CTRL = 3;
    public static final int MESSAGE_TYPE_IN_MSG = 7;
    public static final int MESSAGE_TYPE_NOTIFICATION = 1;
    public static final int MESSAGE_TYPE_TEXT = 2;

    /* renamed from: a  reason: collision with root package name */
    private long f69397a = -1;

    /* renamed from: b  reason: collision with root package name */
    private long f69398b = -1;

    /* renamed from: c  reason: collision with root package name */
    private long f69399c = -1;

    /* renamed from: d  reason: collision with root package name */
    private String f69400d = "";

    /* renamed from: e  reason: collision with root package name */
    private long f69401e = -1;

    /* renamed from: f  reason: collision with root package name */
    private String f69402f = "";

    /* renamed from: g  reason: collision with root package name */
    private String f69403g = "";

    /* renamed from: h  reason: collision with root package name */
    private long f69404h = -1;

    /* renamed from: i  reason: collision with root package name */
    private long f69405i = -1;

    /* renamed from: j  reason: collision with root package name */
    private String f69406j = "";

    /* renamed from: k  reason: collision with root package name */
    private String f69407k = "";

    /* renamed from: l  reason: collision with root package name */
    private String f69408l = "";

    /* renamed from: m  reason: collision with root package name */
    private Context f69409m = null;

    /* renamed from: n  reason: collision with root package name */
    private Intent f69410n = null;

    /* renamed from: o  reason: collision with root package name */
    private a f69411o = null;

    /* renamed from: p  reason: collision with root package name */
    private int f69412p = 0;
    public int pushChannel = 100;
    public long pushTime = 0;
    public long source = 0;
    public long targetType = 0;

    private PushMessageManager(Context context, Intent intent) {
        this.f69409m = context;
        this.f69410n = intent;
    }

    public static PushMessageManager getInstance(Context context, Intent intent) {
        PushMessageManager pushMessageManager = new PushMessageManager(context, intent);
        String decrypt = Rijndael.decrypt(intent.getStringExtra("content"));
        TLogger.d("PushMessageManager", "PushMessageManager content:" + decrypt);
        pushMessageManager.f69402f = decrypt;
        String decrypt2 = Rijndael.decrypt(intent.getStringExtra(MessageKey.MSG_IN_MSG));
        TLogger.d("PushMessageManager", "PushMessageManager inMsg:" + decrypt2);
        pushMessageManager.f69403g = decrypt2;
        pushMessageManager.f69398b = intent.getLongExtra("msgId", -1);
        TLogger.d("PushMessageManager", "PushMessageManager msgId:" + pushMessageManager.f69398b);
        pushMessageManager.f69399c = intent.getLongExtra("accId", -1);
        pushMessageManager.f69400d = intent.getStringExtra(Constants.XG_SYS_INTENT_KEY_THIRD_APP);
        pushMessageManager.f69401e = intent.getLongExtra(MessageKey.MSG_BUSI_MSG_ID, -1);
        pushMessageManager.f69397a = intent.getLongExtra(MessageKey.MSG_CHANNEL_ID, -1);
        pushMessageManager.f69404h = intent.getLongExtra(MessageKey.MSG_CREATE_TIMESTAMPS, -1);
        pushMessageManager.f69405i = intent.getLongExtra("type", -1);
        TLogger.d("PushMessageManager", "PushMessageManager type:" + pushMessageManager.f69405i);
        int intExtra = intent.getIntExtra(MessageKey.MSG_PUSH_CHANNEL, 100);
        pushMessageManager.pushTime = intent.getLongExtra(MessageKey.MSG_PUSH_TIME, -1);
        pushMessageManager.pushChannel = intExtra;
        String stringExtra = intent.getStringExtra("group_id");
        pushMessageManager.f69406j = stringExtra;
        if (j.b(stringExtra)) {
            pushMessageManager.f69406j = intent.getStringExtra("groupId");
        }
        pushMessageManager.targetType = intent.getLongExtra(MessageKey.MSG_TARGET_TYPE, 0);
        pushMessageManager.source = intent.getLongExtra("source", 0);
        pushMessageManager.f69407k = intent.getStringExtra(MessageKey.MSG_TEMPLATE_ID);
        pushMessageManager.f69408l = intent.getStringExtra(MessageKey.MSG_TRACE_ID);
        a aVar = null;
        int i11 = (int) pushMessageManager.f69405i;
        if (i11 == 1) {
            aVar = new d(decrypt);
        } else if (i11 == 2) {
            aVar = new f(decrypt);
        } else if (i11 == 3) {
            MessageManager.getInstance().onCrtlMsgHandle(context, decrypt);
            XGPushManager.msgAck(context, pushMessageManager);
        } else if (!(i11 == 7 || i11 == 1000)) {
            TLogger.e("PushMessageManager", "error type for message, drop it, type:" + pushMessageManager.f69405i + ",intent:" + intent);
            XGPushManager.msgAck(context, pushMessageManager);
        }
        if (aVar != null) {
            pushMessageManager.f69411o = aVar;
            aVar.a();
        }
        pushMessageManager.f69412p = intent.getIntExtra(MessageKey.MSG_REVOKEID, 0);
        return pushMessageManager;
    }

    public long getAccessId() {
        return this.f69399c;
    }

    public String getAppPkgName() {
        return this.f69400d;
    }

    public long getBusiMsgId() {
        return this.f69401e;
    }

    public long getChannelId() {
        return this.f69397a;
    }

    public String getContent() {
        return this.f69402f;
    }

    public Context getContext() {
        return this.f69409m;
    }

    public String getGroupId() {
        return this.f69406j;
    }

    public String getInMsg() {
        return this.f69403g;
    }

    public Intent getIntent() {
        return this.f69410n;
    }

    public a getMessageHolder() {
        return this.f69411o;
    }

    public long getMsgId() {
        return this.f69398b;
    }

    public int getRevokeId() {
        return this.f69412p;
    }

    public long getSource() {
        return this.source;
    }

    public long getTargetType() {
        return this.targetType;
    }

    public String getTemplateId() {
        return this.f69407k;
    }

    public long getTimestamps() {
        return this.f69404h;
    }

    public String getTraceId() {
        return this.f69408l;
    }

    public long getType() {
        return this.f69405i;
    }

    public void setAppPkgName(String str) {
        this.f69400d = str;
    }

    public void setChannelId(long j11) {
        this.f69397a = j11;
    }

    public void setGroupId(String str) {
        this.f69406j = str;
    }

    public void setSource(long j11) {
        this.source = j11;
    }

    public void setTargetType(long j11) {
        this.targetType = j11;
    }

    public void showNotifacition() {
        if (this.f69411o.b() == 1) {
            b.a(this.f69409m, this);
        }
    }

    public String toString() {
        return "PushMessageManager [msgId=" + this.f69398b + ", accessId=" + this.f69399c + ", busiMsgId=" + this.f69401e + ", content=" + this.f69402f + ", timestamps=" + this.f69404h + ", type=" + this.f69405i + ", intent=" + this.f69410n + ", messageHolder=" + this.f69411o + ", appPkgName=" + this.f69400d + ", revokeId=" + this.f69412p + ", templateId=" + this.f69407k + ", traceId=" + this.f69408l + "]";
    }
}
