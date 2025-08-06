package wh;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import i6.d;
import rx.functions.Action1;

public final /* synthetic */ class v0 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ v0 f61347b = new v0();

    public final void call(Object obj) {
        d.c("asset loadData", "preLoad ERROR 1 " + ((APIStatusErrorException) obj).getErrCode());
    }
}
