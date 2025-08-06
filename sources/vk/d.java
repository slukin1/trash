package vk;

import com.huobi.asset.AssetAccountType;
import com.huobi.finance.bean.BaseAssetPositionAccountData;
import com.huobi.finance.viewhandler.AssetPositionHeaderItemViewHandler;

public class d extends BaseAssetPositionAccountData {

    /* renamed from: b  reason: collision with root package name */
    public AssetAccountType f47980b;

    public d(AssetAccountType assetAccountType) {
        this.f47980b = assetAccountType;
    }

    public AssetAccountType a() {
        return this.f47980b;
    }

    public void c(int i11, boolean z11) {
    }

    public String getViewHandlerName() {
        return AssetPositionHeaderItemViewHandler.class.getName();
    }
}
