package ph;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.asset.feature.base.BaseAssetListFragment;
import rx.functions.Action1;

public final /* synthetic */ class j implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BaseAssetListFragment f53047b;

    public /* synthetic */ j(BaseAssetListFragment baseAssetListFragment) {
        this.f53047b = baseAssetListFragment;
    }

    public final void call(Object obj) {
        this.f53047b.Yh((APIStatusErrorException) obj);
    }
}
