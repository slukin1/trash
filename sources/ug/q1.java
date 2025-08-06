package ug;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import rx.functions.Action1;

public final /* synthetic */ class q1 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ q1 f60638b = new q1();

    public final void call(Object obj) {
        HuobiToastUtil.m(((APIStatusErrorException) obj).getErrMsg());
    }
}
