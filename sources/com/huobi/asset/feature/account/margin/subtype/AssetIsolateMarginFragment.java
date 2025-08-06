package com.huobi.asset.feature.account.margin.subtype;

import com.huobi.asset.feature.base.AssetSubTypeBaseFragment;
import com.huobi.asset.feature.base.AssetSubTypesContainerFragment;
import com.huobi.asset.widget.AssetHeadView;
import com.huobi.finance.bean.BaseAssetTotal;
import com.huobi.finance.model.AssetDataCacheManager;
import com.huobi.finance.viewhandler.AssetIsolateMarginHeaderViewHandler;
import rx.Observable;

public class AssetIsolateMarginFragment extends AssetSubTypeBaseFragment {

    public static class HeadViewData extends AssetHeadView.AssetHeadData {
        public String getViewHandlerName() {
            return AssetIsolateMarginHeaderViewHandler.class.getName();
        }
    }

    public AssetIsolateMarginFragment(AssetSubTypesContainerFragment assetSubTypesContainerFragment) {
        super(assetSubTypesContainerFragment);
    }

    public Observable<? extends BaseAssetTotal> Kh() {
        return AssetDataCacheManager.k0().n0();
    }

    public String Mh() {
        return "app_assets_margin_isolate_view";
    }

    /* renamed from: Xh */
    public HeadViewData Lh() {
        return new HeadViewData();
    }
}
