package yt;

import com.alibaba.fastjson.JSONObject;
import com.blankj.utilcode.util.v;
import com.hbg.lib.common.utils.SystemUtils;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.core.util.w;
import com.hbg.lib.network.retrofit.util.SPUtil;
import com.hbg.module.asset.AssetModuleConfig;
import com.huawei.hms.push.AttributionReporter;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.domain.DomainSwitcher;
import com.huochat.community.network.domain.DomainTool;
import java.util.Locale;
import rj.b;
import tg.r;
import yl.g;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f85088a = new a();

    public static /* synthetic */ void b(a aVar, b bVar, String str, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str = null;
        }
        aVar.a(bVar, str);
    }

    public final void a(b bVar, String str) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("contractH5Url", DomainTool.DOMAIN_PREFIX + DomainSwitcher.t());
        if (!SystemUtils.c()) {
            jSONObject.put("contractH5Url", wi.b.f48056t);
        }
        jSONObject.put("currencyCharacter", LegalCurrencyConfigUtil.y().toUpperCase(Locale.ROOT));
        jSONObject.put("currencyRate", LegalCurrencyConfigUtil.v());
        jSONObject.put("priceColorType", Integer.valueOf(w.l() ^ true ? 1 : 0));
        jSONObject.put("colorMode", Integer.valueOf(NightHelper.e().g() ? 1 : 0));
        jSONObject.put("unionMode", Boolean.valueOf(SPUtil.j()));
        String j11 = AssetModuleConfig.a().j();
        jSONObject.put("iconURLHost", j11 != null ? StringsKt__StringsJVMKt.G(j11, DomainTool.DOMAIN_PREFIX, "", false, 4, (Object) null) : null);
        jSONObject.put("iconPlaceholder", "");
        jSONObject.put("OS", 1);
        jSONObject.put(AttributionReporter.APP_VERSION, 105400);
        jSONObject.put("language", m6.a.j());
        jSONObject.put("webUrl", BaseModuleConfig.a().j());
        jSONObject.put("statusHeight", Integer.valueOf(v.a(20.0f)));
        if (str != null) {
            jSONObject.put("source", str);
        }
        jSONObject.put("isChild", r.x().X() ? "1" : "0");
        if (bVar != null) {
            bVar.I("sendCommonConfig(" + jSONObject + ')');
        }
    }

    public final void c(b bVar) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("isLogin", Integer.valueOf(r.x().F0() ? 1 : 0));
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("uId", r.x().J());
        jSONObject2.put("name", r.x().N());
        jSONObject2.put("isChildAccount", Boolean.valueOf(r.x().X()));
        jSONObject2.put("headImage", r.x().p());
        jSONObject2.put("isNFT", Boolean.valueOf(r.x().D() != null));
        jSONObject2.put("countryId", Integer.valueOf(g.h().g()));
        jSONObject2.put("registerCountryId", sn.a.c().a());
        jSONObject.put("userInfo", jSONObject2);
        if (bVar != null) {
            bVar.I("sendLoginStatus(" + jSONObject + ')');
        }
    }
}
