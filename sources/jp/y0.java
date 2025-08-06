package jp;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import i6.d;
import rx.functions.Action1;

public final /* synthetic */ class y0 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ y0 f56094b = new y0();

    public final void call(Object obj) {
        d.e("jumpToAdTab--->", ((APIStatusErrorException) obj).getErrMsg());
    }
}
