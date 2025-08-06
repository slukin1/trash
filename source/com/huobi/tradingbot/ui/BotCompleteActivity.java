package com.huobi.tradingbot.ui;

import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.n0;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.fastjson.JSONObject;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.module.content.custom.widget.TagLayoutWidget;
import com.hbg.module.libkt.base.ui.BaseActivity;
import com.huobi.copytrading.p038enum.Module;
import com.huobi.edgeengine.util.EdgeEngineScene;
import com.huobi.trade.engine.TradeDataParser;
import com.huobi.tradingbot.vm.TradingBotViewModel;
import java.util.Set;
import kotlin.i;
import kotlin.jvm.internal.Reflection;
import lj.a;
import rj.b;

@Route(path = "/trade/botCompletion")
public final class BotCompleteActivity extends BaseActivity<a> {

    /* renamed from: i  reason: collision with root package name */
    public final String f83582i = "BotCompleteActivity";

    /* renamed from: j  reason: collision with root package name */
    public final i f83583j = new n0(Reflection.b(TradingBotViewModel.class), new BotCompleteActivity$special$$inlined$viewModels$default$2(this), new BotCompleteActivity$special$$inlined$viewModels$default$1(this), new BotCompleteActivity$special$$inlined$viewModels$default$3((d10.a) null, this));

    /* renamed from: k  reason: collision with root package name */
    public String f83584k = "";

    /* renamed from: l  reason: collision with root package name */
    public b f83585l;

    public static final void Dh(BotCompleteActivity botCompleteActivity, Object obj) {
        if (!botCompleteActivity.isFinishing()) {
            boolean z11 = obj instanceof Integer;
        }
    }

    public final TradingBotViewModel Ah() {
        return (TradingBotViewModel) this.f83583j.getValue();
    }

    /* renamed from: Bh */
    public a Og() {
        return a.K(getLayoutInflater());
    }

    public final void Ch() {
        Ah().m0(Module.TRADING_BOT_HANDLE_COMPLETION, ((a) Yf()).B);
        Ah().p0("botHandleCompletionPage.currentTabIndex", new au.a(this));
    }

    public final void Eh(b bVar) {
        this.f83585l = bVar;
    }

    public void initView() {
        Bundle extras;
        Set<String> keySet;
        super.initView();
        ((a) Yf()).M(this);
        ((a) Yf()).F(this);
        getLifecycle().a(Ah());
        Ah().r0("botHandleCompletionPage");
        Qg(NightHelper.e().g());
        b zh2 = zh();
        Ah().q0(zh2);
        Ah().t0(EdgeEngineScene.TRADE_BOT.getScene());
        zh2.A("TraderListTags", TagLayoutWidget.class);
        zh2.z("trade_parser", TradeDataParser.class);
        yt.a.b(yt.a.f85088a, zh2, (String) null, 2, (Object) null);
        Ch();
        JSONObject jSONObject = new JSONObject();
        Intent intent = getIntent();
        if (!(intent == null || (extras = intent.getExtras()) == null || (keySet = extras.keySet()) == null)) {
            for (String str : keySet) {
                jSONObject.put(str, getIntent().getStringExtra(str));
            }
        }
        b zh3 = zh();
        zh3.I("botHandleCompletionPage.setPageParams(" + jSONObject + ')');
    }

    public void oh() {
        super.oh();
        String stringExtra = getIntent().getStringExtra("strategyId");
        if (stringExtra != null) {
            this.f83584k = stringExtra;
        }
    }

    public void onCreate(Bundle bundle) {
        EdgeEngineScene edgeEngineScene = EdgeEngineScene.TRADE_BOT;
        Eh(new b(this, edgeEngineScene.getScene()));
        zh().H();
        ek.b.f47515a.f(zh(), edgeEngineScene.getScene());
        super.onCreate(bundle);
    }

    public void onDestroy() {
        super.onDestroy();
        zh().B();
    }

    public void onNewIntent(Intent intent) {
        String stringExtra;
        super.onNewIntent(intent);
        if (intent != null && (stringExtra = intent.getStringExtra("strategyId")) != null) {
            this.f83584k = stringExtra;
        }
    }

    public final b zh() {
        b bVar = this.f83585l;
        if (bVar != null) {
            return bVar;
        }
        return null;
    }
}
