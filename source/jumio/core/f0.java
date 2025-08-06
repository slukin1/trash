package jumio.core;

import com.jumio.core.Controller;
import com.jumio.core.models.CountryDocumentModel;
import com.jumio.sdk.credentials.JumioCredentialCategory;
import com.jumio.sdk.document.JumioDocument;
import com.jumio.sdk.document.JumioDocumentType;
import com.jumio.sdk.document.JumioDocumentVariant;
import java.util.ArrayList;
import java.util.List;

public final class f0 extends c0 {

    /* renamed from: h  reason: collision with root package name */
    public final List<String> f56192h;

    /* renamed from: i  reason: collision with root package name */
    public final List<JumioDocumentType> f56193i;

    /* renamed from: j  reason: collision with root package name */
    public final JumioDocumentVariant f56194j = null;

    /* renamed from: k  reason: collision with root package name */
    public String f56195k;

    /* renamed from: l  reason: collision with root package name */
    public JumioDocument f56196l;

    public f0(String str, List list, ArrayList arrayList, ArrayList arrayList2, List list2) {
        super(str, JumioCredentialCategory.ID, list, list2);
        this.f56192h = arrayList;
        this.f56193i = arrayList2;
    }

    public final boolean a(Controller controller) {
        return ((CountryDocumentModel) controller.getDataManager().get(CountryDocumentModel.class)).isEmpty();
    }

    public final List<String> d() {
        return this.f56192h;
    }

    public final List<JumioDocumentType> e() {
        return this.f56193i;
    }

    public final JumioDocumentVariant f() {
        return this.f56194j;
    }
}
