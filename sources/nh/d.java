package nh;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.asset.feature.account.quant.AssetQuantFragment;
import rx.functions.Action1;

public final /* synthetic */ class d implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetQuantFragment f58541b;

    public /* synthetic */ d(AssetQuantFragment assetQuantFragment) {
        this.f58541b = assetQuantFragment;
    }

    public final void call(Object obj) {
        this.f58541b.Vh((APIStatusErrorException) obj);
    }
}
