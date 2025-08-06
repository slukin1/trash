package n8;

import android.content.Context;
import com.hbg.lib.network.newkyc.retrofit.NewKycApiRetrofitImpl;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public b f69018a;

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f69019a = new a();
    }

    public static b a() {
        return b.f69019a.f69018a;
    }

    public static void b(Context context, c9.b bVar) {
        a().a("NEW_KYC", context, bVar);
    }

    public a() {
        this.f69018a = new NewKycApiRetrofitImpl();
    }
}
