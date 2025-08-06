package i8;

import com.hbg.lib.network.linear.swap.core.bean.LinearSwapLightLimitLevel;
import h8.a;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.Observable;

public class h {

    /* renamed from: b  reason: collision with root package name */
    public static volatile h f70357b;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, LinearSwapLightLimitLevel> f70358a = new HashMap();

    public static h c() {
        if (f70357b == null) {
            synchronized (h.class) {
                if (f70357b == null) {
                    f70357b = new h();
                }
            }
        }
        return f70357b;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f(LinearSwapLightLimitLevel linearSwapLightLimitLevel) {
        this.f70358a.put(linearSwapLightLimitLevel.getContractCode(), linearSwapLightLimitLevel);
    }

    public Observable<List<LinearSwapLightLimitLevel>> d(String str) {
        return a.a().getLightLimitLevel("").b().flatMap(g.f55021b).doOnNext(new f(this)).toList();
    }
}
