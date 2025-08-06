package wk;

import com.hbg.lib.core.BaseModuleConfig;
import com.huobi.finance.bean.BaseAssetTotal;
import i6.k;
import rx.Observable;
import xk.v;

public class r0<T extends BaseAssetTotal> {

    /* renamed from: a  reason: collision with root package name */
    public final v<T> f48075a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f48076b;

    /* renamed from: c  reason: collision with root package name */
    public T f48077c;

    /* renamed from: d  reason: collision with root package name */
    public String f48078d;

    public r0(v<T> vVar) {
        this.f48075a = vVar;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e(BaseAssetTotal baseAssetTotal) {
        this.f48077c = baseAssetTotal;
        this.f48078d = BaseModuleConfig.a().getUid();
        this.f48076b = true;
        k.o("AssetCalculate", "[load]balanceType=" + this.f48075a.getClass().getSimpleName() + " data=" + this.f48077c.toTotalString());
    }

    public final boolean b() {
        String str = this.f48078d;
        return str != null && str.equals(BaseModuleConfig.a().getUid());
    }

    public void c() {
        this.f48076b = false;
        this.f48077c = null;
    }

    public Observable<T> d() {
        Observable<T> doOnNext = this.f48075a.a(this.f48076b).doOnNext(new q0(this));
        return (this.f48077c == null || !b()) ? doOnNext : Observable.concat(Observable.just(this.f48077c), doOnNext);
    }
}
