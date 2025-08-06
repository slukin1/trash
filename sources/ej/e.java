package ej;

import android.app.Activity;
import android.widget.FrameLayout;
import com.alibaba.fastjson.JSONObject;
import com.hbg.lib.common.utils.SystemUtils;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.core.util.p;
import com.hbg.lib.core.util.w;
import com.hbg.lib.network.uc.core.utils.UcHelper;
import com.hbg.module.asset.AssetModuleConfig;
import com.huawei.hms.push.AttributionReporter;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huochat.community.network.domain.DomainTool;
import i6.r;
import pro.huobi.R;
import rj.b;
import sn.a;

public class e {

    /* renamed from: a  reason: collision with root package name */
    public b f47506a;

    public e(Activity activity, r rVar) {
        b bVar = new b(activity, "futures");
        this.f47506a = bVar;
        bVar.H();
        e(this.f47506a);
        ((FrameLayout) rVar.b(R.id.contract_notice_container)).addView(this.f47506a.D("contractNotice.xml", activity));
    }

    public b a() {
        return this.f47506a;
    }

    public void b() {
        b bVar = this.f47506a;
        if (bVar != null) {
            bVar.B();
        }
    }

    public void c(boolean z11) {
        if (z11) {
            this.f47506a.I("pageAppear()");
        } else {
            this.f47506a.I("pageDisappear()");
        }
    }

    public void d() {
        this.f47506a.I("contractNotice.start()");
    }

    public final void e(b bVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("h5Url", (Object) BaseModuleConfig.a().j());
            if (!SystemUtils.c()) {
                jSONObject.put("contractH5Url", (Object) wi.b.f48056t);
            }
            jSONObject.put("currencyCharacter", (Object) LegalCurrencyConfigUtil.y().toUpperCase());
            jSONObject.put("currencyRate", (Object) LegalCurrencyConfigUtil.v());
            jSONObject.put("priceColorType", (Object) Integer.valueOf(w.l() ? 0 : 1));
            jSONObject.put("colorMode", (Object) Integer.valueOf(NightHelper.e().g() ? 1 : 0));
            jSONObject.put("iconURLHost", (Object) AssetModuleConfig.a().j().replace(DomainTool.DOMAIN_PREFIX, ""));
            jSONObject.put("iconPlaceholder", (Object) "");
            jSONObject.put("OS", (Object) 1);
            jSONObject.put("bottomSafeAreaHeight", (Object) 0);
            jSONObject.put(AttributionReporter.APP_VERSION, (Object) 105400);
            jSONObject.put("language", (Object) p.a(bVar.d()).toLowerCase());
            jSONObject.put("webUrl", (Object) BaseModuleConfig.a().j());
            jSONObject.put("countryId", (Object) a.c().a());
            jSONObject.put("isChild", (Object) tg.r.x().X() ? "1" : "0");
            jSONObject.put("vToken", (Object) ku.b.e().h(bVar.d()));
            jSONObject.put("oldVToken", (Object) UcHelper.b(true));
            bVar.I("sendCommonConfig(" + jSONObject.toJSONString() + ")");
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }
}
