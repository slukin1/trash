package com.bbc876219.runtimestatis;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Process;
import com.bbc876219.lib.task.TaskManager;
import com.bbc876219.lib.task.Worker;
import com.bbc876219.lib.zlog.ZLog;

public class RunTimeStatisActivityLifecycleListener implements Application.ActivityLifecycleCallbacks {

    public class a extends Worker {
        public a() {
        }

        public void a() {
            RunTimeStatisManager.dump();
            RunTimeStatisManager.clear();
        }
    }

    public class b implements e {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ StringBuilder f63282a;

        public b(StringBuilder sb2) {
            this.f63282a = sb2;
        }

        public void a(String str) {
            this.f63282a.append(str);
        }

        public void b() {
            ZLog.c("BlockActivityLifecycleListener", this.f63282a.toString());
        }
    }

    public class c implements e {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ StringBuilder f63284a;

        public c(StringBuilder sb2) {
            this.f63284a = sb2;
        }

        public void a(String str) {
            this.f63284a.append(str);
        }

        public void b() {
            ZLog.c("BlockActivityLifecycleListener", this.f63284a.toString());
            RunTimeStatisManager.dump();
            RunTimeStatisManager.clear();
        }
    }

    public static class d extends Thread {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f63286b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e f63287c;

        public d(String str, e eVar) {
            this.f63286b = str;
            this.f63287c = eVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:29:0x0060 A[SYNTHETIC, Splitter:B:29:0x0060] */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x006c A[SYNTHETIC, Splitter:B:37:0x006c] */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x0071  */
        /* JADX WARNING: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r6 = this;
                r0 = 0
                java.lang.Runtime r1 = java.lang.Runtime.getRuntime()     // Catch:{ IOException -> 0x0057, all -> 0x0052 }
                java.lang.String r2 = r6.f63286b     // Catch:{ IOException -> 0x0057, all -> 0x0052 }
                java.lang.Process r1 = r1.exec(r2)     // Catch:{ IOException -> 0x0057, all -> 0x0052 }
                java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ IOException -> 0x004d, all -> 0x0048 }
                java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x004d, all -> 0x0048 }
                java.io.InputStream r4 = r1.getInputStream()     // Catch:{ IOException -> 0x004d, all -> 0x0048 }
                r3.<init>(r4)     // Catch:{ IOException -> 0x004d, all -> 0x0048 }
                r2.<init>(r3)     // Catch:{ IOException -> 0x004d, all -> 0x0048 }
            L_0x0019:
                java.lang.String r0 = r2.readLine()     // Catch:{ IOException -> 0x0046 }
                if (r0 == 0) goto L_0x0038
                com.bbc876219.runtimestatis.RunTimeStatisActivityLifecycleListener$e r3 = r6.f63287c     // Catch:{ IOException -> 0x0046 }
                if (r3 == 0) goto L_0x0019
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0046 }
                r4.<init>()     // Catch:{ IOException -> 0x0046 }
                r4.append(r0)     // Catch:{ IOException -> 0x0046 }
                java.lang.String r0 = " \n"
                r4.append(r0)     // Catch:{ IOException -> 0x0046 }
                java.lang.String r0 = r4.toString()     // Catch:{ IOException -> 0x0046 }
                r3.a(r0)     // Catch:{ IOException -> 0x0046 }
                goto L_0x0019
            L_0x0038:
                com.bbc876219.runtimestatis.RunTimeStatisActivityLifecycleListener$e r0 = r6.f63287c     // Catch:{ IOException -> 0x0046 }
                if (r0 == 0) goto L_0x003f
                r0.b()     // Catch:{ IOException -> 0x0046 }
            L_0x003f:
                r1.destroy()     // Catch:{ IOException -> 0x0046 }
                r2.close()     // Catch:{ IOException -> 0x0065 }
                goto L_0x0065
            L_0x0046:
                r0 = move-exception
                goto L_0x005b
            L_0x0048:
                r2 = move-exception
                r5 = r2
                r2 = r0
                r0 = r5
                goto L_0x006a
            L_0x004d:
                r2 = move-exception
                r5 = r2
                r2 = r0
                r0 = r5
                goto L_0x005b
            L_0x0052:
                r1 = move-exception
                r2 = r0
                r0 = r1
                r1 = r2
                goto L_0x006a
            L_0x0057:
                r1 = move-exception
                r2 = r0
                r0 = r1
                r1 = r2
            L_0x005b:
                r0.printStackTrace()     // Catch:{ all -> 0x0069 }
                if (r2 == 0) goto L_0x0063
                r2.close()     // Catch:{ IOException -> 0x0063 }
            L_0x0063:
                if (r1 == 0) goto L_0x0068
            L_0x0065:
                r1.destroy()
            L_0x0068:
                return
            L_0x0069:
                r0 = move-exception
            L_0x006a:
                if (r2 == 0) goto L_0x006f
                r2.close()     // Catch:{ IOException -> 0x006f }
            L_0x006f:
                if (r1 == 0) goto L_0x0074
                r1.destroy()
            L_0x0074:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bbc876219.runtimestatis.RunTimeStatisActivityLifecycleListener.d.run():void");
        }
    }

    public interface e {
        void a(String str);

        void b();
    }

    public static void a(String str, e eVar) {
        new d(str, eVar).start();
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        ZLog.b("BlockActivityLifecycleListener", "onActivityCreated() called with: activity = [" + activity + "], savedInstanceState = [" + bundle + "]");
    }

    public void onActivityDestroyed(Activity activity) {
        ZLog.b("BlockActivityLifecycleListener", "onActivityDestroyed() called with: activity = [" + activity + "]");
        String format = String.format("cat /proc/%s/status", new Object[]{Integer.valueOf(Process.myPid())});
        StringBuilder sb2 = new StringBuilder();
        sb2.append(format + " \n");
        a(format, new b(sb2));
        String format2 = String.format("ps -T -p %s", new Object[]{Integer.valueOf(Process.myPid())});
        StringBuilder sb3 = new StringBuilder();
        sb3.append(format2 + "\n");
        a(format2, new c(sb3));
    }

    public void onActivityPaused(Activity activity) {
        ZLog.g("BlockActivityLifecycleListener", "onActivityPaused() called with: activity = [" + activity + "]");
    }

    public void onActivityResumed(Activity activity) {
        ZLog.g("BlockActivityLifecycleListener", "onActivityResumed() called with: activity = [" + activity + "]");
        TaskManager.f(new a());
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
        ZLog.b("BlockActivityLifecycleListener", "onActivityStarted() called with: activity = [" + activity + "]");
    }

    public void onActivityStopped(Activity activity) {
        ZLog.g("BlockActivityLifecycleListener", "onActivityStopped() called with: activity = [" + activity + "]");
    }
}
