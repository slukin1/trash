package x8;

import android.content.Context;
import com.hbg.lib.network.pro.IProApi;
import com.hbg.lib.network.pro.retrofit.ProApiRetrofitImpl;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public IProApi f70942a;

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f70943a = new a();
    }

    public static IProApi a() {
        return b.f70943a.f70942a;
    }

    public static void b(Context context, c9.b bVar) {
        a().a("pro", context, bVar);
    }

    public a() {
        this.f70942a = new ProApiRetrofitImpl();
    }
}
