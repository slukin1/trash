package jumio.core;

import com.jumio.core.Controller;
import com.jumio.core.models.ScanPartModel;
import com.jumio.sdk.credentials.JumioDocumentCredential;
import com.jumio.sdk.interfaces.JumioScanPartInterface;

public final class y0<T extends ScanPartModel> extends v<T> {
    public y0(Controller controller, JumioDocumentCredential jumioDocumentCredential, T t11, JumioScanPartInterface jumioScanPartInterface) {
        super(controller, jumioDocumentCredential, CollectionsKt__CollectionsJVMKt.e(t11), jumioScanPartInterface);
    }
}
