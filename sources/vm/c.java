package vm;

import com.huobi.kyc.util.KycProxy;
import java.util.List;
import rx.functions.Func1;

public final /* synthetic */ class c implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ KycProxy f61089b;

    public /* synthetic */ c(KycProxy kycProxy) {
        this.f61089b = kycProxy;
    }

    public final Object call(Object obj) {
        return this.f61089b.u((List) obj);
    }
}
