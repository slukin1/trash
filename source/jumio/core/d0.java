package jumio.core;

import com.jumio.core.Controller;
import com.jumio.core.models.DocumentModel;
import com.jumio.sdk.credentials.JumioCredentialCategory;
import java.util.ArrayList;
import java.util.List;

public final class d0 extends c0 {

    /* renamed from: h  reason: collision with root package name */
    public final List<String> f56158h;

    /* renamed from: i  reason: collision with root package name */
    public final List<String> f56159i;

    public d0(String str, List list, ArrayList arrayList, ArrayList arrayList2, List list2) {
        super(str, JumioCredentialCategory.DOCUMENT, list, list2);
        this.f56158h = arrayList;
        this.f56159i = arrayList2;
    }

    public final boolean a(Controller controller) {
        boolean z11;
        List<String> list = this.f56158h;
        if (list != null && list.size() == 1) {
            List<String> list2 = this.f56159i;
            if (list2 != null && list2.size() == 1) {
                DocumentModel documentModel = (DocumentModel) controller.getDataManager().get(DocumentModel.class);
                String str = this.f56159i.get(0);
                synchronized (documentModel) {
                    z11 = documentModel.a(str) != null;
                }
                if (z11) {
                    return false;
                }
            }
        }
        return true;
    }
}
