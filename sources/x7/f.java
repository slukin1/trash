package x7;

import com.hbg.lib.network.hbg.core.bean.PioneerActivityLimit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import rx.Observable;
import v7.b;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static final List<PioneerActivityLimit> f70553a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public static final Map<String, PioneerActivityLimit> f70554b = new HashMap();

    public static Observable<List<PioneerActivityLimit>> b(boolean z11) {
        if (z11) {
            List<PioneerActivityLimit> list = f70553a;
            if (list.isEmpty()) {
                return Observable.just(list);
            }
        }
        return b.a().getPioneerActivityLimit().b().doOnNext(e.f61512b);
    }

    public static boolean c(String str) {
        PioneerActivityLimit pioneerActivityLimit;
        Map<String, PioneerActivityLimit> map = f70554b;
        if (map.isEmpty() || (pioneerActivityLimit = map.get(str)) == null) {
            return false;
        }
        return pioneerActivityLimit.isCountryDisabled();
    }

    public static boolean d(String str) {
        PioneerActivityLimit pioneerActivityLimit;
        Map<String, PioneerActivityLimit> map = f70554b;
        if (map.isEmpty() || (pioneerActivityLimit = map.get(str)) == null) {
            return false;
        }
        return pioneerActivityLimit.isAuthKyc();
    }

    public static /* synthetic */ void e(List list) {
        List<PioneerActivityLimit> list2 = f70553a;
        synchronized (list2) {
            list2.clear();
            list2.addAll(list);
        }
        HashMap hashMap = new HashMap();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            PioneerActivityLimit pioneerActivityLimit = (PioneerActivityLimit) it2.next();
            hashMap.put(pioneerActivityLimit.getCurrencyCode(), pioneerActivityLimit);
        }
        Map<String, PioneerActivityLimit> map = f70554b;
        synchronized (map) {
            map.clear();
            map.putAll(hashMap);
        }
    }
}
