package zh;

import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.huobi.asset2.index.personer.AssetIndexFragmentPresenterNew;
import rx.functions.Action1;

public final /* synthetic */ class l0 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetIndexFragmentPresenterNew f63030b;

    public /* synthetic */ l0(AssetIndexFragmentPresenterNew assetIndexFragmentPresenterNew) {
        this.f63030b = assetIndexFragmentPresenterNew;
    }

    public final void call(Object obj) {
        this.f63030b.J1((BalanceProfitLossData) obj);
    }
}
