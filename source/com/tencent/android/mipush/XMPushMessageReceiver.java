package com.tencent.android.mipush;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.huochat.community.util.FileTool;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.common.MessageKey;
import com.twitter.sdk.android.core.identity.AuthHandler;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;
import com.xiaomi.mipush.sdk.MiPushMessage;
import com.xiaomi.mipush.sdk.PushMessageReceiver;
import java.security.MessageDigest;
import org.json.JSONObject;

public class XMPushMessageReceiver extends PushMessageReceiver {
    /* access modifiers changed from: private */
    public static String errMsg;

    /* access modifiers changed from: private */
    public static String md5(String str) {
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
        } catch (Throwable unused) {
            return "";
        }
    }

    public void onCommandResult(final Context context, final MiPushCommandMessage miPushCommandMessage) {
        a.a().a(new Runnable() {
            /* JADX WARNING: Code restructure failed: missing block: B:48:0x0200, code lost:
                if (com.tencent.android.mipush.XMPushMessageReceiver.access$000().length() <= 0) goto L_0x0202;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r18 = this;
                    r1 = r18
                    java.lang.String r2 = "TPush"
                    java.lang.String r0 = "com.tencent.android.tpush.service.XGVipPushService"
                    java.lang.Class.forName(r0)     // Catch:{ ClassNotFoundException -> 0x000c }
                    java.lang.String r0 = "com.tencent.android.xg.vip.action.FEEDBACK"
                    goto L_0x0013
                L_0x000c:
                    java.lang.String r0 = "[OtherPush_XG_MI] find XGVipPushService error"
                    android.util.Log.w(r2, r0)
                    java.lang.String r0 = "com.tencent.android.tpush.action.FEEDBACK"
                L_0x0013:
                    android.content.Intent r3 = new android.content.Intent     // Catch:{ all -> 0x0305 }
                    r3.<init>(r0)     // Catch:{ all -> 0x0305 }
                    com.xiaomi.mipush.sdk.MiPushCommandMessage r0 = r4     // Catch:{ all -> 0x0305 }
                    java.lang.String r0 = r0.getCommand()     // Catch:{ all -> 0x0305 }
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0305 }
                    r4.<init>()     // Catch:{ all -> 0x0305 }
                    java.lang.String r5 = "[OtherPush_XG_MI] onCommandResult - command: "
                    r4.append(r5)     // Catch:{ all -> 0x0305 }
                    r4.append(r0)     // Catch:{ all -> 0x0305 }
                    java.lang.String r5 = ", result code: "
                    r4.append(r5)     // Catch:{ all -> 0x0305 }
                    com.xiaomi.mipush.sdk.MiPushCommandMessage r5 = r4     // Catch:{ all -> 0x0305 }
                    long r5 = r5.getResultCode()     // Catch:{ all -> 0x0305 }
                    r4.append(r5)     // Catch:{ all -> 0x0305 }
                    java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0305 }
                    android.util.Log.i(r2, r4)     // Catch:{ all -> 0x0305 }
                    com.xiaomi.mipush.sdk.MiPushCommandMessage r4 = r4     // Catch:{ all -> 0x0305 }
                    java.util.List r4 = r4.getCommandArguments()     // Catch:{ all -> 0x0305 }
                    r5 = 0
                    r6 = 0
                    if (r4 == 0) goto L_0x0057
                    int r7 = r4.size()     // Catch:{ all -> 0x0305 }
                    if (r7 <= 0) goto L_0x0057
                    java.lang.Object r7 = r4.get(r6)     // Catch:{ all -> 0x0305 }
                    java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x0305 }
                    goto L_0x0058
                L_0x0057:
                    r7 = r5
                L_0x0058:
                    r8 = 1
                    if (r4 == 0) goto L_0x0068
                    int r9 = r4.size()     // Catch:{ all -> 0x0305 }
                    if (r9 <= r8) goto L_0x0068
                    java.lang.Object r4 = r4.get(r8)     // Catch:{ all -> 0x0305 }
                    r5 = r4
                    java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x0305 }
                L_0x0068:
                    java.lang.String r4 = "register"
                    boolean r4 = r4.equals(r0)     // Catch:{ all -> 0x0305 }
                    java.lang.String r9 = ""
                    if (r4 == 0) goto L_0x0264
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0305 }
                    r0.<init>()     // Catch:{ all -> 0x0305 }
                    java.lang.String r4 = "errCode : "
                    r0.append(r4)     // Catch:{ all -> 0x0305 }
                    com.xiaomi.mipush.sdk.MiPushCommandMessage r4 = r4     // Catch:{ all -> 0x0305 }
                    long r10 = r4.getResultCode()     // Catch:{ all -> 0x0305 }
                    r0.append(r10)     // Catch:{ all -> 0x0305 }
                    java.lang.String r4 = ", errMsg : unknown"
                    r0.append(r4)     // Catch:{ all -> 0x0305 }
                    java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0305 }
                    com.xiaomi.mipush.sdk.MiPushCommandMessage r4 = r4     // Catch:{ all -> 0x0305 }
                    long r10 = r4.getResultCode()     // Catch:{ all -> 0x0305 }
                    r12 = 0
                    int r4 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
                    java.lang.String r10 = "TPUSH.ERRORCODE"
                    if (r4 != 0) goto L_0x00b8
                    r3.putExtra(r10, r6)     // Catch:{ all -> 0x0305 }
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0305 }
                    r0.<init>()     // Catch:{ all -> 0x0305 }
                    java.lang.String r4 = "[OtherPush_XG_MI] register success， regid is ："
                    r0.append(r4)     // Catch:{ all -> 0x0305 }
                    r0.append(r7)     // Catch:{ all -> 0x0305 }
                    java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0305 }
                    android.util.Log.i(r2, r0)     // Catch:{ all -> 0x0305 }
                    java.lang.String r0 = "errCode : 0, errMsg : success"
                    r4 = r0
                    goto L_0x01e4
                L_0x00b8:
                    com.xiaomi.mipush.sdk.MiPushCommandMessage r4 = r4     // Catch:{ all -> 0x0305 }
                    long r11 = r4.getResultCode()     // Catch:{ all -> 0x0305 }
                    r13 = 70000002(0x42c1d82, double:3.4584596E-316)
                    int r4 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
                    java.lang.String r11 = ",code :"
                    java.lang.String r12 = "arg2:"
                    java.lang.String r13 = "[OtherPush_XG_MI] register failed， arg1: "
                    if (r4 != 0) goto L_0x00fb
                    com.xiaomi.mipush.sdk.MiPushCommandMessage r4 = r4     // Catch:{ all -> 0x0305 }
                    long r14 = r4.getResultCode()     // Catch:{ all -> 0x0305 }
                    int r4 = (int) r14     // Catch:{ all -> 0x0305 }
                    r3.putExtra(r10, r4)     // Catch:{ all -> 0x0305 }
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0305 }
                    r4.<init>()     // Catch:{ all -> 0x0305 }
                    r4.append(r13)     // Catch:{ all -> 0x0305 }
                    r4.append(r7)     // Catch:{ all -> 0x0305 }
                    r4.append(r12)     // Catch:{ all -> 0x0305 }
                    r4.append(r5)     // Catch:{ all -> 0x0305 }
                    r4.append(r11)     // Catch:{ all -> 0x0305 }
                    com.xiaomi.mipush.sdk.MiPushCommandMessage r5 = r4     // Catch:{ all -> 0x0305 }
                    long r10 = r5.getResultCode()     // Catch:{ all -> 0x0305 }
                    r4.append(r10)     // Catch:{ all -> 0x0305 }
                    java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0305 }
                    android.util.Log.i(r2, r4)     // Catch:{ all -> 0x0305 }
                    goto L_0x01e2
                L_0x00fb:
                    com.xiaomi.mipush.sdk.MiPushCommandMessage r4 = r4     // Catch:{ all -> 0x0305 }
                    long r14 = r4.getResultCode()     // Catch:{ all -> 0x0305 }
                    r16 = 70000004(0x42c1d84, double:3.4584597E-316)
                    int r4 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
                    if (r4 != 0) goto L_0x0138
                    com.xiaomi.mipush.sdk.MiPushCommandMessage r4 = r4     // Catch:{ all -> 0x0305 }
                    long r14 = r4.getResultCode()     // Catch:{ all -> 0x0305 }
                    int r4 = (int) r14     // Catch:{ all -> 0x0305 }
                    r3.putExtra(r10, r4)     // Catch:{ all -> 0x0305 }
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0305 }
                    r4.<init>()     // Catch:{ all -> 0x0305 }
                    r4.append(r13)     // Catch:{ all -> 0x0305 }
                    r4.append(r7)     // Catch:{ all -> 0x0305 }
                    r4.append(r12)     // Catch:{ all -> 0x0305 }
                    r4.append(r5)     // Catch:{ all -> 0x0305 }
                    r4.append(r11)     // Catch:{ all -> 0x0305 }
                    com.xiaomi.mipush.sdk.MiPushCommandMessage r5 = r4     // Catch:{ all -> 0x0305 }
                    long r10 = r5.getResultCode()     // Catch:{ all -> 0x0305 }
                    r4.append(r10)     // Catch:{ all -> 0x0305 }
                    java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0305 }
                    android.util.Log.i(r2, r4)     // Catch:{ all -> 0x0305 }
                    goto L_0x01e2
                L_0x0138:
                    com.xiaomi.mipush.sdk.MiPushCommandMessage r4 = r4     // Catch:{ all -> 0x0305 }
                    long r14 = r4.getResultCode()     // Catch:{ all -> 0x0305 }
                    r16 = 70000003(0x42c1d83, double:3.45845967E-316)
                    int r4 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
                    if (r4 != 0) goto L_0x0174
                    com.xiaomi.mipush.sdk.MiPushCommandMessage r4 = r4     // Catch:{ all -> 0x0305 }
                    long r14 = r4.getResultCode()     // Catch:{ all -> 0x0305 }
                    int r4 = (int) r14     // Catch:{ all -> 0x0305 }
                    r3.putExtra(r10, r4)     // Catch:{ all -> 0x0305 }
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0305 }
                    r4.<init>()     // Catch:{ all -> 0x0305 }
                    r4.append(r13)     // Catch:{ all -> 0x0305 }
                    r4.append(r7)     // Catch:{ all -> 0x0305 }
                    r4.append(r12)     // Catch:{ all -> 0x0305 }
                    r4.append(r5)     // Catch:{ all -> 0x0305 }
                    r4.append(r11)     // Catch:{ all -> 0x0305 }
                    com.xiaomi.mipush.sdk.MiPushCommandMessage r5 = r4     // Catch:{ all -> 0x0305 }
                    long r10 = r5.getResultCode()     // Catch:{ all -> 0x0305 }
                    r4.append(r10)     // Catch:{ all -> 0x0305 }
                    java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0305 }
                    android.util.Log.i(r2, r4)     // Catch:{ all -> 0x0305 }
                    goto L_0x01e2
                L_0x0174:
                    com.xiaomi.mipush.sdk.MiPushCommandMessage r4 = r4     // Catch:{ all -> 0x0305 }
                    long r14 = r4.getResultCode()     // Catch:{ all -> 0x0305 }
                    r16 = 70000001(0x42c1d81, double:3.45845957E-316)
                    int r4 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
                    if (r4 != 0) goto L_0x01b0
                    com.xiaomi.mipush.sdk.MiPushCommandMessage r4 = r4     // Catch:{ all -> 0x0305 }
                    long r14 = r4.getResultCode()     // Catch:{ all -> 0x0305 }
                    int r4 = (int) r14     // Catch:{ all -> 0x0305 }
                    r3.putExtra(r10, r4)     // Catch:{ all -> 0x0305 }
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0305 }
                    r4.<init>()     // Catch:{ all -> 0x0305 }
                    r4.append(r13)     // Catch:{ all -> 0x0305 }
                    r4.append(r7)     // Catch:{ all -> 0x0305 }
                    r4.append(r12)     // Catch:{ all -> 0x0305 }
                    r4.append(r5)     // Catch:{ all -> 0x0305 }
                    r4.append(r11)     // Catch:{ all -> 0x0305 }
                    com.xiaomi.mipush.sdk.MiPushCommandMessage r5 = r4     // Catch:{ all -> 0x0305 }
                    long r10 = r5.getResultCode()     // Catch:{ all -> 0x0305 }
                    r4.append(r10)     // Catch:{ all -> 0x0305 }
                    java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0305 }
                    android.util.Log.i(r2, r4)     // Catch:{ all -> 0x0305 }
                    goto L_0x01e2
                L_0x01b0:
                    com.xiaomi.mipush.sdk.MiPushCommandMessage r4 = r4     // Catch:{ all -> 0x0305 }
                    long r4 = r4.getResultCode()     // Catch:{ all -> 0x0305 }
                    int r4 = (int) r4     // Catch:{ all -> 0x0305 }
                    r3.putExtra(r10, r4)     // Catch:{ all -> 0x0305 }
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0305 }
                    r4.<init>()     // Catch:{ all -> 0x0305 }
                    java.lang.String r5 = "[OtherPush_XG_MI] register failed, errorCode: "
                    r4.append(r5)     // Catch:{ all -> 0x0305 }
                    com.xiaomi.mipush.sdk.MiPushCommandMessage r5 = r4     // Catch:{ all -> 0x0305 }
                    long r10 = r5.getResultCode()     // Catch:{ all -> 0x0305 }
                    r4.append(r10)     // Catch:{ all -> 0x0305 }
                    java.lang.String r5 = ", reason: "
                    r4.append(r5)     // Catch:{ all -> 0x0305 }
                    com.xiaomi.mipush.sdk.MiPushCommandMessage r5 = r4     // Catch:{ all -> 0x0305 }
                    java.lang.String r5 = r5.getReason()     // Catch:{ all -> 0x0305 }
                    r4.append(r5)     // Catch:{ all -> 0x0305 }
                    java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0305 }
                    android.util.Log.w(r2, r4)     // Catch:{ all -> 0x0305 }
                L_0x01e2:
                    r4 = r0
                    r7 = r9
                L_0x01e4:
                    android.content.Context r0 = r3     // Catch:{ all -> 0x0249 }
                    android.content.Context r0 = r0.getApplicationContext()     // Catch:{ all -> 0x0249 }
                    java.lang.String r5 = "tpush.vip.shareprefs"
                    android.content.SharedPreferences r5 = r0.getSharedPreferences(r5, r6)     // Catch:{ all -> 0x0249 }
                    java.lang.String r0 = com.tencent.android.mipush.XMPushMessageReceiver.errMsg     // Catch:{ all -> 0x0249 }
                    java.lang.String r10 = "other_push_error_code"
                    if (r0 == 0) goto L_0x0202
                    java.lang.String r0 = com.tencent.android.mipush.XMPushMessageReceiver.errMsg     // Catch:{ all -> 0x0249 }
                    int r0 = r0.length()     // Catch:{ all -> 0x0249 }
                    if (r0 > 0) goto L_0x0227
                L_0x0202:
                    java.lang.String r0 = com.tencent.android.mipush.XMPushMessageReceiver.md5(r10)     // Catch:{ all -> 0x020e }
                    java.lang.String r0 = r5.getString(r0, r9)     // Catch:{ all -> 0x020e }
                    java.lang.String unused = com.tencent.android.mipush.XMPushMessageReceiver.errMsg = r0     // Catch:{ all -> 0x020e }
                    goto L_0x0227
                L_0x020e:
                    r0 = move-exception
                    java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0249 }
                    r9.<init>()     // Catch:{ all -> 0x0249 }
                    java.lang.String r11 = "[OtherPush_XG_MI] onCommandResult read returnMsg from sp error: "
                    r9.append(r11)     // Catch:{ all -> 0x0249 }
                    java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0249 }
                    r9.append(r0)     // Catch:{ all -> 0x0249 }
                    java.lang.String r0 = r9.toString()     // Catch:{ all -> 0x0249 }
                    android.util.Log.d(r2, r0)     // Catch:{ all -> 0x0249 }
                L_0x0227:
                    if (r4 == 0) goto L_0x0262
                    java.lang.String r0 = com.tencent.android.mipush.XMPushMessageReceiver.errMsg     // Catch:{ all -> 0x0249 }
                    boolean r0 = r4.equals(r0)     // Catch:{ all -> 0x0249 }
                    if (r0 != 0) goto L_0x0262
                    java.lang.String unused = com.tencent.android.mipush.XMPushMessageReceiver.errMsg = r4     // Catch:{ all -> 0x0249 }
                    android.content.SharedPreferences$Editor r0 = r5.edit()     // Catch:{ all -> 0x0249 }
                    java.lang.String r4 = com.tencent.android.mipush.XMPushMessageReceiver.md5(r10)     // Catch:{ all -> 0x0249 }
                    java.lang.String r5 = com.tencent.android.mipush.XMPushMessageReceiver.errMsg     // Catch:{ all -> 0x0249 }
                    r0.putString(r4, r5)     // Catch:{ all -> 0x0249 }
                    r0.apply()     // Catch:{ all -> 0x0249 }
                    goto L_0x0262
                L_0x0249:
                    r0 = move-exception
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0305 }
                    r4.<init>()     // Catch:{ all -> 0x0305 }
                    java.lang.String r5 = "[OtherPush_XG_MI] onCommandResult save result errMsg error: "
                    r4.append(r5)     // Catch:{ all -> 0x0305 }
                    java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0305 }
                    r4.append(r0)     // Catch:{ all -> 0x0305 }
                    java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x0305 }
                    android.util.Log.w(r2, r0)     // Catch:{ all -> 0x0305 }
                L_0x0262:
                    r9 = r7
                    goto L_0x02a9
                L_0x0264:
                    java.lang.String r4 = "set-alias"
                    boolean r4 = r4.equals(r0)     // Catch:{ all -> 0x0305 }
                    if (r4 == 0) goto L_0x0272
                    com.xiaomi.mipush.sdk.MiPushCommandMessage r0 = r4     // Catch:{ all -> 0x0305 }
                    r0.getResultCode()     // Catch:{ all -> 0x0305 }
                    goto L_0x02a9
                L_0x0272:
                    java.lang.String r4 = "unset-alias"
                    boolean r4 = r4.equals(r0)     // Catch:{ all -> 0x0305 }
                    if (r4 == 0) goto L_0x0280
                    com.xiaomi.mipush.sdk.MiPushCommandMessage r0 = r4     // Catch:{ all -> 0x0305 }
                    r0.getResultCode()     // Catch:{ all -> 0x0305 }
                    goto L_0x02a9
                L_0x0280:
                    java.lang.String r4 = "subscribe-topic"
                    boolean r4 = r4.equals(r0)     // Catch:{ all -> 0x0305 }
                    if (r4 == 0) goto L_0x028e
                    com.xiaomi.mipush.sdk.MiPushCommandMessage r0 = r4     // Catch:{ all -> 0x0305 }
                    r0.getResultCode()     // Catch:{ all -> 0x0305 }
                    goto L_0x02a9
                L_0x028e:
                    java.lang.String r4 = "unsubscibe-topic"
                    boolean r4 = r4.equals(r0)     // Catch:{ all -> 0x0305 }
                    if (r4 == 0) goto L_0x029c
                    com.xiaomi.mipush.sdk.MiPushCommandMessage r0 = r4     // Catch:{ all -> 0x0305 }
                    r0.getResultCode()     // Catch:{ all -> 0x0305 }
                    goto L_0x02a9
                L_0x029c:
                    java.lang.String r4 = "accept-time"
                    boolean r0 = r4.equals(r0)     // Catch:{ all -> 0x0305 }
                    if (r0 == 0) goto L_0x02a9
                    com.xiaomi.mipush.sdk.MiPushCommandMessage r0 = r4     // Catch:{ all -> 0x0305 }
                    r0.getResultCode()     // Catch:{ all -> 0x0305 }
                L_0x02a9:
                    java.lang.String r0 = "other_push_token"
                    r3.putExtra(r0, r9)     // Catch:{ all -> 0x0305 }
                    java.lang.String r0 = "TPUSH.FEEDBACK"
                    r3.putExtra(r0, r8)     // Catch:{ all -> 0x0305 }
                    java.lang.String r0 = "PUSH.CHANNEL"
                    r4 = 103(0x67, float:1.44E-43)
                    r3.putExtra(r0, r4)     // Catch:{ all -> 0x0305 }
                    java.lang.String r0 = "pushChannel"
                    r3.putExtra(r0, r4)     // Catch:{ all -> 0x0305 }
                    android.content.Context r0 = r3     // Catch:{ all -> 0x0305 }
                    java.lang.String r0 = r0.getPackageName()     // Catch:{ all -> 0x0305 }
                    r3.setPackage(r0)     // Catch:{ all -> 0x0305 }
                    java.lang.String r0 = "TPUSH.OTHERPUSH.TOKENKEY"
                    java.lang.String r4 = "xiaomi_token"
                    r3.putExtra(r0, r4)     // Catch:{ all -> 0x0305 }
                    java.lang.Class<com.tencent.android.tpush.XGPushManager> r0 = com.tencent.android.tpush.XGPushManager.class
                    int r4 = com.tencent.android.tpush.XGPushManager.MAX_TAG_SIZE     // Catch:{ all -> 0x02f8 }
                    java.lang.String r4 = "onOtherPushRegister"
                    r5 = 2
                    java.lang.Class[] r7 = new java.lang.Class[r5]     // Catch:{ all -> 0x02f8 }
                    java.lang.Class<android.content.Context> r9 = android.content.Context.class
                    r7[r6] = r9     // Catch:{ all -> 0x02f8 }
                    java.lang.Class<android.content.Intent> r9 = android.content.Intent.class
                    r7[r8] = r9     // Catch:{ all -> 0x02f8 }
                    java.lang.reflect.Method r4 = r0.getDeclaredMethod(r4, r7)     // Catch:{ all -> 0x02f8 }
                    r4.setAccessible(r8)     // Catch:{ all -> 0x02f8 }
                    java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x02f8 }
                    android.content.Context r7 = r3     // Catch:{ all -> 0x02f8 }
                    android.content.Context r7 = r7.getApplicationContext()     // Catch:{ all -> 0x02f8 }
                    r5[r6] = r7     // Catch:{ all -> 0x02f8 }
                    r5[r8] = r3     // Catch:{ all -> 0x02f8 }
                    r4.invoke(r0, r5)     // Catch:{ all -> 0x02f8 }
                    r6 = r8
                    goto L_0x02fd
                L_0x02f8:
                    java.lang.String r0 = "[OtherPush_XG_MI] find XGPushManager error"
                    android.util.Log.w(r2, r0)     // Catch:{ all -> 0x0305 }
                L_0x02fd:
                    if (r6 != 0) goto L_0x030b
                    android.content.Context r0 = r3     // Catch:{ all -> 0x0305 }
                    r0.sendBroadcast(r3)     // Catch:{ all -> 0x0305 }
                    goto L_0x030b
                L_0x0305:
                    r0 = move-exception
                    java.lang.String r3 = "[OtherPush_XG_MI] onCommandResult "
                    android.util.Log.w(r2, r3, r0)
                L_0x030b:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.mipush.XMPushMessageReceiver.AnonymousClass1.run():void");
            }
        });
    }

    public void onNotificationMessageArrived(Context context, MiPushMessage miPushMessage) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        try {
            Class.forName("com.tencent.android.tpush.service.XGVipPushService");
            str = Constants.ACTION_FEEDBACK;
        } catch (ClassNotFoundException unused) {
            Log.w("TPush", "[OtherPush_XG_MI] find XGVipPushService error");
            str = "com.tencent.android.tpush.action.FEEDBACK";
        }
        try {
            Log.i("TPush", "[OtherPush_XG_MI] onNotificationMessageArrived->  Title: " + miPushMessage.getTitle() + " Content: " + miPushMessage.getContent() + " Extra = " + miPushMessage.getExtra().toString() + "description :" + miPushMessage.getDescription());
            Intent intent = new Intent(str);
            intent.putExtra(Constants.FEEDBACK_TAG, 5);
            intent.putExtra(MessageKey.MSG_PUSH_CHANNEL, 103);
            intent.putExtra(Constants.PUSH_CHANNEL, 103);
            intent.putExtra("content", miPushMessage.getDescription());
            intent.putExtra("title", miPushMessage.getTitle());
            intent.putExtra("type", 1L);
            if (miPushMessage.getExtra() != null) {
                intent.putExtra("custom_content", new JSONObject(miPushMessage.getExtra()).toString());
                if (miPushMessage.getExtra().containsKey("msgId") && (str5 = miPushMessage.getExtra().get("msgId")) != null) {
                    intent.putExtra("msgId", Long.valueOf(str5));
                }
                if (miPushMessage.getExtra().containsKey(MessageKey.MSG_BUSI_MSG_ID) && (str4 = miPushMessage.getExtra().get(MessageKey.MSG_BUSI_MSG_ID)) != null) {
                    intent.putExtra(MessageKey.MSG_BUSI_MSG_ID, Long.valueOf(str4));
                }
                if (miPushMessage.getExtra().containsKey(AuthHandler.EXTRA_TOKEN_SECRET)) {
                    String str6 = miPushMessage.getExtra().get(AuthHandler.EXTRA_TOKEN_SECRET);
                    if (str6 != null) {
                        intent.putExtra(MessageKey.MSG_PUSH_TIME, Long.valueOf(str6));
                    } else {
                        intent.putExtra(MessageKey.MSG_PUSH_TIME, System.currentTimeMillis());
                    }
                } else {
                    intent.putExtra(MessageKey.MSG_PUSH_TIME, System.currentTimeMillis());
                }
                if (miPushMessage.getExtra().containsKey("groupId")) {
                    intent.putExtra("groupId", miPushMessage.getExtra().get("groupId"));
                }
                if (miPushMessage.getExtra().containsKey(MessageKey.MSG_TARGET_TYPE) && (str3 = miPushMessage.getExtra().get(MessageKey.MSG_TARGET_TYPE)) != null) {
                    intent.putExtra(MessageKey.MSG_TARGET_TYPE, Long.valueOf(str3));
                }
                if (miPushMessage.getExtra().containsKey("source") && (str2 = miPushMessage.getExtra().get("source")) != null) {
                    intent.putExtra("source", Long.valueOf(str2));
                }
            } else {
                intent.putExtra("custom_content", "");
            }
            intent.putExtra(MessageKey.MSG_CREATE_TIMESTAMPS, System.currentTimeMillis() / 1000);
            intent.setPackage(context.getPackageName());
            context.sendBroadcast(intent);
        } catch (Throwable th2) {
            Log.e("TPush", "[OtherPush_XG_MI] onNotificationMessageArrived ", th2);
        }
    }

    public void onNotificationMessageClicked(Context context, MiPushMessage miPushMessage) {
    }

    public void onReceivePassThroughMessage(Context context, MiPushMessage miPushMessage) {
        String str;
        String str2;
        String str3;
        try {
            Class.forName("com.tencent.android.tpush.service.XGVipPushService");
            str = Constants.ACTION_PUSH_MESSAGE;
        } catch (ClassNotFoundException unused) {
            Log.w("TPush", "[OtherPush_XG_MI] find XGVipPushService error");
            str = "com.tencent.android.tpush.action.PUSH_MESSAGE";
        }
        try {
            Log.i("TPush", "[OtherPush_XG_MI] onReceivePassThroughMessage->  Title: " + miPushMessage.getTitle() + " Content: " + miPushMessage.getContent() + "description :" + miPushMessage.getDescription());
            Intent intent = new Intent(str);
            intent.putExtra(Constants.PUSH_CHANNEL, 103);
            intent.putExtra(MessageKey.MSG_PUSH_CHANNEL, 103);
            intent.putExtra("content", miPushMessage.getContent());
            intent.putExtra("title", miPushMessage.getTitle());
            intent.putExtra("type", 2L);
            if (miPushMessage.getExtra() != null) {
                intent.putExtra("custom_content", new JSONObject(miPushMessage.getExtra()).toString());
                if (miPushMessage.getExtra().containsKey("msgId") && (str3 = miPushMessage.getExtra().get("msgId")) != null) {
                    intent.putExtra("msgId", Long.valueOf(str3));
                }
                if (miPushMessage.getExtra().containsKey(MessageKey.MSG_BUSI_MSG_ID) && (str2 = miPushMessage.getExtra().get(MessageKey.MSG_BUSI_MSG_ID)) != null) {
                    intent.putExtra(MessageKey.MSG_BUSI_MSG_ID, Long.valueOf(str2));
                }
            } else {
                intent.putExtra("custom_content", "");
            }
            intent.putExtra(MessageKey.MSG_CREATE_TIMESTAMPS, System.currentTimeMillis() / 1000);
            intent.setPackage(context.getPackageName());
            context.sendBroadcast(intent);
        } catch (Throwable th2) {
            Log.e("TPush", "[OtherPush_XG_MI] onReceivePassThroughMessage ", th2);
        }
    }
}
