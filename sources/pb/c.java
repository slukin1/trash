package pb;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import rx.functions.Action1;

public final /* synthetic */ class c implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ c f53007b = new c();

    public final void call(Object obj) {
        HuobiToastUtil.m(((APIStatusErrorException) obj).getErrMsg());
    }
}
