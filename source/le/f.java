package le;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;

@Deprecated
public class f implements a {

    /* renamed from: a  reason: collision with root package name */
    public final Paint f25304a = new Paint(2);

    /* renamed from: b  reason: collision with root package name */
    public final RenderScript f25305b;

    /* renamed from: c  reason: collision with root package name */
    public final ScriptIntrinsicBlur f25306c;

    /* renamed from: d  reason: collision with root package name */
    public Allocation f25307d;

    /* renamed from: e  reason: collision with root package name */
    public int f25308e = -1;

    /* renamed from: f  reason: collision with root package name */
    public int f25309f = -1;

    public f(Context context) {
        RenderScript create = RenderScript.create(context);
        this.f25305b = create;
        this.f25306c = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
    }

    public Bitmap.Config a() {
        return Bitmap.Config.ARGB_8888;
    }

    public boolean b() {
        return true;
    }

    public float c() {
        return 6.0f;
    }

    public void d(Canvas canvas, Bitmap bitmap) {
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, this.f25304a);
    }

    public final void destroy() {
        this.f25306c.destroy();
        this.f25305b.destroy();
        Allocation allocation = this.f25307d;
        if (allocation != null) {
            allocation.destroy();
        }
    }

    public Bitmap e(Bitmap bitmap, float f11) {
        Allocation createFromBitmap = Allocation.createFromBitmap(this.f25305b, bitmap);
        if (!f(bitmap)) {
            Allocation allocation = this.f25307d;
            if (allocation != null) {
                allocation.destroy();
            }
            this.f25307d = Allocation.createTyped(this.f25305b, createFromBitmap.getType());
            this.f25308e = bitmap.getWidth();
            this.f25309f = bitmap.getHeight();
        }
        this.f25306c.setRadius(f11);
        this.f25306c.setInput(createFromBitmap);
        this.f25306c.forEach(this.f25307d);
        this.f25307d.copyTo(bitmap);
        createFromBitmap.destroy();
        return bitmap;
    }

    public final boolean f(Bitmap bitmap) {
        return bitmap.getHeight() == this.f25309f && bitmap.getWidth() == this.f25308e;
    }
}
