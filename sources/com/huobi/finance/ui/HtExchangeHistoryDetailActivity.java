package com.huobi.finance.ui;

import ad.i;
import android.view.View;
import android.widget.TextView;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.core.ui.EmptyMVPActivity;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.hbg.core.bean.HtExchangeHistoryBean;
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
import vk.p;

public class HtExchangeHistoryDetailActivity extends EmptyMVPActivity {

    /* renamed from: b  reason: collision with root package name */
    public TextView f46577b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f46578c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f46579d;

    /* renamed from: e  reason: collision with root package name */
    public EasyRecyclerView f46580e;

    /* renamed from: f  reason: collision with root package name */
    public LoadingLayout f46581f;

    /* renamed from: g  reason: collision with root package name */
    public HtExchangeHistoryBean f46582g;

    public class a extends d<List<p>> {
        public a(g gVar) {
            super(gVar);
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            HtExchangeHistoryDetailActivity.this.f46581f.k();
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            HtExchangeHistoryDetailActivity.this.f46581f.k();
        }

        public void onNext(List<p> list) {
            super.onNext(list);
            if (list == null || list.size() == 0) {
                HtExchangeHistoryDetailActivity.this.f46581f.i();
                return;
            }
            for (p next : list) {
                if (HtExchangeHistoryDetailActivity.this.f46582g.getCurrency() == null || HtExchangeHistoryDetailActivity.this.f46582g.getCurrency().isEmpty()) {
                    next.c().setUnit("HT");
                } else {
                    next.c().setUnit(HtExchangeHistoryDetailActivity.this.f46582g.getCurrency());
                }
            }
            HtExchangeHistoryDetailActivity.this.f46581f.g();
            HtExchangeHistoryDetailActivity.this.f46580e.setData(list);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Pg(View view) {
        Qg(this.f46582g.getId());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        finish();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void Og() {
        this.f46577b.setText(String.format("+%s %s", new Object[]{UiFillUtil.c(this.f46582g.getHtVolume()), this.f46582g.getCurrency()}));
        this.f46578c.setText(DateTimeUtils.f(this.f46582g.getTime()));
        this.f46579d.setText(String.format("%s %s", new Object[]{UiFillUtil.c(this.f46582g.getHtFee()), this.f46582g.getCurrency()}));
    }

    public final void Qg(long j11) {
        b.a().getHtExchangeHistoryDetail(j11).b().compose(HbgRetrofit.e()).compose(RxJavaHelper.t(getUI())).flatMap(i.f3526b).map(b6.f47057b).toList().subscribe(new a(getUI()));
    }

    public void addEvent() {
        findViewById(R.id.iv_back).setOnClickListener(new a6(this));
        this.f46581f.setOnRetryClickListener(new z5(this));
    }

    public int getContentView() {
        return R.layout.activity_ht_exchange_history_detail;
    }

    public void initView() {
        this.f46577b = (TextView) findViewById(R.id.tv_actual_exchange);
        this.f46578c = (TextView) findViewById(R.id.tv_time);
        this.f46579d = (TextView) findViewById(R.id.tv_fee);
        this.f46580e = (EasyRecyclerView) findViewById(R.id.rcv_history);
        this.f46581f = (LoadingLayout) findViewById(R.id.loading_layout);
        this.f46582g = (HtExchangeHistoryBean) getIntent().getSerializableExtra("history_id");
        Og();
        Qg(this.f46582g.getId());
    }
}
