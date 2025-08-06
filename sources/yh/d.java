package yh;

import android.content.Context;
import com.hbg.lib.network.hbg.core.bean.AssetBannerData;
import com.huobi.asset2.index.component.banner.AssetBanner;
import rx.functions.Action1;

public final /* synthetic */ class d implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f61722b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AssetBannerData f61723c;

    public /* synthetic */ d(Context context, AssetBannerData assetBannerData) {
        this.f61722b = context;
        this.f61723c = assetBannerData;
    }

    public final void call(Object obj) {
        AssetBanner.a.e(this.f61722b, this.f61723c, (Void) obj);
    }
}
