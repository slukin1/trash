package com.huobi.asset.feature.account.mortgage.config;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.hbg.module.asset.R$string;
import com.huobi.asset.AssetAccountType;
import com.huobi.asset.feature.account.mortgage.AssetMortgageFragment;
import com.huobi.finance.bean.BaseAssetTotal;
import hh.f;
import rx.Observable;

public class MortgageAccountConfig implements f.a<BaseAssetTotal> {
    public Fragment a() {
        return new AssetMortgageFragment();
    }

    public Observable<BaseAssetTotal> b() {
        return null;
    }

    public String c(Context context) {
        return context.getResources().getString(R$string.n_asset_mortgage_account).replace("账户", "");
    }

    public AssetAccountType d() {
        return AssetAccountType.MORTGAGE;
    }

    public int getPriority() {
        return 900;
    }
}
