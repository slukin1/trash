package sx;

import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import java.lang.reflect.Field;
import vx.c;

public class b extends d {
    public b(ImageView imageView, boolean z11) {
        super(imageView, z11);
    }

    public static int h(Object obj, String str) {
        try {
            Field declaredField = ImageView.class.getDeclaredField(str);
            declaredField.setAccessible(true);
            int intValue = ((Integer) declaredField.get(obj)).intValue();
            if (intValue <= 0 || intValue >= Integer.MAX_VALUE) {
                return 0;
            }
            return intValue;
        } catch (Exception e11) {
            c.c(e11);
            return 0;
        }
    }

    public ViewScaleType a() {
        ImageView imageView = (ImageView) this.f29274a.get();
        if (imageView != null) {
            return ViewScaleType.fromImageView(imageView);
        }
        return super.a();
    }

    public void f(Bitmap bitmap, View view) {
        ((ImageView) view).setImageBitmap(bitmap);
    }

    public void g(Drawable drawable, View view) {
        ((ImageView) view).setImageDrawable(drawable);
        if (drawable instanceof AnimationDrawable) {
            ((AnimationDrawable) drawable).start();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r1 = (android.widget.ImageView) r2.f29274a.get();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int getHeight() {
        /*
            r2 = this;
            int r0 = super.getHeight()
            if (r0 > 0) goto L_0x0016
            java.lang.ref.Reference<android.view.View> r1 = r2.f29274a
            java.lang.Object r1 = r1.get()
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            if (r1 == 0) goto L_0x0016
            java.lang.String r0 = "mMaxHeight"
            int r0 = h(r1, r0)
        L_0x0016:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: sx.b.getHeight():int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r1 = (android.widget.ImageView) r2.f29274a.get();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int getWidth() {
        /*
            r2 = this;
            int r0 = super.getWidth()
            if (r0 > 0) goto L_0x0016
            java.lang.ref.Reference<android.view.View> r1 = r2.f29274a
            java.lang.Object r1 = r1.get()
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            if (r1 == 0) goto L_0x0016
            java.lang.String r0 = "mMaxWidth"
            int r0 = h(r1, r0)
        L_0x0016:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: sx.b.getWidth():int");
    }

    /* renamed from: i */
    public ImageView c() {
        return (ImageView) super.c();
    }
}
