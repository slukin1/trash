package zh;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import i6.d;
import rx.functions.Action1;

public final /* synthetic */ class y1 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ y1 f63070b = new y1();

    public final void call(Object obj) {
        d.c("AssetIndexFragmentPresenter", "preLoad ERROR 1 " + ((APIStatusErrorException) obj).getErrCode());
    }
}
