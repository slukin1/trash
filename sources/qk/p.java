package qk;

import android.view.View;
import com.huobi.feature.util.FutureLimitOrderEditDialogHelper;

public final /* synthetic */ class p implements View.OnFocusChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f59987b;

    public /* synthetic */ p(View view) {
        this.f59987b = view;
    }

    public final void onFocusChange(View view, boolean z11) {
        FutureLimitOrderEditDialogHelper.o(this.f59987b, view, z11);
    }
}
