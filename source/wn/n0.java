package wn;

import android.app.Dialog;
import com.huobi.view.CommonCaptchaDialog;
import wn.u0;

public final /* synthetic */ class n0 implements CommonCaptchaDialog.CommonDialogClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ u0 f61462a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ u0.e f61463b;

    public /* synthetic */ n0(u0 u0Var, u0.e eVar) {
        this.f61462a = u0Var;
        this.f61463b = eVar;
    }

    public final void onCommonDialogClick(Dialog dialog, int i11) {
        this.f61462a.p(this.f61463b, dialog, i11);
    }
}
