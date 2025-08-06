package com.huobi.view;

import android.view.View;
import com.huobi.view.AssetHeavyBubbleDialog;

public final /* synthetic */ class l implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetHeavyBubbleDialog f19064b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AssetHeavyBubbleDialog.Builder.OnDialogClickListener f19065c;

    public /* synthetic */ l(AssetHeavyBubbleDialog assetHeavyBubbleDialog, AssetHeavyBubbleDialog.Builder.OnDialogClickListener onDialogClickListener) {
        this.f19064b = assetHeavyBubbleDialog;
        this.f19065c = onDialogClickListener;
    }

    public final void onClick(View view) {
        this.f19064b.lambda$setPosListener$0(this.f19065c, view);
    }
}
