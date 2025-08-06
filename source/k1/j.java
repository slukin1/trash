package k1;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import androidx.emoji2.text.EmojiCompat;

public final class j extends e {

    /* renamed from: g  reason: collision with root package name */
    public static Paint f16033g;

    public j(d dVar) {
        super(dVar);
    }

    public static Paint c() {
        if (f16033g == null) {
            TextPaint textPaint = new TextPaint();
            f16033g = textPaint;
            textPaint.setColor(EmojiCompat.b().c());
            f16033g.setStyle(Paint.Style.FILL);
        }
        return f16033g;
    }

    public void draw(Canvas canvas, @SuppressLint({"UnknownNullness"}) CharSequence charSequence, int i11, int i12, float f11, int i13, int i14, int i15, Paint paint) {
        if (EmojiCompat.b().i()) {
            canvas.drawRect(f11, (float) i13, f11 + ((float) b()), (float) i15, c());
        }
        a().a(canvas, f11, (float) i14, paint);
    }
}
