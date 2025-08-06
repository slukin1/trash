package tn;

import android.app.Dialog;
import com.huobi.login.v2.ui.UserLoginActivityV2;
import com.huobi.view.CommonCaptchaDialog;

public final /* synthetic */ class x0 implements CommonCaptchaDialog.CommonDialogClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserLoginActivityV2 f37324a;

    public /* synthetic */ x0(UserLoginActivityV2 userLoginActivityV2) {
        this.f37324a = userLoginActivityV2;
    }

    public final void onCommonDialogClick(Dialog dialog, int i11) {
        this.f37324a.jj(dialog, i11);
    }
}
