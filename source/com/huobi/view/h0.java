package com.huobi.view;

import android.view.View;
import com.huobi.view.HeavyBubbleDialog;

public final /* synthetic */ class h0 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HeavyBubbleDialog f19041b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ HeavyBubbleDialog.Builder.OnDialogClickListener f19042c;

    public /* synthetic */ h0(HeavyBubbleDialog heavyBubbleDialog, HeavyBubbleDialog.Builder.OnDialogClickListener onDialogClickListener) {
        this.f19041b = heavyBubbleDialog;
        this.f19042c = onDialogClickListener;
    }

    public final void onClick(View view) {
        this.f19041b.lambda$setNegListener$0(this.f19042c, view);
    }
}
