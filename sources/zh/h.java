package zh;

import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.huobi.asset2.index.personer.AssetIndexFragmentPresenter;
import hh.f;
import rx.functions.Func1;

public final /* synthetic */ class h implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ f f63017b;

    public /* synthetic */ h(f fVar) {
        this.f63017b = fVar;
    }

    public final Object call(Object obj) {
        return AssetIndexFragmentPresenter.y1(this.f63017b, (BalanceProfitLossData) obj);
    }
}
