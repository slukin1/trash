package bj;

import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import java.util.Comparator;

public final /* synthetic */ class r2 implements Comparator {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ r2 f12489b = new r2();

    public final int compare(Object obj, Object obj2) {
        return Long.compare(((ContractCurrencyInfo) obj2).getDelivTime(), ((ContractCurrencyInfo) obj).getDelivTime());
    }
}
