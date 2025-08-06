package com.opensource.svgaplayer;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.media.SoundPool;
import android.widget.ImageView;
import com.opensource.svgaplayer.drawer.SVGACanvasDrawer;
import kotlin.Metadata;
import yx.a;

@Metadata(bv = {}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010,\u001a\u00020)\u0012\u0006\u00100\u001a\u00020-¢\u0006\u0004\b1\u00102J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0006\u0010\r\u001a\u00020\u0004J\u0006\u0010\u000e\u001a\u00020\u0004R*\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f8\u0006@@X\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R*\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00068\u0006@@X\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0017\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010$\u001a\u00020\u001d8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0014\u0010(\u001a\u00020%8\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0017\u0010,\u001a\u00020)8\u0006¢\u0006\f\n\u0004\b\u0014\u0010*\u001a\u0004\b&\u0010+R\u0017\u00100\u001a\u00020-8\u0006¢\u0006\f\n\u0004\b\u001a\u0010.\u001a\u0004\b\u001e\u0010/¨\u00063"}, d2 = {"Lcom/opensource/svgaplayer/d;", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/Canvas;", "canvas", "", "draw", "", "alpha", "setAlpha", "getOpacity", "Landroid/graphics/ColorFilter;", "colorFilter", "setColorFilter", "h", "a", "", "value", "Z", "getCleared", "()Z", "e", "(Z)V", "cleared", "b", "I", "()I", "f", "(I)V", "currentFrame", "Landroid/widget/ImageView$ScaleType;", "c", "Landroid/widget/ImageView$ScaleType;", "getScaleType", "()Landroid/widget/ImageView$ScaleType;", "g", "(Landroid/widget/ImageView$ScaleType;)V", "scaleType", "Lcom/opensource/svgaplayer/drawer/SVGACanvasDrawer;", "d", "Lcom/opensource/svgaplayer/drawer/SVGACanvasDrawer;", "drawer", "Lcom/opensource/svgaplayer/SVGAVideoEntity;", "Lcom/opensource/svgaplayer/SVGAVideoEntity;", "()Lcom/opensource/svgaplayer/SVGAVideoEntity;", "videoItem", "Lcom/opensource/svgaplayer/SVGADynamicEntity;", "Lcom/opensource/svgaplayer/SVGADynamicEntity;", "()Lcom/opensource/svgaplayer/SVGADynamicEntity;", "dynamicItem", "<init>", "(Lcom/opensource/svgaplayer/SVGAVideoEntity;Lcom/opensource/svgaplayer/SVGADynamicEntity;)V", "com.opensource.svgaplayer"}, k = 1, mv = {1, 4, 0})
public final class d extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    public boolean f28565a = true;

    /* renamed from: b  reason: collision with root package name */
    public int f28566b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView.ScaleType f28567c = ImageView.ScaleType.MATRIX;

    /* renamed from: d  reason: collision with root package name */
    public final SVGACanvasDrawer f28568d;

    /* renamed from: e  reason: collision with root package name */
    public final SVGAVideoEntity f28569e;

    /* renamed from: f  reason: collision with root package name */
    public final SVGADynamicEntity f28570f;

    public d(SVGAVideoEntity sVGAVideoEntity, SVGADynamicEntity sVGADynamicEntity) {
        this.f28569e = sVGAVideoEntity;
        this.f28570f = sVGADynamicEntity;
        this.f28568d = new SVGACanvasDrawer(sVGAVideoEntity, sVGADynamicEntity);
    }

    public final void a() {
        for (a aVar : this.f28569e.l()) {
            Integer b11 = aVar.b();
            if (b11 != null) {
                int intValue = b11.intValue();
                g gVar = g.f28608e;
                if (gVar.b()) {
                    gVar.e(intValue);
                } else {
                    SoundPool p11 = this.f28569e.p();
                    if (p11 != null) {
                        p11.stop(intValue);
                    }
                }
            }
            aVar.e((Integer) null);
        }
        this.f28569e.b();
    }

    public final int b() {
        return this.f28566b;
    }

    public final SVGADynamicEntity c() {
        return this.f28570f;
    }

    public final SVGAVideoEntity d() {
        return this.f28569e;
    }

    public void draw(Canvas canvas) {
        if (!this.f28565a && canvas != null) {
            this.f28568d.a(canvas, this.f28566b, this.f28567c);
        }
    }

    public final void e(boolean z11) {
        if (this.f28565a != z11) {
            this.f28565a = z11;
            invalidateSelf();
        }
    }

    public final void f(int i11) {
        if (this.f28566b != i11) {
            this.f28566b = i11;
            invalidateSelf();
        }
    }

    public final void g(ImageView.ScaleType scaleType) {
        this.f28567c = scaleType;
    }

    public int getOpacity() {
        return -2;
    }

    public final void h() {
        for (a b11 : this.f28569e.l()) {
            Integer b12 = b11.b();
            if (b12 != null) {
                int intValue = b12.intValue();
                g gVar = g.f28608e;
                if (gVar.b()) {
                    gVar.e(intValue);
                } else {
                    SoundPool p11 = this.f28569e.p();
                    if (p11 != null) {
                        p11.stop(intValue);
                    }
                }
            }
        }
    }

    public void setAlpha(int i11) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }
}
