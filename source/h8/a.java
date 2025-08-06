package h8;

import android.content.Context;
import com.hbg.lib.network.linear.swap.retrofit.LinearSwapRetrofitImpl;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public b f70352a;

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f70353a = new a();
    }

    public static b a() {
        return b.f70353a.f70352a;
    }

    public static void b(Context context, c9.b bVar) {
        a().a("linear_swap", context, bVar);
    }

    public a() {
        this.f70352a = new LinearSwapRetrofitImpl();
    }
}
