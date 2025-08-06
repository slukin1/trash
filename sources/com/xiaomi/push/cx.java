package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.hbg.lib.network.pro.core.util.Period;
import com.xiaomi.channel.commonutils.logger.b;

public class cx {

    /* renamed from: a  reason: collision with root package name */
    private static int f51561a = 0;

    /* renamed from: a  reason: collision with other field name */
    private static boolean f2635a = true;

    private static int a(boolean z11) {
        return z11 ? 1 : 0;
    }

    /* renamed from: a  reason: collision with other method in class */
    private static SharedPreferences m2514a(Context context) {
        return context.getSharedPreferences("sp_power_stats", 0);
    }

    public static void b(final Context context, final long j11, final boolean z11) {
        af.a(context).a((Runnable) new Runnable() {
            public void run() {
                try {
                    cx.j(context, j11, z11);
                } catch (Exception e11) {
                    b.a("PowerStatsSP onReceiveMsg exception: " + e11.getMessage());
                }
            }
        });
    }

    public static void c(final Context context, final long j11, final boolean z11) {
        af.a(context).a((Runnable) new Runnable() {
            public void run() {
                try {
                    cx.k(context, j11, z11);
                } catch (Exception e11) {
                    b.a("PowerStatsSP onPing exception: " + e11.getMessage());
                }
            }
        });
    }

    public static void d(final Context context, final long j11, final boolean z11) {
        af.a(context).a((Runnable) new Runnable() {
            public void run() {
                try {
                    cx.l(context, j11, z11);
                } catch (Exception e11) {
                    b.a("PowerStatsSP onPong exception: " + e11.getMessage());
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public static synchronized void i(Context context, long j11, boolean z11) {
        int i11;
        synchronized (cx.class) {
            cu.a("recordSendMsg start");
            int a11 = a(z11);
            SharedPreferences a12 = a(context);
            long j12 = a12.getLong("start_time", 0);
            if (j12 <= 0) {
                a(context, a12, j11, a11);
            }
            if (a11 == 1) {
                i11 = a12.getInt("on_up_count", 0) + 1;
                a12.edit().putInt("on_up_count", i11).apply();
            } else {
                i11 = a12.getInt("off_up_count", 0) + 1;
                a12.edit().putInt("off_up_count", i11).apply();
            }
            a(context, j12, j11, i11, a11);
            cu.a("recordSendMsg complete");
        }
    }

    /* access modifiers changed from: private */
    public static synchronized void j(Context context, long j11, boolean z11) {
        int i11;
        synchronized (cx.class) {
            cu.a("recordReceiveMsg start");
            int a11 = a(z11);
            SharedPreferences a12 = a(context);
            long j12 = a12.getLong("start_time", 0);
            if (j12 <= 0) {
                a(context, a12, j11, a11);
            }
            if (a11 == 1) {
                i11 = a12.getInt("on_down_count", 0) + 1;
                a12.edit().putInt("on_down_count", i11).apply();
            } else {
                i11 = a12.getInt("off_down_count", 0) + 1;
                a12.edit().putInt("off_down_count", i11).apply();
            }
            a(context, j12, j11, i11, a11);
            cu.a("recordReceiveMsg complete");
        }
    }

    /* access modifiers changed from: private */
    public static synchronized void k(Context context, long j11, boolean z11) {
        int i11;
        synchronized (cx.class) {
            cu.a("recordPing start");
            int a11 = a(z11);
            SharedPreferences a12 = a(context);
            long j12 = a12.getLong("start_time", 0);
            if (j12 <= 0) {
                a(context, a12, j11, a11);
            }
            if (a11 == 1) {
                i11 = a12.getInt("on_ping_count", 0) + 1;
                a12.edit().putInt("on_ping_count", i11).apply();
            } else {
                i11 = a12.getInt("off_ping_count", 0) + 1;
                a12.edit().putInt("off_ping_count", i11).apply();
            }
            a(context, j12, j11, i11, a11);
            cu.a("recordPing complete");
        }
    }

    /* access modifiers changed from: private */
    public static synchronized void l(Context context, long j11, boolean z11) {
        int i11;
        synchronized (cx.class) {
            cu.a("recordPong start");
            int a11 = a(z11);
            SharedPreferences a12 = a(context);
            long j12 = a12.getLong("start_time", 0);
            if (j12 <= 0) {
                a(context, a12, j11, a11);
            }
            if (a11 == 1) {
                i11 = a12.getInt("on_pong_count", 0) + 1;
                a12.edit().putInt("on_pong_count", i11).apply();
            } else {
                i11 = a12.getInt("off_pong_count", 0) + 1;
                a12.edit().putInt("off_pong_count", i11).apply();
            }
            a(context, j12, j11, i11, a11);
            cu.a("recordPong complete");
        }
    }

    public static void a(final Context context, final long j11, final boolean z11) {
        af.a(context).a((Runnable) new Runnable() {
            public void run() {
                try {
                    cx.i(context, j11, z11);
                } catch (Exception e11) {
                    b.a("PowerStatsSP onSendMsg exception: " + e11.getMessage());
                }
            }
        });
    }

    private static void b(Context context, long j11, int i11) {
        cu.a("reset");
        a(context).edit().clear().putLong("start_time", j11).putInt("current_screen_state", i11).putLong("current_screen_state_start_time", j11).putInt("xmsf_vc", a(context)).putInt("android_vc", Build.VERSION.SDK_INT).apply();
    }

    private static void a(Context context, SharedPreferences sharedPreferences, long j11, int i11) {
        cu.a("recordInit");
        sharedPreferences.edit().putLong("start_time", j11).putInt("current_screen_state", i11).putLong("current_screen_state_start_time", j11).putInt("xmsf_vc", a(context)).putInt("android_vc", Build.VERSION.SDK_INT).apply();
    }

    private static void a(Context context, long j11, long j12, int i11, int i12) {
        if (j11 <= 0) {
            return;
        }
        if (a(context) || i11 >= 1073741823 || j12 - j11 >= Period.DAY_MILLS) {
            a(context).edit().putLong("end_time", j12).apply();
            a(context, j12, i12);
        }
    }

    private static void a(Context context, long j11, int i11) {
        cu.a("upload");
        new cw().a(context, a(context));
        b(context, j11, i11);
    }

    /* renamed from: a  reason: collision with other method in class */
    private static cv m2515a(Context context) {
        SharedPreferences a11 = a(context);
        cv cvVar = new cv();
        cvVar.a(a11.getInt("off_up_count", 0));
        cvVar.b(a11.getInt("off_down_count", 0));
        cvVar.c(a11.getInt("off_ping_count", 0));
        cvVar.d(a11.getInt("off_pong_count", 0));
        cvVar.a(a11.getLong("off_duration", 0));
        cvVar.e(a11.getInt("on_up_count", 0));
        cvVar.f(a11.getInt("on_down_count", 0));
        cvVar.g(a11.getInt("on_ping_count", 0));
        cvVar.h(a11.getInt("on_pong_count", 0));
        cvVar.b(a11.getLong("on_duration", 0));
        cvVar.c(a11.getLong("start_time", 0));
        cvVar.d(a11.getLong("end_time", 0));
        cvVar.i(a11.getInt("xmsf_vc", 0));
        cvVar.j(a11.getInt("android_vc", 0));
        return cvVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    private static boolean m2516a(Context context) {
        boolean z11 = false;
        if (f2635a) {
            f2635a = false;
            SharedPreferences a11 = a(context);
            int i11 = a11.getInt("xmsf_vc", 0);
            int i12 = a11.getInt("android_vc", 0);
            if (!(i11 == 0 || i12 == 0 || (i11 == a(context) && i12 == Build.VERSION.SDK_INT))) {
                z11 = true;
            }
        }
        cu.a("isVcChanged = " + z11);
        return z11;
    }

    private static int a(Context context) {
        if (f51561a <= 0) {
            f51561a = j.b(context);
        }
        return f51561a;
    }
}
