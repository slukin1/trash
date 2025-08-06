package zh;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import i6.d;
import rx.functions.Action1;

public final /* synthetic */ class b implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ b f62993b = new b();

    public final void call(Object obj) {
        d.c("AssetIndexFragmentPresenter", "preLoad ERROR 1 " + ((APIStatusErrorException) obj).getErrCode());
    }
}
