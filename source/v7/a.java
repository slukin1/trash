package v7;

import android.content.Context;
import com.hbg.lib.network.hbg.retrofit.H5ApiRetrofitImpl;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public c f70547a;

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f70548a = new a();
    }

    public static c a() {
        return b.f70548a.f70547a;
    }

    public static void b(Context context, c9.b bVar) {
        a().a("H5", context, bVar);
    }

    public a() {
        this.f70547a = new H5ApiRetrofitImpl();
    }
}
