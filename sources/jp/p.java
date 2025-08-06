package jp;

import android.app.Dialog;
import android.view.View;
import com.huobi.otc.helper.OtcDialogUtils;

public final /* synthetic */ class p implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OtcDialogUtils.b f56046b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Dialog f56047c;

    public /* synthetic */ p(OtcDialogUtils.b bVar, Dialog dialog) {
        this.f56046b = bVar;
        this.f56047c = dialog;
    }

    public final void onClick(View view) {
        this.f56046b.r(this.f56047c, view);
    }
}
