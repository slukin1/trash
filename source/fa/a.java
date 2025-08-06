package fa;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.style.ReplacementSpan;
import com.hbg.lib.common.utils.PixelUtils;
import i6.d;
import java.lang.ref.SoftReference;

public class a extends ReplacementSpan {

    /* renamed from: b  reason: collision with root package name */
    public SoftReference<Context> f76171b;

    /* renamed from: c  reason: collision with root package name */
    public int f76172c;

    /* renamed from: d  reason: collision with root package name */
    public int f76173d;

    /* renamed from: e  reason: collision with root package name */
    public int f76174e;

    /* renamed from: f  reason: collision with root package name */
    public int f76175f;

    /* renamed from: g  reason: collision with root package name */
    public int f76176g;

    /* renamed from: h  reason: collision with root package name */
    public int f76177h;

    /* renamed from: i  reason: collision with root package name */
    public int f76178i;

    /* renamed from: j  reason: collision with root package name */
    public int f76179j = PixelUtils.a(8.0f);

    /* renamed from: k  reason: collision with root package name */
    public int f76180k = PixelUtils.a(4.0f);

    /* renamed from: l  reason: collision with root package name */
    public int f76181l = PixelUtils.a(5.0f);

    public a(Context context, int i11, int i12, int i13, int i14, int i15, int i16) {
        this.f76171b = new SoftReference<>(context);
        this.f76173d = i11;
        this.f76174e = i12;
        this.f76175f = i13;
        this.f76176g = i14;
        this.f76177h = i15;
        this.f76178i = i16;
    }

    public static Bitmap a(Bitmap bitmap, int i11, int i12) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(((float) i11) / ((float) width), ((float) i12) / ((float) height));
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public void draw(Canvas canvas, CharSequence charSequence, int i11, int i12, float f11, int i13, int i14, int i15, Paint paint) {
        Canvas canvas2 = canvas;
        float f12 = f11;
        Paint paint2 = paint;
        float f13 = (float) i14;
        float descent = (float) (((double) (((paint.descent() - paint.ascent()) + f13) - paint.descent())) * 0.5d);
        d.b("#@### ExpandableSpan asccent: " + paint.ascent() + ", descent: " + paint.descent());
        int i16 = this.f76177h;
        if (i16 != 0) {
            paint2.setColor(i16);
            paint2.setAntiAlias(true);
            RectF rectF = new RectF(f12, 1.0f, ((float) this.f76172c) + f12, f13 + paint.descent());
            int i17 = this.f76178i;
            canvas.drawRoundRect(rectF, (float) i17, (float) i17, paint2);
        }
        Context context = this.f76171b.get();
        if (context != null) {
            Bitmap a11 = a(BitmapFactory.decodeResource(context.getResources(), this.f76173d), this.f76174e, this.f76175f);
            canvas.drawBitmap(a11, ((float) this.f76179j) + f12, (float) (this.f76180k + 1), (Paint) null);
            if (!a11.isRecycled()) {
                a11.recycle();
            }
        }
        paint2.setColor(this.f76176g);
        canvas.drawText(charSequence, i11, i12, f12 + ((float) this.f76179j) + ((float) this.f76181l) + ((float) this.f76174e), descent, paint);
    }

    public int getSize(Paint paint, CharSequence charSequence, int i11, int i12, Paint.FontMetricsInt fontMetricsInt) {
        int measureText = (int) (paint.measureText(charSequence, i11, i12) + ((float) (this.f76179j * 2)) + ((float) this.f76181l) + ((float) this.f76174e));
        this.f76172c = measureText;
        return measureText;
    }
}
