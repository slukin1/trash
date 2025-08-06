package jumio.core;

import com.jumio.commons.camera.PreviewProperties;
import com.jumio.core.Controller;
import com.jumio.core.data.ScanMode;
import com.jumio.core.extraction.ExtractionClient;
import com.jumio.core.interfaces.UsabilityInterface;
import com.jumio.core.model.StaticModel;
import com.jumio.core.models.ApiCallDataModel;
import com.jumio.core.models.DocumentDataModel;
import com.jumio.core.models.PhysicalIdScanPartModel;
import com.jumio.core.plugins.ExtractionPlugin;
import com.jumio.core.plugins.ScanPartPlugin;
import com.jumio.core.scanpart.JVisionScanPart;
import com.jumio.core.scanpart.ScanPart;
import com.jumio.core.util.FileData;
import com.jumio.sdk.credentials.JumioIDCredential;
import com.jumio.sdk.enums.JumioCredentialPart;
import com.jumio.sdk.enums.JumioFallbackReason;
import com.jumio.sdk.enums.JumioScanStep;
import com.jumio.sdk.enums.JumioScanUpdate;
import com.jumio.sdk.interfaces.JumioScanPartInterface;
import com.jumio.sdk.scanpart.JumioScanPart;
import d10.l;
import d10.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.r;

public final class b2 extends JVisionScanPart<PhysicalIdScanPartModel> implements UsabilityInterface {

    public static final class a extends Lambda implements p<StaticModel, StaticModel, StaticModel> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f56139a = new a();

        public a() {
            super(2);
        }

        public final Object invoke(Object obj, Object obj2) {
            StaticModel staticModel = (StaticModel) obj2;
            return staticModel == null ? (StaticModel) obj : staticModel;
        }
    }

    public b2(Controller controller, JumioIDCredential jumioIDCredential, ArrayList arrayList, JumioScanPartInterface jumioScanPartInterface) {
        super(controller, jumioIDCredential, arrayList, jumioScanPartInterface);
    }

    public final void checkForAddon(l<? super JumioScanPart, Unit> lVar) {
        Object obj;
        Unit unit;
        l<? super JumioScanPart, Unit> lVar2 = lVar;
        ScanPartPlugin scanPartPlugin = (ScanPartPlugin) getController().getPluginRegistry().a(d2.NFC);
        if (scanPartPlugin == null) {
            lVar2.invoke(null);
            return;
        }
        Iterator it2 = getScanPartModelList().iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj = null;
                break;
            }
            obj = it2.next();
            if (scanPartPlugin.isUsable(getController(), (PhysicalIdScanPartModel) obj)) {
                break;
            }
        }
        PhysicalIdScanPartModel physicalIdScanPartModel = (PhysicalIdScanPartModel) obj;
        if (physicalIdScanPartModel != null) {
            JumioCredentialPart jumioCredentialPart = JumioCredentialPart.NFC;
            PhysicalIdScanPartModel physicalIdScanPartModel2 = new PhysicalIdScanPartModel(jumioCredentialPart, ScanMode.NFC, physicalIdScanPartModel.getFormat(), physicalIdScanPartModel.getSelectionModel(), new FileData(), (List) null, (Map) null, 96, (r) null);
            physicalIdScanPartModel2.setDocumentData(physicalIdScanPartModel.getDocumentData());
            getCredential().getData$jumio_core_release().f56148f.put(jumioCredentialPart, physicalIdScanPartModel2);
            lVar2.invoke(new JumioScanPart(scanPartPlugin.getScanPart(getController(), getCredential(), physicalIdScanPartModel2, getScanPartInterface())));
            ScanPart.sendScanStep$default(this, JumioScanStep.ADDON_SCAN_PART, (Object) null, (Object) null, 6, (Object) null);
            unit = Unit.f56620a;
        } else {
            unit = null;
        }
        if (unit == null) {
            lVar2.invoke(null);
        }
    }

    public final void fallback(JumioFallbackReason jumioFallbackReason) {
        if (getHasFallback() && getScanView() != null) {
            if (((PhysicalIdScanPartModel) getScanPartModel()).getScanStep() == JumioScanStep.SCAN_VIEW || ((PhysicalIdScanPartModel) getScanPartModel()).getScanStep() == JumioScanStep.STARTED) {
                super.fallback(jumioFallbackReason);
                PhysicalIdScanPartModel physicalIdScanPartModel = (PhysicalIdScanPartModel) getScanPartModel();
                ScanMode mode = ((PhysicalIdScanPartModel) getScanPartModel()).getMode();
                int indexOf = ((PhysicalIdScanPartModel) getScanPartModel()).getExtraction().indexOf(mode);
                if (indexOf != CollectionsKt__CollectionsKt.m(((PhysicalIdScanPartModel) getScanPartModel()).getExtraction())) {
                    mode = ((PhysicalIdScanPartModel) getScanPartModel()).getExtraction().get(indexOf + 1);
                }
                physicalIdScanPartModel.setMode(mode);
                initExtractionAndOverlay();
                sendUpdate(JumioScanUpdate.FALLBACK, jumioFallbackReason);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0033, code lost:
        if ((r2.length() == 0) != false) goto L_0x0035;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void finish() {
        /*
            r4 = this;
            super.finish()
            com.jumio.core.Controller r0 = r4.getController()
            com.jumio.core.persistence.DataManager r0 = r0.getDataManager()
            java.lang.Class<jumio.core.b> r1 = jumio.core.b.class
            java.io.Serializable r0 = r0.get(r1)
            jumio.core.b r0 = (jumio.core.b) r0
            com.jumio.core.models.ScanPartModel r1 = r4.getScanPartModel()
            com.jumio.core.models.PhysicalIdScanPartModel r1 = (com.jumio.core.models.PhysicalIdScanPartModel) r1
            r0.getClass()
            com.jumio.core.models.DocumentDataModel r2 = r1.getDocumentData()
            if (r2 == 0) goto L_0x0027
            java.lang.String r2 = r2.getIssuingCountry()
            goto L_0x0028
        L_0x0027:
            r2 = 0
        L_0x0028:
            if (r2 == 0) goto L_0x0035
            int r3 = r2.length()
            if (r3 != 0) goto L_0x0032
            r3 = 1
            goto L_0x0033
        L_0x0032:
            r3 = 0
        L_0x0033:
            if (r3 == 0) goto L_0x0041
        L_0x0035:
            com.jumio.core.models.PhysicalSelectionModel r1 = r1.getSelectionModel()
            com.jumio.core.data.country.Country r1 = r1.getCountry()
            java.lang.String r2 = r1.getIsoCode()
        L_0x0041:
            r0.f56135i = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: jumio.core.b2.finish():void");
    }

    public final ExtractionPlugin getExtractionPlugin(ScanMode scanMode) {
        ExtractionPlugin extractionPlugin = (ExtractionPlugin) getController().getPluginRegistry().a(getScanPluginMode(scanMode));
        while (true) {
            if (extractionPlugin != null && extractionPlugin.isUsable(getController(), getScanPartModel())) {
                return extractionPlugin;
            }
            int indexOf = ((PhysicalIdScanPartModel) getScanPartModel()).getExtraction().indexOf(scanMode);
            if (indexOf != CollectionsKt__CollectionsKt.m(((PhysicalIdScanPartModel) getScanPartModel()).getExtraction())) {
                scanMode = ((PhysicalIdScanPartModel) getScanPartModel()).getExtraction().get(indexOf + 1);
            }
            d2 scanPluginMode = getScanPluginMode(scanMode);
            ((PhysicalIdScanPartModel) getScanPartModel()).setMode(scanMode);
            extractionPlugin = (ExtractionPlugin) getController().getPluginRegistry().a(scanPluginMode);
        }
    }

    public final boolean getHasFallback() {
        return ((PhysicalIdScanPartModel) getScanPartModel()).getExtraction().indexOf(((PhysicalIdScanPartModel) getScanPartModel()).getMode()) != CollectionsKt__CollectionsKt.m(((PhysicalIdScanPartModel) getScanPartModel()).getExtraction());
    }

    public final String getMultipartNameForUsabilityResultKey(ApiCallDataModel<?> apiCallDataModel) {
        FileData fileData;
        PhysicalIdScanPartModel physicalIdScanPartModel = (PhysicalIdScanPartModel) getPartForId(apiCallDataModel.getScanPartId());
        if (physicalIdScanPartModel == null || (fileData = physicalIdScanPartModel.getFileData()) == null) {
            return null;
        }
        return fileData.getFileName();
    }

    public final boolean getShouldEnableUsability() {
        return getSettingsModel().isInstantFeedbackEnabled() && getNumOfRetries() <= getSettingsModel().getAutomationMaxRetries();
    }

    public final void initExtractionClient(ExtractionClient extractionClient) {
        ScanMode scanMode = ((PhysicalIdScanPartModel) getScanPartModel()).getSubExtraction().get(((PhysicalIdScanPartModel) getScanPartModel()).getMode());
        if (scanMode != null) {
            ExtractionPlugin extractionPlugin = (ExtractionPlugin) getController().getPluginRegistry().a(getScanPluginMode(scanMode));
            boolean z11 = true;
            if (extractionPlugin == null || !extractionPlugin.isUsable(getController(), getScanPartModel())) {
                z11 = false;
            }
            if (z11) {
                extractionClient.addSubExtraction(extractionPlugin.getExtractionClient(getController().getContext()), a.f56139a);
            }
        }
        super.initExtractionClient(extractionClient);
    }

    public final void onPreviewAvailable(PreviewProperties previewProperties) {
        super.onPreviewAvailable(previewProperties);
    }

    public final void reset() {
        ((PhysicalIdScanPartModel) getScanPartModel()).setMode(((PhysicalIdScanPartModel) getScanPartModel()).getExtraction().get(0));
        ((PhysicalIdScanPartModel) getScanPartModel()).setDocumentData((DocumentDataModel) null);
        super.reset();
    }

    public void onResult(StaticModel staticModel) {
        ((PhysicalIdScanPartModel) getScanPartModel()).setDocumentData(staticModel instanceof DocumentDataModel ? (DocumentDataModel) staticModel : new DocumentDataModel());
        super.onResult(staticModel);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0049, code lost:
        if ((r3.f56209d.length() > 0) != false) goto L_0x004d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x001b, code lost:
        r3 = r3.getAutomationModel();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onResult(com.jumio.core.models.ApiCallDataModel<?> r3, java.lang.Object r4) {
        /*
            r2 = this;
            super.onResult(r3, r4)
            java.lang.Class r4 = r3.getCall()
            java.lang.Class<com.jumio.core.api.calls.UsabilityCall> r0 = com.jumio.core.api.calls.UsabilityCall.class
            boolean r4 = kotlin.jvm.internal.x.b(r4, r0)
            if (r4 == 0) goto L_0x0060
            java.lang.String r3 = r3.getScanPartId()
            com.jumio.core.models.ScanPartModel r3 = r2.getPartForId(r3)
            com.jumio.core.models.PhysicalIdScanPartModel r3 = (com.jumio.core.models.PhysicalIdScanPartModel) r3
            if (r3 == 0) goto L_0x0024
            com.jumio.core.models.automation.AutomationModel r3 = r3.getAutomationModel()
            if (r3 == 0) goto L_0x0024
            jumio.core.g1 r3 = r3.f39409d
            goto L_0x0025
        L_0x0024:
            r3 = 0
        L_0x0025:
            if (r3 == 0) goto L_0x0060
            java.lang.String r4 = r3.f56206a
            int r4 = r4.length()
            r0 = 1
            r1 = 0
            if (r4 <= 0) goto L_0x0033
            r4 = r0
            goto L_0x0034
        L_0x0033:
            r4 = r1
        L_0x0034:
            if (r4 == 0) goto L_0x004c
            java.util.Date r4 = r3.f56207b
            if (r4 == 0) goto L_0x004c
            java.util.Date r4 = r3.f56208c
            if (r4 == 0) goto L_0x004c
            java.lang.String r4 = r3.f56209d
            int r4 = r4.length()
            if (r4 <= 0) goto L_0x0048
            r4 = r0
            goto L_0x0049
        L_0x0048:
            r4 = r1
        L_0x0049:
            if (r4 == 0) goto L_0x004c
            goto L_0x004d
        L_0x004c:
            r0 = r1
        L_0x004d:
            if (r0 == 0) goto L_0x0060
            com.jumio.core.models.MrzDataModel r4 = new com.jumio.core.models.MrzDataModel
            r4.<init>()
            r4.setFromExtractedData(r3)
            com.jumio.core.models.ScanPartModel r3 = r2.getScanPartModel()
            com.jumio.core.models.PhysicalIdScanPartModel r3 = (com.jumio.core.models.PhysicalIdScanPartModel) r3
            r3.setDocumentData(r4)
        L_0x0060:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: jumio.core.b2.onResult(com.jumio.core.models.ApiCallDataModel, java.lang.Object):void");
    }
}
