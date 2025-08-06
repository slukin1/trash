package com.huawei.hms.support.api.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.firebase.messaging.Constants;
import com.hbg.lib.network.contract.core.bean.ContractSettlementPriceInfo;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.push.d;
import com.huawei.hms.push.q;
import com.huawei.hms.push.r;
import com.huawei.hms.push.utils.JsonUtil;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.ResourceLoaderUtil;
import java.util.concurrent.RejectedExecutionException;
import org.json.JSONException;
import org.json.JSONObject;

public final class PushReceiver extends BroadcastReceiver {

    public static class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private Context f38493a;

        /* renamed from: b  reason: collision with root package name */
        private Intent f38494b;

        public void run() {
            Intent intent = new Intent("com.huawei.push.action.MESSAGING_EVENT");
            intent.setPackage(this.f38494b.getPackage());
            try {
                JSONObject a11 = PushReceiver.b(this.f38494b);
                String string = JsonUtil.getString(a11, "moduleName", "");
                int i11 = JsonUtil.getInt(a11, "msgType", 0);
                int i12 = JsonUtil.getInt(a11, "status", 0);
                if (ErrorEnum.SUCCESS.getInternalCode() != i12) {
                    i12 = ErrorEnum.ERROR_APP_SERVER_NOT_ONLINE.getInternalCode();
                }
                Bundle bundle = new Bundle();
                if (!"Push".equals(string) || i11 != 1) {
                    if (this.f38494b.getExtras() != null) {
                        bundle.putAll(this.f38494b.getExtras());
                    }
                    bundle.putString("message_type", "received_message");
                    bundle.putString(Constants.MessagePayloadKeys.MSGID_SERVER, this.f38494b.getStringExtra("msgIdStr"));
                    bundle.putByteArray(RemoteMessageConst.MSGBODY, this.f38494b.getByteArrayExtra("msg_data"));
                    bundle.putString(RemoteMessageConst.DEVICE_TOKEN, com.huawei.hms.push.a.a(this.f38494b.getByteArrayExtra(RemoteMessageConst.DEVICE_TOKEN)));
                    bundle.putInt(RemoteMessageConst.INPUT_TYPE, 1);
                    bundle.putString("message_proxy_type", this.f38494b.getStringExtra("message_proxy_type"));
                } else {
                    bundle.putString("message_type", ContractSettlementPriceInfo.SETTLEMENT_TYPE_DELIVERY);
                    bundle.putString(Constants.MessagePayloadKeys.MSGID_SERVER, JsonUtil.getString(a11, "msgId", ""));
                    bundle.putInt("error", i12);
                    bundle.putString("transaction_id", JsonUtil.getString(a11, "transactionId", ""));
                }
                if (new r().a(this.f38493a, bundle, intent)) {
                    HMSLog.i("PushReceiver", "receive " + this.f38494b.getAction() + " and start service success");
                    return;
                }
                HMSLog.e("PushReceiver", "receive " + this.f38494b.getAction() + " and start service failed");
            } catch (RuntimeException unused) {
                HMSLog.e("PushReceiver", "handle push message occur exception.");
            }
        }

        private b(Context context, Intent intent) {
            this.f38493a = context;
            this.f38494b = intent;
        }
    }

    public static class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private Context f38495a;

        /* renamed from: b  reason: collision with root package name */
        private Intent f38496b;

        public void run() {
            try {
                byte[] byteArrayExtra = this.f38496b.getByteArrayExtra(RemoteMessageConst.DEVICE_TOKEN);
                if (byteArrayExtra != null) {
                    if (byteArrayExtra.length != 0) {
                        HMSLog.i("PushReceiver", "receive a push token: " + this.f38495a.getPackageName());
                        Intent intent = new Intent("com.huawei.push.action.MESSAGING_EVENT");
                        intent.setPackage(this.f38496b.getPackage());
                        Bundle bundle = new Bundle();
                        bundle.putString("message_type", "new_token");
                        bundle.putString(RemoteMessageConst.DEVICE_TOKEN, com.huawei.hms.push.a.a(byteArrayExtra));
                        bundle.putString("transaction_id", this.f38496b.getStringExtra("transaction_id"));
                        bundle.putString("subjectId", this.f38496b.getStringExtra("subjectId"));
                        bundle.putInt("error", this.f38496b.getIntExtra("error", ErrorEnum.SUCCESS.getInternalCode()));
                        bundle.putString("belongId", this.f38496b.getStringExtra("belongId"));
                        if (!new r().a(this.f38495a, bundle, intent)) {
                            HMSLog.e("PushReceiver", "receive " + this.f38496b.getAction() + " and start service failed");
                            return;
                        }
                        return;
                    }
                }
                HMSLog.i("PushReceiver", "get a deviceToken, but it is null or empty");
            } catch (RejectedExecutionException unused) {
                HMSLog.e("PushReceiver", "execute task error");
            } catch (Exception unused2) {
                HMSLog.e("PushReceiver", "handle push token error");
            }
        }

        private c(Context context, Intent intent) {
            this.f38495a = context;
            this.f38496b = intent;
        }
    }

    private void b(Context context, Intent intent) {
        try {
            if (intent.hasExtra(RemoteMessageConst.DEVICE_TOKEN)) {
                q.a().execute(new c(context, intent));
            } else {
                HMSLog.i("PushReceiver", "This message dose not sent by hwpush.");
            }
        } catch (RuntimeException unused) {
            HMSLog.e("PushReceiver", "handlePushMessageEvent execute task runtime exception.");
        } catch (Exception unused2) {
            HMSLog.e("PushReceiver", "handlePushTokenEvent execute task error");
        }
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null && context != null) {
            HMSLog.i("PushReceiver", "push receive broadcast message, Intent:" + intent.getAction() + " pkgName:" + context.getPackageName());
            try {
                intent.getStringExtra("TestIntent");
                String action = intent.getAction();
                if (ResourceLoaderUtil.getmContext() == null) {
                    ResourceLoaderUtil.setmContext(context.getApplicationContext());
                }
                if ("com.huawei.android.push.intent.REGISTRATION".equals(action)) {
                    b(context, intent);
                } else if ("com.huawei.android.push.intent.RECEIVE".equals(action)) {
                    a(context, intent);
                } else {
                    HMSLog.i("PushReceiver", "message can't be recognised.");
                }
            } catch (Exception unused) {
                HMSLog.e("PushReceiver", "intent has some error");
            }
        }
    }

    private void a(Context context, Intent intent) {
        try {
            if (intent.hasExtra("msg_data")) {
                q.a().execute(new b(context, intent));
            } else {
                HMSLog.i("PushReceiver", "This push message dose not sent by hwpush.");
            }
        } catch (RuntimeException unused) {
            HMSLog.e("PushReceiver", "handlePushMessageEvent execute task runtime exception.");
        } catch (Exception unused2) {
            HMSLog.e("PushReceiver", "handlePushMessageEvent execute task error");
        }
    }

    private static JSONObject b(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject(RemoteMessageConst.MessageBody.PS_CONTENT);
        }
        return null;
    }

    private static JSONObject a(byte[] bArr) {
        try {
            return new JSONObject(com.huawei.hms.push.a.a(bArr));
        } catch (JSONException unused) {
            HMSLog.w("PushReceiver", "JSONException:parse message body failed.");
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static JSONObject b(Intent intent) throws RuntimeException {
        JSONObject a11 = a(intent.getByteArrayExtra("msg_data"));
        JSONObject a12 = a(a11);
        String string = JsonUtil.getString(a12, "data", (String) null);
        if (d.a(a12, b(a12), string)) {
            return a11;
        }
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            return new JSONObject(string);
        } catch (JSONException unused) {
            return null;
        }
    }

    private static JSONObject a(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject(RemoteMessageConst.MessageBody.MSG_CONTENT);
        }
        return null;
    }
}
