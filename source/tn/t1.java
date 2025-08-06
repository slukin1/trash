package tn;

import android.app.Dialog;
import com.huobi.login.v2.ui.UserRegisterActivityV2;
import com.huobi.view.CommonCaptchaDialog;

public final /* synthetic */ class t1 implements CommonCaptchaDialog.CommonDialogClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserRegisterActivityV2 f37313a;

    public /* synthetic */ t1(UserRegisterActivityV2 userRegisterActivityV2) {
        this.f37313a = userRegisterActivityV2;
    }

    public final void onCommonDialogClick(Dialog dialog, int i11) {
        this.f37313a.li(dialog, i11);
    }
}
