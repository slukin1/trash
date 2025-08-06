package jh;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.asset.feature.account.huobiearn.AssetHuobiEarnFragment;
import rx.functions.Action1;

public final /* synthetic */ class f implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetHuobiEarnFragment f55938b;

    public /* synthetic */ f(AssetHuobiEarnFragment assetHuobiEarnFragment) {
        this.f55938b = assetHuobiEarnFragment;
    }

    public final void call(Object obj) {
        this.f55938b.ei((APIStatusErrorException) obj);
    }
}
