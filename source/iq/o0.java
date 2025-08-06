package iq;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import i6.d;
import rx.functions.Action1;

public final /* synthetic */ class o0 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ o0 f55823b = new o0();

    public final void call(Object obj) {
        d.j("StrategyDisable", ((APIStatusErrorException) obj).getErrMsg());
    }
}
