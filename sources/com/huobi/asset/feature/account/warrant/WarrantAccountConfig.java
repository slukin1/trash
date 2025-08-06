package com.huobi.asset.feature.account.warrant;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.hbg.module.asset.R$string;
import com.huobi.asset.AssetAccountType;
import com.huobi.finance.bean.OtcOptionDataTotal;
import com.huobi.finance.model.AssetDataCacheManager;
import com.tencent.rtmp.TXLivePushConfig;
import hh.f;
import rx.Observable;

public class WarrantAccountConfig implements f.a<OtcOptionDataTotal> {
    public Fragment a() {
        return new AssetWarrantFragment();
    }

    public Observable<OtcOptionDataTotal> b() {
        return AssetDataCacheManager.k0().G0();
    }

    public String c(Context context) {
        return context.getResources().getString(R$string.n_otc_options_account).replace("账户", "");
    }

    public AssetAccountType d() {
        return AssetAccountType.WARRANT;
    }

    public int getPriority() {
        return TXLivePushConfig.DEFAULT_MIN_VIDEO_BITRATE;
    }
}
