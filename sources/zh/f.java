package zh;

import com.hbg.lib.network.linear.swap.core.bean.LinearSwapPosition;
import com.huobi.asset2.index.personer.AssetIndexFragmentPresenter;
import rx.functions.Func1;

public final /* synthetic */ class f implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetIndexFragmentPresenter f63009b;

    public /* synthetic */ f(AssetIndexFragmentPresenter assetIndexFragmentPresenter) {
        this.f63009b = assetIndexFragmentPresenter;
    }

    public final Object call(Object obj) {
        return this.f63009b.j1((LinearSwapPosition) obj);
    }
}
