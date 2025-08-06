package ug;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import i6.d;
import rx.functions.Action1;

public final /* synthetic */ class d0 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ d0 f60585b = new d0();

    public final void call(Object obj) {
        d.j("bindEmail", ((APIStatusErrorException) obj).getErrMsg());
    }
}
