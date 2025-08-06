package t7;

import android.content.Context;
import com.hbg.lib.network.etf.retrofit.EtfApiRetrofitImpl;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public b f70545a;

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f70546a = new a();
    }

    public static b a() {
        return b.f70546a.f70545a;
    }

    public static void b(Context context, c9.b bVar) {
        a().a("contract", context, bVar);
    }

    public a() {
        this.f70545a = new EtfApiRetrofitImpl();
    }
}
