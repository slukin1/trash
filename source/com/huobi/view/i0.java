package com.huobi.view;

import android.view.View;
import com.huobi.view.HeavyBubbleDialog;

public final /* synthetic */ class i0 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HeavyBubbleDialog f19047b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ HeavyBubbleDialog.Builder.OnDialogClickListener f19048c;

    public /* synthetic */ i0(HeavyBubbleDialog heavyBubbleDialog, HeavyBubbleDialog.Builder.OnDialogClickListener onDialogClickListener) {
        this.f19047b = heavyBubbleDialog;
        this.f19048c = onDialogClickListener;
    }

    public final void onClick(View view) {
        this.f19047b.lambda$setMoreListener$1(this.f19048c, view);
    }
}
