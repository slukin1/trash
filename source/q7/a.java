package q7;

import android.content.Context;
import com.hbg.lib.network.contract.retrofit.ContractApiRetrofitImpl;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public b f70139a;

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f70140a = new a();
    }

    public static b a() {
        return b.f70140a.f70139a;
    }

    public static void b(Context context, c9.b bVar) {
        a().a("contract", context, bVar);
    }

    public a() {
        this.f70139a = new ContractApiRetrofitImpl();
    }
}
