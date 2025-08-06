package com.jumio.core.scanpart;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.ViewGroup;
import com.jumio.analytics.Analytics;
import com.jumio.analytics.MetaInfo;
import com.jumio.analytics.MobileEvents;
import com.jumio.commons.camera.CameraUtils;
import com.jumio.commons.camera.Frame;
import com.jumio.commons.camera.ImageData;
import com.jumio.commons.camera.PreviewProperties;
import com.jumio.commons.camera.Size;
import com.jumio.commons.log.Log;
import com.jumio.commons.log.LogLevel;
import com.jumio.core.Controller;
import com.jumio.core.R;
import com.jumio.core.data.ScanMode;
import com.jumio.core.enums.ErrorCase;
import com.jumio.core.environment.Environment;
import com.jumio.core.error.Error;
import com.jumio.core.extraction.ExtractionClient;
import com.jumio.core.extraction.ExtractionUpdateInterface;
import com.jumio.core.extraction.ExtractionUpdateState;
import com.jumio.core.interfaces.UsabilityInterface;
import com.jumio.core.model.InvokeOnUiThread;
import com.jumio.core.model.StaticModel;
import com.jumio.core.model.SubscriberWithUpdate;
import com.jumio.core.models.ApiCallDataModel;
import com.jumio.core.models.ScanPartModel;
import com.jumio.core.models.SettingsModel;
import com.jumio.core.models.automation.AutomationModel;
import com.jumio.core.network.ApiBinding;
import com.jumio.core.overlay.Overlay;
import com.jumio.core.plugins.ExtractionPlugin;
import com.jumio.core.util.DataDogHelper;
import com.jumio.core.util.DataPointsUtil;
import com.jumio.core.util.FileData;
import com.jumio.core.views.CameraScanView;
import com.jumio.sdk.credentials.JumioCredential;
import com.jumio.sdk.enums.JumioCameraFacing;
import com.jumio.sdk.enums.JumioCredentialPart;
import com.jumio.sdk.enums.JumioFallbackReason;
import com.jumio.sdk.enums.JumioScanMode;
import com.jumio.sdk.enums.JumioScanStep;
import com.jumio.sdk.enums.JumioScanUpdate;
import com.jumio.sdk.handler.JumioRejectHandler;
import com.jumio.sdk.interfaces.JumioScanPartInterface;
import com.jumio.sdk.retry.JumioRetryReason;
import com.jumio.sdk.views.JumioAnimationView;
import d10.p;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import jumio.core.c1;
import jumio.core.h2;
import jumio.core.i2;
import jumio.core.q;
import jumio.core.r;
import jumio.core.u1;
import jumio.core.w;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.d0;
import kotlin.l;

public abstract class JVisionScanPart<T extends ScanPartModel> extends u1<T> implements q, c1.a, h2, SubscriberWithUpdate<ExtractionUpdateInterface<?>, StaticModel>, ApiBinding {

    /* renamed from: i  reason: collision with root package name */
    public ExtractionPlugin f39471i;

    /* renamed from: j  reason: collision with root package name */
    public ExtractionClient f39472j;

    /* renamed from: k  reason: collision with root package name */
    public Overlay f39473k;

    /* renamed from: l  reason: collision with root package name */
    public int f39474l;

    /* renamed from: m  reason: collision with root package name */
    public int f39475m;

    /* renamed from: n  reason: collision with root package name */
    public int f39476n;

    /* renamed from: o  reason: collision with root package name */
    public r<?> f39477o;

    /* renamed from: p  reason: collision with root package name */
    public CameraScanView f39478p;

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f39479a;

        /* JADX WARNING: Can't wrap try/catch for region: R(22:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|(2:19|20)|21|23) */
        /* JADX WARNING: Can't wrap try/catch for region: R(23:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|23) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0034 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0046 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0050 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x005a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                com.jumio.core.data.ScanMode[] r0 = com.jumio.core.data.ScanMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.jumio.core.data.ScanMode r1 = com.jumio.core.data.ScanMode.PDF417     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.jumio.core.data.ScanMode r1 = com.jumio.core.data.ScanMode.DOCFINDER     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.jumio.core.data.ScanMode r1 = com.jumio.core.data.ScanMode.FACE_MANUAL     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.jumio.core.data.ScanMode r1 = com.jumio.core.data.ScanMode.FACE_IPROOV     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                com.jumio.core.data.ScanMode r1 = com.jumio.core.data.ScanMode.JUMIO_LIVENESS     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                com.jumio.core.data.ScanMode r1 = com.jumio.core.data.ScanMode.MANUAL     // Catch:{ NoSuchFieldError -> 0x003d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                com.jumio.core.data.ScanMode r1 = com.jumio.core.data.ScanMode.NFC     // Catch:{ NoSuchFieldError -> 0x0046 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0046 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0046 }
            L_0x0046:
                com.jumio.core.data.ScanMode r1 = com.jumio.core.data.ScanMode.DEVICE_RISK     // Catch:{ NoSuchFieldError -> 0x0050 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0050 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0050 }
            L_0x0050:
                com.jumio.core.data.ScanMode r1 = com.jumio.core.data.ScanMode.FILE     // Catch:{ NoSuchFieldError -> 0x005a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005a }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005a }
            L_0x005a:
                com.jumio.core.data.ScanMode r1 = com.jumio.core.data.ScanMode.WEB     // Catch:{ NoSuchFieldError -> 0x0064 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0064 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0064 }
            L_0x0064:
                f39479a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.scanpart.JVisionScanPart.a.<clinit>():void");
        }
    }

    public static final class b extends Lambda implements d10.a<Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ JVisionScanPart<T> f39480a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ImageData f39481b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(JVisionScanPart<T> jVisionScanPart, ImageData imageData) {
            super(0);
            this.f39480a = jVisionScanPart;
            this.f39481b = imageData;
        }

        public final Object invoke() {
            CameraScanView scanView = this.f39480a.getScanView();
            if (scanView != null) {
                scanView.fillImageData$jumio_core_release(this.f39481b);
            }
            return Unit.f56620a;
        }
    }

    public static final class c extends Lambda implements d10.a<Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Overlay f39482a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ExtractionUpdateInterface<?> f39483b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(Overlay overlay, ExtractionUpdateInterface<?> extractionUpdateInterface) {
            super(0);
            this.f39482a = overlay;
            this.f39483b = extractionUpdateInterface;
        }

        public final Object invoke() {
            this.f39482a.update(this.f39483b);
            return Unit.f56620a;
        }
    }

    public static final class d extends Lambda implements p<JumioCredentialPart, String, Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ JVisionScanPart<T> f39484a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ r<?> f39485b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(JVisionScanPart<T> jVisionScanPart, r<?> rVar) {
            super(2);
            this.f39484a = jVisionScanPart;
            this.f39485b = rVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            JumioCredentialPart jumioCredentialPart = (JumioCredentialPart) obj;
            Bitmap readBitmap$default = CameraUtils.readBitmap$default(CameraUtils.INSTANCE, (String) obj2, this.f39484a.getController().getAuthorizationModel().getSessionKey(), (BitmapFactory.Options) null, 4, (Object) null);
            if (readBitmap$default != null) {
                this.f39485b.addBitmap$jumio_core_release(jumioCredentialPart, readBitmap$default);
            }
            return Unit.f56620a;
        }
    }

    public JVisionScanPart(Controller controller, JumioCredential jumioCredential, List<? extends T> list, JumioScanPartInterface jumioScanPartInterface) {
        super(controller, jumioCredential, list, jumioScanPartInterface);
        Log.d("init called");
        f();
    }

    public static /* synthetic */ void handleShotTaken$default(JVisionScanPart jVisionScanPart, MetaInfo metaInfo, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 1) != 0) {
                metaInfo = null;
            }
            jVisionScanPart.handleShotTaken(metaInfo);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: handleShotTaken");
    }

    public void addChildren(ViewGroup viewGroup) {
        Overlay overlay = this.f39473k;
        if (overlay != null) {
            overlay.addViews(viewGroup);
        }
    }

    public void cameraAvailable() {
        if (getPreviewPaused()) {
            CameraScanView scanView = getScanView();
            if (scanView != null) {
                scanView.stopPreview$jumio_core_release(true);
                return;
            }
            return;
        }
        sendScanStep(JumioScanStep.STARTED, getScanPartModel().getCredentialPart(), getAnalyticsScanData());
    }

    public void cameraError(Throwable th2) {
        Log.printStackTrace(th2);
        onError(new Error(ErrorCase.NO_CAMERA_CONNECTION, 0, 0, 6, (kotlin.jvm.internal.r) null));
    }

    public void cancel() {
        super.cancel();
        ExtractionClient extractionClient = this.f39472j;
        if (extractionClient != null) {
            extractionClient.cancel();
        }
        getController().getBackendManager().cancelCall(true);
        h();
        reset();
        CameraScanView scanView = getScanView();
        if (scanView != null) {
            scanView.detach$jumio_core_release();
        }
        r<?> rVar = this.f39477o;
        if (rVar != null) {
            rVar.detach$jumio_core_release();
        }
        setPreviewPaused(false);
        System.gc();
        ExtractionClient extractionClient2 = this.f39472j;
        if (extractionClient2 != null) {
            extractionClient2.setDataExtraction(false);
            extractionClient2.unsubscribe(this);
            extractionClient2.destroy();
        }
    }

    public final void d() {
        ExtractionClient extractionClient = this.f39472j;
        if (extractionClient != null) {
            extractionClient.cancel();
            if (!extractionClient.isConfigured()) {
                onError(new Error(ErrorCase.OCR_LOADING_FAILED, 0, 0, 6, (kotlin.jvm.internal.r) null));
                return;
            }
            CameraScanView scanView = getScanView();
            if (scanView != null) {
                extractionClient.setPreviewProperties(scanView.getPreviewProperties$jumio_core_release());
                extractionClient.setExtractionArea(scanView.getPreviewProperties$jumio_core_release().getSurface().toRect());
            }
            extractionClient.reinit();
            extractionClient.setDataExtraction(true);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001e, code lost:
        r3 = r3.getSurface();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void e() {
        /*
            r5 = this;
            com.jumio.core.overlay.Overlay r0 = r5.f39473k
            if (r0 == 0) goto L_0x0053
            com.jumio.core.views.CameraScanView r1 = r5.getScanView()
            if (r1 != 0) goto L_0x000b
            goto L_0x0053
        L_0x000b:
            jumio.core.c1 r2 = r1.getDrawView$jumio_core_release()
            if (r2 == 0) goto L_0x0014
            r0.addViews(r2)
        L_0x0014:
            com.jumio.core.extraction.ExtractionClient r2 = r5.f39472j
            if (r2 == 0) goto L_0x003d
            com.jumio.commons.camera.PreviewProperties r3 = r2.getPreviewProperties()
            if (r3 == 0) goto L_0x0029
            com.jumio.commons.camera.Size r3 = r3.getSurface()
            if (r3 == 0) goto L_0x0029
            android.graphics.Rect r3 = r3.toRect()
            goto L_0x002a
        L_0x0029:
            r3 = 0
        L_0x002a:
            android.graphics.Rect r4 = r2.getExtractionArea()
            boolean r4 = r4.isEmpty()
            if (r4 != 0) goto L_0x003d
            if (r3 == 0) goto L_0x003d
            android.graphics.Rect r2 = r2.getExtractionArea()
            r0.calculate(r3, r2)
        L_0x003d:
            com.jumio.sdk.enums.JumioCameraFacing r2 = r1.getCameraFacing()
            com.jumio.sdk.enums.JumioCameraFacing r3 = com.jumio.sdk.enums.JumioCameraFacing.FRONT
            if (r2 != r3) goto L_0x0047
            r2 = 1
            goto L_0x0048
        L_0x0047:
            r2 = 0
        L_0x0048:
            r0.prepareDraw(r2)
            jumio.core.n1 r0 = new jumio.core.n1
            r0.<init>(r1)
            r5.runOnMain(r0)
        L_0x0053:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.scanpart.JVisionScanPart.e():void");
    }

    public final void f() {
        ExtractionPlugin extractionPlugin = getExtractionPlugin(getScanPartModel().getMode());
        if (extractionPlugin != null) {
            Overlay overlay = extractionPlugin.getOverlay(getController().getContext());
            overlay.setScanPart(getScanPartModel());
            this.f39473k = overlay;
            ExtractionClient extractionClient = extractionPlugin.getExtractionClient(getController().getContext());
            initExtractionClient(extractionClient);
            this.f39472j = extractionClient;
        } else {
            extractionPlugin = null;
        }
        this.f39471i = extractionPlugin;
    }

    public void feedFrame(Frame frame) {
        ExtractionClient extractionClient = this.f39472j;
        if (extractionClient != null) {
            extractionClient.feed(frame);
        }
    }

    public void fillCheckHandler(p<? super JumioCredentialPart, ? super String, Unit> pVar) {
        List scanPartModelList = getScanPartModelList();
        ArrayList<ScanPartModel> arrayList = new ArrayList<>();
        for (Object next : scanPartModelList) {
            AutomationModel automationModel = ((ScanPartModel) next).getAutomationModel();
            if ((automationModel != null ? automationModel.f39406a : null) == AutomationModel.a.REJECT) {
                arrayList.add(next);
            }
        }
        for (ScanPartModel scanPartModel : arrayList) {
            pVar.invoke(scanPartModel.getCredentialPart(), scanPartModel.getFileData().getPath());
        }
    }

    public void finish() {
        CameraScanView scanView = getScanView();
        if (scanView != null) {
            scanView.detach$jumio_core_release();
        }
        r<?> rVar = this.f39477o;
        if (rVar != null) {
            rVar.detach$jumio_core_release();
        }
        setPreviewPaused(false);
        System.gc();
        ExtractionClient extractionClient = this.f39472j;
        if (extractionClient != null) {
            extractionClient.setDataExtraction(false);
            extractionClient.unsubscribe(this);
            extractionClient.destroy();
        }
        super.finish();
    }

    public final void g() {
        String str;
        i2 i2Var;
        String str2;
        i2 i2Var2;
        List scanPartModelList = getScanPartModelList();
        ArrayList arrayList = new ArrayList();
        Iterator it2 = scanPartModelList.iterator();
        while (true) {
            boolean z11 = true;
            AutomationModel.a aVar = null;
            if (!it2.hasNext()) {
                break;
            }
            Object next = it2.next();
            AutomationModel automationModel = ((ScanPartModel) next).getAutomationModel();
            if (automationModel != null) {
                aVar = automationModel.f39406a;
            }
            if (aVar != AutomationModel.a.REJECT) {
                z11 = false;
            }
            if (z11) {
                arrayList.add(next);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.d(MapsKt__MapsJVMKt.d(CollectionsKt__IterablesKt.u(arrayList, 10)), 16));
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            ScanPartModel scanPartModel = (ScanPartModel) it3.next();
            JumioCredentialPart credentialPart = scanPartModel.getCredentialPart();
            AutomationModel automationModel2 = scanPartModel.getAutomationModel();
            if (automationModel2 == null || (i2Var2 = automationModel2.f39407b) == null) {
                str2 = null;
            } else {
                str2 = i2Var2.f56224g.isEmpty() ? i2Var2.f56222e : i2Var2.f56224g.get(0).f56228b;
            }
            Pair a11 = l.a(credentialPart, str2);
            linkedHashMap.put(a11.getFirst(), a11.getSecond());
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(RangesKt___RangesKt.d(MapsKt__MapsJVMKt.d(CollectionsKt__IterablesKt.u(arrayList, 10)), 16));
        Iterator it4 = arrayList.iterator();
        while (it4.hasNext()) {
            ScanPartModel scanPartModel2 = (ScanPartModel) it4.next();
            String name = scanPartModel2.getCredentialPart().name();
            AutomationModel automationModel3 = scanPartModel2.getAutomationModel();
            if (automationModel3 == null || (i2Var = automationModel3.f39407b) == null) {
                str = null;
            } else {
                str = i2Var.f56224g.isEmpty() ? i2Var.f56222e : i2Var.f56224g.get(0).f56228b;
            }
            Pair a12 = l.a(name, str);
            linkedHashMap2.put(a12.getFirst(), a12.getSecond());
        }
        if (!linkedHashMap.isEmpty()) {
            sendScanStep(JumioScanStep.REJECT_VIEW, linkedHashMap, linkedHashMap2);
        } else if (this instanceof w) {
            ((w) this).c();
            ScanPart.sendScanStep$default(this, JumioScanStep.CONFIRMATION_VIEW, (Object) null, (Object) null, 6, (Object) null);
        } else {
            setComplete(true);
            ScanPart.sendScanStep$default(this, JumioScanStep.CAN_FINISH, (Object) null, (Object) null, 6, (Object) null);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.lang.Class<? extends com.jumio.core.network.ApiCall<?>>[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Class<? extends com.jumio.core.network.ApiCall<?>>[] getBindingClasses() {
        /*
            r3 = this;
            r0 = 2
            java.lang.Class[] r0 = new java.lang.Class[r0]
            r1 = 0
            java.lang.Class<com.jumio.core.api.calls.UploadCall> r2 = com.jumio.core.api.calls.UploadCall.class
            r0[r1] = r2
            r1 = 1
            java.lang.Class<com.jumio.core.api.calls.UsabilityCall> r2 = com.jumio.core.api.calls.UsabilityCall.class
            r0[r1] = r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.scanpart.JVisionScanPart.getBindingClasses():java.lang.Class[]");
    }

    public boolean getEnableExtraction() {
        ExtractionClient extractionClient = this.f39472j;
        if (extractionClient != null) {
            return extractionClient.getDataExtraction();
        }
        return false;
    }

    public boolean getExtraction() {
        ExtractionClient extractionClient = this.f39472j;
        return extractionClient != null && extractionClient.getDataExtraction();
    }

    public final ExtractionClient getExtractionClient() {
        return this.f39472j;
    }

    public ExtractionPlugin getExtractionPlugin(ScanMode scanMode) {
        return (ExtractionPlugin) getController().getPluginRegistry().a(getScanPluginMode(scanMode));
    }

    public boolean getHasFallback() {
        return false;
    }

    public void getHelpAnimation(JumioAnimationView jumioAnimationView) {
    }

    public final r<?> getInternalCheckHandler() {
        return this.f39477o;
    }

    public final int getNumOfRetries() {
        return this.f39476n;
    }

    public final Overlay getOverlay() {
        return this.f39473k;
    }

    public final ExtractionPlugin getPlugin() {
        return this.f39471i;
    }

    public int getPreferredBrandTextColor() {
        return R.color.jumio_white_alpha50;
    }

    public final boolean getPreviewPaused() {
        HashMap<String, Serializable> modelData = getModelData();
        Serializable serializable = modelData.get("previewPaused");
        if (serializable == null) {
            serializable = Boolean.FALSE;
            modelData.put("previewPaused", serializable);
        }
        return ((Boolean) serializable).booleanValue();
    }

    public Size getPreviewSize() {
        ExtractionClient extractionClient = this.f39472j;
        if (extractionClient != null) {
            return extractionClient.getPreferredPreviewSize();
        }
        return null;
    }

    public JumioScanMode getScanMode() {
        switch (a.f39479a[getScanPartModel().getMode().ordinal()]) {
            case 1:
                return JumioScanMode.BARCODE;
            case 2:
                return JumioScanMode.DOCFINDER;
            case 3:
                return JumioScanMode.FACE_MANUAL;
            case 4:
                return JumioScanMode.FACE_IPROOV;
            case 5:
                return JumioScanMode.JUMIO_LIVENESS;
            case 6:
                return JumioScanMode.MANUAL;
            case 7:
                return JumioScanMode.NFC;
            case 8:
                return JumioScanMode.DEVICE_RISK;
            case 9:
                return JumioScanMode.FILE;
            case 10:
                return JumioScanMode.WEB;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public CameraScanView getScanView() {
        return this.f39478p;
    }

    public final SettingsModel getSettingsModel() {
        return (SettingsModel) getController().getDataManager().get(SettingsModel.class);
    }

    public boolean getShowShutterButton() {
        ExtractionClient extractionClient = this.f39472j;
        if (extractionClient != null) {
            return extractionClient.takePictureManually();
        }
        return false;
    }

    public JumioCameraFacing[] getSupportedFacing() {
        return new JumioCameraFacing[]{JumioCameraFacing.BACK, JumioCameraFacing.FRONT};
    }

    public final int getViewHeight() {
        return this.f39475m;
    }

    public final int getViewWidth() {
        return this.f39474l;
    }

    public final void h() {
        ExtractionClient.FramePerformance framePerformance;
        ExtractionClient extractionClient = this.f39472j;
        if (extractionClient != null && (framePerformance = extractionClient.getFramePerformance()) != null) {
            MetaInfo metaInfo = new MetaInfo();
            metaInfo.put("frameRate", MapsKt__MapsJVMKt.e(l.a("mean", Double.valueOf(framePerformance.getMean()))));
            Analytics.Companion.add(MobileEvents.performance("ExtractionClient", metaInfo));
            DataDogHelper.INSTANCE.reportCustomAction(extractionClient.getClass().getSimpleName(), MapsKt__MapsJVMKt.e(l.a("frameRate", framePerformance.getAsMap())));
        }
    }

    public final void handleFallback(ExtractionUpdateInterface<?> extractionUpdateInterface) {
        h();
        Object data = extractionUpdateInterface.getData();
        JumioFallbackReason jumioFallbackReason = data instanceof JumioFallbackReason ? (JumioFallbackReason) data : null;
        if (jumioFallbackReason == null) {
            jumioFallbackReason = JumioFallbackReason.LOW_PERFORMANCE;
        }
        fallback(jumioFallbackReason);
    }

    public void handleProcessing() {
        if (!getHasNextPart()) {
            CameraScanView scanView = getScanView();
            if (scanView != null) {
                scanView.stopPreview$jumio_core_release(true);
            }
            setPreviewPaused(true);
            ScanPart.sendScanStep$default(this, JumioScanStep.PROCESSING, (Object) null, (Object) null, 6, (Object) null);
        }
    }

    public final void handleShotTaken(MetaInfo metaInfo) {
        FileData fileData = getScanPartModel().getFileData();
        ImageData imageData = fileData instanceof ImageData ? (ImageData) fileData : null;
        if (imageData != null) {
            runOnMain(new b(this, imageData));
        }
        MetaInfo analyticsScanData = getAnalyticsScanData();
        if (metaInfo != null) {
            analyticsScanData.putAll(metaInfo);
        }
        ScanPart.sendScanStep$default(this, JumioScanStep.IMAGE_TAKEN, (Object) null, analyticsScanData, 2, (Object) null);
        vibrate(100);
        handleProcessing();
        h();
    }

    public final void initExtractionAndOverlay() {
        ExtractionClient extractionClient = this.f39472j;
        if (extractionClient != null) {
            extractionClient.setDataExtraction(false);
            extractionClient.unsubscribe(this);
            extractionClient.destroy();
        }
        Overlay overlay = this.f39473k;
        if (overlay != null) {
            overlay.setVisible(8);
        }
        f();
        d();
        e();
        Overlay overlay2 = this.f39473k;
        if (overlay2 != null) {
            overlay2.setVisible(0);
        }
        CameraScanView scanView = getScanView();
        if (scanView != null) {
            scanView.update$jumio_core_release(false);
        }
    }

    public void initExtractionClient(ExtractionClient extractionClient) {
        extractionClient.subscribe(this);
        extractionClient.configure(getController().getDataManager(), getScanPartModel());
    }

    public boolean isBrandingEnabled() {
        return getSettingsModel().isBrandingEnabled();
    }

    public boolean isCancelable() {
        return true;
    }

    public void isPresented(boolean z11) {
    }

    public boolean isSupportedCheckHandler(r<?> rVar) {
        return rVar instanceof JumioRejectHandler;
    }

    public void onDrawViewDraw(Canvas canvas) {
        Overlay overlay = this.f39473k;
        if (overlay != null) {
            overlay.doDraw(canvas);
        }
    }

    public void onDrawViewMeasure(int i11, int i12) {
        this.f39474l = i11;
        this.f39475m = i12;
        e();
    }

    @InvokeOnUiThread(true)
    public void onError(Throwable th2) {
        ExtractionClient extractionClient = this.f39472j;
        if (extractionClient != null) {
            extractionClient.cancel();
        }
        CameraScanView scanView = getScanView();
        if (scanView != null) {
            scanView.stopPreview$jumio_core_release(true);
        }
        setPreviewPaused(true);
        Controller.onError$default(getController(), th2, (Class) null, 2, (Object) null);
    }

    public void onPreviewAvailable(PreviewProperties previewProperties) {
        ScanPart.sendUpdate$default(this, JumioScanUpdate.CAMERA_AVAILABLE, (Object) null, 2, (Object) null);
        d();
        e();
    }

    public void reject() {
        if (this.f39477o != null) {
            DataPointsUtil.INSTANCE.increment(getController().getContext(), DataPointsUtil.NUMBER_OF_RETAKES);
            this.f39476n++;
            retryScanParts();
            initExtractionAndOverlay();
            setPreviewPaused(false);
            ScanPart.sendScanStep$default(this, JumioScanStep.SCAN_VIEW, (Object) null, (Object) null, 6, (Object) null);
            Overlay overlay = this.f39473k;
            if (overlay != null) {
                overlay.setVisible(0);
            }
            r<?> rVar = this.f39477o;
            if (rVar != null) {
                rVar.detach$jumio_core_release();
            }
            this.f39477o = null;
        }
    }

    public void restore() {
        super.restore();
        if (getScanPartModel().getScanStep() == JumioScanStep.IMAGE_TAKEN) {
            getScanPartModel().setScanStep(JumioScanStep.SCAN_VIEW);
            setPreviewPaused(false);
        } else if (getScanPartModel().getScanStep() == JumioScanStep.CAN_FINISH) {
            setComplete(true);
        }
    }

    public void retry(JumioRetryReason jumioRetryReason) {
        super.retry(jumioRetryReason);
        reset();
        d();
        e();
        ScanPart.sendScanStep$default(this, JumioScanStep.SCAN_VIEW, (Object) null, (Object) null, 6, (Object) null);
        Overlay overlay = this.f39473k;
        if (overlay != null) {
            overlay.setVisible(0);
        }
    }

    public void retryScanParts() {
        getReportingModel().a(getScanPartModel().getCredentialPart(), getCredential().getData$jumio_core_release().f56143a);
        List scanPartModelList = getScanPartModelList();
        ArrayList<ScanPartModel> arrayList = new ArrayList<>();
        Iterator it2 = scanPartModelList.iterator();
        while (true) {
            AutomationModel.a aVar = null;
            if (!it2.hasNext()) {
                break;
            }
            Object next = it2.next();
            AutomationModel automationModel = ((ScanPartModel) next).getAutomationModel();
            if (automationModel != null) {
                aVar = automationModel.f39406a;
            }
            if (aVar == AutomationModel.a.REJECT) {
                arrayList.add(next);
            }
        }
        for (ScanPartModel scanPartModel : arrayList) {
            scanPartModel.getFileData().clear();
            scanPartModel.setAutomationModel((AutomationModel) null);
        }
        setScanPartModel((ScanPartModel) CollectionsKt___CollectionsKt.a0(arrayList));
        getReportingModel().b(getScanPartModel().getCredentialPart(), getCredential().getData$jumio_core_release().f56143a);
    }

    public void setCheckHandler(r<?> rVar) {
        if (rVar.isValidForScanStep$jumio_core_release(getScanPartModel().getScanStep()) || !isSupportedCheckHandler(rVar)) {
            r<?> rVar2 = this.f39477o;
            if (rVar2 != rVar) {
                if (rVar2 != null) {
                    rVar2.detach$jumio_core_release();
                }
                this.f39477o = rVar;
            }
            fillCheckHandler(new d(this, rVar));
        }
    }

    public void setEnableExtraction(boolean z11) {
        ExtractionClient extractionClient = this.f39472j;
        if (extractionClient != null) {
            extractionClient.setDataExtraction(z11);
        }
        if (!z11) {
            onUpdate((ExtractionUpdateInterface<?>) ExtractionUpdateInterface.Companion.build$default(ExtractionUpdateInterface.Companion, ExtractionUpdateState.resetOverlay, (Object) null, (MetaInfo) null, 4, (Object) null));
        }
    }

    public final void setExtractionClient(ExtractionClient extractionClient) {
        this.f39472j = extractionClient;
    }

    public final void setInternalCheckHandler(r<?> rVar) {
        this.f39477o = rVar;
    }

    public final void setNumOfRetries(int i11) {
        this.f39476n = i11;
    }

    public final void setOverlay(Overlay overlay) {
        this.f39473k = overlay;
    }

    public final void setPlugin(ExtractionPlugin extractionPlugin) {
        this.f39471i = extractionPlugin;
    }

    public final void setPreviewPaused(boolean z11) {
        getModelData().put("previewPaused", Boolean.valueOf(z11));
    }

    public void setScanView(CameraScanView cameraScanView) {
        if (cameraScanView != null) {
            CameraScanView cameraScanView2 = this.f39478p;
            cameraScanView.setCameraManager$jumio_core_release(cameraScanView2 != null ? cameraScanView2.getCameraManager$jumio_core_release() : null);
        }
        this.f39478p = cameraScanView;
    }

    public final void setViewHeight(int i11) {
        this.f39475m = i11;
    }

    public final void setViewWidth(int i11) {
        this.f39474l = i11;
    }

    public void start() {
        super.start();
        setPreviewPaused(false);
        ScanPart.sendScanStep$default(this, JumioScanStep.SCAN_VIEW, (Object) null, (Object) null, 6, (Object) null);
        Overlay overlay = this.f39473k;
        if (overlay != null) {
            overlay.setVisible(0);
        }
    }

    public void takePicture() {
        ExtractionClient extractionClient;
        ExtractionClient extractionClient2 = this.f39472j;
        boolean z11 = true;
        if (extractionClient2 == null || !extractionClient2.takePictureManually()) {
            z11 = false;
        }
        if (z11 && (extractionClient = this.f39472j) != null) {
            extractionClient.takePicture();
        }
    }

    @SuppressLint({"MissingPermission"})
    public final void vibrate(long j11) {
        try {
            Vibrator vibrator = (Vibrator) getController().getContext().getSystemService("vibrator");
            if (Build.VERSION.SDK_INT >= 26) {
                vibrator.vibrate(VibrationEffect.createOneShot(j11, -1));
            } else {
                vibrator.vibrate(j11);
            }
        } catch (Exception unused) {
        }
    }

    public void onResult(StaticModel staticModel) {
        if (this instanceof UsabilityInterface) {
            getScanPartModel().setUsability(((UsabilityInterface) this).getShouldEnableUsability());
        }
        getController().getBackendManager().uploadPart(getCredential(), getScanPartModel());
        if (getHasNextPart()) {
            switchToNextPart();
            initExtractionAndOverlay();
            sendScanStep(JumioScanStep.NEXT_PART, getScanPartModel().getCredentialPart(), getAnalyticsScanData());
            getScanPartModel().setScanStep(JumioScanStep.STARTED);
            return;
        }
        CameraScanView scanView = getScanView();
        if (scanView != null) {
            scanView.stopPreview$jumio_core_release(true);
        }
        setPreviewPaused(true);
        ExtractionClient extractionClient = this.f39472j;
        if (extractionClient != null) {
            extractionClient.cancel();
        }
    }

    public void onUpdate(ExtractionUpdateInterface<?> extractionUpdateInterface) {
        Integer state = extractionUpdateInterface.getState();
        int i11 = ExtractionUpdateState.shotTaken;
        if (state != null && state.intValue() == i11) {
            handleShotTaken$default(this, (MetaInfo) null, 1, (Object) null);
            return;
        }
        int i12 = ExtractionUpdateState.saveImage;
        if (state != null && state.intValue() == i12) {
            Bitmap bitmap = (Bitmap) extractionUpdateInterface.getData();
            Log log = Log.INSTANCE;
            LogLevel logLevel = LogLevel.OFF;
            File dataDirectory = Environment.INSTANCE.getDataDirectory(getController().getContext());
            d0 d0Var = d0.f56774a;
            File file = new File(dataDirectory, String.format(Locale.ENGLISH, "tmp_%d", Arrays.copyOf(new Object[]{Long.valueOf(System.currentTimeMillis())}, 1)));
            if (!bitmap.isRecycled()) {
                CameraUtils.INSTANCE.saveBitmap(bitmap, file, Bitmap.CompressFormat.WEBP, 85, getController().getAuthorizationModel().getSessionKey());
            }
            FileData fileData = getScanPartModel().getFileData();
            fileData.setPath(file.getAbsolutePath());
            fileData.setMimeType("image/webp");
            fileData.setFileType("WEBP");
            if (fileData instanceof ImageData) {
                ImageData imageData = (ImageData) fileData;
                imageData.getSize().setWidth(bitmap.getWidth());
                imageData.getSize().setHeight(bitmap.getHeight());
                return;
            }
            return;
        }
        int i13 = ExtractionUpdateState.centerId;
        if (state != null && state.intValue() == i13) {
            ScanPart.sendUpdateFiltered$default(this, JumioScanUpdate.CENTER_ID, (Object) null, 2, (Object) null);
            return;
        }
        int i14 = ExtractionUpdateState.moveCloser;
        if (state != null && state.intValue() == i14) {
            ScanPart.sendUpdateFiltered$default(this, JumioScanUpdate.MOVE_CLOSER, (Object) null, 2, (Object) null);
            return;
        }
        int i15 = ExtractionUpdateState.tooClose;
        if (state != null && state.intValue() == i15) {
            ScanPart.sendUpdateFiltered$default(this, JumioScanUpdate.TOO_CLOSE, (Object) null, 2, (Object) null);
            return;
        }
        int i16 = ExtractionUpdateState.holdStraight;
        if (state != null && state.intValue() == i16) {
            ScanPart.sendUpdateFiltered$default(this, JumioScanUpdate.HOLD_STRAIGHT, (Object) null, 2, (Object) null);
            return;
        }
        int i17 = ExtractionUpdateState.holdStill;
        if (state != null && state.intValue() == i17) {
            ScanPart.sendUpdateFiltered$default(this, JumioScanUpdate.HOLD_STILL, (Object) null, 2, (Object) null);
            return;
        }
        int i18 = ExtractionUpdateState.fallbackRequired;
        if (state != null && state.intValue() == i18) {
            handleFallback(extractionUpdateInterface);
            return;
        }
        Overlay overlay = this.f39473k;
        if (overlay != null) {
            runOnMain(new c(overlay, extractionUpdateInterface));
            CameraScanView scanView = getScanView();
            if (scanView != null) {
                scanView.update$jumio_core_release(false);
            }
        }
    }

    public void onError(ApiCallDataModel<?> apiCallDataModel, Throwable th2) {
        if (getAllPartsHaveImages()) {
            getController().onError(th2, apiCallDataModel.getCall());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0055, code lost:
        if ((r3.length() > 0) == true) goto L_0x0059;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onResult(com.jumio.core.models.ApiCallDataModel<?> r5, java.lang.Object r6) {
        /*
            r4 = this;
            java.lang.Class r0 = r5.getCall()
            java.lang.Class<com.jumio.core.api.calls.UploadCall> r1 = com.jumio.core.api.calls.UploadCall.class
            boolean r1 = kotlin.jvm.internal.x.b(r0, r1)
            if (r1 == 0) goto L_0x0088
            java.lang.String r0 = r5.getScanPartId()
            int r0 = r0.length()
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x001a
            r0 = r1
            goto L_0x001b
        L_0x001a:
            r0 = r2
        L_0x001b:
            if (r0 == 0) goto L_0x001e
            return
        L_0x001e:
            boolean r0 = r4 instanceof com.jumio.core.interfaces.UsabilityInterface
            r3 = 0
            if (r0 == 0) goto L_0x0040
            boolean r0 = r6 instanceof org.json.JSONObject
            if (r0 == 0) goto L_0x002a
            org.json.JSONObject r6 = (org.json.JSONObject) r6
            goto L_0x002b
        L_0x002a:
            r6 = r3
        L_0x002b:
            if (r6 == 0) goto L_0x0040
            java.lang.String r0 = "usabilityResultKeys"
            org.json.JSONObject r6 = r6.optJSONObject(r0)
            if (r6 == 0) goto L_0x0040
            r0 = r4
            com.jumio.core.interfaces.UsabilityInterface r0 = (com.jumio.core.interfaces.UsabilityInterface) r0
            java.lang.String r0 = r0.getMultipartNameForUsabilityResultKey(r5)
            java.lang.String r3 = r6.optString(r0)
        L_0x0040:
            com.jumio.core.models.SettingsModel r6 = r4.getSettingsModel()
            boolean r6 = r6.isInstantFeedbackEnabled()
            if (r6 == 0) goto L_0x006b
            if (r3 == 0) goto L_0x0058
            int r6 = r3.length()
            if (r6 <= 0) goto L_0x0054
            r6 = r1
            goto L_0x0055
        L_0x0054:
            r6 = r2
        L_0x0055:
            if (r6 != r1) goto L_0x0058
            goto L_0x0059
        L_0x0058:
            r1 = r2
        L_0x0059:
            if (r1 == 0) goto L_0x006b
            com.jumio.core.Controller r6 = r4.getController()
            com.jumio.core.api.BackendManager r6 = r6.getBackendManager()
            java.lang.String r5 = r5.getScanPartId()
            r6.usability(r3, r5)
            goto L_0x00a9
        L_0x006b:
            java.lang.String r5 = r5.getScanPartId()
            com.jumio.core.models.ScanPartModel r5 = r4.getPartForId(r5)
            if (r5 != 0) goto L_0x0076
            goto L_0x007e
        L_0x0076:
            com.jumio.core.models.automation.AutomationModel r6 = new com.jumio.core.models.automation.AutomationModel
            r6.<init>(r2)
            r5.setAutomationModel(r6)
        L_0x007e:
            boolean r5 = r4.getAllPartsComplete()
            if (r5 == 0) goto L_0x00a9
            r4.g()
            goto L_0x00a9
        L_0x0088:
            java.lang.Class<com.jumio.core.api.calls.UsabilityCall> r1 = com.jumio.core.api.calls.UsabilityCall.class
            boolean r0 = kotlin.jvm.internal.x.b(r0, r1)
            if (r0 == 0) goto L_0x00a9
            java.lang.String r5 = r5.getScanPartId()
            com.jumio.core.models.ScanPartModel r5 = r4.getPartForId(r5)
            if (r5 != 0) goto L_0x009b
            goto L_0x00a0
        L_0x009b:
            com.jumio.core.models.automation.AutomationModel r6 = (com.jumio.core.models.automation.AutomationModel) r6
            r5.setAutomationModel(r6)
        L_0x00a0:
            boolean r5 = r4.getAllPartsComplete()
            if (r5 == 0) goto L_0x00a9
            r4.g()
        L_0x00a9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.scanpart.JVisionScanPart.onResult(com.jumio.core.models.ApiCallDataModel, java.lang.Object):void");
    }
}
