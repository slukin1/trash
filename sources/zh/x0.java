package zh;

import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.huobi.asset2.index.personer.AssetIndexFragmentPresenterNew;
import hh.f;
import rx.functions.Func1;

public final /* synthetic */ class x0 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ f f63066b;

    public /* synthetic */ x0(f fVar) {
        this.f63066b = fVar;
    }

    public final Object call(Object obj) {
        return AssetIndexFragmentPresenterNew.I1(this.f63066b, (BalanceProfitLossData) obj);
    }
}
