package z9;

import android.view.View;
import c6.b;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;

public final /* synthetic */ class c implements b {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BaseDialogFragment f62028b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f62029c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f62030d;

    public /* synthetic */ c(BaseDialogFragment baseDialogFragment, View view, int i11) {
        this.f62028b = baseDialogFragment;
        this.f62029c = view;
        this.f62030d = i11;
    }

    public final void onCallback(Object obj) {
        this.f62028b.lambda$doDefaultShowAnimation$2(this.f62029c, this.f62030d, (View) obj);
    }
}
