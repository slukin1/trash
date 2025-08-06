package yu;

import android.text.TextUtils;
import com.huobi.woodpecker.kalle.Response;
import com.huobi.woodpecker.kalle.k;
import com.huobi.woodpecker.kalle.l;
import com.huobi.woodpecker.kalle.n;
import com.huobi.woodpecker.kalle.p;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import xu.d;

public class e implements d {

    /* renamed from: a  reason: collision with root package name */
    public final String f23462a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f23463b;

    public e(String str, boolean z11) {
        this.f23462a = str;
        this.f23463b = z11;
    }

    public Response a(c cVar) throws IOException {
        k request = cVar.request();
        if (!this.f23463b) {
            return cVar.a(request);
        }
        Response a11 = cVar.a(request);
        String url = request.l().toString();
        StringBuilder sb2 = new StringBuilder(String.format(" \nPrint Request: %1$s.", new Object[]{url}));
        sb2.append(String.format("\nMethod: %1$s.", new Object[]{request.h().name()}));
        for (Map.Entry entry : request.c().c()) {
            sb2.append(String.format("\n%1$s: %2$s.", new Object[]{(String) entry.getKey(), TextUtils.join(";", (List) entry.getValue())}));
        }
        if (request.h().allowBody()) {
            l d11 = request.d();
            if ((d11 instanceof n) || (d11 instanceof p)) {
                sb2.append(String.format(" \nRequest Body: %1$s.", new Object[]{d11.toString()}));
            }
        }
        sb2.append(String.format(" \nPrint Response: %1$s.", new Object[]{url}));
        sb2.append(String.format(Locale.getDefault(), "\nCode: %1$d", new Object[]{Integer.valueOf(a11.b())}));
        for (Map.Entry entry2 : a11.e().c()) {
            sb2.append(String.format("\n%1$s: %2$s.", new Object[]{(String) entry2.getKey(), TextUtils.join(";", (List) entry2.getValue())}));
        }
        kv.e.m(this.f23462a, sb2.toString());
        return a11;
    }
}
