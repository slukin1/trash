package com.xiaomi.push;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.SystemClock;
import com.tencent.thumbplayer.tcmedia.core.common.TPMediaCodecProfileLevel;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.ea;
import com.xiaomi.push.service.an;
import com.xiaomi.push.service.m;

class eb implements ea.a {

    /* renamed from: a  reason: collision with root package name */
    private volatile long f51673a = 0;

    /* renamed from: a  reason: collision with other field name */
    private PendingIntent f2764a = null;

    /* renamed from: a  reason: collision with other field name */
    public Context f2765a = null;

    public eb(Context context) {
        this.f2765a = context;
    }

    public void a(Intent intent, long j11) {
        AlarmManager alarmManager = (AlarmManager) this.f2765a.getSystemService("alarm");
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 31) {
            this.f2764a = PendingIntent.getBroadcast(this.f2765a, 0, intent, TPMediaCodecProfileLevel.HEVCHighTierLevel62);
        } else {
            this.f2764a = PendingIntent.getBroadcast(this.f2765a, 0, intent, 0);
        }
        if (i11 >= 31 && !j.a(this.f2765a)) {
            alarmManager.set(2, j11, this.f2764a);
        } else if (i11 >= 23) {
            ax.a((Object) alarmManager, "setExactAndAllowWhileIdle", 2, Long.valueOf(j11), this.f2764a);
        } else {
            a(alarmManager, j11, this.f2764a);
        }
        b.c("[Alarm] register timer " + j11);
    }

    private void a(AlarmManager alarmManager, long j11, PendingIntent pendingIntent) {
        Class<AlarmManager> cls = AlarmManager.class;
        try {
            cls.getMethod("setExact", new Class[]{Integer.TYPE, Long.TYPE, PendingIntent.class}).invoke(alarmManager, new Object[]{2, Long.valueOf(j11), pendingIntent});
        } catch (Exception e11) {
            b.d("[Alarm] invoke setExact method meet error. " + e11);
        }
    }

    public void a(boolean z11) {
        long a11 = m.a(this.f2765a).a();
        if (z11 || this.f51673a != 0) {
            if (z11) {
                a();
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (z11 || this.f51673a == 0) {
                this.f51673a = elapsedRealtime + (a11 - (elapsedRealtime % a11));
            } else if (this.f51673a <= elapsedRealtime) {
                this.f51673a += a11;
                if (this.f51673a < elapsedRealtime) {
                    this.f51673a = elapsedRealtime + a11;
                }
            }
            Intent intent = new Intent(an.f52501r);
            intent.setPackage(this.f2765a.getPackageName());
            a(intent, this.f51673a);
        }
    }

    public void a() {
        if (this.f2764a != null) {
            try {
                ((AlarmManager) this.f2765a.getSystemService("alarm")).cancel(this.f2764a);
            } catch (Exception unused) {
            } catch (Throwable th2) {
                this.f2764a = null;
                b.c("[Alarm] unregister timer");
                this.f51673a = 0;
                throw th2;
            }
            this.f2764a = null;
            b.c("[Alarm] unregister timer");
            this.f51673a = 0;
        }
        this.f51673a = 0;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2634a() {
        return this.f51673a != 0;
    }
}
