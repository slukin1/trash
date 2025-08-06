package zh;

import com.huobi.asset2.index.personer.AssetIndexFragmentPresenterNew;
import com.huobi.contract.entity.ContractHeartBeat;
import java.util.List;
import rx.functions.Func4;

public final /* synthetic */ class n1 implements Func4 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetIndexFragmentPresenterNew f63037b;

    public /* synthetic */ n1(AssetIndexFragmentPresenterNew assetIndexFragmentPresenterNew) {
        this.f63037b = assetIndexFragmentPresenterNew;
    }

    public final Object call(Object obj, Object obj2, Object obj3, Object obj4) {
        return this.f63037b.t1((ContractHeartBeat) obj, (List) obj2, (List) obj3, (List) obj4);
    }
}
