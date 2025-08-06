package vm;

import com.hbg.lib.network.newkyc.bean.UserKycInfoNew;
import com.huobi.kyc.util.KycProxy;
import rx.functions.Action1;

public final /* synthetic */ class a implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ KycProxy f61087b;

    public /* synthetic */ a(KycProxy kycProxy) {
        this.f61087b = kycProxy;
    }

    public final void call(Object obj) {
        this.f61087b.s((UserKycInfoNew) obj);
    }
}
