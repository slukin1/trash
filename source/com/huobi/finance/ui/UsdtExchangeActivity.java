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
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.network.hbg.core.bean.UsdtExchangeConfig;
import com.hbg.lib.widgets.CommonCheckBox;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.huobi.finance.presenter.UsdtExchangePresenter;
import com.huobi.finance.utils.UiFillUtil;
import com.huobi.page.SmartRefreshHeader;
import com.huobi.view.title.HbTitleBar;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.m;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import ky.j;
import ny.c;
import pro.huobi.R;
import s9.a;
import tg.r;
import vk.y;

public class UsdtExchangeActivity extends BaseActivity<UsdtExchangePresenter, dc> implements dc, c {

    /* renamed from: b  reason: collision with root package name */
    public EasyRecyclerView f46978b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<a> f46979c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public Toolbar f46980d;

    /* renamed from: e  reason: collision with root package name */
    public View f46981e;

    /* renamed from: f  reason: collision with root package name */
    public View f46982f;

    /* renamed from: g  reason: collision with root package name */
    public SmartRefreshLayout f46983g;

    /* renamed from: h  reason: collision with root package name */
    public LoadingLayout f46984h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f46985i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f46986j;

    /* renamed from: k  reason: collision with root package name */
    public CommonCheckBox f46987k;

    /* renamed from: l  reason: collision with root package name */
    public TextView f46988l;

    /* renamed from: m  reason: collision with root package name */
    public TextView f46989m;

    /* renamed from: n  reason: collision with root package name */
    public TextView f46990n;

    /* renamed from: o  reason: collision with root package name */
    public View f46991o;

    /* renamed from: p  reason: collision with root package name */
    public View f46992p;

    /* renamed from: q  reason: collision with root package name */
    public HbTitleBar f46993q;

    @SensorsDataInstrumented
    public static /* synthetic */ void Ah(Dialog dialog, View view) {
        dialog.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Bh(Dialog dialog, View view) {
        ((UsdtExchangePresenter) getPresenter()).N0();
        dialog.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Ch(ValueAnimator valueAnimator) {
        this.f46981e.setVisibility(0);
        this.f46983g.setVisibility(0);
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.f46981e.setTranslationY(floatValue);
        this.f46991o.setTranslationY(floatValue);
        this.f46983g.setTranslationY(floatValue);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Dh() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{(float) (-this.f46981e.getHeight()), 0.0f});
        ofFloat.setDuration(270);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.addUpdateListener(new rb(this));
        ofFloat.start();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        startActivity(new Intent(this, UsdtExchangeHistoryActivity.class));
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$2(View view) {
        th();
        ((UsdtExchangePresenter) getPresenter()).l0();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$3(View view) {
        ((UsdtExchangePresenter) getPresenter()).F0(true);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$4(View view) {
        if (this.f46979c.size() == 0) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        this.f46987k.toggle();
        ((UsdtExchangePresenter) getPresenter()).J0(this.f46987k.isChecked());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static void sh(Context context) {
        if (r.x().F0()) {
            context.startActivity(new Intent(context, UsdtExchangeActivity.class));
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ boolean wh(MenuItem menuItem) {
        startActivity(new Intent(this, UsdtExchangeHistoryActivity.class));
        SensorsDataAutoTrackHelper.trackMenuItem(this, menuItem);
        return true;
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void xh(View view) {
        Eh();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void yh(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        if (valueAnimator.getAnimatedFraction() == 1.0f) {
            this.f46981e.setVisibility(8);
            this.f46991o.setTranslationY(0.0f);
            this.f46983g.setTranslationY(0.0f);
            return;
        }
        this.f46981e.setTranslationY(floatValue);
        this.f46991o.setTranslationY(floatValue);
        this.f46983g.setTranslationY(floatValue);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void zh() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, (float) (-this.f46981e.getHeight())});
        ofFloat.setDuration(270);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.addUpdateListener(new ob(this));
        ofFloat.start();
    }

    public void C3(boolean z11) {
        this.f46987k.setChecked(z11);
    }

    public void D3(int i11) {
        String valueOf = String.valueOf(i11);
        String format = String.format(getString(R.string.ht_exchange_selected_count), new Object[]{valueOf});
        SpannableString spannableString = new SpannableString(format);
        spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this, i11 > 0 ? R.color.baseColorPrimaryText : R.color.baseColorSecondaryText)), format.indexOf(valueOf), format.indexOf(valueOf) + valueOf.length(), 33);
        this.f46985i.setText(spannableString);
    }

    public final void Eh() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.dialog_ht_exchange_confirm, (ViewGroup) null);
        AlertDialog create = new AlertDialog.Builder(this).setView(inflate).create();
        create.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        Button button = (Button) inflate.findViewById(R.id.dialog_confirm_btn);
        Button button2 = (Button) inflate.findViewById(R.id.dialog_cancel_btn);
        ((TextView) inflate.findViewById(R.id.dialog_title)).setText(getResources().getString(R.string.n_usdt_exchange_btn));
        ((TextView) inflate.findViewById(R.id.tv_count)).setText(String.valueOf(((UsdtExchangePresenter) getPresenter()).q0().size()));
        String j02 = ((UsdtExchangePresenter) getPresenter()).j0();
        String string = getResources().getString(R.string.usdt_suffix);
        ((TextView) inflate.findViewById(R.id.tv_amount)).setText(String.format(string, new Object[]{UiFillUtil.d(j02)}));
        ((TextView) inflate.findViewById(R.id.tv_fee)).setText(String.format(string, new Object[]{UiFillUtil.d(m.a(((UsdtExchangePresenter) getPresenter()).p0().getFeeRate()).multiply(m.a(j02)).toPlainString())}));
        button2.setText(R.string.ht_exchange_cancel);
        button2.setOnClickListener(new sb(create));
        button.setText(R.string.currency_stable_convert_confirm_title);
        button.setOnClickListener(new yb(this, create));
        create.show();
    }

    public final void Fh() {
        this.f46981e.post(new qb(this));
    }

    public void S(String str) {
        String str2;
        if (m.a(str).compareTo(BigDecimal.ZERO) == 0) {
            str2 = "0";
        } else {
            str2 = UiFillUtil.d(str);
        }
        this.f46986j.setTextColor(ContextCompat.getColor(this, m.a(str2).compareTo(BigDecimal.ZERO) > 0 ? R.color.baseColorMajorTheme100 : R.color.baseColorPrimaryText));
        this.f46986j.setText(String.format(" %s USDT", new Object[]{str2}));
    }

    public void addEvent() {
        this.f46993q.setOnClickActionListener(new vb(this));
        this.f46980d.setOnMenuItemClickListener(new zb(this));
        this.f46982f.setOnClickListener(new tb(this));
        this.f46984h.setOnRetryClickListener(new xb(this));
        wb wbVar = new wb(this);
        this.f46987k.setOnClickListener(wbVar);
        findViewById(R.id.tv_select_all).setOnClickListener(wbVar);
        this.f46989m.setOnClickListener(new ub(this));
    }

    public void bf(j jVar) {
        ((UsdtExchangePresenter) getPresenter()).F0(false);
    }

    public void eh(UsdtExchangeConfig usdtExchangeConfig, List<y> list) {
        this.f46981e.setVisibility(4);
        this.f46983g.setVisibility(4);
        lf(usdtExchangeConfig);
        setData(list);
        Fh();
    }

    public void finishRefresh() {
        if (this.f46983g.M()) {
            this.f46983g.finishRefresh();
        }
    }

    public int getContentView() {
        return R.layout.activity_usdt_exchange;
    }

    public void initView() {
        this.f46993q = (HbTitleBar) this.viewFinder.b(R.id.title_bar);
        this.f46980d = (Toolbar) this.viewFinder.b(R.id.toolbar);
        this.f46978b = (EasyRecyclerView) findViewById(R.id.rcv);
        this.f46981e = findViewById(R.id.ll_tips);
        this.f46982f = findViewById(R.id.iv_tips_close);
        setToolBar(this.f46980d, getString(R.string.n_usdt_exchange_title), true);
        this.f46983g = (SmartRefreshLayout) findViewById(R.id.refresh_layout);
        TextView textView = (TextView) findViewById(R.id.tv_tips);
        this.f46990n = textView;
        textView.setText(getString(R.string.n_usdt_exchange_tips));
        this.f46983g.i(true);
        this.f46983g.g(false);
        this.f46983g.j0(new SmartRefreshHeader(this));
        this.f46983g.d0(this);
        LoadingLayout loadingLayout = (LoadingLayout) findViewById(R.id.loading_layout);
        this.f46984h = loadingLayout;
        loadingLayout.g();
        this.f46985i = (TextView) findViewById(R.id.tv_selected_count);
        this.f46986j = (TextView) findViewById(R.id.tv_estimate_amount);
        D3(0);
        S("0");
        this.f46987k = (CommonCheckBox) findViewById(R.id.cb_select_all);
        this.f46988l = (TextView) findViewById(R.id.tv_select_all);
        this.f46989m = (TextView) findViewById(R.id.tv_exchange);
        this.f46991o = findViewById(R.id.rcv_head);
        this.f46992p = findViewById(R.id.ll_select_status_bar);
    }

    public void lf(UsdtExchangeConfig usdtExchangeConfig) {
    }

    public void m0() {
        this.f46984h.k();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_currency_detail_record, menu);
        return true;
    }

    public void setData(List<y> list) {
        this.f46979c.clear();
        if (list == null || list.size() == 0) {
            this.f46984h.i();
            this.f46988l.setTextColor(ContextCompat.getColor(this, R.color.baseColorThreeLevelText));
            this.f46992p.setVisibility(8);
        } else {
            this.f46988l.setTextColor(ContextCompat.getColor(this, R.color.baseColorPrimaryText));
            this.f46992p.setVisibility(0);
            this.f46984h.g();
            this.f46979c.addAll(list);
        }
        this.f46991o.setVisibility(0);
        this.f46978b.setData(this.f46979c);
    }

    public final void th() {
        this.f46981e.post(new pb(this));
    }

    /* renamed from: uh */
    public UsdtExchangePresenter createPresenter() {
        return new UsdtExchangePresenter();
    }

    /* renamed from: vh */
    public dc getUI() {
        return this;
    }

    public void y3(boolean z11) {
        this.f46989m.setEnabled(z11);
    }
}
