package com.huobi.provider;

import android.content.Context;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.hbg.module.libkt.provider.HbgBaseApmProvider;
import com.huobi.apm.TimeMonitorManager;

@Route(path = "/provider/apm")
public class HbgApmProvider implements HbgBaseApmProvider {
    public void i(String str, String str2, boolean z11) {
        TimeMonitorManager.a().b(str).a(str, str2, z11);
    }

    public void init(Context context) {
    }

    public void o(String str) {
        TimeMonitorManager.a().b(str).c();
    }
}
