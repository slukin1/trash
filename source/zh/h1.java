package zh;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.asset2.index.personer.AssetIndexFragmentPresenterNew;
import rx.functions.Action1;

public final /* synthetic */ class h1 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetIndexFragmentPresenterNew f63019b;

    public /* synthetic */ h1(AssetIndexFragmentPresenterNew assetIndexFragmentPresenterNew) {
        this.f63019b = assetIndexFragmentPresenterNew;
    }

    public final void call(Object obj) {
        this.f63019b.E1((APIStatusErrorException) obj);
    }
}
