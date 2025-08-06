package jumio.iproov;

import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.LayoutInflater;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.huobi.view.roundimg.RoundedDrawable;
import com.iproov.sdk.IProov;
import com.iproov.sdk.IProovCallbackLauncher;
import com.iproov.sdk.core.exception.IProovException;
import com.jumio.analytics.Analytics;
import com.jumio.analytics.MetaInfo;
import com.jumio.analytics.MobileEvents;
import com.jumio.commons.camera.CameraUtils;
import com.jumio.commons.camera.ImageData;
import com.jumio.commons.camera.Size;
import com.jumio.commons.enums.ScreenAngle;
import com.jumio.commons.log.Log;
import com.jumio.commons.log.LogLevel;
import com.jumio.core.Controller;
import com.jumio.core.api.calls.IproovTokenCall;
import com.jumio.core.api.calls.IproovValidateCall;
import com.jumio.core.api.calls.UploadCall;
import com.jumio.core.data.ScanMode;
import com.jumio.core.enums.ErrorCase;
import com.jumio.core.environment.Environment;
import com.jumio.core.error.Error;
import com.jumio.core.extraction.liveness.extraction.LivenessDataModel;
import com.jumio.core.face.FaceHelpAnimation;
import com.jumio.core.models.ApiCallDataModel;
import com.jumio.core.models.ConsentModel;
import com.jumio.core.models.FaceScanPartModel;
import com.jumio.core.models.IproovTokenModel;
import com.jumio.core.models.IproovValidateModel;
import com.jumio.core.models.SettingsModel;
import com.jumio.core.network.ApiBinding;
import com.jumio.core.scanpart.ScanPart;
import com.jumio.core.util.DeviceUtilKt;
import com.jumio.core.util.FileData;
import com.jumio.iproov.R;
import com.jumio.sdk.enums.JumioScanMode;
import com.jumio.sdk.enums.JumioScanStep;
import com.jumio.sdk.retry.JumioRetryReason;
import com.jumio.sdk.views.JumioAnimationView;
import d10.p;
import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jumio.iproov.a;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlin.k;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.g;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n1;
import kotlinx.coroutines.v0;

public final class b extends ScanPart<FaceScanPartModel> implements IProovCallbackLauncher.Listener, ApiBinding {

    /* renamed from: j  reason: collision with root package name */
    public static final IProovCallbackLauncher f56405j = new IProovCallbackLauncher();

    /* renamed from: a  reason: collision with root package name */
    public final int f56406a;

    /* renamed from: b  reason: collision with root package name */
    public int f56407b;

    /* renamed from: c  reason: collision with root package name */
    public final SettingsModel f56408c;

    /* renamed from: d  reason: collision with root package name */
    public IProov.Session f56409d;

    /* renamed from: e  reason: collision with root package name */
    public Bitmap f56410e;

    /* renamed from: f  reason: collision with root package name */
    public IproovTokenModel f56411f;

    /* renamed from: g  reason: collision with root package name */
    public IproovValidateModel f56412g;

    /* renamed from: h  reason: collision with root package name */
    public final Map<Integer, Integer> f56413h;

    /* renamed from: i  reason: collision with root package name */
    public final Map<Integer, Boolean> f56414i;

    public static final class a extends Lambda implements p<TypedArray, Integer, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f56415a = new a();

        public a() {
            super(2);
        }

        public final Object invoke(Object obj, Object obj2) {
            return Boolean.valueOf(((TypedArray) obj).getBoolean(((Number) obj2).intValue(), true));
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.jumio.iproov.scanpart.IproovScanPart$onIproovProcessed$2", f = "IproovScanPart.kt", l = {406}, m = "invokeSuspend")
    /* renamed from: jumio.iproov.b$b  reason: collision with other inner class name */
    public static final class C0661b extends SuspendLambda implements p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f56416a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f56417b;

        @kotlin.coroutines.jvm.internal.d(c = "com.jumio.iproov.scanpart.IproovScanPart$onIproovProcessed$2$filePath$1", f = "IproovScanPart.kt", l = {}, m = "invokeSuspend")
        /* renamed from: jumio.iproov.b$b$a */
        public static final class a extends SuspendLambda implements p<h0, kotlin.coroutines.c<? super String>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f56418a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(b bVar, kotlin.coroutines.c<? super a> cVar) {
                super(2, cVar);
                this.f56418a = bVar;
            }

            public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
                return new a(this.f56418a, cVar);
            }

            public final Object invoke(Object obj, Object obj2) {
                return ((a) create((h0) obj, (kotlin.coroutines.c) obj2)).invokeSuspend(Unit.f56620a);
            }

            public final Object invokeSuspend(Object obj) {
                File file;
                Object unused = IntrinsicsKt__IntrinsicsKt.d();
                k.b(obj);
                String str = null;
                try {
                    file = new File(Environment.INSTANCE.getDataDirectory(this.f56418a.getController().getContext()), "tmp_" + System.currentTimeMillis());
                } catch (Exception e11) {
                    Log.printStackTrace(e11);
                    file = null;
                }
                Bitmap a11 = this.f56418a.f56410e;
                if (!(a11 == null || a11.isRecycled() || file == null)) {
                    CameraUtils.INSTANCE.saveBitmap(a11, file, Bitmap.CompressFormat.WEBP, 85, this.f56418a.getController().getAuthorizationModel().getSessionKey());
                }
                if (file != null) {
                    str = file.getAbsolutePath();
                }
                return str == null ? "" : str;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0661b(b bVar, kotlin.coroutines.c<? super C0661b> cVar) {
            super(2, cVar);
            this.f56417b = bVar;
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new C0661b(this.f56417b, cVar);
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((C0661b) create((h0) obj, (kotlin.coroutines.c) obj2)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f56416a;
            if (i11 == 0) {
                k.b(obj);
                CoroutineDispatcher b11 = v0.b();
                a aVar = new a(this.f56417b, (kotlin.coroutines.c<? super a>) null);
                this.f56416a = 1;
                obj = g.g(b11, aVar, this);
                if (obj == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ((FaceScanPartModel) this.f56417b.getScanPartModel()).getFileData().setPath((String) obj);
            LivenessDataModel livenessDataModel = new LivenessDataModel();
            b bVar = this.f56417b;
            livenessDataModel.setType(ScanMode.FACE_IPROOV);
            IproovValidateModel iproovValidateModel = bVar.f56412g;
            livenessDataModel.setPassed(kotlin.coroutines.jvm.internal.a.a(iproovValidateModel != null ? iproovValidateModel.getPassed() : false));
            ((FaceScanPartModel) this.f56417b.getScanPartModel()).setLivenessData(livenessDataModel);
            this.f56417b.setComplete(true);
            ScanPart.sendScanStep$default(this.f56417b, JumioScanStep.CAN_FINISH, (Object) null, (Object) null, 6, (Object) null);
            return Unit.f56620a;
        }
    }

    public static final class c extends Lambda implements d10.a<Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f56419a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(b bVar) {
            super(0);
            this.f56419a = bVar;
        }

        public final Object invoke() {
            this.f56419a.e();
            return Unit.f56620a;
        }
    }

    public static final class d extends Lambda implements p<TypedArray, Integer, Integer> {

        /* renamed from: a  reason: collision with root package name */
        public static final d f56420a = new d();

        public d() {
            super(2);
        }

        public final Object invoke(Object obj, Object obj2) {
            return Integer.valueOf(((TypedArray) obj).getColor(((Number) obj2).intValue(), -1));
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x00bc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public b(com.jumio.core.Controller r17, com.jumio.sdk.credentials.JumioFaceCredential r18, com.jumio.core.models.FaceScanPartModel r19, com.jumio.sdk.interfaces.JumioScanPartInterface r20) {
        /*
            r16 = this;
            r0 = r16
            r16.<init>(r17, r18, r19, r20)
            com.jumio.core.MobileContext r1 = r17.getContext()
            int r2 = com.jumio.iproov.R.style.Iproov_Customization
            int r3 = com.jumio.iproov.R.attr.iproov_customization
            r4 = 11
            int[] r4 = new int[r4]
            int r5 = com.jumio.iproov.R.attr.iproov_filterForegroundColor
            r6 = 0
            r4[r6] = r5
            int r5 = com.jumio.iproov.R.attr.iproov_filterBackgroundColor
            r7 = 1
            r4[r7] = r5
            int r5 = com.jumio.iproov.R.attr.iproov_titleTextColor
            r8 = 2
            r4[r8] = r5
            int r5 = com.jumio.iproov.R.attr.iproov_promptTextColor
            r9 = 3
            r4[r9] = r5
            int r5 = com.jumio.iproov.R.attr.iproov_promptBackgroundColor
            r10 = 4
            r4[r10] = r5
            int r5 = com.jumio.iproov.R.attr.iproov_surroundColor
            r10 = 5
            r4[r10] = r5
            int r5 = com.jumio.iproov.R.attr.iproov_closeButton_colorTint
            r10 = 6
            r4[r10] = r5
            int r5 = com.jumio.iproov.R.attr.iproov_livenessAssurance_ovalStrokeColor
            r10 = 7
            r4[r10] = r5
            int r5 = com.jumio.iproov.R.attr.iproov_livenessAssurance_completedOvalStrokeColor
            r10 = 8
            r4[r10] = r5
            int r5 = com.jumio.iproov.R.attr.iproov_genuinePresenceAssurance_notReadyOvalStrokeColor
            r10 = 9
            r4[r10] = r5
            int r5 = com.jumio.iproov.R.attr.iproov_genuinePresenceAssurance_readyOvalStrokeColor
            r10 = 10
            r4[r10] = r5
            jumio.iproov.b$d r5 = jumio.iproov.b.d.f56420a
            java.util.Map r1 = r1.getCustomizations(r2, r3, r4, r5)
            r0.f56413h = r1
            com.jumio.core.MobileContext r1 = r17.getContext()
            int[] r4 = new int[r7]
            int r5 = com.jumio.iproov.R.attr.iproov_promptRoundedCorners
            r4[r6] = r5
            jumio.iproov.b$a r5 = jumio.iproov.b.a.f56415a
            java.util.Map r1 = r1.getCustomizations(r2, r3, r4, r5)
            r0.f56414i = r1
            r16.reset()
            com.jumio.core.persistence.DataManager r1 = r17.getDataManager()
            java.lang.Class<com.jumio.core.models.IproovTokenModel> r2 = com.jumio.core.models.IproovTokenModel.class
            java.io.Serializable r1 = r1.get(r2)
            com.jumio.core.models.IproovTokenModel r1 = (com.jumio.core.models.IproovTokenModel) r1
            r0.f56411f = r1
            com.jumio.core.persistence.DataManager r1 = r17.getDataManager()
            java.lang.Class<com.jumio.core.models.SettingsModel> r2 = com.jumio.core.models.SettingsModel.class
            java.io.Serializable r1 = r1.get(r2)
            com.jumio.core.models.SettingsModel r1 = (com.jumio.core.models.SettingsModel) r1
            com.jumio.core.models.IproovTokenModel r2 = r0.f56411f
            java.lang.String r2 = r2.getToken()
            int r2 = r2.length()
            if (r2 != 0) goto L_0x0090
            r2 = r7
            goto L_0x0091
        L_0x0090:
            r2 = r6
        L_0x0091:
            if (r2 != 0) goto L_0x00a6
            com.jumio.core.models.IproovTokenModel r2 = r0.f56411f
            java.lang.String r2 = r2.getUrl()
            int r2 = r2.length()
            if (r2 != 0) goto L_0x00a0
            r6 = r7
        L_0x00a0:
            if (r6 == 0) goto L_0x00a3
            goto L_0x00a6
        L_0x00a3:
            r0.f56408c = r1
            goto L_0x00b8
        L_0x00a6:
            com.jumio.core.error.Error r1 = new com.jumio.core.error.Error
            com.jumio.core.enums.ErrorCase r11 = com.jumio.core.enums.ErrorCase.OCR_LOADING_FAILED
            r12 = 0
            r13 = 0
            r14 = 6
            r15 = 0
            r10 = r1
            r10.<init>(r11, r12, r13, r14, r15)
            r2 = 0
            r3 = r17
            com.jumio.core.Controller.onError$default(r3, r1, r2, r8, r2)
        L_0x00b8:
            com.jumio.core.models.SettingsModel r1 = r0.f56408c
            if (r1 == 0) goto L_0x00c0
            int r9 = r1.getIproovMaxAttempts()
        L_0x00c0:
            r0.f56406a = r9
            com.iproov.sdk.IProovCallbackLauncher r1 = f56405j
            r1.setListener(r0)
            r16.d()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: jumio.iproov.b.<init>(com.jumio.core.Controller, com.jumio.sdk.credentials.JumioFaceCredential, com.jumio.core.models.FaceScanPartModel, com.jumio.sdk.interfaces.JumioScanPartInterface):void");
    }

    public final void c() {
        FileData fileData = ((FaceScanPartModel) getScanPartModel()).getFileData();
        if (fileData instanceof ImageData) {
            ImageData imageData = (ImageData) fileData;
            imageData.setCameraPosition(ImageData.CameraPosition.FRONT);
            imageData.setOrientationMode(ScreenAngle.PORTRAIT);
            int i11 = 0;
            imageData.setFlashMode(false);
            Size imageSize = imageData.getImageSize();
            Bitmap bitmap = this.f56410e;
            imageSize.setWidth(bitmap != null ? bitmap.getWidth() : 0);
            Size imageSize2 = imageData.getImageSize();
            Bitmap bitmap2 = this.f56410e;
            if (bitmap2 != null) {
                i11 = bitmap2.getHeight();
            }
            imageSize2.setHeight(i11);
        }
        if (this.f56410e != null) {
            Log log = Log.INSTANCE;
            LogLevel logLevel = LogLevel.DEBUG;
        }
        n1 unused = i.d(getMainScope(), (CoroutineContext) null, (CoroutineStart) null, new C0661b(this, (kotlin.coroutines.c<? super C0661b>) null), 3, (Object) null);
    }

    public final void cancel() {
        IProov.Session session;
        IProov.Session session2 = this.f56409d;
        if ((session2 != null && session2.isActive()) && (session = this.f56409d) != null) {
            session.cancel();
        }
        reset();
        if (b() != d.UPFRONT_HELP) {
            a(d.RETRY_HELP);
        }
        getController().getBackendManager().cancelCall(true);
        f56405j.setListener((IProovCallbackLauncher.Listener) null);
        super.cancel();
    }

    public final void d() {
        ((FaceScanPartModel) getScanPartModel()).getData().put("firstStart", Boolean.FALSE);
    }

    public final void e() {
        d b11 = b();
        d dVar = d.RETRY_HELP;
        if (b11 == dVar) {
            a(d.TOKEN_REQUEST);
            getController().getBackendManager().requestIproovToken();
        } else if (b() != d.UPFRONT_HELP) {
            a(dVar);
            a(d.TOKEN_REQUEST);
            getController().getBackendManager().requestIproovToken();
        } else if (this.f56411f.getUsed()) {
            a(d.TOKEN_REQUEST);
            getController().getBackendManager().requestIproovToken();
        } else {
            if (this.f56411f.getToken().length() > 0) {
                a(d.INITIALIZING);
                try {
                    this.f56409d = f56405j.launch(getController().getContext(), this.f56411f.getUrl(), this.f56411f.getToken(), a());
                } catch (Exception e11) {
                    Log.e("IproovScanPart", "Error on launching Iproov", (Throwable) e11);
                    a(new JumioRetryReason(1, getController().getContext().getString(R.string.iproov__error_unexpected_error)));
                }
            } else {
                Controller.onError$default(getController(), new Error(ErrorCase.OCR_LOADING_FAILED, 0, 2301), (Class) null, 2, (Object) null);
            }
        }
    }

    public final void finish() {
        f56405j.setListener((IProovCallbackLauncher.Listener) null);
        super.finish();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.lang.Class<? extends com.jumio.core.network.ApiCall<?>>[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Class<? extends com.jumio.core.network.ApiCall<?>>[] getBindingClasses() {
        /*
            r3 = this;
            r0 = 3
            java.lang.Class[] r0 = new java.lang.Class[r0]
            r1 = 0
            java.lang.Class<com.jumio.core.api.calls.IproovTokenCall> r2 = com.jumio.core.api.calls.IproovTokenCall.class
            r0[r1] = r2
            r1 = 1
            java.lang.Class<com.jumio.core.api.calls.IproovValidateCall> r2 = com.jumio.core.api.calls.IproovValidateCall.class
            r0[r1] = r2
            r1 = 2
            java.lang.Class<com.jumio.core.api.calls.UploadCall> r2 = com.jumio.core.api.calls.UploadCall.class
            r0[r1] = r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: jumio.iproov.b.getBindingClasses():java.lang.Class[]");
    }

    public final boolean getHasFallback() {
        return false;
    }

    public final void getHelpAnimation(JumioAnimationView jumioAnimationView) {
        jumioAnimationView.removeAllViews();
        ConstraintLayout constraintLayout = (ConstraintLayout) LayoutInflater.from(jumioAnimationView.getContext()).inflate(R.layout.jumio_face_custom_animation, jumioAnimationView, false);
        jumioAnimationView.addView(constraintLayout);
        FaceHelpAnimation faceHelpAnimation = new FaceHelpAnimation(getController().getContext());
        faceHelpAnimation.configure((MotionLayout) constraintLayout.findViewById(R.id.face_help_animation), StringsKt__StringsJVMKt.w(this.f56411f.getProductType(), "iproov_premium", true));
        faceHelpAnimation.applyCustomizations(jumioAnimationView.getContext());
        if (DeviceUtilKt.getDeviceUtil().areAnimationsEnabled(jumioAnimationView.getContext())) {
            faceHelpAnimation.start();
        }
        jumioAnimationView.setTag(faceHelpAnimation);
    }

    public final JumioScanMode getScanMode() {
        return JumioScanMode.FACE_IPROOV;
    }

    public final boolean isCancelable() {
        return (b() == d.INITIALIZING || b() == d.RUNNING) ? false : true;
    }

    public final void onCancelled(IProov.Canceller canceller) {
        this.f56409d = null;
        if (b() == d.RUNNING || b() == d.PROGRESS) {
            Log.i("IproovScanPart", "onIproovCancelled: ");
            a(d.RETRY_HELP);
            a(new JumioRetryReason(2, getController().getContext().getString(R.string.iproov__error_unexpected_error)));
            return;
        }
        d b11 = b();
        Log.i("IproovScanPart", "onCancelled was triggered in state " + b11);
    }

    public final void onConnected() {
        a(d.RUNNING);
        String token = this.f56411f.getToken();
        Log.i("IproovScanPart", "onIproovConnected: " + token);
        ((IproovTokenModel) getController().getDataManager().get(IproovTokenModel.class)).setUsed(true);
        ((FaceScanPartModel) getScanPartModel()).getData().put("isGpa", Boolean.valueOf(StringsKt__StringsJVMKt.w(this.f56411f.getProductType(), "iproov_premium", true)));
        MetaInfo analyticsScanData = getAnalyticsScanData();
        analyticsScanData.put("additionalData", StringsKt__StringsJVMKt.w(this.f56411f.getProductType(), "iproov_premium", true) ? "GPA" : "LA");
        sendScanStep(JumioScanStep.STARTED, ((FaceScanPartModel) getScanPartModel()).getCredentialPart(), analyticsScanData);
    }

    public final void onConnecting() {
        a(d.INITIALIZING);
        String token = this.f56411f.getToken();
        Log.i("IproovScanPart", "onIproovConnecting: " + token);
    }

    public final void onError(IProovException iProovException) {
        this.f56409d = null;
        a.f56400c.getClass();
        a a11 = a.C0660a.a(iProovException);
        String reason = iProovException.getReason();
        String message = iProovException.getMessage();
        Log.e("IproovScanPart", "onIproovError: Reason: " + reason + "; Message: " + message);
        int a12 = a11.a();
        String reason2 = iProovException.getReason();
        if (reason2 == null) {
            reason2 = getController().getContext().getString(R.string.iproov__error_unexpected_error);
        }
        a(new JumioRetryReason(a12, reason2));
    }

    public final void onFailure(IProov.FailureResult failureResult) {
        this.f56409d = null;
        if (b() == d.RUNNING || b() == d.PROGRESS) {
            int a11 = c.a(failureResult.getReason());
            Log.i("IproovScanPart", "onIproovFailure: " + a11);
            Bitmap frame = failureResult.getFrame();
            this.f56410e = frame;
            int i11 = this.f56407b + 1;
            this.f56407b = i11;
            if (i11 < this.f56406a || frame == null) {
                a(new JumioRetryReason(a11, getController().getContext().getString(failureResult.getReason().getDescription())));
            } else {
                a("");
            }
        } else {
            d b11 = b();
            Log.i("IproovScanPart", "failure callback was triggered in state " + b11);
        }
    }

    public final void onProcessing(double d11, String str) {
        if (b() == d.RUNNING || b() == d.PROGRESS) {
            d b11 = b();
            d dVar = d.PROGRESS;
            if (b11 != dVar) {
                Log.i("IproovScanPart", "onProgress: " + ((int) (((double) 100) * d11)) + " ; " + str);
                MetaInfo analyticsScanData = getAnalyticsScanData();
                analyticsScanData.put("additionalData", StringsKt__StringsJVMKt.w(this.f56411f.getProductType(), "iproov_premium", true) ? "GPA" : "LA");
                ScanPart.sendScanStep$default(this, JumioScanStep.IMAGE_TAKEN, (Object) null, analyticsScanData, 2, (Object) null);
            }
            a(dVar);
            Log.i("IproovScanPart", "onProgress: " + ((int) (d11 * ((double) 100))) + " ; " + str);
            return;
        }
        d b12 = b();
        Log.i("IproovScanPart", "processing callback was triggered in state " + b12);
    }

    public final void onResult(ApiCallDataModel<?> apiCallDataModel, Object obj) {
        Class<?> call = apiCallDataModel.getCall();
        if (x.b(call, IproovTokenCall.class)) {
            IproovTokenModel iproovTokenModel = (IproovTokenModel) obj;
            if (iproovTokenModel != null) {
                if ((iproovTokenModel.getToken().length() > 0) && !StringsKt__StringsJVMKt.w(iproovTokenModel.getToken(), this.f56411f.getToken(), true)) {
                    this.f56411f = iproovTokenModel;
                    a(d.UPFRONT_HELP);
                    runOnMain(new c(this));
                    return;
                }
            }
            Log.i("IproovScanPart", "Invalid token received from server");
            a(new JumioRetryReason(209, getController().getContext().getString(R.string.iproov__error_unexpected_error)));
        } else if (x.b(call, IproovValidateCall.class)) {
            IproovValidateModel iproovValidateModel = (IproovValidateModel) obj;
            if (iproovValidateModel == null) {
                onError(apiCallDataModel, (Throwable) null);
            } else if (!iproovValidateModel.getPassed()) {
                this.f56412g = iproovValidateModel;
                if (this.f56407b < this.f56406a || this.f56410e == null) {
                    a(new JumioRetryReason(4, getController().getContext().getString(R.string.iproov__error_unexpected_error)));
                } else {
                    c();
                }
            } else {
                this.f56412g = iproovValidateModel;
                c();
            }
        }
    }

    public final void onSuccess(IProov.SuccessResult successResult) {
        this.f56409d = null;
        if (b() == d.RUNNING || b() == d.PROGRESS) {
            MetaInfo metaInfo = new MetaInfo();
            metaInfo.put("additionalData", this.f56411f.getToken());
            Analytics.Companion.add(MobileEvents.misc("iproovSuccess", metaInfo));
            this.f56410e = successResult.getFrame();
            a(this.f56411f.getToken());
            return;
        }
        d b11 = b();
        Log.i("IproovScanPart", "success callback was triggered in state " + b11);
    }

    public final void persist() {
        super.persist();
        f56405j.setListener((IProovCallbackLauncher.Listener) null);
    }

    public final void retry(JumioRetryReason jumioRetryReason) {
        super.retry(jumioRetryReason);
        d b11 = b();
        Log.i("IproovScanPart", "retry triggered for state " + b11);
        int ordinal = b().ordinal();
        if (ordinal == 0) {
            ScanPart.sendScanStep$default(this, JumioScanStep.PREPARE, (Object) null, (Object) null, 6, (Object) null);
            e();
        } else if (ordinal == 3 || ordinal == 5) {
            ScanPart.sendScanStep$default(this, JumioScanStep.PREPARE, (Object) null, (Object) null, 6, (Object) null);
            a(d.TOKEN_REQUEST);
            getController().getBackendManager().requestIproovToken();
        } else if (ordinal == 6) {
            a("");
        }
    }

    public final void start() {
        super.start();
        ScanPart.sendScanStep$default(this, JumioScanStep.PREPARE, (Object) null, (Object) null, 6, (Object) null);
        e();
    }

    public final void a(d dVar) {
        ((FaceScanPartModel) getScanPartModel()).getData().put("state", dVar);
    }

    public final d b() {
        HashMap<String, Serializable> data = ((FaceScanPartModel) getScanPartModel()).getData();
        Serializable serializable = data.get("state");
        if (serializable == null) {
            serializable = d.UPFRONT_HELP;
            data.put("state", serializable);
        }
        return (d) serializable;
    }

    public final void a(JumioRetryReason jumioRetryReason) {
        a(d.RETRY_HELP);
        ScanPart.sendScanStep$default(this, JumioScanStep.RETRY, jumioRetryReason, (Object) null, 4, (Object) null);
    }

    public final void a(String str) {
        Log.i("IproovScanPart", "onIproovSuccess: " + str);
        a(d.VALIDATE);
        ScanPart.sendScanStep$default(this, JumioScanStep.PROCESSING, (Object) null, (Object) null, 6, (Object) null);
        if (!((ConsentModel) getController().getDataManager().get(ConsentModel.class)).isConsentSent()) {
            getController().getBackendManager().uploadPart(getCredential(), getScanPartModel());
        }
        getController().getBackendManager().validateIproovToken();
    }

    public final void onError(ApiCallDataModel<?> apiCallDataModel, Throwable th2) {
        Class<?> call = apiCallDataModel.getCall();
        boolean z11 = true;
        if (!(x.b(call, UploadCall.class) ? true : x.b(call, IproovTokenCall.class))) {
            z11 = x.b(call, IproovValidateCall.class);
        }
        if (z11) {
            getController().onError(th2, apiCallDataModel.getCall());
        }
    }

    public final IProov.Options a() {
        IProov.Options.Filter filter;
        IProov.Options options = r1;
        IProov.Options options2 = new IProov.Options((String) null, 0, 0, (IProov.Options.Filter) null, 0, (IProov.Options.Font) null, (IProov.Options.Icon) null, false, (IProov.Options.CloseButton) null, 0, 0, false, false, (List) null, 0, (IProov.Orientation) null, (IProov.Camera) null, (IProov.FaceDetector) null, (IProov.Options.GenuinePresenceAssurance) null, (IProov.Options.LivenessAssurance) null, 1048575, (r) null);
        IProov.Options options3 = options;
        options3.setEnableScreenshots(DeviceUtilKt.getDeviceUtil().isDebug(getController().getContext()));
        options3.setTitle("");
        boolean z11 = true;
        int i11 = -1;
        if (StringsKt__StringsJVMKt.w(this.f56411f.getProductType(), "iproov_premium", true)) {
            IProov.LineDrawingStyle lineDrawingStyle = IProov.LineDrawingStyle.VIBRANT;
            Integer num = this.f56413h.get(Integer.valueOf(R.attr.iproov_filterForegroundColor));
            int intValue = num != null ? num.intValue() : RoundedDrawable.DEFAULT_BORDER_COLOR;
            Integer num2 = this.f56413h.get(Integer.valueOf(R.attr.iproov_filterBackgroundColor));
            filter = new IProov.Options.Filter.LineDrawingFilter(lineDrawingStyle, intValue, num2 != null ? num2.intValue() : -1);
        } else {
            filter = new IProov.Options.Filter.NaturalFilter(IProov.NaturalStyle.CLEAR);
        }
        options3.setFilter(filter);
        Boolean bool = this.f56414i.get(Integer.valueOf(R.attr.iproov_promptRoundedCorners));
        if (bool != null) {
            z11 = bool.booleanValue();
        }
        options3.setPromptRoundedCorners(z11);
        Integer num3 = this.f56413h.get(Integer.valueOf(R.attr.iproov_promptTextColor));
        options3.setPromptTextColor(num3 != null ? num3.intValue() : -1);
        Integer num4 = this.f56413h.get(Integer.valueOf(R.attr.iproov_promptBackgroundColor));
        options3.setPromptBackgroundColor(num4 != null ? num4.intValue() : Color.parseColor("#66000000"));
        Integer num5 = this.f56413h.get(Integer.valueOf(R.attr.iproov_titleTextColor));
        options3.setTitleTextColor(num5 != null ? num5.intValue() : -1);
        IProov.Options.CloseButton closeButton = options3.getCloseButton();
        Integer num6 = this.f56413h.get(Integer.valueOf(R.attr.iproov_closeButton_colorTint));
        closeButton.setColorTint(num6 != null ? num6.intValue() : -1);
        Integer num7 = this.f56413h.get(Integer.valueOf(R.attr.iproov_surroundColor));
        options3.setSurroundColor(num7 != null ? num7.intValue() : Color.parseColor("#66000000"));
        IProov.Options.LivenessAssurance livenessAssurance = options3.getLivenessAssurance();
        Integer num8 = this.f56413h.get(Integer.valueOf(R.attr.iproov_livenessAssurance_ovalStrokeColor));
        livenessAssurance.setOvalStrokeColor(num8 != null ? num8.intValue() : -1);
        IProov.Options.LivenessAssurance livenessAssurance2 = options3.getLivenessAssurance();
        Integer num9 = this.f56413h.get(Integer.valueOf(R.attr.iproov_livenessAssurance_completedOvalStrokeColor));
        livenessAssurance2.setCompletedOvalStrokeColor(num9 != null ? num9.intValue() : Color.parseColor("#01AC41"));
        IProov.Options.GenuinePresenceAssurance genuinePresenceAssurance = options3.getGenuinePresenceAssurance();
        Integer num10 = this.f56413h.get(Integer.valueOf(R.attr.iproov_genuinePresenceAssurance_notReadyOvalStrokeColor));
        if (num10 != null) {
            i11 = num10.intValue();
        }
        genuinePresenceAssurance.setNotReadyOvalStrokeColor(i11);
        IProov.Options.GenuinePresenceAssurance genuinePresenceAssurance2 = options3.getGenuinePresenceAssurance();
        Integer num11 = this.f56413h.get(Integer.valueOf(R.attr.iproov_genuinePresenceAssurance_readyOvalStrokeColor));
        genuinePresenceAssurance2.setReadyOvalStrokeColor(num11 != null ? num11.intValue() : Color.parseColor("#01AC41"));
        return options3;
    }
}
