package rk;

import com.huobi.finance.AssetModuleCallbackImp;
import java.util.List;
import rx.functions.Func1;

public final /* synthetic */ class g implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f25727b;

    public /* synthetic */ g(String str) {
        this.f25727b = str;
    }

    public final Object call(Object obj) {
        return AssetModuleCallbackImp.F1(this.f25727b, (List) obj);
    }
}
