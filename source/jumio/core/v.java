package jumio.core;

import com.jumio.core.Controller;
import com.jumio.core.models.ScanPartModel;
import com.jumio.core.models.automation.AutomationModel;
import com.jumio.core.scanpart.JVisionScanPart;
import com.jumio.core.scanpart.ScanPart;
import com.jumio.sdk.credentials.JumioCredential;
import com.jumio.sdk.enums.JumioCredentialPart;
import com.jumio.sdk.enums.JumioScanStep;
import com.jumio.sdk.handler.JumioConfirmationHandler;
import com.jumio.sdk.handler.JumioRejectHandler;
import com.jumio.sdk.interfaces.JumioScanPartInterface;
import d10.p;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;

public abstract class v<T extends ScanPartModel> extends JVisionScanPart<T> implements w {
    public v(Controller controller, JumioCredential jumioCredential, List<? extends T> list, JumioScanPartInterface jumioScanPartInterface) {
        super(controller, jumioCredential, list, jumioScanPartInterface);
    }

    public final void a() {
        if (getInternalCheckHandler() instanceof JumioConfirmationHandler) {
            setComplete(true);
            ScanPart.sendScanStep$default(this, JumioScanStep.CAN_FINISH, (Object) null, (Object) null, 6, (Object) null);
            r<?> internalCheckHandler = getInternalCheckHandler();
            if (internalCheckHandler != null) {
                internalCheckHandler.detach$jumio_core_release();
            }
            setInternalCheckHandler((r<?>) null);
        }
    }

    public final void c() {
    }

    public final void fillCheckHandler(p<? super JumioCredentialPart, ? super String, Unit> pVar) {
        r<?> internalCheckHandler = getInternalCheckHandler();
        if (internalCheckHandler instanceof JumioRejectHandler) {
            super.fillCheckHandler(pVar);
        } else if (internalCheckHandler instanceof JumioConfirmationHandler) {
            List scanPartModelList = getScanPartModelList();
            ArrayList<ScanPartModel> arrayList = new ArrayList<>();
            for (Object next : scanPartModelList) {
                AutomationModel automationModel = ((ScanPartModel) next).getAutomationModel();
                if ((automationModel != null ? automationModel.f39406a : null) != AutomationModel.a.REJECT) {
                    arrayList.add(next);
                }
            }
            for (ScanPartModel scanPartModel : arrayList) {
                pVar.invoke(scanPartModel.getCredentialPart(), scanPartModel.getFileData().getPath());
            }
        }
    }

    public final boolean isSupportedCheckHandler(r<?> rVar) {
        return super.isSupportedCheckHandler(rVar) || (rVar instanceof JumioConfirmationHandler);
    }

    public final void retryScanParts() {
        List<ScanPartModel> scanPartModelList = getScanPartModelList();
        for (ScanPartModel scanPartModel : scanPartModelList) {
            scanPartModel.getFileData().clear();
            scanPartModel.setAutomationModel((AutomationModel) null);
        }
        setScanPartModel((ScanPartModel) CollectionsKt___CollectionsKt.a0(scanPartModelList));
    }
}
