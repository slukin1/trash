package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.os.IBinder;
import android.text.TextUtils;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.huobi.coupon.bean.CouponReturn;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.mipush.sdk.MessageHandleService;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.push.du;
import com.xiaomi.push.ee;
import com.xiaomi.push.gk;
import com.xiaomi.push.hq;
import com.xiaomi.push.s;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class PushMessageHandler extends BaseService {

    /* renamed from: a  reason: collision with root package name */
    private static List<MiPushClient.ICallbackResult> f51292a = new ArrayList();

    /* renamed from: a  reason: collision with other field name */
    private static ThreadPoolExecutor f2443a = new ThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* renamed from: b  reason: collision with root package name */
    private static List<MiPushClient.MiPushClientCallback> f51293b = new ArrayList();

    public interface a extends Serializable {
    }

    public static void a(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, PushMessageHandler.class));
        try {
            context.startService(intent);
        } catch (Exception e11) {
            b.a("PushMessageHandler", e11.getMessage());
        }
    }

    public static void b() {
        synchronized (f51292a) {
            f51292a.clear();
        }
    }

    private static void c(final Context context, final Intent intent) {
        if (intent == null || f2443a.isShutdown()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("-->scheduleJob() fail, case");
            sb2.append(intent == null ? "0" : "1");
            b.d("PushMessageHandler", sb2.toString());
            return;
        }
        f2443a.execute(new Runnable() {
            public void run() {
                PushMessageHandler.b(context, intent);
            }
        });
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onStart(Intent intent, int i11) {
        super.onStart(intent, i11);
        c(getApplicationContext(), intent);
    }

    public static void b(Context context, Intent intent) {
        boolean z11;
        try {
            intent.putExtra("pmh_handle_time", System.currentTimeMillis());
            z11 = intent.getBooleanExtra("is_clicked_activity_call", false);
        } catch (Throwable th2) {
            b.a("PushMessageHandler", "intent unparcel error:" + th2);
            z11 = false;
        }
        try {
            b.a("PushMessageHandler", "-->onHandleIntent(): action=", intent.getAction());
            if ("com.xiaomi.mipush.SEND_TINYDATA".equals(intent.getAction())) {
                gk gkVar = new gk();
                hq.a(gkVar, intent.getByteArrayExtra("mipush_payload"));
                b.b("PushMessageHandler", "PushMessageHandler.onHandleIntent " + gkVar.d());
                MiTinyDataClient.upload(context, gkVar);
            } else if (1 == PushMessageHelper.getPushMode(context)) {
                if (b()) {
                    b.c("PushMessageHandler", "receive a message before application calling initialize");
                    if (z11) {
                        b(context);
                        return;
                    }
                    return;
                }
                a a11 = t.a(context).a(intent);
                if (a11 != null) {
                    a(context, a11);
                }
            } else if (!"com.xiaomi.mipush.sdk.SYNC_LOG".equals(intent.getAction())) {
                Intent intent2 = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
                intent2.setPackage(context.getPackageName());
                intent2.putExtras(intent);
                List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent2, 32);
                ResolveInfo resolveInfo = null;
                if (queryBroadcastReceivers != null) {
                    Iterator<ResolveInfo> it2 = queryBroadcastReceivers.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            ResolveInfo next = it2.next();
                            ActivityInfo activityInfo = next.activityInfo;
                            if (activityInfo != null && activityInfo.packageName.equals(context.getPackageName()) && PushMessageReceiver.class.isAssignableFrom(s.a(context, next.activityInfo.name))) {
                                resolveInfo = next;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                if (resolveInfo != null) {
                    a(context, intent2, resolveInfo, z11);
                } else {
                    b.c("PushMessageHandler", "cannot find the receiver to handler this message, check your manifest");
                    du.a(context).a(context.getPackageName(), intent, BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_LINEAR_SWAP);
                }
            }
        } catch (Exception e11) {
            b.a("PushMessageHandler", (Throwable) e11);
            du.a(context).a(context.getPackageName(), intent, "9");
        } catch (Throwable th3) {
            try {
                b.a("PushMessageHandler", th3);
                du.a(context).a(context.getPackageName(), intent, CouponReturn.TYPE_EXPERIENCE);
                if (!z11) {
                    return;
                }
            } finally {
                if (z11) {
                    b(context);
                }
            }
        }
        if (!z11) {
        }
    }

    public static void a(Context context, Intent intent) {
        b.b("PushMessageHandler", "addjob PushMessageHandler " + intent);
        if (intent != null) {
            c(context, intent);
            a(context);
        }
    }

    public static void a(MiPushClient.MiPushClientCallback miPushClientCallback) {
        synchronized (f51293b) {
            if (!f51293b.contains(miPushClientCallback)) {
                f51293b.add(miPushClientCallback);
            }
        }
    }

    public static void a(MiPushClient.ICallbackResult iCallbackResult) {
        synchronized (f51292a) {
            if (!f51292a.contains(iCallbackResult)) {
                f51292a.add(iCallbackResult);
            }
        }
    }

    public static void a() {
        synchronized (f51293b) {
            f51293b.clear();
        }
    }

    private static void a(Context context, Intent intent, ResolveInfo resolveInfo, boolean z11) {
        try {
            MessageHandleService.a aVar = new MessageHandleService.a(intent, (PushMessageReceiver) s.a(context, resolveInfo.activityInfo.name).newInstance());
            if (z11) {
                MessageHandleService.a(context.getApplicationContext(), aVar);
            } else {
                MessageHandleService.addJob(context.getApplicationContext(), aVar);
            }
            MessageHandleService.a(context, new Intent(context.getApplicationContext(), MessageHandleService.class));
        } catch (Throwable th2) {
            b.a(th2);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2333a() {
        ThreadPoolExecutor threadPoolExecutor = f2443a;
        return (threadPoolExecutor == null || threadPoolExecutor.getQueue() == null || f2443a.getQueue().size() <= 0) ? false : true;
    }

    public static void a(Context context, a aVar) {
        if (aVar instanceof MiPushMessage) {
            a(context, (MiPushMessage) aVar);
        } else if (aVar instanceof MiPushCommandMessage) {
            MiPushCommandMessage miPushCommandMessage = (MiPushCommandMessage) aVar;
            String command = miPushCommandMessage.getCommand();
            String str = null;
            if (ee.COMMAND_REGISTER.f2769a.equals(command)) {
                List<String> commandArguments = miPushCommandMessage.getCommandArguments();
                if (commandArguments != null && !commandArguments.isEmpty()) {
                    str = commandArguments.get(0);
                }
                a(miPushCommandMessage.getResultCode(), miPushCommandMessage.getReason(), str);
            } else if (ee.COMMAND_SET_ALIAS.f2769a.equals(command) || ee.COMMAND_UNSET_ALIAS.f2769a.equals(command) || ee.COMMAND_SET_ACCEPT_TIME.f2769a.equals(command)) {
                a(context, miPushCommandMessage.getCategory(), command, miPushCommandMessage.getResultCode(), miPushCommandMessage.getReason(), miPushCommandMessage.getCommandArguments());
            } else if (ee.COMMAND_SUBSCRIBE_TOPIC.f2769a.equals(command)) {
                List<String> commandArguments2 = miPushCommandMessage.getCommandArguments();
                if (commandArguments2 != null && !commandArguments2.isEmpty()) {
                    str = commandArguments2.get(0);
                }
                Context context2 = context;
                a(context2, miPushCommandMessage.getCategory(), miPushCommandMessage.getResultCode(), miPushCommandMessage.getReason(), str);
            } else if (ee.COMMAND_UNSUBSCRIBE_TOPIC.f2769a.equals(command)) {
                List<String> commandArguments3 = miPushCommandMessage.getCommandArguments();
                if (commandArguments3 != null && !commandArguments3.isEmpty()) {
                    str = commandArguments3.get(0);
                }
                Context context3 = context;
                b(context3, miPushCommandMessage.getCategory(), miPushCommandMessage.getResultCode(), miPushCommandMessage.getReason(), str);
            }
        }
    }

    private static void b(Context context) {
        try {
            Intent intent = new Intent();
            intent.setPackage(context.getPackageName());
            intent.setAction("action_clicked_activity_finish");
            context.sendBroadcast(intent, c.a(context));
        } catch (Exception e11) {
            b.a("PushMessageHandler", "callback sync error" + e11);
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public static boolean m2332b() {
        return f51293b.isEmpty();
    }

    public static void b(Context context, String str, long j11, String str2, String str3) {
        synchronized (f51293b) {
            for (MiPushClient.MiPushClientCallback next : f51293b) {
                if (a(str, next.getCategory())) {
                    next.onUnsubscribeResult(j11, str2, str3);
                }
            }
        }
    }

    public static void a(Context context, MiPushMessage miPushMessage) {
        synchronized (f51293b) {
            for (MiPushClient.MiPushClientCallback next : f51293b) {
                if (a(miPushMessage.getCategory(), next.getCategory())) {
                    next.onReceiveMessage(miPushMessage.getContent(), miPushMessage.getAlias(), miPushMessage.getTopic(), miPushMessage.isNotified());
                    next.onReceiveMessage(miPushMessage);
                }
            }
        }
    }

    public static void a(long j11, String str, String str2) {
        synchronized (f51293b) {
            for (MiPushClient.MiPushClientCallback onInitializeResult : f51293b) {
                onInitializeResult.onInitializeResult(j11, str, str2);
            }
        }
    }

    public static void a(Context context, String str, long j11, String str2, String str3) {
        synchronized (f51293b) {
            for (MiPushClient.MiPushClientCallback next : f51293b) {
                if (a(str, next.getCategory())) {
                    next.onSubscribeResult(j11, str2, str3);
                }
            }
        }
    }

    public static void a(Context context, String str, String str2, long j11, String str3, List<String> list) {
        synchronized (f51293b) {
            for (MiPushClient.MiPushClientCallback next : f51293b) {
                if (a(str, next.getCategory())) {
                    next.onCommandResult(str2, j11, str3, list);
                }
            }
        }
    }

    public static boolean a(String str, String str2) {
        return (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || TextUtils.equals(str, str2);
    }

    public static void a(Context context, MiPushCommandMessage miPushCommandMessage) {
        synchronized (f51292a) {
            for (MiPushClient.ICallbackResult next : f51292a) {
                if (next instanceof MiPushClient.UPSRegisterCallBack) {
                    MiPushClient.TokenResult tokenResult = new MiPushClient.TokenResult();
                    if (!(miPushCommandMessage == null || miPushCommandMessage.getCommandArguments() == null || miPushCommandMessage.getCommandArguments().size() <= 0)) {
                        tokenResult.setResultCode(miPushCommandMessage.getResultCode());
                        tokenResult.setToken(miPushCommandMessage.getCommandArguments().get(0));
                    }
                    next.onResult(tokenResult);
                }
            }
        }
    }
}
