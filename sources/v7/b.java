package v7;

import android.content.Context;
import com.hbg.lib.network.hbg.IHbgApi;
import com.hbg.lib.network.hbg.retrofit.HbgApiRetrofitImpl;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public IHbgApi f70549a;

    /* renamed from: v7.b$b  reason: collision with other inner class name */
    public static class C0772b {

        /* renamed from: a  reason: collision with root package name */
        public static final b f70550a = new b();
    }

    public static IHbgApi a() {
        return C0772b.f70550a.f70549a;
    }

    public static void b(Context context, c9.b bVar) {
        a().a("hbg", context, bVar);
    }

    public b() {
        this.f70549a = new HbgApiRetrofitImpl();
    }
}
