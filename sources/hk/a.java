package hk;

import android.content.Context;
import com.alibaba.fastjson.JSON;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.core.util.p;
import com.huobi.engineutils.ability.AssetJumpAbility;
import com.huobi.engineutils.ability.EngineCurrencyCommonAbility;
import com.huobi.engineutils.widget.AnimTextViewWidget;
import com.huobi.engineutils.widget.AssetBalanceWidget;
import com.huobi.engineutils.widget.AssetBannerCardsWidget;
import com.huobi.engineutils.widget.BottomLineTextWidget;
import com.huobi.engineutils.widget.CurrencySelectWidget;
import com.huobi.engineutils.widget.SortSelectWidget;
import java.util.HashMap;
import rj.b;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public b f47596a;

    public a(Context context) {
        b(context);
    }

    public b a() {
        return this.f47596a;
    }

    public final void b(Context context) {
        b bVar = new b(context, "asset");
        this.f47596a = bVar;
        bVar.H();
        d();
    }

    public void c() {
        this.f47596a.t("currencyCommon", EngineCurrencyCommonAbility.class);
        this.f47596a.t("jump", AssetJumpAbility.class);
        this.f47596a.A("AssetBalanceView", AssetBalanceWidget.class);
        this.f47596a.A("AnimTextView", AnimTextViewWidget.class);
        this.f47596a.A("BottomLineTextView", BottomLineTextWidget.class);
        this.f47596a.A("CurrencyChangeView", CurrencySelectWidget.class);
        this.f47596a.A("SortSelectView", SortSelectWidget.class);
        this.f47596a.A("AssetBannerCards", AssetBannerCardsWidget.class);
    }

    public void d() {
        HashMap hashMap = new HashMap();
        hashMap.put("language", p.a(this.f47596a.d()).toLowerCase());
        hashMap.put("webUrl", BaseModuleConfig.a().j());
        hashMap.put("colorMode", NightHelper.e().g() ? "1" : "0");
        hashMap.put("OS", "1");
        b bVar = this.f47596a;
        bVar.I("sendCommonConfig(" + JSON.toJSONString(hashMap) + ")");
    }
}
