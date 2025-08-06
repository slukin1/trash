package com.hbg.module.libkt.base.ext;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ForegroundColorSpan;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.m;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.hbg.lib.common.BaseApplication;
import com.hbg.module.libkt.R$color;
import com.hbg.module.libkt.custom.decoration.WrapContentGridLayoutManager;
import com.hbg.module.libkt.custom.decoration.WrapContentLinearLayoutManager;
import com.iproov.sdk.bridge.OptionsBridge;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import jp.wasabeef.glide.transformations.BlurTransformation;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlinx.coroutines.k;
import kotlinx.coroutines.l;
import n3.g;

public final class b {

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f24511a;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                android.widget.ImageView$ScaleType[] r0 = android.widget.ImageView.ScaleType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_START     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.CENTER_CROP     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                f24511a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.libkt.base.ext.b.a.<clinit>():void");
        }
    }

    /* renamed from: com.hbg.module.libkt.base.ext.b$b  reason: collision with other inner class name */
    public static final class C0215b extends RecyclerView.ItemDecoration {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ float f24512a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ RecyclerView f24513b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f24514c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f24515d;

        public C0215b(float f11, RecyclerView recyclerView, int i11, int i12) {
            this.f24512a = f11;
            this.f24513b = recyclerView;
            this.f24514c = i11;
            this.f24515d = i12;
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            super.getItemOffsets(rect, view, recyclerView, state);
            rect.set(0, 0, 0, c.d(Float.valueOf(this.f24512a)));
        }

        public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
            int i11;
            super.onDraw(canvas, recyclerView, state);
            int paddingLeft = this.f24513b.getPaddingLeft();
            int measuredWidth = this.f24513b.getMeasuredWidth() - this.f24513b.getPaddingRight();
            int childCount = this.f24513b.getChildCount();
            Paint paint = new Paint(1);
            if (this.f24514c == -1) {
                i11 = this.f24513b.getResources().getColor(this.f24515d);
            } else {
                i11 = b.o(this.f24513b.getContext(), this.f24514c);
            }
            paint.setColor(i11);
            paint.setStyle(Paint.Style.FILL);
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt = this.f24513b.getChildAt(i12);
                int bottom = childAt.getBottom() + ((RecyclerView.LayoutParams) childAt.getLayoutParams()).bottomMargin;
                canvas.drawRect((float) paddingLeft, (float) bottom, (float) measuredWidth, (float) (c.d(Float.valueOf(this.f24512a)) + bottom), paint);
            }
        }
    }

    public static final class c extends SimpleTarget<Bitmap> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ImageView f24516b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ k<Boolean> f24517c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f24518d;

        public c(ImageView imageView, k<? super Boolean> kVar, int i11) {
            this.f24516b = imageView;
            this.f24517c = kVar;
            this.f24518d = i11;
        }

        /* renamed from: a */
        public void onResourceReady(Bitmap bitmap, com.bumptech.glide.request.transition.a<? super Bitmap> aVar) {
            this.f24516b.setImageBitmap(bitmap);
            k<Boolean> kVar = this.f24517c;
            Result.a aVar2 = Result.Companion;
            kVar.resumeWith(Result.m3072constructorimpl(Boolean.TRUE));
        }

        public void onLoadFailed(Drawable drawable) {
            super.onLoadFailed(drawable);
            this.f24516b.setImageResource(this.f24518d);
            k<Boolean> kVar = this.f24517c;
            Result.a aVar = Result.Companion;
            kVar.resumeWith(Result.m3072constructorimpl(Boolean.FALSE));
        }
    }

    public static final void A(ImageView imageView, int i11) {
        if (imageView != null && imageView.getContext() != null) {
            if (!(imageView.getContext() instanceof Activity) || !((Activity) imageView.getContext()).isFinishing()) {
                try {
                    com.bumptech.glide.a.v(imageView.getContext()).o(Integer.valueOf(i11)).D0(imageView);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    Unit unit = Unit.f56620a;
                }
            }
        }
    }

    public static final void B(ImageView imageView, String str) {
        C(imageView, str, 0);
    }

    public static final void C(ImageView imageView, String str, int i11) {
        if (imageView != null && imageView.getContext() != null) {
            if (!(imageView.getContext() instanceof Activity) || !((Activity) imageView.getContext()).isFinishing()) {
                try {
                    com.bumptech.glide.a.v(imageView.getContext()).q(str).b((RequestOptions) ((RequestOptions) new RequestOptions().a0(i11)).l(i11)).D0(imageView);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    Unit unit = Unit.f56620a;
                }
            }
        }
    }

    public static final void D(ImageView imageView, String str) {
        G(imageView, str, 0, 0, 0, 0, 28, (Object) null);
    }

    /* JADX WARNING: type inference failed for: r6v1, types: [com.bumptech.glide.request.BaseRequestOptions] */
    /* JADX WARNING: type inference failed for: r8v10, types: [com.bumptech.glide.request.BaseRequestOptions] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void E(android.widget.ImageView r5, java.lang.String r6, int r7, int r8, int r9, int r10) {
        /*
            if (r5 == 0) goto L_0x00a7
            android.content.Context r0 = r5.getContext()
            if (r0 == 0) goto L_0x00a7
            android.content.Context r0 = r5.getContext()
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 == 0) goto L_0x001e
            android.content.Context r0 = r5.getContext()
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r0 = r0.isFinishing()
            if (r0 == 0) goto L_0x001e
            goto L_0x00a7
        L_0x001e:
            n3.c r0 = new n3.c     // Catch:{ all -> 0x00a0 }
            r1 = 1
            n3.g[] r2 = new n3.g[r1]     // Catch:{ all -> 0x00a0 }
            com.bumptech.glide.load.resource.bitmap.CenterCrop r3 = new com.bumptech.glide.load.resource.bitmap.CenterCrop     // Catch:{ all -> 0x00a0 }
            r3.<init>()     // Catch:{ all -> 0x00a0 }
            r4 = 0
            r2[r4] = r3     // Catch:{ all -> 0x00a0 }
            r0.<init>((n3.g<T>[]) r2)     // Catch:{ all -> 0x00a0 }
            com.bumptech.glide.request.RequestOptions r0 = com.bumptech.glide.request.RequestOptions.r0(r0)     // Catch:{ all -> 0x00a0 }
            com.bumptech.glide.load.resource.bitmap.CenterCrop r2 = new com.bumptech.glide.load.resource.bitmap.CenterCrop     // Catch:{ all -> 0x00a0 }
            r2.<init>()     // Catch:{ all -> 0x00a0 }
            com.bumptech.glide.request.BaseRequestOptions r0 = r0.n0(r2)     // Catch:{ all -> 0x00a0 }
            com.bumptech.glide.request.RequestOptions r0 = (com.bumptech.glide.request.RequestOptions) r0     // Catch:{ all -> 0x00a0 }
            com.bumptech.glide.load.engine.DiskCacheStrategy r2 = com.bumptech.glide.load.engine.DiskCacheStrategy.f63711c     // Catch:{ all -> 0x00a0 }
            com.bumptech.glide.request.BaseRequestOptions r0 = r0.h(r2)     // Catch:{ all -> 0x00a0 }
            com.bumptech.glide.request.RequestOptions r0 = (com.bumptech.glide.request.RequestOptions) r0     // Catch:{ all -> 0x00a0 }
            com.bumptech.glide.request.BaseRequestOptions r0 = r0.a0(r7)     // Catch:{ all -> 0x00a0 }
            com.bumptech.glide.request.RequestOptions r0 = (com.bumptech.glide.request.RequestOptions) r0     // Catch:{ all -> 0x00a0 }
            com.bumptech.glide.request.BaseRequestOptions r0 = r0.l(r7)     // Catch:{ all -> 0x00a0 }
            com.bumptech.glide.request.RequestOptions r0 = (com.bumptech.glide.request.RequestOptions) r0     // Catch:{ all -> 0x00a0 }
            if (r8 <= 0) goto L_0x006b
            r2 = 2
            n3.g[] r2 = new n3.g[r2]     // Catch:{ all -> 0x00a0 }
            com.bumptech.glide.load.resource.bitmap.CenterCrop r3 = new com.bumptech.glide.load.resource.bitmap.CenterCrop     // Catch:{ all -> 0x00a0 }
            r3.<init>()     // Catch:{ all -> 0x00a0 }
            r2[r4] = r3     // Catch:{ all -> 0x00a0 }
            com.bumptech.glide.load.resource.bitmap.m r3 = new com.bumptech.glide.load.resource.bitmap.m     // Catch:{ all -> 0x00a0 }
            r3.<init>(r8)     // Catch:{ all -> 0x00a0 }
            r2[r1] = r3     // Catch:{ all -> 0x00a0 }
            com.bumptech.glide.request.BaseRequestOptions r8 = r0.p0(r2)     // Catch:{ all -> 0x00a0 }
            r0 = r8
            com.bumptech.glide.request.RequestOptions r0 = (com.bumptech.glide.request.RequestOptions) r0     // Catch:{ all -> 0x00a0 }
        L_0x006b:
            android.content.Context r8 = r5.getContext()     // Catch:{ all -> 0x00a0 }
            com.bumptech.glide.d r8 = com.bumptech.glide.a.v(r8)     // Catch:{ all -> 0x00a0 }
            com.bumptech.glide.c r8 = r8.q(r6)     // Catch:{ all -> 0x00a0 }
            com.bumptech.glide.c r8 = r8.b(r0)     // Catch:{ all -> 0x00a0 }
            if (r7 <= 0) goto L_0x0091
            android.content.Context r7 = r5.getContext()     // Catch:{ all -> 0x00a0 }
            com.bumptech.glide.d r7 = com.bumptech.glide.a.v(r7)     // Catch:{ all -> 0x00a0 }
            com.bumptech.glide.c r6 = r7.q(r6)     // Catch:{ all -> 0x00a0 }
            com.bumptech.glide.c r6 = r6.b(r0)     // Catch:{ all -> 0x00a0 }
            com.bumptech.glide.c r8 = r8.T0(r6)     // Catch:{ all -> 0x00a0 }
        L_0x0091:
            if (r9 <= 0) goto L_0x009c
            if (r10 <= 0) goto L_0x009c
            com.bumptech.glide.request.BaseRequestOptions r6 = r8.Z(r9, r10)     // Catch:{ all -> 0x00a0 }
            r8 = r6
            com.bumptech.glide.c r8 = (com.bumptech.glide.c) r8     // Catch:{ all -> 0x00a0 }
        L_0x009c:
            r8.D0(r5)     // Catch:{ all -> 0x00a0 }
            goto L_0x00a7
        L_0x00a0:
            r5 = move-exception
            r5.printStackTrace()
            kotlin.Unit r5 = kotlin.Unit.f56620a
        L_0x00a7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.libkt.base.ext.b.E(android.widget.ImageView, java.lang.String, int, int, int, int):void");
    }

    /* JADX WARNING: type inference failed for: r6v1, types: [com.bumptech.glide.request.BaseRequestOptions] */
    /* JADX WARNING: type inference failed for: r8v10, types: [com.bumptech.glide.request.BaseRequestOptions] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void F(android.widget.ImageView r5, java.lang.String r6, android.graphics.drawable.Drawable r7, int r8, int r9, int r10) {
        /*
            if (r5 == 0) goto L_0x00a7
            android.content.Context r0 = r5.getContext()
            if (r0 == 0) goto L_0x00a7
            android.content.Context r0 = r5.getContext()
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 == 0) goto L_0x001e
            android.content.Context r0 = r5.getContext()
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r0 = r0.isFinishing()
            if (r0 == 0) goto L_0x001e
            goto L_0x00a7
        L_0x001e:
            n3.c r0 = new n3.c     // Catch:{ all -> 0x00a0 }
            r1 = 1
            n3.g[] r2 = new n3.g[r1]     // Catch:{ all -> 0x00a0 }
            com.bumptech.glide.load.resource.bitmap.CenterCrop r3 = new com.bumptech.glide.load.resource.bitmap.CenterCrop     // Catch:{ all -> 0x00a0 }
            r3.<init>()     // Catch:{ all -> 0x00a0 }
            r4 = 0
            r2[r4] = r3     // Catch:{ all -> 0x00a0 }
            r0.<init>((n3.g<T>[]) r2)     // Catch:{ all -> 0x00a0 }
            com.bumptech.glide.request.RequestOptions r0 = com.bumptech.glide.request.RequestOptions.r0(r0)     // Catch:{ all -> 0x00a0 }
            com.bumptech.glide.load.resource.bitmap.CenterCrop r2 = new com.bumptech.glide.load.resource.bitmap.CenterCrop     // Catch:{ all -> 0x00a0 }
            r2.<init>()     // Catch:{ all -> 0x00a0 }
            com.bumptech.glide.request.BaseRequestOptions r0 = r0.n0(r2)     // Catch:{ all -> 0x00a0 }
            com.bumptech.glide.request.RequestOptions r0 = (com.bumptech.glide.request.RequestOptions) r0     // Catch:{ all -> 0x00a0 }
            com.bumptech.glide.load.engine.DiskCacheStrategy r2 = com.bumptech.glide.load.engine.DiskCacheStrategy.f63711c     // Catch:{ all -> 0x00a0 }
            com.bumptech.glide.request.BaseRequestOptions r0 = r0.h(r2)     // Catch:{ all -> 0x00a0 }
            com.bumptech.glide.request.RequestOptions r0 = (com.bumptech.glide.request.RequestOptions) r0     // Catch:{ all -> 0x00a0 }
            com.bumptech.glide.request.BaseRequestOptions r0 = r0.b0(r7)     // Catch:{ all -> 0x00a0 }
            com.bumptech.glide.request.RequestOptions r0 = (com.bumptech.glide.request.RequestOptions) r0     // Catch:{ all -> 0x00a0 }
            com.bumptech.glide.request.BaseRequestOptions r0 = r0.m(r7)     // Catch:{ all -> 0x00a0 }
            com.bumptech.glide.request.RequestOptions r0 = (com.bumptech.glide.request.RequestOptions) r0     // Catch:{ all -> 0x00a0 }
            if (r8 <= 0) goto L_0x006b
            r2 = 2
            n3.g[] r2 = new n3.g[r2]     // Catch:{ all -> 0x00a0 }
            com.bumptech.glide.load.resource.bitmap.CenterCrop r3 = new com.bumptech.glide.load.resource.bitmap.CenterCrop     // Catch:{ all -> 0x00a0 }
            r3.<init>()     // Catch:{ all -> 0x00a0 }
            r2[r4] = r3     // Catch:{ all -> 0x00a0 }
            com.bumptech.glide.load.resource.bitmap.m r3 = new com.bumptech.glide.load.resource.bitmap.m     // Catch:{ all -> 0x00a0 }
            r3.<init>(r8)     // Catch:{ all -> 0x00a0 }
            r2[r1] = r3     // Catch:{ all -> 0x00a0 }
            com.bumptech.glide.request.BaseRequestOptions r8 = r0.p0(r2)     // Catch:{ all -> 0x00a0 }
            r0 = r8
            com.bumptech.glide.request.RequestOptions r0 = (com.bumptech.glide.request.RequestOptions) r0     // Catch:{ all -> 0x00a0 }
        L_0x006b:
            android.content.Context r8 = r5.getContext()     // Catch:{ all -> 0x00a0 }
            com.bumptech.glide.d r8 = com.bumptech.glide.a.v(r8)     // Catch:{ all -> 0x00a0 }
            com.bumptech.glide.c r8 = r8.q(r6)     // Catch:{ all -> 0x00a0 }
            com.bumptech.glide.c r8 = r8.b(r0)     // Catch:{ all -> 0x00a0 }
            if (r7 == 0) goto L_0x0091
            android.content.Context r7 = r5.getContext()     // Catch:{ all -> 0x00a0 }
            com.bumptech.glide.d r7 = com.bumptech.glide.a.v(r7)     // Catch:{ all -> 0x00a0 }
            com.bumptech.glide.c r6 = r7.q(r6)     // Catch:{ all -> 0x00a0 }
            com.bumptech.glide.c r6 = r6.b(r0)     // Catch:{ all -> 0x00a0 }
            com.bumptech.glide.c r8 = r8.T0(r6)     // Catch:{ all -> 0x00a0 }
        L_0x0091:
            if (r9 <= 0) goto L_0x009c
            if (r10 <= 0) goto L_0x009c
            com.bumptech.glide.request.BaseRequestOptions r6 = r8.Z(r9, r10)     // Catch:{ all -> 0x00a0 }
            r8 = r6
            com.bumptech.glide.c r8 = (com.bumptech.glide.c) r8     // Catch:{ all -> 0x00a0 }
        L_0x009c:
            r8.D0(r5)     // Catch:{ all -> 0x00a0 }
            goto L_0x00a7
        L_0x00a0:
            r5 = move-exception
            r5.printStackTrace()
            kotlin.Unit r5 = kotlin.Unit.f56620a
        L_0x00a7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.libkt.base.ext.b.F(android.widget.ImageView, java.lang.String, android.graphics.drawable.Drawable, int, int, int):void");
    }

    public static /* synthetic */ void G(ImageView imageView, String str, int i11, int i12, int i13, int i14, int i15, Object obj) {
        int i16 = (i15 & 2) != 0 ? 0 : i11;
        if ((i15 & 4) != 0) {
            i12 = -1;
        }
        E(imageView, str, i16, i12, (i15 & 8) != 0 ? 0 : i13, (i15 & 16) != 0 ? 0 : i14);
    }

    public static /* synthetic */ void H(ImageView imageView, String str, Drawable drawable, int i11, int i12, int i13, int i14, Object obj) {
        if ((i14 & 4) != 0) {
            i11 = -1;
        }
        F(imageView, str, drawable, i11, (i14 & 8) != 0 ? 0 : i12, (i14 & 16) != 0 ? 0 : i13);
    }

    public static final Object I(ImageView imageView, String str, int i11, kotlin.coroutines.c<? super Boolean> cVar) {
        l lVar = new l(IntrinsicsKt__IntrinsicsJvmKt.c(cVar), 1);
        lVar.A();
        com.bumptech.glide.a.v(imageView.getContext()).b().M0(str).A0(new c(imageView, lVar, i11));
        Object v11 = lVar.v();
        if (v11 == IntrinsicsKt__IntrinsicsKt.d()) {
            f.c(cVar);
        }
        return v11;
    }

    public static final void J(ImageView imageView, String str) {
        K(imageView, str, 0);
    }

    public static final void K(ImageView imageView, String str, int i11) {
        if (imageView != null && imageView.getContext() != null) {
            if (!(imageView.getContext() instanceof Activity) || !((Activity) imageView.getContext()).isFinishing()) {
                try {
                    RequestOptions requestOptions = (RequestOptions) ((RequestOptions) ((RequestOptions) RequestOptions.r0(new n3.c((g<T>[]) new g[]{new CenterCrop(), new CircleCrop()})).h(DiskCacheStrategy.f63711c)).a0(i11)).l(i11);
                    com.bumptech.glide.c<Drawable> s02 = com.bumptech.glide.a.v(imageView.getContext()).q(str).b(requestOptions);
                    if (i11 > 0) {
                        s02 = s02.T0(com.bumptech.glide.a.v(imageView.getContext()).q(str).b(requestOptions));
                    }
                    s02.D0(imageView);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    Unit unit = Unit.f56620a;
                }
            }
        }
    }

    public static final void L(ImageView imageView, String str, float f11) {
        M(imageView, str, f11, 0);
    }

    /* JADX WARNING: type inference failed for: r7v8, types: [com.bumptech.glide.request.BaseRequestOptions] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void M(android.widget.ImageView r5, java.lang.String r6, float r7, int r8) {
        /*
            if (r5 == 0) goto L_0x00a3
            android.content.Context r0 = r5.getContext()
            if (r0 == 0) goto L_0x00a3
            android.content.Context r0 = r5.getContext()
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 == 0) goto L_0x001e
            android.content.Context r0 = r5.getContext()
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r0 = r0.isFinishing()
            if (r0 == 0) goto L_0x001e
            goto L_0x00a3
        L_0x001e:
            n3.c r0 = new n3.c     // Catch:{ all -> 0x009c }
            r1 = 1
            n3.g[] r2 = new n3.g[r1]     // Catch:{ all -> 0x009c }
            com.bumptech.glide.load.resource.bitmap.CenterCrop r3 = new com.bumptech.glide.load.resource.bitmap.CenterCrop     // Catch:{ all -> 0x009c }
            r3.<init>()     // Catch:{ all -> 0x009c }
            r4 = 0
            r2[r4] = r3     // Catch:{ all -> 0x009c }
            r0.<init>((n3.g<T>[]) r2)     // Catch:{ all -> 0x009c }
            com.bumptech.glide.request.RequestOptions r0 = com.bumptech.glide.request.RequestOptions.r0(r0)     // Catch:{ all -> 0x009c }
            com.bumptech.glide.load.resource.bitmap.CenterCrop r2 = new com.bumptech.glide.load.resource.bitmap.CenterCrop     // Catch:{ all -> 0x009c }
            r2.<init>()     // Catch:{ all -> 0x009c }
            com.bumptech.glide.request.BaseRequestOptions r0 = r0.n0(r2)     // Catch:{ all -> 0x009c }
            com.bumptech.glide.request.RequestOptions r0 = (com.bumptech.glide.request.RequestOptions) r0     // Catch:{ all -> 0x009c }
            com.bumptech.glide.load.engine.DiskCacheStrategy r2 = com.bumptech.glide.load.engine.DiskCacheStrategy.f63711c     // Catch:{ all -> 0x009c }
            com.bumptech.glide.request.BaseRequestOptions r0 = r0.h(r2)     // Catch:{ all -> 0x009c }
            com.bumptech.glide.request.RequestOptions r0 = (com.bumptech.glide.request.RequestOptions) r0     // Catch:{ all -> 0x009c }
            com.bumptech.glide.request.BaseRequestOptions r0 = r0.a0(r8)     // Catch:{ all -> 0x009c }
            com.bumptech.glide.request.RequestOptions r0 = (com.bumptech.glide.request.RequestOptions) r0     // Catch:{ all -> 0x009c }
            com.bumptech.glide.request.BaseRequestOptions r0 = r0.l(r8)     // Catch:{ all -> 0x009c }
            com.bumptech.glide.request.RequestOptions r0 = (com.bumptech.glide.request.RequestOptions) r0     // Catch:{ all -> 0x009c }
            r2 = 0
            int r2 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r2 <= 0) goto L_0x0072
            r2 = 2
            n3.g[] r2 = new n3.g[r2]     // Catch:{ all -> 0x009c }
            com.bumptech.glide.load.resource.bitmap.CenterCrop r3 = new com.bumptech.glide.load.resource.bitmap.CenterCrop     // Catch:{ all -> 0x009c }
            r3.<init>()     // Catch:{ all -> 0x009c }
            r2[r4] = r3     // Catch:{ all -> 0x009c }
            com.bumptech.glide.load.resource.bitmap.m r3 = new com.bumptech.glide.load.resource.bitmap.m     // Catch:{ all -> 0x009c }
            int r7 = com.hbg.module.libkt.base.ext.c.a(r7)     // Catch:{ all -> 0x009c }
            r3.<init>(r7)     // Catch:{ all -> 0x009c }
            r2[r1] = r3     // Catch:{ all -> 0x009c }
            com.bumptech.glide.request.BaseRequestOptions r7 = r0.p0(r2)     // Catch:{ all -> 0x009c }
            r0 = r7
            com.bumptech.glide.request.RequestOptions r0 = (com.bumptech.glide.request.RequestOptions) r0     // Catch:{ all -> 0x009c }
        L_0x0072:
            android.content.Context r7 = r5.getContext()     // Catch:{ all -> 0x009c }
            com.bumptech.glide.d r7 = com.bumptech.glide.a.v(r7)     // Catch:{ all -> 0x009c }
            com.bumptech.glide.c r7 = r7.q(r6)     // Catch:{ all -> 0x009c }
            com.bumptech.glide.c r7 = r7.b(r0)     // Catch:{ all -> 0x009c }
            if (r8 <= 0) goto L_0x0098
            android.content.Context r8 = r5.getContext()     // Catch:{ all -> 0x009c }
            com.bumptech.glide.d r8 = com.bumptech.glide.a.v(r8)     // Catch:{ all -> 0x009c }
            com.bumptech.glide.c r6 = r8.q(r6)     // Catch:{ all -> 0x009c }
            com.bumptech.glide.c r6 = r6.b(r0)     // Catch:{ all -> 0x009c }
            com.bumptech.glide.c r7 = r7.T0(r6)     // Catch:{ all -> 0x009c }
        L_0x0098:
            r7.D0(r5)     // Catch:{ all -> 0x009c }
            goto L_0x00a3
        L_0x009c:
            r5 = move-exception
            r5.printStackTrace()
            kotlin.Unit r5 = kotlin.Unit.f56620a
        L_0x00a3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.libkt.base.ext.b.M(android.widget.ImageView, java.lang.String, float, int):void");
    }

    public static final void N(ImageView imageView, String str, float f11, int i11, int i12) {
        Context context;
        if (imageView != null && str != null && (context = imageView.getContext()) != null) {
            if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
                try {
                    List p11 = CollectionsKt__CollectionsKt.p(new CenterCrop());
                    if (f11 > 0.0f) {
                        p11.add(new m(c.a(f11)));
                    }
                    com.bumptech.glide.a.v(context).q(str).b((RequestOptions) ((RequestOptions) ((RequestOptions) ((RequestOptions) new RequestOptions().n0(new n3.c(p11))).h(DiskCacheStrategy.f63711c)).a0(i11)).l(i12)).D0(imageView);
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            }
        }
    }

    /* JADX WARNING: type inference failed for: r8v4, types: [com.bumptech.glide.request.BaseRequestOptions] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void O(android.widget.ImageView r7, java.lang.String r8, int r9, int r10) {
        /*
            if (r7 == 0) goto L_0x00d2
            android.content.Context r0 = r7.getContext()
            if (r0 == 0) goto L_0x00d2
            android.content.Context r0 = r7.getContext()
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 == 0) goto L_0x001e
            android.content.Context r0 = r7.getContext()
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r0 = r0.isFinishing()
            if (r0 == 0) goto L_0x001e
            goto L_0x00d2
        L_0x001e:
            android.widget.ImageView$ScaleType r0 = r7.getScaleType()
            if (r0 != 0) goto L_0x0026
            r0 = -1
            goto L_0x002e
        L_0x0026:
            int[] r1 = com.hbg.module.libkt.base.ext.b.a.f24511a
            int r0 = r0.ordinal()
            r0 = r1[r0]
        L_0x002e:
            r1 = 2
            r2 = 1
            if (r0 == r2) goto L_0x0040
            if (r0 == r1) goto L_0x003a
            com.bumptech.glide.load.resource.bitmap.FitCenter r0 = new com.bumptech.glide.load.resource.bitmap.FitCenter
            r0.<init>()
            goto L_0x0045
        L_0x003a:
            com.bumptech.glide.load.resource.bitmap.CenterCrop r0 = new com.bumptech.glide.load.resource.bitmap.CenterCrop
            r0.<init>()
            goto L_0x0045
        L_0x0040:
            com.huobi.utils.glide.LongImageFitStart r0 = new com.huobi.utils.glide.LongImageFitStart
            r0.<init>()
        L_0x0045:
            n3.c r3 = new n3.c     // Catch:{ all -> 0x00cb }
            n3.g[] r4 = new n3.g[r2]     // Catch:{ all -> 0x00cb }
            com.bumptech.glide.load.resource.bitmap.CenterCrop r5 = new com.bumptech.glide.load.resource.bitmap.CenterCrop     // Catch:{ all -> 0x00cb }
            r5.<init>()     // Catch:{ all -> 0x00cb }
            r6 = 0
            r4[r6] = r5     // Catch:{ all -> 0x00cb }
            r3.<init>((n3.g<T>[]) r4)     // Catch:{ all -> 0x00cb }
            com.bumptech.glide.request.RequestOptions r3 = com.bumptech.glide.request.RequestOptions.r0(r3)     // Catch:{ all -> 0x00cb }
            if (r10 <= 0) goto L_0x006c
            n3.g[] r1 = new n3.g[r1]     // Catch:{ all -> 0x00cb }
            r1[r6] = r0     // Catch:{ all -> 0x00cb }
            com.bumptech.glide.load.resource.bitmap.m r0 = new com.bumptech.glide.load.resource.bitmap.m     // Catch:{ all -> 0x00cb }
            r0.<init>(r10)     // Catch:{ all -> 0x00cb }
            r1[r2] = r0     // Catch:{ all -> 0x00cb }
            com.bumptech.glide.request.BaseRequestOptions r10 = r3.p0(r1)     // Catch:{ all -> 0x00cb }
            com.bumptech.glide.request.RequestOptions r10 = (com.bumptech.glide.request.RequestOptions) r10     // Catch:{ all -> 0x00cb }
            goto L_0x0072
        L_0x006c:
            com.bumptech.glide.request.BaseRequestOptions r10 = r3.n0(r0)     // Catch:{ all -> 0x00cb }
            com.bumptech.glide.request.RequestOptions r10 = (com.bumptech.glide.request.RequestOptions) r10     // Catch:{ all -> 0x00cb }
        L_0x0072:
            com.bumptech.glide.load.engine.DiskCacheStrategy r0 = com.bumptech.glide.load.engine.DiskCacheStrategy.f63711c     // Catch:{ all -> 0x00cb }
            com.bumptech.glide.request.BaseRequestOptions r10 = r10.h(r0)     // Catch:{ all -> 0x00cb }
            com.bumptech.glide.request.RequestOptions r10 = (com.bumptech.glide.request.RequestOptions) r10     // Catch:{ all -> 0x00cb }
            com.bumptech.glide.request.BaseRequestOptions r10 = r10.a0(r9)     // Catch:{ all -> 0x00cb }
            com.bumptech.glide.request.RequestOptions r10 = (com.bumptech.glide.request.RequestOptions) r10     // Catch:{ all -> 0x00cb }
            com.bumptech.glide.request.BaseRequestOptions r10 = r10.l(r9)     // Catch:{ all -> 0x00cb }
            com.bumptech.glide.request.RequestOptions r10 = (com.bumptech.glide.request.RequestOptions) r10     // Catch:{ all -> 0x00cb }
            android.content.Context r0 = r7.getContext()     // Catch:{ all -> 0x00cb }
            com.bumptech.glide.d r0 = com.bumptech.glide.a.v(r0)     // Catch:{ all -> 0x00cb }
            com.bumptech.glide.c r0 = r0.q(r8)     // Catch:{ all -> 0x00cb }
            com.bumptech.glide.c r0 = r0.b(r10)     // Catch:{ all -> 0x00cb }
            if (r9 <= 0) goto L_0x00ac
            android.content.Context r9 = r7.getContext()     // Catch:{ all -> 0x00cb }
            com.bumptech.glide.d r9 = com.bumptech.glide.a.v(r9)     // Catch:{ all -> 0x00cb }
            com.bumptech.glide.c r8 = r9.q(r8)     // Catch:{ all -> 0x00cb }
            com.bumptech.glide.c r8 = r8.b(r10)     // Catch:{ all -> 0x00cb }
            com.bumptech.glide.c r0 = r0.T0(r8)     // Catch:{ all -> 0x00cb }
        L_0x00ac:
            int r8 = r7.getWidth()     // Catch:{ all -> 0x00cb }
            if (r8 <= 0) goto L_0x00c7
            int r8 = r7.getHeight()     // Catch:{ all -> 0x00cb }
            if (r8 <= 0) goto L_0x00c7
            int r8 = r7.getWidth()     // Catch:{ all -> 0x00cb }
            int r9 = r7.getHeight()     // Catch:{ all -> 0x00cb }
            com.bumptech.glide.request.BaseRequestOptions r8 = r0.Z(r8, r9)     // Catch:{ all -> 0x00cb }
            r0 = r8
            com.bumptech.glide.c r0 = (com.bumptech.glide.c) r0     // Catch:{ all -> 0x00cb }
        L_0x00c7:
            r0.D0(r7)     // Catch:{ all -> 0x00cb }
            goto L_0x00d2
        L_0x00cb:
            r7 = move-exception
            r7.printStackTrace()
            kotlin.Unit r7 = kotlin.Unit.f56620a
        L_0x00d2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.libkt.base.ext.b.O(android.widget.ImageView, java.lang.String, int, int):void");
    }

    public static final void P(View view) {
        if (y(view)) {
            view.requestLayout();
        } else {
            view.post(new a(view));
        }
    }

    public static final void Q(View view) {
        view.requestLayout();
    }

    public static final void R(TextView textView) {
        TextPaint textPaint = null;
        TextPaint paint = textView != null ? textView.getPaint() : null;
        if (paint != null) {
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
        }
        if (textView != null) {
            textPaint = textView.getPaint();
        }
        if (textPaint != null) {
            textPaint.setStrokeWidth(0.7f);
        }
    }

    public static final void S(Context context) {
        ((InputMethodManager) context.getSystemService("input_method")).toggleSoftInput(0, 2);
    }

    @SuppressLint({"DiscouragedApi", "InternalInsetResource"})
    public static final int T(Application application) {
        int identifier = application.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return application.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static final void b(RecyclerView recyclerView, float f11, int i11, int i12) {
        if (recyclerView != null) {
            recyclerView.addItemDecoration(new C0215b(f11, recyclerView, i12, i11));
        }
    }

    public static /* synthetic */ void c(RecyclerView recyclerView, float f11, int i11, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            f11 = 0.5f;
        }
        if ((i13 & 2) != 0) {
            i11 = R$color.baseColorSecondarySeparator;
        }
        if ((i13 & 4) != 0) {
            i12 = -1;
        }
        b(recyclerView, f11, i11, i12);
    }

    public static final int d(Object obj) {
        if (obj instanceof Number) {
            return ((Number) obj).intValue();
        }
        return 0;
    }

    public static final boolean e(Activity activity) {
        return activity != null && !activity.isFinishing();
    }

    public static final void f(RecyclerView recyclerView) {
        RecyclerView.ItemAnimator itemAnimator = null;
        SimpleItemAnimator simpleItemAnimator = (SimpleItemAnimator) (recyclerView != null ? recyclerView.getItemAnimator() : null);
        if (simpleItemAnimator != null) {
            simpleItemAnimator.setSupportsChangeAnimations(false);
        }
        if (recyclerView != null) {
            itemAnimator = recyclerView.getItemAnimator();
        }
        if (itemAnimator != null) {
            itemAnimator.setChangeDuration(0);
        }
    }

    public static final String g(Double d11, int i11) {
        if (d11 == null) {
            return "";
        }
        double doubleValue = d11.doubleValue();
        d0 d0Var = d0.f56774a;
        return String.format("%." + i11 + 'f', Arrays.copyOf(new Object[]{Double.valueOf(doubleValue)}, 1));
    }

    public static final int h(int i11) {
        if (Build.VERSION.SDK_INT >= 23) {
            return BaseApplication.b().getColor(i11);
        }
        return BaseApplication.b().getResources().getColor(i11);
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    public static final Drawable i(int i11) {
        return BaseApplication.b().getDrawable(i11);
    }

    public static final String j(int i11) {
        return BaseApplication.b().getResources().getString(i11);
    }

    public static final GridLayoutManager k(Context context, int i11) {
        WrapContentGridLayoutManager wrapContentGridLayoutManager = new WrapContentGridLayoutManager(context, i11);
        wrapContentGridLayoutManager.setOrientation(1);
        return wrapContentGridLayoutManager;
    }

    public static final me.a l(int i11, float f11) {
        return new me.a(i11, c.a(f11), false, false, 8, (r) null);
    }

    public static final LinearLayoutManager m(Context context) {
        WrapContentLinearLayoutManager wrapContentLinearLayoutManager = new WrapContentLinearLayoutManager(context);
        wrapContentLinearLayoutManager.setOrientation(0);
        return wrapContentLinearLayoutManager;
    }

    public static final SpannableStringBuilder n(String str, String str2) {
        if (str2 == null) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str2);
        if (x(str)) {
            return spannableStringBuilder;
        }
        Matcher matcher = Pattern.compile(str.toUpperCase(Locale.getDefault())).matcher(str2.toUpperCase(Locale.getDefault()));
        while (matcher.find()) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(h(R$color.baseColorMajorTheme100)), matcher.start(), matcher.end(), 33);
        }
        return spannableStringBuilder;
    }

    public static final int o(Context context, int i11) {
        TypedValue typedValue = new TypedValue();
        if (context != null) {
            try {
                Resources.Theme theme = context.getTheme();
                if (theme != null) {
                    theme.resolveAttribute(i11, typedValue, true);
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
                return 0;
            }
        }
        return typedValue.data;
    }

    public static final Drawable p(Context context, int i11) {
        Resources resources;
        TypedValue typedValue = new TypedValue();
        if (context != null) {
            try {
                Resources.Theme theme = context.getTheme();
                if (theme != null) {
                    theme.resolveAttribute(i11, typedValue, true);
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
                return null;
            }
        }
        if (context == null || (resources = context.getResources()) == null) {
            return null;
        }
        return resources.getDrawable(typedValue.resourceId);
    }

    public static final int q(Context context, int i11) {
        TypedValue typedValue = new TypedValue();
        if (context != null) {
            try {
                Resources.Theme theme = context.getTheme();
                if (theme != null) {
                    theme.resolveAttribute(i11, typedValue, true);
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
                return -1;
            }
        }
        return typedValue.resourceId;
    }

    public static final String r() {
        try {
            Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", new Class[]{String.class});
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke((Object) null, new Object[]{"qemu.hw.mainkeys"}).toString();
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public static final int s(Context context) {
        int identifier;
        if (context == null || !u(context) || (identifier = context.getResources().getIdentifier("navigation_bar_height", "dimen", "android")) <= 0) {
            return 0;
        }
        return context.getResources().getDimensionPixelSize(identifier);
    }

    public static final LinearLayoutManager t(Context context) {
        WrapContentLinearLayoutManager wrapContentLinearLayoutManager = new WrapContentLinearLayoutManager(context);
        wrapContentLinearLayoutManager.setOrientation(1);
        return wrapContentLinearLayoutManager;
    }

    public static final boolean u(Context context) {
        if (context == null) {
            return false;
        }
        int identifier = context.getResources().getIdentifier("config_showNavigationBar", "bool", "android");
        if (identifier != 0) {
            boolean z11 = context.getResources().getBoolean(identifier);
            String r11 = r();
            if (x.b("1", r11)) {
                return false;
            }
            if (!x.b("0", r11)) {
                return z11;
            }
        } else if (ViewConfiguration.get(context).hasPermanentMenuKey()) {
            return false;
        }
        return true;
    }

    public static final void v(Context context) {
        Activity activity;
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = context instanceof ContextThemeWrapper ? (Activity) ((ContextThemeWrapper) context).getBaseContext() : null;
        }
        if (activity != null) {
            inputMethodManager.hideSoftInputFromWindow(activity.getWindow().getDecorView().getWindowToken(), 0);
        }
    }

    public static final <T> boolean w(Collection<? extends T> collection) {
        return collection == null || collection.isEmpty();
    }

    public static final boolean x(String str) {
        if (str != null) {
            if (!(str.length() == 0)) {
                if (!(StringsKt__StringsKt.i1(str).toString().length() == 0) && !x.b(str.toLowerCase(Locale.ROOT), OptionsBridge.NULL_VALUE)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static final boolean y(View view) {
        boolean z11;
        if (!view.isInLayout()) {
            ViewParent parent = view.getParent();
            while (true) {
                if (parent == null) {
                    z11 = false;
                    break;
                } else if (parent.isLayoutRequested()) {
                    z11 = true;
                    break;
                } else {
                    parent = parent.getParent();
                }
            }
            if (!z11) {
                return true;
            }
        } else if (!view.isLayoutRequested()) {
            return true;
        }
        return false;
    }

    public static final void z(ImageView imageView, String str) {
        if (imageView != null && imageView.getContext() != null) {
            if (!(imageView.getContext() instanceof Activity) || !((Activity) imageView.getContext()).isFinishing()) {
                try {
                    com.bumptech.glide.a.v(imageView.getContext()).q(str).b(RequestOptions.r0(new BlurTransformation(25, 3))).D0(imageView);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    Unit unit = Unit.f56620a;
                }
            }
        }
    }
}
