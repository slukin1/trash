package jumio.core;

import com.jumio.commons.PersistWith;
import com.jumio.core.Controller;
import com.jumio.core.credentials.JCredentialCapabilities;
import com.jumio.core.credentials.RequiredPart;
import com.jumio.core.model.StaticModel;
import com.jumio.core.models.ScanPartModel;
import com.jumio.sdk.credentials.JumioCredentialCategory;
import com.jumio.sdk.enums.JumioCredentialPart;
import java.util.List;
import java.util.SortedMap;
import kotlin.Pair;

@PersistWith("CredentialsDataModel")
public class c0 implements StaticModel {

    /* renamed from: a  reason: collision with root package name */
    public final String f56143a;

    /* renamed from: b  reason: collision with root package name */
    public final JumioCredentialCategory f56144b;

    /* renamed from: c  reason: collision with root package name */
    public final List<JCredentialCapabilities> f56145c;

    /* renamed from: d  reason: collision with root package name */
    public final List<RequiredPart> f56146d;

    /* renamed from: e  reason: collision with root package name */
    public final SortedMap<JumioCredentialPart, ScanPartModel> f56147e = MapsKt__MapsJVMKt.f(new Pair[0]);

    /* renamed from: f  reason: collision with root package name */
    public final SortedMap<JumioCredentialPart, ScanPartModel> f56148f = MapsKt__MapsJVMKt.f(new Pair[0]);

    /* renamed from: g  reason: collision with root package name */
    public JumioCredentialPart f56149g;

    public c0(String str, JumioCredentialCategory jumioCredentialCategory, List<? extends JCredentialCapabilities> list, List<? extends RequiredPart> list2) {
        this.f56143a = str;
        this.f56144b = jumioCredentialCategory;
        this.f56145c = list;
        this.f56146d = list2;
    }

    public final String a() {
        return this.f56143a;
    }

    public boolean a(Controller controller) {
        return false;
    }

    public final SortedMap<JumioCredentialPart, ScanPartModel> b() {
        return this.f56147e;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean c() {
        /*
            r4 = this;
            java.util.SortedMap<com.jumio.sdk.enums.JumioCredentialPart, com.jumio.core.models.ScanPartModel> r0 = r4.f56147e
            boolean r0 = r0.isEmpty()
            r1 = 1
            r0 = r0 ^ r1
            r2 = 0
            if (r0 == 0) goto L_0x003a
            java.util.SortedMap<com.jumio.sdk.enums.JumioCredentialPart, com.jumio.core.models.ScanPartModel> r0 = r4.f56147e
            boolean r3 = r0.isEmpty()
            if (r3 == 0) goto L_0x0014
            goto L_0x0036
        L_0x0014:
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x001c:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x0036
            java.lang.Object r3 = r0.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r3 = r3.getValue()
            com.jumio.core.models.ScanPartModel r3 = (com.jumio.core.models.ScanPartModel) r3
            boolean r3 = r3.isComplete()
            if (r3 != 0) goto L_0x001c
            r0 = r2
            goto L_0x0037
        L_0x0036:
            r0 = r1
        L_0x0037:
            if (r0 == 0) goto L_0x003a
            goto L_0x003b
        L_0x003a:
            r1 = r2
        L_0x003b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: jumio.core.c0.c():boolean");
    }

    public final void a(JumioCredentialPart jumioCredentialPart) {
        this.f56149g = jumioCredentialPart;
    }
}
