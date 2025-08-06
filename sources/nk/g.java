package nk;

import android.view.View;
import com.huobi.feature.ui.LeverSelectDialogFragment;
import nk.e;

public final /* synthetic */ class g implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ e.c f58547b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f58548c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f58549d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f58550e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ LeverSelectDialogFragment f58551f;

    public /* synthetic */ g(e.c cVar, String str, String str2, int i11, LeverSelectDialogFragment leverSelectDialogFragment) {
        this.f58547b = cVar;
        this.f58548c = str;
        this.f58549d = str2;
        this.f58550e = i11;
        this.f58551f = leverSelectDialogFragment;
    }

    public final void onClick(View view) {
        this.f58547b.f(this.f58548c, this.f58549d, this.f58550e, this.f58551f, view);
    }
}
