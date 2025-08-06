package al;

import android.app.Activity;
import android.view.View;

public final /* synthetic */ class e implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Activity f3559b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f3560c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f3561d;

    public /* synthetic */ e(Activity activity, String str, String str2) {
        this.f3559b = activity;
        this.f3560c = str;
        this.f3561d = str2;
    }

    public final void onClick(View view) {
        i.q(this.f3559b, this.f3560c, this.f3561d, view);
    }
}
