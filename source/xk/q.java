package xk;

import com.huobi.contract.entity.OptionBalanceItem;
import com.huobi.finance.model.subaccount.OptionDataProvider;
import java.util.Comparator;

public final /* synthetic */ class q implements Comparator {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ q f61644b = new q();

    public final int compare(Object obj, Object obj2) {
        return OptionDataProvider.r((OptionBalanceItem) obj, (OptionBalanceItem) obj2);
    }
}
