package zh;

import com.hbg.lib.network.hbg.grid.bean.GridStrategy;
import com.huobi.asset2.index.personer.AssetIndexFragmentPresenter;
import rx.functions.Func1;

public final /* synthetic */ class e implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetIndexFragmentPresenter f63005b;

    public /* synthetic */ e(AssetIndexFragmentPresenter assetIndexFragmentPresenter) {
        this.f63005b = assetIndexFragmentPresenter;
    }

    public final Object call(Object obj) {
        return this.f63005b.s1((GridStrategy) obj);
    }
}
