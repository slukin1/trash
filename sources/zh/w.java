package zh;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.asset2.index.personer.AssetIndexFragmentPresenter;
import rx.functions.Action1;

public final /* synthetic */ class w implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetIndexFragmentPresenter f63062b;

    public /* synthetic */ w(AssetIndexFragmentPresenter assetIndexFragmentPresenter) {
        this.f63062b = assetIndexFragmentPresenter;
    }

    public final void call(Object obj) {
        this.f63062b.n1((APIStatusErrorException) obj);
    }
}
