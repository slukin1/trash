package com.huobi.finance.ui;

import android.animation.ValueAnimator;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import bj.o0;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.network.hbg.core.bean.HtExchangeConfig;
import com.hbg.lib.widgets.CommonCheckBox;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.huobi.finance.presenter.HtExchangePresenter;
import com.huobi.finance.utils.UiFillUtil;
import com.huobi.page.SmartRefreshHeader;
import com.huobi.utils.HBHTtoHTXManager;
import com.huobi.view.collapsingtoolbarlayout.CollapsingToolbarLayout;
import com.huobi.view.title.HbTitleBar;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.m;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ky.j;
import ny.c;
import pro.huobi.R;
import s9.a;
import tg.r;

public class HtExchangeActivity extends BaseActivity<HtExchangePresenter, c6> implements c6, c {

    /* renamed from: b  reason: collision with root package name */
    public EasyRecyclerView<a> f46556b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<a> f46557c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public Toolbar f46558d;

    /* renamed from: e  reason: collision with root package name */
    public View f46559e;

    /* renamed from: f  reason: collision with root package name */
    public SmartRefreshLayout f46560f;

    /* renamed from: g  reason: collision with root package name */
    public LoadingLayout f46561g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f46562h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f46563i;

    /* renamed from: j  reason: collision with root package name */
    public CommonCheckBox f46564j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f46565k;

    /* renamed from: l  reason: collision with root package name */
    public TextView f46566l;

    /* renamed from: m  reason: collision with root package name */
    public TextView f46567m;

    /* renamed from: n  reason: collision with root package name */
    public View f46568n;

    /* renamed from: o  reason: collision with root package name */
    public View f46569o;

    /* renamed from: p  reason: collision with root package name */
    public HbTitleBar f46570p;

    /* renamed from: q  reason: collision with root package name */
    public String f46571q;

    /* renamed from: r  reason: collision with root package name */
    public CollapsingToolbarLayout f46572r;

    /* renamed from: s  reason: collision with root package name */
    public TextView f46573s;

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Ah(Dialog dialog, View view) {
        ((HtExchangePresenter) getPresenter()).v0();
        dialog.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Bh() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{(float) (-this.f46559e.getHeight()), 0.0f});
        ofFloat.setDuration(270);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.addUpdateListener(new o5(this));
        ofFloat.start();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Ch(ValueAnimator valueAnimator) {
        this.f46559e.setVisibility(0);
        this.f46560f.setVisibility(0);
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.f46559e.setTranslationY(floatValue);
        this.f46568n.setTranslationY(floatValue);
        this.f46560f.setTranslationY(floatValue);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$2(View view) {
        is.a.i("3561", (Map<String, Object>) null);
        startActivity(new Intent(this, HtExchangeHistoryActivity.class));
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$4(View view) {
        ((HtExchangePresenter) getPresenter()).p0(true);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static void rh(Context context) {
        if (r.x().F0()) {
            context.startActivity(new Intent(context, HtExchangeActivity.class));
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void uh(View view) {
        DialogUtils.X(this, getResources().getString(R.string.n_introduction), this.f46571q, (String) null, getResources().getString(R.string.n_known), o0.f12469a);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ boolean vh(MenuItem menuItem) {
        is.a.i("3561", (Map<String, Object>) null);
        startActivity(new Intent(this, HtExchangeHistoryActivity.class));
        SensorsDataAutoTrackHelper.trackMenuItem(this, menuItem);
        return true;
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void wh(View view) {
        if (this.f46557c.size() == 0) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        this.f46564j.toggle();
        Eh();
        ((HtExchangePresenter) getPresenter()).t0(this.f46564j.isChecked());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void xh(View view) {
        Dh();
        Fh();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void yh() {
        this.f46567m.setSelected(true);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void zh(Dialog dialog, View view) {
        dialog.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void C3(boolean z11) {
        this.f46564j.setChecked(z11);
    }

    public void D3(int i11) {
        String valueOf = String.valueOf(i11);
        String format = String.format(getString(R.string.ht_exchange_selected_count), new Object[]{valueOf});
        SpannableString spannableString = new SpannableString(format);
        spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this, i11 > 0 ? R.color.baseColorPrimaryText : R.color.baseColorSecondaryText)), format.indexOf(valueOf), format.indexOf(valueOf) + valueOf.length(), 33);
        this.f46562h.setText(spannableString);
    }

    public final void Dh() {
        HashMap hashMap = new HashMap(1);
        ArrayList arrayList = new ArrayList();
        for (vk.r c11 : ((HtExchangePresenter) getPresenter()).i0()) {
            arrayList.add(c11.c().getCurrency());
        }
        hashMap.put(FirebaseAnalytics.Param.CURRENCY, arrayList);
        is.a.i("3562", hashMap);
    }

    public final void Eh() {
        HashMap hashMap = new HashMap(1);
        hashMap.put("select", Integer.valueOf(this.f46564j.isChecked() ? 1 : 0));
        is.a.i("3563", hashMap);
    }

    public final void Fh() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.dialog_ht_exchange_confirm, (ViewGroup) null);
        AlertDialog create = new AlertDialog.Builder(this).setView(inflate).create();
        create.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        Button button = (Button) inflate.findViewById(R.id.dialog_confirm_btn);
        Button button2 = (Button) inflate.findViewById(R.id.dialog_cancel_btn);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_count);
        TextView textView2 = (TextView) inflate.findViewById(R.id.tv_amount);
        TextView textView3 = (TextView) inflate.findViewById(R.id.tv_fee);
        TextView textView4 = (TextView) inflate.findViewById(R.id.dialog_title);
        HBHTtoHTXManager hBHTtoHTXManager = HBHTtoHTXManager.f83692a;
        if (hBHTtoHTXManager.g()) {
            textView4.setText(getString(R.string.n_asset_expand_htx));
        }
        textView.setText(String.valueOf(((HtExchangePresenter) getPresenter()).i0().size()));
        String d02 = ((HtExchangePresenter) getPresenter()).d0();
        String string = getResources().getString(R.string.ht_suffix);
        if (hBHTtoHTXManager.g()) {
            string = "%s HTX";
        }
        textView2.setText(String.format(string, new Object[]{UiFillUtil.c(d02)}));
        textView3.setText(String.format(string, new Object[]{UiFillUtil.c(m.a(((HtExchangePresenter) getPresenter()).h0().getFeeRate()).multiply(m.a(d02)).toPlainString())}));
        button2.setText(R.string.ht_exchange_cancel);
        button2.setOnClickListener(new q5(create));
        button.setText(R.string.currency_stable_convert_confirm_title);
        button.setOnClickListener(new w5(this, create));
        create.show();
    }

    public final void Gh() {
        this.f46559e.post(new y5(this));
    }

    public void N9(HtExchangeConfig htExchangeConfig, List<vk.r> list) {
        this.f46559e.setVisibility(4);
        this.f46560f.setVisibility(4);
        O3(htExchangeConfig);
        setData(list);
        Gh();
    }

    public void O3(HtExchangeConfig htExchangeConfig) {
        String str;
        String totalAmount = htExchangeConfig.getTotalAmount();
        String currency = htExchangeConfig.getCurrency();
        if (totalAmount == null || currency == null) {
            str = "--";
        } else {
            str = totalAmount + "(" + StringUtils.i(currency) + ")";
        }
        String format = String.format(getString(R.string.n_exchange_tips_new_v2), new Object[]{str});
        this.f46571q = format;
        this.f46567m.setText(format);
    }

    public void S(String str) {
        String str2;
        if (m.a(str).compareTo(BigDecimal.ZERO) == 0) {
            str2 = "0";
        } else {
            str2 = UiFillUtil.c(str);
        }
        this.f46563i.setTextColor(ContextCompat.getColor(this, m.a(str2).compareTo(BigDecimal.ZERO) > 0 ? R.color.baseColorMajorTheme100 : R.color.baseColorPrimaryText));
        if (HBHTtoHTXManager.f83692a.g()) {
            this.f46563i.setText(String.format(" %s HTX", new Object[]{str2}));
        } else {
            this.f46563i.setText(String.format(" %s HT", new Object[]{str2}));
        }
    }

    public void addEvent() {
        this.f46559e.setOnClickListener(new t5(this));
        this.f46570p.setOnClickActionListener(new v5(this));
        this.f46558d.setOnMenuItemClickListener(new x5(this));
        this.f46561g.setOnRetryClickListener(new u5(this));
        s5 s5Var = new s5(this);
        this.f46564j.setOnClickListener(s5Var);
        findViewById(R.id.tv_select_all).setOnClickListener(s5Var);
        this.f46566l.setOnClickListener(new r5(this));
    }

    public void bf(j jVar) {
        ((HtExchangePresenter) getPresenter()).p0(false);
    }

    public void finishRefresh() {
        if (this.f46560f.M()) {
            this.f46560f.finishRefresh();
        }
    }

    public int getContentView() {
        return R.layout.activity_ht_exchange;
    }

    public void initView() {
        this.f46570p = (HbTitleBar) this.viewFinder.b(R.id.title_bar);
        this.f46558d = (Toolbar) this.viewFinder.b(R.id.toolbar);
        this.f46556b = (EasyRecyclerView) findViewById(R.id.rcv);
        this.f46559e = findViewById(R.id.ll_tips);
        this.f46572r = (CollapsingToolbarLayout) this.viewFinder.b(R.id.collapsing_toolbar);
        this.f46566l = (TextView) findViewById(R.id.tv_exchange);
        this.f46573s = (TextView) findViewById(R.id.exchange_estimate_tv);
        if (HBHTtoHTXManager.f83692a.g()) {
            setToolBar(this.f46558d, getString(R.string.balance_convert_small_HTX), true);
            this.f46570p.setTitle(getString(R.string.balance_convert_small_HTX));
            this.f46572r.setTitle(getString(R.string.balance_convert_small_HTX));
            this.f46566l.setText(getString(R.string.n_asset_expand_htx));
            this.f46573s.setText(getString(R.string.balance_convert_small_convert_num_HTX));
        } else {
            setToolBar(this.f46558d, getString(R.string.ht_exchange_title), true);
        }
        this.f46560f = (SmartRefreshLayout) findViewById(R.id.refresh_layout);
        this.f46567m = (TextView) findViewById(R.id.tv_tips);
        String format = String.format(getString(R.string.n_exchange_tips_new_v2), new Object[]{"--"});
        this.f46571q = format;
        this.f46567m.setText(format);
        this.f46567m.postDelayed(new p5(this), 2000);
        this.f46560f.i(true);
        this.f46560f.g(false);
        this.f46560f.j0(new SmartRefreshHeader(this));
        this.f46560f.d0(this);
        LoadingLayout loadingLayout = (LoadingLayout) findViewById(R.id.loading_layout);
        this.f46561g = loadingLayout;
        loadingLayout.g();
        this.f46562h = (TextView) findViewById(R.id.tv_selected_count);
        this.f46563i = (TextView) findViewById(R.id.tv_estimate_amount);
        D3(0);
        S("0");
        this.f46564j = (CommonCheckBox) findViewById(R.id.cb_select_all);
        this.f46565k = (TextView) findViewById(R.id.tv_select_all);
        this.f46568n = findViewById(R.id.rcv_head);
        this.f46569o = findViewById(R.id.ll_select_status_bar);
    }

    public void m0() {
        this.f46561g.k();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_currency_detail_record, menu);
        return true;
    }

    public void setData(List<vk.r> list) {
        this.f46557c.clear();
        if (list == null || list.size() == 0) {
            this.f46561g.i();
            this.f46565k.setTextColor(ContextCompat.getColor(this, R.color.baseColorThreeLevelText));
            this.f46569o.setVisibility(8);
        } else {
            this.f46565k.setTextColor(ContextCompat.getColor(this, R.color.baseColorPrimaryText));
            this.f46569o.setVisibility(0);
            this.f46561g.g();
            this.f46557c.addAll(list);
        }
        this.f46568n.setVisibility(0);
        this.f46556b.setData(this.f46557c);
    }

    /* renamed from: sh */
    public HtExchangePresenter createPresenter() {
        return new HtExchangePresenter();
    }

    /* renamed from: th */
    public c6 getUI() {
        return this;
    }

    public void y3(boolean z11) {
        this.f46566l.setEnabled(z11);
    }
}
