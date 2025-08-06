package com.huobi.tradingbot.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.lifecycle.n0;
import au.h;
import au.k;
import au.l;
import au.m;
import au.n;
import au.o;
import au.p;
import au.q;
import au.r;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.fastjson.JSONObject;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.page.SmartRefreshHeader;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.future.util.FuturePrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.linear.swap.controller.LinearSwapCurrencyInfoController;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapContractInfo;
import com.hbg.module.content.custom.widget.TagLayoutWidget;
import com.hbg.module.kline.view.KlineViewWrapper;
import com.hbg.module.libkt.base.ui.BaseActivity;
import com.huobi.copytrading.p038enum.Module;
import com.huobi.domain.DomainSwitcher;
import com.huobi.edgeengine.util.EdgeEngineScene;
import com.huobi.trade.engine.TradeDataParser;
import com.huobi.tradingbot.manager.GridLeverageRangeController;
import com.huobi.tradingbot.vm.TradingBotViewModel;
import com.huochat.community.network.domain.DomainTool;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.List;
import java.util.Set;
import kotlin.i;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.x;
import ky.j;
import lj.e;
import pro.huobi.R;
import u6.g;

@Route(path = "/trade/contractGrid")
public final class ContractGridActivity extends BaseActivity<e> {

    /* renamed from: i  reason: collision with root package name */
    public final String f83593i = "ContractGridActivity";

    /* renamed from: j  reason: collision with root package name */
    public boolean f83594j;

    /* renamed from: k  reason: collision with root package name */
    public final i f83595k = new n0(Reflection.b(TradingBotViewModel.class), new ContractGridActivity$special$$inlined$viewModels$default$2(this), new ContractGridActivity$special$$inlined$viewModels$default$1(this), new ContractGridActivity$special$$inlined$viewModels$default$3((d10.a) null, this));

    /* renamed from: l  reason: collision with root package name */
    public String f83596l = com.sumsub.sentry.a.f30241h;

    /* renamed from: m  reason: collision with root package name */
    public int f83597m;

    /* renamed from: n  reason: collision with root package name */
    public rj.b f83598n;

    public static final class a extends EasySubscriber<List<? extends String>> {
    }

    public static final class b extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ContractGridActivity f83599b;

        public b(ContractGridActivity contractGridActivity) {
            this.f83599b = contractGridActivity;
        }

        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            this.f83599b.w3();
        }
    }

    public static final class c extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ContractGridActivity f83600b;

        public c(ContractGridActivity contractGridActivity) {
            this.f83600b = contractGridActivity;
        }

        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            this.f83600b.f83594j = true;
            ContractGridActivity.Jh(this.f83600b).G.r();
        }
    }

    public static final /* synthetic */ e Jh(ContractGridActivity contractGridActivity) {
        return (e) contractGridActivity.Yf();
    }

    public static final void Nh(ContractGridActivity contractGridActivity, Object obj) {
        if (x.b((Boolean) obj, Boolean.TRUE)) {
            contractGridActivity.fi();
        } else {
            contractGridActivity.ai();
        }
    }

    public static final void Oh(ContractGridActivity contractGridActivity, Object obj) {
        KlineViewWrapper klineViewWrapper;
        if ((obj instanceof List) && (klineViewWrapper = ((e) contractGridActivity.Yf()).G.F) != null) {
            klineViewWrapper.I((List) obj, 3);
        }
    }

    public static final void Ph(ContractGridActivity contractGridActivity, Object obj) {
        KlineViewWrapper klineViewWrapper;
        if ((obj instanceof List) && (klineViewWrapper = ((e) contractGridActivity.Yf()).G.F) != null) {
            klineViewWrapper.I((List) obj, 4);
        }
    }

    public static final void Qh(ContractGridActivity contractGridActivity, Object obj) {
        if (obj instanceof String) {
            String str = (String) obj;
            contractGridActivity.hi(str);
            contractGridActivity.Wh(str);
        }
    }

    public static final void Rh(ContractGridActivity contractGridActivity, Object obj) {
        if (!(obj instanceof Integer)) {
            return;
        }
        if (x.b(obj, 0)) {
            ((e) contractGridActivity.Yf()).L.setVisibility(0);
            ((e) contractGridActivity.Yf()).J.setVisibility(0);
            ((e) contractGridActivity.Yf()).K.setVisibility(8);
            ((e) contractGridActivity.Yf()).I.setVisibility(8);
            return;
        }
        ((e) contractGridActivity.Yf()).L.setVisibility(8);
        ((e) contractGridActivity.Yf()).K.setVisibility(0);
        ((e) contractGridActivity.Yf()).J.setVisibility(8);
        ((e) contractGridActivity.Yf()).I.setVisibility(0);
    }

    public static final void Sh(ContractGridActivity contractGridActivity, j jVar) {
        jVar.finishRefresh();
        contractGridActivity.Wh(((e) contractGridActivity.Yf()).G.M);
        contractGridActivity.Yh().h0().I("contractGridPage.onGridPullRefresh()");
    }

    @SensorsDataInstrumented
    public static final void Th(View view) {
        BaseModuleConfig.a().k0(BaseModuleConfig.a().j() + '/' + m6.a.j() + "/tradingbot/h5/my-strategies?showbar=1&currentType=contract");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static final void Uh(ContractGridActivity contractGridActivity, View view) {
        HBBaseWebActivity.showWebView(contractGridActivity, DomainTool.DOMAIN_PREFIX + DomainSwitcher.w() + '/' + AppLanguageHelper.getInstance().getCurLanguageUrlLowerCase() + "/support/74987199455424", "", "", false);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static final void Vh(View view) {
        zn.a.d().v(Uri.parse("holigeit://open/v1?url=ihuobiglobal://m.hbg.com/edgeengine/container?scene=tradingBot&rootName=botSearch&xml=bot_search&navConfig=")).c();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static final void bi(ContractGridActivity contractGridActivity, ValueAnimator valueAnimator) {
        ((e) contractGridActivity.Yf()).H.getLayoutParams().height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        ((e) contractGridActivity.Yf()).H.requestLayout();
    }

    public static final void gi(ContractGridActivity contractGridActivity, ValueAnimator valueAnimator) {
        ((e) contractGridActivity.Yf()).H.getLayoutParams().height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        ((e) contractGridActivity.Yf()).H.requestLayout();
    }

    public final void Mh() {
        ci();
        ((e) Yf()).Q.i(true);
        ((e) Yf()).Q.g(false);
        ((e) Yf()).Q.V(false);
        ((e) Yf()).Q.j0(new SmartRefreshHeader(this));
        ((e) Yf()).Q.d0(new n(this));
        ((e) Yf()).C.setOnClickListener(m.f12223b);
        ((e) Yf()).E.setOnClickListener(new k(this));
        ((e) Yf()).D.setOnClickListener(l.f12222b);
        Yh().p0("contractTopSymbol.isOpen", new au.i(this));
        Yh().p0("contractGridPage.gridPriceData", new o(this));
        Yh().p0("contractGridPage.minMaxPrice", new q(this));
        Yh().p0("contractTopSymbol.currentSymbol", new r(this));
        Yh().p0("contractGridPage.currentIndex", new p(this));
    }

    public final void Wh(String str) {
        if (str != null) {
            GridLeverageRangeController.b(false, str).compose(RxJavaHelper.t((g) null)).retry(3).subscribe(new a());
        }
    }

    public final rj.b Xh() {
        rj.b bVar = this.f83598n;
        if (bVar != null) {
            return bVar;
        }
        return null;
    }

    public final TradingBotViewModel Yh() {
        return (TradingBotViewModel) this.f83595k.getValue();
    }

    /* renamed from: Zh */
    public e Og() {
        return e.K(getLayoutInflater());
    }

    public final void ai() {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{((e) Yf()).H.getHeight(), 0});
        ofInt.setDuration(220);
        ofInt.setInterpolator(new DecelerateInterpolator());
        ofInt.addUpdateListener(new au.j(this));
        ofInt.addListener(new b(this));
        ofInt.start();
    }

    public final void ci() {
        Yh().m0(Module.TRADING_BOT_CONTRACT_TOP_AD_BANNER, ((e) Yf()).N);
        Yh().m0(Module.TRADING_BOT_CONTRACT_TOP_SYMBOL, ((e) Yf()).O);
        Yh().m0(Module.TRADING_BOT_CONTRACT_TAB, ((e) Yf()).M);
        Yh().m0(Module.TRADING_BOT_TRADE_FILTER, ((e) Yf()).L);
        Yh().m0(Module.TRADING_BOT_CONTRACT_LIST, ((e) Yf()).J);
        Yh().m0(Module.TRADING_BOT_CONTRACT_EDIT_PAGE, ((e) Yf()).K);
        Yh().m0(Module.TRADING_BOT_CONTRACT_BOTTOM_VIEW, ((e) Yf()).I);
        ei(getIntent());
    }

    public final void di(rj.b bVar) {
        this.f83598n = bVar;
    }

    public final void ei(Intent intent) {
        Bundle extras;
        Set<String> keySet;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("pageType", 1);
        if (!(intent == null || (extras = intent.getExtras()) == null || (keySet = extras.keySet()) == null)) {
            for (String str : keySet) {
                jSONObject.put(str, intent.getStringExtra(str));
            }
        }
        rj.b Xh = Xh();
        Xh.I("contractGridPage.setPageParams(" + jSONObject + ')');
    }

    public final void fi() {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{0, ((e) Yf()).G.getLayoutParams().height + (getResources().getDimensionPixelOffset(R.dimen.global_divider_height) * 2) + getResources().getDimensionPixelOffset(R.dimen.dimen_8) + 1});
        ofInt.setDuration(220);
        ofInt.setInterpolator(new DecelerateInterpolator());
        ofInt.addUpdateListener(new h(this));
        ofInt.addListener(new c(this));
        ofInt.start();
    }

    public final void hi(String str) {
        int i11;
        int i12;
        LinearSwapContractInfo n11 = LinearSwapCurrencyInfoController.l().n(str);
        if (n11 != null) {
            FutureContractInfo futureContractInfo = new FutureContractInfo();
            futureContractInfo.convert(futureContractInfo, n11);
            i11 = FuturePrecisionUtil.s(futureContractInfo.getContractCode(), futureContractInfo.getContractShortType(), "");
            i12 = FuturePrecisionUtil.y(futureContractInfo.getContractCode(), futureContractInfo.getContractShortType(), (String) null);
        } else {
            i12 = 8;
            i11 = 8;
        }
        if (!TextUtils.equals(str, ((e) Yf()).G.M)) {
            ((KlineViewWrapper) ((e) Yf()).G.findViewById(R.id.klineViewWrapper)).G();
        }
        ((e) Yf()).G.i(false, TradeType.LINEAR_SWAP.toString(), str, i12, i11);
        if (this.f83594j) {
            ((e) Yf()).G.r();
        }
    }

    public void initView() {
        super.initView();
        ((e) Yf()).M(this);
        ((e) Yf()).N(Yh());
        ((e) Yf()).F(this);
        getLifecycle().a(Yh());
        Yh().r0("contractGridPage");
        Qg(NightHelper.e().g());
        rj.b Xh = Xh();
        Yh().q0(Xh);
        Yh().t0("");
        Xh.A("TraderListTags", TagLayoutWidget.class);
        Xh.z("trade_parser", TradeDataParser.class);
        yt.a aVar = yt.a.f85088a;
        aVar.a(Xh, this.f83596l);
        aVar.c(Xh);
        Mh();
    }

    public void oh() {
        super.oh();
        String stringExtra = getIntent().getStringExtra("source");
        if (stringExtra != null) {
            this.f83596l = stringExtra;
        }
        this.f83597m = getIntent().getIntExtra("tabIndex", 0);
    }

    public void onCreate(Bundle bundle) {
        EdgeEngineScene edgeEngineScene = EdgeEngineScene.TRADE_BOT;
        di(new rj.b(this, edgeEngineScene.getScene()));
        Xh().H();
        ek.b.f47515a.f(Xh(), edgeEngineScene.getScene());
        super.onCreate(bundle);
    }

    public void onDestroy() {
        super.onDestroy();
        Xh().B();
    }

    public void onNewIntent(Intent intent) {
        String stringExtra;
        super.onNewIntent(intent);
        if (!(intent == null || (stringExtra = intent.getStringExtra("source")) == null)) {
            this.f83596l = stringExtra;
        }
        if (intent != null) {
            this.f83597m = intent.getIntExtra("tabIndex", 0);
        }
        ei(intent);
    }

    public final void w3() {
        if (this.f83594j) {
            ((e) Yf()).H.getLayoutParams().height = 0;
            ((KlineViewWrapper) ((e) Yf()).G.findViewById(R.id.klineViewWrapper)).C();
            ((e) Yf()).H.requestLayout();
        }
        this.f83594j = false;
    }
}
