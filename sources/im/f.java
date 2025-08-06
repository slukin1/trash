package im;

import com.huobi.kalle.Response;
import hm.d;
import java.io.IOException;

public class f implements d {

    /* renamed from: a  reason: collision with root package name */
    public int f76222a;

    public f(int i11) {
        this.f76222a = i11;
    }

    public Response a(c cVar) throws IOException {
        try {
            return cVar.a(cVar.request());
        } catch (IOException e11) {
            int i11 = this.f76222a;
            if (i11 > 0) {
                this.f76222a = i11 - 1;
                return a(cVar);
            }
            throw e11;
        }
    }
}
