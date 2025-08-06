package zh;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.asset2.index.personer.AssetIndexFragmentPresenter;
import rx.functions.Action1;

public final /* synthetic */ class l implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetIndexFragmentPresenter f63029b;

    public /* synthetic */ l(AssetIndexFragmentPresenter assetIndexFragmentPresenter) {
        this.f63029b = assetIndexFragmentPresenter;
    }

    public final void call(Object obj) {
        this.f63029b.A1((APIStatusErrorException) obj);
    }
}
