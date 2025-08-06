package com.tencent.android.tpush.common;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.engagelab.privates.push.constants.MTPushConstants;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.baseapi.base.util.ChannelUtils;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.baseapi.base.util.TTask;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.util.concurrent.locks.ReentrantLock;

public class c {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static int f68897a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static int f68898b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static Handler f68899c;

    /* renamed from: d  reason: collision with root package name */
    private static ReentrantLock f68900d = new ReentrantLock();

    public static class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private Context f68909a;

        public a(Context context) {
            this.f68909a = context;
        }

        public void handleMessage(Message message) {
            Context context = this.f68909a;
            if (context == null) {
                super.handleMessage(message);
                return;
            }
            int i11 = message.what;
            if (i11 == 1) {
                if (c.f68898b > 0) {
                    c.a(1);
                }
                if (c.f68898b == 0) {
                    c.h(this.f68909a, c.f68897a);
                    int unused = c.f68897a = 0;
                    c.f68899c.removeCallbacks((Runnable) null);
                }
            } else if (i11 != 2) {
                super.handleMessage(message);
            } else {
                c.i(context, message.arg1);
            }
        }
    }

    /* access modifiers changed from: private */
    public static void d(Context context, String str, int i11) {
        Bundle bundle = new Bundle();
        bundle.putString("package", context.getPackageName());
        bundle.putString(Constants.CLASS, j.q(context));
        bundle.putInt("badgenumber", i11);
        context.getContentResolver().call(Uri.parse(str), "change_badge", (String) null, bundle);
    }

    public static void e(final Context context, final int i11) {
        String b11 = j.b();
        if (!TextUtils.isEmpty(b11) && "vivo".equals(b11)) {
            CommonWorkingThread.getInstance().execute(new TTask() {
                public void TRun() {
                    try {
                        TLogger.i("BadgeUtils", "set vivo badge " + i11);
                        Intent intent = new Intent();
                        intent.setAction("launcher.action.CHANGE_APPLICATION_NOTIFICATION_NUM");
                        intent.putExtra(Constants.FLAG_PACKAGE_NAME, context.getPackageName());
                        intent.putExtra("className", j.q(context));
                        intent.putExtra("notificationNum", i11);
                        intent.addFlags(16777216);
                        context.sendBroadcast(intent);
                    } catch (Throwable th2) {
                        TLogger.w("BadgeUtils", "set vivo badge error: " + th2.toString());
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public static void h(final Context context, final int i11) {
        if (ChannelUtils.isBrandHuaWei() || ChannelUtils.isBrandHonor() || ChannelUtils.isEmuiOrOhosVersion()) {
            CommonWorkingThread.getInstance().execute(new TTask() {
                public void TRun() {
                    String str;
                    boolean isBrandHonor = ChannelUtils.isBrandHonor();
                    if (isBrandHonor) {
                        TLogger.i("BadgeUtils", "change honor badge " + i11);
                        str = "content://com.hihonor.android.launcher.settings/badge/";
                    } else if (ChannelUtils.isBrandHuaWei() || ChannelUtils.isEmuiOrOhosVersion()) {
                        TLogger.i("BadgeUtils", "change huawei badge " + i11);
                        str = "content://com.huawei.android.launcher.settings/badge/";
                    } else {
                        str = "";
                    }
                    try {
                        c.c(context, str, i11);
                    } catch (Throwable unused) {
                        TLogger.w("BadgeUtils", "change honor badge with huawei uri error: " + th.toString());
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public static void i(final Context context, final int i11) {
        if (ChannelUtils.isBrandHuaWei() || ChannelUtils.isBrandHonor() || ChannelUtils.isEmuiOrOhosVersion()) {
            CommonWorkingThread.getInstance().execute(new TTask() {
                public void TRun() {
                    String str;
                    boolean isBrandHonor = ChannelUtils.isBrandHonor();
                    if (isBrandHonor) {
                        TLogger.i("BadgeUtils", "set honor badge " + i11);
                        str = "content://com.hihonor.android.launcher.settings/badge/";
                    } else if (ChannelUtils.isBrandHuaWei() || ChannelUtils.isEmuiOrOhosVersion()) {
                        TLogger.i("BadgeUtils", "set huawei badge " + i11);
                        str = "content://com.huawei.android.launcher.settings/badge/";
                    } else {
                        str = "";
                    }
                    try {
                        c.d(context, str, i11);
                    } catch (Throwable unused) {
                        TLogger.w("BadgeUtils", "set honor badge with huawei uri error: " + th.toString());
                    }
                }
            });
        }
    }

    public static /* synthetic */ int a(int i11) {
        int i12 = f68898b - i11;
        f68898b = i12;
        return i12;
    }

    /* access modifiers changed from: private */
    public static void c(Context context, String str, int i11) {
        Bundle bundle = new Bundle();
        bundle.putString("package", context.getPackageName());
        bundle.putString(Constants.CLASS, j.q(context));
        Bundle call = context.getContentResolver().call(Uri.parse(str), "getbadgeNumber", (String) null, bundle);
        int i12 = 0;
        int i13 = (call != null ? call.getInt("badgenumber", 0) : 0) + i11;
        if (i13 >= 0) {
            i12 = i13;
        }
        bundle.putInt("badgenumber", i12);
        context.getContentResolver().call(Uri.parse(str), "change_badge", (String) null, bundle);
    }

    public static void a(Context context) {
        b(context, 0);
    }

    public static void b(Context context, int i11) {
        if (ChannelUtils.isBrandHuaWei() || ChannelUtils.isBrandHonor() || ChannelUtils.isEmuiOrOhosVersion()) {
            try {
                if (f68899c == null) {
                    f68899c = new a(context.getApplicationContext());
                }
                Message message = new Message();
                message.what = 2;
                message.arg1 = i11;
                f68899c.sendMessage(message);
            } catch (Throwable th2) {
                TLogger.w("BadgeUtils", "set huawei badge error: " + th2.toString());
            }
        }
    }

    public static void a(Context context, int i11) {
        StringBuilder sb2;
        if (ChannelUtils.isBrandHuaWei() || ChannelUtils.isBrandHonor() || ChannelUtils.isEmuiOrOhosVersion()) {
            try {
                f68900d.lock();
                if (f68899c == null) {
                    f68899c = new a(context.getApplicationContext());
                }
                f68898b++;
                f68897a += i11;
                Message message = new Message();
                message.what = 1;
                f68899c.sendMessageDelayed(message, 200);
                try {
                    f68900d.unlock();
                    return;
                } catch (Throwable th2) {
                    th = th2;
                    sb2 = new StringBuilder();
                }
            } catch (Throwable th3) {
                th = th3;
                sb2 = new StringBuilder();
            }
        } else {
            return;
        }
        sb2.append("change huawei badge unlock error: ");
        sb2.append(th.toString());
        TLogger.e("BadgeUtils", sb2.toString());
    }

    public static void d(final Context context, final int i11) {
        String b11 = j.b();
        if (!TextUtils.isEmpty(b11) && MTPushConstants.Manufacturer.OPPO.equals(b11)) {
            CommonWorkingThread.getInstance().execute(new TTask() {
                public void TRun() {
                    try {
                        TLogger.i("BadgeUtils", "set oppo badge " + i11);
                        Bundle bundle = new Bundle();
                        bundle.putInt("app_badge_count", i11);
                        context.getContentResolver().call(Uri.parse("content://com.android.badge/badge"), "setAppBadgeCount", (String) null, bundle);
                    } catch (Throwable th2) {
                        TLogger.w("BadgeUtils", "set oppo badge error" + th2.toString());
                    }
                }
            });
        }
    }

    public static void b(Context context) {
        b(context, 0);
        d(context, 0);
        e(context, 0);
    }

    public static void c(Context context, int i11) {
        if (i11 >= 0) {
            b(context, i11);
            e(context, i11);
            d(context, i11);
        }
    }
}
