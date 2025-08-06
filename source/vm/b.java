package vm;

import com.hbg.lib.network.inst.bean.InstStateInfo;
import com.huobi.kyc.util.KycProxy;
import rx.functions.Func1;

public final /* synthetic */ class b implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ KycProxy f61088b;

    public /* synthetic */ b(KycProxy kycProxy) {
        this.f61088b = kycProxy;
    }

    public final Object call(Object obj) {
        return this.f61088b.w((InstStateInfo) obj);
    }
}
