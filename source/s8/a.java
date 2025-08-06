package s8;

import android.content.Context;
import com.hbg.lib.network.otc.retrofit.OtcApiRetrofitImpl;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public b f70927a;

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f70928a = new a();
    }

    public static b a() {
        return b.f70928a.f70927a;
    }

    public static void b(Context context, c9.b bVar) {
        a().a("otc", context, bVar);
    }

    public a() {
        this.f70927a = new OtcApiRetrofitImpl();
    }
}
