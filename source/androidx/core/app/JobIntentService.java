package androidx.core.app;

import android.app.Service;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.IBinder;
import android.os.PowerManager;
import java.util.ArrayList;
import java.util.HashMap;

@Deprecated
public abstract class JobIntentService extends Service {

    /* renamed from: i  reason: collision with root package name */
    public static final Object f8147i = new Object();

    /* renamed from: j  reason: collision with root package name */
    public static final HashMap<ComponentName, h> f8148j = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public b f8149b;

    /* renamed from: c  reason: collision with root package name */
    public h f8150c;

    /* renamed from: d  reason: collision with root package name */
    public a f8151d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f8152e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f8153f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f8154g = false;

    /* renamed from: h  reason: collision with root package name */
    public final ArrayList<d> f8155h;

    public final class a extends AsyncTask<Void, Void, Void> {
        public a() {
        }

        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            while (true) {
                e a11 = JobIntentService.this.a();
                if (a11 == null) {
                    return null;
                }
                JobIntentService.this.e(a11.getIntent());
                a11.complete();
            }
        }

        /* renamed from: b */
        public void onCancelled(Void voidR) {
            JobIntentService.this.g();
        }

        /* renamed from: c */
        public void onPostExecute(Void voidR) {
            JobIntentService.this.g();
        }
    }

    public interface b {
        IBinder a();

        e b();
    }

    public static final class c extends h {

        /* renamed from: d  reason: collision with root package name */
        public final Context f8157d;

        /* renamed from: e  reason: collision with root package name */
        public final PowerManager.WakeLock f8158e;

        /* renamed from: f  reason: collision with root package name */
        public final PowerManager.WakeLock f8159f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f8160g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f8161h;

        public c(Context context, ComponentName componentName) {
            super(componentName);
            this.f8157d = context.getApplicationContext();
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(1, componentName.getClassName() + ":launch");
            this.f8158e = newWakeLock;
            newWakeLock.setReferenceCounted(false);
            PowerManager.WakeLock newWakeLock2 = powerManager.newWakeLock(1, componentName.getClassName() + ":run");
            this.f8159f = newWakeLock2;
            newWakeLock2.setReferenceCounted(false);
        }

        public void b() {
            synchronized (this) {
                if (this.f8161h) {
                    if (this.f8160g) {
                        this.f8158e.acquire(60000);
                    }
                    this.f8161h = false;
                    this.f8159f.release();
                }
            }
        }

        public void c() {
            synchronized (this) {
                if (!this.f8161h) {
                    this.f8161h = true;
                    this.f8159f.acquire(600000);
                    this.f8158e.release();
                }
            }
        }

        public void d() {
            synchronized (this) {
                this.f8160g = false;
            }
        }
    }

    public final class d implements e {

        /* renamed from: a  reason: collision with root package name */
        public final Intent f8162a;

        /* renamed from: b  reason: collision with root package name */
        public final int f8163b;

        public d(Intent intent, int i11) {
            this.f8162a = intent;
            this.f8163b = i11;
        }

        public void complete() {
            JobIntentService.this.stopSelf(this.f8163b);
        }

        public Intent getIntent() {
            return this.f8162a;
        }
    }

    public interface e {
        void complete();

        Intent getIntent();
    }

    public static final class f extends JobServiceEngine implements b {

        /* renamed from: a  reason: collision with root package name */
        public final JobIntentService f8165a;

        /* renamed from: b  reason: collision with root package name */
        public final Object f8166b = new Object();

        /* renamed from: c  reason: collision with root package name */
        public JobParameters f8167c;

        public final class a implements e {

            /* renamed from: a  reason: collision with root package name */
            public final JobWorkItem f8168a;

            public a(JobWorkItem jobWorkItem) {
                this.f8168a = jobWorkItem;
            }

            public void complete() {
                synchronized (f.this.f8166b) {
                    JobParameters jobParameters = f.this.f8167c;
                    if (jobParameters != null) {
                        jobParameters.completeWork(this.f8168a);
                    }
                }
            }

            public Intent getIntent() {
                return this.f8168a.getIntent();
            }
        }

        public f(JobIntentService jobIntentService) {
            super(jobIntentService);
            this.f8165a = jobIntentService;
        }

        public IBinder a() {
            return getBinder();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0011, code lost:
            r1.getIntent().setExtrasClassLoader(r3.f8165a.getClassLoader());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0023, code lost:
            return new androidx.core.app.JobIntentService.f.a(r3, r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0024, code lost:
            return null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x000f, code lost:
            if (r1 == null) goto L_0x0024;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public androidx.core.app.JobIntentService.e b() {
            /*
                r3 = this;
                java.lang.Object r0 = r3.f8166b
                monitor-enter(r0)
                android.app.job.JobParameters r1 = r3.f8167c     // Catch:{ all -> 0x0025 }
                r2 = 0
                if (r1 != 0) goto L_0x000a
                monitor-exit(r0)     // Catch:{ all -> 0x0025 }
                return r2
            L_0x000a:
                android.app.job.JobWorkItem r1 = r1.dequeueWork()     // Catch:{ all -> 0x0025 }
                monitor-exit(r0)     // Catch:{ all -> 0x0025 }
                if (r1 == 0) goto L_0x0024
                android.content.Intent r0 = r1.getIntent()
                androidx.core.app.JobIntentService r2 = r3.f8165a
                java.lang.ClassLoader r2 = r2.getClassLoader()
                r0.setExtrasClassLoader(r2)
                androidx.core.app.JobIntentService$f$a r0 = new androidx.core.app.JobIntentService$f$a
                r0.<init>(r1)
                return r0
            L_0x0024:
                return r2
            L_0x0025:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0025 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.app.JobIntentService.f.b():androidx.core.app.JobIntentService$e");
        }

        public boolean onStartJob(JobParameters jobParameters) {
            this.f8167c = jobParameters;
            this.f8165a.c(false);
            return true;
        }

        public boolean onStopJob(JobParameters jobParameters) {
            boolean b11 = this.f8165a.b();
            synchronized (this.f8166b) {
                this.f8167c = null;
            }
            return b11;
        }
    }

    public static final class g extends h {

        /* renamed from: d  reason: collision with root package name */
        public final JobInfo f8170d;

        /* renamed from: e  reason: collision with root package name */
        public final JobScheduler f8171e;

        public g(Context context, ComponentName componentName, int i11) {
            super(componentName);
            a(i11);
            this.f8170d = new JobInfo.Builder(i11, this.f8172a).setOverrideDeadline(0).build();
            this.f8171e = (JobScheduler) context.getApplicationContext().getSystemService("jobscheduler");
        }
    }

    public static abstract class h {

        /* renamed from: a  reason: collision with root package name */
        public final ComponentName f8172a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f8173b;

        /* renamed from: c  reason: collision with root package name */
        public int f8174c;

        public h(ComponentName componentName) {
            this.f8172a = componentName;
        }

        public void a(int i11) {
            if (!this.f8173b) {
                this.f8173b = true;
                this.f8174c = i11;
            } else if (this.f8174c != i11) {
                throw new IllegalArgumentException("Given job ID " + i11 + " is different than previous " + this.f8174c);
            }
        }

        public void b() {
        }

        public void c() {
        }

        public void d() {
        }
    }

    public JobIntentService() {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f8155h = null;
        } else {
            this.f8155h = new ArrayList<>();
        }
    }

    public static h d(Context context, ComponentName componentName, boolean z11, int i11) {
        h hVar;
        HashMap<ComponentName, h> hashMap = f8148j;
        h hVar2 = hashMap.get(componentName);
        if (hVar2 != null) {
            return hVar2;
        }
        if (Build.VERSION.SDK_INT < 26) {
            hVar = new c(context, componentName);
        } else if (z11) {
            hVar = new g(context, componentName, i11);
        } else {
            throw new IllegalArgumentException("Can't be here without a job id");
        }
        h hVar3 = hVar;
        hashMap.put(componentName, hVar3);
        return hVar3;
    }

    public e a() {
        b bVar = this.f8149b;
        if (bVar != null) {
            return bVar.b();
        }
        synchronized (this.f8155h) {
            if (this.f8155h.size() <= 0) {
                return null;
            }
            e remove = this.f8155h.remove(0);
            return remove;
        }
    }

    public boolean b() {
        a aVar = this.f8151d;
        if (aVar != null) {
            aVar.cancel(this.f8152e);
        }
        this.f8153f = true;
        return f();
    }

    public void c(boolean z11) {
        if (this.f8151d == null) {
            this.f8151d = new a();
            h hVar = this.f8150c;
            if (hVar != null && z11) {
                hVar.c();
            }
            this.f8151d.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    public abstract void e(Intent intent);

    public boolean f() {
        return true;
    }

    public void g() {
        ArrayList<d> arrayList = this.f8155h;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.f8151d = null;
                ArrayList<d> arrayList2 = this.f8155h;
                if (arrayList2 != null && arrayList2.size() > 0) {
                    c(false);
                } else if (!this.f8154g) {
                    this.f8150c.b();
                }
            }
        }
    }

    public IBinder onBind(Intent intent) {
        b bVar = this.f8149b;
        if (bVar != null) {
            return bVar.a();
        }
        return null;
    }

    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 26) {
            this.f8149b = new f(this);
            this.f8150c = null;
            return;
        }
        this.f8149b = null;
        this.f8150c = d(this, new ComponentName(this, getClass()), false, 0);
    }

    public void onDestroy() {
        super.onDestroy();
        ArrayList<d> arrayList = this.f8155h;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.f8154g = true;
                this.f8150c.b();
            }
        }
    }

    public int onStartCommand(Intent intent, int i11, int i12) {
        if (this.f8155h == null) {
            return 2;
        }
        this.f8150c.d();
        synchronized (this.f8155h) {
            ArrayList<d> arrayList = this.f8155h;
            if (intent == null) {
                intent = new Intent();
            }
            arrayList.add(new d(intent, i12));
            c(true);
        }
        return 3;
    }
}
