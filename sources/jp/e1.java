package jp;

import com.huobi.login.usercenter.data.source.bean.CodeVerifyData;
import com.huobi.otc.helper.OtcSecurityTokenFactory;
import rx.functions.Action1;

public final /* synthetic */ class e1 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OtcSecurityTokenFactory f56013b;

    public /* synthetic */ e1(OtcSecurityTokenFactory otcSecurityTokenFactory) {
        this.f56013b = otcSecurityTokenFactory;
    }

    public final void call(Object obj) {
        this.f56013b.s((CodeVerifyData) obj);
    }
}
