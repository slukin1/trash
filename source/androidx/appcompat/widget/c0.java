package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

public class c0 extends w {

    /* renamed from: b  reason: collision with root package name */
    public final WeakReference<Context> f4548b;

    public c0(Context context, Resources resources) {
        super(resources);
        this.f4548b = new WeakReference<>(context);
    }

    public Drawable getDrawable(int i11) throws Resources.NotFoundException {
        Drawable a11 = a(i11);
        Context context = (Context) this.f4548b.get();
        if (!(a11 == null || context == null)) {
            ResourceManagerInternal.h().x(context, i11, a11);
        }
        return a11;
    }
}
