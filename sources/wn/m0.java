package wn;

import android.app.Dialog;
import com.huobi.view.CommonCaptchaDialog;
import wn.u0;

public final /* synthetic */ class m0 implements CommonCaptchaDialog.CommonDialogClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ u0 f61459a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ u0.e f61460b;

    public /* synthetic */ m0(u0 u0Var, u0.e eVar) {
        this.f61459a = u0Var;
        this.f61460b = eVar;
    }

    public final void onCommonDialogClick(Dialog dialog, int i11) {
        this.f61459a.q(this.f61460b, dialog, i11);
    }
}
