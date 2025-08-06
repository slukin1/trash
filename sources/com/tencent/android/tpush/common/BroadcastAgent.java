package com.tencent.android.tpush.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.android.tpush.XGPushBaseReceiver;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.baseapi.base.util.Util;
import java.util.Iterator;
import java.util.List;

public class BroadcastAgent {

    /* renamed from: a  reason: collision with root package name */
    private static volatile boolean f68890a = false;

    /* renamed from: b  reason: collision with root package name */
    private static XGPushBaseReceiver f68891b;

    /* renamed from: c  reason: collision with root package name */
    private static int f68892c;

    private static void a(Context context) {
        try {
            if (!f68890a) {
                TLogger.i("BroadcastAgent", "try initBaseReceiverInstance");
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null) {
                    Intent intent = new Intent(Constants.ACTION_PUSH_MESSAGE);
                    intent.setPackage(context.getPackageName());
                    List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 131072);
                    if (queryBroadcastReceivers != null && queryBroadcastReceivers.size() > 0) {
                        Iterator<ResolveInfo> it2 = queryBroadcastReceivers.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            ResolveInfo next = it2.next();
                            String str = next.activityInfo.name;
                            if (!TextUtils.isEmpty(str)) {
                                Class<?> loadClass = context.getClassLoader().loadClass(str);
                                if (XGPushBaseReceiver.class.isAssignableFrom(loadClass)) {
                                    String str2 = next.activityInfo.processName;
                                    if (str2 != null) {
                                        try {
                                            if (str2.equals(Util.getCurProcessName(context))) {
                                                f68892c = Process.myPid();
                                                f68891b = (XGPushBaseReceiver) loadClass.newInstance();
                                                TLogger.i("BroadcastAgent", "initBaseReceiverInstance success " + str);
                                            }
                                        } catch (Throwable unused) {
                                        }
                                    }
                                }
                            }
                        }
                    }
                    f68890a = true;
                }
            }
        } catch (Throwable th2) {
            TLogger.w("BroadcastAgent", "getBaseReceiverInstance error: " + th2.toString());
        }
    }

    private static String b(Context context) {
        return context.getPackageName() + Constants.RECEIVER_PERMISSION_SUFFIX;
    }

    public static void registerReceiver(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, int i11) {
        try {
            if (Build.VERSION.SDK_INT >= 33) {
                context.getApplicationContext().registerReceiver(broadcastReceiver, intentFilter, b(context), (Handler) null, (i11 == 2 || i11 == 4 || i11 == 1) ? i11 : 4);
            } else {
                context.getApplicationContext().registerReceiver(broadcastReceiver, intentFilter, b(context), (Handler) null);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void sendBroadcast(Context context, Intent intent) {
        try {
            String action = intent.getAction();
            if (Constants.ACTION_PUSH_MESSAGE.equals(action) || Constants.ACTION_FEEDBACK.equals(action)) {
                a(context);
                if (f68891b != null && f68892c == Process.myPid()) {
                    TLogger.d("BroadcastAgent", "processBroadcastToBaseReceiver " + action);
                    f68891b.onReceive(context, intent);
                    return;
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
            return;
        }
        intent.setPackage(context.getPackageName());
        context.sendBroadcast(intent, b(context));
    }

    public static void unregisterReceiver(Context context, BroadcastReceiver broadcastReceiver) {
        try {
            context.getApplicationContext().unregisterReceiver(broadcastReceiver);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }
}
