package zh;

import com.hbg.lib.network.swap.core.bean.SwapPosition;
import com.huobi.asset2.index.personer.AssetIndexFragmentPresenter;
import rx.functions.Func1;

public final /* synthetic */ class g implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetIndexFragmentPresenter f63013b;

    public /* synthetic */ g(AssetIndexFragmentPresenter assetIndexFragmentPresenter) {
        this.f63013b = assetIndexFragmentPresenter;
    }

    public final Object call(Object obj) {
        return this.f63013b.h1((SwapPosition) obj);
    }
}
