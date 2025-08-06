package com.huobi.view;

import android.view.View;
import com.huobi.view.OtcHeavyBubbleDialog;

public final /* synthetic */ class j1 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OtcHeavyBubbleDialog f19054b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ OtcHeavyBubbleDialog.Builder.OnDialogClickListener f19055c;

    public /* synthetic */ j1(OtcHeavyBubbleDialog otcHeavyBubbleDialog, OtcHeavyBubbleDialog.Builder.OnDialogClickListener onDialogClickListener) {
        this.f19054b = otcHeavyBubbleDialog;
        this.f19055c = onDialogClickListener;
    }

    public final void onClick(View view) {
        this.f19054b.lambda$setPosListener$1(this.f19055c, view);
    }
}
