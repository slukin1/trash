package rr;

import android.view.View;
import com.huobi.sharev2.fragment.NewPreviewFragment;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NewPreviewFragment f25795b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f25796c;

    public /* synthetic */ f(NewPreviewFragment newPreviewFragment, View view) {
        this.f25795b = newPreviewFragment;
        this.f25796c = view;
    }

    public final void run() {
        this.f25795b.sh(this.f25796c);
    }
}
