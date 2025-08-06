package com.huobi.view;

import android.view.View;
import com.huobi.view.OtcHeavyBubbleDialog;

public final /* synthetic */ class i1 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OtcHeavyBubbleDialog f19049b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ OtcHeavyBubbleDialog.Builder.OnDialogClickListener f19050c;

    public /* synthetic */ i1(OtcHeavyBubbleDialog otcHeavyBubbleDialog, OtcHeavyBubbleDialog.Builder.OnDialogClickListener onDialogClickListener) {
        this.f19049b = otcHeavyBubbleDialog;
        this.f19050c = onDialogClickListener;
    }

    public final void onClick(View view) {
        this.f19049b.lambda$setNegListener$0(this.f19050c, view);
    }
}
