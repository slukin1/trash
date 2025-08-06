package xk;

import com.huobi.finance.bean.BaseAssetInfo;
import com.huobi.finance.bean.BaseAssetTotal;
import com.huobi.utils.SymbolUtil;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import rx.Observable;
import wk.p0;

public abstract class b<T extends BaseAssetTotal, I extends BaseAssetInfo, P, O> implements v<T> {

    /* renamed from: a  reason: collision with root package name */
    public Comparator<I> f48082a;

    /* renamed from: b  reason: collision with root package name */
    public String f48083b;

    /* access modifiers changed from: private */
    public /* synthetic */ BaseAssetTotal i(BaseAssetTotal baseAssetTotal, List list, Object obj, Map map) {
        c(baseAssetTotal, list, map, e(), obj);
        return baseAssetTotal;
    }

    public Observable<T> a(boolean z11) {
        this.f48083b = SymbolUtil.d();
        return Observable.zip(d(), f(z11), g(z11), h(z11), new a(this));
    }

    public abstract void c(T t11, List<P> list, Map<String, BigDecimal> map, Comparator<I> comparator, O o11);

    public abstract Observable<T> d();

    public abstract Comparator<I> e();

    public abstract Observable<List<P>> f(boolean z11);

    public abstract Observable<O> g(boolean z11);

    public final Observable<Map<String, BigDecimal>> h(boolean z11) {
        return p0.g(this.f48083b, z11);
    }
}
