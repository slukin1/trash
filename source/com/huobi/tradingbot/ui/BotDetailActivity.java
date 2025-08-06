package com.huobi.tradingbot.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.n0;
import androidx.viewpager2.widget.ViewPager2;
import au.d;
import au.e;
import au.f;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hbg.lib.core.page.SmartRefreshHeader;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.module.content.custom.widget.TagLayoutWidget;
import com.hbg.module.libkt.base.ui.BaseActivity;
import com.huobi.copytrading.p038enum.Module;
import com.huobi.copytrading.ui.CopyTradingTradeFragment;
import com.huobi.edgeengine.util.EdgeEngineScene;
import com.huobi.engineutils.ability.AssetJumpAbility;
import com.huobi.trade.engine.TradeDataParser;
import com.huobi.tradingbot.bean.BotDetailTabInfo;
import com.huobi.tradingbot.vm.TradingBotViewModel;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import gs.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import kotlin.i;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.x;
import ky.j;
import lj.c;

@Route(path = "/trade/contractBotDetail")
public final class BotDetailActivity extends BaseActivity<c> {

    /* renamed from: i  reason: collision with root package name */
    public final String f83586i = "BotDetailActivity";

    /* renamed from: j  reason: collision with root package name */
    public final i f83587j = new n0(Reflection.b(TradingBotViewModel.class), new BotDetailActivity$special$$inlined$viewModels$default$2(this), new BotDetailActivity$special$$inlined$viewModels$default$1(this), new BotDetailActivity$special$$inlined$viewModels$default$3((d10.a) null, this));

    /* renamed from: k  reason: collision with root package name */
    public String f83588k = "";

    /* renamed from: l  reason: collision with root package name */
    public String f83589l = "BTC-USDT";

    /* renamed from: m  reason: collision with root package name */
    public String f83590m;

    /* renamed from: n  reason: collision with root package name */
    public rj.b f83591n;

    public static final class a extends TypeToken<List<? extends BotDetailTabInfo>> {
    }

    public static final class b extends ViewPager2.OnPageChangeCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BotDetailActivity f83592a;

        public b(BotDetailActivity botDetailActivity) {
            this.f83592a = botDetailActivity;
        }

        public void onPageScrollStateChanged(int i11) {
        }

        public void onPageScrolled(int i11, float f11, int i12) {
        }

        public void onPageSelected(int i11) {
            rj.b h02 = this.f83592a.Kh().h0();
            h02.I("botDetailHeader.tabClick(" + i11 + ')');
        }
    }

    public static final void Gh(BotDetailActivity botDetailActivity, j jVar) {
        jVar.finishRefresh();
        botDetailActivity.Kh().h0().I("botDetailPage.onBotDetailPullRefresh()");
    }

    @SensorsDataInstrumented
    public static final void Hh(BotDetailActivity botDetailActivity, View view) {
        AssetJumpAbility.C(botDetailActivity, botDetailActivity.f83588k, botDetailActivity.f83589l);
        g.i("tradingbot_botsdetails_share_app", (HashMap) null);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static final void Ih(BotDetailActivity botDetailActivity, View view) {
        ((c) botDetailActivity.Yf()).G.p();
        botDetailActivity.Kh().h0().I("botDetailPage.onBotDetailPullRefresh()");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static final void Nh(BotDetailActivity botDetailActivity, Object obj) {
        if (!botDetailActivity.isFinishing() && (obj instanceof String) && !TextUtils.isEmpty((CharSequence) obj)) {
            String str = (String) obj;
            int i11 = 0;
            if (!StringsKt__StringsJVMKt.x(botDetailActivity.f83590m, str, false, 2, (Object) null)) {
                botDetailActivity.f83590m = str;
                ArrayList arrayList = new ArrayList();
                List list = (List) new Gson().fromJson(str, new a().getType());
                if (list != null) {
                    for (Object next : list) {
                        int i12 = i11 + 1;
                        if (i11 < 0) {
                            CollectionsKt__CollectionsKt.t();
                        }
                        BotDetailTabInfo botDetailTabInfo = (BotDetailTabInfo) next;
                        TradingBotViewModel Kh = botDetailActivity.Kh();
                        StringBuilder sb2 = new StringBuilder();
                        String xml = botDetailTabInfo.getXml();
                        String str2 = "";
                        if (xml == null) {
                            xml = str2;
                        }
                        sb2.append(xml);
                        sb2.append(".xml");
                        String sb3 = sb2.toString();
                        String js2 = botDetailTabInfo.getJs();
                        if (js2 != null) {
                            str2 = js2;
                        }
                        View k02 = Kh.k0(sb3, str2);
                        if (k02 != null) {
                            arrayList.add(k02);
                        }
                        i11 = i12;
                    }
                }
                ((c) botDetailActivity.Yf()).K.setOffscreenPageLimit(arrayList.size());
                ((c) botDetailActivity.Yf()).K.setAdapter(new CopyTradingTradeFragment.b(arrayList));
            }
        }
    }

    public static final void Oh(BotDetailActivity botDetailActivity, Object obj) {
        if (!botDetailActivity.isFinishing() && (obj instanceof Integer)) {
            ((c) botDetailActivity.Yf()).K.setCurrentItem(((Number) obj).intValue(), true);
        }
    }

    public static final void Ph(BotDetailActivity botDetailActivity, Object obj) {
        if (!botDetailActivity.isFinishing() && (obj instanceof Integer)) {
            if (x.b(obj, 1)) {
                ((c) botDetailActivity.Yf()).G.g();
                ((c) botDetailActivity.Yf()).E.setVisibility(0);
            } else if (x.b(obj, 0)) {
                ((c) botDetailActivity.Yf()).G.k();
            }
        }
    }

    public final void Fh() {
        Mh();
        ((c) Yf()).H.i(true);
        ((c) Yf()).H.g(false);
        ((c) Yf()).H.V(false);
        ((c) Yf()).H.j0(new SmartRefreshHeader(this));
        ((c) Yf()).H.d0(new d(this));
        ((c) Yf()).B.setOnClickListener(new au.c(this));
        ((c) Yf()).G.setOnRetryClickListener(new au.b(this));
    }

    public final rj.b Jh() {
        rj.b bVar = this.f83591n;
        if (bVar != null) {
            return bVar;
        }
        return null;
    }

    public final TradingBotViewModel Kh() {
        return (TradingBotViewModel) this.f83587j.getValue();
    }

    /* renamed from: Lh */
    public c Og() {
        return c.K(getLayoutInflater());
    }

    public final void Mh() {
        Kh().m0(Module.TRADING_BOT_DETAIL_HEADER, ((c) Yf()).C);
        Kh().m0(Module.TRADING_BOT_DETAIL_TAB, ((c) Yf()).F);
        Kh().m0(Module.TRADING_BOT_DETAIL_BOTTOM_VIEW, ((c) Yf()).E);
        Kh().p0("botDetailPage.tabInfo", new f(this));
        Kh().p0("botDetailHeader.currentTabIndex", new au.g(this));
        Kh().p0("botDetailPage.pageStatus", new e(this));
        ((c) Yf()).K.registerOnPageChangeCallback(new b(this));
    }

    public final void Qh(rj.b bVar) {
        this.f83591n = bVar;
    }

    public final void Rh(Intent intent) {
        Bundle extras;
        Set<String> keySet;
        JSONObject jSONObject = new JSONObject();
        if (!(intent == null || (extras = intent.getExtras()) == null || (keySet = extras.keySet()) == null)) {
            for (String str : keySet) {
                jSONObject.put(str, intent.getStringExtra(str));
            }
        }
        rj.b Jh = Jh();
        Jh.I("botDetailPage.setPageParams(" + jSONObject + ')');
    }

    public void initView() {
        super.initView();
        ((c) Yf()).M(this);
        ((c) Yf()).F(this);
        getLifecycle().a(Kh());
        Kh().r0("botDetailPage");
        ((c) Yf()).G.p();
        Qg(NightHelper.e().g());
        rj.b Jh = Jh();
        Kh().q0(Jh);
        Kh().t0(EdgeEngineScene.TRADE_BOT.getScene());
        Jh.A("TraderListTags", TagLayoutWidget.class);
        Jh.z("trade_parser", TradeDataParser.class);
        yt.a.b(yt.a.f85088a, Jh, (String) null, 2, (Object) null);
        Fh();
        Rh(getIntent());
    }

    public void oh() {
        super.oh();
        String stringExtra = getIntent().getStringExtra("strategyId");
        if (stringExtra != null) {
            this.f83588k = stringExtra;
        }
        String stringExtra2 = getIntent().getStringExtra("symbol");
        if (stringExtra2 != null) {
            this.f83589l = stringExtra2;
        }
    }

    public void onCreate(Bundle bundle) {
        EdgeEngineScene edgeEngineScene = EdgeEngineScene.TRADE_BOT;
        Qh(new rj.b(this, edgeEngineScene.getScene()));
        Jh().H();
        ek.b.f47515a.f(Jh(), edgeEngineScene.getScene());
        super.onCreate(bundle);
    }

    public void onDestroy() {
        super.onDestroy();
        Jh().B();
    }

    public void onNewIntent(Intent intent) {
        String stringExtra;
        String stringExtra2;
        super.onNewIntent(intent);
        if (!(intent == null || (stringExtra2 = intent.getStringExtra("strategyId")) == null)) {
            this.f83588k = stringExtra2;
        }
        if (!(intent == null || (stringExtra = intent.getStringExtra("symbol")) == null)) {
            this.f83589l = stringExtra;
        }
        Rh(intent);
    }
}
