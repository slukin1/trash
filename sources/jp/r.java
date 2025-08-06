package jp;

import android.app.Dialog;
import android.view.View;
import com.huobi.otc.helper.OtcDialogUtils;

public final /* synthetic */ class r implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OtcDialogUtils.b f56053b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Dialog f56054c;

    public /* synthetic */ r(OtcDialogUtils.b bVar, Dialog dialog) {
        this.f56053b = bVar;
        this.f56054c = dialog;
    }

    public final void onClick(View view) {
        this.f56053b.p(this.f56054c, view);
    }
}
