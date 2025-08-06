package oupson.apng;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0006H\u0016J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\r\u001a\u00020\u0006H\u0016J\b\u0010\u000e\u001a\u00020\u0006H\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0016R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Loupson/apng/a;", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/Canvas;", "canvas", "", "draw", "", "getOpacity", "alpha", "setAlpha", "Landroid/graphics/ColorFilter;", "cf", "setColorFilter", "getIntrinsicWidth", "getIntrinsicHeight", "getMinimumWidth", "getMinimumHeight", "Landroid/graphics/Bitmap;", "a", "Landroid/graphics/Bitmap;", "bitmap", "<init>", "(Landroid/graphics/Bitmap;)V", "apng_library_release"}, k = 1, mv = {1, 4, 2})
public final class a extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    public final Bitmap f52934a;

    public a(Bitmap bitmap) {
        this.f52934a = bitmap;
    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(this.f52934a, 0.0f, 0.0f, (Paint) null);
    }

    public int getIntrinsicHeight() {
        return this.f52934a.getHeight();
    }

    public int getIntrinsicWidth() {
        return this.f52934a.getWidth();
    }

    public int getMinimumHeight() {
        return this.f52934a.getHeight();
    }

    public int getMinimumWidth() {
        return this.f52934a.getWidth();
    }

    public int getOpacity() {
        return -3;
    }

    public void setAlpha(int i11) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }
}
