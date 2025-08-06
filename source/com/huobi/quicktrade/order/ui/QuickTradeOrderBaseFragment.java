package com.huobi.quicktrade.order.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.ui.BaseFragment;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.order.ui.TradeOrderActivity;
import com.huobi.quicktrade.bean.QuickTradeDismissEvent;
import com.huobi.quicktrade.order.presenter.QuickTradeOrderBasePresenter;
import com.huobi.trade.helper.c;
import com.huobi.view.rv.VerticalDividerItemDecoration;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import d7.a1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;
import org.greenrobot.eventbus.EventBus;
import pq.d;
import pq.e;
import pro.huobi.R;
import q10.b;
import tg.r;

public abstract class QuickTradeOrderBaseFragment<P extends QuickTradeOrderBasePresenter<V>, V extends e> extends BaseFragment<P, V> implements e {

    /* renamed from: l  reason: collision with root package name */
    public RecyclerView f80532l;

    /* renamed from: m  reason: collision with root package name */
    public View f80533m;

    /* renamed from: n  reason: collision with root package name */
    public MagicIndicator f80534n;

    /* renamed from: o  reason: collision with root package name */
    public HorizontalScrollView f80535o;

    /* renamed from: p  reason: collision with root package name */
    public RadioGroup f80536p;

    /* renamed from: q  reason: collision with root package name */
    public View f80537q;

    /* renamed from: r  reason: collision with root package name */
    public View f80538r;

    /* renamed from: s  reason: collision with root package name */
    public TextView f80539s;

    /* renamed from: t  reason: collision with root package name */
    public View f80540t;

    /* renamed from: u  reason: collision with root package name */
    public View f80541u;

    /* renamed from: v  reason: collision with root package name */
    public List<String> f80542v = new ArrayList();

    /* renamed from: w  reason: collision with root package name */
    public Map<Integer, Integer> f80543w = new HashMap();

    public class a extends CommonNavigatorAdapter {
        public a() {
        }

        /* access modifiers changed from: private */
        @SensorsDataInstrumented
        public /* synthetic */ void lambda$getTitleView$0(int i11, View view) {
            Integer num = QuickTradeOrderBaseFragment.this.f80543w.get(Integer.valueOf(i11));
            if (num == null) {
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            } else if (num.intValue() == ((QuickTradeOrderBasePresenter) QuickTradeOrderBaseFragment.this.yh()).g()) {
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            } else {
                QuickTradeOrderBaseFragment.this.f80534n.c(i11);
                QuickTradeOrderBaseFragment.this.f80534n.b(i11, 0.0f, 0);
                ((QuickTradeOrderBasePresenter) QuickTradeOrderBaseFragment.this.yh()).l0(num.intValue());
                QuickTradeOrderBaseFragment.this.Lh(i11);
                int intValue = num.intValue();
                if (intValue == 1) {
                    ((QuickTradeOrderBasePresenter) QuickTradeOrderBaseFragment.this.yh()).p0();
                    ((QuickTradeOrderBasePresenter) QuickTradeOrderBaseFragment.this.yh()).t0();
                } else if (intValue != 2) {
                    ((QuickTradeOrderBasePresenter) QuickTradeOrderBaseFragment.this.yh()).p0();
                    ((QuickTradeOrderBasePresenter) QuickTradeOrderBaseFragment.this.yh()).g0(false, ((QuickTradeOrderBasePresenter) QuickTradeOrderBaseFragment.this.yh()).o0(), false);
                } else {
                    ((QuickTradeOrderBasePresenter) QuickTradeOrderBaseFragment.this.yh()).n0();
                }
                c.b().j(num);
                c.b().g();
                QuickTradeOrderBaseFragment.this.l1();
                QuickTradeOrderBaseFragment.this.J2();
                ((QuickTradeOrderBasePresenter) QuickTradeOrderBaseFragment.this.yh()).s0();
                ((QuickTradeOrderBasePresenter) QuickTradeOrderBaseFragment.this.yh()).u0();
                ((QuickTradeOrderBasePresenter) QuickTradeOrderBaseFragment.this.yh()).d0();
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        }

        public int getCount() {
            List<String> list = QuickTradeOrderBaseFragment.this.f80542v;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public b getIndicator(Context context) {
            LinePagerIndicator linePagerIndicator = new LinePagerIndicator(context);
            linePagerIndicator.setColors(Integer.valueOf(ContextCompat.getColor(context, R.color.baseColorMajorTheme100)));
            linePagerIndicator.setMode(1);
            linePagerIndicator.setLineHeight(context.getResources().getDimension(R.dimen.global_indicator_height));
            linePagerIndicator.setRoundRadius((float) PixelUtils.a(1.0f));
            return linePagerIndicator;
        }

        public q10.c getTitleView(Context context, int i11) {
            ColorTransitionPagerTitleView colorTransitionPagerTitleView = new ColorTransitionPagerTitleView(context);
            colorTransitionPagerTitleView.setText(QuickTradeOrderBaseFragment.this.f80542v.get(i11));
            colorTransitionPagerTitleView.setTextSize(1, 16.0f);
            colorTransitionPagerTitleView.setTypeface(ResourcesCompat.h(context, R.font.dinpro_medium));
            colorTransitionPagerTitleView.setPadding(PixelUtils.a(15.0f), 0, PixelUtils.a(15.0f), 0);
            colorTransitionPagerTitleView.setNormalColor(ContextCompat.getColor(context, R.color.baseColorSecondaryText));
            colorTransitionPagerTitleView.setSelectedColor(ContextCompat.getColor(context, R.color.baseColorPrimaryText));
            colorTransitionPagerTitleView.setOnClickListener(new d(this, i11));
            return colorTransitionPagerTitleView;
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Jh(RadioGroup radioGroup, int i11) {
        if (i11 == R.id.plan_order_rb) {
            ((QuickTradeOrderBasePresenter) yh()).k0(2);
        } else if (i11 != R.id.tp_sl_order_rb) {
            ((QuickTradeOrderBasePresenter) yh()).k0(0);
        } else {
            ((QuickTradeOrderBasePresenter) yh()).k0(1);
        }
        ((QuickTradeOrderBasePresenter) yh()).r0();
        ((QuickTradeOrderBasePresenter) yh()).q0();
        ((QuickTradeOrderBasePresenter) yh()).d0();
        ((QuickTradeOrderBasePresenter) yh()).t0();
        SensorsDataAutoTrackHelper.trackRadioGroup(radioGroup, i11);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void lambda$addEvent$0(View view) {
        EventBus.d().k(new QuickTradeDismissEvent());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$1(View view) {
        int i11 = 0;
        int i12 = ((QuickTradeOrderBasePresenter) yh()).g() == 2 ? 1 : 0;
        if (((QuickTradeOrderBasePresenter) yh()).e() == 2) {
            i11 = 2;
        } else if (((QuickTradeOrderBasePresenter) yh()).e() == 1) {
            i11 = 1;
        }
        TradeOrderActivity.Hi(getActivity(), ((QuickTradeOrderBasePresenter) yh()).f0(), (String) null, i11, i12);
        c.b().f();
        EventBus.d().k(new QuickTradeDismissEvent());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void Ah() {
        super.Ah();
        this.f80540t.setOnClickListener(pq.b.f53208b);
        this.f80533m.setOnClickListener(new pq.a(this));
        this.f80536p.setOnCheckedChangeListener(new pq.c(this));
    }

    public void D1(int i11) {
        this.f80533m.setVisibility(i11);
    }

    public abstract void Hh();

    public final void Ih() {
        this.f80534n = (MagicIndicator) this.f67460i.b(R.id.order_type_indicator);
        Hh();
        CommonNavigator commonNavigator = new CommonNavigator(getActivity());
        commonNavigator.setAdapter(new a());
        this.f80534n.setNavigator(commonNavigator);
    }

    public void J2() {
        if (!r.x().F0()) {
            this.f80538r.setVisibility(8);
        } else if (((QuickTradeOrderBasePresenter) yh()).g() == 0) {
            this.f80538r.setVisibility(0);
        } else {
            this.f80538r.setVisibility(8);
        }
    }

    public void Kh(int i11) {
        if (i11 < this.f80543w.size()) {
            this.f80534n.c(i11);
            this.f80534n.b(i11, 0.0f, 0);
            ((QuickTradeOrderBasePresenter) yh()).l0(i11);
            Lh(i11);
        }
    }

    public final void Lh(int i11) {
        HashMap hashMap = new HashMap();
        if (i11 == 0) {
            hashMap.put("order_tab_name", "fund");
        } else if (i11 == 1) {
            hashMap.put("order_tab_name", TUIChatConstants.BUSINESS_ID_CUSTOM_ORDER);
        } else if (i11 == 2) {
            hashMap.put("order_tab_name", "history");
        }
        BaseModuleConfig.a().w("App_quickcomponent_order_view", hashMap);
    }

    public void b(v9.a aVar) {
        this.f80532l.setAdapter(aVar);
    }

    public void d(boolean z11) {
        if (z11) {
            this.f80533m.setVisibility(0);
        } else {
            this.f80533m.setVisibility(8);
        }
    }

    public void initViews() {
        super.initViews();
        this.f80541u = this.f67460i.b(R.id.order_tab_rl);
        this.f80540t = this.f67460i.b(R.id.order_page_close_tv);
        RecyclerView recyclerView = (RecyclerView) this.f67460i.b(R.id.spotRv);
        this.f80532l = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        this.f80532l.addItemDecoration(new VerticalDividerItemDecoration(ContextCompat.getDrawable(getActivity(), R.color.baseColorPrimarySeparator), PixelUtils.a(0.5f), false));
        Ih();
        this.f80535o = (HorizontalScrollView) this.f67460i.b(R.id.order_tab_sv);
        this.f80536p = (RadioGroup) this.f67460i.b(R.id.order_tab_rg);
        this.f80537q = this.f67460i.b(R.id.order_tab_divider);
        this.f80538r = this.f67460i.b(R.id.trade_hold_label_container);
        TextView textView = (TextView) this.f67460i.b(R.id.trade_hold_volume_label_tv);
        this.f80539s = textView;
        textView.setText(String.format(Locale.ENGLISH, getString(R.string.n_trade_total_accounted2), new Object[]{LegalCurrencyConfigUtil.y().toUpperCase(Locale.US)}));
        this.f80533m = this.f67460i.b(R.id.order_current_iv);
    }

    public void l1() {
        if (!r.x().F0()) {
            this.f80535o.setVisibility(8);
            this.f80537q.setVisibility(8);
        } else if (((QuickTradeOrderBasePresenter) yh()).g() != 1 || a1.v().s0(((QuickTradeOrderBasePresenter) yh()).o0())) {
            this.f80535o.setVisibility(8);
            this.f80537q.setVisibility(0);
        } else {
            this.f80535o.setVisibility(0);
            this.f80537q.setVisibility(0);
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    public void uh(boolean z11) {
        super.uh(z11);
        if (z11) {
            this.f80539s.setText(String.format(Locale.ENGLISH, getString(R.string.n_trade_total_accounted2), new Object[]{LegalCurrencyConfigUtil.y().toUpperCase(Locale.US)}));
        }
    }
}
