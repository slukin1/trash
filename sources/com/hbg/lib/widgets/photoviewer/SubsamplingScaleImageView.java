package com.hbg.lib.widgets.photoviewer;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import com.hbg.lib.widgets.R$styleable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SubsamplingScaleImageView extends View {
    public static final String C0 = SubsamplingScaleImageView.class.getSimpleName();
    public static final List<Integer> D0 = Arrays.asList(new Integer[]{0, 90, 180, 270, -1});
    public static final List<Integer> E0 = Arrays.asList(new Integer[]{1, 2, 3});
    public static final List<Integer> F0 = Arrays.asList(new Integer[]{2, 1});
    public static final List<Integer> G0 = Arrays.asList(new Integer[]{1, 2, 3});
    public static final List<Integer> H0 = Arrays.asList(new Integer[]{2, 1, 3, 4});
    public static Bitmap.Config I0;
    public PointF A;
    public final float[] A0 = new float[8];
    public PointF B;
    public final float B0 = getResources().getDisplayMetrics().density;
    public PointF C;
    public Float D;
    public PointF E;
    public PointF F;
    public int G;
    public int H;
    public int I;
    public Rect J;
    public Rect K;
    public boolean L;
    public boolean M;
    public boolean N;
    public int O;
    public GestureDetector P;
    public GestureDetector Q;
    public ia.d R;
    public final ReadWriteLock S = new ReentrantReadWriteLock(true);
    public ia.b<? extends ia.c> T = new ia.a(SkiaImageDecoder.class);
    public ia.b<? extends ia.d> U = new ia.a(SkiaImageRegionDecoder.class);
    public PointF V;
    public float W;

    /* renamed from: a0  reason: collision with root package name */
    public final float f72166a0;

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f72167b;

    /* renamed from: b0  reason: collision with root package name */
    public float f72168b0;

    /* renamed from: c  reason: collision with root package name */
    public boolean f72169c;

    /* renamed from: c0  reason: collision with root package name */
    public boolean f72170c0;

    /* renamed from: d  reason: collision with root package name */
    public boolean f72171d;

    /* renamed from: d0  reason: collision with root package name */
    public PointF f72172d0;

    /* renamed from: e  reason: collision with root package name */
    public Uri f72173e;

    /* renamed from: e0  reason: collision with root package name */
    public PointF f72174e0;

    /* renamed from: f  reason: collision with root package name */
    public int f72175f;

    /* renamed from: f0  reason: collision with root package name */
    public PointF f72176f0;

    /* renamed from: g  reason: collision with root package name */
    public Map<Integer, List<k>> f72177g;

    /* renamed from: g0  reason: collision with root package name */
    public d f72178g0;

    /* renamed from: h  reason: collision with root package name */
    public boolean f72179h;

    /* renamed from: h0  reason: collision with root package name */
    public boolean f72180h0;

    /* renamed from: i  reason: collision with root package name */
    public int f72181i = 0;

    /* renamed from: i0  reason: collision with root package name */
    public boolean f72182i0;

    /* renamed from: j  reason: collision with root package name */
    public float f72183j = 2.0f;

    /* renamed from: j0  reason: collision with root package name */
    public h f72184j0;

    /* renamed from: k  reason: collision with root package name */
    public float f72185k = m0();

    /* renamed from: k0  reason: collision with root package name */
    public i f72186k0;

    /* renamed from: l  reason: collision with root package name */
    public int f72187l = -1;

    /* renamed from: l0  reason: collision with root package name */
    public View.OnLongClickListener f72188l0;

    /* renamed from: m  reason: collision with root package name */
    public int f72189m = 1;

    /* renamed from: m0  reason: collision with root package name */
    public final Handler f72190m0;

    /* renamed from: n  reason: collision with root package name */
    public int f72191n = 1;

    /* renamed from: n0  reason: collision with root package name */
    public Paint f72192n0;

    /* renamed from: o  reason: collision with root package name */
    public int f72193o = Integer.MAX_VALUE;

    /* renamed from: p  reason: collision with root package name */
    public int f72194p = Integer.MAX_VALUE;

    /* renamed from: q  reason: collision with root package name */
    public Executor f72195q = AsyncTask.THREAD_POOL_EXECUTOR;

    /* renamed from: r  reason: collision with root package name */
    public boolean f72196r = true;

    /* renamed from: s  reason: collision with root package name */
    public boolean f72197s = true;

    /* renamed from: t  reason: collision with root package name */
    public boolean f72198t = true;

    /* renamed from: t0  reason: collision with root package name */
    public Paint f72199t0;

    /* renamed from: u  reason: collision with root package name */
    public boolean f72200u = true;

    /* renamed from: u0  reason: collision with root package name */
    public Paint f72201u0;

    /* renamed from: v  reason: collision with root package name */
    public float f72202v = 1.0f;

    /* renamed from: v0  reason: collision with root package name */
    public Paint f72203v0;

    /* renamed from: w  reason: collision with root package name */
    public int f72204w = 1;

    /* renamed from: w0  reason: collision with root package name */
    public j f72205w0;

    /* renamed from: x  reason: collision with root package name */
    public int f72206x = 500;

    /* renamed from: x0  reason: collision with root package name */
    public Matrix f72207x0;

    /* renamed from: y  reason: collision with root package name */
    public float f72208y;

    /* renamed from: y0  reason: collision with root package name */
    public RectF f72209y0;

    /* renamed from: z  reason: collision with root package name */
    public float f72210z;

    /* renamed from: z0  reason: collision with root package name */
    public final float[] f72211z0 = new float[8];

    public static class DefaultOnAnimationEventListener implements g {
        public void onComplete() {
        }

        public void onInterruptedByNewAnim() {
        }

        public void onInterruptedByUser() {
        }
    }

    public static class DefaultOnImageEventListener implements h {
        public void onImageLoadError(Exception exc) {
        }

        public void onImageLoaded() {
        }

        public void onPreviewLoadError(Exception exc) {
        }

        public void onPreviewReleased() {
        }

        public void onReady() {
        }

        public void onTileLoadError(Exception exc) {
        }
    }

    public static class DefaultOnStateChangedListener implements i {
        public void onCenterChanged(PointF pointF, int i11) {
        }

        public void onScaleChanged(float f11, int i11) {
        }
    }

    public class a implements Handler.Callback {
        public a() {
        }

        public boolean handleMessage(Message message) {
            if (message.what == 1 && SubsamplingScaleImageView.this.f72188l0 != null) {
                int unused = SubsamplingScaleImageView.this.O = 0;
                SubsamplingScaleImageView subsamplingScaleImageView = SubsamplingScaleImageView.this;
                SubsamplingScaleImageView.super.setOnLongClickListener(subsamplingScaleImageView.f72188l0);
                SubsamplingScaleImageView.this.performLongClick();
                SubsamplingScaleImageView.super.setOnLongClickListener((View.OnLongClickListener) null);
            }
            return true;
        }
    }

    public class b extends GestureDetector.SimpleOnGestureListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f72213b;

        public b(Context context) {
            this.f72213b = context;
        }

        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (!SubsamplingScaleImageView.this.f72198t || !SubsamplingScaleImageView.this.f72180h0 || SubsamplingScaleImageView.this.A == null) {
                return super.onDoubleTapEvent(motionEvent);
            }
            SubsamplingScaleImageView.this.setGestureDetector(this.f72213b);
            if (SubsamplingScaleImageView.this.f72200u) {
                PointF unused = SubsamplingScaleImageView.this.V = new PointF(motionEvent.getX(), motionEvent.getY());
                PointF unused2 = SubsamplingScaleImageView.this.B = new PointF(SubsamplingScaleImageView.this.A.x, SubsamplingScaleImageView.this.A.y);
                SubsamplingScaleImageView subsamplingScaleImageView = SubsamplingScaleImageView.this;
                float unused3 = subsamplingScaleImageView.f72210z = subsamplingScaleImageView.f72208y;
                boolean unused4 = SubsamplingScaleImageView.this.N = true;
                boolean unused5 = SubsamplingScaleImageView.this.L = true;
                float unused6 = SubsamplingScaleImageView.this.f72168b0 = -1.0f;
                SubsamplingScaleImageView subsamplingScaleImageView2 = SubsamplingScaleImageView.this;
                PointF unused7 = subsamplingScaleImageView2.f72174e0 = subsamplingScaleImageView2.P0(subsamplingScaleImageView2.V);
                PointF unused8 = SubsamplingScaleImageView.this.f72176f0 = new PointF(motionEvent.getX(), motionEvent.getY());
                PointF unused9 = SubsamplingScaleImageView.this.f72172d0 = new PointF(SubsamplingScaleImageView.this.f72174e0.x, SubsamplingScaleImageView.this.f72174e0.y);
                boolean unused10 = SubsamplingScaleImageView.this.f72170c0 = false;
                return false;
            }
            SubsamplingScaleImageView subsamplingScaleImageView3 = SubsamplingScaleImageView.this;
            subsamplingScaleImageView3.W(subsamplingScaleImageView3.P0(new PointF(motionEvent.getX(), motionEvent.getY())), new PointF(motionEvent.getX(), motionEvent.getY()));
            return true;
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f11, float f12) {
            if (!SubsamplingScaleImageView.this.f72197s || !SubsamplingScaleImageView.this.f72180h0 || SubsamplingScaleImageView.this.A == null || motionEvent == null || motionEvent2 == null || ((Math.abs(motionEvent.getX() - motionEvent2.getX()) <= 50.0f && Math.abs(motionEvent.getY() - motionEvent2.getY()) <= 50.0f) || ((Math.abs(f11) <= 500.0f && Math.abs(f12) <= 500.0f) || SubsamplingScaleImageView.this.L))) {
                return super.onFling(motionEvent, motionEvent2, f11, f12);
            }
            PointF pointF = new PointF(SubsamplingScaleImageView.this.A.x + (f11 * 0.25f), SubsamplingScaleImageView.this.A.y + (f12 * 0.25f));
            new e(SubsamplingScaleImageView.this, new PointF((((float) (SubsamplingScaleImageView.this.getWidth() / 2)) - pointF.x) / SubsamplingScaleImageView.this.f72208y, (((float) (SubsamplingScaleImageView.this.getHeight() / 2)) - pointF.y) / SubsamplingScaleImageView.this.f72208y), (a) null).e(1).h(false).g(3).c();
            return true;
        }

        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            SubsamplingScaleImageView.this.performClick();
            return true;
        }
    }

    public class c extends GestureDetector.SimpleOnGestureListener {
        public c() {
        }

        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            SubsamplingScaleImageView.this.performClick();
            return true;
        }
    }

    public final class e {

        /* renamed from: a  reason: collision with root package name */
        public final float f72229a;

        /* renamed from: b  reason: collision with root package name */
        public final PointF f72230b;

        /* renamed from: c  reason: collision with root package name */
        public final PointF f72231c;

        /* renamed from: d  reason: collision with root package name */
        public long f72232d;

        /* renamed from: e  reason: collision with root package name */
        public int f72233e;

        /* renamed from: f  reason: collision with root package name */
        public int f72234f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f72235g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f72236h;

        /* renamed from: i  reason: collision with root package name */
        public g f72237i;

        public /* synthetic */ e(SubsamplingScaleImageView subsamplingScaleImageView, float f11, PointF pointF, PointF pointF2, a aVar) {
            this(f11, pointF, pointF2);
        }

        public void c() {
            PointF pointF;
            if (!(SubsamplingScaleImageView.this.f72178g0 == null || SubsamplingScaleImageView.this.f72178g0.f72228m == null)) {
                try {
                    SubsamplingScaleImageView.this.f72178g0.f72228m.onInterruptedByNewAnim();
                } catch (Exception e11) {
                    Log.w(SubsamplingScaleImageView.C0, "Error thrown by animation listener", e11);
                }
            }
            int paddingLeft = SubsamplingScaleImageView.this.getPaddingLeft() + (((SubsamplingScaleImageView.this.getWidth() - SubsamplingScaleImageView.this.getPaddingRight()) - SubsamplingScaleImageView.this.getPaddingLeft()) / 2);
            int paddingTop = SubsamplingScaleImageView.this.getPaddingTop() + (((SubsamplingScaleImageView.this.getHeight() - SubsamplingScaleImageView.this.getPaddingBottom()) - SubsamplingScaleImageView.this.getPaddingTop()) / 2);
            float J = SubsamplingScaleImageView.this.l0(this.f72229a);
            if (this.f72236h) {
                SubsamplingScaleImageView subsamplingScaleImageView = SubsamplingScaleImageView.this;
                PointF pointF2 = this.f72230b;
                pointF = subsamplingScaleImageView.k0(pointF2.x, pointF2.y, J, new PointF());
            } else {
                pointF = this.f72230b;
            }
            d unused = SubsamplingScaleImageView.this.f72178g0 = new d((a) null);
            float unused2 = SubsamplingScaleImageView.this.f72178g0.f72216a = SubsamplingScaleImageView.this.f72208y;
            float unused3 = SubsamplingScaleImageView.this.f72178g0.f72217b = J;
            long unused4 = SubsamplingScaleImageView.this.f72178g0.f72227l = System.currentTimeMillis();
            PointF unused5 = SubsamplingScaleImageView.this.f72178g0.f72220e = pointF;
            PointF unused6 = SubsamplingScaleImageView.this.f72178g0.f72218c = SubsamplingScaleImageView.this.getCenter();
            PointF unused7 = SubsamplingScaleImageView.this.f72178g0.f72219d = pointF;
            PointF unused8 = SubsamplingScaleImageView.this.f72178g0.f72221f = SubsamplingScaleImageView.this.H0(pointF);
            PointF unused9 = SubsamplingScaleImageView.this.f72178g0.f72222g = new PointF((float) paddingLeft, (float) paddingTop);
            long unused10 = SubsamplingScaleImageView.this.f72178g0.f72223h = this.f72232d;
            boolean unused11 = SubsamplingScaleImageView.this.f72178g0.f72224i = this.f72235g;
            int unused12 = SubsamplingScaleImageView.this.f72178g0.f72225j = this.f72233e;
            int unused13 = SubsamplingScaleImageView.this.f72178g0.f72226k = this.f72234f;
            long unused14 = SubsamplingScaleImageView.this.f72178g0.f72227l = System.currentTimeMillis();
            g unused15 = SubsamplingScaleImageView.this.f72178g0.f72228m = this.f72237i;
            PointF pointF3 = this.f72231c;
            if (pointF3 != null) {
                float f11 = pointF3.x - (SubsamplingScaleImageView.this.f72178g0.f72218c.x * J);
                float f12 = this.f72231c.y - (SubsamplingScaleImageView.this.f72178g0.f72218c.y * J);
                j jVar = new j(J, new PointF(f11, f12), (a) null);
                SubsamplingScaleImageView.this.d0(true, jVar);
                PointF unused16 = SubsamplingScaleImageView.this.f72178g0.f72222g = new PointF(this.f72231c.x + (jVar.f72247b.x - f11), this.f72231c.y + (jVar.f72247b.y - f12));
            }
            SubsamplingScaleImageView.this.invalidate();
        }

        public e d(long j11) {
            this.f72232d = j11;
            return this;
        }

        public e e(int i11) {
            if (SubsamplingScaleImageView.F0.contains(Integer.valueOf(i11))) {
                this.f72233e = i11;
                return this;
            }
            throw new IllegalArgumentException("Unknown easing type: " + i11);
        }

        public e f(boolean z11) {
            this.f72235g = z11;
            return this;
        }

        public final e g(int i11) {
            this.f72234f = i11;
            return this;
        }

        public final e h(boolean z11) {
            this.f72236h = z11;
            return this;
        }

        public /* synthetic */ e(SubsamplingScaleImageView subsamplingScaleImageView, float f11, PointF pointF, a aVar) {
            this(f11, pointF);
        }

        public /* synthetic */ e(SubsamplingScaleImageView subsamplingScaleImageView, PointF pointF, a aVar) {
            this(pointF);
        }

        public e(PointF pointF) {
            this.f72232d = 500;
            this.f72233e = 2;
            this.f72234f = 1;
            this.f72235g = true;
            this.f72236h = true;
            this.f72229a = SubsamplingScaleImageView.this.f72208y;
            this.f72230b = pointF;
            this.f72231c = null;
        }

        public e(float f11, PointF pointF) {
            this.f72232d = 500;
            this.f72233e = 2;
            this.f72234f = 1;
            this.f72235g = true;
            this.f72236h = true;
            this.f72229a = f11;
            this.f72230b = pointF;
            this.f72231c = null;
        }

        public e(float f11, PointF pointF, PointF pointF2) {
            this.f72232d = 500;
            this.f72233e = 2;
            this.f72234f = 1;
            this.f72235g = true;
            this.f72236h = true;
            this.f72229a = f11;
            this.f72230b = pointF;
            this.f72231c = pointF2;
        }
    }

    public static class f extends AsyncTask<Void, Void, Integer> {

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<SubsamplingScaleImageView> f72239a;

        /* renamed from: b  reason: collision with root package name */
        public final WeakReference<Context> f72240b;

        /* renamed from: c  reason: collision with root package name */
        public final WeakReference<ia.b<? extends ia.c>> f72241c;

        /* renamed from: d  reason: collision with root package name */
        public final Uri f72242d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f72243e;

        /* renamed from: f  reason: collision with root package name */
        public Bitmap f72244f;

        /* renamed from: g  reason: collision with root package name */
        public Exception f72245g;

        public f(SubsamplingScaleImageView subsamplingScaleImageView, Context context, ia.b<? extends ia.c> bVar, Uri uri, boolean z11) {
            this.f72239a = new WeakReference<>(subsamplingScaleImageView);
            this.f72240b = new WeakReference<>(context);
            this.f72241c = new WeakReference<>(bVar);
            this.f72242d = uri;
            this.f72243e = z11;
        }

        /* renamed from: a */
        public Integer doInBackground(Void... voidArr) {
            try {
                String uri = this.f72242d.toString();
                Context context = (Context) this.f72240b.get();
                ia.b bVar = (ia.b) this.f72241c.get();
                SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView) this.f72239a.get();
                if (context == null || bVar == null || subsamplingScaleImageView == null) {
                    return null;
                }
                subsamplingScaleImageView.U("BitmapLoadTask.doInBackground", new Object[0]);
                this.f72244f = ((ia.c) bVar.make()).decode(context, this.f72242d);
                return Integer.valueOf(subsamplingScaleImageView.e0(context, uri));
            } catch (Exception e11) {
                Log.e(SubsamplingScaleImageView.C0, "Failed to load bitmap", e11);
                this.f72245g = e11;
                return null;
            } catch (OutOfMemoryError e12) {
                Log.e(SubsamplingScaleImageView.C0, "Failed to load bitmap - OutOfMemoryError", e12);
                this.f72245g = new RuntimeException(e12);
                return null;
            }
        }

        /* renamed from: b */
        public void onPostExecute(Integer num) {
            SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView) this.f72239a.get();
            if (subsamplingScaleImageView != null) {
                Bitmap bitmap = this.f72244f;
                if (bitmap == null || num == null) {
                    if (this.f72245g != null && subsamplingScaleImageView.f72184j0 != null) {
                        if (this.f72243e) {
                            subsamplingScaleImageView.f72184j0.onPreviewLoadError(this.f72245g);
                        } else {
                            subsamplingScaleImageView.f72184j0.onImageLoadError(this.f72245g);
                        }
                    }
                } else if (this.f72243e) {
                    subsamplingScaleImageView.p0(bitmap);
                } else {
                    subsamplingScaleImageView.o0(bitmap, num.intValue(), false);
                }
            }
        }
    }

    public interface g {
        void onComplete();

        void onInterruptedByNewAnim();

        void onInterruptedByUser();
    }

    public interface h {
        void onImageLoadError(Exception exc);

        void onImageLoaded();

        void onPreviewLoadError(Exception exc);

        void onPreviewReleased();

        void onReady();

        void onTileLoadError(Exception exc);
    }

    public interface i {
        void onCenterChanged(PointF pointF, int i11);

        void onScaleChanged(float f11, int i11);
    }

    public static class j {

        /* renamed from: a  reason: collision with root package name */
        public float f72246a;

        /* renamed from: b  reason: collision with root package name */
        public final PointF f72247b;

        public /* synthetic */ j(float f11, PointF pointF, a aVar) {
            this(f11, pointF);
        }

        public j(float f11, PointF pointF) {
            this.f72246a = f11;
            this.f72247b = pointF;
        }
    }

    public static class k {

        /* renamed from: a  reason: collision with root package name */
        public Rect f72248a;

        /* renamed from: b  reason: collision with root package name */
        public int f72249b;

        /* renamed from: c  reason: collision with root package name */
        public Bitmap f72250c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f72251d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f72252e;

        /* renamed from: f  reason: collision with root package name */
        public Rect f72253f;

        /* renamed from: g  reason: collision with root package name */
        public Rect f72254g;

        public k() {
        }

        public /* synthetic */ k(a aVar) {
            this();
        }
    }

    public static class l extends AsyncTask<Void, Void, Bitmap> {

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<SubsamplingScaleImageView> f72255a;

        /* renamed from: b  reason: collision with root package name */
        public final WeakReference<ia.d> f72256b;

        /* renamed from: c  reason: collision with root package name */
        public final WeakReference<k> f72257c;

        /* renamed from: d  reason: collision with root package name */
        public Exception f72258d;

        public l(SubsamplingScaleImageView subsamplingScaleImageView, ia.d dVar, k kVar) {
            this.f72255a = new WeakReference<>(subsamplingScaleImageView);
            this.f72256b = new WeakReference<>(dVar);
            this.f72257c = new WeakReference<>(kVar);
            boolean unused = kVar.f72251d = true;
        }

        /* renamed from: a */
        public Bitmap doInBackground(Void... voidArr) {
            SubsamplingScaleImageView subsamplingScaleImageView;
            try {
                subsamplingScaleImageView = (SubsamplingScaleImageView) this.f72255a.get();
                ia.d dVar = (ia.d) this.f72256b.get();
                k kVar = (k) this.f72257c.get();
                if (dVar != null && kVar != null && subsamplingScaleImageView != null && dVar.isReady() && kVar.f72252e) {
                    subsamplingScaleImageView.U("TileLoadTask.doInBackground, tile.sRect=%s, tile.sampleSize=%d", kVar.f72248a, Integer.valueOf(kVar.f72249b));
                    subsamplingScaleImageView.S.readLock().lock();
                    if (dVar.isReady()) {
                        subsamplingScaleImageView.b0(kVar.f72248a, kVar.f72254g);
                        if (subsamplingScaleImageView.J != null) {
                            kVar.f72254g.offset(subsamplingScaleImageView.J.left, subsamplingScaleImageView.J.top);
                        }
                        Bitmap decodeRegion = dVar.decodeRegion(kVar.f72254g, kVar.f72249b);
                        subsamplingScaleImageView.S.readLock().unlock();
                        return decodeRegion;
                    }
                    boolean unused = kVar.f72251d = false;
                    subsamplingScaleImageView.S.readLock().unlock();
                    return null;
                } else if (kVar == null) {
                    return null;
                } else {
                    boolean unused2 = kVar.f72251d = false;
                    return null;
                }
            } catch (Exception e11) {
                Log.e(SubsamplingScaleImageView.C0, "Failed to decode tile", e11);
                this.f72258d = e11;
                return null;
            } catch (OutOfMemoryError e12) {
                Log.e(SubsamplingScaleImageView.C0, "Failed to decode tile - OutOfMemoryError", e12);
                this.f72258d = new RuntimeException(e12);
                return null;
            } catch (Throwable th2) {
                subsamplingScaleImageView.S.readLock().unlock();
                throw th2;
            }
        }

        /* renamed from: b */
        public void onPostExecute(Bitmap bitmap) {
            SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView) this.f72255a.get();
            k kVar = (k) this.f72257c.get();
            if (subsamplingScaleImageView != null && kVar != null) {
                if (bitmap != null) {
                    Bitmap unused = kVar.f72250c = bitmap;
                    boolean unused2 = kVar.f72251d = false;
                    subsamplingScaleImageView.r0();
                } else if (this.f72258d != null && subsamplingScaleImageView.f72184j0 != null) {
                    subsamplingScaleImageView.f72184j0.onTileLoadError(this.f72258d);
                }
            }
        }
    }

    public static class m extends AsyncTask<Void, Void, int[]> {

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<SubsamplingScaleImageView> f72259a;

        /* renamed from: b  reason: collision with root package name */
        public final WeakReference<Context> f72260b;

        /* renamed from: c  reason: collision with root package name */
        public final WeakReference<ia.b<? extends ia.d>> f72261c;

        /* renamed from: d  reason: collision with root package name */
        public final Uri f72262d;

        /* renamed from: e  reason: collision with root package name */
        public ia.d f72263e;

        /* renamed from: f  reason: collision with root package name */
        public Exception f72264f;

        public m(SubsamplingScaleImageView subsamplingScaleImageView, Context context, ia.b<? extends ia.d> bVar, Uri uri) {
            this.f72259a = new WeakReference<>(subsamplingScaleImageView);
            this.f72260b = new WeakReference<>(context);
            this.f72261c = new WeakReference<>(bVar);
            this.f72262d = uri;
        }

        /* renamed from: a */
        public int[] doInBackground(Void... voidArr) {
            try {
                String uri = this.f72262d.toString();
                Context context = (Context) this.f72260b.get();
                ia.b bVar = (ia.b) this.f72261c.get();
                SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView) this.f72259a.get();
                if (context == null || bVar == null || subsamplingScaleImageView == null) {
                    return null;
                }
                subsamplingScaleImageView.U("TilesInitTask.doInBackground", new Object[0]);
                ia.d dVar = (ia.d) bVar.make();
                this.f72263e = dVar;
                Point init = dVar.init(context, this.f72262d);
                int i11 = init.x;
                int i12 = init.y;
                int v11 = subsamplingScaleImageView.e0(context, uri);
                if (subsamplingScaleImageView.J != null) {
                    subsamplingScaleImageView.J.left = Math.max(0, subsamplingScaleImageView.J.left);
                    subsamplingScaleImageView.J.top = Math.max(0, subsamplingScaleImageView.J.top);
                    subsamplingScaleImageView.J.right = Math.min(i11, subsamplingScaleImageView.J.right);
                    subsamplingScaleImageView.J.bottom = Math.min(i12, subsamplingScaleImageView.J.bottom);
                    i11 = subsamplingScaleImageView.J.width();
                    i12 = subsamplingScaleImageView.J.height();
                }
                return new int[]{i11, i12, v11};
            } catch (Exception e11) {
                Log.e(SubsamplingScaleImageView.C0, "Failed to initialise bitmap decoder", e11);
                this.f72264f = e11;
                return null;
            }
        }

        /* renamed from: b */
        public void onPostExecute(int[] iArr) {
            SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView) this.f72259a.get();
            if (subsamplingScaleImageView != null) {
                ia.d dVar = this.f72263e;
                if (dVar != null && iArr != null && iArr.length == 3) {
                    subsamplingScaleImageView.s0(dVar, iArr[0], iArr[1], iArr[2]);
                } else if (this.f72264f != null && subsamplingScaleImageView.f72184j0 != null) {
                    subsamplingScaleImageView.f72184j0.onImageLoadError(this.f72264f);
                }
            }
        }
    }

    public SubsamplingScaleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int resourceId;
        String string;
        setMinimumDpi(160);
        setDoubleTapZoomDpi(160);
        setMinimumTileDpi(320);
        setGestureDetector(context);
        this.f72190m0 = new Handler(new a());
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.SubsamplingScaleImageView);
            int i11 = R$styleable.SubsamplingScaleImageView_assetName;
            if (obtainStyledAttributes.hasValue(i11) && (string = obtainStyledAttributes.getString(i11)) != null && string.length() > 0) {
                setImage(ia.e.a(string).l());
            }
            int i12 = R$styleable.SubsamplingScaleImageView_src;
            if (obtainStyledAttributes.hasValue(i12) && (resourceId = obtainStyledAttributes.getResourceId(i12, 0)) > 0) {
                setImage(ia.e.j(resourceId).l());
            }
            int i13 = R$styleable.SubsamplingScaleImageView_panEnabled;
            if (obtainStyledAttributes.hasValue(i13)) {
                setPanEnabled(obtainStyledAttributes.getBoolean(i13, true));
            }
            int i14 = R$styleable.SubsamplingScaleImageView_zoomEnabled;
            if (obtainStyledAttributes.hasValue(i14)) {
                setZoomEnabled(obtainStyledAttributes.getBoolean(i14, true));
            }
            int i15 = R$styleable.SubsamplingScaleImageView_quickScaleEnabled;
            if (obtainStyledAttributes.hasValue(i15)) {
                setQuickScaleEnabled(obtainStyledAttributes.getBoolean(i15, true));
            }
            int i16 = R$styleable.SubsamplingScaleImageView_tileBackgroundColor;
            if (obtainStyledAttributes.hasValue(i16)) {
                setTileBackgroundColor(obtainStyledAttributes.getColor(i16, Color.argb(0, 0, 0, 0)));
            }
            obtainStyledAttributes.recycle();
        }
        this.f72166a0 = TypedValue.applyDimension(1, 20.0f, context.getResources().getDisplayMetrics());
    }

    public static Bitmap.Config getPreferredBitmapConfig() {
        return I0;
    }

    private int getRequiredRotation() {
        int i11 = this.f72181i;
        return i11 == -1 ? this.I : i11;
    }

    /* access modifiers changed from: private */
    public void setGestureDetector(Context context) {
        this.P = new GestureDetector(context, new b(context));
        this.Q = new GestureDetector(context, new c());
    }

    public static void setPreferredBitmapConfig(Bitmap.Config config) {
        I0 = config;
    }

    public final int A0() {
        int requiredRotation = getRequiredRotation();
        if (requiredRotation == 90 || requiredRotation == 270) {
            return this.G;
        }
        return this.H;
    }

    public final int B0() {
        int requiredRotation = getRequiredRotation();
        if (requiredRotation == 90 || requiredRotation == 270) {
            return this.H;
        }
        return this.G;
    }

    public final void C0(float f11, PointF pointF, int i11) {
        i iVar = this.f72186k0;
        if (iVar != null) {
            float f12 = this.f72208y;
            if (f12 != f11) {
                iVar.onScaleChanged(f12, i11);
            }
        }
        if (this.f72186k0 != null && !this.A.equals(pointF)) {
            this.f72186k0.onCenterChanged(getCenter(), i11);
        }
    }

    public final void D0(ia.e eVar, ia.e eVar2, ImageViewState imageViewState) {
        Objects.requireNonNull(eVar, "imageSource must not be null");
        y0(true);
        if (imageViewState != null) {
            z0(imageViewState);
        }
        if (eVar2 != null) {
            if (eVar.b() != null) {
                throw new IllegalArgumentException("Preview image cannot be used when a bitmap is provided for the main image");
            } else if (eVar.f() <= 0 || eVar.d() <= 0) {
                throw new IllegalArgumentException("Preview image cannot be used unless dimensions are provided for the main image");
            } else {
                this.G = eVar.f();
                this.H = eVar.d();
                this.K = eVar2.e();
                if (eVar2.b() != null) {
                    this.f72171d = eVar2.i();
                    p0(eVar2.b());
                } else {
                    Uri h11 = eVar2.h();
                    if (h11 == null && eVar2.c() != null) {
                        h11 = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + eVar2.c());
                    }
                    a0(new f(this, getContext(), this.T, h11, true));
                }
            }
        }
        if (eVar.b() != null && eVar.e() != null) {
            o0(Bitmap.createBitmap(eVar.b(), eVar.e().left, eVar.e().top, eVar.e().width(), eVar.e().height()), 0, false);
        } else if (eVar.b() != null) {
            o0(eVar.b(), 0, eVar.i());
        } else {
            this.J = eVar.e();
            Uri h12 = eVar.h();
            this.f72173e = h12;
            if (h12 == null && eVar.c() != null) {
                this.f72173e = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + eVar.c());
            }
            if (eVar.g() || this.J != null) {
                a0(new m(this, getContext(), this.U, this.f72173e));
                return;
            }
            a0(new f(this, getContext(), this.T, this.f72173e, false));
        }
    }

    public final void E0(float[] fArr, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18) {
        fArr[0] = f11;
        fArr[1] = f12;
        fArr[2] = f13;
        fArr[3] = f14;
        fArr[4] = f15;
        fArr[5] = f16;
        fArr[6] = f17;
        fArr[7] = f18;
    }

    public final void F0(float f11, PointF pointF) {
        this.f72178g0 = null;
        this.D = Float.valueOf(f11);
        this.E = pointF;
        this.F = pointF;
        invalidate();
    }

    public final PointF G0(float f11, float f12, PointF pointF) {
        if (this.A == null) {
            return null;
        }
        pointF.set(J0(f11), K0(f12));
        return pointF;
    }

    public final PointF H0(PointF pointF) {
        return G0(pointF.x, pointF.y, new PointF());
    }

    public final void I0(Rect rect, Rect rect2) {
        rect2.set((int) J0((float) rect.left), (int) K0((float) rect.top), (int) J0((float) rect.right), (int) K0((float) rect.bottom));
    }

    public final float J0(float f11) {
        PointF pointF = this.A;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f11 * this.f72208y) + pointF.x;
    }

    public final float K0(float f11) {
        PointF pointF = this.A;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f11 * this.f72208y) + pointF.y;
    }

    public final boolean L0(k kVar) {
        return Q0(0.0f) <= ((float) kVar.f72248a.right) && ((float) kVar.f72248a.left) <= Q0((float) getWidth()) && R0(0.0f) <= ((float) kVar.f72248a.bottom) && ((float) kVar.f72248a.top) <= R0((float) getHeight());
    }

    public final PointF M0(float f11, float f12, float f13) {
        int paddingLeft = getPaddingLeft() + (((getWidth() - getPaddingRight()) - getPaddingLeft()) / 2);
        int paddingTop = getPaddingTop() + (((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2);
        if (this.f72205w0 == null) {
            this.f72205w0 = new j(0.0f, new PointF(0.0f, 0.0f), (a) null);
        }
        float unused = this.f72205w0.f72246a = f13;
        this.f72205w0.f72247b.set(((float) paddingLeft) - (f11 * f13), ((float) paddingTop) - (f12 * f13));
        d0(true, this.f72205w0);
        return this.f72205w0.f72247b;
    }

    public final PointF N0(float f11, float f12) {
        return O0(f11, f12, new PointF());
    }

    public final PointF O0(float f11, float f12, PointF pointF) {
        if (this.A == null) {
            return null;
        }
        pointF.set(Q0(f11), R0(f12));
        return pointF;
    }

    public final PointF P0(PointF pointF) {
        return O0(pointF.x, pointF.y, new PointF());
    }

    public final int Q(float f11) {
        int i11;
        if (this.f72187l > 0) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            f11 *= ((float) this.f72187l) / ((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f);
        }
        int B02 = (int) (((float) B0()) * f11);
        int A02 = (int) (((float) A0()) * f11);
        if (B02 == 0 || A02 == 0) {
            return 32;
        }
        int i12 = 1;
        if (A0() > A02 || B0() > B02) {
            i11 = Math.round(((float) A0()) / ((float) A02));
            int round = Math.round(((float) B0()) / ((float) B02));
            if (i11 >= round) {
                i11 = round;
            }
        } else {
            i11 = 1;
        }
        while (true) {
            int i13 = i12 * 2;
            if (i13 >= i11) {
                return i12;
            }
            i12 = i13;
        }
    }

    public final float Q0(float f11) {
        PointF pointF = this.A;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f11 - pointF.x) / this.f72208y;
    }

    public final boolean R() {
        boolean i02 = i0();
        if (!this.f72182i0 && i02) {
            u0();
            this.f72182i0 = true;
            n0();
            h hVar = this.f72184j0;
            if (hVar != null) {
                hVar.onImageLoaded();
            }
        }
        return i02;
    }

    public final float R0(float f11) {
        PointF pointF = this.A;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f11 - pointF.y) / this.f72208y;
    }

    public final boolean S() {
        boolean z11 = getWidth() > 0 && getHeight() > 0 && this.G > 0 && this.H > 0 && (this.f72167b != null || i0());
        if (!this.f72180h0 && z11) {
            u0();
            this.f72180h0 = true;
            q0();
            h hVar = this.f72184j0;
            if (hVar != null) {
                hVar.onReady();
            }
        }
        return z11;
    }

    public final void T() {
        if (this.f72192n0 == null) {
            Paint paint = new Paint();
            this.f72192n0 = paint;
            paint.setAntiAlias(true);
            this.f72192n0.setFilterBitmap(true);
            this.f72192n0.setDither(true);
        }
        if ((this.f72199t0 == null || this.f72201u0 == null) && this.f72179h) {
            Paint paint2 = new Paint();
            this.f72199t0 = paint2;
            paint2.setTextSize((float) v0(12));
            this.f72199t0.setColor(-65281);
            this.f72199t0.setStyle(Paint.Style.FILL);
            Paint paint3 = new Paint();
            this.f72201u0 = paint3;
            paint3.setColor(-65281);
            this.f72201u0.setStyle(Paint.Style.STROKE);
            this.f72201u0.setStrokeWidth((float) v0(1));
        }
    }

    public final void U(String str, Object... objArr) {
        if (this.f72179h) {
            Log.d(C0, String.format(str, objArr));
        }
    }

    public final float V(float f11, float f12, float f13, float f14) {
        float f15 = f11 - f12;
        float f16 = f13 - f14;
        return (float) Math.sqrt((double) ((f15 * f15) + (f16 * f16)));
    }

    public final void W(PointF pointF, PointF pointF2) {
        if (!this.f72197s) {
            PointF pointF3 = this.F;
            if (pointF3 != null) {
                pointF.x = pointF3.x;
                pointF.y = pointF3.y;
            } else {
                pointF.x = (float) (B0() / 2);
                pointF.y = (float) (A0() / 2);
            }
        }
        float min = Math.min(this.f72183j, this.f72202v);
        float f11 = this.f72208y;
        boolean z11 = ((double) f11) <= ((double) min) * 0.9d || f11 == this.f72185k;
        if (!z11) {
            min = m0();
        }
        float f12 = min;
        int i11 = this.f72204w;
        if (i11 == 3) {
            F0(f12, pointF);
        } else if (i11 == 2 || !z11 || !this.f72197s) {
            new e(this, f12, pointF, (a) null).f(false).d((long) this.f72206x).g(4).c();
        } else if (i11 == 1) {
            new e(this, f12, pointF, pointF2, (a) null).f(false).d((long) this.f72206x).g(4).c();
        }
        invalidate();
    }

    public final float X(int i11, long j11, float f11, float f12, long j12) {
        if (i11 == 1) {
            return Z(j11, f11, f12, j12);
        }
        if (i11 == 2) {
            return Y(j11, f11, f12, j12);
        }
        throw new IllegalStateException("Unexpected easing type: " + i11);
    }

    public final float Y(long j11, float f11, float f12, long j12) {
        float f13;
        float f14 = ((float) j11) / (((float) j12) / 2.0f);
        if (f14 < 1.0f) {
            f13 = (f12 / 2.0f) * f14;
        } else {
            float f15 = f14 - 1.0f;
            f13 = (-f12) / 2.0f;
            f14 = (f15 * (f15 - 2.0f)) - 1.0f;
        }
        return (f13 * f14) + f11;
    }

    public final float Z(long j11, float f11, float f12, long j12) {
        float f13 = ((float) j11) / ((float) j12);
        return ((-f12) * f13 * (f13 - 2.0f)) + f11;
    }

    public final void a0(AsyncTask<Void, Void, ?> asyncTask) {
        asyncTask.executeOnExecutor(this.f72195q, new Void[0]);
    }

    public final void b0(Rect rect, Rect rect2) {
        if (getRequiredRotation() == 0) {
            rect2.set(rect);
        } else if (getRequiredRotation() == 90) {
            int i11 = rect.top;
            int i12 = this.H;
            rect2.set(i11, i12 - rect.right, rect.bottom, i12 - rect.left);
        } else if (getRequiredRotation() == 180) {
            int i13 = this.G;
            int i14 = this.H;
            rect2.set(i13 - rect.right, i14 - rect.bottom, i13 - rect.left, i14 - rect.top);
        } else {
            int i15 = this.G;
            rect2.set(i15 - rect.bottom, rect.left, i15 - rect.top, rect.right);
        }
    }

    public final void c0(boolean z11) {
        boolean z12;
        if (this.A == null) {
            z12 = true;
            this.A = new PointF(0.0f, 0.0f);
        } else {
            z12 = false;
        }
        if (this.f72205w0 == null) {
            this.f72205w0 = new j(0.0f, new PointF(0.0f, 0.0f), (a) null);
        }
        float unused = this.f72205w0.f72246a = this.f72208y;
        this.f72205w0.f72247b.set(this.A);
        d0(z11, this.f72205w0);
        this.f72208y = this.f72205w0.f72246a;
        this.A.set(this.f72205w0.f72247b);
        if (z12 && this.f72191n != 4) {
            this.A.set(M0((float) (B0() / 2), (float) (A0() / 2), this.f72208y));
        }
    }

    public final void d0(boolean z11, j jVar) {
        float f11;
        float f12;
        int i11;
        if (this.f72189m == 2 && j0()) {
            z11 = false;
        }
        PointF c11 = jVar.f72247b;
        float l02 = l0(jVar.f72246a);
        float B02 = ((float) B0()) * l02;
        float A02 = ((float) A0()) * l02;
        if (this.f72189m == 3 && j0()) {
            c11.x = Math.max(c11.x, ((float) (getWidth() / 2)) - B02);
            c11.y = Math.max(c11.y, ((float) (getHeight() / 2)) - A02);
        } else if (z11) {
            c11.x = Math.max(c11.x, ((float) getWidth()) - B02);
            c11.y = Math.max(c11.y, ((float) getHeight()) - A02);
        } else {
            c11.x = Math.max(c11.x, -B02);
            c11.y = Math.max(c11.y, -A02);
        }
        float f13 = 0.5f;
        float paddingLeft = (getPaddingLeft() > 0 || getPaddingRight() > 0) ? ((float) getPaddingLeft()) / ((float) (getPaddingLeft() + getPaddingRight())) : 0.5f;
        if (getPaddingTop() > 0 || getPaddingBottom() > 0) {
            f13 = ((float) getPaddingTop()) / ((float) (getPaddingTop() + getPaddingBottom()));
        }
        if (this.f72189m == 3 && j0()) {
            f11 = (float) Math.max(0, getWidth() / 2);
            i11 = Math.max(0, getHeight() / 2);
        } else if (z11) {
            f11 = Math.max(0.0f, (((float) getWidth()) - B02) * paddingLeft);
            f12 = Math.max(0.0f, (((float) getHeight()) - A02) * f13);
            c11.x = Math.min(c11.x, f11);
            c11.y = Math.min(c11.y, f12);
            float unused = jVar.f72246a = l02;
        } else {
            f11 = (float) Math.max(0, getWidth());
            i11 = Math.max(0, getHeight());
        }
        f12 = (float) i11;
        c11.x = Math.min(c11.x, f11);
        c11.y = Math.min(c11.y, f12);
        float unused2 = jVar.f72246a = l02;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0059, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        android.util.Log.w(C0, "Could not get orientation of image from media store");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0065, code lost:
        if (r0 != null) goto L_0x0067;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0067, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006a, code lost:
        throw r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
        return 0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x005b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int e0(android.content.Context r10, java.lang.String r11) {
        /*
            r9 = this;
            java.lang.String r0 = "content"
            boolean r0 = r11.startsWith(r0)
            r1 = 0
            if (r0 == 0) goto L_0x006b
            r0 = 0
            java.lang.String r2 = "orientation"
            java.lang.String[] r5 = new java.lang.String[]{r2}     // Catch:{ Exception -> 0x005b }
            android.content.ContentResolver r3 = r10.getContentResolver()     // Catch:{ Exception -> 0x005b }
            android.net.Uri r4 = android.net.Uri.parse(r11)     // Catch:{ Exception -> 0x005b }
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r0 = r3.query(r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x005b }
            if (r0 == 0) goto L_0x0052
            boolean r10 = r0.moveToFirst()     // Catch:{ Exception -> 0x005b }
            if (r10 == 0) goto L_0x0052
            int r10 = r0.getInt(r1)     // Catch:{ Exception -> 0x005b }
            java.util.List<java.lang.Integer> r11 = D0     // Catch:{ Exception -> 0x005b }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r10)     // Catch:{ Exception -> 0x005b }
            boolean r11 = r11.contains(r2)     // Catch:{ Exception -> 0x005b }
            if (r11 == 0) goto L_0x003c
            r11 = -1
            if (r10 == r11) goto L_0x003c
            r1 = r10
            goto L_0x0052
        L_0x003c:
            java.lang.String r11 = C0     // Catch:{ Exception -> 0x005b }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x005b }
            r2.<init>()     // Catch:{ Exception -> 0x005b }
            java.lang.String r3 = "Unsupported orientation: "
            r2.append(r3)     // Catch:{ Exception -> 0x005b }
            r2.append(r10)     // Catch:{ Exception -> 0x005b }
            java.lang.String r10 = r2.toString()     // Catch:{ Exception -> 0x005b }
            android.util.Log.w(r11, r10)     // Catch:{ Exception -> 0x005b }
        L_0x0052:
            if (r0 == 0) goto L_0x00c3
        L_0x0054:
            r0.close()
            goto L_0x00c3
        L_0x0059:
            r10 = move-exception
            goto L_0x0065
        L_0x005b:
            java.lang.String r10 = C0     // Catch:{ all -> 0x0059 }
            java.lang.String r11 = "Could not get orientation of image from media store"
            android.util.Log.w(r10, r11)     // Catch:{ all -> 0x0059 }
            if (r0 == 0) goto L_0x00c3
            goto L_0x0054
        L_0x0065:
            if (r0 == 0) goto L_0x006a
            r0.close()
        L_0x006a:
            throw r10
        L_0x006b:
            java.lang.String r10 = "file:///"
            boolean r10 = r11.startsWith(r10)
            if (r10 == 0) goto L_0x00c3
            java.lang.String r10 = "file:///android_asset/"
            boolean r10 = r11.startsWith(r10)
            if (r10 != 0) goto L_0x00c3
            m1.a r10 = new m1.a     // Catch:{ Exception -> 0x00bc }
            r0 = 7
            java.lang.String r11 = r11.substring(r0)     // Catch:{ Exception -> 0x00bc }
            r10.<init>((java.lang.String) r11)     // Catch:{ Exception -> 0x00bc }
            java.lang.String r11 = "Orientation"
            r0 = 1
            int r10 = r10.i(r11, r0)     // Catch:{ Exception -> 0x00bc }
            if (r10 == r0) goto L_0x00c3
            if (r10 != 0) goto L_0x0091
            goto L_0x00c3
        L_0x0091:
            r11 = 6
            if (r10 != r11) goto L_0x0098
            r10 = 90
        L_0x0096:
            r1 = r10
            goto L_0x00c3
        L_0x0098:
            r11 = 3
            if (r10 != r11) goto L_0x009e
            r10 = 180(0xb4, float:2.52E-43)
            goto L_0x0096
        L_0x009e:
            r11 = 8
            if (r10 != r11) goto L_0x00a5
            r10 = 270(0x10e, float:3.78E-43)
            goto L_0x0096
        L_0x00a5:
            java.lang.String r11 = C0     // Catch:{ Exception -> 0x00bc }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00bc }
            r0.<init>()     // Catch:{ Exception -> 0x00bc }
            java.lang.String r2 = "Unsupported EXIF orientation: "
            r0.append(r2)     // Catch:{ Exception -> 0x00bc }
            r0.append(r10)     // Catch:{ Exception -> 0x00bc }
            java.lang.String r10 = r0.toString()     // Catch:{ Exception -> 0x00bc }
            android.util.Log.w(r11, r10)     // Catch:{ Exception -> 0x00bc }
            goto L_0x00c3
        L_0x00bc:
            java.lang.String r10 = C0
            java.lang.String r11 = "Could not get EXIF orientation of image"
            android.util.Log.w(r10, r11)
        L_0x00c3:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.lib.widgets.photoviewer.SubsamplingScaleImageView.e0(android.content.Context, java.lang.String):int");
    }

    public final Point f0(Canvas canvas) {
        return new Point(Math.min(canvas.getMaximumBitmapWidth(), this.f72193o), Math.min(canvas.getMaximumBitmapHeight(), this.f72194p));
    }

    public final synchronized void g0(Point point) {
        U("initialiseBaseLayer maxTileDimensions=%dx%d", Integer.valueOf(point.x), Integer.valueOf(point.y));
        j jVar = new j(0.0f, new PointF(0.0f, 0.0f), (a) null);
        this.f72205w0 = jVar;
        d0(true, jVar);
        int Q2 = Q(this.f72205w0.f72246a);
        this.f72175f = Q2;
        if (Q2 > 1) {
            this.f72175f = Q2 / 2;
        }
        if (this.f72175f != 1 || this.J != null || B0() >= point.x || A0() >= point.y) {
            h0(point);
            for (k lVar : this.f72177g.get(Integer.valueOf(this.f72175f))) {
                a0(new l(this, this.R, lVar));
            }
            w0(true);
        } else {
            this.R.recycle();
            this.R = null;
            a0(new f(this, getContext(), this.T, this.f72173e, false));
        }
    }

    public final int getAppliedOrientation() {
        return getRequiredRotation();
    }

    public final PointF getCenter() {
        return N0((float) (getWidth() / 2), (float) (getHeight() / 2));
    }

    public float getMaxScale() {
        return this.f72183j;
    }

    public final float getMinScale() {
        return m0();
    }

    public final int getOrientation() {
        return this.f72181i;
    }

    public final int getSHeight() {
        return this.H;
    }

    public final int getSWidth() {
        return this.G;
    }

    public final float getScale() {
        return this.f72208y;
    }

    public final ImageViewState getState() {
        if (this.A == null || this.G <= 0 || this.H <= 0) {
            return null;
        }
        return new ImageViewState(getScale(), getCenter(), getOrientation());
    }

    public final void h0(Point point) {
        Point point2 = point;
        boolean z11 = false;
        boolean z12 = true;
        U("initialiseTileMap maxTileDimensions=%dx%d", Integer.valueOf(point2.x), Integer.valueOf(point2.y));
        this.f72177g = new LinkedHashMap();
        int i11 = this.f72175f;
        int i12 = 1;
        int i13 = 1;
        while (true) {
            int B02 = B0() / i12;
            int A02 = A0() / i13;
            int i14 = B02 / i11;
            int i15 = A02 / i11;
            while (true) {
                if (i14 + i12 + (z12 ? 1 : 0) > point2.x || (((double) i14) > ((double) getWidth()) * 1.25d && i11 < this.f72175f)) {
                    boolean z13 = z12;
                    boolean z14 = z11;
                    boolean z15 = z13;
                    i12++;
                    B02 = B0() / i12;
                    i14 = B02 / i11;
                    boolean z16 = z14;
                    z12 = z15;
                    z11 = z16;
                }
            }
            while (true) {
                if (i15 + i13 + (z12 ? 1 : 0) > point2.y || (((double) i15) > ((double) getHeight()) * 1.25d && i11 < this.f72175f)) {
                    boolean z17 = z12;
                    boolean z18 = z11;
                    boolean z19 = z17;
                    i13++;
                    A02 = A0() / i13;
                    i15 = A02 / i11;
                    boolean z21 = z18;
                    z12 = z19;
                    z11 = z21;
                }
            }
            ArrayList arrayList = new ArrayList(i12 * i13);
            int i16 = z11;
            while (i16 < i12) {
                int i17 = z11;
                while (i17 < i13) {
                    k kVar = new k((a) null);
                    int unused = kVar.f72249b = i11;
                    boolean unused2 = kVar.f72252e = i11 == this.f72175f ? z12 : z11;
                    Rect unused3 = kVar.f72248a = new Rect(i16 * B02, i17 * A02, i16 == i12 + -1 ? B0() : (i16 + 1) * B02, i17 == i13 + -1 ? A0() : (i17 + 1) * A02);
                    Rect unused4 = kVar.f72253f = new Rect(0, 0, 0, 0);
                    Rect unused5 = kVar.f72254g = new Rect(kVar.f72248a);
                    arrayList.add(kVar);
                    i17++;
                    z11 = false;
                    z12 = true;
                }
                boolean z22 = z11;
                i16++;
                z12 = true;
            }
            boolean z23 = z11;
            this.f72177g.put(Integer.valueOf(i11), arrayList);
            if (i11 != 1) {
                i11 /= 2;
                boolean z24 = z23;
                z12 = true;
                z11 = z24;
            } else {
                return;
            }
        }
    }

    public final boolean i0() {
        boolean z11 = true;
        if (this.f72167b != null && !this.f72169c) {
            return true;
        }
        Map<Integer, List<k>> map = this.f72177g;
        if (map == null) {
            return false;
        }
        for (Map.Entry next : map.entrySet()) {
            if (((Integer) next.getKey()).intValue() == this.f72175f) {
                for (k kVar : (List) next.getValue()) {
                    if (kVar.f72251d || kVar.f72250c == null) {
                        z11 = false;
                    }
                }
            }
        }
        return z11;
    }

    public final boolean j0() {
        return this.f72180h0;
    }

    public final PointF k0(float f11, float f12, float f13, PointF pointF) {
        PointF M0 = M0(f11, f12, f13);
        pointF.set((((float) (getPaddingLeft() + (((getWidth() - getPaddingRight()) - getPaddingLeft()) / 2))) - M0.x) / f13, (((float) (getPaddingTop() + (((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2))) - M0.y) / f13);
        return pointF;
    }

    public final float l0(float f11) {
        return Math.min(this.f72183j, Math.max(m0(), f11));
    }

    public final float m0() {
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int i11 = this.f72191n;
        if (i11 == 2 || i11 == 4) {
            return Math.max(((float) (getWidth() - paddingLeft)) / ((float) B0()), ((float) (getHeight() - paddingBottom)) / ((float) A0()));
        }
        if (i11 == 3) {
            float f11 = this.f72185k;
            if (f11 > 0.0f) {
                return f11;
            }
        }
        return Math.min(((float) (getWidth() - paddingLeft)) / ((float) B0()), ((float) (getHeight() - paddingBottom)) / ((float) A0()));
    }

    public void n0() {
    }

    public final synchronized void o0(Bitmap bitmap, int i11, boolean z11) {
        h hVar;
        U("onImageLoaded", new Object[0]);
        int i12 = this.G;
        if (i12 > 0 && this.H > 0 && !(i12 == bitmap.getWidth() && this.H == bitmap.getHeight())) {
            y0(false);
        }
        Bitmap bitmap2 = this.f72167b;
        if (bitmap2 != null && !this.f72171d) {
            bitmap2.recycle();
        }
        if (!(this.f72167b == null || !this.f72171d || (hVar = this.f72184j0) == null)) {
            hVar.onPreviewReleased();
        }
        this.f72169c = false;
        this.f72171d = z11;
        this.f72167b = bitmap;
        this.G = bitmap.getWidth();
        this.H = bitmap.getHeight();
        this.I = i11;
        boolean S2 = S();
        boolean R2 = R();
        if (S2 || R2) {
            invalidate();
            requestLayout();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:107:0x041d  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0487  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDraw(android.graphics.Canvas r32) {
        /*
            r31 = this;
            r11 = r31
            r12 = r32
            super.onDraw(r32)
            r31.T()
            int r0 = r11.G
            if (r0 == 0) goto L_0x0757
            int r0 = r11.H
            if (r0 == 0) goto L_0x0757
            int r0 = r31.getWidth()
            if (r0 == 0) goto L_0x0757
            int r0 = r31.getHeight()
            if (r0 != 0) goto L_0x0020
            goto L_0x0757
        L_0x0020:
            java.util.Map<java.lang.Integer, java.util.List<com.hbg.lib.widgets.photoviewer.SubsamplingScaleImageView$k>> r0 = r11.f72177g
            if (r0 != 0) goto L_0x002f
            ia.d r0 = r11.R
            if (r0 == 0) goto L_0x002f
            android.graphics.Point r0 = r31.f0(r32)
            r11.g0(r0)
        L_0x002f:
            boolean r0 = r31.S()
            if (r0 != 0) goto L_0x0036
            return
        L_0x0036:
            r31.u0()
            com.hbg.lib.widgets.photoviewer.SubsamplingScaleImageView$d r0 = r11.f72178g0
            r9 = 0
            if (r0 == 0) goto L_0x016f
            android.graphics.PointF r0 = r0.f72221f
            if (r0 == 0) goto L_0x016f
            float r0 = r11.f72208y
            android.graphics.PointF r1 = r11.C
            if (r1 != 0) goto L_0x0051
            android.graphics.PointF r1 = new android.graphics.PointF
            r1.<init>(r9, r9)
            r11.C = r1
        L_0x0051:
            android.graphics.PointF r1 = r11.C
            android.graphics.PointF r2 = r11.A
            r1.set(r2)
            long r1 = java.lang.System.currentTimeMillis()
            com.hbg.lib.widgets.photoviewer.SubsamplingScaleImageView$d r3 = r11.f72178g0
            long r3 = r3.f72227l
            long r1 = r1 - r3
            com.hbg.lib.widgets.photoviewer.SubsamplingScaleImageView$d r3 = r11.f72178g0
            long r3 = r3.f72223h
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 <= 0) goto L_0x006f
            r10 = 1
            goto L_0x0070
        L_0x006f:
            r10 = 0
        L_0x0070:
            com.hbg.lib.widgets.photoviewer.SubsamplingScaleImageView$d r3 = r11.f72178g0
            long r3 = r3.f72223h
            long r15 = java.lang.Math.min(r1, r3)
            com.hbg.lib.widgets.photoviewer.SubsamplingScaleImageView$d r1 = r11.f72178g0
            int r2 = r1.f72225j
            com.hbg.lib.widgets.photoviewer.SubsamplingScaleImageView$d r1 = r11.f72178g0
            float r5 = r1.f72216a
            com.hbg.lib.widgets.photoviewer.SubsamplingScaleImageView$d r1 = r11.f72178g0
            float r1 = r1.f72217b
            com.hbg.lib.widgets.photoviewer.SubsamplingScaleImageView$d r3 = r11.f72178g0
            float r3 = r3.f72216a
            float r6 = r1 - r3
            com.hbg.lib.widgets.photoviewer.SubsamplingScaleImageView$d r1 = r11.f72178g0
            long r7 = r1.f72223h
            r1 = r31
            r3 = r15
            float r1 = r1.X(r2, r3, r5, r6, r7)
            r11.f72208y = r1
            com.hbg.lib.widgets.photoviewer.SubsamplingScaleImageView$d r1 = r11.f72178g0
            int r2 = r1.f72225j
            com.hbg.lib.widgets.photoviewer.SubsamplingScaleImageView$d r1 = r11.f72178g0
            android.graphics.PointF r1 = r1.f72221f
            float r5 = r1.x
            com.hbg.lib.widgets.photoviewer.SubsamplingScaleImageView$d r1 = r11.f72178g0
            android.graphics.PointF r1 = r1.f72222g
            float r1 = r1.x
            com.hbg.lib.widgets.photoviewer.SubsamplingScaleImageView$d r3 = r11.f72178g0
            android.graphics.PointF r3 = r3.f72221f
            float r3 = r3.x
            float r6 = r1 - r3
            com.hbg.lib.widgets.photoviewer.SubsamplingScaleImageView$d r1 = r11.f72178g0
            long r7 = r1.f72223h
            r1 = r31
            r3 = r15
            float r17 = r1.X(r2, r3, r5, r6, r7)
            com.hbg.lib.widgets.photoviewer.SubsamplingScaleImageView$d r1 = r11.f72178g0
            int r2 = r1.f72225j
            com.hbg.lib.widgets.photoviewer.SubsamplingScaleImageView$d r1 = r11.f72178g0
            android.graphics.PointF r1 = r1.f72221f
            float r5 = r1.y
            com.hbg.lib.widgets.photoviewer.SubsamplingScaleImageView$d r1 = r11.f72178g0
            android.graphics.PointF r1 = r1.f72222g
            float r1 = r1.y
            com.hbg.lib.widgets.photoviewer.SubsamplingScaleImageView$d r3 = r11.f72178g0
            android.graphics.PointF r3 = r3.f72221f
            float r3 = r3.y
            float r6 = r1 - r3
            com.hbg.lib.widgets.photoviewer.SubsamplingScaleImageView$d r1 = r11.f72178g0
            long r7 = r1.f72223h
            r1 = r31
            r3 = r15
            float r1 = r1.X(r2, r3, r5, r6, r7)
            android.graphics.PointF r2 = r11.A
            float r3 = r2.x
            com.hbg.lib.widgets.photoviewer.SubsamplingScaleImageView$d r4 = r11.f72178g0
            android.graphics.PointF r4 = r4.f72219d
            float r4 = r4.x
            float r4 = r11.J0(r4)
            float r4 = r4 - r17
            float r3 = r3 - r4
            r2.x = r3
            android.graphics.PointF r2 = r11.A
            float r3 = r2.y
            com.hbg.lib.widgets.photoviewer.SubsamplingScaleImageView$d r4 = r11.f72178g0
            android.graphics.PointF r4 = r4.f72219d
            float r4 = r4.y
            float r4 = r11.K0(r4)
            float r4 = r4 - r1
            float r3 = r3 - r4
            r2.y = r3
            if (r10 != 0) goto L_0x013b
            com.hbg.lib.widgets.photoviewer.SubsamplingScaleImageView$d r1 = r11.f72178g0
            float r1 = r1.f72216a
            com.hbg.lib.widgets.photoviewer.SubsamplingScaleImageView$d r2 = r11.f72178g0
            float r2 = r2.f72217b
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 != 0) goto L_0x0139
            goto L_0x013b
        L_0x0139:
            r1 = 0
            goto L_0x013c
        L_0x013b:
            r1 = 1
        L_0x013c:
            r11.c0(r1)
            android.graphics.PointF r1 = r11.C
            com.hbg.lib.widgets.photoviewer.SubsamplingScaleImageView$d r2 = r11.f72178g0
            int r2 = r2.f72226k
            r11.C0(r0, r1, r2)
            r11.w0(r10)
            if (r10 == 0) goto L_0x016c
            com.hbg.lib.widgets.photoviewer.SubsamplingScaleImageView$d r0 = r11.f72178g0
            com.hbg.lib.widgets.photoviewer.SubsamplingScaleImageView$g r0 = r0.f72228m
            if (r0 == 0) goto L_0x0169
            com.hbg.lib.widgets.photoviewer.SubsamplingScaleImageView$d r0 = r11.f72178g0     // Catch:{ Exception -> 0x0161 }
            com.hbg.lib.widgets.photoviewer.SubsamplingScaleImageView$g r0 = r0.f72228m     // Catch:{ Exception -> 0x0161 }
            r0.onComplete()     // Catch:{ Exception -> 0x0161 }
            goto L_0x0169
        L_0x0161:
            r0 = move-exception
            java.lang.String r1 = C0
            java.lang.String r2 = "Error thrown by animation listener"
            android.util.Log.w(r1, r2, r0)
        L_0x0169:
            r0 = 0
            r11.f72178g0 = r0
        L_0x016c:
            r31.invalidate()
        L_0x016f:
            java.util.Map<java.lang.Integer, java.util.List<com.hbg.lib.widgets.photoviewer.SubsamplingScaleImageView$k>> r0 = r11.f72177g
            r15 = 270(0x10e, float:3.78E-43)
            r10 = 90
            r8 = 35
            r7 = 180(0xb4, float:2.52E-43)
            if (r0 == 0) goto L_0x0498
            boolean r0 = r31.i0()
            if (r0 == 0) goto L_0x0498
            int r0 = r11.f72175f
            float r1 = r11.f72208y
            int r1 = r11.Q(r1)
            int r0 = java.lang.Math.min(r0, r1)
            java.util.Map<java.lang.Integer, java.util.List<com.hbg.lib.widgets.photoviewer.SubsamplingScaleImageView$k>> r1 = r11.f72177g
            java.util.Set r1 = r1.entrySet()
            java.util.Iterator r1 = r1.iterator()
            r16 = 0
        L_0x0199:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x01dc
            java.lang.Object r2 = r1.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r3 = r2.getKey()
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            if (r3 != r0) goto L_0x0199
            java.lang.Object r2 = r2.getValue()
            java.util.List r2 = (java.util.List) r2
            java.util.Iterator r2 = r2.iterator()
        L_0x01bb:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0199
            java.lang.Object r3 = r2.next()
            com.hbg.lib.widgets.photoviewer.SubsamplingScaleImageView$k r3 = (com.hbg.lib.widgets.photoviewer.SubsamplingScaleImageView.k) r3
            boolean r4 = r3.f72252e
            if (r4 == 0) goto L_0x01bb
            boolean r4 = r3.f72251d
            if (r4 != 0) goto L_0x01d9
            android.graphics.Bitmap r3 = r3.f72250c
            if (r3 != 0) goto L_0x01bb
        L_0x01d9:
            r16 = 1
            goto L_0x01bb
        L_0x01dc:
            java.util.Map<java.lang.Integer, java.util.List<com.hbg.lib.widgets.photoviewer.SubsamplingScaleImageView$k>> r1 = r11.f72177g
            java.util.Set r1 = r1.entrySet()
            java.util.Iterator r17 = r1.iterator()
        L_0x01e6:
            boolean r1 = r17.hasNext()
            if (r1 == 0) goto L_0x0493
            java.lang.Object r1 = r17.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getKey()
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            if (r2 == r0) goto L_0x0208
            if (r16 == 0) goto L_0x0201
            goto L_0x0208
        L_0x0201:
            r13 = r7
            r3 = r8
            r14 = r10
            r5 = 15
            goto L_0x048e
        L_0x0208:
            java.lang.Object r1 = r1.getValue()
            java.util.List r1 = (java.util.List) r1
            java.util.Iterator r18 = r1.iterator()
        L_0x0212:
            boolean r1 = r18.hasNext()
            if (r1 == 0) goto L_0x0201
            java.lang.Object r1 = r18.next()
            r19 = r1
            com.hbg.lib.widgets.photoviewer.SubsamplingScaleImageView$k r19 = (com.hbg.lib.widgets.photoviewer.SubsamplingScaleImageView.k) r19
            android.graphics.Rect r1 = r19.f72248a
            android.graphics.Rect r2 = r19.f72253f
            r11.I0(r1, r2)
            boolean r1 = r19.f72251d
            if (r1 != 0) goto L_0x03e2
            android.graphics.Bitmap r1 = r19.f72250c
            if (r1 == 0) goto L_0x03e2
            android.graphics.Paint r1 = r11.f72203v0
            if (r1 == 0) goto L_0x0244
            android.graphics.Rect r1 = r19.f72253f
            android.graphics.Paint r2 = r11.f72203v0
            r12.drawRect(r1, r2)
        L_0x0244:
            android.graphics.Matrix r1 = r11.f72207x0
            if (r1 != 0) goto L_0x024f
            android.graphics.Matrix r1 = new android.graphics.Matrix
            r1.<init>()
            r11.f72207x0 = r1
        L_0x024f:
            android.graphics.Matrix r1 = r11.f72207x0
            r1.reset()
            float[] r2 = r11.f72211z0
            r3 = 0
            r4 = 0
            android.graphics.Bitmap r1 = r19.f72250c
            int r1 = r1.getWidth()
            float r9 = (float) r1
            r20 = 0
            android.graphics.Bitmap r1 = r19.f72250c
            int r1 = r1.getWidth()
            float r1 = (float) r1
            android.graphics.Bitmap r21 = r19.f72250c
            int r5 = r21.getHeight()
            float r5 = (float) r5
            r21 = 0
            android.graphics.Bitmap r23 = r19.f72250c
            int r6 = r23.getHeight()
            float r6 = (float) r6
            r23 = r1
            r1 = r31
            r22 = r5
            r14 = 5
            r5 = r9
            r24 = r6
            r9 = 15
            r6 = r20
            r13 = r7
            r7 = r23
            r8 = r22
            r9 = r21
            r14 = r10
            r10 = r24
            r1.E0(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            int r1 = r31.getRequiredRotation()
            if (r1 != 0) goto L_0x02e2
            float[] r2 = r11.A0
            android.graphics.Rect r1 = r19.f72253f
            int r1 = r1.left
            float r3 = (float) r1
            android.graphics.Rect r1 = r19.f72253f
            int r1 = r1.top
            float r4 = (float) r1
            android.graphics.Rect r1 = r19.f72253f
            int r1 = r1.right
            float r5 = (float) r1
            android.graphics.Rect r1 = r19.f72253f
            int r1 = r1.top
            float r6 = (float) r1
            android.graphics.Rect r1 = r19.f72253f
            int r1 = r1.right
            float r7 = (float) r1
            android.graphics.Rect r1 = r19.f72253f
            int r1 = r1.bottom
            float r8 = (float) r1
            android.graphics.Rect r1 = r19.f72253f
            int r1 = r1.left
            float r9 = (float) r1
            android.graphics.Rect r1 = r19.f72253f
            int r1 = r1.bottom
            float r10 = (float) r1
            r1 = r31
            r1.E0(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            goto L_0x03b4
        L_0x02e2:
            int r1 = r31.getRequiredRotation()
            if (r1 != r14) goto L_0x0329
            float[] r2 = r11.A0
            android.graphics.Rect r1 = r19.f72253f
            int r1 = r1.right
            float r3 = (float) r1
            android.graphics.Rect r1 = r19.f72253f
            int r1 = r1.top
            float r4 = (float) r1
            android.graphics.Rect r1 = r19.f72253f
            int r1 = r1.right
            float r5 = (float) r1
            android.graphics.Rect r1 = r19.f72253f
            int r1 = r1.bottom
            float r6 = (float) r1
            android.graphics.Rect r1 = r19.f72253f
            int r1 = r1.left
            float r7 = (float) r1
            android.graphics.Rect r1 = r19.f72253f
            int r1 = r1.bottom
            float r8 = (float) r1
            android.graphics.Rect r1 = r19.f72253f
            int r1 = r1.left
            float r9 = (float) r1
            android.graphics.Rect r1 = r19.f72253f
            int r1 = r1.top
            float r10 = (float) r1
            r1 = r31
            r1.E0(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            goto L_0x03b4
        L_0x0329:
            int r1 = r31.getRequiredRotation()
            if (r1 != r13) goto L_0x036f
            float[] r2 = r11.A0
            android.graphics.Rect r1 = r19.f72253f
            int r1 = r1.right
            float r3 = (float) r1
            android.graphics.Rect r1 = r19.f72253f
            int r1 = r1.bottom
            float r4 = (float) r1
            android.graphics.Rect r1 = r19.f72253f
            int r1 = r1.left
            float r5 = (float) r1
            android.graphics.Rect r1 = r19.f72253f
            int r1 = r1.bottom
            float r6 = (float) r1
            android.graphics.Rect r1 = r19.f72253f
            int r1 = r1.left
            float r7 = (float) r1
            android.graphics.Rect r1 = r19.f72253f
            int r1 = r1.top
            float r8 = (float) r1
            android.graphics.Rect r1 = r19.f72253f
            int r1 = r1.right
            float r9 = (float) r1
            android.graphics.Rect r1 = r19.f72253f
            int r1 = r1.top
            float r10 = (float) r1
            r1 = r31
            r1.E0(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            goto L_0x03b4
        L_0x036f:
            int r1 = r31.getRequiredRotation()
            if (r1 != r15) goto L_0x03b4
            float[] r2 = r11.A0
            android.graphics.Rect r1 = r19.f72253f
            int r1 = r1.left
            float r3 = (float) r1
            android.graphics.Rect r1 = r19.f72253f
            int r1 = r1.bottom
            float r4 = (float) r1
            android.graphics.Rect r1 = r19.f72253f
            int r1 = r1.left
            float r5 = (float) r1
            android.graphics.Rect r1 = r19.f72253f
            int r1 = r1.top
            float r6 = (float) r1
            android.graphics.Rect r1 = r19.f72253f
            int r1 = r1.right
            float r7 = (float) r1
            android.graphics.Rect r1 = r19.f72253f
            int r1 = r1.top
            float r8 = (float) r1
            android.graphics.Rect r1 = r19.f72253f
            int r1 = r1.right
            float r9 = (float) r1
            android.graphics.Rect r1 = r19.f72253f
            int r1 = r1.bottom
            float r10 = (float) r1
            r1 = r31
            r1.E0(r2, r3, r4, r5, r6, r7, r8, r9, r10)
        L_0x03b4:
            android.graphics.Matrix r1 = r11.f72207x0
            float[] r2 = r11.f72211z0
            r27 = 0
            float[] r3 = r11.A0
            r29 = 0
            r30 = 4
            r25 = r1
            r26 = r2
            r28 = r3
            r25.setPolyToPoly(r26, r27, r28, r29, r30)
            android.graphics.Bitmap r1 = r19.f72250c
            android.graphics.Matrix r2 = r11.f72207x0
            android.graphics.Paint r3 = r11.f72192n0
            r12.drawBitmap(r1, r2, r3)
            boolean r1 = r11.f72179h
            if (r1 == 0) goto L_0x0411
            android.graphics.Rect r1 = r19.f72253f
            android.graphics.Paint r2 = r11.f72201u0
            r12.drawRect(r1, r2)
            goto L_0x0411
        L_0x03e2:
            r13 = r7
            r14 = r10
            boolean r1 = r19.f72251d
            if (r1 == 0) goto L_0x0411
            boolean r1 = r11.f72179h
            if (r1 == 0) goto L_0x0411
            android.graphics.Rect r1 = r19.f72253f
            int r1 = r1.left
            r2 = 5
            int r3 = r11.v0(r2)
            int r1 = r1 + r3
            float r1 = (float) r1
            android.graphics.Rect r2 = r19.f72253f
            int r2 = r2.top
            r3 = 35
            int r4 = r11.v0(r3)
            int r2 = r2 + r4
            float r2 = (float) r2
            android.graphics.Paint r4 = r11.f72199t0
            java.lang.String r5 = "LOADING"
            r12.drawText(r5, r1, r2, r4)
            goto L_0x0413
        L_0x0411:
            r3 = 35
        L_0x0413:
            boolean r1 = r19.f72252e
            if (r1 == 0) goto L_0x0487
            boolean r1 = r11.f72179h
            if (r1 == 0) goto L_0x0487
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "ISS "
            r1.append(r2)
            int r2 = r19.f72249b
            r1.append(r2)
            java.lang.String r2 = " RECT "
            r1.append(r2)
            android.graphics.Rect r2 = r19.f72248a
            int r2 = r2.top
            r1.append(r2)
            java.lang.String r2 = ","
            r1.append(r2)
            android.graphics.Rect r4 = r19.f72248a
            int r4 = r4.left
            r1.append(r4)
            r1.append(r2)
            android.graphics.Rect r4 = r19.f72248a
            int r4 = r4.bottom
            r1.append(r4)
            r1.append(r2)
            android.graphics.Rect r2 = r19.f72248a
            int r2 = r2.right
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            android.graphics.Rect r2 = r19.f72253f
            int r2 = r2.left
            r4 = 5
            int r5 = r11.v0(r4)
            int r2 = r2 + r5
            float r2 = (float) r2
            android.graphics.Rect r4 = r19.f72253f
            int r4 = r4.top
            r5 = 15
            int r6 = r11.v0(r5)
            int r4 = r4 + r6
            float r4 = (float) r4
            android.graphics.Paint r6 = r11.f72199t0
            r12.drawText(r1, r2, r4, r6)
            goto L_0x0489
        L_0x0487:
            r5 = 15
        L_0x0489:
            r8 = r3
            r7 = r13
            r10 = r14
            goto L_0x0212
        L_0x048e:
            r8 = r3
            r7 = r13
            r10 = r14
            goto L_0x01e6
        L_0x0493:
            r3 = r8
            r5 = 15
            goto L_0x0573
        L_0x0498:
            r13 = r7
            r3 = r8
            r14 = r10
            r5 = 15
            android.graphics.Bitmap r0 = r11.f72167b
            if (r0 == 0) goto L_0x0573
            boolean r0 = r0.isRecycled()
            if (r0 != 0) goto L_0x0573
            float r0 = r11.f72208y
            boolean r1 = r11.f72169c
            if (r1 == 0) goto L_0x04c8
            int r1 = r11.G
            float r1 = (float) r1
            android.graphics.Bitmap r2 = r11.f72167b
            int r2 = r2.getWidth()
            float r2 = (float) r2
            float r1 = r1 / r2
            float r0 = r0 * r1
            float r1 = r11.f72208y
            int r2 = r11.H
            float r2 = (float) r2
            android.graphics.Bitmap r4 = r11.f72167b
            int r4 = r4.getHeight()
            float r4 = (float) r4
            float r2 = r2 / r4
            float r1 = r1 * r2
            goto L_0x04c9
        L_0x04c8:
            r1 = r0
        L_0x04c9:
            android.graphics.Matrix r2 = r11.f72207x0
            if (r2 != 0) goto L_0x04d4
            android.graphics.Matrix r2 = new android.graphics.Matrix
            r2.<init>()
            r11.f72207x0 = r2
        L_0x04d4:
            android.graphics.Matrix r2 = r11.f72207x0
            r2.reset()
            android.graphics.Matrix r2 = r11.f72207x0
            r2.postScale(r0, r1)
            android.graphics.Matrix r0 = r11.f72207x0
            int r1 = r31.getRequiredRotation()
            float r1 = (float) r1
            r0.postRotate(r1)
            android.graphics.Matrix r0 = r11.f72207x0
            android.graphics.PointF r1 = r11.A
            float r2 = r1.x
            float r1 = r1.y
            r0.postTranslate(r2, r1)
            int r0 = r31.getRequiredRotation()
            if (r0 != r13) goto L_0x0509
            android.graphics.Matrix r0 = r11.f72207x0
            float r1 = r11.f72208y
            int r2 = r11.G
            float r2 = (float) r2
            float r2 = r2 * r1
            int r4 = r11.H
            float r4 = (float) r4
            float r1 = r1 * r4
            r0.postTranslate(r2, r1)
            goto L_0x052c
        L_0x0509:
            int r0 = r31.getRequiredRotation()
            if (r0 != r14) goto L_0x051b
            android.graphics.Matrix r0 = r11.f72207x0
            float r1 = r11.f72208y
            int r2 = r11.H
            float r2 = (float) r2
            float r1 = r1 * r2
            r0.postTranslate(r1, r9)
            goto L_0x052c
        L_0x051b:
            int r0 = r31.getRequiredRotation()
            if (r0 != r15) goto L_0x052c
            android.graphics.Matrix r0 = r11.f72207x0
            float r1 = r11.f72208y
            int r2 = r11.G
            float r2 = (float) r2
            float r1 = r1 * r2
            r0.postTranslate(r9, r1)
        L_0x052c:
            android.graphics.Paint r0 = r11.f72203v0
            if (r0 == 0) goto L_0x056a
            android.graphics.RectF r0 = r11.f72209y0
            if (r0 != 0) goto L_0x053b
            android.graphics.RectF r0 = new android.graphics.RectF
            r0.<init>()
            r11.f72209y0 = r0
        L_0x053b:
            android.graphics.RectF r0 = r11.f72209y0
            boolean r1 = r11.f72169c
            if (r1 == 0) goto L_0x0548
            android.graphics.Bitmap r1 = r11.f72167b
            int r1 = r1.getWidth()
            goto L_0x054a
        L_0x0548:
            int r1 = r11.G
        L_0x054a:
            float r1 = (float) r1
            boolean r2 = r11.f72169c
            if (r2 == 0) goto L_0x0556
            android.graphics.Bitmap r2 = r11.f72167b
            int r2 = r2.getHeight()
            goto L_0x0558
        L_0x0556:
            int r2 = r11.H
        L_0x0558:
            float r2 = (float) r2
            r0.set(r9, r9, r1, r2)
            android.graphics.Matrix r0 = r11.f72207x0
            android.graphics.RectF r1 = r11.f72209y0
            r0.mapRect(r1)
            android.graphics.RectF r0 = r11.f72209y0
            android.graphics.Paint r1 = r11.f72203v0
            r12.drawRect(r0, r1)
        L_0x056a:
            android.graphics.Bitmap r0 = r11.f72167b
            android.graphics.Matrix r1 = r11.f72207x0
            android.graphics.Paint r2 = r11.f72192n0
            r12.drawBitmap(r0, r1, r2)
        L_0x0573:
            boolean r0 = r11.f72179h
            if (r0 == 0) goto L_0x0757
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Scale: "
            r0.append(r1)
            java.util.Locale r1 = java.util.Locale.ENGLISH
            r2 = 1
            java.lang.Object[] r4 = new java.lang.Object[r2]
            float r6 = r11.f72208y
            java.lang.Float r6 = java.lang.Float.valueOf(r6)
            r7 = 0
            r4[r7] = r6
            java.lang.String r6 = "%.2f"
            java.lang.String r4 = java.lang.String.format(r1, r6, r4)
            r0.append(r4)
            java.lang.String r4 = " ("
            r0.append(r4)
            java.lang.Object[] r4 = new java.lang.Object[r2]
            float r8 = r31.m0()
            java.lang.Float r8 = java.lang.Float.valueOf(r8)
            r4[r7] = r8
            java.lang.String r4 = java.lang.String.format(r1, r6, r4)
            r0.append(r4)
            java.lang.String r4 = " - "
            r0.append(r4)
            java.lang.Object[] r4 = new java.lang.Object[r2]
            float r2 = r11.f72183j
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            r4[r7] = r2
            java.lang.String r2 = java.lang.String.format(r1, r6, r4)
            r0.append(r2)
            java.lang.String r2 = ")"
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            r2 = 5
            int r4 = r11.v0(r2)
            float r2 = (float) r4
            int r4 = r11.v0(r5)
            float r4 = (float) r4
            android.graphics.Paint r5 = r11.f72199t0
            r12.drawText(r0, r2, r4, r5)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "Translate: "
            r0.append(r2)
            r2 = 1
            java.lang.Object[] r4 = new java.lang.Object[r2]
            android.graphics.PointF r5 = r11.A
            float r5 = r5.x
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
            r7 = 0
            r4[r7] = r5
            java.lang.String r4 = java.lang.String.format(r1, r6, r4)
            r0.append(r4)
            java.lang.String r4 = ":"
            r0.append(r4)
            java.lang.Object[] r5 = new java.lang.Object[r2]
            android.graphics.PointF r2 = r11.A
            float r2 = r2.y
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            r5[r7] = r2
            java.lang.String r2 = java.lang.String.format(r1, r6, r5)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            r2 = 5
            int r5 = r11.v0(r2)
            float r2 = (float) r5
            r5 = 30
            int r7 = r11.v0(r5)
            float r7 = (float) r7
            android.graphics.Paint r8 = r11.f72199t0
            r12.drawText(r0, r2, r7, r8)
            android.graphics.PointF r0 = r31.getCenter()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r7 = "Source center: "
            r2.append(r7)
            r7 = 1
            java.lang.Object[] r8 = new java.lang.Object[r7]
            float r9 = r0.x
            java.lang.Float r9 = java.lang.Float.valueOf(r9)
            r10 = 0
            r8[r10] = r9
            java.lang.String r8 = java.lang.String.format(r1, r6, r8)
            r2.append(r8)
            r2.append(r4)
            java.lang.Object[] r4 = new java.lang.Object[r7]
            float r0 = r0.y
            java.lang.Float r0 = java.lang.Float.valueOf(r0)
            r4[r10] = r0
            java.lang.String r0 = java.lang.String.format(r1, r6, r4)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1 = 5
            int r1 = r11.v0(r1)
            float r1 = (float) r1
            r2 = 45
            int r2 = r11.v0(r2)
            float r2 = (float) r2
            android.graphics.Paint r4 = r11.f72199t0
            r12.drawText(r0, r1, r2, r4)
            com.hbg.lib.widgets.photoviewer.SubsamplingScaleImageView$d r0 = r11.f72178g0
            r1 = -16711681(0xffffffffff00ffff, float:-1.714704E38)
            r2 = -16776961(0xffffffffff0000ff, float:-1.7014636E38)
            r4 = 20
            r6 = -65536(0xffffffffffff0000, float:NaN)
            if (r0 == 0) goto L_0x06f6
            android.graphics.PointF r0 = r0.f72218c
            android.graphics.PointF r0 = r11.H0(r0)
            com.hbg.lib.widgets.photoviewer.SubsamplingScaleImageView$d r7 = r11.f72178g0
            android.graphics.PointF r7 = r7.f72220e
            android.graphics.PointF r7 = r11.H0(r7)
            com.hbg.lib.widgets.photoviewer.SubsamplingScaleImageView$d r8 = r11.f72178g0
            android.graphics.PointF r8 = r8.f72219d
            android.graphics.PointF r8 = r11.H0(r8)
            float r9 = r0.x
            float r0 = r0.y
            r10 = 10
            int r10 = r11.v0(r10)
            float r10 = (float) r10
            android.graphics.Paint r13 = r11.f72201u0
            r12.drawCircle(r9, r0, r10, r13)
            android.graphics.Paint r0 = r11.f72201u0
            r0.setColor(r6)
            float r0 = r7.x
            float r7 = r7.y
            int r9 = r11.v0(r4)
            float r9 = (float) r9
            android.graphics.Paint r10 = r11.f72201u0
            r12.drawCircle(r0, r7, r9, r10)
            android.graphics.Paint r0 = r11.f72201u0
            r0.setColor(r2)
            float r0 = r8.x
            float r7 = r8.y
            r8 = 25
            int r8 = r11.v0(r8)
            float r8 = (float) r8
            android.graphics.Paint r9 = r11.f72201u0
            r12.drawCircle(r0, r7, r8, r9)
            android.graphics.Paint r0 = r11.f72201u0
            r0.setColor(r1)
            int r0 = r31.getWidth()
            int r0 = r0 / 2
            float r0 = (float) r0
            int r7 = r31.getHeight()
            int r7 = r7 / 2
            float r7 = (float) r7
            int r8 = r11.v0(r5)
            float r8 = (float) r8
            android.graphics.Paint r9 = r11.f72201u0
            r12.drawCircle(r0, r7, r8, r9)
        L_0x06f6:
            android.graphics.PointF r0 = r11.V
            if (r0 == 0) goto L_0x070f
            android.graphics.Paint r0 = r11.f72201u0
            r0.setColor(r6)
            android.graphics.PointF r0 = r11.V
            float r6 = r0.x
            float r0 = r0.y
            int r4 = r11.v0(r4)
            float r4 = (float) r4
            android.graphics.Paint r7 = r11.f72201u0
            r12.drawCircle(r6, r0, r4, r7)
        L_0x070f:
            android.graphics.PointF r0 = r11.f72174e0
            if (r0 == 0) goto L_0x0732
            android.graphics.Paint r0 = r11.f72201u0
            r0.setColor(r2)
            android.graphics.PointF r0 = r11.f72174e0
            float r0 = r0.x
            float r0 = r11.J0(r0)
            android.graphics.PointF r2 = r11.f72174e0
            float r2 = r2.y
            float r2 = r11.K0(r2)
            int r3 = r11.v0(r3)
            float r3 = (float) r3
            android.graphics.Paint r4 = r11.f72201u0
            r12.drawCircle(r0, r2, r3, r4)
        L_0x0732:
            android.graphics.PointF r0 = r11.f72176f0
            if (r0 == 0) goto L_0x074f
            boolean r0 = r11.N
            if (r0 == 0) goto L_0x074f
            android.graphics.Paint r0 = r11.f72201u0
            r0.setColor(r1)
            android.graphics.PointF r0 = r11.f72176f0
            float r1 = r0.x
            float r0 = r0.y
            int r2 = r11.v0(r5)
            float r2 = (float) r2
            android.graphics.Paint r3 = r11.f72201u0
            r12.drawCircle(r1, r0, r2, r3)
        L_0x074f:
            android.graphics.Paint r0 = r11.f72201u0
            r1 = -65281(0xffffffffffff00ff, float:NaN)
            r0.setColor(r1)
        L_0x0757:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.lib.widgets.photoviewer.SubsamplingScaleImageView.onDraw(android.graphics.Canvas):void");
    }

    public void onMeasure(int i11, int i12) {
        int mode = View.MeasureSpec.getMode(i11);
        int mode2 = View.MeasureSpec.getMode(i12);
        int size = View.MeasureSpec.getSize(i11);
        int size2 = View.MeasureSpec.getSize(i12);
        boolean z11 = true;
        boolean z12 = mode != 1073741824;
        if (mode2 == 1073741824) {
            z11 = false;
        }
        if (this.G > 0 && this.H > 0) {
            if (z12 && z11) {
                size = B0();
                size2 = A0();
            } else if (z11) {
                size2 = (int) ((((double) A0()) / ((double) B0())) * ((double) size));
            } else if (z12) {
                size = (int) ((((double) B0()) / ((double) A0())) * ((double) size2));
            }
        }
        setMeasuredDimension(Math.max(size, getSuggestedMinimumWidth()), Math.max(size2, getSuggestedMinimumHeight()));
    }

    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        U("onSizeChanged %dx%d -> %dx%d", Integer.valueOf(i13), Integer.valueOf(i14), Integer.valueOf(i11), Integer.valueOf(i12));
        PointF center = getCenter();
        if (this.f72180h0 && center != null) {
            this.f72178g0 = null;
            this.D = Float.valueOf(this.f72208y);
            this.E = center;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        GestureDetector gestureDetector;
        d dVar = this.f72178g0;
        if (dVar == null || dVar.f72224i) {
            d dVar2 = this.f72178g0;
            if (!(dVar2 == null || dVar2.f72228m == null)) {
                try {
                    this.f72178g0.f72228m.onInterruptedByUser();
                } catch (Exception e11) {
                    Log.w(C0, "Error thrown by animation listener", e11);
                }
            }
            this.f72178g0 = null;
            if (this.A == null) {
                GestureDetector gestureDetector2 = this.Q;
                if (gestureDetector2 != null) {
                    gestureDetector2.onTouchEvent(motionEvent);
                }
                return true;
            } else if (this.N || ((gestureDetector = this.P) != null && !gestureDetector.onTouchEvent(motionEvent))) {
                if (this.B == null) {
                    this.B = new PointF(0.0f, 0.0f);
                }
                if (this.C == null) {
                    this.C = new PointF(0.0f, 0.0f);
                }
                if (this.V == null) {
                    this.V = new PointF(0.0f, 0.0f);
                }
                float f11 = this.f72208y;
                this.C.set(this.A);
                boolean t02 = t0(motionEvent);
                C0(f11, this.C, 2);
                if (t02 || super.onTouchEvent(motionEvent)) {
                    return true;
                }
                return false;
            } else {
                this.L = false;
                this.M = false;
                this.O = 0;
                return true;
            }
        } else {
            x0(true);
            return true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void p0(android.graphics.Bitmap r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.lang.String r0 = "onPreviewLoaded"
            r1 = 0
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x0043 }
            r4.U(r0, r1)     // Catch:{ all -> 0x0043 }
            android.graphics.Bitmap r0 = r4.f72167b     // Catch:{ all -> 0x0043 }
            if (r0 != 0) goto L_0x003e
            boolean r0 = r4.f72182i0     // Catch:{ all -> 0x0043 }
            if (r0 == 0) goto L_0x0012
            goto L_0x003e
        L_0x0012:
            android.graphics.Rect r0 = r4.K     // Catch:{ all -> 0x0043 }
            if (r0 == 0) goto L_0x002b
            int r1 = r0.left     // Catch:{ all -> 0x0043 }
            int r2 = r0.top     // Catch:{ all -> 0x0043 }
            int r0 = r0.width()     // Catch:{ all -> 0x0043 }
            android.graphics.Rect r3 = r4.K     // Catch:{ all -> 0x0043 }
            int r3 = r3.height()     // Catch:{ all -> 0x0043 }
            android.graphics.Bitmap r5 = android.graphics.Bitmap.createBitmap(r5, r1, r2, r0, r3)     // Catch:{ all -> 0x0043 }
            r4.f72167b = r5     // Catch:{ all -> 0x0043 }
            goto L_0x002d
        L_0x002b:
            r4.f72167b = r5     // Catch:{ all -> 0x0043 }
        L_0x002d:
            r5 = 1
            r4.f72169c = r5     // Catch:{ all -> 0x0043 }
            boolean r5 = r4.S()     // Catch:{ all -> 0x0043 }
            if (r5 == 0) goto L_0x003c
            r4.invalidate()     // Catch:{ all -> 0x0043 }
            r4.requestLayout()     // Catch:{ all -> 0x0043 }
        L_0x003c:
            monitor-exit(r4)
            return
        L_0x003e:
            r5.recycle()     // Catch:{ all -> 0x0043 }
            monitor-exit(r4)
            return
        L_0x0043:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.lib.widgets.photoviewer.SubsamplingScaleImageView.p0(android.graphics.Bitmap):void");
    }

    public void q0() {
    }

    public final synchronized void r0() {
        Bitmap bitmap;
        U("onTileLoaded", new Object[0]);
        S();
        R();
        if (i0() && (bitmap = this.f72167b) != null) {
            if (!this.f72171d) {
                bitmap.recycle();
            }
            this.f72167b = null;
            h hVar = this.f72184j0;
            if (hVar != null && this.f72171d) {
                hVar.onPreviewReleased();
            }
            this.f72169c = false;
            this.f72171d = false;
        }
        invalidate();
    }

    public final synchronized void s0(ia.d dVar, int i11, int i12, int i13) {
        int i14;
        int i15;
        int i16;
        U("onTilesInited sWidth=%d, sHeight=%d, sOrientation=%d", Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(this.f72181i));
        int i17 = this.G;
        if (i17 > 0 && (i16 = this.H) > 0 && !(i17 == i11 && i16 == i12)) {
            y0(false);
            Bitmap bitmap = this.f72167b;
            if (bitmap != null) {
                if (!this.f72171d) {
                    bitmap.recycle();
                }
                this.f72167b = null;
                h hVar = this.f72184j0;
                if (hVar != null && this.f72171d) {
                    hVar.onPreviewReleased();
                }
                this.f72169c = false;
                this.f72171d = false;
            }
        }
        this.R = dVar;
        this.G = i11;
        this.H = i12;
        this.I = i13;
        S();
        if (!R() && (i14 = this.f72193o) > 0 && i14 != Integer.MAX_VALUE && (i15 = this.f72194p) > 0 && i15 != Integer.MAX_VALUE && getWidth() > 0 && getHeight() > 0) {
            g0(new Point(this.f72193o, this.f72194p));
        }
        invalidate();
        requestLayout();
    }

    public final void setBitmapDecoderClass(Class<? extends ia.c> cls) {
        if (cls != null) {
            this.T = new ia.a(cls);
            return;
        }
        throw new IllegalArgumentException("Decoder class cannot be set to null");
    }

    public final void setBitmapDecoderFactory(ia.b<? extends ia.c> bVar) {
        if (bVar != null) {
            this.T = bVar;
            return;
        }
        throw new IllegalArgumentException("Decoder factory cannot be set to null");
    }

    public final void setDebug(boolean z11) {
        this.f72179h = z11;
    }

    public final void setDoubleTapZoomDpi(int i11) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setDoubleTapZoomScale(((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) / ((float) i11));
    }

    public final void setDoubleTapZoomDuration(int i11) {
        this.f72206x = Math.max(0, i11);
    }

    public final void setDoubleTapZoomScale(float f11) {
        this.f72202v = f11;
    }

    public final void setDoubleTapZoomStyle(int i11) {
        if (E0.contains(Integer.valueOf(i11))) {
            this.f72204w = i11;
            return;
        }
        throw new IllegalArgumentException("Invalid zoom style: " + i11);
    }

    public void setEagerLoadingEnabled(boolean z11) {
        this.f72196r = z11;
    }

    public void setExecutor(Executor executor) {
        Objects.requireNonNull(executor, "Executor must not be null");
        this.f72195q = executor;
    }

    public final void setImage(ia.e eVar) {
        D0(eVar, (ia.e) null, (ImageViewState) null);
    }

    public final void setMaxScale(float f11) {
        this.f72183j = f11;
    }

    public void setMaxTileSize(int i11) {
        this.f72193o = i11;
        this.f72194p = i11;
    }

    public final void setMaximumDpi(int i11) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setMinScale(((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) / ((float) i11));
    }

    public final void setMinScale(float f11) {
        this.f72185k = f11;
    }

    public final void setMinimumDpi(int i11) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setMaxScale(((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) / ((float) i11));
    }

    public final void setMinimumScaleType(int i11) {
        if (H0.contains(Integer.valueOf(i11))) {
            this.f72191n = i11;
            if (j0()) {
                c0(true);
                invalidate();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Invalid scale type: " + i11);
    }

    public void setMinimumTileDpi(int i11) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.f72187l = (int) Math.min((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f, (float) i11);
        if (j0()) {
            y0(false);
            invalidate();
        }
    }

    public void setOnImageEventListener(h hVar) {
        this.f72184j0 = hVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f72188l0 = onLongClickListener;
    }

    public void setOnStateChangedListener(i iVar) {
        this.f72186k0 = iVar;
    }

    public final void setOrientation(int i11) {
        if (D0.contains(Integer.valueOf(i11))) {
            this.f72181i = i11;
            y0(false);
            invalidate();
            requestLayout();
            return;
        }
        throw new IllegalArgumentException("Invalid orientation: " + i11);
    }

    public final void setPanEnabled(boolean z11) {
        PointF pointF;
        this.f72197s = z11;
        if (!z11 && (pointF = this.A) != null) {
            pointF.x = ((float) (getWidth() / 2)) - (this.f72208y * ((float) (B0() / 2)));
            this.A.y = ((float) (getHeight() / 2)) - (this.f72208y * ((float) (A0() / 2)));
            if (j0()) {
                w0(true);
                invalidate();
            }
        }
    }

    public final void setPanLimit(int i11) {
        if (G0.contains(Integer.valueOf(i11))) {
            this.f72189m = i11;
            if (j0()) {
                c0(true);
                invalidate();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Invalid pan limit: " + i11);
    }

    public final void setQuickScaleEnabled(boolean z11) {
        this.f72200u = z11;
    }

    public final void setRegionDecoderClass(Class<? extends ia.d> cls) {
        if (cls != null) {
            this.U = new ia.a(cls);
            return;
        }
        throw new IllegalArgumentException("Decoder class cannot be set to null");
    }

    public final void setRegionDecoderFactory(ia.b<? extends ia.d> bVar) {
        if (bVar != null) {
            this.U = bVar;
            return;
        }
        throw new IllegalArgumentException("Decoder factory cannot be set to null");
    }

    public final void setTileBackgroundColor(int i11) {
        if (Color.alpha(i11) == 0) {
            this.f72203v0 = null;
        } else {
            Paint paint = new Paint();
            this.f72203v0 = paint;
            paint.setStyle(Paint.Style.FILL);
            this.f72203v0.setColor(i11);
        }
        invalidate();
    }

    public final void setZoomEnabled(boolean z11) {
        this.f72198t = z11;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001f, code lost:
        if (r1 != 262) goto L_0x03ac;
     */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x03a3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean t0(android.view.MotionEvent r13) {
        /*
            r12 = this;
            int r0 = r13.getPointerCount()
            int r1 = r13.getAction()
            r2 = 1073741824(0x40000000, float:2.0)
            r3 = 2
            r4 = 0
            r5 = 1
            if (r1 == 0) goto L_0x0419
            if (r1 == r5) goto L_0x03ad
            if (r1 == r3) goto L_0x0023
            r6 = 5
            if (r1 == r6) goto L_0x0419
            r6 = 6
            if (r1 == r6) goto L_0x03ad
            r6 = 261(0x105, float:3.66E-43)
            if (r1 == r6) goto L_0x0419
            r2 = 262(0x106, float:3.67E-43)
            if (r1 == r2) goto L_0x03ad
            goto L_0x03ac
        L_0x0023:
            int r1 = r12.O
            if (r1 <= 0) goto L_0x03a0
            r1 = 1084227584(0x40a00000, float:5.0)
            if (r0 < r3) goto L_0x017f
            float r0 = r13.getX(r4)
            float r6 = r13.getX(r5)
            float r7 = r13.getY(r4)
            float r8 = r13.getY(r5)
            float r0 = r12.V(r0, r6, r7, r8)
            float r6 = r13.getX(r4)
            float r7 = r13.getX(r5)
            float r6 = r6 + r7
            float r6 = r6 / r2
            float r7 = r13.getY(r4)
            float r13 = r13.getY(r5)
            float r7 = r7 + r13
            float r7 = r7 / r2
            boolean r13 = r12.f72198t
            if (r13 == 0) goto L_0x03a0
            android.graphics.PointF r13 = r12.V
            float r2 = r13.x
            float r13 = r13.y
            float r13 = r12.V(r2, r6, r13, r7)
            int r13 = (r13 > r1 ? 1 : (r13 == r1 ? 0 : -1))
            if (r13 > 0) goto L_0x0075
            float r13 = r12.W
            float r13 = r0 - r13
            float r13 = java.lang.Math.abs(r13)
            int r13 = (r13 > r1 ? 1 : (r13 == r1 ? 0 : -1))
            if (r13 > 0) goto L_0x0075
            boolean r13 = r12.M
            if (r13 == 0) goto L_0x03a0
        L_0x0075:
            r12.L = r5
            r12.M = r5
            float r13 = r12.f72208y
            double r1 = (double) r13
            float r13 = r12.f72183j
            float r8 = r12.W
            float r8 = r0 / r8
            float r9 = r12.f72210z
            float r8 = r8 * r9
            float r13 = java.lang.Math.min(r13, r8)
            r12.f72208y = r13
            float r8 = r12.m0()
            int r13 = (r13 > r8 ? 1 : (r13 == r8 ? 0 : -1))
            if (r13 > 0) goto L_0x00a9
            r12.W = r0
            float r13 = r12.m0()
            r12.f72210z = r13
            android.graphics.PointF r13 = r12.V
            r13.set(r6, r7)
            android.graphics.PointF r13 = r12.B
            android.graphics.PointF r0 = r12.A
            r13.set(r0)
            goto L_0x0175
        L_0x00a9:
            boolean r13 = r12.f72197s
            if (r13 == 0) goto L_0x0124
            android.graphics.PointF r13 = r12.V
            float r3 = r13.x
            android.graphics.PointF r8 = r12.B
            float r9 = r8.x
            float r3 = r3 - r9
            float r13 = r13.y
            float r8 = r8.y
            float r13 = r13 - r8
            float r8 = r12.f72208y
            float r9 = r12.f72210z
            float r10 = r8 / r9
            float r3 = r3 * r10
            float r8 = r8 / r9
            float r13 = r13 * r8
            android.graphics.PointF r8 = r12.A
            float r3 = r6 - r3
            r8.x = r3
            float r13 = r7 - r13
            r8.y = r13
            int r13 = r12.A0()
            double r8 = (double) r13
            double r8 = r8 * r1
            int r13 = r12.getHeight()
            double r10 = (double) r13
            int r13 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r13 >= 0) goto L_0x00ee
            float r13 = r12.f72208y
            int r3 = r12.A0()
            float r3 = (float) r3
            float r13 = r13 * r3
            int r3 = r12.getHeight()
            float r3 = (float) r3
            int r13 = (r13 > r3 ? 1 : (r13 == r3 ? 0 : -1))
            if (r13 >= 0) goto L_0x010e
        L_0x00ee:
            int r13 = r12.B0()
            double r8 = (double) r13
            double r1 = r1 * r8
            int r13 = r12.getWidth()
            double r8 = (double) r13
            int r13 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r13 >= 0) goto L_0x0175
            float r13 = r12.f72208y
            int r1 = r12.B0()
            float r1 = (float) r1
            float r13 = r13 * r1
            int r1 = r12.getWidth()
            float r1 = (float) r1
            int r13 = (r13 > r1 ? 1 : (r13 == r1 ? 0 : -1))
            if (r13 < 0) goto L_0x0175
        L_0x010e:
            r12.c0(r5)
            android.graphics.PointF r13 = r12.V
            r13.set(r6, r7)
            android.graphics.PointF r13 = r12.B
            android.graphics.PointF r1 = r12.A
            r13.set(r1)
            float r13 = r12.f72208y
            r12.f72210z = r13
            r12.W = r0
            goto L_0x0175
        L_0x0124:
            android.graphics.PointF r13 = r12.F
            if (r13 == 0) goto L_0x014d
            android.graphics.PointF r13 = r12.A
            int r0 = r12.getWidth()
            int r0 = r0 / r3
            float r0 = (float) r0
            float r1 = r12.f72208y
            android.graphics.PointF r2 = r12.F
            float r2 = r2.x
            float r1 = r1 * r2
            float r0 = r0 - r1
            r13.x = r0
            android.graphics.PointF r13 = r12.A
            int r0 = r12.getHeight()
            int r0 = r0 / r3
            float r0 = (float) r0
            float r1 = r12.f72208y
            android.graphics.PointF r2 = r12.F
            float r2 = r2.y
            float r1 = r1 * r2
            float r0 = r0 - r1
            r13.y = r0
            goto L_0x0175
        L_0x014d:
            android.graphics.PointF r13 = r12.A
            int r0 = r12.getWidth()
            int r0 = r0 / r3
            float r0 = (float) r0
            float r1 = r12.f72208y
            int r2 = r12.B0()
            int r2 = r2 / r3
            float r2 = (float) r2
            float r1 = r1 * r2
            float r0 = r0 - r1
            r13.x = r0
            android.graphics.PointF r13 = r12.A
            int r0 = r12.getHeight()
            int r0 = r0 / r3
            float r0 = (float) r0
            float r1 = r12.f72208y
            int r2 = r12.A0()
            int r2 = r2 / r3
            float r2 = (float) r2
            float r1 = r1 * r2
            float r0 = r0 - r1
            r13.y = r0
        L_0x0175:
            r12.c0(r5)
            boolean r13 = r12.f72196r
            r12.w0(r13)
            goto L_0x02cc
        L_0x017f:
            boolean r0 = r12.N
            if (r0 == 0) goto L_0x02cf
            android.graphics.PointF r0 = r12.f72176f0
            float r0 = r0.y
            float r1 = r13.getY()
            float r0 = r0 - r1
            float r0 = java.lang.Math.abs(r0)
            float r0 = r0 * r2
            float r1 = r12.f72166a0
            float r0 = r0 + r1
            float r1 = r12.f72168b0
            r2 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 != 0) goto L_0x019e
            r12.f72168b0 = r0
        L_0x019e:
            float r1 = r13.getY()
            android.graphics.PointF r2 = r12.f72172d0
            float r6 = r2.y
            int r1 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r1 <= 0) goto L_0x01ac
            r1 = r5
            goto L_0x01ad
        L_0x01ac:
            r1 = r4
        L_0x01ad:
            float r13 = r13.getY()
            r6 = 0
            r2.set(r6, r13)
            float r13 = r12.f72168b0
            float r13 = r0 / r13
            r2 = 1065353216(0x3f800000, float:1.0)
            float r13 = r2 - r13
            float r13 = java.lang.Math.abs(r13)
            r7 = 1056964608(0x3f000000, float:0.5)
            float r13 = r13 * r7
            r7 = 1022739087(0x3cf5c28f, float:0.03)
            int r7 = (r13 > r7 ? 1 : (r13 == r7 ? 0 : -1))
            if (r7 > 0) goto L_0x01cf
            boolean r7 = r12.f72170c0
            if (r7 == 0) goto L_0x02c2
        L_0x01cf:
            r12.f72170c0 = r5
            float r7 = r12.f72168b0
            int r7 = (r7 > r6 ? 1 : (r7 == r6 ? 0 : -1))
            if (r7 <= 0) goto L_0x01dd
            if (r1 == 0) goto L_0x01dc
            float r13 = r13 + r2
            r2 = r13
            goto L_0x01dd
        L_0x01dc:
            float r2 = r2 - r13
        L_0x01dd:
            float r13 = r12.f72208y
            double r7 = (double) r13
            float r13 = r12.m0()
            float r1 = r12.f72183j
            float r9 = r12.f72208y
            float r9 = r9 * r2
            float r1 = java.lang.Math.min(r1, r9)
            float r13 = java.lang.Math.max(r13, r1)
            r12.f72208y = r13
            boolean r1 = r12.f72197s
            if (r1 == 0) goto L_0x0271
            android.graphics.PointF r1 = r12.V
            float r2 = r1.x
            android.graphics.PointF r3 = r12.B
            float r9 = r3.x
            float r9 = r2 - r9
            float r1 = r1.y
            float r3 = r3.y
            float r3 = r1 - r3
            float r10 = r12.f72210z
            float r11 = r13 / r10
            float r9 = r9 * r11
            float r13 = r13 / r10
            float r3 = r3 * r13
            android.graphics.PointF r13 = r12.A
            float r2 = r2 - r9
            r13.x = r2
            float r1 = r1 - r3
            r13.y = r1
            int r13 = r12.A0()
            double r1 = (double) r13
            double r1 = r1 * r7
            int r13 = r12.getHeight()
            double r9 = (double) r13
            int r13 = (r1 > r9 ? 1 : (r1 == r9 ? 0 : -1))
            if (r13 >= 0) goto L_0x0236
            float r13 = r12.f72208y
            int r1 = r12.A0()
            float r1 = (float) r1
            float r13 = r13 * r1
            int r1 = r12.getHeight()
            float r1 = (float) r1
            int r13 = (r13 > r1 ? 1 : (r13 == r1 ? 0 : -1))
            if (r13 >= 0) goto L_0x0256
        L_0x0236:
            int r13 = r12.B0()
            double r1 = (double) r13
            double r7 = r7 * r1
            int r13 = r12.getWidth()
            double r1 = (double) r13
            int r13 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r13 >= 0) goto L_0x02c2
            float r13 = r12.f72208y
            int r1 = r12.B0()
            float r1 = (float) r1
            float r13 = r13 * r1
            int r1 = r12.getWidth()
            float r1 = (float) r1
            int r13 = (r13 > r1 ? 1 : (r13 == r1 ? 0 : -1))
            if (r13 < 0) goto L_0x02c2
        L_0x0256:
            r12.c0(r5)
            android.graphics.PointF r13 = r12.V
            android.graphics.PointF r0 = r12.f72174e0
            android.graphics.PointF r0 = r12.H0(r0)
            r13.set(r0)
            android.graphics.PointF r13 = r12.B
            android.graphics.PointF r0 = r12.A
            r13.set(r0)
            float r13 = r12.f72208y
            r12.f72210z = r13
            r0 = r6
            goto L_0x02c2
        L_0x0271:
            android.graphics.PointF r13 = r12.F
            if (r13 == 0) goto L_0x029a
            android.graphics.PointF r13 = r12.A
            int r1 = r12.getWidth()
            int r1 = r1 / r3
            float r1 = (float) r1
            float r2 = r12.f72208y
            android.graphics.PointF r6 = r12.F
            float r6 = r6.x
            float r2 = r2 * r6
            float r1 = r1 - r2
            r13.x = r1
            android.graphics.PointF r13 = r12.A
            int r1 = r12.getHeight()
            int r1 = r1 / r3
            float r1 = (float) r1
            float r2 = r12.f72208y
            android.graphics.PointF r3 = r12.F
            float r3 = r3.y
            float r2 = r2 * r3
            float r1 = r1 - r2
            r13.y = r1
            goto L_0x02c2
        L_0x029a:
            android.graphics.PointF r13 = r12.A
            int r1 = r12.getWidth()
            int r1 = r1 / r3
            float r1 = (float) r1
            float r2 = r12.f72208y
            int r6 = r12.B0()
            int r6 = r6 / r3
            float r6 = (float) r6
            float r2 = r2 * r6
            float r1 = r1 - r2
            r13.x = r1
            android.graphics.PointF r13 = r12.A
            int r1 = r12.getHeight()
            int r1 = r1 / r3
            float r1 = (float) r1
            float r2 = r12.f72208y
            int r6 = r12.A0()
            int r6 = r6 / r3
            float r3 = (float) r6
            float r2 = r2 * r3
            float r1 = r1 - r2
            r13.y = r1
        L_0x02c2:
            r12.f72168b0 = r0
            r12.c0(r5)
            boolean r13 = r12.f72196r
            r12.w0(r13)
        L_0x02cc:
            r13 = r5
            goto L_0x03a1
        L_0x02cf:
            boolean r0 = r12.L
            if (r0 != 0) goto L_0x03a0
            float r0 = r13.getX()
            android.graphics.PointF r2 = r12.V
            float r2 = r2.x
            float r0 = r0 - r2
            float r0 = java.lang.Math.abs(r0)
            float r2 = r13.getY()
            android.graphics.PointF r3 = r12.V
            float r3 = r3.y
            float r2 = r2 - r3
            float r2 = java.lang.Math.abs(r2)
            float r3 = r12.B0
            float r3 = r3 * r1
            int r1 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r1 > 0) goto L_0x02fc
            int r6 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r6 > 0) goto L_0x02fc
            boolean r6 = r12.M
            if (r6 == 0) goto L_0x03a0
        L_0x02fc:
            android.graphics.PointF r6 = r12.A
            android.graphics.PointF r7 = r12.B
            float r7 = r7.x
            float r8 = r13.getX()
            android.graphics.PointF r9 = r12.V
            float r9 = r9.x
            float r8 = r8 - r9
            float r7 = r7 + r8
            r6.x = r7
            android.graphics.PointF r6 = r12.A
            android.graphics.PointF r7 = r12.B
            float r7 = r7.y
            float r13 = r13.getY()
            android.graphics.PointF r8 = r12.V
            float r8 = r8.y
            float r13 = r13 - r8
            float r7 = r7 + r13
            r6.y = r7
            android.graphics.PointF r13 = r12.A
            float r6 = r13.x
            float r13 = r13.y
            r12.c0(r5)
            android.graphics.PointF r7 = r12.A
            float r8 = r7.x
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 == 0) goto L_0x0333
            r6 = r5
            goto L_0x0334
        L_0x0333:
            r6 = r4
        L_0x0334:
            float r7 = r7.y
            int r8 = (r13 > r7 ? 1 : (r13 == r7 ? 0 : -1))
            if (r8 == 0) goto L_0x033c
            r8 = r5
            goto L_0x033d
        L_0x033c:
            r8 = r4
        L_0x033d:
            if (r6 == 0) goto L_0x0349
            int r9 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r9 <= 0) goto L_0x0349
            boolean r9 = r12.M
            if (r9 != 0) goto L_0x0349
            r9 = r5
            goto L_0x034a
        L_0x0349:
            r9 = r4
        L_0x034a:
            if (r8 == 0) goto L_0x0356
            int r0 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x0356
            boolean r0 = r12.M
            if (r0 != 0) goto L_0x0356
            r0 = r5
            goto L_0x0357
        L_0x0356:
            r0 = r4
        L_0x0357:
            int r13 = (r13 > r7 ? 1 : (r13 == r7 ? 0 : -1))
            if (r13 != 0) goto L_0x0364
            r13 = 1077936128(0x40400000, float:3.0)
            float r13 = r13 * r3
            int r13 = (r2 > r13 ? 1 : (r2 == r13 ? 0 : -1))
            if (r13 <= 0) goto L_0x0364
            r13 = r5
            goto L_0x0365
        L_0x0364:
            r13 = r4
        L_0x0365:
            if (r9 != 0) goto L_0x0376
            if (r0 != 0) goto L_0x0376
            if (r6 == 0) goto L_0x0373
            if (r8 == 0) goto L_0x0373
            if (r13 != 0) goto L_0x0373
            boolean r13 = r12.M
            if (r13 == 0) goto L_0x0376
        L_0x0373:
            r12.M = r5
            goto L_0x0386
        L_0x0376:
            if (r1 > 0) goto L_0x037c
            int r13 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r13 <= 0) goto L_0x0386
        L_0x037c:
            r12.O = r4
            android.os.Handler r13 = r12.f72190m0
            r13.removeMessages(r5)
            r12.x0(r4)
        L_0x0386:
            boolean r13 = r12.f72197s
            if (r13 != 0) goto L_0x0399
            android.graphics.PointF r13 = r12.A
            android.graphics.PointF r0 = r12.B
            float r1 = r0.x
            r13.x = r1
            float r0 = r0.y
            r13.y = r0
            r12.x0(r4)
        L_0x0399:
            boolean r13 = r12.f72196r
            r12.w0(r13)
            goto L_0x02cc
        L_0x03a0:
            r13 = r4
        L_0x03a1:
            if (r13 == 0) goto L_0x03ac
            android.os.Handler r13 = r12.f72190m0
            r13.removeMessages(r5)
            r12.invalidate()
            return r5
        L_0x03ac:
            return r4
        L_0x03ad:
            android.os.Handler r1 = r12.f72190m0
            r1.removeMessages(r5)
            boolean r1 = r12.N
            if (r1 == 0) goto L_0x03c3
            r12.N = r4
            boolean r1 = r12.f72170c0
            if (r1 != 0) goto L_0x03c3
            android.graphics.PointF r1 = r12.f72174e0
            android.graphics.PointF r2 = r12.V
            r12.W(r1, r2)
        L_0x03c3:
            int r1 = r12.O
            if (r1 <= 0) goto L_0x0410
            boolean r1 = r12.L
            if (r1 != 0) goto L_0x03cf
            boolean r2 = r12.M
            if (r2 == 0) goto L_0x0410
        L_0x03cf:
            if (r1 == 0) goto L_0x0401
            if (r0 != r3) goto L_0x0401
            r12.M = r5
            android.graphics.PointF r1 = r12.B
            android.graphics.PointF r2 = r12.A
            float r6 = r2.x
            float r2 = r2.y
            r1.set(r6, r2)
            int r1 = r13.getActionIndex()
            if (r1 != r5) goto L_0x03f4
            android.graphics.PointF r1 = r12.V
            float r2 = r13.getX(r4)
            float r13 = r13.getY(r4)
            r1.set(r2, r13)
            goto L_0x0401
        L_0x03f4:
            android.graphics.PointF r1 = r12.V
            float r2 = r13.getX(r5)
            float r13 = r13.getY(r5)
            r1.set(r2, r13)
        L_0x0401:
            r13 = 3
            if (r0 >= r13) goto L_0x0406
            r12.L = r4
        L_0x0406:
            if (r0 >= r3) goto L_0x040c
            r12.M = r4
            r12.O = r4
        L_0x040c:
            r12.w0(r5)
            return r5
        L_0x0410:
            if (r0 != r5) goto L_0x0418
            r12.L = r4
            r12.M = r4
            r12.O = r4
        L_0x0418:
            return r5
        L_0x0419:
            r1 = 0
            r12.f72178g0 = r1
            r12.x0(r5)
            int r1 = r12.O
            int r1 = java.lang.Math.max(r1, r0)
            r12.O = r1
            if (r0 < r3) goto L_0x0474
            boolean r0 = r12.f72198t
            if (r0 == 0) goto L_0x046c
            float r0 = r13.getX(r4)
            float r1 = r13.getX(r5)
            float r3 = r13.getY(r4)
            float r6 = r13.getY(r5)
            float r0 = r12.V(r0, r1, r3, r6)
            float r1 = r12.f72208y
            r12.f72210z = r1
            r12.W = r0
            android.graphics.PointF r0 = r12.B
            android.graphics.PointF r1 = r12.A
            float r3 = r1.x
            float r1 = r1.y
            r0.set(r3, r1)
            android.graphics.PointF r0 = r12.V
            float r1 = r13.getX(r4)
            float r3 = r13.getX(r5)
            float r1 = r1 + r3
            float r1 = r1 / r2
            float r3 = r13.getY(r4)
            float r13 = r13.getY(r5)
            float r3 = r3 + r13
            float r3 = r3 / r2
            r0.set(r1, r3)
            goto L_0x046e
        L_0x046c:
            r12.O = r4
        L_0x046e:
            android.os.Handler r13 = r12.f72190m0
            r13.removeMessages(r5)
            goto L_0x0497
        L_0x0474:
            boolean r0 = r12.N
            if (r0 != 0) goto L_0x0497
            android.graphics.PointF r0 = r12.B
            android.graphics.PointF r1 = r12.A
            float r2 = r1.x
            float r1 = r1.y
            r0.set(r2, r1)
            android.graphics.PointF r0 = r12.V
            float r1 = r13.getX()
            float r13 = r13.getY()
            r0.set(r1, r13)
            android.os.Handler r13 = r12.f72190m0
            r0 = 600(0x258, double:2.964E-321)
            r13.sendEmptyMessageDelayed(r5, r0)
        L_0x0497:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.lib.widgets.photoviewer.SubsamplingScaleImageView.t0(android.view.MotionEvent):boolean");
    }

    public final void u0() {
        Float f11;
        if (getWidth() != 0 && getHeight() != 0 && this.G > 0 && this.H > 0) {
            if (!(this.E == null || (f11 = this.D) == null)) {
                this.f72208y = f11.floatValue();
                if (this.A == null) {
                    this.A = new PointF();
                }
                this.A.x = ((float) (getWidth() / 2)) - (this.f72208y * this.E.x);
                this.A.y = ((float) (getHeight() / 2)) - (this.f72208y * this.E.y);
                this.E = null;
                this.D = null;
                c0(true);
                w0(true);
            }
            c0(false);
        }
    }

    public final int v0(int i11) {
        return (int) (this.B0 * ((float) i11));
    }

    public final void w0(boolean z11) {
        if (this.R != null && this.f72177g != null) {
            int min = Math.min(this.f72175f, Q(this.f72208y));
            for (Map.Entry<Integer, List<k>> value : this.f72177g.entrySet()) {
                for (k kVar : (List) value.getValue()) {
                    if (kVar.f72249b < min || (kVar.f72249b > min && kVar.f72249b != this.f72175f)) {
                        boolean unused = kVar.f72252e = false;
                        if (kVar.f72250c != null) {
                            kVar.f72250c.recycle();
                            Bitmap unused2 = kVar.f72250c = null;
                        }
                    }
                    if (kVar.f72249b == min) {
                        if (L0(kVar)) {
                            boolean unused3 = kVar.f72252e = true;
                            if (!kVar.f72251d && kVar.f72250c == null && z11) {
                                a0(new l(this, this.R, kVar));
                            }
                        } else if (kVar.f72249b != this.f72175f) {
                            boolean unused4 = kVar.f72252e = false;
                            if (kVar.f72250c != null) {
                                kVar.f72250c.recycle();
                                Bitmap unused5 = kVar.f72250c = null;
                            }
                        }
                    } else if (kVar.f72249b == this.f72175f) {
                        boolean unused6 = kVar.f72252e = true;
                    }
                }
            }
        }
    }

    public final void x0(boolean z11) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z11);
        }
    }

    /* JADX INFO: finally extract failed */
    public final void y0(boolean z11) {
        h hVar;
        U("reset newImage=" + z11, new Object[0]);
        this.f72208y = 0.0f;
        this.f72210z = 0.0f;
        this.A = null;
        this.B = null;
        this.C = null;
        this.D = Float.valueOf(0.0f);
        this.E = null;
        this.F = null;
        this.L = false;
        this.M = false;
        this.N = false;
        this.O = 0;
        this.f72175f = 0;
        this.V = null;
        this.W = 0.0f;
        this.f72168b0 = 0.0f;
        this.f72170c0 = false;
        this.f72174e0 = null;
        this.f72172d0 = null;
        this.f72176f0 = null;
        this.f72178g0 = null;
        this.f72205w0 = null;
        this.f72207x0 = null;
        this.f72209y0 = null;
        if (z11) {
            this.f72173e = null;
            this.S.writeLock().lock();
            try {
                ia.d dVar = this.R;
                if (dVar != null) {
                    dVar.recycle();
                    this.R = null;
                }
                this.S.writeLock().unlock();
                Bitmap bitmap = this.f72167b;
                if (bitmap != null && !this.f72171d) {
                    bitmap.recycle();
                }
                if (!(this.f72167b == null || !this.f72171d || (hVar = this.f72184j0) == null)) {
                    hVar.onPreviewReleased();
                }
                this.G = 0;
                this.H = 0;
                this.I = 0;
                this.J = null;
                this.K = null;
                this.f72180h0 = false;
                this.f72182i0 = false;
                this.f72167b = null;
                this.f72169c = false;
                this.f72171d = false;
            } catch (Throwable th2) {
                this.S.writeLock().unlock();
                throw th2;
            }
        }
        Map<Integer, List<k>> map = this.f72177g;
        if (map != null) {
            for (Map.Entry<Integer, List<k>> value : map.entrySet()) {
                for (k kVar : (List) value.getValue()) {
                    boolean unused = kVar.f72252e = false;
                    if (kVar.f72250c != null) {
                        kVar.f72250c.recycle();
                        Bitmap unused2 = kVar.f72250c = null;
                    }
                }
            }
            this.f72177g = null;
        }
        setGestureDetector(getContext());
    }

    public final void z0(ImageViewState imageViewState) {
        if (imageViewState != null && D0.contains(Integer.valueOf(imageViewState.getOrientation()))) {
            this.f72181i = imageViewState.getOrientation();
            this.D = Float.valueOf(imageViewState.getScale());
            this.E = imageViewState.getCenter();
            invalidate();
        }
    }

    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public float f72216a;

        /* renamed from: b  reason: collision with root package name */
        public float f72217b;

        /* renamed from: c  reason: collision with root package name */
        public PointF f72218c;

        /* renamed from: d  reason: collision with root package name */
        public PointF f72219d;

        /* renamed from: e  reason: collision with root package name */
        public PointF f72220e;

        /* renamed from: f  reason: collision with root package name */
        public PointF f72221f;

        /* renamed from: g  reason: collision with root package name */
        public PointF f72222g;

        /* renamed from: h  reason: collision with root package name */
        public long f72223h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f72224i;

        /* renamed from: j  reason: collision with root package name */
        public int f72225j;

        /* renamed from: k  reason: collision with root package name */
        public int f72226k;

        /* renamed from: l  reason: collision with root package name */
        public long f72227l;

        /* renamed from: m  reason: collision with root package name */
        public g f72228m;

        public d() {
            this.f72223h = 500;
            this.f72224i = true;
            this.f72225j = 2;
            this.f72226k = 1;
            this.f72227l = System.currentTimeMillis();
        }

        public /* synthetic */ d(a aVar) {
            this();
        }
    }
}
