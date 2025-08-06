package zh;

import com.hbg.lib.network.hbg.core.bean.AssetPositionSpotData;
import com.huobi.asset2.index.personer.AssetIndexFragmentPresenterNew;
import rx.functions.Func1;

public final /* synthetic */ class p0 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetIndexFragmentPresenterNew f63042b;

    public /* synthetic */ p0(AssetIndexFragmentPresenterNew assetIndexFragmentPresenterNew) {
        this.f63042b = assetIndexFragmentPresenterNew;
    }

    public final Object call(Object obj) {
        return this.f63042b.G1((AssetPositionSpotData) obj);
    }
}
