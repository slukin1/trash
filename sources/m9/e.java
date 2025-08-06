package m9;

import android.text.TextUtils;
import com.hbg.lib.network.swap.core.bean.SwapPriceInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import l9.a;
import rx.Observable;

public class e {

    /* renamed from: c  reason: collision with root package name */
    public static volatile e f70903c;

    /* renamed from: a  reason: collision with root package name */
    public List<SwapPriceInfo> f70904a = null;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, SwapPriceInfo> f70905b = new HashMap();

    public static e e() {
        if (f70903c == null) {
            synchronized (e.class) {
                if (f70903c == null) {
                    f70903c = new e();
                }
            }
        }
        return f70903c;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void h(SwapPriceInfo swapPriceInfo) {
        this.f70905b.put(swapPriceInfo.getContractCode(), swapPriceInfo);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void i(List list) {
        ArrayList arrayList = new ArrayList();
        this.f70904a = arrayList;
        arrayList.addAll(this.f70905b.values());
    }

    public static /* synthetic */ Boolean j(List list) {
        return Boolean.valueOf(list != null);
    }

    public Observable<List<SwapPriceInfo>> f(boolean z11, String str) {
        Observable<T> observable;
        Observable<List<R>> doOnNext = a.a().getPriceInfo(str).b().flatMap(c.f58123b).doOnNext(new a(this)).toList().doOnNext(new b(this));
        if (!z11) {
            return doOnNext;
        }
        if (TextUtils.isEmpty(str)) {
            observable = Observable.just(this.f70904a);
        } else {
            ArrayList arrayList = new ArrayList();
            if (this.f70905b.get(str) != null) {
                arrayList.add(this.f70905b.get(str));
            }
            observable = Observable.just(arrayList);
        }
        return Observable.concat(observable, doOnNext).takeFirst(d.f58124b);
    }
}
