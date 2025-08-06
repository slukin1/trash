package ks;

import android.view.View;
import androidx.fragment.app.DialogFragment;
import com.huobi.view.HeavyBubbleDialog;
import com.huobi.view.HighLightPopup;

public final /* synthetic */ class f implements HeavyBubbleDialog.Builder.OnDialogClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HighLightPopup f57986a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f57987b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f57988c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ View.OnClickListener f57989d;

    public /* synthetic */ f(HighLightPopup highLightPopup, View view, boolean z11, View.OnClickListener onClickListener) {
        this.f57986a = highLightPopup;
        this.f57987b = view;
        this.f57988c = z11;
        this.f57989d = onClickListener;
    }

    public final void onDialogClick(DialogFragment dialogFragment, View view) {
        g.m(this.f57986a, this.f57987b, this.f57988c, this.f57989d, dialogFragment, view);
    }
}
