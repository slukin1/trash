package com.huobi.asset.feature.account.future.subtype;

import com.huobi.asset.feature.account.future.AssetFutureBaseFragment;
import com.huobi.asset.feature.base.AssetSubTypesContainerFragment;
import com.huobi.asset.widget.AssetHeadView;
import com.huobi.finance.bean.BaseAssetTotal;
import com.huobi.finance.model.AssetDataCacheManager;
import com.huobi.finance.viewhandler.AssetDerivativesFutureHeaderViewHandler;
import rx.Observable;

public class AssetDerivativesFutureFragment extends AssetFutureBaseFragment {

    public static class HeadViewData extends AssetHeadView.AssetHeadData {
        public String getViewHandlerName() {
            return AssetDerivativesFutureHeaderViewHandler.class.getName();
        }
    }

    public AssetDerivativesFutureFragment(AssetSubTypesContainerFragment assetSubTypesContainerFragment) {
        super(assetSubTypesContainerFragment);
    }

    public AssetHeadView.AssetHeadData Lh() {
        return new HeadViewData();
    }

    public String Mh() {
        return "app_assets_derivatives_coin_M_futures_view";
    }

    public int Zh() {
        return 3;
    }

    public Observable<? extends BaseAssetTotal> ai() {
        return AssetDataCacheManager.k0().r0();
    }
}
