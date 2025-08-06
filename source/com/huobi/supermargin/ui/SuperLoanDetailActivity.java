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
import com.huobi.supermargin.presenter.SuperLoanDetailPresenter;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.k;
import i6.m;
import java.math.BigDecimal;
import java.util.Locale;
import pro.huobi.R;

public class SuperLoanDetailActivity extends BaseActivity<SuperLoanDetailPresenter, SuperLoanDetailPresenter.b> implements SuperLoanDetailPresenter.b {

    /* renamed from: b  reason: collision with root package name */
    public LoadingLayout f81387b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f81388c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f81389d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f81390e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f81391f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f81392g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f81393h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f81394i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f81395j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f81396k;

    /* renamed from: l  reason: collision with root package name */
    public TextView f81397l;

    /* renamed from: m  reason: collision with root package name */
    public TextView f81398m;

    /* renamed from: n  reason: collision with root package name */
    public TextView f81399n;

    /* renamed from: o  reason: collision with root package name */
    public long f81400o;

    public class a implements View.OnClickListener {
        public a() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            SuperLoanDetailActivity superLoanDetailActivity = SuperLoanDetailActivity.this;
            superLoanDetailActivity.Pg(superLoanDetailActivity.f81400o);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            SuperLoanDetailActivity.this.finish();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class c extends EasySubscriber<LoanRepay> {
        public c() {
        }

        /* renamed from: a */
        public void onNext(LoanRepay loanRepay) {
            SuperLoanDetailActivity.this.f81387b.g();
            SuperLoanDetailActivity.this.Qg(loanRepay);
        }

        public void onError2(Throwable th2) {
            SuperLoanDetailActivity.this.f81387b.k();
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            SuperLoanDetailActivity.this.f81387b.k();
        }
    }

    public static Intent fg(Context context, long j11) {
        Intent intent = new Intent(context, SuperLoanDetailActivity.class);
        intent.putExtra("LOAN_ID", j11);
        return intent;
    }

    /* renamed from: Og */
    public SuperLoanDetailPresenter.b getUI() {
        return this;
    }

    public final void Pg(long j11) {
        this.f81387b.p();
        ((SuperLoanDetailPresenter) getPresenter()).Q(j11).compose(RxJavaHelper.t(getUI())).subscribe(new c());
    }

    public void Qg(LoanRepay loanRepay) {
        String z11 = k.C().z(loanRepay.getCurrency());
        this.f81388c.setText(String.format(Locale.US, getString(R.string.loan_currency), new Object[]{z11}));
        this.f81389d.setText(String.format("%s %s", new Object[]{m.m(loanRepay.getLoanAmount(), PrecisionUtil.r()), z11}));
        this.f81390e.setText(String.format("%s %s", new Object[]{m.m(loanRepay.getRemainAmount(), PrecisionUtil.r()), z11}));
        this.f81391f.setText(String.format("%s %s", new Object[]{m.m(loanRepay.getInterest(), PrecisionUtil.r()), z11}));
        this.f81392g.setText(String.format("%s %s", new Object[]{m.m(loanRepay.getInterestAmount(), PrecisionUtil.r()), z11}));
        this.f81393h.setText(DateTimeUtils.g(loanRepay.getLoanTime()));
        this.f81394i.setText(getString(R.string.currency_amount_label, new Object[]{z11}));
        this.f81395j.setText(String.format("%s %s", new Object[]{m.m(loanRepay.getCurrencyAmount(), PrecisionUtil.r()), z11}));
        this.f81396k.setText(String.format("%s PTS", new Object[]{m.m(loanRepay.getPointAmount(), PrecisionUtil.m())}));
        BigDecimal bigDecimal = BigDecimal.ZERO;
        try {
            bigDecimal = new BigDecimal(loanRepay.getHtxAmount());
        } catch (Throwable unused) {
        }
        boolean z12 = bigDecimal.compareTo(BigDecimal.ZERO) == 1;
        if (z12) {
            this.f81398m.setVisibility(0);
            this.f81398m.setText(String.format("%s HTX", new Object[]{m.q(bigDecimal, PrecisionUtil.m())}));
        } else {
            this.f81398m.setVisibility(8);
        }
        BigDecimal bigDecimal2 = BigDecimal.ZERO;
        try {
            bigDecimal2 = new BigDecimal(loanRepay.getTrxAmount());
        } catch (Throwable unused2) {
        }
        boolean z13 = bigDecimal2.compareTo(BigDecimal.ZERO) == 1;
        if (z13) {
            this.f81399n.setVisibility(0);
            this.f81399n.setText(String.format("%s TRX", new Object[]{m.q(bigDecimal2, PrecisionUtil.m())}));
        } else {
            this.f81399n.setVisibility(8);
        }
        BigDecimal bigDecimal3 = BigDecimal.ZERO;
        try {
            bigDecimal3 = new BigDecimal(loanRepay.getHtAmount());
        } catch (Throwable unused3) {
        }
        boolean z14 = bigDecimal3.compareTo(BigDecimal.ZERO) == 1;
        if (z14) {
            this.f81397l.setVisibility(0);
            this.f81397l.setText(String.format("%s HT", new Object[]{m.q(bigDecimal3, PrecisionUtil.m())}));
        } else {
            this.f81397l.setVisibility(8);
        }
        if (!z14 && !z12 && !z13) {
            this.f81397l.setVisibility(0);
            this.f81397l.setText("0.00000");
        }
    }

    public void addEvent() {
        this.f81387b.setOnRetryClickListener(new a());
        this.viewFinder.b(R.id.iv_back).setOnClickListener(new b());
    }

    public boolean canFullScreen() {
        return false;
    }

    public int getContentView() {
        return R.layout.activity_super_loan_detail;
    }

    /* renamed from: gg */
    public SuperLoanDetailPresenter createPresenter() {
        return new SuperLoanDetailPresenter();
    }

    public void initView() {
        this.f81387b = (LoadingLayout) this.viewFinder.b(R.id.loading_layout);
        this.f81388c = (TextView) this.viewFinder.b(R.id.tv_currency);
        this.f81389d = (TextView) this.viewFinder.b(R.id.tv_loan_amount);
        this.f81390e = (TextView) this.viewFinder.b(R.id.tv_remain_amount);
        this.f81391f = (TextView) this.viewFinder.b(R.id.tv_interest);
        this.f81392g = (TextView) this.viewFinder.b(R.id.tv_interest_amount);
        this.f81393h = (TextView) this.viewFinder.b(R.id.tv_loan_time);
        this.f81394i = (TextView) this.viewFinder.b(R.id.tv_currency_amount_label);
        this.f81395j = (TextView) this.viewFinder.b(R.id.tv_currency_amount);
        this.f81396k = (TextView) this.viewFinder.b(R.id.tv_point_amount);
        this.f81397l = (TextView) this.viewFinder.b(R.id.tv_ht_amount);
        this.f81398m = (TextView) this.viewFinder.b(R.id.tv_htx_amount);
        this.f81399n = (TextView) this.viewFinder.b(R.id.tv_trx_amount);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        long longExtra = getIntent().getLongExtra("LOAN_ID", 0);
        this.f81400o = longExtra;
        Pg(longExtra);
    }
}
