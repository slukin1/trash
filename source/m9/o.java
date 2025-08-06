package m9;

import com.hbg.lib.network.swap.core.bean.SwapLightLimitLevel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import l9.a;
import rx.Observable;

public class o {

    /* renamed from: b  reason: collision with root package name */
    public static volatile o f70908b;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, SwapLightLimitLevel> f70909a = new HashMap();

    public static o c() {
        if (f70908b == null) {
            synchronized (o.class) {
                if (f70908b == null) {
                    f70908b = new o();
                }
            }
        }
        return f70908b;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f(SwapLightLimitLevel swapLightLimitLevel) {
        this.f70909a.put(swapLightLimitLevel.getContractCode(), swapLightLimitLevel);
    }

    public Observable<List<SwapLightLimitLevel>> d(String str) {
        return a.a().getLightLimitLevel("").b().flatMap(n.f58133b).doOnNext(new m(this)).toList();
    }
}
