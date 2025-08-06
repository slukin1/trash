package zh;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import i6.d;
import rx.functions.Action1;

public final /* synthetic */ class m0 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ m0 f63033b = new m0();

    public final void call(Object obj) {
        d.c("AssetIndexFragmentPresenter", "preLoad ERROR 1 " + ((APIStatusErrorException) obj).getErrCode());
    }
}
