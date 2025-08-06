package tn;

import android.app.Dialog;
import com.huobi.login.v2.ui.SubAccountLoginActivityV2;
import com.huobi.view.CommonCaptchaDialog;

public final /* synthetic */ class c0 implements CommonCaptchaDialog.CommonDialogClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SubAccountLoginActivityV2 f37253a;

    public /* synthetic */ c0(SubAccountLoginActivityV2 subAccountLoginActivityV2) {
        this.f37253a = subAccountLoginActivityV2;
    }

    public final void onCommonDialogClick(Dialog dialog, int i11) {
        this.f37253a.Fi(dialog, i11);
    }
}
