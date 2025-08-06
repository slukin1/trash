package zh;

import com.hbg.lib.network.swap.core.bean.SwapPosition;
import com.huobi.asset2.index.personer.AssetIndexFragmentPresenterNew;
import rx.functions.Func1;

public final /* synthetic */ class s0 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetIndexFragmentPresenterNew f63051b;

    public /* synthetic */ s0(AssetIndexFragmentPresenterNew assetIndexFragmentPresenterNew) {
        this.f63051b = assetIndexFragmentPresenterNew;
    }

    public final Object call(Object obj) {
        return this.f63051b.p1((SwapPosition) obj);
    }
}
