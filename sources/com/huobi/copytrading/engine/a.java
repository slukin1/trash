package com.huobi.copytrading.engine;

import android.content.Context;
import com.alibaba.fastjson.JSONObject;
import com.blankj.utilcode.util.v;
import com.hbg.lib.common.utils.SystemUtils;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.core.util.p;
import com.hbg.lib.core.util.w;
import com.hbg.module.asset.AssetModuleConfig;
import com.huawei.hms.push.AttributionReporter;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.domain.DomainSwitcher;
import com.huochat.community.network.domain.DomainTool;
import java.util.Locale;
import rj.b;
import tg.r;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f43594a = new a();

    public final void a(b bVar) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("contractH5Url", DomainTool.DOMAIN_PREFIX + DomainSwitcher.t());
        if (!SystemUtils.c()) {
            jSONObject.put("contractH5Url", wi.b.f48056t);
        }
        String y11 = LegalCurrencyConfigUtil.y();
        Locale locale = Locale.ROOT;
        jSONObject.put("currencyCharacter", y11.toUpperCase(locale));
        jSONObject.put("currencyRate", LegalCurrencyConfigUtil.v());
        jSONObject.put("priceColorType", Integer.valueOf(w.l() ^ true ? 1 : 0));
        jSONObject.put("colorMode", Integer.valueOf(NightHelper.e().g() ? 1 : 0));
        String j11 = AssetModuleConfig.a().j();
        Context context = null;
        jSONObject.put("iconURLHost", j11 != null ? StringsKt__StringsJVMKt.G(j11, DomainTool.DOMAIN_PREFIX, "", false, 4, (Object) null) : null);
        jSONObject.put("iconPlaceholder", "");
        jSONObject.put("OS", 1);
        jSONObject.put(AttributionReporter.APP_VERSION, 105400);
        if (bVar != null) {
            context = bVar.d();
        }
        jSONObject.put("language", p.a(context).toLowerCase(locale));
        jSONObject.put("webUrl", BaseModuleConfig.a().j());
        jSONObject.put("statusHeight", Integer.valueOf(v.a(20.0f)));
        jSONObject.put("isChild", r.x().X() ? "1" : "0");
        if (bVar != null) {
            bVar.I("sendCommonConfig(" + jSONObject + ')');
        }
    }
}
