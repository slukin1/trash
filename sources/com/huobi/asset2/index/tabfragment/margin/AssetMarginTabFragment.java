package com.huobi.asset2.index.tabfragment.margin;

import android.view.View;
import com.hbg.module.asset.AssetModuleConfig;
import com.hbg.module.asset.R$string;
import com.huobi.asset2.index.BaseAssetChildTabFragment;
import com.huobi.asset2.index.BaseAssetTabFragment;
import java.util.ArrayList;
import java.util.List;

public class AssetMarginTabFragment extends BaseAssetTabFragment {
    public ArrayList<BaseAssetChildTabFragment> sh() {
        ArrayList<BaseAssetChildTabFragment> arrayList = new ArrayList<>();
        AssetMarginAllChildFragment assetMarginAllChildFragment = new AssetMarginAllChildFragment();
        AssetMarginPartChildFragment assetMarginPartChildFragment = new AssetMarginPartChildFragment();
        assetMarginPartChildFragment.Sh(this.f42587e);
        assetMarginAllChildFragment.Sh(this.f42587e);
        arrayList.add(assetMarginAllChildFragment);
        arrayList.add(assetMarginPartChildFragment);
        return arrayList;
    }

    public List<String> th() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(getString(R$string.n_trade_cross_margin));
        arrayList.add(getString(R$string.n_trade_isolated_margin));
        return arrayList;
    }

    public void uh(View view) {
        if (this.f42591i == 0) {
            AssetModuleConfig.a().b1(view.getContext());
        } else {
            AssetModuleConfig.a().x0(view.getContext());
        }
    }

    public int vh() {
        return 0;
    }

    public void zh(int i11) {
    }
}
