package gj;

import android.util.Log;
import com.hbg.lib.core.network.response.UcIntCodeResponse;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.hbg.core.bean.TeachConfig;
import com.hbg.lib.network.hbg.core.bean.TeachConfigItem;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.huobi.control.api.ControlConfigService;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.functions.Func1;
import tq.p;

public final class g {

    /* renamed from: c  reason: collision with root package name */
    public static final g f47559c = new g();

    /* renamed from: a  reason: collision with root package name */
    public TeachConfig f47560a;

    /* renamed from: b  reason: collision with root package name */
    public Map<Integer, TeachConfigItem> f47561b = new HashMap();

    public class a implements Func1<TeachConfig, Boolean> {
        public a() {
        }

        /* renamed from: a */
        public Boolean call(TeachConfig teachConfig) {
            return Boolean.valueOf(teachConfig != null);
        }
    }

    public class b extends BaseSubscriber<TeachConfig> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c6.b f47563b;

        public b(c6.b bVar) {
            this.f47563b = bVar;
        }

        /* renamed from: a */
        public void onNext(TeachConfig teachConfig) {
            super.onNext(teachConfig);
            TeachConfig unused = g.this.f47560a = teachConfig;
            g.this.j(teachConfig);
            c6.b bVar = this.f47563b;
            if (bVar != null) {
                bVar.onCallback(teachConfig);
            }
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            g.this.j((TeachConfig) null);
        }
    }

    public static g e() {
        return f47559c;
    }

    public static /* synthetic */ UcIntCodeResponse g(Throwable th2) {
        return null;
    }

    public final Observable<TeachConfig> d() {
        return Observable.concat(Observable.just(this.f47560a), ((ControlConfigService) p.C(ControlConfigService.class)).getTeachConfig().compose(RxJavaHelper.t((u6.g) null)).timeout(2, TimeUnit.SECONDS).onErrorReturn(f.f54822b).compose(p.D())).takeFirst(new a());
    }

    public TeachConfigItem f(int i11) {
        return this.f47561b.get(Integer.valueOf(i11));
    }

    public void h() {
        i((c6.b) null);
    }

    public void i(c6.b bVar) {
        d().subscribe(new b(bVar));
    }

    public final void j(TeachConfig teachConfig) {
        if (teachConfig != null && teachConfig.getTeachConfigList() != null && !teachConfig.getTeachConfigList().isEmpty()) {
            for (TeachConfigItem next : teachConfig.getTeachConfigList()) {
                this.f47561b.put(Integer.valueOf(next.getCode()), next);
            }
            Log.i("HbControl", "load remote success " + this.f47561b);
        }
    }

    public void k() {
        this.f47561b.clear();
        this.f47560a = null;
        h();
    }
}
