package com.huobi.asset.feature.account.mortgage.subtype;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.core.ui.EmptyMVPFragment;
import com.hbg.lib.network.hbg.core.bean.PledgeBalance;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.hbg.lib.widgets.adapter.recyclerview.StableLinearLayoutManager;
import com.hbg.module.asset.R$color;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.hbg.module.asset.R$string;
import com.huobi.asset.feature.account.mortgage.impl.MortgageType;
import com.huobi.asset.widget.LoadingViewData;
import com.huobi.finance.bean.AssetMortgageItemInfo;
import com.huobi.view.rv.VerticalDividerItemDecoration;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.k;
import java.util.ArrayList;
import java.util.List;
import s9.a;

public class AssetMortgageBorrowedSubFragment extends EmptyMVPFragment {

    /* renamed from: l  reason: collision with root package name */
    public LoadingViewData f42282l;

    /* renamed from: m  reason: collision with root package name */
    public EasyRecyclerView<a> f42283m;

    /* renamed from: n  reason: collision with root package name */
    public lh.a f42284n;

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Fh(View view) {
        if (this.f42284n != null) {
            this.f42282l.g(1);
            Hh();
            this.f42284n.callback();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void Gh(List<PledgeBalance.CurrencyBalance> list, int i11) {
        ArrayList arrayList = new ArrayList();
        boolean z11 = list == null || list.isEmpty();
        LoadingViewData loadingViewData = this.f42282l;
        if (loadingViewData == null || this.f42283m == null) {
            k.c("l = :" + this.f42282l + " r = : " + this.f42283m);
            return;
        }
        if (!z11) {
            for (PledgeBalance.CurrencyBalance assetMortgageItemInfo : list) {
                arrayList.add(new AssetMortgageItemInfo(assetMortgageItemInfo, getString(R$string.n_asset_mortgage_borrowed_number), MortgageType.borrow));
            }
        } else if (i11 == 2) {
            loadingViewData.g(2);
            arrayList.add(this.f42282l);
        } else {
            loadingViewData.g(3);
            arrayList.add(this.f42282l);
        }
        this.f42283m.setData(arrayList);
    }

    public void Hh() {
        this.f42283m.c();
    }

    public void Ih(lh.a aVar) {
        this.f42284n = aVar;
    }

    public void initViews() {
        super.initViews();
        EasyRecyclerView<a> easyRecyclerView = (EasyRecyclerView) this.f67460i.b(R$id.borrow_recyclerview);
        this.f42283m = easyRecyclerView;
        easyRecyclerView.setLayoutManager(new StableLinearLayoutManager(getActivity()));
        this.f42283m.addItemDecoration(new VerticalDividerItemDecoration(ContextCompat.getDrawable(getActivity(), R$color.baseColorPrimarySeparator), PixelUtils.a(0.5f), false, false));
        this.f42282l = new LoadingViewData(new mh.a(this));
    }

    public View ph(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return LayoutInflater.from(getContext()).inflate(R$layout.fragment_asset_mortgage_borrowed_subtype, viewGroup, false);
    }
}
