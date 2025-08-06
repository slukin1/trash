package zendesk.commonui;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import com.squareup.picasso.x;
import java.util.Locale;

public class a {

    /* renamed from: zendesk.commonui.a$a  reason: collision with other inner class name */
    public static class C0693a implements x {

        /* renamed from: a  reason: collision with root package name */
        public final int f62926a;

        /* renamed from: b  reason: collision with root package name */
        public final int f62927b;

        /* renamed from: c  reason: collision with root package name */
        public final int f62928c;

        public C0693a(int i11, int i12, int i13) {
            this.f62926a = i11;
            this.f62928c = i12;
            this.f62927b = i13;
        }

        public final RectF a(int i11, int i12, int i13) {
            float f11 = (float) i13;
            return new RectF(f11, f11, (float) (i11 - i13), (float) (i12 - i13));
        }

        public final Paint b(Bitmap bitmap) {
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            paint.setShader(new BitmapShader(bitmap, tileMode, tileMode));
            return paint;
        }

        public final Paint c() {
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(this.f62928c);
            return paint;
        }

        public String key() {
            return String.format(Locale.US, "rounded-%s-%s-%s", new Object[]{Integer.valueOf(this.f62926a), Integer.valueOf(this.f62928c), Integer.valueOf(this.f62927b)});
        }

        public Bitmap transform(Bitmap bitmap) {
            if (this.f62927b > 0) {
                Canvas canvas = new Canvas(bitmap);
                Paint c11 = c();
                Path path = new Path();
                path.setFillType(Path.FillType.INVERSE_EVEN_ODD);
                RectF a11 = a(bitmap.getWidth(), bitmap.getHeight(), this.f62927b);
                int i11 = this.f62926a;
                path.addRoundRect(a11, (float) i11, (float) i11, Path.Direction.CW);
                canvas.drawPath(path, c11);
            }
            Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(createBitmap);
            Paint b11 = b(bitmap);
            RectF a12 = a(bitmap.getWidth(), bitmap.getHeight(), 0);
            int i12 = this.f62926a;
            canvas2.drawRoundRect(a12, (float) i12, (float) i12, b11);
            if (bitmap != createBitmap) {
                bitmap.recycle();
            }
            return createBitmap;
        }
    }

    public static x a(int i11, int i12, int i13) {
        return new C0693a(i11, i12, i13);
    }
}
