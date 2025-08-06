package w;

import android.content.Context;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraEffect;
import androidx.camera.core.CameraFilter;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraInfoUnavailableException;
import androidx.camera.core.CameraProvider;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.CameraX;
import androidx.camera.core.CameraXConfig;
import androidx.camera.core.UseCase;
import androidx.camera.core.UseCaseGroup;
import androidx.camera.core.ViewPort;
import androidx.camera.core.impl.CameraConfig;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.ExtendedCameraConfigProviderStore;
import androidx.camera.core.impl.utils.ContextUtil;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.internal.CameraUseCaseAdapter;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.h;
import androidx.lifecycle.LifecycleOwner;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

public final class g implements CameraProvider {

    /* renamed from: h  reason: collision with root package name */
    public static final g f16716h = new g();

    /* renamed from: a  reason: collision with root package name */
    public final Object f16717a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public CameraXConfig.Provider f16718b = null;

    /* renamed from: c  reason: collision with root package name */
    public ListenableFuture<CameraX> f16719c;

    /* renamed from: d  reason: collision with root package name */
    public ListenableFuture<Void> f16720d = Futures.immediateFuture(null);

    /* renamed from: e  reason: collision with root package name */
    public final c f16721e = new c();

    /* renamed from: f  reason: collision with root package name */
    public CameraX f16722f;

    /* renamed from: g  reason: collision with root package name */
    public Context f16723g;

    public class a implements FutureCallback<Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackToFutureAdapter.a f16724a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CameraX f16725b;

        public a(CallbackToFutureAdapter.a aVar, CameraX cameraX) {
            this.f16724a = aVar;
            this.f16725b = cameraX;
        }

        /* renamed from: a */
        public void onSuccess(Void voidR) {
            this.f16724a.c(this.f16725b);
        }

        public void onFailure(Throwable th2) {
            this.f16724a.f(th2);
        }
    }

    public static ListenableFuture<g> g(Context context) {
        h.g(context);
        return Futures.transform(f16716h.h(context), new d(context), CameraXExecutors.directExecutor());
    }

    public static /* synthetic */ g i(Context context, CameraX cameraX) {
        g gVar = f16716h;
        gVar.m(cameraX);
        gVar.n(ContextUtil.getApplicationContext(context));
        return gVar;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object k(CameraX cameraX, CallbackToFutureAdapter.a aVar) throws Exception {
        synchronized (this.f16717a) {
            Futures.addCallback(FutureChain.from(this.f16720d).transformAsync(new e(cameraX), CameraXExecutors.directExecutor()), new a(aVar, cameraX), CameraXExecutors.directExecutor());
        }
        return "ProcessCameraProvider-initializeCameraX";
    }

    public Camera d(LifecycleOwner lifecycleOwner, CameraSelector cameraSelector, UseCaseGroup useCaseGroup) {
        if (f() != 2) {
            l(1);
            return e(lifecycleOwner, cameraSelector, useCaseGroup.getViewPort(), useCaseGroup.getEffects(), (UseCase[]) useCaseGroup.getUseCases().toArray(new UseCase[0]));
        }
        throw new UnsupportedOperationException("bindToLifecycle for single camera is not supported in concurrent camera mode, call unbindAll() first");
    }

    public Camera e(LifecycleOwner lifecycleOwner, CameraSelector cameraSelector, ViewPort viewPort, List<CameraEffect> list, UseCase... useCaseArr) {
        CameraConfig cameraConfig;
        CameraConfig config;
        LifecycleOwner lifecycleOwner2 = lifecycleOwner;
        UseCase[] useCaseArr2 = useCaseArr;
        Threads.checkMainThread();
        CameraSelector.Builder fromSelector = CameraSelector.Builder.fromSelector(cameraSelector);
        int length = useCaseArr2.length;
        int i11 = 0;
        while (true) {
            cameraConfig = null;
            if (i11 >= length) {
                break;
            }
            CameraSelector cameraSelector2 = useCaseArr2[i11].getCurrentConfig().getCameraSelector((CameraSelector) null);
            if (cameraSelector2 != null) {
                Iterator it2 = cameraSelector2.getCameraFilterSet().iterator();
                while (it2.hasNext()) {
                    fromSelector.addCameraFilter((CameraFilter) it2.next());
                }
            }
            i11++;
        }
        LinkedHashSet<CameraInternal> filter = fromSelector.build().filter(this.f16722f.getCameraRepository().getCameras());
        if (!filter.isEmpty()) {
            b c11 = this.f16721e.c(lifecycleOwner, CameraUseCaseAdapter.generateCameraId(filter));
            Collection<b> e11 = this.f16721e.e();
            for (UseCase useCase : useCaseArr2) {
                for (b next : e11) {
                    if (next.e(useCase) && next != c11) {
                        throw new IllegalStateException(String.format("Use case %s already bound to a different lifecycle.", new Object[]{useCase}));
                    }
                }
            }
            if (c11 == null) {
                c11 = this.f16721e.b(lifecycleOwner, new CameraUseCaseAdapter(filter, this.f16722f.getCameraFactory().getCameraCoordinator(), this.f16722f.getCameraDeviceSurfaceManager(), this.f16722f.getDefaultConfigFactory()));
            }
            Iterator it3 = cameraSelector.getCameraFilterSet().iterator();
            while (it3.hasNext()) {
                CameraFilter cameraFilter = (CameraFilter) it3.next();
                if (!(cameraFilter.getIdentifier() == CameraFilter.DEFAULT_ID || (config = ExtendedCameraConfigProviderStore.getConfigProvider(cameraFilter.getIdentifier()).getConfig(c11.getCameraInfo(), this.f16723g)) == null)) {
                    if (cameraConfig == null) {
                        cameraConfig = config;
                    } else {
                        throw new IllegalArgumentException("Cannot apply multiple extended camera configs at the same time.");
                    }
                }
            }
            c11.setExtendedConfig(cameraConfig);
            if (useCaseArr2.length == 0) {
                return c11;
            }
            this.f16721e.a(c11, viewPort, list, Arrays.asList(useCaseArr), this.f16722f.getCameraFactory().getCameraCoordinator());
            return c11;
        }
        throw new IllegalArgumentException("Provided camera selector unable to resolve a camera for the given use case");
    }

    public final int f() {
        CameraX cameraX = this.f16722f;
        if (cameraX == null) {
            return 0;
        }
        return cameraX.getCameraFactory().getCameraCoordinator().getCameraOperatingMode();
    }

    public List<CameraInfo> getAvailableCameraInfos() {
        ArrayList arrayList = new ArrayList();
        for (CameraInternal cameraInfo : this.f16722f.getCameraRepository().getCameras()) {
            arrayList.add(cameraInfo.getCameraInfo());
        }
        return arrayList;
    }

    public final ListenableFuture<CameraX> h(Context context) {
        synchronized (this.f16717a) {
            ListenableFuture<CameraX> listenableFuture = this.f16719c;
            if (listenableFuture != null) {
                return listenableFuture;
            }
            ListenableFuture<CameraX> a11 = CallbackToFutureAdapter.a(new f(this, new CameraX(context, this.f16718b)));
            this.f16719c = a11;
            return a11;
        }
    }

    public boolean hasCamera(CameraSelector cameraSelector) throws CameraInfoUnavailableException {
        try {
            cameraSelector.select(this.f16722f.getCameraRepository().getCameras());
            return true;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    public final void l(int i11) {
        CameraX cameraX = this.f16722f;
        if (cameraX != null) {
            cameraX.getCameraFactory().getCameraCoordinator().setCameraOperatingMode(i11);
        }
    }

    public final void m(CameraX cameraX) {
        this.f16722f = cameraX;
    }

    public final void n(Context context) {
        this.f16723g = context;
    }

    public void o() {
        Threads.checkMainThread();
        l(0);
        this.f16721e.k();
    }
}
