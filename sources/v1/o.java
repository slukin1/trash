package v1;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

public class o implements p {

    /* renamed from: a  reason: collision with root package name */
    public final ViewGroupOverlay f16680a;

    public o(ViewGroup viewGroup) {
        this.f16680a = viewGroup.getOverlay();
    }

    public void add(Drawable drawable) {
        this.f16680a.add(drawable);
    }

    public void remove(Drawable drawable) {
        this.f16680a.remove(drawable);
    }

    public void add(View view) {
        this.f16680a.add(view);
    }

    public void remove(View view) {
        this.f16680a.remove(view);
    }
}
