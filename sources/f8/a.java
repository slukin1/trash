package f8;

import android.content.Context;
import com.hbg.lib.network.inst.retrofit.InstApiRetrofitImpl;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public b f70350a;

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f70351a = new a();
    }

    public static b a() {
        return b.f70351a.f70350a;
    }

    public static void b(Context context, c9.b bVar) {
        a().a("HBG_INST", context, bVar);
    }

    public a() {
        this.f70350a = new InstApiRetrofitImpl();
    }
}
