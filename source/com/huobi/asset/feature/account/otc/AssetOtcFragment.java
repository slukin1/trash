package com.huobi.asset.feature.account.otc;

import com.huobi.asset.AssetAccountType;
import com.huobi.asset.feature.base.BaseAssetListFragment;
import com.huobi.asset.widget.AssetHeadView;
import com.huobi.finance.bean.BaseAssetTotal;
import com.huobi.finance.viewhandler.AssetOtcHeaderViewHandler;
import hh.f;
import qh.p0;
import rx.Observable;

public class AssetOtcFragment extends BaseAssetListFragment {

    public static class HeadViewData extends AssetHeadView.AssetHeadData {
        public String getViewHandlerName() {
            return AssetOtcHeaderViewHandler.class.getName();
        }
    }

    public String Gh() {
        return "app_assets_fiat_view";
    }

    public void Jh() {
        super.Jh();
        if (Vh()) {
            p0.n().i();
        }
    }

    public Observable<? extends BaseAssetTotal> Rh() {
        f.a<?> g11 = f.h().g(AssetAccountType.OTC);
        if (g11 == null) {
            return Observable.empty();
        }
        return g11.b();
    }

    public AssetHeadView.AssetHeadData Sh() {
        return new HeadViewData();
    }

    public boolean Vh() {
        return p0.n().p();
    }
}
