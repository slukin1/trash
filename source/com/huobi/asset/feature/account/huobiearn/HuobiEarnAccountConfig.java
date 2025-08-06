package com.huobi.asset.feature.account.huobiearn;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.hbg.module.asset.R$string;
import com.huobi.asset.AssetAccountType;
import com.huobi.finance.bean.MiningDataTotal;
import com.huobi.finance.model.AssetDataCacheManager;
import hh.f;
import rx.Observable;

public class HuobiEarnAccountConfig implements f.a<MiningDataTotal> {
    public Fragment a() {
        return new AssetHuobiEarnFragment();
    }

    public Observable<MiningDataTotal> b() {
        return AssetDataCacheManager.k0().p0();
    }

    public String c(Context context) {
        return context.getResources().getString(R$string.n_asset_ybb_stop_financial);
    }

    public AssetAccountType d() {
        return AssetAccountType.HUOBI_EARN;
    }

    public int getPriority() {
        return 500;
    }
}
