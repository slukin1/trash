package n7;

import android.content.Context;
import com.hbg.lib.network.content.retrofit.MgtContentApiRetrofitImpl;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public b f70130a;

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f70131a = new a();
    }

    public static b a() {
        return b.f70131a.f70130a;
    }

    public static void b(Context context, c9.b bVar) {
        a().a("mgt_content", context, bVar);
    }

    public a() {
        this.f70130a = new MgtContentApiRetrofitImpl();
    }
}
