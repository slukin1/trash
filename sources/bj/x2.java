package bj;

import com.hbg.lib.network.contract.core.bean.ContractUserOrderLimit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import q7.a;
import rx.Observable;

public final class x2 {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, List<ContractUserOrderLimit>> f40896a = new HashMap();

    public static Observable<List<ContractUserOrderLimit>> b(boolean z11, String str) {
        List list;
        if (!z11 || (list = f40896a.get(str)) == null) {
            return a.a().z(str).b().map(new w2(str));
        }
        return Observable.just(list);
    }

    public static List<ContractUserOrderLimit> c(String str) {
        Map<String, List<ContractUserOrderLimit>> map = f40896a;
        if (map.get(str) != null) {
            return map.get(str);
        }
        return new ArrayList();
    }
}
