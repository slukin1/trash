package com.huobi.tradingbot.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Keep;
import androidx.lifecycle.n0;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.fastjson.JSONObject;
import com.google.android.material.appbar.AppBarLayout;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.network.pro.core.bean.ProTokenUpdate;
import com.hbg.module.content.custom.widget.TagLayoutWidget;
import com.hbg.module.libkt.base.ui.BaseActivity;
import com.huobi.account.event.LogOutEvent;
import com.huobi.copytrading.p038enum.Module;
import com.huobi.edgeengine.util.EdgeEngineScene;
import com.huobi.homemarket.helper.AppBarStateChangeListener;
import com.huobi.trade.engine.TradeDataParser;
import com.huobi.tradingbot.vm.TradingBotViewModel;
import com.huobi.utils.v0;
import com.huobi.view.MarketTitleLayout;
import com.huobi.view.TitleLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import gs.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import k20.h;
import kotlin.i;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.Reflection;
import ky.j;
import lj.s;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;

@Route(path = "/trade/bot")
public final class TradingBotActivity extends BaseActivity<s> {

    /* renamed from: i  reason: collision with root package name */
    public RecyclerView f83618i;

    /* renamed from: j  reason: collision with root package name */
    public final String f83619j = "TradingBotActivity";

    /* renamed from: k  reason: collision with root package name */
    public final int f83620k = 1;

    /* renamed from: l  reason: collision with root package name */
    public final int f83621l = 2;

    /* renamed from: m  reason: collision with root package name */
    public final int f83622m = 3;

    /* renamed from: n  reason: collision with root package name */
    public final int f83623n = 4;

    /* renamed from: o  reason: collision with root package name */
    public final i f83624o = new n0(Reflection.b(TradingBotViewModel.class), new TradingBotActivity$special$$inlined$viewModels$default$2(this), new TradingBotActivity$special$$inlined$viewModels$default$1(this), new TradingBotActivity$special$$inlined$viewModels$default$3((d10.a) null, this));

    /* renamed from: p  reason: collision with root package name */
    public String f83625p = com.sumsub.sentry.a.f30241h;

    /* renamed from: q  reason: collision with root package name */
    public int f83626q = 1;

    /* renamed from: r  reason: collision with root package name */
    public HashMap<Integer, Integer> f83627r = new HashMap<>(4);

    /* renamed from: s  reason: collision with root package name */
    public final ArrayList<String> f83628s = new ArrayList<>();

    /* renamed from: t  reason: collision with root package name */
    public rj.b f83629t;

    public static final class a extends AppBarStateChangeListener {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ TradingBotActivity f83630c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Ref$ObjectRef<d> f83631d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Ref$ObjectRef<c> f83632e;

        public a(TradingBotActivity tradingBotActivity, Ref$ObjectRef<d> ref$ObjectRef, Ref$ObjectRef<c> ref$ObjectRef2) {
            this.f83630c = tradingBotActivity;
            this.f83631d = ref$ObjectRef;
            this.f83632e = ref$ObjectRef2;
        }

        public void a(AppBarLayout appBarLayout, AppBarStateChangeListener.State state) {
            String Nh = this.f83630c.Nh();
            i6.d.c(Nh, "onStateChanged state: " + state);
            if (state == AppBarStateChangeListener.State.COLLAPSED) {
                TradingBotActivity.Ch(this.f83630c).F.animate().setListener((Animator.AnimatorListener) this.f83631d.element).alpha(1.0f).setDuration(200).start();
            } else {
                TradingBotActivity.Ch(this.f83630c).F.animate().setListener((Animator.AnimatorListener) this.f83632e.element).alpha(0.0f).setDuration(200).start();
            }
        }
    }

    public static final class b implements TitleLayout.OnTitleListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TradingBotActivity f83633b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ MarketTitleLayout f83634c;

        public b(TradingBotActivity tradingBotActivity, MarketTitleLayout marketTitleLayout) {
            this.f83633b = tradingBotActivity;
            this.f83634c = marketTitleLayout;
        }

        public void onTitleChange(int i11) {
            int scrollX = TradingBotActivity.Ch(this.f83633b).D.getScrollX();
            View childAt = this.f83634c.getChildAt(i11);
            int left = childAt.getLeft();
            if (left < scrollX) {
                TradingBotActivity.Ch(this.f83633b).D.smoothScrollBy(left - scrollX, 0);
            }
            int right = childAt.getRight();
            int measuredWidth = TradingBotActivity.Ch(this.f83633b).D.getMeasuredWidth();
            if (measuredWidth + scrollX < right) {
                TradingBotActivity.Ch(this.f83633b).D.smoothScrollBy((right - scrollX) - measuredWidth, 0);
            }
            rj.b h02 = this.f83633b.Mh().h0();
            h02.I("onSelectedIndex(" + this.f83633b.f83627r.get(Integer.valueOf(i11)) + ')');
        }

        public void onTitleStatueChange(int i11, boolean z11) {
        }
    }

    public static final class c extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TradingBotActivity f83635b;

        public c(TradingBotActivity tradingBotActivity) {
            this.f83635b = tradingBotActivity;
        }

        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            TradingBotActivity.Ch(this.f83635b).F.setVisibility(8);
        }
    }

    public static final class d extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TradingBotActivity f83636b;

        public d(TradingBotActivity tradingBotActivity) {
            this.f83636b = tradingBotActivity;
        }

        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            TradingBotActivity.Ch(this.f83636b).F.setVisibility(0);
        }
    }

    public static final /* synthetic */ s Ch(TradingBotActivity tradingBotActivity) {
        return (s) tradingBotActivity.Yf();
    }

    public static final void Gh(TradingBotActivity tradingBotActivity, j jVar) {
        jVar.finishRefresh();
        tradingBotActivity.Mh().h0().I("tradePage.onTraderPullRefresh()");
    }

    @SensorsDataInstrumented
    public static final void Hh(TradingBotActivity tradingBotActivity, View view) {
        HBBaseWebActivity.showWebView(tradingBotActivity, v0.b("84975976936694"), "", "", false);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static final void Ih(View view) {
        zn.a.d().v(Uri.parse("holigeit://open/v1?url=ihuobiglobal://m.hbg.com/edgeengine/container?scene=tradingBot&rootName=botSearch&xml=bot_search&navConfig=")).c();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static final void Jh(TradingBotActivity tradingBotActivity, View view) {
        ((s) tradingBotActivity.Yf()).B.setExpanded(true, true);
        tradingBotActivity.Kh(((s) tradingBotActivity.Yf()).K);
        RecyclerView recyclerView = tradingBotActivity.f83618i;
        if (recyclerView != null) {
            recyclerView.scrollToPosition(0);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x01bd  */
    /* JADX WARNING: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void Fh() {
        /*
            r6 = this;
            r6.Ph()
            java.util.ArrayList<java.lang.String> r0 = r6.f83628s
            android.content.res.Resources r1 = r6.getResources()
            r2 = 2132024975(0x7f141e8f, float:1.9688441E38)
            java.lang.String r1 = r1.getString(r2)
            r0.add(r1)
            java.util.HashMap<java.lang.Integer, java.lang.Integer> r0 = r6.f83627r
            java.util.ArrayList<java.lang.String> r1 = r6.f83628s
            int r1 = r1.size()
            r2 = 1
            int r1 = r1 - r2
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            int r3 = r6.f83620k
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r0.put(r1, r3)
            java.util.ArrayList<java.lang.String> r0 = r6.f83628s
            android.content.res.Resources r1 = r6.getResources()
            r3 = 2132024849(0x7f141e11, float:1.9688186E38)
            java.lang.String r1 = r1.getString(r3)
            r0.add(r1)
            java.util.HashMap<java.lang.Integer, java.lang.Integer> r0 = r6.f83627r
            java.util.ArrayList<java.lang.String> r1 = r6.f83628s
            int r1 = r1.size()
            int r1 = r1 - r2
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            int r3 = r6.f83623n
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r0.put(r1, r3)
            java.util.ArrayList<java.lang.String> r0 = r6.f83628s
            android.content.res.Resources r1 = r6.getResources()
            r3 = 2132024977(0x7f141e91, float:1.9688445E38)
            java.lang.String r1 = r1.getString(r3)
            r0.add(r1)
            java.util.HashMap<java.lang.Integer, java.lang.Integer> r0 = r6.f83627r
            java.util.ArrayList<java.lang.String> r1 = r6.f83628s
            int r1 = r1.size()
            int r1 = r1 - r2
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            int r3 = r6.f83621l
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r0.put(r1, r3)
            java.util.ArrayList<java.lang.String> r0 = r6.f83628s
            android.content.res.Resources r1 = r6.getResources()
            r3 = 2132024918(0x7f141e56, float:1.9688326E38)
            java.lang.String r1 = r1.getString(r3)
            r0.add(r1)
            java.util.HashMap<java.lang.Integer, java.lang.Integer> r0 = r6.f83627r
            java.util.ArrayList<java.lang.String> r1 = r6.f83628s
            int r1 = r1.size()
            int r1 = r1 - r2
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            int r3 = r6.f83622m
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r0.put(r1, r3)
            int r0 = r6.f83626q
            int r1 = r6.f83620k
            r3 = 0
            if (r0 != r1) goto L_0x00a5
        L_0x00a3:
            r0 = r3
            goto L_0x00ba
        L_0x00a5:
            int r4 = r6.f83623n
            if (r0 != r4) goto L_0x00ab
            r0 = r2
            goto L_0x00ba
        L_0x00ab:
            int r4 = r6.f83621l
            if (r0 != r4) goto L_0x00b1
            r0 = 2
            goto L_0x00ba
        L_0x00b1:
            int r4 = r6.f83622m
            if (r0 != r4) goto L_0x00b7
            r0 = 3
            goto L_0x00ba
        L_0x00b7:
            r6.f83626q = r1
            goto L_0x00a3
        L_0x00ba:
            x1.a r1 = r6.Yf()
            lj.s r1 = (lj.s) r1
            com.scwang.smartrefresh.layout.SmartRefreshLayout r1 = r1.L
            r1.i(r2)
            x1.a r1 = r6.Yf()
            lj.s r1 = (lj.s) r1
            com.scwang.smartrefresh.layout.SmartRefreshLayout r1 = r1.L
            r1.g(r3)
            x1.a r1 = r6.Yf()
            lj.s r1 = (lj.s) r1
            com.scwang.smartrefresh.layout.SmartRefreshLayout r1 = r1.L
            r1.V(r3)
            x1.a r1 = r6.Yf()
            lj.s r1 = (lj.s) r1
            com.scwang.smartrefresh.layout.SmartRefreshLayout r1 = r1.L
            com.hbg.lib.core.page.SmartRefreshHeader r2 = new com.hbg.lib.core.page.SmartRefreshHeader
            r2.<init>(r6)
            r1.j0(r2)
            x1.a r1 = r6.Yf()
            lj.s r1 = (lj.s) r1
            com.scwang.smartrefresh.layout.SmartRefreshLayout r1 = r1.L
            au.a0 r2 = new au.a0
            r2.<init>(r6)
            r1.d0(r2)
            x1.a r1 = r6.Yf()
            lj.s r1 = (lj.s) r1
            android.widget.ImageView r1 = r1.G
            au.x r2 = new au.x
            r2.<init>(r6)
            r1.setOnClickListener(r2)
            x1.a r1 = r6.Yf()
            lj.s r1 = (lj.s) r1
            android.widget.ImageView r1 = r1.E
            au.z r2 = au.z.f12236b
            r1.setOnClickListener(r2)
            x1.a r1 = r6.Yf()
            lj.s r1 = (lj.s) r1
            android.widget.ImageView r1 = r1.F
            au.y r2 = new au.y
            r2.<init>(r6)
            r1.setOnClickListener(r2)
            kotlin.jvm.internal.Ref$ObjectRef r1 = new kotlin.jvm.internal.Ref$ObjectRef
            r1.<init>()
            com.huobi.tradingbot.ui.TradingBotActivity$d r2 = new com.huobi.tradingbot.ui.TradingBotActivity$d
            r2.<init>(r6)
            r1.element = r2
            kotlin.jvm.internal.Ref$ObjectRef r2 = new kotlin.jvm.internal.Ref$ObjectRef
            r2.<init>()
            com.huobi.tradingbot.ui.TradingBotActivity$c r4 = new com.huobi.tradingbot.ui.TradingBotActivity$c
            r4.<init>(r6)
            r2.element = r4
            x1.a r4 = r6.Yf()
            lj.s r4 = (lj.s) r4
            com.google.android.material.appbar.AppBarLayout r4 = r4.B
            com.huobi.tradingbot.ui.TradingBotActivity$a r5 = new com.huobi.tradingbot.ui.TradingBotActivity$a
            r5.<init>(r6, r1, r2)
            r4.addOnOffsetChangedListener((com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener) r5)
            x1.a r1 = r6.Yf()
            lj.s r1 = (lj.s) r1
            com.huobi.view.MarketTitleLayout r1 = r1.M
            r1.setItemSpace(r3)
            android.content.res.Resources r2 = r1.getResources()
            r3 = 2131166250(0x7f07042a, float:1.794674E38)
            int r2 = r2.getDimensionPixelOffset(r3)
            r1.setItemPaddingLeft(r2)
            android.content.res.Resources r2 = r1.getResources()
            int r2 = r2.getDimensionPixelOffset(r3)
            r1.setItemPaddingRight(r2)
            android.content.res.Resources r2 = r1.getResources()
            r3 = 2131165529(0x7f070159, float:1.7945278E38)
            int r2 = r2.getDimensionPixelSize(r3)
            float r2 = (float) r2
            r1.setNormalTextSize(r2)
            android.content.res.Resources r2 = r1.getResources()
            r3 = 2131165617(0x7f0701b1, float:1.7945456E38)
            int r2 = r2.getDimensionPixelSize(r3)
            float r2 = (float) r2
            r1.setSelectedTextSize(r2)
            android.content.res.Resources r2 = r1.getResources()
            r3 = 2131099918(0x7f06010e, float:1.7812203E38)
            int r2 = r2.getColor(r3)
            r1.setNormalColor(r2)
            android.content.res.Resources r2 = r1.getResources()
            r3 = 2131099907(0x7f060103, float:1.781218E38)
            int r2 = r2.getColor(r3)
            r1.setSelectedColor(r2)
            com.huobi.tradingbot.ui.TradingBotActivity$b r2 = new com.huobi.tradingbot.ui.TradingBotActivity$b
            r2.<init>(r6, r1)
            r1.setTitleListener(r2)
            java.util.ArrayList<java.lang.String> r2 = r6.f83628s
            r1.setTitles(r2, r0)
            if (r0 <= 0) goto L_0x01e0
            com.huobi.tradingbot.vm.TradingBotViewModel r0 = r6.Mh()
            rj.b r0 = r0.h0()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "onSelectedIndex("
            r1.append(r2)
            int r2 = r6.f83626q
            r1.append(r2)
            r2 = 41
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.I(r1)
        L_0x01e0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.tradingbot.ui.TradingBotActivity.Fh():void");
    }

    public final void Kh(View view) {
        if (this.f83618i == null && (view instanceof ViewGroup)) {
            int i11 = 0;
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            while (i11 < childCount) {
                View childAt = viewGroup.getChildAt(i11);
                if (childAt instanceof RecyclerView) {
                    this.f83618i = (RecyclerView) childAt;
                    return;
                } else {
                    Kh(childAt);
                    i11++;
                }
            }
        }
    }

    public final rj.b Lh() {
        rj.b bVar = this.f83629t;
        if (bVar != null) {
            return bVar;
        }
        return null;
    }

    public final TradingBotViewModel Mh() {
        return (TradingBotViewModel) this.f83624o.getValue();
    }

    public final String Nh() {
        return this.f83619j;
    }

    /* renamed from: Oh */
    public s Og() {
        return s.K(getLayoutInflater());
    }

    public final void Ph() {
        Mh().m0(Module.TRADING_BOT_TRADE_TOP_ASSET, ((s) Yf()).J);
        Mh().m0(Module.TRADING_BOT_TRADE_CREATE_BOT, ((s) Yf()).J);
        Mh().m0(Module.TRADING_BOT_TRADE_FILTER, ((s) Yf()).I);
        Mh().m0(Module.TRADING_BOT_TRADE_LIST, ((s) Yf()).K);
    }

    public final void Qh(rj.b bVar) {
        this.f83629t = bVar;
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
        rj.b Lh = Lh();
        Lh.I("tradePage.setPageParams(" + jSONObject + ')');
    }

    public void initView() {
        super.initView();
        ((s) Yf()).M(this);
        ((s) Yf()).N(Mh());
        ((s) Yf()).F(this);
        getLifecycle().a(Mh());
        Mh().r0("tradePage");
        Qg(NightHelper.e().g());
        rj.b Lh = Lh();
        Mh().q0(Lh);
        Mh().t0(EdgeEngineScene.TRADE_BOT.getScene());
        Lh.A("TraderListTags", TagLayoutWidget.class);
        Lh.z("trade_parser", TradeDataParser.class);
        yt.a aVar = yt.a.f85088a;
        aVar.a(Lh, this.f83625p);
        aVar.c(Lh);
        Fh();
        Rh(getIntent());
    }

    public void oh() {
        super.oh();
        String stringExtra = getIntent().getStringExtra("source");
        if (stringExtra != null) {
            this.f83625p = stringExtra;
        }
        String stringExtra2 = getIntent().getStringExtra("tabIndex");
        if (stringExtra2 != null) {
            try {
                this.f83626q = Integer.parseInt(stringExtra2);
            } catch (Throwable unused) {
            }
        }
    }

    public void onCreate(Bundle bundle) {
        EdgeEngineScene edgeEngineScene = EdgeEngineScene.TRADE_BOT;
        Qh(new rj.b(this, edgeEngineScene.getScene()));
        Lh().H();
        ek.b.f47515a.f(Lh(), edgeEngineScene.getScene());
        super.onCreate(bundle);
        if (!EventBus.d().i(this)) {
            EventBus.d().p(this);
        }
        g.i("tradingbot_pageview_app", (HashMap) null);
    }

    public void onDestroy() {
        EventBus.d().r(this);
        super.onDestroy();
        Lh().B();
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public final void onEvent(LogOutEvent logOutEvent) {
        yt.a.f85088a.c(Mh().h0());
    }

    public void onNewIntent(Intent intent) {
        String stringExtra;
        String stringExtra2;
        super.onNewIntent(intent);
        if (!(intent == null || (stringExtra2 = intent.getStringExtra("source")) == null)) {
            this.f83625p = stringExtra2;
        }
        if (!(intent == null || (stringExtra = intent.getStringExtra("tabIndex")) == null)) {
            try {
                this.f83626q = Integer.parseInt(stringExtra);
            } catch (Throwable unused) {
            }
        }
        Rh(intent);
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public final void onProTokenUpdate(ProTokenUpdate proTokenUpdate) {
        yt.a.f85088a.c(Mh().h0());
    }
}
