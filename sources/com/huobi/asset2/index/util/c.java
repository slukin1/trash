package com.huobi.asset2.index.util;

import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.huobi.view.AssetHeavyBubbleDialog;
import com.huobi.view.HighLightPopup;
import d10.a;

public final /* synthetic */ class c implements AssetHeavyBubbleDialog.Builder.OnDialogClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f42772a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HighLightPopup f42773b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f42774c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ a f42775d;

    public /* synthetic */ c(FragmentActivity fragmentActivity, HighLightPopup highLightPopup, String str, a aVar) {
        this.f42772a = fragmentActivity;
        this.f42773b = highLightPopup;
        this.f42774c = str;
        this.f42775d = aVar;
    }

    public final void onDialogClick(DialogFragment dialogFragment, View view) {
        d.e(this.f42772a, this.f42773b, this.f42774c, this.f42775d, dialogFragment, view);
    }
}
