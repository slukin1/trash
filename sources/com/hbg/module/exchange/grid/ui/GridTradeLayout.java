package com.hbg.module.exchange.grid.ui;

import ad.d;
import ad.e;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import cd.c0;
import cd.d0;
import cd.e0;
import cd.f0;
import cd.g0;
import cd.h0;
import cd.i0;
import cd.j0;
import cd.k0;
import cd.l0;
import cd.m0;
import cd.n0;
import com.google.android.material.appbar.AppBarLayout;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.page.SmartRefreshHeader;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.widgets.CommonCornerTabLayout;
import com.hbg.lib.widgets.CommonSwitchButton;
import com.hbg.module.exchange.R$color;
import com.hbg.module.exchange.R$dimen;
import com.hbg.module.exchange.R$drawable;
import com.hbg.module.exchange.R$id;
import com.hbg.module.exchange.R$layout;
import com.hbg.module.exchange.grid.ui.GridTradeAiView;
import com.huobi.view.AnimTradeMenuView;
import com.huobi.view.rv.VerticalDividerItemDecoration;
import com.huochat.community.widget.FlingBehavior;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import ky.j;
import net.lucode.hackware.magicindicator.buildins.UIUtil;

public class GridTradeLayout extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public GridTradeActivity f19566b;

    /* renamed from: c  reason: collision with root package name */
    public AnimTradeMenuView f19567c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f19568d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f19569e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f19570f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f19571g;

    /* renamed from: h  reason: collision with root package name */
    public RecyclerView f19572h;

    /* renamed from: i  reason: collision with root package name */
    public SmartRefreshLayout f19573i;

    /* renamed from: j  reason: collision with root package name */
    public GridTradeAiView f19574j;

    /* renamed from: k  reason: collision with root package name */
    public GridTradeHandView f19575k;

    /* renamed from: l  reason: collision with root package name */
    public View f19576l;

    /* renamed from: m  reason: collision with root package name */
    public CommonSwitchButton f19577m;

    /* renamed from: n  reason: collision with root package name */
    public View f19578n;

    /* renamed from: o  reason: collision with root package name */
    public View f19579o;

    /* renamed from: p  reason: collision with root package name */
    public TextView f19580p;

    /* renamed from: q  reason: collision with root package name */
    public TextView f19581q;

    /* renamed from: r  reason: collision with root package name */
    public TextView f19582r;

    /* renamed from: s  reason: collision with root package name */
    public AppBarLayout f19583s;

    /* renamed from: t  reason: collision with root package name */
    public CommonCornerTabLayout f19584t;

    /* renamed from: u  reason: collision with root package name */
    public b f19585u;

    /* renamed from: v  reason: collision with root package name */
    public boolean f19586v;

    /* renamed from: w  reason: collision with root package name */
    public int f19587w;

    /* renamed from: x  reason: collision with root package name */
    public int f19588x;

    public class a extends VerticalDividerItemDecoration {
        public a(Drawable drawable, int i11, boolean z11, boolean z12) {
            super(drawable, i11, z11, z12);
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            super.getItemOffsets(rect, view, recyclerView, state);
            try {
                int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
                RecyclerView.Adapter adapter = recyclerView.getAdapter();
                if (adapter != null && childAdapterPosition == adapter.getItemCount() - 1) {
                    rect.bottom = PixelUtils.a(10.0f);
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public interface b extends GridTradeAiView.c {
        void c();

        void d();

        void f(boolean z11);

        void g();

        void h();

        void j();

        void k();

        void l();

        void m(boolean z11);

        void onRefresh();
    }

    public GridTradeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void A(View view) {
        b bVar = this.f19585u;
        if (bVar != null) {
            bVar.g();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void B(View view) {
        b bVar = this.f19585u;
        if (bVar != null) {
            bVar.l();
        }
        vc.b.a().d("5834", (Map<String, Object>) null, "1005373");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static /* synthetic */ void C(View view, View view2, AppBarLayout appBarLayout, int i11) {
        int height = view.getHeight() + (Math.abs(i11) - (appBarLayout.getHeight() - view2.getHeight()));
        if (height < 0) {
            height = 0;
        }
        view.setTranslationY((float) (-height));
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void r(View view) {
        b bVar = this.f19585u;
        if (bVar != null) {
            bVar.k();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void s(View view) {
        if (!d.b()) {
            d.f(getContext());
            vc.b.a().d("5839", (Map<String, Object>) null, "1005373");
        } else if (!d.c()) {
            d.e(getContext());
            vc.b.a().d("5840", (Map<String, Object>) null, "1005373");
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void t(j jVar) {
        b bVar = this.f19585u;
        if (bVar != null) {
            bVar.onRefresh();
        }
        this.f19573i.d(1000);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void u(View view) {
        b bVar = this.f19585u;
        if (bVar != null) {
            bVar.j();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void v(View view) {
        CommonSwitchButton commonSwitchButton = this.f19577m;
        commonSwitchButton.b(!commonSwitchButton.isChecked(), true);
        e.b(this.f19577m.isChecked());
        b bVar = this.f19585u;
        if (bVar != null) {
            bVar.m(this.f19577m.isChecked());
        }
        vc.b.a().d("5845", (Map<String, Object>) null, "1005373");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void w(View view) {
        b bVar = this.f19585u;
        if (bVar != null) {
            bVar.h();
        }
        vc.b.a().d("5846", (Map<String, Object>) null, "1005373");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void x(int i11) {
        boolean z11 = i11 != 1;
        if (z11 != this.f19586v) {
            this.f19586v = z11;
            b bVar = this.f19585u;
            if (bVar != null) {
                bVar.f(z11);
            }
            if (this.f19586v) {
                ViewUtil.m(this.f19574j, true);
                ViewUtil.m(this.f19575k, false);
            } else {
                ViewUtil.m(this.f19575k, true);
                ViewUtil.m(this.f19574j, false);
            }
            this.f19584t.setSelectIndex(i11);
            D();
            HashMap hashMap = new HashMap();
            hashMap.put("type", z11 ? "一键创建" : "手动创建");
            vc.b.a().d("5835", hashMap, "1005373");
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void y(View view) {
        b bVar = this.f19585u;
        if (bVar != null) {
            bVar.d();
        }
        HashMap hashMap = new HashMap();
        GridTradeActivity gridTradeActivity = this.f19566b;
        hashMap.put("symbol", gridTradeActivity != null ? gridTradeActivity.o0() : "");
        vc.b.a().d("5832", hashMap, "1005373");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void z(View view) {
        b bVar = this.f19585u;
        if (bVar != null) {
            bVar.c();
        }
        vc.b.a().d("5833", (Map<String, Object>) null, "1005373");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void D() {
        CoordinatorLayout.Behavior f11 = ((CoordinatorLayout.LayoutParams) this.f19583s.getLayoutParams()).f();
        try {
            if (f11.getClass() == FlingBehavior.class) {
                Method declaredMethod = f11.getClass().getDeclaredMethod("stopScrollerAnimation", new Class[0]);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(f11, new Object[0]);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        if (f11 instanceof AppBarLayout.Behavior) {
            AppBarLayout.Behavior behavior = (AppBarLayout.Behavior) f11;
            if (behavior.getTopAndBottomOffset() != 0) {
                behavior.setTopAndBottomOffset(0);
            }
        }
    }

    public void E() {
        AppBarLayout appBarLayout = this.f19583s;
        if (appBarLayout != null) {
            appBarLayout.setExpanded(true, true);
        }
    }

    public void F(SpannableStringBuilder spannableStringBuilder, String str) {
        ViewUtil.m(this.f19576l, true);
        this.f19580p.setText(spannableStringBuilder);
        this.f19581q.setText(str);
    }

    public void G(String str, String str2, String str3, int i11, int i12, int i13) {
        this.f19570f.setText(str);
        this.f19570f.setTextColor(i11);
        this.f19571g.setText(str2);
        this.f19569e.setText(str3);
        this.f19569e.setTextColor(i13);
        this.f19569e.setBackgroundResource(i12);
    }

    public GridTradeAiView getGridTradeAiView() {
        return this.f19574j;
    }

    public GridTradeHandView getGridTradeHandView() {
        return this.f19575k;
    }

    public final void m() {
        findViewById(R$id.id_grid_trade_head_back_btn).setOnClickListener(new c0(this));
        this.f19582r.setOnClickListener(new i0(this));
        k0 k0Var = new k0(this);
        this.f19577m.setOnClickListener(k0Var);
        findViewById(R$id.grid_show_current_symbol_tv).setOnClickListener(k0Var);
        findViewById(R$id.id_grid_trade_order_all_btn).setOnClickListener(new l0(this));
        int i11 = R$drawable.bot_tag_ai_us;
        if (AppLanguageHelper.getInstance().isChineseLanguage()) {
            i11 = R$drawable.bot_tag_ai_cn;
        }
        this.f19584t.getTextView1().setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, i11, 0);
        this.f19584t.getTextView1().setCompoundDrawablePadding(getResources().getDimensionPixelOffset(R$dimen.dimen_3));
        this.f19584t.setCallback(new d0(this));
        findViewById(R$id.id_grid_trade_head_drawer).setOnClickListener(new g0(this));
        findViewById(R$id.trade_kline_iv).setOnClickListener(new m0(this));
        findViewById(R$id.trade_ranking_iv).setOnClickListener(new j0(this));
        findViewById(R$id.trade_question_iv).setOnClickListener(new f0(this));
        this.f19576l.setOnClickListener(new h0(this));
        this.f19573i.d0(new e0(this));
    }

    public final void n() {
    }

    public void o() {
        ViewUtil.m(this.f19576l, false);
    }

    public final void p() {
        this.f19578n = findViewById(R$id.id_grid_trade_layout_parent);
        this.f19579o = findViewById(R$id.id_grid_trade_price_layout);
        this.f19573i = (SmartRefreshLayout) findViewById(R$id.grid_smart_refresh);
        SmartRefreshHeader smartRefreshHeader = new SmartRefreshHeader(getContext());
        smartRefreshHeader.setBackgroundColor(ContextCompat.getColor(getContext(), R$color.baseColorContentBackground));
        this.f19573i.i(true);
        this.f19573i.g(false);
        this.f19573i.V(false);
        this.f19573i.W(false);
        this.f19573i.j0(smartRefreshHeader);
        this.f19573i.Z(UIUtil.a(getContext(), 55.0d));
        this.f19567c = (AnimTradeMenuView) findViewById(R$id.trade_drawer_iv);
        this.f19568d = (TextView) findViewById(R$id.trade_head_symbol_tv);
        this.f19569e = (TextView) findViewById(R$id.trade_price_change_tv);
        this.f19572h = (RecyclerView) findViewById(R$id.id_grid_trade_recyclerView);
        this.f19582r = (TextView) findViewById(R$id.id_grid_trade_create_btn);
        this.f19583s = (AppBarLayout) findViewById(R$id.id_grid_trade_appbar_layout);
        View findViewById = findViewById(R$id.id_grid_trade_order_layout_parent);
        this.f19583s.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new n0(findViewById(R$id.fl_trad_trade_tab_layout), findViewById));
        this.f19572h.addItemDecoration(new a(ContextCompat.getDrawable(getContext(), R$color.baseColorPrimarySeparator), PixelUtils.a(0.5f), false, false));
        this.f19574j = (GridTradeAiView) findViewById(R$id.id_grid_trade_create_tab_ai);
        this.f19575k = (GridTradeHandView) findViewById(R$id.id_grid_trade_create_tab_hand);
        this.f19584t = (CommonCornerTabLayout) findViewById(R$id.id_grid_trade_tab_layout);
        this.f19570f = (TextView) findViewById(R$id.id_grid_trade_price_tv);
        this.f19571g = (TextView) findViewById(R$id.id_grid_trade_legal_tv);
        CommonSwitchButton commonSwitchButton = (CommonSwitchButton) findViewById(R$id.id_grid_trade_order_current_only_switch_button);
        this.f19577m = commonSwitchButton;
        commonSwitchButton.setChecked(e.a());
        this.f19576l = findViewById(R$id.id_grid_trade_layout_risk_parent);
        this.f19580p = (TextView) findViewById(R$id.id_grid_trade_layout_risk);
        this.f19581q = (TextView) findViewById(R$id.id_grid_trade_layout_risk_btn);
    }

    public boolean q() {
        return this.f19586v;
    }

    public void setActivity(GridTradeActivity gridTradeActivity) {
        this.f19566b = gridTradeActivity;
        this.f19574j.setActivity(gridTradeActivity);
        this.f19575k.setActivity(gridTradeActivity);
    }

    public void setCallback(b bVar) {
        this.f19585u = bVar;
        this.f19574j.setCallback(bVar);
    }

    public void setCreateBtnEnable(boolean z11) {
        if (z11) {
            this.f19582r.setBackgroundResource(R$drawable.selector_common_btn_corner_bg);
            this.f19582r.setTextColor(getResources().getColor(R$color.baseTextColor));
            return;
        }
        this.f19582r.setBackgroundResource(R$drawable.shape_common_btn_bg_disable);
        this.f19582r.setTextColor(getResources().getColor(R$color.baseColorThreeLevelText));
    }

    public void setIsAI(boolean z11) {
        this.f19586v = z11;
        if (z11) {
            ViewUtil.m(this.f19574j, true);
            ViewUtil.m(this.f19575k, false);
        } else {
            ViewUtil.m(this.f19575k, true);
            ViewUtil.m(this.f19574j, false);
        }
        this.f19584t.setSelectIndex(z11 ^ true ? 1 : 0);
    }

    public void setRvAdapter(v9.a aVar) {
        this.f19572h.setAdapter(aVar);
    }

    public void setSymbolTitle(String str) {
        this.f19568d.setText(str);
    }

    public GridTradeLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f19586v = true;
        FrameLayout.inflate(context, R$layout.grid_trade_layout, this);
        this.f19587w = getResources().getColor(R$color.login_v2_bottom_background);
        this.f19588x = getResources().getColor(R$color.baseColorContentBackground);
        p();
        m();
        n();
    }
}
