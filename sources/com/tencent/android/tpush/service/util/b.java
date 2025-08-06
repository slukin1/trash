package com.tencent.android.tpush.service.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.c.a;
import com.tencent.android.tpush.common.AppInfos;
import com.tencent.android.tpush.common.j;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.c;
import com.tencent.android.tpush.service.channel.security.TpnsSecurity;
import com.tencent.android.tpush.stat.ServiceStat;
import com.tencent.tpns.baseapi.base.PushPreferences;
import com.tencent.tpns.baseapi.base.logger.TBaseLogger;
import com.tencent.tpns.baseapi.base.util.CloudManager;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.baseapi.base.util.TTask;
import com.tencent.tpns.baseapi.base.util.Util;
import com.tencent.tpns.mqttchannel.api.OnMqttCallback;

public class b {
    public static boolean a(Context context, boolean z11) {
        Context applicationContext = context.getApplicationContext();
        com.tencent.android.tpush.service.b.b(applicationContext);
        ServiceStat.init(applicationContext);
        try {
            a.a().f68881b.a((OnMqttCallback) null);
        } catch (Throwable unused) {
        }
        Util.getCurProcessName(context);
        com.tencent.android.tpush.service.a.a().b(context);
        if (z11) {
            a(context);
            b(context);
        }
        if (j.a(context.getApplicationContext()) > 0) {
            g.e(context.getApplicationContext());
        }
        c(applicationContext);
        return true;
    }

    public static void b(Context context) {
        CommonWorkingThread.getInstance().execute(new TTask() {
            public void TRun() {
                try {
                    if (CloudManager.getInstance(AppInfos.getAppContext()).disableShareBugly()) {
                        TLogger.d("CommonServiceHelper", "initBuglyInfo | disable share bugly");
                        return;
                    }
                    SharedPreferences.Editor edit = AppInfos.getAppContext().getSharedPreferences("BuglySdkInfos", 0).edit();
                    edit.putString("42510ae4dd", "1.4.4.2");
                    edit.apply();
                } catch (Throwable th2) {
                    TLogger.e("CommonServiceHelper", "initBuglyInfo :", th2);
                }
            }
        });
    }

    private static void c(final Context context) {
        CommonWorkingThread.getInstance().execute(new TTask() {
            public void TRun() {
                try {
                    TpnsSecurity.getEncryptAPKSignature(context);
                } catch (Throwable unused) {
                }
                c.a(context);
            }
        });
    }

    public static void a(Context context) {
        CommonWorkingThread.getInstance().execute(new TTask() {
            public void TRun() {
                boolean z11 = false;
                if (PushPreferences.getInt(AppInfos.getAppContext(), "com.tencent.android.tpush.debug," + AppInfos.getAppContext().getPackageName(), 0) == 1) {
                    z11 = true;
                }
                XGPushConfig.enableDebug = true;
                TLogger.enableDebug(AppInfos.getAppContext(), z11);
                TBaseLogger.setDebugLevel(PushPreferences.getInt(AppInfos.getAppContext(), "com.tencent.android.tpush.log_level," + AppInfos.getAppContext().getPackageName(), -1));
            }
        });
    }
}
