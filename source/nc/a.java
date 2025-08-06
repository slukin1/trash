package nc;

import android.content.Context;
import com.alibaba.fastjson.JSONObject;
import com.blankj.utilcode.util.v;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.core.util.p;
import com.hbg.lib.core.util.w;
import com.hbg.module.asset.AssetModuleConfig;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huochat.community.network.domain.DomainTool;
import java.util.Locale;
import rj.b;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f19345a = new a();

    public final b a() {
        b bVar = new b(BaseApplication.b(), "copytrading");
        bVar.H();
        b(bVar);
        return bVar;
    }

    public final void b(b bVar) {
        JSONObject jSONObject = new JSONObject();
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
        if (bVar != null) {
            context = bVar.d();
        }
        jSONObject.put("language", p.a(context).toLowerCase(locale));
        jSONObject.put("webUrl", BaseModuleConfig.a().j());
        jSONObject.put("statusHeight", Integer.valueOf(v.a(20.0f)));
        if (bVar != null) {
            bVar.I("sendCommonConfig(" + jSONObject + ')');
        }
    }
}
