package com.huobi.asset.feature.account.pool;

import com.huobi.asset.AssetAccountType;
import com.huobi.asset.feature.base.BaseAssetListFragment;
import com.huobi.asset.widget.AssetHeadView;
import com.huobi.finance.bean.BaseAssetTotal;
import com.huobi.finance.viewhandler.AssetPoolHeaderViewHandler;
import hh.f;
import rx.Observable;

public class AssetPoolFragment extends BaseAssetListFragment {

    public static class HeadViewData extends AssetHeadView.AssetHeadData {
        public String getViewHandlerName() {
            return AssetPoolHeaderViewHandler.class.getName();
        }
    }

    public String Gh() {
        return "app_assets_pool_view";
    }

    public Observable<? extends BaseAssetTotal> Rh() {
        f.a<?> g11 = f.h().g(AssetAccountType.POOL);
        if (g11 == null) {
            return Observable.empty();
        }
        return g11.b();
    }

    public AssetHeadView.AssetHeadData Sh() {
        return new HeadViewData();
    }

    public boolean Vh() {
        return false;
    }
}
