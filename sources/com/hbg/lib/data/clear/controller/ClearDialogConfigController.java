package com.hbg.lib.data.clear.controller;

import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.network.hbg.core.bean.ClearDialogConfig;
import com.hbg.lib.network.pro.core.util.Period;
import java.util.HashMap;
import java.util.Map;
import rx.Observable;
import v7.b;
import y6.a;

public class ClearDialogConfigController {

    /* renamed from: a  reason: collision with root package name */
    public static Map<Integer, ClearDialogConfig> f68832a = new HashMap();

    public static void b() {
        f68832a.clear();
    }

    public static Observable<ClearDialogConfig> c(int i11, boolean z11) {
        ClearDialogConfig clearDialogConfig = f68832a.get(Integer.valueOf(i11));
        if (!z11 || clearDialogConfig == null) {
            return b.a().getClearDialogConfig(i11).b().map(new a(i11));
        }
        return Observable.just(clearDialogConfig);
    }

    public static ClearDialogConfig d(int i11) {
        return f68832a.get(Integer.valueOf(i11));
    }

    public static boolean e(int i11) {
        long h11 = ConfigPreferences.h("user_config", "config_last_clear_dialog_show_time" + i11);
        long currentTimeMillis = System.currentTimeMillis();
        ClearDialogConfig clearDialogConfig = f68832a.get(Integer.valueOf(i11));
        return clearDialogConfig != null && (currentTimeMillis - h11) / Period.MIN60_MILLS >= clearDialogConfig.getInterval();
    }

    public static void g(int i11) {
        long currentTimeMillis = System.currentTimeMillis();
        ConfigPreferences.l("user_config", "config_last_clear_dialog_show_time" + i11, currentTimeMillis);
    }

    public static boolean h(int i11) {
        ClearDialogConfig clearDialogConfig = f68832a.get(Integer.valueOf(i11));
        if (clearDialogConfig != null && 1 == clearDialogConfig.getHitBlacklist() && clearDialogConfig.getDialogSwitch() == 2) {
            return true;
        }
        return false;
    }

    public static boolean i(int i11) {
        ClearDialogConfig clearDialogConfig = f68832a.get(Integer.valueOf(i11));
        if (!(clearDialogConfig != null && 1 == clearDialogConfig.getHitBlacklist() && clearDialogConfig.getDialogSwitch() == 1) || !e(i11)) {
            return false;
        }
        return true;
    }
}
