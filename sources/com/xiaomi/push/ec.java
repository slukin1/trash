package com.xiaomi.push;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.SystemClock;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.ea;
import com.xiaomi.push.service.XMJobService;

@TargetApi(21)
public class ec implements ea.a {

    /* renamed from: a  reason: collision with root package name */
    public JobScheduler f51674a;

    /* renamed from: a  reason: collision with other field name */
    public Context f2766a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f2767a = false;

    public ec(Context context) {
        this.f2766a = context;
        this.f51674a = (JobScheduler) context.getSystemService("jobscheduler");
    }

    public void a(long j11) {
        JobInfo.Builder builder = new JobInfo.Builder(1, new ComponentName(this.f2766a.getPackageName(), XMJobService.class.getName()));
        builder.setMinimumLatency(j11);
        builder.setOverrideDeadline(j11);
        builder.setRequiredNetworkType(1);
        JobInfo build = builder.build();
        b.c("schedule Job = " + build.getId() + " in " + j11);
        this.f51674a.schedule(builder.build());
    }

    public void a(boolean z11) {
        if (z11 || this.f2767a) {
            long b11 = (long) fh.b();
            if (z11) {
                a();
                b11 -= SystemClock.elapsedRealtime() % b11;
            }
            this.f2767a = true;
            a(b11);
        }
    }

    public void a() {
        this.f2767a = false;
        this.f51674a.cancel(1);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2635a() {
        return this.f2767a;
    }
}
