package d7;

import com.hbg.lib.data.symbol.SuperMarginSymbolConfigUtil;
import java.util.List;
import rx.functions.Action1;

public final /* synthetic */ class t0 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f53533b;

    public /* synthetic */ t0(String str) {
        this.f53533b = str;
    }

    public final void call(Object obj) {
        SuperMarginSymbolConfigUtil.p((List) obj, this.f53533b);
    }
}
