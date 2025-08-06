package com.huobi.assetrecord;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import bj.o0;
import com.hbg.lib.core.page.SmartRefreshHeader;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.huobi.asset.widget.LoadingViewData;
import com.huobi.assetrecord.presenter.AppleOrderHistoryRecordListPresenter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import ii.k;
import ii.l;
import java.util.ArrayList;
import java.util.List;
import ky.j;
import ny.d;
import pro.huobi.R;

public class AppleOrderHistoryRecordListActivity extends BaseActivity<AppleOrderHistoryRecordListPresenter, AppleOrderHistoryRecordListPresenter.a> implements AppleOrderHistoryRecordListPresenter.a {

    /* renamed from: b  reason: collision with root package name */
    public EasyRecyclerView<s9.a> f42803b;

    /* renamed from: c  reason: collision with root package name */
    public SmartRefreshLayout f42804c;

    /* renamed from: d  reason: collision with root package name */
    public LoadingViewData f42805d;

    /* renamed from: e  reason: collision with root package name */
    public View f42806e;

    public class a implements d {
        public a() {
        }

        public void P8(j jVar) {
        }

        public void bf(j jVar) {
            ((AppleOrderHistoryRecordListPresenter) AppleOrderHistoryRecordListActivity.this.getPresenter()).Y();
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Og(View view) {
        finish();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static void Qg(Context context, boolean z11) {
        Intent intent = new Intent(context, AppleOrderHistoryRecordListActivity.class);
        intent.putExtra("isShowSucceedDialog", z11);
        context.startActivity(intent);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$initView$0(View view) {
        this.f42805d.g(1);
        ((AppleOrderHistoryRecordListPresenter) getPresenter()).Y();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void Pg() {
        if (getIntent().getBooleanExtra("isShowSucceedDialog", false)) {
            DialogUtils.X(this, getString(R.string.n_all_cancel_title), getString(R.string.n_asset_apply_record_submit_succeed_tips), (String) null, getString(R.string.n_known), o0.f12469a);
        }
    }

    public void Ug(int i11) {
        this.f42805d.g(i11);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f42805d);
        this.f42803b.setData(arrayList);
        finishRefresh();
    }

    public void addEvent() {
        this.f42806e.setOnClickListener(new k(this));
        this.f42804c.e0(new a());
    }

    /* renamed from: fg */
    public AppleOrderHistoryRecordListPresenter createPresenter() {
        return new AppleOrderHistoryRecordListPresenter();
    }

    public void finishRefresh() {
        SmartRefreshLayout smartRefreshLayout = this.f42804c;
        if (smartRefreshLayout != null) {
            smartRefreshLayout.finishRefresh();
        }
    }

    public int getContentView() {
        return R.layout.activity_apple_order_record_list;
    }

    /* renamed from: gg */
    public AppleOrderHistoryRecordListPresenter.a getUI() {
        return this;
    }

    public void initView() {
        this.f42803b = (EasyRecyclerView) this.viewFinder.b(R.id.apple_record_list);
        this.f42806e = this.viewFinder.b(R.id.apple_order_record_back);
        this.f42804c = (SmartRefreshLayout) this.viewFinder.b(R.id.apple_refresh_layout);
        this.f42805d = new LoadingViewData(new l(this));
        this.f42804c.j0(new SmartRefreshHeader(this));
        this.f42804c.g(false);
        Pg();
    }

    public void u5(List<s9.a> list) {
        this.f42803b.setData(list);
    }
}
