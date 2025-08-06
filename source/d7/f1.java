package d7;

import com.hbg.lib.data.symbol.SymbolsDataProvider;
import java.util.List;
import rx.functions.Action1;

public final /* synthetic */ class f1 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f53504b;

    public /* synthetic */ f1(String str) {
        this.f53504b = str;
    }

    public final void call(Object obj) {
        SymbolsDataProvider.p(this.f53504b, (List) obj);
    }
}
