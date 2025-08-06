package androidx.camera.camera2.internal;

import android.graphics.SurfaceTexture;
import android.util.Range;
import android.util.Size;
import android.view.Surface;
import androidx.camera.camera2.internal.compat.workaround.SupportedRepeatingSurfaceSize;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.Logger;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImmediateSurface;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.g0;
import androidx.camera.core.impl.n0;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.impl.y;
import androidx.camera.core.internal.d;
import androidx.camera.core.internal.f;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class e3 {

    /* renamed from: a  reason: collision with root package name */
    public DeferrableSurface f5092a;

    /* renamed from: b  reason: collision with root package name */
    public SessionConfig f5093b;

    /* renamed from: c  reason: collision with root package name */
    public final b f5094c = new b();

    /* renamed from: d  reason: collision with root package name */
    public final Size f5095d;

    /* renamed from: e  reason: collision with root package name */
    public final SupportedRepeatingSurfaceSize f5096e = new SupportedRepeatingSurfaceSize();

    /* renamed from: f  reason: collision with root package name */
    public final c f5097f;

    public class a implements FutureCallback<Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Surface f5098a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SurfaceTexture f5099b;

        public a(Surface surface, SurfaceTexture surfaceTexture) {
            this.f5098a = surface;
            this.f5099b = surfaceTexture;
        }

        /* renamed from: a */
        public void onSuccess(Void voidR) {
            this.f5098a.release();
            this.f5099b.release();
        }

        public void onFailure(Throwable th2) {
            throw new IllegalStateException("Future should never fail. Did it get completed by GC?", th2);
        }
    }

    public static class b implements UseCaseConfig<UseCase> {

        /* renamed from: a  reason: collision with root package name */
        public final Config f5101a;

        public b() {
            MutableOptionsBundle create = MutableOptionsBundle.create();
            create.insertOption(UseCaseConfig.OPTION_SESSION_CONFIG_UNPACKER, new o1());
            this.f5101a = create;
        }

        public /* synthetic */ boolean containsOption(Config.Option option) {
            return g0.a(this, option);
        }

        public /* synthetic */ void findOptions(String str, Config.OptionMatcher optionMatcher) {
            g0.b(this, str, optionMatcher);
        }

        public /* synthetic */ CameraSelector getCameraSelector() {
            return n0.a(this);
        }

        public /* synthetic */ CameraSelector getCameraSelector(CameraSelector cameraSelector) {
            return n0.b(this, cameraSelector);
        }

        public /* synthetic */ CaptureConfig.OptionUnpacker getCaptureOptionUnpacker() {
            return n0.c(this);
        }

        public /* synthetic */ CaptureConfig.OptionUnpacker getCaptureOptionUnpacker(CaptureConfig.OptionUnpacker optionUnpacker) {
            return n0.d(this, optionUnpacker);
        }

        public UseCaseConfigFactory.CaptureType getCaptureType() {
            return UseCaseConfigFactory.CaptureType.METERING_REPEATING;
        }

        public Config getConfig() {
            return this.f5101a;
        }

        public /* synthetic */ CaptureConfig getDefaultCaptureConfig() {
            return n0.f(this);
        }

        public /* synthetic */ CaptureConfig getDefaultCaptureConfig(CaptureConfig captureConfig) {
            return n0.g(this, captureConfig);
        }

        public /* synthetic */ SessionConfig getDefaultSessionConfig() {
            return n0.h(this);
        }

        public /* synthetic */ SessionConfig getDefaultSessionConfig(SessionConfig sessionConfig) {
            return n0.i(this, sessionConfig);
        }

        public /* synthetic */ DynamicRange getDynamicRange() {
            return y.a(this);
        }

        public /* synthetic */ int getInputFormat() {
            return y.b(this);
        }

        public /* synthetic */ Config.OptionPriority getOptionPriority(Config.Option option) {
            return g0.c(this, option);
        }

        public /* synthetic */ Set getPriorities(Config.Option option) {
            return g0.d(this, option);
        }

        public /* synthetic */ SessionConfig.OptionUnpacker getSessionOptionUnpacker() {
            return n0.j(this);
        }

        public /* synthetic */ SessionConfig.OptionUnpacker getSessionOptionUnpacker(SessionConfig.OptionUnpacker optionUnpacker) {
            return n0.k(this, optionUnpacker);
        }

        public /* synthetic */ int getSurfaceOccupancyPriority() {
            return n0.l(this);
        }

        public /* synthetic */ int getSurfaceOccupancyPriority(int i11) {
            return n0.m(this, i11);
        }

        public /* synthetic */ Class getTargetClass() {
            return d.a(this);
        }

        public /* synthetic */ Class getTargetClass(Class cls) {
            return d.b(this, cls);
        }

        public /* synthetic */ Range getTargetFrameRate() {
            return n0.n(this);
        }

        public /* synthetic */ Range getTargetFrameRate(Range range) {
            return n0.o(this, range);
        }

        public /* synthetic */ String getTargetName() {
            return d.c(this);
        }

        public /* synthetic */ String getTargetName(String str) {
            return d.d(this, str);
        }

        public /* synthetic */ UseCase.EventCallback getUseCaseEventCallback() {
            return f.a(this);
        }

        public /* synthetic */ UseCase.EventCallback getUseCaseEventCallback(UseCase.EventCallback eventCallback) {
            return f.b(this, eventCallback);
        }

        public /* synthetic */ boolean hasDynamicRange() {
            return y.c(this);
        }

        public /* synthetic */ boolean isHigResolutionDisabled(boolean z11) {
            return n0.p(this, z11);
        }

        public /* synthetic */ boolean isZslDisabled(boolean z11) {
            return n0.q(this, z11);
        }

        public /* synthetic */ Set listOptions() {
            return g0.e(this);
        }

        public /* synthetic */ Object retrieveOption(Config.Option option) {
            return g0.f(this, option);
        }

        public /* synthetic */ Object retrieveOption(Config.Option option, Object obj) {
            return g0.g(this, option, obj);
        }

        public /* synthetic */ Object retrieveOptionWithPriority(Config.Option option, Config.OptionPriority optionPriority) {
            return g0.h(this, option, optionPriority);
        }
    }

    public interface c {
        void a();
    }

    public e3(o.y yVar, g2 g2Var, c cVar) {
        this.f5097f = cVar;
        Size f11 = f(yVar, g2Var);
        this.f5095d = f11;
        Logger.d("MeteringRepeating", "MeteringSession SurfaceTexture size: " + f11);
        this.f5093b = d();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void i(SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
        this.f5093b = d();
        c cVar = this.f5097f;
        if (cVar != null) {
            cVar.a();
        }
    }

    public void c() {
        Logger.d("MeteringRepeating", "MeteringRepeating clear!");
        DeferrableSurface deferrableSurface = this.f5092a;
        if (deferrableSurface != null) {
            deferrableSurface.close();
        }
        this.f5092a = null;
    }

    public SessionConfig d() {
        SurfaceTexture surfaceTexture = new SurfaceTexture(0);
        surfaceTexture.setDefaultBufferSize(this.f5095d.getWidth(), this.f5095d.getHeight());
        Surface surface = new Surface(surfaceTexture);
        SessionConfig.Builder createFrom = SessionConfig.Builder.createFrom(this.f5094c, this.f5095d);
        createFrom.setTemplateType(1);
        ImmediateSurface immediateSurface = new ImmediateSurface(surface);
        this.f5092a = immediateSurface;
        Futures.addCallback(immediateSurface.getTerminationFuture(), new a(surface, surfaceTexture), CameraXExecutors.directExecutor());
        createFrom.addSurface(this.f5092a);
        createFrom.addErrorListener(new c3(this));
        return createFrom.build();
    }

    public String e() {
        return "MeteringRepeating";
    }

    public final Size f(o.y yVar, g2 g2Var) {
        Size[] b11 = yVar.b().b(34);
        if (b11 == null) {
            Logger.e("MeteringRepeating", "Can not get output size list.");
            return new Size(0, 0);
        }
        Size[] a11 = this.f5096e.a(b11);
        List asList = Arrays.asList(a11);
        Collections.sort(asList, d3.f5079b);
        Size f11 = g2Var.f();
        long min = Math.min(((long) f11.getWidth()) * ((long) f11.getHeight()), 307200);
        Size size = null;
        int length = a11.length;
        int i11 = 0;
        while (true) {
            if (i11 >= length) {
                break;
            }
            Size size2 = a11[i11];
            int i12 = ((((long) size2.getWidth()) * ((long) size2.getHeight())) > min ? 1 : ((((long) size2.getWidth()) * ((long) size2.getHeight())) == min ? 0 : -1));
            if (i12 == 0) {
                return size2;
            }
            if (i12 <= 0) {
                i11++;
                size = size2;
            } else if (size != null) {
                return size;
            }
        }
        return (Size) asList.get(0);
    }

    public SessionConfig g() {
        return this.f5093b;
    }

    public UseCaseConfig<?> h() {
        return this.f5094c;
    }
}
