package androidx.camera.view;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Size;
import android.view.PixelCopy;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.FrameLayout;
import androidx.camera.core.Logger;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.view.PreviewView;
import androidx.camera.view.c;
import androidx.core.content.ContextCompat;
import androidx.core.util.h;
import com.google.common.util.concurrent.ListenableFuture;
import e0.j;
import e0.k;
import e0.l;
import e0.m;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public final class d extends c {

    /* renamed from: e  reason: collision with root package name */
    public SurfaceView f6455e;

    /* renamed from: f  reason: collision with root package name */
    public final b f6456f = new b();

    public static class a {
        public static void a(SurfaceView surfaceView, Bitmap bitmap, PixelCopy.OnPixelCopyFinishedListener onPixelCopyFinishedListener, Handler handler) {
            PixelCopy.request(surfaceView, bitmap, onPixelCopyFinishedListener, handler);
        }
    }

    public class b implements SurfaceHolder.Callback {

        /* renamed from: b  reason: collision with root package name */
        public Size f6457b;

        /* renamed from: c  reason: collision with root package name */
        public SurfaceRequest f6458c;

        /* renamed from: d  reason: collision with root package name */
        public SurfaceRequest f6459d;

        /* renamed from: e  reason: collision with root package name */
        public c.a f6460e;

        /* renamed from: f  reason: collision with root package name */
        public Size f6461f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f6462g = false;

        /* renamed from: h  reason: collision with root package name */
        public boolean f6463h = false;

        public b() {
        }

        public static /* synthetic */ void e(c.a aVar, SurfaceRequest.Result result) {
            Logger.d("SurfaceViewImpl", "Safe to release surface.");
            if (aVar != null) {
                aVar.a();
            }
        }

        public final boolean b() {
            return !this.f6462g && this.f6458c != null && Objects.equals(this.f6457b, this.f6461f);
        }

        public final void c() {
            if (this.f6458c != null) {
                Logger.d("SurfaceViewImpl", "Request canceled: " + this.f6458c);
                this.f6458c.willNotProvideSurface();
            }
        }

        public final void d() {
            if (this.f6458c != null) {
                Logger.d("SurfaceViewImpl", "Surface closed " + this.f6458c);
                this.f6458c.getDeferrableSurface().close();
            }
        }

        public void f(SurfaceRequest surfaceRequest, c.a aVar) {
            c();
            if (this.f6463h) {
                this.f6463h = false;
                surfaceRequest.invalidate();
                return;
            }
            this.f6458c = surfaceRequest;
            this.f6460e = aVar;
            Size resolution = surfaceRequest.getResolution();
            this.f6457b = resolution;
            this.f6462g = false;
            if (!g()) {
                Logger.d("SurfaceViewImpl", "Wait for new Surface creation.");
                d.this.f6455e.getHolder().setFixedSize(resolution.getWidth(), resolution.getHeight());
            }
        }

        public final boolean g() {
            Surface surface = d.this.f6455e.getHolder().getSurface();
            if (!b()) {
                return false;
            }
            Logger.d("SurfaceViewImpl", "Surface set on Preview.");
            c.a aVar = this.f6460e;
            SurfaceRequest surfaceRequest = this.f6458c;
            Objects.requireNonNull(surfaceRequest);
            surfaceRequest.provideSurface(surface, ContextCompat.getMainExecutor(d.this.f6455e.getContext()), new m(aVar));
            this.f6462g = true;
            d.this.f();
            return true;
        }

        public void surfaceChanged(SurfaceHolder surfaceHolder, int i11, int i12, int i13) {
            Logger.d("SurfaceViewImpl", "Surface changed. Size: " + i12 + "x" + i13);
            this.f6461f = new Size(i12, i13);
            g();
        }

        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            SurfaceRequest surfaceRequest;
            Logger.d("SurfaceViewImpl", "Surface created.");
            if (this.f6463h && (surfaceRequest = this.f6459d) != null) {
                surfaceRequest.invalidate();
                this.f6459d = null;
                this.f6463h = false;
            }
        }

        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            Logger.d("SurfaceViewImpl", "Surface destroyed.");
            if (this.f6462g) {
                d();
            } else {
                c();
            }
            this.f6463h = true;
            SurfaceRequest surfaceRequest = this.f6458c;
            if (surfaceRequest != null) {
                this.f6459d = surfaceRequest;
            }
            this.f6462g = false;
            this.f6458c = null;
            this.f6460e = null;
            this.f6461f = null;
            this.f6457b = null;
        }
    }

    public d(FrameLayout frameLayout, b bVar) {
        super(frameLayout, bVar);
    }

    public static /* synthetic */ void n(Semaphore semaphore, int i11) {
        if (i11 == 0) {
            Logger.d("SurfaceViewImpl", "PreviewView.SurfaceViewImplementation.getBitmap() succeeded");
        } else {
            Logger.e("SurfaceViewImpl", "PreviewView.SurfaceViewImplementation.getBitmap() failed with error " + i11);
        }
        semaphore.release();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void o(SurfaceRequest surfaceRequest, c.a aVar) {
        this.f6456f.f(surfaceRequest, aVar);
    }

    public static boolean p(SurfaceView surfaceView, Size size, SurfaceRequest surfaceRequest) {
        return surfaceView != null && Objects.equals(size, surfaceRequest.getResolution());
    }

    public View b() {
        return this.f6455e;
    }

    public Bitmap c() {
        SurfaceView surfaceView = this.f6455e;
        if (surfaceView == null || surfaceView.getHolder().getSurface() == null || !this.f6455e.getHolder().getSurface().isValid()) {
            return null;
        }
        Semaphore semaphore = new Semaphore(0);
        Bitmap createBitmap = Bitmap.createBitmap(this.f6455e.getWidth(), this.f6455e.getHeight(), Bitmap.Config.ARGB_8888);
        HandlerThread handlerThread = new HandlerThread("pixelCopyRequest Thread");
        handlerThread.start();
        a.a(this.f6455e, createBitmap, new j(semaphore), new Handler(handlerThread.getLooper()));
        try {
            if (!semaphore.tryAcquire(1, 100, TimeUnit.MILLISECONDS)) {
                Logger.e("SurfaceViewImpl", "Timed out while trying to acquire screenshot.");
            }
        } catch (InterruptedException e11) {
            Logger.e("SurfaceViewImpl", "Interrupted while trying to acquire screenshot.", e11);
        } catch (Throwable th2) {
            handlerThread.quitSafely();
            throw th2;
        }
        handlerThread.quitSafely();
        return createBitmap;
    }

    public void d() {
    }

    public void e() {
    }

    public void g(SurfaceRequest surfaceRequest, c.a aVar) {
        if (!p(this.f6455e, this.f6451a, surfaceRequest)) {
            this.f6451a = surfaceRequest.getResolution();
            m();
        }
        if (aVar != null) {
            surfaceRequest.addRequestCancellationListener(ContextCompat.getMainExecutor(this.f6455e.getContext()), new k(aVar));
        }
        this.f6455e.post(new l(this, surfaceRequest, aVar));
    }

    public void i(Executor executor, PreviewView.d dVar) {
        throw new IllegalArgumentException("SurfaceView doesn't support frame update listener");
    }

    public ListenableFuture<Void> j() {
        return Futures.immediateFuture(null);
    }

    public void m() {
        h.g(this.f6452b);
        h.g(this.f6451a);
        SurfaceView surfaceView = new SurfaceView(this.f6452b.getContext());
        this.f6455e = surfaceView;
        surfaceView.setLayoutParams(new FrameLayout.LayoutParams(this.f6451a.getWidth(), this.f6451a.getHeight()));
        this.f6452b.removeAllViews();
        this.f6452b.addView(this.f6455e);
        this.f6455e.getHolder().addCallback(this.f6456f);
    }
}
