package com.huobi.asset.feature.account.future.subtype;

import com.huobi.asset.feature.account.future.AssetFutureBaseFragment;
import com.huobi.asset.feature.base.AssetSubTypesContainerFragment;
import com.huobi.asset.widget.AssetHeadView;
import com.huobi.finance.bean.BaseAssetTotal;
import com.huobi.finance.model.AssetDataCacheManager;
import com.huobi.finance.viewhandler.AssetSwapFutureHeaderViewHandler;
import rx.Observable;

public class AssetSwapFutureFragment extends AssetFutureBaseFragment {

    public static class HeadViewData extends AssetHeadView.AssetHeadData {
        public String getViewHandlerName() {
            return AssetSwapFutureHeaderViewHandler.class.getName();
        }
    }

    public AssetSwapFutureFragment(AssetSubTypesContainerFragment assetSubTypesContainerFragment) {
        super(assetSubTypesContainerFragment);
    }

    public String Mh() {
        return "app_assets_derivatives_coin_M_swaps_view";
    }

    public int Zh() {
        return 6;
    }

    public Observable<? extends BaseAssetTotal> ai() {
        return AssetDataCacheManager.k0().y0();
    }

    /* renamed from: di */
    public HeadViewData Lh() {
        return new HeadViewData();
    }
}
