package com.huawei.hms.push;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import com.google.firebase.messaging.Constants;
import com.hbg.lib.network.contract.core.bean.ContractSettlementPriceInfo;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.threads.AsyncExec;
import com.huawei.hms.aaid.utils.BaseUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.push.f;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.api.entity.push.PushNaming;
import com.huawei.hms.support.log.HMSLog;
import com.iproov.sdk.bridge.OptionsBridge;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HmsMessageService extends Service {
    public static final String PROXY_TYPE = "proxy_type";
    public static final String SUBJECT_ID = "subject_id";

    /* renamed from: a  reason: collision with root package name */
    private final Messenger f38335a = new Messenger(new f(new b(this, (a) null)));

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f38336a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f38337b;

        public a(String str, String str2) {
            this.f38336a = str;
            this.f38337b = str2;
        }

        public void run() {
            Context applicationContext = HmsMessageService.this.getApplicationContext();
            if (!this.f38337b.equals(BaseUtils.getLocalToken(applicationContext, this.f38336a))) {
                HMSLog.i("HmsMessageService", "receive a new token, refresh the local token");
                BaseUtils.saveToken(applicationContext, this.f38336a, this.f38337b);
            }
        }
    }

    public class b implements f.a {
        private b() {
        }

        public void a(Message message) {
            if (message == null) {
                HMSLog.e("HmsMessageService", "receive message is null");
                return;
            }
            HMSLog.i("HmsMessageService", "handle message start...");
            Bundle data = Message.obtain(message).getData();
            if (data != null) {
                Intent intent = new Intent();
                intent.putExtras(data);
                intent.putExtra(RemoteMessageConst.INPUT_TYPE, data.getInt(RemoteMessageConst.INPUT_TYPE, -1));
                HmsMessageService.this.handleIntentMessage(intent);
            }
        }

        public /* synthetic */ b(HmsMessageService hmsMessageService, a aVar) {
            this();
        }
    }

    private void a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            AsyncExec.submitSeqIO(new a(str2, str));
        }
    }

    private void b(Intent intent) {
        HMSLog.i("HmsMessageService", "parse batch response.");
        String stringExtra = intent.getStringExtra("batchMsgbody");
        if (!TextUtils.isEmpty(stringExtra)) {
            try {
                JSONArray jSONArray = new JSONArray(stringExtra);
                for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i11);
                    String optString = jSONObject.optString("transactionId");
                    String optString2 = jSONObject.optString("msgId");
                    int optInt = jSONObject.optInt("ret", ErrorEnum.ERROR_UNKNOWN.getInternalCode());
                    if (ErrorEnum.SUCCESS.getInternalCode() == optInt) {
                        b(optString, optString2);
                    } else {
                        b(optString, optString2, optInt);
                    }
                }
            } catch (JSONException unused) {
                HMSLog.w("HmsMessageService", "parse batch response failed.");
            }
        }
    }

    public void doMsgReceived(Intent intent) {
        onMessageReceived(new RemoteMessage(a(intent)));
    }

    public void handleIntentMessage(Intent intent) {
        if (intent == null) {
            HMSLog.e("HmsMessageService", "receive message is null");
            return;
        }
        try {
            String stringExtra = intent.getStringExtra(Constants.MessagePayloadKeys.MSGID_SERVER);
            String stringExtra2 = intent.getStringExtra("message_type");
            String stringExtra3 = intent.getStringExtra("transaction_id");
            if ("new_token".equals(stringExtra2)) {
                HMSLog.i("HmsMessageService", "onNewToken");
                a(intent, stringExtra3);
            } else if ("received_message".equals(stringExtra2)) {
                HMSLog.i("HmsMessageService", "onMessageReceived, message id:" + stringExtra);
                a(PushNaming.RECEIVE_MSG_RSP, stringExtra, ErrorEnum.SUCCESS.getInternalCode());
                doMsgReceived(intent);
            } else if ("sent_message".equals(stringExtra2)) {
                b(stringExtra3, stringExtra);
            } else if (Constants.MessageTypes.SEND_ERROR.equals(stringExtra2)) {
                b(stringExtra3, stringExtra, intent.getIntExtra("error", ErrorEnum.ERROR_UNKNOWN.getInternalCode()));
            } else if (ContractSettlementPriceInfo.SETTLEMENT_TYPE_DELIVERY.equals(stringExtra2)) {
                int intExtra = intent.getIntExtra("error", ErrorEnum.ERROR_APP_SERVER_NOT_ONLINE.getInternalCode());
                HMSLog.i("HmsMessageService", "onMessageDelivery, message id:" + stringExtra + ", status:" + intExtra + ", transactionId: " + stringExtra3);
                a(PushNaming.UPSEND_RECEIPT, stringExtra3, intExtra);
                onMessageDelivered(stringExtra, new SendException(intExtra));
            } else if ("server_deleted_message".equals(stringExtra2)) {
                HMSLog.i("HmsMessageService", "delete message, message id:" + stringExtra);
                onDeletedMessages();
            } else if ("batchSent".equals(stringExtra2)) {
                b(intent);
            } else {
                HMSLog.e("HmsMessageService", "Receive unknown message: " + stringExtra2);
            }
        } catch (RuntimeException e11) {
            HMSLog.e("HmsMessageService", "handle intent RuntimeException: " + e11.getMessage());
        } catch (Exception e12) {
            HMSLog.e("HmsMessageService", "handle intent exception: " + e12.getMessage());
        }
    }

    public IBinder onBind(Intent intent) {
        HMSLog.i("HmsMessageService", "start to bind");
        return this.f38335a.getBinder();
    }

    public void onDeletedMessages() {
    }

    public void onDestroy() {
        HMSLog.i("HmsMessageService", "start to destroy");
        super.onDestroy();
    }

    public void onMessageDelivered(String str, Exception exc) {
    }

    public void onMessageReceived(RemoteMessage remoteMessage) {
    }

    public void onMessageSent(String str) {
    }

    public void onNewToken(String str) {
    }

    public void onNewToken(String str, Bundle bundle) {
    }

    public void onSendError(String str, Exception exc) {
    }

    public int onStartCommand(Intent intent, int i11, int i12) {
        HMSLog.i("HmsMessageService", "start to command , startId = " + i12);
        handleIntentMessage(intent);
        return 2;
    }

    public void onTokenError(Exception exc) {
    }

    public void onTokenError(Exception exc, Bundle bundle) {
    }

    private Bundle a(Intent intent) {
        Bundle bundle = new Bundle();
        bundle.putString(Constants.MessagePayloadKeys.MSGID_SERVER, intent.getStringExtra(Constants.MessagePayloadKeys.MSGID_SERVER));
        bundle.putByteArray(RemoteMessageConst.MSGBODY, intent.getByteArrayExtra(RemoteMessageConst.MSGBODY));
        bundle.putString(RemoteMessageConst.DEVICE_TOKEN, intent.getStringExtra(RemoteMessageConst.DEVICE_TOKEN));
        if (intent.getIntExtra(RemoteMessageConst.INPUT_TYPE, -1) == 1) {
            bundle.putInt(RemoteMessageConst.INPUT_TYPE, 1);
        }
        return bundle;
    }

    private void a(Intent intent, String str) {
        ErrorEnum errorEnum = ErrorEnum.SUCCESS;
        int intExtra = intent.getIntExtra("error", errorEnum.getInternalCode());
        a(PushNaming.GETTOKEN_ASYNC_RSP, str, intExtra);
        String stringExtra = intent.getStringExtra("subjectId");
        String stringExtra2 = intent.getStringExtra("message_proxy_type");
        HMSLog.i("HmsMessageService", "doOnNewToken:transactionId = " + str + " , internalCode = " + intExtra + ",subjectId:" + stringExtra + ",proxyType:" + stringExtra2);
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(stringExtra)) {
            bundle.putString(SUBJECT_ID, stringExtra);
        }
        if (!TextUtils.isEmpty(stringExtra2)) {
            bundle.putString(PROXY_TYPE, stringExtra2);
        }
        if (intExtra == errorEnum.getInternalCode()) {
            HMSLog.i("HmsMessageService", "Apply token OnNewToken, subId: " + stringExtra);
            a(intent, bundle, stringExtra);
            return;
        }
        HMSLog.i("HmsMessageService", "Apply token failed, subId: " + stringExtra);
        a(intent, bundle, stringExtra, intExtra);
    }

    private void b(String str, String str2) {
        HMSLog.i("HmsMessageService", "onMessageSent, message id:" + str2 + ", transactionId: " + str);
        a(PushNaming.UPSEND_MSG_ASYNC_RSP, str, ErrorEnum.SUCCESS.getInternalCode());
        onMessageSent(str2);
    }

    private void b(String str, String str2, int i11) {
        HMSLog.i("HmsMessageService", "onSendError, message id:" + str2 + " error:" + i11 + ", transactionId: " + str);
        a(PushNaming.UPSEND_MSG_ASYNC_RSP, str, i11);
        onSendError(str2, new SendException(i11));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00a8, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void a(android.content.Intent r4, android.os.Bundle r5, java.lang.String r6, int r7) {
        /*
            r3 = this;
            monitor-enter(r3)
            android.content.Context r4 = r3.getApplicationContext()     // Catch:{ all -> 0x00a9 }
            java.lang.String r0 = r4.getPackageName()     // Catch:{ all -> 0x00a9 }
            r1 = 0
            java.lang.String r0 = com.huawei.hms.aaid.utils.BaseUtils.getCacheData(r4, r0, r1)     // Catch:{ all -> 0x00a9 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x00a9 }
            r0 = r0 ^ 1
            boolean r2 = r5.isEmpty()     // Catch:{ all -> 0x00a9 }
            if (r2 == 0) goto L_0x0032
            if (r0 == 0) goto L_0x0032
            java.lang.String r0 = "HmsMessageService"
            java.lang.String r2 = "onTokenError to host app."
            com.huawei.hms.support.log.HMSLog.i(r0, r2)     // Catch:{ all -> 0x00a9 }
            com.huawei.hms.push.BaseException r0 = new com.huawei.hms.push.BaseException     // Catch:{ all -> 0x00a9 }
            r0.<init>(r7)     // Catch:{ all -> 0x00a9 }
            r3.onTokenError(r0)     // Catch:{ all -> 0x00a9 }
            java.lang.String r0 = r4.getPackageName()     // Catch:{ all -> 0x00a9 }
            com.huawei.hms.aaid.utils.BaseUtils.deleteCacheData(r4, r0)     // Catch:{ all -> 0x00a9 }
        L_0x0032:
            boolean r0 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x00a9 }
            if (r0 == 0) goto L_0x0089
            java.lang.String[] r6 = com.huawei.hms.aaid.utils.BaseUtils.getSubjectIds(r4)     // Catch:{ all -> 0x00a9 }
            if (r6 == 0) goto L_0x0078
            int r0 = r6.length     // Catch:{ all -> 0x00a9 }
            if (r0 != 0) goto L_0x0042
            goto L_0x0078
        L_0x0042:
            int r5 = r6.length     // Catch:{ all -> 0x00a9 }
            if (r1 >= r5) goto L_0x0074
            android.os.Bundle r5 = new android.os.Bundle     // Catch:{ all -> 0x00a9 }
            r5.<init>()     // Catch:{ all -> 0x00a9 }
            r0 = r6[r1]     // Catch:{ all -> 0x00a9 }
            java.lang.String r2 = "subject_id"
            r5.putString(r2, r0)     // Catch:{ all -> 0x00a9 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a9 }
            r0.<init>()     // Catch:{ all -> 0x00a9 }
            java.lang.String r2 = "onTokenError to sub app, subjectId:"
            r0.append(r2)     // Catch:{ all -> 0x00a9 }
            r2 = r6[r1]     // Catch:{ all -> 0x00a9 }
            r0.append(r2)     // Catch:{ all -> 0x00a9 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00a9 }
            java.lang.String r2 = "HmsMessageService"
            com.huawei.hms.support.log.HMSLog.i(r2, r0)     // Catch:{ all -> 0x00a9 }
            com.huawei.hms.push.BaseException r0 = new com.huawei.hms.push.BaseException     // Catch:{ all -> 0x00a9 }
            r0.<init>(r7)     // Catch:{ all -> 0x00a9 }
            r3.onTokenError(r0, r5)     // Catch:{ all -> 0x00a9 }
            int r1 = r1 + 1
            goto L_0x0042
        L_0x0074:
            com.huawei.hms.aaid.utils.BaseUtils.clearSubjectIds(r4)     // Catch:{ all -> 0x00a9 }
            goto L_0x00a7
        L_0x0078:
            java.lang.String r4 = "HmsMessageService"
            java.lang.String r6 = "onTokenError to host app with bundle."
            com.huawei.hms.support.log.HMSLog.i(r4, r6)     // Catch:{ all -> 0x00a9 }
            com.huawei.hms.push.BaseException r4 = new com.huawei.hms.push.BaseException     // Catch:{ all -> 0x00a9 }
            r4.<init>(r7)     // Catch:{ all -> 0x00a9 }
            r3.onTokenError(r4, r5)     // Catch:{ all -> 0x00a9 }
            monitor-exit(r3)
            return
        L_0x0089:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a9 }
            r4.<init>()     // Catch:{ all -> 0x00a9 }
            java.lang.String r0 = "onTokenError to sub app, subjectId:"
            r4.append(r0)     // Catch:{ all -> 0x00a9 }
            r4.append(r6)     // Catch:{ all -> 0x00a9 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x00a9 }
            java.lang.String r6 = "HmsMessageService"
            com.huawei.hms.support.log.HMSLog.i(r6, r4)     // Catch:{ all -> 0x00a9 }
            com.huawei.hms.push.BaseException r4 = new com.huawei.hms.push.BaseException     // Catch:{ all -> 0x00a9 }
            r4.<init>(r7)     // Catch:{ all -> 0x00a9 }
            r3.onTokenError(r4, r5)     // Catch:{ all -> 0x00a9 }
        L_0x00a7:
            monitor-exit(r3)
            return
        L_0x00a9:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.push.HmsMessageService.a(android.content.Intent, android.os.Bundle, java.lang.String, int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00ad, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void a(android.content.Intent r6, android.os.Bundle r7, java.lang.String r8) {
        /*
            r5 = this;
            monitor-enter(r5)
            java.lang.String r0 = "device_token"
            java.lang.String r0 = r6.getStringExtra(r0)     // Catch:{ all -> 0x00ae }
            r5.a((java.lang.String) r0, (java.lang.String) r8)     // Catch:{ all -> 0x00ae }
            android.content.Context r1 = r5.getApplicationContext()     // Catch:{ all -> 0x00ae }
            java.lang.String r2 = r1.getPackageName()     // Catch:{ all -> 0x00ae }
            r3 = 0
            java.lang.String r2 = com.huawei.hms.aaid.utils.BaseUtils.getCacheData(r1, r2, r3)     // Catch:{ all -> 0x00ae }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x00ae }
            r2 = r2 ^ 1
            boolean r4 = r7.isEmpty()     // Catch:{ all -> 0x00ae }
            if (r4 == 0) goto L_0x0036
            if (r2 == 0) goto L_0x0036
            java.lang.String r2 = "HmsMessageService"
            java.lang.String r4 = "onNewToken to host app."
            com.huawei.hms.support.log.HMSLog.i(r2, r4)     // Catch:{ all -> 0x00ae }
            r5.onNewToken(r0)     // Catch:{ all -> 0x00ae }
            java.lang.String r2 = r1.getPackageName()     // Catch:{ all -> 0x00ae }
            com.huawei.hms.aaid.utils.BaseUtils.deleteCacheData(r1, r2)     // Catch:{ all -> 0x00ae }
        L_0x0036:
            boolean r2 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x00ae }
            if (r2 == 0) goto L_0x0093
            java.lang.String[] r8 = com.huawei.hms.aaid.utils.BaseUtils.getSubjectIds(r1)     // Catch:{ all -> 0x00ae }
            if (r8 == 0) goto L_0x007c
            int r2 = r8.length     // Catch:{ all -> 0x00ae }
            if (r2 != 0) goto L_0x0046
            goto L_0x007c
        L_0x0046:
            int r6 = r8.length     // Catch:{ all -> 0x00ae }
            if (r3 >= r6) goto L_0x0078
            android.os.Bundle r6 = new android.os.Bundle     // Catch:{ all -> 0x00ae }
            r6.<init>()     // Catch:{ all -> 0x00ae }
            r7 = r8[r3]     // Catch:{ all -> 0x00ae }
            java.lang.String r2 = "subject_id"
            r6.putString(r2, r7)     // Catch:{ all -> 0x00ae }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ae }
            r7.<init>()     // Catch:{ all -> 0x00ae }
            java.lang.String r2 = "onNewToken to sub app, subjectId:"
            r7.append(r2)     // Catch:{ all -> 0x00ae }
            r2 = r8[r3]     // Catch:{ all -> 0x00ae }
            r7.append(r2)     // Catch:{ all -> 0x00ae }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x00ae }
            java.lang.String r2 = "HmsMessageService"
            com.huawei.hms.support.log.HMSLog.i(r2, r7)     // Catch:{ all -> 0x00ae }
            r5.onNewToken(r0, r6)     // Catch:{ all -> 0x00ae }
            r6 = r8[r3]     // Catch:{ all -> 0x00ae }
            r5.a((java.lang.String) r0, (java.lang.String) r6)     // Catch:{ all -> 0x00ae }
            int r3 = r3 + 1
            goto L_0x0046
        L_0x0078:
            com.huawei.hms.aaid.utils.BaseUtils.clearSubjectIds(r1)     // Catch:{ all -> 0x00ae }
            goto L_0x00ac
        L_0x007c:
            java.lang.String r8 = "HmsMessageService"
            java.lang.String r1 = "onNewToken to host app with bundle."
            com.huawei.hms.support.log.HMSLog.i(r8, r1)     // Catch:{ all -> 0x00ae }
            java.lang.String r8 = "belongId"
            java.lang.String r6 = r6.getStringExtra(r8)     // Catch:{ all -> 0x00ae }
            java.lang.String r8 = "belongId"
            r7.putString(r8, r6)     // Catch:{ all -> 0x00ae }
            r5.onNewToken(r0, r7)     // Catch:{ all -> 0x00ae }
            monitor-exit(r5)
            return
        L_0x0093:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ae }
            r6.<init>()     // Catch:{ all -> 0x00ae }
            java.lang.String r1 = "onNewToken to sub app, subjectId:"
            r6.append(r1)     // Catch:{ all -> 0x00ae }
            r6.append(r8)     // Catch:{ all -> 0x00ae }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x00ae }
            java.lang.String r8 = "HmsMessageService"
            com.huawei.hms.support.log.HMSLog.i(r8, r6)     // Catch:{ all -> 0x00ae }
            r5.onNewToken(r0, r7)     // Catch:{ all -> 0x00ae }
        L_0x00ac:
            monitor-exit(r5)
            return
        L_0x00ae:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.push.HmsMessageService.a(android.content.Intent, android.os.Bundle, java.lang.String):void");
    }

    private void a(String str, String str2, int i11) {
        if (TextUtils.isEmpty(str2)) {
            str2 = OptionsBridge.NULL_VALUE;
        }
        PushBiUtil.reportExit(getApplicationContext(), str, str2, i11);
    }
}
