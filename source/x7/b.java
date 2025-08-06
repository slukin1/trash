package x7;

import com.hbg.lib.network.hbg.core.bean.EtpInfo;
import java.util.HashMap;
import java.util.Map;
import rx.Observable;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static Map<String, EtpInfo> f70551a = new HashMap();

    public static Observable<EtpInfo> b(String str, boolean z11) {
        if (!z11 || f70551a.get(str) == null) {
            return v7.b.a().getEtpInfo(str).b().doOnNext(new a(str));
        }
        return Observable.just(f70551a.get(str));
    }
}
