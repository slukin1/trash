package com.huobi.finance.ui;

import ad.i;
import android.view.View;
import android.widget.TextView;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.core.ui.EmptyMVPActivity;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.hbg.core.bean.UsdtExchangeHistoryBean;
import com.hbg.lib.network.hbg.retrofit.HbgRetrofit;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.huobi.finance.utils.UiFillUtil;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.List;
import pro.huobi.R;
import q6.d;
import u6.g;
import v7.b;
import vk.w;

public class UsdtExchangeHistoryDetailActivity extends EmptyMVPActivity {

    /* renamed from: b  reason: collision with root package name */
    public TextView f46997b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f46998c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f46999d;

    /* renamed from: e  reason: collision with root package name */
    public EasyRecyclerView f47000e;

    /* renamed from: f  reason: collision with root package name */
    public LoadingLayout f47001f;

    /* renamed from: g  reason: collision with root package name */
    public UsdtExchangeHistoryBean f47002g;

    public class a extends d<List<w>> {
        public a(g gVar) {
            super(gVar);
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            UsdtExchangeHistoryDetailActivity.this.f47001f.k();
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            UsdtExchangeHistoryDetailActivity.this.f47001f.k();
        }

        public void onNext(List<w> list) {
            super.onNext(list);
            if (list == null || list.size() == 0) {
                UsdtExchangeHistoryDetailActivity.this.f47001f.i();
                return;
            }
            UsdtExchangeHistoryDetailActivity.this.f47001f.g();
            UsdtExchangeHistoryDetailActivity.this.f47000e.setData(list);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Og(View view) {
        Pg(this.f47002g.getId());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        finish();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void Pg(long j11) {
        b.a().getUsdtExchangeHistoryDetail(j11).b().compose(HbgRetrofit.e()).compose(RxJavaHelper.t(getUI())).flatMap(i.f3526b).map(cc.f47080b).toList().subscribe(new a(getUI()));
    }

    public void addEvent() {
        findViewById(R.id.iv_back).setOnClickListener(new ac(this));
        this.f47001f.setOnRetryClickListener(new bc(this));
    }

    public int getContentView() {
        return R.layout.activity_usdt_exchange_history_detail;
    }

    public final void gg() {
        this.f46997b.setText(String.format("+%s USDT", new Object[]{UiFillUtil.d(this.f47002g.getUsdtVolume())}));
        this.f46998c.setText(DateTimeUtils.f(this.f47002g.getTime()));
        this.f46999d.setText(String.format(getString(R.string.usdt_suffix), new Object[]{UiFillUtil.d(this.f47002g.getUsdtFee())}));
    }

    public void initView() {
        this.f46997b = (TextView) findViewById(R.id.tv_actual_exchange);
        this.f46998c = (TextView) findViewById(R.id.tv_time);
        this.f46999d = (TextView) findViewById(R.id.tv_fee);
        this.f47000e = (EasyRecyclerView) findViewById(R.id.rcv_history);
        this.f47001f = (LoadingLayout) findViewById(R.id.loading_layout);
        this.f47002g = (UsdtExchangeHistoryBean) getIntent().getSerializableExtra("history_id");
        gg();
        Pg(this.f47002g.getId());
    }
}
