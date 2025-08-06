package bv;

import com.huobi.woodpecker.kalle.Response;
import java.io.IOException;
import java.lang.reflect.Type;
import yu.b;

public final class j<S, F> extends a<i, S, F> {

    /* renamed from: h  reason: collision with root package name */
    public b f19423h;

    public j(i iVar, Type type, Type type2) {
        super(iVar, type, type2);
    }

    /* renamed from: k */
    public Response f(i iVar) throws IOException {
        b bVar = new b(iVar);
        this.f19423h = bVar;
        return bVar.a();
    }
}
