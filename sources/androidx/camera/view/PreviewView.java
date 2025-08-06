package androidx.camera.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Rational;
import android.util.Size;
import android.view.Display;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.FrameLayout;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.Logger;
import androidx.camera.core.MeteringPointFactory;
import androidx.camera.core.Preview;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.ViewPort;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.view.internal.compat.quirk.SurfaceViewNotCroppedByParentQuirk;
import androidx.camera.view.internal.compat.quirk.SurfaceViewStretchedQuirk;
import androidx.core.content.ContextCompat;
import androidx.core.view.h0;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import e0.f;
import e0.g;
import e0.h;
import e0.i;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

public final class PreviewView extends FrameLayout {

    /* renamed from: r  reason: collision with root package name */
    public static final ImplementationMode f6407r = ImplementationMode.PERFORMANCE;

    /* renamed from: b  reason: collision with root package name */
    public ImplementationMode f6408b;

    /* renamed from: c  reason: collision with root package name */
    public c f6409c;

    /* renamed from: d  reason: collision with root package name */
    public final b f6410d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f6411e;

    /* renamed from: f  reason: collision with root package name */
    public final MutableLiveData<StreamState> f6412f;

    /* renamed from: g  reason: collision with root package name */
    public final AtomicReference<a> f6413g;

    /* renamed from: h  reason: collision with root package name */
    public e0.a f6414h;

    /* renamed from: i  reason: collision with root package name */
    public d f6415i;

    /* renamed from: j  reason: collision with root package name */
    public Executor f6416j;

    /* renamed from: k  reason: collision with root package name */
    public i f6417k;

    /* renamed from: l  reason: collision with root package name */
    public final ScaleGestureDetector f6418l;

    /* renamed from: m  reason: collision with root package name */
    public CameraInfoInternal f6419m;

    /* renamed from: n  reason: collision with root package name */
    public MotionEvent f6420n;

    /* renamed from: o  reason: collision with root package name */
    public final c f6421o;

    /* renamed from: p  reason: collision with root package name */
    public final View.OnLayoutChangeListener f6422p;

    /* renamed from: q  reason: collision with root package name */
    public final Preview.SurfaceProvider f6423q;

    public enum ImplementationMode {
        PERFORMANCE(0),
        COMPATIBLE(1);
        
        private final int mId;

        private ImplementationMode(int i11) {
            this.mId = i11;
        }

        public static ImplementationMode fromId(int i11) {
            for (ImplementationMode implementationMode : values()) {
                if (implementationMode.mId == i11) {
                    return implementationMode;
                }
            }
            throw new IllegalArgumentException("Unknown implementation mode id " + i11);
        }

        public int getId() {
            return this.mId;
        }
    }

    public enum ScaleType {
        FILL_START(0),
        FILL_CENTER(1),
        FILL_END(2),
        FIT_START(3),
        FIT_CENTER(4),
        FIT_END(5);
        
        private final int mId;

        private ScaleType(int i11) {
            this.mId = i11;
        }

        public static ScaleType fromId(int i11) {
            for (ScaleType scaleType : values()) {
                if (scaleType.mId == i11) {
                    return scaleType;
                }
            }
            throw new IllegalArgumentException("Unknown scale type id " + i11);
        }

        public int getId() {
            return this.mId;
        }
    }

    public enum StreamState {
        IDLE,
        STREAMING
    }

    public class a implements Preview.SurfaceProvider {
        public a() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void d(SurfaceRequest surfaceRequest) {
            PreviewView.this.f6423q.onSurfaceRequested(surfaceRequest);
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Removed duplicated region for block: B:13:0x0052  */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x0055  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ void e(androidx.camera.core.impl.CameraInternal r4, androidx.camera.core.SurfaceRequest r5, androidx.camera.core.SurfaceRequest.TransformationInfo r6) {
            /*
                r3 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "Preview transformation info updated. "
                r0.append(r1)
                r0.append(r6)
                java.lang.String r0 = r0.toString()
                java.lang.String r1 = "PreviewView"
                androidx.camera.core.Logger.d(r1, r0)
                androidx.camera.core.impl.CameraInfoInternal r4 = r4.getCameraInfoInternal()
                int r4 = r4.getLensFacing()
                java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
                r0 = 0
                r2 = 1
                if (r4 != 0) goto L_0x002d
                java.lang.String r4 = "The lens facing is null, probably an external."
                androidx.camera.core.Logger.w(r1, r4)
            L_0x002b:
                r4 = r2
                goto L_0x0035
            L_0x002d:
                int r4 = r4.intValue()
                if (r4 != 0) goto L_0x0034
                goto L_0x002b
            L_0x0034:
                r4 = r0
            L_0x0035:
                androidx.camera.view.PreviewView r1 = androidx.camera.view.PreviewView.this
                androidx.camera.view.b r1 = r1.f6410d
                android.util.Size r5 = r5.getResolution()
                r1.r(r6, r5, r4)
                int r4 = r6.getTargetRotation()
                r5 = -1
                if (r4 == r5) goto L_0x0055
                androidx.camera.view.PreviewView r4 = androidx.camera.view.PreviewView.this
                androidx.camera.view.c r5 = r4.f6409c
                if (r5 == 0) goto L_0x0052
                boolean r5 = r5 instanceof androidx.camera.view.d
                if (r5 == 0) goto L_0x0052
                goto L_0x0055
            L_0x0052:
                r4.f6411e = r0
                goto L_0x0059
            L_0x0055:
                androidx.camera.view.PreviewView r4 = androidx.camera.view.PreviewView.this
                r4.f6411e = r2
            L_0x0059:
                androidx.camera.view.PreviewView r4 = androidx.camera.view.PreviewView.this
                r4.e()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.view.PreviewView.a.e(androidx.camera.core.impl.CameraInternal, androidx.camera.core.SurfaceRequest, androidx.camera.core.SurfaceRequest$TransformationInfo):void");
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void f(a aVar, CameraInternal cameraInternal) {
            if (PreviewView.this.f6413g.compareAndSet(aVar, (Object) null)) {
                aVar.k(StreamState.IDLE);
            }
            aVar.e();
            cameraInternal.getCameraState().removeObserver(aVar);
        }

        public void onSurfaceRequested(SurfaceRequest surfaceRequest) {
            Executor executor;
            c cVar;
            if (!Threads.isMainThread()) {
                ContextCompat.getMainExecutor(PreviewView.this.getContext()).execute(new h(this, surfaceRequest));
                return;
            }
            Logger.d("PreviewView", "Surface requested by Preview.");
            CameraInternal camera = surfaceRequest.getCamera();
            PreviewView.this.f6419m = camera.getCameraInfoInternal();
            surfaceRequest.setTransformationInfoListener(ContextCompat.getMainExecutor(PreviewView.this.getContext()), new f(this, camera, surfaceRequest));
            PreviewView previewView = PreviewView.this;
            if (!PreviewView.f(previewView.f6409c, surfaceRequest, previewView.f6408b)) {
                PreviewView previewView2 = PreviewView.this;
                if (PreviewView.g(surfaceRequest, previewView2.f6408b)) {
                    PreviewView previewView3 = PreviewView.this;
                    cVar = new e(previewView3, previewView3.f6410d);
                } else {
                    PreviewView previewView4 = PreviewView.this;
                    cVar = new d(previewView4, previewView4.f6410d);
                }
                previewView2.f6409c = cVar;
            }
            CameraInfoInternal cameraInfoInternal = camera.getCameraInfoInternal();
            PreviewView previewView5 = PreviewView.this;
            a aVar = new a(cameraInfoInternal, previewView5.f6412f, previewView5.f6409c);
            PreviewView.this.f6413g.set(aVar);
            camera.getCameraState().addObserver(ContextCompat.getMainExecutor(PreviewView.this.getContext()), aVar);
            PreviewView.this.f6409c.g(surfaceRequest, new g(this, aVar, camera));
            PreviewView previewView6 = PreviewView.this;
            d dVar = previewView6.f6415i;
            if (dVar != null && (executor = previewView6.f6416j) != null) {
                previewView6.f6409c.i(executor, dVar);
            }
        }
    }

    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f6425a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f6426b;

        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|18|(3:19|20|22)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(19:0|1|2|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|18|19|20|22) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0038 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0043 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x004e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0059 */
        static {
            /*
                androidx.camera.view.PreviewView$ImplementationMode[] r0 = androidx.camera.view.PreviewView.ImplementationMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f6426b = r0
                r1 = 1
                androidx.camera.view.PreviewView$ImplementationMode r2 = androidx.camera.view.PreviewView.ImplementationMode.COMPATIBLE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f6426b     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.camera.view.PreviewView$ImplementationMode r3 = androidx.camera.view.PreviewView.ImplementationMode.PERFORMANCE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                androidx.camera.view.PreviewView$ScaleType[] r2 = androidx.camera.view.PreviewView.ScaleType.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                f6425a = r2
                androidx.camera.view.PreviewView$ScaleType r3 = androidx.camera.view.PreviewView.ScaleType.FILL_END     // Catch:{ NoSuchFieldError -> 0x002e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002e }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002e }
            L_0x002e:
                int[] r1 = f6425a     // Catch:{ NoSuchFieldError -> 0x0038 }
                androidx.camera.view.PreviewView$ScaleType r2 = androidx.camera.view.PreviewView.ScaleType.FILL_CENTER     // Catch:{ NoSuchFieldError -> 0x0038 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0038 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0038 }
            L_0x0038:
                int[] r0 = f6425a     // Catch:{ NoSuchFieldError -> 0x0043 }
                androidx.camera.view.PreviewView$ScaleType r1 = androidx.camera.view.PreviewView.ScaleType.FILL_START     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r0 = f6425a     // Catch:{ NoSuchFieldError -> 0x004e }
                androidx.camera.view.PreviewView$ScaleType r1 = androidx.camera.view.PreviewView.ScaleType.FIT_END     // Catch:{ NoSuchFieldError -> 0x004e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                int[] r0 = f6425a     // Catch:{ NoSuchFieldError -> 0x0059 }
                androidx.camera.view.PreviewView$ScaleType r1 = androidx.camera.view.PreviewView.ScaleType.FIT_CENTER     // Catch:{ NoSuchFieldError -> 0x0059 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0059 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0059 }
            L_0x0059:
                int[] r0 = f6425a     // Catch:{ NoSuchFieldError -> 0x0064 }
                androidx.camera.view.PreviewView$ScaleType r1 = androidx.camera.view.PreviewView.ScaleType.FIT_START     // Catch:{ NoSuchFieldError -> 0x0064 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0064 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0064 }
            L_0x0064:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.view.PreviewView.b.<clinit>():void");
        }
    }

    public class c implements DisplayManager.DisplayListener {
        public c() {
        }

        public void onDisplayAdded(int i11) {
        }

        public void onDisplayChanged(int i11) {
            Display display = PreviewView.this.getDisplay();
            if (display != null && display.getDisplayId() == i11) {
                PreviewView.this.e();
            }
        }

        public void onDisplayRemoved(int i11) {
        }
    }

    public interface d {
        void a(long j11);
    }

    public class e extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        public e() {
        }

        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            e0.a aVar = PreviewView.this.f6414h;
            return true;
        }
    }

    public PreviewView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d(View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
        if ((i13 - i11 == i17 - i15 && i14 - i12 == i18 - i16) ? false : true) {
            e();
            b(true);
        }
    }

    public static boolean f(c cVar, SurfaceRequest surfaceRequest, ImplementationMode implementationMode) {
        return (cVar instanceof d) && !g(surfaceRequest, implementationMode);
    }

    public static boolean g(SurfaceRequest surfaceRequest, ImplementationMode implementationMode) {
        int i11;
        boolean equals = surfaceRequest.getCamera().getCameraInfoInternal().getImplementationType().equals(CameraInfo.IMPLEMENTATION_TYPE_CAMERA2_LEGACY);
        boolean z11 = (f0.a.a(SurfaceViewStretchedQuirk.class) == null && f0.a.a(SurfaceViewNotCroppedByParentQuirk.class) == null) ? false : true;
        if (Build.VERSION.SDK_INT <= 24 || equals || z11 || (i11 = b.f6426b[implementationMode.ordinal()]) == 1) {
            return true;
        }
        if (i11 == 2) {
            return false;
        }
        throw new IllegalArgumentException("Invalid implementation mode: " + implementationMode);
    }

    private DisplayManager getDisplayManager() {
        Context context = getContext();
        if (context == null) {
            return null;
        }
        return (DisplayManager) context.getApplicationContext().getSystemService("display");
    }

    private int getViewPortScaleType() {
        switch (b.f6425a[getScaleType().ordinal()]) {
            case 1:
                return 2;
            case 2:
                return 1;
            case 3:
                return 0;
            case 4:
            case 5:
            case 6:
                return 3;
            default:
                throw new IllegalStateException("Unexpected scale type: " + getScaleType());
        }
    }

    public final void b(boolean z11) {
        Threads.checkMainThread();
        getViewPort();
    }

    @SuppressLint({"WrongConstant"})
    public ViewPort c(int i11) {
        Threads.checkMainThread();
        if (getWidth() == 0 || getHeight() == 0) {
            return null;
        }
        return new ViewPort.Builder(new Rational(getWidth(), getHeight()), i11).setScaleType(getViewPortScaleType()).setLayoutDirection(getLayoutDirection()).build();
    }

    public void e() {
        Threads.checkMainThread();
        if (this.f6409c != null) {
            j();
            this.f6409c.h();
        }
        this.f6417k.a(new Size(getWidth(), getHeight()), getLayoutDirection());
    }

    public Bitmap getBitmap() {
        Threads.checkMainThread();
        c cVar = this.f6409c;
        if (cVar == null) {
            return null;
        }
        return cVar.a();
    }

    public e0.a getController() {
        Threads.checkMainThread();
        return this.f6414h;
    }

    public ImplementationMode getImplementationMode() {
        Threads.checkMainThread();
        return this.f6408b;
    }

    public MeteringPointFactory getMeteringPointFactory() {
        Threads.checkMainThread();
        return this.f6417k;
    }

    public g0.a getOutputTransform() {
        Matrix matrix;
        Threads.checkMainThread();
        try {
            matrix = this.f6410d.j(new Size(getWidth(), getHeight()), getLayoutDirection());
        } catch (IllegalStateException unused) {
            matrix = null;
        }
        Rect i11 = this.f6410d.i();
        if (matrix == null || i11 == null) {
            Logger.d("PreviewView", "Transform info is not ready");
            return null;
        }
        matrix.preConcat(TransformUtils.getNormalizedToBuffer(i11));
        if (this.f6409c instanceof e) {
            matrix.postConcat(getMatrix());
        } else if (!getMatrix().isIdentity()) {
            Logger.w("PreviewView", "PreviewView needs to be in COMPATIBLE mode for the transform to work correctly.");
        }
        return new g0.a(matrix, new Size(i11.width(), i11.height()));
    }

    public LiveData<StreamState> getPreviewStreamState() {
        return this.f6412f;
    }

    public ScaleType getScaleType() {
        Threads.checkMainThread();
        return this.f6410d.g();
    }

    public Matrix getSensorToViewTransform() {
        Threads.checkMainThread();
        return this.f6410d.h(new Size(getWidth(), getHeight()), getLayoutDirection());
    }

    public Preview.SurfaceProvider getSurfaceProvider() {
        Threads.checkMainThread();
        return this.f6423q;
    }

    public ViewPort getViewPort() {
        Threads.checkMainThread();
        if (getDisplay() == null) {
            return null;
        }
        return c(getDisplay().getRotation());
    }

    public final void h() {
        DisplayManager displayManager = getDisplayManager();
        if (displayManager != null) {
            displayManager.registerDisplayListener(this.f6421o, new Handler(Looper.getMainLooper()));
        }
    }

    public final void i() {
        DisplayManager displayManager = getDisplayManager();
        if (displayManager != null) {
            displayManager.unregisterDisplayListener(this.f6421o);
        }
    }

    public void j() {
        Display display;
        CameraInfoInternal cameraInfoInternal;
        if (this.f6411e && (display = getDisplay()) != null && (cameraInfoInternal = this.f6419m) != null) {
            this.f6410d.o(cameraInfoInternal.getSensorRotationDegrees(display.getRotation()), display.getRotation());
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        h();
        addOnLayoutChangeListener(this.f6422p);
        c cVar = this.f6409c;
        if (cVar != null) {
            cVar.d();
        }
        b(true);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeOnLayoutChangeListener(this.f6422p);
        c cVar = this.f6409c;
        if (cVar != null) {
            cVar.e();
        }
        i();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public boolean performClick() {
        this.f6420n = null;
        return super.performClick();
    }

    public void setController(e0.a aVar) {
        Threads.checkMainThread();
        b(false);
    }

    public void setImplementationMode(ImplementationMode implementationMode) {
        Threads.checkMainThread();
        this.f6408b = implementationMode;
        if (implementationMode == ImplementationMode.PERFORMANCE && this.f6415i != null) {
            throw new IllegalArgumentException("PERFORMANCE mode doesn't support frame update listener");
        }
    }

    public void setScaleType(ScaleType scaleType) {
        Threads.checkMainThread();
        this.f6410d.q(scaleType);
        e();
        b(false);
    }

    public PreviewView(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0);
    }

    /* JADX INFO: finally extract failed */
    public PreviewView(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        ImplementationMode implementationMode = f6407r;
        this.f6408b = implementationMode;
        b bVar = new b();
        this.f6410d = bVar;
        this.f6411e = true;
        this.f6412f = new MutableLiveData<>(StreamState.IDLE);
        this.f6413g = new AtomicReference<>();
        this.f6417k = new i(bVar);
        this.f6421o = new c();
        this.f6422p = new e0.e(this);
        this.f6423q = new a();
        Threads.checkMainThread();
        Resources.Theme theme = context.getTheme();
        int[] iArr = R$styleable.PreviewView;
        TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, iArr, i11, i12);
        h0.v0(this, context, iArr, attributeSet, obtainStyledAttributes, i11, i12);
        try {
            setScaleType(ScaleType.fromId(obtainStyledAttributes.getInteger(R$styleable.PreviewView_scaleType, bVar.g().getId())));
            setImplementationMode(ImplementationMode.fromId(obtainStyledAttributes.getInteger(R$styleable.PreviewView_implementationMode, implementationMode.getId())));
            obtainStyledAttributes.recycle();
            this.f6418l = new ScaleGestureDetector(context, new e());
            if (getBackground() == null) {
                setBackgroundColor(ContextCompat.getColor(getContext(), 17170444));
            }
        } catch (Throwable th2) {
            obtainStyledAttributes.recycle();
            throw th2;
        }
    }
}
