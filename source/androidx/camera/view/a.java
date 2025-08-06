package androidx.camera.view;

import androidx.camera.core.CameraInfo;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.view.PreviewView;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.lifecycle.MutableLiveData;
import com.google.common.util.concurrent.ListenableFuture;
import e0.c;
import e0.d;
import java.util.ArrayList;
import java.util.List;

public final class a implements Observable.Observer<CameraInternal.State> {

    /* renamed from: a  reason: collision with root package name */
    public final CameraInfoInternal f6429a;

    /* renamed from: b  reason: collision with root package name */
    public final MutableLiveData<PreviewView.StreamState> f6430b;

    /* renamed from: c  reason: collision with root package name */
    public PreviewView.StreamState f6431c;

    /* renamed from: d  reason: collision with root package name */
    public final c f6432d;

    /* renamed from: e  reason: collision with root package name */
    public ListenableFuture<Void> f6433e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f6434f = false;

    /* renamed from: androidx.camera.view.a$a  reason: collision with other inner class name */
    public class C0014a implements FutureCallback<Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f6435a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CameraInfo f6436b;

        public C0014a(List list, CameraInfo cameraInfo) {
            this.f6435a = list;
            this.f6436b = cameraInfo;
        }

        /* renamed from: a */
        public void onSuccess(Void voidR) {
            a.this.f6433e = null;
        }

        public void onFailure(Throwable th2) {
            a.this.f6433e = null;
            if (!this.f6435a.isEmpty()) {
                for (CameraCaptureCallback removeSessionCaptureCallback : this.f6435a) {
                    ((CameraInfoInternal) this.f6436b).removeSessionCaptureCallback(removeSessionCaptureCallback);
                }
                this.f6435a.clear();
            }
        }
    }

    public class b extends CameraCaptureCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackToFutureAdapter.a f6438a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CameraInfo f6439b;

        public b(CallbackToFutureAdapter.a aVar, CameraInfo cameraInfo) {
            this.f6438a = aVar;
            this.f6439b = cameraInfo;
        }

        public void onCaptureCompleted(CameraCaptureResult cameraCaptureResult) {
            this.f6438a.c(null);
            ((CameraInfoInternal) this.f6439b).removeSessionCaptureCallback(this);
        }
    }

    public a(CameraInfoInternal cameraInfoInternal, MutableLiveData<PreviewView.StreamState> mutableLiveData, c cVar) {
        this.f6429a = cameraInfoInternal;
        this.f6430b = mutableLiveData;
        this.f6432d = cVar;
        synchronized (this) {
            this.f6431c = mutableLiveData.getValue();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ListenableFuture f(Void voidR) throws Exception {
        return this.f6432d.j();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Void g(Void voidR) {
        k(PreviewView.StreamState.STREAMING);
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object h(CameraInfo cameraInfo, List list, CallbackToFutureAdapter.a aVar) throws Exception {
        b bVar = new b(aVar, cameraInfo);
        list.add(bVar);
        ((CameraInfoInternal) cameraInfo).addSessionCaptureCallback(CameraXExecutors.directExecutor(), bVar);
        return "waitForCaptureResult";
    }

    public final void d() {
        ListenableFuture<Void> listenableFuture = this.f6433e;
        if (listenableFuture != null) {
            listenableFuture.cancel(false);
            this.f6433e = null;
        }
    }

    public void e() {
        d();
    }

    /* renamed from: i */
    public void onNewData(CameraInternal.State state) {
        if (state == CameraInternal.State.CLOSING || state == CameraInternal.State.CLOSED || state == CameraInternal.State.RELEASING || state == CameraInternal.State.RELEASED) {
            k(PreviewView.StreamState.IDLE);
            if (this.f6434f) {
                this.f6434f = false;
                d();
            }
        } else if ((state == CameraInternal.State.OPENING || state == CameraInternal.State.OPEN || state == CameraInternal.State.PENDING_OPEN) && !this.f6434f) {
            j(this.f6429a);
            this.f6434f = true;
        }
    }

    public final void j(CameraInfo cameraInfo) {
        k(PreviewView.StreamState.IDLE);
        ArrayList arrayList = new ArrayList();
        FutureChain<T> transform = FutureChain.from(l(cameraInfo, arrayList)).transformAsync(new c(this), CameraXExecutors.directExecutor()).transform(new e0.b(this), CameraXExecutors.directExecutor());
        this.f6433e = transform;
        Futures.addCallback(transform, new C0014a(arrayList, cameraInfo), CameraXExecutors.directExecutor());
    }

    public void k(PreviewView.StreamState streamState) {
        synchronized (this) {
            if (!this.f6431c.equals(streamState)) {
                this.f6431c = streamState;
                Logger.d("StreamStateObserver", "Update Preview stream state to " + streamState);
                this.f6430b.postValue(streamState);
            }
        }
    }

    public final ListenableFuture<Void> l(CameraInfo cameraInfo, List<CameraCaptureCallback> list) {
        return CallbackToFutureAdapter.a(new d(this, cameraInfo, list));
    }

    public void onError(Throwable th2) {
        e();
        k(PreviewView.StreamState.IDLE);
    }
}
