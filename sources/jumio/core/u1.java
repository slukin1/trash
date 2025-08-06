package jumio.core;

import com.jumio.core.Controller;
import com.jumio.core.models.ScanPartModel;
import com.jumio.core.models.automation.AutomationModel;
import com.jumio.core.scanpart.ScanPart;
import com.jumio.sdk.credentials.JumioCredential;
import com.jumio.sdk.interfaces.JumioScanPartInterface;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.x;

public abstract class u1<T extends ScanPartModel> extends ScanPart<T> {

    /* renamed from: h  reason: collision with root package name */
    public final List<T> f56331h;

    public u1(Controller controller, JumioCredential jumioCredential, List<? extends T> list, JumioScanPartInterface jumioScanPartInterface) {
        super(controller, jumioCredential, (ScanPartModel) CollectionsKt___CollectionsKt.a0(list), jumioScanPartInterface);
        this.f56331h = list;
    }

    public final boolean getAllPartsComplete() {
        boolean z11;
        List<T> list = this.f56331h;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            for (T t11 : list) {
                if (!t11.isComplete() || t11.getAutomationModel() == null) {
                    z11 = false;
                    continue;
                } else {
                    z11 = true;
                    continue;
                }
                if (!z11) {
                    return false;
                }
            }
        }
        return true;
    }

    public final boolean getAllPartsHaveImages() {
        List<T> list = this.f56331h;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            for (T isComplete : list) {
                if (!isComplete.isComplete()) {
                    return false;
                }
            }
        }
        return true;
    }

    public final boolean getCurrentPartHasImage() {
        return getScanPartModel().isComplete();
    }

    public final boolean getHasNextPart() {
        boolean z11;
        List<T> list = this.f56331h;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            for (T t11 : list) {
                if (x.b(t11, getScanPartModel()) || t11.isComplete()) {
                    z11 = false;
                    continue;
                } else {
                    z11 = true;
                    continue;
                }
                if (z11) {
                    return true;
                }
            }
        }
        return false;
    }

    public final HashMap<String, Serializable> getModelData() {
        return ((ScanPartModel) this.f56331h.get(0)).getData();
    }

    public final T getPartForId(String str) {
        T t11;
        Iterator<T> it2 = this.f56331h.iterator();
        while (true) {
            if (!it2.hasNext()) {
                t11 = null;
                break;
            }
            t11 = it2.next();
            if (x.b(((ScanPartModel) t11).getId(), str)) {
                break;
            }
        }
        return (ScanPartModel) t11;
    }

    public final List<T> getScanPartModelList() {
        return this.f56331h;
    }

    public void reset() {
        super.reset();
        for (T t11 : this.f56331h) {
            t11.getFileData().clear();
            t11.setAutomationModel((AutomationModel) null);
        }
    }

    public final synchronized void switchToNextPart() {
        T t11;
        if (getCurrentPartHasImage()) {
            getReportingModel().a(getScanPartModel().getCredentialPart(), getCredential().getData$jumio_core_release().f56143a);
            Iterator<T> it2 = this.f56331h.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    t11 = null;
                    break;
                }
                t11 = it2.next();
                if (!((ScanPartModel) t11).isComplete()) {
                    break;
                }
            }
            ScanPartModel scanPartModel = (ScanPartModel) t11;
            if (scanPartModel != null) {
                setScanPartModel(scanPartModel);
            }
            getReportingModel().b(getScanPartModel().getCredentialPart(), getCredential().getData$jumio_core_release().f56143a);
        }
    }
}
