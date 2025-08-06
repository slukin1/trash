package im;

import com.huobi.kalle.Response;
import com.huobi.kalle.k;
import hm.d;
import java.io.IOException;
import java.util.List;

public class a implements c {

    /* renamed from: a  reason: collision with root package name */
    public final List<d> f76206a;

    /* renamed from: b  reason: collision with root package name */
    public final int f76207b;

    /* renamed from: c  reason: collision with root package name */
    public final k f76208c;

    /* renamed from: d  reason: collision with root package name */
    public b f76209d;

    public a(List<d> list, int i11, k kVar, b bVar) {
        this.f76206a = list;
        this.f76207b = i11;
        this.f76208c = kVar;
        this.f76209d = bVar;
    }

    public Response a(k kVar) throws IOException {
        return this.f76206a.get(this.f76207b).a(new a(this.f76206a, this.f76207b + 1, kVar, this.f76209d));
    }

    public k request() {
        return this.f76208c;
    }
}
