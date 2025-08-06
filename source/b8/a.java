package b8;

import android.content.Context;
import com.hbg.lib.network.index.retrofit.IndexApiRetrofitImpl;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public b f70189a;

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f70190a = new a();
    }

    public static b a() {
        return b.f70190a.f70189a;
    }

    public static void b(Context context, c9.b bVar) {
        a().a("index", context, bVar);
    }

    public a() {
        this.f70189a = new IndexApiRetrofitImpl();
    }
}
