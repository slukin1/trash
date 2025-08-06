package iq;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.points.presenter.MyTransferPresenter;
import rx.functions.Action1;

public final /* synthetic */ class f implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ f f55803b = new f();

    public final void call(Object obj) {
        MyTransferPresenter.a0((APIStatusErrorException) obj);
    }
}
