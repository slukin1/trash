package ej;

import android.view.View;
import androidx.fragment.app.DialogFragment;
import com.huobi.view.HeavyBubbleDialog;
import com.huobi.view.HighLightPopup;

public final /* synthetic */ class h implements HeavyBubbleDialog.Builder.OnDialogClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HighLightPopup f54334a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f54335b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View.OnClickListener f54336c;

    public /* synthetic */ h(HighLightPopup highLightPopup, View view, View.OnClickListener onClickListener) {
        this.f54334a = highLightPopup;
        this.f54335b = view;
        this.f54336c = onClickListener;
    }

    public final void onDialogClick(DialogFragment dialogFragment, View view) {
        j.e(this.f54334a, this.f54335b, this.f54336c, dialogFragment, view);
    }
}
