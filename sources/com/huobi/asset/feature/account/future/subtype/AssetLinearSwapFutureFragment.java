package com.huobi.asset.feature.account.future.subtype;

import com.huobi.asset.feature.account.future.AssetFutureBaseFragment;
import com.huobi.asset.feature.base.AssetSubTypesContainerFragment;
import com.huobi.asset.widget.AssetHeadView;
import com.huobi.finance.bean.BaseAssetTotal;
import com.huobi.finance.model.AssetDataCacheManager;
import com.huobi.finance.viewhandler.AssetLinearSwapFutureHeaderViewHandler;
import rx.Observable;

public class AssetLinearSwapFutureFragment extends AssetFutureBaseFragment {

    public static class HeadViewData extends AssetHeadView.AssetHeadData {
        public String getViewHandlerName() {
            return AssetLinearSwapFutureHeaderViewHandler.class.getName();
        }
    }

    public AssetLinearSwapFutureFragment(AssetSubTypesContainerFragment assetSubTypesContainerFragment) {
        super(assetSubTypesContainerFragment);
    }

    public AssetHeadView.AssetHeadData Lh() {
        return new HeadViewData();
    }

    public String Mh() {
        return "app_assets_derivatives_usdt_M_swaps_view";
    }

    public int Zh() {
        return 11;
    }

    public Observable<? extends BaseAssetTotal> ai() {
        return AssetDataCacheManager.k0().t0();
    }
}
