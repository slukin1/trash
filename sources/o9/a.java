package o9;

import android.content.Context;
import com.hbg.lib.network.uc.retrofit.UcApiRetrofitImpl;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public b f70923a;

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f70924a = new a();
    }

    public static b a() {
        return b.f70924a.f70923a;
    }

    public static void b(Context context, c9.b bVar) {
        a().a("uc", context, bVar);
    }

    public a() {
        this.f70923a = new UcApiRetrofitImpl();
    }
}
