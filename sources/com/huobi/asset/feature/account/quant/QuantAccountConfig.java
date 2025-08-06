package com.huobi.asset.feature.account.quant;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.hbg.module.asset.R$string;
import com.huobi.asset.AssetAccountType;
import com.huobi.finance.bean.GridDataTotal;
import com.huobi.finance.model.AssetDataCacheManager;
import com.youth.banner.config.BannerConfig;
import hh.f;
import rx.Observable;

public class QuantAccountConfig implements f.a<GridDataTotal> {
    public Fragment a() {
        return new AssetQuantFragment();
    }

    public Observable<GridDataTotal> b() {
        return AssetDataCacheManager.k0().j0();
    }

    public String c(Context context) {
        return context.getResources().getString(R$string.n_quantization_account).replace("账户", "");
    }

    public AssetAccountType d() {
        return AssetAccountType.QUANT;
    }

    public int getPriority() {
        return BannerConfig.SCROLL_TIME;
    }
}
