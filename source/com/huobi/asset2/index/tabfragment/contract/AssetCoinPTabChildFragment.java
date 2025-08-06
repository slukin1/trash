package com.huobi.asset2.index.tabfragment.contract;

import com.alibaba.fastjson.JSONObject;
import com.hbg.lib.core.BaseModuleConfig;
import com.huobi.asset2.index.BaseAssetChildTabFragment;
import com.huobi.asset2.index.BaseAssetThirdTabFragment;
import hk.a;
import java.util.ArrayList;
import java.util.HashMap;

public class AssetCoinPTabChildFragment extends BaseAssetThirdTabFragment {
    public void initViews() {
        super.initViews();
        a aVar = this.f42600g;
        if (aVar != null && aVar.a() != null) {
            this.f42597d.addView(this.f42600g.a().E("asset_tab_coin_p_header_layout_new.xml", getContext(), false, (JSONObject) null));
        }
    }

    public void onResume() {
        super.onResume();
        a aVar = this.f42600g;
        if (!(aVar == null || aVar.a() == null)) {
            this.f42600g.a().I("assetTabEvent('7')");
        }
        BaseModuleConfig.a().w("app_assets_futures_coinp_exposure", (HashMap) null);
    }

    public ArrayList<BaseAssetChildTabFragment> qh() {
        ArrayList<BaseAssetChildTabFragment> arrayList = new ArrayList<>();
        AssetCoinPAllTabChildFragment assetCoinPAllTabChildFragment = new AssetCoinPAllTabChildFragment();
        AssetCoinPOwnTabChildFragment assetCoinPOwnTabChildFragment = new AssetCoinPOwnTabChildFragment();
        assetCoinPAllTabChildFragment.Sh(this.f42600g);
        assetCoinPOwnTabChildFragment.Sh(this.f42600g);
        arrayList.add(assetCoinPAllTabChildFragment);
        arrayList.add(assetCoinPOwnTabChildFragment);
        return arrayList;
    }
}
