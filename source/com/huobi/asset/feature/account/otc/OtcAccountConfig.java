package com.huobi.asset.feature.account.otc;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.hbg.module.asset.R$string;
import com.huobi.asset.AssetAccountType;
import com.huobi.finance.bean.LegalDataTotal;
import com.huobi.finance.model.AssetDataCacheManager;
import hh.f;
import rx.Observable;

public class OtcAccountConfig implements f.a<LegalDataTotal> {
    public Fragment a() {
        return new AssetOtcFragment();
    }

    public Observable<LegalDataTotal> b() {
        return AssetDataCacheManager.k0().l0();
    }

    public String c(Context context) {
        return context.getResources().getString(R$string.n_blance_fiat_assets);
    }

    public AssetAccountType d() {
        return AssetAccountType.OTC;
    }

    public int getPriority() {
        return 400;
    }
}
