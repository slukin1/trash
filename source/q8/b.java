package q8;

import com.hbg.lib.network.option.controller.OptionMarketIndexInfoController;
import java.util.List;
import rx.functions.Func1;

public final /* synthetic */ class b implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f53305b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f53306c;

    public /* synthetic */ b(String str, String str2) {
        this.f53305b = str;
        this.f53306c = str2;
    }

    public final Object call(Object obj) {
        return OptionMarketIndexInfoController.f(this.f53305b, this.f53306c, (List) obj);
    }
}
