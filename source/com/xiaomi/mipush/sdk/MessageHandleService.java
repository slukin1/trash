package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.engagelab.privates.push.constants.MTPushConstants;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.mipush.sdk.PushMessageHandler;
import com.xiaomi.push.af;
import com.xiaomi.push.du;
import com.xiaomi.push.ee;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MessageHandleService extends BaseService {

    /* renamed from: a  reason: collision with root package name */
    private static ConcurrentLinkedQueue<a> f51280a = new ConcurrentLinkedQueue<>();

    /* renamed from: a  reason: collision with other field name */
    private static ExecutorService f2428a = new ThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue());

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private Intent f51283a;

        /* renamed from: a  reason: collision with other field name */
        private PushMessageReceiver f2430a;

        public a(Intent intent, PushMessageReceiver pushMessageReceiver) {
            this.f2430a = pushMessageReceiver;
            this.f51283a = intent;
        }

        /* renamed from: a  reason: collision with other method in class */
        public PushMessageReceiver m2328a() {
            return this.f2430a;
        }

        public Intent a() {
            return this.f51283a;
        }
    }

    public static void addJob(Context context, a aVar) {
        if (aVar != null) {
            f51280a.add(aVar);
            b(context);
            startService(context);
        }
    }

    private static void b(final Context context) {
        if (!f2428a.isShutdown()) {
            f2428a.execute(new Runnable() {
                public void run() {
                    MessageHandleService.c(context);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public static void c(Context context) {
        try {
            a(context, f51280a.poll());
        } catch (RuntimeException e11) {
            b.a((Throwable) e11);
        }
    }

    public static void startService(final Context context) {
        final Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, MessageHandleService.class));
        af.a(context).a((Runnable) new Runnable() {
            public void run() {
                try {
                    context.startService(intent);
                } catch (Exception e11) {
                    b.a(e11.getMessage());
                }
            }
        });
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onStart(Intent intent, int i11) {
        super.onStart(intent, i11);
    }

    public static void a(Context context, Intent intent) {
        if (intent != null) {
            b(context);
        }
    }

    public static void a(Context context, a aVar) {
        String[] stringArrayExtra;
        if (aVar != null) {
            try {
                PushMessageReceiver a11 = aVar.a();
                Intent a12 = aVar.a();
                int intExtra = a12.getIntExtra("message_type", 1);
                if (intExtra == 1) {
                    PushMessageHandler.a a13 = t.a(context).a(a12);
                    int intExtra2 = a12.getIntExtra("eventMessageType", -1);
                    if (a13 == null) {
                        b.d("MessageHandleService", "no message from raw for receiver");
                    } else if (a13 instanceof MiPushMessage) {
                        MiPushMessage miPushMessage = (MiPushMessage) a13;
                        if (!miPushMessage.isArrivedMessage()) {
                            a11.onReceiveMessage(context, miPushMessage);
                        }
                        if (miPushMessage.getPassThrough() == 1) {
                            du.a(context.getApplicationContext()).a(context.getPackageName(), a12, 2004, (String) null);
                            b.d("MessageHandleService", "begin execute onReceivePassThroughMessage from " + miPushMessage.getMessageId());
                            a11.onReceivePassThroughMessage(context, miPushMessage);
                        } else if (miPushMessage.isNotified()) {
                            if (intExtra2 == 1000) {
                                du.a(context.getApplicationContext()).a(context.getPackageName(), a12, 1007, (String) null);
                            } else {
                                du.a(context.getApplicationContext()).a(context.getPackageName(), a12, (int) MTPushConstants.PlatformNode.CODE_UPLOAD_TOKEN_SUCCESS, (String) null);
                            }
                            b.d("MessageHandleService", "begin execute onNotificationMessageClicked from　" + miPushMessage.getMessageId());
                            a11.onNotificationMessageClicked(context, miPushMessage);
                        } else {
                            b.d("MessageHandleService", "begin execute onNotificationMessageArrived from " + miPushMessage.getMessageId());
                            a11.onNotificationMessageArrived(context, miPushMessage);
                        }
                    } else if (a13 instanceof MiPushCommandMessage) {
                        MiPushCommandMessage miPushCommandMessage = (MiPushCommandMessage) a13;
                        b.d("MessageHandleService", "begin execute onCommandResult, command=" + miPushCommandMessage.getCommand() + ", resultCode=" + miPushCommandMessage.getResultCode() + ", reason=" + miPushCommandMessage.getReason());
                        a11.onCommandResult(context, miPushCommandMessage);
                        if (TextUtils.equals(miPushCommandMessage.getCommand(), ee.COMMAND_REGISTER.f2769a)) {
                            a11.onReceiveRegisterResult(context, miPushCommandMessage);
                            PushMessageHandler.a(context, miPushCommandMessage);
                            if (miPushCommandMessage.getResultCode() == 0) {
                                f.b(context);
                            }
                        }
                    } else {
                        b.d("MessageHandleService", "unknown raw message: " + a13);
                    }
                } else if (intExtra == 3) {
                    MiPushCommandMessage miPushCommandMessage2 = (MiPushCommandMessage) a12.getSerializableExtra(PushMessageHelper.KEY_COMMAND);
                    b.e("(Local) begin execute onCommandResult, command=" + miPushCommandMessage2.getCommand() + ", resultCode=" + miPushCommandMessage2.getResultCode() + ", reason=" + miPushCommandMessage2.getReason());
                    a11.onCommandResult(context, miPushCommandMessage2);
                    if (TextUtils.equals(miPushCommandMessage2.getCommand(), ee.COMMAND_REGISTER.f2769a)) {
                        a11.onReceiveRegisterResult(context, miPushCommandMessage2);
                        PushMessageHandler.a(context, miPushCommandMessage2);
                        if (miPushCommandMessage2.getResultCode() == 0) {
                            f.b(context);
                        }
                    }
                } else if (intExtra == 5) {
                    if (PushMessageHelper.ERROR_TYPE_NEED_PERMISSION.equals(a12.getStringExtra("error_type")) && (stringArrayExtra = a12.getStringArrayExtra("error_message")) != null) {
                        b.e("begin execute onRequirePermissions, lack of necessary permissions");
                        a11.onRequirePermissions(context, stringArrayExtra);
                    }
                }
            } catch (RuntimeException e11) {
                b.a("MessageHandleService", (Throwable) e11);
            }
        }
    }

    public boolean a() {
        ConcurrentLinkedQueue<a> concurrentLinkedQueue = f51280a;
        return concurrentLinkedQueue != null && concurrentLinkedQueue.size() > 0;
    }
}
