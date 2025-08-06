package ts;

import com.hbg.lib.network.swap.core.bean.SwapCancelResult;
import rx.functions.Func1;

public final /* synthetic */ class p implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ q f60407b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f60408c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f60409d;

    public /* synthetic */ p(q qVar, String str, String str2) {
        this.f60407b = qVar;
        this.f60408c = str;
        this.f60409d = str2;
    }

    public final Object call(Object obj) {
        return this.f60407b.q(this.f60408c, this.f60409d, (SwapCancelResult) obj);
    }
}
