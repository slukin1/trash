package sn;

import com.geetest.captcha.GTCaptcha4Client;
import com.huobi.login.usercenter.data.source.bean.RiskControl;
import com.huobi.login.utils.VerifyHelper;

public final /* synthetic */ class y implements GTCaptcha4Client.OnSuccessListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ VerifyHelper f70186a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RiskControl.ItemsBean f70187b;

    public /* synthetic */ y(VerifyHelper verifyHelper, RiskControl.ItemsBean itemsBean) {
        this.f70186a = verifyHelper;
        this.f70187b = itemsBean;
    }

    public final void onSuccess(boolean z11, String str) {
        this.f70186a.v(this.f70187b, z11, str);
    }
}
