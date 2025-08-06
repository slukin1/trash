package i8;

import com.hbg.lib.network.linear.swap.controller.LinearSwapAllowLevelController;
import java.util.List;
import rx.functions.Func1;

public final /* synthetic */ class a implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f55014b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f55015c;

    public /* synthetic */ a(int i11, String str) {
        this.f55014b = i11;
        this.f55015c = str;
    }

    public final Object call(Object obj) {
        return LinearSwapAllowLevelController.e(this.f55014b, this.f55015c, (List) obj);
    }
}
