package com.huobi.trade.helper;

import android.view.View;
import androidx.fragment.app.DialogFragment;
import com.huobi.view.HeavyBubbleDialog;
import com.huobi.view.HighLightPopup;

public final /* synthetic */ class d0 implements HeavyBubbleDialog.Builder.OnDialogClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f82025a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HighLightPopup f82026b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f82027c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ View.OnClickListener f82028d;

    public /* synthetic */ d0(int i11, HighLightPopup highLightPopup, View view, View.OnClickListener onClickListener) {
        this.f82025a = i11;
        this.f82026b = highLightPopup;
        this.f82027c = view;
        this.f82028d = onClickListener;
    }

    public final void onDialogClick(DialogFragment dialogFragment, View view) {
        f0.j(this.f82025a, this.f82026b, this.f82027c, this.f82028d, dialogFragment, view);
    }
}
