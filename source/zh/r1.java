package zh;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.asset2.index.personer.AssetIndexFragmentPresenterNew;
import rx.functions.Action1;

public final /* synthetic */ class r1 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetIndexFragmentPresenterNew f63049b;

    public /* synthetic */ r1(AssetIndexFragmentPresenterNew assetIndexFragmentPresenterNew) {
        this.f63049b = assetIndexFragmentPresenterNew;
    }

    public final void call(Object obj) {
        this.f63049b.v1((APIStatusErrorException) obj);
    }
}
