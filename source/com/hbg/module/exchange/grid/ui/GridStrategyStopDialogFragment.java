package com.hbg.module.exchange.grid.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import cd.e;
import cd.f;
import cd.h;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.hbg.grid.bean.GridStrategy;
import com.hbg.lib.widgets.LoadingView;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.exchange.R$drawable;
import com.hbg.module.exchange.R$id;
import com.hbg.module.exchange.R$layout;
import com.hbg.module.exchange.R$raw;
import com.hbg.module.exchange.R$string;
import com.hbg.module.exchange.R$style;
import com.hbg.module.exchange.grid.bean.GridStrategyItem;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.a1;
import i6.i;
import i6.r;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import u6.g;
import vc.b;

public class GridStrategyStopDialogFragment extends BaseDialogFragment {

    /* renamed from: b  reason: collision with root package name */
    public GridStrategy f19482b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f19483c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f19484d;

    /* renamed from: e  reason: collision with root package name */
    public View f19485e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f19486f;

    /* renamed from: g  reason: collision with root package name */
    public View f19487g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f19488h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f19489i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f19490j;

    /* renamed from: k  reason: collision with root package name */
    public View f19491k;

    /* renamed from: l  reason: collision with root package name */
    public View f19492l;

    /* renamed from: m  reason: collision with root package name */
    public LoadingView f19493m;

    /* renamed from: n  reason: collision with root package name */
    public View f19494n;

    /* renamed from: o  reason: collision with root package name */
    public GridStrategyItem.a f19495o;

    /* renamed from: p  reason: collision with root package name */
    public int f19496p;

    public class a extends EasySubscriber<Object> {
        public a() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b() {
            GridStrategyStopDialogFragment.this.dismiss();
        }

        public void onAfter() {
            super.onAfter();
            GridStrategyStopDialogFragment.this.f19492l.setVisibility(8);
            GridStrategyStopDialogFragment.this.f19493m.d();
            GridStrategyStopDialogFragment.this.f19491k.setEnabled(true);
        }

        public void onNext(Object obj) {
            super.onNext(obj);
            HuobiToastUtil.s(R$string.n_grid_strategy_is_stopping);
            if (GridStrategyStopDialogFragment.this.f19495o != null) {
                GridStrategyStopDialogFragment.this.f19495o.b(GridStrategyStopDialogFragment.this.f19482b.getSymbol());
            }
            i.b().g(new cd.i(this), 10);
        }

        public void onStart() {
            super.onStart();
            GridStrategyStopDialogFragment.this.f19492l.setVisibility(0);
            GridStrategyStopDialogFragment.this.f19491k.setEnabled(false);
            GridStrategyStopDialogFragment.this.f19493m.c();
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        dismiss();
        b.a().d("5923", (Map<String, Object>) null, "1005373");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$1(View view) {
        this.f19485e.setSelected(true);
        this.f19487g.setSelected(false);
        this.f19486f.setImageResource(R$drawable.marquee_selected);
        this.f19488h.setImageResource(R$drawable.marquee_unselected);
        this.f19496p = 1;
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$2(View view) {
        this.f19485e.setSelected(false);
        this.f19487g.setSelected(true);
        this.f19486f.setImageResource(R$drawable.marquee_unselected);
        this.f19488h.setImageResource(R$drawable.marquee_selected);
        this.f19496p = 2;
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$3(View view) {
        v7.b.a().d0(this.f19482b.getId(), this.f19496p).b().compose(RxJavaHelper.t((g) null)).subscribe(new a());
        HashMap hashMap = new HashMap();
        hashMap.put("type", Integer.valueOf(this.f19496p));
        hashMap.put("symbol", this.f19482b.getSymbol());
        b.a().d("5924", hashMap, "1005373");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void Bh(GridStrategyItem.a aVar) {
        this.f19495o = aVar;
    }

    public void Ch(GridStrategy gridStrategy) {
        this.f19482b = gridStrategy;
    }

    public void addEvent(r rVar) {
        this.f19484d.setOnClickListener(new h(this));
        this.f19485e.setOnClickListener(new e(this));
        this.f19487g.setOnClickListener(new cd.g(this));
        this.f19491k.setOnClickListener(new f(this));
    }

    public void afterInit() {
        b.a().l("5922", "1005373", (Map<String, Object>) null);
    }

    public int getAnimationStyle() {
        return R$style.bottom_dialog_animation;
    }

    public int getContentViewResId() {
        return R$layout.dialog_grid_strategy_stop;
    }

    public int getGravity() {
        return 80;
    }

    public void initView(r rVar) {
        this.f19494n = rVar.b(R$id.dialog_contract_bg);
        this.f19483c = (TextView) rVar.b(R$id.dialog_name_tv);
        this.f19484d = (TextView) rVar.b(R$id.dialog_cancel_tv);
        this.f19485e = rVar.b(R$id.stop_and_sell_container);
        this.f19486f = (ImageView) rVar.b(R$id.stop_and_sell_iv);
        this.f19487g = rVar.b(R$id.stop_and_not_sell_container);
        this.f19488h = (ImageView) rVar.b(R$id.stop_and_not_sell_iv);
        this.f19485e.setSelected(true);
        this.f19486f.setImageResource(R$drawable.marquee_selected);
        this.f19496p = 1;
        this.f19489i = (TextView) rVar.b(R$id.stop_and_sell_content_tv);
        this.f19490j = (TextView) rVar.b(R$id.stop_and_not_sell_content_tv);
        this.f19491k = rVar.b(R$id.stop_container);
        this.f19492l = rVar.b(R$id.dialog_loading);
        LoadingView loadingView = (LoadingView) rVar.b(R$id.loading_dialog_loading_view);
        this.f19493m = loadingView;
        loadingView.setLottieAnimationRes(R$raw.nd_middle_bg);
        if (this.f19482b != null) {
            TextView textView = this.f19483c;
            Locale locale = Locale.ENGLISH;
            textView.setText(String.format(locale, getString(R$string.n_grid_strategy_stop_dialog_title), new Object[]{a1.v().W(this.f19482b.getSymbol())}));
            this.f19489i.setText(String.format(locale, getString(R$string.n_grid_strategy_stop_and_sell_content), new Object[]{StringUtils.i(a1.v().p(this.f19482b.getSymbol()))}));
            this.f19490j.setText(String.format(locale, getString(R$string.n_grid_strategy_stop_and_not_sell_content), new Object[]{StringUtils.i(a1.v().p(this.f19482b.getSymbol()))}));
        }
    }

    public boolean isTransparent() {
        return false;
    }
}
