package com.mob.commons;

import android.content.ContentValues;
import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import android.util.SparseArray;
import com.huobi.vulcan.model.VulcanInfo;
import com.jumio.core.cdn.CDNDownload;
import com.jumio.sdk.reject.JumioRejectReason;
import com.mob.MobSDK;
import com.mob.commons.a.l;
import com.mob.tools.MDP;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.network.NetCommunicator;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.DH;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.FileLocker;
import com.mob.tools.utils.FileUtils;
import com.mob.tools.utils.HashonHelper;
import com.mob.tools.utils.ResHelper;
import com.mob.tools.utils.SQLiteHelper;
import com.mob.tools.utils.e;
import java.io.File;
import java.io.FileFilter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private static c f27102a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static volatile SQLiteHelper.SingleTableDB f27103b;

    public static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private static final a[] f27114a = new a[3];
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public long f27115b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public HashMap<String, Object> f27116c;

        private a(long j11, HashMap<String, Object> hashMap) {
            this.f27115b = j11;
            this.f27116c = hashMap;
        }

        public void run() {
            try {
                p.a(p.a(p.f27289b), new o() {
                    public boolean a(FileLocker fileLocker) {
                        DH.requester(MobSDK.getContext()).getDetailNetworkTypeForStatic().request(new DH.DHResponder() {
                            public void onResponse(DH.DHResponse dHResponse) throws Throwable {
                                b a11;
                                ContentValues contentValues = new ContentValues();
                                contentValues.put(C0891r.b("004h)chceXe"), String.valueOf(a.this.f27115b));
                                if (a.this.f27116c != null) {
                                    a.this.f27116c.put(C0891r.b("006ciiZdg2eOdb"), u.a());
                                    a.this.f27116c.put(C0891r.b("006ciiiBdgdi"), DH.SyncMtd.getPackageName());
                                    a.this.f27116c.put(C0891r.b("006cii7cc?e;ci"), DH.SyncMtd.getAppVersionName());
                                    long longValue = ((Long) b.a(C0891r.b("010Jeh@hYci@cheUdidbddcb"), 0L)).longValue();
                                    if (longValue != 0) {
                                        a.this.f27116c.put(C0891r.b("010Beh-hWci'cheBdidbddcb"), Long.valueOf(longValue));
                                    }
                                }
                                contentValues.put(C0891r.b("004CcbGchc"), Base64.encodeToString(Data.AES128Encode(Data.rawMD5(DH.SyncMtd.getManufacturer()), HashonHelper.fromHashMap(a.this.f27116c).getBytes("utf-8")), 2));
                                SQLiteHelper.insert(c.f27103b, contentValues);
                                long longValue2 = ((Long) b.a(C0891r.b("004Icb0e5cfJi"), 2L)).longValue();
                                if (C0891r.b("004d:cj$de").equals(dHResponse.getDetailNetworkTypeForStatic())) {
                                    longValue2 = 120;
                                }
                                if (b.c() && (a11 = b.b()) != null) {
                                    if (longValue2 <= 0) {
                                        a11.run();
                                    } else if (!l.a().a(longValue2, (Runnable) a11)) {
                                        a11.c();
                                    }
                                }
                            }
                        });
                        return false;
                    }
                });
            } catch (Throwable th2) {
                a();
                throw th2;
            }
            a();
        }

        /* access modifiers changed from: private */
        public static a b(long j11, HashMap<String, Object> hashMap) {
            a[] aVarArr = f27114a;
            synchronized (aVarArr) {
                for (int i11 = 0; i11 < 3; i11++) {
                    a aVar = aVarArr[i11];
                    if (aVar != null) {
                        aVar.f27115b = j11;
                        HashMap<String, Object> hashMap2 = aVar.f27116c;
                        if (hashMap2 != null) {
                            hashMap2.clear();
                        }
                        aVar.f27116c = hashMap;
                        aVarArr[i11] = null;
                        return aVar;
                    }
                }
                a aVar2 = new a(j11, hashMap);
                return aVar2;
            }
        }

        private void a() {
            try {
                a[] aVarArr = f27114a;
                synchronized (aVarArr) {
                    for (int i11 = 0; i11 < 3; i11++) {
                        if (aVarArr[i11] == null) {
                            this.f27115b = 0;
                            HashMap<String, Object> hashMap = this.f27116c;
                            if (hashMap != null) {
                                hashMap.clear();
                            }
                            this.f27116c = null;
                            aVarArr[i11] = this;
                            return;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    private c() {
        try {
            Context context = MobSDK.getContext();
            String str = m.f27278a;
            File dataCacheFile = ResHelper.getDataCacheFile(context, str, true);
            if (dataCacheFile.exists() && dataCacheFile.length() > 209715200) {
                dataCacheFile.delete();
                dataCacheFile = ResHelper.getDataCacheFile(MobSDK.getContext(), str, true);
            }
            String absolutePath = dataCacheFile.getAbsolutePath();
            f27103b = SQLiteHelper.getDatabase(absolutePath, C0891r.b("008OekBchcSejKeci") + "_" + 1);
            f27103b.addField(C0891r.b("004h:chceOe"), C0891r.b("004heTdh<h"), true);
            f27103b.addField(C0891r.b("004?cb2chc"), C0891r.b("004heNdh]h"), true);
            b a11 = b.b();
            if (a11 != null) {
                l.a().a(0, 180, a11);
            }
        } catch (Throwable th2) {
            MobLog.getInstance().w(th2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x008d A[SYNTHETIC, Splitter:B:27:0x008d] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0131  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.io.File b(java.lang.Object... r14) throws java.lang.Throwable {
        /*
            r0 = 0
            r1 = r14[r0]
            java.lang.String r1 = (java.lang.String) r1
            r2 = 1
            r3 = r14[r2]
            java.lang.String r3 = (java.lang.String) r3
            r4 = 4
            r5 = r14[r4]
            java.lang.String r5 = (java.lang.String) r5
            r6 = 5
            r6 = r14[r6]
            java.lang.String r6 = (java.lang.String) r6
            boolean r7 = android.text.TextUtils.isEmpty(r1)
            r8 = 0
            if (r7 != 0) goto L_0x0145
            boolean r7 = android.text.TextUtils.isEmpty(r3)
            if (r7 != 0) goto L_0x0145
            java.io.File r7 = new java.io.File     // Catch:{ all -> 0x013c }
            android.content.Context r9 = com.mob.MobSDK.getContext()     // Catch:{ all -> 0x013c }
            java.io.File r9 = r9.getFilesDir()     // Catch:{ all -> 0x013c }
            java.lang.String r10 = "003Aeh<bb"
            java.lang.String r10 = com.mob.commons.C0891r.b(r10)     // Catch:{ all -> 0x013c }
            r7.<init>(r9, r10)     // Catch:{ all -> 0x013c }
            r9 = 2
            r10 = r14[r9]     // Catch:{ all -> 0x013c }
            byte[] r10 = (byte[]) r10     // Catch:{ all -> 0x013c }
            r11 = 3
            r14 = r14[r11]     // Catch:{ all -> 0x0045 }
            java.lang.String r14 = java.lang.String.valueOf(r14)     // Catch:{ all -> 0x0045 }
            int r14 = java.lang.Integer.parseInt(r14)     // Catch:{ all -> 0x0045 }
            goto L_0x0046
        L_0x0045:
            r14 = r0
        L_0x0046:
            if (r10 == 0) goto L_0x005d
            if (r14 <= 0) goto L_0x005d
            int r11 = r10.length     // Catch:{ all -> 0x013c }
            if (r11 < r14) goto L_0x005d
            java.lang.String r11 = com.mob.tools.utils.Data.MD5(r10, r0, r14)     // Catch:{ all -> 0x013c }
            boolean r11 = r1.equals(r11)     // Catch:{ all -> 0x013c }
            if (r11 == 0) goto L_0x005d
            java.io.ByteArrayInputStream r11 = new java.io.ByteArrayInputStream     // Catch:{ all -> 0x013c }
            r11.<init>(r10, r0, r14)     // Catch:{ all -> 0x013c }
            goto L_0x008b
        L_0x005d:
            java.io.File r14 = new java.io.File     // Catch:{ all -> 0x013c }
            java.lang.String r10 = "008b!cjYdVdeckeh_bb"
            java.lang.String r10 = com.mob.commons.C0891r.b(r10)     // Catch:{ all -> 0x013c }
            r14.<init>(r7, r10)     // Catch:{ all -> 0x013c }
            boolean r10 = r14.exists()     // Catch:{ all -> 0x013c }
            if (r10 == 0) goto L_0x007e
            java.lang.String r10 = com.mob.tools.utils.Data.MD5((java.io.File) r14)     // Catch:{ all -> 0x013c }
            boolean r10 = r1.equals(r10)     // Catch:{ all -> 0x013c }
            if (r10 == 0) goto L_0x007e
            java.io.FileInputStream r11 = new java.io.FileInputStream     // Catch:{ all -> 0x013c }
            r11.<init>(r14)     // Catch:{ all -> 0x013c }
            goto L_0x008b
        L_0x007e:
            com.mob.commons.h r10 = com.mob.commons.h.a()     // Catch:{ all -> 0x013c }
            r11 = 20
            r10.a((int) r11)     // Catch:{ all -> 0x013c }
            r14.delete()     // Catch:{ all -> 0x013c }
            r11 = r8
        L_0x008b:
            if (r11 == 0) goto L_0x0131
            java.io.File r14 = new java.io.File     // Catch:{ all -> 0x012e }
            long r12 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x012e }
            java.lang.String r10 = java.lang.String.valueOf(r12)     // Catch:{ all -> 0x012e }
            r14.<init>(r7, r10)     // Catch:{ all -> 0x012e }
            boolean r7 = r14.exists()     // Catch:{ all -> 0x012e }
            if (r7 != 0) goto L_0x00a3
            r14.mkdirs()     // Catch:{ all -> 0x012e }
        L_0x00a3:
            java.io.File r7 = new java.io.File     // Catch:{ all -> 0x012e }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x012e }
            r10.<init>()     // Catch:{ all -> 0x012e }
            java.lang.String r12 = r14.getName()     // Catch:{ all -> 0x012e }
            r10.append(r12)     // Catch:{ all -> 0x012e }
            java.lang.String r12 = "004:ckfcch<i"
            java.lang.String r12 = com.mob.commons.C0891r.b(r12)     // Catch:{ all -> 0x012e }
            r10.append(r12)     // Catch:{ all -> 0x012e }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x012e }
            r7.<init>(r14, r10)     // Catch:{ all -> 0x012e }
            java.io.FileOutputStream r10 = new java.io.FileOutputStream     // Catch:{ all -> 0x0122 }
            r10.<init>(r7)     // Catch:{ all -> 0x0122 }
            com.mob.tools.utils.Data.AES128Decode((java.lang.String) r3, (java.io.InputStream) r11, (java.io.OutputStream) r10)     // Catch:{ all -> 0x0120 }
            java.io.Closeable[] r3 = new java.io.Closeable[r9]     // Catch:{ all -> 0x012e }
            r3[r0] = r11     // Catch:{ all -> 0x012e }
            r3[r2] = r10     // Catch:{ all -> 0x012e }
            com.mob.commons.v.a((java.io.Closeable[]) r3)     // Catch:{ all -> 0x012e }
            com.mob.commons.j r3 = com.mob.commons.j.a()     // Catch:{ all -> 0x00ff }
            boolean r3 = r3.b()     // Catch:{ all -> 0x00ff }
            if (r3 != 0) goto L_0x00e6
            com.mob.commons.h r1 = com.mob.commons.h.a()     // Catch:{ all -> 0x00ff }
            r3 = 19
            r1.a((int) r3)     // Catch:{ all -> 0x00ff }
            goto L_0x00f2
        L_0x00e6:
            com.mob.commons.h r3 = com.mob.commons.h.a()     // Catch:{ all -> 0x00ff }
            r9 = 14
            r3.a((int) r9)     // Catch:{ all -> 0x00ff }
            com.mob.commons.a.c.a((java.lang.String) r1, (java.io.File) r7, (java.lang.String) r5, (java.lang.String) r6)     // Catch:{ all -> 0x00ff }
        L_0x00f2:
            com.mob.tools.utils.ResHelper.deleteFileAndFolder(r14)     // Catch:{ all -> 0x00f6 }
            goto L_0x0133
        L_0x00f6:
            r1 = move-exception
            com.mob.commons.h r3 = com.mob.commons.h.a()     // Catch:{ all -> 0x013c }
        L_0x00fb:
            r3.a((int) r4, (java.lang.Throwable) r1)     // Catch:{ all -> 0x013c }
            goto L_0x0133
        L_0x00ff:
            r1 = move-exception
            com.mob.commons.h r3 = com.mob.commons.h.a()     // Catch:{ all -> 0x0112 }
            r5 = 6
            r3.a((int) r5, (java.lang.Throwable) r1)     // Catch:{ all -> 0x0112 }
            com.mob.tools.utils.ResHelper.deleteFileAndFolder(r14)     // Catch:{ all -> 0x010c }
            goto L_0x0133
        L_0x010c:
            r1 = move-exception
            com.mob.commons.h r3 = com.mob.commons.h.a()     // Catch:{ all -> 0x013c }
            goto L_0x00fb
        L_0x0112:
            r1 = move-exception
            com.mob.tools.utils.ResHelper.deleteFileAndFolder(r14)     // Catch:{ all -> 0x0117 }
            goto L_0x011f
        L_0x0117:
            r14 = move-exception
            com.mob.commons.h r3 = com.mob.commons.h.a()     // Catch:{ all -> 0x013c }
            r3.a((int) r4, (java.lang.Throwable) r14)     // Catch:{ all -> 0x013c }
        L_0x011f:
            throw r1     // Catch:{ all -> 0x013c }
        L_0x0120:
            r14 = move-exception
            goto L_0x0124
        L_0x0122:
            r14 = move-exception
            r10 = r8
        L_0x0124:
            java.io.Closeable[] r1 = new java.io.Closeable[r9]     // Catch:{ all -> 0x012e }
            r1[r0] = r11     // Catch:{ all -> 0x012e }
            r1[r2] = r10     // Catch:{ all -> 0x012e }
            com.mob.commons.v.a((java.io.Closeable[]) r1)     // Catch:{ all -> 0x012e }
            throw r14     // Catch:{ all -> 0x013c }
        L_0x012e:
            r14 = move-exception
            r8 = r11
            goto L_0x013d
        L_0x0131:
            r14 = r8
            r8 = r11
        L_0x0133:
            java.io.Closeable[] r1 = new java.io.Closeable[r2]
            r1[r0] = r8
            com.mob.commons.v.a((java.io.Closeable[]) r1)
            r8 = r14
            goto L_0x0145
        L_0x013c:
            r14 = move-exception
        L_0x013d:
            java.io.Closeable[] r1 = new java.io.Closeable[r2]
            r1[r0] = r8
            com.mob.commons.v.a((java.io.Closeable[]) r1)
            throw r14
        L_0x0145:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.commons.c.b(java.lang.Object[]):java.io.File");
    }

    public static synchronized c a() {
        c cVar;
        synchronized (c.class) {
            if (f27102a == null) {
                f27102a = new c();
            }
            cVar = f27102a;
        }
        return cVar;
    }

    public static class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private static final b[] f27119b;

        /* renamed from: a  reason: collision with root package name */
        public boolean f27120a = false;

        static {
            b[] bVarArr = new b[1];
            f27119b = bVarArr;
            bVarArr[0] = new b();
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0012, code lost:
            return r2;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static com.mob.commons.c.b b() {
            /*
                com.mob.commons.c$b[] r0 = f27119b
                monitor-enter(r0)
                r1 = 0
                r2 = r0[r1]     // Catch:{ all -> 0x0015 }
                r3 = 0
                if (r2 == 0) goto L_0x0013
                r0[r1] = r3     // Catch:{ all -> 0x0015 }
                boolean r3 = r2.f27120a     // Catch:{ all -> 0x0015 }
                if (r3 == 0) goto L_0x0011
                r2.f27120a = r1     // Catch:{ all -> 0x0015 }
            L_0x0011:
                monitor-exit(r0)     // Catch:{ all -> 0x0015 }
                return r2
            L_0x0013:
                monitor-exit(r0)     // Catch:{ all -> 0x0015 }
                return r3
            L_0x0015:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0015 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mob.commons.c.b.b():com.mob.commons.c$b");
        }

        /* access modifiers changed from: private */
        public void c() {
            b[] bVarArr = f27119b;
            synchronized (bVarArr) {
                if (bVarArr[0] == null) {
                    bVarArr[0] = this;
                }
            }
            this.f27120a = false;
        }

        public void run() {
            DH.requester(MobSDK.getContext()).getDeviceKey().getDetailNetworkTypeForStatic().getDataNtType().request(new DH.DHResponder() {
                public void onResponse(DH.DHResponse dHResponse) {
                    try {
                        String[][] strArr = new String[50][];
                        int a11 = b.this.a(strArr);
                        while (true) {
                            if (a11 <= 0) {
                                break;
                            }
                            SparseArray a12 = b.this.a(strArr, a11, dHResponse);
                            if (a12.size() == 0 && b.this.f27120a) {
                                l.a().d();
                                break;
                            }
                            if (a12.size() > 0) {
                                int unused = b.this.a((SparseArray<String>) a12);
                            }
                            if (a11 < 50) {
                                break;
                            }
                            a11 = b.this.a(strArr);
                        }
                    } finally {
                        b.this.c();
                    }
                }
            });
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x0051 A[SYNTHETIC, Splitter:B:27:0x0051] */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x006f A[SYNTHETIC, Splitter:B:41:0x006f] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int a(java.lang.String[][] r12) {
            /*
                r11 = this;
                r0 = 2
                r1 = 0
                r2 = 0
                java.lang.String[] r3 = new java.lang.String[r0]     // Catch:{ all -> 0x0065 }
                java.lang.String r4 = "004h[chceUe"
                java.lang.String r4 = com.mob.commons.C0891r.b(r4)     // Catch:{ all -> 0x0065 }
                r3[r2] = r4     // Catch:{ all -> 0x0065 }
                java.lang.String r4 = "004=cb6chc"
                java.lang.String r4 = com.mob.commons.C0891r.b(r4)     // Catch:{ all -> 0x0065 }
                r5 = 1
                r3[r5] = r4     // Catch:{ all -> 0x0065 }
                java.lang.String r4 = "time desc"
                com.mob.tools.utils.SQLiteHelper$SingleTableDB r6 = com.mob.commons.c.f27103b     // Catch:{ all -> 0x0065 }
                android.database.Cursor r1 = com.mob.tools.utils.SQLiteHelper.query(r6, r3, r1, r1, r4)     // Catch:{ all -> 0x0065 }
                if (r1 != 0) goto L_0x0028
                if (r1 == 0) goto L_0x0027
                r1.close()     // Catch:{ all -> 0x0027 }
            L_0x0027:
                return r2
            L_0x0028:
                boolean r3 = r1.moveToFirst()     // Catch:{ all -> 0x0065 }
                if (r3 != 0) goto L_0x0032
                r1.close()     // Catch:{ all -> 0x0031 }
            L_0x0031:
                return r2
            L_0x0032:
                long r3 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0065 }
                r6 = r2
            L_0x0037:
                java.lang.String[] r7 = new java.lang.String[r0]     // Catch:{ all -> 0x0062 }
                java.lang.String r8 = r1.getString(r2)     // Catch:{ all -> 0x0062 }
                r7[r2] = r8     // Catch:{ all -> 0x0062 }
                java.lang.String r8 = r1.getString(r5)     // Catch:{ all -> 0x0062 }
                r7[r5] = r8     // Catch:{ all -> 0x0062 }
                r8 = -1
                r10 = r7[r2]     // Catch:{ all -> 0x004d }
                long r8 = java.lang.Long.parseLong(r10)     // Catch:{ all -> 0x004d }
            L_0x004d:
                int r8 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
                if (r8 > 0) goto L_0x0055
                r12[r6] = r7     // Catch:{ all -> 0x0062 }
                int r6 = r6 + 1
            L_0x0055:
                int r7 = r12.length     // Catch:{ all -> 0x0062 }
                if (r6 >= r7) goto L_0x005e
                boolean r7 = r1.moveToNext()     // Catch:{ all -> 0x0062 }
                if (r7 != 0) goto L_0x0037
            L_0x005e:
                r1.close()     // Catch:{ all -> 0x0073 }
                goto L_0x0073
            L_0x0062:
                r12 = move-exception
                r2 = r6
                goto L_0x0066
            L_0x0065:
                r12 = move-exception
            L_0x0066:
                com.mob.tools.log.NLog r0 = com.mob.tools.MobLog.getInstance()     // Catch:{ all -> 0x0074 }
                r0.w((java.lang.Throwable) r12)     // Catch:{ all -> 0x0074 }
                if (r1 == 0) goto L_0x0072
                r1.close()     // Catch:{ all -> 0x0072 }
            L_0x0072:
                r6 = r2
            L_0x0073:
                return r6
            L_0x0074:
                r12 = move-exception
                if (r1 == 0) goto L_0x007a
                r1.close()     // Catch:{ all -> 0x007a }
            L_0x007a:
                throw r12
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mob.commons.c.b.a(java.lang.String[][]):int");
        }

        /* access modifiers changed from: private */
        public int a(SparseArray<String> sparseArray) {
            StringBuilder sb2;
            try {
                sb2 = new StringBuilder();
                int size = sparseArray.size();
                for (int i11 = 0; i11 < size; i11++) {
                    if (sb2.length() > 0) {
                        sb2.append(", ");
                    }
                    sb2.append('\'');
                    sb2.append(sparseArray.valueAt(i11));
                    sb2.append('\'');
                }
                return SQLiteHelper.delete(c.f27103b, "time in (" + sb2.toString() + ")", (String[]) null);
            } catch (Throwable th2) {
                MobLog.getInstance().w(th2);
                return 0;
            }
        }

        /* access modifiers changed from: private */
        public SparseArray<String> a(String[][] strArr, int i11, DH.DHResponse dHResponse) {
            SparseArray<String> sparseArray = new SparseArray<>();
            try {
                HashMap hashMap = new HashMap();
                hashMap.put(C0891r.b("004ifch"), Integer.valueOf(DH.SyncMtd.getPlatformCode()));
                hashMap.put(C0891r.b("006,cb]e(ccch6be"), dHResponse.getDeviceKey());
                hashMap.put(C0891r.b("005Ececjcb-ef"), DH.SyncMtd.getModel());
                hashMap.put(C0891r.b("004Lcbcfchcb"), e.a((MobProduct) null));
                hashMap.put(C0891r.b("011deh$efcjcidgUhMdb<ie"), dHResponse.getDetailNetworkTypeForStatic());
                hashMap.put(C0891r.b("015.cbAchcZdf=eh)efcjcidgebdb]ie"), Integer.valueOf(dHResponse.getDataNtType()));
                ArrayList arrayList = new ArrayList();
                byte[] rawMD5 = Data.rawMD5(DH.SyncMtd.getManufacturer());
                for (int i12 = 0; i12 < i11; i12++) {
                    String[] strArr2 = strArr[i12];
                    HashMap fromJson = HashonHelper.fromJson(new String(Data.AES128Decode(rawMD5, Base64.decode(strArr2[1], 2)), "utf-8").trim());
                    sparseArray.put(i12, strArr2[0]);
                    arrayList.add(fromJson);
                }
                if (arrayList.isEmpty()) {
                    return new SparseArray<>();
                }
                hashMap.put(C0891r.b("005'cb:chcXeh"), arrayList);
                hashMap.put(C0891r.b("005hTcjdgVed"), ac.a().b());
                HashMap hashMap2 = new HashMap();
                hashMap2.put(C0891r.b("013Zdjeh]e]cigjddcbNedh9ch_hGdb"), aa.c());
                hashMap2.put(C0891r.b("004Ocecjchcb"), com.mob.tools.b.c.a(MobSDK.getContext()).d().ai());
                NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
                networkTimeOut.readTimout = CDNDownload.DEFAULT_TIMEOUT;
                networkTimeOut.connectionTimeout = CDNDownload.DEFAULT_TIMEOUT;
                if (!JumioRejectReason.NOT_READABLE.equals(String.valueOf(HashonHelper.fromJson((String) new NetCommunicator(1024, "ceeef5035212dfe7c6a0acdc0ef35ce5b118aab916477037d7381f85c6b6176fcf57b1d1c3296af0bb1c483fe5e1eb0ce9eb2953b44e494ca60777a1b033cc07", "191737288d17e660c4b61440d5d14228a0bf9854499f9d68d8274db55d6d954489371ecf314f26bec236e58fac7fffa9b27bcf923e1229c4080d49f7758739e5bd6014383ed2a75ce1be9b0ab22f283c5c5e11216c5658ba444212b6270d629f2d615b8dfdec8545fb7d4f935b0cc10b6948ab4fc1cb1dd496a8f94b51e888dd", networkTimeOut).requestWithoutEncode(false, hashMap2, hashMap, i.a().a("gclg") + "/v6/gcl", false)).get(C0891r.b("006>eh>hch-cfeh"))))) {
                    sparseArray.clear();
                }
                return sparseArray;
            } catch (Throwable th2) {
                MobLog.getInstance().w(th2);
            }
        }
    }

    public void a(long j11, HashMap<String, Object> hashMap) {
        boolean a11 = b.a();
        NLog instance = MobLog.getInstance();
        instance.d("DH PD: " + hashMap.get(C0891r.b("004h)dbMie")) + ", to: " + a11, new Object[0]);
        if (a11) {
            z.f27385d.execute(a.b(j11, hashMap));
        }
    }

    public static void a(Object... objArr) {
        try {
            h.a().a(13);
            ResHelper.deleteFileAndFolder(b(objArr));
        } catch (Throwable th2) {
            h.a().a(4, th2);
        }
    }

    public static void a(final ArrayList<HashMap<String, Object>> arrayList, final e<Void> eVar) throws Throwable {
        if (arrayList == null || arrayList.isEmpty()) {
            eVar.a(null);
        } else {
            DH.requester(MobSDK.getContext()).getDeviceKey().getMIUIVersion().getAdvertisingID().request(new DH.DHResponder() {
                public void onResponse(DH.DHResponse dHResponse) {
                    HashMap hashMap;
                    try {
                        File file = new File(MobSDK.getContext().getFilesDir(), C0891r.b("0035ehee$f"));
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        final ArrayList arrayList = new ArrayList();
                        Iterator it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            hashMap = (HashMap) it2.next();
                            Boolean bool = (Boolean) hashMap.get(C0891r.b("002cTeh"));
                            boolean z11 = false;
                            if (bool != null) {
                                z11 = bool.booleanValue();
                            }
                            boolean z12 = z11;
                            String str = (String) hashMap.get(C0891r.b("002(deCf"));
                            String str2 = (String) hashMap.get("m");
                            String str3 = (String) hashMap.get("args");
                            Object obj = hashMap.get(C0891r.b("002Hchcb"));
                            if (!TextUtils.isEmpty(str2)) {
                                if (!TextUtils.isEmpty(str)) {
                                    String a11 = e.a((MobProduct) null);
                                    HashMap hashMap2 = new HashMap();
                                    hashMap2.put(C0891r.b("004[cbcfchcb"), a11);
                                    hashMap2.put(C0891r.b("005hOcjdg*ed"), ac.a().b());
                                    hashMap2.put(C0891r.b("004Ucecjchcb"), com.mob.tools.b.c.a(MobSDK.getContext()).d().ah());
                                    hashMap2.put(C0891r.b("010Yehcbdgfj8e%ciehchcjPd"), Integer.valueOf(MobSDK.SDK_VERSION_CODE));
                                    hashMap2.put(C0891r.b("006ciiDdg_eUdb"), u.a());
                                    hashMap2.put(C0891r.b("009ciiQdkOeb8ciSeh"), MobSDK.getAppSecret());
                                    hashMap2.put(C0891r.b("006Kcbcjce7cXchId"), MobSDK.getDomain().getDomain());
                                    hashMap2.put(C0891r.b("010Jdecjci!beFejVhhi?eh"), Boolean.valueOf(MobSDK.checkForceHttps()));
                                    hashMap2.put(C0891r.b("009!decjciYbe dd;i.ccgg"), Boolean.valueOf(MobSDK.checkV6()));
                                    hashMap2.put(C0891r.b("004ebe4dh"), Long.valueOf(((Long) b.a(C0891r.b("004ebe6dh"), 5L)).longValue()));
                                    hashMap2.put(C0891r.b("002b2cb"), (String) b.a(C0891r.b("002b1cb"), C0891r.b("006Tgdgdgegegege")));
                                    hashMap2.put("usridt", aa.e());
                                    hashMap2.put(C0891r.b("002Mchcb"), obj);
                                    if (!TextUtils.isEmpty(str3)) {
                                        hashMap2.put("args", HashonHelper.fromJson(str3));
                                    }
                                    hashMap2.put(C0891r.b("008Ucb*e5ccchQbe]ddcb"), dHResponse.getDeviceKey());
                                    hashMap2.put(VulcanInfo.IMEI, (Object) null);
                                    hashMap2.put(VulcanInfo.IMSI, (Object) null);
                                    hashMap2.put("sno", (Object) null);
                                    hashMap2.put("ssno", (Object) null);
                                    hashMap2.put("miui", dHResponse.getMIUIVersion());
                                    hashMap2.put(C0891r.b("005<cecjcbAef"), DH.SyncMtd.getModel());
                                    hashMap2.put(C0891r.b("007%de_cbhJcjcidb"), DH.SyncMtd.getManufacturer());
                                    hashMap2.put(C0891r.b("005@eeci=cd_cb"), DH.SyncMtd.getBrand());
                                    hashMap2.put(C0891r.b("005c$cbehchcb"), dHResponse.getAdvertisingID());
                                    hashMap2.put(C0891r.b("006cii(cc@eKci"), DH.SyncMtd.getAppVersionName());
                                    hashMap2.put("appVerCode", Integer.valueOf(DH.SyncMtd.getAppVersion()));
                                    hashMap2.put(C0891r.b("011icb1dgPc]diGeTdf$cZceNe"), DH.SyncMtd.getPackageName());
                                    hashMap2.put(C0891r.b("005]eeehehchcb"), (Object) null);
                                    hashMap2.put("osint", Integer.valueOf(DH.SyncMtd.getOSVersionInt()));
                                    hashMap2.put("osname", DH.SyncMtd.getOSVersionName());
                                    hashMap2.put("mdpName", MDP.class.getName());
                                    String fromHashMap = HashonHelper.fromHashMap(hashMap2);
                                    String checkHttpRequestUrl = NetCommunicator.checkHttpRequestUrl(str);
                                    if (!TextUtils.isEmpty(str2)) {
                                        File file2 = new File(file, str2);
                                        if (z12) {
                                            arrayList.add(file2.getAbsolutePath());
                                        }
                                        c.b(String.valueOf(obj), file2, z12, checkHttpRequestUrl, str2, fromHashMap);
                                    }
                                }
                            }
                        }
                        FileUtils.deleteFilesInDirWithFilter(file, new FileFilter() {
                            public boolean accept(File file) {
                                return !arrayList.contains(file.getAbsolutePath());
                            }
                        });
                    } catch (Throwable th2) {
                        try {
                            g.a().a(2, -1, th2, "-1");
                            MobLog.getInstance().d(th2);
                        } catch (Throwable th3) {
                            eVar.a(null);
                            throw th3;
                        }
                    }
                    eVar.a(null);
                }
            });
        }
    }

    public static String a(int[] iArr) {
        StringBuilder sb2 = new StringBuilder();
        for (int i11 = 0; i11 < iArr.length; i11++) {
            String f11 = x.f();
            if (iArr[i11] < f11.length()) {
                sb2.append((char) (f11.charAt(iArr[i11]) - 2));
            }
        }
        return sb2.toString();
    }

    /* access modifiers changed from: private */
    public static void b(String str, File file, boolean z11, String str2, String str3, String str4) {
        final boolean z12 = z11;
        final File file2 = file;
        final String str5 = str3;
        final String str6 = str2;
        final String str7 = str;
        final String str8 = str4;
        new Thread(new Runnable() {
            /* JADX WARNING: Code restructure failed: missing block: B:73:0x0143, code lost:
                r3 = th;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:74:0x0144, code lost:
                r8 = r2;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:78:0x014f, code lost:
                r2 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:79:0x0150, code lost:
                r12 = r2;
                r2 = r0;
                r0 = r12;
             */
            /* JADX WARNING: Exception block dominator not found, dom blocks: [B:29:0x0087, B:65:0x010c] */
            /* JADX WARNING: Removed duplicated region for block: B:45:0x00d0 A[SYNTHETIC, Splitter:B:45:0x00d0] */
            /* JADX WARNING: Removed duplicated region for block: B:49:0x00e6 A[SYNTHETIC, Splitter:B:49:0x00e6] */
            /* JADX WARNING: Unknown top exception splitter block from list: {B:49:0x00e6=Splitter:B:49:0x00e6, B:33:0x009e=Splitter:B:33:0x009e} */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r13 = this;
                    r0 = 7
                    r1 = 5
                    r2 = 13
                    boolean r3 = r2     // Catch:{ all -> 0x0154 }
                    r4 = 15000(0x3a98, float:2.102E-41)
                    r5 = 60000(0xea60, float:8.4078E-41)
                    r6 = 0
                    r7 = 1
                    r8 = 0
                    if (r3 == 0) goto L_0x00f8
                    java.io.File r2 = r3     // Catch:{ all -> 0x00f5 }
                    boolean r2 = r2.exists()     // Catch:{ all -> 0x00f5 }
                    if (r2 == 0) goto L_0x003e
                    java.lang.String r2 = r4     // Catch:{ all -> 0x00f5 }
                    java.io.File r3 = r3     // Catch:{ all -> 0x00f5 }
                    java.lang.String r3 = com.mob.tools.utils.Data.MD5((java.io.File) r3)     // Catch:{ all -> 0x00f5 }
                    boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x00f5 }
                    if (r2 != 0) goto L_0x0027
                    goto L_0x003e
                L_0x0027:
                    java.lang.String r0 = r6     // Catch:{ all -> 0x00f5 }
                    java.io.File r2 = r3     // Catch:{ all -> 0x00f5 }
                    java.lang.String r2 = r2.getAbsolutePath()     // Catch:{ all -> 0x00f5 }
                    java.lang.String r3 = r7     // Catch:{ all -> 0x00f5 }
                    boolean r0 = com.mob.commons.c.b(r0, r1, r2, r8, r3)     // Catch:{ all -> 0x00f5 }
                    if (r0 != 0) goto L_0x0165
                    java.io.File r0 = r3     // Catch:{ all -> 0x00f5 }
                    r0.delete()     // Catch:{ all -> 0x00f5 }
                    goto L_0x0165
                L_0x003e:
                    r2 = 6
                    java.io.File r3 = r3     // Catch:{ all -> 0x0154 }
                    boolean r3 = r3.exists()     // Catch:{ all -> 0x0154 }
                    if (r3 == 0) goto L_0x004c
                    java.io.File r3 = r3     // Catch:{ all -> 0x0154 }
                    r3.delete()     // Catch:{ all -> 0x0154 }
                L_0x004c:
                    r9 = 0
                    java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ all -> 0x00af }
                    java.io.File r11 = r3     // Catch:{ all -> 0x00af }
                    r3.<init>(r11)     // Catch:{ all -> 0x00af }
                    com.mob.tools.network.NetworkHelper$NetworkTimeOut r11 = new com.mob.tools.network.NetworkHelper$NetworkTimeOut     // Catch:{ all -> 0x00ad }
                    r11.<init>()     // Catch:{ all -> 0x00ad }
                    r11.readTimout = r5     // Catch:{ all -> 0x00ad }
                    r11.connectionTimeout = r4     // Catch:{ all -> 0x00ad }
                    com.mob.tools.network.NetworkHelper r4 = new com.mob.tools.network.NetworkHelper     // Catch:{ all -> 0x00ad }
                    r4.<init>()     // Catch:{ all -> 0x00ad }
                    java.lang.String r5 = r5     // Catch:{ all -> 0x00ad }
                    r4.download(r5, r3, r11)     // Catch:{ all -> 0x00ad }
                    java.io.Closeable[] r4 = new java.io.Closeable[r7]     // Catch:{ all -> 0x0154 }
                    r4[r6] = r3     // Catch:{ all -> 0x0154 }
                    com.mob.commons.v.a((java.io.Closeable[]) r4)     // Catch:{ all -> 0x0154 }
                    java.io.File r3 = r3     // Catch:{ all -> 0x0154 }
                    long r3 = r3.length()     // Catch:{ all -> 0x0154 }
                    int r3 = (r3 > r9 ? 1 : (r3 == r9 ? 0 : -1))
                    if (r3 <= 0) goto L_0x009e
                    java.lang.String r3 = r4     // Catch:{ all -> 0x0154 }
                    java.io.File r4 = r3     // Catch:{ all -> 0x0154 }
                    java.lang.String r4 = com.mob.tools.utils.Data.MD5((java.io.File) r4)     // Catch:{ all -> 0x0154 }
                    boolean r3 = android.text.TextUtils.equals(r3, r4)     // Catch:{ all -> 0x0154 }
                    if (r3 == 0) goto L_0x009e
                    java.lang.String r2 = r6     // Catch:{ all -> 0x014f }
                    java.io.File r3 = r3     // Catch:{ all -> 0x014f }
                    java.lang.String r3 = r3.getAbsolutePath()     // Catch:{ all -> 0x014f }
                    java.lang.String r4 = r7     // Catch:{ all -> 0x014f }
                    boolean r2 = com.mob.commons.c.b(r2, r0, r3, r8, r4)     // Catch:{ all -> 0x014f }
                    if (r2 != 0) goto L_0x0165
                    java.io.File r2 = r3     // Catch:{ all -> 0x014f }
                    r2.delete()     // Catch:{ all -> 0x014f }
                    goto L_0x0165
                L_0x009e:
                    java.io.File r0 = r3     // Catch:{ all -> 0x0154 }
                    boolean r0 = r0.exists()     // Catch:{ all -> 0x0154 }
                    if (r0 == 0) goto L_0x0165
                    java.io.File r0 = r3     // Catch:{ all -> 0x0154 }
                    r0.delete()     // Catch:{ all -> 0x0154 }
                    goto L_0x0165
                L_0x00ad:
                    r4 = move-exception
                    goto L_0x00b1
                L_0x00af:
                    r4 = move-exception
                    r3 = r8
                L_0x00b1:
                    java.io.Closeable[] r5 = new java.io.Closeable[r7]     // Catch:{ all -> 0x0154 }
                    r5[r6] = r3     // Catch:{ all -> 0x0154 }
                    com.mob.commons.v.a((java.io.Closeable[]) r5)     // Catch:{ all -> 0x0154 }
                    java.io.File r3 = r3     // Catch:{ all -> 0x0154 }
                    long r5 = r3.length()     // Catch:{ all -> 0x0154 }
                    int r3 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
                    if (r3 <= 0) goto L_0x00e6
                    java.lang.String r3 = r4     // Catch:{ all -> 0x0154 }
                    java.io.File r5 = r3     // Catch:{ all -> 0x0154 }
                    java.lang.String r5 = com.mob.tools.utils.Data.MD5((java.io.File) r5)     // Catch:{ all -> 0x0154 }
                    boolean r3 = android.text.TextUtils.equals(r3, r5)     // Catch:{ all -> 0x0154 }
                    if (r3 == 0) goto L_0x00e6
                    java.lang.String r2 = r6     // Catch:{ all -> 0x014f }
                    java.io.File r3 = r3     // Catch:{ all -> 0x014f }
                    java.lang.String r3 = r3.getAbsolutePath()     // Catch:{ all -> 0x014f }
                    java.lang.String r5 = r7     // Catch:{ all -> 0x014f }
                    boolean r2 = com.mob.commons.c.b(r2, r0, r3, r8, r5)     // Catch:{ all -> 0x014f }
                    if (r2 != 0) goto L_0x00f4
                    java.io.File r2 = r3     // Catch:{ all -> 0x014f }
                    r2.delete()     // Catch:{ all -> 0x014f }
                    goto L_0x00f4
                L_0x00e6:
                    java.io.File r0 = r3     // Catch:{ all -> 0x0154 }
                    boolean r0 = r0.exists()     // Catch:{ all -> 0x0154 }
                    if (r0 == 0) goto L_0x00f3
                    java.io.File r0 = r3     // Catch:{ all -> 0x0154 }
                    r0.delete()     // Catch:{ all -> 0x0154 }
                L_0x00f3:
                    r0 = r2
                L_0x00f4:
                    throw r4     // Catch:{ all -> 0x014f }
                L_0x00f5:
                    r0 = move-exception
                    r2 = r1
                    goto L_0x0155
                L_0x00f8:
                    java.io.File r0 = r3     // Catch:{ all -> 0x0154 }
                    boolean r0 = r0.exists()     // Catch:{ all -> 0x0154 }
                    if (r0 == 0) goto L_0x0105
                    java.io.File r0 = r3     // Catch:{ all -> 0x0154 }
                    r0.delete()     // Catch:{ all -> 0x0154 }
                L_0x0105:
                    r0 = 8
                    java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0146 }
                    r2.<init>()     // Catch:{ all -> 0x0146 }
                    com.mob.tools.network.NetworkHelper$NetworkTimeOut r3 = new com.mob.tools.network.NetworkHelper$NetworkTimeOut     // Catch:{ all -> 0x0143 }
                    r3.<init>()     // Catch:{ all -> 0x0143 }
                    r3.readTimout = r5     // Catch:{ all -> 0x0143 }
                    r3.connectionTimeout = r4     // Catch:{ all -> 0x0143 }
                    com.mob.tools.network.NetworkHelper r4 = new com.mob.tools.network.NetworkHelper     // Catch:{ all -> 0x0143 }
                    r4.<init>()     // Catch:{ all -> 0x0143 }
                    java.lang.String r5 = r5     // Catch:{ all -> 0x0143 }
                    r4.download(r5, r2, r3)     // Catch:{ all -> 0x0143 }
                    java.io.Closeable[] r3 = new java.io.Closeable[r7]     // Catch:{ all -> 0x014f }
                    r3[r6] = r2     // Catch:{ all -> 0x014f }
                    com.mob.commons.v.a((java.io.Closeable[]) r3)     // Catch:{ all -> 0x014f }
                    byte[] r2 = r2.toByteArray()     // Catch:{ all -> 0x014f }
                    int r3 = r2.length     // Catch:{ all -> 0x014f }
                    if (r3 <= 0) goto L_0x0165
                    java.lang.String r3 = r4     // Catch:{ all -> 0x014f }
                    java.lang.String r4 = com.mob.tools.utils.Data.MD5((byte[]) r2)     // Catch:{ all -> 0x014f }
                    boolean r0 = android.text.TextUtils.equals(r3, r4)     // Catch:{ all -> 0x014f }
                    if (r0 == 0) goto L_0x0165
                    r0 = 9
                    java.lang.String r3 = r6     // Catch:{ all -> 0x014f }
                    java.lang.String r4 = r7     // Catch:{ all -> 0x014f }
                    boolean unused = com.mob.commons.c.b(r3, r0, r8, r2, r4)     // Catch:{ all -> 0x014f }
                    goto L_0x0165
                L_0x0143:
                    r3 = move-exception
                    r8 = r2
                    goto L_0x0147
                L_0x0146:
                    r3 = move-exception
                L_0x0147:
                    java.io.Closeable[] r2 = new java.io.Closeable[r7]     // Catch:{ all -> 0x014f }
                    r2[r6] = r8     // Catch:{ all -> 0x014f }
                    com.mob.commons.v.a((java.io.Closeable[]) r2)     // Catch:{ all -> 0x014f }
                    throw r3     // Catch:{ all -> 0x014f }
                L_0x014f:
                    r2 = move-exception
                    r12 = r2
                    r2 = r0
                    r0 = r12
                    goto L_0x0155
                L_0x0154:
                    r0 = move-exception
                L_0x0155:
                    com.mob.commons.g r3 = com.mob.commons.g.a()
                    java.lang.String r4 = r6
                    r3.a((int) r1, (int) r2, (java.lang.Throwable) r0, (java.lang.String) r4)
                    com.mob.tools.log.NLog r1 = com.mob.tools.MobLog.getInstance()
                    r1.d(r0)
                L_0x0165:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.mob.commons.c.AnonymousClass2.run():void");
            }
        }).start();
    }

    /* access modifiers changed from: private */
    public static boolean b(String str, int i11, String str2, byte[] bArr, String str3) {
        byte[] bArr2 = bArr;
        String str4 = str3;
        try {
            Method[] methods = com.mob.tools.c.a.class.getMethods();
            Method method = null;
            int length = methods.length;
            int i12 = 0;
            boolean z11 = false;
            while (true) {
                if (i12 >= length) {
                    break;
                }
                Method method2 = methods[i12];
                Annotation[] annotations = method2.getAnnotations();
                if (annotations != null) {
                    int length2 = annotations.length;
                    int i13 = 0;
                    while (true) {
                        if (i13 < length2) {
                            Annotation annotation = annotations[i13];
                            if (annotation != null && annotation.annotationType() == com.mob.tools.c.b.class) {
                                z11 = true;
                                method = method2;
                                break;
                            }
                            i13++;
                        } else {
                            break;
                        }
                    }
                    if (z11) {
                        break;
                    }
                }
                i12++;
            }
            if (bArr2 != null) {
                com.mob.commons.cc.a.a(MobSDK.getContext(), bArr2, str4, method);
            } else {
                com.mob.commons.cc.a.a(MobSDK.getContext(), str2, str4, method);
            }
            return true;
        } catch (Throwable unused) {
        }
        return false;
    }
}
