package al;

import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.network.hbg.core.bean.SavingsCurrencyProvider;
import com.hbg.lib.network.pro.core.bean.CurrencyBean;
import d7.k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import rx.Observable;

public final class e0 {
    public static List<String> c(List<String> list) {
        ArrayList arrayList = new ArrayList();
        Map<String, CurrencyBean> u11 = k.C().u();
        for (String next : list) {
            if (u11.containsKey(StringUtils.g(next))) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public static Observable<List<String>> d(boolean z11) {
        return Observable.zip(SavingsCurrencyProvider.getInstance().createCurrencyObservable(z11), k.C().E(z11), d0.f3558b);
    }

    public static List<String> g(List<String> list) {
        List<String> c11 = c(list);
        h(c11);
        return c11;
    }

    public static void h(List<String> list) {
        Collections.sort(list, c0.f3555b);
    }
}
