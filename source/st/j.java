package st;

import android.util.Pair;
import com.huobi.finance.bean.MarginBalanceDataTotal;
import com.huobi.supermargin.bean.MarginOverview;
import rx.functions.Func2;

public final /* synthetic */ class j implements Func2 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ j f29219b = new j();

    public final Object call(Object obj, Object obj2) {
        return new Pair((MarginBalanceDataTotal) obj, (MarginOverview) obj2);
    }
}
