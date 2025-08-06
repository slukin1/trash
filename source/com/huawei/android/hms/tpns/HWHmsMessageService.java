package com.huawei.android.hms.tpns;

import android.content.Intent;
import android.util.Log;
import com.huawei.hms.push.HmsMessageService;
import com.huawei.hms.push.RemoteMessage;
import com.huochat.community.util.FileTool;
import com.tencent.android.tpush.common.Constants;
import java.security.MessageDigest;

public class HWHmsMessageService extends HmsMessageService {

    /* renamed from: b  reason: collision with root package name */
    public static String f37549b;

    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f37550b;

        public a(String str) {
            this.f37550b = str;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x002b, code lost:
            if (com.huawei.android.hms.tpns.HWHmsMessageService.c().length() <= 0) goto L_0x002d;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r7 = this;
                java.lang.String r0 = "[XG_HWPUSH_V3] onNewToken:"
                java.lang.String r1 = r7.f37550b
                r2 = 0
                java.lang.String r3 = "TPush"
                if (r1 == 0) goto L_0x0075
                int r1 = r1.length()
                if (r1 == 0) goto L_0x0075
                com.huawei.android.hms.tpns.HWHmsMessageService r1 = com.huawei.android.hms.tpns.HWHmsMessageService.this     // Catch:{ all -> 0x005c }
                android.content.Context r1 = r1.getApplicationContext()     // Catch:{ all -> 0x005c }
                java.lang.String r4 = "tpush.vip.shareprefs"
                android.content.SharedPreferences r1 = r1.getSharedPreferences(r4, r2)     // Catch:{ all -> 0x005c }
                java.lang.String r4 = com.huawei.android.hms.tpns.HWHmsMessageService.f37549b     // Catch:{ all -> 0x005c }
                java.lang.String r5 = "huawei_token"
                if (r4 == 0) goto L_0x002d
                java.lang.String r4 = com.huawei.android.hms.tpns.HWHmsMessageService.f37549b     // Catch:{ all -> 0x005c }
                int r4 = r4.length()     // Catch:{ all -> 0x005c }
                if (r4 > 0) goto L_0x003a
            L_0x002d:
                java.lang.String r4 = com.huawei.android.hms.tpns.HWHmsMessageService.f(r5)     // Catch:{ all -> 0x005c }
                java.lang.String r6 = ""
                java.lang.String r4 = r1.getString(r4, r6)     // Catch:{ all -> 0x005c }
                java.lang.String unused = com.huawei.android.hms.tpns.HWHmsMessageService.f37549b = r4     // Catch:{ all -> 0x005c }
            L_0x003a:
                java.lang.String r4 = r7.f37550b     // Catch:{ all -> 0x005c }
                java.lang.String r6 = com.huawei.android.hms.tpns.HWHmsMessageService.f37549b     // Catch:{ all -> 0x005c }
                boolean r4 = r4.equals(r6)     // Catch:{ all -> 0x005c }
                if (r4 != 0) goto L_0x0075
                java.lang.String r4 = r7.f37550b     // Catch:{ all -> 0x005c }
                java.lang.String unused = com.huawei.android.hms.tpns.HWHmsMessageService.f37549b = r4     // Catch:{ all -> 0x005c }
                android.content.SharedPreferences$Editor r1 = r1.edit()     // Catch:{ all -> 0x005c }
                java.lang.String r4 = com.huawei.android.hms.tpns.HWHmsMessageService.f(r5)     // Catch:{ all -> 0x005c }
                java.lang.String r5 = r7.f37550b     // Catch:{ all -> 0x005c }
                r1.putString(r4, r5)     // Catch:{ all -> 0x005c }
                r1.apply()     // Catch:{ all -> 0x005c }
                goto L_0x0075
            L_0x005c:
                r1 = move-exception
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                java.lang.String r5 = "[XG_HWPUSH_V3] otherpush huawei save newToken error: "
                r4.append(r5)
                java.lang.String r1 = r1.getMessage()
                r4.append(r1)
                java.lang.String r1 = r4.toString()
                android.util.Log.e(r3, r1)
            L_0x0075:
                java.lang.String r1 = "com.tencent.android.tpush.service.XGVipPushService"
                java.lang.Class.forName(r1)     // Catch:{ ClassNotFoundException -> 0x007d }
                java.lang.String r1 = "com.tencent.android.xg.vip.action.FEEDBACK"
                goto L_0x0096
            L_0x007d:
                r1 = move-exception
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                r4.append(r0)
                java.lang.String r1 = r1.getMessage()
                r4.append(r1)
                java.lang.String r1 = r4.toString()
                android.util.Log.w(r3, r1)
                java.lang.String r1 = "com.tencent.android.tpush.action.FEEDBACK"
            L_0x0096:
                android.content.Intent r4 = new android.content.Intent     // Catch:{ all -> 0x00d1 }
                r4.<init>(r1)     // Catch:{ all -> 0x00d1 }
                java.lang.String r1 = "TPUSH.ERRORCODE"
                java.lang.String r5 = r7.f37550b     // Catch:{ all -> 0x00d1 }
                if (r5 == 0) goto L_0x00a2
                goto L_0x00a3
            L_0x00a2:
                r2 = -1
            L_0x00a3:
                r4.putExtra(r1, r2)     // Catch:{ all -> 0x00d1 }
                java.lang.String r1 = "other_push_token"
                java.lang.String r2 = r7.f37550b     // Catch:{ all -> 0x00d1 }
                r4.putExtra(r1, r2)     // Catch:{ all -> 0x00d1 }
                java.lang.String r1 = "TPUSH.FEEDBACK"
                r2 = 1
                r4.putExtra(r1, r2)     // Catch:{ all -> 0x00d1 }
                java.lang.String r1 = "PUSH.CHANNEL"
                r2 = 102(0x66, float:1.43E-43)
                r4.putExtra(r1, r2)     // Catch:{ all -> 0x00d1 }
                com.huawei.android.hms.tpns.HWHmsMessageService r1 = com.huawei.android.hms.tpns.HWHmsMessageService.this     // Catch:{ all -> 0x00d1 }
                android.content.Context r1 = r1.getApplicationContext()     // Catch:{ all -> 0x00d1 }
                java.lang.String r1 = r1.getPackageName()     // Catch:{ all -> 0x00d1 }
                r4.setPackage(r1)     // Catch:{ all -> 0x00d1 }
                com.huawei.android.hms.tpns.HWHmsMessageService r1 = com.huawei.android.hms.tpns.HWHmsMessageService.this     // Catch:{ all -> 0x00d1 }
                android.content.Context r1 = r1.getApplicationContext()     // Catch:{ all -> 0x00d1 }
                r1.sendBroadcast(r4)     // Catch:{ all -> 0x00d1 }
                goto L_0x00e8
            L_0x00d1:
                r1 = move-exception
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                r2.append(r0)
                java.lang.String r0 = r1.getMessage()
                r2.append(r0)
                java.lang.String r0 = r2.toString()
                android.util.Log.w(r3, r0)
            L_0x00e8:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hms.tpns.HWHmsMessageService.a.run():void");
        }
    }

    public static String f(String str) {
        if (str == null) {
            return "";
        }
        try {
            MessageDigest instance = MessageDigest.getInstance(FileTool.HASH_TYPE_MD5);
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b11 : digest) {
                byte b12 = b11 & 255;
                if (b12 < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(b12));
            }
            return stringBuffer.toString();
        } catch (Throwable th2) {
            Log.e("TPush", "[XG_HWPUSH_V3] md5:" + th2.getMessage());
            return "";
        }
    }

    public void onMessageReceived(RemoteMessage remoteMessage) {
        String str;
        super.onMessageReceived(remoteMessage);
        Log.w("TPush", "[XG_HWPUSH_V3] On messageReceived: " + remoteMessage.getMessageId() + ", " + remoteMessage.getMessageType());
        try {
            Class.forName("com.tencent.android.tpush.service.XGVipPushService");
            str = Constants.ACTION_PUSH_MESSAGE;
        } catch (ClassNotFoundException e11) {
            Log.w("TPush", "[XG_HWPUSH_V3] onMessageReceived:" + e11.getMessage());
            str = "com.tencent.android.tpush.action.PUSH_MESSAGE";
        }
        try {
            if (remoteMessage.getData().length() > 0) {
                String data = remoteMessage.getData();
                Log.i("TPush", "[XG_HWPUSH_V3] Message data payload: " + data);
                Intent intent = new Intent(str);
                intent.putExtra(Constants.PUSH_CHANNEL, 102);
                intent.putExtra("content", data);
                intent.putExtra("custom_content", "");
                intent.putExtra("type", 2L);
                intent.setPackage(getPackageName());
                sendBroadcast(intent);
            }
            if (remoteMessage.getNotification() != null) {
                Log.d("TPush", "[XG_HWPUSH_V3] Message Notification Body: " + remoteMessage.getNotification().getBody());
            }
        } catch (Throwable th2) {
            Log.e("TPush", "[XG_HWPUSH_V3] onMessageReceived:" + th2.getMessage());
        }
    }

    public void onNewToken(String str) {
        super.onNewToken(str);
        Log.i("TPush", "[XG_HWPUSH_V3] otherpush huawei register onNewToken: " + str);
        CommonWorkingThread.b().a(new a(str));
    }
}
