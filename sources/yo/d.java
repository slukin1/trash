package yo;

import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.huobi.account.entity.AccountType;
import dt.h2;
import rx.functions.Func1;

public final /* synthetic */ class d implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MapParamsBuilder f61913b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f61914c;

    public /* synthetic */ d(MapParamsBuilder mapParamsBuilder, String str) {
        this.f61913b = mapParamsBuilder;
        this.f61914c = str;
    }

    public final Object call(Object obj) {
        return this.f61913b.a("account-id", Long.valueOf(h2.t1().C1(AccountType.margin.toString(), this.f61914c)));
    }
}
