package al;

import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.network.hbg.core.bean.MineAccountItem;
import com.hbg.lib.network.hbg.core.bean.MineCurrencyProvider;
import com.hbg.lib.network.pro.core.bean.CurrencyBean;
import d7.k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import rx.Observable;

public final class b0 {
    public static List<MineAccountItem> c() {
        return h(MineCurrencyProvider.cloneTransferableCurrencyList());
    }

    public static List<MineAccountItem> d(List<MineAccountItem> list) {
        ArrayList arrayList = new ArrayList();
        Map<String, CurrencyBean> u11 = k.C().u();
        for (MineAccountItem next : list) {
            if (u11.containsKey(StringUtils.g(next.getCurrency()))) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public static Observable<List<MineAccountItem>> e(boolean z11) {
        return Observable.zip(MineCurrencyProvider.createCurrencyObservable(z11), k.C().E(z11), a0.f3553b);
    }

    public static List<MineAccountItem> h(List<MineAccountItem> list) {
        List<MineAccountItem> d11 = d(list);
        i(d11);
        return d11;
    }

    public static void i(List<MineAccountItem> list) {
        Collections.sort(list, z.f3604b);
    }
}
