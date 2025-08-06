package dt;

import com.huobi.account.entity.AccountQueryData;
import rx.functions.Func1;

public final /* synthetic */ class n0 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f54110b;

    public /* synthetic */ n0(String str) {
        this.f54110b = str;
    }

    public final Object call(Object obj) {
        return Boolean.valueOf(((AccountQueryData) obj).getType().equals(this.f54110b));
    }
}
