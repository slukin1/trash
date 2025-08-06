package com.tencent.android.tpush.stat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import com.engagelab.privates.push.constants.MTPushConstants;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.common.AppInfos;
import com.tencent.android.tpush.common.h;
import com.tencent.android.tpush.d.d;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.protocol.PushStatClientReport;
import com.tencent.android.tpush.service.protocol.j;
import com.tencent.android.tpush.stat.event.b;
import com.tencent.android.tpush.stat.event.g;
import com.tencent.tpns.baseapi.base.util.ChannelUtils;
import com.tencent.tpns.baseapi.base.util.CloudManager;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.baseapi.base.util.ErrCode;
import com.tencent.tpns.baseapi.base.util.TTask;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class ServiceStat {
    public static final String ACCOUNT_EVENT_ID = "SdkAccount";
    public static final String ACK_EVENT_ID = "Ack";
    public static final String APP_LIST_EVENT_ID = "app_list";
    public static final int EnumPushAction_IN_MSG_ACTION_MOBILE_USER_DISABLED = 129;
    public static final int EnumPushAction_PUSH_ACTION_MOBILE_APP_RECEIVED = 8;
    public static final int EnumPushAction_PUSH_ACTION_MOBILE_CLEAN_UP = 64;
    public static final int EnumPushAction_PUSH_ACTION_MOBILE_REVOKE_MESSAGE_SERVICE_RECEIVED = 2048;
    public static final int EnumPushAction_PUSH_ACTION_MOBILE_SERVICE_RECEIVED = 4;
    public static final int EnumPushAction_PUSH_ACTION_MOBILE_SHOW = 128;
    public static final int EnumPushAction_PUSH_ACTION_MOBILE_USER_CLICK = 16;
    public static final int EnumPushChannel = 0;
    public static final int EnumPushChannel_CHANNEL_FCM = 101;
    public static final int EnumPushChannel_CHANNEL_HONOR = 107;
    public static final int EnumPushChannel_CHANNEL_HUAWEI = 102;
    public static final int EnumPushChannel_CHANNEL_LOCAL = 99;
    public static final int EnumPushChannel_CHANNEL_MEIZU = 106;
    public static final int EnumPushChannel_CHANNEL_OPPO = 105;
    public static final int EnumPushChannel_CHANNEL_VIVO = 104;
    public static final int EnumPushChannel_CHANNEL_XG = 100;
    public static final int EnumPushChannel_CHANNEL_XIAOMI = 103;
    public static final String FAILED_CNT = "failed_cnt";
    public static final String HEARTBEAT_EVENT_ID = "SdkHeartbeat";
    public static final String IS_CUSTOMDATA_VERSION_EVENT_ID = "IsCustomDataVersion";
    public static final String LAST_REPORT_APPLIST = "last_reportAppList_time";
    public static final String LAST_REPORT_NOTIFICATION = "last_reportNotification_time";
    public static final String NETWORKTYOE = "np";
    public static final String NOTIFACTION_CLICK_OR_CLEAR_EVENT_ID = "Action";
    public static final String NOTIFICATION_STATUS_EVENT_ID = "notification_st";
    public static final String REGISTER_EVENT_ID = "SdkRegister";
    public static final String SDK_ACK_EVENT_ID = "SdkAck";
    public static final String SDK_OTHER_PULLUP_ID = "OtherPull";
    public static final String SERVICE_EVENT_ID = "SdkService";
    public static final String SHOW_EVENT_ID = "SHOW";
    public static final String SRV_ACK_EVENT_ID = "SrvAck";
    public static final String STRATTIME = "failed_cnt";
    public static final String SUCC_CNT = "suc_cnt";
    public static final String UNREGISTER_EVENT_ID = "SdkUnRegister";
    public static final String VERIFY_EVENT_ID = "Verify";
    public static AtomicBoolean _isInited = new AtomicBoolean(false);

    /* renamed from: a  reason: collision with root package name */
    private static Context f69864a = null;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f69865b = false;

    /* renamed from: c  reason: collision with root package name */
    private static volatile a f69866c;

    public static class a extends BroadcastReceiver {
        private a() {
        }

        public void onReceive(final Context context, Intent intent) {
            NetworkInfo networkInfo;
            PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
            if (intent != null && context != null && "android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction()) && (networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo")) != null) {
                TLogger.v("ServiceStat", "NetworkReceiver - Connection state changed to - " + networkInfo.toString());
                if (intent.getBooleanExtra("noConnectivity", false)) {
                    TLogger.v("ServiceStat", "stat network is disConnected");
                } else if (NetworkInfo.State.CONNECTED == networkInfo.getState()) {
                    TLogger.v("ServiceStat", "stat network connected and sendLocalMsg on 5s later");
                    CommonWorkingThread.getInstance().execute(new TTask() {
                        public void TRun() {
                            ServiceStat.sendLocalMsg(context);
                        }
                    }, 5000);
                } else if (NetworkInfo.State.DISCONNECTED == networkInfo.getState()) {
                    TLogger.v("ServiceStat", "Network is disconnected.");
                } else {
                    TLogger.v("ServiceStat", "other network state - " + networkInfo.getState() + ". Do nothing.");
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x00d5 A[Catch:{ all -> 0x00fb }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(android.content.Context r16, android.content.Intent r17, int r18) {
        /*
            r0 = r17
            r1 = r18
            java.lang.String r2 = "ServiceStat"
            if (r0 == 0) goto L_0x0102
            if (r1 >= 0) goto L_0x000c
            goto L_0x0102
        L_0x000c:
            init(r16)
            java.lang.String r3 = "msgId"
            r4 = 0
            long r6 = r0.getLongExtra(r3, r4)     // Catch:{ all -> 0x00fb }
            java.lang.String r3 = "type"
            r8 = 1
            long r8 = r0.getLongExtra(r3, r8)     // Catch:{ all -> 0x00fb }
            java.lang.String r3 = "busiMsgId"
            long r10 = r0.getLongExtra(r3, r4)     // Catch:{ all -> 0x00fb }
            java.lang.String r3 = "accId"
            long r12 = r0.getLongExtra(r3, r4)     // Catch:{ all -> 0x00fb }
            java.lang.String r3 = "groupId"
            java.lang.String r3 = r0.getStringExtra(r3)     // Catch:{ all -> 0x00fb }
            boolean r14 = com.tencent.android.tpush.common.j.b((java.lang.String) r3)     // Catch:{ all -> 0x00fb }
            if (r14 == 0) goto L_0x003d
            java.lang.String r3 = "group_id"
            java.lang.String r3 = r0.getStringExtra(r3)     // Catch:{ all -> 0x00fb }
        L_0x003d:
            int r14 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r14 != 0) goto L_0x0047
            android.content.Context r12 = f69864a     // Catch:{ all -> 0x00fb }
            long r12 = com.tencent.tpns.baseapi.XGApiConfig.getAccessId(r12)     // Catch:{ all -> 0x00fb }
        L_0x0047:
            com.tencent.android.tpush.stat.event.MQTTEvent r14 = new com.tencent.android.tpush.stat.event.MQTTEvent     // Catch:{ all -> 0x00fb }
            android.content.Context r15 = r16.getApplicationContext()     // Catch:{ all -> 0x00fb }
            r14.<init>(r15, r12)     // Catch:{ all -> 0x00fb }
            r14.msgId = r6     // Catch:{ all -> 0x00fb }
            r14.msgType = r8     // Catch:{ all -> 0x00fb }
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00fb }
            r8 = 1000(0x3e8, double:4.94E-321)
            long r6 = r6 / r8
            r14.timestamp = r6     // Catch:{ all -> 0x00fb }
            boolean r6 = com.tencent.android.tpush.common.j.b((java.lang.String) r3)     // Catch:{ all -> 0x00fb }
            if (r6 != 0) goto L_0x0065
            r14.nGroupId = r3     // Catch:{ all -> 0x00fb }
        L_0x0065:
            java.lang.String r3 = "pushChannel"
            r6 = -1
            int r3 = r0.getIntExtra(r3, r6)     // Catch:{ all -> 0x00fb }
            r14.pushChannel = r3     // Catch:{ all -> 0x00fb }
            r6 = 100
            if (r3 == r6) goto L_0x0088
            boolean r3 = com.tencent.android.tpush.f.a.a(r16)     // Catch:{ all -> 0x00fb }
            if (r3 == 0) goto L_0x0081
            int r3 = r14.pushChannel     // Catch:{ all -> 0x00fb }
            int r6 = com.tencent.android.tpush.f.a.a()     // Catch:{ all -> 0x00fb }
            if (r3 != r6) goto L_0x0081
            goto L_0x0088
        L_0x0081:
            java.lang.String r3 = "pushTime"
            long r6 = r0.getLongExtra(r3, r4)     // Catch:{ all -> 0x00fb }
            goto L_0x008e
        L_0x0088:
            java.lang.String r3 = "timestamps"
            long r6 = r0.getLongExtra(r3, r4)     // Catch:{ all -> 0x00fb }
        L_0x008e:
            r14.pushAction = r1     // Catch:{ all -> 0x00fb }
            r14.msgBusiId = r10     // Catch:{ all -> 0x00fb }
            long r6 = r6 / r8
            r14.pushtime = r6     // Catch:{ all -> 0x00fb }
            android.content.Context r1 = r16.getApplicationContext()     // Catch:{ all -> 0x00fb }
            java.lang.String r1 = com.tencent.tpns.baseapi.base.device.GuidInfoManager.getToken(r1)     // Catch:{ all -> 0x00fb }
            r14.token = r1     // Catch:{ all -> 0x00fb }
            java.lang.String r1 = "1.4.4.2"
            r14.sdkVersion = r1     // Catch:{ all -> 0x00fb }
            java.lang.String r1 = com.tencent.android.tpush.stat.b.b.c((android.content.Context) r16)     // Catch:{ all -> 0x00fb }
            r14.appVersion = r1     // Catch:{ all -> 0x00fb }
            java.lang.String r1 = "targetType"
            long r6 = r0.getLongExtra(r1, r4)     // Catch:{ all -> 0x00fb }
            r14.targetType = r6     // Catch:{ all -> 0x00fb }
            java.lang.String r1 = "source"
            long r3 = r0.getLongExtra(r1, r4)     // Catch:{ all -> 0x00fb }
            r14.source = r3     // Catch:{ all -> 0x00fb }
            java.lang.String r1 = "templateId"
            java.lang.String r1 = r0.getStringExtra(r1)     // Catch:{ all -> 0x00fb }
            r14.templateId = r1     // Catch:{ all -> 0x00fb }
            java.lang.String r1 = "traceId"
            java.lang.String r1 = r0.getStringExtra(r1)     // Catch:{ all -> 0x00fb }
            r14.traceId = r1     // Catch:{ all -> 0x00fb }
            java.lang.String r1 = "inapp_custom_event_id"
            java.lang.String r1 = r0.getStringExtra(r1)     // Catch:{ all -> 0x00fb }
            boolean r3 = com.tencent.android.tpush.common.j.b((java.lang.String) r1)     // Catch:{ all -> 0x00fb }
            if (r3 != 0) goto L_0x00f3
            r14.eventId = r1     // Catch:{ all -> 0x00fb }
            java.lang.String r1 = "inapp_button_event_id"
            r3 = 0
            int r0 = r0.getIntExtra(r1, r3)     // Catch:{ all -> 0x00fb }
            java.util.Properties r1 = new java.util.Properties     // Catch:{ all -> 0x00fb }
            r1.<init>()     // Catch:{ all -> 0x00fb }
            java.lang.String r3 = "BUTTON_ID"
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x00fb }
            r1.put(r3, r0)     // Catch:{ all -> 0x00fb }
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ all -> 0x00fb }
            r0.<init>(r1)     // Catch:{ all -> 0x00fb }
            r14.prop = r0     // Catch:{ all -> 0x00fb }
        L_0x00f3:
            android.content.Context r0 = r16.getApplicationContext()     // Catch:{ all -> 0x00fb }
            com.tencent.android.tpush.stat.StatServiceImpl.reportXGEvent(r0, r14)     // Catch:{ all -> 0x00fb }
            goto L_0x0101
        L_0x00fb:
            r0 = move-exception
            java.lang.String r1 = "reportSDKAck"
            com.tencent.android.tpush.logging.TLogger.e(r2, r1, r0)
        L_0x0101:
            return
        L_0x0102:
            java.lang.String r0 = "intent = null or evendId < 0 "
            com.tencent.android.tpush.logging.TLogger.e(r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.stat.ServiceStat.a(android.content.Context, android.content.Intent, int):void");
    }

    public static void appReportInMsgUserDisabled(Context context, Intent intent) {
        a(context, intent, 129);
    }

    public static void appReportNotificationCleared(Context context, Intent intent) {
        a(context, intent, 64);
    }

    public static void appReportNotificationClicked(Context context, Intent intent) {
        a(context, intent, 16);
    }

    public static void appReportNotificationShowed(Context context, Intent intent) {
        a(context, intent, 128);
    }

    public static void appReportPullupAck(Context context, Intent intent) {
    }

    public static void appReportRevokeMessageServiceReceived(Context context, Intent intent) {
        a(context, intent, 2048);
    }

    public static void appReportSDKReceived(Context context, Intent intent) {
        a(context, intent, 8);
    }

    public static void appReportServiceReceived(Context context, Intent intent) {
        a(context, intent, 4);
    }

    public static void commit() {
        StatServiceImpl.commitEvents(f69864a, -1);
    }

    public static void debug(boolean z11) {
        d.a(z11);
    }

    public static synchronized void init(Context context) {
        synchronized (ServiceStat.class) {
            if (!_isInited.get()) {
                AppInfos.init(context);
                d.c(true);
                d.a(StatReportStrategy.INSTANT);
                StatServiceImpl.setContext(context);
                StatServiceImpl.getHandler(context);
                f69864a = context.getApplicationContext();
                try {
                    if (f69866c == null) {
                        TLogger.d("ServiceStat", "register network receiver on ServiceStat.init");
                        f69866c = new a();
                        IntentFilter intentFilter = new IntentFilter();
                        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                        if (Build.VERSION.SDK_INT >= 33) {
                            f69864a.getApplicationContext().registerReceiver(f69866c, intentFilter, 4);
                        } else {
                            f69864a.getApplicationContext().registerReceiver(f69866c, intentFilter);
                        }
                    }
                } catch (Throwable th2) {
                    TLogger.e("ServiceStat", ZendeskBlipsProvider.ACTION_CORE_INIT, th2);
                }
                _isInited.set(true);
            }
        }
    }

    public static void reportAck(ArrayList<PushStatClientReport> arrayList) {
    }

    public static void reportCloudControl(Context context, long j11, int i11, String str, long j12) {
        try {
            init(context);
            b bVar = new b(context, j11, i11);
            if (j12 != 0) {
                bVar.f70007b = j12;
            }
            if (!TextUtils.isEmpty(str)) {
                bVar.f70006a = str;
            }
            StatServiceImpl.reportXGEvent(context.getApplicationContext(), bVar);
        } catch (Throwable th2) {
            TLogger.w("ServiceStat", "unexpected for reportCloudControl", th2);
        }
    }

    public static void reportCustomData(Context context, String str, Properties properties) {
        init(context);
        if (CloudManager.getInstance(context).disableRepoCusEv()) {
            TLogger.d("ServiceStat", "disable reportCustomData");
        } else {
            StatServiceImpl.trackCustomKVEvent(context, str, properties);
        }
    }

    public static void reportCustomData4FirstLaunch(Context context) {
        init(context);
        StatServiceImpl.trackCustomKVEvent(context, "FIRST_OPEN", (Properties) null);
    }

    public static void reportErrCode(Context context, int i11, String str, long j11, String str2) {
        try {
            if (CloudManager.getInstance(context).disableReptErrCode()) {
                TLogger.d("ServiceStat", "disable reportErrCode");
                return;
            }
            init(context);
            g gVar = new g(context, i11, str2);
            if (!TextUtils.isEmpty(str)) {
                gVar.f70040m = str;
            }
            if (j11 != 0) {
                gVar.f70041n = j11;
            }
            StatServiceImpl.reportXGEvent(context.getApplicationContext(), gVar);
        } catch (Throwable th2) {
            TLogger.w("ServiceStat", "unexpected for reportErrCode", th2);
        }
    }

    public static void reportIsCustomDataAcquisitionVersion(Context context) {
    }

    public static void reportLaunchEvent(Context context, int i11, int i12, long j11) {
        init(context);
        StatServiceImpl.trackLaunchEvent(context, i11, i12, j11);
    }

    public static void reportNotifactionClickedOrClear(ArrayList<PushStatClientReport> arrayList) {
    }

    public static void reportPullYYB() {
    }

    public static void reportSrvAck(ArrayList<j> arrayList) {
    }

    public static void reportTokenFailed(Context context) {
        try {
            if (!f69865b) {
                String j11 = d.j();
                int i11 = 0;
                int i12 = (!h.a(context).a() || !XGPushConfig.isUsedFcmPush(context)) ? 0 : ErrCode.INNER_ERROR_FCM_TOKEN_ERROR;
                if (d.a(context).n()) {
                    if (com.tencent.android.tpush.f.a.b(context)) {
                        i11 = ErrCode.INNER_ERROR_SYS_TOKEN_ERROR;
                    } else if ((ChannelUtils.isBrandXiaoMi() || ChannelUtils.isBrandBlackShark()) && !com.tencent.android.tpush.common.j.b(d.f68945a)) {
                        i11 = ErrCode.INNER_ERROR_XIAOMI_TOKEN_ERROR;
                    } else if ((ChannelUtils.isBrandHuaWei() || ChannelUtils.isBrandHonor()) && !com.tencent.android.tpush.common.j.b(com.tencent.android.tpush.common.j.m(context))) {
                        i11 = ErrCode.INNER_ERROR_HUAWEI_TOKEN_ERROR;
                    } else if (ChannelUtils.isBrandMeiZu() && !com.tencent.android.tpush.common.j.b(d.f68947c)) {
                        i11 = ErrCode.INNER_ERROR_MEIZU_TOKEN_ERROR;
                    } else if ((MTPushConstants.Manufacturer.OPPO.equals(j11) || MTPushConstants.Manufacturer.ONEPLUS.equals(j11) || MTPushConstants.Manufacturer.REALME.equals(j11)) && !com.tencent.android.tpush.common.j.b(d.f68949e)) {
                        i11 = ErrCode.INNER_ERROR_OPPO_TOKEN_ERROR;
                    } else if ("vivo".equals(j11) && !com.tencent.android.tpush.common.j.b(com.tencent.android.tpush.common.j.n(context))) {
                        i11 = ErrCode.INNER_ERROR_VIVO_TOKEN_ERROR;
                    }
                }
                if (i12 != 0 || i11 != 0) {
                    f69865b = true;
                    if (i12 != 0 && i11 != 0) {
                        reportErrCode(context, ErrCode.INNER_ERROR_FCM_AND_ChANNEL_TOKEN_ERROR, j11 + ":" + XGPushConfig.getOtherPushErrCode(context), 0, ErrCode.ERROR_INNER_TYPE);
                    } else if (i12 != 0) {
                        reportErrCode(context, i12, j11 + ":" + XGPushConfig.getOtherPushErrCode(context), 0, ErrCode.ERROR_INNER_TYPE);
                    } else if (i11 != 0) {
                        reportErrCode(context, i11, j11 + ":" + XGPushConfig.getOtherPushErrCode(context), 0, ErrCode.ERROR_INNER_TYPE);
                    }
                }
            }
        } catch (Throwable th2) {
            TLogger.w("ServiceStat", "unexpected for reportTokenFailed", th2);
        }
    }

    public static void reportXGLBS(Context context, String str, JSONObject jSONObject) {
    }

    public static void reportXGStat(Context context, long j11, String str, JSONObject jSONObject) {
    }

    public static void reportXGStat2(Context context, String str, JSONObject jSONObject) {
    }

    public static void sendLocalMsg(Context context) {
        if (context != null) {
            init(context);
            if (StatServiceImpl.storedList) {
                StatServiceImpl.storedList = !StatServiceImpl.sendLocalMsg(context, -1);
            }
        }
    }
}
