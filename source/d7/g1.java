package d7;

import com.hbg.lib.data.symbol.SymbolsDataProvider;
import java.util.List;
import rx.functions.Func1;

public final /* synthetic */ class g1 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f53506b;

    public /* synthetic */ g1(String str) {
        this.f53506b = str;
    }

    public final Object call(Object obj) {
        return SymbolsDataProvider.s((List) obj, this.f53506b);
    }
}
