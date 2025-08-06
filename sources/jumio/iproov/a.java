package jumio.iproov;

import com.iproov.sdk.core.exception.IProovException;
import kotlin.jvm.internal.x;

public enum a {
    GENERIC(IProovException.class.getSimpleName(), 209);
    

    /* renamed from: c  reason: collision with root package name */
    public static final C0660a f56400c = null;

    /* renamed from: a  reason: collision with root package name */
    public final String f56403a;

    /* renamed from: b  reason: collision with root package name */
    public final int f56404b;

    /* renamed from: jumio.iproov.a$a  reason: collision with other inner class name */
    public static final class C0660a {
        public static a a(IProovException iProovException) {
            a aVar;
            if (iProovException.getReason() == null) {
                return a.GENERIC;
            }
            a[] values = a.values();
            int i11 = 0;
            int length = values.length;
            while (true) {
                if (i11 >= length) {
                    aVar = null;
                    break;
                }
                aVar = values[i11];
                if (x.b(aVar.f56403a, iProovException.getClass().getSimpleName())) {
                    break;
                }
                i11++;
            }
            if (aVar == null) {
                return a.GENERIC;
            }
            return aVar;
        }
    }

    /* access modifiers changed from: public */
    static {
        f56400c = new C0660a();
    }

    /* access modifiers changed from: public */
    a(String str, int i11) {
        this.f56403a = str;
        this.f56404b = i11;
    }

    public final int a() {
        return this.f56404b;
    }
}
