package jp;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.otc.helper.OtcFaitDWJumpHelper;
import rx.functions.Action1;

public final /* synthetic */ class z implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OtcFaitDWJumpHelper.k f56096b;

    public /* synthetic */ z(OtcFaitDWJumpHelper.k kVar) {
        this.f56096b = kVar;
    }

    public final void call(Object obj) {
        OtcFaitDWJumpHelper.J(this.f56096b, (APIStatusErrorException) obj);
    }
}
