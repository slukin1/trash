package h0;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import h0.g;

public class a extends c {

    /* renamed from: h0.a$a  reason: collision with other inner class name */
    public class C0083a implements g.a {
        public C0083a() {
        }

        public void a(Canvas canvas, RectF rectF, float f11, Paint paint) {
            canvas.drawRoundRect(rectF, f11, f11, paint);
        }
    }

    public void k() {
        g.f15882r = new C0083a();
    }
}
