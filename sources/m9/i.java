package m9;

import com.hbg.lib.network.swap.core.bean.SwapAllowLevel;
import java.util.HashMap;
import java.util.Map;
import l9.a;
import rx.Observable;

public final class i {

    /* renamed from: b  reason: collision with root package name */
    public static volatile i f70906b;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, SwapAllowLevel> f70907a = new HashMap();

    public static i d() {
        if (f70906b == null) {
            synchronized (i.class) {
                if (f70906b == null) {
                    f70906b = new i();
                }
            }
        }
        return f70906b;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void g(String str, SwapAllowLevel swapAllowLevel) {
        this.f70907a.put(str, swapAllowLevel);
    }

    public Observable<SwapAllowLevel> c(boolean z11, String str) {
        SwapAllowLevel swapAllowLevel = this.f70907a.get(str);
        if (!z11 || swapAllowLevel == null) {
            return a.a().getAllowMaxLevel(str).b().flatMap(h.f58128b).doOnNext(new g(this, str));
        }
        return Observable.just(this.f70907a.get(str));
    }

    public SwapAllowLevel e(String str) {
        Map<String, SwapAllowLevel> map = this.f70907a;
        if (map == null || map.get(str) == null) {
            return null;
        }
        return this.f70907a.get(str);
    }
}
