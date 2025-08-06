package jumio.core;

import com.jumio.commons.log.Log;
import com.jumio.sdk.document.JumioDocumentType;
import d10.l;
import kotlin.jvm.internal.Lambda;

public final class n0 extends Lambda implements l<String, JumioDocumentType> {

    /* renamed from: a  reason: collision with root package name */
    public static final n0 f56281a = new n0();

    public n0() {
        super(1);
    }

    public static JumioDocumentType a(String str) {
        try {
            return JumioDocumentType.valueOf(str);
        } catch (Exception unused) {
            Log.e(str + " is not a valid DocumentType");
            return null;
        }
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return a((String) obj);
    }
}
