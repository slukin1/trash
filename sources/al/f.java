package al;

import android.app.Activity;
import android.view.View;

public final /* synthetic */ class f implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Activity f3562b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f3563c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f3564d;

    public /* synthetic */ f(Activity activity, String str, String str2) {
        this.f3562b = activity;
        this.f3563c = str;
        this.f3564d = str2;
    }

    public final void onClick(View view) {
        i.p(this.f3562b, this.f3563c, this.f3564d, view);
    }
}
