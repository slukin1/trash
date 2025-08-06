package com.huobi.finance.ui;

import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.huobi.finance.bean.OtcFinanceRecordItem;
import com.huobi.finance.presenter.OtcCurrencyOrderDetailPresenter;
import com.huobi.otc.utils.OtcMarketPriceConfigUtil;
import com.huobi.view.collapsingtoolbarlayout.CollapsingToolbarLayout;
import com.xiaomi.mipush.sdk.Constants;
import i6.m;
import java.util.Locale;
import pro.huobi.R;

public class OtcCurrencyDetailOrderActivity extends BaseActivity<OtcCurrencyOrderDetailPresenter, OtcCurrencyOrderDetailPresenter.a> implements OtcCurrencyOrderDetailPresenter.a {

    /* renamed from: b  reason: collision with root package name */
    public CollapsingToolbarLayout f46708b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f46709c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f46710d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f46711e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f46712f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f46713g;

    /* renamed from: h  reason: collision with root package name */
    public Toolbar f46714h;

    /* renamed from: i  reason: collision with root package name */
    public CoordinatorLayout f46715i;

    /* access modifiers changed from: private */
    public /* synthetic */ void gg(String str, String str2, String str3) {
        CollapsingToolbarLayout collapsingToolbarLayout = this.f46708b;
        if (collapsingToolbarLayout != null) {
            collapsingToolbarLayout.setTitle(str + str2 + str3.toUpperCase(Locale.US));
        }
    }

    public void Ig(OtcFinanceRecordItem otcFinanceRecordItem) {
        Yf(otcFinanceRecordItem);
    }

    public final void Yf(OtcFinanceRecordItem otcFinanceRecordItem) {
        String str;
        String str2;
        String c11 = OtcMarketPriceConfigUtil.c(otcFinanceRecordItem.getCoinId());
        this.f46711e.setText(DateTimeUtils.h(otcFinanceRecordItem.getGmtCreate(), "HH:mm:ss MM/dd/yyyy "));
        this.f46712f.setVisibility(8);
        try {
            str = m.m(otcFinanceRecordItem.getCashFreeFlow(), PrecisionUtil.b(c11));
        } catch (Exception e11) {
            e11.printStackTrace();
            str = "--";
        }
        int type = otcFinanceRecordItem.getType();
        if (type != 2) {
            if (type == 3) {
                this.f46713g.setText(R.string.otc_balance_detail_buy);
            } else if (type == 5) {
                this.f46713g.setText(R.string.otc_balance_detail_in);
                this.f46712f.setVisibility(0);
                this.f46712f.setText(R.string.n_transfer_to_otc);
            } else if (type == 6) {
                this.f46713g.setText(R.string.otc_balance_detail_out);
                this.f46712f.setVisibility(0);
                this.f46712f.setText(R.string.n_transfer_from_otc);
            } else if (type == 7) {
                this.f46713g.setText(R.string.n_otc_balance_detail_deposit);
            } else if (type == 43) {
                this.f46713g.setText(R.string.otc_balance_detail_legal);
            } else if (type != 45) {
                this.f46713g.setText(R.string.currency_detail_system);
                str2 = "";
                this.f46708b.post(new c7(this, str2, str, c11));
            } else {
                this.f46713g.setText(R.string.otc_balance_detail_fee);
            }
            str2 = "+";
            this.f46708b.post(new c7(this, str2, str, c11));
        }
        this.f46713g.setText(R.string.otc_balance_detail_sell);
        str2 = Constants.ACCEPT_TIME_SEPARATOR_SERVER;
        this.f46708b.post(new c7(this, str2, str, c11));
    }

    /* renamed from: Zf */
    public OtcCurrencyOrderDetailPresenter createPresenter() {
        return new OtcCurrencyOrderDetailPresenter();
    }

    public void addEvent() {
    }

    /* renamed from: fg */
    public OtcCurrencyOrderDetailPresenter.a getUI() {
        return this;
    }

    public int getContentView() {
        return R.layout.activity_otc_currency_order_detail;
    }

    public void initView() {
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) this.viewFinder.b(R.id.currency_detail_collapsing_toolbar);
        this.f46708b = collapsingToolbarLayout;
        collapsingToolbarLayout.setDrawCollapsingMiddleTitle(false);
        this.f46709c = (TextView) this.viewFinder.b(R.id.currency_order_status);
        this.f46710d = (TextView) this.viewFinder.b(R.id.currency_order_status_message);
        this.f46711e = (TextView) this.viewFinder.b(R.id.currency_order_date);
        this.f46713g = (TextView) this.viewFinder.b(R.id.currency_order_type);
        this.f46712f = (TextView) this.viewFinder.b(R.id.currency_transfer_indicator);
        Toolbar toolbar = (Toolbar) this.viewFinder.b(R.id.currency_order_detail_toolbar);
        this.f46714h = toolbar;
        toolbar.setTitle((CharSequence) getResources().getString(R.string.currency_order_detail));
        setToolBar(this.f46714h, getResources().getString(R.string.currency_order_detail), true);
        this.f46715i = (CoordinatorLayout) this.viewFinder.b(R.id.main_content);
    }
}
