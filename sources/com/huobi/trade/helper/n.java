package com.huobi.trade.helper;

import android.view.View;
import androidx.fragment.app.DialogFragment;
import com.huobi.view.HeavyBubbleDialog;
import com.huobi.view.HighLightPopup;

public final /* synthetic */ class n implements HeavyBubbleDialog.Builder.OnDialogClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HighLightPopup f82064a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f82065b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View.OnClickListener f82066c;

    public /* synthetic */ n(HighLightPopup highLightPopup, View view, View.OnClickListener onClickListener) {
        this.f82064a = highLightPopup;
        this.f82065b = view;
        this.f82066c = onClickListener;
    }

    public final void onDialogClick(DialogFragment dialogFragment, View view) {
        o.c(this.f82064a, this.f82065b, this.f82066c, dialogFragment, view);
    }
}
