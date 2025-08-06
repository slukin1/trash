package pk;

import android.view.View;
import com.huobi.feature.ui.LeverSelectDialogFragment;

public final /* synthetic */ class f3 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LeverSelectDialogFragment.e f53080b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f53081c;

    public /* synthetic */ f3(LeverSelectDialogFragment.e eVar, String str) {
        this.f53080b = eVar;
        this.f53081c = str;
    }

    public final void onClick(View view) {
        this.f53080b.f(this.f53081c, view);
    }
}
