package com.huobi.finance.ui;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import bj.d;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.data.future.util.FuturePrecisionUtil;
import com.hbg.lib.network.option.core.bean.OptionFinancialRecord;
import com.huobi.finance.presenter.OptionOrderDetailPresenter;
import com.huobi.view.collapsingtoolbarlayout.CollapsingToolbarLayout;
import i6.m;
import java.math.BigDecimal;
import java.util.Locale;
import pro.huobi.R;

public class OptionDetailOrderActivity extends BaseActivity<OptionOrderDetailPresenter, OptionOrderDetailPresenter.a> implements OptionOrderDetailPresenter.a {

    /* renamed from: b  reason: collision with root package name */
    public CollapsingToolbarLayout f46693b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f46694c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f46695d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f46696e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f46697f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f46698g;

    /* renamed from: h  reason: collision with root package name */
    public View f46699h;

    public void D4(OptionFinancialRecord optionFinancialRecord) {
        String symbol = optionFinancialRecord.getSymbol();
        this.f46697f.setText(DateTimeUtils.h(optionFinancialRecord.getCreatedAt(), "HH:mm:ss MM/dd/yyyy "));
        Xf(optionFinancialRecord);
        String m11 = m.m(optionFinancialRecord.getInterest(), FuturePrecisionUtil.m(symbol));
        this.f46696e.setText(String.format("%s %s", new Object[]{m11, StringUtils.i(optionFinancialRecord.getSymbol())}));
        String amount = optionFinancialRecord.getAmount();
        if (amount == null || m.a(amount).compareTo(BigDecimal.ZERO) == 0) {
            this.f46699h.setVisibility(8);
        } else {
            this.f46695d.setText(m.m(amount, 0));
        }
    }

    public final void Xf(OptionFinancialRecord optionFinancialRecord) {
        String str;
        this.f46698g.setText(d.r(optionFinancialRecord.getMoneyType(), 10));
        this.f46694c.setText(d.f(d.g(optionFinancialRecord.getMoneyType())));
        int n11 = FuturePrecisionUtil.n(optionFinancialRecord.getSymbol());
        if (TextUtils.isEmpty(optionFinancialRecord.getMoney())) {
            str = "--";
        } else {
            str = m.m(optionFinancialRecord.getMoney(), n11);
        }
        try {
            if (Double.compare(m.h0(str), 0.0d) > 0) {
                CollapsingToolbarLayout collapsingToolbarLayout = this.f46693b;
                collapsingToolbarLayout.setTitle("+" + str + optionFinancialRecord.getCurrency().toUpperCase(Locale.US));
                return;
            }
            CollapsingToolbarLayout collapsingToolbarLayout2 = this.f46693b;
            collapsingToolbarLayout2.setTitle(str + optionFinancialRecord.getCurrency().toUpperCase(Locale.US));
        } catch (Exception e11) {
            CollapsingToolbarLayout collapsingToolbarLayout3 = this.f46693b;
            collapsingToolbarLayout3.setTitle(str + optionFinancialRecord.getCurrency().toUpperCase(Locale.US));
            e11.printStackTrace();
        }
    }

    /* renamed from: Yf */
    public OptionOrderDetailPresenter createPresenter() {
        return new OptionOrderDetailPresenter();
    }

    /* renamed from: Zf */
    public OptionOrderDetailPresenter.a getUI() {
        return this;
    }

    public void addEvent() {
    }

    public int getContentView() {
        return R.layout.activity_option_order_detail;
    }

    public void initView() {
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) this.viewFinder.b(R.id.contract_detail_collapsing_toolbar);
        this.f46693b = collapsingToolbarLayout;
        collapsingToolbarLayout.setDrawCollapsingMiddleTitle(false);
        this.f46694c = (TextView) this.viewFinder.b(R.id.currency_order_type);
        this.f46699h = this.viewFinder.b(R.id.layout_piece);
        this.f46695d = (TextView) this.viewFinder.b(R.id.currency_order_piece);
        this.f46696e = (TextView) this.viewFinder.b(R.id.currency_order_fee);
        this.f46697f = (TextView) this.viewFinder.b(R.id.currency_order_date);
        this.f46698g = (TextView) this.viewFinder.b(R.id.currency_transfer_indicator);
        Toolbar toolbar = (Toolbar) this.viewFinder.b(R.id.currency_order_detail_toolbar);
        toolbar.setTitle((CharSequence) getResources().getString(R.string.currency_order_detail));
        setToolBar(toolbar, "", true);
    }
}
