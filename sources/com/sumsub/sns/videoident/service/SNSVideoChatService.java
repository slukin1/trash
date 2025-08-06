package com.sumsub.sns.videoident.service;

import android.annotation.SuppressLint;
import android.app.Application;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.IBinder;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleService;
import androidx.lifecycle.v;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import com.sumsub.sns.R;
import com.sumsub.sns.internal.core.common.SNSSession;
import com.sumsub.sns.internal.core.common.n0;
import com.sumsub.sns.internal.core.data.source.dynamic.b;
import com.sumsub.sns.internal.log.LoggerType;
import com.sumsub.sns.internal.log.a;
import com.sumsub.sns.internal.videoident.videoident.SNSVideoIdent;
import com.sumsub.sns.internal.videoident.videoident.chat.SNSVideoChatController;
import com.sumsub.sns.internal.videoident.videoident.chat.SNSVideoChatState;
import com.sumsub.sns.presentation.screen.SNSAppActivity;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.jvm.internal.r;
import p0.l;
import p0.m;

@Metadata(d1 = {"\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007*\u00016\u0018\u0000 ?2\u00020\u0001:\u0001?B\u0007¢\u0006\u0004\b=\u0010>J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0003J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0017J\u0012\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J\u0012\u0010\u0016\u001a\u00020\u00152\b\u0010\u0012\u001a\u0004\u0018\u00010\u000fH\u0016J\"\u0010\u001a\u001a\u00020\u00172\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0016J\b\u0010\u001b\u001a\u00020\u0004H\u0016R\u0016\u0010\u001d\u001a\u00020\u001c8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010\"\u001a\u00020!8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010%\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0017\u0010(\u001a\u00020'8\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R$\u0010-\u001a\u00020\u00152\u0006\u0010,\u001a\u00020\u00158\u0006@BX\u000e¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b-\u0010/R\u0018\u00101\u001a\u0004\u0018\u0001008\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u00104\u001a\u0004\u0018\u0001038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0014\u00107\u001a\u0002068\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010<\u001a\u0004\u0018\u0001098BX\u0004¢\u0006\u0006\u001a\u0004\b:\u0010;¨\u0006@"}, d2 = {"Lcom/sumsub/sns/videoident/service/SNSVideoChatService;", "Landroidx/lifecycle/LifecycleService;", "Lcom/sumsub/sns/internal/videoident/videoident/chat/SNSVideoChatState;", "state", "", "handleChatState", "registerDismissReceiver", "stopCallAndService", "doStopForeground", "unRegisterDismissReceiver", "", "message", "Landroid/app/Notification;", "createNotification", "onCreate", "Landroid/content/Intent;", "rootIntent", "onTaskRemoved", "intent", "Landroid/os/IBinder;", "onBind", "", "onUnbind", "", "flags", "startId", "onStartCommand", "onDestroy", "Lcom/sumsub/sns/videoident/service/NotificationState;", "notificationState", "Lcom/sumsub/sns/videoident/service/NotificationState;", "notificationChannelName", "Ljava/lang/String;", "Lcom/sumsub/sns/internal/core/data/source/dynamic/b$c;", "strings", "Lcom/sumsub/sns/internal/core/data/source/dynamic/b$c;", "Lcom/sumsub/sns/internal/core/common/SNSSession;", "session", "Lcom/sumsub/sns/internal/core/common/SNSSession;", "Lcom/sumsub/sns/internal/videoident/videoident/chat/SNSVideoChatController;", "videoChatController", "Lcom/sumsub/sns/internal/videoident/videoident/chat/SNSVideoChatController;", "getVideoChatController", "()Lcom/sumsub/sns/internal/videoident/videoident/chat/SNSVideoChatController;", "<set-?>", "isInForeground", "Z", "()Z", "Lcom/sumsub/sns/videoident/service/SNSServiceBinder;", "binder", "Lcom/sumsub/sns/videoident/service/SNSServiceBinder;", "Landroid/content/BroadcastReceiver;", "dismissReceiver", "Landroid/content/BroadcastReceiver;", "com/sumsub/sns/videoident/service/SNSVideoChatService$activityLifecycleCallbacks$1", "activityLifecycleCallbacks", "Lcom/sumsub/sns/videoident/service/SNSVideoChatService$activityLifecycleCallbacks$1;", "Lcom/sumsub/sns/internal/core/a;", "getServiceLocator", "()Lcom/sumsub/sns/internal/core/a;", "serviceLocator", "<init>", "()V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public final class SNSVideoChatService extends LifecycleService {
    public static final String ACTION_INTERNAL_CLOSE = "com.sumsub.sns.videoident.ACTION_INTERNAL_CLOSE";
    public static final String ACTION_START_FOREGROUND = "com.sumsub.sns.videoident.ACTION_START_FOREGROUND";
    public static final Companion Companion = new Companion((r) null);
    public static final String NOTIFICATION_CHANNEL_ID = "video_identification_service";
    public static final int NOTIFICATION_ID = 11;
    public static final String SNS_EXTRA_SESSION = "sns_extra_session";
    private final SNSVideoChatService$activityLifecycleCallbacks$1 activityLifecycleCallbacks = new SNSVideoChatService$activityLifecycleCallbacks$1(this);
    private SNSServiceBinder binder;
    private BroadcastReceiver dismissReceiver;
    private boolean isInForeground;
    private String notificationChannelName = "";
    private NotificationState notificationState = NotificationState.NONE;
    private SNSSession session;
    /* access modifiers changed from: private */
    public b.c strings = new b.c((Map) null, (List) null, 3, (r) null);
    private final SNSVideoChatController videoChatController = new SNSVideoChatController();

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/sumsub/sns/videoident/service/SNSVideoChatService$Companion;", "", "()V", "ACTION_INTERNAL_CLOSE", "", "ACTION_START_FOREGROUND", "NOTIFICATION_CHANNEL_ID", "NOTIFICATION_ID", "", "SNS_EXTRA_SESSION", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(r rVar) {
            this();
        }

        private Companion() {
        }
    }

    private final Notification createNotification(String str) {
        m d11 = m.d(this);
        if (d11.f(NOTIFICATION_CHANNEL_ID) == null) {
            d11.c(new l.c(NOTIFICATION_CHANNEL_ID, 4).b(this.notificationChannelName).a());
        }
        Class<SNSAppActivity> cls = SNSAppActivity.class;
        try {
            SNSAppActivity.a aVar = SNSAppActivity.f39563h;
        } catch (Exception e11) {
            a.f34862a.a(LoggerType.KIBANA).e(SNSVideoIdent.logTag, "activity class missing", e11);
            cls = null;
        }
        Notification.Builder onlyAlertOnce = new Notification.Builder(this).setOngoing(true).setContentTitle(str).setOnlyAlertOnce(false);
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 31) {
            onlyAlertOnce.setForegroundServiceBehavior(1);
        }
        Notification.Builder smallIcon = onlyAlertOnce.setSmallIcon(R.drawable.sns_ic_videoident_intro_face);
        if (cls != null) {
            Intent intent = new Intent(this, cls);
            intent.putExtra(RemoteMessageConst.NOTIFICATION, true);
            intent.setFlags(603979776);
            int i12 = i11 >= 23 ? 201326592 : 134217728;
            PushAutoTrackHelper.hookIntentGetActivity(this, 1, intent, i12);
            PendingIntent activity = PendingIntent.getActivity(this, 1, intent, i12);
            PushAutoTrackHelper.hookPendingIntentGetActivity(activity, this, 1, intent, i12);
            smallIcon.setContentIntent(activity);
        }
        smallIcon.setCategory("service");
        NotificationCompat.e eVar = new NotificationCompat.e((Context) this, smallIcon.build());
        eVar.v(NOTIFICATION_CHANNEL_ID);
        if (i11 >= 24) {
            eVar.Q(2);
        }
        eVar.W(false);
        return eVar.g();
    }

    private final void doStopForeground() {
        com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "doStopForeground", (Throwable) null, 4, (Object) null);
        p0.r.a(this, 1);
        this.isInForeground = false;
    }

    /* access modifiers changed from: private */
    public final com.sumsub.sns.internal.core.a getServiceLocator() {
        SNSSession sNSSession = this.session;
        if (sNSSession != null) {
            return com.sumsub.sns.internal.core.a.f31823z.a(getApplicationContext(), sNSSession);
        }
        return null;
    }

    /* access modifiers changed from: private */
    @SuppressLint({"MissingPermission"})
    public final void handleChatState(SNSVideoChatState sNSVideoChatState) {
        NotificationState notificationState2;
        boolean z11 = true;
        if (getServiceLocator() != null) {
            if (!(sNSVideoChatState instanceof SNSVideoChatState.a)) {
                z11 = sNSVideoChatState instanceof SNSVideoChatState.e;
            }
            if (z11) {
                notificationState2 = NotificationState.WAITING;
            } else if (sNSVideoChatState instanceof SNSVideoChatState.d) {
                notificationState2 = NotificationState.CALL;
            } else if (!(sNSVideoChatState instanceof SNSVideoChatState.c) || !this.isInForeground) {
                notificationState2 = null;
            } else {
                doStopForeground();
                notificationState2 = NotificationState.NONE;
            }
            if (notificationState2 != null && this.notificationState != notificationState2) {
                com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "updating notification state=" + notificationState2 + ", isInForeground=" + this.isInForeground, (Throwable) null, 4, (Object) null);
                if (this.isInForeground && notificationState2 != NotificationState.NONE) {
                    this.notificationState = notificationState2;
                    m.d(this).g(11, createNotification(SNSVideoChatServiceKt.getMessage(notificationState2, this.strings)));
                }
            }
        } else if (this.isInForeground) {
            com.sumsub.log.logger.a.b(a.f34862a.a(LoggerType.KIBANA), SNSVideoIdent.logTag, "can't get service locator instance", (Throwable) null, 4, (Object) null);
        }
    }

    private final void registerDismissReceiver() {
        if (this.dismissReceiver == null) {
            this.dismissReceiver = new SNSVideoChatService$registerDismissReceiver$1(this);
            Context applicationContext = getApplicationContext();
            BroadcastReceiver broadcastReceiver = this.dismissReceiver;
            IntentFilter intentFilter = new IntentFilter(n0.f.f32173d);
            intentFilter.addAction(ACTION_INTERNAL_CLOSE);
            Unit unit = Unit.f56620a;
            ContextCompat.registerReceiver(applicationContext, broadcastReceiver, intentFilter, 4);
        }
    }

    /* access modifiers changed from: private */
    public final void stopCallAndService() {
        com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "stopCallAndService", (Throwable) null, 4, (Object) null);
        this.videoChatController.a();
        doStopForeground();
        stopSelf();
    }

    private final void unRegisterDismissReceiver() {
        BroadcastReceiver broadcastReceiver = this.dismissReceiver;
        if (broadcastReceiver != null) {
            getApplicationContext().unregisterReceiver(broadcastReceiver);
            this.dismissReceiver = null;
        }
    }

    public final SNSVideoChatController getVideoChatController() {
        return this.videoChatController;
    }

    public final boolean isInForeground() {
        return this.isInForeground;
    }

    public IBinder onBind(Intent intent) {
        super.onBind(intent);
        com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "service bind, isInForeground=" + this.isInForeground, (Throwable) null, 4, (Object) null);
        SNSServiceBinder sNSServiceBinder = new SNSServiceBinder(this);
        this.binder = sNSServiceBinder;
        return sNSServiceBinder;
    }

    @SuppressLint({"NewApi"})
    public void onCreate() {
        super.onCreate();
        com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "service created", (Throwable) null, 4, (Object) null);
        registerDismissReceiver();
        Context applicationContext = getApplicationContext();
        if (applicationContext instanceof Application) {
            ((Application) applicationContext).registerActivityLifecycleCallbacks(this.activityLifecycleCallbacks);
        }
        v.a(this).b(new SNSVideoChatService$onCreate$1(this, (c<? super SNSVideoChatService$onCreate$1>) null));
    }

    public void onDestroy() {
        com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "service destroyed, isInForeground=" + this.isInForeground, (Throwable) null, 4, (Object) null);
        unRegisterDismissReceiver();
        Context applicationContext = getApplicationContext();
        if (applicationContext instanceof Application) {
            ((Application) applicationContext).unregisterActivityLifecycleCallbacks(this.activityLifecycleCallbacks);
        }
        this.videoChatController.b();
        this.isInForeground = false;
        super.onDestroy();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: com.sumsub.sns.internal.core.common.SNSSession} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int onStartCommand(android.content.Intent r3, int r4, int r5) {
        /*
            r2 = this;
            super.onStartCommand(r3, r4, r5)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "service onStartCommand: "
            r4.append(r5)
            r4.append(r3)
            java.lang.String r4 = r4.toString()
            java.lang.String r5 = "SNSVideoIdent"
            r0 = 0
            r1 = 4
            com.sumsub.sns.internal.videoident.videoident.a.a(r5, r4, r0, r1, r0)
            if (r3 == 0) goto L_0x0022
            java.lang.String r4 = r3.getAction()
            goto L_0x0023
        L_0x0022:
            r4 = r0
        L_0x0023:
            java.lang.String r5 = "com.sumsub.sns.videoident.ACTION_START_FOREGROUND"
            boolean r4 = kotlin.jvm.internal.x.b(r5, r4)
            if (r4 == 0) goto L_0x006e
            android.os.Bundle r3 = r3.getExtras()
            if (r3 == 0) goto L_0x003c
            java.lang.Class<com.sumsub.sns.internal.core.common.SNSSession> r4 = com.sumsub.sns.internal.core.common.SNSSession.class
            java.lang.String r5 = "sns_extra_session"
            java.lang.Object r3 = androidx.core.os.d.b(r3, r5, r4)
            r0 = r3
            com.sumsub.sns.internal.core.common.SNSSession r0 = (com.sumsub.sns.internal.core.common.SNSSession) r0
        L_0x003c:
            r2.session = r0
            com.sumsub.sns.internal.core.data.source.dynamic.b$c r3 = r2.strings
            java.lang.String r4 = "sns_videoident_state_followIntructions_title"
            java.lang.String r3 = r3.a((java.lang.String) r4)
            if (r3 != 0) goto L_0x004a
            java.lang.String r3 = "Video Identification"
        L_0x004a:
            r2.notificationChannelName = r3
            com.sumsub.sns.videoident.service.NotificationState r3 = com.sumsub.sns.videoident.service.NotificationState.WAITING
            com.sumsub.sns.internal.core.data.source.dynamic.b$c r4 = r2.strings
            java.lang.String r4 = com.sumsub.sns.videoident.service.SNSVideoChatServiceKt.getMessage(r3, r4)
            android.app.Notification r4 = r2.createNotification(r4)
            int r5 = android.os.Build.VERSION.SDK_INT
            r0 = 30
            r1 = 11
            if (r5 < r0) goto L_0x0066
            r5 = 128(0x80, float:1.794E-43)
            r2.startForeground(r1, r4, r5)
            goto L_0x0069
        L_0x0066:
            r2.startForeground(r1, r4)
        L_0x0069:
            r2.notificationState = r3
            r3 = 1
            r2.isInForeground = r3
        L_0x006e:
            r3 = 2
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.videoident.service.SNSVideoChatService.onStartCommand(android.content.Intent, int, int):int");
    }

    public void onTaskRemoved(Intent intent) {
        com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "service task removed: " + intent, (Throwable) null, 4, (Object) null);
        stopCallAndService();
    }

    public boolean onUnbind(Intent intent) {
        com.sumsub.sns.internal.videoident.videoident.a.a(SNSVideoIdent.logTag, "service unBind, isInForeground=" + this.isInForeground, (Throwable) null, 4, (Object) null);
        this.binder = null;
        return super.onUnbind(intent);
    }
}
