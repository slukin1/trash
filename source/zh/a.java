package zh;

import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.huobi.asset2.index.personer.AssetIndexFragmentPresenter;
import rx.functions.Action1;

public final /* synthetic */ class a implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetIndexFragmentPresenter f62989b;

    public /* synthetic */ a(AssetIndexFragmentPresenter assetIndexFragmentPresenter) {
        this.f62989b = assetIndexFragmentPresenter;
    }

    public final void call(Object obj) {
        this.f62989b.z1((BalanceProfitLossData) obj);
    }
}
