package com.hbg.module.account.index.ui.view;

import android.app.Activity;
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
import com.hbg.module.libkt.base.ext.c;
import kotlin.jvm.internal.r;
import zb.b;

public final class AccountAvatarView extends ShapeableImageView {

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f77684b;

    /* renamed from: c  reason: collision with root package name */
    public Bitmap f77685c;

    /* renamed from: d  reason: collision with root package name */
    public int f77686d;

    /* renamed from: e  reason: collision with root package name */
    public int f77687e;

    /* renamed from: f  reason: collision with root package name */
    public float f77688f;

    /* renamed from: g  reason: collision with root package name */
    public int f77689g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f77690h;

    /* renamed from: i  reason: collision with root package name */
    public Paint f77691i;

    /* renamed from: j  reason: collision with root package name */
    public PorterDuffXfermode f77692j;

    /* renamed from: k  reason: collision with root package name */
    public RectF f77693k;

    /* renamed from: l  reason: collision with root package name */
    public final ShapeAppearanceModel f77694l;

    /* renamed from: m  reason: collision with root package name */
    public final ShapeAppearanceModel f77695m;

    public static final class a implements e<Bitmap> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AccountAvatarView f77696b;

        public a(AccountAvatarView accountAvatarView) {
            this.f77696b = accountAvatarView;
        }

        public static final void c(AccountAvatarView accountAvatarView, Bitmap bitmap) {
            accountAvatarView.setImageBitmap((Bitmap) null);
            accountAvatarView.f77684b = bitmap;
            accountAvatarView.invalidate();
        }

        /* renamed from: b */
        public boolean onResourceReady(Bitmap bitmap, Object obj, g<Bitmap> gVar, DataSource dataSource, boolean z11) {
            if (!this.f77696b.f77690h) {
                return false;
            }
            AccountAvatarView accountAvatarView = this.f77696b;
            accountAvatarView.post(new b(accountAvatarView, bitmap));
            return false;
        }

        public boolean onLoadFailed(GlideException glideException, Object obj, g<Bitmap> gVar, boolean z11) {
            this.f77696b.f77684b = null;
            return false;
        }
    }

    public AccountAvatarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AccountAvatarView(Context context, AttributeSet attributeSet, int i11, int i12, r rVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    public final void e(Canvas canvas, Paint paint) {
        float sqrt = (float) ((((double) this.f77686d) - (Math.sqrt(3.0d) * ((double) this.f77688f))) / 2.0d);
        Path path = new Path();
        float f11 = ((float) this.f77689g) / 2.0f;
        float sqrt2 = (float) ((Math.sqrt(3.0d) / ((double) 2)) * ((double) this.f77689g));
        float f12 = (float) 2;
        float f13 = (this.f77688f / f12) + 0.0f;
        float f14 = sqrt + sqrt2;
        path.moveTo(f13 - f11, f14);
        path.quadTo(f13, sqrt, f13 + sqrt2, sqrt);
        float f15 = (this.f77688f * 1.5f) + 0.0f;
        path.lineTo(f15 - sqrt2, sqrt);
        path.quadTo(f15, sqrt, f15 + f11, f14);
        float f16 = (f12 * this.f77688f) + 0.0f;
        double d11 = (double) sqrt;
        float sqrt3 = (float) (d11 + ((Math.sqrt(3.0d) * ((double) this.f77688f)) / ((double) 2.0f)));
        float f17 = f16 - f11;
        path.lineTo(f17, sqrt3 - sqrt2);
        path.quadTo(f16, sqrt3, f17, sqrt3 + sqrt2);
        float f18 = (this.f77688f * 1.5f) + 0.0f;
        float sqrt4 = (float) ((Math.sqrt(3.0d) * ((double) this.f77688f)) + d11);
        path.lineTo(f18 + f11, sqrt4 - sqrt2);
        path.quadTo(f18, sqrt4, f18 - sqrt2, sqrt4);
        float f19 = (this.f77688f / 2.0f) + 0.0f;
        float sqrt5 = (float) ((Math.sqrt(3.0d) * ((double) this.f77688f)) + d11);
        path.lineTo(f19 + sqrt2, sqrt5);
        path.quadTo(f19, sqrt5, f19 - f11, sqrt5 - sqrt2);
        float sqrt6 = (float) (d11 + ((Math.sqrt(3.0d) * ((double) this.f77688f)) / 2.0d));
        float f21 = f11 + 0.0f;
        path.lineTo(f21, sqrt6 + sqrt2);
        path.quadTo(0.0f, sqrt6, f21, sqrt6 - sqrt2);
        path.close();
        canvas.drawPath(path, paint);
    }

    public final void f(int i11, int i12, String str, boolean z11) {
        if (com.hbg.module.libkt.base.ext.b.x(str)) {
            this.f77690h = false;
            this.f77684b = null;
            this.f77685c = null;
            setShapeAppearanceModel(this.f77694l);
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            int i13 = layoutParams.width;
            int i14 = this.f77687e;
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
            this.f77686d = c.d(Float.valueOf(f11));
            this.f77689g = c.d(Float.valueOf(f11 * 0.071f));
        }
        if (i12 > 0) {
            this.f77687e = c.d(Float.valueOf((float) i12));
        }
        this.f77688f = ((float) this.f77686d) / 2.0f;
        int i15 = this.f77686d;
        this.f77693k = new RectF(0.0f, 0.0f, (float) i15, (float) i15);
        this.f77690h = z11;
        if (z11) {
            setShapeAppearanceModel(this.f77695m);
            if (this.f77685c == null) {
                int i16 = this.f77686d;
                this.f77685c = Bitmap.createBitmap(i16, i16, Bitmap.Config.ARGB_4444);
            }
            if (getLayoutParams().width != this.f77686d) {
                getLayoutParams().width = this.f77686d;
                getLayoutParams().height = this.f77686d;
                requestLayout();
            }
            if (getContext() == null) {
                return;
            }
            if (!(getContext() instanceof Activity) || !((Activity) getContext()).isFinishing()) {
                com.bumptech.glide.c<Bitmap> r02 = com.bumptech.glide.a.v(getContext().getApplicationContext()).b().M0(str).b(new RequestOptions()).r0(new a(this));
                int i17 = this.f77686d;
                r02.E0(i17, i17);
                return;
            }
            return;
        }
        this.f77685c = null;
        setShapeAppearanceModel(this.f77694l);
        if (getLayoutParams().width != this.f77687e) {
            getLayoutParams().width = this.f77687e;
            getLayoutParams().height = this.f77687e;
            requestLayout();
        }
        com.hbg.module.libkt.base.ext.b.K(this, str, R$drawable.account_user_image);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f77690h && this.f77684b != null) {
            Canvas canvas2 = new Canvas(this.f77685c);
            e(canvas2, this.f77691i);
            this.f77691i.setXfermode(this.f77692j);
            RectF rectF = this.f77693k;
            if (rectF != null) {
                canvas2.drawBitmap(this.f77684b, (Rect) null, rectF, this.f77691i);
            }
            canvas.drawBitmap(this.f77685c, 0.0f, 0.0f, (Paint) null);
            this.f77691i.setXfermode((Xfermode) null);
        }
    }

    public AccountAvatarView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f77686d = -1;
        this.f77687e = -1;
        this.f77689g = c.d(Float.valueOf(5.0f));
        this.f77690h = true;
        this.f77691i = new Paint(1);
        this.f77692j = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        this.f77694l = ShapeAppearanceModel.builder().setAllCornerSizes((CornerSize) new RelativeCornerSize(0.5f)).build();
        this.f77695m = ShapeAppearanceModel.builder().setAllCornerSizes((CornerSize) new RelativeCornerSize(0.0f)).build();
    }
}
