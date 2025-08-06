package com.huobi.asset.feature.account.margin;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.hbg.module.asset.R$string;
import com.huobi.asset.AssetAccountType;
import com.huobi.finance.bean.BaseAssetTotal;
import hh.f;
import rx.Observable;

public class MarginAccountConfig implements f.a<BaseAssetTotal> {
    public Fragment a() {
        return new AssetMarginContainerFragment();
    }

    public Observable<BaseAssetTotal> b() {
        return null;
    }

    public String c(Context context) {
        return context.getResources().getString(R$string.margin_toolbar_header_title);
    }

    public AssetAccountType d() {
        return AssetAccountType.MARGIN;
    }

    public int getPriority() {
        return 300;
    }
}
