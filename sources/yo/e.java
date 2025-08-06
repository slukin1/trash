package yo;

import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.huobi.account.entity.AccountType;
import dt.h2;
import rx.functions.Func1;

public final /* synthetic */ class e implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MapParamsBuilder f61916b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f61917c;

    public /* synthetic */ e(MapParamsBuilder mapParamsBuilder, String str) {
        this.f61916b = mapParamsBuilder;
        this.f61917c = str;
    }

    public final Object call(Object obj) {
        return this.f61916b.a("account-id", Long.valueOf(h2.t1().C1(AccountType.borrow.toString(), this.f61917c)));
    }
}
