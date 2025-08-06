package yh;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.asset2.index.component.banner.AssetBanner;
import rx.functions.Action1;

public final /* synthetic */ class a implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetBanner f61719b;

    public /* synthetic */ a(AssetBanner assetBanner) {
        this.f61719b = assetBanner;
    }

    public final void call(Object obj) {
        this.f61719b.f((APIStatusErrorException) obj);
    }
}
