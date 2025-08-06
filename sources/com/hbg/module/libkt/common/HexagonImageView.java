package com.hbg.module.libkt.common;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.view.ViewGroup;
import c4.g;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.e;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.RelativeCornerSize;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.hbg.module.libkt.R$drawable;
import com.hbg.module.libkt.base.ext.b;
import com.hbg.module.libkt.base.ext.c;
import kotlin.jvm.internal.r;

public final class HexagonImageView extends ShapeableImageView {

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f24545b;

    /* renamed from: c  reason: collision with root package name */
    public Bitmap f24546c;

    /* renamed from: d  reason: collision with root package name */
    public int f24547d;

    /* renamed from: e  reason: collision with root package name */
    public int f24548e;

    /* renamed from: f  reason: collision with root package name */
    public float f24549f;

    /* renamed from: g  reason: collision with root package name */
    public int f24550g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f24551h;

    /* renamed from: i  reason: collision with root package name */
    public Paint f24552i;

    /* renamed from: j  reason: collision with root package name */
    public PorterDuffXfermode f24553j;

    /* renamed from: k  reason: collision with root package name */
    public RectF f24554k;

    /* renamed from: l  reason: collision with root package name */
    public final ShapeAppearanceModel f24555l;

    /* renamed from: m  reason: collision with root package name */
    public final ShapeAppearanceModel f24556m;

    public static final class a implements e<Bitmap> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ HexagonImageView f24557b;

        public a(HexagonImageView hexagonImageView) {
            this.f24557b = hexagonImageView;
        }

        public static final void c(HexagonImageView hexagonImageView, Bitmap bitmap) {
            hexagonImageView.setImageBitmap((Bitmap) null);
            hexagonImageView.f24545b = bitmap;
            hexagonImageView.invalidate();
        }

        /* renamed from: b */
        public boolean onResourceReady(Bitmap bitmap, Object obj, g<Bitmap> gVar, DataSource dataSource, boolean z11) {
            if (!this.f24557b.f24551h) {
                return false;
            }
            HexagonImageView hexagonImageView = this.f24557b;
            hexagonImageView.post(new je.a(hexagonImageView, bitmap));
            return false;
        }

        public boolean onLoadFailed(GlideException glideException, Object obj, g<Bitmap> gVar, boolean z11) {
            this.f24557b.f24545b = null;
            return false;
        }
    }

    public HexagonImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HexagonImageView(Context context, AttributeSet attributeSet, int i11, int i12, r rVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    public static /* synthetic */ void g(HexagonImageView hexagonImageView, int i11, int i12, String str, boolean z11, int i13, Object obj) {
        if ((i13 & 8) != 0) {
            z11 = false;
        }
        hexagonImageView.f(i11, i12, str, z11);
    }

    public final void e(Canvas canvas, Paint paint) {
        float sqrt = (float) ((((double) this.f24547d) - (Math.sqrt(3.0d) * ((double) this.f24549f))) / 2.0d);
        Path path = new Path();
        float f11 = ((float) this.f24550g) / 2.0f;
        float sqrt2 = (float) ((Math.sqrt(3.0d) / ((double) 2)) * ((double) this.f24550g));
        float f12 = (float) 2;
        float f13 = (this.f24549f / f12) + 0.0f;
        float f14 = sqrt + sqrt2;
        path.moveTo(f13 - f11, f14);
        path.quadTo(f13, sqrt, f13 + sqrt2, sqrt);
        float f15 = (this.f24549f * 1.5f) + 0.0f;
        path.lineTo(f15 - sqrt2, sqrt);
        path.quadTo(f15, sqrt, f15 + f11, f14);
        float f16 = (f12 * this.f24549f) + 0.0f;
        double d11 = (double) sqrt;
        float sqrt3 = (float) (d11 + ((Math.sqrt(3.0d) * ((double) this.f24549f)) / ((double) 2.0f)));
        float f17 = f16 - f11;
        path.lineTo(f17, sqrt3 - sqrt2);
        path.quadTo(f16, sqrt3, f17, sqrt3 + sqrt2);
        float f18 = (this.f24549f * 1.5f) + 0.0f;
        float sqrt4 = (float) ((Math.sqrt(3.0d) * ((double) this.f24549f)) + d11);
        path.lineTo(f18 + f11, sqrt4 - sqrt2);
        path.quadTo(f18, sqrt4, f18 - sqrt2, sqrt4);
        float f19 = (this.f24549f / 2.0f) + 0.0f;
        float sqrt5 = (float) ((Math.sqrt(3.0d) * ((double) this.f24549f)) + d11);
        path.lineTo(f19 + sqrt2, sqrt5);
        path.quadTo(f19, sqrt5, f19 - f11, sqrt5 - sqrt2);
        float sqrt6 = (float) (d11 + ((Math.sqrt(3.0d) * ((double) this.f24549f)) / 2.0d));
        float f21 = f11 + 0.0f;
        path.lineTo(f21, sqrt6 + sqrt2);
        path.quadTo(0.0f, sqrt6, f21, sqrt6 - sqrt2);
        path.close();
        canvas.drawPath(path, paint);
    }

    public final void f(int i11, int i12, String str, boolean z11) {
        if (b.x(str)) {
            this.f24551h = false;
            this.f24545b = null;
            this.f24546c = null;
            setShapeAppearanceModel(this.f24555l);
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            int i13 = layoutParams.width;
            int i14 = this.f24548e;
            if (i13 != i14) {
                layoutParams.width = i14;
                layoutParams.height = i14;
                requestLayout();
                return;
            }
            return;
        }
        if (i11 > 0) {
            float f11 = (float) i11;
            this.f24547d = c.d(Float.valueOf(f11));
            this.f24550g = c.d(Float.valueOf(f11 * 0.071f));
        }
        if (i12 > 0) {
            this.f24548e = c.d(Float.valueOf((float) i12));
        }
        this.f24549f = ((float) this.f24547d) / 2.0f;
        int i15 = this.f24547d;
        this.f24554k = new RectF(0.0f, 0.0f, (float) i15, (float) i15);
        this.f24551h = z11;
        if (z11) {
            setShapeAppearanceModel(this.f24556m);
            if (this.f24546c == null) {
                int i16 = this.f24547d;
                this.f24546c = Bitmap.createBitmap(i16, i16, Bitmap.Config.ARGB_4444);
            }
            if (getLayoutParams().width != this.f24547d) {
                getLayoutParams().width = this.f24547d;
                getLayoutParams().height = this.f24547d;
                requestLayout();
            }
            com.bumptech.glide.c<Bitmap> r02 = com.bumptech.glide.a.v(getContext()).b().M0(str).b(new RequestOptions()).r0(new a(this));
            int i17 = this.f24547d;
            r02.E0(i17, i17);
            return;
        }
        this.f24546c = null;
        setShapeAppearanceModel(this.f24555l);
        if (getLayoutParams().width != this.f24548e) {
            getLayoutParams().width = this.f24548e;
            getLayoutParams().height = this.f24548e;
            requestLayout();
        }
        b.K(this, str, R$drawable.account_user_image);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f24551h && this.f24545b != null) {
            Canvas canvas2 = new Canvas(this.f24546c);
            e(canvas2, this.f24552i);
            this.f24552i.setXfermode(this.f24553j);
            RectF rectF = this.f24554k;
            if (rectF != null) {
                canvas2.drawBitmap(this.f24545b, (Rect) null, rectF, this.f24552i);
            }
            canvas.drawBitmap(this.f24546c, 0.0f, 0.0f, (Paint) null);
            this.f24552i.setXfermode((Xfermode) null);
        }
    }

    public HexagonImageView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f24547d = -1;
        this.f24548e = -1;
        this.f24550g = c.d(Float.valueOf(5.0f));
        this.f24551h = true;
        this.f24552i = new Paint(1);
        this.f24553j = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        this.f24555l = ShapeAppearanceModel.builder().setAllCornerSizes((CornerSize) new RelativeCornerSize(0.5f)).build();
        this.f24556m = ShapeAppearanceModel.builder().setAllCornerSizes((CornerSize) new RelativeCornerSize(0.0f)).build();
    }
}
