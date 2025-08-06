package com.huobi.trade.helper;

import android.view.View;
import androidx.fragment.app.DialogFragment;
import com.huobi.view.HeavyBubbleDialog;
import com.huobi.view.HighLightPopup;

public final /* synthetic */ class e0 implements HeavyBubbleDialog.Builder.OnDialogClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HighLightPopup f82030a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f82031b;

    public /* synthetic */ e0(HighLightPopup highLightPopup, View view) {
        this.f82030a = highLightPopup;
        this.f82031b = view;
    }

    public final void onDialogClick(DialogFragment dialogFragment, View view) {
        f0.k(this.f82030a, this.f82031b, dialogFragment, view);
    }
}
