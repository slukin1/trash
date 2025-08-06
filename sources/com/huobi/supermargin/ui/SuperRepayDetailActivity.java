package com.huobi.supermargin.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.LoadingLayout;
import com.huobi.supermargin.bean.LoanRepay;
import com.huobi.supermargin.presenter.SuperRepayDetailPresenter;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.k;
import i6.m;
import pro.huobi.R;

public class SuperRepayDetailActivity extends BaseActivity<SuperRepayDetailPresenter, SuperRepayDetailPresenter.b> implements SuperRepayDetailPresenter.b {

    /* renamed from: b  reason: collision with root package name */
    public LoadingLayout f81433b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f81434c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f81435d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f81436e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f81437f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f81438g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f81439h;

    /* renamed from: i  reason: collision with root package name */
    public long f81440i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f81441j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f81442k;

    /* renamed from: l  reason: collision with root package name */
    public TextView f81443l;

    public class a implements View.OnClickListener {
        public a() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            SuperRepayDetailActivity superRepayDetailActivity = SuperRepayDetailActivity.this;
            superRepayDetailActivity.Pg(superRepayDetailActivity.f81440i);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            SuperRepayDetailActivity.this.finish();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class c extends EasySubscriber<LoanRepay> {
        public c() {
        }

        /* renamed from: a */
        public void onNext(LoanRepay loanRepay) {
            SuperRepayDetailActivity.this.f81433b.g();
            SuperRepayDetailActivity.this.Qg(loanRepay);
        }

        public void onError2(Throwable th2) {
            SuperRepayDetailActivity.this.f81433b.k();
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            SuperRepayDetailActivity.this.f81433b.k();
        }
    }

    public static Intent fg(Context context, long j11) {
        Intent intent = new Intent(context, SuperRepayDetailActivity.class);
        intent.putExtra("REPAY_ID", j11);
        return intent;
    }

    /* renamed from: Og */
    public SuperRepayDetailPresenter.b getUI() {
        return this;
    }

    public final void Pg(long j11) {
        this.f81433b.p();
        ((SuperRepayDetailPresenter) getPresenter()).Q(j11).compose(RxJavaHelper.t(getUI())).subscribe(new c());
    }

    public void Qg(LoanRepay loanRepay) {
        String z11 = k.C().z(loanRepay.getCurrency());
        if ("HT".equalsIgnoreCase(loanRepay.getDeductCurrency())) {
            this.f81441j.setText(R.string.ht_deduct_return);
            this.f81442k.setText(R.string.deduct_amount);
            this.f81434c.setText(String.format("%s %s", new Object[]{m.m(loanRepay.getRepayAmount(), PrecisionUtil.m()), "HT"}));
            this.f81443l.setText(R.string.estimate_interest);
            this.f81435d.setText(String.format("%s %s", new Object[]{m.m(loanRepay.getInterest(), PrecisionUtil.r()), z11}));
        } else if ("HTX".equalsIgnoreCase(loanRepay.getDeductCurrency())) {
            this.f81441j.setText(R.string.balance_super_margin_histoay_deduct_currency_htx);
            this.f81442k.setText(R.string.deduct_amount);
            this.f81434c.setText(String.format("%s %s", new Object[]{m.m(loanRepay.getRepayAmount(), PrecisionUtil.m()), "HTX"}));
            this.f81443l.setText(R.string.estimate_interest);
            this.f81435d.setText(String.format("%s %s", new Object[]{m.m(loanRepay.getInterest(), PrecisionUtil.r()), z11}));
        } else if ("TRX".equalsIgnoreCase(loanRepay.getDeductCurrency())) {
            this.f81441j.setText(R.string.balance_super_margin_histoay_deduct_currency_trx);
            this.f81442k.setText(R.string.deduct_amount);
            this.f81434c.setText(String.format("%s %s", new Object[]{m.m(loanRepay.getRepayAmount(), PrecisionUtil.m()), "TRX"}));
            this.f81443l.setText(R.string.estimate_interest);
            this.f81435d.setText(String.format("%s %s", new Object[]{m.m(loanRepay.getInterest(), PrecisionUtil.r()), z11}));
        } else if ("HBPOINT".equalsIgnoreCase(loanRepay.getDeductCurrency())) {
            this.f81441j.setText(R.string.point_deduct_return);
            this.f81442k.setText(R.string.deduct_amount);
            this.f81434c.setText(String.format("%s %s", new Object[]{m.m(loanRepay.getRepayAmount(), PrecisionUtil.m()), "PTS"}));
            this.f81443l.setText(R.string.estimate_interest);
            this.f81435d.setText(String.format("%s %s", new Object[]{m.m(loanRepay.getInterest(), PrecisionUtil.r()), z11}));
        } else {
            this.f81441j.setText(getString(R.string.return_currency, new Object[]{z11}));
            this.f81442k.setText(R.string.return_sum);
            this.f81434c.setText(String.format("%s %s", new Object[]{m.m(loanRepay.getRepayAmount(), PrecisionUtil.r()), z11}));
            this.f81443l.setText(R.string.return_interest);
            this.f81435d.setText(String.format("%s %s", new Object[]{m.m(loanRepay.getInterestAmount(), PrecisionUtil.r()), z11}));
        }
        this.f81436e.setText(DateTimeUtils.g(loanRepay.getRepayTime()));
        this.f81437f.setText(DateTimeUtils.g(loanRepay.getLoanTime()));
        this.f81438g.setText(String.format("%s %s", new Object[]{m.m(loanRepay.getLoanAmount(), PrecisionUtil.r()), z11}));
        this.f81439h.setText(String.format("%s %s", new Object[]{m.m(loanRepay.getInterest(), PrecisionUtil.r()), z11}));
    }

    public void addEvent() {
        this.f81433b.setOnRetryClickListener(new a());
        this.viewFinder.b(R.id.iv_back).setOnClickListener(new b());
    }

    public boolean canFullScreen() {
        return false;
    }

    public int getContentView() {
        return R.layout.activity_super_repay_detail;
    }

    /* renamed from: gg */
    public SuperRepayDetailPresenter createPresenter() {
        return new SuperRepayDetailPresenter();
    }

    public void initView() {
        this.f81441j = (TextView) this.viewFinder.b(R.id.tv_currency);
        this.f81433b = (LoadingLayout) this.viewFinder.b(R.id.loading_layout);
        this.f81442k = (TextView) this.viewFinder.b(R.id.tv_repay_amount_label);
        this.f81434c = (TextView) this.viewFinder.b(R.id.tv_repay_amount);
        this.f81443l = (TextView) this.viewFinder.b(R.id.tv_interest_amount_label);
        this.f81435d = (TextView) this.viewFinder.b(R.id.tv_interest_amount);
        this.f81436e = (TextView) this.viewFinder.b(R.id.tv_repay_time);
        this.f81437f = (TextView) this.viewFinder.b(R.id.tv_loan_time);
        this.f81438g = (TextView) this.viewFinder.b(R.id.tv_loan_amount);
        this.f81439h = (TextView) this.viewFinder.b(R.id.tv_interest);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        long longExtra = getIntent().getLongExtra("REPAY_ID", 0);
        this.f81440i = longExtra;
        Pg(longExtra);
    }
}
