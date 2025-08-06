package com.huobi.supermargin.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.LoadingLayout;
import com.huobi.supermargin.bean.LoanCurrency;
import com.huobi.supermargin.presenter.SuperLoanChooseCoinPresenter;
import com.huobi.view.rv.CommonVerticalDividerItemDecoration;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.ArrayList;
import java.util.List;
import ms.h;
import pro.huobi.R;

public class SuperLoanChooseCoinActivity extends BaseActivity<SuperLoanChooseCoinPresenter, SuperLoanChooseCoinPresenter.b> implements SuperLoanChooseCoinPresenter.b {

    /* renamed from: b  reason: collision with root package name */
    public LoadingLayout f81383b;

    /* renamed from: c  reason: collision with root package name */
    public RecyclerView f81384c;

    /* renamed from: d  reason: collision with root package name */
    public v9.a<LoanCurrency> f81385d = new v9.a<>(new ArrayList());

    public class a extends EasySubscriber<List<LoanCurrency>> {
        public a() {
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            SuperLoanChooseCoinActivity.this.f81383b.k();
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            SuperLoanChooseCoinActivity.this.f81383b.k();
        }

        public void onStart() {
            super.onStart();
            SuperLoanChooseCoinActivity.this.f81383b.p();
        }

        public void onNext(List<LoanCurrency> list) {
            super.onNext(list);
            SuperLoanChooseCoinActivity.this.f81383b.g();
            SuperLoanChooseCoinActivity.this.f81385d.i(list);
            SuperLoanChooseCoinActivity.this.f81385d.notifyDataSetChanged();
        }
    }

    public static Intent fg(Context context) {
        return new Intent(context, SuperLoanChooseCoinActivity.class);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        Pg();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: Og */
    public SuperLoanChooseCoinPresenter.b getUI() {
        return this;
    }

    public void Pg() {
        ((SuperLoanChooseCoinPresenter) getPresenter()).Q(true).subscribe(new a());
    }

    public void addEvent() {
        this.f81383b.setOnRetryClickListener(new h(this));
    }

    public int getContentView() {
        return R.layout.activity_loan_choose_coin;
    }

    /* renamed from: gg */
    public SuperLoanChooseCoinPresenter createPresenter() {
        return new SuperLoanChooseCoinPresenter();
    }

    public void initView() {
        setToolBar((Toolbar) findViewById(R.id.toolbar), getResources().getString(R.string.choose_currency), true);
        this.f81383b = (LoadingLayout) findViewById(R.id.loading_layout);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        this.f81384c = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.f81384c.addItemDecoration(new CommonVerticalDividerItemDecoration(ContextCompat.getDrawable(this, R.drawable.divider_secondary_with_left_margin), ContextCompat.getDrawable(this, R.drawable.divider_secondary_with_left_margin), PixelUtils.a(0.5f), PixelUtils.a(0.5f), true));
        this.f81384c.setAdapter(this.f81385d);
    }

    public void onResume() {
        super.onResume();
        Pg();
    }
}
