package com.mob.tools.b;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.mob.MobSDK;
import com.mob.commons.C0891r;
import com.mob.commons.d;
import com.mob.commons.v;
import com.mob.tools.MobLog;
import com.mob.tools.utils.DH;
import com.mob.tools.utils.ReflectHelper;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

public class j {

    /* renamed from: a  reason: collision with root package name */
    public static volatile IBinder f27890a = null;

    /* renamed from: b  reason: collision with root package name */
    private static int f27891b = 0;

    /* renamed from: c  reason: collision with root package name */
    private static volatile int f27892c = Integer.MIN_VALUE;

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0051 A[Catch:{ all -> 0x0062, all -> 0x0076, all -> 0x0059 }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0055 A[Catch:{ all -> 0x0062, all -> 0x0076, all -> 0x0059 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Set<java.lang.String> a(android.content.Context r4, int r5) {
        /*
            android.os.HandlerThread r0 = new android.os.HandlerThread
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = com.mob.commons.z.f27382a
            r1.append(r2)
            java.lang.String r2 = "XPL-1"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            r0.start()
            r1 = 1
            r2 = 18
            r3 = 0
            if (r5 == r1) goto L_0x0048
            r1 = 4
            if (r5 == r1) goto L_0x0025
            goto L_0x004d
        L_0x0025:
            java.lang.String r5 = "005_ce4eDchfccf"
            java.lang.String r5 = com.mob.commons.C0891r.b(r5)     // Catch:{ all -> 0x0062 }
            com.mob.tools.b.c r1 = com.mob.tools.b.c.a((android.content.Context) r4)     // Catch:{ all -> 0x0062 }
            com.mob.tools.b.a r1 = r1.d()     // Catch:{ all -> 0x0062 }
            java.lang.String r1 = r1.m()     // Catch:{ all -> 0x0062 }
            boolean r5 = r5.equalsIgnoreCase(r1)     // Catch:{ all -> 0x0062 }
            if (r5 != 0) goto L_0x004d
            boolean r5 = a()     // Catch:{ all -> 0x0062 }
            if (r5 == 0) goto L_0x004d
            java.util.Set r4 = a((android.content.Context) r4, (android.os.HandlerThread) r0)     // Catch:{ all -> 0x0062 }
            goto L_0x004c
        L_0x0048:
            java.util.Set r4 = a((android.content.Context) r4, (boolean) r1, (android.os.HandlerThread) r0)     // Catch:{ all -> 0x0062 }
        L_0x004c:
            r3 = r4
        L_0x004d:
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0059 }
            if (r4 < r2) goto L_0x0055
            r0.quitSafely()     // Catch:{ all -> 0x0059 }
            goto L_0x0075
        L_0x0055:
            r0.quit()     // Catch:{ all -> 0x0059 }
            goto L_0x0075
        L_0x0059:
            r4 = move-exception
            com.mob.tools.log.NLog r5 = com.mob.tools.MobLog.getInstance()
            r5.d(r4)
            goto L_0x0075
        L_0x0062:
            r4 = move-exception
            com.mob.tools.log.NLog r5 = com.mob.tools.MobLog.getInstance()     // Catch:{ all -> 0x0076 }
            r5.d(r4)     // Catch:{ all -> 0x0076 }
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0059 }
            if (r4 < r2) goto L_0x0072
            r0.quitSafely()     // Catch:{ all -> 0x0059 }
            goto L_0x0075
        L_0x0072:
            r0.quit()     // Catch:{ all -> 0x0059 }
        L_0x0075:
            return r3
        L_0x0076:
            r4 = move-exception
            int r5 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0083 }
            if (r5 < r2) goto L_0x007f
            r0.quitSafely()     // Catch:{ all -> 0x0083 }
            goto L_0x008b
        L_0x007f:
            r0.quit()     // Catch:{ all -> 0x0083 }
            goto L_0x008b
        L_0x0083:
            r5 = move-exception
            com.mob.tools.log.NLog r0 = com.mob.tools.MobLog.getInstance()
            r0.d(r5)
        L_0x008b:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.b.j.a(android.content.Context, int):java.util.Set");
    }

    private static Parcelable.Creator<?> b() throws Throwable {
        return (Parcelable.Creator) ReflectHelper.getStaticField(ReflectHelper.importClass(C0891r.b("030cdKcbcicjchcbckSbLcjQdhedhEck2iIceckfkTcbFdg%cOdiLeQdd>dJdecj")), C0891r.b("007Idcfifhecebfgfi"));
    }

    private static int c() {
        if (f27892c != Integer.MIN_VALUE) {
            return f27892c;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            try {
                int intValue = ((Integer) ReflectHelper.invokeStaticMethod(ReflectHelper.importClass(C0891r.b("021cdBcbcicjchcbckcjehckdjehAe9ciej0cd:cb;fe")), C0891r.b("009Ndi%eh*djehMeZciddcb"), new Object[]{Integer.valueOf(Process.myUid())}, new Class[]{Integer.TYPE})).intValue();
                f27892c = intValue;
                return intValue;
            } catch (Throwable th2) {
                MobLog.getInstance().d(th2);
            }
        }
        return 0;
    }

    public static Set<String> a(Context context, HandlerThread handlerThread) throws Throwable {
        InputStreamReader inputStreamReader;
        FileInputStream fileInputStream;
        BufferedReader bufferedReader = null;
        if (d.b()) {
            File file = new File(context.getFilesDir(), ".tmp11");
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, C0891r.b("002Dch d") + System.currentTimeMillis());
            File file3 = new File(file, "out" + System.currentTimeMillis());
            File file4 = new File(file, "err" + System.currentTimeMillis());
            if (file3.exists()) {
                file3.delete();
            }
            try {
                a(context, C0891r.b("007icb:dg.c.di>e"), new String[]{C0891r.b("004fXchehUh"), "packages"}, file2, file3, file4, handlerThread);
                if (!file3.exists() || file3.length() <= 0) {
                    v.a(null, null, null);
                    file2.delete();
                    file3.delete();
                    file4.delete();
                } else {
                    HashSet hashSet = new HashSet();
                    fileInputStream = new FileInputStream(file3);
                    try {
                        inputStreamReader = new InputStreamReader(fileInputStream, "utf-8");
                    } catch (Throwable th2) {
                        th = th2;
                        inputStreamReader = null;
                        v.a(bufferedReader, inputStreamReader, fileInputStream);
                        file2.delete();
                        file3.delete();
                        file4.delete();
                        throw th;
                    }
                    try {
                        BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader);
                        try {
                            String b11 = C0891r.b("008icb7dgJcYdiOej");
                            for (String readLine = bufferedReader2.readLine(); readLine != null; readLine = bufferedReader2.readLine()) {
                                String trim = readLine.trim();
                                if (trim.length() > b11.length() && trim.substring(0, b11.length()).equalsIgnoreCase(b11)) {
                                    String trim2 = trim.substring(b11.length()).trim();
                                    if (!TextUtils.isEmpty(trim2)) {
                                        hashSet.add(trim2);
                                    }
                                }
                            }
                            v.a(bufferedReader2, inputStreamReader, fileInputStream);
                            file2.delete();
                            file3.delete();
                            file4.delete();
                            return hashSet;
                        } catch (Throwable th3) {
                            th = th3;
                            bufferedReader = bufferedReader2;
                            v.a(bufferedReader, inputStreamReader, fileInputStream);
                            file2.delete();
                            file3.delete();
                            file4.delete();
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        v.a(bufferedReader, inputStreamReader, fileInputStream);
                        file2.delete();
                        file3.delete();
                        file4.delete();
                        throw th;
                    }
                }
            } catch (Throwable th5) {
                th = th5;
                fileInputStream = null;
                inputStreamReader = null;
                v.a(bufferedReader, inputStreamReader, fileInputStream);
                file2.delete();
                file3.delete();
                file4.delete();
                throw th;
            }
        }
        return null;
    }

    public static Set<String> a(Context context, boolean z11, HandlerThread handlerThread) throws Throwable {
        InputStreamReader inputStreamReader;
        FileInputStream fileInputStream;
        BufferedReader bufferedReader = null;
        if (d.b()) {
            File file = new File(context.getFilesDir(), ".tmp11");
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, C0891r.b("002'ch:d") + System.currentTimeMillis());
            File file3 = new File(file, "out" + System.currentTimeMillis());
            File file4 = new File(file, "err" + System.currentTimeMillis());
            if (file3.exists()) {
                file3.delete();
            }
            if (z11) {
                try {
                    a(context, C0891r.b("007icbAdg_c7di@e"), new String[]{C0891r.b("016Qcdcf4e>cidbgjLcbhWchccchBhPchPe eh"), "-a", C0891r.b("026cdDcbcicjchcbckch$dhedhAckGcbhJchcjEd(ckgbecdddf"), "--user", "0"}, file2, file3, file4, handlerThread);
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = null;
                    inputStreamReader = null;
                    v.a(bufferedReader, inputStreamReader, fileInputStream);
                    file2.delete();
                    file3.delete();
                    file4.delete();
                    throw th;
                }
            } else {
                a(context, C0891r.b("007icbXdg_cDdi2e"), new String[]{C0891r.b("016$cdcfFe%cidbgj[cbh_chccch7h=chBe%eh"), "-a", C0891r.b("026cd5cbcicjchcbckchJdhedh5ckPcbhOchcjSd@ckgbecdddf"), "-c", C0891r.b("032cd4cbcicjchcbckch;dhedhOck0bche>dicjcidbckedecdjdfdcejfhfi"), "--user", "0"}, file2, file3, file4, handlerThread);
            }
            if (!file3.exists() || file3.length() <= 0) {
                v.a(null, null, null);
                file2.delete();
                file3.delete();
                file4.delete();
            } else {
                HashSet hashSet = new HashSet();
                fileInputStream = new FileInputStream(file3);
                try {
                    inputStreamReader = new InputStreamReader(fileInputStream, "utf-8");
                } catch (Throwable th3) {
                    th = th3;
                    inputStreamReader = null;
                    v.a(bufferedReader, inputStreamReader, fileInputStream);
                    file2.delete();
                    file3.delete();
                    file4.delete();
                    throw th;
                }
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader);
                    try {
                        String b11 = C0891r.b("012icb(dg>c)diFeJdf:c)ceWe1hh");
                        for (String readLine = bufferedReader2.readLine(); readLine != null; readLine = bufferedReader2.readLine()) {
                            String trim = readLine.trim();
                            if (trim.length() > b11.length() && trim.substring(0, b11.length()).equalsIgnoreCase(b11)) {
                                String trim2 = trim.substring(b11.length()).trim();
                                if (!TextUtils.isEmpty(trim2)) {
                                    hashSet.add(trim2);
                                }
                            }
                        }
                        v.a(bufferedReader2, inputStreamReader, fileInputStream);
                        file2.delete();
                        file3.delete();
                        file4.delete();
                        return hashSet;
                    } catch (Throwable th4) {
                        th = th4;
                        bufferedReader = bufferedReader2;
                        v.a(bufferedReader, inputStreamReader, fileInputStream);
                        file2.delete();
                        file3.delete();
                        file4.delete();
                        throw th;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    v.a(bufferedReader, inputStreamReader, fileInputStream);
                    file2.delete();
                    file3.delete();
                    file4.delete();
                    throw th;
                }
            }
        }
        return null;
    }

    private static int a(Context context, String str, String[] strArr, File file, File file2, File file3, HandlerThread handlerThread) throws Throwable {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        Object a11;
        FileOutputStream fileOutputStream3 = null;
        try {
            IBinder iBinder = (IBinder) com.mob.tools.a.d.a(context).a(C0891r.b("025cdXcbcicjchcbckcjehckdk.e,ciccch_beTgb)cdc+diRe ci"), (Object) null, C0891r.b("0101diMeh@dkDeCciccch[be"), new Class[]{String.class}, new Object[]{str}, null);
            if (iBinder == null || (a11 = com.mob.tools.a.d.a(context).a(C0891r.b("024cd5cbcicjchcbckcjehckdkIgeff^dc6cff2ee$cb3dg"))) == null) {
                v.a(null, null, null);
                return -1;
            }
            FileOutputStream fileOutputStream4 = new FileOutputStream(file);
            try {
                fileOutputStream2 = new FileOutputStream(file2);
                try {
                    fileOutputStream = new FileOutputStream(file3);
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = null;
                    fileOutputStream3 = fileOutputStream4;
                    v.a(fileOutputStream3, fileOutputStream2, fileOutputStream);
                    throw th;
                }
                try {
                    com.mob.tools.a.d.a(context).a(IBinder.class, (Object) iBinder, C0891r.b("0126ehFgeff'dccjceceAcd]cb"), new Class[]{FileDescriptor.class, FileDescriptor.class, FileDescriptor.class, String[].class, Class.forName(C0891r.b("024cdHcbcicjchcbckcjehckdk9geffBdcHcffGeeZcb7dg")), ResultReceiver.class}, new Object[]{fileOutputStream4.getFD(), fileOutputStream2.getFD(), fileOutputStream.getFD(), strArr, a11, new ResultReceiver(new Handler(handlerThread.getLooper()))}, null);
                    v.a(fileOutputStream4, fileOutputStream2, fileOutputStream);
                    return 0;
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream3 = fileOutputStream4;
                    v.a(fileOutputStream3, fileOutputStream2, fileOutputStream);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream2 = null;
                fileOutputStream = null;
                fileOutputStream3 = fileOutputStream4;
                v.a(fileOutputStream3, fileOutputStream2, fileOutputStream);
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            fileOutputStream2 = null;
            fileOutputStream = null;
            v.a(fileOutputStream3, fileOutputStream2, fileOutputStream);
            throw th;
        }
    }

    public static Object a(Context context, String str, int i11) throws Throwable {
        return a(context, str, i11, c(), a(context));
    }

    private static Object a(Context context, String str, int i11, int i12, int i13) throws Throwable {
        if (Build.VERSION.SDK_INT < 23) {
            return null;
        }
        if (f27890a == null) {
            f27890a = (IBinder) com.mob.tools.a.d.a(context).a(C0891r.b("025cd5cbcicjchcbckcjehckdk,e.ciccchRbe;gbKcdcZdiRe8ci"), (Object) null, C0891r.b("010KdiWeh[dk?e@ciccchAbe"), new Class[]{String.class}, new Object[]{C0891r.b("007icb5dg>cAdi0e")}, null);
        }
        if (f27890a == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(C0891r.b("034cd6cbcicjchcbck]bVcj]dhedh?ck7i@ceckddfk>cb6dg]c)di*e4gbAcdcFdi3e+ci"));
            obtain.writeString(str);
            obtain.writeInt(i11);
            obtain.writeInt(i12);
            f27890a.transact(i13, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readTypedObject(b());
        } finally {
            obtain2.recycle();
            obtain.recycle();
            com.mob.tools.a.d.a(context).b(context);
        }
    }

    private static int a(Context context) throws Throwable {
        int i11 = f27891b;
        if (i11 != 0) {
            return i11;
        }
        String b11 = C0891r.b("034cd=cbcicjchcbckMb2cjSdhedhUck'i1ceckddfkRcbMdg(c4di3eKgb9cdc]di[eSci");
        String b12 = C0891r.b("004:dkTh3cfee");
        int intValue = ((Integer) com.mob.tools.a.d.a(context).a(b11 + "$" + b12, C0891r.b("026;ebfiecdfdkecdcebddfgdfcgdi(eh'fkCcb3dg<c1di$e8dd0d)decj"), (Object) null, 0)).intValue();
        f27891b = intValue;
        return intValue;
    }

    public static boolean a() {
        try {
            if (!C0891r.b("006g2cf4cNef_eHch").equalsIgnoreCase(DH.SyncMtd.getManufacturer())) {
                return true;
            }
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            final int[] iArr = new int[1];
            DH.requester(MobSDK.getContext()).getHmOsDetailedVer().request(new DH.DHResponder() {
                public void onResponse(DH.DHResponse dHResponse) {
                    String hmOsDetailedVer = dHResponse.getHmOsDetailedVer();
                    if (hmOsDetailedVer == null) {
                        hmOsDetailedVer = "";
                    }
                    iArr[0] = "3.0.0.200".compareTo(hmOsDetailedVer);
                    countDownLatch.countDown();
                }
            });
            countDownLatch.await();
            if (iArr[0] <= 0) {
                return false;
            }
            return true;
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
            return true;
        }
    }
}
