package com.huobi.app.startuptasks;

import android.util.Log;
import com.hbg.lib.core.util.NightHelper;
import e6.h;

public final class DynamicInitTask extends BaseAppStartTask {

    /* renamed from: a  reason: collision with root package name */
    public final String f42179a = "DynamicInitTask";

    public static final class a implements com.hbg.lib.common.dynamic.downloader.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DynamicInitTask f42180a;

        public a(DynamicInitTask dynamicInitTask) {
            this.f42180a = dynamicInitTask;
        }

        public void a(String str) {
            String e11 = this.f42180a.f42179a;
            Log.d(e11, "dynamicReady() called with: dynamicVersion = [" + str + ']');
        }

        public String b() {
            return h.r().h();
        }
    }

    public static final boolean f() {
        return NightHelper.e().g();
    }

    /* JADX WARNING: Removed duplicated region for block: B:106:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x011a A[Catch:{ IOException -> 0x0110, all -> 0x03e9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x01e9 A[Catch:{ IOException -> 0x0110, all -> 0x03e9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x02b7 A[Catch:{ IOException -> 0x0110, all -> 0x03e9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0333 A[Catch:{ all -> 0x0374 }] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x03cf  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c() {
        /*
            r17 = this;
            r1 = r17
            java.lang.String r2 = "init_dynamic_cost"
            java.lang.String r3 = "   ,exists="
            java.lang.String r4 = "]Throwable "
            java.lang.String r5 = ""
            android.app.Application r6 = com.hbg.lib.common.BaseApplication.b()
            java.lang.String r0 = "pro.huobi"
            boolean r0 = com.huobi.app.HuobiApplicationUtil.r(r0, r6)
            if (r0 != 0) goto L_0x0017
            return
        L_0x0017:
            long r7 = java.lang.System.currentTimeMillis()
            com.hbg.lib.network.hbg.core.util.MgtConfigNumber r0 = com.hbg.lib.network.hbg.core.util.MgtConfigNumber.H5_CACHE_CONFIG
            int r0 = r0.number
            java.lang.Class<com.huobi.app.H5CacheServiceHelper$H5CacheConfig> r9 = com.huobi.app.H5CacheServiceHelper.H5CacheConfig.class
            java.lang.Object r0 = com.huobi.store.AppConfigManager.c(r0, r9)
            com.huobi.app.H5CacheServiceHelper$H5CacheConfig r0 = (com.huobi.app.H5CacheServiceHelper.H5CacheConfig) r0
            if (r0 != 0) goto L_0x002e
            com.huobi.app.H5CacheServiceHelper$H5CacheConfig r0 = new com.huobi.app.H5CacheServiceHelper$H5CacheConfig
            r0.<init>()
        L_0x002e:
            r9 = r0
            android.content.pm.PackageManager r0 = r6.getPackageManager()
            java.lang.String r10 = r6.getPackageName()
            r11 = 0
            android.content.pm.PackageInfo r0 = r0.getPackageInfo(r10, r11)
            java.lang.String r10 = r0.versionName
            boolean r0 = com.hbg.lib.common.dynamic.downloader.Util.a()
            java.lang.String r12 = "DynamicInitTask.run() called  cost:"
            if (r0 == 0) goto L_0x005f
            java.lang.String r0 = r1.f42179a
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            r13.append(r12)
            long r14 = java.lang.System.currentTimeMillis()
            long r14 = r14 - r7
            r13.append(r14)
            java.lang.String r13 = r13.toString()
            android.util.Log.d(r0, r13)
        L_0x005f:
            java.io.File r15 = new java.io.File     // Catch:{ all -> 0x00cd }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00cd }
            r0.<init>()     // Catch:{ all -> 0x00cd }
            java.io.File r16 = r6.getCacheDir()     // Catch:{ all -> 0x00cd }
            java.lang.String r13 = r16.getPath()     // Catch:{ all -> 0x00cd }
            r0.append(r13)     // Catch:{ all -> 0x00cd }
            java.lang.String r13 = java.io.File.separator     // Catch:{ all -> 0x00cd }
            r0.append(r13)     // Catch:{ all -> 0x00cd }
            r0.append(r10)     // Catch:{ all -> 0x00cd }
            r0.append(r13)     // Catch:{ all -> 0x00cd }
            java.lang.String r13 = "init_i18nmanager_stop.huobi"
            r0.append(r13)     // Catch:{ all -> 0x00cd }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00cd }
            r15.<init>(r0)     // Catch:{ all -> 0x00cd }
            java.lang.String r0 = r1.f42179a     // Catch:{ all -> 0x00cb }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x00cb }
            r13.<init>()     // Catch:{ all -> 0x00cb }
            java.lang.String r14 = "run(): config.i18nManageInitSwitch="
            r13.append(r14)     // Catch:{ all -> 0x00cb }
            boolean r14 = r9.i18nManageInitSwitch     // Catch:{ all -> 0x00cb }
            r13.append(r14)     // Catch:{ all -> 0x00cb }
            r13.append(r3)     // Catch:{ all -> 0x00cb }
            boolean r14 = r15.exists()     // Catch:{ all -> 0x00cb }
            r13.append(r14)     // Catch:{ all -> 0x00cb }
            java.lang.String r13 = r13.toString()     // Catch:{ all -> 0x00cb }
            i6.k.i(r0, r13, r11)     // Catch:{ all -> 0x00cb }
            boolean r0 = r15.exists()     // Catch:{ all -> 0x00cb }
            if (r0 != 0) goto L_0x0114
            boolean r0 = r9.i18nManageInitSwitch     // Catch:{ all -> 0x00cb }
            if (r0 == 0) goto L_0x0114
            e6.d r0 = e6.d.r()     // Catch:{ all -> 0x00cb }
            com.hbg.lib.core.util.AppLanguageHelper r13 = com.hbg.lib.core.util.AppLanguageHelper.getInstance()     // Catch:{ all -> 0x00cb }
            java.lang.String r13 = r13.getCurLanguageHeader()     // Catch:{ all -> 0x00cb }
            r0.x(r13)     // Catch:{ all -> 0x00cb }
            e6.d r0 = e6.d.r()     // Catch:{ all -> 0x00cb }
            r0.j()     // Catch:{ all -> 0x00cb }
            goto L_0x0114
        L_0x00cb:
            r0 = move-exception
            goto L_0x00cf
        L_0x00cd:
            r0 = move-exception
            r15 = 0
        L_0x00cf:
            java.lang.String r13 = r1.f42179a     // Catch:{ all -> 0x03e9 }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ all -> 0x03e9 }
            r14.<init>()     // Catch:{ all -> 0x03e9 }
            java.lang.String r11 = "run:init_i18nmanager  config.i18nManageInitSwitch=["
            r14.append(r11)     // Catch:{ all -> 0x03e9 }
            boolean r11 = r9.i18nManageInitSwitch     // Catch:{ all -> 0x03e9 }
            r14.append(r11)     // Catch:{ all -> 0x03e9 }
            r14.append(r4)     // Catch:{ all -> 0x03e9 }
            java.lang.String r11 = r14.toString()     // Catch:{ all -> 0x03e9 }
            r14 = 0
            i6.k.h(r13, r11, r0, r14)     // Catch:{ all -> 0x03e9 }
            java.lang.String r11 = "init_i18nmanager_crash_close"
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0110 }
            r13.<init>()     // Catch:{ IOException -> 0x0110 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ IOException -> 0x0110 }
            r13.append(r0)     // Catch:{ IOException -> 0x0110 }
            r13.append(r5)     // Catch:{ IOException -> 0x0110 }
            java.lang.String r0 = r13.toString()     // Catch:{ IOException -> 0x0110 }
            r13 = 1
            com.hbg.lib.common.dynamic.downloader.Util.b(r11, r13, r0)     // Catch:{ IOException -> 0x0110 }
            java.io.File r0 = r15.getParentFile()     // Catch:{ IOException -> 0x0110 }
            r0.mkdirs()     // Catch:{ IOException -> 0x0110 }
            r15.createNewFile()     // Catch:{ IOException -> 0x0110 }
            goto L_0x0114
        L_0x0110:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x03e9 }
        L_0x0114:
            boolean r0 = com.hbg.lib.common.dynamic.downloader.Util.a()     // Catch:{ all -> 0x03e9 }
            if (r0 == 0) goto L_0x0133
            java.lang.String r0 = r1.f42179a     // Catch:{ all -> 0x03e9 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x03e9 }
            r11.<init>()     // Catch:{ all -> 0x03e9 }
            r11.append(r12)     // Catch:{ all -> 0x03e9 }
            long r13 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x03e9 }
            long r13 = r13 - r7
            r11.append(r13)     // Catch:{ all -> 0x03e9 }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x03e9 }
            android.util.Log.d(r0, r11)     // Catch:{ all -> 0x03e9 }
        L_0x0133:
            java.io.File r11 = new java.io.File     // Catch:{ all -> 0x019c }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x019c }
            r0.<init>()     // Catch:{ all -> 0x019c }
            java.io.File r13 = r6.getCacheDir()     // Catch:{ all -> 0x019c }
            java.lang.String r13 = r13.getPath()     // Catch:{ all -> 0x019c }
            r0.append(r13)     // Catch:{ all -> 0x019c }
            java.lang.String r13 = java.io.File.separator     // Catch:{ all -> 0x019c }
            r0.append(r13)     // Catch:{ all -> 0x019c }
            r0.append(r10)     // Catch:{ all -> 0x019c }
            r0.append(r13)     // Catch:{ all -> 0x019c }
            java.lang.String r13 = "init_dynamic_image_manager_stop.huobi"
            r0.append(r13)     // Catch:{ all -> 0x019c }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x019c }
            r11.<init>(r0)     // Catch:{ all -> 0x019c }
            java.lang.String r0 = r1.f42179a     // Catch:{ all -> 0x019a }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x019a }
            r13.<init>()     // Catch:{ all -> 0x019a }
            java.lang.String r14 = "run(): config.dyanmicImageInitSwitch="
            r13.append(r14)     // Catch:{ all -> 0x019a }
            boolean r14 = r9.dyanmicImageInitSwitch     // Catch:{ all -> 0x019a }
            r13.append(r14)     // Catch:{ all -> 0x019a }
            r13.append(r3)     // Catch:{ all -> 0x019a }
            boolean r14 = r11.exists()     // Catch:{ all -> 0x019a }
            r13.append(r14)     // Catch:{ all -> 0x019a }
            java.lang.String r13 = r13.toString()     // Catch:{ all -> 0x019a }
            r14 = 0
            i6.k.i(r0, r13, r14)     // Catch:{ all -> 0x019a }
            boolean r0 = r11.exists()     // Catch:{ all -> 0x019a }
            if (r0 != 0) goto L_0x01e3
            boolean r0 = r9.dyanmicImageInitSwitch     // Catch:{ all -> 0x019a }
            if (r0 == 0) goto L_0x01e3
            e6.g r0 = e6.g.v()     // Catch:{ all -> 0x019a }
            r0.j()     // Catch:{ all -> 0x019a }
            e6.g r0 = e6.g.v()     // Catch:{ all -> 0x019a }
            ch.a r13 = ch.a.f13083a     // Catch:{ all -> 0x019a }
            r0.B(r13)     // Catch:{ all -> 0x019a }
            goto L_0x01e3
        L_0x019a:
            r0 = move-exception
            goto L_0x019e
        L_0x019c:
            r0 = move-exception
            r11 = 0
        L_0x019e:
            java.lang.String r13 = r1.f42179a     // Catch:{ all -> 0x03e9 }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ all -> 0x03e9 }
            r14.<init>()     // Catch:{ all -> 0x03e9 }
            java.lang.String r15 = "run:dynamic_image_manager  config.dyanmicImageInitSwitch=["
            r14.append(r15)     // Catch:{ all -> 0x03e9 }
            boolean r15 = r9.dyanmicImageInitSwitch     // Catch:{ all -> 0x03e9 }
            r14.append(r15)     // Catch:{ all -> 0x03e9 }
            r14.append(r4)     // Catch:{ all -> 0x03e9 }
            java.lang.String r14 = r14.toString()     // Catch:{ all -> 0x03e9 }
            r15 = 0
            i6.k.h(r13, r14, r0, r15)     // Catch:{ all -> 0x03e9 }
            java.lang.String r13 = "init_imagemanager_crash_close"
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x01df }
            r14.<init>()     // Catch:{ IOException -> 0x01df }
            java.lang.String r0 = r0.getMessage()     // Catch:{ IOException -> 0x01df }
            r14.append(r0)     // Catch:{ IOException -> 0x01df }
            r14.append(r5)     // Catch:{ IOException -> 0x01df }
            java.lang.String r0 = r14.toString()     // Catch:{ IOException -> 0x01df }
            r14 = 1
            com.hbg.lib.common.dynamic.downloader.Util.b(r13, r14, r0)     // Catch:{ IOException -> 0x01df }
            java.io.File r0 = r11.getParentFile()     // Catch:{ IOException -> 0x01df }
            r0.mkdirs()     // Catch:{ IOException -> 0x01df }
            r11.createNewFile()     // Catch:{ IOException -> 0x01df }
            goto L_0x01e3
        L_0x01df:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x03e9 }
        L_0x01e3:
            boolean r0 = com.hbg.lib.common.dynamic.downloader.Util.a()     // Catch:{ all -> 0x03e9 }
            if (r0 == 0) goto L_0x0202
            java.lang.String r0 = r1.f42179a     // Catch:{ all -> 0x03e9 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x03e9 }
            r11.<init>()     // Catch:{ all -> 0x03e9 }
            r11.append(r12)     // Catch:{ all -> 0x03e9 }
            long r13 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x03e9 }
            long r13 = r13 - r7
            r11.append(r13)     // Catch:{ all -> 0x03e9 }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x03e9 }
            android.util.Log.d(r0, r11)     // Catch:{ all -> 0x03e9 }
        L_0x0202:
            java.io.File r11 = new java.io.File     // Catch:{ all -> 0x026a }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x026a }
            r0.<init>()     // Catch:{ all -> 0x026a }
            java.io.File r13 = r6.getCacheDir()     // Catch:{ all -> 0x026a }
            java.lang.String r13 = r13.getPath()     // Catch:{ all -> 0x026a }
            r0.append(r13)     // Catch:{ all -> 0x026a }
            java.lang.String r13 = java.io.File.separator     // Catch:{ all -> 0x026a }
            r0.append(r13)     // Catch:{ all -> 0x026a }
            r0.append(r10)     // Catch:{ all -> 0x026a }
            r0.append(r13)     // Catch:{ all -> 0x026a }
            java.lang.String r13 = "init_jsonConfig_manager_stop.huobi"
            r0.append(r13)     // Catch:{ all -> 0x026a }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x026a }
            r11.<init>(r0)     // Catch:{ all -> 0x026a }
            java.lang.String r0 = r1.f42179a     // Catch:{ all -> 0x0268 }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x0268 }
            r13.<init>()     // Catch:{ all -> 0x0268 }
            java.lang.String r14 = "run(): config.jsonConfigInitSwitch="
            r13.append(r14)     // Catch:{ all -> 0x0268 }
            boolean r14 = r9.jsonConfigInitSwitch     // Catch:{ all -> 0x0268 }
            r13.append(r14)     // Catch:{ all -> 0x0268 }
            r13.append(r3)     // Catch:{ all -> 0x0268 }
            boolean r14 = r11.exists()     // Catch:{ all -> 0x0268 }
            r13.append(r14)     // Catch:{ all -> 0x0268 }
            java.lang.String r13 = r13.toString()     // Catch:{ all -> 0x0268 }
            r14 = 0
            i6.k.i(r0, r13, r14)     // Catch:{ all -> 0x0268 }
            boolean r0 = r11.exists()     // Catch:{ all -> 0x0268 }
            if (r0 != 0) goto L_0x02b1
            boolean r0 = r9.jsonConfigInitSwitch     // Catch:{ all -> 0x0268 }
            if (r0 == 0) goto L_0x02b1
            com.huobi.app.startuptasks.DynamicInitTask$a r0 = new com.huobi.app.startuptasks.DynamicInitTask$a     // Catch:{ all -> 0x0268 }
            r0.<init>(r1)     // Catch:{ all -> 0x0268 }
            com.hbg.lib.common.dynamic.manager.HBDynamicBaseManager.a(r0)     // Catch:{ all -> 0x0268 }
            e6.h r0 = e6.h.r()     // Catch:{ all -> 0x0268 }
            r0.j()     // Catch:{ all -> 0x0268 }
            goto L_0x02b1
        L_0x0268:
            r0 = move-exception
            goto L_0x026c
        L_0x026a:
            r0 = move-exception
            r11 = 0
        L_0x026c:
            java.lang.String r13 = r1.f42179a     // Catch:{ all -> 0x03e9 }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ all -> 0x03e9 }
            r14.<init>()     // Catch:{ all -> 0x03e9 }
            java.lang.String r15 = "run:jsonConfig_manager  config.jsonConfigInitSwitch=["
            r14.append(r15)     // Catch:{ all -> 0x03e9 }
            boolean r15 = r9.jsonConfigInitSwitch     // Catch:{ all -> 0x03e9 }
            r14.append(r15)     // Catch:{ all -> 0x03e9 }
            r14.append(r4)     // Catch:{ all -> 0x03e9 }
            java.lang.String r14 = r14.toString()     // Catch:{ all -> 0x03e9 }
            r15 = 0
            i6.k.h(r13, r14, r0, r15)     // Catch:{ all -> 0x03e9 }
            java.lang.String r13 = "init_jsonconfig_crash_close"
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x02ad }
            r14.<init>()     // Catch:{ IOException -> 0x02ad }
            java.lang.String r0 = r0.getMessage()     // Catch:{ IOException -> 0x02ad }
            r14.append(r0)     // Catch:{ IOException -> 0x02ad }
            r14.append(r5)     // Catch:{ IOException -> 0x02ad }
            java.lang.String r0 = r14.toString()     // Catch:{ IOException -> 0x02ad }
            r14 = 1
            com.hbg.lib.common.dynamic.downloader.Util.b(r13, r14, r0)     // Catch:{ IOException -> 0x02ad }
            java.io.File r0 = r11.getParentFile()     // Catch:{ IOException -> 0x02ad }
            r0.mkdirs()     // Catch:{ IOException -> 0x02ad }
            r11.createNewFile()     // Catch:{ IOException -> 0x02ad }
            goto L_0x02b1
        L_0x02ad:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x03e9 }
        L_0x02b1:
            boolean r0 = com.hbg.lib.common.dynamic.downloader.Util.a()     // Catch:{ all -> 0x03e9 }
            if (r0 == 0) goto L_0x02d0
            java.lang.String r0 = r1.f42179a     // Catch:{ all -> 0x03e9 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x03e9 }
            r11.<init>()     // Catch:{ all -> 0x03e9 }
            r11.append(r12)     // Catch:{ all -> 0x03e9 }
            long r13 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x03e9 }
            long r13 = r13 - r7
            r11.append(r13)     // Catch:{ all -> 0x03e9 }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x03e9 }
            android.util.Log.d(r0, r11)     // Catch:{ all -> 0x03e9 }
        L_0x02d0:
            java.io.File r11 = new java.io.File     // Catch:{ all -> 0x0377 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0377 }
            r0.<init>()     // Catch:{ all -> 0x0377 }
            java.io.File r6 = r6.getCacheDir()     // Catch:{ all -> 0x0377 }
            java.lang.String r6 = r6.getPath()     // Catch:{ all -> 0x0377 }
            r0.append(r6)     // Catch:{ all -> 0x0377 }
            java.lang.String r6 = java.io.File.separator     // Catch:{ all -> 0x0377 }
            r0.append(r6)     // Catch:{ all -> 0x0377 }
            r0.append(r10)     // Catch:{ all -> 0x0377 }
            r0.append(r6)     // Catch:{ all -> 0x0377 }
            java.lang.String r6 = "init_dynamicColor_manager_stop.huobi"
            r0.append(r6)     // Catch:{ all -> 0x0377 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0377 }
            r11.<init>(r0)     // Catch:{ all -> 0x0377 }
            java.lang.String r0 = r1.f42179a     // Catch:{ all -> 0x0374 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0374 }
            r6.<init>()     // Catch:{ all -> 0x0374 }
            java.lang.String r10 = "run(): config.dynamicColorInitSwitch="
            r6.append(r10)     // Catch:{ all -> 0x0374 }
            boolean r10 = r9.dynamicColorInitSwitch     // Catch:{ all -> 0x0374 }
            r6.append(r10)     // Catch:{ all -> 0x0374 }
            r6.append(r3)     // Catch:{ all -> 0x0374 }
            boolean r3 = r11.exists()     // Catch:{ all -> 0x0374 }
            r6.append(r3)     // Catch:{ all -> 0x0374 }
            java.lang.String r3 = r6.toString()     // Catch:{ all -> 0x0374 }
            r6 = 0
            i6.k.i(r0, r3, r6)     // Catch:{ all -> 0x0374 }
            boolean r0 = r11.exists()     // Catch:{ all -> 0x0374 }
            if (r0 != 0) goto L_0x03be
            boolean r0 = r9.dynamicColorInitSwitch     // Catch:{ all -> 0x0374 }
            if (r0 == 0) goto L_0x03be
            e6.b r0 = e6.b.v()     // Catch:{ all -> 0x0374 }
            r0.j()     // Catch:{ all -> 0x0374 }
            boolean r0 = com.hbg.lib.common.dynamic.downloader.Util.a()     // Catch:{ all -> 0x0374 }
            if (r0 == 0) goto L_0x03be
            e6.b r0 = e6.b.v()     // Catch:{ all -> 0x0374 }
            java.lang.String r3 = "text_black"
            int r0 = r0.r(r3)     // Catch:{ all -> 0x0374 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0374 }
            r3.<init>()     // Catch:{ all -> 0x0374 }
            java.lang.String r6 = "getJsonContent(\"text_black\")="
            r3.append(r6)     // Catch:{ all -> 0x0374 }
            r3.append(r0)     // Catch:{ all -> 0x0374 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x0374 }
            java.io.PrintStream r3 = java.lang.System.out     // Catch:{ all -> 0x0374 }
            r3.println(r0)     // Catch:{ all -> 0x0374 }
            e6.b r0 = e6.b.v()     // Catch:{ all -> 0x0374 }
            java.lang.String r3 = "text_black1"
            int r0 = r0.r(r3)     // Catch:{ all -> 0x0374 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0374 }
            r3.<init>()     // Catch:{ all -> 0x0374 }
            java.lang.String r6 = "getJsonContent(\"text_black1\")="
            r3.append(r6)     // Catch:{ all -> 0x0374 }
            r3.append(r0)     // Catch:{ all -> 0x0374 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x0374 }
            java.io.PrintStream r3 = java.lang.System.out     // Catch:{ all -> 0x0374 }
            r3.println(r0)     // Catch:{ all -> 0x0374 }
            goto L_0x03be
        L_0x0374:
            r0 = move-exception
            r15 = r11
            goto L_0x0379
        L_0x0377:
            r0 = move-exception
            r15 = 0
        L_0x0379:
            java.lang.String r3 = r1.f42179a     // Catch:{ all -> 0x03e9 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x03e9 }
            r6.<init>()     // Catch:{ all -> 0x03e9 }
            java.lang.String r10 = "run:dynamicColor_manager  config.dynamicColorInitSwitch=["
            r6.append(r10)     // Catch:{ all -> 0x03e9 }
            boolean r9 = r9.dynamicColorInitSwitch     // Catch:{ all -> 0x03e9 }
            r6.append(r9)     // Catch:{ all -> 0x03e9 }
            r6.append(r4)     // Catch:{ all -> 0x03e9 }
            java.lang.String r4 = r6.toString()     // Catch:{ all -> 0x03e9 }
            r6 = 0
            i6.k.h(r3, r4, r0, r6)     // Catch:{ all -> 0x03e9 }
            java.lang.String r3 = "init_dynamicColor_crash_close"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x03ba }
            r4.<init>()     // Catch:{ IOException -> 0x03ba }
            java.lang.String r0 = r0.getMessage()     // Catch:{ IOException -> 0x03ba }
            r4.append(r0)     // Catch:{ IOException -> 0x03ba }
            r4.append(r5)     // Catch:{ IOException -> 0x03ba }
            java.lang.String r0 = r4.toString()     // Catch:{ IOException -> 0x03ba }
            r9 = 1
            com.hbg.lib.common.dynamic.downloader.Util.b(r3, r9, r0)     // Catch:{ IOException -> 0x03ba }
            java.io.File r0 = r15.getParentFile()     // Catch:{ IOException -> 0x03ba }
            r0.mkdirs()     // Catch:{ IOException -> 0x03ba }
            r15.createNewFile()     // Catch:{ IOException -> 0x03ba }
            goto L_0x03be
        L_0x03ba:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x03e9 }
        L_0x03be:
            com.hbg.lib.common.dynamic.manager.HBDynamicBaseManager.c()
            long r3 = java.lang.System.currentTimeMillis()
            long r3 = r3 - r7
            com.hbg.lib.common.dynamic.downloader.Util.b(r2, r3, r5)
            boolean r0 = com.hbg.lib.common.dynamic.downloader.Util.a()
            if (r0 == 0) goto L_0x03e8
            java.lang.String r0 = r1.f42179a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r12)
            long r3 = java.lang.System.currentTimeMillis()
            long r3 = r3 - r7
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            android.util.Log.d(r0, r2)
        L_0x03e8:
            return
        L_0x03e9:
            r0 = move-exception
            com.hbg.lib.common.dynamic.manager.HBDynamicBaseManager.c()
            long r3 = java.lang.System.currentTimeMillis()
            long r3 = r3 - r7
            com.hbg.lib.common.dynamic.downloader.Util.b(r2, r3, r5)
            boolean r2 = com.hbg.lib.common.dynamic.downloader.Util.a()
            if (r2 == 0) goto L_0x0414
            java.lang.String r2 = r1.f42179a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r12)
            long r4 = java.lang.System.currentTimeMillis()
            long r4 = r4 - r7
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            android.util.Log.d(r2, r3)
        L_0x0414:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.app.startuptasks.DynamicInitTask.c():void");
    }
}
