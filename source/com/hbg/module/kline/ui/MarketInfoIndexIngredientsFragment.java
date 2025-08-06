package com.hbg.module.kline.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.hbg.lib.core.ui.BaseFragment;
import com.hbg.lib.core.util.CollectionsUtils;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.hbg.module.kline.R$id;
import com.hbg.module.kline.R$layout;
import com.hbg.module.kline.bean.IndexIngredient;
import com.hbg.module.kline.presenter.MarketInfoIndexIngredientsPresenter;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.ArrayList;
import java.util.List;
import vd.c;

public class MarketInfoIndexIngredientsFragment extends BaseFragment<MarketInfoIndexIngredientsPresenter, MarketInfoIndexIngredientsPresenter.a> implements MarketInfoIndexIngredientsPresenter.a {

    /* renamed from: l  reason: collision with root package name */
    public EasyRecyclerView f24096l;

    /* renamed from: m  reason: collision with root package name */
    public LoadingLayout f24097m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f24098n = false;

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        if (getActivity() instanceof c) {
            ((c) getActivity()).mg();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void Ah() {
        super.Ah();
        this.f24097m.setOnRetryClickListener(new f4(this));
    }

    /* renamed from: Dh */
    public MarketInfoIndexIngredientsPresenter xh() {
        return new MarketInfoIndexIngredientsPresenter();
    }

    /* renamed from: Eh */
    public MarketInfoIndexIngredientsPresenter.a zh() {
        return this;
    }

    public void Fh(List<IndexIngredient> list) {
        this.f24098n = !CollectionsUtils.b(list);
        this.f24097m.g();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        this.f24096l.setData(arrayList);
    }

    public void Gh() {
        if (!this.f24098n) {
            this.f24097m.k();
        }
    }

    public void initViews() {
        super.initViews();
        EasyRecyclerView easyRecyclerView = (EasyRecyclerView) this.f67460i.b(R$id.recycler_view);
        this.f24096l = easyRecyclerView;
        easyRecyclerView.setNestedScrollingEnabled(false);
        this.f24097m = (LoadingLayout) this.f67460i.b(R$id.loading_layout);
    }

    public View ph(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R$layout.fragment_market_info_index_ingredients, viewGroup, false);
    }
}
