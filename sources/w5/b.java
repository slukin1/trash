package w5;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DrawFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat$AnimationCallback;
import com.hbg.lib.apng.decode.FrameSeqDecoder;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public abstract class b<Decoder extends FrameSeqDecoder> extends Drawable implements Animatable, FrameSeqDecoder.j {

    /* renamed from: b  reason: collision with root package name */
    public final Paint f16749b;

    /* renamed from: c  reason: collision with root package name */
    public final Decoder f16750c;

    /* renamed from: d  reason: collision with root package name */
    public final DrawFilter f16751d = new PaintFlagsDrawFilter(0, 3);

    /* renamed from: e  reason: collision with root package name */
    public final Matrix f16752e = new Matrix();

    /* renamed from: f  reason: collision with root package name */
    public final Set<Animatable2Compat$AnimationCallback> f16753f = new HashSet();

    /* renamed from: g  reason: collision with root package name */
    public Bitmap f16754g;

    /* renamed from: h  reason: collision with root package name */
    public final Handler f16755h = new a(Looper.getMainLooper());

    /* renamed from: i  reason: collision with root package name */
    public final Runnable f16756i = new C0110b();

    /* renamed from: j  reason: collision with root package name */
    public boolean f16757j = true;

    /* renamed from: k  reason: collision with root package name */
    public final Set<WeakReference<Drawable.Callback>> f16758k = new HashSet();

    /* renamed from: l  reason: collision with root package name */
    public boolean f16759l = false;

    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            int i11 = message.what;
            if (i11 == 1) {
                Iterator it2 = new ArrayList(b.this.f16753f).iterator();
                while (it2.hasNext()) {
                    ((Animatable2Compat$AnimationCallback) it2.next()).onAnimationStart(b.this);
                }
            } else if (i11 == 2) {
                Iterator it3 = new ArrayList(b.this.f16753f).iterator();
                while (it3.hasNext()) {
                    ((Animatable2Compat$AnimationCallback) it3.next()).onAnimationEnd(b.this);
                }
            }
        }
    }

    /* renamed from: w5.b$b  reason: collision with other inner class name */
    public class C0110b implements Runnable {
        public C0110b() {
        }

        public void run() {
            b.this.invalidateSelf();
        }
    }

    public b(a6.b bVar) {
        Paint paint = new Paint();
        this.f16749b = paint;
        paint.setAntiAlias(true);
        this.f16750c = d(bVar, this);
    }

    public void a() {
        Message.obtain(this.f16755h, 2).sendToTarget();
    }

    public void b(ByteBuffer byteBuffer) {
        if (isRunning()) {
            Bitmap bitmap = this.f16754g;
            if (bitmap == null || bitmap.isRecycled()) {
                this.f16754g = Bitmap.createBitmap(this.f16750c.r().width() / this.f16750c.y(), this.f16750c.r().height() / this.f16750c.y(), Bitmap.Config.ARGB_8888);
            }
            byteBuffer.rewind();
            if (byteBuffer.remaining() < this.f16754g.getByteCount()) {
                Log.e("wuxinrong", "onRender:Buffer not large enough for pixels");
                return;
            }
            this.f16754g.copyPixelsFromBuffer(byteBuffer);
            this.f16755h.post(this.f16756i);
        }
    }

    public abstract Decoder d(a6.b bVar, FrameSeqDecoder.j jVar);

    public void draw(Canvas canvas) {
        Bitmap bitmap = this.f16754g;
        if (bitmap != null && !bitmap.isRecycled()) {
            canvas.setDrawFilter(this.f16751d);
            canvas.drawBitmap(this.f16754g, this.f16752e, this.f16749b);
        }
    }

    public final void e() {
        ArrayList<WeakReference> arrayList = new ArrayList<>();
        Drawable.Callback callback = getCallback();
        boolean z11 = false;
        for (WeakReference next : this.f16758k) {
            Drawable.Callback callback2 = (Drawable.Callback) next.get();
            if (callback2 == null) {
                arrayList.add(next);
            } else if (callback2 == callback) {
                z11 = true;
            } else {
                callback2.invalidateDrawable(this);
            }
        }
        for (WeakReference remove : arrayList) {
            this.f16758k.remove(remove);
        }
        if (!z11) {
            this.f16758k.add(new WeakReference(callback));
        }
    }

    public final void f() {
        this.f16750c.o(this);
        if (this.f16757j) {
            this.f16750c.M();
        } else if (!this.f16750c.D()) {
            this.f16750c.M();
        }
    }

    public final void g() {
        this.f16750c.I(this);
        if (this.f16757j) {
            this.f16750c.O();
        } else {
            this.f16750c.P();
        }
    }

    public Drawable.Callback getCallback() {
        return super.getCallback();
    }

    public int getIntrinsicHeight() {
        if (this.f16759l) {
            return -1;
        }
        try {
            return this.f16750c.r().height();
        } catch (Exception unused) {
            return 0;
        }
    }

    public int getIntrinsicWidth() {
        if (this.f16759l) {
            return -1;
        }
        try {
            return this.f16750c.r().width();
        } catch (Exception unused) {
            return 0;
        }
    }

    public int getOpacity() {
        return -3;
    }

    public void invalidateSelf() {
        super.invalidateSelf();
        for (WeakReference<Drawable.Callback> weakReference : this.f16758k) {
            Drawable.Callback callback = (Drawable.Callback) weakReference.get();
            if (!(callback == null || callback == getCallback())) {
                callback.invalidateDrawable(this);
            }
        }
    }

    public boolean isRunning() {
        return this.f16750c.D();
    }

    public void onStart() {
        Message.obtain(this.f16755h, 1).sendToTarget();
    }

    public void setAlpha(int i11) {
        this.f16749b.setAlpha(i11);
    }

    public void setBounds(int i11, int i12, int i13, int i14) {
        super.setBounds(i11, i12, i13, i14);
        boolean L = this.f16750c.L(getBounds().width(), getBounds().height());
        this.f16752e.setScale(((((float) getBounds().width()) * 1.0f) * ((float) this.f16750c.y())) / ((float) this.f16750c.r().width()), ((((float) getBounds().height()) * 1.0f) * ((float) this.f16750c.y())) / ((float) this.f16750c.r().height()));
        if (L) {
            this.f16754g = Bitmap.createBitmap(this.f16750c.r().width() / this.f16750c.y(), this.f16750c.r().height() / this.f16750c.y(), Bitmap.Config.ARGB_8888);
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f16749b.setColorFilter(colorFilter);
    }

    public boolean setVisible(boolean z11, boolean z12) {
        e();
        if (this.f16757j) {
            if (z11) {
                if (!isRunning()) {
                    f();
                }
            } else if (isRunning()) {
                g();
            }
        }
        return super.setVisible(z11, z12);
    }

    public void start() {
        if (this.f16750c.D()) {
            this.f16750c.O();
        }
        this.f16750c.K();
        f();
    }

    public void stop() {
        g();
    }
}
