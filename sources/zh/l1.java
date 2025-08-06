package zh;

import com.huobi.asset2.index.personer.AssetIndexFragmentPresenterNew;
import com.huobi.finance.bean.MarginBalanceDataTotal;
import com.huobi.finance.bean.SuperMarginDataTotal;
import rx.functions.Func2;

public final /* synthetic */ class l1 implements Func2 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetIndexFragmentPresenterNew f63031b;

    public /* synthetic */ l1(AssetIndexFragmentPresenterNew assetIndexFragmentPresenterNew) {
        this.f63031b = assetIndexFragmentPresenterNew;
    }

    public final Object call(Object obj, Object obj2) {
        return this.f63031b.x1((MarginBalanceDataTotal) obj, (SuperMarginDataTotal) obj2);
    }
}
