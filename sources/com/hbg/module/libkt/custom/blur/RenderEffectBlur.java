package com.hbg.module.libkt.custom.blur;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RenderEffect;
import android.graphics.RenderNode;
import android.graphics.Shader;
import le.a;
import le.f;

public class RenderEffectBlur implements a {

    /* renamed from: a  reason: collision with root package name */
    public final RenderNode f24765a = new RenderNode("BlurViewNode");

    /* renamed from: b  reason: collision with root package name */
    public int f24766b;

    /* renamed from: c  reason: collision with root package name */
    public int f24767c;

    /* renamed from: d  reason: collision with root package name */
    public float f24768d = 1.0f;

    /* renamed from: e  reason: collision with root package name */
    public a f24769e;

    /* renamed from: f  reason: collision with root package name */
    public Context f24770f;

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
        if (canvas.isHardwareAccelerated()) {
            canvas.drawRenderNode(this.f24765a);
            return;
        }
        if (this.f24769e == null) {
            this.f24769e = new f(this.f24770f);
        }
        this.f24769e.e(bitmap, this.f24768d);
        this.f24769e.d(canvas, bitmap);
    }

    public void destroy() {
        this.f24765a.discardDisplayList();
        a aVar = this.f24769e;
        if (aVar != null) {
            aVar.destroy();
        }
    }

    public Bitmap e(Bitmap bitmap, float f11) {
        this.f24768d = f11;
        if (!(bitmap.getHeight() == this.f24766b && bitmap.getWidth() == this.f24767c)) {
            this.f24766b = bitmap.getHeight();
            int width = bitmap.getWidth();
            this.f24767c = width;
            this.f24765a.setPosition(0, 0, width, this.f24766b);
        }
        this.f24765a.beginRecording().drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        this.f24765a.endRecording();
        this.f24765a.setRenderEffect(RenderEffect.createBlurEffect(f11, f11, Shader.TileMode.MIRROR));
        return bitmap;
    }

    public void f(Context context) {
        this.f24770f = context;
    }
}
