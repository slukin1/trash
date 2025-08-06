package zh;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.asset2.index.personer.AssetIndexFragmentPresenterNew;
import rx.functions.Action1;

public final /* synthetic */ class w0 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetIndexFragmentPresenterNew f63063b;

    public /* synthetic */ w0(AssetIndexFragmentPresenterNew assetIndexFragmentPresenterNew) {
        this.f63063b = assetIndexFragmentPresenterNew;
    }

    public final void call(Object obj) {
        this.f63063b.K1((APIStatusErrorException) obj);
    }
}
