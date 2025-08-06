package wn;

import android.app.Activity;
import android.view.View;
import java.util.List;

public final /* synthetic */ class t implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ b0 f61478b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Activity f61479c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ List f61480d;

    public /* synthetic */ t(b0 b0Var, Activity activity, List list) {
        this.f61478b = b0Var;
        this.f61479c = activity;
        this.f61480d = list;
    }

    public final void onClick(View view) {
        this.f61478b.E(this.f61479c, this.f61480d, view);
    }
}
