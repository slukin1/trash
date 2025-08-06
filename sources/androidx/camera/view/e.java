package androidx.camera.view;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.util.Size;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import androidx.camera.core.Logger;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.view.PreviewView;
import androidx.camera.view.c;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.content.ContextCompat;
import androidx.core.util.h;
import com.google.common.util.concurrent.ListenableFuture;
import e0.n;
import e0.o;
import e0.p;
import e0.q;
import e0.r;
import e0.s;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

public final class e extends c {

    /* renamed from: e  reason: collision with root package name */
    public TextureView f6465e;

    /* renamed from: f  reason: collision with root package name */
    public SurfaceTexture f6466f;

    /* renamed from: g  reason: collision with root package name */
    public ListenableFuture<SurfaceRequest.Result> f6467g;

    /* renamed from: h  reason: collision with root package name */
    public SurfaceRequest f6468h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f6469i = false;

    /* renamed from: j  reason: collision with root package name */
    public SurfaceTexture f6470j;

    /* renamed from: k  reason: collision with root package name */
    public AtomicReference<CallbackToFutureAdapter.a<Void>> f6471k = new AtomicReference<>();

    /* renamed from: l  reason: collision with root package name */
    public c.a f6472l;

    /* renamed from: m  reason: collision with root package name */
    public PreviewView.d f6473m;

    /* renamed from: n  reason: collision with root package name */
    public Executor f6474n;

    public class a implements TextureView.SurfaceTextureListener {

        /* renamed from: androidx.camera.view.e$a$a  reason: collision with other inner class name */
        public class C0015a implements FutureCallback<SurfaceRequest.Result> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ SurfaceTexture f6476a;

            public C0015a(SurfaceTexture surfaceTexture) {
                this.f6476a = surfaceTexture;
            }

            /* renamed from: a */
            public void onSuccess(SurfaceRequest.Result result) {
                h.j(result.getResultCode() != 3, "Unexpected result from SurfaceRequest. Surface was provided twice.");
                Logger.d("TextureViewImpl", "SurfaceTexture about to manually be destroyed");
                this.f6476a.release();
                e eVar = e.this;
                if (eVar.f6470j != null) {
                    eVar.f6470j = null;
                }
            }

            public void onFailure(Throwable th2) {
                throw new IllegalStateException("SurfaceReleaseFuture did not complete nicely.", th2);
            }
        }

        public a() {
        }

        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i11, int i12) {
            Logger.d("TextureViewImpl", "SurfaceTexture available. Size: " + i11 + "x" + i12);
            e eVar = e.this;
            eVar.f6466f = surfaceTexture;
            if (eVar.f6467g != null) {
                h.g(eVar.f6468h);
                Logger.d("TextureViewImpl", "Surface invalidated " + e.this.f6468h);
                e.this.f6468h.getDeferrableSurface().close();
                return;
            }
            eVar.v();
        }

        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            e eVar = e.this;
            eVar.f6466f = null;
            ListenableFuture<SurfaceRequest.Result> listenableFuture = eVar.f6467g;
            if (listenableFuture != null) {
                Futures.addCallback(listenableFuture, new C0015a(surfaceTexture), ContextCompat.getMainExecutor(e.this.f6465e.getContext()));
                e.this.f6470j = surfaceTexture;
                return false;
            }
            Logger.d("TextureViewImpl", "SurfaceTexture about to be destroyed");
            return true;
        }

        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i11, int i12) {
            Logger.d("TextureViewImpl", "SurfaceTexture size changed: " + i11 + "x" + i12);
        }

        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            CallbackToFutureAdapter.a andSet = e.this.f6471k.getAndSet((Object) null);
            if (andSet != null) {
                andSet.c(null);
            }
            e eVar = e.this;
            PreviewView.d dVar = eVar.f6473m;
            Executor executor = eVar.f6474n;
            if (dVar != null && executor != null) {
                executor.execute(new s(dVar, surfaceTexture));
            }
        }
    }

    public e(FrameLayout frameLayout, b bVar) {
        super(frameLayout, bVar);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void p(SurfaceRequest surfaceRequest) {
        SurfaceRequest surfaceRequest2 = this.f6468h;
        if (surfaceRequest2 != null && surfaceRequest2 == surfaceRequest) {
            this.f6468h = null;
            this.f6467g = null;
        }
        t();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object q(Surface surface, CallbackToFutureAdapter.a aVar) throws Exception {
        Logger.d("TextureViewImpl", "Surface set on Preview.");
        SurfaceRequest surfaceRequest = this.f6468h;
        Executor directExecutor = CameraXExecutors.directExecutor();
        Objects.requireNonNull(aVar);
        surfaceRequest.provideSurface(surface, directExecutor, new p(aVar));
        return "provideSurface[request=" + this.f6468h + " surface=" + surface + "]";
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void r(Surface surface, ListenableFuture listenableFuture, SurfaceRequest surfaceRequest) {
        Logger.d("TextureViewImpl", "Safe to release surface.");
        t();
        surface.release();
        if (this.f6467g == listenableFuture) {
            this.f6467g = null;
        }
        if (this.f6468h == surfaceRequest) {
            this.f6468h = null;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object s(CallbackToFutureAdapter.a aVar) throws Exception {
        this.f6471k.set(aVar);
        return "textureViewImpl_waitForNextFrame";
    }

    public View b() {
        return this.f6465e;
    }

    public Bitmap c() {
        TextureView textureView = this.f6465e;
        if (textureView == null || !textureView.isAvailable()) {
            return null;
        }
        return this.f6465e.getBitmap();
    }

    public void d() {
        u();
    }

    public void e() {
        this.f6469i = true;
    }

    public void g(SurfaceRequest surfaceRequest, c.a aVar) {
        this.f6451a = surfaceRequest.getResolution();
        this.f6472l = aVar;
        o();
        SurfaceRequest surfaceRequest2 = this.f6468h;
        if (surfaceRequest2 != null) {
            surfaceRequest2.willNotProvideSurface();
        }
        this.f6468h = surfaceRequest;
        surfaceRequest.addRequestCancellationListener(ContextCompat.getMainExecutor(this.f6465e.getContext()), new r(this, surfaceRequest));
        v();
    }

    public void i(Executor executor, PreviewView.d dVar) {
        this.f6473m = dVar;
        this.f6474n = executor;
    }

    public ListenableFuture<Void> j() {
        return CallbackToFutureAdapter.a(new n(this));
    }

    public void o() {
        h.g(this.f6452b);
        h.g(this.f6451a);
        TextureView textureView = new TextureView(this.f6452b.getContext());
        this.f6465e = textureView;
        textureView.setLayoutParams(new FrameLayout.LayoutParams(this.f6451a.getWidth(), this.f6451a.getHeight()));
        this.f6465e.setSurfaceTextureListener(new a());
        this.f6452b.removeAllViews();
        this.f6452b.addView(this.f6465e);
    }

    public final void t() {
        c.a aVar = this.f6472l;
        if (aVar != null) {
            aVar.a();
            this.f6472l = null;
        }
    }

    public final void u() {
        SurfaceTexture surfaceTexture;
        if (this.f6469i && this.f6470j != null && this.f6465e.getSurfaceTexture() != (surfaceTexture = this.f6470j)) {
            this.f6465e.setSurfaceTexture(surfaceTexture);
            this.f6470j = null;
            this.f6469i = false;
        }
    }

    public void v() {
        SurfaceTexture surfaceTexture;
        Size size = this.f6451a;
        if (size != null && (surfaceTexture = this.f6466f) != null && this.f6468h != null) {
            surfaceTexture.setDefaultBufferSize(size.getWidth(), this.f6451a.getHeight());
            Surface surface = new Surface(this.f6466f);
            SurfaceRequest surfaceRequest = this.f6468h;
            ListenableFuture<SurfaceRequest.Result> a11 = CallbackToFutureAdapter.a(new o(this, surface));
            this.f6467g = a11;
            a11.addListener(new q(this, surface, a11, surfaceRequest), ContextCompat.getMainExecutor(this.f6465e.getContext()));
            f();
        }
    }
}
