package pb;

import rx.functions.Func1;
import s8.a;

public final /* synthetic */ class e implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f53009b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f53010c;

    public /* synthetic */ e(String str, String str2) {
        this.f53009b = str;
        this.f53010c = str2;
    }

    public final Object call(Object obj) {
        return a.a().setTradePass(this.f53009b, this.f53010c, (String) obj).b();
    }
}
