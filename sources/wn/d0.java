package wn;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import rx.functions.Action1;

public final /* synthetic */ class d0 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ k0 f61435b;

    public /* synthetic */ d0(k0 k0Var) {
        this.f61435b = k0Var;
    }

    public final void call(Object obj) {
        this.f61435b.n((APIStatusErrorException) obj);
    }
}
