package ph;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.asset.feature.base.AssetSubTypeBaseFragment;
import rx.functions.Action1;

public final /* synthetic */ class d implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetSubTypeBaseFragment f53041b;

    public /* synthetic */ d(AssetSubTypeBaseFragment assetSubTypeBaseFragment) {
        this.f53041b = assetSubTypeBaseFragment;
    }

    public final void call(Object obj) {
        this.f53041b.Ph((APIStatusErrorException) obj);
    }
}
