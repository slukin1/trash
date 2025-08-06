package ks;

import android.view.View;
import androidx.fragment.app.DialogFragment;
import com.huobi.view.HeavyBubbleDialog;
import com.huobi.view.HighLightPopup;

public final /* synthetic */ class e implements HeavyBubbleDialog.Builder.OnDialogClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HighLightPopup f57984a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f57985b;

    public /* synthetic */ e(HighLightPopup highLightPopup, View view) {
        this.f57984a = highLightPopup;
        this.f57985b = view;
    }

    public final void onDialogClick(DialogFragment dialogFragment, View view) {
        g.n(this.f57984a, this.f57985b, dialogFragment, view);
    }
}
