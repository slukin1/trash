package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import com.xiaomi.push.af;
import com.xiaomi.push.service.ah;
import java.io.File;
import java.util.List;

/* renamed from: com.xiaomi.push.do  reason: invalid class name */
public class Cdo extends af.a {

    /* renamed from: a  reason: collision with root package name */
    private Context f51593a;

    /* renamed from: a  reason: collision with other field name */
    private SharedPreferences f2676a;

    /* renamed from: a  reason: collision with other field name */
    private ah f2677a;

    public Cdo(Context context) {
        this.f51593a = context;
        this.f2676a = context.getSharedPreferences("mipush_extra", 0);
        this.f2677a = ah.a(context);
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m2526a() {
        if (av.d(this.f51593a)) {
            return false;
        }
        if ((av.f(this.f51593a) || av.e(this.f51593a)) && !c()) {
            return true;
        }
        if ((!av.g(this.f51593a) || b()) && !av.h(this.f51593a)) {
            return false;
        }
        return true;
    }

    private boolean b() {
        if (!this.f2677a.a(gl.Upload3GSwitch.a(), true)) {
            return false;
        }
        int max = Math.max(86400, this.f2677a.a(gl.Upload3GFrequency.a(), 432000));
        if (Math.abs((System.currentTimeMillis() / 1000) - this.f2676a.getLong("last_upload_data_timestamp", -1)) > ((long) max)) {
            return true;
        }
        return false;
    }

    private boolean c() {
        if (!this.f2677a.a(gl.Upload4GSwitch.a(), true)) {
            return false;
        }
        int max = Math.max(86400, this.f2677a.a(gl.Upload4GFrequency.a(), 259200));
        if (Math.abs((System.currentTimeMillis() / 1000) - this.f2676a.getLong("last_upload_data_timestamp", -1)) > ((long) max)) {
            return true;
        }
        return false;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m2527a() {
        return "1";
    }

    public void run() {
        File file = new File(this.f51593a.getFilesDir(), "push_cdata.data");
        if (!av.c(this.f51593a)) {
            if (file.length() > 1863680) {
                file.delete();
            }
        } else if (!a() && file.exists()) {
            List<go> a11 = a(file);
            if (!aa.a(a11)) {
                int size = a11.size();
                if (size > 4000) {
                    a11 = a11.subList(size - 4000, size);
                }
                gz gzVar = new gz();
                gzVar.a(a11);
                byte[] a12 = x.a(hq.a(gzVar));
                hf hfVar = new hf("-1", false);
                hfVar.c(gq.DataCollection.f2942a);
                hfVar.a(a12);
                dg a13 = dh.a().a();
                if (a13 != null) {
                    a13.a(hfVar, gg.Notification, (gt) null);
                }
                a();
            }
            file.delete();
        }
    }

    private void a() {
        SharedPreferences.Editor edit = this.f2676a.edit();
        edit.putLong("last_upload_data_timestamp", System.currentTimeMillis() / 1000);
        edit.commit();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:48|47|63|65|66|67|68|29|69|70) */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:13|14|(3:15|16|(2:75|18)(2:19|(1:76)(4:30|31|(1:77)(2:33|(2:35|78)(2:36|79))|74)))|(3:22|23|(2:25|26))|27|28) */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:45|46|(0)|57|58|59) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0066 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x00a2 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:67:0x00b6 */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0099 A[SYNTHETIC, Splitter:B:52:0x0099] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:57:0x00a2=Splitter:B:57:0x00a2, B:27:0x0066=Splitter:B:27:0x0066, B:67:0x00b6=Splitter:B:67:0x00b6} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List<com.xiaomi.push.go> a(java.io.File r11) {
        /*
            r10 = this;
            com.xiaomi.push.dh r0 = com.xiaomi.push.dh.a()
            com.xiaomi.push.dg r0 = r0.a()
            if (r0 != 0) goto L_0x000d
            java.lang.String r0 = ""
            goto L_0x0011
        L_0x000d:
            java.lang.String r0 = r0.a()
        L_0x0011:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            r2 = 0
            if (r1 == 0) goto L_0x0019
            return r2
        L_0x0019:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r3 = 4
            byte[] r4 = new byte[r3]
            java.lang.Object r5 = com.xiaomi.push.dk.f51588a
            monitor-enter(r5)
            java.io.File r6 = new java.io.File     // Catch:{ Exception -> 0x00a9, all -> 0x0094 }
            android.content.Context r7 = r10.f51593a     // Catch:{ Exception -> 0x00a9, all -> 0x0094 }
            java.io.File r7 = r7.getFilesDir()     // Catch:{ Exception -> 0x00a9, all -> 0x0094 }
            java.lang.String r8 = "push_cdata.lock"
            r6.<init>(r7, r8)     // Catch:{ Exception -> 0x00a9, all -> 0x0094 }
            com.xiaomi.push.x.a((java.io.File) r6)     // Catch:{ Exception -> 0x00a9, all -> 0x0094 }
            java.io.RandomAccessFile r7 = new java.io.RandomAccessFile     // Catch:{ Exception -> 0x00a9, all -> 0x0094 }
            java.lang.String r8 = "rw"
            r7.<init>(r6, r8)     // Catch:{ Exception -> 0x00a9, all -> 0x0094 }
            java.nio.channels.FileChannel r6 = r7.getChannel()     // Catch:{ Exception -> 0x0092, all -> 0x008f }
            java.nio.channels.FileLock r6 = r6.lock()     // Catch:{ Exception -> 0x0092, all -> 0x008f }
            java.io.FileInputStream r8 = new java.io.FileInputStream     // Catch:{ Exception -> 0x008c, all -> 0x0088 }
            r8.<init>(r11)     // Catch:{ Exception -> 0x008c, all -> 0x0088 }
        L_0x0048:
            int r11 = r8.read(r4)     // Catch:{ Exception -> 0x008d, all -> 0x0086 }
            if (r11 == r3) goto L_0x004f
            goto L_0x005b
        L_0x004f:
            int r11 = com.xiaomi.push.z.a((byte[]) r4)     // Catch:{ Exception -> 0x008d, all -> 0x0086 }
            byte[] r2 = new byte[r11]     // Catch:{ Exception -> 0x008d, all -> 0x0086 }
            int r9 = r8.read(r2)     // Catch:{ Exception -> 0x008d, all -> 0x0086 }
            if (r9 == r11) goto L_0x006d
        L_0x005b:
            if (r6 == 0) goto L_0x0066
            boolean r11 = r6.isValid()     // Catch:{ all -> 0x00bc }
            if (r11 == 0) goto L_0x0066
            r6.release()     // Catch:{ IOException -> 0x0066 }
        L_0x0066:
            com.xiaomi.push.x.a((java.io.Closeable) r8)     // Catch:{ all -> 0x00bc }
        L_0x0069:
            com.xiaomi.push.x.a((java.io.Closeable) r7)     // Catch:{ all -> 0x00bc }
            goto L_0x00ba
        L_0x006d:
            byte[] r11 = com.xiaomi.push.dj.a(r0, r2)     // Catch:{ Exception -> 0x008d, all -> 0x0086 }
            if (r11 == 0) goto L_0x0048
            int r2 = r11.length     // Catch:{ Exception -> 0x008d, all -> 0x0086 }
            if (r2 != 0) goto L_0x0077
            goto L_0x0048
        L_0x0077:
            com.xiaomi.push.go r2 = new com.xiaomi.push.go     // Catch:{ Exception -> 0x008d, all -> 0x0086 }
            r2.<init>()     // Catch:{ Exception -> 0x008d, all -> 0x0086 }
            com.xiaomi.push.hq.a(r2, (byte[]) r11)     // Catch:{ Exception -> 0x008d, all -> 0x0086 }
            r1.add(r2)     // Catch:{ Exception -> 0x008d, all -> 0x0086 }
            r10.a((com.xiaomi.push.go) r2)     // Catch:{ Exception -> 0x008d, all -> 0x0086 }
            goto L_0x0048
        L_0x0086:
            r11 = move-exception
            goto L_0x008a
        L_0x0088:
            r11 = move-exception
            r8 = r2
        L_0x008a:
            r2 = r6
            goto L_0x0097
        L_0x008c:
            r8 = r2
        L_0x008d:
            r2 = r6
            goto L_0x00ab
        L_0x008f:
            r11 = move-exception
            r8 = r2
            goto L_0x0097
        L_0x0092:
            r8 = r2
            goto L_0x00ab
        L_0x0094:
            r11 = move-exception
            r7 = r2
            r8 = r7
        L_0x0097:
            if (r2 == 0) goto L_0x00a2
            boolean r0 = r2.isValid()     // Catch:{ all -> 0x00bc }
            if (r0 == 0) goto L_0x00a2
            r2.release()     // Catch:{ IOException -> 0x00a2 }
        L_0x00a2:
            com.xiaomi.push.x.a((java.io.Closeable) r8)     // Catch:{ all -> 0x00bc }
            com.xiaomi.push.x.a((java.io.Closeable) r7)     // Catch:{ all -> 0x00bc }
            throw r11     // Catch:{ all -> 0x00bc }
        L_0x00a9:
            r7 = r2
            r8 = r7
        L_0x00ab:
            if (r2 == 0) goto L_0x00b6
            boolean r11 = r2.isValid()     // Catch:{ all -> 0x00bc }
            if (r11 == 0) goto L_0x00b6
            r2.release()     // Catch:{ IOException -> 0x00b6 }
        L_0x00b6:
            com.xiaomi.push.x.a((java.io.Closeable) r8)     // Catch:{ all -> 0x00bc }
            goto L_0x0069
        L_0x00ba:
            monitor-exit(r5)     // Catch:{ all -> 0x00bc }
            return r1
        L_0x00bc:
            r11 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x00bc }
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.Cdo.a(java.io.File):java.util.List");
    }

    private void a(go goVar) {
        if (goVar.f2933a == gi.AppInstallList && !goVar.f2934a.startsWith("same_")) {
            SharedPreferences.Editor edit = this.f2676a.edit();
            edit.putLong("dc_job_result_time_4", goVar.f2932a);
            edit.putString("dc_job_result_4", bc.a(goVar.f2934a));
            edit.commit();
        }
    }
}
