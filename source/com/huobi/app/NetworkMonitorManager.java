package com.huobi.app;

import android.text.TextUtils;
import androidx.annotation.Keep;
import com.hbg.lib.network.hbg.core.util.MgtConfigNumber;
import com.huobi.store.AppConfigManager;
import java.util.List;

public class NetworkMonitorManager {

    /* renamed from: b  reason: collision with root package name */
    public static NetworkMonitorManager f42143b;

    /* renamed from: a  reason: collision with root package name */
    public List<String> f42144a;

    @Keep
    public class NetworkConfig {
        public List<String> whiteList;

        public NetworkConfig() {
        }
    }

    public NetworkMonitorManager() {
        b();
    }

    public static NetworkMonitorManager a() {
        NetworkMonitorManager networkMonitorManager = f42143b;
        if (networkMonitorManager != null) {
            return networkMonitorManager;
        }
        synchronized (NetworkMonitorManager.class) {
            if (f42143b == null) {
                f42143b = new NetworkMonitorManager();
            }
        }
        return f42143b;
    }

    public void b() {
        NetworkConfig networkConfig = (NetworkConfig) AppConfigManager.c(MgtConfigNumber.NETWORK_CONFIG.number, NetworkConfig.class);
        if (networkConfig != null) {
            this.f42144a = networkConfig.whiteList;
        } else {
            this.f42144a = null;
        }
    }

    public boolean c(String str) {
        List<String> list;
        if (!TextUtils.isEmpty(str) && (list = this.f42144a) != null) {
            for (String equals : list) {
                if (str.equals(equals)) {
                    return true;
                }
            }
        }
        return false;
    }
}
