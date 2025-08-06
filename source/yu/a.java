package yu;

import com.huobi.woodpecker.kalle.Response;
import com.huobi.woodpecker.kalle.k;
import java.io.IOException;
import java.util.List;
import xu.d;

public class a implements c {

    /* renamed from: a  reason: collision with root package name */
    public final List<d> f23448a;

    /* renamed from: b  reason: collision with root package name */
    public final int f23449b;

    /* renamed from: c  reason: collision with root package name */
    public final k f23450c;

    /* renamed from: d  reason: collision with root package name */
    public b f23451d;

    public a(List<d> list, int i11, k kVar, b bVar) {
        this.f23448a = list;
        this.f23449b = i11;
        this.f23450c = kVar;
        this.f23451d = bVar;
    }

    public Response a(k kVar) throws IOException {
        return this.f23448a.get(this.f23449b).a(new a(this.f23448a, this.f23449b + 1, kVar, this.f23451d));
    }

    public k request() {
        return this.f23450c;
    }
}
