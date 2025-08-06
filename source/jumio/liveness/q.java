package jumio.liveness;

import com.jumio.analytics.Analytics;
import com.jumio.analytics.MetaInfo;
import com.jumio.analytics.MobileEvents;
import com.jumio.commons.log.Log;
import com.jumio.core.Controller;
import com.jumio.core.data.ScanMode;
import com.jumio.core.extraction.ExtractionClient;
import com.jumio.core.extraction.ExtractionUpdateInterface;
import com.jumio.core.interfaces.UsabilityInterface;
import com.jumio.core.models.ApiCallDataModel;
import com.jumio.core.models.LivenessScanPartModel;
import com.jumio.core.models.LivenessSettingsModel;
import com.jumio.core.overlay.Overlay;
import com.jumio.core.scanpart.FaceScanPart;
import com.jumio.sdk.credentials.JumioFaceCredential;
import com.jumio.sdk.enums.JumioFallbackReason;
import com.jumio.sdk.enums.JumioScanStep;
import com.jumio.sdk.enums.JumioScanUpdate;
import com.jumio.sdk.interfaces.JumioScanPartInterface;
import d10.p;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.internal.Lambda;
import kotlin.k;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n1;

public final class q extends FaceScanPart<LivenessScanPartModel> implements UsabilityInterface {

    /* renamed from: a  reason: collision with root package name */
    public final LivenessSettingsModel f56502a;

    /* renamed from: b  reason: collision with root package name */
    public n1 f56503b;

    @d(c = "com.jumio.liveness.scanpart.LivenessScanPart$enableTimeFallback$1", f = "LivenessScanPart.kt", l = {151}, m = "invokeSuspend")
    public static final class a extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f56504a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ q f56505b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(q qVar, c<? super a> cVar) {
            super(2, cVar);
            this.f56505b = qVar;
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new a(this.f56505b, cVar);
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((a) create((h0) obj, (c) obj2)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f56504a;
            if (i11 == 0) {
                k.b(obj);
                this.f56504a = 1;
                if (DelayKt.b(((long) this.f56505b.f56502a.getFallbackTimeInS()) * 1000, this) == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Analytics.Companion.add(MobileEvents.misc$default("livenessTimerFallback", (MetaInfo) null, 2, (Object) null));
            this.f56505b.fallback(JumioFallbackReason.NO_DETECTION);
            return Unit.f56620a;
        }
    }

    public static final class b extends Lambda implements d10.a<Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ q f56506a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ExtractionUpdateInterface<?> f56507b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(q qVar, ExtractionUpdateInterface<?> extractionUpdateInterface) {
            super(0);
            this.f56506a = qVar;
            this.f56507b = extractionUpdateInterface;
        }

        public final Object invoke() {
            Overlay a11 = this.f56506a.getOverlay();
            if (a11 != null) {
                a11.update(this.f56507b);
            }
            return Unit.f56620a;
        }
    }

    public q(Controller controller, JumioFaceCredential jumioFaceCredential, LivenessScanPartModel livenessScanPartModel, JumioScanPartInterface jumioScanPartInterface) {
        super(controller, jumioFaceCredential, livenessScanPartModel, jumioScanPartInterface);
        this.f56502a = (LivenessSettingsModel) controller.getDataManager().get(LivenessSettingsModel.class);
    }

    public final void fallback(JumioFallbackReason jumioFallbackReason) {
        if ((getHasFallback() || jumioFallbackReason == JumioFallbackReason.LOW_PERFORMANCE) && getScanView() != null) {
            a(false);
            super.fallback(jumioFallbackReason);
            ((LivenessScanPartModel) getScanPartModel()).setMode(ScanMode.FACE_MANUAL);
            initExtractionAndOverlay();
            sendUpdate(JumioScanUpdate.FALLBACK, jumioFallbackReason);
        }
    }

    public final boolean getEnableExtraction() {
        ExtractionClient extractionClient = getExtractionClient();
        if (extractionClient != null) {
            return extractionClient.getDataExtraction();
        }
        return false;
    }

    public final boolean getHasFallback() {
        return ((LivenessScanPartModel) getScanPartModel()).getMode() != ScanMode.FACE_MANUAL && this.f56502a.getUserFallbackAllowed();
    }

    public final String getMultipartNameForUsabilityResultKey(ApiCallDataModel<?> apiCallDataModel) {
        return ((LivenessScanPartModel) getScanPartModel()).getFileData().getFileName();
    }

    public final boolean getShouldEnableUsability() {
        return getSettingsModel().isInstantFeedbackEnabled() && getNumOfRetries() <= getSettingsModel().getAutomationMaxRetries();
    }

    public final void handleProcessing() {
        if (((LivenessScanPartModel) getScanPartModel()).getMode() == ScanMode.FACE_MANUAL) {
            super.handleProcessing();
        }
    }

    public final void isPresented(boolean z11) {
        super.isPresented(z11);
        a(z11);
    }

    public final void setEnableExtraction(boolean z11) {
        ExtractionClient extractionClient = getExtractionClient();
        if (extractionClient != null) {
            extractionClient.setDataExtraction(z11);
        }
        super.isPresented(z11);
        a(z11);
    }

    public final void a(boolean z11) {
        n1 n1Var = this.f56503b;
        if (n1Var != null) {
            n1.a.a(n1Var, (CancellationException) null, 1, (Object) null);
        }
        if (z11 && ((LivenessScanPartModel) getScanPartModel()).getScanStep() != JumioScanStep.PROCESSING) {
            int fallbackTimeInS = this.f56502a.getFallbackTimeInS();
            Log.d("LivenessScanPart", "Falling back in " + fallbackTimeInS + " secs");
            this.f56503b = i.d(getMainScope(), (CoroutineContext) null, (CoroutineStart) null, new a(this, (c<? super a>) null), 3, (Object) null);
        }
    }

    /* JADX WARNING: type inference failed for: r0v5, types: [com.jumio.core.util.FileData] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onResult(com.jumio.core.model.StaticModel r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.jumio.core.extraction.liveness.extraction.LivenessDataModel
            r1 = 0
            if (r0 == 0) goto L_0x0009
            r0 = r8
            com.jumio.core.extraction.liveness.extraction.LivenessDataModel r0 = (com.jumio.core.extraction.liveness.extraction.LivenessDataModel) r0
            goto L_0x000a
        L_0x0009:
            r0 = r1
        L_0x000a:
            if (r0 != 0) goto L_0x000d
            return
        L_0x000d:
            com.jumio.commons.camera.ImageData[] r0 = r0.getFrames()
            if (r0 == 0) goto L_0x0079
            int r2 = r0.length
            r3 = 0
            r4 = r3
        L_0x0016:
            if (r4 >= r2) goto L_0x0030
            r5 = r0[r4]
            boolean r6 = r5 instanceof com.jumio.liveness.image.LivenessImageData
            if (r6 == 0) goto L_0x0029
            r6 = r5
            com.jumio.liveness.image.LivenessImageData r6 = (com.jumio.liveness.image.LivenessImageData) r6
            boolean r6 = r6.getBestSelfie()
            if (r6 == 0) goto L_0x0029
            r6 = 1
            goto L_0x002a
        L_0x0029:
            r6 = r3
        L_0x002a:
            if (r6 == 0) goto L_0x002d
            goto L_0x0031
        L_0x002d:
            int r4 = r4 + 1
            goto L_0x0016
        L_0x0030:
            r5 = r1
        L_0x0031:
            if (r5 == 0) goto L_0x0079
            com.jumio.core.models.ScanPartModel r0 = r7.getScanPartModel()
            com.jumio.core.models.LivenessScanPartModel r0 = (com.jumio.core.models.LivenessScanPartModel) r0
            com.jumio.core.util.FileData r0 = r0.getFileData()
            boolean r2 = r0 instanceof com.jumio.commons.camera.ImageData
            if (r2 == 0) goto L_0x0044
            r1 = r0
            com.jumio.commons.camera.ImageData r1 = (com.jumio.commons.camera.ImageData) r1
        L_0x0044:
            if (r1 == 0) goto L_0x0079
            java.lang.String r0 = r5.getPath()
            r1.setPath(r0)
            java.lang.String r0 = r5.getMimeType()
            r1.setMimeType(r0)
            java.lang.String r0 = r5.getFileType()
            r1.setFileType(r0)
            com.jumio.commons.camera.Size r0 = r1.getSize()
            com.jumio.commons.camera.Size r2 = r5.getSize()
            int r2 = r2.getWidth()
            r0.setWidth(r2)
            com.jumio.commons.camera.Size r0 = r1.getSize()
            com.jumio.commons.camera.Size r1 = r5.getSize()
            int r1 = r1.getHeight()
            r0.setHeight(r1)
        L_0x0079:
            super.onResult((com.jumio.core.model.StaticModel) r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: jumio.liveness.q.onResult(com.jumio.core.model.StaticModel):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x00b3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onUpdate(com.jumio.core.extraction.ExtractionUpdateInterface<?> r9) {
        /*
            r8 = this;
            java.lang.Integer r0 = r9.getState()
            com.jumio.core.extraction.liveness.extraction.LivenessUpdateState r1 = com.jumio.core.extraction.liveness.extraction.LivenessUpdateState.INSTANCE
            int r2 = r1.getFaceRoiRect()
            r3 = 0
            r4 = 1
            if (r0 != 0) goto L_0x000f
            goto L_0x001a
        L_0x000f:
            int r5 = r0.intValue()
            if (r5 != r2) goto L_0x001a
            r8.a((boolean) r4)
            goto L_0x00b0
        L_0x001a:
            int r2 = r1.getCenterFace()
            r5 = 2
            r6 = 0
            if (r0 != 0) goto L_0x0023
            goto L_0x0030
        L_0x0023:
            int r7 = r0.intValue()
            if (r7 != r2) goto L_0x0030
            com.jumio.sdk.enums.JumioScanUpdate r0 = com.jumio.sdk.enums.JumioScanUpdate.CENTER_FACE
            com.jumio.core.scanpart.ScanPart.sendUpdateFiltered$default(r8, r0, r6, r5, r6)
            goto L_0x00b0
        L_0x0030:
            int r2 = com.jumio.core.extraction.ExtractionUpdateState.shotTaken
            if (r0 != 0) goto L_0x0035
            goto L_0x0044
        L_0x0035:
            int r7 = r0.intValue()
            if (r7 != r2) goto L_0x0044
            com.jumio.analytics.MetaInfo r0 = r9.getMetaInfo()
            r8.handleShotTaken(r0)
            goto L_0x00b0
        L_0x0044:
            int r2 = r1.getLevelEyesAndDevice()
            if (r0 != 0) goto L_0x004b
            goto L_0x0057
        L_0x004b:
            int r7 = r0.intValue()
            if (r7 != r2) goto L_0x0057
            com.jumio.sdk.enums.JumioScanUpdate r0 = com.jumio.sdk.enums.JumioScanUpdate.LEVEL_EYES_AND_DEVICE
            com.jumio.core.scanpart.ScanPart.sendUpdateFiltered$default(r8, r0, r6, r5, r6)
            goto L_0x00b0
        L_0x0057:
            int r2 = com.jumio.core.extraction.ExtractionUpdateState.holdStill
            if (r0 != 0) goto L_0x005c
            goto L_0x0068
        L_0x005c:
            int r7 = r0.intValue()
            if (r7 != r2) goto L_0x0068
            com.jumio.sdk.enums.JumioScanUpdate r0 = com.jumio.sdk.enums.JumioScanUpdate.HOLD_STILL
            com.jumio.core.scanpart.ScanPart.sendUpdateFiltered$default(r8, r0, r6, r5, r6)
            goto L_0x00b0
        L_0x0068:
            int r2 = r1.getFaceTooClose()
            if (r0 != 0) goto L_0x006f
            goto L_0x007b
        L_0x006f:
            int r7 = r0.intValue()
            if (r7 != r2) goto L_0x007b
            com.jumio.sdk.enums.JumioScanUpdate r0 = com.jumio.sdk.enums.JumioScanUpdate.FACE_TOO_CLOSE
            com.jumio.core.scanpart.ScanPart.sendUpdateFiltered$default(r8, r0, r6, r5, r6)
            goto L_0x00b0
        L_0x007b:
            int r2 = r1.getMoveFaceCloser()
            if (r0 != 0) goto L_0x0082
            goto L_0x008e
        L_0x0082:
            int r7 = r0.intValue()
            if (r7 != r2) goto L_0x008e
            com.jumio.sdk.enums.JumioScanUpdate r0 = com.jumio.sdk.enums.JumioScanUpdate.MOVE_FACE_CLOSER
            com.jumio.core.scanpart.ScanPart.sendUpdateFiltered$default(r8, r0, r6, r5, r6)
            goto L_0x00b0
        L_0x008e:
            int r1 = r1.getLivenessFinished()
            if (r0 != 0) goto L_0x0095
            goto L_0x00a2
        L_0x0095:
            int r2 = r0.intValue()
            if (r2 != r1) goto L_0x00a2
            super.handleProcessing()
            r8.a((boolean) r3)
            goto L_0x00b0
        L_0x00a2:
            int r1 = com.jumio.core.extraction.ExtractionUpdateState.fallbackRequired
            if (r0 != 0) goto L_0x00a7
            goto L_0x00b1
        L_0x00a7:
            int r0 = r0.intValue()
            if (r0 != r1) goto L_0x00b1
            r8.handleFallback(r9)
        L_0x00b0:
            r3 = r4
        L_0x00b1:
            if (r3 != 0) goto L_0x00b6
            super.onUpdate((com.jumio.core.extraction.ExtractionUpdateInterface<?>) r9)
        L_0x00b6:
            jumio.liveness.q$b r0 = new jumio.liveness.q$b
            r0.<init>(r8, r9)
            r8.runOnMain(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: jumio.liveness.q.onUpdate(com.jumio.core.extraction.ExtractionUpdateInterface):void");
    }
}
