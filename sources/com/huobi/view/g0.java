package com.huobi.view;

import android.view.View;
import com.huobi.view.HeavyBubbleDialog;

public final /* synthetic */ class g0 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HeavyBubbleDialog f19035b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ HeavyBubbleDialog.Builder.OnDialogClickListener f19036c;

    public /* synthetic */ g0(HeavyBubbleDialog heavyBubbleDialog, HeavyBubbleDialog.Builder.OnDialogClickListener onDialogClickListener) {
        this.f19035b = heavyBubbleDialog;
        this.f19036c = onDialogClickListener;
    }

    public final void onClick(View view) {
        this.f19035b.lambda$setPosListener$2(this.f19036c, view);
    }
}
