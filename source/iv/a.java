package iv;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Debug;
import android.os.Process;
import android.text.TextUtils;
import com.huobi.woodpecker.WoodPeckerSDK;
import com.huobi.woodpecker.utils.ContextUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public Context f22832a;

    /* renamed from: b  reason: collision with root package name */
    public ActivityManager f22833b;

    /* renamed from: c  reason: collision with root package name */
    public RandomAccessFile f22834c;

    /* renamed from: d  reason: collision with root package name */
    public RandomAccessFile f22835d;

    /* renamed from: e  reason: collision with root package name */
    public Long f22836e;

    /* renamed from: f  reason: collision with root package name */
    public Long f22837f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f22838g;

    /* renamed from: h  reason: collision with root package name */
    public float f22839h;

    /* renamed from: i  reason: collision with root package name */
    public float f22840i;

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static a f22841a = new a();
    }

    public static a e() {
        return b.f22841a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x00cc A[Catch:{ Exception -> 0x00fd }] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x00d9 A[Catch:{ Exception -> 0x00fd }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final float a() {
        /*
            r7 = this;
            java.lang.String r0 = " "
            java.lang.String r1 = "r"
            r2 = 0
            java.io.RandomAccessFile r3 = r7.f22834c     // Catch:{ Exception -> 0x00fd }
            if (r3 == 0) goto L_0x0019
            java.io.RandomAccessFile r4 = r7.f22835d     // Catch:{ Exception -> 0x00fd }
            if (r4 != 0) goto L_0x000e
            goto L_0x0019
        L_0x000e:
            r4 = 0
            r3.seek(r4)     // Catch:{ Exception -> 0x00fd }
            java.io.RandomAccessFile r1 = r7.f22835d     // Catch:{ Exception -> 0x00fd }
            r1.seek(r4)     // Catch:{ Exception -> 0x00fd }
            goto L_0x0043
        L_0x0019:
            java.io.RandomAccessFile r3 = new java.io.RandomAccessFile     // Catch:{ Exception -> 0x00fd }
            java.lang.String r4 = "/proc/stat"
            r3.<init>(r4, r1)     // Catch:{ Exception -> 0x00fd }
            r7.f22834c = r3     // Catch:{ Exception -> 0x00fd }
            java.io.RandomAccessFile r3 = new java.io.RandomAccessFile     // Catch:{ Exception -> 0x00fd }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00fd }
            r4.<init>()     // Catch:{ Exception -> 0x00fd }
            java.lang.String r5 = "/proc/"
            r4.append(r5)     // Catch:{ Exception -> 0x00fd }
            int r5 = android.os.Process.myPid()     // Catch:{ Exception -> 0x00fd }
            r4.append(r5)     // Catch:{ Exception -> 0x00fd }
            java.lang.String r5 = "/stat"
            r4.append(r5)     // Catch:{ Exception -> 0x00fd }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x00fd }
            r3.<init>(r4, r1)     // Catch:{ Exception -> 0x00fd }
            r7.f22835d = r3     // Catch:{ Exception -> 0x00fd }
        L_0x0043:
            java.io.RandomAccessFile r1 = r7.f22834c     // Catch:{ Exception -> 0x00fd }
            java.lang.String r1 = r1.readLine()     // Catch:{ Exception -> 0x00fd }
            java.io.RandomAccessFile r3 = r7.f22835d     // Catch:{ Exception -> 0x00fd }
            java.lang.String r3 = r3.readLine()     // Catch:{ Exception -> 0x00fd }
            java.lang.String[] r1 = r1.split(r0)     // Catch:{ Exception -> 0x00fd }
            java.lang.String[] r0 = r3.split(r0)     // Catch:{ Exception -> 0x00fd }
            r3 = 2
            r3 = r1[r3]     // Catch:{ Exception -> 0x00fd }
            java.lang.Long r3 = com.huobi.woodpecker.utils.NumberUtil.a(r3)     // Catch:{ Exception -> 0x00fd }
            long r3 = r3.longValue()     // Catch:{ Exception -> 0x00fd }
            r5 = 3
            r5 = r1[r5]     // Catch:{ Exception -> 0x00fd }
            java.lang.Long r5 = com.huobi.woodpecker.utils.NumberUtil.a(r5)     // Catch:{ Exception -> 0x00fd }
            long r5 = r5.longValue()     // Catch:{ Exception -> 0x00fd }
            long r3 = r3 + r5
            r5 = 4
            r5 = r1[r5]     // Catch:{ Exception -> 0x00fd }
            java.lang.Long r5 = com.huobi.woodpecker.utils.NumberUtil.a(r5)     // Catch:{ Exception -> 0x00fd }
            long r5 = r5.longValue()     // Catch:{ Exception -> 0x00fd }
            long r3 = r3 + r5
            r5 = 5
            r5 = r1[r5]     // Catch:{ Exception -> 0x00fd }
            java.lang.Long r5 = com.huobi.woodpecker.utils.NumberUtil.a(r5)     // Catch:{ Exception -> 0x00fd }
            long r5 = r5.longValue()     // Catch:{ Exception -> 0x00fd }
            long r3 = r3 + r5
            r5 = 6
            r5 = r1[r5]     // Catch:{ Exception -> 0x00fd }
            java.lang.Long r5 = com.huobi.woodpecker.utils.NumberUtil.a(r5)     // Catch:{ Exception -> 0x00fd }
            long r5 = r5.longValue()     // Catch:{ Exception -> 0x00fd }
            long r3 = r3 + r5
            r5 = 7
            r5 = r1[r5]     // Catch:{ Exception -> 0x00fd }
            java.lang.Long r5 = com.huobi.woodpecker.utils.NumberUtil.a(r5)     // Catch:{ Exception -> 0x00fd }
            long r5 = r5.longValue()     // Catch:{ Exception -> 0x00fd }
            long r3 = r3 + r5
            r5 = 8
            r1 = r1[r5]     // Catch:{ Exception -> 0x00fd }
            java.lang.Long r1 = com.huobi.woodpecker.utils.NumberUtil.a(r1)     // Catch:{ Exception -> 0x00fd }
            long r5 = r1.longValue()     // Catch:{ Exception -> 0x00fd }
            long r3 = r3 + r5
            r1 = 13
            r1 = r0[r1]     // Catch:{ Exception -> 0x00fd }
            java.lang.Long r1 = com.huobi.woodpecker.utils.NumberUtil.a(r1)     // Catch:{ Exception -> 0x00fd }
            long r5 = r1.longValue()     // Catch:{ Exception -> 0x00fd }
            r1 = 14
            r0 = r0[r1]     // Catch:{ Exception -> 0x00fd }
            java.lang.Long r0 = com.huobi.woodpecker.utils.NumberUtil.a(r0)     // Catch:{ Exception -> 0x00fd }
            long r0 = r0.longValue()     // Catch:{ Exception -> 0x00fd }
            long r5 = r5 + r0
            java.lang.Long r0 = r7.f22836e     // Catch:{ Exception -> 0x00fd }
            if (r0 != 0) goto L_0x00d9
            java.lang.Long r0 = r7.f22837f     // Catch:{ Exception -> 0x00fd }
            if (r0 != 0) goto L_0x00d9
            java.lang.Long r0 = java.lang.Long.valueOf(r3)     // Catch:{ Exception -> 0x00fd }
            r7.f22836e = r0     // Catch:{ Exception -> 0x00fd }
            java.lang.Long r0 = java.lang.Long.valueOf(r5)     // Catch:{ Exception -> 0x00fd }
            r7.f22837f = r0     // Catch:{ Exception -> 0x00fd }
            return r2
        L_0x00d9:
            java.lang.Long r0 = r7.f22837f     // Catch:{ Exception -> 0x00fd }
            long r0 = r0.longValue()     // Catch:{ Exception -> 0x00fd }
            long r0 = r5 - r0
            float r0 = (float) r0     // Catch:{ Exception -> 0x00fd }
            java.lang.Long r1 = r7.f22836e     // Catch:{ Exception -> 0x00fd }
            long r1 = r1.longValue()     // Catch:{ Exception -> 0x00fd }
            long r1 = r3 - r1
            float r1 = (float) r1     // Catch:{ Exception -> 0x00fd }
            float r0 = r0 / r1
            r1 = 1120403456(0x42c80000, float:100.0)
            float r2 = r0 * r1
            java.lang.Long r0 = java.lang.Long.valueOf(r3)     // Catch:{ Exception -> 0x00fd }
            r7.f22836e = r0     // Catch:{ Exception -> 0x00fd }
            java.lang.Long r0 = java.lang.Long.valueOf(r5)     // Catch:{ Exception -> 0x00fd }
            r7.f22837f = r0     // Catch:{ Exception -> 0x00fd }
            goto L_0x0101
        L_0x00fd:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0101:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: iv.a.a():float");
    }

    public final int b(String str) {
        if (!str.contains("CPU")) {
            return -1;
        }
        String[] split = str.split("\\s+");
        for (int i11 = 0; i11 < split.length; i11++) {
            if (split[i11].contains("CPU")) {
                return i11;
            }
        }
        return -1;
    }

    public final float c() {
        Process process = null;
        try {
            process = Runtime.getRuntime().exec("top -n 1");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            int i11 = -1;
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                String trim = readLine.trim();
                if (!TextUtils.isEmpty(trim)) {
                    int b11 = b(trim);
                    if (b11 != -1) {
                        i11 = b11;
                    } else if (!trim.startsWith(String.valueOf(Process.myPid()))) {
                        continue;
                    } else if (i11 != -1) {
                        String[] split = trim.split("\\s+");
                        if (split.length > i11) {
                            String str = split[i11];
                            if (str.endsWith("%")) {
                                str = str.substring(0, str.lastIndexOf("%"));
                            }
                            float parseFloat = Float.parseFloat(str) / ((float) Runtime.getRuntime().availableProcessors());
                            process.destroy();
                            return parseFloat;
                        }
                    }
                }
            }
        } catch (IOException e11) {
            e11.printStackTrace();
            if (process == null) {
                return 0.0f;
            }
        } catch (Throwable th2) {
            if (process != null) {
                process.destroy();
            }
            throw th2;
        }
        process.destroy();
        return 0.0f;
    }

    public float d() {
        if (this.f22838g) {
            this.f22839h = c();
        } else {
            this.f22839h = a();
        }
        return this.f22839h;
    }

    public float f() {
        Debug.MemoryInfo memoryInfo = null;
        float f11 = 0.0f;
        try {
            if (Build.VERSION.SDK_INT > 28) {
                memoryInfo = new Debug.MemoryInfo();
                Debug.getMemoryInfo(memoryInfo);
            } else {
                Debug.MemoryInfo[] processMemoryInfo = ((ActivityManager) ContextUtil.g().getSystemService("activity")).getProcessMemoryInfo(new int[]{Process.myPid()});
                if (processMemoryInfo != null && processMemoryInfo.length > 0) {
                    memoryInfo = processMemoryInfo[0];
                }
            }
            int totalPss = memoryInfo.getTotalPss();
            if (totalPss >= 0) {
                f11 = ((float) totalPss) / 1024.0f;
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        this.f22840i = f11;
        return f11;
    }

    public void g() {
        Context e11 = WoodPeckerSDK.f().e();
        this.f22832a = e11;
        if (this.f22833b != null) {
            this.f22833b = (ActivityManager) e11.getSystemService("activity");
        }
        if (Build.VERSION.SDK_INT >= 26) {
            this.f22838g = true;
        }
    }

    public a() {
    }
}
