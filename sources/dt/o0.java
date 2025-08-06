package dt;

import com.huobi.account.entity.AccountQueryData;
import rx.functions.Func1;

public final /* synthetic */ class o0 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f54117b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f54118c;

    public /* synthetic */ o0(String str, String str2) {
        this.f54117b = str;
        this.f54118c = str2;
    }

    public final Object call(Object obj) {
        return h2.k2(this.f54117b, this.f54118c, (AccountQueryData) obj);
    }
}
