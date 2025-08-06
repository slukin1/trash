package iq;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import i6.d;
import rx.functions.Action1;

public final /* synthetic */ class y implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ y f55837b = new y();

    public final void call(Object obj) {
        d.j("StrategyDisable", ((APIStatusErrorException) obj).getErrMsg());
    }
}
