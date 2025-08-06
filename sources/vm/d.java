package vm;

import com.hbg.lib.network.newkyc.bean.UserKycInfoNew;
import com.huobi.kyc.util.KycProxy;
import rx.functions.Func1;

public final /* synthetic */ class d implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ d f61090b = new d();

    public final Object call(Object obj) {
        return KycProxy.t((UserKycInfoNew) obj);
    }
}
