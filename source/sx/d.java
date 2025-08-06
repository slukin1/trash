package sx;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import vx.c;

public abstract class d implements a {

    /* renamed from: a  reason: collision with root package name */
    public Reference<View> f29274a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f29275b;

    public d(View view, boolean z11) {
        if (view != null) {
            this.f29274a = new WeakReference(view);
            this.f29275b = z11;
            return;
        }
        throw new IllegalArgumentException("view must not be null");
    }

    public ViewScaleType a() {
        return ViewScaleType.CROP;
    }

    public boolean b(Bitmap bitmap) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            View view = this.f29274a.get();
            if (view != null) {
                f(bitmap, view);
                return true;
            }
        } else {
            c.f("Can't set a bitmap into view. You should call ImageLoader on UI thread for it.", new Object[0]);
        }
        return false;
    }

    public View c() {
        return this.f29274a.get();
    }

    public boolean d(Drawable drawable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            View view = this.f29274a.get();
            if (view != null) {
                g(drawable, view);
                return true;
            }
        } else {
            c.f("Can't set a drawable into view. You should call ImageLoader on UI thread for it.", new Object[0]);
        }
        return false;
    }

    public boolean e() {
        return this.f29274a.get() == null;
    }

    public abstract void f(Bitmap bitmap, View view);

    public abstract void g(Drawable drawable, View view);

    public int getHeight() {
        View view = this.f29274a.get();
        int i11 = 0;
        if (view == null) {
            return 0;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(!this.f29275b || layoutParams == null || layoutParams.height == -2)) {
            i11 = view.getHeight();
        }
        return (i11 > 0 || layoutParams == null) ? i11 : layoutParams.height;
    }

    public int getId() {
        View view = this.f29274a.get();
        return view == null ? super.hashCode() : view.hashCode();
    }

    public int getWidth() {
        View view = this.f29274a.get();
        int i11 = 0;
        if (view == null) {
            return 0;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(!this.f29275b || layoutParams == null || layoutParams.width == -2)) {
            i11 = view.getWidth();
        }
        return (i11 > 0 || layoutParams == null) ? i11 : layoutParams.width;
    }
}
