package jp;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.otc.helper.OtcFaitDWJumpHelper;
import rx.functions.Action1;

public final /* synthetic */ class a0 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OtcFaitDWJumpHelper.k f55994b;

    public /* synthetic */ a0(OtcFaitDWJumpHelper.k kVar) {
        this.f55994b = kVar;
    }

    public final void call(Object obj) {
        OtcFaitDWJumpHelper.G(this.f55994b, (APIStatusErrorException) obj);
    }
}
