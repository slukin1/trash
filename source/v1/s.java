package v1;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

public class s implements t {

    /* renamed from: a  reason: collision with root package name */
    public final ViewOverlay f16689a;

    public s(View view) {
        this.f16689a = view.getOverlay();
    }

    public void add(Drawable drawable) {
        this.f16689a.add(drawable);
    }

    public void remove(Drawable drawable) {
        this.f16689a.remove(drawable);
    }
}
