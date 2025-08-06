package com.tencent.android.tpush;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import com.tencent.android.tpush.common.BroadcastAgent;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.common.MessageKey;
import com.tencent.android.tpush.common.j;
import com.tencent.android.tpush.d.b;
import com.tencent.android.tpush.data.MessageId;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.message.PushMessageManager;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.baseapi.base.util.TTask;
import com.tencent.tpns.dataacquisition.DeviceInfos;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public abstract class XGPushBaseReceiver extends BroadcastReceiver {
    public static final int SUCCESS = 0;

    /* renamed from: b  reason: collision with root package name */
    private static long f67849b;

    /* renamed from: a  reason: collision with root package name */
    private long f67850a = 0;

    private void d(Context context, Intent intent) {
        XGPushConfig.changeHuaweiBadgeNum(context, -1);
        int intExtra = intent.getIntExtra(Constants.PUSH_CHANNEL, 100);
        long longExtra = intent.getLongExtra("accId", 0);
        List<Long> accessidList = XGPushConfig.getAccessidList(context);
        if (accessidList == null || accessidList.size() <= 0) {
            TLogger.e("XGPushBaseReceiver", "accessIdList " + accessidList + " local accessid " + longExtra);
            TLogger.e("XGPushBaseReceiver", "give up msg");
        } else if (!accessidList.contains(Long.valueOf(longExtra)) || !(intExtra == 100 || intExtra == 101 || intExtra == 99)) {
            XGPushClickedResult xGPushClickedResult = new XGPushClickedResult();
            xGPushClickedResult.content = intent.getStringExtra("content");
            xGPushClickedResult.title = intent.getStringExtra("title");
            xGPushClickedResult.customContent = intent.getStringExtra("custom_content");
            xGPushClickedResult.pushChannel = intent.getIntExtra(Constants.PUSH_CHANNEL, 0);
            xGPushClickedResult.actionType = intent.getIntExtra("action", 0);
            xGPushClickedResult.customContent = intent.getStringExtra("custom_content");
            xGPushClickedResult.msgId = intent.getLongExtra("msgId", 0);
            xGPushClickedResult.notificationActionType = intent.getIntExtra("notificationActionType", NotificationAction.activity.getType());
            xGPushClickedResult.activityName = intent.getStringExtra("activity");
            xGPushClickedResult.templateId = intent.getStringExtra(MessageKey.MSG_TEMPLATE_ID);
            xGPushClickedResult.traceId = intent.getStringExtra(MessageKey.MSG_TRACE_ID);
            onNotificationClickedResult(context, xGPushClickedResult);
        } else {
            XGPushClickedResult xGPushClickedResult2 = new XGPushClickedResult();
            xGPushClickedResult2.parseIntent(intent);
            onNotificationClickedResult(context, xGPushClickedResult2);
        }
    }

    private void e(Context context, Intent intent, int i11) {
        XGPushRegisterResult xGPushRegisterResult = new XGPushRegisterResult();
        if (!intent.getBooleanExtra(Constants.FLAG_REGISTER_FROM_CLOUDCTRL, false)) {
            if (intent.getIntExtra(Constants.PUSH_CHANNEL, 100) == 100) {
                xGPushRegisterResult.parseIntent(intent);
            } else {
                xGPushRegisterResult.f68070h = intent.getIntExtra(Constants.PUSH_CHANNEL, 0);
                xGPushRegisterResult.f68069g = intent.getStringExtra(Constants.OTHER_PUSH_TOKEN);
                int intExtra = intent.getIntExtra(Constants.FEEDBACK_NOT_UPDATE_TOKEN_KEY, 0);
                if (i11 == 0 && !j.b(xGPushRegisterResult.f68069g) && intExtra == 0) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - f67849b > 10000) {
                        f67849b = currentTimeMillis;
                        b.a(context);
                    }
                }
            }
            onRegisterResult(context, i11, xGPushRegisterResult);
        }
    }

    /* access modifiers changed from: private */
    public void f(Context context, Intent intent) {
        XGPushTextMessage xGPushTextMessage = new XGPushTextMessage();
        xGPushTextMessage.f68080a = intent.getLongExtra("msgId", 0);
        xGPushTextMessage.f68084e = intent.getIntExtra(Constants.PUSH_CHANNEL, 100);
        xGPushTextMessage.f68081b = Rijndael.decrypt(intent.getStringExtra("title"));
        xGPushTextMessage.f68082c = Rijndael.decrypt(intent.getStringExtra("content"));
        xGPushTextMessage.f68083d = Rijndael.decrypt(intent.getStringExtra("custom_content"));
        xGPushTextMessage.f68085f = intent.getStringExtra(MessageKey.MSG_TEMPLATE_ID);
        xGPushTextMessage.f68086g = intent.getStringExtra(MessageKey.MSG_TRACE_ID);
        xGPushTextMessage.a(intent);
        onInMsgReceivedResult(context, xGPushTextMessage);
    }

    private void g(Context context, Intent intent) {
        XGPushShowedResult xGPushShowedResult = new XGPushShowedResult();
        xGPushShowedResult.parseIntent(intent);
        onInMsgShowedResult(context, xGPushShowedResult);
    }

    private void h(Context context, Intent intent) {
        XGPushClickedResult xGPushClickedResult = new XGPushClickedResult();
        xGPushClickedResult.parseIntent(intent);
        onInMsgClickedResult(context, xGPushClickedResult);
    }

    public abstract void onDeleteAccountResult(Context context, int i11, String str);

    public abstract void onDeleteAttributeResult(Context context, int i11, String str);

    public abstract void onDeleteTagResult(Context context, int i11, String str);

    public void onInMsgClickedResult(Context context, XGPushClickedResult xGPushClickedResult) {
    }

    public void onInMsgReceivedResult(Context context, XGPushTextMessage xGPushTextMessage) {
    }

    public void onInMsgShowedResult(Context context, XGPushShowedResult xGPushShowedResult) {
    }

    public abstract void onNotificationClickedResult(Context context, XGPushClickedResult xGPushClickedResult);

    public abstract void onNotificationShowedResult(Context context, XGPushShowedResult xGPushShowedResult);

    public abstract void onQueryTagsResult(Context context, int i11, String str, String str2);

    public final void onReceive(final Context context, final Intent intent) {
        PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
        if (context != null && intent != null) {
            CommonWorkingThread.getInstance().execute(new TTask() {
                public void TRun() {
                    try {
                        if (j.a(context) <= 0) {
                            String action = intent.getAction();
                            if (Constants.ACTION_PUSH_MESSAGE.equals(action)) {
                                if (intent.getLongExtra("type", -1) == 7) {
                                    XGPushBaseReceiver.this.f(context, intent);
                                } else {
                                    XGPushBaseReceiver.this.a(context, intent);
                                }
                            } else if (Constants.ACTION_FEEDBACK.equals(action)) {
                                XGPushBaseReceiver.this.b(context, intent);
                            } else {
                                TLogger.e("XGPushBaseReceiver", "未知的action:" + action);
                            }
                        }
                    } catch (Throwable th2) {
                        TLogger.e("XGPushBaseReceiver", "onReceive handle error.", th2);
                    }
                }
            });
        }
    }

    public abstract void onRegisterResult(Context context, int i11, XGPushRegisterResult xGPushRegisterResult);

    public abstract void onSetAccountResult(Context context, int i11, String str);

    public abstract void onSetAttributeResult(Context context, int i11, String str);

    public abstract void onSetTagResult(Context context, int i11, String str);

    public abstract void onTextMessage(Context context, XGPushTextMessage xGPushTextMessage);

    public abstract void onUnregisterResult(Context context, int i11);

    /* access modifiers changed from: private */
    public void a(Context context, Intent intent) {
        int intExtra = intent.getIntExtra(Constants.PUSH_CHANNEL, 100);
        if (intExtra == 100) {
            PushMessageManager instance = PushMessageManager.getInstance(context, intent);
            if (instance.getMessageHolder().b() == 2) {
                XGPushTextMessage xGPushTextMessage = new XGPushTextMessage();
                xGPushTextMessage.f68080a = instance.getMsgId();
                xGPushTextMessage.f68084e = intExtra;
                xGPushTextMessage.f68081b = instance.getMessageHolder().d();
                xGPushTextMessage.f68082c = instance.getMessageHolder().e();
                xGPushTextMessage.f68083d = instance.getMessageHolder().f();
                xGPushTextMessage.f68085f = instance.getTemplateId();
                xGPushTextMessage.f68086g = instance.getTraceId();
                xGPushTextMessage.a(intent);
                onTextMessage(context, xGPushTextMessage);
                return;
            }
            return;
        }
        XGPushTextMessage xGPushTextMessage2 = new XGPushTextMessage();
        xGPushTextMessage2.f68080a = intent.getLongExtra("msgId", -1);
        xGPushTextMessage2.f68084e = intExtra;
        xGPushTextMessage2.f68082c = intent.getStringExtra("content");
        xGPushTextMessage2.f68081b = intent.getStringExtra("title");
        xGPushTextMessage2.f68083d = intent.getStringExtra("custom_content");
        xGPushTextMessage2.f68085f = intent.getStringExtra(MessageKey.MSG_TEMPLATE_ID);
        xGPushTextMessage2.f68086g = intent.getStringExtra(MessageKey.MSG_TRACE_ID);
        intent.putExtra("accId", XGPushConfig.getAccessId(context));
        e(context, intent);
        onTextMessage(context, xGPushTextMessage2);
    }

    /* access modifiers changed from: private */
    public void b(Context context, Intent intent) {
        int intExtra = intent.getIntExtra(Constants.FEEDBACK_TAG, -1);
        int intExtra2 = intent.getIntExtra(Constants.FEEDBACK_ERROR_CODE, -1);
        TLogger.i("XGPushBaseReceiver", "action - feedbackHandler, feedbackType: " + intExtra);
        switch (intExtra) {
            case 1:
                e(context, intent, intExtra2);
                return;
            case 2:
                new XGPushRegisterResult().parseIntent(intent);
                onUnregisterResult(context, intExtra2);
                return;
            case 3:
                d(context, intent, intExtra2);
                return;
            case 4:
                d(context, intent);
                return;
            case 5:
                c(context, intent);
                return;
            case 6:
                c(context, intent, intExtra2);
                return;
            case 7:
                b(context, intent, intExtra2);
                return;
            case 8:
                a(context, intent, intExtra2);
                return;
            case 10:
                g(context, intent);
                return;
            case 11:
                h(context, intent);
                return;
            default:
                TLogger.e("XGPushBaseReceiver", "未知的feedbackType:" + intExtra);
                return;
        }
    }

    private void c(Context context, Intent intent) {
        XGPushShowedResult xGPushShowedResult = new XGPushShowedResult();
        int intExtra = intent.getIntExtra(Constants.PUSH_CHANNEL, 100);
        if (intExtra == 100 || intExtra == 101 || intExtra == 99) {
            xGPushShowedResult.parseIntent(intent);
        } else {
            xGPushShowedResult.f68073c = intent.getStringExtra("content");
            xGPushShowedResult.f68072b = intent.getStringExtra("title");
            xGPushShowedResult.f68074d = intent.getStringExtra("custom_content");
            xGPushShowedResult.f68078h = intent.getIntExtra(Constants.PUSH_CHANNEL, 0);
            intent.putExtra("accId", XGPushConfig.getAccessId(context));
        }
        onNotificationShowedResult(context, xGPushShowedResult);
    }

    private void c(Context context, Intent intent, int i11) {
        String decrypt = Rijndael.decrypt(intent.getStringExtra(Constants.FLAG_ACCOUNT_NAME));
        int intExtra = intent.getIntExtra(Constants.FLAG_ACCOUNT_OP_TYPE, -1);
        String stringExtra = intent.getStringExtra(Constants.FLAG_ACCOUNT_FEEDBACK);
        if (intExtra == 1) {
            onDeleteAccountResult(context, i11, stringExtra);
        } else if (j.b(decrypt)) {
        } else {
            if (intExtra == 0 || intExtra == 2 || intExtra == 6) {
                onSetAccountResult(context, i11, stringExtra);
            } else if (intExtra == 3 || intExtra == 1 || intExtra == 7) {
                onDeleteAccountResult(context, i11, stringExtra);
            } else {
                TLogger.e("XGPushBaseReceiver", "错误的帐号处理类型：" + intExtra + " ,accountName：" + decrypt);
            }
        }
    }

    private void e(Context context, Intent intent) {
        MessageId messageId = new MessageId();
        messageId.f69316id = intent.getLongExtra("msgId", 0);
        messageId.isAck = 0;
        messageId.accessId = intent.getLongExtra("accId", 0);
        messageId.host = intent.getLongExtra(MessageKey.MSG_EXTRA_HOST, 0);
        messageId.port = intent.getIntExtra(MessageKey.MSG_EXTRA_PORT, 0);
        messageId.pact = intent.getByteExtra(MessageKey.MSG_EXTRA_PACT, (byte) 0);
        messageId.apn = DeviceInfos.getNetworkType(context);
        messageId.isp = j.p(context);
        messageId.serviceHost = intent.getStringExtra(MessageKey.MSG_SERVICE_PACKAGE_NAME);
        messageId.receivedTime = System.currentTimeMillis();
        messageId.pkgName = context.getPackageName();
        messageId.busiMsgId = intent.getLongExtra(MessageKey.MSG_BUSI_MSG_ID, 0);
        messageId.timestamp = intent.getLongExtra(MessageKey.MSG_CREATE_TIMESTAMPS, 0);
        messageId.msgType = intent.getLongExtra("type", 0);
        messageId.multiPkg = intent.getLongExtra(MessageKey.MSG_CREATE_MULTIPKG, 0);
        messageId.date = new SimpleDateFormat("yyyyMMdd").format(new Date());
        String stringExtra = intent.getStringExtra("group_id");
        if (!j.b(stringExtra)) {
            messageId.groupId = stringExtra;
        }
        intent.putExtra("MessageId", messageId);
        Intent intent2 = new Intent(context.getPackageName() + "com.tencent.android.xg.vip.action.MSG_ACK.V4");
        intent2.putExtras(intent);
        BroadcastAgent.sendBroadcast(context, intent2);
    }

    private void b(Context context, Intent intent, int i11) {
        String decrypt = Rijndael.decrypt(intent.getStringExtra(Constants.FLAG_ATTRIBUTES_NAME));
        if (!j.b(decrypt)) {
            int intExtra = intent.getIntExtra(Constants.FLAG_ATTRIBUTES_TYPE, -1);
            String stringExtra = intent.getStringExtra(Constants.FLAG_ATTRIBUTES_OPER_NAME);
            TLogger.i("XGPushBaseReceiver", "attributes, opType:" + intExtra + " ,attributesName:" + decrypt + ", operateName:" + stringExtra);
            if (intExtra == 2 || intExtra == 1) {
                onSetAttributeResult(context, i11, stringExtra);
            } else if (intExtra == 4 || intExtra == 3) {
                onDeleteAttributeResult(context, i11, stringExtra);
            } else {
                TLogger.e("XGPushBaseReceiver", "error attributes：" + intExtra + " ,attributesName：" + decrypt + ", intent:" + intent.getExtras());
            }
        }
    }

    private void d(Context context, Intent intent, int i11) {
        String decrypt = Rijndael.decrypt(intent.getStringExtra(Constants.FLAG_TAG_NAME));
        int intExtra = intent.getIntExtra(Constants.FLAG_TAG_TYPE, -1);
        String stringExtra = intent.getStringExtra(Constants.FLAG_TAG_OPER_NAME);
        if (intExtra == 8) {
            onDeleteTagResult(context, i11, stringExtra);
        } else if (j.b(decrypt)) {
        } else {
            if (intExtra == 1 || intExtra == 6 || intExtra == 5) {
                onSetTagResult(context, i11, stringExtra);
            } else if (intExtra == 2 || intExtra == 7 || intExtra == 8) {
                onDeleteTagResult(context, i11, stringExtra);
            } else {
                TLogger.e("XGPushBaseReceiver", "错误的标签处理类型：" + intExtra + " ,标签名：" + decrypt);
            }
        }
    }

    private void a(Context context, Intent intent, int i11) {
        try {
            String stringExtra = intent.getStringExtra("data");
            onQueryTagsResult(context, i11, Rijndael.decrypt(stringExtra), intent.getStringExtra(Constants.FLAG_QUERY_TAGS_OPER_NAME));
        } catch (Throwable th2) {
            TLogger.e("XGPushBaseReceiver", "feekbackQueryTags:", th2);
        }
    }
}
