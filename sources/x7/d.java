package x7;

import com.hbg.lib.network.hbg.core.bean.EtpRebalInfo;
import java.util.HashMap;
import java.util.Map;
import rx.Observable;
import v7.b;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static Map<String, EtpRebalInfo> f70552a = new HashMap();

    public static EtpRebalInfo b(String str) {
        return f70552a.get(str);
    }

    public static Observable<EtpRebalInfo> c(String str, boolean z11) {
        if (!z11 || f70552a.get(str) == null) {
            return b.a().getEtpRebalInfo(str).b().doOnNext(new c(str));
        }
        return Observable.just(f70552a.get(str));
    }
}
