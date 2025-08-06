package ej;

import android.view.View;
import androidx.fragment.app.DialogFragment;
import com.huobi.view.HeavyBubbleDialog;
import com.huobi.view.HighLightPopup;

public final /* synthetic */ class i implements HeavyBubbleDialog.Builder.OnDialogClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HighLightPopup f54337a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f54338b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ HeavyBubbleDialog.Builder.OnDialogClickListener f54339c;

    public /* synthetic */ i(HighLightPopup highLightPopup, View view, HeavyBubbleDialog.Builder.OnDialogClickListener onDialogClickListener) {
        this.f54337a = highLightPopup;
        this.f54338b = view;
        this.f54339c = onDialogClickListener;
    }

    public final void onDialogClick(DialogFragment dialogFragment, View view) {
        j.d(this.f54337a, this.f54338b, this.f54339c, dialogFragment, view);
    }
}
