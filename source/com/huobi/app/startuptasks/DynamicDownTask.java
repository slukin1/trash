package com.huobi.app.startuptasks;

import android.app.Application;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.common.dynamic.downloader.HBDynamicResDownManager;
import com.hbg.lib.common.dynamic.downloader.Util;
import com.hbg.lib.network.hbg.core.util.MgtConfigNumber;
import com.huobi.app.H5CacheServiceHelper;
import com.huobi.network.HttpConfig;
import com.huobi.store.AppConfigManager;
import i6.k;
import java.io.File;
import java.io.IOException;

public final class DynamicDownTask extends BaseAppStartTask {

    /* renamed from: a  reason: collision with root package name */
    public final String f42178a = "DynamicDownTask";

    public void c() {
        File file;
        Throwable th2;
        H5CacheServiceHelper.H5CacheConfig h5CacheConfig = (H5CacheServiceHelper.H5CacheConfig) AppConfigManager.c(MgtConfigNumber.H5_CACHE_CONFIG.number, H5CacheServiceHelper.H5CacheConfig.class);
        if (h5CacheConfig == null) {
            h5CacheConfig = new H5CacheServiceHelper.H5CacheConfig();
        }
        Application b11 = BaseApplication.b();
        String str = b11.getPackageManager().getPackageInfo(b11.getPackageName(), 0).versionName;
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(b11.getCacheDir().getPath());
            String str2 = File.separator;
            sb2.append(str2);
            sb2.append(str);
            sb2.append(str2);
            sb2.append("start_download_dynamic_file_stop.huobi");
            file = new File(sb2.toString());
            try {
                k.i(this.f42178a, "start_download_dynamic_file_stop: config.downloaderSwitch=" + h5CacheConfig.downloaderSwitch + "  ,exists=" + file.exists(), false);
                if (!file.exists() && h5CacheConfig.downloaderSwitch) {
                    HBDynamicResDownManager.b().h(HttpConfig.a(false).build(), true);
                }
            } catch (Throwable th3) {
                th2 = th3;
                k.h(this.f42178a, "run:start download dynamic file downloaderSwitch=[" + h5CacheConfig.downloaderSwitch + "]Throwable ", th2, false);
                try {
                    file.getParentFile().mkdirs();
                    file.createNewFile();
                    Util.b("downloader_crash_close", 1, th2.getMessage() + "");
                } catch (IOException e11) {
                    e11.printStackTrace();
                }
            }
        } catch (Throwable th4) {
            file = null;
            th2 = th4;
            k.h(this.f42178a, "run:start download dynamic file downloaderSwitch=[" + h5CacheConfig.downloaderSwitch + "]Throwable ", th2, false);
            file.getParentFile().mkdirs();
            file.createNewFile();
            Util.b("downloader_crash_close", 1, th2.getMessage() + "");
        }
    }
}
