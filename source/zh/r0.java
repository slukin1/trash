package zh;

import com.hbg.lib.network.linear.swap.core.bean.LinearSwapPosition;
import com.huobi.asset2.index.personer.AssetIndexFragmentPresenterNew;
import rx.functions.Func1;

public final /* synthetic */ class r0 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetIndexFragmentPresenterNew f63048b;

    public /* synthetic */ r0(AssetIndexFragmentPresenterNew assetIndexFragmentPresenterNew) {
        this.f63048b = assetIndexFragmentPresenterNew;
    }

    public final Object call(Object obj) {
        return this.f63048b.r1((LinearSwapPosition) obj);
    }
}
