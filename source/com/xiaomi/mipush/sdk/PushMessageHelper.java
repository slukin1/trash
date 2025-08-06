package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.xiaomi.push.gt;
import com.xiaomi.push.hj;
import java.util.List;

public class PushMessageHelper {
    public static final String ERROR_MESSAGE = "error_message";
    public static final String ERROR_TYPE = "error_type";
    public static final String ERROR_TYPE_NEED_PERMISSION = "error_lack_of_permission";
    public static final String KEY_COMMAND = "key_command";
    public static final String KEY_MESSAGE = "key_message";
    public static final int MESSAGE_COMMAND = 3;
    public static final int MESSAGE_ERROR = 5;
    public static final int MESSAGE_QUIT = 4;
    public static final int MESSAGE_RAW = 1;
    public static final int MESSAGE_SENDMESSAGE = 2;
    public static final String MESSAGE_TYPE = "message_type";
    public static final int PUSH_MODE_BROADCAST = 2;
    public static final int PUSH_MODE_CALLBACK = 1;
    private static int pushMode;

    public static MiPushCommandMessage generateCommandMessage(String str, List<String> list, long j11, String str2, String str3, List<String> list2) {
        MiPushCommandMessage miPushCommandMessage = new MiPushCommandMessage();
        miPushCommandMessage.setCommand(str);
        miPushCommandMessage.setCommandArguments(list);
        miPushCommandMessage.setResultCode(j11);
        miPushCommandMessage.setReason(str2);
        miPushCommandMessage.setCategory(str3);
        miPushCommandMessage.setAutoMarkPkgs(list2);
        return miPushCommandMessage;
    }

    public static MiPushMessage generateMessage(hj hjVar, gt gtVar, boolean z11) {
        MiPushMessage miPushMessage = new MiPushMessage();
        miPushMessage.setMessageId(hjVar.a());
        if (!TextUtils.isEmpty(hjVar.d())) {
            miPushMessage.setMessageType(1);
            miPushMessage.setAlias(hjVar.d());
        } else if (!TextUtils.isEmpty(hjVar.c())) {
            miPushMessage.setMessageType(2);
            miPushMessage.setTopic(hjVar.c());
        } else if (!TextUtils.isEmpty(hjVar.f())) {
            miPushMessage.setMessageType(3);
            miPushMessage.setUserAccount(hjVar.f());
        } else {
            miPushMessage.setMessageType(0);
        }
        miPushMessage.setCategory(hjVar.e());
        if (hjVar.a() != null) {
            miPushMessage.setContent(hjVar.a().c());
        }
        if (gtVar != null) {
            if (TextUtils.isEmpty(miPushMessage.getMessageId())) {
                miPushMessage.setMessageId(gtVar.a());
            }
            if (TextUtils.isEmpty(miPushMessage.getTopic())) {
                miPushMessage.setTopic(gtVar.b());
            }
            miPushMessage.setDescription(gtVar.d());
            miPushMessage.setTitle(gtVar.c());
            miPushMessage.setNotifyType(gtVar.a());
            miPushMessage.setNotifyId(gtVar.c());
            miPushMessage.setPassThrough(gtVar.b());
            miPushMessage.setExtra(gtVar.a());
        }
        miPushMessage.setNotified(z11);
        return miPushMessage;
    }

    public static int getPushMode(Context context) {
        if (pushMode == 0) {
            if (isUseCallbackPushMode(context)) {
                setPushMode(1);
            } else {
                setPushMode(2);
            }
        }
        return pushMode;
    }

    private static boolean isIntentAvailable(Context context, Intent intent) {
        try {
            List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 32);
            if (queryBroadcastReceivers == null || queryBroadcastReceivers.isEmpty()) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return true;
        }
    }

    public static boolean isUseCallbackPushMode(Context context) {
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.setClassName(context.getPackageName(), "com.xiaomi.mipush.sdk.PushServiceReceiver");
        return isIntentAvailable(context, intent);
    }

    public static void sendCommandMessageBroadcast(Context context, MiPushCommandMessage miPushCommandMessage) {
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.setPackage(context.getPackageName());
        intent.putExtra("message_type", 3);
        intent.putExtra(KEY_COMMAND, miPushCommandMessage);
        new PushServiceReceiver().onReceive(context, intent);
    }

    public static void sendQuitMessageBroadcast(Context context) {
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.setPackage(context.getPackageName());
        intent.putExtra("message_type", 4);
        new PushServiceReceiver().onReceive(context, intent);
    }

    private static void setPushMode(int i11) {
        pushMode = i11;
    }

    public static gt generateMessage(MiPushMessage miPushMessage) {
        gt gtVar = new gt();
        gtVar.a(miPushMessage.getMessageId());
        gtVar.b(miPushMessage.getTopic());
        gtVar.d(miPushMessage.getDescription());
        gtVar.c(miPushMessage.getTitle());
        gtVar.c(miPushMessage.getNotifyId());
        gtVar.a(miPushMessage.getNotifyType());
        gtVar.b(miPushMessage.getPassThrough());
        gtVar.a(miPushMessage.getExtra());
        return gtVar;
    }
}
