package uh;

import android.text.TextUtils;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.module.asset.AssetModuleConfig;
import com.huobi.finance.bean.BaseAssetInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class d {

    /* renamed from: d  reason: collision with root package name */
    public static final d f47916d = new d();

    /* renamed from: a  reason: collision with root package name */
    public boolean f47917a;

    /* renamed from: b  reason: collision with root package name */
    public String f47918b;

    /* renamed from: c  reason: collision with root package name */
    public List<a> f47919c = new ArrayList();

    public interface a {
        void Ec();
    }

    public d() {
        h(ConfigPreferences.c("user_config", "CONFIG_HIDE_ZERO_BALANCE_" + AssetModuleConfig.a().getUid(), false));
    }

    public static d d() {
        return f47916d;
    }

    public void a(a aVar) {
        this.f47919c.add(aVar);
    }

    public <P extends BaseAssetInfo> List<P> b(List<P> list) {
        ArrayList arrayList = new ArrayList();
        for (P p11 : list) {
            if (!TextUtils.isEmpty(this.f47918b)) {
                if (!TextUtils.isEmpty(p11.getTitle())) {
                    String title = p11.getTitle();
                    Locale locale = Locale.US;
                    if (!title.toLowerCase(locale).contains(this.f47918b.toLowerCase(locale))) {
                    }
                }
            }
            if (!this.f47917a || !p11.isMinAmountAsset()) {
                arrayList.add(p11);
            }
        }
        return arrayList;
    }

    public String c() {
        return this.f47918b;
    }

    public boolean e() {
        return this.f47917a;
    }

    public final void f() {
        for (a Ec : this.f47919c) {
            Ec.Ec();
        }
    }

    public void g(String str) {
        this.f47918b = str;
        f();
    }

    public void h(boolean z11) {
        if (this.f47917a != z11) {
            this.f47917a = z11;
            ConfigPreferences.n("user_config", "CONFIG_HIDE_ZERO_BALANCE_" + AssetModuleConfig.a().getUid(), z11);
            f();
        }
    }
}
