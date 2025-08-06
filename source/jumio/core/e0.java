package jumio.core;

import com.jumio.commons.camera.Camera1Manager;
import com.jumio.core.Controller;
import com.jumio.core.credentials.JCredentialCapabilities;
import com.jumio.core.models.CredentialsModel;
import com.jumio.core.models.IproovTokenModel;
import com.jumio.sdk.credentials.JumioCredentialCategory;
import java.util.ArrayList;
import java.util.List;

public final class e0 extends c0 {

    /* renamed from: h  reason: collision with root package name */
    public final List<r1> f56181h;

    public e0(String str, List list, ArrayList arrayList, List list2) {
        super(str, JumioCredentialCategory.FACE, list, list2);
        this.f56181h = arrayList;
    }

    public final boolean a(Controller controller) {
        CredentialsModel credentialsModel = (CredentialsModel) controller.getDataManager().get(CredentialsModel.class);
        IproovTokenModel iproovTokenModel = (IproovTokenModel) controller.getDataManager().get(IproovTokenModel.class);
        if (!Camera1Manager.Companion.hasFrontFacingCamera(controller.getContext())) {
            return true;
        }
        if (!this.f56145c.contains(JCredentialCapabilities.AUTHENTICATION) || (credentialsModel.f39259a.size() == 1 && !iproovTokenModel.isEmpty() && controller.getPluginRegistry().b(d2.FACE_IPROOV))) {
            return false;
        }
        return true;
    }
}
