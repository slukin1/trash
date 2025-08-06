package jp;

import android.app.Dialog;
import android.view.View;
import com.huobi.otc.helper.OtcDialogUtils;

public final /* synthetic */ class q implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OtcDialogUtils.b f56050b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Dialog f56051c;

    public /* synthetic */ q(OtcDialogUtils.b bVar, Dialog dialog) {
        this.f56050b = bVar;
        this.f56051c = dialog;
    }

    public final void onClick(View view) {
        this.f56050b.q(this.f56051c, view);
    }
}
