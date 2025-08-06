package com.sumsub.sns.internal.core.domain.camera;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.util.Size;
import androidx.annotation.Keep;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraControl;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Preview;
import androidx.camera.core.UseCaseGroup;
import androidx.camera.core.resolutionselector.AspectRatioStrategy;
import androidx.camera.core.resolutionselector.ResolutionSelector;
import androidx.camera.core.resolutionselector.ResolutionStrategy;
import androidx.camera.video.Recorder;
import androidx.camera.video.VideoCapture;
import androidx.camera.video.o;
import androidx.camera.video.q;
import androidx.camera.video.u;
import androidx.camera.video.v;
import androidx.camera.video.v1;
import androidx.camera.video.y;
import androidx.camera.video.z0;
import androidx.camera.view.PreviewView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.z;
import com.google.common.util.concurrent.ListenableFuture;
import com.luck.picture.lib.config.PictureMimeType;
import com.sumsub.sns.internal.core.common.e0;
import d10.p;
import java.io.File;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlin.k;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.f1;
import kotlinx.coroutines.h;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.i0;
import w.g;

public final class CameraX {

    /* renamed from: t  reason: collision with root package name */
    public static final a f33522t = new a((r) null);

    /* renamed from: u  reason: collision with root package name */
    public static final int f33523u = 1080;

    /* renamed from: v  reason: collision with root package name */
    public static final int f33524v = 1920;

    /* renamed from: w  reason: collision with root package name */
    public static final String f33525w = "CameraX";

    /* renamed from: a  reason: collision with root package name */
    public final Mode f33526a;

    /* renamed from: b  reason: collision with root package name */
    public final b f33527b;

    /* renamed from: c  reason: collision with root package name */
    public final CameraSelector f33528c;

    /* renamed from: d  reason: collision with root package name */
    public final a f33529d;

    /* renamed from: e  reason: collision with root package name */
    public ExecutorService f33530e;

    /* renamed from: f  reason: collision with root package name */
    public CoroutineDispatcher f33531f;

    /* renamed from: g  reason: collision with root package name */
    public h0 f33532g;

    /* renamed from: h  reason: collision with root package name */
    public VideoCapture<Recorder> f33533h;

    /* renamed from: i  reason: collision with root package name */
    public z0 f33534i;

    /* renamed from: j  reason: collision with root package name */
    public ImageCapture f33535j;

    /* renamed from: k  reason: collision with root package name */
    public ImageAnalysis f33536k;

    /* renamed from: l  reason: collision with root package name */
    public Preview f33537l;

    /* renamed from: m  reason: collision with root package name */
    public Camera f33538m;

    /* renamed from: n  reason: collision with root package name */
    public g f33539n;

    /* renamed from: o  reason: collision with root package name */
    public PreviewView.StreamState f33540o;

    /* renamed from: p  reason: collision with root package name */
    public File f33541p;

    /* renamed from: q  reason: collision with root package name */
    public PreviewView f33542q;

    /* renamed from: r  reason: collision with root package name */
    public final z<PreviewView.StreamState> f33543r;

    /* renamed from: s  reason: collision with root package name */
    public final ResolutionSelector f33544s;

    @Keep
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/sumsub/sns/internal/core/domain/camera/CameraX$Mode;", "", "(Ljava/lang/String;I)V", "VIDEO", "PHOTO", "ANALYZER", "PHOTO_AND_ANALYZER", "SEAMLESS_DOC_CAPTURE", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public enum Mode {
        VIDEO,
        PHOTO,
        ANALYZER,
        PHOTO_AND_ANALYZER,
        SEAMLESS_DOC_CAPTURE
    }

    public static final class a {
        public /* synthetic */ a(r rVar) {
            this();
        }

        public a() {
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f33545a;

        /* renamed from: b  reason: collision with root package name */
        public final v f33546b;

        /* renamed from: c  reason: collision with root package name */
        public final v f33547c;

        /* renamed from: d  reason: collision with root package name */
        public final long f33548d;

        /* renamed from: e  reason: collision with root package name */
        public final long f33549e;

        public b() {
            this(0, (v) null, (v) null, 0, 0, 31, (r) null);
        }

        public final int a() {
            return this.f33545a;
        }

        public final v b() {
            return this.f33546b;
        }

        public final v c() {
            return this.f33547c;
        }

        public final long d() {
            return this.f33548d;
        }

        public final long e() {
            return this.f33549e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f33545a == bVar.f33545a && x.b(this.f33546b, bVar.f33546b) && x.b(this.f33547c, bVar.f33547c) && this.f33548d == bVar.f33548d && this.f33549e == bVar.f33549e;
        }

        public final int f() {
            return this.f33545a;
        }

        public final long g() {
            return this.f33548d;
        }

        public final v h() {
            return this.f33547c;
        }

        public int hashCode() {
            return (((((((this.f33545a * 31) + this.f33546b.hashCode()) * 31) + this.f33547c.hashCode()) * 31) + com.fluttercandies.photo_manager.core.entity.a.a(this.f33548d)) * 31) + com.fluttercandies.photo_manager.core.entity.a.a(this.f33549e);
        }

        public final long i() {
            return this.f33549e;
        }

        public final v j() {
            return this.f33546b;
        }

        public String toString() {
            return "VideoParams(bitRate=" + this.f33545a + ", quality=" + this.f33546b + ", fallbackQuality=" + this.f33547c + ", durationLimitMs=" + this.f33548d + ", fileSizeLimitBytes=" + this.f33549e + ')';
        }

        public b(int i11, v vVar, v vVar2, long j11, long j12) {
            this.f33545a = i11;
            this.f33546b = vVar;
            this.f33547c = vVar2;
            this.f33548d = j11;
            this.f33549e = j12;
        }

        public final b a(int i11, v vVar, v vVar2, long j11, long j12) {
            return new b(i11, vVar, vVar2, j11, j12);
        }

        public static /* synthetic */ b a(b bVar, int i11, v vVar, v vVar2, long j11, long j12, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                i11 = bVar.f33545a;
            }
            if ((i12 & 2) != 0) {
                vVar = bVar.f33546b;
            }
            v vVar3 = vVar;
            if ((i12 & 4) != 0) {
                vVar2 = bVar.f33547c;
            }
            v vVar4 = vVar2;
            if ((i12 & 8) != 0) {
                j11 = bVar.f33548d;
            }
            long j13 = j11;
            if ((i12 & 16) != 0) {
                j12 = bVar.f33549e;
            }
            return bVar.a(i11, vVar3, vVar4, j13, j12);
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ b(int r6, androidx.camera.video.v r7, androidx.camera.video.v r8, long r9, long r11, int r13, kotlin.jvm.internal.r r14) {
            /*
                r5 = this;
                r14 = r13 & 1
                if (r14 == 0) goto L_0x0005
                r6 = 0
            L_0x0005:
                r14 = r13 & 2
                if (r14 == 0) goto L_0x000b
                androidx.camera.video.v r7 = androidx.camera.video.v.f6366b
            L_0x000b:
                r14 = r7
                r7 = r13 & 4
                if (r7 == 0) goto L_0x0012
                androidx.camera.video.v r8 = androidx.camera.video.v.f6365a
            L_0x0012:
                r0 = r8
                r7 = r13 & 8
                r1 = 0
                if (r7 == 0) goto L_0x001b
                r3 = r1
                goto L_0x001c
            L_0x001b:
                r3 = r9
            L_0x001c:
                r7 = r13 & 16
                if (r7 == 0) goto L_0x0021
                goto L_0x0022
            L_0x0021:
                r1 = r11
            L_0x0022:
                r7 = r5
                r8 = r6
                r9 = r14
                r10 = r0
                r11 = r3
                r13 = r1
                r7.<init>(r8, r9, r10, r11, r13)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.domain.camera.CameraX.b.<init>(int, androidx.camera.video.v, androidx.camera.video.v, long, long, int, kotlin.jvm.internal.r):void");
        }
    }

    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final File f33550a;

        /* renamed from: b  reason: collision with root package name */
        public final a f33551b;

        public static abstract class a {

            /* renamed from: com.sumsub.sns.internal.core.domain.camera.CameraX$c$a$a  reason: collision with other inner class name */
            public static final class C0371a extends a {

                /* renamed from: a  reason: collision with root package name */
                public final int f33552a;

                /* renamed from: b  reason: collision with root package name */
                public final Throwable f33553b;

                public C0371a(int i11, Throwable th2) {
                    super((r) null);
                    this.f33552a = i11;
                    this.f33553b = th2;
                }

                public final int a() {
                    return this.f33552a;
                }

                public final Throwable b() {
                    return this.f33553b;
                }

                public final Throwable c() {
                    return this.f33553b;
                }

                public final int d() {
                    return this.f33552a;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof C0371a)) {
                        return false;
                    }
                    C0371a aVar = (C0371a) obj;
                    return this.f33552a == aVar.f33552a && x.b(this.f33553b, aVar.f33553b);
                }

                public int hashCode() {
                    int i11 = this.f33552a * 31;
                    Throwable th2 = this.f33553b;
                    return i11 + (th2 == null ? 0 : th2.hashCode());
                }

                public String toString() {
                    return "Error(code=" + this.f33552a + ", cause=" + this.f33553b + ')';
                }

                public final C0371a a(int i11, Throwable th2) {
                    return new C0371a(i11, th2);
                }

                public static /* synthetic */ C0371a a(C0371a aVar, int i11, Throwable th2, int i12, Object obj) {
                    if ((i12 & 1) != 0) {
                        i11 = aVar.f33552a;
                    }
                    if ((i12 & 2) != 0) {
                        th2 = aVar.f33553b;
                    }
                    return aVar.a(i11, th2);
                }
            }

            public static final class b extends a {

                /* renamed from: a  reason: collision with root package name */
                public final int f33554a;

                /* renamed from: b  reason: collision with root package name */
                public final long f33555b;

                public b(int i11, long j11) {
                    super((r) null);
                    this.f33554a = i11;
                    this.f33555b = j11;
                }

                public final int a() {
                    return this.f33554a;
                }

                public final long b() {
                    return this.f33555b;
                }

                public final int c() {
                    return this.f33554a;
                }

                public final long d() {
                    return this.f33555b;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof b)) {
                        return false;
                    }
                    b bVar = (b) obj;
                    return this.f33554a == bVar.f33554a && this.f33555b == bVar.f33555b;
                }

                public int hashCode() {
                    return (this.f33554a * 31) + com.fluttercandies.photo_manager.core.entity.a.a(this.f33555b);
                }

                public String toString() {
                    return "Ok(durationsSec=" + this.f33554a + ", fileSizeBytes=" + this.f33555b + ')';
                }

                public final b a(int i11, long j11) {
                    return new b(i11, j11);
                }

                public static /* synthetic */ b a(b bVar, int i11, long j11, int i12, Object obj) {
                    if ((i12 & 1) != 0) {
                        i11 = bVar.f33554a;
                    }
                    if ((i12 & 2) != 0) {
                        j11 = bVar.f33555b;
                    }
                    return bVar.a(i11, j11);
                }
            }

            public /* synthetic */ a(r rVar) {
                this();
            }

            public a() {
            }
        }

        public c(File file, a aVar) {
            this.f33550a = file;
            this.f33551b = aVar;
        }

        public final File a() {
            return this.f33550a;
        }

        public final a b() {
            return this.f33551b;
        }

        public final File c() {
            return this.f33550a;
        }

        public final a d() {
            return this.f33551b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return x.b(this.f33550a, cVar.f33550a) && x.b(this.f33551b, cVar.f33551b);
        }

        public int hashCode() {
            return (this.f33550a.hashCode() * 31) + this.f33551b.hashCode();
        }

        public String toString() {
            return "VideoRecordingResult(file=" + this.f33550a + ", status=" + this.f33551b + ')';
        }

        public final c a(File file, a aVar) {
            return new c(file, aVar);
        }

        public static /* synthetic */ c a(c cVar, File file, a aVar, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                file = cVar.f33550a;
            }
            if ((i11 & 2) != 0) {
                aVar = cVar.f33551b;
            }
            return cVar.a(file, aVar);
        }
    }

    public /* synthetic */ class d {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f33556a;

        static {
            int[] iArr = new int[Mode.values().length];
            iArr[Mode.PHOTO.ordinal()] = 1;
            iArr[Mode.VIDEO.ordinal()] = 2;
            iArr[Mode.ANALYZER.ordinal()] = 3;
            iArr[Mode.PHOTO_AND_ANALYZER.ordinal()] = 4;
            iArr[Mode.SEAMLESS_DOC_CAPTURE.ordinal()] = 5;
            f33556a = iArr;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.domain.camera.CameraX$buildImageAnalysisUseCase$1$1$1", f = "CameraX.kt", l = {365}, m = "invokeSuspend")
    public static final class e extends SuspendLambda implements p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f33557a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CameraX f33558b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ImageProxy f33559c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(CameraX cameraX, ImageProxy imageProxy, kotlin.coroutines.c<? super e> cVar) {
            super(2, cVar);
            this.f33558b = cameraX;
            this.f33559c = imageProxy;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((e) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new e(this.f33558b, this.f33559c, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f33557a;
            if (i11 == 0) {
                k.b(obj);
                a a11 = this.f33558b.f33529d;
                if (a11 != null) {
                    ImageProxy imageProxy = this.f33559c;
                    c f11 = this.f33558b.f();
                    this.f33557a = 1;
                    if (a11.a(imageProxy, f11, this) == d11) {
                        return d11;
                    }
                }
            } else if (i11 == 1) {
                k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.f56620a;
        }
    }

    public static final class f implements ImageCapture.OnImageSavedCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CameraX f33560a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ File f33561b;

        public f(CameraX cameraX, File file) {
            this.f33560a = cameraX;
            this.f33561b = file;
        }

        public void onError(ImageCaptureException imageCaptureException) {
            b.a(CameraX.f33525w, "Photo capture failed: " + imageCaptureException.getMessage(), imageCaptureException);
        }

        public void onImageSaved(ImageCapture.OutputFileResults outputFileResults) {
            a a11 = this.f33560a.f33529d;
            if (a11 != null) {
                a11.a(this.f33561b);
            }
        }
    }

    public CameraX(Mode mode, Size size, b bVar, CameraSelector cameraSelector, a aVar) {
        this.f33526a = mode;
        this.f33527b = bVar;
        this.f33528c = cameraSelector;
        this.f33529d = aVar;
        this.f33543r = new f(this);
        this.f33544s = new ResolutionSelector.Builder().setResolutionStrategy(new ResolutionStrategy(size, 1)).setAspectRatioStrategy(new AspectRatioStrategy(1, 1)).build();
    }

    public final void b() {
        this.f33535j = new ImageCapture.Builder().setResolutionSelector(this.f33544s).build();
    }

    public final UseCaseGroup c() {
        UseCaseGroup.Builder builder = new UseCaseGroup.Builder();
        int i11 = d.f33556a[this.f33526a.ordinal()];
        if (i11 == 1) {
            b();
        } else if (i11 == 2) {
            d();
        } else if (i11 == 3) {
            a();
        } else if (i11 == 4) {
            b();
            a();
        } else if (i11 == 5) {
            d();
            a();
        }
        ImageCapture imageCapture = this.f33535j;
        if (imageCapture != null) {
            builder.addUseCase(imageCapture);
        }
        VideoCapture<Recorder> videoCapture = this.f33533h;
        if (videoCapture != null) {
            builder.addUseCase(videoCapture);
        }
        ImageAnalysis imageAnalysis = this.f33536k;
        if (imageAnalysis != null) {
            builder.addUseCase(imageAnalysis);
        }
        Preview build = new Preview.Builder().setResolutionSelector(this.f33544s).build();
        PreviewView previewView = this.f33542q;
        build.setSurfaceProvider(previewView != null ? previewView.getSurfaceProvider() : null);
        builder.addUseCase(build);
        this.f33537l = build;
        return builder.build();
    }

    public final void d() {
        Recorder.Builder f11 = new Recorder.Builder().f(y.d(this.f33527b.j(), o.a(this.f33527b.h())));
        if (this.f33527b.f() > 0) {
            b.b(f33525w, "using " + this.f33527b.f() + " videoBitRate", (Throwable) null, 4, (Object) null);
            f11.g(this.f33527b.f());
        }
        this.f33533h = VideoCapture.X(f11.c());
    }

    public final Context e() {
        PreviewView previewView = this.f33542q;
        if (previewView != null) {
            return previewView.getContext();
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0027, code lost:
        r0 = (r0 = r0.getCameraInfo()).getExposureState();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.sumsub.sns.internal.core.domain.camera.c f() {
        /*
            r10 = this;
            androidx.camera.core.Camera r0 = r10.f33538m
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0019
            androidx.camera.core.CameraInfo r0 = r0.getCameraInfo()
            if (r0 == 0) goto L_0x0019
            androidx.camera.core.ExposureState r0 = r0.getExposureState()
            if (r0 == 0) goto L_0x0019
            boolean r0 = r0.isExposureCompensationSupported()
            if (r0 != r1) goto L_0x0019
            goto L_0x001a
        L_0x0019:
            r1 = r2
        L_0x001a:
            if (r1 == 0) goto L_0x0087
            androidx.camera.core.Camera r0 = r10.f33538m
            r1 = 0
            if (r0 == 0) goto L_0x0032
            androidx.camera.core.CameraInfo r0 = r0.getCameraInfo()
            if (r0 == 0) goto L_0x0032
            androidx.camera.core.ExposureState r0 = r0.getExposureState()
            if (r0 == 0) goto L_0x0032
            android.util.Range r0 = r0.getExposureCompensationRange()
            goto L_0x0033
        L_0x0032:
            r0 = r1
        L_0x0033:
            if (r0 == 0) goto L_0x003c
            java.lang.Comparable r3 = r0.getLower()
            java.lang.Integer r3 = (java.lang.Integer) r3
            goto L_0x003d
        L_0x003c:
            r3 = r1
        L_0x003d:
            if (r3 != 0) goto L_0x0041
            r3 = r2
            goto L_0x0045
        L_0x0041:
            int r3 = r3.intValue()
        L_0x0045:
            if (r0 == 0) goto L_0x004e
            java.lang.Comparable r0 = r0.getUpper()
            java.lang.Integer r0 = (java.lang.Integer) r0
            goto L_0x004f
        L_0x004e:
            r0 = r1
        L_0x004f:
            if (r0 != 0) goto L_0x0053
            r0 = r2
            goto L_0x0057
        L_0x0053:
            int r0 = r0.intValue()
        L_0x0057:
            androidx.camera.core.Camera r4 = r10.f33538m
            if (r4 == 0) goto L_0x006f
            androidx.camera.core.CameraInfo r4 = r4.getCameraInfo()
            if (r4 == 0) goto L_0x006f
            androidx.camera.core.ExposureState r4 = r4.getExposureState()
            if (r4 == 0) goto L_0x006f
            int r1 = r4.getExposureCompensationIndex()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
        L_0x006f:
            if (r1 == 0) goto L_0x0075
            int r2 = r1.intValue()
        L_0x0075:
            com.sumsub.sns.internal.core.domain.camera.c r1 = new com.sumsub.sns.internal.core.domain.camera.c
            float r2 = r10.a((int) r2)
            float r3 = r10.a((int) r3)
            float r0 = r10.a((int) r0)
            r1.<init>(r2, r3, r0)
            return r1
        L_0x0087:
            com.sumsub.sns.internal.core.domain.camera.c r0 = new com.sumsub.sns.internal.core.domain.camera.c
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 7
            r9 = 0
            r4 = r0
            r4.<init>(r5, r6, r7, r8, r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.domain.camera.CameraX.f():com.sumsub.sns.internal.core.domain.camera.c");
    }

    public final void g() {
        LiveData<PreviewView.StreamState> previewStreamState;
        b.b(f33525w, "On destroy", (Throwable) null, 4, (Object) null);
        this.f33540o = null;
        ImageAnalysis imageAnalysis = this.f33536k;
        if (imageAnalysis != null) {
            imageAnalysis.clearAnalyzer();
        }
        ExecutorService executorService = this.f33530e;
        if (executorService != null) {
            executorService.shutdown();
        }
        h();
        g gVar = this.f33539n;
        if (gVar != null) {
            gVar.o();
        }
        this.f33539n = null;
        Preview preview = this.f33537l;
        if (preview != null) {
            preview.setSurfaceProvider((Preview.SurfaceProvider) null);
        }
        this.f33537l = null;
        PreviewView previewView = this.f33542q;
        if (!(previewView == null || (previewStreamState = previewView.getPreviewStreamState()) == null)) {
            previewStreamState.removeObserver(this.f33543r);
        }
        this.f33542q = null;
        this.f33538m = null;
        h0 h0Var = this.f33532g;
        if (h0Var != null) {
            i0.f(h0Var, (CancellationException) null, 1, (Object) null);
        }
    }

    public final void h() {
        if (this.f33534i != null) {
            b.b(f33525w, "Stop video recording", (Throwable) null, 4, (Object) null);
            z0 z0Var = this.f33534i;
            if (z0Var != null) {
                z0Var.g();
            }
            z0 z0Var2 = this.f33534i;
            if (z0Var2 != null) {
                z0Var2.close();
            }
            this.f33534i = null;
        }
    }

    public static final void a(CameraX cameraX, PreviewView.StreamState streamState) {
        a aVar;
        b.b(f33525w, "Stream state changed: " + streamState, (Throwable) null, 4, (Object) null);
        if (cameraX.f33540o != streamState) {
            if (streamState == PreviewView.StreamState.STREAMING && (aVar = cameraX.f33529d) != null) {
                aVar.c();
            }
            cameraX.f33540o = streamState;
        }
    }

    public final void a(LifecycleOwner lifecycleOwner, PreviewView previewView) {
        ExecutorCoroutineDispatcher b11;
        LiveData<PreviewView.StreamState> previewStreamState;
        boolean b12 = x.b(this.f33528c, CameraSelector.DEFAULT_FRONT_CAMERA);
        ExecutorCoroutineDispatcher executorCoroutineDispatcher = null;
        b.b(f33525w, "start: cameraFront=" + b12, (Throwable) null, 4, (Object) null);
        if (previewView != null) {
            PreviewView previewView2 = this.f33542q;
            if (previewView == previewView2) {
                b.b(f33525w, "start: skipping", (Throwable) null, 4, (Object) null);
                return;
            }
            if (!(previewView2 == null || (previewStreamState = previewView2.getPreviewStreamState()) == null)) {
                previewStreamState.removeObserver(this.f33543r);
            }
            this.f33542q = previewView;
            ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
            this.f33530e = newSingleThreadExecutor;
            if (!(newSingleThreadExecutor == null || (b11 = f1.b(newSingleThreadExecutor)) == null)) {
                this.f33532g = i0.a(b11);
                executorCoroutineDispatcher = b11;
            }
            this.f33531f = executorCoroutineDispatcher;
            previewView.getPreviewStreamState().observe(lifecycleOwner, this.f33543r);
            ListenableFuture<g> g11 = g.g(previewView.getContext());
            g11.addListener(new g(g11, this, lifecycleOwner), ContextCompat.getMainExecutor(previewView.getContext()));
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CameraX(com.sumsub.sns.internal.core.domain.camera.CameraX.Mode r13, android.util.Size r14, com.sumsub.sns.internal.core.domain.camera.CameraX.b r15, androidx.camera.core.CameraSelector r16, com.sumsub.sns.internal.core.domain.camera.a r17, int r18, kotlin.jvm.internal.r r19) {
        /*
            r12 = this;
            r0 = r18 & 2
            if (r0 == 0) goto L_0x000e
            android.util.Size r0 = new android.util.Size
            r1 = 1920(0x780, float:2.69E-42)
            r2 = 1080(0x438, float:1.513E-42)
            r0.<init>(r1, r2)
            goto L_0x000f
        L_0x000e:
            r0 = r14
        L_0x000f:
            r1 = r18 & 4
            if (r1 == 0) goto L_0x0024
            com.sumsub.sns.internal.core.domain.camera.CameraX$b r1 = new com.sumsub.sns.internal.core.domain.camera.CameraX$b
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r8 = 0
            r10 = 31
            r11 = 0
            r2 = r1
            r2.<init>(r3, r4, r5, r6, r8, r10, r11)
            goto L_0x0025
        L_0x0024:
            r1 = r15
        L_0x0025:
            r2 = r18 & 8
            if (r2 == 0) goto L_0x002c
            androidx.camera.core.CameraSelector r2 = androidx.camera.core.CameraSelector.DEFAULT_BACK_CAMERA
            goto L_0x002e
        L_0x002c:
            r2 = r16
        L_0x002e:
            r3 = r18 & 16
            if (r3 == 0) goto L_0x0034
            r3 = 0
            goto L_0x0036
        L_0x0034:
            r3 = r17
        L_0x0036:
            r14 = r12
            r15 = r13
            r16 = r0
            r17 = r1
            r18 = r2
            r19 = r3
            r14.<init>(r15, r16, r17, r18, r19)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.domain.camera.CameraX.<init>(com.sumsub.sns.internal.core.domain.camera.CameraX$Mode, android.util.Size, com.sumsub.sns.internal.core.domain.camera.CameraX$b, androidx.camera.core.CameraSelector, com.sumsub.sns.internal.core.domain.camera.a, int, kotlin.jvm.internal.r):void");
    }

    public static final void a(ListenableFuture listenableFuture, CameraX cameraX, LifecycleOwner lifecycleOwner) {
        try {
            g gVar = (g) listenableFuture.get();
            gVar.o();
            cameraX.f33538m = gVar.d(lifecycleOwner, cameraX.f33528c, cameraX.c());
            cameraX.f33539n = gVar;
        } catch (Exception e11) {
            a aVar = cameraX.f33529d;
            if (aVar != null) {
                aVar.onError(e11);
            }
            b.a(f33525w, "Init camera failed", e11);
        }
    }

    public static /* synthetic */ void a(CameraX cameraX, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = null;
        }
        cameraX.a(str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0032, code lost:
        if (r5 == null) goto L_0x0034;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r5) {
        /*
            r4 = this;
            java.lang.String r0 = "CameraX"
            java.lang.String r1 = "Take picture"
            r2 = 0
            r3 = 4
            com.sumsub.sns.internal.core.domain.camera.b.b(r0, r1, r2, r3, r2)
            androidx.camera.core.ImageCapture r0 = r4.f33535j
            if (r0 != 0) goto L_0x000e
            return
        L_0x000e:
            android.content.Context r1 = r4.e()
            if (r1 == 0) goto L_0x0018
            java.io.File r2 = r1.getCacheDir()
        L_0x0018:
            java.lang.String r1 = ".jpg"
            if (r5 == 0) goto L_0x0034
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r5)
            java.util.UUID r5 = java.util.UUID.randomUUID()
            r3.append(r5)
            r3.append(r1)
            java.lang.String r5 = r3.toString()
            if (r5 != 0) goto L_0x0047
        L_0x0034:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.util.UUID r3 = java.util.UUID.randomUUID()
            r5.append(r3)
            r5.append(r1)
            java.lang.String r5 = r5.toString()
        L_0x0047:
            java.io.File r1 = new java.io.File
            r1.<init>(r2, r5)
            androidx.camera.core.ImageCapture$OutputFileOptions$Builder r5 = new androidx.camera.core.ImageCapture$OutputFileOptions$Builder
            r5.<init>((java.io.File) r1)
            androidx.camera.core.ImageCapture$OutputFileOptions r5 = r5.build()
            android.content.Context r2 = r4.e()
            if (r2 != 0) goto L_0x005c
            return
        L_0x005c:
            java.util.concurrent.Executor r2 = androidx.core.content.ContextCompat.getMainExecutor(r2)
            com.sumsub.sns.internal.core.domain.camera.CameraX$f r3 = new com.sumsub.sns.internal.core.domain.camera.CameraX$f
            r3.<init>(r4, r1)
            r0.lambda$takePicture$2(r5, r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.domain.camera.CameraX.a(java.lang.String):void");
    }

    public static /* synthetic */ void a(CameraX cameraX, File file, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            file = null;
        }
        cameraX.a(file);
    }

    @SuppressLint({"MissingPermission"})
    public final void a(File file) {
        Context e11;
        if (!e0.f32018a.isDebug() || this.f33534i == null) {
            VideoCapture<Recorder> videoCapture = this.f33533h;
            if (videoCapture != null && (e11 = e()) != null) {
                if (file == null) {
                    File cacheDir = e11.getCacheDir();
                    file = new File(cacheDir, UUID.randomUUID().toString() + PictureMimeType.MP4);
                }
                b.b(f33525w, "Take video snapshot and save to " + file.getName(), (Throwable) null, 4, (Object) null);
                q.a aVar = new q.a(file);
                if (this.f33527b.i() > 0) {
                    aVar.b(this.f33527b.i());
                }
                if (this.f33527b.g() > 0) {
                    aVar.a(this.f33527b.g());
                }
                u f02 = videoCapture.B().f0(e11, aVar.c());
                if (this.f33526a != Mode.SEAMLESS_DOC_CAPTURE) {
                    f02.i();
                }
                this.f33534i = f02.h(ContextCompat.getMainExecutor(e11), new e(this, file));
                this.f33541p = file;
                return;
            }
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public static final void a(CameraX cameraX, File file, v1 v1Var) {
        boolean z11;
        boolean z12;
        a aVar;
        boolean z13 = v1Var instanceof v1.d;
        if (z13 && (aVar = cameraX.f33529d) != null) {
            aVar.b(file);
        }
        boolean z14 = true;
        if (z13) {
            z11 = true;
        } else {
            z11 = v1Var instanceof v1.b;
        }
        if (z11) {
            z12 = true;
        } else {
            z12 = v1Var instanceof v1.c;
        }
        if (!z12) {
            z14 = v1Var instanceof v1.a;
        }
        if (z14) {
            Log.v(f33525w, file.getName() + " recording state=" + v1Var);
            if (v1Var instanceof v1.a) {
                cameraX.a((v1.a) v1Var);
            }
        }
    }

    public final void a(v1.a aVar) {
        c.a aVar2;
        a aVar3;
        if (aVar.l()) {
            b.b(f33525w, "handleVideoRecordFinalized: error=" + aVar.k(), (Throwable) null, 4, (Object) null);
            Throwable j11 = aVar.j();
            if (j11 != null) {
                b.b(f33525w, "Video recording finialized with exception", j11);
            }
            aVar2 = new c.a.C0371a(aVar.k(), aVar.j());
        } else {
            aVar2 = new c.a.b((int) TimeUnit.NANOSECONDS.toSeconds(aVar.d().c()), aVar.d().b());
        }
        File file = this.f33541p;
        if (!(file == null || (aVar3 = this.f33529d) == null)) {
            aVar3.a(new c(file, aVar2));
        }
        this.f33541p = null;
    }

    public final void a(boolean z11) {
        CameraControl cameraControl;
        b.b(f33525w, "Enable flash", (Throwable) null, 4, (Object) null);
        Camera camera = this.f33538m;
        if (!(camera == null || (cameraControl = camera.getCameraControl()) == null)) {
            cameraControl.enableTorch(z11);
        }
        ImageCapture imageCapture = this.f33535j;
        if (imageCapture != null) {
            imageCapture.setFlashMode(z11 ? 1 : 2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0040, code lost:
        r4 = (r4 = (r4 = r4.getCameraInfo()).getExposureState()).getExposureCompensationStep();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(float r9) {
        /*
            r8 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Set exposure "
            r0.append(r1)
            r0.append(r9)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "CameraX"
            r2 = 0
            r3 = 4
            com.sumsub.sns.internal.core.domain.camera.b.b(r1, r0, r2, r3, r2)
            androidx.camera.core.Camera r0 = r8.f33538m
            if (r0 == 0) goto L_0x00a8
            androidx.camera.core.CameraInfo r0 = r0.getCameraInfo()
            if (r0 == 0) goto L_0x00a8
            androidx.camera.core.ExposureState r0 = r0.getExposureState()
            if (r0 == 0) goto L_0x00a8
            android.util.Range r0 = r0.getExposureCompensationRange()
            if (r0 != 0) goto L_0x0030
            goto L_0x00a8
        L_0x0030:
            androidx.camera.core.Camera r4 = r8.f33538m
            if (r4 == 0) goto L_0x004b
            androidx.camera.core.CameraInfo r4 = r4.getCameraInfo()
            if (r4 == 0) goto L_0x004b
            androidx.camera.core.ExposureState r4 = r4.getExposureState()
            if (r4 == 0) goto L_0x004b
            android.util.Rational r4 = r4.getExposureCompensationStep()
            if (r4 == 0) goto L_0x004b
            float r4 = r4.floatValue()
            goto L_0x004d
        L_0x004b:
            r4 = 1065353216(0x3f800000, float:1.0)
        L_0x004d:
            java.lang.Comparable r5 = r0.getLower()
            java.lang.Integer r5 = (java.lang.Integer) r5
            r6 = 0
            if (r5 != 0) goto L_0x0058
            r5 = r6
            goto L_0x005c
        L_0x0058:
            int r5 = r5.intValue()
        L_0x005c:
            java.lang.Comparable r7 = r0.getUpper()
            java.lang.Integer r7 = (java.lang.Integer) r7
            if (r7 != 0) goto L_0x0065
            goto L_0x0069
        L_0x0065:
            int r6 = r7.intValue()
        L_0x0069:
            float r4 = r9 / r4
            int r4 = (int) r4
            int r4 = java.lang.Math.min(r4, r6)
            int r4 = java.lang.Math.max(r4, r5)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)
            boolean r5 = r0.contains(r5)
            if (r5 == 0) goto L_0x008c
            androidx.camera.core.Camera r9 = r8.f33538m
            if (r9 == 0) goto L_0x00a8
            androidx.camera.core.CameraControl r9 = r9.getCameraControl()
            if (r9 == 0) goto L_0x00a8
            r9.setExposureCompensationIndex(r4)
            goto L_0x00a8
        L_0x008c:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Set exposure failed, "
            r4.append(r5)
            r4.append(r9)
            java.lang.String r9 = " is out of range "
            r4.append(r9)
            r4.append(r0)
            java.lang.String r9 = r4.toString()
            com.sumsub.sns.internal.core.domain.camera.b.a(r1, r9, r2, r3, r2)
        L_0x00a8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.domain.camera.CameraX.a(float):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0010, code lost:
        r0 = (r0 = (r0 = r0.getCameraInfo()).getExposureState()).getExposureCompensationStep();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final float a(int r2) {
        /*
            r1 = this;
            androidx.camera.core.Camera r0 = r1.f33538m
            if (r0 == 0) goto L_0x001b
            androidx.camera.core.CameraInfo r0 = r0.getCameraInfo()
            if (r0 == 0) goto L_0x001b
            androidx.camera.core.ExposureState r0 = r0.getExposureState()
            if (r0 == 0) goto L_0x001b
            android.util.Rational r0 = r0.getExposureCompensationStep()
            if (r0 == 0) goto L_0x001b
            float r0 = r0.floatValue()
            goto L_0x001c
        L_0x001b:
            r0 = 0
        L_0x001c:
            float r2 = (float) r2
            float r0 = r0 * r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.domain.camera.CameraX.a(int):float");
    }

    public final void a() {
        ImageAnalysis build = new ImageAnalysis.Builder().setBackpressureStrategy(0).setTargetRotation(0).setOutputImageFormat(2).setResolutionSelector(this.f33544s).build();
        this.f33536k = build;
        ExecutorService executorService = this.f33530e;
        if (executorService != null && build != null) {
            build.setAnalyzer(executorService, new d(this));
        }
    }

    public static final void a(CameraX cameraX, ImageProxy imageProxy) {
        Object unused = h.b((CoroutineContext) null, new e(cameraX, imageProxy, (kotlin.coroutines.c<? super e>) null), 1, (Object) null);
    }
}
