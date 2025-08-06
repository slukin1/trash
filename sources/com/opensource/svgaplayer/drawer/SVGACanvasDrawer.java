package com.opensource.svgaplayer.drawer;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import android.media.SoundPool;
import android.os.Build;
import android.text.BoringLayout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.widget.ImageView;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.opensource.svgaplayer.SVGADynamicEntity;
import com.opensource.svgaplayer.SVGAVideoEntity;
import com.opensource.svgaplayer.entities.SVGAVideoShapeEntity;
import com.opensource.svgaplayer.g;
import d10.p;
import d10.r;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.x;
import xx.a;
import yx.b;

@Metadata(bv = {}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001:\u0002>?B\u0017\u0012\u0006\u0010;\u001a\u00020:\u0012\u0006\u00109\u001a\u000205¢\u0006\u0004\b<\u0010=J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\"\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u00042\u0010\u0010\r\u001a\f\u0012\b\u0012\u00060\fR\u00020\u00010\u000bH\u0002J\"\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u00042\u0010\u0010\r\u001a\f\u0012\b\u0012\u00060\fR\u00020\u00010\u000bH\u0002J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J$\u0010\u0016\u001a\u00020\b2\n\u0010\u0015\u001a\u00060\fR\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001c\u0010\u0017\u001a\u00020\b2\n\u0010\u0015\u001a\u00060\fR\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J,\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00182\n\u0010\u0015\u001a\u00060\fR\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u0012H\u0002J\u001c\u0010\u001c\u001a\u00020\b2\n\u0010\u0015\u001a\u00060\fR\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u0012H\u0002J$\u0010 \u001a\u00020\b2\n\u0010\u0015\u001a\u00060\fR\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002R\u0014\u0010$\u001a\u00020!8\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R0\u0010*\u001a\u001e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u00180%j\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u0018`'8\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010-\u001a\u00020+8\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010,R\u001e\u00100\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010.8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010/R\u001e\u00101\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010.8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010/R\u0014\u00104\u001a\u0002028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u00103R\u0017\u00109\u001a\u0002058\u0006¢\u0006\f\n\u0004\b\u001b\u00106\u001a\u0004\b7\u00108¨\u0006@"}, d2 = {"Lcom/opensource/svgaplayer/drawer/SVGACanvasDrawer;", "Lxx/a;", "Landroid/graphics/Canvas;", "canvas", "", "frameIndex", "Landroid/widget/ImageView$ScaleType;", "scaleType", "", "a", "spriteIndex", "", "Lxx/a$a;", "sprites", "", "k", "l", "n", "Landroid/graphics/Matrix;", "transform", "o", "sprite", "i", "g", "Landroid/graphics/Bitmap;", "drawingBitmap", "frameMatrix", "j", "h", "matrix", "", "m", "f", "Lcom/opensource/svgaplayer/drawer/SVGACanvasDrawer$ShareValues;", "d", "Lcom/opensource/svgaplayer/drawer/SVGACanvasDrawer$ShareValues;", "sharedValues", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "e", "Ljava/util/HashMap;", "drawTextCache", "Lcom/opensource/svgaplayer/drawer/SVGACanvasDrawer$PathCache;", "Lcom/opensource/svgaplayer/drawer/SVGACanvasDrawer$PathCache;", "pathCache", "", "[Ljava/lang/Boolean;", "beginIndexList", "endIndexList", "", "[F", "matrixScaleTempValues", "Lcom/opensource/svgaplayer/SVGADynamicEntity;", "Lcom/opensource/svgaplayer/SVGADynamicEntity;", "getDynamicItem", "()Lcom/opensource/svgaplayer/SVGADynamicEntity;", "dynamicItem", "Lcom/opensource/svgaplayer/SVGAVideoEntity;", "videoItem", "<init>", "(Lcom/opensource/svgaplayer/SVGAVideoEntity;Lcom/opensource/svgaplayer/SVGADynamicEntity;)V", "PathCache", "ShareValues", "com.opensource.svgaplayer"}, k = 1, mv = {1, 4, 0})
public final class SVGACanvasDrawer extends a {

    /* renamed from: d  reason: collision with root package name */
    public final ShareValues f28571d = new ShareValues();

    /* renamed from: e  reason: collision with root package name */
    public final HashMap<String, Bitmap> f28572e = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    public final PathCache f28573f = new PathCache();

    /* renamed from: g  reason: collision with root package name */
    public Boolean[] f28574g;

    /* renamed from: h  reason: collision with root package name */
    public Boolean[] f28575h;

    /* renamed from: i  reason: collision with root package name */
    public final float[] f28576i = new float[16];

    /* renamed from: j  reason: collision with root package name */
    public final SVGADynamicEntity f28577j;

    @Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006R\u0016\u0010\f\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u000bR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u000bR0\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u000ej\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b`\u000f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/opensource/svgaplayer/drawer/SVGACanvasDrawer$PathCache;", "", "Landroid/graphics/Canvas;", "canvas", "", "b", "Lcom/opensource/svgaplayer/entities/SVGAVideoShapeEntity;", "shape", "Landroid/graphics/Path;", "a", "", "I", "canvasWidth", "canvasHeight", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "c", "Ljava/util/HashMap;", "cache", "<init>", "()V", "com.opensource.svgaplayer"}, k = 1, mv = {1, 4, 0})
    public static final class PathCache {

        /* renamed from: a  reason: collision with root package name */
        public int f28578a;

        /* renamed from: b  reason: collision with root package name */
        public int f28579b;

        /* renamed from: c  reason: collision with root package name */
        public final HashMap<SVGAVideoShapeEntity, Path> f28580c = new HashMap<>();

        public final Path a(SVGAVideoShapeEntity sVGAVideoShapeEntity) {
            if (!this.f28580c.containsKey(sVGAVideoShapeEntity)) {
                Path path = new Path();
                path.set(sVGAVideoShapeEntity.f());
                this.f28580c.put(sVGAVideoShapeEntity, path);
            }
            Path path2 = this.f28580c.get(sVGAVideoShapeEntity);
            if (path2 == null) {
                x.j();
            }
            return path2;
        }

        public final void b(Canvas canvas) {
            if (!(this.f28578a == canvas.getWidth() && this.f28579b == canvas.getHeight())) {
                this.f28580c.clear();
            }
            this.f28578a = canvas.getWidth();
            this.f28579b = canvas.getHeight();
        }
    }

    @Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001f\u0010 J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\t\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\u0002J\u0006\u0010\f\u001a\u00020\u000bJ\u0016\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rR\u0014\u0010\u0013\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0012R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u001bR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u001d¨\u0006!"}, d2 = {"Lcom/opensource/svgaplayer/drawer/SVGACanvasDrawer$ShareValues;", "", "Landroid/graphics/Paint;", "f", "Landroid/graphics/Path;", "g", "h", "Landroid/graphics/Matrix;", "c", "d", "b", "Landroid/graphics/Bitmap;", "e", "", "width", "height", "Landroid/graphics/Canvas;", "a", "Landroid/graphics/Paint;", "sharedPaint", "Landroid/graphics/Path;", "sharedPath", "sharedPath2", "Landroid/graphics/Matrix;", "sharedMatrix", "sharedMatrix2", "shareMattePaint", "Landroid/graphics/Canvas;", "shareMatteCanvas", "Landroid/graphics/Bitmap;", "sharedMatteBitmap", "<init>", "()V", "com.opensource.svgaplayer"}, k = 1, mv = {1, 4, 0})
    public static final class ShareValues {

        /* renamed from: a  reason: collision with root package name */
        public final Paint f28581a = new Paint();

        /* renamed from: b  reason: collision with root package name */
        public final Path f28582b = new Path();

        /* renamed from: c  reason: collision with root package name */
        public final Path f28583c = new Path();

        /* renamed from: d  reason: collision with root package name */
        public final Matrix f28584d = new Matrix();

        /* renamed from: e  reason: collision with root package name */
        public final Matrix f28585e = new Matrix();

        /* renamed from: f  reason: collision with root package name */
        public final Paint f28586f = new Paint();

        /* renamed from: g  reason: collision with root package name */
        public Canvas f28587g;

        /* renamed from: h  reason: collision with root package name */
        public Bitmap f28588h;

        public final Canvas a(int i11, int i12) {
            if (this.f28587g == null) {
                this.f28588h = Bitmap.createBitmap(i11, i12, Bitmap.Config.ALPHA_8);
            }
            return new Canvas(this.f28588h);
        }

        public final Paint b() {
            this.f28586f.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            return this.f28586f;
        }

        public final Matrix c() {
            this.f28584d.reset();
            return this.f28584d;
        }

        public final Matrix d() {
            this.f28585e.reset();
            return this.f28585e;
        }

        public final Bitmap e() {
            Bitmap bitmap = this.f28588h;
            if (bitmap != null) {
                return bitmap;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.graphics.Bitmap");
        }

        public final Paint f() {
            this.f28581a.reset();
            return this.f28581a;
        }

        public final Path g() {
            this.f28582b.reset();
            return this.f28582b;
        }

        public final Path h() {
            this.f28583c.reset();
            return this.f28583c;
        }
    }

    public SVGACanvasDrawer(SVGAVideoEntity sVGAVideoEntity, SVGADynamicEntity sVGADynamicEntity) {
        super(sVGAVideoEntity);
        this.f28577j = sVGADynamicEntity;
    }

    public void a(Canvas canvas, int i11, ImageView.ScaleType scaleType) {
        int i12;
        int i13;
        a.C0259a aVar;
        a.C0259a aVar2;
        Canvas canvas2 = canvas;
        int i14 = i11;
        super.a(canvas, i11, scaleType);
        n(i14);
        this.f28573f.b(canvas2);
        List<a.C0259a> e11 = e(i14);
        if (e11.size() > 0) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Object obj = null;
            this.f28574g = null;
            this.f28575h = null;
            boolean z11 = false;
            String b11 = e11.get(0).b();
            int i15 = 2;
            boolean v11 = b11 != null ? StringsKt__StringsJVMKt.v(b11, ".matte", false, 2, (Object) null) : false;
            int i16 = 0;
            int i17 = -1;
            for (T next : e11) {
                int i18 = i16 + 1;
                if (i16 < 0) {
                    CollectionsKt__CollectionsKt.t();
                }
                a.C0259a aVar3 = (a.C0259a) next;
                String b12 = aVar3.b();
                if (b12 != null) {
                    if (!v11 || Build.VERSION.SDK_INT < 21) {
                        i(aVar3, canvas2, i14);
                    } else if (StringsKt__StringsJVMKt.v(b12, ".matte", z11, i15, obj)) {
                        linkedHashMap.put(b12, aVar3);
                    }
                    i16 = i18;
                    obj = null;
                    z11 = false;
                    i15 = 2;
                }
                if (!k(i16, e11)) {
                    aVar = aVar3;
                    i13 = i16;
                    i12 = -1;
                } else if (Build.VERSION.SDK_INT >= 21) {
                    aVar = aVar3;
                    i13 = i16;
                    i12 = -1;
                    i17 = canvas.saveLayer(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight(), (Paint) null);
                } else {
                    aVar = aVar3;
                    i13 = i16;
                    i12 = -1;
                    canvas.save();
                }
                i(aVar, canvas2, i14);
                if (l(i13, e11) && (aVar2 = (a.C0259a) linkedHashMap.get(aVar.c())) != null) {
                    i(aVar2, this.f28571d.a(canvas.getWidth(), canvas.getHeight()), i14);
                    canvas2.drawBitmap(this.f28571d.e(), 0.0f, 0.0f, this.f28571d.b());
                    if (i17 != i12) {
                        canvas2.restoreToCount(i17);
                    } else {
                        canvas.restore();
                    }
                }
                i16 = i18;
                obj = null;
                z11 = false;
                i15 = 2;
            }
            d(e11);
        }
    }

    public final void f(a.C0259a aVar, Canvas canvas, int i11) {
        String b11 = aVar.b();
        if (b11 != null) {
            p pVar = this.f28577j.b().get(b11);
            if (pVar != null) {
                Matrix o11 = o(aVar.a().e());
                canvas.save();
                canvas.concat(o11);
                pVar.invoke(canvas, Integer.valueOf(i11));
                canvas.restore();
            }
            r rVar = this.f28577j.c().get(b11);
            if (rVar != null) {
                Matrix o12 = o(aVar.a().e());
                canvas.save();
                canvas.concat(o12);
                rVar.invoke(canvas, Integer.valueOf(i11), Integer.valueOf((int) aVar.a().b().b()), Integer.valueOf((int) aVar.a().b().a()));
                canvas.restore();
            }
        }
    }

    public final void g(a.C0259a aVar, Canvas canvas) {
        String b11 = aVar.b();
        if (b11 != null && !x.b(this.f28577j.d().get(b11), Boolean.TRUE)) {
            String substring = StringsKt__StringsJVMKt.v(b11, ".matte", false, 2, (Object) null) ? b11.substring(0, b11.length() - 6) : b11;
            Bitmap bitmap = this.f28577j.f().get(substring);
            if (bitmap == null) {
                bitmap = c().o().get(substring);
            }
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null) {
                Matrix o11 = o(aVar.a().e());
                Paint f11 = this.f28571d.f();
                f11.setAntiAlias(c().k());
                f11.setFilterBitmap(c().k());
                f11.setAlpha((int) (aVar.a().a() * ((double) 255)));
                if (aVar.a().c() != null) {
                    b c11 = aVar.a().c();
                    if (c11 != null) {
                        canvas.save();
                        Path g11 = this.f28571d.g();
                        c11.a(g11);
                        g11.transform(o11);
                        canvas.clipPath(g11);
                        o11.preScale((float) (aVar.a().b().b() / ((double) bitmap2.getWidth())), (float) (aVar.a().b().a() / ((double) bitmap2.getHeight())));
                        if (!bitmap2.isRecycled()) {
                            canvas.drawBitmap(bitmap2, o11, f11);
                        }
                        canvas.restore();
                    } else {
                        return;
                    }
                } else {
                    o11.preScale((float) (aVar.a().b().b() / ((double) bitmap2.getWidth())), (float) (aVar.a().b().a() / ((double) bitmap2.getHeight())));
                    if (!bitmap2.isRecycled()) {
                        canvas.drawBitmap(bitmap2, o11, f11);
                    }
                }
                com.opensource.svgaplayer.a aVar2 = this.f28577j.e().get(b11);
                if (aVar2 != null) {
                    float[] fArr = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
                    o11.getValues(fArr);
                    aVar2.a(b11, (int) fArr[2], (int) fArr[5], (int) ((((float) bitmap2.getWidth()) * fArr[0]) + fArr[2]), (int) ((((float) bitmap2.getHeight()) * fArr[4]) + fArr[5]));
                }
                j(canvas, bitmap2, aVar, o11);
            }
        }
    }

    public final void h(a.C0259a aVar, Canvas canvas) {
        float[] c11;
        String d11;
        String b11;
        int a11;
        Matrix o11 = o(aVar.a().e());
        for (SVGAVideoShapeEntity sVGAVideoShapeEntity : aVar.a().d()) {
            sVGAVideoShapeEntity.a();
            if (sVGAVideoShapeEntity.f() != null) {
                Paint f11 = this.f28571d.f();
                f11.reset();
                f11.setAntiAlias(c().k());
                double d12 = (double) 255;
                f11.setAlpha((int) (aVar.a().a() * d12));
                Path g11 = this.f28571d.g();
                g11.reset();
                g11.addPath(this.f28573f.a(sVGAVideoShapeEntity));
                Matrix d13 = this.f28571d.d();
                d13.reset();
                Matrix h11 = sVGAVideoShapeEntity.h();
                if (h11 != null) {
                    d13.postConcat(h11);
                }
                d13.postConcat(o11);
                g11.transform(d13);
                SVGAVideoShapeEntity.Styles g12 = sVGAVideoShapeEntity.g();
                if (!(g12 == null || (a11 = g12.a()) == 0)) {
                    f11.setStyle(Paint.Style.FILL);
                    f11.setColor(a11);
                    int min = Math.min(255, Math.max(0, (int) (aVar.a().a() * d12)));
                    if (min != 255) {
                        f11.setAlpha(min);
                    }
                    if (aVar.a().c() != null) {
                        canvas.save();
                    }
                    b c12 = aVar.a().c();
                    if (c12 != null) {
                        Path h12 = this.f28571d.h();
                        c12.a(h12);
                        h12.transform(o11);
                        canvas.clipPath(h12);
                    }
                    canvas.drawPath(g11, f11);
                    if (aVar.a().c() != null) {
                        canvas.restore();
                    }
                }
                SVGAVideoShapeEntity.Styles g13 = sVGAVideoShapeEntity.g();
                if (g13 != null) {
                    float f12 = (float) 0;
                    if (g13.g() > f12) {
                        f11.setAlpha((int) (aVar.a().a() * d12));
                        f11.setStyle(Paint.Style.STROKE);
                        SVGAVideoShapeEntity.Styles g14 = sVGAVideoShapeEntity.g();
                        if (g14 != null) {
                            f11.setColor(g14.f());
                            int min2 = Math.min(255, Math.max(0, (int) (aVar.a().a() * d12)));
                            if (min2 != 255) {
                                f11.setAlpha(min2);
                            }
                        }
                        float m11 = m(o11);
                        SVGAVideoShapeEntity.Styles g15 = sVGAVideoShapeEntity.g();
                        if (g15 != null) {
                            f11.setStrokeWidth(g15.g() * m11);
                        }
                        SVGAVideoShapeEntity.Styles g16 = sVGAVideoShapeEntity.g();
                        if (!(g16 == null || (b11 = g16.b()) == null)) {
                            if (StringsKt__StringsJVMKt.w(b11, "butt", true)) {
                                f11.setStrokeCap(Paint.Cap.BUTT);
                            } else if (StringsKt__StringsJVMKt.w(b11, "round", true)) {
                                f11.setStrokeCap(Paint.Cap.ROUND);
                            } else if (StringsKt__StringsJVMKt.w(b11, MessengerShareContentUtility.IMAGE_RATIO_SQUARE, true)) {
                                f11.setStrokeCap(Paint.Cap.SQUARE);
                            }
                        }
                        SVGAVideoShapeEntity.Styles g17 = sVGAVideoShapeEntity.g();
                        if (!(g17 == null || (d11 = g17.d()) == null)) {
                            if (StringsKt__StringsJVMKt.w(d11, "miter", true)) {
                                f11.setStrokeJoin(Paint.Join.MITER);
                            } else if (StringsKt__StringsJVMKt.w(d11, "round", true)) {
                                f11.setStrokeJoin(Paint.Join.ROUND);
                            } else if (StringsKt__StringsJVMKt.w(d11, "bevel", true)) {
                                f11.setStrokeJoin(Paint.Join.BEVEL);
                            }
                        }
                        SVGAVideoShapeEntity.Styles g18 = sVGAVideoShapeEntity.g();
                        if (g18 != null) {
                            f11.setStrokeMiter(((float) g18.e()) * m11);
                        }
                        SVGAVideoShapeEntity.Styles g19 = sVGAVideoShapeEntity.g();
                        if (g19 != null && (c11 = g19.c()) != null && c11.length == 3 && (c11[0] > f12 || c11[1] > f12)) {
                            float[] fArr = new float[2];
                            float f13 = 1.0f;
                            if (c11[0] >= 1.0f) {
                                f13 = c11[0];
                            }
                            fArr[0] = f13 * m11;
                            float f14 = 0.1f;
                            if (c11[1] >= 0.1f) {
                                f14 = c11[1];
                            }
                            fArr[1] = f14 * m11;
                            f11.setPathEffect(new DashPathEffect(fArr, c11[2] * m11));
                        }
                        if (aVar.a().c() != null) {
                            canvas.save();
                        }
                        b c13 = aVar.a().c();
                        if (c13 != null) {
                            Path h13 = this.f28571d.h();
                            c13.a(h13);
                            h13.transform(o11);
                            canvas.clipPath(h13);
                        }
                        canvas.drawPath(g11, f11);
                        if (aVar.a().c() != null) {
                            canvas.restore();
                        }
                    }
                }
            }
        }
    }

    public final void i(a.C0259a aVar, Canvas canvas, int i11) {
        g(aVar, canvas);
        h(aVar, canvas);
        f(aVar, canvas, i11);
    }

    public final void j(Canvas canvas, Bitmap bitmap, a.C0259a aVar, Matrix matrix) {
        StaticLayout staticLayout;
        int i11;
        TextPaint textPaint;
        Canvas canvas2 = canvas;
        Matrix matrix2 = matrix;
        if (this.f28577j.k()) {
            this.f28572e.clear();
            this.f28577j.l(false);
        }
        String b11 = aVar.b();
        if (b11 != null) {
            Bitmap bitmap2 = null;
            String str = this.f28577j.h().get(b11);
            if (!(str == null || (textPaint = this.f28577j.i().get(b11)) == null || (bitmap2 = this.f28572e.get(b11)) != null)) {
                bitmap2 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
                Canvas canvas3 = new Canvas(bitmap2);
                textPaint.setAntiAlias(true);
                Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
                float f11 = fontMetrics.top;
                float f12 = fontMetrics.bottom;
                float f13 = (float) 2;
                canvas3.drawText(str, (float) rect.centerX(), (((float) rect.centerY()) - (f11 / f13)) - (f12 / f13), textPaint);
                HashMap<String, Bitmap> hashMap = this.f28572e;
                if (bitmap2 != null) {
                    Bitmap put = hashMap.put(b11, bitmap2);
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type android.graphics.Bitmap");
                }
            }
            BoringLayout boringLayout = this.f28577j.a().get(b11);
            if (boringLayout != null && (bitmap2 = this.f28572e.get(b11)) == null) {
                boringLayout.getPaint().setAntiAlias(true);
                bitmap2 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas4 = new Canvas(bitmap2);
                canvas4.translate(0.0f, (float) ((bitmap.getHeight() - boringLayout.getHeight()) / 2));
                boringLayout.draw(canvas4);
                HashMap<String, Bitmap> hashMap2 = this.f28572e;
                if (bitmap2 != null) {
                    Bitmap put2 = hashMap2.put(b11, bitmap2);
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type android.graphics.Bitmap");
                }
            }
            StaticLayout staticLayout2 = this.f28577j.g().get(b11);
            if (staticLayout2 != null && (bitmap2 = this.f28572e.get(b11)) == null) {
                staticLayout2.getPaint().setAntiAlias(true);
                if (Build.VERSION.SDK_INT >= 23) {
                    try {
                        Field declaredField = StaticLayout.class.getDeclaredField("mMaximumVisibleLineCount");
                        declaredField.setAccessible(true);
                        i11 = declaredField.getInt(staticLayout2);
                    } catch (Exception unused) {
                        i11 = Integer.MAX_VALUE;
                    }
                    staticLayout = StaticLayout.Builder.obtain(staticLayout2.getText(), 0, staticLayout2.getText().length(), staticLayout2.getPaint(), bitmap.getWidth()).setAlignment(staticLayout2.getAlignment()).setMaxLines(i11).setEllipsize(TextUtils.TruncateAt.END).build();
                } else {
                    staticLayout = new StaticLayout(staticLayout2.getText(), 0, staticLayout2.getText().length(), staticLayout2.getPaint(), bitmap.getWidth(), staticLayout2.getAlignment(), staticLayout2.getSpacingMultiplier(), staticLayout2.getSpacingAdd(), false);
                }
                bitmap2 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas5 = new Canvas(bitmap2);
                canvas5.translate(0.0f, (float) ((bitmap.getHeight() - staticLayout.getHeight()) / 2));
                staticLayout.draw(canvas5);
                HashMap<String, Bitmap> hashMap3 = this.f28572e;
                if (bitmap2 != null) {
                    Bitmap put3 = hashMap3.put(b11, bitmap2);
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type android.graphics.Bitmap");
                }
            }
            if (bitmap2 != null) {
                Paint f14 = this.f28571d.f();
                f14.setAntiAlias(c().k());
                f14.setAlpha((int) (aVar.a().a() * ((double) 255)));
                if (aVar.a().c() != null) {
                    b c11 = aVar.a().c();
                    if (c11 != null) {
                        canvas.save();
                        canvas2.concat(matrix2);
                        canvas2.clipRect(0, 0, bitmap.getWidth(), bitmap.getHeight());
                        Shader.TileMode tileMode = Shader.TileMode.REPEAT;
                        f14.setShader(new BitmapShader(bitmap2, tileMode, tileMode));
                        Path g11 = this.f28571d.g();
                        c11.a(g11);
                        canvas2.drawPath(g11, f14);
                        canvas.restore();
                        return;
                    }
                    return;
                }
                f14.setFilterBitmap(c().k());
                canvas2.drawBitmap(bitmap2, matrix2, f14);
            }
        }
    }

    public final boolean k(int i11, List<a.C0259a> list) {
        Boolean bool;
        String c11;
        a.C0259a aVar;
        if (this.f28574g == null) {
            int size = list.size();
            Boolean[] boolArr = new Boolean[size];
            for (int i12 = 0; i12 < size; i12++) {
                boolArr[i12] = Boolean.FALSE;
            }
            int i13 = 0;
            for (T next : list) {
                int i14 = i13 + 1;
                if (i13 < 0) {
                    CollectionsKt__CollectionsKt.t();
                }
                a.C0259a aVar2 = (a.C0259a) next;
                String b11 = aVar2.b();
                if ((b11 == null || !StringsKt__StringsJVMKt.v(b11, ".matte", false, 2, (Object) null)) && (c11 = aVar2.c()) != null && c11.length() > 0 && (aVar = list.get(i13 - 1)) != null) {
                    String c12 = aVar.c();
                    if (c12 == null || c12.length() == 0) {
                        boolArr[i13] = Boolean.TRUE;
                    } else if (!x.b(aVar.c(), aVar2.c())) {
                        boolArr[i13] = Boolean.TRUE;
                    }
                }
                i13 = i14;
            }
            this.f28574g = boolArr;
        }
        Boolean[] boolArr2 = this.f28574g;
        if (boolArr2 == null || (bool = boolArr2[i11]) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final boolean l(int i11, List<a.C0259a> list) {
        Boolean bool;
        String c11;
        if (this.f28575h == null) {
            int size = list.size();
            Boolean[] boolArr = new Boolean[size];
            for (int i12 = 0; i12 < size; i12++) {
                boolArr[i12] = Boolean.FALSE;
            }
            int i13 = 0;
            for (T next : list) {
                int i14 = i13 + 1;
                if (i13 < 0) {
                    CollectionsKt__CollectionsKt.t();
                }
                a.C0259a aVar = (a.C0259a) next;
                String b11 = aVar.b();
                if ((b11 == null || !StringsKt__StringsJVMKt.v(b11, ".matte", false, 2, (Object) null)) && (c11 = aVar.c()) != null && c11.length() > 0) {
                    if (i13 == list.size() - 1) {
                        boolArr[i13] = Boolean.TRUE;
                    } else {
                        a.C0259a aVar2 = list.get(i14);
                        if (aVar2 != null) {
                            String c12 = aVar2.c();
                            if (c12 == null || c12.length() == 0) {
                                boolArr[i13] = Boolean.TRUE;
                            } else if (!x.b(aVar2.c(), aVar.c())) {
                                boolArr[i13] = Boolean.TRUE;
                            }
                        }
                    }
                }
                i13 = i14;
            }
            this.f28575h = boolArr;
        }
        Boolean[] boolArr2 = this.f28575h;
        if (boolArr2 == null || (bool = boolArr2[i11]) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final float m(Matrix matrix) {
        matrix.getValues(this.f28576i);
        float[] fArr = this.f28576i;
        if (fArr[0] == 0.0f) {
            return 0.0f;
        }
        double d11 = (double) fArr[0];
        double d12 = (double) fArr[3];
        double d13 = (double) fArr[1];
        double d14 = (double) fArr[4];
        if (d11 * d14 == d12 * d13) {
            return 0.0f;
        }
        double sqrt = Math.sqrt((d11 * d11) + (d12 * d12));
        double d15 = d11 / sqrt;
        double d16 = d12 / sqrt;
        double d17 = (d15 * d13) + (d16 * d14);
        double d18 = d13 - (d15 * d17);
        double d19 = d14 - (d17 * d16);
        double sqrt2 = Math.sqrt((d18 * d18) + (d19 * d19));
        if (d15 * (d19 / sqrt2) < d16 * (d18 / sqrt2)) {
            sqrt = -sqrt;
        }
        return Math.abs(b().a() ? (float) sqrt : (float) sqrt2);
    }

    public final void n(int i11) {
        Integer c11;
        for (yx.a aVar : c().l()) {
            if (aVar.d() == i11) {
                g gVar = g.f28608e;
                if (gVar.b()) {
                    Integer c12 = aVar.c();
                    if (c12 != null) {
                        aVar.e(Integer.valueOf(gVar.d(c12.intValue())));
                    }
                } else {
                    SoundPool p11 = c().p();
                    if (!(p11 == null || (c11 = aVar.c()) == null)) {
                        aVar.e(Integer.valueOf(p11.play(c11.intValue(), 1.0f, 1.0f, 1, 0, 1.0f)));
                    }
                }
            }
            if (aVar.a() <= i11) {
                Integer b11 = aVar.b();
                if (b11 != null) {
                    int intValue = b11.intValue();
                    g gVar2 = g.f28608e;
                    if (gVar2.b()) {
                        gVar2.e(intValue);
                    } else {
                        SoundPool p12 = c().p();
                        if (p12 != null) {
                            p12.stop(intValue);
                        }
                    }
                }
                aVar.e((Integer) null);
            }
        }
    }

    public final Matrix o(Matrix matrix) {
        Matrix c11 = this.f28571d.c();
        c11.postScale(b().b(), b().c());
        c11.postTranslate(b().d(), b().e());
        c11.preConcat(matrix);
        return c11;
    }
}
