package tn;

import android.app.Dialog;
import com.huobi.login.v2.ui.CaptchaCodeActivityV2;
import com.huobi.view.CommonCaptchaDialog;

public final /* synthetic */ class f implements CommonCaptchaDialog.CommonDialogClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CaptchaCodeActivityV2 f37264a;

    public /* synthetic */ f(CaptchaCodeActivityV2 captchaCodeActivityV2) {
        this.f37264a = captchaCodeActivityV2;
    }

    public final void onCommonDialogClick(Dialog dialog, int i11) {
        this.f37264a.Oh(dialog, i11);
    }
}
