package com.tencent.android.tpush.message;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sumsub.sns.internal.core.data.source.dynamic.c;
import com.tencent.android.tpush.XGIOperateCallback;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.common.BroadcastAgent;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.common.MessageKey;
import com.tencent.android.tpush.common.j;
import com.tencent.android.tpush.data.MessageId;
import com.tencent.android.tpush.data.RegisterEntity;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.b;
import com.tencent.android.tpush.service.cache.CacheManager;
import com.tencent.android.tpush.service.util.g;
import com.tencent.android.tpush.stat.ServiceStat;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.TIMMentionEditText;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.baseapi.base.util.TTask;
import com.tencent.tpns.dataacquisition.DeviceInfos;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class e {

    /* renamed from: a  reason: collision with root package name */
    public static ArrayList<Long> f69471a;

    /* renamed from: b  reason: collision with root package name */
    private static volatile e f69472b;

    /* renamed from: c  reason: collision with root package name */
    private static long f69473c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public Context f69474d = null;

    public class a extends TTask {

        /* renamed from: b  reason: collision with root package name */
        private Context f69481b;

        /* renamed from: c  reason: collision with root package name */
        private Intent f69482c;

        /* renamed from: d  reason: collision with root package name */
        private XGIOperateCallback f69483d;

        public a(Context context, Intent intent, XGIOperateCallback xGIOperateCallback) {
            this.f69481b = context;
            this.f69482c = intent;
            this.f69483d = xGIOperateCallback;
        }

        private void a() {
            Intent intent = new Intent(Constants.ACTION_PUSH_MESSAGE);
            intent.putExtras(this.f69482c);
            if (com.tencent.android.tpush.f.a.a(this.f69481b)) {
                String stringExtra = this.f69482c.getStringExtra(Constants.XG_SYS_INTENT_KEY_THIRD_APP);
                if (!j.b(stringExtra)) {
                    TLogger.ii("PushMessageRunnable", "ACTION_PUSH_MESSAGE otherApp -> " + stringExtra);
                    intent.setPackage(stringExtra);
                    this.f69481b.sendBroadcast(intent);
                } else {
                    intent.setPackage(this.f69481b.getPackageName());
                    BroadcastAgent.sendBroadcast(this.f69481b, intent);
                }
            } else {
                intent.setPackage(this.f69481b.getPackageName());
                BroadcastAgent.sendBroadcast(this.f69481b, intent);
            }
            String stringExtra2 = this.f69482c.getStringExtra(MessageKey.MSG_SERVICE_PACKAGE_NAME);
            if (!j.b(stringExtra2)) {
                Intent intent2 = new Intent(this.f69481b.getPackageName() + "com.tencent.android.xg.vip.action.ack.sdk2srv.V4");
                intent2.setPackage(stringExtra2);
                intent2.putExtras(this.f69482c);
                BroadcastAgent.sendBroadcast(this.f69481b, intent2);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:120:0x0320, code lost:
            return;
         */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x0151 A[Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb, all -> 0x0321 }] */
        /* JADX WARNING: Removed duplicated region for block: B:46:0x0168  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void TRun() {
            /*
                r22 = this;
                r1 = r22
                com.tencent.android.tpush.message.e r2 = com.tencent.android.tpush.message.e.this
                monitor-enter(r2)
                boolean r3 = com.tencent.android.tpush.XGPushConfig.enableDebug     // Catch:{ all -> 0x0321 }
                if (r3 == 0) goto L_0x0010
                java.lang.String r3 = "PushMessageRunnable"
                java.lang.String r4 = "Action -> handlerPushMessage"
                com.tencent.android.tpush.logging.TLogger.d(r3, r4)     // Catch:{ all -> 0x0321 }
            L_0x0010:
                r3 = 0
                android.content.Intent r4 = r1.f69482c     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                java.lang.String r5 = "msgId"
                r6 = -1
                long r14 = r4.getLongExtra(r5, r6)     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                android.content.Context r4 = r1.f69481b     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                android.content.Intent r5 = r1.f69482c     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                com.tencent.android.tpush.message.PushMessageManager r4 = com.tencent.android.tpush.message.PushMessageManager.getInstance(r4, r5)     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                android.content.Intent r5 = r1.f69482c     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                java.lang.String r8 = "expire_time"
                r9 = 0
                long r11 = r5.getLongExtra(r8, r9)     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                android.content.Intent r5 = r1.f69482c     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                java.lang.String r8 = "ttl"
                int r5 = r5.getIntExtra(r8, r3)     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                java.lang.String r8 = "PushMessageRunnable"
                java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                r13.<init>()     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                java.lang.String r3 = "get msgIntent expire_time: "
                r13.append(r3)     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                r13.append(r11)     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                java.lang.String r3 = ", ttl: "
                r13.append(r3)     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                long r6 = (long) r5     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                r18 = 1000(0x3e8, double:4.94E-321)
                long r6 = r6 * r18
                r13.append(r6)     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                java.lang.String r3 = r13.toString()     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                com.tencent.android.tpush.logging.TLogger.d(r8, r3)     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                long r9 = java.lang.System.currentTimeMillis()     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                long r6 = r6 + r9
                r20 = 30000(0x7530, double:1.4822E-319)
                long r6 = r6 + r20
                int r3 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
                if (r3 >= 0) goto L_0x0093
                java.lang.String r3 = "PushMessageRunnable"
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                r5.<init>()     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                java.lang.String r6 = "invalid expire_time larger than currentTime plus ttl too much, msgid = "
                r5.append(r6)     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                r5.append(r14)     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                java.lang.String r6 = ", currentTime: "
                r5.append(r6)     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                r5.append(r9)     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                java.lang.String r5 = r5.toString()     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                com.tencent.android.tpush.logging.TLogger.w(r3, r5)     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                com.tencent.android.tpush.message.MessageManager r3 = com.tencent.android.tpush.message.MessageManager.getInstance()     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                android.content.Context r5 = r1.f69481b     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                r3.deleteCachedMsgIntent(r5, r14)     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                android.content.Context r3 = r1.f69481b     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                com.tencent.android.tpush.XGPushManager.msgAck(r3, r4)     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                monitor-exit(r2)     // Catch:{ all -> 0x0321 }
                return
            L_0x0093:
                r6 = 0
                int r3 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1))
                if (r3 > 0) goto L_0x0114
                android.content.Intent r3 = r1.f69482c     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                java.lang.String r6 = "server_time"
                r20 = r11
                r7 = -1
                long r11 = r3.getLongExtra(r6, r7)     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                java.lang.String r3 = "PushMessageRunnable"
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                r6.<init>()     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                java.lang.String r7 = "get msgIntent serverTime: "
                r6.append(r7)     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                r6.append(r11)     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                java.lang.String r6 = r6.toString()     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                com.tencent.android.tpush.logging.TLogger.d(r3, r6)     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                r6 = 0
                int r3 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1))
                if (r3 <= 0) goto L_0x0116
                if (r5 > 0) goto L_0x00c6
                r5 = 259200(0x3f480, float:3.63217E-40)
            L_0x00c6:
                java.lang.String r3 = java.lang.String.valueOf(r11)     // Catch:{ all -> 0x00f0 }
                long r6 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00f0 }
                java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x00f0 }
                int r7 = r6.length()     // Catch:{ all -> 0x00f0 }
                int r8 = r3.length()     // Catch:{ all -> 0x00f0 }
                int r7 = r7 - r8
                r8 = 3
                if (r7 != r8) goto L_0x00e1
                long r11 = r11 * r18
                goto L_0x00f9
            L_0x00e1:
                int r6 = r6.length()     // Catch:{ all -> 0x00f0 }
                int r3 = r3.length()     // Catch:{ all -> 0x00f0 }
                int r6 = r6 - r3
                r3 = -3
                if (r6 != r3) goto L_0x00f9
                long r11 = r11 / r18
                goto L_0x00f9
            L_0x00f0:
                r0 = move-exception
                r3 = r0
                java.lang.String r6 = "PushMessageHandler"
                java.lang.String r7 = ""
                com.tencent.android.tpush.logging.TLogger.e(r6, r7, r3)     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
            L_0x00f9:
                int r5 = r5 * 1000
                long r5 = (long) r5     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                long r11 = r11 + r5
                java.lang.String r3 = "PushMessageRunnable"
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                r5.<init>()     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                java.lang.String r6 = "execute expire_time: "
                r5.append(r6)     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                r5.append(r11)     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                java.lang.String r5 = r5.toString()     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                com.tencent.android.tpush.logging.TLogger.d(r3, r5)     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                goto L_0x0118
            L_0x0114:
                r20 = r11
            L_0x0116:
                r11 = r20
            L_0x0118:
                android.content.Intent r3 = r1.f69482c     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                java.lang.String r3 = r3.getPackage()     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                r5.<init>()     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                java.lang.String r6 = "@"
                r5.append(r6)     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                r5.append(r14)     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                r5.append(r3)     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                java.lang.String r3 = "@"
                r5.append(r3)     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                java.lang.String r3 = r5.toString()     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                android.content.Intent r5 = r1.f69482c     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                java.lang.String r6 = "accId"
                r7 = -1
                long r5 = r5.getLongExtra(r6, r7)     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                android.content.Context r7 = r1.f69481b     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                java.lang.String r7 = com.tencent.android.tpush.message.MessageManager.getNotifiedMsgIds(r7, r5)     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                long r16 = r4.getType()     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                r18 = 7
                int r8 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1))
                if (r8 != 0) goto L_0x0168
                boolean r3 = r7.contains(r3)     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                if (r3 != 0) goto L_0x0166
                java.lang.String r3 = r4.getInMsg()     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                boolean r3 = com.tencent.android.tpush.common.j.b((java.lang.String) r3)     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                if (r3 != 0) goto L_0x0166
                android.content.Context r3 = r1.f69481b     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                com.tencent.android.tpush.b.a.a(r3, r4)     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
            L_0x0166:
                monitor-exit(r2)     // Catch:{ all -> 0x0321 }
                return
            L_0x0168:
                r16 = 0
                int r8 = (r11 > r16 ? 1 : (r11 == r16 ? 0 : -1))
                if (r8 <= 0) goto L_0x01a8
                int r8 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
                if (r8 <= 0) goto L_0x01a8
                java.lang.String r3 = "PushMessageHandler"
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                r5.<init>()     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                java.lang.String r6 = "msg is expired, currentTimeMillis="
                r5.append(r6)     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                r5.append(r9)     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                java.lang.String r6 = ", expire_time="
                r5.append(r6)     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                r5.append(r11)     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                java.lang.String r6 = ". msgid = "
                r5.append(r6)     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                r5.append(r14)     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                java.lang.String r5 = r5.toString()     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                com.tencent.android.tpush.logging.TLogger.e(r3, r5)     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                com.tencent.android.tpush.message.MessageManager r3 = com.tencent.android.tpush.message.MessageManager.getInstance()     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                android.content.Context r5 = r1.f69481b     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                r3.deleteCachedMsgIntent(r5, r14)     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                android.content.Context r3 = r1.f69481b     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                com.tencent.android.tpush.XGPushManager.msgAck(r3, r4)     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                monitor-exit(r2)     // Catch:{ all -> 0x0321 }
                return
            L_0x01a8:
                java.lang.Long r8 = java.lang.Long.valueOf(r14)     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                boolean r8 = com.tencent.android.tpush.message.e.a((java.lang.Long) r8)     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                if (r8 != 0) goto L_0x01b9
                android.content.Context r3 = r1.f69481b     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                com.tencent.android.tpush.XGPushManager.msgAck(r3, r4)     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                monitor-exit(r2)     // Catch:{ all -> 0x0321 }
                return
            L_0x01b9:
                android.content.Intent r8 = r1.f69482c     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                java.lang.String r9 = "busiMsgId"
                r10 = 0
                long r12 = r8.getLongExtra(r9, r10)     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                android.content.Intent r8 = r1.f69482c     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                java.lang.String r9 = "timestamps"
                long r10 = r8.getLongExtra(r9, r10)     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                android.content.Context r8 = r1.f69481b     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                java.util.List r8 = com.tencent.android.tpush.XGPushConfig.getAccessidList(r8)     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                android.content.Context r9 = r1.f69481b     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                boolean r9 = com.tencent.android.tpush.f.a.a(r9)     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                if (r9 != 0) goto L_0x0221
                if (r8 == 0) goto L_0x0221
                int r9 = r8.size()     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                if (r9 <= 0) goto L_0x0221
                java.lang.Long r9 = java.lang.Long.valueOf(r5)     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                boolean r9 = r8.contains(r9)     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                if (r9 != 0) goto L_0x0221
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                r7.<init>()     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                java.lang.String r9 = "PushMessageRunnable match accessId failed, message droped cause accessId:"
                r7.append(r9)     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                r7.append(r5)     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                java.lang.String r5 = " not in "
                r7.append(r5)     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                r7.append(r8)     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                java.lang.String r5 = " msgId = "
                r7.append(r5)     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                r7.append(r3)     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                java.lang.String r3 = r7.toString()     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                java.lang.String r5 = "PushMessageRunnable"
                com.tencent.android.tpush.logging.TLogger.ee(r5, r3)     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                com.tencent.android.tpush.message.MessageManager r3 = com.tencent.android.tpush.message.MessageManager.getInstance()     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                android.content.Context r5 = r1.f69481b     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                r3.deleteCachedMsgIntent(r5, r14)     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                android.content.Context r3 = r1.f69481b     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                com.tencent.android.tpush.XGPushManager.msgAck(r3, r4)     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                monitor-exit(r2)     // Catch:{ all -> 0x0321 }
                return
            L_0x0221:
                boolean r8 = r7.contains(r3)     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                r9 = 0
                if (r8 != 0) goto L_0x02e7
                android.content.Context r8 = r1.f69481b     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                boolean r3 = com.tencent.android.tpush.message.MessageManager.setNotifiedMsgIds(r8, r5, r3, r7)     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                if (r3 != 0) goto L_0x0232
                monitor-exit(r2)     // Catch:{ all -> 0x0321 }
                return
            L_0x0232:
                java.lang.String r3 = "PushMessageRunnable"
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                r5.<init>()     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                java.lang.String r6 = "Receiver msg from server :"
                r5.append(r6)     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                java.lang.String r6 = r4.toString()     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                r5.append(r6)     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                java.lang.String r5 = r5.toString()     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                com.tencent.android.tpush.logging.TLogger.i(r3, r5)     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                android.content.Context r3 = r1.f69481b     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                com.tencent.android.tpush.XGPushManager.msgAck(r3, r4)     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                android.content.Intent r3 = r1.f69482c     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                java.lang.String r5 = "svrPkgName"
                java.lang.String r3 = r3.getStringExtra(r5)     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                android.content.Context r5 = r1.f69481b     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                java.lang.String r5 = r5.getPackageName()     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                boolean r5 = r5.equals(r3)     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                if (r5 != 0) goto L_0x0282
                java.lang.String r5 = "PushMessageRunnable"
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                r6.<init>()     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                java.lang.String r7 = "Receiver msg from other app :"
                r6.append(r7)     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                r6.append(r3)     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                java.lang.String r3 = r6.toString()     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                com.tencent.android.tpush.logging.TLogger.ii(r5, r3)     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                android.content.Context r3 = r1.f69481b     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                android.content.Intent r5 = r1.f69482c     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                com.tencent.android.tpush.stat.ServiceStat.appReportPullupAck(r3, r5)     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
            L_0x0282:
                com.tencent.android.tpush.message.a r3 = r4.getMessageHolder()     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                if (r3 == 0) goto L_0x02e4
                java.lang.String r5 = r4.getContent()     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                boolean r5 = com.tencent.android.tpush.common.j.b((java.lang.String) r5)     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                if (r5 != 0) goto L_0x02e4
                com.tencent.android.tpush.message.c r8 = new com.tencent.android.tpush.message.c     // Catch:{ all -> 0x02cc }
                android.content.Context r5 = r1.f69481b     // Catch:{ all -> 0x02cc }
                android.content.Intent r6 = r1.f69482c     // Catch:{ all -> 0x02cc }
                r8.<init>(r5, r6)     // Catch:{ all -> 0x02cc }
                r5 = r9
                r9 = r4
                boolean r6 = r8.a(r9, r10, r12, r14)     // Catch:{ all -> 0x02cc }
                if (r6 == 0) goto L_0x02be
                r22.a()     // Catch:{ all -> 0x02cc }
                com.tencent.android.tpush.message.MessageManager r6 = com.tencent.android.tpush.message.MessageManager.getInstance()     // Catch:{ all -> 0x02cc }
                android.content.Context r7 = r1.f69481b     // Catch:{ all -> 0x02cc }
                long r8 = r4.getMsgId()     // Catch:{ all -> 0x02cc }
                r6.updateCachedMsgIntentToShowed(r7, r8)     // Catch:{ all -> 0x02cc }
                int r3 = r3.b()     // Catch:{ all -> 0x02cc }
                r6 = 1
                if (r3 != r6) goto L_0x02e5
                r4.showNotifacition()     // Catch:{ all -> 0x02cc }
                goto L_0x02e5
            L_0x02be:
                com.tencent.android.tpush.message.MessageManager r3 = com.tencent.android.tpush.message.MessageManager.getInstance()     // Catch:{ all -> 0x02cc }
                android.content.Context r6 = r1.f69481b     // Catch:{ all -> 0x02cc }
                long r7 = r4.getMsgId()     // Catch:{ all -> 0x02cc }
                r3.updateCachedMsgIntentToVerifyErr(r6, r7)     // Catch:{ all -> 0x02cc }
                goto L_0x02e5
            L_0x02cc:
                r0 = move-exception
                r3 = r0
                java.lang.String r5 = "PushMessageRunnable"
                java.lang.String r6 = "unknown error"
                com.tencent.android.tpush.logging.TLogger.e(r5, r6, r3)     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                com.tencent.android.tpush.message.MessageManager r5 = com.tencent.android.tpush.message.MessageManager.getInstance()     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                android.content.Context r6 = r1.f69481b     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                long r7 = r4.getMsgId()     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                r5.updateCachedMsgIntentToVerifyErr(r6, r7)     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                r9 = r3
                goto L_0x0308
            L_0x02e4:
                r5 = r9
            L_0x02e5:
                r9 = r5
                goto L_0x0308
            L_0x02e7:
                r5 = r9
                r1.f69483d = r5     // Catch:{ JSONException -> 0x02ff, IllegalArgumentException -> 0x02f5, all -> 0x02eb }
                goto L_0x02e5
            L_0x02eb:
                r0 = move-exception
                r9 = r0
                java.lang.String r3 = "PushMessageRunnable"
                java.lang.String r4 = "unknown error"
                com.tencent.android.tpush.logging.TLogger.e(r3, r4, r9)     // Catch:{ all -> 0x0321 }
                goto L_0x0308
            L_0x02f5:
                r0 = move-exception
                r9 = r0
                java.lang.String r3 = "PushMessageRunnable"
                java.lang.String r4 = "push msg type error"
                com.tencent.android.tpush.logging.TLogger.e(r3, r4, r9)     // Catch:{ all -> 0x0321 }
                goto L_0x0308
            L_0x02ff:
                r0 = move-exception
                r9 = r0
                java.lang.String r3 = "PushMessageRunnable"
                java.lang.String r4 = "push parse error"
                com.tencent.android.tpush.logging.TLogger.e(r3, r4, r9)     // Catch:{ all -> 0x0321 }
            L_0x0308:
                com.tencent.android.tpush.XGIOperateCallback r3 = r1.f69483d     // Catch:{ all -> 0x0321 }
                if (r3 == 0) goto L_0x031f
                if (r9 == 0) goto L_0x0319
                java.lang.String r4 = ""
                r5 = -1
                java.lang.String r6 = r9.toString()     // Catch:{ all -> 0x0321 }
                r3.onFail(r4, r5, r6)     // Catch:{ all -> 0x0321 }
                goto L_0x031f
            L_0x0319:
                java.lang.String r4 = ""
                r5 = 0
                r3.onSuccess(r4, r5)     // Catch:{ all -> 0x0321 }
            L_0x031f:
                monitor-exit(r2)     // Catch:{ all -> 0x0321 }
                return
            L_0x0321:
                r0 = move-exception
                r3 = r0
                monitor-exit(r2)     // Catch:{ all -> 0x0321 }
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.message.e.a.TRun():void");
        }
    }

    /* access modifiers changed from: private */
    public void c(final Intent intent) {
        CommonWorkingThread.getInstance().execute(new TTask() {
            public void TRun() {
                if (intent.getLongExtra("type", -1) != 7 || XGPushConfig.isEnableShowInMsg(e.this.f69474d)) {
                    String stringExtra = intent.getStringExtra(MessageKey.MSG_DATE);
                    if (intent.getLongExtra("msgId", -1) < 0) {
                        try {
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
                            if (!j.b(stringExtra)) {
                                if (j.b(stringExtra) || simpleDateFormat.parse(stringExtra).compareTo(simpleDateFormat.parse(simpleDateFormat.format(new Date()))) != 0) {
                                    if (j.b(stringExtra) || simpleDateFormat.parse(stringExtra).compareTo(simpleDateFormat.parse(simpleDateFormat.format(new Date()))) >= 0) {
                                        TLogger.w("PushMessageHandler", "can not handle the local message because of the date");
                                        return;
                                    } else {
                                        e.this.a(intent);
                                        return;
                                    }
                                }
                            }
                            if (g.a(intent)) {
                                e.this.a(intent);
                            } else {
                                TLogger.w("PushMessageHandler", "can not handle the local message because of the time");
                            }
                        } catch (ParseException e11) {
                            TLogger.ee("PushMessageHandler", "try to handlerPushMessage, but ParseException : " + e11);
                        }
                    } else if (g.a(intent)) {
                        e.this.a(intent);
                    } else {
                        TLogger.w("PushMessageHandler", "can not handle the message because of the time");
                    }
                } else {
                    TLogger.w("PushMessageHandler", "handle pushMessage inMsg not allowed");
                    ServiceStat.appReportInMsgUserDisabled(e.this.f69474d, intent);
                }
            }
        });
    }

    public void b(final Intent intent) {
        CommonWorkingThread.getInstance().execute(new TTask() {
            public void TRun() {
                if (XGPushConfig.enableDebug) {
                    TLogger.d("PushMessageHandler", "Action -> handleRemotePushMessage");
                }
                long longExtra = intent.getLongExtra("msgId", 0);
                long longExtra2 = intent.getLongExtra(MessageKey.MSG_CREATE_TIMESTAMPS, 0);
                long longExtra3 = intent.getLongExtra("server_time", 0);
                int intExtra = intent.getIntExtra("ttl", 0);
                long longExtra4 = intent.getLongExtra("type", 1);
                int intExtra2 = intent.getIntExtra(MessageKey.MSG_REVOKEID, 0);
                if (intExtra2 > 0) {
                    try {
                        TLogger.i("PushMessageHandler", "message revokeId of notifyId " + intExtra2);
                        ((NotificationManager) e.this.f69474d.getSystemService(RemoteMessageConst.NOTIFICATION)).cancel(intExtra2);
                    } catch (Throwable th2) {
                        TLogger.e("PushMessageHandler", "NotificationManager.cancel error: " + th2.toString());
                    }
                } else if (!XGPushConfig.isNotificationShowEnable(e.this.f69474d)) {
                    TLogger.ii("PushMessageHandler", "XINGE NotificationShow is not enabe, so discard this notification, msgid:" + longExtra);
                } else {
                    long j11 = longExtra4;
                    long longExtra5 = intent.getLongExtra("accId", 0);
                    String str = intent.getPackage();
                    try {
                        RegisterEntity currentAppRegisterEntity = CacheManager.getCurrentAppRegisterEntity(e.this.f69474d);
                        if (currentAppRegisterEntity != null && !j.b(currentAppRegisterEntity.packageName) && str.equals(currentAppRegisterEntity.packageName) && longExtra5 == currentAppRegisterEntity.accessId && currentAppRegisterEntity.state == 1) {
                            return;
                        }
                    } catch (Throwable th3) {
                        TLogger.e("PushMessageHandler", th3.toString());
                    }
                    String stringExtra = intent.getStringExtra(MessageKey.MSG_DATE);
                    int i11 = intExtra;
                    long longExtra6 = intent.getLongExtra(MessageKey.MSG_EXTRA_PUSHTIME, 0);
                    String str2 = "PushMessageHandler";
                    long j12 = longExtra3;
                    long longExtra7 = intent.getLongExtra(MessageKey.MSG_BUSI_MSG_ID, 0);
                    long j13 = longExtra6;
                    long longExtra8 = intent.getLongExtra(MessageKey.MSG_CREATE_MULTIPKG, 0);
                    long longExtra9 = intent.getLongExtra(MessageKey.MSG_CHANNEL_ID, -1);
                    String stringExtra2 = intent.getStringExtra("group_id");
                    String stringExtra3 = intent.getStringExtra(MessageKey.MSG_STAT_TAG);
                    long currentTimeMillis = System.currentTimeMillis();
                    String str3 = stringExtra2;
                    MessageId messageId = new MessageId();
                    messageId.f69316id = longExtra;
                    messageId.isAck = 0;
                    messageId.accessId = longExtra5;
                    long j14 = longExtra5;
                    messageId.host = intent.getLongExtra(MessageKey.MSG_EXTRA_HOST, 0);
                    messageId.port = intent.getIntExtra(MessageKey.MSG_EXTRA_PORT, 0);
                    messageId.pact = intent.getByteExtra(MessageKey.MSG_EXTRA_PACT, (byte) 0);
                    messageId.apn = DeviceInfos.getNetworkType(e.this.f69474d);
                    messageId.isp = j.p(e.this.f69474d);
                    messageId.serviceHost = intent.getStringExtra(MessageKey.MSG_SERVICE_PACKAGE_NAME);
                    messageId.receivedTime = currentTimeMillis;
                    messageId.pkgName = str;
                    messageId.busiMsgId = longExtra7;
                    messageId.timestamp = longExtra2;
                    long j15 = j11;
                    messageId.msgType = j15;
                    long j16 = longExtra8;
                    messageId.multiPkg = j16;
                    messageId.date = stringExtra;
                    messageId.channelId = longExtra9;
                    long j17 = currentTimeMillis;
                    messageId.pushTime = intent.getLongExtra(MessageKey.MSG_PUSH_TIME, 0);
                    messageId.pushChannel = intent.getIntExtra(MessageKey.MSG_PUSH_CHANNEL, 100);
                    String stringExtra4 = intent.getStringExtra("groupId");
                    if (!j.b(stringExtra4)) {
                        messageId.nGroupId = stringExtra4;
                    }
                    if (!j.b(str3)) {
                        messageId.groupId = str3;
                    }
                    if (!j.b(stringExtra3)) {
                        messageId.statTag = stringExtra3;
                    }
                    String str4 = str2;
                    TLogger.i(str4, ">> msg from service,  @msgId=" + messageId.f69316id + " @accId=" + messageId.accessId + " @timeUs=" + j13 + " @recTime=" + messageId.receivedTime + " @msg.date=" + stringExtra + " @msg.busiMsgId=" + longExtra7 + " @msg.timestamp=" + longExtra2 + " @msg.type=" + j15 + " @msg.multiPkg=" + j16 + " @msg.serverTime=" + j12 + " @msg.ttl=" + i11 + " @currentTimeMillis=" + j17);
                    String notifiedMsgIds = MessageManager.getNotifiedMsgIds(e.this.f69474d, j14);
                    String str5 = TIMMentionEditText.TIM_MENTION_TAG + messageId.f69316id + str + TIMMentionEditText.TIM_MENTION_TAG;
                    TLogger.i(str4, "cache msgIds:" + notifiedMsgIds + ", vs current msgIdstr:" + str5);
                    if (notifiedMsgIds.contains(str5)) {
                        TLogger.ee(str4, "getNotifiedMsgIds contain the msgId id:" + str5 + ", return");
                    } else if (MessageManager.getInstance().isMsgAcked(e.this.f69474d, str, messageId.f69316id)) {
                        TLogger.ee(str4, ">> msgId:" + messageId.f69316id + " has been acked, return");
                    } else {
                        messageId.pkgName = str;
                        if (messageId.f69316id > 0) {
                            MessageManager.getInstance().addMsgId(e.this.f69474d, str, messageId);
                        }
                        MessageManager.getInstance().addNewCachedMsgIntent(e.this.f69474d, intent);
                        e.this.c(intent);
                    }
                }
            }
        });
    }

    public static e a(Context context) {
        if (f69472b == null) {
            synchronized (e.class) {
                if (f69472b == null) {
                    f69472b = new e();
                    f69472b.f69474d = context.getApplicationContext();
                    b.b(f69472b.f69474d);
                }
            }
        }
        return f69472b;
    }

    public void a(Intent intent) {
        CommonWorkingThread.getInstance().execute(new a(this.f69474d, intent, (XGIOperateCallback) null));
    }

    public static synchronized boolean a(Long l11) {
        synchronized (e.class) {
            try {
                if (f69471a == null) {
                    f69471a = new ArrayList<>();
                }
                if (f69471a.contains(l11)) {
                    return false;
                }
                f69471a.add(l11);
                if (f69471a.size() > 200) {
                    f69471a.remove(0);
                }
                return true;
            } catch (Throwable th2) {
                TLogger.e("PushMessageHandler", "addCachedmsgID " + l11, th2);
            }
        }
    }

    public synchronized void a(boolean z11) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - f69473c > c.f33305t || z11) {
            f69473c = currentTimeMillis;
            CommonWorkingThread.getInstance().execute(new TTask() {
                public void TRun() {
                    ArrayList<Intent> newCachedMsgIntentList;
                    if (e.this.f69474d != null && !j.b(e.this.f69474d.getPackageName()) && (newCachedMsgIntentList = MessageManager.getInstance().getNewCachedMsgIntentList(e.this.f69474d)) != null && newCachedMsgIntentList.size() > 0) {
                        if (XGPushConfig.enableDebug) {
                            TLogger.d("PushMessageHandler", "Action -> trySendCachedMsg with CachedMsgList size = " + newCachedMsgIntentList.size());
                        }
                        for (int i11 = 0; i11 < newCachedMsgIntentList.size(); i11++) {
                            try {
                                e.this.c(newCachedMsgIntentList.get(i11));
                            } catch (Throwable th2) {
                                TLogger.e("PushMessageHandler", "", th2);
                            }
                        }
                    }
                }
            });
        }
    }
}
