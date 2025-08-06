package tn;

import android.app.Dialog;
import com.huobi.login.v2.ui.SubAccountLoginActivityV2;
import com.huobi.view.CommonCaptchaDialog;

public final /* synthetic */ class b0 implements CommonCaptchaDialog.CommonDialogClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SubAccountLoginActivityV2 f37249a;

    public /* synthetic */ b0(SubAccountLoginActivityV2 subAccountLoginActivityV2) {
        this.f37249a = subAccountLoginActivityV2;
    }

    public final void onCommonDialogClick(Dialog dialog, int i11) {
        this.f37249a.Ei(dialog, i11);
    }
}
