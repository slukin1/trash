package yu;

import com.huobi.woodpecker.kalle.Kalle;
import com.huobi.woodpecker.kalle.Response;
import com.huobi.woodpecker.kalle.k;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class b {

    /* renamed from: e  reason: collision with root package name */
    public static final Executor f23452e = Executors.newCachedThreadPool();

    /* renamed from: a  reason: collision with root package name */
    public final k f23453a;

    /* renamed from: b  reason: collision with root package name */
    public d f23454b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f23455c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f23456d;

    public b(k kVar) {
        this.f23453a = kVar;
    }

    public Response a() throws IOException {
        if (!this.f23456d) {
            this.f23455c = true;
            ArrayList arrayList = new ArrayList(Kalle.b().i());
            d dVar = new d();
            this.f23454b = dVar;
            arrayList.add(dVar);
            try {
                return new a(arrayList, 0, this.f23453a, this).a(this.f23453a);
            } catch (Exception e11) {
                if (this.f23456d) {
                    throw new CancellationException("The request has been cancelled.");
                }
                throw e11;
            }
        } else {
            throw new CancellationException("The request has been cancelled.");
        }
    }
}
