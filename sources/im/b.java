package im;

import com.huobi.kalle.Kalle;
import com.huobi.kalle.Response;
import com.huobi.kalle.k;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class b {

    /* renamed from: e  reason: collision with root package name */
    public static final Executor f76210e = Executors.newCachedThreadPool();

    /* renamed from: a  reason: collision with root package name */
    public final k f76211a;

    /* renamed from: b  reason: collision with root package name */
    public d f76212b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f76213c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f76214d;

    public b(k kVar) {
        this.f76211a = kVar;
    }

    public Response a() throws IOException {
        if (!this.f76214d) {
            this.f76213c = true;
            ArrayList arrayList = new ArrayList(Kalle.a().i());
            d dVar = new d();
            this.f76212b = dVar;
            arrayList.add(dVar);
            try {
                return new a(arrayList, 0, this.f76211a, this).a(this.f76211a);
            } catch (Exception e11) {
                if (this.f76214d) {
                    throw new CancellationException("The request has been cancelled.");
                }
                throw e11;
            }
        } else {
            throw new CancellationException("The request has been cancelled.");
        }
    }
}
