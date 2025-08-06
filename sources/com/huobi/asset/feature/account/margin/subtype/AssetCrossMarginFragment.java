package com.huobi.asset.feature.account.margin.subtype;

import com.huobi.asset.feature.base.AssetSubTypeBaseFragment;
import com.huobi.asset.feature.base.AssetSubTypesContainerFragment;
import com.huobi.asset.widget.AssetHeadView;
import com.huobi.finance.bean.BaseAssetTotal;
import com.huobi.finance.model.AssetDataCacheManager;
import com.huobi.finance.viewhandler.AssetCrossMarginHeaderViewHandler;
import rx.Observable;

public class AssetCrossMarginFragment extends AssetSubTypeBaseFragment {

    public static class HeadViewData extends AssetHeadView.AssetHeadData {
        public String getViewHandlerName() {
            return AssetCrossMarginHeaderViewHandler.class.getName();
        }
    }

    public AssetCrossMarginFragment(AssetSubTypesContainerFragment assetSubTypesContainerFragment) {
        super(assetSubTypesContainerFragment);
    }

    public Observable<? extends BaseAssetTotal> Kh() {
        return AssetDataCacheManager.k0().J0();
    }

    public AssetHeadView.AssetHeadData Lh() {
        return new HeadViewData();
    }

    public String Mh() {
        return "app_assets_margin_cross_view";
    }
}
