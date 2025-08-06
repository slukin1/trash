package com.huobi.otc.edgeengine.p2p;

import android.widget.FrameLayout;
import androidx.annotation.Keep;
import com.alibaba.fastjson.JSON;
import com.blankj.utilcode.util.KeyboardUtils;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.core.util.p;
import com.huobi.edgeengine.ability.AbilityFunction;
import com.huobi.edgeengine.util.EdgeEngineScene;
import com.huobi.otc.helper.OtcMerchantProfileSwither;
import i6.d;
import java.util.HashMap;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import pro.huobi.R;
import rj.b;
import u6.g;

public class OtcMerchantSearchActivity extends BaseActivity<OtcMerchantSearchPresenter, g> {

    /* renamed from: b  reason: collision with root package name */
    public b f78366b;

    /* renamed from: c  reason: collision with root package name */
    public FrameLayout f78367c;

    /* renamed from: Xf */
    public OtcMerchantSearchPresenter createPresenter() {
        return new OtcMerchantSearchPresenter();
    }

    public final void Yf() {
        if (this.f78366b != null) {
            ek.b.f47515a.i(EdgeEngineScene.OTC_MERCHANT_SEARCH.getScene());
        }
        this.f78366b = ek.b.f47515a.b(this, EdgeEngineScene.OTC_MERCHANT_SEARCH.getScene());
        Zf();
        this.f78367c.addView(this.f78366b.D("merchant_search_page.xml", this), 0);
    }

    public void Zf() {
        HashMap hashMap = new HashMap();
        hashMap.put("language", p.a(this.f78366b.d()).toLowerCase());
        hashMap.put("colorMode", NightHelper.e().g() ? "1" : "0");
        hashMap.put("OS", "1");
        b bVar = this.f78366b;
        bVar.I("sendCommonConfig(" + JSON.toJSONString(hashMap) + ")");
    }

    public void addEvent() {
    }

    public int getContentView() {
        return R.layout.activity_otc_merchant_search;
    }

    public g getUI() {
        return this;
    }

    public void initView() {
        this.f78367c = (FrameLayout) this.viewFinder.b(R.id.fl_root);
        Yf();
        EventBus.d().p(this);
    }

    public void onDestroy() {
        super.onDestroy();
        if (EventBus.d().i(this)) {
            EventBus.d().r(this);
        }
        ek.b.f47515a.e(EdgeEngineScene.OTC_MERCHANT_SEARCH.getScene());
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onMerchantSearchEvent(OtcMerchantSearchEvent otcMerchantSearchEvent) {
        if (getUI().isAlive()) {
            KeyboardUtils.j(this.f78367c);
            AbilityFunction.a c11 = otcMerchantSearchEvent.c();
            String b11 = otcMerchantSearchEvent.b();
            d.j("adfsdfdsfaf", "OtcMerchantSearchEvent action--->" + b11);
            b11.hashCode();
            if (b11.equals("onBackClick")) {
                finish();
            } else if (b11.equals("goToMerchantPage")) {
                OtcMerchantProfileSwither.a(this, Long.valueOf(otcMerchantSearchEvent.d()));
            }
            c11.a(true, (Object) null);
        }
    }
}
