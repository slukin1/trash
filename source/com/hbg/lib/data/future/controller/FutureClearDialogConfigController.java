package com.hbg.lib.data.future.controller;

import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.network.contract.core.bean.ContractClearDialogConfig;
import com.hbg.lib.network.pro.core.util.Period;
import java.util.HashMap;
import java.util.Map;
import q7.a;
import rx.Observable;

public class FutureClearDialogConfigController {

    /* renamed from: a  reason: collision with root package name */
    public static Map<Integer, ContractClearDialogConfig> f68833a = new HashMap();

    public static void b() {
        f68833a.clear();
    }

    public static Observable<ContractClearDialogConfig> c(int i11, boolean z11) {
        ContractClearDialogConfig contractClearDialogConfig = f68833a.get(Integer.valueOf(i11));
        if (!z11 || contractClearDialogConfig == null) {
            return a.a().getClearDialogConfig().b().map(new z6.a(i11));
        }
        return Observable.just(contractClearDialogConfig);
    }

    public static boolean d(int i11) {
        long h11 = ConfigPreferences.h("user_config", "config_last_clear_dialog_show_time" + i11);
        long currentTimeMillis = System.currentTimeMillis();
        ContractClearDialogConfig contractClearDialogConfig = f68833a.get(Integer.valueOf(i11));
        return contractClearDialogConfig != null && (currentTimeMillis - h11) / Period.MIN60_MILLS >= contractClearDialogConfig.getInterval();
    }

    public static void f(int i11) {
        long currentTimeMillis = System.currentTimeMillis();
        ConfigPreferences.l("user_config", "config_last_clear_dialog_show_time" + i11, currentTimeMillis);
    }

    public static boolean g(int i11) {
        ContractClearDialogConfig contractClearDialogConfig = f68833a.get(Integer.valueOf(i11));
        if (!(contractClearDialogConfig != null && 1 == contractClearDialogConfig.getHitBlacklist() && contractClearDialogConfig.getDialogSwitch() == 1) || !d(i11)) {
            return false;
        }
        return true;
    }
}
