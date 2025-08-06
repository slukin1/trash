package com.huawei.hms.support.api.push.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import com.huawei.hms.push.c;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.push.i;
import com.huawei.hms.push.t;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.ResourceLoaderUtil;
import java.util.Objects;

public class HmsMsgService extends Service {

    public static class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private Context f38497a;

        public a(Context context) {
            this.f38497a = context;
        }

        public void handleMessage(Message message) {
            PackageManagerHelper.PackageStates packageStates;
            if (Build.VERSION.SDK_INT >= 21) {
                Bundle data = message.getData();
                if (Objects.equals(this.f38497a.getApplicationContext().getPackageManager().getNameForUid(message.sendingUid), HMSPackageManager.getInstance(this.f38497a).getHMSPackageName()) && data != null && HMSPackageManager.getInstance(this.f38497a).getHMSPackageStates() == (packageStates = PackageManagerHelper.PackageStates.ENABLED)) {
                    if (HMSPackageManager.getInstance(this.f38497a).getHMSPackageStates() != packageStates) {
                        HMSLog.i("HmsMsgService", "service not start by hms");
                    } else {
                        HMSLog.i("HmsMsgService", "chose push type");
                        if (Objects.equals(c.b(data, "push_action"), "com.huawei.push.msg.NOTIFY_MSG")) {
                            if (ResourceLoaderUtil.getmContext() == null) {
                                ResourceLoaderUtil.setmContext(this.f38497a.getApplicationContext());
                            }
                            HMSLog.i("HmsMsgService", "invokeSelfShow");
                            HmsMsgService.c(this.f38497a, data);
                        } else if (Objects.equals(c.b(data, "push_action"), "com.huawei.push.msg.PASSBY_MSG")) {
                            HMSLog.i("HmsMsgService", "sendBroadcastToHms");
                            HmsMsgService.d(this.f38497a, data);
                        }
                    }
                }
                super.handleMessage(message);
            }
        }
    }

    /* access modifiers changed from: private */
    public static void c(Context context, Bundle bundle) {
        if (!i.a(context)) {
            HMSLog.i("HmsMsgService", context.getPackageName() + " disable display notification.");
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.huawei.push.msg.NOTIFY_MSG");
        intent.putExtra("selfshow_info", c.a(bundle, "selfshow_info"));
        intent.putExtra("selfshow_token", c.a(bundle, "selfshow_token"));
        intent.setPackage(c.c(bundle, "push_package"));
        t.a(context, intent);
        HMSLog.i("HmsMsgService", "invokeSelfShow done");
    }

    /* access modifiers changed from: private */
    public static void d(Context context, Bundle bundle) {
        try {
            Intent intent = new Intent();
            intent.setAction("com.huawei.android.push.intent.RECEIVE");
            intent.putExtra("msg_data", c.a(bundle, "msg_data"));
            intent.putExtra(RemoteMessageConst.DEVICE_TOKEN, c.a(bundle, RemoteMessageConst.DEVICE_TOKEN));
            intent.putExtra("msgIdStr", c.c(bundle, "msgIdStr"));
            intent.setFlags(32);
            intent.setPackage(c.c(bundle, "push_package"));
            context.sendBroadcast(intent, context.getPackageName() + ".permission.PROCESS_PUSH_MSG");
            HMSLog.i("HmsMsgService", "send broadcast passby done");
        } catch (SecurityException unused) {
            HMSLog.i("HmsMsgService", "send broadcast SecurityException");
        } catch (Exception unused2) {
            HMSLog.i("HmsMsgService", "send broadcast Exception");
        }
    }

    public IBinder onBind(Intent intent) {
        HMSLog.i("HmsMsgService", "onBind");
        return new Messenger(new a(this)).getBinder();
    }

    public int onStartCommand(Intent intent, int i11, int i12) {
        HMSLog.i("HmsMsgService", "Enter onStartCommand.");
        return 2;
    }
}
