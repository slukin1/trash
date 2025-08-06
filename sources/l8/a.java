package l8;

import android.content.Context;
import com.hbg.lib.network.mgt.retrofit.MgtApiRetrofitImpl;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public b f69012a;

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f69013a = new a();
    }

    public static b a() {
        return b.f69013a.f69012a;
    }

    public static void b(Context context, c9.b bVar) {
        a().a("mgt", context, bVar);
    }

    public a() {
        this.f69012a = new MgtApiRetrofitImpl();
    }
}
