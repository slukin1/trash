package q8;

import com.hbg.lib.network.option.controller.OptionMarketIndexInfoController;
import java.util.List;
import rx.functions.Func1;

public final /* synthetic */ class a implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f53304b;

    public /* synthetic */ a(String str) {
        this.f53304b = str;
    }

    public final Object call(Object obj) {
        return OptionMarketIndexInfoController.e(this.f53304b, (List) obj);
    }
}
