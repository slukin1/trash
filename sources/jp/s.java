package jp;

import android.app.Dialog;
import android.view.View;
import com.huobi.otc.helper.OtcDialogUtils;

public final /* synthetic */ class s implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OtcDialogUtils.b f56057b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Dialog f56058c;

    public /* synthetic */ s(OtcDialogUtils.b bVar, Dialog dialog) {
        this.f56057b = bVar;
        this.f56058c = dialog;
    }

    public final void onClick(View view) {
        this.f56057b.m(this.f56058c, view);
    }
}
