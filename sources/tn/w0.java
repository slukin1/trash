package tn;

import android.app.Dialog;
import com.huobi.login.v2.ui.UserLoginActivityV2;
import com.huobi.view.CommonCaptchaDialog;

public final /* synthetic */ class w0 implements CommonCaptchaDialog.CommonDialogClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserLoginActivityV2 f37321a;

    public /* synthetic */ w0(UserLoginActivityV2 userLoginActivityV2) {
        this.f37321a = userLoginActivityV2;
    }

    public final void onCommonDialogClick(Dialog dialog, int i11) {
        this.f37321a.kj(dialog, i11);
    }
}
