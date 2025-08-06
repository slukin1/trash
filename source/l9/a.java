package l9;

import android.content.Context;
import com.hbg.lib.network.swap.retrofit.SwapApiRetrofitImpl;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public b f70901a;

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f70902a = new a();
    }

    public static b a() {
        return b.f70902a.f70901a;
    }

    public static void b(Context context, c9.b bVar) {
        a().a("swap", context, bVar);
    }

    public a() {
        this.f70901a = new SwapApiRetrofitImpl();
    }
}
