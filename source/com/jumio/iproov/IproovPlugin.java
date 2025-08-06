package com.jumio.iproov;

import androidx.annotation.Keep;
import com.jumio.core.Controller;
import com.jumio.core.environment.Environment;
import com.jumio.core.models.FaceScanPartModel;
import com.jumio.core.models.IproovTokenModel;
import com.jumio.core.models.ScanPartModel;
import com.jumio.core.plugins.ScanPartPlugin;
import com.jumio.core.scanpart.ScanPart;
import com.jumio.sdk.credentials.JumioCredential;
import com.jumio.sdk.credentials.JumioFaceCredential;
import com.jumio.sdk.interfaces.JumioScanPartInterface;
import jumio.iproov.b;

@Keep
public final class IproovPlugin implements ScanPartPlugin {
    private final String version = Environment.BUILD_VERSION;

    public <T extends ScanPartModel> ScanPart<?> getScanPart(Controller controller, JumioCredential jumioCredential, T t11, JumioScanPartInterface jumioScanPartInterface) {
        if (jumioCredential instanceof JumioFaceCredential) {
            if ((t11 instanceof FaceScanPartModel ? (FaceScanPartModel) t11 : null) != null) {
                return new b(controller, (JumioFaceCredential) jumioCredential, (FaceScanPartModel) t11, jumioScanPartInterface);
            }
            String simpleName = FaceScanPartModel.class.getSimpleName();
            throw new IllegalArgumentException(("ScanPartModel needs to be instance of " + simpleName).toString());
        }
        String simpleName2 = JumioFaceCredential.class.getSimpleName();
        throw new IllegalArgumentException(("Credential needs to be instance of " + simpleName2).toString());
    }

    public String getVersion() {
        return this.version;
    }

    public boolean isUsable(Controller controller, ScanPartModel scanPartModel) {
        return ((IproovTokenModel) controller.getDataManager().get(IproovTokenModel.class)).getToken().length() > 0;
    }

    public void preload(Controller controller) {
        ScanPartPlugin.DefaultImpls.preload(this, controller);
    }

    public void unload() {
        ScanPartPlugin.DefaultImpls.unload(this);
    }
}
