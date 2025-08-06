package com.huobi.asset2.index.tabfragment.spot;

import android.view.View;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.module.asset.AssetModuleConfig;
import com.hbg.module.asset.R$string;
import com.huobi.asset2.index.BaseAssetChildTabFragment;
import com.huobi.asset2.index.BaseAssetTabFragment;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AssetSpotTabFragment extends BaseAssetTabFragment {
    public ArrayList<BaseAssetChildTabFragment> sh() {
        ArrayList<BaseAssetChildTabFragment> arrayList = new ArrayList<>();
        AssetSpotTabChildFragment assetSpotTabChildFragment = new AssetSpotTabChildFragment();
        AssetCollateralTabChildFragment assetCollateralTabChildFragment = new AssetCollateralTabChildFragment();
        assetSpotTabChildFragment.Sh(this.f42587e);
        assetCollateralTabChildFragment.Sh(this.f42587e);
        arrayList.add(assetSpotTabChildFragment);
        arrayList.add(assetCollateralTabChildFragment);
        return arrayList;
    }

    public List<String> th() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(getString(R$string.n_spot));
        arrayList.add(getString(R$string.n_asset_mortgage));
        return arrayList;
    }

    public void uh(View view) {
        int i11 = this.f42591i;
        if (i11 == 0) {
            AssetModuleConfig.a().i1(view.getContext());
            BaseModuleConfig.a().w("app_assets_spot_record_click", (HashMap) null);
        } else if (i11 == 1) {
            this.f42587e.a().I("goToCollateralHistory()");
            BaseModuleConfig.a().w("app_assets_collateral_record_click", (HashMap) null);
        }
    }

    public int vh() {
        return 0;
    }

    public void zh(int i11) {
        if (i11 == 0) {
            this.f42589g.setVisibility(0);
        } else if (i11 == 1) {
            this.f42589g.setVisibility(0);
        } else {
            this.f42589g.setVisibility(8);
        }
    }
}
