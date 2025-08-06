package sx;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;

public class c implements a {

    /* renamed from: a  reason: collision with root package name */
    public final String f29271a;

    /* renamed from: b  reason: collision with root package name */
    public final ox.c f29272b;

    /* renamed from: c  reason: collision with root package name */
    public final ViewScaleType f29273c;

    public c(String str, ox.c cVar, ViewScaleType viewScaleType) {
        if (cVar == null) {
            throw new IllegalArgumentException("imageSize must not be null");
        } else if (viewScaleType != null) {
            this.f29271a = str;
            this.f29272b = cVar;
            this.f29273c = viewScaleType;
        } else {
            throw new IllegalArgumentException("scaleType must not be null");
        }
    }

    public ViewScaleType a() {
        return this.f29273c;
    }

    public boolean b(Bitmap bitmap) {
        return true;
    }

    public View c() {
        return null;
    }

    public boolean d(Drawable drawable) {
        return true;
    }

    public boolean e() {
        return false;
    }

    public int getHeight() {
        return this.f29272b.a();
    }

    public int getId() {
        return TextUtils.isEmpty(this.f29271a) ? super.hashCode() : this.f29271a.hashCode();
    }

    public int getWidth() {
        return this.f29272b.b();
    }
}
