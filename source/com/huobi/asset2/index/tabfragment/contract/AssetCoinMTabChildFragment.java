package com.huobi.asset2.index.tabfragment.contract;

import com.alibaba.fastjson.JSONObject;
import com.hbg.lib.core.BaseModuleConfig;
import com.huobi.asset2.index.BaseAssetChildTabFragment;
import com.huobi.asset2.index.BaseAssetThirdTabFragment;
import hk.a;
import java.util.ArrayList;
import java.util.HashMap;

public class AssetCoinMTabChildFragment extends BaseAssetThirdTabFragment {
    public void initViews() {
        super.initViews();
        a aVar = this.f42600g;
        if (aVar != null && aVar.a() != null) {
            this.f42597d.addView(this.f42600g.a().E("asset_tab_coin_m_header_layout_new.xml", getContext(), false, (JSONObject) null));
        }
    }

    public void onResume() {
        super.onResume();
        a aVar = this.f42600g;
        if (!(aVar == null || aVar.a() == null)) {
            this.f42600g.a().I("assetTabEvent('11')");
        }
        BaseModuleConfig.a().w("app_assets_futures_coinf_exposure", (HashMap) null);
    }

    public ArrayList<BaseAssetChildTabFragment> qh() {
        ArrayList<BaseAssetChildTabFragment> arrayList = new ArrayList<>();
        AssetCoinMAllTabChildFragment assetCoinMAllTabChildFragment = new AssetCoinMAllTabChildFragment();
        AssetCoinMOwnTabChildFragment assetCoinMOwnTabChildFragment = new AssetCoinMOwnTabChildFragment();
        assetCoinMAllTabChildFragment.Sh(this.f42600g);
        assetCoinMOwnTabChildFragment.Sh(this.f42600g);
        arrayList.add(assetCoinMAllTabChildFragment);
        arrayList.add(assetCoinMOwnTabChildFragment);
        return arrayList;
    }
}
