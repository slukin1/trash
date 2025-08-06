package com.hbg.module.market.widget.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.widgets.CommonSwitchButton;
import com.hbg.lib.widgets.MyNestedScrollView;
import com.hbg.lib.widgets.SettingItemArrowView;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.module.market.R$id;
import com.hbg.module.market.R$layout;
import com.hbg.module.market.R$string;
import com.hbg.module.market.widget.bean.MarketWidgetSymbolItem;
import com.hbg.module.market.widget.presenter.MarketWidgetSettingPresenter;
import com.hbg.module.market.widget.viewhandler.MarketWidgetSymbolItemHandler;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import hf.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import mf.i;
import mf.j;
import mf.k;
import mf.l;
import mf.m;
import mf.n;
import mf.o;
import mf.p;
import rl.c;

@Route(path = "/market/realTimeReminder")
public class MarketWidgetSettingActivity extends BaseActivity<MarketWidgetSettingPresenter, MarketWidgetSettingPresenter.d> implements MarketWidgetSettingPresenter.d {

    /* renamed from: b  reason: collision with root package name */
    public MyNestedScrollView f26755b;

    /* renamed from: c  reason: collision with root package name */
    public View f26756c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f26757d;

    /* renamed from: e  reason: collision with root package name */
    public View f26758e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f26759f;

    /* renamed from: g  reason: collision with root package name */
    public RecyclerView f26760g;

    /* renamed from: h  reason: collision with root package name */
    public View f26761h;

    /* renamed from: i  reason: collision with root package name */
    public List<s9.a> f26762i = new ArrayList();

    /* renamed from: j  reason: collision with root package name */
    public LinearLayoutManager f26763j;

    /* renamed from: k  reason: collision with root package name */
    public v9.a<s9.a> f26764k;

    /* renamed from: l  reason: collision with root package name */
    public CommonSwitchButton f26765l;

    /* renamed from: m  reason: collision with root package name */
    public SettingItemArrowView f26766m;

    /* renamed from: n  reason: collision with root package name */
    public SettingItemArrowView f26767n;

    /* renamed from: o  reason: collision with root package name */
    public MarketWidgetCountSettingDialog f26768o = new MarketWidgetCountSettingDialog();

    /* renamed from: p  reason: collision with root package name */
    public MarketWidgetBgAlphaDialog f26769p = new MarketWidgetBgAlphaDialog();

    public class a implements BaseDialogFragment.c {
        public a() {
        }

        public void onDialogFragmentBackPressed() {
        }

        public void onDialogFragmentPause() {
            MarketWidgetSettingActivity.this.xh();
        }

        public void onDialogFragmentResume() {
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        ((MarketWidgetSettingPresenter) getPresenter()).Q();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$2(View view) {
        if (!gf.a.j()) {
            gf.a.o(true);
        } else {
            gf.a.e();
        }
        this.f26765l.b(gf.a.j(), true);
        ((MarketWidgetSettingPresenter) getPresenter()).Q();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$3(View view) {
        this.f26768o.show(getSupportFragmentManager(), "MarketWidgetCountDialog");
        ((MarketWidgetSettingPresenter) getPresenter()).Q();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$4(View view) {
        this.f26769p.show(getSupportFragmentManager(), "MarketWidgetBgAlphaDialog");
        ((MarketWidgetSettingPresenter) getPresenter()).Q();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void rh(View view) {
        MarketWidgetSearchActivity.yh(this);
        ((MarketWidgetSettingPresenter) getPresenter()).Q();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void sh(Float f11) {
        float floatValue = f11.floatValue();
        SettingItemArrowView settingItemArrowView = this.f26767n;
        settingItemArrowView.setDesc(((int) (floatValue * 100.0f)) + "%");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean th(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 1) {
            return false;
        }
        ((MarketWidgetSettingPresenter) getPresenter()).Q();
        return false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void uh(NestedScrollView nestedScrollView, int i11, int i12, int i13, int i14) {
        ((MarketWidgetSettingPresenter) getPresenter()).Q();
    }

    public static void vh(Context context) {
        if (context != null) {
            Intent intent = new Intent(context, MarketWidgetSettingActivity.class);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
        }
    }

    public void G(List<s9.a> list) {
        this.f26762i.clear();
        if (list != null) {
            this.f26762i.addAll(list);
        }
        this.f26764k.notifyDataSetChanged();
        this.f26758e.setVisibility(this.f26762i.isEmpty() ? 8 : 0);
    }

    public void Mc(MarketWidgetSymbolItem marketWidgetSymbolItem) {
        if (marketWidgetSymbolItem != null) {
            try {
                int indexOf = this.f26762i.indexOf(marketWidgetSymbolItem);
                this.f26762i.remove(marketWidgetSymbolItem);
                this.f26762i.add(0, marketWidgetSymbolItem);
                this.f26764k.notifyItemMoved(indexOf, 0);
                ((MarketWidgetSettingPresenter) getPresenter()).T(this.f26764k.c());
                ((MarketWidgetSettingPresenter) getPresenter()).Q();
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public void a5(s9.a aVar) {
        v9.a<s9.a> aVar2 = this.f26764k;
        if (aVar2 != null) {
            this.f26764k.notifyItemRemoved(aVar2.e(aVar));
        }
    }

    public void addEvent() {
        this.f26756c.setOnClickListener(new i(this));
        this.f26757d.setOnClickListener(new l(this));
        this.viewFinder.b(R$id.id_market_widget_setting_switch_layout).setOnClickListener(new m(this));
        this.f26766m.setOnClickListener(new j(this));
        this.f26767n.setOnClickListener(new k(this));
        this.f26768o.setDialogFragmentListener(new a());
        this.f26769p.yh(new o(this));
        this.f26760g.setOnTouchListener(new n(this));
        this.f26755b.setOnScrollChangedListener(new p(this));
    }

    public void afterInit() {
        this.f26765l.setChecked(gf.a.j());
        xh();
        wh();
    }

    public void cb() {
        v9.a<s9.a> aVar = this.f26764k;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    public int getContentView() {
        return R$layout.activity_market_widget_setting;
    }

    public void h0(boolean z11) {
        View view = this.f26761h;
        if (view != null) {
            view.setVisibility(z11 ? 0 : 8);
        }
    }

    public boolean i7(int i11, int i12) {
        try {
            List<s9.a> list = this.f26762i;
            if (list == null) {
                return false;
            }
            Collections.swap(list, i11, i12);
            this.f26764k.notifyItemMoved(i11, i12);
            ((MarketWidgetSettingPresenter) getPresenter()).T(this.f26764k.c());
            ((MarketWidgetSettingPresenter) getPresenter()).Q();
            return true;
        } catch (Exception e11) {
            e11.printStackTrace();
            return false;
        }
    }

    public void initView() {
        this.f26755b = (MyNestedScrollView) this.viewFinder.b(R$id.nsv_scroll_view);
        this.f26756c = this.viewFinder.b(R$id.ll_content_container);
        this.f26757d = (TextView) this.viewFinder.b(R$id.tv_add_market);
        this.f26758e = this.viewFinder.b(R$id.item_search_symbol_layout);
        TextView textView = (TextView) this.viewFinder.b(R$id.item_search_symbol_text);
        this.f26759f = textView;
        textView.setText(getResources().getString(R$string.n_widget_market_list_header_coin));
        this.f26760g = (RecyclerView) this.viewFinder.b(R$id.id_common_list_recyclerView);
        this.f26761h = this.viewFinder.b(R$id.ll_empty_view_page);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, 1, false);
        this.f26763j = linearLayoutManager;
        this.f26760g.setLayoutManager(linearLayoutManager);
        v9.a<s9.a> aVar = new v9.a<>(this.f26762i);
        this.f26764k = aVar;
        this.f26760g.setAdapter(aVar);
        this.f26765l = (CommonSwitchButton) this.viewFinder.b(R$id.id_market_widget_setting_switch_button);
        this.f26766m = (SettingItemArrowView) this.viewFinder.b(R$id.id_market_widget_setting_count);
        this.f26767n = (SettingItemArrowView) this.viewFinder.b(R$id.id_market_widget_setting_bg_alpha);
        MarketWidgetSymbolItemHandler.f26803d = 0;
    }

    /* renamed from: ph */
    public MarketWidgetSettingPresenter createPresenter() {
        return new MarketWidgetSettingPresenter();
    }

    /* renamed from: qh */
    public MarketWidgetSettingPresenter.d getUI() {
        return this;
    }

    public boolean useNewStatusBarFunc() {
        return true;
    }

    public final void wh() {
        if (gf.a.i()) {
            SettingItemArrowView settingItemArrowView = this.f26767n;
            settingItemArrowView.setDesc(((int) (gf.a.b() * 100.0f)) + "%");
            return;
        }
        this.f26767n.setDesc(getString(R$string.n_widget_market_float_window_bg_alpha_default));
    }

    public void xe(c cVar) {
        if (cVar != null) {
            cVar.b(this.f26760g);
        }
    }

    public final void xh() {
        String valueOf = String.valueOf(b.r());
        this.f26766m.setDesc(String.format(Locale.US, getString(R$string.n_widget_market_float_window_size), new Object[]{valueOf}));
    }
}
