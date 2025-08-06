package androidx.camera.camera2.internal;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import androidx.camera.core.CameraControl;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.concurrent.Executor;
import o.y;
import r.e;

public final class h4 {

    /* renamed from: a  reason: collision with root package name */
    public final u f5142a;

    /* renamed from: b  reason: collision with root package name */
    public final MutableLiveData<Integer> f5143b = new MutableLiveData<>(0);

    /* renamed from: c  reason: collision with root package name */
    public final boolean f5144c;

    /* renamed from: d  reason: collision with root package name */
    public final Executor f5145d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f5146e;

    /* renamed from: f  reason: collision with root package name */
    public CallbackToFutureAdapter.a<Void> f5147f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f5148g;

    public h4(u uVar, y yVar, Executor executor) {
        this.f5142a = uVar;
        this.f5145d = executor;
        Objects.requireNonNull(yVar);
        this.f5144c = e.a(new q0(yVar));
        uVar.k(new e4(this));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object h(boolean z11, CallbackToFutureAdapter.a aVar) throws Exception {
        this.f5145d.execute(new g4(this, aVar, z11));
        return "enableTorch: " + z11;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean i(TotalCaptureResult totalCaptureResult) {
        if (this.f5147f != null) {
            Integer num = (Integer) totalCaptureResult.getRequest().get(CaptureRequest.FLASH_MODE);
            if ((num != null && num.intValue() == 2) == this.f5148g) {
                this.f5147f.c(null);
                this.f5147f = null;
            }
        }
        return false;
    }

    public ListenableFuture<Void> d(boolean z11) {
        if (!this.f5144c) {
            Logger.d("TorchControl", "Unable to enableTorch due to there is no flash unit.");
            return Futures.immediateFailedFuture(new IllegalStateException("No flash unit"));
        }
        k(this.f5143b, Integer.valueOf(z11 ? 1 : 0));
        return CallbackToFutureAdapter.a(new f4(this, z11));
    }

    /* renamed from: e */
    public void g(CallbackToFutureAdapter.a<Void> aVar, boolean z11) {
        if (!this.f5144c) {
            if (aVar != null) {
                aVar.f(new IllegalStateException("No flash unit"));
            }
        } else if (!this.f5146e) {
            k(this.f5143b, 0);
            if (aVar != null) {
                aVar.f(new CameraControl.OperationCanceledException("Camera is not active."));
            }
        } else {
            this.f5148g = z11;
            this.f5142a.n(z11);
            k(this.f5143b, Integer.valueOf(z11 ? 1 : 0));
            CallbackToFutureAdapter.a<Void> aVar2 = this.f5147f;
            if (aVar2 != null) {
                aVar2.f(new CameraControl.OperationCanceledException("There is a new enableTorch being set"));
            }
            this.f5147f = aVar;
        }
    }

    public LiveData<Integer> f() {
        return this.f5143b;
    }

    public void j(boolean z11) {
        if (this.f5146e != z11) {
            this.f5146e = z11;
            if (!z11) {
                if (this.f5148g) {
                    this.f5148g = false;
                    this.f5142a.n(false);
                    k(this.f5143b, 0);
                }
                CallbackToFutureAdapter.a<Void> aVar = this.f5147f;
                if (aVar != null) {
                    aVar.f(new CameraControl.OperationCanceledException("Camera is not active."));
                    this.f5147f = null;
                }
            }
        }
    }

    public final <T> void k(MutableLiveData<T> mutableLiveData, T t11) {
        if (Threads.isMainThread()) {
            mutableLiveData.setValue(t11);
        } else {
            mutableLiveData.postValue(t11);
        }
    }
}
