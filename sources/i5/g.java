package i5;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import e5.d;
import g5.e;

public abstract class g extends o {

    /* renamed from: b  reason: collision with root package name */
    public ChartAnimator f66316b;

    /* renamed from: c  reason: collision with root package name */
    public Paint f66317c;

    /* renamed from: d  reason: collision with root package name */
    public Paint f66318d;

    /* renamed from: e  reason: collision with root package name */
    public Paint f66319e = new Paint(4);

    /* renamed from: f  reason: collision with root package name */
    public Paint f66320f;

    public g(ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(viewPortHandler);
        this.f66316b = chartAnimator;
        Paint paint = new Paint(1);
        this.f66317c = paint;
        paint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint(1);
        this.f66320f = paint2;
        paint2.setColor(Color.rgb(63, 63, 63));
        this.f66320f.setTextAlign(Paint.Align.CENTER);
        this.f66320f.setTextSize(Utils.e(9.0f));
        Paint paint3 = new Paint(1);
        this.f66318d = paint3;
        paint3.setStyle(Paint.Style.STROKE);
        this.f66318d.setStrokeWidth(2.0f);
        this.f66318d.setColor(Color.rgb(255, 187, 115));
    }

    public void a(e eVar) {
        this.f66320f.setTypeface(eVar.getValueTypeface());
        this.f66320f.setTextSize(eVar.getValueTextSize());
    }

    public abstract void b(Canvas canvas);

    public abstract void c(Canvas canvas);

    public abstract void d(Canvas canvas, d[] dVarArr);

    public void e(Canvas canvas, d5.e eVar, float f11, Entry entry, int i11, float f12, float f13, int i12) {
        this.f66320f.setColor(i12);
        canvas.drawText(eVar.b(f11, entry, i11, this.f66370a), f12, f13, this.f66320f);
    }

    public abstract void f(Canvas canvas);

    public abstract void g();

    public boolean h(f5.e eVar) {
        return ((float) eVar.getData().h()) < ((float) eVar.getMaxVisibleCount()) * this.f66370a.q();
    }
}
