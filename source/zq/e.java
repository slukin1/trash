package zq;

import com.hbg.lib.core.BaseModuleConfig;
import java.util.HashMap;
import java.util.Map;
import rx.Observable;
import v7.b;

public final class e {

    /* renamed from: d  reason: collision with root package name */
    public static final e f85104d = new e();

    /* renamed from: a  reason: collision with root package name */
    public boolean f85105a = true;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, Boolean> f85106b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public Map<String, Boolean> f85107c = new HashMap();

    public static e e() {
        return f85104d;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void g(Boolean bool) {
        this.f85106b.put(BaseModuleConfig.a().i0(), bool);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void h(Boolean bool) {
        this.f85107c.put(BaseModuleConfig.a().i0(), bool);
    }

    public static /* synthetic */ Boolean i(Boolean bool, Throwable th2) {
        return Boolean.valueOf(bool != null ? bool.booleanValue() : false);
    }

    public Observable<Boolean> d(boolean z11) {
        Boolean bool;
        if (BaseModuleConfig.a().a() && BaseModuleConfig.a().c()) {
            return Observable.just(Boolean.FALSE);
        }
        if (!z11 || (bool = this.f85106b.get(BaseModuleConfig.a().i0())) == null) {
            return b.a().savingsCheckPermission().b().doOnNext(new b(this));
        }
        return Observable.just(bool);
    }

    public Observable<Boolean> f(boolean z11) {
        if (!BaseModuleConfig.a().a() || BaseModuleConfig.a().c()) {
            return Observable.just(Boolean.FALSE);
        }
        Boolean bool = this.f85107c.get(BaseModuleConfig.a().i0());
        if (!z11 || bool == null) {
            return b.a().getMiningAssetSwitch().b().map(d.f63111b).doOnNext(new a(this)).onErrorReturn(new c(bool));
        }
        return Observable.just(bool);
    }
}
