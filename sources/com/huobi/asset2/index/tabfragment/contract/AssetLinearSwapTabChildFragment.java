package com.huobi.asset2.index.tabfragment.contract;

import com.alibaba.fastjson.JSONObject;
import com.hbg.lib.core.BaseModuleConfig;
import com.huobi.asset2.index.BaseAssetChildTabFragment;
import com.huobi.asset2.index.BaseAssetThirdTabFragment;
import hk.a;
import java.util.ArrayList;
import java.util.HashMap;

public class AssetLinearSwapTabChildFragment extends BaseAssetThirdTabFragment {
    public void initViews() {
        super.initViews();
        a aVar = this.f42600g;
        if (aVar != null && aVar.a() != null) {
            this.f42597d.addView(this.f42600g.a().E("asset_tab_linear_header_layout_new.xml", getContext(), false, (JSONObject) null));
        }
    }

    public void onResume() {
        super.onResume();
        a aVar = this.f42600g;
        if (!(aVar == null || aVar.a() == null)) {
            this.f42600g.a().I("assetTabEvent('4')");
        }
        BaseModuleConfig.a().w("app_assets_futures_usdtm_exposure", (HashMap) null);
    }

    public ArrayList<BaseAssetChildTabFragment> qh() {
        ArrayList<BaseAssetChildTabFragment> arrayList = new ArrayList<>();
        AssetLinearSwapAllTabChildFragment assetLinearSwapAllTabChildFragment = new AssetLinearSwapAllTabChildFragment();
        AssetLinearSwapOwnTabChildFragment assetLinearSwapOwnTabChildFragment = new AssetLinearSwapOwnTabChildFragment();
        assetLinearSwapAllTabChildFragment.Sh(this.f42600g);
        assetLinearSwapOwnTabChildFragment.Sh(this.f42600g);
        arrayList.add(assetLinearSwapAllTabChildFragment);
        arrayList.add(assetLinearSwapOwnTabChildFragment);
        return arrayList;
    }
}
