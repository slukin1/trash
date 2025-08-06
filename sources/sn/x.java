package sn;

import android.app.Activity;
import com.geetest.captcha.GTCaptcha4Client;
import com.huobi.login.usercenter.data.source.bean.RiskControl;
import com.huobi.login.utils.VerifyHelper;

public final /* synthetic */ class x implements GTCaptcha4Client.OnFailureListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ VerifyHelper f70180a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Activity f70181b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f70182c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f70183d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ RiskControl f70184e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ boolean f70185f;

    public /* synthetic */ x(VerifyHelper verifyHelper, Activity activity, String str, String str2, RiskControl riskControl, boolean z11) {
        this.f70180a = verifyHelper;
        this.f70181b = activity;
        this.f70182c = str;
        this.f70183d = str2;
        this.f70184e = riskControl;
        this.f70185f = z11;
    }

    public final void onFailure(String str) {
        this.f70180a.w(this.f70181b, this.f70182c, this.f70183d, this.f70184e, this.f70185f, str);
    }
}
