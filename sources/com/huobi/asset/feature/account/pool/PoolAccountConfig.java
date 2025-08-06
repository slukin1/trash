package com.huobi.asset.feature.account.pool;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.hbg.module.asset.R$string;
import com.huobi.asset.AssetAccountType;
import com.huobi.finance.bean.MineDataTotal;
import com.huobi.finance.model.AssetDataCacheManager;
import hh.f;
import rx.Observable;

public class PoolAccountConfig implements f.a<MineDataTotal> {
    public Fragment a() {
        return new AssetPoolFragment();
    }

    public Observable<MineDataTotal> b() {
        return AssetDataCacheManager.k0().u0();
    }

    public String c(Context context) {
        return context.getResources().getString(R$string.mine_toolbar_header_title);
    }

    public AssetAccountType d() {
        return AssetAccountType.POOL;
    }

    public int getPriority() {
        return 700;
    }
}
