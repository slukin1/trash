package jumio.core;

import android.graphics.pdf.PdfRenderer;
import android.os.ParcelFileDescriptor;
import android.system.Os;
import com.jumio.commons.log.Log;
import com.jumio.commons.utils.FileUtil;
import com.jumio.core.Controller;
import com.jumio.core.R;
import com.jumio.core.api.calls.UploadCall;
import com.jumio.core.environment.Environment;
import com.jumio.core.models.ApiCallDataModel;
import com.jumio.core.models.SettingsModel;
import com.jumio.core.network.ApiBinding;
import com.jumio.core.scanpart.ScanPart;
import com.jumio.core.util.ByteArrayUtilKt;
import com.jumio.core.util.DataPointsUtil;
import com.jumio.sdk.credentials.JumioDocumentCredential;
import com.jumio.sdk.enums.JumioScanMode;
import com.jumio.sdk.enums.JumioScanStep;
import com.jumio.sdk.handler.JumioConfirmationHandler;
import com.jumio.sdk.interfaces.JumioScanPartInterface;
import com.jumio.sdk.retry.JumioRetryReason;
import com.jumio.sdk.views.JumioAnimationView;
import com.jumio.sdk.views.JumioFileAttacher;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.x;

public final class k1 extends ScanPart<z0> implements h2, w, ApiBinding, j1 {

    /* renamed from: h  reason: collision with root package name */
    public final byte[] f56233h = ByteArrayUtilKt.byteArrayOfInts(47, 69, 110, 99, 114, 121, 112, 116);

    /* renamed from: i  reason: collision with root package name */
    public r<?> f56234i;

    /* renamed from: j  reason: collision with root package name */
    public final boolean f56235j = true;

    /* renamed from: k  reason: collision with root package name */
    public final JumioScanMode f56236k = JumioScanMode.FILE;

    /* renamed from: l  reason: collision with root package name */
    public PdfRenderer f56237l;

    /* renamed from: m  reason: collision with root package name */
    public final JumioFileAttacher.JumioFileRequirements f56238m;

    public k1(Controller controller, JumioDocumentCredential jumioDocumentCredential, z0 z0Var, JumioScanPartInterface jumioScanPartInterface) {
        super(controller, jumioDocumentCredential, z0Var, jumioScanPartInterface);
        this.f56238m = new JumioFileAttacher.JumioFileRequirements(CollectionsKt__CollectionsJVMKt.e("application/pdf"), ((SettingsModel) controller.getDataManager().get(SettingsModel.class)).getMaxFileUploadSize(), z0Var.a().getMaxPages());
    }

    public final void a(File file) {
        if (!file.exists() || !file.isFile() || !file.canRead()) {
            ScanPart.sendScanStep$default(this, JumioScanStep.RETRY, new JumioRetryReason(401, getController().getContext().getString(R.string.jumio_dv_retry_not_readable)), (Object) null, 4, (Object) null);
            return;
        }
        c(ParcelFileDescriptor.open(file, 268435456));
    }

    public final JumioFileAttacher.JumioFileRequirements b() {
        return this.f56238m;
    }

    public final void c() {
    }

    public final void c(ParcelFileDescriptor parcelFileDescriptor) {
        int i11;
        try {
            d();
            if (b(parcelFileDescriptor) > ((long) ((SettingsModel) getController().getDataManager().get(SettingsModel.class)).getMaxFileUploadSize())) {
                ScanPart.sendScanStep$default(this, JumioScanStep.RETRY, new JumioRetryReason(404, getController().getContext().getString(R.string.jumio_dv_retry_size_limit)), (Object) null, 4, (Object) null);
                return;
            }
            this.f56237l = new PdfRenderer(parcelFileDescriptor);
            int maxPages = ((z0) getScanPartModel()).f56351k.getMaxPages();
            PdfRenderer pdfRenderer = this.f56237l;
            if (pdfRenderer != null) {
                i11 = pdfRenderer.getPageCount();
            } else {
                i11 = ((z0) getScanPartModel()).f56351k.getMaxPages();
            }
            if (maxPages < i11) {
                ScanPart.sendScanStep$default(this, JumioScanStep.RETRY, new JumioRetryReason(403, getController().getContext().getString(R.string.jumio_dv_retry_page_limit)), (Object) null, 4, (Object) null);
                return;
            }
            d(parcelFileDescriptor);
            ScanPart.sendScanStep$default(this, JumioScanStep.CONFIRMATION_VIEW, (Object) null, (Object) null, 6, (Object) null);
        } catch (SecurityException unused) {
            d();
            ScanPart.sendScanStep$default(this, JumioScanStep.RETRY, new JumioRetryReason(402, getController().getContext().getString(R.string.jumio_dv_retry_encrypted)), (Object) null, 4, (Object) null);
        } catch (Exception unused2) {
            d();
            ScanPart.sendScanStep$default(this, JumioScanStep.RETRY, new JumioRetryReason(401, getController().getContext().getString(R.string.jumio_dv_retry_not_readable)), (Object) null, 4, (Object) null);
        }
    }

    public final void cancel() {
        super.cancel();
        reset();
        d();
    }

    public final void d() {
        r<?> rVar = this.f56234i;
        if (rVar != null) {
            rVar.detach$jumio_core_release();
        }
        try {
            PdfRenderer pdfRenderer = this.f56237l;
            if (pdfRenderer != null) {
                pdfRenderer.close();
            }
        } catch (Exception e11) {
            Log.printStackTrace(e11);
        }
        this.f56237l = null;
    }

    public final void finish() {
        d();
        super.finish();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.lang.Class<? extends com.jumio.core.network.ApiCall<?>>[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Class<? extends com.jumio.core.network.ApiCall<?>>[] getBindingClasses() {
        /*
            r3 = this;
            r0 = 1
            java.lang.Class[] r0 = new java.lang.Class[r0]
            r1 = 0
            java.lang.Class<com.jumio.core.api.calls.UploadCall> r2 = com.jumio.core.api.calls.UploadCall.class
            r0[r1] = r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: jumio.core.k1.getBindingClasses():java.lang.Class[]");
    }

    public final boolean getHasFallback() {
        return false;
    }

    public final void getHelpAnimation(JumioAnimationView jumioAnimationView) {
    }

    public final JumioScanMode getScanMode() {
        return this.f56236k;
    }

    public final boolean isCancelable() {
        return this.f56235j;
    }

    public final void onError(ApiCallDataModel<?> apiCallDataModel, Throwable th2) {
        if (x.b(apiCallDataModel.getCall(), UploadCall.class)) {
            getController().onError(th2, apiCallDataModel.getCall());
        }
    }

    public final void onResult(ApiCallDataModel<?> apiCallDataModel, Object obj) {
        if (x.b(apiCallDataModel.getCall(), UploadCall.class)) {
            setComplete(true);
            ScanPart.sendScanStep$default(this, JumioScanStep.CAN_FINISH, (Object) null, (Object) null, 6, (Object) null);
        }
    }

    public final void reject() {
        if (this.f56234i != null) {
            DataPointsUtil.INSTANCE.increment(getController().getContext(), DataPointsUtil.NUMBER_OF_RETAKES);
            ((z0) getScanPartModel()).getFileData().clear();
            r<?> rVar = this.f56234i;
            if (rVar != null) {
                rVar.detach$jumio_core_release();
            }
            this.f56234i = null;
            ScanPart.sendScanStep$default(this, JumioScanStep.ATTACH_FILE, (Object) null, (Object) null, 6, (Object) null);
        }
    }

    public final void retry(JumioRetryReason jumioRetryReason) {
        super.retry(jumioRetryReason);
        ScanPart.sendScanStep$default(this, JumioScanStep.ATTACH_FILE, (Object) null, (Object) null, 6, (Object) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0068, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0069, code lost:
        b10.a.a(r0, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x006c, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setCheckHandler(jumio.core.r<?> r7) {
        /*
            r6 = this;
            com.jumio.core.models.ScanPartModel r0 = r6.getScanPartModel()
            jumio.core.z0 r0 = (jumio.core.z0) r0
            com.jumio.sdk.enums.JumioScanStep r0 = r0.getScanStep()
            boolean r0 = r7.isValidForScanStep$jumio_core_release(r0)
            if (r0 != 0) goto L_0x0019
            boolean r0 = r7 instanceof com.jumio.sdk.handler.JumioRejectHandler
            if (r0 != 0) goto L_0x0018
            boolean r0 = r7 instanceof com.jumio.sdk.handler.JumioConfirmationHandler
            if (r0 == 0) goto L_0x0019
        L_0x0018:
            return
        L_0x0019:
            jumio.core.r<?> r0 = r6.f56234i
            if (r0 == r7) goto L_0x0024
            if (r0 == 0) goto L_0x0022
            r0.detach$jumio_core_release()
        L_0x0022:
            r6.f56234i = r7
        L_0x0024:
            android.graphics.pdf.PdfRenderer r0 = r6.f56237l
            if (r0 == 0) goto L_0x006d
            r1 = 0
            android.graphics.pdf.PdfRenderer$Page r0 = r0.openPage(r1)
            if (r0 == 0) goto L_0x006d
            com.jumio.core.models.ScanPartModel r1 = r6.getScanPartModel()     // Catch:{ all -> 0x0066 }
            jumio.core.z0 r1 = (jumio.core.z0) r1     // Catch:{ all -> 0x0066 }
            com.jumio.sdk.enums.JumioCredentialPart r1 = r1.getCredentialPart()     // Catch:{ all -> 0x0066 }
            int r2 = r0.getWidth()     // Catch:{ all -> 0x0066 }
            int r2 = r2 * 2
            int r3 = r0.getHeight()     // Catch:{ all -> 0x0066 }
            int r3 = r3 * 2
            android.graphics.Bitmap$Config r4 = android.graphics.Bitmap.Config.ARGB_8888     // Catch:{ all -> 0x0066 }
            android.graphics.Bitmap r2 = android.graphics.Bitmap.createBitmap(r2, r3, r4)     // Catch:{ all -> 0x0066 }
            android.graphics.Canvas r3 = new android.graphics.Canvas     // Catch:{ all -> 0x0066 }
            r3.<init>(r2)     // Catch:{ all -> 0x0066 }
            r4 = -1
            r3.drawColor(r4)     // Catch:{ all -> 0x0066 }
            r4 = 0
            r5 = 0
            r3.drawBitmap(r2, r4, r4, r5)     // Catch:{ all -> 0x0066 }
            r3 = 1
            r0.render(r2, r5, r5, r3)     // Catch:{ all -> 0x0066 }
            kotlin.Unit r3 = kotlin.Unit.f56620a     // Catch:{ all -> 0x0066 }
            r7.addBitmap$jumio_core_release(r1, r2)     // Catch:{ all -> 0x0066 }
            b10.a.a(r0, r5)
            goto L_0x006d
        L_0x0066:
            r7 = move-exception
            throw r7     // Catch:{ all -> 0x0068 }
        L_0x0068:
            r1 = move-exception
            b10.a.a(r0, r7)
            throw r1
        L_0x006d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: jumio.core.k1.setCheckHandler(jumio.core.r):void");
    }

    public final void start() {
        super.start();
        ScanPart.sendScanStep$default(this, JumioScanStep.ATTACH_FILE, (Object) null, (Object) null, 6, (Object) null);
    }

    public final long b(ParcelFileDescriptor parcelFileDescriptor) {
        long j11 = Os.fstat(parcelFileDescriptor.getFileDescriptor()).st_size;
        byte[] bArr = new byte[1024];
        Os.pread(parcelFileDescriptor.getFileDescriptor(), bArr, 0, 1024, j11 - ((long) 1024));
        if (ByteArrayUtilKt.findSequence$default(bArr, this.f56233h, 0, 2, (Object) null) == -1) {
            return j11;
        }
        throw new SecurityException("PDF Encrypted");
    }

    public final void d(ParcelFileDescriptor parcelFileDescriptor) {
        ((z0) getScanPartModel()).getFileData().clear();
        File dataDirectory = Environment.INSTANCE.getDataDirectory(getController().getContext());
        d0 d0Var = d0.f56774a;
        File file = new File(dataDirectory, String.format(Locale.ENGLISH, "tmp_%d", Arrays.copyOf(new Object[]{Long.valueOf(System.currentTimeMillis())}, 1)));
        FileUtil.INSTANCE.saveToFile((InputStream) new FileInputStream(parcelFileDescriptor.getFileDescriptor()), file, getController().getAuthorizationModel().getSessionKey());
        ((z0) getScanPartModel()).getFileData().setMimeType("application/pdf");
        ((z0) getScanPartModel()).getFileData().setFileType("PDF");
        ((z0) getScanPartModel()).getFileData().setPath(file.getAbsolutePath());
    }

    public final void a(ParcelFileDescriptor parcelFileDescriptor) {
        c(parcelFileDescriptor);
    }

    public final void a() {
        r<?> rVar = this.f56234i;
        if (rVar != null && (rVar instanceof JumioConfirmationHandler)) {
            ScanPart.sendScanStep$default(this, JumioScanStep.PROCESSING, (Object) null, (Object) null, 6, (Object) null);
            getController().getBackendManager().uploadPart(getCredential(), getScanPartModel());
            r<?> rVar2 = this.f56234i;
            if (rVar2 != null) {
                rVar2.detach$jumio_core_release();
            }
            this.f56234i = null;
        }
    }
}
