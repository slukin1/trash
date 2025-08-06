package us;

import com.hbg.lib.network.swap.core.bean.SwapUserOrderLimit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import l9.a;
import rx.Observable;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, List<SwapUserOrderLimit>> f84951a = new HashMap();

    public static Observable<List<SwapUserOrderLimit>> b(boolean z11, String str) {
        List list;
        if (!z11 || (list = f84951a.get(str)) == null) {
            return a.a().z(str).b().map(new k(str));
        }
        return Observable.just(list);
    }

    public static List<SwapUserOrderLimit> c(String str) {
        Map<String, List<SwapUserOrderLimit>> map = f84951a;
        if (map.get(str) != null) {
            return map.get(str);
        }
        return new ArrayList();
    }
}
