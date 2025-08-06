package zh;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.asset2.index.personer.AssetIndexFragmentPresenter;
import rx.functions.Action1;

public final /* synthetic */ class e0 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetIndexFragmentPresenter f63006b;

    public /* synthetic */ e0(AssetIndexFragmentPresenter assetIndexFragmentPresenter) {
        this.f63006b = assetIndexFragmentPresenter;
    }

    public final void call(Object obj) {
        this.f63006b.u1((APIStatusErrorException) obj);
    }
}
