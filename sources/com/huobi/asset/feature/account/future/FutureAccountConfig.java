package com.huobi.asset.feature.account.future;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.hbg.module.asset.R$string;
import com.huobi.asset.AssetAccountType;
import com.huobi.finance.bean.BaseAssetTotal;
import hh.f;
import rx.Observable;

public class FutureAccountConfig implements f.a<BaseAssetTotal> {
    public Fragment a() {
        return new AssetFutureContainerFragment();
    }

    public Observable<BaseAssetTotal> b() {
        return null;
    }

    public String c(Context context) {
        return context.getResources().getString(R$string.n_balance_contract_title);
    }

    public AssetAccountType d() {
        return AssetAccountType.FUTURE;
    }

    public int getPriority() {
        return 200;
    }
}
