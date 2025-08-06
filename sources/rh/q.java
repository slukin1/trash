package rh;

import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.module.asset.AssetModuleConfig;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import i8.s;
import m9.z;
import qh.i0;
import rx.Observable;
import uh.c;
import z6.l;

public final class q {
    public static void L(String str, boolean z11) {
        ConfigPreferences.n("user_config", q(str), z11);
    }

    public static void M() {
        ConfigPreferences.n("user_config", "CONFIG_SHOWED_ASSET_USER_GUIDE_" + AssetModuleConfig.a().getUid(), true);
    }

    public static String q(String str) {
        return "CONFIG_ASSET_SUMMARY_ACCOUNT_EXPANDED_" + AssetModuleConfig.a().getUid() + "_" + str;
    }

    public static Observable<Boolean> r() {
        return AssetModuleConfig.a().X().map(new j(c.b())).onErrorReturn(c.f25643b);
    }

    public static Observable<Boolean> s() {
        Observable<R> onErrorReturn = LegalCurrencyConfigUtil.f(false).map(f.f25646b).onErrorReturn(e.f25645b);
        c b11 = c.b();
        return Observable.zip(onErrorReturn, AssetModuleConfig.a().g1(false).map(new l(b11)).onErrorReturn(p.f25656b), z.f().g(false).map(new i(b11)).onErrorReturn(n.f25654b), s.d().e(false).map(new h(b11)).onErrorReturn(b.f25642b), l.c().e(false).map(new a(b11)).onErrorReturn(o.f25655b), AssetModuleConfig.a().X().map(new k(b11)).onErrorReturn(m.f25653b), i0.d().f().onErrorReturn(d.f25644b), i0.d().e(), g.f25647b).asObservable();
    }

    public static boolean t() {
        return ConfigPreferences.c("user_config", "CONFIG_SHOWED_ASSET_USER_GUIDE_" + AssetModuleConfig.a().getUid(), false);
    }

    public static boolean u(String str) {
        return ConfigPreferences.c("user_config", q(str), false);
    }
}
