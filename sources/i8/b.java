package i8;

import com.hbg.lib.network.linear.swap.controller.LinearSwapAllowLevelController;
import java.util.List;
import rx.functions.Func1;

public final /* synthetic */ class b implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f55016b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f55017c;

    public /* synthetic */ b(int i11, String str) {
        this.f55016b = i11;
        this.f55017c = str;
    }

    public final Object call(Object obj) {
        return LinearSwapAllowLevelController.f(this.f55016b, this.f55017c, (List) obj);
    }
}
