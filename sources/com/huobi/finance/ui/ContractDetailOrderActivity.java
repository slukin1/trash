package com.huobi.finance.ui;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import bj.d;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.core.ui.BaseActivity;
import com.huobi.contract.helper.ContractCurrencyUtils;
import com.huobi.finance.bean.ContractRecordItem;
import com.huobi.finance.presenter.ContractOrderDetailPresenter;
import com.huobi.view.collapsingtoolbarlayout.CollapsingToolbarLayout;
import ej.f;
import i6.m;
import java.util.Locale;
import pro.huobi.R;

public class ContractDetailOrderActivity extends BaseActivity<ContractOrderDetailPresenter, ContractOrderDetailPresenter.a> implements ContractOrderDetailPresenter.a {

    /* renamed from: b  reason: collision with root package name */
    public CollapsingToolbarLayout f46420b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f46421c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f46422d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f46423e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f46424f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f46425g;

    /* renamed from: h  reason: collision with root package name */
    public Toolbar f46426h;

    /* renamed from: i  reason: collision with root package name */
    public CoordinatorLayout f46427i;

    /* renamed from: j  reason: collision with root package name */
    public View f46428j;

    public void V7(ContractRecordItem contractRecordItem) {
        contractRecordItem.getSymbol();
        this.f46424f.setText(DateTimeUtils.h(contractRecordItem.getCreatedAt(), "HH:mm:ss MM/dd/yyyy "));
        Xf(contractRecordItem);
        String m11 = m.m(contractRecordItem.getInterest(), f.f());
        TextView textView = this.f46423e;
        textView.setText(m11 + " " + contractRecordItem.getSymbol().toUpperCase(Locale.US));
        if (contractRecordItem.getAmount() == null) {
            this.f46428j.setVisibility(8);
        } else {
            this.f46422d.setText(m.m(contractRecordItem.getAmount(), 0));
        }
    }

    public final void Xf(ContractRecordItem contractRecordItem) {
        String str;
        this.f46425g.setText(d.q(contractRecordItem.getMoneyType()));
        this.f46421c.setText(d.f(d.g(contractRecordItem.getMoneyType())));
        int o11 = ContractCurrencyUtils.o(contractRecordItem.getSymbol(), 8);
        if (TextUtils.isEmpty(contractRecordItem.getMoney())) {
            str = "--";
        } else {
            str = m.m(contractRecordItem.getMoney(), o11);
        }
        try {
            if (Double.compare(m.h0(str), 0.0d) > 0) {
                CollapsingToolbarLayout collapsingToolbarLayout = this.f46420b;
                collapsingToolbarLayout.setTitle("+" + str + contractRecordItem.getSymbol().toUpperCase(Locale.US));
                return;
            }
            CollapsingToolbarLayout collapsingToolbarLayout2 = this.f46420b;
            collapsingToolbarLayout2.setTitle(str + contractRecordItem.getSymbol().toUpperCase(Locale.US));
        } catch (Exception e11) {
            CollapsingToolbarLayout collapsingToolbarLayout3 = this.f46420b;
            collapsingToolbarLayout3.setTitle(str + contractRecordItem.getSymbol().toUpperCase(Locale.US));
            e11.printStackTrace();
        }
    }

    /* renamed from: Yf */
    public ContractOrderDetailPresenter createPresenter() {
        return new ContractOrderDetailPresenter();
    }

    /* renamed from: Zf */
    public ContractOrderDetailPresenter.a getUI() {
        return this;
    }

    public void addEvent() {
    }

    public int getContentView() {
        return R.layout.activity_contract_order_detail;
    }

    public void initView() {
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) this.viewFinder.b(R.id.contract_detail_collapsing_toolbar);
        this.f46420b = collapsingToolbarLayout;
        collapsingToolbarLayout.setDrawCollapsingMiddleTitle(false);
        this.f46421c = (TextView) this.viewFinder.b(R.id.currency_order_type);
        this.f46428j = this.viewFinder.b(R.id.layout_piece);
        this.f46422d = (TextView) this.viewFinder.b(R.id.currency_order_piece);
        this.f46423e = (TextView) this.viewFinder.b(R.id.currency_order_fee);
        this.f46424f = (TextView) this.viewFinder.b(R.id.currency_order_date);
        this.f46425g = (TextView) this.viewFinder.b(R.id.currency_transfer_indicator);
        Toolbar toolbar = (Toolbar) this.viewFinder.b(R.id.currency_order_detail_toolbar);
        this.f46426h = toolbar;
        toolbar.setTitle((CharSequence) getResources().getString(R.string.currency_order_detail));
        setToolBar(this.f46426h, "", true);
        this.f46427i = (CoordinatorLayout) this.viewFinder.b(R.id.main_content);
    }
}
