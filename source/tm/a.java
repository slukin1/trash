package tm;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.TypedValue;
import com.huawei.face.antispoofing.utils.ThreadUtils;
import java.util.Objects;

public class a extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    public Paint f76579a;

    /* renamed from: b  reason: collision with root package name */
    public Paint f76580b;

    /* renamed from: c  reason: collision with root package name */
    public Paint f76581c;

    /* renamed from: d  reason: collision with root package name */
    public TextPaint f76582d;

    /* renamed from: e  reason: collision with root package name */
    public Path f76583e;

    /* renamed from: f  reason: collision with root package name */
    public int f76584f;

    /* renamed from: g  reason: collision with root package name */
    public int f76585g;

    /* renamed from: h  reason: collision with root package name */
    public int f76586h;

    /* renamed from: i  reason: collision with root package name */
    public volatile String f76587i;

    /* renamed from: j  reason: collision with root package name */
    public RectF f76588j;

    /* renamed from: k  reason: collision with root package name */
    public int f76589k;

    /* renamed from: l  reason: collision with root package name */
    public Xfermode f76590l;

    /* renamed from: tm.a$a  reason: collision with other inner class name */
    public class C0822a implements Runnable {
        public C0822a() {
        }

        public void run() {
            a.this.invalidateSelf();
        }
    }

    public a(Drawable drawable, Activity activity) {
        this.f76583e = new Path();
        this.f76589k = -1;
        this.f76590l = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        Paint paint = new Paint(1);
        this.f76579a = paint;
        paint.setColor(-1);
        Paint paint2 = new Paint();
        this.f76580b = paint2;
        paint2.setColor(Color.parseColor("#52000000"));
        this.f76580b.setAntiAlias(true);
        this.f76580b.setStyle(Paint.Style.FILL);
        Paint paint3 = new Paint();
        this.f76581c = paint3;
        paint3.setColor(-1);
        this.f76581c.setTextSize(50.0f);
        TextPaint textPaint = new TextPaint();
        this.f76582d = textPaint;
        textPaint.setColor(-1);
        this.f76582d.setAntiAlias(true);
        this.f76582d.setTextSize(TypedValue.applyDimension(2, (float) 18, activity.getResources().getDisplayMetrics()));
    }

    public void a(String str) {
        String str2 = this.f76587i;
        this.f76587i = str;
        if (!Objects.equals(str2, this.f76587i)) {
            ThreadUtils.getInstance().runOnUiThread(new C0822a());
        }
    }

    public void draw(Canvas canvas) {
        Path path = this.f76583e;
        if (path == null || path.isEmpty()) {
            canvas.drawColor(this.f76589k);
            return;
        }
        canvas.drawColor(this.f76589k);
        this.f76579a.setXfermode(this.f76590l);
        canvas.drawPath(this.f76583e, this.f76579a);
        this.f76579a.setXfermode((Xfermode) null);
        String str = this.f76587i;
        if (str != null && !str.equals("")) {
            StaticLayout staticLayout = new StaticLayout(str, this.f76582d, (int) (((double) this.f76586h) * 1.2d), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
            int lineCount = staticLayout.getLineCount();
            canvas.drawArc(this.f76588j, (float) (225 - (lineCount * 10)), (float) ((lineCount * 20) + 90), false, this.f76580b);
            canvas.save();
            int i11 = this.f76586h;
            canvas.translate(((float) this.f76584f) - (((float) i11) * 0.6f), ((float) this.f76585g) - (((float) i11) * 0.8f));
            staticLayout.draw(canvas);
        }
    }

    public int getOpacity() {
        return -1;
    }

    public void setAlpha(int i11) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public a(Drawable drawable, Activity activity, int i11, int i12, int i13) {
        this(drawable, activity);
        this.f76584f = i11;
        this.f76585g = i12;
        this.f76586h = i13;
        this.f76588j = new RectF((float) (i11 - i13), (float) (i12 - i13), (float) (i11 + i13), (float) (i12 + i13));
        this.f76583e.addCircle((float) i11, (float) i12, (float) i13, Path.Direction.CW);
    }
}
