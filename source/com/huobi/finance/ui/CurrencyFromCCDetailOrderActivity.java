package com.huobi.finance.ui;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.network.hbg.core.bean.CurrencyFromCCFinanceRecordInfo;
import com.huobi.finance.bean.CurrencyFromCCFinanceRecordItem;
import com.huobi.finance.presenter.CurrencyFromCCOrderDetailPresenter;
import com.huobi.view.button.StatusButton;
import com.huobi.view.collapsingtoolbarlayout.CollapsingToolbarLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.xiaomi.mipush.sdk.Constants;
import i6.m;
import java.util.Locale;
import pro.huobi.R;

public class CurrencyFromCCDetailOrderActivity extends BaseActivity<CurrencyFromCCOrderDetailPresenter, CurrencyFromCCOrderDetailPresenter.a> implements CurrencyFromCCOrderDetailPresenter.a {

    /* renamed from: b  reason: collision with root package name */
    public CollapsingToolbarLayout f46505b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f46506c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f46507d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f46508e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f46509f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f46510g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f46511h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f46512i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f46513j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f46514k;

    /* renamed from: l  reason: collision with root package name */
    public TextView f46515l;

    /* renamed from: m  reason: collision with root package name */
    public StatusButton f46516m;

    /* renamed from: n  reason: collision with root package name */
    public StatusButton f46517n;

    /* renamed from: o  reason: collision with root package name */
    public View f46518o;

    /* renamed from: p  reason: collision with root package name */
    public View f46519p;

    /* renamed from: q  reason: collision with root package name */
    public TextView f46520q;

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Og(View view) {
        ((CurrencyFromCCOrderDetailPresenter) getPresenter()).R();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Pg(String str, String str2, String str3) {
        CollapsingToolbarLayout collapsingToolbarLayout = this.f46505b;
        if (collapsingToolbarLayout != null) {
            collapsingToolbarLayout.setTitle(str + str2 + " " + str3.toUpperCase(Locale.US));
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        ((CurrencyFromCCOrderDetailPresenter) getPresenter()).S();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void addEvent() {
        this.f46516m.setOnClickListener(new v4(this));
        this.f46517n.setOnClickListener(new w4(this));
    }

    /* renamed from: fg */
    public CurrencyFromCCOrderDetailPresenter createPresenter() {
        return new CurrencyFromCCOrderDetailPresenter();
    }

    public int getContentView() {
        return R.layout.activity_currency_from_cc_order_detail;
    }

    /* renamed from: gg */
    public CurrencyFromCCOrderDetailPresenter.a getUI() {
        return this;
    }

    public void hh(CurrencyFromCCFinanceRecordInfo currencyFromCCFinanceRecordInfo) {
        String str;
        String str2;
        String str3;
        String str4 = "--";
        String currency = currencyFromCCFinanceRecordInfo.getCurrency();
        if (currency == null) {
            finish();
            return;
        }
        this.f46506c.setText(DateTimeUtils.h(currencyFromCCFinanceRecordInfo.getCreateAtLong(), "HH:mm:ss MM/dd/yyyy "));
        this.f46507d.setText(currency.toUpperCase(Locale.US));
        if (currencyFromCCFinanceRecordInfo.getType() == 1) {
            this.f46514k.setText(R.string.n_currency_from_cc_deposit_order_id);
            this.f46515l.setText(R.string.n_currency_from_cc_deposit_count);
            this.f46508e.setText(R.string.n_currency_operation_type_deposit);
            str = "+";
        } else {
            this.f46514k.setText(R.string.n_currency_from_cc_withdraw_order_id);
            this.f46515l.setText(R.string.n_currency_from_cc_withdraw_count);
            this.f46508e.setText(R.string.n_currency_operation_type_withdraw);
            str = Constants.ACCEPT_TIME_SEPARATOR_SERVER;
        }
        if (currencyFromCCFinanceRecordInfo.getType() == 1 && currencyFromCCFinanceRecordInfo.getStateInt() == 1) {
            this.f46509f.setTextColor(ContextCompat.getColor(this, R.color.baseColorShadeButtonRedStart));
            this.f46518o.setVisibility(0);
        } else {
            this.f46509f.setTextColor(ContextCompat.getColor(this, R.color.global_main_text_color));
            this.f46518o.setVisibility(8);
        }
        this.f46509f.setText(new CurrencyFromCCFinanceRecordItem(currencyFromCCFinanceRecordInfo).getStatusTextId(this));
        this.f46510g.setText(currencyFromCCFinanceRecordInfo.getOrderCode());
        this.f46511h.setText(currencyFromCCFinanceRecordInfo.getPaymentMethodName());
        if (TextUtils.isEmpty(currencyFromCCFinanceRecordInfo.getBank())) {
            this.f46519p.setVisibility(8);
        } else {
            this.f46519p.setVisibility(0);
            this.f46520q.setText(currencyFromCCFinanceRecordInfo.getBank());
        }
        try {
            str2 = m.q(currencyFromCCFinanceRecordInfo.getAmount().subtract(currencyFromCCFinanceRecordInfo.getFee()), 2);
        } catch (Exception e11) {
            e11.printStackTrace();
            str2 = str4;
        }
        this.f46505b.post(new x4(this, str, str2, currency));
        try {
            str3 = m.q(currencyFromCCFinanceRecordInfo.getAmount(), 2);
        } catch (Exception e12) {
            e12.printStackTrace();
            str3 = str4;
        }
        this.f46512i.setText(str3);
        try {
            str4 = m.q(currencyFromCCFinanceRecordInfo.getFee(), 2);
        } catch (Exception e13) {
            e13.printStackTrace();
        }
        this.f46513j.setText(str4);
    }

    public void initView() {
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) this.viewFinder.b(R.id.currency_detail_collapsing_toolbar);
        this.f46505b = collapsingToolbarLayout;
        collapsingToolbarLayout.setDrawCollapsingMiddleTitle(false);
        this.f46506c = (TextView) this.viewFinder.b(R.id.currency_order_date);
        this.f46507d = (TextView) this.viewFinder.b(R.id.currency_order_coin_type);
        this.f46508e = (TextView) this.viewFinder.b(R.id.currency_order_type);
        this.f46509f = (TextView) this.viewFinder.b(R.id.currency_order_status);
        this.f46510g = (TextView) this.viewFinder.b(R.id.currency_order_order_id);
        this.f46511h = (TextView) this.viewFinder.b(R.id.currency_order_payment_method);
        this.f46519p = this.viewFinder.b(R.id.currency_detail_bank_container);
        this.f46520q = (TextView) this.viewFinder.b(R.id.currency_detail_bank_tv);
        this.f46512i = (TextView) this.viewFinder.b(R.id.currency_order_amount);
        this.f46513j = (TextView) this.viewFinder.b(R.id.currency_order_fee);
        this.f46516m = (StatusButton) this.viewFinder.b(R.id.currency_detail_payment);
        this.f46517n = (StatusButton) this.viewFinder.b(R.id.currency_detail_cancel);
        this.f46518o = this.viewFinder.b(R.id.currency_detail_bottom_layout);
        this.f46514k = (TextView) this.viewFinder.b(R.id.currency_detail_order_id_tv);
        this.f46515l = (TextView) this.viewFinder.b(R.id.currency_detail_amount_tv);
        Toolbar toolbar = (Toolbar) this.viewFinder.b(R.id.currency_order_detail_toolbar);
        toolbar.setTitle((CharSequence) getResources().getString(R.string.currency_order_detail));
        setToolBar(toolbar, getResources().getString(R.string.currency_order_detail), true);
    }
}
