package jp;

import com.huobi.login.usercenter.data.source.bean.CodeVerifyData;
import com.huobi.otc.helper.OtcSecurityTokenFactory;
import rx.functions.Action1;

public final /* synthetic */ class f1 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OtcSecurityTokenFactory f56014b;

    public /* synthetic */ f1(OtcSecurityTokenFactory otcSecurityTokenFactory) {
        this.f56014b = otcSecurityTokenFactory;
    }

    public final void call(Object obj) {
        this.f56014b.r((CodeVerifyData) obj);
    }
}
