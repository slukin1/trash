package qk;

import android.view.View;
import com.huobi.feature.util.FutureLimitOrderEditDialogHelper;

public final /* synthetic */ class q implements View.OnFocusChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f59989b;

    public /* synthetic */ q(View view) {
        this.f59989b = view;
    }

    public final void onFocusChange(View view, boolean z11) {
        FutureLimitOrderEditDialogHelper.p(this.f59989b, view, z11);
    }
}
