package oh;

import com.hbg.lib.network.hbg.core.bean.YbbUserAssetInfoData;
import com.huobi.asset.feature.account.spot.SpotAccountConfig;
import com.huobi.finance.bean.BalanceDataTotal;
import java.util.List;
import java.util.Map;
import rx.functions.Func5;

public final /* synthetic */ class i implements Func5 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ i f58862b = new i();

    public final Object call(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return SpotAccountConfig.n((BalanceDataTotal) obj, (YbbUserAssetInfoData) obj2, (List) obj3, (Boolean) obj4, (Map) obj5);
    }
}
