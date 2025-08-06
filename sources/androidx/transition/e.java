package androidx.transition;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import v1.p;

public class e extends ViewOverlayApi14 implements p {
    public e(Context context, ViewGroup viewGroup, View view) {
        super(context, viewGroup, view);
    }

    public static e c(ViewGroup viewGroup) {
        return (e) ViewOverlayApi14.a(viewGroup);
    }

    public void add(View view) {
        this.f11868a.b(view);
    }

    public void remove(View view) {
        this.f11868a.g(view);
    }
}
