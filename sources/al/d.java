package al;

import android.app.Activity;
import android.view.View;

public final /* synthetic */ class d implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Activity f3556b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f3557c;

    public /* synthetic */ d(Activity activity, String str) {
        this.f3556b = activity;
        this.f3557c = str;
    }

    public final void onClick(View view) {
        i.n(this.f3556b, this.f3557c, view);
    }
}
