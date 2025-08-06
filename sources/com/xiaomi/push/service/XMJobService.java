package com.xiaomi.push.service;

import android.annotation.TargetApi;
import android.app.Service;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.ax;
import com.xiaomi.push.ea;
import com.xiaomi.push.j;

public class XMJobService extends Service {

    /* renamed from: a  reason: collision with root package name */
    public static Service f52392a;

    /* renamed from: a  reason: collision with other field name */
    private IBinder f3275a = null;

    @TargetApi(21)
    public static class a extends JobService {

        /* renamed from: a  reason: collision with root package name */
        public Binder f52393a;

        /* renamed from: a  reason: collision with other field name */
        private Handler f3276a;

        /* renamed from: com.xiaomi.push.service.XMJobService$a$a  reason: collision with other inner class name */
        public static class C0641a extends Handler {

            /* renamed from: a  reason: collision with root package name */
            public JobService f52394a;

            public C0641a(JobService jobService) {
                super(jobService.getMainLooper());
                this.f52394a = jobService;
            }

            public void handleMessage(Message message) {
                if (message.what == 1) {
                    JobParameters jobParameters = (JobParameters) message.obj;
                    b.a("Job finished " + jobParameters.getJobId());
                    this.f52394a.jobFinished(jobParameters, false);
                    if (jobParameters.getJobId() == 1) {
                        ea.a(false);
                    }
                }
            }
        }

        public a(Service service) {
            this.f52393a = null;
            this.f52393a = (Binder) ax.a((Object) this, "onBind", new Intent());
            ax.a((Object) this, "attachBaseContext", service);
        }

        public boolean onStartJob(JobParameters jobParameters) {
            b.a("Job started " + jobParameters.getJobId());
            Intent intent = new Intent(this, XMPushService.class);
            intent.setAction("com.xiaomi.push.timer");
            intent.setPackage(getPackageName());
            startService(intent);
            if (this.f3276a == null) {
                this.f3276a = new C0641a(this);
            }
            Handler handler = this.f3276a;
            handler.sendMessage(Message.obtain(handler, 1, jobParameters));
            return true;
        }

        public boolean onStopJob(JobParameters jobParameters) {
            b.a("Job stop " + jobParameters.getJobId());
            return false;
        }
    }

    public IBinder onBind(Intent intent) {
        IBinder iBinder = this.f3275a;
        if (iBinder != null) {
            return iBinder;
        }
        return new Binder();
    }

    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 21) {
            this.f3275a = new a(this).f52393a;
        }
        f52392a = this;
    }

    public void onDestroy() {
        super.onDestroy();
        f52392a = null;
    }

    public int onStartCommand(Intent intent, int i11, int i12) {
        int onStartCommand = super.onStartCommand(intent, i11, i12);
        if (j.a((Context) this)) {
            return onStartCommand;
        }
        return 2;
    }
}
