package com.hbg.lite.record.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.core.ui.BaseFragment;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.lite.R$drawable;
import com.hbg.lite.R$id;
import com.hbg.lite.R$layout;
import com.hbg.lite.record.presenter.OtcCoinRecordPresenter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import jb.x;
import ub.a;

public class OtcCoinRecordFragment extends BaseFragment<OtcCoinRecordPresenter, OtcCoinRecordPresenter.b> implements OtcCoinRecordPresenter.b {

    /* renamed from: l  reason: collision with root package name */
    public SmartRefreshLayout f77414l;

    /* renamed from: m  reason: collision with root package name */
    public LoadingLayout f77415m;

    /* renamed from: n  reason: collision with root package name */
    public RecyclerView f77416n;

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        ((OtcCoinRecordPresenter) yh()).k0();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void Ah() {
        super.Ah();
        this.f77415m.setOnRetryClickListener(new x(this));
    }

    /* renamed from: Dh */
    public OtcCoinRecordPresenter xh() {
        return new OtcCoinRecordPresenter();
    }

    /* renamed from: Eh */
    public OtcCoinRecordPresenter.b zh() {
        return this;
    }

    public RecyclerView Y0() {
        return this.f77416n;
    }

    public LoadingLayout f6() {
        return this.f77415m;
    }

    public void initViews() {
        super.initViews();
        this.f77414l = (SmartRefreshLayout) this.f67460i.b(R$id.single_currency_record_refresh);
        this.f77415m = (LoadingLayout) this.f67460i.b(R$id.single_currency_loading_layout);
        RecyclerView recyclerView = (RecyclerView) this.f67460i.b(R$id.single_currency_rv);
        this.f77416n = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.f77416n.addItemDecoration(new a(getActivity(), R$drawable.shape_item_divider_bg, PixelUtils.a(0.5f)));
    }

    public View ph(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R$layout.fragment_lite_order_record, viewGroup, false);
    }

    public SmartRefreshLayout t2() {
        return this.f77414l;
    }
}
