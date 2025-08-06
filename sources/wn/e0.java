package wn;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import rx.functions.Action1;

public final /* synthetic */ class e0 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ k0 f61437b;

    public /* synthetic */ e0(k0 k0Var) {
        this.f61437b = k0Var;
    }

    public final void call(Object obj) {
        this.f61437b.r((APIStatusErrorException) obj);
    }
}
