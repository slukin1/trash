package vk;

import com.huobi.asset.AssetAccountType;
import com.huobi.finance.bean.BaseAssetPositionAccountData;
import com.huobi.finance.viewhandler.AssetPositionLoadingItemViewHandler;

public class f extends BaseAssetPositionAccountData {

    /* renamed from: b  reason: collision with root package name */
    public AssetAccountType f47985b;

    public f(AssetAccountType assetAccountType) {
        this.f47985b = assetAccountType;
    }

    public AssetAccountType a() {
        return this.f47985b;
    }

    public void c(int i11, boolean z11) {
    }

    public String getViewHandlerName() {
        return AssetPositionLoadingItemViewHandler.class.getName();
    }
}
