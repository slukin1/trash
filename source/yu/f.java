package yu;

import com.huobi.woodpecker.kalle.Response;
import java.io.IOException;
import xu.d;

public class f implements d {

    /* renamed from: a  reason: collision with root package name */
    public int f23464a;

    public f(int i11) {
        this.f23464a = i11;
    }

    public Response a(c cVar) throws IOException {
        try {
            return cVar.a(cVar.request());
        } catch (IOException e11) {
            int i11 = this.f23464a;
            if (i11 > 0) {
                this.f23464a = i11 - 1;
                return a(cVar);
            }
            throw e11;
        }
    }
}
