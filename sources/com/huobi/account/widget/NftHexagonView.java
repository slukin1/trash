package com.huobi.account.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import c4.g;
import com.bumptech.glide.c;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.e;
import com.hbg.lib.common.utils.PixelUtils;
import com.huobi.R$styleable;
import g6.b;
import pro.huobi.R;
import wg.x;

public class NftHexagonView extends AppCompatImageView {

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f41973b;

    /* renamed from: c  reason: collision with root package name */
    public Bitmap f41974c;

    /* renamed from: d  reason: collision with root package name */
    public int f41975d;

    /* renamed from: e  reason: collision with root package name */
    public int f41976e;

    /* renamed from: f  reason: collision with root package name */
    public float f41977f;

    /* renamed from: g  reason: collision with root package name */
    public int f41978g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f41979h;

    /* renamed from: i  reason: collision with root package name */
    public Path f41980i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f41981j;

    public class a implements e<Bitmap> {
        public a() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b(Bitmap bitmap) {
            NftHexagonView.this.setImageBitmap((Bitmap) null);
            Bitmap unused = NftHexagonView.this.f41973b = bitmap;
            NftHexagonView.this.invalidate();
        }

        /* renamed from: c */
        public boolean onResourceReady(Bitmap bitmap, Object obj, g<Bitmap> gVar, DataSource dataSource, boolean z11) {
            if (!NftHexagonView.this.f41981j) {
                return false;
            }
            NftHexagonView.this.post(new x(this, bitmap));
            return false;
        }

        public boolean onLoadFailed(GlideException glideException, Object obj, g<Bitmap> gVar, boolean z11) {
            Bitmap unused = NftHexagonView.this.f41973b = null;
            return false;
        }
    }

    public NftHexagonView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final Path e() {
        float sqrt = (float) ((((double) this.f41975d) - (Math.sqrt(3.0d) * ((double) this.f41977f))) / 2.0d);
        Path path = new Path();
        float f11 = ((float) this.f41978g) / 2.0f;
        float sqrt2 = (float) ((Math.sqrt(3.0d) / 2.0d) * ((double) this.f41978g));
        float f12 = (this.f41977f / 2.0f) + 0.0f;
        float f13 = sqrt + sqrt2;
        path.moveTo(f12 - f11, f13);
        path.quadTo(f12, sqrt, f12 + sqrt2, sqrt);
        float f14 = (this.f41977f * 1.5f) + 0.0f;
        path.lineTo(f14 - sqrt2, sqrt);
        path.quadTo(f14, sqrt, f14 + f11, f13);
        float f15 = (this.f41977f * 2.0f) + 0.0f;
        double d11 = (double) sqrt;
        float sqrt3 = (float) (d11 + ((Math.sqrt(3.0d) * ((double) this.f41977f)) / 2.0d));
        float f16 = f15 - f11;
        path.lineTo(f16, sqrt3 - sqrt2);
        path.quadTo(f15, sqrt3, f16, sqrt3 + sqrt2);
        float f17 = (this.f41977f * 1.5f) + 0.0f;
        float sqrt4 = (float) (d11 + (Math.sqrt(3.0d) * ((double) this.f41977f)));
        path.lineTo(f17 + f11, sqrt4 - sqrt2);
        path.quadTo(f17, sqrt4, f17 - sqrt2, sqrt4);
        float f18 = (this.f41977f / 2.0f) + 0.0f;
        float sqrt5 = (float) (d11 + (Math.sqrt(3.0d) * ((double) this.f41977f)));
        path.lineTo(f18 + sqrt2, sqrt5);
        path.quadTo(f18, sqrt5, f18 - f11, sqrt5 - sqrt2);
        float sqrt6 = (float) (d11 + ((Math.sqrt(3.0d) * ((double) this.f41977f)) / 2.0d));
        float f19 = f11 + 0.0f;
        path.lineTo(f19, sqrt6 + sqrt2);
        path.quadTo(0.0f, sqrt6, f19, sqrt6 - sqrt2);
        path.close();
        return path;
    }

    public final void f() {
        Paint paint = new Paint();
        this.f41979h = paint;
        paint.setDither(true);
        this.f41979h.setAntiAlias(true);
    }

    public void g(String str, boolean z11) {
        if (TextUtils.isEmpty(str)) {
            this.f41981j = false;
            this.f41973b = null;
            this.f41974c = null;
            setImageResource(R.drawable.account_user_image);
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            int i11 = layoutParams.width;
            int i12 = this.f41976e;
            if (i11 != i12) {
                layoutParams.width = i12;
                layoutParams.height = i12;
                requestLayout();
                return;
            }
            return;
        }
        ViewGroup.LayoutParams layoutParams2 = getLayoutParams();
        if (!z11) {
            this.f41981j = false;
            this.f41974c = null;
            int i13 = layoutParams2.width;
            int i14 = this.f41976e;
            if (i13 != i14) {
                layoutParams2.width = i14;
                layoutParams2.height = i14;
                requestLayout();
            }
            b.c().j(this, str, R.drawable.account_user_image, b.c().e(R.drawable.account_user_image), (tx.a) null);
            return;
        }
        this.f41981j = true;
        if (this.f41974c == null) {
            int i15 = this.f41975d;
            this.f41974c = Bitmap.createBitmap(i15, i15, Bitmap.Config.ARGB_4444);
        }
        int i16 = layoutParams2.width;
        int i17 = this.f41975d;
        if (i16 != i17) {
            layoutParams2.width = i17;
            layoutParams2.height = i17;
            requestLayout();
        }
        c<Bitmap> r02 = com.bumptech.glide.a.v(getContext()).b().M0(str).b(new RequestOptions()).r0(new a());
        int i18 = this.f41975d;
        r02.E0(i18, i18);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.f41981j || this.f41973b == null) {
            super.onDraw(canvas);
            return;
        }
        Bitmap bitmap = this.f41973b;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.f41979h.setShader(new BitmapShader(bitmap, tileMode, tileMode));
        canvas.drawPath(this.f41980i, this.f41979h);
    }

    public NftHexagonView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f41981j = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.NftHexagonView);
        this.f41975d = (int) obtainStyledAttributes.getDimension(0, (float) PixelUtils.a(76.0f));
        this.f41976e = (int) obtainStyledAttributes.getDimension(1, (float) PixelUtils.a(70.0f));
        this.f41978g = (int) obtainStyledAttributes.getDimension(2, (float) PixelUtils.a(4.0f));
        this.f41977f = ((float) this.f41975d) / 2.0f;
        obtainStyledAttributes.recycle();
        f();
        this.f41980i = e();
    }
}
